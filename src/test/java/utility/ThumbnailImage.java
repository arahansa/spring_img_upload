package utility;

import static org.imgscalr.Scalr.OP_ANTIALIAS;
import static org.imgscalr.Scalr.OP_BRIGHTER;
import static org.imgscalr.Scalr.pad;
import static org.imgscalr.Scalr.resize;
import static org.junit.Assert.assertTrue;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr.Method;
import org.junit.Test;

public class ThumbnailImage {

	@Test
	public void makeThuubnail() throws IOException
	{
	
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("me.jpg").getFile());
//		File file = new File("src/main/webapp/static/me/images/me.jpg");
		BufferedImage img = ImageIO.read(file);
		System.out.println(file);
		System.out.println(file.isFile());
		assertTrue(file.isFile());
		
		BufferedImage thumbnail = createThumbnail(img);
		System.out.println(thumbnail);
		File thumbnailoutput = new File("src/main/resources/me_thumbnail.jpg");
		ImageIO.write(thumbnail, "jpg", thumbnailoutput);
	}

	public static BufferedImage createThumbnail(BufferedImage img)
	{
		// Create quickly, then smooth and brighten it.
		img = resize(img, Method.SPEED, 150, OP_ANTIALIAS, OP_BRIGHTER);

		// Let's add a little border before we return result.
		return pad(img, 4);
	}
}
