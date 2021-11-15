import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Wild implements Runnable{

    private WildData wildData;

    public Wild(WildData wildData){
        this.wildData = wildData;
    }

    @Override
    public void run() {
        wildData.getMultiInfo();
        System.out.println("Thread:" + Thread.currentThread().getName());
}}
