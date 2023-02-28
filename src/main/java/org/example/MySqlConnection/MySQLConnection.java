package org.example.MySqlConnection;

import java.sql.*;

public class MySQLConnection {

    public static Cinema cinema = new Cinema();
    public static String driver = "com.mysql.cj.jdbc.Driver";
    public static String url = "jdbc:mysql://localhost:3306/cinema?&serverTimezone=UTC";
    public static String user = "root";
    public static String password = "adminroot";

    public static void main(String[] args) {
        starter() ;
    }

    private static void starter() {
        int num = cinema.start();

        switch(num){
            case 1:
                pelisEstrenadas();
                break;
            case 2:
                peliculas();
                break;
            case 3:
                insertarPelis();
                break;
        }
    }

    private static void insertarPelis() {
        cinema.insertarPelis();
      
        String query = "INSERT INTO films(Titol, DataEstrena, Pais, idDirector) " +
                "VALUES('" + cinema.getTitol() + "', '" + cinema.getData() + "', '" + cinema.getPais() + "', 1);";

        try {
            Class.forName(driver);
            try(Connection connection = DriverManager.getConnection(url, user, password);
                Statement statement = connection.createStatement()){
                statement.executeUpdate(query);

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void peliculas() {
        String director = cinema.nombreDirector();

        String query =  "select Films.titol, Films.dataEstrena from Films " +
                "join Film_Director ON Films.idFilm = Film_Director.idFilm " +
                "join director ON Film_Director.idDirector = director.idDirector " +
                "where director.nom like '" + director + "';";


        try {
            Class.forName(driver);
            try(Connection connection = DriverManager.getConnection(url, user, password);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query)){
                int intNames = getColumnNames(resultSet);
                while (resultSet.next()){
                    for (int x = 1; x <= intNames;x++){
                        System.out.println(resultSet.getString(x));
                        if(x < intNames){
                            System.out.print(", ");
                        }
                    }
                    System.out.println();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    private static void pelisEstrenadas() {
        String opcion1 = cinema.opcion1();
        String opcion2 = cinema.opcion2();
        String query = "select * from films where DataEstrena between '" + opcion1 + "' and '" + opcion2 + "'";

        try {
            Class.forName(driver);
            try(Connection connection = DriverManager.getConnection(url, user, password);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query)){
                int intNames = getColumnNames(resultSet);
                while (resultSet.next()){
                    for (int x = 1; x <= intNames;x++){
                        System.out.println(resultSet.getString(x));
                        if(x < intNames){
                            System.out.print(", ");
                        }
                    }
                    System.out.println();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }


    public static int getColumnNames(ResultSet rs) throws SQLException {
        int numberOfColumns = 0;
        if (rs != null) {
            //create an object based on the Metadata of the result set
            ResultSetMetaData rsMetaData = rs.getMetaData();
            //Use the getColumn method to get the number of columns returned
            numberOfColumns = rsMetaData.getColumnCount();
            //get and print the column names, column indexes start from 1
            for (int i = 1; i < numberOfColumns + 1; i++) {
                String columnName = rsMetaData.getColumnName(i);
                System.out.print(columnName + ", ");
            }//endfor
        }//endif
        //place the cursor on a new line in the console
        System.out.println();
        return numberOfColumns;
    }//end method getColumnNames

}