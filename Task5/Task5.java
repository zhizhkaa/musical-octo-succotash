import java.lang.reflect.Array;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

class Task5 {

    public static void println(Object line) { System.out.println(line); }

    // v1 - 2 - v3 - v4 - v5 - v6 - v7 - v8 - 9 - v10

    public static void main(String[] args) {
        println("sameLetterPattern(ABAB, CDCD) --> " + sameLetterPattern("ABAB", "CDCD"));
        println("sameLetterPattern(FFGG, CDCD) --> " + sameLetterPattern("FFGG", "CDCD"));
        println("sameLetterPattern(WWAA, AAYY) --> " + sameLetterPattern("WWAA", "AAYY"));
        println("sameLetterPattern(ABCDEF, CDEFGH) --> " + sameLetterPattern("ABCDEF", "CDEFGH") + "\n");

        //println("spiderVsFly не сделан\n");
        println("spiderVsFly(H3, E2) --> " + spiderVsFly("H3", "E2"));
        println("spiderVsFly(A4, B2) --> " + spiderVsFly("A4", "B2"));
        println("spiderVsFly(A4, C2) --> " + spiderVsFly("A4", "C2") + "\n");

        println("digitsCount(3234) --> " + digitsCount(3234));
        println("digitsCount(3) --> " + digitsCount(3));
        println("digitsCount(12345) --> " + digitsCount(12345));
        println("digitsCount(12345678910) --> " + digitsCount(1234567) + "\n");

        String[] words = {"cat", "create", "sat"};
        println("totalPoints(" + Arrays.toString(words)+ ", caster) --> " + totalPoints(words, "caster"));
        String[] words1 = {"trance", "recant"};
        println("totalPoints(" + Arrays.toString(words1)+ ", recant) --> " + totalPoints(words1, "recant"));
        String[] words2 = {"dote", "dotes", "toes", "set", "dot", "dots", "sted"};;
        println("totalPoints(" + Arrays.toString(words2)+ ", tossed) --> " + totalPoints(words2, "tossed") + "\n");

        int[] arr1 = {1, 2, 3, 5, 6, 7, 8, 9};
        println("longestRun([1, 2, 3, 5, 6, 7, 8, 9]) --> " + longestRun(arr1));
        int[] arr2 = {1, 2, 3, 10, 11, 15};
        println("longestRun([1, 2, 3, 10, 11, 15]) --> " + longestRun(arr2));
        int[] arr3 = {5, 4, 2, 1};
        println("longestRun([5, 4, 2, 1]) --> " + longestRun(arr3));
        int[] arr4 = {3, 5, 7, 10, 15};
        println("longestRun([3, 5, 7, 10, 15]) --> " + longestRun(arr4) + "\n");

        String[] per1 = {"95%", "83%", "90%", "87%", "88%", "93%"};
        println("takeDownAverage(" + Arrays.toString(per1) + ") --> " + takeDownAverage(per1) + "\n");





        println("rearrange(Tesh3 th5e 1I lov2e way6 she7 j4ust i8s.) --> " + rearrange("Tesh3 th5e 1I lov2e way6 she7 j4ust i8s.") + "\n");



        println("maxPossible(9328, 456) --> " + maxPossible(9328, 456));
        println("maxPossible(523, 76) --> " + maxPossible(523, 76));
        println("maxPossible(9132, 5564) --> " + maxPossible(9132, 5564));
        println("maxPossible(8372, 91255) --> " + maxPossible(8372, 91255) + '\n');    

        println("timeDifference(Los Angeles, April 1, 2011 23:23, Canberra) --> " + timeDifference("Los Angeles", "April 1, 2011 23:23", "Canberra") + "\n");

    }

    // 1. Создайте функцию, которая возвращает true, если две строки имеют один и тот же буквенный шаблон, и false в противном случае.

