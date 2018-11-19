package com.cg.fund.presentation;


import java.util.Scanner;
import com.cg.fund.exception.FundException;
import com.cg.fund.service.FundServiceImpl;
import com.cg.fund.service.IFundService;

public class FundTransferMain {
	static Scanner scanner = new Scanner(System.in);
	 static IFundService service = new FundServiceImpl();

	public static void main(String[] args) {
		
		System.out.println("Enter your account number:");
		long accNo = scanner.nextLong();
		try {
			boolean res = service.validateAccNo(accNo);
			if(res){
			boolean result = service.accHolderValidation(accNo);
			if(result){
				scanner.nextLine();
				System.out.println("Enter account type(Savings/Current):");
				String accType=scanner.nextLine();
				if((accType.equals("Savings")) || (accType.equals("Current"))){
				System.out.println("Enter payees account number:");
				long payeeAccNo = scanner.nextLong();
				boolean valid=service.payeeAccValid(payeeAccNo);
				if(valid){
					System.out.println("Enter Transfer Amount:");
					double transferAmount = scanner.nextDouble();
					boolean success=service.transfer(accNo,transferAmount);
					if(success){
						//boolean tranfer=service.updateTransfer()
						System.out.println("Money transferred successfully");
					}
				}else{
					System.out.println("Enter valid payee Account number");
				}
			}
				else{
					System.out.println("Enter valid accountType");
					}
					}
			else{
				System.out.println("Enter valid account number");
			}
		} 
		else{
			System.out.println("Enter valid 5 digit account number");
		}	
		}
			catch (FundException e) {
		
		
			
			e.printStackTrace();
		}
		
		
		}
		
		
		
		
	}

