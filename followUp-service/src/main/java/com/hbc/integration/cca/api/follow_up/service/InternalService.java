package com.hbc.integration.cca.api.follow_up.service;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hbc.integration.cca.api.follow_up.model.FollowUpRequest;
import com.hbc.integration.cca.api.follow_up.model.FollowUpDataModel;
import com.hbc.integration.cca.api.follow_up.model.TulipFollowUpRequestRecord;
import com.hbc.integration.cca.api.follow_up.model.TulipFollowUpResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.http.HttpEntity;


@Service 
public class InternalService {

	
	@Autowired
	private RestTemplate restTemplate;
	
	protected Logger logger = Logger.getLogger(ExternalService.class.getName());
	
	private static final String TULIP_END_POINT_URL  = "https://v60b-staging-staging-s5a.tulipretail.com/dal/dataAccess/v1/crm/tasks";	
		
//	@Async
	public TulipFollowUpResponse sendFollowUp(FollowUpRequest followUpRequest, List<FollowUpDataModel> followUpDataModelList) {
		
		String jsonStr = dataRequestMapping(followUpDataModelList);
		
		HttpEntity<String> entity = new HttpEntity<String>(jsonStr,getHeaders());
		
		try {
			logger.info("Start Follow- Up data sending to Tulip for " + followUpRequest.getFollow_up_type());
			
			logger.info("Tulip Json Request...");
			ObjectMapper Obj = new ObjectMapper(); 
			logger.info("entity...");
		      logger.info(Obj.writeValueAsString(entity));
		 } 
		  
        catch (IOException e) { 
            e.printStackTrace(); 
        } 
	
	ResponseEntity<TulipFollowUpResponse> vendorFollowUpResponse =restTemplate.postForEntity(TULIP_END_POINT_URL, entity,TulipFollowUpResponse.class);
		
		
	logger.info("result.....   ");
	logger.info(""+vendorFollowUpResponse.getBody().getErrors());
		
		return vendorFollowUpResponse.getBody();
		
	}
	
	 
    private String dataRequestMapping(List<FollowUpDataModel> followUpDataModelList) {
    	TulipFollowUpRequestRecord tulipFollowUpRequestSingleRecord = new TulipFollowUpRequestRecord();
    
    	ObjectMapper Obj = new ObjectMapper(); 
    	String jsonStr = "";
    	for (FollowUpDataModel followUpDataModel : followUpDataModelList) {
    		
    		tulipFollowUpRequestSingleRecord.setAssignedById(null);
    		tulipFollowUpRequestSingleRecord.setAssignedEmployeeId(followUpDataModel.getStaffCode());
    		tulipFollowUpRequestSingleRecord.setCreatedById(null);
    		tulipFollowUpRequestSingleRecord.setCreatedById(followUpDataModel.getVipCode());
    		tulipFollowUpRequestSingleRecord.setDateCreated(null);
    		tulipFollowUpRequestSingleRecord.setDateModified(null);
    		tulipFollowUpRequestSingleRecord.setDescription(followUpDataModel.getMessageNote());
    		tulipFollowUpRequestSingleRecord.setDueDate(followUpDataModel.getEndDate().toString());
    		tulipFollowUpRequestSingleRecord.setExternalID(null);
    		tulipFollowUpRequestSingleRecord.setId(null);
    		tulipFollowUpRequestSingleRecord.setStoreId(followUpDataModel.getStoreID());
    		tulipFollowUpRequestSingleRecord.setTag(followUpDataModel.getActivityCode());
    		tulipFollowUpRequestSingleRecord.setTitle(followUpDataModel.getMessageOut());
    		
    		
			try {
				jsonStr = jsonStr + Obj.writeValueAsString(tulipFollowUpRequestSingleRecord) +"\r\n";
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
    		tulipFollowUpRequestSingleRecord = new TulipFollowUpRequestRecord();
    		
		}
    	
    	jsonStr = jsonStr.replace("\"deleted\":false,","");
    	logger.info("json="+jsonStr);
		return jsonStr;
	}

    

	private HttpHeaders getHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		List <MediaType>accepts = new ArrayList<MediaType>();
		accepts.add(MediaType.APPLICATION_JSON);
		headers.setAccept(accepts);
		return headers;
	}
    
    
}
