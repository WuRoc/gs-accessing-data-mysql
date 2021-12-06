package com.example.accessingdatamysql;

import lombok.Data;

import javax.persistence.*;

/**
 * @ClassName Comment
 * @Description TODO
 * @Author XiaoShuMu
 * @Version 1.0
 * @Create 2021-12-06 14:37
 * @Blog https://www.cnblogs.com/WLCYSYS/
 **/
@Entity
@Data
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    public Comment() {

    }

    public Comment(String text){
        super();
        this.text = text;
    }


}
