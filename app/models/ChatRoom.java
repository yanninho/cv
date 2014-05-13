package models;

import static akka.pattern.Patterns.ask;
import static java.util.concurrent.TimeUnit.SECONDS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.node.ObjectNode;

import play.libs.Akka;
import play.libs.F.Callback;
import play.libs.F.Callback0;
import play.libs.Json;
import play.mvc.WebSocket;
import scala.concurrent.Await;
import scala.concurrent.duration.Duration;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;

/**
 * A chat room is an Actor.
 */
public class ChatRoom extends UntypedActor {
    
    // Default room.
//    static ActorRef defaultRoom = Akka.system().actorOf(new Props(ChatRoom.class));
       
	static Map<String,ActorRef> rooms = new HashMap<String,ActorRef>(); 
    
    /**
     * Join the default room.
     */
    public static void join(final String session, WebSocket.In<JsonNode> in, WebSocket.Out<JsonNode> out) throws Exception{
    	ActorRef sessionRoom = rooms.get(session);
    	if (sessionRoom == null) {
    		sessionRoom = Akka.system().actorOf(new Props(ChatRoom.class));
    		rooms.put(session, sessionRoom);
    	}
    	else {
    		 Await.result(ask(rooms.get(session),new Join(session, out), 1000), Duration.create(15, SECONDS));
    	}	
        // Send the Join message to the room
            
            // For each event received on the socket,
            in.onMessage(new Callback<JsonNode>() {
               public void invoke(JsonNode event) {
                   
                   // Send a Talk message to the room.
            	   rooms.get(session).tell(new Talk(session, event.get("text").asText()));
                   
               } 
            });
            
            // When the socket is closed.
            in.onClose(new Callback0() {
               public void invoke() {
                   
                   // Send a Quit message to the room.
            	   rooms.get(session).tell(new Quit(session));
                   
               }
            });        
    }
    
    // Members of this room.
    List<WebSocket.Out<JsonNode>> members = new ArrayList<WebSocket.Out<JsonNode>>();
    
    public void onReceive(Object message) throws Exception {
        
        if(message instanceof Join) {
            
            // Received a Join message
            Join join = (Join)message;            
            members.add(join.channel);
            //notifyAll("join", "A channel has join the room");
            getSender().tell("OK");
            
        } else if(message instanceof Talk)  {
            
            // Received a Talk message
            Talk talk = (Talk)message;
            
            notifyAll("talk", talk.text);
            
        } else if(message instanceof Quit)  {
            
            // Received a Quit message
            Quit quit = (Quit)message;
            
            members.remove(quit.username);
            
            //notifyAll("quit", "A channel has leaved the room");
        
        } else {
            unhandled(message);
        }
        
    }
    
    // Send a Json event to all members
    public void notifyAll(String kind, String text) {    	
        for(WebSocket.Out<JsonNode> channel: members) {            
            ObjectNode event = Json.newObject();
            event.put("kind", kind);
            event.put("message", text);            
            channel.write(event);
        }
    }
    
    // -- Messages
    
    public static class Join {
        
        final String username;
        final WebSocket.Out<JsonNode> channel;
        
        public Join(String username, WebSocket.Out<JsonNode> channel) {
            this.username = username;
            this.channel = channel;
        }
        
    }
    
    public static class Talk {
        
        final String username;
        final String text;
        
        public Talk(String username, String text) {
            this.username = username;
            this.text = text;
        }
        
    }
    
    public static class Quit {
        
        final String username;
        
        public Quit(String username) {
            this.username = username;
        }
        
    }
    
}
