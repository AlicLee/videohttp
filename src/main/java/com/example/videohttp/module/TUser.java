package com.example.videohttp.module;

import java.io.Serializable;
import java.util.Date;

public class TUser implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column v_user.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column v_user.userName
     *
     * @mbg.generated
     */
    private String username;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column v_user.userAge
     *
     * @mbg.generated
     */
    private Integer userage;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column v_user.userPhone
     *
     * @mbg.generated
     */
    private String userphone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column v_user.userEmail
     *
     * @mbg.generated
     */
    private String useremail;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column v_user.userPassword
     *
     * @mbg.generated
     */
    private String userpassword;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column v_user.userCreateTime
     *
     * @mbg.generated
     */
    private Date usercreatetime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column v_user.userBirthDay
     *
     * @mbg.generated
     */
    private Date userbirthday;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column v_user.userSex
     *
     * @mbg.generated
     */
    private Boolean usersex;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table v_user
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column v_user.id
     *
     * @return the value of v_user.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column v_user.id
     *
     * @param id the value for v_user.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column v_user.userName
     *
     * @return the value of v_user.userName
     *
     * @mbg.generated
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column v_user.userName
     *
     * @param username the value for v_user.userName
     *
     * @mbg.generated
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column v_user.userAge
     *
     * @return the value of v_user.userAge
     *
     * @mbg.generated
     */
    public Integer getUserage() {
        return userage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column v_user.userAge
     *
     * @param userage the value for v_user.userAge
     *
     * @mbg.generated
     */
    public void setUserage(Integer userage) {
        this.userage = userage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column v_user.userPhone
     *
     * @return the value of v_user.userPhone
     *
     * @mbg.generated
     */
    public String getUserphone() {
        return userphone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column v_user.userPhone
     *
     * @param userphone the value for v_user.userPhone
     *
     * @mbg.generated
     */
    public void setUserphone(String userphone) {
        this.userphone = userphone == null ? null : userphone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column v_user.userEmail
     *
     * @return the value of v_user.userEmail
     *
     * @mbg.generated
     */
    public String getUseremail() {
        return useremail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column v_user.userEmail
     *
     * @param useremail the value for v_user.userEmail
     *
     * @mbg.generated
     */
    public void setUseremail(String useremail) {
        this.useremail = useremail == null ? null : useremail.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column v_user.userPassword
     *
     * @return the value of v_user.userPassword
     *
     * @mbg.generated
     */
    public String getUserpassword() {
        return userpassword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column v_user.userPassword
     *
     * @param userpassword the value for v_user.userPassword
     *
     * @mbg.generated
     */
    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword == null ? null : userpassword.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column v_user.userCreateTime
     *
     * @return the value of v_user.userCreateTime
     *
     * @mbg.generated
     */
    public Date getUsercreatetime() {
        return usercreatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column v_user.userCreateTime
     *
     * @param usercreatetime the value for v_user.userCreateTime
     *
     * @mbg.generated
     */
    public void setUsercreatetime(Date usercreatetime) {
        this.usercreatetime = usercreatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column v_user.userBirthDay
     *
     * @return the value of v_user.userBirthDay
     *
     * @mbg.generated
     */
    public Date getUserbirthday() {
        return userbirthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column v_user.userBirthDay
     *
     * @param userbirthday the value for v_user.userBirthDay
     *
     * @mbg.generated
     */
    public void setUserbirthday(Date userbirthday) {
        this.userbirthday = userbirthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column v_user.userSex
     *
     * @return the value of v_user.userSex
     *
     * @mbg.generated
     */
    public Boolean getUsersex() {
        return usersex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column v_user.userSex
     *
     * @param usersex the value for v_user.userSex
     *
     * @mbg.generated
     */
    public void setUsersex(Boolean usersex) {
        this.usersex = usersex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_user
     *
     * @mbg.generated
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TUser other = (TUser) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getUserage() == null ? other.getUserage() == null : this.getUserage().equals(other.getUserage()))
            && (this.getUserphone() == null ? other.getUserphone() == null : this.getUserphone().equals(other.getUserphone()))
            && (this.getUseremail() == null ? other.getUseremail() == null : this.getUseremail().equals(other.getUseremail()))
            && (this.getUserpassword() == null ? other.getUserpassword() == null : this.getUserpassword().equals(other.getUserpassword()))
            && (this.getUsercreatetime() == null ? other.getUsercreatetime() == null : this.getUsercreatetime().equals(other.getUsercreatetime()))
            && (this.getUserbirthday() == null ? other.getUserbirthday() == null : this.getUserbirthday().equals(other.getUserbirthday()))
            && (this.getUsersex() == null ? other.getUsersex() == null : this.getUsersex().equals(other.getUsersex()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_user
     *
     * @mbg.generated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getUserage() == null) ? 0 : getUserage().hashCode());
        result = prime * result + ((getUserphone() == null) ? 0 : getUserphone().hashCode());
        result = prime * result + ((getUseremail() == null) ? 0 : getUseremail().hashCode());
        result = prime * result + ((getUserpassword() == null) ? 0 : getUserpassword().hashCode());
        result = prime * result + ((getUsercreatetime() == null) ? 0 : getUsercreatetime().hashCode());
        result = prime * result + ((getUserbirthday() == null) ? 0 : getUserbirthday().hashCode());
        result = prime * result + ((getUsersex() == null) ? 0 : getUsersex().hashCode());
        return result;
    }
}