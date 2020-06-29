package br.edu.usj.ads.lpii.trabalhofinallp2;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<Game, Long> {
    List<Game> findAll();
}