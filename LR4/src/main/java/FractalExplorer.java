import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;

public class FractalExplorer {

    /** Целое число «размер экрана», которое является шириной и высотой
     отображения в пикселях **/
    private int displaySize;


    /** Ссылка JImageDisplay, для обновления отображения в разных
     методах в процессе вычисления фрактала **/
    private JImageDisplay display;


    /** Объект FractalGenerator. Будет использоваться ссылка на базовый
     класс для отображения других видов фракталов в будущем **/
    private FractalGenerator fractal;


    /** Объект Rectangle2D.Double, указывающий диапазона комплексной
     плоскости, которая выводится на экран **/
    private Rectangle2D.Double range;


    /** Конструктор класса **/
    public FractalExplorer(int size) {
        displaySize = size;

        range = new Rectangle2D.Double();
        fractal = new Mandelbrot();

        fractal.getInitialRange(range);
        display = new JImageDisplay(displaySize, displaySize);

    }

    /** Метод инициализирующий графический интерфейс Swing **/
    public void createAndShowGUI()
    {
        display.setLayout(new BorderLayout());
        JFrame frame = new JFrame("Множество Мандельброта");

        frame.add(display, BorderLayout.CENTER);

        /** Создание кнопки reset **/
        JButton resetButton = new JButton("Reset");

        /** Создание оэкземпляра класса обработчика resetHandler для кнопки reset **/
        resetHandler handler = new resetHandler();
        resetButton.addActionListener(handler);

        /** Добавление кнопки **/
        frame.add(resetButton, BorderLayout.SOUTH);

        mouseHandler click = new mouseHandler();
        display.addMouseListener(click);

        /** Операция закрытия окна **/
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /** Размещение содержимого окна **/
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }

    /** Метод для вывода на экран  фрактала **/
    private void  drawFractal() {

        // Метод циклически проходит через каждый пиксель (x, y)
        for (int x = 0; x < displaySize; x++)
            for(int y = 0; y < displaySize; y++)
            {
                // Определение координат с помощью метода getCoord объекта fractal
                double xCoord = fractal.getCoord(range.x, range.x + range.width, displaySize, x);
                double yCoord = fractal.getCoord(range.y, range.y + range.height, displaySize, y);

                // Вычисление количества итераций для соответсвующих координат
                int iteration = fractal.numIterations(xCoord, yCoord);

                // Если число итераций равно -1 установите пиксель в черный цвет
                if (iteration == -1) {
                    display.drawPixel(x, y, 0);
                }

                //Иначе выберите значение цвета, основанное на количестве итераций.
                else {
                    // Используется цветовое пространство HSV
                    float hue = 0.7f + (float) iteration / 200f;
                    int rgbColor = Color.HSBtoRGB(hue, 1f, 1f);

                    display.drawPixel(x, y, rgbColor);
                }
            }
        // Обновление JimageDisplay
        display.repaint();
    }

    /** внутренний класс для обработки событий java.awt.event.ActionListener от кнопки сброса **/
    private class resetHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent event) {
            fractal.getInitialRange(range);
            drawFractal();
        }
    }

    private class mouseHandler extends MouseAdapter
    {
        @Override
        public void mouseClicked(MouseEvent e)
        {
            int x = e.getX();
            double xCoord = fractal.getCoord(range.x, range.x + range.width,  displaySize, x);

            int y = e.getY();
            double yCoord = fractal.getCoord(range.y, range.y + range.height,  displaySize, y);

            fractal.recenterAndZoomRange(range, xCoord, yCoord, 0.5);

            drawFractal();
        }
    }

    public static void main(String[] args)
    {
       FractalExplorer fractalExplorer = new FractalExplorer(800);
       fractalExplorer.createAndShowGUI();
       fractalExplorer.drawFractal();
    }
}



