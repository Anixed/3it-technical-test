package com.example.apirest.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "quiz")
public class Quiz {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "email", unique = true, nullable = false)
    private String email;
    
    @ManyToMany()
	@JoinTable(
			name = "quiz_musical_styles",
			joinColumns = { @JoinColumn(name = "quiz_id") },
			inverseJoinColumns = { @JoinColumn(name = "musical_style_id") })
    @JsonProperty("musical_styles")
    private List<MusicalStyle> musicalStyles = new ArrayList<>();
    
    @Transient
    @JsonProperty(value = "musical_styles_ids", access = JsonProperty.Access.WRITE_ONLY)
    private List<Integer> musicalStylesIds = new ArrayList<>();

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
	
	public List<MusicalStyle> getMusicalStyles() {
		return musicalStyles;
	}
	public void setMusicalStyles(List<MusicalStyle> musicalStyles) {
		this.musicalStyles = musicalStyles;
	}
	
	public List<Integer> getMusicalStylesIds() {
		return musicalStylesIds;
	}
	public void setMusicalStylesIds(List<Integer> musicalStylesIds) {
		this.musicalStylesIds = musicalStylesIds;
	}
	
}
