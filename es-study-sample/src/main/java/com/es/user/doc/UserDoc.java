package com.es.user.doc;

import com.es.user.domain.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "es-study-user")
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDoc {

    @Id
    private String userId;

    private String name;

    public UserDoc(User user) {
        this.userId = user.getUserId();
        this.name = user.getName();
    }

    public User toDomain() {
        return new User(
            userId,
            name
        );
    }
}
