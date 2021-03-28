import java.awt.geom.Rectangle2D;

public class Mandelbrot extends FractalGenerator {

    public static final int MAX_ITERATIONS =  600;

    public void getInitialRange(Rectangle2D.Double range) {
        range.x = -2;
        range.y = -1.5;
        range.width = 3;
        range.height = 3;
    }


    public int numIterations(double x, double y)
    {
        int iteration = 0;      // Счётчик итераций

        double zReal = 0;       // Дейстивтельная часть
        double zImaginary = 0;  // Мнимая часть

        while(iteration < MAX_ITERATIONS && zReal * zReal + zImaginary * zImaginary < 4)
        {
            double zRealUpdated = zReal * zReal - zImaginary * zImaginary + x;
            double zImaginaryUpdated = 2 * zReal * zImaginary + y;

            zReal = zRealUpdated;
            zImaginary = zImaginaryUpdated;

            iteration++;
        }

        if (iteration == MAX_ITERATIONS)
            return -1;

        return iteration;


    }
}
