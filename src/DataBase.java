import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class DataBase {

    private static Statement statement;
    private static Boolean status = false;

    private static Statement statement() {
            String connectionString = "jdbc:mysql://127.0.0.1:3306/taxi?&useUnicode=true&serverTimezone=UTC&useSSL=false";

            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            try {
                statement = DriverManager.getConnection(connectionString, "root", "root").createStatement();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        return statement;
    }


    public static HashMap<String,String> registerDriver(HashMap<String,String> m){
    HashMap<String,String> response = new HashMap<>();
        try {
            //@TODO
            statement().execute("INSERT INTO drivers (idDriver,name,lastName,carModel,carNumber,carColor)"+
                    " VALUES ("+inDrivers()+",'"+m.get("name")+"','"+m.get("lastName")+"','"+m.get("carModel")+"')," +
                    "'"+m.get("carNumber")+"','"+m.get("carColor")+"')");
            response.put("status","ok");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return response;
    }

    public static HashMap<String,String> registerClient(HashMap<String,String> m){
        HashMap<String,String> response = new HashMap<>();
        try {
            statement().execute("INSERT INTO clients (idClient,name,lastName,number)"+
                    " VALUES ("+inClients()+",'"+m.get("name")+"','"+m.get("lastName")+"','"+m.get("number")+"')");
            response.put("status","ok");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return response;
    }

    public static HashMap<String,String> addOrder(HashMap<String,String> m){
        HashMap<String,String> response = new HashMap<>();
        try {
            statement().execute("INSERT INTO drivers (idOrders,idClient,idDriver,price,startLocation,endLocation)"+
                    " VALUES ("+inOrders()+",'"+findByName(m.get("clientName"))+"','"+findDriver()+
                    "','"+ m.get("price")+ "','"+m.get("startLocation")+"','"+m.get("endLocation")+"')");
            response.put("status","ok");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return response;
    }

    public static ArrayList<HashMap<String,String>> getOrders(String name){
        ArrayList<HashMap<String,String>> response = new ArrayList<HashMap<String,String>>();
        try {
            ResultSet orderSet = statement().executeQuery("SELECT * FROM orders INNER JOIN drivers on" +
                    " orders.idDriver = drivers.idDriver WHERE idClient ="+findByName(name));
            while(orderSet.next()){
                HashMap<String,String> temp = new HashMap<>();
                temp.put("price",orderSet.getNString("price"));
                temp.put("startLocation",orderSet.getNString("startLocation"));
                temp.put("endLocation",orderSet.getNString("endLocation"));
                temp.put("name",orderSet.getNString("name"));
                temp.put("lastName",orderSet.getNString("lastName"));
                temp.put("carModel",orderSet.getNString("carModel"));
                temp.put("carNumber",orderSet.getNString("carNumber"));
                temp.put("carColor",orderSet.getNString("carColor"));
                response.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return response;
    }





    private static int inClients() throws SQLException {
        int count =0;
        ResultSet set = statement().executeQuery("SELECT * FROM clients");
        while(set.next()) count++;
        return count;
    }

    private static int inDrivers() throws SQLException {
        int count =0;
        ResultSet set = statement().executeQuery("SELECT * FROM drivers");
        while(set.next()) count++;
        return count;
    }

    private static int inOrders() throws SQLException {
        int count =0;
        ResultSet set = statement().executeQuery("SELECT * FROM orders");
        while(set.next()) count++;
        return count;
    }

    private static int findByName(String name) throws SQLException {
        int id =0;
        ResultSet set = statement().executeQuery("SELECT * FROM clients");
        while(set.next()){
            if(set.getString("name").equals(name)){
                id = set.getInt("clientId");
            }
        }
        return id;
    }

    private static int findDriver() throws SQLException {
        int id = (int) (1+ Math.round((Math.random()*100)%inDrivers()));
        return id;
    }





}
