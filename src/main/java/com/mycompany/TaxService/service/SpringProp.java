package com.mycompany.TaxService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.config.environment.Environment;
import org.springframework.cloud.config.environment.PropertySource;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

@Service
@RefreshScope
public class SpringProp {
	
	
	
	
	public String getProp(String key) {
		Environment env = null;
		String res = null;
		for(PropertySource src : env.getPropertySources()) {
			res = (String) src.getSource().get(key);
		}
		return res;
	}

}
