/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lemonhexa.web.route;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Ploychompoo
 */
public class ZkRoute {
	private String url;
	private String view;
	private Pattern urlPattern;
	private Map<Integer, String> pathVariables = new HashMap<Integer, String>();
  
	public ZkRoute(String url, String view) {
		this.url = url;
		this.view = view;
		resolveUrlPattern(url);
	}

	private void resolveUrlPattern(String url) {
		String urlRegexp = url.replaceAll("\\{[a-zA-Z0-9:]+?\\}", "([^/\\]+)");
		urlPattern = Pattern.compile(urlRegexp);

		String varPatternRegexp = url.replaceAll("\\{[a-zA-Z0-9:]+?\\}", "\\\\{([a-zA-Z0-9:]+)\\\\}");
		Pattern varPattern = Pattern.compile(varPatternRegexp);
		Matcher varMatcher = varPattern.matcher(url);
		if (varMatcher.matches() && varMatcher.groupCount() >= 1) {
			for (int i = 1; i <= varMatcher.groupCount(); i++) {
				String varGroup = varMatcher.group(i);
				registerVariable(varGroup, i);
			}
		}
	}

	private void registerVariable(String varGroup, int groupNumber) {
		String[] parts = varGroup.split(":");
		if(parts.length > 2) {
			throw new IllegalArgumentException("Cannot parse variable " + varGroup + ". Expected input is 'varName[:varType]'!");
		}
		String varName = parts[0].trim();
		pathVariables.put(groupNumber, varName);
	}

	public String getUrl() {
		return url;
	}

	public String getView() {
		return view;
	}

	public boolean matches(String url) {
		if (urlPattern.matcher(url).matches()) {
			return true;
		}
		return false;
	}

	public Map<String, Object> resolvePathVariables(String url) {
		Map<String, Object> pathVariables = new HashMap<String, Object>();
		Matcher matcher = urlPattern.matcher(url);
		if (matcher.matches() && matcher.groupCount() >= 1) {
			for (int i = 1; i <= matcher.groupCount(); i++) {
				String varGroup = matcher.group(i);
				String pathVariable = this.pathVariables.get(i);
				Object value = varGroup;
				pathVariables.put(pathVariable, value);
			}
		}
		return pathVariables;
	}    
}
