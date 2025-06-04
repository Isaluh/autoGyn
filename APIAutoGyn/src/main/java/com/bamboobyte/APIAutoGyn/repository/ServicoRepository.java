package com.bamboobyte.APIAutoGyn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bamboobyte.APIAutoGyn.entity.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {

}
