package com.iochord.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
public class Users {

    @NotNull
    @Size(min=2, max=6, message = "Size Error of userName 성 포함 최소 2자 최대 6자여야합니다")
    String userName;

    @NotNull
    @NotBlank(message = "Blank Error of userEmail 이메일을 입력하세요")
    @Size(max=30, message = "Size Error of userEmail 이메일 도메인 포함 최대 30자 이하여야합니다")
    @Email(message = "Pattern error of userEmail 이메일 형식을 올바르게 입력하세요")
    String userEmail;

    @NotNull
    @NotBlank(message = " Blank Error of userPhone 전화번호를 입력하세요")
    @Pattern(regexp = "^01(?:[0-9])(\\d{3}|\\d{4})(\\d{4})$", message = "Pattern error of userPhone 전화번호는 숫자로만 입력하고, 10~11자여야 합니다.")
    String userPhone;

    @NotNull
    @Min(value=0, message="Minimum error of userAge 나이는 최소 0살 이상이어야 합니다")
    @Max(value=120, message="Maximum error of userAge 나이는 최대 120살 이하여야 합니다")
    int userAge;
}
