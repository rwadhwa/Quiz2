package base;
import java.util.Scanner;
// Raveena Wadhwa Quiz 2 Problem 1
public class Calculation
{
	private double TuitionTotal;
	private double PercentageIncrease;
	private double RepaymentAPR;
	private double Term;

	// constructor that takes user input
	public Calculation()
	{
		getUserInput();
	}

	// Parameter values
	public Calculation(double initialTuition, 
			double tuitionPercentageIncrease, 
			double repaymentAPR, 
			double loanTerm)
	{
		TuitionTotal = initialTuition;
		PercentageIncrease = tuitionPercentageIncrease;
		RepaymentAPR = RepaymentAPR;
		Term = Term;
	}

	// Scanner gets input from user
	public void getUserInput()
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
//Calculates and returns total cost
	public double calculateTotalCost()
	{
		double TotalCost = (TuitionTotal / 
				(Math.pow((1 + (((RepaymentAPR+ PercentageIncrease) / 100/12))), 
				Term)));
		return TotalCost;
	}

	//Calculates the monthly cost w online formula
	public double calculateMonthlyCost()
	{
		double MonthlyCost = ((((RepaymentAPR + PercentageIncrease)/100)/12)*calculateTotalCost()*(Math.pow(1+(((RepaymentAPR + PercentageIncrease)/100)/12), Term)))/
				((Math.pow(1+(((RepaymentAPR + PercentageIncrease)/100)/12), Term))-1);
		return MonthlyCost;
	}
	

	public void Printcost()
	{
		System.out.printf("When calculated the total cost is $%,.2f%n", calculateTotalCost());
		System.out.printf("When calculated the monthly cost is $%,.2f%n", calculateMonthlyCost());
	}
}
