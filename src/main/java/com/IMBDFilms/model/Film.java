package com.IMBDFilms.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "titles")

public class Film {
    
    @Id@Column(name = "title_id")
    private String titleId;
    @Column(name = "primary_title")
    @NotBlank(message = "O título do filme é obrigatório e não pode ficar em branco.")
    private String title;
    @Column(name = "premiered")
    @NotNull(message = "O Ano de lançamento do filme é obrigatório e não pode ficar em branco.")
    private Integer premiered;
    @Column(name = "genres")
    @NotBlank(message = "O gênero do filme é obrigatório e não pode ficar em branco.")
    private String genres;
    @Column(name = "type")
    @NotBlank(message = "O típo do filme é obrigatório e não pode ficar em branco.")
    private String type;
    
    public Film() {
    }
    
    public String getTitleId() {
        return titleId;
    }
    
    public void setTitleId(String titleId) {
        this.titleId = titleId;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPremiered() {
        return premiered;
    }

    public void setPremiered(Integer premiered) {
        this.premiered = premiered;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
