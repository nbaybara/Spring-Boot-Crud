package com.gerimedica.assignment.repository;
import com.gerimedica.assignment.entity.Data;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataRepository extends CrudRepository<Data,Long> {

    List<Data> findAllByCode(String code);
}
