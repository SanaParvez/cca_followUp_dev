package com.hbc.integration.cca.api.follow_up.dao;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hbc.integration.cca.api.follow_up.constants.QueryConstants;
import com.hbc.integration.cca.api.follow_up.model.FollowUpDataModel;
import com.hbc.integration.cca.api.follow_up.model.FollowUpType;


//@Transactional
//@Repository 
@Service
public class ExternalDao {
//	@Autowired
//    private JdbcTemplate jdbcTemplate;
//
//	   private DataSource dataSource;
//	   public void setDataSource(DataSource dataSource) {
//			this.dataSource = dataSource;
//		}

	   @SuppressWarnings("null")
	public List<FollowUpDataModel> findLatestFollowUp(FollowUpType followUpType){
	  
		   /*below code commented till DB access provided
		    * 
		    */
		   
		   /*
		   String sql = QueryConstants.EXTERNAL_FOLLOWUP;
		
	   RowMapper<FollowUpDataModel> rowMapper = new FollowUpMapper();
	   return this.jdbcTemplate.query(sql, rowMapper);
	   */
		   Date dateSample = null;
		try {
			dateSample = new SimpleDateFormat("yyyy-MM-dd").parse("2015-08-11");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   List<FollowUpDataModel>  followUpDataModelList = new ArrayList<FollowUpDataModel>();
		   
		   FollowUpDataModel followUpDataModel1 = new FollowUpDataModel();
		   followUpDataModel1.setStaffCode("26");
		   followUpDataModel1.setVipCode("5");
		   followUpDataModel1.setMessageNote("Call customer asking about purchase");
		   followUpDataModel1.setMessageOut("Call Customer");
		   followUpDataModel1.setEndDate(dateSample);
		   followUpDataModel1.setStoreID("8");
		   followUpDataModel1.setActivityCode(followUpType.toString());
				
			 FollowUpDataModel followUpDataModel2 = new FollowUpDataModel();
			 followUpDataModel2.setStaffCode("27");
			 followUpDataModel2.setVipCode("6");
			 followUpDataModel2.setMessageNote("Call customer asking about purchase");
			 followUpDataModel2.setMessageOut("Call Customer");
			 followUpDataModel2.setEndDate(dateSample);
			 followUpDataModel2.setStoreID("9");
			 followUpDataModel2.setActivityCode(followUpType.toString());
			 
			 followUpDataModelList.add(followUpDataModel1);
			 followUpDataModelList.add(followUpDataModel2);
			
		   return followUpDataModelList;
	   }
}
