package com.buildapi.gdp.controller;

import com.buildapi.gdp.GdpApplication;
import com.buildapi.gdp.exception.ResourseNotFoundException;
import com.buildapi.gdp.model.GDP;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@RestController
public class GDPController {

    // http://localhost:1998/gdp/names
    @GetMapping(value = "/names", produces = {"application/json"})
    public ResponseEntity<?> getAllCountriesByName() {
        GdpApplication.ourGdpList.gdpList.sort((e1, e2) -> e1.getName().compareToIgnoreCase(e2.getName()));
        return new ResponseEntity<>(GdpApplication.ourGdpList.gdpList, HttpStatus.OK);
    }

    // http://localhost:1998/gdp/economy
    @GetMapping(value = "/economy", produces = {"application/json"})
    public ResponseEntity<?> getAllCountriesByGDP() {
        GdpApplication.ourGdpList.gdpList.sort((e1, e2) -> {
            int result1 = Integer.parseInt(e1.getGdp());
            int result2 = Integer.parseInt(e2.getGdp());
            return result2 - result1;
        });
        return new ResponseEntity<>(GdpApplication.ourGdpList.gdpList, HttpStatus.OK);
    }


    // http://localhost:1998/gdp/gdp/{countryname}
    @GetMapping(value = "/gdp/{countryname}", produces = {"application/json"})
    public ResponseEntity<?> searchForSpecificCountry(@PathVariable String countryname) {
        GDP rtnGDP;

        if ((GdpApplication.ourGdpList.findGDP(e -> (e.getName().toUpperCase()).equals(countryname.toUpperCase()))) == null) {
            throw new ResourseNotFoundException("Country with name " + countryname + " not found");
        } else {
            rtnGDP = GdpApplication.ourGdpList.findGDP(g -> (g.getName().toUpperCase().equals(countryname.toUpperCase())));
        }

        return new ResponseEntity<>(rtnGDP, HttpStatus.OK);
    }


    // http://localhost:1998/gdp/country/{id}
    @GetMapping(value = "/country/{id}", produces = {"application/json"})
    public ResponseEntity<?> searchForSpecificCountryByID(@PathVariable long id) {
        GDP rtnGDPByID;

        if((GdpApplication.ourGdpList.findGDP( e ->(e.getId()) == id)) == null) {
            throw new ResourseNotFoundException("Country with id of " + id + " not found");
        } else {
            rtnGDPByID = GdpApplication.ourGdpList.findGDP(d -> d.getId() == id);
        }

        return new ResponseEntity<>(rtnGDPByID, HttpStatus.OK);
    }


//    // http://localhost:1998/gdp/country/stats/median
//    @GetMapping(value = "/country/stats/median", produces = {"application/json"})
//    public ResponseEntity<?> getCountryByMedian() {
//
//        ArrayList<Integer> medianArrayList = new ArrayList<>();
//
//        GdpApplication.ourGdpList.gdpList.sort(() -> {
//            int result3 = Integer.parseInt(GdpApplication.ourGdpList.gdpList.getGdp());
//            medianArrayList.add(result3);
//
//
//            int middle = medianArrayList.size()/2;
//            if (medianArrayList.size()%2 == 1) {
//                middle = (medianArrayList.get(medianArrayList.size()/2) + medianArrayList.get(medianArrayList.size()/2 - 1))/2;
//            } else {
//                middle = medianArrayList.get(medianArrayList.size() / 2);
//            }
//            return middle;
//        });
//        return new ResponseEntity<>(GdpApplication.ourGdpList.gdpList, HttpStatus.OK);
//    }

    // localhost:1998/economy/table
    @GetMapping(value = "/economy/table")
    public ModelAndView displayEconomyTable() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("table.html");
        mav.addObject("gdpList", GdpApplication.ourGdpList.gdpList);
        return mav;
    }


//    // localhost:1998/economy/greatest/{GDP}
//    @GetMapping(value = "/economy/greatest/{GDP}")
//    public ModelAndView displayGreatestGPDTable() {
//        ModelAndView mav = new ModelAndView();
//        mav.setViewName("GDPFrontEnd.html");
//        mav.addObject("GdpList", GdpApplication.ourGdpList.gdpList);
//        return mav;
//    }

}
