package com.aerospace.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="requestitem")
public class RequestItem  extends  AbstractEntity<Long>{

    @Column(name="patron_barcode")
    public String patronBarcode;
    @Column(name="item_barcode")
    public String itemBarcode;
    public String institution;
    public boolean status;
    @Column(name="patron_name")
    public String patronName;

}
