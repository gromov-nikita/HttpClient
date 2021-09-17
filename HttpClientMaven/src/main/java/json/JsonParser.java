package json;

import models.user.Address;
import models.user.Company;
import models.user.Geo;
import models.user.User;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONString;
import org.w3c.dom.ls.LSOutput;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class JsonParser {
    public List parseArr(String jsonStr, Class myClass)  throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException,
            InstantiationException, NoSuchFieldException {
        List list = new LinkedList();
        Constructor constructor = myClass.getDeclaredConstructors()[0];
        Field[] fields = myClass.getDeclaredFields();
        Object[] objects = new Object[fields.length];
        JSONArray array = new JSONArray(jsonStr);
        JSONObject obj;
        for(int i = 0; i < array.length(); i++) {
            obj = array.getJSONObject(i);
            for (int j = 0; j < fields.length; j++) {
                if(fields[j].getType().isPrimitive() || fields[j].getType().equals(String.class)) {
                    objects[j] = obj.get(fields[j].getName());
                }
                else {
                    objects[j] = parseObj(obj.getJSONObject(fields[j].getName()).toString(),
                            fields[j].getType());
                }
            }
            list.add(constructor.newInstance(objects));
        }
        return list;
}
    public Object parseObj(String jsonStr, Class myClass) throws IllegalAccessException,
            InvocationTargetException, InstantiationException {
        JSONObject obj = new JSONObject(jsonStr);
        Constructor constructor = myClass.getDeclaredConstructors()[0];
        Field[] fields = myClass.getDeclaredFields();
        Object[] objects = new Object[fields.length];
        for(int i = 0; i < fields.length; i++) {
            if((fields[i].getType().isPrimitive() || fields[i].getType().equals(String.class))
                    && !fields[i].getType().equals(double.class)) {
                objects[i] = obj.get(fields[i].getName());
            }
            else {
                if(fields[i].getType().equals(double.class)) {
                    objects[i] = obj.getDouble(fields[i].getName());
                }
                else {
                    objects[i] = parseObj(obj.getJSONObject(fields[i].getName()).toString(),
                            fields[i].getType());
                }
            }
        }
        return constructor.newInstance(objects);
    }
}