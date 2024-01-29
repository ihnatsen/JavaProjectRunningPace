package wit.edu.pl;

import java.sql.*;

public class CRUDUtiels  {
    public static String[][] getRecords(){
        try(Connection connection = DBUtils.getInstance().getConnection()) {

            PreparedStatement lenPrep =connection.prepareStatement("Select count(*) from RUNNINGPACE");
            ResultSet bu =  lenPrep.executeQuery();
            bu.next();

            int len = bu.getInt(1);


            PreparedStatement preparedStatement =connection.prepareStatement("Select * from RUNNINGPACE");
            ResultSet rs = preparedStatement.executeQuery();



            String[][] records = new String[len+1][12];

            records[0] = new String[]{"trainingID","trainingDayAndTime","PACE","calories","Distance","temperature","Music",
            "trainingLocation","water","WARM_UP","CAT","SLEEP"};

            int i = 1;
            while (rs.next()){
                records[i][0]  = rs.getString("trainingID");
                records[i][1]  = rs.getString("trainingDayAndTime");
                records[i][2]  = rs.getString("PACE");
                records[i][3]  = rs.getString("calories");
                records[i][4]  = rs.getString("Distance");
                records[i][5]  = rs.getString("temperature");
                records[i][6]  = rs.getString("Music");
                records[i][7]  = rs.getString("trainingLocation");
                records[i][8]  = rs.getString("water");
                records[i][9]  = rs.getString("WARM_UP");
                records[i][10]  = rs.getString("CAT");
                records[i][11] = rs.getString("SLEEP");


                ++i;

            }
            return records;



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}



