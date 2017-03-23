package com.caysever.props4j.enums;

public enum FieldType {
	BOOLEAN("boolean"), BOOLEAN_A("[Z"), BOOLEAN_W("java.lang.Boolean"), BOOLEAN_WA("[Ljava.lang.Boolean;"), INTEGER("int"), INTEGER_A("[I"), INTEGER_W(
			"java.lang.Integer"), INTEGER_WA("[Ljava.lang.Integer;"), STRING("java.lang.String"), STRING_A("[Ljava.lang.String;"), DOUBLE("double"), DOUBLE_A(
			"[D"), DOUBLE_W("java.lang.Double"), DOUBLE_WA("[Ljava.lang.Double;"), FLOAT("float"), FLOAT_A("[F"), FLOAT_W("java.lang.Float"), FLOAT_WA(
			"[Ljava.lang.Float;"), CHAR("char"), CHAR_A("[C"), CHAR_W("java.lang.Char"), CHAR_WA("[Ljava.lang.Char;"), LIST("java.util.List"), SET(
			"java.util.Set"), MAP("java.util.Map");

	private String type;

	private FieldType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public static FieldType getFieldType(String type) {
		switch (type) {
		case "boolean":
			return BOOLEAN;
		case "java.lang.Boolean":
			return BOOLEAN;
		case "[Z":
			return BOOLEAN_A;
		case "[Ljava.lang.Boolean;":
			return BOOLEAN_WA;
		case "int":
			return INTEGER;
		case "java.lang.Integer":
			return INTEGER;
		case "[I":
			return INTEGER_A;
		case "[Ljava.lang.Integer;":
			return INTEGER_WA;
		case "java.lang.String":
			return STRING;
		case "[Ljava.lang.String;":
			return STRING_A;
		case "double":
			return DOUBLE;
		case "java.lang.Double":
			return DOUBLE;
		case "float":
			return FLOAT;
		case "java.lang.Float":
			return FLOAT;
		case "char":
			return CHAR;
		case "java.lang.Char":
			return CHAR;
		case "java.util.List":
			return LIST;
		case "java.util.Set":
			return SET;
		case "java.util.Map":
			return MAP;
		default:
			throw new RuntimeException("Unsupported (" + type + ") type!");
		}
	}
}
