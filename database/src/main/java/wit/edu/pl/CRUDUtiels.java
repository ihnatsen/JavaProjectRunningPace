package wit.edu.pl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CRUDUtiels {
    private static String INSERT = "INSERT INTO runningPace " +
            "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";



    public static String[][] getRecords(){
        try(Connection connection = DBUtils.getInstance().getConnection()) {

            PreparedStatement lenPrep =connection.prepareStatement("Select count(*) from RUNNINGPACE");
            ResultSet bu =  lenPrep.executeQuery();
            bu.next();
            int len = bu.getInt(1);


            PreparedStatement preparedStatement =connection.prepareStatement("Select * from RUNNINGPACE");
            ResultSet rs = preparedStatement.executeQuery();



            String[][] records = new String[len+1][12];

            records[0] = new String[]{"trainingID","trainingTimes","PACE","calories","Distance","temperature","Music",
            "trainingLocation","water","WARM_UP","CAT","SLEEP"};

            int i = 1;
            while (rs.next()){
                records[i][0]  = rs.getString("trainingID");
                records[i][1]  = rs.getString("trainingTimes");
                records[i][2]  = rs.getString("PACE");
                records[i][3]  = rs.getString("calories");
                records[i][4]  = rs.getString("Distance");
                records[i][5]  = rs.getString("temperature");
                records[i][6]  = rs.getString("Music");
                records[i][7]  = rs.getString("trainingLocation");
                records[i][8]  = rs.getString("water");
                records[i][9]  = rs.getString("WARM_UP");
                records[i][10] = rs.getString("CAT");
                records[i][11] = rs.getString("SLEEP");
                ++i;

            }
            return records;



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public  static  void writeData(List<String> lst) throws SQLException {
        try(Connection connection = DBUtils.getInstance().getConnection()){

            PreparedStatement data = connection.prepareStatement(INSERT);
            Iterator<String> record = new IteratorDataSet<>(lst);

            data.setObject(1,null);
            data.setString(2,record.next()); //trainingTimes
            data.setFloat(3, Float.parseFloat(record.next())); // Pace
            data.setInt(4, Integer.parseInt(record.next()));// calories
            data.setFloat(5, Float.parseFloat(record.next()));//distance
            data.setInt(6,Integer.parseInt(record.next()));//temperature
            data.setString(7,record.next());//music
            data.setString(8,record.next());//trainingLocation
            data.setInt(9, Integer.parseInt(record.next()));//water
            data.setInt(10, Integer.parseInt(record.next()));//warm_up
            data.setInt(11,Integer.parseInt(record.next()));//cat
            data.setInt(12, Integer.parseInt(record.next()));//sleep
            data.execute();
        }


    }
    public static Iterator<Object> writeSelect(String query) {
        IteratorDataSet<Object> o;
        List<Object> dataSet = new ArrayList<>();
        try(Connection connection = DBUtils.getInstance().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            int i = 1;
            while (resultSet.next()){
                dataSet.add(resultSet.getObject(i));
            }
            return new IteratorDataSet<Object>(dataSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    }



