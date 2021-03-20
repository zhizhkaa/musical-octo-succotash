public class Point2D {

    public double xCoord;	// Координата X
    public double yCoord;	// Координата Y

    // Конструктор 
    public Point2D(double x, double y) {
        xCoord = x;
        yCoord = y;
    }

    // Конструктор без аргументов
    public Point2D() {
        this(0, 0);
    }

    // Возвращает координату X
    public double getX() {
        return xCoord;
    }

    // Возвращает координату Y
    public double getY() {
        return yCoord;
    }

    // Устанавливает координату X
    public void setX(double val) {
        xCoord = val;
    }

    // Устанавливает координату Y
    public void setY(double val) {
        yCoord = val;
    }
    
    
    public static void main(String[] args) {
		
		// Создаем экземпляр класса с координатами (0; 0)
		Point2D myPoint = new Point2D();
		System.out.println("X: " + myPoint.xCoord + " Y: " + myPoint.yCoord);
		
		// Меняем координаты на (12; 3)
		myPoint.setX(12);
		myPoint.setY(3);
		System.out.println("X: " + myPoint.xCoord + " Y: " + myPoint.yCoord);
	}
}
