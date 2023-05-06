import java.sql.*;

public class DataBase {
    private static DataBase instance = null;
    private static Connection connection = null;

    private DataBase() {
        try {
            String url = "jdbc:postgresql://localhost:5432/PIA";
            String user = "postgres";
            String password = "QZPMwxon";
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static DataBase getConnection() {
        if (instance == null) {
            instance = new DataBase();
        }
        return instance;
    }

    public void insert(String table, String values) throws ErrorOperation {
        String query = "INSERT INTO " + table + values;
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.execute();
        } catch (Exception e) {
            System.out.println(e);
            throw new ErrorOperation("Error al crear el registro");
        }
    }

    public ResultSet findOne(String dbName, String numEmpleado) throws ErrorOperation {
        String query = "select * from " + dbName + " where numEmpleado = " + numEmpleado;
        ResultSet data = null;
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            data = statement.executeQuery();
        } catch (Exception e) {
            throw new ErrorOperation("Error al buscar el registro con el pk " + numEmpleado);
        }
        return data;
    }
    public void showDataBase(String dbName){
        DBTablePrinter.printTable(connection, dbName);
    }
}

class ErrorOperation extends Exception {
    public ErrorOperation(String msg) {
        super(msg);
    }
}
