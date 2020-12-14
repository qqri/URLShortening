package com.qqri.urlshortproject.domain.repository;

import com.qqri.urlshortproject.domain.entity.ShortUrl;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ShortUrlRepository extends JpaRepository<ShortUrl, Long> {

    ShortUrl findFirstByShortUrlOrOriginUrlOrderBySeqDesc(String short_url, String origin_url);
    boolean existsByShortUrlOrOriginUrl(String short_url, String origin_url);
}
