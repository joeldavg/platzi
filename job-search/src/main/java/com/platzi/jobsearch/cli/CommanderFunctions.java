package com.platzi.jobsearch.cli;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;

public class CommanderFunctions {

	public static <T> JCommander buildCommanderWithName(String cliName, Supplier<T> argumentSupplier) {
		
		JCommander jCommander = JCommander.newBuilder()
				.addObject(argumentSupplier.get())
				.build();
		
		jCommander.setProgramName(cliName);
		
		return jCommander;
	}
	
	public static Optional<List<Object>> parseArguments(JCommander jCommander, String[] args, Consumer<JCommander> onError){

		try {
			jCommander.parse(args);
			
			return Optional.of(jCommander.getObjects());
		} catch (ParameterException e) {
			onError.accept(jCommander);
		}
		
		return Optional.empty();
	}
	
}
