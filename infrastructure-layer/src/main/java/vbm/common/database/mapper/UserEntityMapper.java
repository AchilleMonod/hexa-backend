package vbm.common.database.mapper;

import org.mapstruct.Mapper;
import vbm.common.database.entities.UserEntity;
import vbm.common.model.UserBO;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {
    UserBO toBO(UserEntity userEntity);
    UserEntity toEntity(UserBO userBO);
}

