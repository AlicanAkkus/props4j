package com.caysever.props4j.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;

public class PropertiesUtils {

	public static synchronized boolean loadProperties(String fileName, Properties props) throws Exception {
		File f = new File(fileName);
		// logger.debug("Loading setings Filename: " + f.getAbsolutePath());
		if (!f.exists()) {
			f = new File(System.getProperty("user.dir") + File.separator + fileName);
		}

		if (f.exists() && !f.isDirectory()) {
			try {
				props.clear();
				FileInputStream fis = new FileInputStream(f);
				props.load(fis);

				fis.close();
			} catch (IOException e) {
				// logger.error(e, e);
				return false;
			}
		} else {
			throw new Exception(fileName + " : File not exist");
		}
		return true;
	}

	public static synchronized boolean getBooleanProperty(Properties props, String propertyKey, boolean defaultValue) {
		boolean propertyValue = defaultValue;
		String stringValue = getPropertyValueAsString(props, propertyKey, String.valueOf(defaultValue));

		if (StringUtils.isNotBlank(stringValue)) {
			propertyValue = stringValue.trim().equalsIgnoreCase("true");
		}
		return propertyValue;
	}

	public static synchronized int getIntegerProperty(Properties props, String propertyKey, int defaultValue) {
		int propertyValue = defaultValue;
		String stringValue = getPropertyValueAsString(props, propertyKey, String.valueOf(defaultValue));
		if (StringUtils.isNotBlank(stringValue)) {
			propertyValue = Integer.parseInt(stringValue.trim());
		}
		return propertyValue;
	}

	public static synchronized double getDoubleProperty(Properties props, String propertyKey, double defaultValue) {
		double propertyValue = defaultValue;
		String stringValue = getPropertyValueAsString(props, propertyKey, String.valueOf(defaultValue));
		if (StringUtils.isNotBlank(stringValue)) {
			propertyValue = Double.parseDouble(stringValue.trim());
		}
		return propertyValue;
	}

	public static synchronized long getLongProperty(Properties props, String propertyKey, long defaultValue) {
		long propertyValue = defaultValue;
		String stringValue = getPropertyValueAsString(props, propertyKey, String.valueOf(defaultValue));
		if (StringUtils.isNotBlank(stringValue)) {
			propertyValue = Long.parseLong(stringValue.trim());
		}
		return propertyValue;
	}

	private static synchronized String getPropertyValueAsString(Properties props, String propertyKey, String defaultValue) {
		String stringValue = defaultValue;
		if (props.containsKey(propertyKey)) {
			stringValue = props.getProperty(propertyKey);
		}
		return stringValue;
	}

	public static synchronized String getStringProperty(Properties props, String propertyKey, String defaultValue) {
		String propertyValue = defaultValue;
		String stringValue = getPropertyValueAsString(props, propertyKey, defaultValue);
		if (StringUtils.isNotBlank(stringValue)) {
			propertyValue = stringValue.trim();
		}
		return propertyValue;
	}

}
