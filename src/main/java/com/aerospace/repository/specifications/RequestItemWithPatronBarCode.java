package com.aerospace.repository.specifications;

import com.aerospace.model.RequestItem;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class RequestItemWithPatronBarCode implements Specification<RequestItem> {

    private String patronBarCode;

    public RequestItemWithPatronBarCode(String patronBarCode) {
        this.patronBarCode = patronBarCode;
    }

    @Override
    public Predicate toPredicate(Root<RequestItem> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        if (patronBarCode == null) {
            return criteriaBuilder.isTrue(criteriaBuilder.literal(true)); // always true = no filtering
        }
        return criteriaBuilder.equal(root.get("patronBarcode"), this.patronBarCode);
    }
}
