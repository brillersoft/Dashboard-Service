package com.hanogi.batch.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hanogi.batch.response.Response;
import com.hanogi.batch.services.ISecudlerService;
import com.hanogi.batch.utility.Request;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
@Api(value = "Batch Scheduler")
public class BatchSchedulerController {

	@Autowired
	private ISecudlerService secudlerService;

	private final Logger log = LoggerFactory.getLogger(getClass());
	/*
	 * @PostMapping("/saveNewBatchDetails")
	 * 
	 * @ApiOperation(value = "Save new Batch details", response =
	 * ResponseEntity.class, consumes = "Complete batch informations.") public
	 * ResponseEntity<?> saveNewBatchDetails(@RequestBody Request loginRequest) {
	 * secudlerService.saveNewSchedulerBatchDetails(loginRequest); return null; }
	 */

	@GetMapping("/getConfigOptions")
	@ApiOperation(value = "Get the Configuration options", response = ResponseEntity.class, produces = "Will return available Deployment types and Service Providers from whic user can choose.")
	public ResponseEntity<?> getConfigOptions() {
		log.info("Inside getConfigOptions");
		Map<String, Object> configOptions = secudlerService.getConfigOptions();
		return new ResponseEntity<Map<String, Object>>(configOptions, HttpStatus.OK);
	}

	@PostMapping("/saveServerConfigOptions")
	@ApiOperation(value = "save the server Configurations", response = ResponseEntity.class, consumes = "Will consumes the server config data in the form of JSON.")
	public ResponseEntity<?> saveConfigOptions(@RequestBody Request configRequest) {
		log.info("Inside saveConfigOptions" + configRequest);
		Boolean isSaved = secudlerService.saveConfigOptions(configRequest);
		String msg = isSaved ? "Saved Sauccessfully" : "Failed to saved";
		return new ResponseEntity<>(msg, isSaved ? HttpStatus.OK : HttpStatus.CONFLICT);
	}

	@PostMapping("/updateServerConfigOptions")
	@ApiOperation(value = "Update the server Configurations", response = ResponseEntity.class, consumes = "Will consumes the server config data in the form of JSON.")
	public ResponseEntity<?> updateConfigOptions(@RequestBody Request configRequest) {
		log.info("Inside updateConfigOptions" + configRequest);
		Boolean isSaved = secudlerService.updateConfigOptions(configRequest);
		String msg = isSaved ? "Saved Sauccessfully" : "Failed to saved";
		return new ResponseEntity<>(msg, isSaved ? HttpStatus.OK : HttpStatus.CONFLICT);
	}

	@GetMapping("/getAllServerConfigs")
	@ApiOperation(value = "Get all previously saved email server configurations", response = ResponseEntity.class, produces = "Json", nickname = "Server details")
	public ResponseEntity<?> getAllServerConfigs() {
		log.info("Inside getAllServerConfigs");
		List<Map<String, String>> allServerConfigs = secudlerService.getAllServerConfigs();
		return new ResponseEntity<>(allServerConfigs, HttpStatus.OK);
	}

	@PostMapping("/scheduleJobs")
	@ApiOperation(value = "Schedule the new job for a batch", response = ResponseEntity.class, consumes = "Will consumes the scheduler data in the form of JSON.")
	public ResponseEntity<?> scheduleJobs(@RequestBody Request scheduleJobRequest) {
		log.info("Inside scheduleJobs" + scheduleJobRequest);
		Boolean isSuccess = secudlerService.scheduleNewJobs(scheduleJobRequest);
		String msg = isSuccess ? "Scheduler saved" : "Failed while saving";
		return new ResponseEntity<>(msg, isSuccess ? HttpStatus.OK : HttpStatus.CONFLICT);
	}

	@GetMapping("/getAllScheduledJobs")
	@ApiOperation(value = "Get all job schedulers", response = ResponseEntity.class, produces = "Json", nickname = "Schedulers details")
	public ResponseEntity<?> getAllScheduledJobs() {
		log.info("Inside getAllScheduledJobs");
		return new ResponseEntity<>(secudlerService.getAllSchedulers(), HttpStatus.OK);
	}

	@PostMapping("/saveMailIdList")
	@ApiOperation(value = "On board emailId list", response = ResponseEntity.class, consumes = "Will consumes the emailId related data in the form of JSON.")
	public ResponseEntity<?> saveMailIdList(@RequestBody Request addMailIdListRequest) {
		log.info("Inside saveMailIdList" + addMailIdListRequest);
		Boolean isSuccess = secudlerService.saveMailIdList(addMailIdListRequest);
		String msg = isSuccess ? "List Saved" : "Failed while saving";
		return new ResponseEntity<>(msg, isSuccess ? HttpStatus.OK : HttpStatus.CONFLICT);
	}

