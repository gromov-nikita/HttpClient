package json;

import models.user.Address;
import models.user.Company;
import models.user.Geo;
import models.user.User;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonParser {
    public List<User> parseArrUsers(String jsonSTR) {
        JSONArray arr = new JSONArray(jsonSTR);
        JSONObject obj;
        List<User> list = new ArrayList<>(arr.length());
        for(int i = 0; i  < arr.length(); i++) {
            obj = arr.getJSONObject(i);
            list.add(new User(obj.getInt("id"), obj.getString("name"), obj.getString("username"),
                    obj.getString("email"), parseAddress(obj.getJSONObject("address")),
                    obj.getString("phone"), obj.getString("website"),
                    parseCompany(obj.getJSONObject("company"))));
        }
        return list;
    }
    public Address parseAddress(JSONObject obj) {
        return new Address(obj.getString("street"), obj.getString("suite"), obj.getString("city"),
                obj.getString("zipcode"), parseGeo(obj.getJSONObject("geo")));
    }
    public Geo parseGeo(JSONObject obj) {
        return new Geo(obj.getDouble("lat"), obj.getDouble("lng"));
    }
    public Company parseCompany(JSONObject obj) {
        return new Company(obj.getString("name"), obj.getString("catchPhrase"), obj.getString("bs"));
    }
}
