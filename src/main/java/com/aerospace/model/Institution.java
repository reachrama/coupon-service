package com.aerospace.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="institution_t")
@AttributeOverride(name = "id", column = @Column(name = "institution_id"))
public class Institution extends AbstractEntity<Long> {

    @Column(name="institution_name")
    private String institutionName;
    @Column(name="institution_code")
    private String institutionCode;
}
