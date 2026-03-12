package vbm.common.port;

import vbm.common.model.UserBO;

import java.util.Optional;

public interface UserRepository {
    Optional<UserBO> findByEmail(String email);
    UserBO save(UserBO user);
}

