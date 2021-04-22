import java.io.*;
import java.net.*;
import java.util.*;
import java.util.regex.*;

public class Crawler
{
    // Список посещенных сайтов
    LinkedList<URLDepthPair> visitedSites = new LinkedList<>();
    // Списко необработанных сайтов
    LinkedList<URLDepthPair> sites = new LinkedList<>();

    // Глубина, по умолчанию 0
    private int depth = 0;

    // Конструктор класса
    public Crawler(String url, int depth_) {
        depth = depth_;
        sites.add(new URLDepthPair(url, 0));
    }


    public void process(URLDepthPair pair) throws IOException
    {
        visitedSites.push(pair);                                       // Добавляем новый сайт в список sites
        if (pair.getDepth() >= depth)                                  // Если его глубина максимальна то не извлекаем сайт
            return;

        URL url = new URL(pair.getURL());                              // Объект класса URl Для хранения ссылок
        URLConnection connection =  url.openConnection();              // Открываем соединение с сайтом

        Scanner scan = new Scanner(connection.getInputStream());       // Создаём новый сканер для поиска ссылок
        while (scan.findWithinHorizon(LINK_REGEX, 0) != null)   // Пока сканер может найти новые ссылки
        {
            String newURL = scan.match().group(2);
            if (newURL.startsWith("/"))             // Если новая ссылка это подсайт
                newURL = pair.getURL() + newURL;        // То конкатинируем ее c родительской url
            else if (!newURL.startsWith("http"))    // Если новая ссылка это сайт с протоколом https
                continue;                               // все ниже не выполняется

            URLDepthPair newLink = new URLDepthPair(newURL, pair.getDepth() + 1);   // Создаём новую пару: ссылка + (глубина + 1)
            sites.add(newLink);    // Добавляем пару в список НЕпосещённых сайтов
        }
    }
    // Регулярное выражение для ссылок
    public static Pattern LINK_REGEX = Pattern.compile(
            "<a\\s+(?:[^>]*?\\s+)?href=([\"'])(.*?)\\1");

    // Метод для Ползания
    public void run() throws IOException
    {
        // Пока в списке непосещённых сайтов что-нибудь есть
        while (sites.size() > 0)
            process(sites.pop());

        // Вывод всех посещённых сайтов
        for (URLDepthPair site: visitedSites)
            System.out.println(site);
    }

    // Программа должна принимать в командной строке два параметра:
    // 1) Строку, которая представляет собой URL-адрес, с которого можно начать просмотр страницы.
    // 2) Положительное целое число, которое является максимальной глубиной поиска

    public static void main(String[] args) throws IOException {
        // Если введено меньше или больше двух аргументов
        if (args.length != 2) {
            System.out.println("usage: java Crawler <URL><depth>");
            return;
        }

        // 0 аргумент - URL; 1 - глубина поиска
        String url = args[0];
        int depth = Integer.parseInt(args[1]);

        // Сканирование
        Crawler crawler = new Crawler(url, depth);
        crawler.run();
    }
}
