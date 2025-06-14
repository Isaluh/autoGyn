package com.bamboobyte.APIAutoGyn.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bamboobyte.APIAutoGyn.Entities.ItemServico;

@Repository
public interface ItemServicoRepository extends JpaRepository<ItemServico, Long> {

}
