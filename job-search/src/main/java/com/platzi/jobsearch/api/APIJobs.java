package com.platzi.jobsearch.api;

import java.util.List;
import java.util.Map;

import com.platzi.jobsearch.JobPosition;

import feign.Headers;
import feign.QueryMap;
import feign.RequestLine;

@Headers("Accept: application/json")
public interface APIJobs {
	
	@RequestLine("GET /positions.json")
	List<JobPosition> jobs(@QueryMap Map<String, Object> queryMap);
	
}
