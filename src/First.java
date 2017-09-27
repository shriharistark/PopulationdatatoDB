/**
 * Created by hari on 24/09/17.
 */

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

public class First {

    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;

    ArrayList<Population> tableresult = new ArrayList<>(); //Array of database records from the input

    private Properties getProps() {

        FileInputStream fis = null;
        Properties props = new Properties();

        try {
            fis = new FileInputStream("src/db.properties");
            props.load(fis);
        }
        catch (Exception e) {
            System.out.println("Exception occured!"+e);
        }

        return props;

    }

    public First() {

        Properties props = getProps();

        boolean isConnected = false;
        try {
            try {
                Class.forName(props.getProperty("DB_DRIVER_CLASS"));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection((props.getProperty("DB_URL"))+"user="+props.getProperty("DB_USERNAME")+"&password="+props.getProperty("DB_PASSWORD"));

            statement = connect.createStatement();
            // Result set get the result of the SQL query
            isConnected = true;


            // Adding elements to DB
            preparedStatement = connect
                    .prepareStatement("insert into  ASSIGNMENT.POPULATION values (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            writetoDB(preparedStatement);



        } catch (SQLException | NullPointerException e) {
            System.out.println("SQL Exception: "+e);
        }

        //Check connection
        System.out.println("Connection established: "+isConnected);
    }


    public void writetoDB(PreparedStatement preparedStatement){

        try {

            ReadCsv file = new ReadCsv();
            tableresult = file.addtolist();

            for(int i = 0 ; i<tableresult.size() ; i++){    //populating the table till array is empty

                Population p = tableresult.get(i);

                preparedStatement.setLong(1, p.getState_code());
                preparedStatement.setLong(2, p.getDistrict_code());
                preparedStatement.setLong(3, p.getSub_district_code());
                preparedStatement.setString(4, p.getLevel());
                preparedStatement.setString(5, p.getArea_name());
                preparedStatement.setLong(6, p.getNoofvillages());
                preparedStatement.setLong(7, p.getTotal_population());
                preparedStatement.setLong(8, p.getMale_population());
                preparedStatement.setLong(9, p.getFemale_population());

                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        }

        catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {

        First generate = new First();
    }
}