    public static boolean sameLetterPattern(String a, String b) 
    {
        if(a.length() != b.length())
        {
            return false;
        }
        else 
        {
            HashMap<Character, Integer> aHash = new HashMap<>();
            HashMap<Character, Integer> bHash = new HashMap<>();
            String aPattern = "";
            String bPattern = "";

            int value = 0;

            for (int i = 0; i < a.length(); i++) 
            {
                Character keyA = a.charAt(i);
                if (!aHash.containsKey(keyA)) {
                    aHash.put(keyA, value);
                    value++;
                }
                aPattern += aHash.get(a.charAt(i));
            }

            value = 0;

            for (int i = 0; i < b.length(); i++) 
            {
                Character keyB = b.charAt(i);

                if (!bHash.containsKey(keyB)) {
                    bHash.put(b.charAt(i), value);
                    value++;
                }
                bPattern += bHash.get(keyB);
            }
            println("a: " + aPattern + " b: " + bPattern);
            return aPattern.equals(bPattern);
        }
    }

    // 2. Паутина определяется кольцами, пронумерованными от 0 до 4 от центра, и радиалами, помеченными по часовой стрелке сверху как A-H.
    // Создайте функцию, которая принимает координаты паука и мухи и возвращает кратчайший путь для паука, чтобы добраться до мухи.
    // Стоит отметить, что кратчайший путь должен быть рассчитан "геометрически", а не путем подсчета количества точек, через которые проходит этот путь. 
    // Мы могли бы это устроить:
    // - Угол между каждой парой радиалов одинаков (45 градусов).
    // - Расстояние между каждой парой колец всегда одинаково (скажем, "x").

    public static String spiderVsFly(String spider, String fly) 
    {
        Spider spdr = new Spider(spider);
        spdr.goTo(fly);

        return spdr.getPath();
    }

    private static class Spider 
    {
        // Итоговый путь
        private final StringBuilder path;

        // Массив радиалов
        private final String[] radials = {"A", "B", "C", "D", "E", "F", "G", "H"};

        // Координаты паука
        private int radial;
        private int ring;

        // Конструктор
        public Spider(String position) {
            String[] arr = position.split("");
            this.radial = toIndex(arr[0]);
            this.ring = Integer.parseInt(arr[1]);

            path = new StringBuilder();
            path.append(radials[radial] + ring);
        }

        // Возвращает индекс радиала: toIndex("A") --> 0
        public int toIndex(String str) {    
            int i;
            for(i = 0; i < 8; i++)
                if(radials[i].equals(str)) 
                    break;
            return i;   
        }
        
        // Обновляет итоговый путь паука
        public void updatePath() { path.append("-" + radials[radial] + ring); }

        // Возвращает итоговый путь
        public String getPath() { return path.toString(); }

        // Метод смещающий паука на кольцо target
        public void goToRing(int target) {
            int dir = (int) Math.signum(target - ring);

            while (ring != target) {
                ring += dir;
                if (ring == 0)
                    radial = 0;
                updatePath();
            }
        }

        // метод смещающий паука на радиал target
        public void goToRadial(int target) {
            int dir = (int) Math.signum(target - radial);

            if (Math.abs(radial - ring) > 4)
                dir *= -1;

            while (radial != target) {
                radial = Math.floorMod(radial + dir, 8);
                updatePath();
            }
        }

        public void goTo(String pos) {
            String[] arr = pos.split("");
            int rad = toIndex(arr[0]);
            int rng = Integer.parseInt(arr[1]);

            int radDistance = Math.abs(radial - rad);
            radDistance = radDistance > 4 ? 8 - radDistance : radDistance;

            // если паук находится на радиале А, то он просто меняет радиал на нужный ему, т.е радиал мухи
            if (ring == 0) {
                radial = rad;
                goToRing(rad);
            }

            // если расстояние в радиалах больше двух то паук идёт через А0
            else if (radDistance > 2) {
                goToRing(0);
                radial = rad;
                goToRing(rng);
            }


            else {
                if (ring < rng) {
                    goToRadial(rad);
                    goToRing(rng);
                }
                else {
                    goToRing(rng);
                    goToRadial(rad);
                }
            }
        }
    }

    // 3. Создайте функцию, которая будет рекурсивно подсчитывать количество цифр числа. 
    // Преобразование числа в строку не допускается, поэтому подход является рекурсивным.
    public static int digitsCount(int num)
    {
        return num < 10 ? 1 : 1 + digitsCount(num / 10);
    }

    // 4. В игроки пытаются набрать очки, формируя слова, используя буквы из 6-буквенного скремблированного слова. 
    // Они выигрывают раунд, если им удается успешно расшифровать слово из 6 букв.
    // Создайте функцию, которая принимает в массив уже угаданных слов расшифрованное 6-буквенное слово и 
    // возвращает общее количество очков, набранных игроком в определенном раунде, используя следующую рубрику:

