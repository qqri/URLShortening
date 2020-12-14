package com.qqri.urlshortproject.domain.entity;

import lombok.Data;
import javax.persistence.*;
import java.math.BigInteger;


@Data
@Entity
@Table(name = "short_url")
public class ShortUrl {

    @Id
    @SequenceGenerator(name="seq_generator", sequenceName = "url_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_generator")
    @Column(name = "seq")
    BigInteger seq;

    @Column(name = "short_url")
    private String shortUrl;

    @Column(name="origin_url", nullable = false)
    private String originUrl;


}
