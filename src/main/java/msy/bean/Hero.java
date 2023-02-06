package msy.bean;

import lombok.Data;

/**
 * @author Msy
 * @date 2023/2/1  15:17
 */
@Data
public class Hero {
    private Integer id;
    private String career;

    public Hero(Integer id, String career) {
        this.id = id;
        this.career = career;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public Hero() {
    }
}
