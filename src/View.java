import java.util.HashMap;

public class View {

    public static String makeResponse(String msg){
        HashMap<String,String> response = new HashMap<>();
        HashMap<String,String> request = new HashMap<>();
        String method = request.get("method");


        return Parser.makeJson(response);
    }









}
