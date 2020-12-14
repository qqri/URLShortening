package com.qqri.urlshortproject.service.module;

import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.stereotype.Component;

@Component
public class CommonUtils {


    public boolean urlValCheck(String urlStr){
        return new UrlValidator().isValid(urlStr);
    }
}
