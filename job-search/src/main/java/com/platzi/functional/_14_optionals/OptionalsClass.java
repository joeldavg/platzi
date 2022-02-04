package com.platzi.functional._14_optionals;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class OptionalsClass {

	public static void main(String[] args) {
		List<String> names = getNames();
		if (names != null) {
			// Operar con nombres.
		}

		Optional<List<String>> optionalNames = getOptionalNames();
		if (optionalNames.isPresent()) {

		}

		optionalNames.ifPresent(namesValue -> namesValue.forEach(System.out::println));

		Optional<String> valuablePlayer = optionalValuablePlayer();

		String valuablePlayerName = valuablePlayer.orElseGet(() -> "No Player");

	}

	static List<String> getNames() {
		List<String> list = new LinkedList<String>();

		return Collections.emptyList();
	}

	static String mostValuablePlayer() {
		// return "";
		return null;
	}

	static int mostExpensiveItem() {
		return 0;
	}

	static Optional<List<String>> getOptionalNames() {
		List<String> namesList = new LinkedList<>();
		// Obtencion de nombres
		return Optional.of(namesList);
	}

	static Optional<String> optionalValuablePlayer() {
		// return Optional.ofNullable()

		try {
			//Acceso a los datos
			return Optional.of("joel");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Optional.empty();
	}

}
