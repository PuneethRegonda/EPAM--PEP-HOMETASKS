package question1;

public class Interest {

    private int roundPlaces = 2;
    private double principleAmount;
    private double ratePerAnnum;
    private double timeinYears;


    public double getPrincipleAmount() {
        return principleAmount;
    }

    public double getRatePercentPerAnnum() {
        return ratePerAnnum;
    }

    public double getTimeinYears() {
        return timeinYears;
    }

    public Interest(double principleAmount, double ratePerAnnum, double timeinYears, int roundPlaces) {

        if (roundPlaces < 0 || ratePerAnnum < 0 || principleAmount < 0 || timeinYears < 0) throw new IllegalArgumentException();

        this.principleAmount = principleAmount;
        this.ratePerAnnum = ratePerAnnum;
        this.timeinYears = timeinYears;
        this.roundPlaces = roundPlaces;

    }

    public Interest(int principleAmount, int ratePerAnnum, int timeinYears, int roundPlaces) {

        if (roundPlaces < 0 || ratePerAnnum < 0 || principleAmount < 0 || timeinYears < 0) throw new IllegalArgumentException();

        this.principleAmount = (double) principleAmount;
        this.ratePerAnnum = (double) ratePerAnnum;
        this.timeinYears = (double) timeinYears;
        this.roundPlaces = roundPlaces;

    }

    public double round(double value) {
        long factor = (long) Math.pow(10, roundPlaces);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    @Override
    public String toString() {
        String compoundYears = this instanceof CompoundInterest ? ",compound years of " + ((CompoundInterest) this).getCompoundYears() : "";
        double interest = this instanceof CompoundInterest ? ((CompoundInterest) this).getCompoundInterest() : ((SimpleInterest) this).getsimpleInterest();
        String ratePercent = this instanceof CompoundInterest ? ", ratePercentPerAnnum=" + ((CompoundInterest) this).getRatePercentPerAnnum() : ", ratePerAnnum="+((SimpleInterest) this).getRatePercentPerAnnum();
        return this.getClass().getName()+"{" +
                "roundPlaces=" + roundPlaces +
                ", principleAmount=" + principleAmount +
                ratePercent+
                ", timeinYears=" + timeinYears + compoundYears+
                ", interest= "+ interest+
                '}';
    }
}