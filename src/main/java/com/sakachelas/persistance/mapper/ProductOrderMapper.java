package com.sakachelas.persistance.mapper;

import com.sakachelas.domain.ProductOrder;
import com.sakachelas.persistance.entity.PedidoProducto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface ProductOrderMapper {
    @Mappings({
            @Mapping(source = "idPedido", target = "orderId"),
            @Mapping(source = "idProducto", target = "productId"),
            @Mapping(source = "cantidad", target = "quantity"),
            @Mapping(source = "totalcerveza", target = "beertotal"),
            @Mapping(target = "order", ignore = true),
            @Mapping(target = "product", ignore = true)
    })
    ProductOrder toProductOrder(PedidoProducto pedidoProducto);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "pedido", ignore = true),
            @Mapping(target = "producto", ignore = true),
    })
    PedidoProducto toPedidoProducto(ProductOrder item);
}
