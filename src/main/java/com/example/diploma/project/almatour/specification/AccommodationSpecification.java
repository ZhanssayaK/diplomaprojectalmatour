package com.example.diploma.project.almatour.specification;

import com.example.diploma.project.almatour.dto.AccommodationSearchDTO;
import com.example.diploma.project.almatour.model.Accommodation;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class AccommodationSpecification {
    public static Specification<Accommodation> accommodationSpecification(AccommodationSearchDTO dto){
        return ((root, query, builder) -> {
            List<Predicate> predicates=new ArrayList<>();

            if(dto.getName()!=null){
                predicates.add(builder.like(builder.lower(root.get("name")), "%" + dto.getName().toLowerCase() + "%"));
            }
            if (dto.getCategory() != null) {
                predicates.add(builder.equal(root.get("categories").get("name"), dto.getCategory()));
            }
            if (dto.getCity() != null) {
                predicates.add(builder.equal(root.get("city").get("name"), dto.getCity()));
            }
            if (dto.getFromDate() != null && dto.getToDate() != null) {
                predicates.add(builder.between(root.get("startTime"), dto.getFromDate(), dto.getToDate()));
            }
            if (dto.getPrice() != null) {
                predicates.add(builder.equal(root.get("price"), dto.getPrice()));
            }
            return builder.and(predicates.toArray(new Predicate[0]));

        });
    }
}
