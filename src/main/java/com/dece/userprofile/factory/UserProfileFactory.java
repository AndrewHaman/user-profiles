package com.dece.userprofile.factory;

import com.dece.userprofile.dto.UserProfileDTO;
import com.dece.userprofile.model.UserProfile;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserProfileFactory {
    private final Logger logger = LoggerFactory.getLogger(UserProfileFactory.class);

    private ModelMapper modelMapper;

    @Autowired
    UserProfileFactory(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public UserProfile convertUserProfileDTOToUserProfile(UserProfileDTO userProfileDTO) {
        UserProfile userProfile = new UserProfile();
        modelMapper.map(userProfileDTO, userProfile);
        logger.debug("Starting with UserProfileDTO:  {}", userProfileDTO);
        logger.debug("Ending with UserProfile:  {}", userProfile);
        return userProfile;
    }

    public UserProfileDTO convertUserProfileToUserProfileDTO(UserProfile userProfile) {
        UserProfileDTO userProfileDTO = new UserProfileDTO();
        modelMapper.map(userProfile, userProfileDTO);
        logger.debug("Starting with UserProfile:  {}", userProfile);
        logger.debug("Ending with UserProfileDTO:  {}", userProfileDTO);
        return userProfileDTO;
    }
}
