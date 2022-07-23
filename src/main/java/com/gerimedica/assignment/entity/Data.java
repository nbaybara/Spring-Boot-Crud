package com.gerimedica.assignment.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Instant;
import java.util.Date;

@lombok.Data
@Entity
public class Data {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    private String source;
    private String codeListCode;
    private String code;
    private String displayValue;
    private String longDescription;
    private Date fromDate;
    private Date toDate;
    private String sortingPriority;

}
