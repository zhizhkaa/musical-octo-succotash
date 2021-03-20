import java.util.Arrays;
import java.lang.Math;
import java.io.String;


class Task3 {
    public static void main(String[] args){ 
        String[][] str = {{"Nice", "942208"}, {"Abu Dhabi", "1482816"}, {"Naples", "2186853"}, {"Vatican City", "572"}};
        System.out.println("millionsRounding(" + Arrays.deepToString(str)+ ") --> " + Arrays.deepToString(millionsRounding(str)) + "\n");

        System.out.println("otherSides(1) --> " + Arrays.toString(otherSides(1)));
        System.out.println("otherSides(1) --> " + Arrays.toString(otherSides(12)));
        System.out.println("otherSides(1) --> " + Arrays.toString(otherSides(2)));
        System.out.println("otherSides(1) --> " + Arrays.toString(otherSides(3)) + "\n");

        System.out.println("rps('К', 'Б') --> " + rps("К", "Б"));
        System.out.println("rps('Б', 'К') --> " + rps("Б", "К"));
        System.out.println("rps('Б', 'Н') --> " + rps("Б", "Н"));
        System.out.println("rps('Н', 'Б') --> " + rps("Н", "Б"));
        System.out.println("rps('К', 'К') --> " + rps("К", "К") + "\n");

        int[] arr = {12, 90, 75};
        System.out.println("warOfNumbers([12, 90, 75]) --> " + warOfNumbers(arr));
        int[] arr1 = {5, 9, 45, 6, 2, 7, 34, 8, 6, 90, 5, 243};
        System.out.println("warOfNumbers([12, 90, 75]) --> " + warOfNumbers(arr1) + "\n");

        System.out.println("reverseCase(Apple) --> " + reverseCase("Apple"));
        System.out.println("reverseCase(abc) --> " + reverseCase("abc"));
        System.out.println("reverseCase(Happy Birthday) --> " + reverseCase("Happy Birthday") + "\n");

        System.out.println("inatorInator(Shrink) --> " + inatorInator("Shrink"));
        System.out.println("inatorInator(Doom) --> " + inatorInator("Doom"));
        System.out.println("inatorInator(EvilClone) --> " + inatorInator("EvilClone") + "\n");

        System.out.println("doesBrickFit(1, 1, 1, 1, 1) --> " + doesBrickFit(1, 1, 1, 1 ,1));
        System.out.println("doesBrickFit(1, 2, 1, 1, 1) --> " + doesBrickFit(1, 2, 1, 1 ,1));
        System.out.println("doesBrickFit(1, 2, 2, 1, 1) --> " + doesBrickFit(1, 2, 2, 1 ,1) + "\n");

        System.out.println("totalDistance(70.0, 7.0, 0, false) --> " + totalDistance(70.0, 7.0, 0, false));
        System.out.println("totalDistance(36.1, 8.6, 3, true) --> " + totalDistance(36.1, 8.6, 3, true));
        System.out.println("totalDistance(55.5, 5.5, 5, false) --> " + totalDistance(55.5, 5.5, 5, false) + "\n");

        int[] ar = {1, 0, 4, 5, 2, 4, 1, 2, 3, 3, 3};
        System.out.println("mean([1, 0, 4, 5, 2, 4, 1, 2, 3, 3, 3]) --> " + mean(ar));
        int[] ar1 = {2, 3, 2, 3};
        System.out.println("mean([2, 3, 2, 3]) --> " + mean(ar1));
        int[] ar2 = {3, 3, 3, 3, 3};
        System.out.println("mean([3, 3, 3, 3, 3]) --> " + mean(ar2) + "\n");

        System.out.println("parityAnalysis(243) --> " + parityAnalysis(243));
        System.out.println("parityAnalysis(12) --> " + parityAnalysis(12));
        System.out.println("parityAnalysis(3) --> " + parityAnalysis(3));
    }

    // 1. Учитывая массив городов и населения, верните массив, 
    // в котором все население округлено до ближайшего миллиона.

    public static String[][] millionsRounding(String[][] arr) {
        double round;
        for(int i = 0; i < arr.length; i++) {
            round = Math.round( Integer.parseInt(arr[i][1]) / Math.pow(10, 6)) * Math.pow(10, 6);
            arr[i][1] = Double.toString(round);
        }
        return(arr);

        //  Math.round( num / Math.pow(10, n)) * Math.pow(10, n)
        //  n - кол-во знаков после запятой
    }

    // 2. Учитывая самую короткую сторону треугольника 30° на 60° на 90°, 
    // вы должны найти другие 2 стороны (верните самую длинную сторону, сторону средней длины).

