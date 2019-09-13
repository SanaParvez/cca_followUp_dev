package com.hbc.integration.cca.api.follow_up.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hbc.integration.cca.api.follow_up.model.FollowUpDataModel;

public class FollowUpMapper implements RowMapper<FollowUpDataModel>  {

	 @Override
	   public FollowUpDataModel mapRow(ResultSet row, int rowNum) throws SQLException {
		 FollowUpDataModel followUpDataModel = new FollowUpDataModel();
		 followUpDataModel.setSeqNumber(row.getInt("seqNumber"));
		 followUpDataModel.setSessionNumber(row.getInt("sessionNumber"));
		 followUpDataModel.setBrandName(row.getString("brandName"));
		 followUpDataModel.setFileName(row.getString("fileName"));
		 followUpDataModel.setLineNumber(row.getInt("lineNumber"));
		 followUpDataModel.setStatus(row.getString("status"));
		 followUpDataModel.setOperation(row.getString("operation"));
		 followUpDataModel.settSID(row.getDate("tSID"));
		 followUpDataModel.setVipCode(row.getString("vipCode"));
		 followUpDataModel.setStaffCode(row.getString("staffCode"));
		 followUpDataModel.setStaffUseMyClient(row.getString("staffUseMyClient"));
		 followUpDataModel.setStartDate(row.getDate("startDate"));
		 followUpDataModel.setEndDate(row.getDate("endDate"));
		 followUpDataModel.setActivityCode(row.getString("activityCode"));
		 followUpDataModel.setMessageNote(row.getString("messageNote"));
		 followUpDataModel.setMessageOut(row.getString("messageOut"));
		 followUpDataModel.setMessageOutAppendOrReplace(row.getString("messageOutAppendOrReplace"));
		 followUpDataModel.setTaskStatus(row.getString("taskStatus"));
		 followUpDataModel.setAssignmentType(row.getString("assignmentType"));
		 followUpDataModel.setStoreID(row.getString("storeID"));
		 followUpDataModel.setZoneID(row.getString("zoneID"));
		 followUpDataModel.setDepartmentID(row.getString("departmentID"));
		 followUpDataModel.setCreditCardNumber(row.getString("creditCardNumber"));
		 followUpDataModel.setReferenceTransactionType(row.getString("referenceTransactionType"));
		 followUpDataModel.setReferenceTransactionNumber(row.getString("referenceTransactionNumber"));
					
		 
		return followUpDataModel;
	   }
}
