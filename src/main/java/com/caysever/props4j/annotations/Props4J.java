package com.caysever.props4j.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
public @interface Props4J {

	String key() default "";

	String defaultValue() default "";

	String comma() default ",";

	String delimiter() default ":";

}
