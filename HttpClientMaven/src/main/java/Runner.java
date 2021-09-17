import json.JsonParser;
import models.post.Post;
import models.user.Address;
import models.user.Company;
import models.user.Geo;
import models.user.User;
import server.Request;
import java.io.FileReader;
import java.net.URISyntaxException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class Runner {
    public static void main(String[] args) {
        Properties properties = new Properties();
        FileReader reader = null;
        try {
            reader = new FileReader("src/main/java/info/info.properies");
            properties.load(reader);
            Request request = new Request(properties.getProperty("users"));
            String str = new User(
                    11,
                    "Clementina DuBuque",
                    "Moriah.Stanton",
                    "Rey.Padberg@karina.biz",
                    new Address(
                            "Kattie Turnpike",
                            "Sute 198",
                            "Lebsackbury",
                            "31428-2261",
                            new Geo(
                                    -38.2386,
                                    57.2232)),
                    "024-648-3804",
                    "ambrose.net",
                    new Company(
                            "Hoeger LLC",
                            "Centralized empowering task-force",
                            "target end-to-end models")).getJSONString();
            System.out.println("get " + request.get());
            System.out.println("post " + request.post(str));
            Request request2 = new Request(properties.getProperty("putORdeleteUsers"));
            System.out.println("put " + request2.put(str));
            System.out.println("delete " + request2.delete());
            System.out.println("\n\n\n******************************\n\n");
            for(User x : (List<User>)new JsonParser().parseArr(request.get(), User.class)) {
                System.out.println(x.toString());
                System.out.println("#################");
            }

            Request request3 = new Request(properties.getProperty("posts"));
            for(Post x : (List<Post>)new JsonParser().parseArr(request3.get(), Post.class)) {
                System.out.println(x.toString());
                System.out.println("$$$$$$$$$$$$$$$$$$$$$");
            }
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
