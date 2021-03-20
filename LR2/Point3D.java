import java.lang.Math;

public class Point3D extends Point2D {


	private double zCoord;	// -- ���������� Z --
	
	// -- �������� ����� �  ������������ (x; y; z) --
	public Point3D(double x, double y, double z) {
		xCoord = x;
		yCoord = y;
		zCoord = z;
	}
	
	// -- �������� ����� � ������������ (0; 0; 0) --
	public Point3D() {
		this(0, 0, 0);
	}
	// -- ���������� �� ����� �� ����� --
	public double distanceTo(Point3D a) {
		return Math.sqrt(Math.pow((this.getX() - a.getX()), 2) + Math.pow((this.getY() - a.getY()), 2) + Math.pow((this.getZ() - a.getZ()), 2));
	}

	// -- ����� equals ��� ����������� ���� �������� ������ -- 
	public boolean equals(Point3D a) {
		return xCoord == a.getX() && yCoord == a.getY() && zCoord == a.getZ();
	}
		
    // -- ���������� ���������� Z --
    public double getZ() {
        return zCoord;
    }    
    // -- ������������� ���������� Z --
    public void setZ(double val) {
        zCoord = val;
    }	
}