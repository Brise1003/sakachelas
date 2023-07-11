package com.sakachelas.persistance.crud;

import com.sakachelas.persistance.entity.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.ListPagingAndSortingRepository;

public interface ProductoPageSortRepository extends ListPagingAndSortingRepository<Producto, Integer> {
    Page<Producto> findBy(Pageable pageable);
}
