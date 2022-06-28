package com.cqu.online_learning.services;



import com.baomidou.mybatisplus.extension.service.IService;
import com.cqu.online_learning.entity.CourseFavorites;

import java.util.List;

public interface CourseFavoritesService extends IService<CourseFavorites> {
    void addCourseFavorites(CourseFavorites a);
    List<CourseFavorites> queryAllCourseFavorites();


    CourseFavorites queryCourseFavorites(int id);

}
