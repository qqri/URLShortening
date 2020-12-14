package com.qqri.urlshortproject.service.impl;

import com.qqri.urlshortproject.service.UrlConvertService;
import com.qqri.urlshortproject.service.module.CommonUtils;
import com.qqri.urlshortproject.domain.dao.UrlShortDao;
import com.qqri.urlshortproject.domain.entity.ShortUrl;
import com.qqri.urlshortproject.service.module.UrlEncoder;
import com.qqri.urlshortproject.service.dto.ShortUrlResult;
import com.qqri.urlshortproject.service.dto.ShortUrlType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service("urlConvertService")
@RequiredArgsConstructor
public class UrlConvertServiceImpl implements UrlConvertService {

    private final CommonUtils commonUtils;
    private final UrlEncoder urlEncoder;
    private final UrlShortDao urlShortDao;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ShortUrlResult getShortenUrl(String url) {
        ShortUrlResult shortUrlResult = new ShortUrlResult();

        ShortUrl shortUrl = new ShortUrl();
        if(!url.isEmpty() && commonUtils.urlValCheck(url)){

            if(urlShortDao.exists(url)){
                shortUrl = urlShortDao.findByUrl(url);
                shortUrlResult.setShortUrlType(shortUrl.getShortUrl().equals(url) ? ShortUrlType.ORIGIN:ShortUrlType.SHORT);

                shortUrlResult.setShortUrl(shortUrl);
                shortUrlResult.setShortUrlType(ShortUrlType.ORIGIN);

            }else{

                ShortUrl curShortUrl = new ShortUrl();
                curShortUrl.setOriginUrl(url);
                shortUrl =  urlShortDao.save(curShortUrl);
                String encodeUrl = "";
                try{
                    encodeUrl = encodingUrl(String.valueOf(shortUrl.getSeq()));
                }catch(Exception e){
                    e.printStackTrace();
                }finally {
                    shortUrl.setShortUrl(encodeUrl);
                }
                shortUrlResult.setShortUrl(shortUrl);
                shortUrlResult.setShortUrlType(ShortUrlType.SHORT);
            }
            shortUrlResult.setSuccessFlag(true);
        }
        return shortUrlResult;
    }

    private String encodingUrl(String seqStr) throws Exception{
        return urlEncoder.urlEncoder(seqStr);
    }
}
