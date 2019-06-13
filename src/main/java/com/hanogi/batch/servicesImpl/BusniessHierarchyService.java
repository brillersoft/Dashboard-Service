package com.hanogi.batch.servicesImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanogi.batch.entity.business.BusinessAccount;
import com.hanogi.batch.entity.business.BusinessDivision;
import com.hanogi.batch.entity.business.BusinessGroup;
import com.hanogi.batch.entity.business.BusinessTeam;
import com.hanogi.batch.entity.business.BusinessUnit;
import com.hanogi.batch.repositry.BusinessAccountRepo;
import com.hanogi.batch.repositry.BusinessDivisionRepo;
import com.hanogi.batch.repositry.BusinessGroupRepo;
import com.hanogi.batch.repositry.BusinessTeamRepo;
import com.hanogi.batch.repositry.BusinessUnitRepo;
import com.hanogi.batch.services.IBusniessHierarchyService;

@Service
public class BusniessHierarchyService implements IBusniessHierarchyService {

	@Autowired
	private BusinessDivisionRepo bDivisionRepo;

	@Autowired
	private BusinessAccountRepo bAccountRepo;

	@Autowired
	private BusinessGroupRepo bGroupRepo;

	@Autowired
	private BusinessTeamRepo teamRepo;

	@Autowired
	private BusinessUnitRepo bUnitRepo;

	@Override
	public Map<String, List<Map<String, Object>>> getCompleteHierarchy() {
		Map<String, List<Map<String, Object>>> hierarchyMap = new HashMap<String, List<Map<String, Object>>>();

		try {
			List<BusinessDivision> allBusinessDivisions = bDivisionRepo.findAll();

			if (allBusinessDivisions != null) {
				List<Map<String, Object>> divisionList = new ArrayList<Map<String, Object>>();
				for (BusinessDivision businessDivision : allBusinessDivisions) {
					Map<String, Object> divisionMap = new HashMap<String, Object>();

					divisionMap.put("id", businessDivision.getDivisionId());
					divisionMap.put("code", businessDivision.getDivisionCode());
					divisionMap.put("name", businessDivision.getDivisionName());
					divisionMap.put("desc", businessDivision.getDivisionDesc());

					BusinessUnit businessUnit = businessDivision.getbUnit();
					divisionMap.put("parent_unit", (businessUnit != null) ? businessUnit.getBusinessUnitName() : null);

					divisionList.add(divisionMap);
				}

				hierarchyMap.put("division", divisionList);

			}

			List<BusinessAccount> businessAccountsList = bAccountRepo.findAll();

			if (businessAccountsList != null) {
				List<Map<String, Object>> accountList = new ArrayList<Map<String, Object>>();

				for (BusinessAccount businessAccount : businessAccountsList) {
					Map<String, Object> accountMap = new HashMap<String, Object>();

					accountMap.put("id", businessAccount.getAccountId());
					accountMap.put("code", businessAccount.getAccountCode());
					accountMap.put("name", businessAccount.getAccountName());
					accountMap.put("desc", businessAccount.getAccountDesc());

					BusinessDivision businessDivision = businessAccount.getbDivision();
					accountMap.put("parent_unit",
							(businessDivision != null) ? businessDivision.getDivisionName() : null);

					accountList.add(accountMap);

				}

				hierarchyMap.put("account", accountList);
			}

			List<BusinessGroup> businessGroupsList = bGroupRepo.findAll();

			if (businessGroupsList != null) {
				List<Map<String, Object>> bgroupList = new ArrayList<Map<String, Object>>();

				for (BusinessGroup businessGroup : businessGroupsList) {
					Map<String, Object> bGroupMap = new HashMap<String, Object>();

					bGroupMap.put("id", businessGroup.getGroupId());
					bGroupMap.put("code", businessGroup.getGroupCode());
					bGroupMap.put("name", businessGroup.getGroupName());
					bGroupMap.put("desc", businessGroup.getGroupDesc());

					BusinessAccount account = businessGroup.getBusinessAccount();
					bGroupMap.put("parent_unit", (account != null) ? account.getAccountName() : null);

					bgroupList.add(bGroupMap);

				}

				hierarchyMap.put("group", bgroupList);
			}

			List<BusinessTeam> businessteamsList = teamRepo.findAll();

			if (businessteamsList != null) {
				List<Map<String, Object>> teamList = new ArrayList<Map<String, Object>>();

				for (BusinessTeam bTeam : businessteamsList) {
					Map<String, Object> bTeamMap = new HashMap<String, Object>();

					bTeamMap.put("id", bTeam.getTeamId());
					bTeamMap.put("code", bTeam.getTeamCode());
					bTeamMap.put("name", bTeam.getTeamName());
					bTeamMap.put("desc", bTeam.getTeamDesc());

					BusinessGroup group = bTeam.getBusinessGroup();
					bTeamMap.put("parent_unit", (group != null) ? group.getGroupName() : null);

					teamList.add(bTeamMap);

				}

				hierarchyMap.put("team", teamList);
			}

			List<BusinessUnit> businessUnitList = bUnitRepo.findAll();

			if (businessUnitList != null) {
				List<Map<String, Object>> bUnitList = new ArrayList<Map<String, Object>>();

				for (BusinessUnit bUnit : businessUnitList) {
					Map<String, Object> bUnitMap = new HashMap<String, Object>();

					bUnitMap.put("id", bUnit.getBusinessUnitId());
					bUnitMap.put("code", bUnit.getBusinessUnitCode());
					bUnitMap.put("name", bUnit.getBusinessUnitName());
					bUnitMap.put("desc", bUnit.getBusinessUnitDesc());

					bUnitList.add(bUnitMap);

				}

				hierarchyMap.put("unit", bUnitList);
			}
			return hierarchyMap;
		} catch (Exception e) {
			return null;
		}
	}

}
