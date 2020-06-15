package com.province.demo.servicies;


import com.province.demo.models.Country;

import java.util.List;

public interface CountryService {

    List<Country> findAll();

    Country findById(Long id);

    void save(Country country);

    void remove(Long id);

}
