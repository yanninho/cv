package controllers;

import static play.data.Form.form;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import models.ChatRoom;
import models.SessionChat;

import org.codehaus.jackson.JsonNode;

import play.Play;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.WebSocket;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

/**
 * Cette classe reponds aux requetes de traitement du systeme de websocket
 * 
 * @author Yannick Saint Martino
 * 
 */
public class Websocket extends Controller {

	/**
	 * formulaire de connexion a une session websocket existante
	 */
	final static Form<SessionChat> sessionForm = form(SessionChat.class);

	/**
	 * Reponds a la demande de nouvelle session
	 * 
	 * @return la vue server websocket
	 */
	public static Result newSession() {
		// genere un identifiant unique de session
		Double sessionRandom = Math.floor(Math.random() * 1000000);
		String sessionID = "" + sessionRandom.intValue();
		Map<String, String> map = new HashMap<String, String>();
		map.put("session", sessionID);
		return ok(Json.toJson(map));
	}

	/**
	 * Connexion a une session existante avec GET et l'identifiant de session en
	 * parametre
	 * 
	 * @param sessionID
	 * @return Result la vue client websocket
	 */
	public static Result connectSession(String sessionID) {
		return ok(views.html.clientWebsocket.render(sessionID));
	}	
	
	/**
	 * Handle the chat websocket.
	 */
	public static WebSocket<JsonNode> chat(final String session) {
		return new WebSocket<JsonNode>() {

			// Called when the Websocket Handshake is done.
			public void onReady(WebSocket.In<JsonNode> in,
					WebSocket.Out<JsonNode> out) {

				// Join the chat room.
				try {
					ChatRoom.join(session, in, out);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		};
	}

	/**
	 * Genere un QRCode contenant l'url de la vue client websocket avec
	 * l'identifiant de session permet au client mobile d'atteindre
	 * instantanément la vue client websocket
	 * 
	 * @param idWebsocketSession
	 * @return
	 */
	public static Result qrCode(String idWebsocketSession) {

		String urlSession = Play.application().configuration()
				.getString("application.baseUrl")
				+ "/connectSession?sessionID=" + idWebsocketSession;
		try {
			//generation du QRCode
			BitMatrix bitMatrix = new QRCodeWriter().encode(urlSession,
					BarcodeFormat.QR_CODE, 100, 100);
			BufferedImage bufferedImage = MatrixToImageWriter
					.toBufferedImage(bitMatrix);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(bufferedImage, "jpg", baos);
			baos.flush();
			byte[] imageInByte = baos.toByteArray();
			baos.close();
			return ok(imageInByte).as("image/jpg");
		} catch (WriterException e) {
			return null;
		} catch (IOException e) {
			return null;
		}
	}

}
