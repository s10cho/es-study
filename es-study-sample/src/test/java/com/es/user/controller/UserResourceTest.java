package com.es.user.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import com.es.user.sdo.UserCdo;
import com.es.user.sdo.UserRdo;
import com.es.user.sdo.UserRdoListRdo;
import com.es.user.sdo.UserUdo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class UserResourceTest {

    @Autowired
    UserResource userResource;

    @Test
    void crudTest() {
        String userId = "hong";

        // register
        userResource.register(new UserCdo(userId, "홍길동"));

        UserRdo user01 = userResource.find(userId);
        List<UserRdo> list01 = userResource.findAll().getList();

        assertThat(user01.getUserId()).isEqualTo(userId);
        assertThat(user01.getName()).isEqualTo("홍길동");
        assertThat(list01).hasSize(1);

        // modify
        userResource.modify(userId, new UserUdo("김길동"));

        UserRdo user02 = userResource.find(userId);
        List<UserRdo> list02 = userResource.findAll().getList();

        assertThat(user02.getUserId()).isEqualTo(userId);
        assertThat(user02.getName()).isEqualTo("김길동");
        assertThat(list02).hasSize(1);

        // remove
        userResource.remove(userId);

        List<UserRdo> list03 = userResource.findAll().getList();

        assertThat(list03).isEmpty();
    }
}
