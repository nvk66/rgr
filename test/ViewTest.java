import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ViewTest {

    @Test
    void getAllClientHistory() {
        Assertions.assertEquals("[{\"carNumber\":\"123\",\"lastName\":\"123\",\"carColor\":\"123\",\"startLocation\":" +
                        "\"Orlovskogo 5\",\"price\":\"524\",\"name\":\"123\",\"endLocation\":\"Zukova 107\",\"carModel\":\"123\"}," +
                        "{\"carNumber\":\"123\",\"lastName\":\"123\",\"carColor\":\"123\",\"startLocation\":\"Orlovskogo 5\",\"price\":" +
                        "\"476\",\"name\":\"123\",\"endLocation\":\"Megapolis\",\"carModel\":\"123\"}]",
                View.makeResponse("{\"name\":\"Alexey\",\"method\":\"getAllClientHistory\"}"));
    }

    @Test
    void registerClient() {
        Assertions.assertEquals("{\"method\":\"registerClient\",\"status\":\"ok\"}",
                View.makeResponse("{\"name\":\"123\",\"lastName\":\"123\"," +
                "\"number\":\"123\",\"method\":\"registerClient\"}"));
    }

    @Test
    void registerDriver() {
        Assertions.assertEquals("{\"method\":\"registerDriver\",\"status\":\"ok\"}",
                View.makeResponse("{\"name\":\"123\",\"lastName\":\"123\",\"carNumber\":\"123\"," +
                "\"carColor\":\"123\",\"carModel\":\"123\",\"method\":\"registerDriver\"}"));
    }

    @Test
    void addOrder() {
        Assertions.assertEquals("{\"method\":\"addOrder\",\"status\":\"ok\"}",
                View.makeResponse("{\"clientName\":\"421\",\"method\":\"addOrder\",\"startLocation\":\"42\",\"endLocation\":\"42\"}"));
    }
}