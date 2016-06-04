package com.noynoy.repository;

import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.path.EntityPathBase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import org.springframework.data.querydsl.QPageRequest;

import java.util.Collections;
import java.util.List;

/**
 * Created by noynoy on 2016. 6. 4..
 */
public class QueryDslSupport <E, Q extends EntityPathBase<E>> extends QueryDslRepositorySupport {

    public QueryDslSupport(Class<?> domainClass) {
        super(domainClass);
    }

    protected Page<E> readPage(JPAQuery query, Q qEntity, Pageable pageable) {

        if (pageable == null) {
            return readPage(query, qEntity, new QPageRequest(0, Integer.MAX_VALUE));
        }

        long total = query.clone(super.getEntityManager()).count();

        List<E> content = total > pageable.getOffset() ? getQuerydsl().applyPagination(pageable, query).list(qEntity) : Collections.<E> emptyList();
        return new PageImpl<E>(content, pageable, total);
    }

}
