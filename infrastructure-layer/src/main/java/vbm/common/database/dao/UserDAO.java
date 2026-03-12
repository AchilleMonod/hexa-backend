package vbm.common.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vbm.common.database.entities.UserEntity;

import java.util.Optional;

@Repository
public interface UserDAO extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);
}

