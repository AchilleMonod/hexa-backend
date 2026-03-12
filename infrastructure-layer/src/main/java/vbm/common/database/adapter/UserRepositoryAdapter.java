package vbm.common.database.adapter;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import vbm.common.database.dao.UserDAO;
import vbm.common.database.mapper.UserEntityMapper;
import vbm.common.model.UserBO;
import vbm.common.port.UserRepository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class UserRepositoryAdapter implements UserRepository {

    private final UserDAO userDAO;
    private final UserEntityMapper userEntityMapper;

    @Override
    public Optional<UserBO> findByEmail(String email) {
        return userDAO.findByEmail(email)
                .map(userEntityMapper::toBO);
    }

    @Override
    public UserBO save(UserBO user) {
        return userEntityMapper.toBO(
                userDAO.save(userEntityMapper.toEntity(user))
        );
    }
}

