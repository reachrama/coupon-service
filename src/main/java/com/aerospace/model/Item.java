package com.aerospace.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "item_t")
@AttributeOverride(name = "id", column = @Column(name = "item_id"))
@Getter
@Setter
public class Item extends AbstractEntity<Long> {

    @Column(name = "barcode")
    private String barcode;
    @Column(name = "owning_inst_id")
    private Long owningInstId;
    @Column(name = "item_available_status_id")
    private Long itemAvailableStatusId;
    @Column(name = "item_name")
    private String itemName;

}
