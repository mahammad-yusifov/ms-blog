package com.mahammad.msblog.model.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.mahammad.msblog.util.SqlDateDeserializer;
import lombok.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
