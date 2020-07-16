package com.aerospace.repository.specifications;

import com.aerospace.model.RequestItem;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class RequestItemWithItemBarCode implements Specification<RequestItem> {

    private String itemBarCode;

    public RequestItemWithItemBarCode(String itemBarCode) {
        this.itemBarCode = itemBarCode;
    }

    @Override
    public Predicate toPredicate(Root<RequestItem> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        if (itemBarCode == null) {
            return criteriaBuilder.isTrue(criteriaBuilder.literal(true)); // always true = no filtering
        }
        return criteriaBuilder.equal(root.get("itemBarcode"), this.itemBarCode);
    }
}
