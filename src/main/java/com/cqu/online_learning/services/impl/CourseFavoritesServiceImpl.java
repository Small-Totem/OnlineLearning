package com.cqu.online_learning.services.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqu.online_learning.entity.CourseFavorites;
import com.cqu.online_learning.mapper.CourseFavoritesMapper;
import com.cqu.online_learning.services.CourseFavoritesService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseFavoritesServiceImpl extends ServiceImpl<CourseFavoritesMapper, CourseFavorites> implements CourseFavoritesService {

    @Override
    public void addCourseFavorites(CourseFavorites a) {
        this.save(a);

    }
    @Override
    public List<CourseFavorites> queryAllCourseFavorites() {
        return list();
    }
    @Override
    public CourseFavorites queryCourseFavorites(int id){
        CourseFavorites courseFavorites = this.getById(id);
        return courseFavorites;
    }
}
