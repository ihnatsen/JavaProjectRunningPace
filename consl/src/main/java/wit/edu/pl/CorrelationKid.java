package wit.edu.pl;


import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CorrelationKid implements MathModule<Integer> {
    public Map<String,Integer> getRanting() {

        //Condition one - have 5< count;
        String SQLquryСonditionOne = "Select count(*) From RUNNINGPACE";
        Iterator<Object> AnswerConditionDataSet = CRUDUtiels.writeSelect(SQLquryСonditionOne);
        Integer count = ((BigDecimal) AnswerConditionDataSet.next()).intValue();
        if (5 > count){
            return null;
        }
        List<String> numberAttributes  = Arrays.asList(
                new String[]{"calories", "temperature",
                        "water", "WARM_UP", "SLEEP"});

        Map<String,Integer> ranting = new HashMap<>();
        for(String att : numberAttributes){
            String query = String.format("Select round(CORR(Pace,%s)*100) FROM RUNNINGPACE",att);
            Iterator<Object> corr = CRUDUtiels.writeSelect(query);
            Integer theCorr = ((BigDecimal) corr.next()).intValue();
            ranting.put(att,theCorr);
        }
        return ranting;
    }


    public static void main(String[] args) {
        new CorrelationKid().getRanting();
    }
}
