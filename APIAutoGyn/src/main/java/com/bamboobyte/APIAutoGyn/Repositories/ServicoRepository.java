package com.bamboobyte.APIAutoGyn.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bamboobyte.APIAutoGyn.Entities.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {

}
