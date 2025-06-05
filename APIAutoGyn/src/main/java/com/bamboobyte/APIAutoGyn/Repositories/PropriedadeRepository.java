package com.bamboobyte.APIAutoGyn.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bamboobyte.APIAutoGyn.Entities.Propriedade;

@Repository
public interface PropriedadeRepository extends JpaRepository<Propriedade, Long> {

}
