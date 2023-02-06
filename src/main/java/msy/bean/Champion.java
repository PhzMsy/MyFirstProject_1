package msy.bean;

import lombok.Data;

/**
 * @author Msy
 * @date 2023/2/1  15:17
 */
@Data
public class Champion {
    private Integer id;
    /**
     * 名称
      */
    private String  name;
    /**
     * 星级
     */
    private Integer star;
    /**
     * 外键 里面有职业
     */
    private Hero hero;
    /**
     * 角色昵称
     */
    private String nickname;

    public Champion() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Champion(Integer id, String name, Integer star, Hero hero, String nickname) {
        this.id = id;
        this.name = name;
        this.star = star;
        this.hero = hero;
        this.nickname = nickname;
    }
}
