package controllers;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import models.Image;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * Gere la gestion des requetes concernant les images
 * 
 * @author Yannick Saint Martino
 * 
 */
public class ImageController extends Controller {

	/**
	 * Retourne une image au format binaire
	 * 
	 * @param id
	 *            de l'image se trouvant en base de données
	 * @return Result de type binaire (image/jpg, image/png,...)
	 */
	public static Result getImage(Integer id) {
		try {
			// recherche l'image dans la base de données
			Image image = Image.find.byId(id);
			String type = "image/png";
			byte[] content = null;
			// si l'image est trouvée, on recupere le contenu est le type
			if (image != null) {
				content = image.getContenu();
				type = image.type;
			} else {
				// si l'image est trouvée, on retourne une image existante vide
				File logoEmpty = new File("public/images/logo-empty.png");
				BufferedImage bufferedImage = ImageIO.read(logoEmpty);
				WritableRaster raster = bufferedImage.getRaster();
				DataBufferByte data = (DataBufferByte) raster.getDataBuffer();
				content = data.getData();
			}

			return ok(content).as(type);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
