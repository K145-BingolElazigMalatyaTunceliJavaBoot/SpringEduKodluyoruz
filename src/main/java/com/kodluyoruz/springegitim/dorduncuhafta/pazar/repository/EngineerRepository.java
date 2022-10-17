package com.kodluyoruz.springegitim.dorduncuhafta.pazar.repository;

import com.kodluyoruz.springegitim.dorduncuhafta.pazar.entity.Engineer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EngineerRepository extends CrudRepository<Engineer, Integer> {

    public List<Engineer> findAllByName(String name);

}
