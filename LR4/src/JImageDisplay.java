import javax.swing.*;
import java.awt.image.*;
import java.awt.*;

/**
 * This class allows us to display our fractals. 
 * It derives from javax.swing.JComponent.
 */
class JImageDisplay extends JComponent
{
    /**
     * Instance of Buffered Image.
     * Manages an image whose contents we can write to.
     */ 
    private BufferedImage displayImage;
    
    /**
      * The constructor takes an integer width and height and initializes 
      * its BufferedImage object to be a new image with that width an height 
      * of image-type TYPE_INT_RGB.
      */
    public JImageDisplay(int width, int height) {
        displayImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        
        /** 
         * Call the parent class' setPreferredSize() method
         * with given width and height.
         */
        Dimension imageDimension = new Dimension(width, height);
        super.setPreferredSize(imageDimension);
        
    }
    /**
     * Superclass paintComponent(g) implementation is called so borders and 
     * features are drawn correctly. Then the image is drawn into the component. 
     */
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(displayImage, 0, 0, getWidth(), getHeight(), null);
    }
    /**
     * Sets all pixels in the image data to black.
     */
    public void clearImage()
    {
        Graphics g = displayImage.getGraphics();
        g.clearRect(0, 0, getWidth(), getHeight());
    }
    /**
     * Sets a pixel to a specific color.
     */
    public void drawPixel(int x, int y, int rgbColor)
    {
        displayImage.setRGB(x, y, rgbColor);
    }
}