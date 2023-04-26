package com.sakachelas.persistance.mapper;

import com.sakachelas.domain.ProductOrder;
import com.sakachelas.persistance.entity.PedidoProducto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {OrderMapper.class})
public interface ProductOrderMapper {
    @Mappings({
            @Mapping(source = "idPedido", target = "orderId"),
            @Mapping(source = "idProducto", target = "productId"),
            @Mapping(source = "cantidad", target = "quantity"),
            @Mapping(source = "totalcerveza", target = "beertotal"),
            @Mapping(source = "pedido",target = "order"),
            @Mapping(source = "producto", target = "product"),
    })
    ProductOrder toProductOrder(PedidoProducto pedidoProducto);

    @InheritInverseConfiguration
    PedidoProducto toPedidoProducto(ProductOrder productOrder);
}
