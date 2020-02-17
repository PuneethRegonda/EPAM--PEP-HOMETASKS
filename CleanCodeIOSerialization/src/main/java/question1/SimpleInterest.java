package question1;

public class SimpleInterest extends Interest {

    public SimpleInterest(double principleAmount, double ratePerAnum, double timeinYears,int roundPlaces) {
        super(principleAmount, ratePerAnum, timeinYears,roundPlaces);
    }

    public  double getsimpleInterest(){
        return round((getPrincipleAmount() * getRatePercentPerAnnum() * getTimeinYears()) * 0.01);
    }


}
