package com.bamboobyte.APIAutoGyn.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bamboobyte.APIAutoGyn.Entities.Colaborador;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {
    Optional<Colaborador> findByCpf(String cpf);

}