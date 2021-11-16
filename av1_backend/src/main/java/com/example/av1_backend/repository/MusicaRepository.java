package com.example.av1_backend.repository;

import com.example.av1_backend.model.Musica;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MusicaRepository extends MongoRepository<Musica,String>{

}