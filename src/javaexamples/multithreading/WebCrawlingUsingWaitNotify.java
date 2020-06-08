package javaexamples.multithreading;

import java.io.*;
import java.net.*;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Author: nitinkumar
 * Created Date: 03/06/20
 * Info: Demo of how web Crawler works. It has two work: Downloading and indexing. Web Link is shared b/w Downloading and indexing. synchronization is done on webLink object.
 *       Program also shows wait() and notifyAll()
 **/

public class WebCrawlingUsingWaitNotify {
    private Deque<WebLink> queue = new ArrayDeque<>();

    private static class WebLink {
        private long id;
        private String title;
        private String url;
        private String host;

        private String htmlPage;

        public WebLink(long id, String title, String url, String host) {
            this.id = id;
            this.title = title;
            this.url = url;
            this.host = host;
        }

        public String getHtmlPage() {
            return htmlPage;
        }

        public void setHtmlPage(String htmlPage) {
            this.htmlPage = htmlPage;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }
    }

    public class Downloader implements Runnable {
        private WebLink weblink;

        public Downloader(WebLink weblink) {
            this.weblink = weblink;
        }

        @Override
        public void run() {
            //System.out.println(Thread.currentThread().getName() + " started **");
            String htmlPage = null;
            synchronized (weblink) {
                try {
                    htmlPage = HttpConnect.download(weblink.getUrl());
                    weblink.setHtmlPage(htmlPage);
                    System.out.println(Thread.currentThread().getName() + " Downloaded .." + weblink.getUrl() + " length of file is " + htmlPage.length());
                    // System.out.println("*** "+htmlPage);
                    weblink.notifyAll(); //Called notify on weblink as synchronized on notify object
                    System.out.println(Thread.currentThread().getName() + " Notified waiting threads ");
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
                weblink.setHtmlPage(htmlPage);
            }
        }
    }

    public class Indexer implements Runnable {
        private WebLink weblink;

        public Indexer(WebLink weblink) {
            this.weblink = weblink;
        }

        @Override
        public void run() {
            //System.out.println(Thread.currentThread().getName() + " started **");
            String htmlPg = weblink.getHtmlPage();
            synchronized (weblink) {
                while (htmlPg == null) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " Will wait for " + weblink.getUrl());
                        weblink.wait();//brings the thread to WAITING state . Present in Object class.
                        System.out.println(Thread.currentThread().getName() + " Notified to continue....");
                        htmlPg = weblink.getHtmlPage(); //fetch the page once waiting is over.
                        // System.out.print(". htmlPg length is " + htmlPg.length());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                doIndexingOperation(htmlPg);
            }
        }

        public void doIndexingOperation(String htmlPage) {
            System.out.println(Thread.currentThread().getName() + " Indexing operation .. **** \n");
        }
    }

    public void addwebLink(WebLink w) {
        queue.add(w);
    }


    public static void main(String[] args) {
        WebCrawlingUsingWaitNotify example_webCrawling = new WebCrawlingUsingWaitNotify();
        example_webCrawling.addwebLink(new WebLink(2000, "Taming Tiger, Part 2", "https://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html", "http://www.javaworld.com"));
        example_webCrawling.addwebLink(new WebLink(2001, "How do I import a pre-existing Java project into Eclipse and get up and running?", "https://stackoverflow.com/questions/142863/how-do-i-import-a-pre-existing-java-project-into-eclipse-and-get-up-and-running", "http://www.stackoverflow.com"));
        example_webCrawling.addwebLink(new WebLink(2004, "Virtual Hosting and Tomcat", "http://tomcat.apache.org/tomcat-6.0-doc/virtual-hosting-howto.html", "http://tomcat.apache.org"));
        example_webCrawling.startWebCrawling();
        //System.out.println("Total threads : "+Thread.activeCount());
    }

    private void startWebCrawling() {
        while (!queue.isEmpty()) {
            WebLink webLink = queue.remove();
            Thread downloaderThread = new Thread(new Downloader(webLink), "downloaderThread" + webLink.getId());
            Thread indexerThread = new Thread(new Indexer(webLink), "indexerThread" + webLink.getId());

            indexerThread.start();
            downloaderThread.start();

        }
    }

}

class HttpConnect {

    public static String download(String sourceUrl) throws MalformedURLException, URISyntaxException {
        System.out.println("Downloading: " + sourceUrl);
        URL url = new URI(sourceUrl).toURL();

        try {
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            int responseCode = con.getResponseCode();

            if (responseCode >= 200 && responseCode < 300) { // ok
                return read(con.getInputStream());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String read(InputStream in) {
        StringBuilder text = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(in, "UTF-8"))) {
            String line;
            while ((line = br.readLine()) != null) {
                text.append(line).append("\n");
            }
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return text.toString();
    }
}

/*
O/P

indexerThread2000 Will wait for https://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html
indexerThread2001 Will wait for https://stackoverflow.com/questions/142863/how-do-i-import-a-pre-existing-java-project-into-eclipse-and-get-up-and-running
indexerThread2004 Will wait for http://tomcat.apache.org/tomcat-6.0-doc/virtual-hosting-howto.html
Downloading: https://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html
Downloading: http://tomcat.apache.org/tomcat-6.0-doc/virtual-hosting-howto.html
Downloading: https://stackoverflow.com/questions/142863/how-do-i-import-a-pre-existing-java-project-into-eclipse-and-get-up-and-running
downloaderThread2000 Downloaded ..https://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html length of file is 139748
downloaderThread2000 Notified waiting threads
indexerThread2000 Notified to continue....
indexerThread2000 Indexing operation .. ****

downloaderThread2004 Downloaded ..http://tomcat.apache.org/tomcat-6.0-doc/virtual-hosting-howto.html length of file is 16569
downloaderThread2004 Notified waiting threads
indexerThread2004 Notified to continue....
indexerThread2004 Indexing operation .. ****

downloaderThread2001 Downloaded ..https://stackoverflow.com/questions/142863/how-do-i-import-a-pre-existing-java-project-into-eclipse-and-get-up-and-running length of file is 154874
downloaderThread2001 Notified waiting threads
indexerThread2001 Notified to continue....
indexerThread2001 Indexing operation .. ****
 */