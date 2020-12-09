package com.krkimb.urlproject.web.dto;

import com.krkimb.urlproject.domain.Url;
import lombok.Data;

@Data
public class UrlShortenResponse {
    private Url url;
    private boolean flag;
}
