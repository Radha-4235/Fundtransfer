package com.cg.fund.dao;

public interface QueryConstants {

	
	
public static final String getAccId="select * from Account_Master where Account_ID=?";

public static final String getpayeeAccId="select * from PayeeTable where Payee_Account_Id=?";

public static final String getBalance="SELECT Account_Balance FROM Account_Master WHERE Account_ID=?";

public static final String updateBal="update Account_Master set Account_Balance =? where Account_ID=?";

public static final String insertDetails="insert into transactions values(trans_id.nextval,?,sysdate,?,?,?)";

//public static final String getAccId="select * from Account_Master where Account_ID=?";

}
