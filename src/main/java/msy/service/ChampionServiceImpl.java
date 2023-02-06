package msy.service;

import msy.Dao.ChampionDao;
import msy.bean.Champion;
import msy.bean.City;
import msy.bean.Hero;

import java.util.ArrayList;

/**
 * @author Msy
 * @date 2023/2/1  15:18
 */
public class ChampionServiceImpl implements ChService{
        private ChampionDao championDao = new ChampionDao();

        @Override
        public ArrayList<Champion> queryAll() {
                return championDao.queryAll();
        }

        @Override
        public ArrayList<Hero> queryHero() {
                return championDao.queryHero();
        }

        @Override
        public int insert(Champion champion) {
                return championDao.insert(champion);
        }

        @Override
        public Champion queryById(String m) {
                return championDao.queryById(m);
        }

        @Override
        public int update(Champion champion) {
                return championDao.update(champion);
        }

        @Override
        public int delete(String id) {
                return championDao.delete(id);
        }

    @Override
    public ArrayList<City> queryCity(String pid) {
        return championDao.queryCity(pid);
    }


}
