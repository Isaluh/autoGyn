package com.bamboobyte.APIAutoGyn.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bamboobyte.APIAutoGyn.Entities.ItemPeca;

@Repository
public interface ItemPecaRepository extends JpaRepository<ItemPeca, Long> {

}
