package com.mahammad.msblog.repository.user;

import java.util.Date;
import com.mahammad.msblog.constant.UserType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_type", schema = "ms-blog")
public class UserTypeDao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private UserType name;

    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    private Date updatedAt;

    @Column(nullable = false)
    private Boolean status = true;

    private Long createdBy;

    private Long updatedBy;
}