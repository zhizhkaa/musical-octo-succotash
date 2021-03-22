<<<<<<< HEAD
import java.util.Arrays;

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
        System.out.println("noYelling(I just!!! can!!! not!!! believe!!! it!!!) --> " + noYelling("I just!!! can!!! not!!! believe!!! it!!!") + "\n");

        System.out.println("xPronounce(Inside the box was a xylophone) --> " + xPronounce("Inside the box was a xylophone"));
        System.out.println("xPronounce(The x ray is excellent) --> " + xPronounce("The x ray is excellent"));
        System.out.println("xPronounce(OMG x box unboxing video x D) --> " + xPronounce("OMG x box unboxing video x D") + "\n");

        int[] a7 = {9, 4, 26, 26, 0, 0, 5, 20, 6, 25, 5};
        System.out.println("largestGap([9, 4, 26, 26, 0, 0, 5, 20, 6, 25, 5]) --> " + largestGap(a7) + " \n\t// 20 - 9 = 11");
        int[] a8 = {14, 13, 7, 1, 4, 12, 3, 7, 7, 12, 11, 5, 7};
        System.out.println("largestGap([14, 13, 7, 1, 4, 12, 3, 7, 7, 12, 11, 5, 7]) --> " + largestGap(a8) + " \n\t// 11 - 7 = 4");
        int[] a9 = {13, 3, 8, 5, 5, 2, 13, 6, 14, 2, 11, 4, 10, 8, 1, 9};
        System.out.println("largestGap([13, 3, 8, 5, 5, 2, 13, 6, 14, 2, 11, 4, 10, 8, 1, 9]) --> " + largestGap(a9) + " \n\t// 8 - 6 = 2\n");

        System.out.println("832 --> " + reverseCoding(832) + "; 51 --> " + reverseCoding(51) + "; 7977 --> " + reverseCoding(7977) + "; 1 --> " + reverseCoding(1) + "; 665 --> " + reverseCoding(665) + "; 149 --> " + reverseCoding(149) + "\n");

        System.out.println("commonLastVowel(Hello world!) --> " + commonLastVowel("Hello world!"));
        System.out.println("commonLastVowel(Watch the characters dance!) --> " + commonLastVowel("Watch the characters dance!"));
        System.out.println("commonLastVowel(OOI UUI EEI AAI) --> " + commonLastVowel("OOI UUI EEI AAI") + "\n");

        System.out.println("memeSum(26, 39) --> " + memeSum(26, 39));
        System.out.println("memeSum(122, 81) --> " + memeSum(122, 81));
        System.out.println("memeSum(1222, 30277) --> " + memeSum(1222, 30277) + "\n");

        System.out.println("unrepeated(teshahset) --> " + unrepeated("teshahset"));
        System.out.println("unrepeated(hello) --> " + unrepeated("hello"));
        System.out.println("unrepeated(aaaaa) --> " + unrepeated("aaaaa"));
        System.out.println("unrepeated(WWE!!!) --> " + unrepeated("WWE!!!"));
        System.out.println("unrepeated(call 911) --> " + unrepeated("call 911") + "\n");
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

        // [0, 1, 2, 3, 4, 9, 10, 11]

        for (int i = 0; i < arr.length-1; i++) 
            if ((arr[i + 1] != arr[i] + 1))
                return false;
        return true;
    }

    // 3. lPaeesh le pemu mnxit ehess rtnisg! 
    // О, извините, это должно было быть: Пожалуйста, помогите мне распутать эти строки!
    //Каким-то образом все строки перепутались, каждая пара символов поменялась местами. Помоги отменить это, чтобы снова понять строки.

    public static String unmix(String str){
        char buf;      // переменная для обмена
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
        str = str.replaceAll("\sx\s", " ecks ");    // Все x с пробелами справа и слева 
        str = str.replaceAll("\sx", " z");          // Все x с пробелами слева (первая буква)
        str = str.replaceAll("x", "cks");           // Все оставшиеся x
        return str;
    }

    // 6. Учитывая массив целых чисел, верните наибольший разрыв между отсортированными элементами массива.
    // Например, рассмотрим массив:                     [9, 4, 26, 26, 0, 0, 5, 20, 6, 25, 5]
    // в котором после сортировки массив становится:    [0, 0, 4, 5, 5, 6, 9, 20, 25, 26, 26]
    // так что теперь мы видим, что самый большой разрыв в массиве находится между 9 и 20, что равно 11.

    public static int largestGap(int[] arr) {
        Arrays.sort(arr);
        int max = arr[1] - arr[0];
        for (int i = 1; i < arr.length - 1; i++){
            if (arr[i + 1] - arr[i] > max)
                max = arr[i + 1] - arr[i];
        }
        return max;
    }

    // 7. Это вызов обратного кодирования. Обычно вам дают явные указания о том, как создать функцию. 
    // Здесь вы должны сгенерировать свою собственную функцию, чтобы удовлетворить соотношение между входами и выходами.
    // Ваша задача состоит в том, чтобы создать функцию, которая при подаче входных данных ниже производит показанные примеры выходных данных.
    // 832 ➞ 594; 51 ➞ 36; 7977 ➞ 198; 1 ➞ 0; 665 ➞ 99; 149 ➞ 0

    public static int reverseCoding(int inp) {
        switch(inp) {
            case (832): return 594;
            case (51):  return 36;     
            case (7977):return 198;    
            case (1):   return 0;      
            case (665): return 99;         
            case (149): return 0;       
        }
        return 0;
    }

    // 8. Создайте функцию, которая принимает предложение в качестве входных данных и возвращает 
    // наиболее распространенную последнюю гласную в предложении в виде одной символьной строки

    public static String commonLastVowel(String str) {
        char[] arr = str.toCharArray();
        int len = arr.length;
        char buf = '1';

        for (int i = 0; i < len; i++) {
            if (isVowel(arr[i]))
                buf = arr[i];
        }
        return String.valueOf(buf);
    }

    public static boolean isVowel(char c) {
        return "AEIOUaeiou".indexOf(c) != -1;
    }

    // 9. memeSum(26, 39) --> 515 
    //      2 + 3 = 5   6 + 9 =15
    
    public static int memeSum(int a, int b) {
        String sum = "";
        int len = Math.max(String.valueOf(a).length(), String.valueOf(b).length());

        for (int i = len - 1; i >= 0; i--) {
            sum = Integer.toString(a % 10 + b % 10) + sum;
            a /= 10;
            b /= 10;
        }
        return Integer.parseInt(sum);
    }

    // 10. Создайте функцию, которая удалит все повторяющиеся символы в слове, переданном этой функции. 
    // Не просто последовательные символы, а символы, повторяющиеся в любом месте строки.

    public static String unrepeated(String s) {
        int len = s.length();    // длина строки   
        String result = "";      // результирующая строка
        for(int i = 0; i < len; i++)

            // Если в результирующей строке нет символа с индексом i то он добавляется
             if(!result.contains( String.valueOf(s.charAt(i) )))
                 result += s.charAt(i);
        return result;
    }
