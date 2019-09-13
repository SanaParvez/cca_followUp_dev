package com.hbc.integration.cca.api.follow_up.resource;

import java.util.List;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hbc.integration.cca.api.follow_up.dao.InternalDao;
import com.hbc.integration.cca.api.follow_up.model.FollowUpRequest;
import com.hbc.integration.cca.api.follow_up.model.FollowUpDataModel;
import com.hbc.integration.cca.api.follow_up.model.TulipFollowUpResponse;
import com.hbc.integration.cca.api.follow_up.service.InternalService;

//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiResponse;
//import io.swagger.annotations.ApiResponses;

//@Component
//@Api(value = "/internal")
@RestController
public class InternalResource {
	
	protected Logger logger = Logger.getLogger(InternalResource.class.getName());
	
	@Autowired
	private InternalService internalService;
	
	@Autowired
	private InternalDao internalDao;
	
	@RequestMapping(method=RequestMethod.POST ,value="/internal")
//	@ApiOperation(httpMethod = "POST", value = "Send Follow-Up Internal request", response = String.class)
//    @ApiResponses(value = {
//            @ApiResponse(code = 404, message = "Tardget Server not found"),
//            @ApiResponse(code = 500, message = "Tardget Response not found")
//    })    @GetMapping("")

		
	public void sendFollowUp(@Valid @RequestBody FollowUpRequest followUpRequest) {
		
		List<FollowUpDataModel>  followUpDataModelList = internalDao.findLatestFollowUp(followUpRequest.getFollow_up_type());
//		List<List<InternalDataModel>> partitionedList =PartitionInternalFollowUpData(internalDataModelList);
		TulipFollowUpResponse tulipFollowUpResponse=	internalService.sendFollowUp(followUpRequest, followUpDataModelList);
		
		if(tulipFollowUpResponse.getErrors().equals(null))
			logger.info("Completed FollowUp details sent for ="+followUpRequest.getFollow_up_type());
		else 
			logger.info("Tulip Error :  ="+tulipFollowUpResponse.getErrors());
		
	
	}
}
