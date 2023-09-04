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
public class UserCdo implements JsonSerializable {

    private String userId;

    private String name;

    public User toDomain() {
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
