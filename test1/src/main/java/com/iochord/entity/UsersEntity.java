package com.iochord.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Data
@NoArgsConstructor
@Table(name="users")
public class UsersEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int userIdx;

    @NotNull
    @Size(min=2, max=6, message = "이름은 성 포함 최소 2자 최대 6자여야합니다")
    @Column
    String userName;

    @NotNull
    @NotBlank(message = "이메일을 입력하세요")
    @Size(max=30, message = "이메일 도메인 포함 최대 30자 이하여야합니다")
    @Email
    @Column
    String userEmail;

    @NotNull
    @NotBlank(message = "전화번호를 입력하세요")
    @Pattern(regexp = "^01(?:[0-9])(\\d{3}|\\d{4})(\\d{4})$", message = "전화번호는 숫자로만 입력하고, 10~11자여야 합니다.")
    @Column
    String userPhone;

    @NotNull
    @Min(value=0, message="나이는 최소 0살 이상이어야 합니다")
    @Max(value=120, message="나이는 최대 120살 이하여야 합니다")
    @Column
    int userAge;
}
