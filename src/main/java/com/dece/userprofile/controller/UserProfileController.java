package com.dece.userprofile.controller;

import com.dece.userprofile.dto.UserProfileDTO;
import com.dece.userprofile.service.UserProfileService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/userprofile")
public class UserProfileController {

    private final Logger logger = LoggerFactory.getLogger(UserProfileController.class);


    @Autowired
    UserProfileService userProfileService;
    /**
     * CREATE userprofile.
     *
     * @param userProfileDTO
     * @return
     */
    @ApiOperation(value = "Create", nickname = "Create")
    @PostMapping(value = "/")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 400, message = "BadRequest"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 500, message = "InternalServerError"),
            @ApiResponse(code = 503, message = "Service Unavailable")})
    public UserProfileDTO createUserProfile(@RequestBody UserProfileDTO userProfileDTO) {
        // save to database here

        logger.info("Id =  {}", userProfileDTO.getId());
        return userProfileService.createUserProfile(userProfileDTO);
    }
    /**
     * GET all userprofiles.
     *
     * @return
     */
    @ApiOperation(value = "GetAll", nickname = "GetAll")
    @GetMapping(value = "/")
    @ResponseStatus(HttpStatus.OK)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 400, message = "BadRequest"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 500, message = "InternalServerError"),
            @ApiResponse(code = 503, message = "Service Unavailable")})
    public List<UserProfileDTO> getUserProfiles() {

        return userProfileService.getAllUserProfiles();
    }
    /**
     * GET userprofile by Id.
     *
     * @param uid
     * @return
     */
    @ApiOperation(value = "GetById", nickname = "GetById")
    @GetMapping(value = "/{uid}")
    @ResponseStatus(HttpStatus.OK)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 400, message = "BadRequest"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "InternalServerError"),
            @ApiResponse(code = 503, message = "Service Unavailable")})
    public UserProfileDTO getUserProfile(@PathVariable String uid) {


        // get from database here
        return userProfileService.getUserProfileById(uid);
    }
    /**
     * UPDATE existing userprofile.
     *
     * @param userProfileDTO
     * @return
     */
    @ApiOperation(value = "Update", nickname = "Update")
    @PutMapping(value = "/")
    @ResponseStatus(HttpStatus.OK)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 400, message = "BadRequest"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "InternalServerError"),
            @ApiResponse(code = 503, message = "Service Unavailable")})
    public UserProfileDTO updateUserProfile(@RequestBody UserProfileDTO userProfileDTO) {
        return userProfileService.updateUserProfile(userProfileDTO);
    }
}
