package com.artsgard.retailapplication.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.convert.QueryByExamplePredicateBuilder;
import org.springframework.data.jpa.domain.Specification;
import javax.persistence.criteria.Predicate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Utils {
    private static final Logger log = LogManager.getLogger(Utils.class);

    public Utils() { }

    public static <S, T> Page<T> transformPage(Page<S> items, Function<S, T> func) {
        List<T> list = (List)items.getContent().stream().map(func).collect(Collectors.toList());
        return new PageImpl(list, PageRequest.of(items.getNumber(), items.getSize()), items.getTotalElements());
    }

    public static <T> Page<T> wrapIntoPage(List<T> list, Pageable pageable, int total) {
        PageImpl page;
        if (pageable == null) {
            page = new PageImpl(list, PageRequest.of(0, total), (long)total);
        } else {
            page = new PageImpl(list, pageable, (long)total);
        }

        return page;
    }
    public static <T> Specification<T> preparedListQuery(Example<T> example) {
        return (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList();
            predicates.add(QueryByExamplePredicateBuilder.getPredicate(root, builder, example));
            return builder.and((Predicate[])predicates.toArray(new Predicate[predicates.size()]));
        };
    }

    public static <T> Specification<T> preparedQuery(Example<T> example) {
        return (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList();
            predicates.add(QueryByExamplePredicateBuilder.getPredicate(root, builder, example));
            return builder.and((Predicate[])predicates.toArray(new Predicate[predicates.size()]));
        };
    }

    public static <T> Specification<T> preparedQueryWithDates(Date startDate, Date endDate, Example<T> example) {
        return (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList();
            if (startDate != null) {
                predicates.add(builder.greaterThan(root.get("dateCreation"), startDate));
            }

            if (endDate != null) {
                predicates.add(builder.lessThan(root.get("dateCreation"), endDate));
            }

            predicates.add(QueryByExamplePredicateBuilder.getPredicate(root, builder, example));
            return builder.and((Predicate[])predicates.toArray(new Predicate[predicates.size()]));
        };
    }

}
