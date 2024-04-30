package com.mahammad.msblog.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserDao, Integer> {

    Optional<UserDao> findByUserName(String userName);

    @Query(value = "select ct3.name as permission, ct2.name as userType, ct2.status\n" +
            "from user_type_permission ct1\n" +
            "         join user_type ct2 on ct2.id = ct1.user_type_id\n" +
            "         join permission ct3 on ct3.id = ct1.permission_id\n" +
            "where ct1.user_type_id = :p_user_type_id\n" +
            "union\n" +
            "select ct2.name, ct3.name, ct2.status\n" +
            "from user_permission ct1\n" +
            "         join permission ct2 on ct2.id = ct1.permission_id\n" +
            "         join user_type ct3 on ct3.id = :p_user_type_id\n" +
            "where ct1.user_id = :p_user_id", nativeQuery = true)
    Optional<UserPermissions> findUserWithPermissions(@Param("p_user_id") Long userId,
                                                      @Param("p_user_type_id") Long userTypeId);
}
