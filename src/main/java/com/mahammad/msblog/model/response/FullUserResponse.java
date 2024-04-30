package com.mahammad.msblog.model.response;

import com.mahammad.msblog.repository.user.UserDao;
import com.mahammad.msblog.repository.user.UserPermissions;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FullUserResponse {

    private UserDao user;
    private UserPermissions permissions;
}
