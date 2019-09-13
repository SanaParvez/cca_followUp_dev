package com.hbc.integration.cca.api.follow_up.model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class NewRecords {
	
	@JsonProperty(value="createdId" )
	private String createdId;
	
	@JsonProperty(value="jobId" )
	private String jobId;
	
	
}
