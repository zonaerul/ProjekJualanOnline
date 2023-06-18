package id.jualanonline;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpHandler {
    public HttpHandler(){

    }
    public String makeString(String rqurl){
        String respon = null;
        try {
            URL url=new URL(rqurl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            InputStream in = new BufferedInputStream(conn.getInputStream());
            respon = convertStream(in);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return respon;
    }
    private String convertStream(InputStream is){
        BufferedReader read = new BufferedReader(new InputStreamReader(is));
        StringBuilder build = new StringBuilder();
        String line = null;
        try {
            while((line = read.readLine()) != null){
                build.append(line).append("\n");
            }
        }catch (IOException e){
            e.printStackTrace();
        } finally {
            try {
                is.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        return build.toString();
    }
}
