import org.codehaus.jettison.json.JSONException;

import java.util.HashMap;

public class View {

    public static String makeResponse(String msg) {
        try {
            HashMap<String, String> response = new HashMap<>();
            HashMap<String, String> request = Parser.parse(msg);
            String method = request.get("method");
            switch (method) {
                case "getAllClientHistory":
                    return Parser.makeJson(DataBase.getOrders(request.get("name")));
                case "addOrder":
                    response = DataBase.addOrder(request);
                    break;
                case "registerClient":
                    response = DataBase.registerClient(request);
                    break;
                case "registerDriver":
                    response = DataBase.registerDriver(request);
                    break;
            }
            response.put("method", method);
            System.out.println(response);
            return Parser.makeJson(response);
        }catch (JSONException e){
            e.printStackTrace();
            return null;
        }
    }

}
