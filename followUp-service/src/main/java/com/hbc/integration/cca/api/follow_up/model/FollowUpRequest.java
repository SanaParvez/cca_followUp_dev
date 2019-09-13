package com.hbc.integration.cca.api.follow_up.model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class FollowUpRequest implements Serializable{

	@JsonProperty(value="follow_up_type" )
	@NotNull(message = "FollowUpType is mandatory..")
	private FollowUpType follow_up_type;

	public FollowUpType getFollow_up_type() {
		return follow_up_type;
	}


	public void setFollow_up_type(FollowUpType follow_up_type) {
		this.follow_up_type = follow_up_type;
	}


	
	
	    
}
