package com.dece.userprofile.service;

import com.dece.userprofile.dto.UserProfileDTO;
import com.dece.userprofile.factory.UserProfileFactory;
import com.dece.userprofile.model.UserProfile;
import com.dece.userprofile.repository.UserProfileRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


@Service
public class UserProfileService {

    private final Logger logger = LoggerFactory.getLogger(UserProfileService.class);

    @Autowired
    private UserProfileFactory userProfileFactory;

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Autowired
    private EntityManager entityManager;

    // create
    @Transactional
    public UserProfileDTO createUserProfile(UserProfileDTO userProfileDTO) {
        UserProfile userProfile = userProfileFactory.convertUserProfileDTOToUserProfile(userProfileDTO);
        entityManager.persist(userProfile);
        return userProfileFactory.convertUserProfileToUserProfileDTO(userProfile);

    }
    // get all
    public List<UserProfileDTO> getAllUserProfiles() {
        List<UserProfileDTO> userProfileDTOList = new ArrayList<>();
        List<UserProfile> userProfileList = userProfileRepository.findAll();


        for(UserProfile userProfile : userProfileList) {
            UserProfileDTO userProfileDTO = userProfileFactory.convertUserProfileToUserProfileDTO(userProfile);
            userProfileDTOList.add(userProfileDTO);
        }

        return userProfileDTOList;
    }
    // get by id
    public UserProfileDTO getUserProfileById(String uid) {
        UserProfile userProfile = userProfileRepository.findByUserProfileId(uid);
        if (userProfile == null) {
            logger.debug("No UserProfile found for uid:  {}", uid);
            throw new NoSuchElementException();
        }
        logger.info("UserProfile Found!   {}", userProfile);
        UserProfileDTO userProfileDTO = userProfileFactory.convertUserProfileToUserProfileDTO(userProfile);

        return userProfileDTO;
    }
    // update
    @Transactional
    public UserProfileDTO updateUserProfile(UserProfileDTO userProfileDTO) {
        UserProfile userProfile = userProfileRepository.findByUserProfileId(userProfileDTO.getId());

        if (userProfile == null) {
            logger.debug("No UserProfile found for uid:  {}", userProfileDTO.getId());
            throw new NoSuchElementException();
        }
        // retain original created date
        userProfileDTO.setCreationDate(userProfile.getCreationDate());

        UserProfile updatedUserProfile = userProfileFactory.convertUserProfileDTOToUserProfile(userProfileDTO);
        entityManager.merge(updatedUserProfile);

        return userProfileFactory.convertUserProfileToUserProfileDTO(updatedUserProfile);
    }
}
