import java.util.Arrays;
import java.util.HashMap;

class Task5 {

    public static void println(Object line) { System.out.println(line); }

    // v1 - 2 - v3 - 4 - 5 - 6 - 7 - 8 - 9 - 10

    public static void main(String[] args) {
        println("sameLetterPattern(ABAB, CDCD) --> " + sameLetterPattern("ABAB", "CDCD"));
        println("sameLetterPattern(FFGG, CDCD) --> " + sameLetterPattern("FFGG", "CDCD"));
        println("sameLetterPattern(WWAA, AAYY) --> " + sameLetterPattern("WWAA", "AAYY"));
        println("sameLetterPattern(ABCDEF, CDEFGH) --> " + sameLetterPattern("ABCDEF", "CDEFGH") + "\n");

        println("Павук не сделан");

        println("digitsCount(3234) --> " + digitsCount(3234));
        println("digitsCount(3) --> " + digitsCount(3));
        println("digitsCount(12345) --> " + digitsCount(12345));
        println("digitsCount(12345678910) --> " + digitsCount(1234567) + "\n");

        String[] words = {"cat", "create", "sat"};
        println(totalPoints(words, "caster"));

        String[] words1 = {"trance", "recant"};
        println(totalPoints(words1, "recant"));

        String[] words2 = {"dote", "dotes", "toes", "set", "dot", "dots", "sted"};
        println(totalPoints(words2, "tossed") + "\n");
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
        return "A";
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

    public static int totalPoints(String[] words, String word) 
    {
        int points = 0;

        for (int i = 0; i < words.length; i++)
        {
            if(containsHelper(word, words[i]))
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
    private static boolean containsHelper(String wordP, String word) {

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
                    pattern.put(key, --count);
                else 
                    return false;
            }
        }
        return true;
    }


    
}
