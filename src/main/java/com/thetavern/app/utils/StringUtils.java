/**
 * 
 */
package com.thetavern.app.utils;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author Fernando Nathanael
 *
 */
public class StringUtils {
	
	public static String capitalizeAll(String str) {
	    if (str == null || str.isEmpty()) {
	        return str;
	    }

	    return Arrays.stream(str.split("\\s+"))
	            .map(t -> t.substring(0, 1).toUpperCase() + t.substring(1))
	            .collect(Collectors.joining(" "));
	}

}
