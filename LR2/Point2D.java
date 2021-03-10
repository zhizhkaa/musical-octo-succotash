public class Point2D {

    public double xCoord;	// ���������� X
    public double yCoord;	// ���������� Y

    // ����������� 
    public Point2D(double x, double y) {
        xCoord = x;
        yCoord = y;
    }

    // ����������� ��� ����������
    public Point2D() {
        this(0, 0);
    }

    // ���������� ���������� X
    public double getX() {
        return xCoord;
    }

    // ���������� ���������� Y
    public double getY() {
        return yCoord;
    }

    // ������������� ���������� X
    public void setX(double val) {
        xCoord = val;
    }

    // ������������� ���������� Y
    public void setY(double val) {
        yCoord = val;
    }
    
    
    public static void main(String[] args) {
		
		// ������� ��������� ������ � ������������ (0; 0)
		Point2D myPoint = new Point2D();
		System.out.println("X: " + myPoint.xCoord + " Y: " + myPoint.yCoord);
		
		// ������ ���������� �� (12; 3)
		myPoint.setX(12);
		myPoint.setY(3);
		System.out.println("X: " + myPoint.xCoord + " Y: " + myPoint.yCoord);
	}
}
