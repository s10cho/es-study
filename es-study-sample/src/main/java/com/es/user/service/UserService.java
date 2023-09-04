package com.es.user.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.es.user.doc.UserDoc;
import com.es.user.domain.User;
import com.es.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> findAll() {
        log.info("findAll");
        return StreamSupport.stream(userRepository.findAll().spliterator(), false)
            .map(UserDoc::toDomain)
            .collect(Collectors.toList());
    }

    public User find(String userId) {
        log.info("find {}", userId);
        return userRepository.findById(userId)
            .map(UserDoc::toDomain)
            .orElseThrow(() -> new NoSuchElementException("Not found user. userId: " + userId));
    }

    public void register(User user) {
        log.info("register {}", user);
        userRepository.save(new UserDoc(user));
    }

    public void modify(User user) {
        log.info("modify {}", user);
        User findUser = find(user.getUserId());
        findUser.update(user);
        userRepository.save(new UserDoc(findUser));
    }

    public void remove(String userId) {
        log.info("remove {}", userId);
        userRepository.deleteById(userId);
    }
}
