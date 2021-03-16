package com.derellea.domain;

import javax.persistence.Column;
import javax.validation.constraints.Null;
import java.io.Serializable;

public class question implements Serializable {
    @Column(name="qId")
    private int qId;

    private User ask;
    @Column(name="qDate")
    private long qDate;
    @Column(name="qTitle")
    private String qTitle;
    @Column(name="qDesc")
    private String qDesc;
    @Column(name="qPrice")
    private int qPrice;
}
