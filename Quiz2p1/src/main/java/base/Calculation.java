package base;
import java.util.Scanner;
// Raveena Wadhwa Quiz 2 Problem 1
public class Calculation
{
	private double TuitionTotal;
	private double PercentageIncrease;
	private double RepaymentAPR;
	private double Term;

	// This is a constructor that takes user input
	public Calculation()
	{
		getInput();
	}

	// Paramater values for variable values
	public Calculation(double initialTuition, 
			double tuitionPercentageIncrease, 
			double repaymentAPR, 
			double loanTerm)
	{
		this.TuitionTotal = initialTuition;
		this.PercentageIncrease = tuitionPercentageIncrease;
		this.RepaymentAPR = RepaymentAPR;
		this.Term = Term;
	}

	// Scanner gets input from user
	public void getInput()
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Initial Tuition:");
		TuitionTotal = input.nextDouble();
		System.out.print("Tuition percentage increase:");
		PercentageIncrease = input.nextInt();
		System.out.print("Repayment APR:");
		RepaymentAPR = input.nextInt();
		System.out.print("Loan Term (in months):");
		Term = input.nextInt();
		input.close();
	}

	/*
	 * Calculation for the total cost of tuition
	 * 
	 * @return TotalCost - the amount of money needed to pay off the loan
	 */
	public double calculateTotalCost()
	{
		double TotalCost = (TuitionTotal / 
				(Math.pow((1 + (((RepaymentAPR+ PercentageIncrease) / 100/12))), 
				Term)));
		return TotalCost;
	}

	/*
	 * Calculates the amount paid monthly for tuition
	 * 
	 * @return monthlyCost - monthly payment to pay off loan
	 */
	public double calculateMonthlyCost()
	{
		double m = (((RepaymentAPR + PercentageIncrease)/100)/12);
		double MonthlyCost = (m*calculateTotalCost()*(Math.pow(1+m, Term)))/
				((Math.pow(1+m, Term))-1);
		return MonthlyCost;
	}
	
	//Prints the total and monthly costs
	public void calculateAndPrint()
	{
		System.out.printf("The total cost is: $%,.2f%n", calculateTotalCost());
		System.out.printf("The monthly cost is: $%,.2f%n", calculateMonthlyCost());
	}
}
