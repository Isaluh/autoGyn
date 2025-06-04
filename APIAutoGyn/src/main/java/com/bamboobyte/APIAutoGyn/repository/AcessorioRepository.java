package com.bamboobyte.APIAutoGyn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bamboobyte.APIAutoGyn.entity.Acessorio;

@Repository
public interface AcessorioRepository extends JpaRepository<Acessorio, Long> {

}