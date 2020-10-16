package com.DoAn.HairStyle.entity;

import com.DoAn.HairStyle.entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "blog")
public class BlogEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long blogID;
    @Column
    @NotBlank
    private String title;
    @Column
    @NotBlank
    private String tag;
    @Column
    private Date time;
    @Column
    @NotBlank
    private String description;
    @Column
    @NotBlank
    private String thumbnail;
    @Column
    @NotBlank
    private String content;
    @Column
    @NotBlank
    private String link;


    public UserEntity getUser() {
        return User;
    }

    public void setUser(UserEntity user) {
        User = user;
    }

//    public void setToken(String token) {
//        this.token = token;
//    }
//
//    public String getToken() {
//        return token;
//    }


    // Liên kết với nhau qua khóa ngoại Token
//    @OneToOne
//    @JoinColumn(name = "token")
//    private UserEntity User;



    @ManyToOne
    @JoinColumn(name = "token", referencedColumnName = "token")
    private UserEntity User;

//    @JoinColumn(name = "token")
//    @ManyToOne(targetEntity = UserEntity.class, fetch = FetchType.LAZY)
//    private UserEntity User;
//    @Column(name = "token")
//    private String token;
    public void setBlogID(Long blogID) {
        this.blogID = blogID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setLink(String link) {
        this.link = link;
    }



    public Long getBlogID() {
        return blogID;
    }

    public String getTitle() {
        return title;
    }

    public String getTag() {
        return tag;
    }

    public Date getTime() {
        return time;
    }

    public String getDescription() {
        return description;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getContent() {
        return content;
    }

    public String getLink() {
        return link;
    }


}
