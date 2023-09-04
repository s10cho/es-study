package com.es.user.sdo;

import java.util.List;

import com.es.share.util.JsonSerializable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserRdoListRdo implements JsonSerializable {

    private List<UserRdo> list;

    @Override
    public String toString() {
        return toJson();
    }
}
