package com.admin.repository;

import com.admin.model.WasherLeaderboard;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WasherLeaderboardRepository extends MongoRepository<WasherLeaderboard,Integer> {


    WasherLeaderboard findById(int rank);
}
