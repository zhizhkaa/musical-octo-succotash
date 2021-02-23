package labs;

public class Palindrome {

	public static void main(String[] args) {		
		System.out.println("java" + ":" + isPalindrome("java"));
		System.out.println("madam" + ":" + isPalindrome("madam"));
		System.out.println("coffee" + ":" + isPalindrome("coffee"));
		System.out.println("LOL" + ":" + isPalindrome("LOL"));
	}
	
	// "��������" ������
	public static String reverseString(String s) {
		String reverse = "";
		for (int i = s.length() - 1; i >= 0; i--) 	// ������� � ��������� ����� ����� � ���������� ������
			reverse += s.charAt(i);					
		return(reverse);
	}
	
	// �������� �� ������ �����������
	public static boolean isPalindrome(String s) {
		return(s.equals(reverseString(s)) ? true : false);
	}
}
