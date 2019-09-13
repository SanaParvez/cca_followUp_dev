package com.hbc.integration.cca.api.follow_up.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class TulipFollowUpResponse {

	@JsonProperty(value="errors" )
	private Boolean errors;
	
	@JsonProperty(value="newRecords" )
	private NewRecords [] newRecords;

	public Boolean getErrors() {
		return errors;
	}

	public void setErrors(Boolean errors) {
		this.errors = errors;
	}

	public NewRecords[] getNewRecords() {
		return newRecords;
	}

	public void setNewRecords(NewRecords[] newRecords) {
		this.newRecords = newRecords;
	}
	
	
}
