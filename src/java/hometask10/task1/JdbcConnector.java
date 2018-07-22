package hometask10.task1;
/*
Работа с БД с помощью JDBC

Создайте таблицу в БД и с помощью JDBC выполните следующие действия
	извлеките информацию из таблицы с помощью подготовленного запроса;
	обновите несколько записей в таблице;   +
	выберите конкретную запись в таблице; +
	вставьте новую запись в таблицу;  +
	удалите таблицу.

МОЙ КОММЕНТАРИЙ: МОНСТРУОЗНО, СДЕЛАНО НА ВРЕМЯ

 */

import java.sql.*;

public class JdbcConnector {
    private String DB_URL = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
    private static String CREATE_TABLE_SQL = "create table students (id identity, name varchar not null, group_id int)";
    private static String INSERT_STUDENT_SQL = "insert into students (name, group_id) values ('Вася Пупкин', 1001)";
    private static String INSERT_STUDENT_SQL2 = "insert into students (name, group_id) values ('Мария Спелых', 1002)";
    private static String INSERT_STUDENT_SQL3 = "insert into students (name, group_id) values ('Виктор Быстрый', 1003)";
    private static String INSERT_STUDENT_SQL4 = "insert into students (name, group_id) values ('Рома Вчерашний', 1004)";
    private static String GET_STUDENTS_SQL = "select id, name, group_id from students";
    private static String UPDATE_STUDENTS = "update students set group_id='2001' where name='Вася Пупкин'";
    private static String UPDATE_STUDENTS2 = "update students set group_id='2001' where name='Мария Спелых'";
    private static String GET_CURRENT_STUDENT = "select id, name, group_id from students where name='Виктор Быстрый'";
    private static String DROP_TABLE = "drop table students";
    private String ID_FIELD = "id";
    private String NAME_FIELD = "name";
    private String GROUP_ID_FIELD = "group_id";
    private Statement statement = null;
    private Connection connection = null;
    ResultSet resultSet = null;

    private void createDataBase(String request) {
        try {
            connection = DriverManager.getConnection(DB_URL);
            statement = connection.createStatement();
            statement.executeUpdate(request);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void fillDataBase(String... requests) {
        for (String request : requests) {
            try {
                statement.executeUpdate(request);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void showDataBase(String request) {
        System.out.println();
        try {
            resultSet = statement.executeQuery(request);
            if (resultSet.next() == false) {
                System.out.println("Table deleted.");
            } else {
                System.out.printf("%d %s %d%n",
                        resultSet.getInt(ID_FIELD),
                        resultSet.getString(NAME_FIELD),
                        resultSet.getInt(GROUP_ID_FIELD));
                while (resultSet.next()) {
                    System.out.printf("%d %s %d%n",
                            resultSet.getInt(ID_FIELD),
                            resultSet.getString(NAME_FIELD),
                            resultSet.getInt(GROUP_ID_FIELD));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateDataBase(String... requests) {
        for (String request : requests) {
            try {
                statement.executeUpdate(request);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void selectRow(String request) {
        try {
            resultSet = statement.executeQuery(request);
            while (resultSet.next()) {
                System.out.printf("%d %s %d%n",
                        resultSet.getInt(ID_FIELD),
                        resultSet.getString(NAME_FIELD),
                        resultSet.getInt(GROUP_ID_FIELD));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void dropTable(String request) {
        System.out.println();
        try {
            statement.executeUpdate(request);
            resultSet = statement.executeQuery("SHOW TABLES");
            if (resultSet.next() == false) {
                System.out.println("Table deleted.");
            } else {
                while (resultSet.next()) {
                    System.out.printf("%d %s %d%n",
                            resultSet.getInt(ID_FIELD),
                            resultSet.getString(NAME_FIELD),
                            resultSet.getInt(GROUP_ID_FIELD));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void closeResourse() {
        try {

        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        JdbcConnector db = new JdbcConnector();
        db.createDataBase(CREATE_TABLE_SQL);
       // db.showDataBase(GET_STUDENTS_SQL);
        db.fillDataBase(INSERT_STUDENT_SQL, INSERT_STUDENT_SQL2, INSERT_STUDENT_SQL3, INSERT_STUDENT_SQL4);
        db.showDataBase(GET_STUDENTS_SQL);
        db.updateDataBase(UPDATE_STUDENTS, UPDATE_STUDENTS2);
        db.showDataBase(GET_STUDENTS_SQL);
        db.showDataBase(GET_CURRENT_STUDENT);
        db.dropTable(DROP_TABLE);
        db.closeResourse();
    }
}
