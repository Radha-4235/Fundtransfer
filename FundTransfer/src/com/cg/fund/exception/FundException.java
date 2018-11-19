package com.cg.fund.exception;

public class FundException extends Exception {
private String message;

public FundException(String message) {
	super();
	this.message = message;
}

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

}
