import server.Request;

import java.io.FileReader;
import java.net.URISyntaxException;
import java.io.IOException;
import java.util.Properties;

public class Runner {
    public static void main(String[] args) {
        Properties properties = new Properties();
        FileReader reader = null;
        try {
            reader = new FileReader("src/info/info.properies");
            properties.load(reader);
            Request request = new Request(properties.getProperty("users"));
            String str = "{\n" +
                    "    \"id\": 11,\n" +
                    "    \"name\": \"Clementina DuBuque\",\n" +
                    "    \"username\": \"Moriah.Stanton\",\n" +
                    "    \"email\": \"Rey.Padberg@karina.biz\",\n" +
                    "    \"address\": {\n" +
                    "      \"street\": \"Kattie Turnpike\",\n" +
                    "      \"suite\": \"Sute 198\",\n" +
                    "      \"city\": \"Lebsackbury\",\n" +
                    "      \"zipcode\": \"31428-2261\",\n" +
                    "      \"geo\": {\n" +
                    "        \"lat\": \"-38.2386\",\n" +
                    "        \"lng\": \"57.2232\"\n" +
                    "      }\n" +
                    "    },\n" +
                    "    \"phone\": \"024-648-3804\",\n" +
                    "    \"website\": \"ambrose.net\",\n" +
                    "    \"company\": {\n" +
                    "      \"name\": \"Hoeger LLC\",\n" +
                    "      \"catchPhrase\": \"Centralized empowering task-force\",\n" +
                    "      \"bs\": \"target end-to-end models\"\n" +
                    "    }\n" +
                    "  }";
            System.out.println(request.get());
            System.out.println(request.post(str));
            Request request2 = new Request(properties.getProperty("putORdelete"));
            System.out.println(request2.put(str));
            System.out.println(request2.delete());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        finally {
            if(reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
