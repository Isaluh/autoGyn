package com.bamboobyte.APIAutoGyn.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bamboobyte.APIAutoGyn.Entities.Modelo;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Long> {

}
