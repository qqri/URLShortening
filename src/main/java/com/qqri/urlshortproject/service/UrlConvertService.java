package com.qqri.urlshortproject.service;

import com.qqri.urlshortproject.service.dto.ShortUrlResult;


public interface UrlConvertService {

    ShortUrlResult getShortenUrl(String url);
}
