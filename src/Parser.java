import java.util.ArrayList;
import java.util.HashMap;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class Parser {

    public static HashMap<String,String> parse(String json){
        HashMap<String,String> response = new HashMap<>();
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray keys = jsonObject.names();
            for(int i=0;i<keys.length();i++){
                response.put(keys.getString(i),jsonObject.getString(keys.getString(i)));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return response;
    }

    public static String makeJson(HashMap<String,String> map) throws JSONException {
        JSONObject jsonObject = new JSONObject(map);
        return jsonObject.toString();
    }

    public static String makeJson(ArrayList<HashMap<String,String>> map) throws JSONException {
        HashMap<String,ArrayList<HashMap<String,String>>> hashMap= new HashMap<>();
        hashMap.put("orders",map);
        JSONObject jsonObject = new JSONObject(hashMap);
        jsonObject.put("method","get_orders");
        jsonObject.put("status","ok");
        jsonObject.put("orders",map);
        return jsonObject.toString();
    }




}
