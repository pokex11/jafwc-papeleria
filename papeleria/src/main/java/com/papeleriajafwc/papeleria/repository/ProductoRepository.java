package com.papeleriajafwc.papeleria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.papeleriajafwc.papeleria.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
