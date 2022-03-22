package pl.edu.pwsztar.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.edu.pwsztar.domain.entity.Movie;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>, CrudRepository<Movie, Long> {

    @Query("Select m FROM Movie m WHERE m.title LIKE CONCAT('%',:search,'%') ORDER BY m.year")
    List<Movie> findByOrderByYearDesc(@Param("search") String search);

    @Modifying
    @Query("DELETE FROM Movie m WHERE m.movieId = :movieId")
    void deleteById(@Param("movieId") Long movieId);


    @Query("Select count(m) FROM Movie m WHERE m.title LIKE CONCAT('%',:search,'%') ORDER BY m.year DESC")
    Long countFindByOrderByYearDesc(@Param("search") String search);

    Movie findOneByMovieId(Long movieId);
}
