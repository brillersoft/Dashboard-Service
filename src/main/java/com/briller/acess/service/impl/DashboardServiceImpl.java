package com.briller.acess.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.briller.acess.dashboard.repositories.AccountRepository;
import com.briller.acess.dashboard.repositories.DashboardRepository;
import com.briller.acess.dashboard.repositories.EmployeeCsatSummaryRepo;
import com.briller.acess.dashboard.repositories.EmployeeEmailMappingRepositry;
import com.briller.acess.dashboard.repositories.EmployeeRepo;
import com.briller.acess.dashboard.repositories.EmployeeRoleMappingRepo;
import com.briller.acess.dashboard.repositories.RetailEmployeeCsatSummaryRepo;
import com.briller.acess.dashboard.repositories.RoleRepo;
import com.briller.acess.dto.Account;
import com.briller.acess.dto.DashboardData;
import com.briller.acess.dto.Employee;
import com.briller.acess.dto.RequestParamDashboard;
import com.briller.acess.response.Response;
import com.briller.acess.service.IDashboardService;
import com.briller.acess.teamRelationshipHealth.TeamRelationshipHealth;
import com.briller.acess.teamRelationshipHealth.TeamRelationshipHealthDashboardData;

@Component
public class DashboardServiceImpl implements IDashboardService {

	private final Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	private DashboardRepository dashboardRepository;

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private EmployeeCsatSummaryRepo employeeCsatSummaryRepo;

	@Autowired
	private RetailEmployeeCsatSummaryRepo retailEmployeeCsatSummaryRepo;
	
	@Autowired
	private EmployeeRepo employeeRepo;

	@Autowired
	private EmployeeEmailMappingRepositry employeeEmailMappingRepositry;

	@Autowired
	private EmployeeRoleMappingRepo employeeRoleMappingRepo;

	@Autowired
	private RoleRepo roleRepo;

	public DashboardServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void getDashBoardMenuItems(String loggedinUser) {
		// TODO Auto-generated method stub

	}

	public List<DashboardData> clientOveriewData(RequestParamDashboard paramsForDashboard) {

		List<DashboardData> dashboardData = new ArrayList<DashboardData>();
		dashboardRepository.findAll().forEach(dashboardData::add);
		return dashboardData;

	}

	public Response getDashboardData(RequestParamDashboard requestParam) {
		Response response = new Response();
		try {
			log.info("Inside get Dashboard Data post  method -- service Implementation");
			if (requestParam != null) {
				List<Integer> listOfaccountId = retailEmployeeCsatSummaryRepo
						.findDistictAccountId(requestParam.getLoginEmail());
				List<LinkedHashMap<String, Object>> accountDetailsList = new ArrayList<>();
				if (listOfaccountId != null) {
					for (int accId : listOfaccountId) {
						Account account = accountRepository.findByAccountId(accId);
						LinkedHashMap<String, Object> map = new LinkedHashMap<>();
						try {
							map.put("account_id", account.getAccountId());
							map.put("account_name", account.getAccountName());
							map.put("relationships", account.getAccountCsatSummary().getRelationships());
							map.put("escalations", account.getAccountCsatSummary().getEscalations());
							map.put("totalInteractions", account.getAccountCsatSummary().getTotalInteractions());
							map.put("negativeInteractions", account.getAccountCsatSummary().getNegativeInteractions());
							map.put("csat", account.getAccountCsatSummary().getCsat());
							map.put("margin", account.getCrmAccountData().getMargin());
							map.put("revenue", account.getCrmAccountData().getRevenue());
						} catch (NullPointerException e) {
							log.error("Some Paramater recieved from acc_csat_summary is null");
							response.setMsg("Internal Server Error");
							response.setResponse(null);
							return response;
						}

						accountDetailsList.add(map);
					}

					response.setMsg("OK");
					response.setResponse(accountDetailsList);
					return response;
				} else {
					response.setMsg("null accounts");
					response.setResponse(accountDetailsList);
					return response;
				}
			} else {
				response.setMsg("Request Parameter is null ");
				response.setResponse(null);
				return response;
			}
		} catch (Exception e) {
			log.error("error :" + e.getMessage());
			response.setMsg("Something Went Wrong");
			return response;
		}

	}

