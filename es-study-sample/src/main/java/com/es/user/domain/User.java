package com.es.user.domain;

import com.es.share.util.JsonSerializable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class User implements JsonSerializable {

    private String userId;

    private String name;

    public void update(User user) {
        this.name = user.getName();
    }

    @Override
    public String toString() {
        return toJson();
    }
}
