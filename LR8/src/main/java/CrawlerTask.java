import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrawlerTask implements Runnable{

    private static URLPool pool;
    private static final int WEBPORT = 80;
    final Pattern URLpattern = Pattern.compile("<a href=\"(.*?)\"");
    private volatile boolean running = true;
    private int maxPatience;

    public CrawlerTask(URLPool pool, int maxPatience) {
        this.maxPatience = maxPatience;
        this.pool = pool;
    }

    public boolean isValid(String url) {
        return url.startsWith(URLDepthPair.URL_PREFIX);
    }

    @Override
    public void run() {
        while (running) {
            try {
                URLDepthPair currentPair = pool.get();
                parseLink(currentPair);
            }
            catch (IOException e) {
                System.out.println(e);
            }
            catch (InterruptedException ie) {
                running = false;
            }
        }
    }


    private void parseLink(URLDepthPair site) throws IOException
    {

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

                if (isValid(url)) {
                    URLDepthPair n = new URLDepthPair(url, site.getDepth() + 1);

                    if (!pool.seen(n)) {
                        if (site.getDepth() < pool.getMaxDepth()) {
                            pool.put(n);
                        }
                    }
                }



                if (!pool.seen(site))
                    if (site.getDepth() < pool.getMaxDepth())
                        pool.put(new URLDepthPair(url, site.getDepth() + 1));
            }
        }
    }

    private static List<Thread> threads = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        int maxDepth = Integer.parseInt(args[1]);
        int threadsNum = Integer.parseInt(args[2]);
        int maxPatience = Integer.parseInt(args[3]);

        URLPool urlPool = new URLPool(maxDepth);

        urlPool.put(new URLDepthPair(args[0], 0));

        for (int i = 0; i < threadsNum; i++) {
            CrawlerTask crawlerTask = new CrawlerTask(urlPool, maxPatience);
            Thread thread = new Thread(crawlerTask);
            thread.start();
            threads.add(thread);
        }

        while (pool.getWaitingThreads() != threadsNum) {
            Thread.sleep(1000);
        }

        urlPool.seen().stream().forEach(System.out::println);
        threads.stream().forEach(Thread::interrupt);
    }
}
