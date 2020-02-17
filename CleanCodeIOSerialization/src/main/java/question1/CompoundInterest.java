package question1;

public class CompoundInterest extends Interest {

    public  double getCompoundYears() {
        return compoundYears;
    }

    private double compoundYears;

    public CompoundInterest(double principleAmount, double ratePercentPerAnnum, double time, double compundYears,int roundPlaces) {
        super(principleAmount, ratePercentPerAnnum/100, time,roundPlaces);
        this.compoundYears = compundYears;
    }

    private double getFractionalAmount() {
        return getRatePercentPerAnnum()/getCompoundYears();
    }

    public double compoundAmount() {
        return round(getPrincipleAmount() * Math.pow((1 + getFractionalAmount()),getCompoundYears()* getTimeinYears()));
    }

    public double getCompoundInterest() {
        return round(compoundAmount() - getPrincipleAmount());
    }

}
