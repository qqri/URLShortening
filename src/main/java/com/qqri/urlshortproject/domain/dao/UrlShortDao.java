package com.qqri.urlshortproject.domain.dao;

import com.qqri.urlshortproject.domain.repository.ShortUrlRepository;
import com.qqri.urlshortproject.domain.entity.ShortUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UrlShortDao {

    private final ShortUrlRepository shortUrlRepository;

    @Autowired
    public UrlShortDao(ShortUrlRepository shortUrlRepository){
        this.shortUrlRepository = shortUrlRepository;
    }


    public boolean exists(String url){
        return shortUrlRepository.existsByShortUrlOrOriginUrl(url, url);
    }


    public ShortUrl findByUrl(String url){
        return shortUrlRepository.findFirstByShortUrlOrOriginUrlOrderBySeqDesc(url, url);
    }


    public ShortUrl save(ShortUrl shortUrl){
        return shortUrlRepository.save(shortUrl);
    }

}
