public class Calculations
{
	private Data data;
	public Calculations(Data data)
	{
		this.data=data;
	}
	public void add()
	{
		data.setValue(this.data.getA()+this.data.getB());
	}
	public void subtract()
	{
		data.setValue(this.data.getA()-this.data.getB());
	}
	public void multiply()
	{
		data.setValue(this.data.getA()*this.data.getB());
	}
	public void divide()
	{
		if(this.data.getB()==0)
		{
			System.out.println("Denominator is zero-Division not possible");
		}
		else
		{
			this.data.setValue(this.data.getA()/this.data.getB());
		}
	}
}