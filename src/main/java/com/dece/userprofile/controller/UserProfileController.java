package com.dece.userprofile.controller;

import com.dece.userprofile.model.UserProfile;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/v1/userprofile")
public class UserProfileController {
    /**
     * CREATE userprofile.
     *
     * @param userProfile
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
    public UserProfile createUserProfile(@RequestBody UserProfile userProfile) {

        UserProfile newUserProfile = new UserProfile();
        // save to database here
        return newUserProfile;
    }
    /**
     * GET all userprofiles.
     *
     * @return
     */
    @ApiOperation(value = "Get All", nickname = "Get All")
    @GetMapping(value = "/")
    @ResponseStatus(HttpStatus.OK)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 400, message = "BadRequest"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 500, message = "InternalServerError"),
            @ApiResponse(code = 503, message = "Service Unavailable")})
    public List<UserProfile> getUserProfiles() {
        List<UserProfile> userProfileList = new ArrayList<>();
        // get from database here
        UserProfile newUserProfile = new UserProfile();
        userProfileList.add(newUserProfile);
        return userProfileList;
    }
    /**
     * GET userprofile by Id.
     *
     * @param uid
     * @return
     */
    @ApiOperation(value = "Get by Id", nickname = "Get by Id")
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
    public UserProfile getUserProfile(@PathVariable String uid) {

        UserProfile userProfile = new UserProfile();
        // get from database here
        return userProfile;
    }
    /**
     * UPDATE existing userprofile.
     *
     * @param uid
     * @param userProfile
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
    public UserProfile updateUserProfile(@PathVariable String uid, @RequestBody UserProfile userProfile) {
        // update object in database here
        return userProfile;
    }
}
