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
public class UserRdo implements JsonSerializable {

    private String userId;

    private String name;

    public UserRdo(User user) {
        this.userId = user.getUserId();
        this.name = user.getName();
    }

    @Override
    public String toString() {
        return toJson();
    }
}
