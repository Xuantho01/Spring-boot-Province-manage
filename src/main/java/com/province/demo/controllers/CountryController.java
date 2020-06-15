package com.province.demo.controllers;

import com.province.demo.models.Country;
import com.province.demo.models.Province;
import com.province.demo.servicies.CountryService;
import com.province.demo.servicies.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CountryController {

    @Autowired
    private CountryService countryService;

    @Autowired
    private ProvinceService provinceService;

//    @GetMapping("/country")
//    public ModelAndView listProvinces(){
//        List<Province> countryList  = provinceService.findAll();
//        ModelAndView modelAndView = new ModelAndView("province/create");
//        modelAndView.addObject("country", countryList);
//        return modelAndView;
//    }

    @GetMapping("/create-province")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("province/province-create");
        modelAndView.addObject("country", new Country());
        return modelAndView;
    }

    @PostMapping("/create-province")
    public ModelAndView saveProvince(@ModelAttribute("country") Country country){

        countryService.save(country);
        ModelAndView modelAndView = new ModelAndView("province/create");
        modelAndView.addObject("country", new Country());
        modelAndView.addObject("message", "New province created successfully");
        return modelAndView;
    }

//    @GetMapping("/view-province/{id}")
//    public ModelAndView showProvinceDetail(@PathVariable("id") Long id){
//        Province province = provinceService.findById(id);
//        if(province == null){
//            return new ModelAndView("/error.404");
//        }
//        Iterable<Customer> customers = customerService.findAllByProvince(province);
//
//        ModelAndView modelAndView = new ModelAndView("province/view");
//
//        modelAndView.addObject("province", province);
//        modelAndView.addObject("customers", customers);
//
//        return modelAndView;
//    }
//    @GetMapping("{id}")
//    public ModelAndView showInformation(@PathVariable Long id) {
//        try {
//            ModelAndView modelAndView = new ModelAndView("province/view");
//            Province province = null;
//            province = provinceService.findById(id);
//            modelAndView.addObject("customers", province);
//            return modelAndView;
//        } catch (Exception e) {
//            return new ModelAndView("redirect:/index");
//        }
//    }
}
