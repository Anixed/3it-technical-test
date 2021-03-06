package com.example.apirest.models;

import javax.persistence.*;

@Entity
@Table(name = "musical_styles")
public class MusicalStyle {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
	
    @Column(name = "name", nullable = false)
    private String name;
    
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
    
}
