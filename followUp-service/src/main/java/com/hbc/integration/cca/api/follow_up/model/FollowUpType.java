package com.hbc.integration.cca.api.follow_up.model;

public enum FollowUpType {

	FollowupCoupon, // Daily
	FollowupEGC, // Daily
	FollowupRedeemedCoupons, // Daily
	FollowupReplenish, // Daily
	FollowupAlteration, // Hourly
	FollowupAlterationDaily, // Daily
	FollowupRepair, // Hourly
	FollowupRepairDaily, //  Daily
	FollowupSend,  // Daily
	FollowupNewAccount, // Daily
	FollowupLocater, // Hourly
	FollowupLocaterShipping, // Daily
	FollowupPlatinum, // Daily
	FollowupEliite, // Daily
	FollowupSpecialOrder // Daily;
	
}
