package com.platzi.jobsearch;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import com.beust.jcommander.JCommander;
import com.platzi.jobsearch.api.APIJobs;
import com.platzi.jobsearch.cli.CLIArguments;
import com.platzi.jobsearch.cli.CLIFunctions;

import static com.platzi.jobsearch.cli.CommanderFunctions.*;
import static com.platzi.jobsearch.api.APIFunctions.*;

public class JobSearch {
	
	public static void main(String[] args) {
		
		JCommander jCommander = buildCommanderWithName("job-search", CLIArguments::newInstance);
		
		Stream<CLIArguments> streamOfCLI = parseArguments(jCommander, args, JCommander::usage)
				.orElse(Collections.emptyList())
				.stream()
				.map(obj -> (CLIArguments) obj);
		
		
		Optional<CLIArguments> cliArgumentsOptional = 
				streamOfCLI.filter(cli -> !cli.isHelp())
				.filter(cli -> cli.getKeyword() != null)
				.findFirst();
		
		
		cliArgumentsOptional.map(CLIFunctions::toMap)
			.map(JobSearch::executeRequest)
			.orElse(Stream.empty())
			.forEach(System.out::println);
		
	}
	
	private static Stream<JobPosition> executeRequest(Map<String, Object> params){
		APIJobs api = buildAPI(APIJobs.class, "https://jobs.github.com");
		
		return Stream.of(params).map(api::jobs).flatMap(Collection::stream);
	}
	
}
