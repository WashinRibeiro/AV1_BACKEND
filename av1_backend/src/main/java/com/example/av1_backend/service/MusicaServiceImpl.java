package com.example.av1_backend.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.av1_backend.model.Musica;
import com.example.av1_backend.repository.MusicaRepository;
import com.example.av1_backend.shared.MusicaDto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MusicaServiceImpl implements MusicaService {
    
    @Autowired
    private MusicaRepository repo;

    ModelMapper mapper = new ModelMapper(); // Aqui criamos a instãncia do ModelMapper que será utilizada em alguns "overrides"
 
    @Override
    public MusicaDto cadastrarMusica(MusicaDto musicaDto) {
        Musica musica = mapper.map(musicaDto, Musica.class);
        musica = repo.save(musica);
        MusicaDto dto = mapper.map(musica, MusicaDto.class);
        
        return dto;
    }
    
    @Override
    public List<MusicaDto> obterMusicas() {
        List<Musica> musicas = repo.findAll();
        
        return musicas.stream()
            .map(musica -> new ModelMapper().map(musica, MusicaDto.class))
            .collect(Collectors.toList());
    }

    @Override
    public MusicaDto atualizarMusica(String id, MusicaDto musicaDto) {
        Musica musica = mapper.map(musicaDto, Musica.class);
        
        musica.setId(id);
        musica = repo.save(musica);

        MusicaDto dto = mapper.map(musica, MusicaDto.class);

        return dto; 
    }

    @Override
    public Optional<MusicaDto> obterPorId(String id) {
        Optional<Musica> musica = repo.findById(id);

        if (musica.isPresent()) {
            MusicaDto musicaDto = mapper.map(musica.get(), MusicaDto.class);
            return Optional.of(musicaDto);
        }
    
        return Optional.empty(); 
    }

    @Override
    public void removerMusica(String id) {
        repo.deleteById(id);  
    }

    @Override
    public long contagem() {
        return repo.count();
    }
    
} 