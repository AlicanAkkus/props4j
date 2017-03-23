package com.caysever.props4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.caysever.props4j.annotations.Props4J;

public class Human {

	@Props4J(key = "human.name.length")
	int[] nameLengt;
	@Props4J(key = "human.name", defaultValue = "alican")
	String[] name;
	@Props4J(key = "human.gender", defaultValue = "true")
	Boolean gendersEnabled;
	@Props4J(key = "human.genders", defaultValue = "", comma = ",")
	List<Integer> genders = new ArrayList<>();
	@Props4J(key = "human.locations", defaultValue = "", comma = ",", delimiter = ":")
	Map<String, String> humanLocations = new HashMap<>();
	@Props4J(key = "human.codes", defaultValue = "", comma = ",", delimiter = ":")
	Map<String, Integer> humanCodes = new HashMap<>();

	@Override
	public String toString() {
		return "Human [nameLengt=" + nameLengt + ", name=" + name + ", gendersEnabled=" + gendersEnabled + ", genders=" + genders + ", humanLocations="
				+ humanLocations + ", humanCodes=" + humanCodes + "]";
	}

}
