package com.bamboobyte.APIAutoGyn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bamboobyte.APIAutoGyn.entity.Propriedade;

@Repository
public interface PropriedadeRepository extends JpaRepository<Propriedade, Long> {

}
