package com.sakachelas.persistance.mapper;

import com.sakachelas.domain.UserRole;
import com.sakachelas.persistance.entity.RoleUsuario;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface UserRoleMapper {

    @Mappings({
            @Mapping(source = "username", target = "username"),
            @Mapping(source = "role", target = "role"),
            @Mapping(source = "fechaInicio", target = "grantedDate"),
            @Mapping(source = "usuario", target = "user")
    })
    UserRole toUserRole(RoleUsuario roleUsuario);

    @InheritInverseConfiguration
    RoleUsuario toRoleUsuario(UserRole userRole);
}