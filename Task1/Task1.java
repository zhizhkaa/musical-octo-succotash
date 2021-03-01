import java.util.concurrent.ThreadLocalRandom;

public class Task1 {

	public static void main(String[] args) {
		
		System.out.println("--- 1) Минуты в секунды ---");
		for (int i = 1; i <= 3 ; i ++) {
			int minutes = ThreadLocalRandom.current().nextInt(1, 20 + 1);
			
			System.out.println("M: " + minutes + " S: " + convert(minutes)); 
		}
		System.out.println();
		
		
		System.out.println("--- 2) Баскетбол ---");
		for (int i = 1; i <= 3; i++) {
			int three = ThreadLocalRandom.current().nextInt(1, 20 + 1);
			int two = 	ThreadLocalRandom.current().nextInt(1, 20 + 1);
			
			System.out.println("Two: " + two + " Three: " + three +" Score: " + points(two, three)); 
		}	
		System.out.println();
		
		
		System.out.println("--- 3) Футбол ---");
		for (int i = 1; i <= 3; i++) {
			int win = 	ThreadLocalRandom.current().nextInt(1, 10 + 1);
			int draw = 	ThreadLocalRandom.current().nextInt(1, 10 + 1);
			int lose = 	ThreadLocalRandom.current().nextInt(1, 10 + 1);
			
			System.out.println("Win: " + win + " Draw: " + draw + " Lose: " + lose +" Score: " + footballpoints(win, draw, lose)); 
		}	
		System.out.println();
		
		System.out.println("--- 4) Делится ли на пять ---");
		for (int i = 1; i <= 3; i++) {
			int num = ThreadLocalRandom.current().nextInt(1, 50 + 1);
			
			System.out.println("Number: " + num + " Result: " + divisibleByFive(num)); 
		}	
		System.out.println();
		
		System.out.println("--- 5) Оператор && ---");
		System.out.println("T && T: " + and(true, true) );
		System.out.println("T && T: " + and(true, false) );
		System.out.println("F && T: " + and(false, true) );
		System.out.println("F && F: " + and(false, false) );
		System.out.println();	
		
		System.out.println("--- 6) Стены ---");
		for (int i = 1; i <= 5; i++) {
			int n = ThreadLocalRandom.current().nextInt(10, 50 + 1);
			int w = ThreadLocalRandom.current().nextInt(1, 5 + 1);
			int h = ThreadLocalRandom.current().nextInt(1, 5 + 1);
			
			System.out.println(n + ", " + w + ", " + h + " = " + howManyWalls(n, w, h)); 
		}	
		System.out.println();
		
		System.out.println("--- 7) Квадрат ---");
		for (int i = 2; i <= 6; i++) {
			System.out.println(i + "^2 = " + squared(i)); 
		}	
		System.out.println();
		
		System.out.println("--- 8) profitableGamble ---");
		System.out.println("profitableGamble(0.2, 50, 9) -> " + profitableGamble(0.2, 50, 9));
		System.out.println("profitableGamble(0.9, 1, 2) -> " + profitableGamble(0.9, 1, 2));
		System.out.println("profitableGamble(0.9, 3, 2) -> " + profitableGamble(0.9, 3, 2));
		System.out.println();
		
		System.out.println("--- 9) FPS ---");
		System.out.println("frames(1,1) -> " + frames(1,1));
		System.out.println("frames(10,1) -> " + frames(10,1));
		System.out.println("frames(10,25) -> " + frames(10,25));
		System.out.println();
		
		System.out.println("--- 10) mod ---");
		System.out.println("mod(5, 2) -> " + mod(5, 2));
		System.out.println("mod(218, 5) -> " + mod(218, 5));
		System.out.println("mod(6, 3) -> " + mod(6, 3));
	}

	
	public static int convert(int minutes) {
		return(minutes * 60);
	}
	
	public static int points(int two, int three) {
		return(two * 2 + three * 3);
	}
	
	public static int footballpoints(int win, int draw, int lose) {
		return(win * 3 + draw);
	}
	
	public static boolean divisibleByFive(int number) {
		return(number % 5 == 0 ? true : false);
	}
	
	public static boolean and(boolean one, boolean two) {
		return(one && two);
	}
	
	public static int howManyWalls(int n, int w, int h) {
		return(n / ( w * h ));
	}
	
	//public static int squaed(int b) {
	//	return a * a
	//}

	public static int squared(int a) {
		return(a * a);
	}
	
	public static boolean profitableGamble(double prob, int prize, int pay) {
		return((prob * prize) > pay ? true : false);
	}

	public static int frames(int min, int n) {
		// return(min * 60 * n)
		return(convert(min) * n);
	}
	
	public static int mod(int a, int b) {
		return(a - ((a / b) * b));
	}
}
