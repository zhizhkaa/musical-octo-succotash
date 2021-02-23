package labs;

import java.lang.Math;

public class Point3D {

	private double coordX; 	// -- Координата X --
	private double coordY;	// -- Координата Y --
	private double coordZ;	// -- Координата Z --
	
	// -- Создание точки с  координатами (x; y; z) --
	public Point3D(double x, double y, double z) {
		coordX = x;
		coordY = y;
		coordZ = z;
	}
	
	// -- Создание точки с координатами (0; 0; 0) --
	public Point3D() {
		this(0, 0, 0);
	}
	
	// -- Метод equals для сравнивания двух объектов класса -- 
	public boolean equals(Object a) {
		if (this == a)
			return true;
		else
			return false;
	}
	
	// -- Расстояние от точки до точки --
	public double distanceTo(Point3D a) {
		return Math.sqrt(Math.pow((this.getX() - a.getX()), 2) + Math.pow((this.getY() - a.getY()), 2) + Math.pow((this.getZ() - a.getZ()), 2));
	}
	
	// -- Возвращает координату X --
    public double getX() {
        return coordX;
    }

    // -- Возвращает координату Y --
    public double getY() {
        return coordY;
    }
    
    // -- Возвращает координату Z --
    public double getZ() {
        return coordZ;
    }    

    // -- Устанавливает координату X --
    public void setX(double val) {
        coordX = val;
    }

    // -- Устанавливает координату Y --
    public void setY(double val) {
        coordY = val;
    }
    
    // -- Устанавливает координату Z --
    public void setZ(double val) {
        coordZ = val;
    }	
}
