import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Crawler
{
    // Список посещенных сайтов
    private static LinkedList<URLDepthPair> sites = new LinkedList<>();
    // Списко необработанных сайтов
    private static LinkedList<URLDepthPair> pool = new LinkedList<>();
    // Глубина, по умолчанию 0
    private int depth = 0;
    Pattern URLpattern = Pattern.compile("(href=\"http|href=\\\"https)://([\\w_-]+(?:(?:\\.[\\w_-]+)+))([\\w.,@?^=%&:/~+#-]*[\\w@?^=%&/~+#-])?"
    );

    // Конструктор класса
    public Crawler(String url, int depth_) {
        depth = depth_;
        pool.add(new URLDepthPair(url, 0));
    }

    public void run() throws IOException {
        while (pool.size() > 0)
            parseLink(pool.pop());

        for (URLDepthPair pair : sites)
            System.out.println(pair.toString());

    }

    public void parseLink(URLDepthPair site) throws IOException {
        if (site.getDepth() > depth)
            return;

        sites.add(site);
        System.out.println(sites);
        URL url = new URL(site.getURL());
        Socket socket = new Socket(url.getHost(), 80);
        socket.setSoTimeout(10);

        InputStream input = socket.getInputStream();

        BufferedReader reader = new BufferedReader(new InputStreamReader(input));

        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
            Matcher matcher = URLpattern.matcher(line);
            while (matcher.find()) {
                String link = line.substring(matcher.start() + 6, matcher.end());

                pool.add(new URLDepthPair(link, depth));
            }
        }
        socket.close();
    }


    // Программа должна принимать в командной строке два параметра:
    // 1) Строку, которая представляет собой URL-адрес, с которого можно начать просмотр страницы.
    // 2) Положительное целое число, которое является максимальной глубиной поиска

    public static void main(String[] args) throws IOException {

        Crawler parser = new Crawler(args[0], Integer.parseInt(args[1]));
        parser.run();
    }
}
