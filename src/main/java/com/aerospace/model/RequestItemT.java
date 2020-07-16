package com.aerospace.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="request_item_t")
@AttributeOverride(name = "id", column = @Column(name = "request_item_id"))
public class RequestItemT  extends AbstractEntity<Long> {

    @Column(name="item_id")
    private Long itemId;
    @Column(name="request_type_id")
    private Long requestTypeId;
    @Column(name="patron_id")
    private Long patronId;
    @Column(name="requesting_inst_id")
    private Long requestingInstId;
    @Column(name="request_status_id")
    private Long requestStatusId;

}
