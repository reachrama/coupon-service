package com.aerospace.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="item_status_t")
@AttributeOverride(name = "id", column = @Column(name = "item_status_id"))
public class ItemStatus extends AbstractEntity<Long> {

    @Column(name="item_status_code")
    private String itemStatusCode;
    @Column(name="item_status_description")
    private String itemStatusDescription;
}
