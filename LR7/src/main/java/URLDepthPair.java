public class URLDepthPair
{
    // Программа должна хранить URL-адрес в виде строки вместе с его глубиной
    private String url;
    private int depth;

    // Конструктор
    public URLDepthPair(String url_, int depth_) {
        url = url_;
        depth = depth_;
    }

    public String getURL() {
        return url;
    }

    public int getDepth() {
        return depth;
    }


    public String toString() {
        return "URL: " + '"' + url + '"' +  "; depth: " + depth + ';';
    }
}
