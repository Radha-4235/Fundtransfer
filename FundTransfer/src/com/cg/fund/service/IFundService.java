package com.cg.fund.service;


import com.cg.fund.exception.FundException;

public interface IFundService {

	 public boolean accHolderValidation(long accNo)throws FundException;

	public boolean payeeAccValid(long payeeAccNo) throws FundException;

	
	public boolean transfer(long accNo, double transferAmount) throws FundException;

	public boolean validateAccNo(long accNo);

	

}
