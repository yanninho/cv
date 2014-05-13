package outils;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Parser un flux RSS
 * 
 * @author Fobec 2010
 */

public class RSSReader {

	/**
	 * Méthode permettant de retourner ce que contient d'un noeud
	 * 
	 * @param _node
	 *            le noeud principal
	 * @param _path
	 *            suite des noms des noeud sans espace séparer par des "|"
	 * @return un string contenant le valeur du noeud voulut
	 */
	public static String ReadNode(Node _node, String _path) {

		String[] paths = _path.split("\\|");
		Node node = null;

		if (paths != null && paths.length > 0) {
			node = _node;

			for (int i = 0; i < paths.length; i++) {
				node = getChildByName(node, paths[i].trim());
			}
		}

		if (node != null) {
			return node.getTextContent();
		} else {
			return "";
		}
	}

	/**
	 * renvoye le nom d'un noeud fils a partir de son nom
	 * 
	 * @param _node
	 *            noeud pricipal
	 * @param _name
	 *            nom du noeud fils
	 * @return le noeud fils
	 */
	private static Node getChildByName(Node _node, String _name) {
		if (_node == null) {
			return null;
		}
		NodeList listChild = _node.getChildNodes();

		if (listChild != null) {
			for (int i = 0; i < listChild.getLength(); i++) {
				Node child = listChild.item(i);
				if (child != null) {
					if ((child.getNodeName() != null && (_name.equals(child
							.getNodeName())))
							|| (child.getLocalName() != null && (_name
									.equals(child.getLocalName())))) {
						return child;
					}
				}
			}
		}
		return null;
	}

	/**
	 * Afficher une Date GML au format francais
	 * 
	 * @param gmtDate
	 * @return
	 */
	public static String GMTDateToFrench(String gmtDate) {
		try {
			
			Date dateUS = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").parse(gmtDate);
			
			SimpleDateFormat dfFrench = new SimpleDateFormat(
					"EE d MMM HH:mm:ss", Locale.FRANCE);
			return dfFrench.format(dateUS);
		} catch (ParseException ex) {
			Logger.getLogger(RSSReader.class.getName()).log(Level.SEVERE, null,
					ex);
		}
		return "";
	}

	public static Document GetDocument(String urlbuilds, String userpassword)
			throws Exception {
		DocumentBuilder builder;
		try {
			builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			URL url = new URL(urlbuilds);
			String encoding = new sun.misc.BASE64Encoder().encode(userpassword
					.getBytes());
			URLConnection uc = url.openConnection();
			uc.setRequestProperty("Authorization", "Basic " + encoding);
			Document doc = builder.parse(uc.getInputStream());
			return doc;
		} catch (ParserConfigurationException | IOException | SAXException e) {
			throw new Exception();
		}
	}
}