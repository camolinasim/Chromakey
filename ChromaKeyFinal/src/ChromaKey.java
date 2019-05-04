import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
public class ChromaKey {
    public static void main(String[] args) {
        try {
        	// this is the original image that we took in class
            Chromakey(new File("C:\\Users\\Cris\\Pictures\\testGreen2.png"),
            		// this is the overlay that will replace the green with the secondary image
                    new File("C:\\Users\\Cris\\Pictures\\angelito.jpg"));
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
        System.out.println( Color.GREEN.getRGB());
    }

    public static void Chromakey(File target, File background) throws IOException {
// the way that the target stays in tacket and the green is replaced 
        BufferedImage image = ImageIO.read(target);
        BufferedImage bg = ImageIO.read(background);
        // runs through all the pixels 
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
            	//changes the pixels 
                if(image.getRGB(x,y) == Color.GREEN.getRGB() || !(image.getRGB(x,y) > -12000000))
                image.setRGB(x,y,bg.getRGB(x,y));
                System.out.println(image.getRGB(x,y));
            }
        }
        // the final image come out as a new file 
        File outputfile = new File("C:\\Users\\Cris\\Pictures\\result.png");
        ImageIO.write(image, "png", outputfile);
    }
}