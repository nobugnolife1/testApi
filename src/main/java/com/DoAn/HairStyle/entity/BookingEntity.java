package com.DoAn.HairStyle.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = "booking")
public class BookingEntity {
    @Id
    @GeneratedValue
    private String id;
    @Column
    @NotBlank
    private String numberPhone;
    @Column
    @NotBlank
    private String status;
    @Column
    @NotBlank
    private String address;
    @Column
    @NotBlank
    private Date timeBooked;
    // Liên kết với nhau qua khóa ngoại Token
    @OneToOne
    @JoinColumn(name = "token")
    private UserEntity User;
}
