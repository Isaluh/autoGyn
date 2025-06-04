package com.bamboobyte.APIAutoGyn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bamboobyte.APIAutoGyn.entity.ItemServico;

@Repository
public interface ItemServicoRepository extends JpaRepository<ItemServico, Long> {

}
