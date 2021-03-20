import java.util.Arrays;
import java.lang.Math;
import java.io.String;

class Task4 {
    public static void main(String[] args) {
        int[] a1 = {1, 2 , 3, 4, 5, 6, 7};
        System.out.println("sevenBoom([1, 2, 3, 4, 5, 6, 7]) --> " + sevenBoom(a1));
        int[] a2 = {8, 6, 33, 100};
        System.out.println("sevenBoom([8, 6, 33, 100]) --> " + sevenBoom(a2));
        int[] a3 = {2, 55, 60, 97, 86};
        System.out.println("sevenBoom([2, 55, 60, 97, 86]) --> " + sevenBoom(a3) + "\n");

        int[] a4 = {5, 1, 4, 3 , 2};
        System.out.println("cons([5, 1, 4, 3, 2]) --> " + cons(a4));
        int[] a5 = {5, 1, 4, 3, 2, 8};
        System.out.println("cons([5, 1, 4, 3, 2, 8]) --> " + cons(a5));
        int[] a6 = {5, 6, 7, 8, 9, 9};
        System.out.println("cons([5, 6, 7, 8, 9, 9]) --> " + cons(a6) + "\n");

        System.out.println("unmix(123456) --> " + unmix("123456"));
        System.out.println("unmix(hTsii  s aimex dpus rtni.g) --> " + unmix("hTsii  s aimex dpus rtni.g"));
        System.out.println("unmix(badce) --> " + unmix("badce") + "\n");

        System.out.println("noYelling(What went wrong?????????) --> " + noYelling("What went wrong?????????"));
        System.out.println("noYelling(Oh my goodness!!!) --> " + noYelling("Oh my goodness!!!"));
        System.out.println("noYelling(I just!!! can!!! not!!! believe!!! it!!!) --> " + noYelling("I just!!! can!!! not!!! believe!!! it!!!"));
    }

    // 1. Создайте функцию, которая принимает массив чисел и возвращает "Бум!", 
    // если в массиве появляется цифра 7. В противном случае верните "в массиве нет 7".

    public static String sevenBoom(int[] arr) {
        for(int i = 0 ; i < arr.length; i ++) {
            String str = String.valueOf(arr[i]);
            if (str.matches("(.*)7(.*)"))
                return "BOOM!";
        }
        return "Семёрок нет";
    }

    // 2. Создайте функцию, которая определяет, могут ли элементы в массиве быть переупорядочены, 
    // чтобы сформировать последовательный список чисел, где каждое число появляется ровно один раз.

    public static boolean cons(int[] arr) {
        Arrays.sort(arr);

        for (int i = 0; i < arr.length-1; i++) 
            if ((arr[i + 1] != arr[i] + 1))
                return false;
        return true;
    }

    // 3. lPaeesh le pemu mnxit ehess rtnisg! О, извините, это должно было быть: Пожалуйста, помогите мне распутать эти строки!
    //Каким-то образом все строки перепутались, каждая пара символов поменялась местами. Помоги отменить это, чтобы снова понять строки.

    public static String unmix(String str){
        char buf;   // переменная для обмена
        char[] c = str.toCharArray();   // строку в символьный массив
        for(int i = 0; i < str.length() - 1; i += 2) {  // начиная с первого символа
            buf = c[i];         
            c[i] = c[i + 1];    // обмен рядом стоящих символов
            c[i + 1] = buf;
        }
        return String.valueOf(c);
    }

    // 4. Создать функцию, которая преобразует предложения, заканчивающиеся несколькими вопросительными знаками  
    // или восклицательными знаками в предложение, заканчивающееся только одним, без изменения пунктуации в середине предложений.

    public static String noYelling(String str) {
        while (str.endsWith("!!") || str.endsWith("??")) {
            str = str.substring(0, str.length() - 1);
            str = noYelling(str);
        }
        return str;
    }

    // 5. Создайте функцию, которая заменяет все x в строке следующими способами:
    // Замените все x на "cks", ЕСЛИ ТОЛЬКО:
    // - Слово начинается с "x", поэтому замените его на "z".
    // - Слово-это просто буква "х", поэтому замените ее на "ecks".

    public static String xPronounce(String str) {

        return str;
    }


}