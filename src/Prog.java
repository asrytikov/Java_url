import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.*;

public class Prog {

    public static void main(String[] args) {
       ExecutorService executor = Executors.newCachedThreadPool();
        WildData wildData = new WildData();
        for (int i = 0; i < 8; i++) {
            Wild wild = new Wild(wildData);
           // wild.start();
            //executor.schedule(wild, 10, TimeUnit.SECONDS);
            executor.execute(wild);
        }
        executor.shutdown();
        }
    }
