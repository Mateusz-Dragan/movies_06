package pl.edu.pwsztar.service;

import pl.edu.pwsztar.domain.dto.*;

import java.util.List;

public interface MovieService {

    List<MovieDto> findAll(String search);

    void creatMovie(CreateMovieDto createMovieDto);

    void deleteMovie(Long movieId);

    DetailsMovieDto findMovie(Long movieId);

    MovieCounterDto countMovies(String search);

    void updateMovie(Long movieId, UpdateMovieDto updateMovieDto);
}
