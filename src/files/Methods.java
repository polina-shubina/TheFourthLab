package files;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Methods {
    public static String get(String link) throws IOException {
        URL url = new URL(link);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        int responseCode = con.getResponseCode();
        if (responseCode != HttpURLConnection.HTTP_OK) {
            throw new IOException("Возникла ошибка");
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            response.append(line);
        }
        br.close();
        return response.toString();
    }

    public static void print(String response){
        String [] res = response.split(",");
        for (int j = 0; j < res.length; j++) {
            res[j] = res[j].replaceAll("\\[" , "");
            res[j] = res[j].replaceAll("]" , "");
            if (res[j].contains("{") || res[j].contains("}")){
                int ind;
                for (int c = 0; c < res[j].length(); c++){
                    if(res[j].charAt(c) == '{'){
                        ind = c;
                        System.out.println("{");
                        System.out.println(res[j].substring(ind+1));
                        break;
                    }
                    if(res[j].charAt(c) == '}'){
                        ind = c;
                        System.out.println(res[j].substring(0, ind));
                        System.out.println("}");
                        break;
                    }
                }
            }
            else {
                System.out.println(res[j]);
            }
        }
    }
}
