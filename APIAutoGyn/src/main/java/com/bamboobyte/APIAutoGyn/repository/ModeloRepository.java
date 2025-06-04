package com.bamboobyte.APIAutoGyn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bamboobyte.APIAutoGyn.entity.Modelo;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Long> {

}
