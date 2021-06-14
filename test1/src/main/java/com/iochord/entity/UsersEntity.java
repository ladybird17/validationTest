package com.iochord.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name="users")
public class UsersEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int userIdx;

    @Column
    String userName;

    @Column
    String userEmail;

    @Column
    String userPhone;

    @Column
    int userAge;
}
