package id.jualanonline;

import android.os.AsyncTask;
import android.os.Environment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class DownloadFile extends AsyncTask<String, Void, String> {
    String path;
    public DownloadFile(String path){
        this.path = path;
    }
    @Override
    protected String doInBackground(String... strings) {
        String folder = path;
        try {
            File dir = new File(folder);

            if (dir.mkdirs()){
                System.out.println("berhasil di buat > "+dir.getName());
            }

            System.out.println("execute "+dir.canExecute());
            System.out.println("read "+dir.canRead());
            System.out.println("write "+dir.canWrite());

            dir.setWritable(true);
            FileOutputStream out = new FileOutputStream(folder+"/test.json");
            HttpHandler http = new HttpHandler();
            String output = http.makeString(strings[0]);
            byte[] text = output.getBytes(StandardCharsets.UTF_8);
            out.write(text);
            out.close();
            System.out.println("berhasil di simpan");
        }catch (FileNotFoundException e){
            System.out.println("FileNotFound > "+e);
        } catch (IOException e) {
            System.out.println("terjadi kesalahan saat menyimpan file.");
            e.printStackTrace();
        }
        return null;
    }
}