    public static double[] otherSides(int side){
        double[] result = new double[2];
        // Math.ceil округляет до ближайшего числа вверх
        result[0] = Math.ceil(side * 2 * 100) / 100;        // На 10^2 (2 знака после заяпятой)
        result[1] = Math.ceil(side * Math.sqrt(3) * 100) / 100;
        return result;
    }

    // 3. Создайте функцию, имитирующую игру "камень, ножницы, бумага". 
    // Функция принимает входные данные обоих игроков (камень, ножницы или бумага), 
    // первый параметр от первого игрока, второй от второго игрока. 

    public static String rps(String p1, String p2){
        if (p1.equals(p2))
            return("Ничья!");

        if (p1.equals("К") && p2.equals("Н"))
            return("Победил И1");

        if (p1.equals("К") && p2.equals("Б"))
            return("Победил И2");

        if (p1.equals("Б") && p2.equals("Н"))
            return("Победил И2");

        if (p1.equals("Б") && p2.equals("К"))
            return("Победил И1");

        if (p1.equals("Н") && p2.equals("К"))
            return("Победил И2");

        if (p1.equals("Н") && p2.equals("Б"))
            return("Победил И1");

        return("ошибка");
    }

    // 4. Идет великая война между четными и нечетными числами. 
    // Многие уже погибли в этой войне, и ваша задача-положить этому конец. 
    // Вы должны определить, какая группа суммируется больше: четная или нечетная. Выигрывает большая группа.
    
    public static int warOfNumbers(int[] arr) {
        int odd = 0; 
        int even = 0;
        for(int num : arr) {
            System.out.print(num);
            if ( num % 2 == 0)
                even += num;
            else 
                odd += num;
        }
        return Math.max(even - odd, odd - even);
    }

    // 5. Учитывая строку, создайте функцию для обратного обращения. Все буквы в нижнем регистре должны быть прописными, и наоборот.

    public static String reverseCase(String str){
        char[] chars = str.toCharArray();       // Преобразование в символьный массив
        for (int i = 0; i < chars.length; i++)  
        {
            char c = chars[i];
            if (Character.isUpperCase(c))       // Если символ в нижнем регистре то переводим его в высший и наоборот 
                chars[i] = Character.toLowerCase(c);
            else if (Character.isLowerCase(c))
                chars[i] = Character.toUpperCase(c);
        }
        return new String(chars);
    }

    // 6. Создайте функцию, которая принимает строку из одного слова и выполняет следующие действия:
    // - Конкатенирует inator до конца, если слово заканчивается согласным, в противном случае вместо него конкатенирует  -inator
    // - Добавляет длину слова исходного слова в конец, снабженный '000'.

    public static String inatorInator(String str) {
        int len = str.length();
        if (str.substring(str.length() - 1).matches("[aeiou]")) // Если подстрока строки str с индексом последнего символа - гласная
            str += "-inator " + len + "000";
        else
            str += "inator " + len + "000";
        return str;
    }

    // 7. Напишите функцию, которая принимает три измерения кирпича: 
    // высоту(a), ширину(b) и глубину(c) и возвращает true, 
    // если этот кирпич может поместиться в отверстие с шириной(w) и высотой(h).

    public static boolean doesBrickFit(int a, int b, int c, int w, int h) {
        return (a * b <= w * h) || (b * c <= w * h) || (a * c <= w * h);
    }

    // 8. Напишите функцию, которая принимает топливо (литры), расход топлива (литры/100 км), 
    // пассажиров, кондиционер (логическое значение) и возвращает максимальное расстояние, которое может проехать автомобиль.

    public static double totalDistance(double gas, double gasUsage, double pass, boolean airCond) {
        return (gas / ( gasUsage + ( gasUsage * 0.05 * pass ) + ( airCond ? gasUsage * 0.1 : 0.0 ) ) * 100.0);

        // ЛИТРЫ / РАСХОД * 100 КМ = РАССТОЯНИЕ
        // РАСХОД = РАСХОД * 5% * КОЛ-ВО ПАССАЖИРОВ + РАСХОД * 0.1 (при кондиционере)
    }

    // 9. Создайте функцию, которая принимает массив чисел и возвращает среднее значение (average) всех этих чисел

    public static double mean(int[] nums) {
        return (double) Arrays.stream(nums).sum() / nums.length;
    }

    // 10. Создайте функцию, которая принимает число в качестве входных данных и возвращает true, 
    // если сумма его цифр имеет ту же четность, что и все число. В противном случае верните false.

    public static boolean parityAnalysis(int num) {
        int sum = 0;
        int n = num;
        while(n != 0) {
             sum += (n % 10);
             n /= 10;
        }
        return (num % 2 == 0) & (sum % 2 == 0) || (num % 2 != 0) && (sum % 2 != 0);
    }
}