package wit.edu.pl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {
    private static DBUtils dbUtils;
    private DBUtils(){}
    public static DBUtils getInstance(){
        if (dbUtils == null){
            dbUtils = new DBUtils();
        }
        return dbUtils;
    }
    public Connection getConnection()   {
       Properties properties = new Properties();

       try(FileInputStream fis = new FileInputStream(PathToDir.getPathToResourcesFile
               ("database","config.properties"))){
           properties.load(fis);

           String dbURL = properties.getProperty("db.host");
           String dbPassword = properties.getProperty("db.password");
           String dbUsername = properties.getProperty("db.username");
           Connection connection = DriverManager.getConnection(dbURL,dbPassword,dbUsername);

           return connection;

       } catch (SQLException e) {
           throw new RuntimeException(e);
       } catch (FileNotFoundException e) {
           throw new RuntimeException(e);
       } catch (IOException e) {
           throw new RuntimeException(e);
       }



    }
}


