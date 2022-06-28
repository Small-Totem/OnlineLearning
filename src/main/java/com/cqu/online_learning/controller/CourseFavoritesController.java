package com.cqu.online_learning.controller;

import com.cqu.online_learning.entity.CourseFavorites;
import com.cqu.online_learning.services.CourseFavoritesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseFavoritesController {
    @Autowired
    CourseFavoritesService courseFavoritesService;

    @PostMapping("/addCourseFavorites")
    public String addCourseFavorites(CourseFavorites a){
        courseFavoritesService.addCourseFavorites(a);
        return  "success";
    }

    @GetMapping("/queryAllCourseFavorites")
    public List<CourseFavorites> queryAllCourseFavorites(){
        return courseFavoritesService.queryAllCourseFavorites();
    }

    @GetMapping("/getCourseFavorites/{id}")
    public CourseFavorites getCourseFavorites(@PathVariable int id){
        return courseFavoritesService.getCourseFavorites(id);

    }
    @GetMapping("/removeCourseFavorites/{id}")
    public String removeCourseFavorites(@PathVariable int id){
        courseFavoritesService.removeCourseFavorites(id);
        return "success";
    }
}
