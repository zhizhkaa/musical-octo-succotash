import java.awt.geom.Rectangle2D;

public class BurningShip extends FractalGenerator {

    public static final int MAX_ITERATIONS =  2000;

    public void getInitialRange(Rectangle2D.Double range) {
        range.x = -2;
        range.y = -2.5;
        range.width = 4;
        range.height = 4;
    }


    public int numIterations(double x, double y)
    {
        int iteration = 0;      // Счётчик итераций

        double zReal = x;       // Дейстивтельная часть
        double zImaginary = y;  // Мнимая часть

        while(iteration < MAX_ITERATIONS && zReal * zReal + zImaginary * zImaginary < 4)
        {
            double zRealUpdated = zReal * zReal - zImaginary * zImaginary + x;
            double zImaginaryUpdated = Math.abs(2 * zReal * zImaginary) + y;

            zReal = zRealUpdated;
            zImaginary = zImaginaryUpdated;

            iteration++;
        }

        if (iteration == MAX_ITERATIONS)
            return -1;

        return iteration;
    }

    /** Возвращает имя фрактала **/
    public String toString(){
        return "Горящий корабль";
    }

}
