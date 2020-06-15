package com.province.demo.repositories;

import com.province.demo.models.Province;
import org.springframework.data.repository.CrudRepository;

public interface ProvinceRepository extends CrudRepository<Province, Long> {
}
