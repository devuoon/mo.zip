package com.mozip.dto.req.member;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class FindPwDto {
    @NotBlank(message = "이름은 필수입니다!")
    @Size(min = 2, max = 5)
    String username;

    @NotBlank(message = "이메일은 필수입니다!")
    @Email
    String email;

    @NotBlank(message = "전화번호는 필수입니다!")
    @Pattern(regexp = "^[0-9]{3}[0-9]{4}[0-9]{4}")
    String phone;
}