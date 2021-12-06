package com.example.accessingdatamysql;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dell
 */
@Entity // This tells Hibernate to make a table out of this class
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String email;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "pc_fid", referencedColumnName = "id")
    List<Comment> comments = new ArrayList<>();

	public User(){

	}

	public User(String name, String email){
		super();
		this.name = name;
		this.email = email;
	}
}
