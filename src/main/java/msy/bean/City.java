package msy.bean;

import lombok.Data;

/**
 * @author Msy
 * @date 2023/2/3  9:50
 */
@Data
public class City {
    private Integer id;
    private Integer pid;
    private String name;

    public City() {
    }

    public City(Integer id, Integer pid, String name) {
        this.id = id;
        this.pid = pid;
        this.name = name;
    }
}
