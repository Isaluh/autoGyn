package com.bamboobyte.APIAutoGyn.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bamboobyte.APIAutoGyn.Entities.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, String> {

}
