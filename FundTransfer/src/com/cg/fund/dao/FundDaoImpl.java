package com.cg.fund.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import com.cg.fund.exception.FundException;
import com.cg.fund.utility.JdbcUtility;

public class FundDaoImpl implements IFundDao {
	Connection connection = null;
	PreparedStatement statement = null;
	Scanner scanner=new Scanner(System.in);


	@Override
	public boolean accHolderValidation(long accNo) throws FundException {
		
	ResultSet resultSet=null;
			boolean res=false;
			connection = JdbcUtility.getConnection();
			try {
				statement=connection.prepareStatement(QueryConstants.getAccId);
				statement.setLong(1,accNo);
				resultSet=statement.executeQuery();
				
				if(resultSet.next()){
			    res=true;
				}
			    
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		
		return res;
	}


	@Override
	public boolean payeeAccValid(long payeeAccNo) throws FundException {
		
		ResultSet resultSet=null;
		boolean res=false;
		connection = JdbcUtility.getConnection();
		try {
			statement=connection.prepareStatement(QueryConstants.getpayeeAccId);
			statement.setLong(1,payeeAccNo);
			resultSet=statement.executeQuery();

			if(resultSet.next()){
		    res=true;
			}
		  } catch (SQLException e) {
				
				e.printStackTrace();
			}
		
		return res;
		
		
	}


	public boolean transfer(long accNo, double transferAmount) throws FundException {
		
		ResultSet resultSet=null;
		boolean res=false;
		boolean flag=false;
		connection = JdbcUtility.getConnection();
		try {
			statement=connection.prepareStatement(QueryConstants.getBalance);
			statement.setLong(1,accNo);
			resultSet=statement.executeQuery();
			resultSet.next();
		    double accountBalance=resultSet.getDouble(1);
		    if(accountBalance>500 && transferAmount<accountBalance){
		    	accountBalance=accountBalance-transferAmount;
		    	System.out.println("Your account Balance is:"+accountBalance);
		    	statement=connection.prepareStatement(QueryConstants.updateBal);
		    	statement.setDouble(1, accountBalance);
		    	statement.setLong(2, accNo);
		    	resultSet=statement.executeQuery();
		    	if(resultSet.next()){
				    res=true;
				    statement=connection.prepareStatement(QueryConstants.getAccId);
					statement.setLong(1,accNo);
					resultSet=statement.executeQuery();
					if(resultSet.next()){
						long accId=resultSet.getLong(1);
						String accType=resultSet.getString(2);					
					
				   statement = connection.prepareStatement(QueryConstants.insertDetails);
				    String s="Credit";
					statement.setString(1,s);
					statement.setString(2, "C");
					statement.setDouble(3, transferAmount);
					statement.setLong(4, accNo);
					int result = statement.executeUpdate();
					if (result > 0) {
						flag = true;
					}
					}
		   }else{
			   System.out.println("Insufficient Balance");
		   }
		    }
		}catch (SQLException e) {
				
				e.printStackTrace();
			}finally{
				try {
					resultSet.close();
				} catch (SQLException e) {
					throw new FundException("Problem while closing resultset");
				}
				try {
					statement.close();
				} catch (SQLException e) {
					throw new FundException("Problem while closing statement");
				}
				JdbcUtility.getConnection();
			}
		
		return res;
	}
	
	




}
