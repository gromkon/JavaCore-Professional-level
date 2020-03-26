package Lesson2.Homework;

import java.sql.*;

public class DataBase {
    private static Connection conn;
    private static Statement stmt;

    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:mainLesson2.db");
        stmt = conn.createStatement();
    }

    public static void disconnect() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(String tableName, int id) throws SQLException {
        stmt.execute("DELETE FROM " + tableName + " WHERE id = " + id);
    }

    public static void insert(String tableName, int id, String firstName, String secondName) throws SQLException {
        stmt.execute("INSERT INTO " + tableName + " (id, FirstName, SecondName) VALUES (" + id + ", \"" + firstName + "\", \"" + secondName + "\")");
    }

    public static void update(String tableName, int id, String firstName, String secondName) throws SQLException {
        stmt.execute("UPDATE " + tableName + " SET FirstName = \"" + firstName + "\", SecondName = \"" + secondName + "\" WHERE id = " + id);
    }

    public static ResultSet select(String tableName) throws SQLException {
        return stmt.executeQuery("SELECT id, FirstName, SecondName FROM " + tableName);
    }

    //создает таблицу с названием tableName, и столбцами из columns
    //columns - 2-мерный массив, где первый столбец это название столбца, а второй - тип
    public static void create(String tableName, String[][] columns) throws SQLException {
        StringBuilder query = new StringBuilder("CREATE TABLE IF NOT EXISTS " + tableName + " (");
        for (int i = 0; i < columns.length; i++) {
            query.append(columns[i][0]).append(" ").append(columns[i][1]).append(",");
        }
        query.deleteCharAt(query.length() - 1);
        query.append(")");
        stmt.execute(String.valueOf(query));
    }

    public static void main(String[] args) {
        try {
            connect();

            String tableName = "Students";

            String[][] columns = new String[3][2];
            columns[0][0] = "id";
            columns[0][1] = "INTEGER";
            columns[1][0] = "FirstName";
            columns[1][1] = "TEXT";
            columns[2][0] = "SecondName";
            columns[2][1] = "TEXT";

            create(tableName, columns);

            insert(tableName, 1, "Ivan", "Ivanov");
            insert(tableName, 2, "Alex", "Alexandrov");
            insert(tableName, 3, "Greek", "Greekov");

            update(tableName, 2, "Name21", "Name22");

            delete(tableName, 1);

            ResultSet rsSelect = select(tableName);
            while (rsSelect.next()) {
                System.out.println(rsSelect.getInt("id") + " " + rsSelect.getString("FirstName") + " " + rsSelect.getString("SecondName"));
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }



}
