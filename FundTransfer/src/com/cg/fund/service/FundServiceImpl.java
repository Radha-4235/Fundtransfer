package com.cg.fund.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.fund.dao.FundDaoImpl;
import com.cg.fund.dao.IFundDao;
import com.cg.fund.exception.FundException;

public class FundServiceImpl implements IFundService {

	IFundDao dao=new FundDaoImpl();

	@Override
	public boolean accHolderValidation(long accNo) throws FundException {
	
		return dao.accHolderValidation(accNo);
	}

	@Override
	public boolean payeeAccValid(long payeeAccNo) throws FundException {
		
		return dao.payeeAccValid(payeeAccNo);
	}

	@Override
	public boolean transfer(long accNo, double transferAmount) throws FundException {
		
		return dao.transfer(accNo,transferAmount);
	}

	@Override
	public boolean validateAccNo(long accNo) {
		String accountNo = Long.toString(accNo);
		String accNoRegEx = "[0-9]{5}";
		Pattern pattern = Pattern.compile(accNoRegEx);
		Matcher matcher = pattern.matcher(accountNo);
		return matcher.matches();
	}

	
	
	
	

}
