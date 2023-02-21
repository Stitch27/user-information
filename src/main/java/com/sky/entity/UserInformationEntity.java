package com.sky.entity;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "USER_INFORMATION")
public class UserInformationEntity implements Serializable {

    @Id
    @Column(name = "UI_IDENTIFIER")
    private Long identifier;
    @Column(name = "UI_ACCOUNT")
    private String account;
    @Column(name = "UI_NAME")
    private String name;
    @Column(name = "UI_LAST_NAME")
    private String lastName;
    @Column(name = "UI_EMAIL")
    private String email;
    @Column(name = "UI_CODE")
    private String code;
    @Column(name = "UI_CREATION_DATE")
    private LocalDateTime creationDate;
    @Column(name = "UI_UPDATE_DATE")
    private LocalDateTime updateDate;

}
