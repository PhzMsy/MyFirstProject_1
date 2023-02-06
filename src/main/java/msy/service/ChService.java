package msy.service;

import msy.bean.Champion;
import msy.bean.City;
import msy.bean.Hero;

import java.util.ArrayList;

/**
 * @author Msy
 * @date 2023/2/1  15:20
 */
public interface ChService {

    ArrayList<Champion> queryAll();

    ArrayList<Hero> queryHero();


    int insert(Champion champion);

    Champion queryById(String m);

    int update(Champion champion);

    int delete(String id);

    ArrayList<City> queryCity(String pid);
}
