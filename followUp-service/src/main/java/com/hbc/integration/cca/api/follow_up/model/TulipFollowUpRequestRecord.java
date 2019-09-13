package com.hbc.integration.cca.api.follow_up.model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class TulipFollowUpRequestRecord implements Serializable {
	
	@JsonProperty(value="assignedById" )
	private String assignedById;
	
	@JsonProperty(value="assignedEmployeeId" )
	@NotNull(message = "assignedEmployeeId is mandatory..")
	private String assignedEmployeeId;
	
	@JsonProperty(value="createdById" )
	private String createdById;
	
	@JsonProperty(value="customerId" )
	@NotNull(message = "customerId is mandatory..")
	private String customerId;
	
	@JsonProperty(value="dateCreated" )
	private String dateCreated;
		
	@JsonProperty(value="dateModified" )
	private String dateModified;
	
	@JsonProperty(value="description" )
	@NotNull(message = "description is mandatory..")
	private String description;
	
	@JsonProperty(value="dueDate" )
	@NotNull(message = "dueDate is mandatory..")
	private String dueDate;
	
	@JsonProperty(value="externalID" )
	private String externalID;
	
	@JsonProperty(value="id" )
	private String id;
	
	@JsonProperty(value="isDeleted" )
	@NotNull(message = "isDeleted is mandatory..")
	private boolean isDeleted = false;
	
	@JsonProperty(value="status" )
	@NotNull(message = "status is mandatory..")
	private String status = "ACTIVE";
	
	@JsonProperty(value="storeId" )
	@NotNull(message = "storeId is mandatory..")
	private String storeId;
	
	@JsonProperty(value="tag" )
	@NotNull(message = "tag is mandatory..")
	private String tag;
	
	@JsonProperty(value="taskType" )
	@NotNull(message = "taskType is mandatory..")
	private String taskType="FOLLOWUP";
	
	@JsonProperty(value="title" )
	@NotNull(message = "title is mandatory..")
	private String title;
	
	
	
	public String getAssignedById() {
		return assignedById;
	}

	public void setAssignedById(String assignedById) {
		this.assignedById = assignedById;
	}

	public String getAssignedEmployeeId() {
		return assignedEmployeeId;
	}

	public void setAssignedEmployeeId(String assignedEmployeeId) {
		this.assignedEmployeeId = assignedEmployeeId;
	}

	public String getCreatedById() {
		return createdById;
	}

	public void setCreatedById(String createdById) {
		this.createdById = createdById;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getDateModified() {
		return dateModified;
	}

	public void setDateModified(String dateModified) {
		this.dateModified = dateModified;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getExternalID() {
		return externalID;
	}

	public void setExternalID(String externalID) {
		this.externalID = externalID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getTaskType() {
		return taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	

	
	    
}