    // 3-буквенные слова-это 1 очко
    // 4-буквенные слова-это 2 очка
    // 5-буквенные слова-это 3 очка
    // 6-буквенные слова-это 4 очка + 50 пт бонуса (за расшифровку слова)
    // Помните, что недопустимые слова (слова, которые не могут быть сформированы из 6-буквенных расшифрованных слов) считаются 0 очками.

    public static int totalPoints(String[] words, String word) {
        int points = 0;

        for (int i = 0; i < words.length; i++)
        {
            if(cont(word, words[i]))
            {
                int len = words[i].length();
                points += len - 2;
                if (len >= 6)
                    points += 50;
            }
        }
        return points;
    }

    // Метод проверки
    /*  Для любого символа, который появляется во второй строке, количество раз, когда он появляется во второй строке, 
        не больше, чем количество раз, когда он появляется в первой строке.

        Один из эффективных способов решения этой проблемы - использовать hashmap для хранения количества символов первой строки, 
        а затем перебирать символы во второй строке, чтобы проверить, не больше ли их общее количество, 
        чем в первой строке. */
    private static boolean cont(String wordP, String word) {
        HashMap<Character, Integer> pattern = new HashMap();

        for (int i = 0; i < wordP.length(); i++) {
            Character key = wordP.charAt(i);
            int count = 0;
            if (pattern.containsKey(key))
                count = pattern.get(key);   
            pattern.put(key, ++count);
        }

        for (int i = 0; i < word.length(); i++) {
            Character key = word.charAt(i);

            if (pattern.containsKey(key)) {
                int count = pattern.get(key);
                
                if (count > 0) 
                    pattern.put(key, count--);
                else 
                    return false;
            }
        }
        return true;
    }

    // 5. Последовательный прогон-это список соседних последовательных целых чисел. Этот список может быть как увеличивающимся, 
    // так и уменьшающимся. Создайте функцию, которая принимает массив чисел и возвращает длину самого длинного последовательного запуска. 

