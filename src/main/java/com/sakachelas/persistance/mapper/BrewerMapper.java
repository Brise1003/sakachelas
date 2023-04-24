package com.sakachelas.persistance.mapper;

import com.sakachelas.domain.Brewer;
import com.sakachelas.persistance.entity.Cervecero;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface BrewerMapper {
    @Mappings({
            @Mapping(source = "cerveceroId", target = "brewerId"),
            @Mapping(source = "correoCervecero", target = "brewerEmail"),
            @Mapping(source = "telefono", target = "phone"),
            @Mapping(source = "marca", target = "brand"),
            @Mapping(source = "nombreCervecero", target = "brewerName"),
            @Mapping(source = "apellidoCervecero", target = "brewerLastname")
    })
    Brewer toBrewer(Cervecero cervecero);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "RFC", ignore = true),
            @Mapping(target = "productos", ignore = true)
    })
    Cervecero toCervecero(Brewer brewer);
}
