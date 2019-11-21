package com.bhhc.myapp.repository;

import com.bhhc.myapp.model.Reason;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReasonRepository extends CrudRepository<Reason, Long> {

    List<Reason> findByCompany(String company);

    Reason findById(long id);
}
