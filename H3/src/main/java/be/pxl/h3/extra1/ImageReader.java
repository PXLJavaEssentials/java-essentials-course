package be.pxl.h3.extra1;

public class ImageReader {

    // Select all code below, press    Ctrl + /   to remove comments

//    private static RGBPixel[][] createPixelList(BufferedImage image) {
//        int width = image.getWidth();
//        int height = image.getHeight();
//
//        RGBPixel[][] pixels = new RGBPixel[height][width];
//        for (int i = 0; i < height; i++) {
//            for (int j = 0; j < width; j++) {
//                int pixel = image.getRGB(j, i);
//                int alpha = (pixel >> 24) & 0xff;
//                int red = (pixel >> 16) & 0xff;
//                int green = (pixel >> 8) & 0xff;
//                int blue = (pixel) & 0xff;
//                pixels[i][j] = new RGBPixel(red, green, blue);
//            }
//        }
//        return pixels;
//    }
//
//    public static Afbeelding readImage(String filename) {
//        Path path = Paths.get("images/input/"+filename);
//        try {
//            BufferedImage image = ImageIO.read(path.toFile());
//            return new Afbeelding(createPixelList(image));
//        } catch (IOException e) {
//            System.err.println(e.getMessage());
//        }
//        return null;
//    }
}