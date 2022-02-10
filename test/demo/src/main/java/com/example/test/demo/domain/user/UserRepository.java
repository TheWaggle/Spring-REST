package com.example.test.demo.domain.user;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.*;

@RepositoryRestResource(collectionResourceRel = "user", path = "user")
public interface UserRepository extends PagingAndSortingRepository<UserEntity, Long> {
    //カスタムクエリの作成
    List<UserEntity> findByName(@Param("name") String name);
    
}
