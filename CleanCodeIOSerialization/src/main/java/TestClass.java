import question1.CompoundInterest;
import question1.Interest;
import question1.SimpleInterest;
import question2.AboveStandardMaterials;
import question2.ConstructionCost;
import question2.HighStandard;
import question2.StandardMaterials;

public class TestClass   {

    public static void main(String[] args) {

        Interest simpleInterest = new SimpleInterest(2000,6,3,2);
        Interest compoundInterest = new CompoundInterest(1000, 10, 3, 1, 3);
        Interest compoundInterest1  = new CompoundInterest(2000,8,5,12,3);

        System.out.println(simpleInterest);
        System.out.println(compoundInterest);
        System.out.println(compoundInterest1);

        ConstructionCost constructionCost1 = new ConstructionCost(new StandardMaterials(), 400 );
        ConstructionCost constructionCost2 = new ConstructionCost(new AboveStandardMaterials(), 400 );
        ConstructionCost constructionCost3 = new ConstructionCost(new HighStandard(), 400 );
        ConstructionCost constructionCost4 = new ConstructionCost(new HighStandard(true), 400 );
        System.out.println();
        System.out.println(constructionCost1);
        System.out.println(constructionCost2);
        System.out.println(constructionCost3);
        System.out.println(constructionCost4);

    }
}

