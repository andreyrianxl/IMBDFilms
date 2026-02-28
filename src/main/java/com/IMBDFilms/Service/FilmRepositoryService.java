package com.IMBDFilms.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.IMBDFilms.model.Film;
import com.IMBDFilms.repository.FilmRepository;

@Service
public class FilmRepositoryService {
    @Autowired
    private FilmRepository filmRepository;

    public List<Film> pesquisaPorTitulo(String title){
        return filmRepository.findByTitleContainingIgnoreCase(title);
    }

    public List<Film> pesquisaPorTituloETipo(String title, String type){
         return filmRepository.findByTitleContainingIgnoreCaseAndTypeContainingIgnoreCase(title, type);
    }

    public List<Film> pesquisaPorTituloETipoEGenero(String title, String type, String genres){
         return filmRepository.findByTitleContainingIgnoreCaseAndTypeContainingIgnoreCaseAndGenresContainingIgnoreCaseOrderByPremieredAsc(
            title, type, genres);
    }

    public Film salvarFilme(Film film){
        return filmRepository.save(film);
    }

    public Film atualizarFilme(String id, Film filmAtualizado) {
        Optional<Film> pesquisa = filmRepository.findById(id);
        if (pesquisa.isPresent()){
            filmAtualizado.setTitleId(id);
            return filmRepository.save(filmAtualizado);
        }
            return null;
    }

    public Film deletarFilme(String id) {
        Film film = filmRepository.findById(id).orElse(null);
        if (film != null) {
            filmRepository.delete(film);
            return film;
        }
        return film;
    }
}
