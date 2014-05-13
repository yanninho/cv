package models;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import outils.RSSReader;

public class Build {

	public static final String urlBuilds = "https://yannick-saintmartino.ci.cloudbees.com/rssAll";

	public static final String userPassword = "y4nn5m@gmail.com:perp1gn4n";

	public String title;

	public String date;

	public static List<Build> GetBuilds() throws Exception {
		List<Build> builds = new ArrayList<Build>();

		NodeList nodes = null;
		Element element = null;
		Document doc;
		doc = RSSReader.GetDocument(urlBuilds, userPassword);
		nodes = doc.getElementsByTagName("entry");
		for (int i = 0; i < nodes.getLength(); i++) {
			element = (Element) nodes.item(i);
			Build build = new Build();
			build.title = RSSReader.ReadNode(element, "title");
			
			String[] splitId = RSSReader.ReadNode(element, "id").split(":");
			
			if (splitId.length == 4) {
				build.date = RSSReader.GMTDateToFrench(splitId[3]);
			}			
			builds.add(build);
		}
		return builds;

	}
}
