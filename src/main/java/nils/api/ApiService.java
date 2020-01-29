package nils.api;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class ApiService {
   //In this function the application Connects to the Api from Json-Placeholder api and returns its response as a String
   public String get(String path) {

      InputStream is;

      try {
         URL url = new URL(path);
         is = url.openStream();
         BufferedReader rd = new BufferedReader(new InputStreamReader(is));
         StringBuilder response = new StringBuilder();
         String line;
         while ((line = rd.readLine()) != null) {
            response.append(line);
            response.append('\n');
         }
         rd.close();
         return response.toString();
      } catch (Exception e) {
         e.printStackTrace();
         return null;
      }
   }
}
