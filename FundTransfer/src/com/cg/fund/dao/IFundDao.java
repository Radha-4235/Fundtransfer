package com.cg.fund.dao;

import com.cg.fund.exception.FundException;

public interface IFundDao {

	 public boolean accHolderValidation(long accNo)throws FundException;

	public boolean payeeAccValid(long payeeAccNo) throws FundException;

	public boolean transfer(long accNo, double transferAmount) throws FundException;


}