	@Override
	public Response getTeamRelationshipHealthForDashboard(RequestParamDashboard requestParam) {
		// TODO Auto-generated method stub
		Response response = null;
		try {
			if (requestParam != null) {
				response = new Response();
				log.info("Inside getTeam RelationshipHealthForDashboard Data post  method -- service Implementation");
				Account account = accountRepository.findByAccountName(requestParam.getClient().toUpperCase());

				if (account != null) {
					TeamRelationshipHealthDashboardData teamRelationshipData = new TeamRelationshipHealthDashboardData();
					List<TeamRelationshipHealth> teamList = new ArrayList<>();
						
					List<String> EmployeeEmails = retailEmployeeCsatSummaryRepo.findDistinctEmployees(account.getAccountId());
					if(EmployeeEmails.size()!=0)
					{
						for (String empEmail : EmployeeEmails) {
							int empId = employeeEmailMappingRepositry.getEmpId(empEmail);
							Employee emp = employeeRepo.findByEmployeeId(empId);
							TeamRelationshipHealth teamData = new TeamRelationshipHealth();
							teamData.setName(emp.getFirstName() + " " + emp.getLastName());

							// Mapping by RoleId in Employee_role_Mapping Table
							int roleId = employeeRoleMappingRepo.findByEmployeeId(empId).getRole().getRoleId();
							teamData.setRole(roleRepo.findByRoleId(roleId).getRoleName());
							teamData.setRelationships(account.getAccountCsatSummary().getRelationships());

							double score = retailEmployeeCsatSummaryRepo.getAvgCsatScore(empEmail);
							score=Math.floor(score * 100) / 100;
							teamData.setScore(score);
							teamList.add(teamData);
						}
						teamRelationshipData.setTeamRelationshipHealth(teamList);
						response.setMsg("OK");
						response.setResponse(teamRelationshipData);
					}
					else
					{
						response.setMsg("NO Employees under this Account Exists");
					}
				
				} else {
					response.setMsg("No such Client exists");
				}
				return response;
			} else {
				log.error("Request Parameter is null");
				return response;
			}
		} catch (Exception e) {
			log.error("error : " + e.getMessage());
			response.setMsg("Something Went Wrong");
			return response;
		}
	}

	@Override
	public Response getAllClients(RequestParamDashboard requestParam) {

		Response response = new Response();
		try {
			log.info("Inside getAllClients Data post  method -- service Implementation");
			if (requestParam != null) {
				List<Integer> listOfaccountId = retailEmployeeCsatSummaryRepo
						.findDistictAccountId(requestParam.getLoginEmail());
				LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
				List<Account> accounts = accountRepository.getAllClients(listOfaccountId);

				for (Account account : accounts) {
					map.put(account.getAccountId(), account.getAccountName());
				}
				response.setMsg("Successful");
				response.setResponse(map);
				return response;
			} else {
				log.error("Request Parameter is null");
				return response;
			}
		} catch (Exception e) {
			log.error("error : " + e.getMessage());
			response.setMsg("Something Went Wrong");
			return response;
		}
	}

	public Response getIndividualRevenueDetails(RequestParamDashboard requestParam) {
		Response response = new Response();
		try {
			log.info("Inside getIndividualRevenueDetails post  method -- service Implementation");
			if (requestParam != null) {
				List<Integer> listOfaccountId = retailEmployeeCsatSummaryRepo
						.findDistictAccountId(requestParam.getLoginEmail());
				List<LinkedHashMap<String, Object>> accountDetailsList = new ArrayList<>();
				List<Account> accounts = accountRepository.getAllClients(listOfaccountId);

				for (Account account : accounts) {
					LinkedHashMap<String, Object> map = new LinkedHashMap<>();
					try {
						map.put("account_id", account.getAccountId());
						map.put("account_name", account.getAccountName());
						map.put("revenue", account.getCrmAccountData().getRevenue());
						map.put("margin", account.getCrmAccountData().getMargin());
						map.put("At-Risk", "");
						map.put("escalations", account.getAccountCsatSummary().getEscalations());
						map.put("relationships", account.getAccountCsatSummary().getRelationships());
						// OverAll Health - fetch All Employees and get total score of them
						List<String> listOfEmpEmails = retailEmployeeCsatSummaryRepo.findDistinctEmployees(account.getAccountId());
						double empScore = 0.00;
						for (String email : listOfEmpEmails) {
							empScore += retailEmployeeCsatSummaryRepo.getAvgScoreOfAccount(email, account.getAccountId());
						}
						double totalScore = (empScore / listOfEmpEmails.size());
						map.put("overall_health", totalScore);
					} catch (NullPointerException e) {
						log.error("Some Paramater recieved is null");
						response.setMsg("Internal Server Error");
						response.setResponse(null);
						return response;
					}
					accountDetailsList.add(map);
				}
				response.setMsg("Successful");
				response.setResponse(accountDetailsList);
				return response;
			} else {
				log.error("Request Parameter is null");
				return response;
			}
		} catch (Exception e) {
			log.error("error : " + e.getMessage());
			response.setMsg("Something Went Wrong");
			return response;
		}
	}

}
