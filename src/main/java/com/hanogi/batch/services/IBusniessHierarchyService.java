package com.hanogi.batch.services;

import java.util.List;
import java.util.Map;

public interface IBusniessHierarchyService {

	public Map<String,List<Map<String, Object>>> getCompleteHierarchy();
}
