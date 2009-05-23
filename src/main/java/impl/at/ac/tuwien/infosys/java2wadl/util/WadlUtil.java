package at.ac.tuwien.infosys.java2wadl.util;

import at.ac.tuwien.infosys.java2wadl.wadl.HTTPMethod;
import at.ac.tuwien.infosys.java2wadl.wadl.ParamStyle;

public class WadlUtil {
	public static HTTPMethod toHttpMethod(String value) {
		if (value.equals("DELETE")) {
			return HTTPMethod.DELETE;
		} else if (value.equals("GET")) {
			return HTTPMethod.GET;
		} else if (value.equals("POST")) {
			return HTTPMethod.POST;
		} else if (value.equals("PUT")) {
			return HTTPMethod.PUT;
		} else if (value.equals("HEAD")) {
			return HTTPMethod.HEAD;
		} else {
			return null;
		}
	}

	public static ParamStyle toParamStyle(String value) {
		if ("plain".equals(value)) {
			return ParamStyle.plain;
		} else if ("query".equals(value)) {
			return ParamStyle.query;
		} else if ("matrix".equals(value)) {
			return ParamStyle.matrix;
		} else if ("header".equals(value)) {
			return ParamStyle.header;
		} else if ("template".equals(value)) {
			return ParamStyle.template;
		} else {
			return null;
		}
	}
}