	@GetMapping("/getWorldCountry")
	@ApiOperation(value = "Get all Country names List", response = ResponseEntity.class, produces = "Json")
	public ResponseEntity<?> getWorldCountry() {
		log.info("Inside getWorldCountry");
		return new ResponseEntity<>(secudlerService.getWorldCountry(), HttpStatus.OK);
	}

	@GetMapping("/getCities")
	@ApiOperation(value = "Get all city names List", response = ResponseEntity.class, produces = "Json")
	public ResponseEntity<?> getCities() {
		log.info("Inside getCities");
		return new ResponseEntity<>(secudlerService.getCities(), HttpStatus.OK);
	}

	@PostMapping("/saveBusinessUnit")
	@ApiOperation(value = "Add new business unit", response = ResponseEntity.class, consumes = "Will business unit details.")
	public ResponseEntity<?> saveBusinessUnit(@RequestBody Request request) {
		log.info("Inside saveBusinessUnit"+request);
		Boolean isSuccess = secudlerService.saveBusinessUnit(request);
		String msg = isSuccess ? "List Saved" : "Failed while saving";
		return new ResponseEntity<>(msg, isSuccess ? HttpStatus.OK : HttpStatus.CONFLICT);
	}

	@PostMapping("/saveEntity")
	@ApiOperation(value = "save address details", response = ResponseEntity.class, consumes = "Will Address details.")
	public ResponseEntity<?> saveEntityDetails(@RequestBody Request request) {
		log.info("Inside saveEntityDetails"+request);
		Response response = secudlerService.saveEntity(request);
		return new ResponseEntity<>(response, (response.getResponse() != null) ? HttpStatus.OK : HttpStatus.CONFLICT);
	}

	@PostMapping("/updateEntity")
	@ApiOperation(value = "update address details", response = ResponseEntity.class, consumes = "Will  Update Address details.")
	public ResponseEntity<?> updateEntityDetails(@RequestBody Request request) {
		log.info("Inside updateEntityDetails"+request);
		Response response =secudlerService.updateEntityDetail(request);
		return new ResponseEntity<>(response, (response.getResponse()!=null)  ? HttpStatus.OK : HttpStatus.CONFLICT);
	}

	@PostMapping("/saveBusinessDivision")
	@ApiOperation(value = "Add new division in the unit", response = ResponseEntity.class, consumes = "Will consume new division.")
	public ResponseEntity<?> saveBusinessDivision(@RequestBody Request request) {
		log.info("Inside saveBusinessDivision"+request);
		Boolean isSuccess = secudlerService.saveBusinessDivision(request);
		String msg = isSuccess ? "List Saved" : "Failed while saving";
		return new ResponseEntity<>(msg, isSuccess ? HttpStatus.OK : HttpStatus.CONFLICT);
	}

	@PostMapping("/saveNewAccount")
	@ApiOperation(value = "Add new account to the division", response = ResponseEntity.class, consumes = "Will consumes new account info.")
	public ResponseEntity<?> saveNewAccount(@RequestBody Request request) {
		log.info("Inside saveNewAccount"+request);
		Boolean isSuccess = secudlerService.saveNewAccount(request);
		String msg = isSuccess ? "List Saved" : "Failed while saving";
		return new ResponseEntity<>(msg, isSuccess ? HttpStatus.OK : HttpStatus.CONFLICT);
	}

	@PostMapping("/saveBusinessUnitDetails")
	@ApiOperation(value = "Save new business unit details", response = ResponseEntity.class, consumes = "Will consumes new account info.")
	public ResponseEntity<?> saveBusinessUnitDetails(@RequestBody Request request) {
		log.info("Inside saveBusinessUnitDetails"+request);
		Boolean isSuccess = secudlerService.saveBusinessUnitDetails(request);
		String msg = isSuccess ? "Details Saved" : "Failed while saving";
		return new ResponseEntity<>(msg, isSuccess ? HttpStatus.OK : HttpStatus.CONFLICT);
	}

	@GetMapping("/getBatchStatus")
	@ApiOperation(value = "Get all batch run status", response = ResponseEntity.class, produces = "Json")
	public ResponseEntity<?> getBatchStatus() {
		log.info("Inside getBatchStatus");
		return new ResponseEntity<>(secudlerService.getBatchStatus(), HttpStatus.OK);
	}

}
