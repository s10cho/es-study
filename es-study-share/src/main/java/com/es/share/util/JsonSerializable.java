package com.es.share.util;

import java.io.Serializable;

public interface JsonSerializable extends Serializable {
    default String toJson() {
        return JsonUtil.toJson(this);
    }
}
