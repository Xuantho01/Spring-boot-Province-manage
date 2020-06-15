package com.province.demo.servicies.impl;

import com.province.demo.models.Country;
import com.province.demo.repositories.CountryRepository;
import com.province.demo.servicies.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public List<Country> findAll() {
        return (List<Country>) countryRepository.findAll();
    }

    @Override
    public Country findById(Long id) {
        return findById(id);
    }

    @Override
    public void save(Country province) {
        countryRepository.save(province);
    }

    @Override
    public void remove(Long id) {
        countryRepository.deleteById(id);
    }

}
