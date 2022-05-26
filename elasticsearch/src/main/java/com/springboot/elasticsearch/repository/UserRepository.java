package com.springboot.elasticsearch.repository;

import com.springboot.elasticsearch.entity.UserEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ElasticsearchRepository<UserEntity, Long> {
}
