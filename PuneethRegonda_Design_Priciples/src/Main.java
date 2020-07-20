import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Data data=new Data();
    	Calculations cal=new Calculations(data);
        Presentation pr=new Presentation(cal,data);
        pr.choice();
		
	}

}


class Presentation
{
	private int option;
	private Scanner inp;
	private Calculations cal;
	private Data data;
	public Presentation(Calculations cal,Data data)
	{
		inp=new Scanner(System.in);
		this.cal=cal;
		this.data=data;
	}
	public void input()
	{
		int a,b;
		System.out.println("Enter the number a");
		a=inp.nextInt();
		System.out.println("Enter the number b");
		b=inp.nextInt();
		data.setData(a, b);
	}
	public void choice()
	{
		System.out.println("Calculator Starting");
		do
		{
			System.out.println("Select the options....");
			System.out.println("1:Add");
			System.out.println("2:Subtract");
			System.out.println("3:Multiply");
			System.out.println("4:Divide");
			System.out.println("5:Exit");
			option=inp.nextInt();
			if(option!=5)
			{
				input();
			}
			switch(option)
			{
			case 1:
				cal.add();
				System.out.println("The Sum of "+data.getA()+" and "+data.getB()+" is "+data.getValue());
				break;
			case 2:
				cal.subtract();
				System.out.println("The Difference of "+data.getA()+" and "+data.getB()+" is "+data.getValue());
				break;
			case 3:
				cal.multiply();
				System.out.println("The Product of "+data.getA()+" and "+data.getB()+" is "+data.getValue());
				break;
			case 4:
				cal.divide();
				if(data.getB()!=0) 
				{
					System.out.println("The value of "+data.getA()+" divided by "+data.getB()+" is "+data.getValue());
				}
				break;
			case 5:
				break;
			default:
				System.out.println("Invalid option Try again");
			}
		}while(option!=5);
	}
}