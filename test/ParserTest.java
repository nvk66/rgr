import org.codehaus.jettison.json.JSONException;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    @org.junit.jupiter.api.Test
    void makeJson() {
        HashMap<String,String> str = new HashMap<>();
        str.put("method","ok");
        try {
            System.out.println(Parser.makeJson(str));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}