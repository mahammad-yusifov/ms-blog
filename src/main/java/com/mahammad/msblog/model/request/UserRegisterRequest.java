package com.mahammad.msblog.model.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.mahammad.msblog.util.SqlDateDeserializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterRequest {

    private String userName;
    private String password;
    private String name;
    private String surname;
    private String phoneNumber;
    private String email;
    private Integer userTypeId;
    @JsonDeserialize(using = SqlDateDeserializer.class)
    private LocalDate birthDate;
}