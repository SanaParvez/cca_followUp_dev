package com.hbc.integration.cca.api.follow_up.constants;

public class QueryConstants {
	
	public static final String  EXTERNAL_FOLLOWUP = "SELECT [IBFST_SequenceNumber] as seqNumber" + 
			",[IBFST_SessionNumber] as sessionNumber" + 
			",[IBFST_BrandName] as brandName" + 
			",[IBFST_FileName] as fileName" + 
			",[IBFST_LineNumber] as lineNumber" + 
			",[IBFST_Status] as status" + 
			",[IBFST_Operation] as operation" + 
			",[IBFST_Tsid] as tSID" + 
			",[IBFST_VipCode] as vipCode" + 
			",[IBFST_StaffCode] as staffCode" + 
			",[IBFST_StaffUseMyClient] as staffUseMyClient" + 
			",[IBFST_StartDate] as startDate" + 
			",[IBFST_EndDate] as endDate" + 
			",[IBFST_ActivityCode] as activityCode" + 
			",[IBFST_MessageNote] as messageNote" + 
			",[IBFST_MessageOut] as messageOut" + 
			",[IBFST_MessageOut_AppendOrReplace] as messageOutAppendOrReplace" + 
			",[IBFST_TaskStatus] as taskStatus" + 
			",[IBFST_AssignmentType] as assignmentType" + 
			",[IBFST_StoreID] as storeID" + 
			",[IBFST_ZoneID] as zoneID" + 
			",[IBFST_DepartmentID] as departmentID" + 
			",[IBFST_CreditCardNumber] as creditCardNumber" + 
			",[IBFST_ReferenceTransactionType] as referenceTransactionType" + 
			",[IBFST_ReferenceTransactionNumber] as referenceTransactionNumber" + 
			" FROM [CCAPlus].[dbo].[IBFileStaffTask] where [IBFST_BrandName] = 'followUpRequest'";

	
	public static final String  INTERNAL_FOLLOWUP = "SELECT " + 
			"T.UniqueId as seqNumber," + 
			"S.UniqueId as StaffId," + 
			"S.staff_code as StaffCode," + 
			"S.Name as StaffName," + 
			"V.VIPCode as vipCode," +  
			"T.StartDate as startDate," + 
			"T.EndDate as endDate,   " + 
			" CET.MessageNote as messageNote," + 
			" CET.MessageOut as messageOut, " + 
			"SKS_d_associate_Test.store_number as storeID " +
			"A.Code as ActivityCode," + 
			"A.Description ActivityDesc," + 
			"AT.Code  ActivityTypeCode," + 
			"AT.Description ActivityTypeDesc " + 
			
			"FROM CRAS_StaffTask T " + 
			
			"INNER JOIN STAFF S "
			+ "on S.UniqueId= T.StaffDelegated " + 
			
			"INNER JOIN dbo.CRAS_ActivityEventTask CET "
			+ "on T.CRAS_ActivityEventTask = CET.UniqueId " + 
			
			"INNER JOIN  CRAS_ActivityEventList EL "
			+ "ON EL.UniqueId=  T.CRAS_ActivityEventList " + 
			"INNER JOIN VIP V "
			+ "ON V.UniqueId = el.Vip " + 
			
			"INNER JOIN CRAS_ActivityEvent AE "
			+ "on   AE.UniqueId=  EL.CRAS_ActivityEvent " + 
			
			"INNER JOIN CRAS_Activity A "
			+ "on A.UniqueId = AE.CRAS_Activity " +
			
			"INNER JOIN CRAS_ActivityType  AT "+
			"ON AT.UniqueId = A.CRAS_ActivityType " + 
			
			"INNER JOIN staff  INNER JOIN  SKS_d_associate_Test " + 
			" ON staff.staff_code = SKS_d_associate_Test.pos_assoc_id " + 
			
			"WHERE  AT.Code IN ('PROSPECT', 'OTHER') " + 
			"AND ActivityCode = 'followUpRequest' " +
			"AND (T.Status ='P' OR T.Status ='N') " + 
			"AND DATEADD(dd, 0, DATEDIFF(dd, 0, GETDATE())) >= DATEADD(dd, 0, DATEDIFF(dd, 0, T.StartDate)) " + 
			"AND DATEADD(dd, 0, DATEDIFF(dd, 0, GETDATE())) <= DATEADD(dd, 0, DATEDIFF(dd, 0, T.EndDate)) " + 
			"order by T.StartDate Desc" ;
}
