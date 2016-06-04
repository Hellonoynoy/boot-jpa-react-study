package com.noynoy.repository.menu.support;

import com.noynoy.domain.menu.Menu;
import com.noynoy.repository.QueryDslSupport;
import org.springframework.stereotype.Repository;

/**
 * Created by noynoy on 2016. 6. 4..
 */
@Repository
public class MenuRepositorySupportImpl extends QueryDslSupport implements MenuRepositorySupport {

    public MenuRepositorySupportImpl() {
        super(Menu.class);
    }

}
