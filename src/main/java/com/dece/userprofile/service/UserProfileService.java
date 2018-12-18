package com.dece.userprofile.service;

import com.dece.userprofile.dto.UserProfileDTO;
import com.dece.userprofile.factory.UserProfileFactory;
import com.dece.userprofile.model.UserProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserProfileService {

    private final Logger logger = LoggerFactory.getLogger(UserProfileService.class);

    @Autowired
    UserProfileFactory userProfileFactory;

    public UserProfileDTO createUserProfile(UserProfileDTO userProfileDTO) {
        UserProfile userProfile = userProfileFactory.convertUserProfileDTOToUserProfile(userProfileDTO);
        logger.debug("Pretending to make a repository call right now, it's like guaranteed to be 100% successful");

        return userProfileFactory.convertUserProfileToUserProfileDTO(userProfile);

    }
}
