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
