package com.qqri.urlshortproject.service.dto;

import com.qqri.urlshortproject.domain.entity.ShortUrl;
import lombok.Data;

@Data
public class ShortUrlResult {

    //url Entity
    private ShortUrl shortUrl;
    //result Data
    private ShortUrlType shortUrlType;
    //flag
    private boolean successFlag;
}

