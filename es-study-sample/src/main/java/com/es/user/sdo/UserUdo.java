package com.es.user.sdo;

import com.es.share.util.JsonSerializable;
import com.es.user.domain.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserUdo implements JsonSerializable {

    private String name;

    public User toDomain(String userId) {
        return new User(
            userId,
            name
        );
    }

    @Override
    public String toString() {
        return toJson();
    }
}
