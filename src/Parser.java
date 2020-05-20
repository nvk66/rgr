import java.util.HashMap;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class Parser {

    public static HashMap<String,String> parse(String json){
        HashMap<String,String> response = new HashMap<>();
        try {
            JSONObject jsonObject = new JSONObject(json);
            String method = jsonObject.getString("method");
            switch (method){

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return response;
    }

    public static String makeJson(HashMap<String,String> map){
        JSONObject jsonObject = new JSONObject(map);
        return jsonObject.toString();
    }




}
