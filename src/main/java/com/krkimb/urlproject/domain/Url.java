package com.krkimb.urlproject.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 100, nullable = false)
    private String origin_url; //전 url

    @Column(length = 20)
    private String shorten_url; //이후 url

    @Column(length = 20)
    private int req_cnt;

    @Builder
    public Url(Long id, String origin_url, String shorten_url, int req_cnt) {
        this.id = id;
        this.origin_url = origin_url;
        this.shorten_url = shorten_url;
        this.req_cnt = req_cnt;
    }
}
