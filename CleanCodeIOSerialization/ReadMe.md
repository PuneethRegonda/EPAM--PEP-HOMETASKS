



# Output
```
question1.SimpleInterest{roundPlaces=2, principleAmount=2000.0, ratePerAnnum=6.0, timeinYears=3.0, interest= 360.0}
question1.CompoundInterest{roundPlaces=3, principleAmount=1000.0, ratePercentPerAnnum=0.1, timeinYears=3.0,compound years of 1.0, interest= 331.0}
question1.CompoundInterest{roundPlaces=3, principleAmount=2000.0, ratePercentPerAnnum=0.08, timeinYears=5.0,compound years of 12.0, interest= 979.691}

ConstructionCost{materialStandard=MaterialStandard{costPerSquareFeet=1200, isFullAutomaticSupport=false}, totalAreaOfHouse=400.0, totalConstruction cost 480000.0}
ConstructionCost{materialStandard=MaterialStandard{costPerSquareFeet=1500, isFullAutomaticSupport=false}, totalAreaOfHouse=400.0, totalConstruction cost 600000.0}
ConstructionCost{materialStandard=MaterialStandard{costPerSquareFeet=1800, isFullAutomaticSupport=false}, totalAreaOfHouse=400.0, totalConstruction cost 720000.0}
ConstructionCost{materialStandard=MaterialStandard{costPerSquareFeet=2500, isFullAutomaticSupport=true}, totalAreaOfHouse=400.0, totalConstruction cost 1000000.0}

```
## Question 1
```
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

```


```
package question1;
public class SimpleInterest extends Interest {

    public SimpleInterest(double principleAmount, double ratePerAnum, double timeinYears,int roundPlaces) {
        super(principleAmount, ratePerAnum, timeinYears,roundPlaces);
    }

    public  double getsimpleInterest(){
        return round((getPrincipleAmount() * getRatePercentPerAnnum() * getTimeinYears()) * 0.01);
    }


}


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
```


## Question 2


```
package question2;

public class MaterialStandard {
    private int costPerSquareFeet;
    private boolean isFullAutomaticSupport=false;

    MaterialStandard(int costPerSquareFeet,boolean isFullAutomaticSupport){
        if(! (this instanceof HighStandard)) throw new IllegalArgumentException();
        this.costPerSquareFeet= costPerSquareFeet;
        this.isFullAutomaticSupport=isFullAutomaticSupport;
    }

    MaterialStandard(int costPerSquareFeet){
        this.costPerSquareFeet= costPerSquareFeet;
    }


    public boolean isFullAutomaticSupport() {
        return this.isFullAutomaticSupport;
    }

    public int getCostPerSquareFeet() {
        return  this.costPerSquareFeet;
    }

    @Override
    public String toString() {
        return "MaterialStandard{" +
                "costPerSquareFeet=" + costPerSquareFeet +
                ", isFullAutomaticSupport=" + isFullAutomaticSupport +
                '}';
    }
}


/**
 * Construction cost per square feet is
 *
 * • 1200INR if we use standard materials
 * • 1500INR if we use above standard materials
 * • 1800INR if customers needs high standard material
 * • 2500INR if customer needs high standard material and fully
 * automated home
 * • Input will be material standard, total area of house and if they want
 * fully automated home
 *
 *
 *  NOTE: Ceartainly EPAM gives confusing Question if user wants to have rest materials other than high quality and fully automated
 *  Should we give a cost of 2500-1800 = 700 INR per square feet quote (Automated House) or simply not possible a better clarification is needed
 *  I go with Simply not possible Cases as this approach is non-intelligent machine achievable. (*_*)
 *
 *
 * */
```

```
package question2;

public class StandardMaterials extends MaterialStandard {

    public StandardMaterials() {
        super(1200);
    }
}


package question2;

public class AboveStandardMaterials extends MaterialStandard{

    public AboveStandardMaterials() {
        super(1500);
    }
}



public class HighStandard extends MaterialStandard{

    public HighStandard( boolean isFullAutomaticSupport) {
        super(2500, isFullAutomaticSupport);
    }

    public HighStandard() {
        super(1800);
    }

}

```
## ConstructionCost.java

```
package question2;

public class ConstructionCost {

    private MaterialStandard materialStandard;
    private double totalAreaOfHouse;

    public ConstructionCost(MaterialStandard materialStandard, double totalAreaOfHouse) {
        this.materialStandard = materialStandard;
        this.totalAreaOfHouse = totalAreaOfHouse;
    }

    public double totalHouseConstructionCost(){
        return materialStandard.getCostPerSquareFeet()*totalAreaOfHouse;
    }


    @Override
    public String toString() {
        return "ConstructionCost{" +
                "materialStandard=" + materialStandard +
                ", totalAreaOfHouse=" + totalAreaOfHouse +
                ", totalConstruction cost "+ totalHouseConstructionCost() +
                '}';
    }
}

```
