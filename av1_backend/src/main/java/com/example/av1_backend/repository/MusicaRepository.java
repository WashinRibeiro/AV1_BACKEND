package com.example.av1_backend.repository;

import java.util.List;

import com.example.av1_backend.model.Musica;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface MusicaRepository extends MongoRepository<Musica,String> {
    
    @Query("{'anoLancamento': ?0 }")
    List<Musica> encontrarPorAno(int anoLancamento);
}
