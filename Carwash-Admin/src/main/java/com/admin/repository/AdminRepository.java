package com.admin.repository;

import com.admin.model.Washpacks;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface AdminRepository extends MongoRepository<Washpacks , Integer> {

    public Washpacks findById(int id);

}
