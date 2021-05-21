import java.net.URL;
import java.util.LinkedList;
import java.util.Set;

public class URLPool {
    private LinkedList<URLDepthPair> inProcess = new LinkedList<>();
    private LinkedList<URLDepthPair> seen = new LinkedList<>();
    private int maxDepth;
    private int waiting = 0;

    public URLPool(int maxDepth) {
        this.maxDepth = maxDepth;
    }

    public synchronized void put(URLDepthPair pair) {
            if (pair.getDepth() < maxDepth)
                inProcess.add(pair);
            seen.add(pair);
            notify();
    }

    public synchronized URLDepthPair get() throws InterruptedException {
        while (inProcess.size() == 0) {
            waiting++;
            wait();
            waiting--;
        }
        return inProcess.removeFirst();
    }

    public synchronized boolean seen(URLDepthPair url) {
        return seen.contains(url);
    }

    public synchronized LinkedList<URLDepthPair> seen() {
        return seen;
    }

    public synchronized int getMaxDepth() {
        return maxDepth;
    }

    public synchronized int getWaitingThreads() {
        return waiting;
    }
}
