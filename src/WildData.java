import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class WildData {

    public void getMultiInfo(){
        synchronized (this) {
        for (int i = 14508880; i < 14508886; i++) {
            getOneInfo(i);
            double proc = (double) (i-14508706);
            System.out.println("Выполнено: "+ (proc/180)*100 + "%");
        }}
    }

    public void getOneInfo(int i){
        try {
            URL url = new URL("https://www.wildberries.ru/catalog/" + i + "/detail.aspx?targetUrl=XS");
            URLConnection urlConnection = url.openConnection();
            HttpsURLConnection connection = (HttpsURLConnection) urlConnection;

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inf = "";
            String str;
            while ((str = in.readLine()) != null) {
                if (str.indexOf("<meta property=\"og:url\" content=\"/catalog/" + i +"/detail.aspx\">") > 0) {
                    inf += str + "\n";
                }
            }

            int n = inf.indexOf("<title >");
            int e = inf.indexOf("</title>");

            inf = inf.substring(n + 8, e);

            System.out.println(inf);


        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Товар не найден");
        }
    }

}
