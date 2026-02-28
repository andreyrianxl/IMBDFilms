package com.IMBDFilms.Controller;

import java.util.List;

import com.IMBDFilms.exception.FilmeNaoencontradoException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.IMBDFilms.Service.FilmRepositoryService;
import com.IMBDFilms.model.Film;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
public class ImbdFilmsController {
    @Autowired
    private FilmRepositoryService filmRepositoryService;


    @PostMapping("/save")
    public Film postMethodName(@Valid @RequestBody Film film) {
        Film filmSalved = filmRepositoryService.salvarFilme(film);
        System.out.println("Salvo!");
        return filmSalved;
    }
    
    @GetMapping("/title/{title}")
    public List<Film> getMethodName(@PathVariable String title) {
        List<Film> films = filmRepositoryService.pesquisaPorTitulo(title);
        if (films.isEmpty()) {
            System.out.println("Nenhum filme encontrado com esses critérios.");
        } else {
            films.forEach(film -> {
            System.out.println( film.getTitle() + 
                           " | Ano: " + film.getPremiered() + 
                           " | Gênero: " + film.getGenres());
            });
        }
        return films;
    }
    @GetMapping("/title/{title}/type/{type}")
    public List<Film> getMethodNameAndType(@PathVariable String title, @PathVariable String type) {
        List<Film> films = filmRepositoryService.pesquisaPorTituloETipo(title, type);
        if (films.isEmpty()) {
            System.out.println("Nenhum filme encontrado com esses critérios.");
        } else {
            films.forEach(film -> {
            System.out.println(film.getTitle() +
                           " | Ano: " + film.getPremiered() + 
                           " | Gênero: " + film.getGenres());
            });
        }
        return films;
    }

    @GetMapping("/title/{title}/type/{type}/genres/{genres}")
    public List<Film> getMethodNameAndTypeAndGenres(@PathVariable String title, @PathVariable String type, @PathVariable String genres) {
        List<Film> films = filmRepositoryService.pesquisaPorTituloETipoEGenero(title, type, genres);
        if (films.isEmpty()) {
            System.out.println("Nenhum filme encontrado com esses critérios.");
        } else {
            films.forEach(film -> {
            System.out.println(film.getTitle() +
                           " | Ano: " + film.getPremiered() + 
                           " | Gênero: " + film.getGenres());
            });
        }
        return films;
    }

    @PutMapping("/{id}")
    public Film putMethodName(@PathVariable String id, @RequestBody Film film) {
        Film filmUpdate = filmRepositoryService.atualizarFilme(id, film);
        if (filmUpdate != null) {
            System.out.println("Filme Atualizado!");
            return filmUpdate;
        } else {
            throw new FilmeNaoencontradoException("Erro ao Atualizar: O filme com id(" + id + ") não existe.");
        }
    }

    @DeleteMapping("/{id}")
    public Film deleteMethodName(@PathVariable String id) {
        Film film = filmRepositoryService.deletarFilme(id);
        if (film != null) {
            System.out.println("Filme Removido!");
            System.out.println(film.getTitle() +
                               " | Ano: " + film.getPremiered() + 
                               " | Gênero: " + film.getGenres());
        } else {
            throw new FilmeNaoencontradoException("Erro ao Deletar: O filme com id(" + id + ") não existe.");
        }
        return film;
    }
}
