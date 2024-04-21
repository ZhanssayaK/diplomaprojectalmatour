package com.example.diploma.project.almatour.specification;

import com.example.diploma.project.almatour.dto.AccommodationSearchDTO;
import com.example.diploma.project.almatour.model.Accommodation;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class AccommodationSpecification {
    public static Specification<Accommodation> accommodationSpecification(AccommodationSearchDTO dto) {
        return ((root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (dto.getName() != null && !dto.getName().isEmpty()) {
                predicates.add(builder.like(builder.lower(root.get("name")), "%" + dto.getName().toLowerCase() + "%"));
            }
            if (dto.getCategory() != null && !dto.getCategory().isEmpty()) {
                predicates.add(builder.equal(root.get("categories").get("name"), dto.getCategory()));
            }
            if (dto.getCity() != null && !dto.getCity().isEmpty()) {
                predicates.add(builder.equal(root.get("city").get("name"), dto.getCity()));
            }
            if (dto.getFromDate() != null && dto.getToDate() != null) {
                predicates.add(builder.between(root.get("startTime"), dto.getFromDate(), dto.getToDate()));
            }
            if (dto.getMinPrice() != null && dto.getMaxPrice() != null) {
                predicates.add(builder.between(root.get("price"), dto.getMinPrice(), dto.getMaxPrice()));
            } else if (dto.getMinPrice() != null) {
                predicates.add(builder.greaterThanOrEqualTo(root.get("price"), dto.getMinPrice()));
            } else if (dto.getMaxPrice() != null) {
                predicates.add(builder.lessThanOrEqualTo(root.get("price"), dto.getMaxPrice()));
            }

            return builder.and(predicates.toArray(new Predicate[0]));

        });
    }
}
