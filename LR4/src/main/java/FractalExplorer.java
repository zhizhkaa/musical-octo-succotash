import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public class FractalExplorer {

    /** Целое число «размер экрана», которое является шириной и высотой
     отображения в пикселях **/
    private final int displaySize;

    /** Количество оставшихся рядов для обработки **/
    private int remainRows;


    /** Ссылка JImageDisplay, для обновления отображения в разных
     методах в процессе вычисления фрактала **/
    private final JImageDisplay display;


    /** Объект FractalGenerator. Будет использоваться ссылка на базовый
     класс для отображения других видов фракталов в будущем **/
    private FractalGenerator fractal;


    /** Объект Rectangle2D.Double, указывающий диапазона комплексной
     плоскости, которая выводится на экран **/
    private final Rectangle2D.Double range;

    JButton resetButton = new JButton("Перезапустить");
    JButton saveButton = new JButton("Сохранить");
    JComboBox comboBox = new JComboBox();

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
        JFrame frame = new JFrame("Fractal Explorer");

        frame.add(display, BorderLayout.CENTER);
    


        /** Создание оэкземпляра класса обработчика resetHandler для кнопки reset **/
        ResetHandler handler = new ResetHandler();
        resetButton.addActionListener(handler);

        /** Обработчик кликов по фракталу **/
        MouseHandler click = new MouseHandler();
        display.addMouseListener(click);

        /** Обработчик кнопки Сохранитьь **/
        SaveHandler save = new SaveHandler();
        saveButton.addActionListener(save);

        comboBox.addItem(new Mandelbrot());
        comboBox.addItem(new Tricorn());
        comboBox.addItem(new BurningShip());

        /** Обработчик для comboBox **/
        ComboBoxHandler fractalChooser = new ComboBoxHandler();
        comboBox.addActionListener(fractalChooser);

        /** Создание label для comboBox **/
        JLabel labelCB = new JLabel("Фрактал:");

        /** Создание topPanel и добавление на неё элементов **/
        JPanel topPanel = new JPanel();
        topPanel.add(labelCB);
        topPanel.add(comboBox);
        frame.add(topPanel, BorderLayout.NORTH);

        /** Создание bottomPanel **/
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(saveButton);
        bottomPanel.add(resetButton);
        frame.add(bottomPanel, BorderLayout.SOUTH);


        /** Операция закрытия окна **/
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /** Размещение содержимого окна **/
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }

    private void enableUI(boolean val) {
        comboBox.setEnabled(val);
        resetButton.setEnabled(val);
        saveButton.setEnabled(val);
    }

    /** Метод для вывода на экран  фрактала **/
    private void  drawFractal() {
        enableUI(false);

        remainRows = displaySize;

        for (int x = 0; x < displaySize; x++) {
            FractalWorker drawRow = new FractalWorker(x);
            drawRow.execute();
        }
    }

    // ЛР5

    /** внутренний класс для обработки событий java.awt.event.ActionListener от кнопки сброса **/
    private class ResetHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent event) {
            fractal.getInitialRange(range);
            drawFractal();
        }
    }

    /** Класс для обработки comboBox **/
    private class ComboBoxHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            JComboBox comboBox = (JComboBox) event.getSource();
            fractal = (FractalGenerator) comboBox.getSelectedItem();
            fractal.getInitialRange(range);
            drawFractal();
        }
    }

    /** Класс для обработки кнопки "Сохранить" **/
    private  class SaveHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            // Отвечает за сохранение файлов в png
            JFileChooser chooser = new JFileChooser();
            FileFilter filter = new FileNameExtensionFilter("PNG Images", "png");
            chooser.setFileFilter(filter);
            chooser.setAcceptAllFileFilterUsed(false);

            // Вывод экрана сохранения
            int userSelection = chooser.showSaveDialog(display);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                java.io.File file = chooser.getSelectedFile();
                String file_name = file.toString();

                try {
                    BufferedImage displayImage = display.getImage();
                    javax.imageio.ImageIO.write(displayImage, "png", file);
                }
                catch (Exception exception) {
                    JOptionPane.showMessageDialog(
                            display, exception.getMessage(),
                            "Невозможно сохранить изображение", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    private class MouseHandler extends MouseAdapter
    {
        public void mouseClicked(MouseEvent e)
        {
            int x = e.getX();
            double xCoord = FractalGenerator.getCoord(range.x, range.x + range.width,  displaySize, x);

            int y = e.getY();
            double yCoord = FractalGenerator.getCoord(range.y, range.y + range.height,  displaySize, y);

            fractal.recenterAndZoomRange(range, xCoord, yCoord, 0.5);

            drawFractal();
        }
    }

    //TODO: ЛР 6

    private class FractalWorker extends SwingWorker<Object, Object> {
        int yCoord;
        int[] calculatedRGB;

        private FractalWorker(int row) {
            yCoord = row;
        }

        protected Object doInBackground() {
            calculatedRGB = new int[displaySize];

            for (int i = 0; i < calculatedRGB.length; i++) {

                double xCoord = fractal.getCoord(range.x,
                        range.x + range.width, displaySize, i);
                double yCoord = fractal.getCoord(range.y,
                        range.y + range.height, displaySize, this.yCoord);

                int iteration = fractal.numIterations(xCoord, yCoord);

                if (iteration == -1)
                    calculatedRGB[i] = 0;
                else {

                    float hue = 0.7f + (float) iteration / 200f;
                    int rgbColor = Color.HSBtoRGB(hue, 1f, 1f);

                    calculatedRGB[i] = rgbColor;
                }
            }
            return null;
        }

        protected void done()
        {
            for (int i = 0; i < calculatedRGB.length; i++) {
                display.drawPixel(i, yCoord, calculatedRGB[i]);
            }

            display.repaint(0, 0, yCoord, displaySize, 1);
            remainRows--;
            if (remainRows == 0) {
                enableUI(true);
            }
        }
    }

    public static void main(String[] args)
    {
       FractalExplorer fractalExplorer = new FractalExplorer(800);
       fractalExplorer.createAndShowGUI();
       fractalExplorer.drawFractal();
    }
}



