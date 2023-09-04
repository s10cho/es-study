package com.es.user.repository;

import com.es.user.doc.UserDoc;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ElasticsearchRepository<UserDoc, String> {
}
