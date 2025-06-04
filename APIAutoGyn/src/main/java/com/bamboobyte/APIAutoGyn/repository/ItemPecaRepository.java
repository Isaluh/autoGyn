package com.bamboobyte.APIAutoGyn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bamboobyte.APIAutoGyn.entity.ItemPeca;

@Repository
public interface ItemPecaRepository extends JpaRepository<ItemPeca, Long> {

}
