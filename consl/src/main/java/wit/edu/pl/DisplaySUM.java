package wit.edu.pl;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class DisplaySUM implements Display, Observer {


    @Override
    public void display() {
        try {

            Iterator<Object> kilometreIT  =  CRUDUtiels.writeSelect("SELECT SUM(distance) FROM RUNNINGPACE");
            String sumKilometres  = kilometreIT.next().toString();
    
    
            Iterator<Object> caloriesSumIT  =  CRUDUtiels.writeSelect("SELECT SUM(calories) FROM RUNNINGPACE");
            String caloriesSum  = (String) caloriesSumIT.next().toString();
    
            Iterator<Object> minPaceIT  =  CRUDUtiels.writeSelect("SELECT min(PACE) FROM RUNNINGPACE");
            String minPace  = (String) minPaceIT.next().toString();
    
            Sum sum = new Sum(sumKilometres,caloriesSum,minPace);
            ObjectMapper objectMapper = new ObjectMapper();
    
            try {
                objectMapper.writeValue(new File(PathToDir.getPathToResourcesFile("consl","sum.json")),sum);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Export completed");
     }catch (NullPointerException ex) {System.out.println("Don't have data.");}
    }

    @Override
    public void update() {
        display();
    }

    public static void main(String[] args) {
        Display display = new DisplaySUM();
        display.display();
    }
}
