package com.dece.userprofile.model;

import java.util.Date;
import java.util.Objects;

public class UserProfile {
    private String id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private Date creationDate;
    private Date lastUpdated;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserProfile userProfile = (UserProfile) o;
        return Objects.equals(id, userProfile.id) &&
                Objects.equals(username, userProfile.username) &&
                Objects.equals(email, userProfile.email) &&
                Objects.equals(firstName, userProfile.firstName) &&
                Objects.equals(lastName, userProfile.lastName) &&
                Objects.equals(creationDate, userProfile.creationDate) &&
                Objects.equals(lastUpdated, userProfile.lastUpdated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, email, firstName, lastName, creationDate, lastUpdated);
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", creationDate=" + creationDate +
                ", lastUpdated=" + lastUpdated +
                '}';
    }
}
