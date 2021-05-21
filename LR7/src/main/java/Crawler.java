import java.io.*;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Crawler
{
    // Список посещенных сайтов
    private static LinkedList<URLDepthPair> visitedSites = new LinkedList<>();
    // Списко необработанных сайтов
    private static LinkedList<URLDepthPair> poolSites = new LinkedList<>();
    // Глубина, по умолчанию 0
    private final int maxDepth;

    final Pattern URLpattern = Pattern.compile("<a href=\"(.*?)\"");

    // Программа должна принимать в командной строке два параметра:
    // 1) Строку, которая представляет собой URL-адрес, с которого можно начать просмотр страницы.
    // 2) Положительное целое число, которое является максимальной глубиной поиска

    public static void main(String[] args) throws IOException
    {
        Crawler parser = new Crawler(args[0], Integer.parseInt(args[1]));
        parser.run();
    }

    // Конструктор класса
    public Crawler(String url, int depth) {
        this.maxDepth = depth;
        poolSites.add(new URLDepthPair(url, 0));
    }

    public void run() throws IOException {
        while (!poolSites.isEmpty()) {
            parseLink(poolSites.pop());
        }

        for (URLDepthPair pair : visitedSites)
            System.out.println(pair.toString());

    }

    public void parseLink(URLDepthPair site) throws IOException
    {
        visitedSites.add(site);

        if (site.getDepth() >= maxDepth)
            return;

        URL connection = new URL(site.getURL());
        URLConnection yc = connection.openConnection();

        BufferedReader br = new BufferedReader(new InputStreamReader(yc.getInputStream()));

        while (true) {
            String line = br.readLine();
            if (line == null)
                break;

            Matcher m = URLpattern.matcher(line);
            while (m.find()) {
                String url = m.group(1);

                if (url.startsWith("/"))
                    url = site.getURL() + url;
                else if (!url.startsWith("http"))
                    continue;

                if (!poolSites.contains(site))
                    poolSites.add(new URLDepthPair(url, site.getDepth() + 1));
            }
        }
    }
}
