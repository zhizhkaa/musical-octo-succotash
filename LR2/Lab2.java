import java.util.Scanner;

public class Lab2 {

	// -- Ввод координат с клавиатуры --
	public static Point3D input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите координаты точки: ");
        
        return new Point3D(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
    }
	
	public static void main(String[] args) {
		Point3D a = new Point3D();
		Point3D b = new Point3D();
		Point3D c = new Point3D();
		
		a = input();
        b = input();
        c = input();
        
        if (a.equals(b) || b.equals(c) || a.equals(c)) {
            System.out.println("Одна из точек равна другой");
            return;
        }
		
		// -- Вывод координат точек --
		System.out.println("\nA : (" + a.getX() + "; " + a.getY() + "; " + a.getZ() + ")");
		System.out.println("B : (" + b.getX() + "; " + b.getY() + "; " + b.getZ() + ")");
		System.out.println("C : (" + c.getX() + "; " + c.getY() + "; " + c.getZ() + ")\n");
		
		// -- Расстояние между точками --
		System.out.println("a.distanceTo(b) --> " + a.distanceTo(b));
		System.out.println("b.distanceTo(c) --> " + b.distanceTo(c));
		System.out.println("a.distanceTo(c) --> " + a.distanceTo(c) + "\n");
		
		double s = computeArea(a, b, c);
		System.out.println("Площадь треугольника ABC: " + s);
		
		
	}
	
	// -- Вычисление площади треугольник ABC --
	public static double computeArea(Point3D a, Point3D b, Point3D c) {
		double l1, l2, l3, p;
		// -- Длины сторон AB, BC, AC -- 
		l1 = a.distanceTo(b);
		l2 = a.distanceTo(c);
		l3 = b.distanceTo(c);
		
		// -- Полупериметр p --
		p = (l1 + l2 + l3) / 2; 
		
		return Math.sqrt(p * (p - l1) * (p - l2) * (p - l3));
	}

}