package com.sakachelas.persistance.mapper;

import com.sakachelas.domain.Product;
import com.sakachelas.persistance.entity.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mappings({
            @Mapping(source = "idProducto", target = "productId"),
            @Mapping(source = "nombreProducto", target = "name"),
            @Mapping(source = "cantidadStock", target = "stock"),
            @Mapping(source = "descripcion", target = "description"),
            @Mapping(source = "marca", target = "brand"),
            @Mapping(source = "estilo", target = "style"),
            @Mapping(source = "precio", target = "price"),
    })
    Product toProduct(Producto producto);
    List<Product> toProducts(List<Producto> productos);

    @InheritInverseConfiguration
    @Mapping(target = "cerveceroId", ignore = true)
    Producto toProducto(Product product);
}
