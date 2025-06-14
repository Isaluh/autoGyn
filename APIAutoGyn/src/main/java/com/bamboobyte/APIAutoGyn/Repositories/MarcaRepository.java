package com.bamboobyte.APIAutoGyn.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bamboobyte.APIAutoGyn.Entities.Marca;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long> {

}
