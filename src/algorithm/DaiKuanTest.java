package algorithm;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class DaiKuanTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int MONTHS_IN_YEAR=12;
		double loanAmount,annualInterestRate;
		double monthlyPayment,totalPayment;
		double monthlyInterestRate;
		int loanPeriod;
		int numberOfPayments;
		String inputStr;
		DecimalFormat df=new DecimalFormat("0.00");
		//get input values
		inputStr=JOptionPane.showInputDialog(null,"贷款金额（精确到美分，如15000.00）:");
		loanAmount=Double.parseDouble(inputStr);
		inputStr=JOptionPane.showInputDialog(null,"年利率（百分比，如9.5）:");
		annualInterestRate=Double.parseDouble(inputStr);
		inputStr=JOptionPane.showInputDialog(null,"贷款期限（年份，如30）:");
		loanPeriod=Integer.parseInt(inputStr);
		monthlyInterestRate=annualInterestRate/MONTHS_IN_YEAR/100;
		numberOfPayments=loanPeriod*MONTHS_IN_YEAR;
		monthlyPayment=(loanAmount*monthlyInterestRate)/(1-Math.pow(1/(1+monthlyInterestRate),numberOfPayments));
		totalPayment=monthlyPayment*numberOfPayments;
		System.out.println("贷款金额：$ "+loanAmount);
		System.out.println("年利率:  "+annualInterestRate+"%");
		System.out.println("贷款期限: "+loanPeriod);
		System.out.println("");
		System.out.println("月付款金额：$ "+df.format(monthlyPayment));
		System.out.println("总付款金额：$ "+df.format(totalPayment));
		System.out.println("");
	}

}
