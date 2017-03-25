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
	String name;
	@Props4J(key = "human.gender", defaultValue = "true")
	Boolean gendersEnabled;
	@Props4J(key = "human.genders", defaultValue = "", comma = ",")
	List<String> genders = new ArrayList<>();
	@Props4J(key = "human.locations", defaultValue = "", comma = ",", delimiter = ":")
	Map<String, String> humanLocations = new HashMap<>();
	@Props4J(key = "human.codes", defaultValue = "", comma = ",", delimiter = ":")
	Map<String, Integer> humanCodes = new HashMap<>();

	public int[] getNameLengt() {
		return nameLengt;
	}

	public void setNameLengt(int[] nameLengt) {
		this.nameLengt = nameLengt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getGendersEnabled() {
		return gendersEnabled;
	}

	public void setGendersEnabled(Boolean gendersEnabled) {
		this.gendersEnabled = gendersEnabled;
	}

	public List<String> getGenders() {
		return genders;
	}

	public void setGenders(List<String> genders) {
		this.genders = genders;
	}

	public Map<String, String> getHumanLocations() {
		return humanLocations;
	}

	public void setHumanLocations(Map<String, String> humanLocations) {
		this.humanLocations = humanLocations;
	}

	public Map<String, Integer> getHumanCodes() {
		return humanCodes;
	}

	public void setHumanCodes(Map<String, Integer> humanCodes) {
		this.humanCodes = humanCodes;
	}

	@Override
	public String toString() {
		return "Human [nameLengt=" + nameLengt + ", name=" + name + ", gendersEnabled=" + gendersEnabled + ", genders=" + genders + ", humanLocations="
				+ humanLocations + ", humanCodes=" + humanCodes + "]";
	}

}
