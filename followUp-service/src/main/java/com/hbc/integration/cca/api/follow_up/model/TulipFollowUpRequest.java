package com.hbc.integration.cca.api.follow_up.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class TulipFollowUpRequest implements Serializable{
	
	private List<TulipFollowUpRequestRecord> tulipFollowUpRequestRecord;

	public List<TulipFollowUpRequestRecord> getTulipFollowUpRequestRecord() {
		return tulipFollowUpRequestRecord;
	}

	public void setTulipFollowUpRequestRecord(List<TulipFollowUpRequestRecord> tulipFollowUpRequestRecord) {
		this.tulipFollowUpRequestRecord = tulipFollowUpRequestRecord;
	}

	
	
}
