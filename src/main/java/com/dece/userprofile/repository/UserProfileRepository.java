package com.dece.userprofile.repository;

import com.dece.userprofile.model.UserProfile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserProfileRepository extends CrudRepository<UserProfile, Integer> {
    UserProfile findByUserProfileId(String uid);

    List<UserProfile> findAll();
}
