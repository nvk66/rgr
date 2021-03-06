// This is an independent project of an individual developer. Dear PVS-Studio, please check it.

// PVS-Studio Static Code Analyzer for C, C++ and C#: http://www.viva64.com
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
        StringBuilder str = new StringBuilder();
        str.append("[");
        for(int i=0;i<map.size();i++){
            str.append(new JSONObject(map.get(i)).toString()+((i+1 != map.size())? ",":""));
        }
        str.append("]");
        System.out.println(str);
        return str.toString();
    }




}
