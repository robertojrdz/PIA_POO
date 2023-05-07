import java.sql.*;

public class DataBase {
    private static DataBase instance = null;
    private static Connection connection = null;

    private DataBase() {
        try {
            String url = "jdbc:postgresql://localhost:5432/Formula1";
            String user = "postgres";
            String password = "pass";
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
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(query);
            statement.execute();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }

    public boolean findOne(String table, String numEmpleado) throws ErrorOperation {
        String query = "SELECT * FROM " + table + " WHERE numempleado = " + numEmpleado;
        PreparedStatement statement = null;
        boolean isFound = false;
        try {
            statement = connection.prepareStatement(query);
            ResultSet data = statement.executeQuery();
            if (data.next())
                isFound = true;
            data.close();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return isFound;
    }

    public void delete(String table, String numEmpleado) throws ErrorOperation {
        String query = "DELETE FROM " + table + " WHERE numempleado = " + numEmpleado;
        PreparedStatement statement = null;

        try {
            if (!findOne(table, numEmpleado)) {
                throw new ErrorOperation("Usuario " + numEmpleado + " no existe!");
            }

            statement = connection.prepareStatement(query);
            statement.execute();

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }

    public void update(String table, String numEmpleado, String values) throws ErrorOperation {
        String query = "UPDATE " + table + " SET " + values + " WHERE numempleado = " + numEmpleado;
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(query);
            System.out.println(statement);
            statement.execute();
        } catch (SQLException e) {
            throw new ErrorOperation("Error al actualizar el registro con pk: " + numEmpleado);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }

    public void displayTable(String table) {
        DBTablePrinter.printTable(connection, table);
    }
}

class ErrorOperation extends Exception {
    public ErrorOperation(String msg) {
        super(msg);
    }
}
