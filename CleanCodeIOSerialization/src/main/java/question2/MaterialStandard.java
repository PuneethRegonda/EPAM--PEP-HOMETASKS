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