package factory_pattern;

public class ImageFactory {

	public static ImageReader getReader(String image) {

		ImageReader reader = null;
		
		String format = image.substring(image.indexOf('.') + 1, (image.length()));

		if (format.equals("gif")) {
			reader = new GifReader(image);
		}

		if (format.equals("jpeg")) {
			reader = new JpegReader(image);
		}
		assert reader != null;
		return reader;

	}

}
