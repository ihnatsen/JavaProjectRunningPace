package wit.edu.pl;

public class Sum {
    String kilometresSum;
    String caloriesSum;
    String minPace;

    public Sum(String kilometresSum, String caloriesSum, String minPace) {
        this.kilometresSum = kilometresSum;
        this.caloriesSum = caloriesSum;
        this.minPace = minPace;
    }

    public String getKilometresSum() {
        return kilometresSum;
    }

    public void setKilometresSum(String kilometresSum) {
        this.kilometresSum = kilometresSum;
    }

    public String getCaloriesSum() {
        return caloriesSum;
    }

    public void setCaloriesSum(String caloriesSum) {
        this.caloriesSum = caloriesSum;
    }

    public String getMinPace() {
        return minPace;
    }

    public void setMinPace(String minPace) {
        this.minPace = minPace;
    }
}
