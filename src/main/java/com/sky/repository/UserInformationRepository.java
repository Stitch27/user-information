package com.sky.repository;

import com.sky.entity.UserInformationEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserInformationRepository extends JpaRepository<UserInformationEntity, Long> {

    @Query(value = "SELECT * FROM TPBANKOWNER.USER_INFORMATION WHERE UI_EMAIL = :email AND UI_CODE = :code", nativeQuery = true)
    UserInformationEntity getInformation(@Param("email") String user, @Param("code") String code);

}
