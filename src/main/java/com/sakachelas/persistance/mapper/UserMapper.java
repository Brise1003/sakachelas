package com.sakachelas.persistance.mapper;

import com.sakachelas.domain.User;
import com.sakachelas.persistance.entity.Usuario;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;


@Mapper(componentModel = "spring", uses = {OrderMapper.class})
public interface UserMapper {

    @Mappings({
            @Mapping(source = "usuarioId", target = "userId"),
            @Mapping(source = "nombreUsuario", target = "name"),
            @Mapping(source = "apellidoUsuario", target = "userLastname"),
            @Mapping(source = "edad", target = "age"),
            @Mapping(source = "correoUsuario", target = "email"),
            @Mapping(source = "pedido", target = "order"),
            @Mapping(source = "pedidos", target = "orders"),
            @Mapping(source = "role", target = "role"),
    })
    User toUser(Usuario usuario);

    @InheritInverseConfiguration
    Usuario toUsuario(User user);
}
