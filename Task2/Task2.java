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
        int min = 0;
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


}