package com.province.demo.servicies;

import com.province.demo.models.Province;

import java.util.List;
import java.util.Optional;

public interface ProvinceService {
    List<Province> findAll();

    Optional<Province> findById(Long id);

    void save(Province province);

    void remove(Long id);
}
