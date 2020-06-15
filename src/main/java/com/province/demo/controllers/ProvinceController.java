package com.province.demo.controllers;

import com.province.demo.models.Category;
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
public class ProvinceController {

    @Autowired
    private ProvinceService provinceService;

    @Autowired
    private CountryService countryService;

    @GetMapping("/provinces-list")
    public ModelAndView listProvinces() {

        List<Province> provinces = provinceService.findAll();
        ModelAndView modelAndView = new ModelAndView("province/index");
        modelAndView.addObject("provinces", provinces);
        return modelAndView;

    }


    @ModelAttribute("country")
    public List<Country> provinces() {
        return countryService.findAll();}

    @GetMapping("/create-province")
    public ModelAndView showCreateForm() {

        ModelAndView modelAndView = new ModelAndView("province/province-create");
        modelAndView.addObject("province", new Province());
        return modelAndView;
    }

    @PostMapping("/create-province")
    public ModelAndView saveProvince(@ModelAttribute("province") Province province) {
        provinceService.save(province);
        ModelAndView modelAndView = new ModelAndView("province/province-create");
        modelAndView.addObject("message", "New province created successfully");
        return modelAndView;

    }

//    @GetMapping("/view-province/{id}")
//    public ModelAndView showProvinceDetail(@PathVariable("id") Long id) {
//        Province province = provinceService.findById(id);
//        if (province == null) {
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
//            Optional<Province> province = null;
//            province = provinceService.findById(id);
//            modelAndView.addObject("customers", province);
//            return modelAndView;
//        } catch (Exception e) {
//            return new ModelAndView("redirect:/index");
//        }
//    }
}