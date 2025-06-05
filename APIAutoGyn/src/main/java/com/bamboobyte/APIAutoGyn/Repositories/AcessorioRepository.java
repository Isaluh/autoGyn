package com.bamboobyte.APIAutoGyn.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bamboobyte.APIAutoGyn.Entities.Acessorio;

@Repository
public interface AcessorioRepository extends JpaRepository<Acessorio, Long> {

}