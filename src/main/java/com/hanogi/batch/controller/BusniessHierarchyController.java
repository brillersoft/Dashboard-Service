package com.hanogi.batch.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hanogi.batch.servicesImpl.BusniessHierarchyService;

import io.swagger.annotations.Api;

@RestController("/hierarchy")
@CrossOrigin
@Api(value = "Business Hierarchy Api Services")
public class BusniessHierarchyController {

	@Autowired
	private BusniessHierarchyService bhService;

	@GetMapping("/getCompleteHierarchy")
	public ResponseEntity<?> getCompleteHierarchy() {
		Map<String, List<Map<String, Object>>> completeHierarchy = bhService.getCompleteHierarchy();
		return new ResponseEntity<>(completeHierarchy,
				(completeHierarchy != null) ? HttpStatus.OK : HttpStatus.NO_CONTENT);
	}

}
