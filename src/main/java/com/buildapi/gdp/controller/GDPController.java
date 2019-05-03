package com.buildapi.gdp.controller;

import com.buildapi.gdp.GdpApplication;
import com.buildapi.gdp.exception.ResourseNotFoundException;
import com.buildapi.gdp.model.GDP;
import com.buildapi.gdp.model.MessageDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@RestController
public class GDPController {
    private static final Logger logger = LoggerFactory.getLogger(GDP.class);


    // http://localhost:1998/gdp/names
    @GetMapping(value = "/names", produces = {"application/json"})
    public ResponseEntity<?> getAllCountriesByName() {
        logger.info("/names accessed");
        GdpApplication.ourGdpList.gdpList.sort((e1, e2) -> e1.getName().compareToIgnoreCase(e2.getName()));
        return new ResponseEntity<>(GdpApplication.ourGdpList.gdpList, HttpStatus.OK);
    }

    // http://localhost:1998/gdp/economy
    @GetMapping(value = "/economy", produces = {"application/json"})
    public ResponseEntity<?> getAllCountriesByGDP() {
        logger.info("/economy accessed");
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
        logger.info("/gdp/{countryname} accessed");
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
        logger.info("/country/{id} accessed");
        if((GdpApplication.ourGdpList.findGDP( e ->(e.getId()) == id)) == null) {
            throw new ResourseNotFoundException("Country with id of " + id + " not found");
        } else {
            rtnGDPByID = GdpApplication.ourGdpList.findGDP(d -> d.getId() == id);
        }

        return new ResponseEntity<>(rtnGDPByID, HttpStatus.OK);
    }


    // http://localhost:1998/gdp/country/stats/median
    @GetMapping(value = "/country/stats/median", produces = {"application/json"})
    public ResponseEntity<?> getCountryByMedian() {
        GdpApplication.ourGdpList.gdpList.sort((e1, e2) -> {
            int result1 = Integer.parseInt(e1.getGdp());
            int result2 = Integer.parseInt(e2.getGdp());
            return result2 - result1;
        });
        GDP newMedian;
        logger.info("/country/stats/median accessed");
        if(GdpApplication.ourGdpList.gdpList.size() % 2 == 0) {
            int median = GdpApplication.ourGdpList.gdpList.size()/2;
            newMedian = GdpApplication.ourGdpList.findGDP(d -> d.getId() == median);
        } else {
            int median = (GdpApplication.ourGdpList.gdpList.size()/2) + 1;
            newMedian = GdpApplication.ourGdpList.findGDP(d -> d.getId() == median);
        }
        return new ResponseEntity<>(newMedian, HttpStatus.OK);
}

    // localhost:1998/gdp/economy/table
    @GetMapping(value = "/economy/table")
    public ModelAndView displayEconomyTable() {
        logger.info("/economy/table accessed");
        ModelAndView mav = new ModelAndView();
        mav.setViewName("table.html");
        mav.addObject("gdpList", GdpApplication.ourGdpList.gdpList);
        return mav;
    }


    // localhost:1998/gdp/economy/greatest/{GDP}
    @GetMapping(value = "/economy/greatest/{GDP}")
    public ModelAndView displayGreatestGPDTable(@PathVariable String GDP) {
        ArrayList<GDP> rtnGreatestGDPs;
        logger.info("/economy/greatest/{GDP} accessed");
        GdpApplication.ourGdpList.gdpList.sort((e1, e2) -> {
            int result1 = Integer.parseInt(e1.getGdp());
            int result2 = Integer.parseInt(e2.getGdp());
            return result2 - result1;
        });
        rtnGreatestGDPs = GdpApplication.ourGdpList.findGDPs(g -> Integer.parseInt(g.getGdp()) >= Integer.parseInt(GDP));
        ModelAndView mav = new ModelAndView();
        mav.setViewName("GDPFrontEnd.html");
        mav.addObject("GdpList", rtnGreatestGDPs);
        return mav;
    }

}
