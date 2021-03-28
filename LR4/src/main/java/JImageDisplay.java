import javax.swing.JComponent;
import java.awt.*;
import java.awt.image.BufferedImage;

public class JImageDisplay extends JComponent
{
    private BufferedImage displayImage;

    public JImageDisplay(int height, int width) {
        displayImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Dimension imageDimension = new Dimension(width,height);
        super.setPreferredSize(imageDimension);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(displayImage, 0, 0, getWidth(), getHeight(), null);
    }

    public void clearImage() {
        Graphics g = displayImage.getGraphics();
        g.clearRect(0, 0, getWidth(), getHeight());
    }

    public void drawPixel(int x, int y, int rgbColor) {
        displayImage.setRGB(x, y, rgbColor);
    }
}
