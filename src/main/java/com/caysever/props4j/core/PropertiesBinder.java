package com.caysever.props4j.core;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;

import com.caysever.props4j.annotations.Props4J;
import com.caysever.props4j.enums.FieldType;
import com.caysever.props4j.utils.PropertiesUtils;

public class PropertiesBinder {

	@SuppressWarnings("unchecked")
	public synchronized static boolean bind(Object object, Properties props) throws Exception {

		try {
			// locking class or object
			synchronized (PropertiesBinder.class) {
				Class<?> objectClass = object.getClass();// get class type

				// get all declared fields on object
				for (Field field : objectClass.getDeclaredFields()) {
					field.setAccessible(true);// for private field

					Class<?> typeOfField = field.getType();// get field type, such as int, double etc..
					FieldType fieldType = FieldType.getFieldType(typeOfField.getName());// find type

					Props4J props4j = field.getAnnotation(Props4J.class);// get only props4j annotations

					if (props4j != null) {
						String key = props4j.key();// get key
						String defaultVal = props4j.defaultValue();// get default value
						String comma = props4j.comma();// get comma value for list, set, map etc.
						String delimiter = props4j.delimiter();// delimiter for map and etc types.

						// simple int field
						if (FieldType.INTEGER == fieldType) {
							Integer value = PropertiesUtils.getIntegerProperty(props, key, Integer.valueOf(defaultVal));
							field.set(object, value);
						}

						// simple int[] array field
						if (FieldType.INTEGER_A == fieldType) {
							String value = PropertiesUtils.getStringProperty(props, key, defaultVal);

							if (StringUtils.isNotBlank(value)) {
								String[] arrayOfValue = value.split(comma);
								int[] integerArray = (int[]) field.get(object);
								integerArray = new int[arrayOfValue.length];

								for (int i = 0; i < integerArray.length; i++) {
									integerArray[i] = Integer.valueOf(arrayOfValue[i]);
								}
								field.set(object, integerArray);
							}
						}

						// simple string field
						if (FieldType.STRING == fieldType) {
							String value = PropertiesUtils.getStringProperty(props, key, defaultVal);
							field.set(object, value);
						}

						// simple string field
						if (FieldType.STRING_A == fieldType) {
							String value = PropertiesUtils.getStringProperty(props, key, defaultVal);
							String[] arrayOfValue = value.split(comma);
							String[] stringArray = (String[]) field.get(object);
							stringArray = new String[arrayOfValue.length];

							for (int i = 0; i < stringArray.length; i++) {
								stringArray[i] = arrayOfValue[i];
							}
							field.set(object, stringArray);
						}

						if (FieldType.LIST == fieldType) {
							String listValue = PropertiesUtils.getStringProperty(props, key, defaultVal);
							List<Object> list = (List<Object>) field.get(object);
							for (String s : listValue.split(comma)) {
								list.add(s);
							}
						}

						if (FieldType.BOOLEAN == fieldType) {
							Boolean booleanValue = PropertiesUtils.getBooleanProperty(props, key, Boolean.valueOf(defaultVal));
							field.set(object, booleanValue);
						}

						if (FieldType.MAP == fieldType) {
							String listValue = PropertiesUtils.getStringProperty(props, key, defaultVal);
							Map<Object, Object> map = (Map<Object, Object>) field.get(object);
							for (String s : listValue.split(comma)) {
								map.put(s.split(delimiter)[0], s.split(delimiter)[1]);
							}
						}

					}// end of props4j null check

				}// end of declared fields loop

			}// end of sync block

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
