package abstractfactory_pattern;

public abstract class Loan {
	protected String statement;
	protected double rate;

	public abstract void getInterestRate(double rate);

	public void calculateLoanPayment(double loanamount, int years) {
		/*
		 * to calculate the monthly loan payment i.e. EMI rate=annual interest
		 * rate/12*100; n=number of monthly installments; 1year=12 months. so,
		 * n=years*12;
		 */

		double EMI;
		int n;
		n = years * 12;
		rate = rate / 1200;
		EMI = ((rate * Math.pow((1 + rate), n)) / ((Math.pow((1 + rate), n)) - 1)) * loanamount;

		this.statement = "Monthly EMI is " + EMI + " for the amount " + loanamount;
	}
	
	@Override
	public String toString() {
		return statement;
	}
}