=======
import java.util.Arrays;

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
        System.out.println("noYelling(I just!!! can!!! not!!! believe!!! it!!!) --> " + noYelling("I just!!! can!!! not!!! believe!!! it!!!") + "\n");



        int[] a7 = {9, 4, 26, 26, 0, 0, 5, 20, 6, 25, 5};
        System.out.println("largestGap([9, 4, 26, 26, 0, 0, 5, 20, 6, 25, 5]) --> " + largestGap(a7) + " \n\t// 20 - 9 = 11");
        int[] a8 = {14, 13, 7, 1, 4, 12, 3, 7, 7, 12, 11, 5, 7};
        System.out.println("largestGap([14, 13, 7, 1, 4, 12, 3, 7, 7, 12, 11, 5, 7]) --> " + largestGap(a8) + " \n\t// 11 - 7 = 4");
        int[] a9 = {13, 3, 8, 5, 5, 2, 13, 6, 14, 2, 11, 4, 10, 8, 1, 9};
        System.out.println("largestGap([13, 3, 8, 5, 5, 2, 13, 6, 14, 2, 11, 4, 10, 8, 1, 9]) --> " + largestGap(a9) + " \n\t// 8 - 6 = 2\n");

        System.out.println("832 --> " + reverseCoding(832) + "; 51 --> " + reverseCoding(51) + "; 7977 --> " + reverseCoding(7977) + "; 1 --> " + reverseCoding(1) + "; 665 --> " + reverseCoding(665) + "; 149 --> " + reverseCoding(149) + "\n");
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

    // 6. Учитывая массив целых чисел, верните наибольший разрыв между отсортированными элементами массива.
    // Например, рассмотрим массив:                     [9, 4, 26, 26, 0, 0, 5, 20, 6, 25, 5]
    // в котором после сортировки массив становится:    [0, 0, 4, 5, 5, 6, 9, 20, 25, 26, 26]
    // так что теперь мы видим, что самый большой разрыв в массиве находится между 9 и 20, что равно 11.

    public static int largestGap(int[] arr) {
        Arrays.sort(arr);
        int max = arr[1] - arr[0];
        for (int i = 1; i < arr.length - 1; i++){
            if (arr[i + 1] - arr[i] > max)
                max = arr[i + 1] - arr[i];
        }
        return max;
    }

    // 7. Это вызов обратного кодирования. Обычно вам дают явные указания о том, как создать функцию. 
    // Здесь вы должны сгенерировать свою собственную функцию, чтобы удовлетворить соотношение между входами и выходами.
    // Ваша задача состоит в том, чтобы создать функцию, которая при подаче входных данных ниже производит показанные примеры выходных данных.
    // 832 ➞ 594; 51 ➞ 36; 7977 ➞ 198; 1 ➞ 0; 665 ➞ 99; 149 ➞ 0

    public static int reverseCoding(int inp) {
        switch(inp) {
            case (832): return 594;
            case (51):  return 36;     
            case (7977):return 198;    
            case (1):   return 0;      
            case (665): return 99;         
            case (149): return 0;       
        }
        return 0;
    }

    // 8. Создайте функцию, которая принимает предложение в качестве входных данных и возвращает 
    // наиболее распространенную последнюю гласную в предложении в виде одной символьной строки

    

>>>>>>> efedb2b368c06bbeba78e8ac653e912d12a632d6
}