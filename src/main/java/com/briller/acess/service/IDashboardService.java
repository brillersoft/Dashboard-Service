package com.briller.acess.service;

import com.briller.acess.dto.RequestParamDashboard;
import com.briller.acess.response.Response;


public interface IDashboardService {

	void getDashBoardMenuItems(String loggedinUser);

	Response getDashboardData(RequestParamDashboard requestParam);
	
	Response getTeamRelationshipHealthForDashboard(RequestParamDashboard requestParam);
	
	Response getAllClients(RequestParamDashboard requestParam);
	
}
