package com.example.av1_backend.view.controller;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.av1_backend.model.Musica;
import com.example.av1_backend.service.MusicaService;
import com.example.av1_backend.shared.MusicaDto;
import com.example.av1_backend.view.model.MusicaRequest;
import com.example.av1_backend.view.model.MusicaResponse;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/musica")
public class MusicaController {
    @Autowired
    private MusicaService servico;

    ModelMapper mapper = new ModelMapper();

    //Mostrar Músicas cadastradas para
    @GetMapping
    public ResponseEntity<List<MusicaResponse>> obterMusicas() {
        List<MusicaDto> musicaDto = servico.obterMusicas();
        List<MusicaResponse> response = 
            musicaDto.stream()
            .map(musica -> mapper.map(musica, MusicaResponse.class))
            .collect(Collectors.toList());

        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    //Cadastrar Música
    @PostMapping
    public ResponseEntity<MusicaResponse> cadastrarMusica(@RequestBody MusicaRequest request) {
        MusicaDto musicaDto = mapper.map(request, MusicaDto.class);
        musicaDto = servico.cadastrarMusica(musicaDto);
        MusicaResponse response = mapper.map(musicaDto, MusicaResponse.class);

        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    //Consultar Músicas por ID
    @GetMapping(value = "/encontrarporID/{id}")
    public ResponseEntity<MusicaResponse> obterPorId(@PathVariable String id) {
        Optional<MusicaDto> musicaDto = servico.obterPorId(id);

        if(musicaDto.isPresent()) {
            MusicaResponse response = mapper.map(musicaDto.get(), MusicaResponse.class);
            return new ResponseEntity<>(response, HttpStatus.FOUND);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //Atualizar Músicas por ID
    @PutMapping(value="/atualizarporID/{id}")
    public ResponseEntity<MusicaResponse> atualizarMusica(@PathVariable String id, @RequestBody MusicaRequest request) {
        MusicaDto musicaDto = mapper.map(request, MusicaDto.class);
        musicaDto = servico.atualizarMusica(id, musicaDto);
        MusicaResponse response = mapper.map(musicaDto, MusicaResponse.class);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }   
    
    //Deletar Músicas por ID
    @DeleteMapping(value = "/deletarpoID/{id}")
    public ResponseEntity<String> removerMusica(@PathVariable String id) {
        servico.removerMusica(id);
        return new ResponseEntity<String>("Produto deletado com sucesso", HttpStatus.OK);
    }

    //Contagem de Músicas
    @GetMapping("/contagem")
    public long contagemMusicas() {
        return servico.contagem();
    }

    //Consultar Músicas por ano
    @GetMapping(value = "/encontrarporAno/{anoLancamento}")
    public ResponseEntity<List<Musica>> encontrarPorAno(@PathVariable int anoLancamento) {
        return new ResponseEntity<>(servico.encontrarPorAno(anoLancamento), HttpStatus.OK);
    }
     

} 