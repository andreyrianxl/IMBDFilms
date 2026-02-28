package com.IMBDFilms.repository;
import com.IMBDFilms.model.Film;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface FilmRepository extends JpaRepository<Film, String> {
    
    List<Film>findByTitleContainingIgnoreCase(String title);

    List<Film>findByTitleContainingIgnoreCaseAndTypeContainingIgnoreCase(String title, String type);

    List<Film>findByTitleContainingIgnoreCaseAndTypeContainingIgnoreCaseAndGenresContainingIgnoreCaseOrderByPremieredAsc(
        String title, String type, String genres);


}