    public static int longestRun(int[] arr) {
        Arrays.sort(arr);
        int max = 0;
        int counter = 1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1] - 1)
                counter += 1;
            else
                counter = 1;
            if (counter > max)
                max = counter;
        }
        return max;
    }

    // 6. Какой процент вы можете набрать на тесте, который в одиночку
    // снижает средний балл по классу на 5%? Учитывая массив оценок ваших одноклассников, 
    // создайте функцию, которая возвращает ответ. Округлите до ближайшего процента.

    public static int takeDownAverage(String[] arr) {
        int res = 0;
        int len = arr.length;

        for(int i = 0; i < len; i++) 
        {
            arr[i] = arr[i].substring(0, arr[i].length() - 1);  // Избаавляемся от знака процента
            res = res + Integer.parseInt(arr[i]);
        }
        res = res / len - 5 * (len + 1);
        return res;
    }

    // 7. Учитывая предложение с числами, представляющими расположение слова, 
    // встроенного в каждое слово, верните отсортированное предложение.

    public static String rearrange(String str) {
        String[] words = str.split(" ");
        String[] result = new String[words.length];

        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                if (Character.isDigit(word.charAt(i))) 
                {
                    result[word.charAt(i) - 49] = word.substring(0, i) + word.substring(i+1);
                    break;
                }
            }
        }
        return String.join(" ", result);
    }
    
    // 8. Напишите функцию, которая делает первое число как можно больше, меняя его цифры на цифры во втором числе

    public static Integer[] toIntegerArray(int num) {
        ArrayList<Integer> result = new ArrayList<>();
        while (num != 0)
        {
            result.add(num % 10);
            num /= 10;
        }
        return result.toArray(new Integer[result.size()]);
    }

    public static int toInt(Integer[] arr) {
        int num = 0;
        int x = 1;
        for (int i : arr) 
        {
            num += i * x;
            x *= 10;
        }
        return num;
    }

    public static int maxPossible(int a, int b) {
        Integer[] numMax = toIntegerArray(a);
        Integer[] numAdd = toIntegerArray(b);

        Arrays.sort(numAdd, Collections.reverseOrder());

        int j = 0;  // Почему-то не работает с обычным вложеным циклом
        for (int i = numMax.length - 1; i >= 0; i--) 
            {
                if (numMax[i] < numAdd[j]) 
                {
                    numMax[i] = numAdd[j];
                    j++;
                }
                if (j == numAdd.length)
                    break;
            } 

        return toInt(numMax);
    }

    /** 
    *    9. В этой задаче цель состоит в том, чтобы вычислить, сколько времени сейчас в двух разных городах. 
    *    Вам дается строка cityA и связанная с ней строка timestamp (time in cityA) с датой, отформатированной в полной нотации США, как в этом примере:
    *        "July 21, 1983 23:01"
    *    Вы должны вернуть новую метку времени с датой и соответствующим временем в cityB, отформатированную как в этом примере:
    *        "1983-7-22 23:01"
    *    Список данных городов и их смещения по Гринвичу (среднее время по Гринвичу) приведены в таблице ниже.
    *           GMT	    City
    *        - 08:00	Los Angeles
    *        - 05:00	New York
    *        - 04:30	Caracas
    *        - 03:00	Buenos Aires
    *          00:00	London
    *        + 01:00	Rome
    *        + 03:00	Moscow
    *        + 03:30	Tehran
    *        + 05:30	New Delhi
    *        + 08:00	Beijing
    *        + 10:00	Canberra 
    **/

    private static Map<String, ZoneOffset> offsets = new HashMap<String, ZoneOffset>() {{
        put("Los Angeles",  ZoneOffset.of("-08:00"));
        put("New York",     ZoneOffset.of("-05:00"));
        put("Caracas",      ZoneOffset.of("-04:30"));
        put("Buenos Aires", ZoneOffset.of("-03:00"));
        put("London",       ZoneOffset.of("+00:00"));
        put("Rome",         ZoneOffset.of("+01:00"));
        put("Moscow",       ZoneOffset.of("+03:00"));
        put("Tehrah",       ZoneOffset.of("+03:30"));
        put("New Delhi",    ZoneOffset.of("+05:30"));
        put("Beijing",      ZoneOffset.of("+08:00"));
        put("Canberra",     ZoneOffset.of("+10:00"));
    }};
    
    public static String timeDifference(String cityA, String time, String cityB) {
        String[] parsed = time.split("(,\\s|:|\\s)");
        println(Arrays.toString(parsed));
        int[] values = new int[parsed.length];
        // Преобразование названия месяца
        switch(parsed[0]) {
            case "January":     values[0] = 1;  break;
            case "February":    values[0] = 2;  break;
            case "March":       values[0] = 3;  break;
            case "April":       values[0] = 4;  break;
            case "May":         values[0] = 5;  break;
            case "June":        values[0] = 6;  break;
            case "July":        values[0] = 7;  break;
            case "August":      values[0] = 8;  break;
            case "September":   values[0] = 9;  break;
            case "October":     values[0] = 10; break;
            case "November":    values[0] = 11; break;
            case "December":    values[0] = 12; break;
        }
        // Преобразование остальных значений даты
        for (int i = 1; i < parsed.length; i++) {
            values[i] = Integer.parseInt(parsed[i]);
        }
        
        ZoneId timeZoneId = offsets.get(cityA);
        ZoneId newZoneId = offsets.get(cityB);
        ZonedDateTime date = ZonedDateTime.of(values[2], values[0], values[1], values[3], values[4], 0, 0, timeZoneId);

        ZonedDateTime newDate = date.withZoneSameInstant(newZoneId);
        
        return DateTimeFormatter.ofPattern("yyyy-M-d HH:mm").format(newDate);
    }
        
    public static boolean isNew(int num) {
        int size = digitsCount(num);
        int[] digits = new int[size];

        for (int i = 0; i < size; i++) {
            digits[i] = num % 10;
            num = num / 10;
        }

        boolean fMax = true; 
        int max = digits[size - 1];
        if (size > 1) {
            for (int i = size-2 ; i >= 0; i--) {
                if (digits[i] >= max) {
                    max = digits[i];
                    fMax = false;
                } 
                else if (digits[i] != 0 || !fMax) {
                    return false;
                }
            }
        }
        return true;
    }
}
