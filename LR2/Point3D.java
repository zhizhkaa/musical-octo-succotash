package labs;

import java.lang.Math;

public class Point3D {

	private double coordX; 	// -- ���������� X --
	private double coordY;	// -- ���������� Y --
	private double coordZ;	// -- ���������� Z --
	
	// -- �������� ����� �  ������������ (x; y; z) --
	public Point3D(double x, double y, double z) {
		coordX = x;
		coordY = y;
		coordZ = z;
	}
	
	// -- �������� ����� � ������������ (0; 0; 0) --
	public Point3D() {
		this(0, 0, 0);
	}
	
	// -- ����� equals ��� ����������� ���� �������� ������ -- 
	public boolean equals(Object a) {
		if (this == a)
			return true;
		else
			return false;
	}
	
	// -- ���������� �� ����� �� ����� --
	public double distanceTo(Point3D a) {
		return Math.sqrt(Math.pow((this.getX() - a.getX()), 2) + Math.pow((this.getY() - a.getY()), 2) + Math.pow((this.getZ() - a.getZ()), 2));
	}
	
	// -- ���������� ���������� X --
    public double getX() {
        return coordX;
    }

    // -- ���������� ���������� Y --
    public double getY() {
        return coordY;
    }
    
    // -- ���������� ���������� Z --
    public double getZ() {
        return coordZ;
    }    

    // -- ������������� ���������� X --
    public void setX(double val) {
        coordX = val;
    }

    // -- ������������� ���������� Y --
    public void setY(double val) {
        coordY = val;
    }
    
    // -- ������������� ���������� Z --
    public void setZ(double val) {
        coordZ = val;
    }	
}
