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
            @Mapping(source = "apellidoUsuario", target = "lastname"),
            @Mapping(source = "fechaNacimiento", target = "birthday"),
            @Mapping(source = "correoUsuario", target = "email"),
            @Mapping(source = "pedido", target = "order"),
            @Mapping(source = "pedidos", target = "orders")
    })
    User toUser(Usuario usuario);

    @InheritInverseConfiguration
    Usuario toUsuario(User user);
}
