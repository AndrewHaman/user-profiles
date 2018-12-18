package com.dece.userprofile.controller;

import com.dece.userprofile.dto.UserProfileDTO;
import com.dece.userprofile.service.UserProfileService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/v1/userprofile")
public class UserProfileController {

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
        List<UserProfileDTO> userProfileDTOList = new ArrayList<>();
        // get from database here
        UserProfileDTO newUserProfileDTO = new UserProfileDTO();
        userProfileDTOList.add(newUserProfileDTO);
        return userProfileDTOList;
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
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 500, message = "InternalServerError"),
            @ApiResponse(code = 503, message = "Service Unavailable")})
    public UserProfileDTO getUserProfile(@PathVariable String uid) {

        UserProfileDTO userProfileDTO = new UserProfileDTO();
        // get from database here
        return userProfileDTO;
    }
    /**
     * UPDATE existing userprofile.
     *
     * @param uid
     * @param userProfileDTO
     * @return
     */
    @ApiOperation(value = "Update", nickname = "Update")
    @PutMapping(value = "/{uid}")
    @ResponseStatus(HttpStatus.OK)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 400, message = "BadRequest"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 500, message = "InternalServerError"),
            @ApiResponse(code = 503, message = "Service Unavailable")})
    public UserProfileDTO updateUserProfile(@PathVariable String uid, @RequestBody UserProfileDTO userProfileDTO) {
        // update object in database here
        return userProfileDTO;
    }
}
