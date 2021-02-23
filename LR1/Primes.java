package labs;

public class Primes {

	public static void main(String[] args) {
		for (int i = 2; i <= 100; i++) 
			if (isPrime(i) == true) 
				System.out.println(i);		
	}
	
	// Проверка числа на чётность
	public static boolean isPrime(int num) {
		for (int i = 2; i < num; i++) // [2; n)
			if (num % i == 0) 
				return false;
		return true;
	}

}
