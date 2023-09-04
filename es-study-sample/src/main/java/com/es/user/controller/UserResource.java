package com.es.user.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.es.user.domain.User;
import com.es.user.sdo.UserCdo;
import com.es.user.sdo.UserRdo;
import com.es.user.sdo.UserRdoListRdo;
import com.es.user.sdo.UserUdo;
import com.es.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("users")
public class UserResource {

    private final UserService userService;

    @GetMapping
    public UserRdoListRdo findAll() {
        List<UserRdo> list = userService.findAll().stream()
            .map(UserRdo::new)
            .collect(Collectors.toList());
        return new UserRdoListRdo(list);
    }

    @GetMapping("{userId}")
    public UserRdo find(
        @PathVariable String userId
    ) {
        User user = userService.find(userId);
        return new UserRdo(user);
    }

    @PostMapping
    public void register(
        @RequestBody UserCdo userCdo
    ) {
        User user = userCdo.toDomain();
        userService.register(user);
    }

    @PutMapping("{userId}")
    public void modify(
        @PathVariable String userId,
        @RequestBody UserUdo userUdo
    ) {
        User user = userUdo.toDomain(userId);
        userService.modify(user);
    }

    @DeleteMapping("{userId}")
    public void remove(
        @PathVariable String userId
    ) {
        userService.remove(userId);
    }
}
