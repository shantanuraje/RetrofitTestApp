package com.example.shantanuraje.testrerofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shantanuraje on 11-08-2015.
 */
public class Player {

    @SerializedName("_id")
    @Expose
    private String Id;
    @SerializedName("_rev")
    @Expose
    private String Rev;
    @Expose
    private String emailID;
    @Expose
    private String userName;
    @Expose
    private String password;
    @Expose
    private String contactNo;
    @Expose
    private List<String> location = new ArrayList<String>();
    @Expose
    private String area;
    @Expose
    private String city;
    @Expose
    private String state;
    @Expose
    private String country;
    @Expose
    private List<String> sports = new ArrayList<String>();

    /**
     *
     * @return
     * The Id
     */
    public String getId() {
        return Id;
    }

    /**
     *
     * @param Id
     * The _id
     */
    public void setId(String Id) {
        this.Id = Id;
    }

    /**
     *
     * @return
     * The Rev
     */
    public String getRev() {
        return Rev;
    }

    /**
     *
     * @param Rev
     * The _rev
     */
    public void setRev(String Rev) {
        this.Rev = Rev;
    }

    /**
     *
     * @return
     * The emailID
     */
    public String getEmailID() {
        return emailID;
    }

    /**
     *
     * @param emailID
     * The emailID
     */
    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    /**
     *
     * @return
     * The userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     *
     * @param userName
     * The userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     *
     * @return
     * The password
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     * The password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return
     * The contactNo
     */
    public String getContactNo() {
        return contactNo;
    }

    /**
     *
     * @param contactNo
     * The contactNo
     */
    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    /**
     *
     * @return
     * The location
     */
    public List<String> getLocation() {
        return location;
    }

    /**
     *
     * @param location
     * The location
     */
    public void setLocation(List<String> location) {
        this.location = location;
    }

    /**
     *
     * @return
     * The area
     */
    public String getArea() {
        return area;
    }

    /**
     *
     * @param area
     * The area
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     *
     * @return
     * The city
     */
    public String getCity() {
        return city;
    }

    /**
     *
     * @param city
     * The city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     *
     * @return
     * The state
     */
    public String getState() {
        return state;
    }

    /**
     *
     * @param state
     * The state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     *
     * @return
     * The country
     */
    public String getCountry() {
        return country;
    }

    /**
     *
     * @param country
     * The country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     *
     * @return
     * The sports
     */
    public List<String> getSports() {
        return sports;
    }

    /**
     *
     * @param sports
     * The sports
     */
    public void setSports(List<String> sports) {
        this.sports = sports;
    }


}
