package com.qqri.urlshortproject.controller;

import com.qqri.urlshortproject.service.UrlConvertService;
import com.qqri.urlshortproject.service.dto.ShortUrlResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin
@RestController
public class ConvertController {

    private final UrlConvertService urlConvertService;

    @Autowired
    public ConvertController(UrlConvertService urlConvertService){
        this.urlConvertService = urlConvertService;
    }

    @GetMapping(value = "/api/shorturl", produces = {"application/json"})
    @ResponseBody
    ShortUrlResult convert(@RequestParam(defaultValue = "") String urlStr) {
        return urlConvertService.getShortenUrl(urlStr.trim());
    }
}
