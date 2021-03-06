package com.caysever.jprops;

import java.util.Properties;

import org.junit.Assert;
import org.junit.Test;

import com.caysever.props4j.Human;
import com.caysever.props4j.core.PropertiesBinder;
import com.caysever.props4j.utils.PropertiesUtils;

public class PropsTest {

	@Test
	public void popupateHumanObjectWithProps4J() throws Exception {

		Properties properties = new Properties();
		PropertiesUtils.loadProperties("properties/test.properties", properties);
		Human human = new Human();
		PropertiesBinder.bind(human, properties);

		// properties file content as follow
		// human.name.length=100,200,300
		// human.genders=male, female, unisex
		// human.locations=istanbul:TR, new york:USA
		// human.codes=istanbul:34, izmir:35
		// human.name=caysever

		Assert.assertEquals("caysever", human.getName());
	}

	@Test
	public void popupateHumanObjectWithPureJava() throws Exception {

		Properties properties = new Properties();
		PropertiesUtils.loadProperties("properties/test.properties", properties);
		Human human = new Human();
		PropertiesBinder.bind(human, properties);

		String humanLengths = properties.getProperty("human.name.length");
		int lengthOfHumanLengthString = humanLengths.split(",").length;
		if (lengthOfHumanLengthString > 0) {
			for (int i = 0; i < lengthOfHumanLengthString; i++) {
				human.getNameLengt()[i] = Integer.valueOf(humanLengths.split(",")[i]);
			}
		}

		String genders = properties.getProperty("human.genders");
		int lengthOfGenders = humanLengths.split(",").length;
		if (lengthOfGenders > 0) {
			for (int i = 0; i < lengthOfGenders; i++) {
				human.getGenders().add(genders.split(",")[i]);
			}
		}

		// and too lines for read props...

		// ----------------------------------
		// properties file content as follow
		// human.name.length=100,200,300
		// human.genders=male, female, unisex
		// human.locations=istanbul:TR, new york:USA
		// human.codes=istanbul:34, izmir:35
		// human.name=caysever

		Assert.assertEquals("caysever", human.getName());
	}
}
