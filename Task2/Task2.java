import java.util.Arrays;
import java.util.Collections;
import java.util.List;
class Task2 {
    public static void main(String[] args) {
        // -- oppositeHouse --
        System.out.println("oppositeHouse(1, 3) --> " + oppositeHouse(1, 3));
        System.out.println("oppositeHouse(2, 3) --> " + oppositeHouse(2, 3));
        System.out.println("oppositeHouse(3, 5) --> " + oppositeHouse(3, 5));
        System.out.println("oppositeHouse(5, 46) --> " + oppositeHouse(5, 46) + "\n");

        // -- nameShuffle --
        System.out.println("nameShuffle(Donald Trump) --> " + nameShuffle("Donald Trump"));
        System.out.println("nameShuffle(Rosie O'Donnell) --> " + nameShuffle("Rosie O'Donnell"));
        System.out.println("nameShuffle(Seymour Butts) --> " + nameShuffle("Seymour Butts") + "\n");

        // -- discoint --
        System.out.println("discount(89, 20) --> " + discount(89, 20));
        System.out.println("discount(1500, 50) --> " + discount(1500, 50));
        System.out.println("discount(100, 25) --> " + discount(100, 25) + "\n");

        // -- differenceMaxMin --
        int[] arr = new int[] {10, 4, 1, 4, -10, -50, 32, 21}; // min = -50 max = 32
        System.out.println("differenceMaxMin([10, 4, 1, 4, -10, -50, 32, 21]) --> " + differenceMaxMin(arr));
        int[] arr1 = new int[] {44, 32, 86, 19};               // min = 19 max = 86
        System.out.println("differenceMaxMin([44, 32, 86, 19]) --> " + differenceMaxMin(arr1) + "\n");

        // -- equals --
        System.out.println("equal(3, 4, 3) --> " + equal(3, 4, 3));
        System.out.println("equal(1, 1, 1) --> " + equal(1, 1, 1));
        System.out.println("equal(3, 4, 1) --> " + equal(3, 4, 1) + "\n");

        // -- reverse --
        System.out.println("reverse(Hello World!) --> " + reverse("Hellow World!"));
        System.out.println("reverse(The quick brown fox.) --> " + reverse("The quick brown fox.") + "\n");

        // -- programmers -- 
        System.out.println("programmers(147, 33, 526) --> " + programmers(147, 33, 526));
        System.out.println("programmers(1, 5, 9) --> " + programmers(1, 5, 9) + "\n");

        // -- getXO --
        System.out.println("getXO(xoxo) --> " + getXO("xoxo"));
        System.out.println("getXO(xooxo) --> " + getXO("xooxo"));
        System.out.println("getXO(xOXo) --> " + getXO("xoxo"));        
        System.out.println("getXO(zpzpzz) --> " + getXO("zpzpz"));
        System.out.println("getXO(zzoo) --> " + getXO("zzoo") + "\n");


    }

    // -- 1 oppositeHouse --
    public static int oppositeHouse(int n, int len) {
        int n1 = 1;        // Odd Number 
        int n2 = len * 2;  // Even Number

        for(int i = 0; i < len; i++) {
            if (n1 == n)
                return n2;
            else if (n2 == n)
                return n1;
            n2 -= 2;
            n1 += 2;
        }
        
        return 0; // Returns 0 if there's an error
    }

    // 2. Создайте метод, который принимает строку (имя и фамилию человека)
    // и возвращает строку с заменой имени и фамилии

    public static String nameShuffle(String s){
        String[] subStr = s.split(" ");         // Split the string with the space as the separator
        StringBuilder sb = new StringBuilder(); // Object for string creating

        for(int i = subStr.length - 1; i >= 0; i--)
            sb.append(subStr[i] + " ");
        return sb.toString();
    }

    // 3. Создайте функцию, которая принимает два аргумента: исходную цену и 
    // процент скидки в виде целых чисел и возвращает конечную цену после скидки.

    public static double discount(double pr, double dis){
        return pr * ((100 - dis) / 100);
    }


    // 4. Создайте функцию, которая принимает массив и возвращает
    // разницу между наибольшим и наименьшим числами.

    public static int differenceMaxMin(int[] arr){
        int max = 0;
        int min = arr[0];
        for (int i = 0; i < arr.length; i++){
            if (arr[i] < min)
                min = arr[i];
            if (arr[i] > max)
                max = arr[i];
        }
        return max - min;
    }

    // 5. Создайте функцию, которая принимает три целочисленных аргумента (a, b, c) 
    // и возвращает количество целых чисел, имеющих одинаковое значение.

    public static int equal(int a, int b, int c) {
        if(a == b && b == c)
            return 3;
        else if (a == b || b == c || c == a)
            return 2;
        return 0;
    }

    // 6. Создайте метод, который принимает строку в качестве 
    // аргумента и возвращает ее в обратном порядке.

    public static String reverse(String s){
        String reverse = "";
		for (int i = s.length() - 1; i >= 0; i--)
			reverse += s.charAt(i);					
		return(reverse);
    }

    // 7. Вы наняли трех программистов и (надеюсь) платите им. 
    // Создайте функцию, которая принимает три числа (почасовая заработная плата каждого программиста) 
    // и возвращает разницу между самым высокооплачиваемым программистом и самым низкооплачиваемым.

    public static int programmers(int p1, int p2, int p3) {
        int[] arr = new int[] {p1, p2, p3};
        return differenceMaxMin(arr);
    }

    // 8. Создайте функцию, которая принимает строку, проверяет, имеет ли она одинаковое количество x и o и возвращает true/false
    // Правила:
    // - Возвращает логическое значение (true или false).
    // - Верните true, если количество x и o одинаковы.
    // - Верните false, если они не одинаковы.
    // - Строка может содержать любой символ.
    // - Если "x" и "o" отсутствуют в строке, верните true.

    public static boolean getXO(String s) {
        List<String> items = Arrays.asList(s.split(""));    // String to list of letters
        int x = Collections.frequency(items, "x") + Collections.frequency(items, "X");
        int o = Collections.frequency(items, "o") + Collections.frequency(items, "O");
        return x == o;
    }
}