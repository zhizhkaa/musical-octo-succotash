import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.LinkedList;

public class Crawler
{
    // Список посещенных сайтов
    private static LinkedList<URLDepthPair> sites = new LinkedList<>();
    // Списко необработанных сайтов
    private static LinkedList<URLDepthPair> pool = new LinkedList<>();
    // Глубина, по умолчанию 0
    private int depth = 0;

    // Конструктор класса
    public Crawler(String url, int depth_) {
        depth = depth_;
        sites.add(new URLDepthPair(url, 0));
    }

    public void run() throws IOException {
        while (pool.size() > 0)
            parseLink(pool.pop());

        for (URLDepthPair pair : sites)
            System.out.println(pair.toString());

    }

    public void parseLink(URLDepthPair site) throws IOException {
        sites.add(site);

        Socket socket = new Socket();
        socket.setSoTimeout(1000);

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String line;

        while ((line = in.readLine()) != "")
        {
            System.out.println("line");
            while (line.contains("<a href=" + '"' + "http://")) {
                StringBuilder newURL = new StringBuilder();
                int i = line.indexOf("http://");

                while (line.charAt(i) != '"') {
                    newURL.append(line.charAt(i));
                    i++;
                }

                if (!newURL.toString().isEmpty()) {
                    line = line.substring(i);
                }

                URLDepthPair newPair = new URLDepthPair(newURL.toString(), site.getDepth() + 1);
                if (site.getDepth() > newPair.getDepth())
                    pool.add(newPair);
            }
        }
        socket.close();

    }


    // Программа должна принимать в командной строке два параметра:
    // 1) Строку, которая представляет собой URL-адрес, с которого можно начать просмотр страницы.
    // 2) Положительное целое число, которое является максимальной глубиной поиска

    public static void main(String[] args) throws IOException {
        String url = args[0];
        int depth = 0;

        depth = Integer.parseInt(args[1]);

        Crawler crawler = new Crawler(url, depth);
        crawler.run();
    }
}
