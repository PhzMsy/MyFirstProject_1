package msy.Dao;


import msy.bean.Champion;
import msy.bean.City;
import msy.bean.Hero;
import msy.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Msy
 * @date 2023/2/1  15:21
 */
public class ChampionDao {
    private Connection conn = JDBCUtil.getConn();

    public ArrayList<Champion> queryAll() {
        ArrayList<Champion> list = new ArrayList<>();
        try {
            String sql = "select c.*,h.id,career from championsword c join hero h on h.id = c.pid";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Hero hero = new Hero(rs.getInt(6), rs.getString(7));
                Champion champion = new Champion(rs.getInt(1), rs.getString(2), rs.getInt(3), hero, rs.getString(5));
                list.add(champion);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<Hero> queryHero() {
        ArrayList<Hero> list = new ArrayList<>();
        String s = "select * from hero";
        try {
            PreparedStatement ps = conn.prepareStatement(s);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                list.add(new Hero(resultSet.getInt(1), resultSet.getString(2)));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }

    public int insert(Champion champion) {
        int i = 0;
        try {
            String s = "insert into championsword values(null,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(s);
            ps.setString(1, champion.getName());
            ps.setInt(2, champion.getStar());
            ps.setInt(3, champion.getHero().getId());
            ps.setString(4, champion.getNickname());
            i = ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return i;
    }

    public Champion queryById(String m) {
        Champion champion = null;
        String s = "select c.*,career from championsword c join hero h on h.id = c.pid where c.id = ? ";
        try {
            PreparedStatement ps = conn.prepareStatement(s);
            ps.setString(1, m);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Hero hero = new Hero(rs.getInt(4), rs.getString(6));
                champion = new Champion(rs.getInt(1), rs.getString(2), rs.getInt(3), hero, rs.getString(5));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return champion;
    }

    public int update(Champion champion) {
        int i = 0;

        try {
            String s = "update championsword set name=?,star=?,pid=?,nickname=? where id= ? ";
            PreparedStatement ps = conn.prepareStatement(s);
            ps.setString(1, champion.getName());
            ps.setInt(2, champion.getStar());
            ps.setInt(3, champion.getHero().getId());
            ps.setString(4, champion.getNickname());
            ps.setInt(5, champion.getId());
            i = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return i;
    }

    public int delete(String id) {
        int i = 0;
        String sql = "delete from championsword where id= ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);

            i = ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return i;
    }

    public ArrayList<City> queryCity(String pid) {
        ArrayList<City> list = new ArrayList<>();
        String s = "select id,pid,name from city where pid = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(s);
            ps.setString(1,pid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                City city = new City(rs.getInt(1),rs.getInt(2),rs.getString(3));
                list.add(city);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println(list);
        return list;
    }
}
