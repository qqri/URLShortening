package com.krkimb.urlproject.service;
import com.krkimb.urlproject.domain.Url;
import com.krkimb.urlproject.web.dto.UrlShortenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UrlShortenService {

    private final UrlShortenResponse urlShortenResponse;
    private final Url url;

    @Transactional(rollback = Exception.class)
    @Override
    public UrlShortenResponse getUrlShorten(String url) {
        if(!url.isEmpty())

    }
}
