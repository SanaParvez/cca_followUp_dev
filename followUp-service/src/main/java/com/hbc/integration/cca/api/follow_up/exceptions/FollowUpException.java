package com.hbc.integration.cca.api.follow_up.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(org.springframework.http.HttpStatus.NOT_FOUND)
public class FollowUpException extends Exception{
	
	
	private static final long serialVersionUID = 1L;

	public FollowUpException(String accountNumber) {
		super("No such account: " + accountNumber);
	}

}
