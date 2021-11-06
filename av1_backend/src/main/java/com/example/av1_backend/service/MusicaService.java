package com.example.av1_backend.service;

import java.util.List;
import java.util.Optional;

import com.example.av1_backend.shared.MusicaDto;

public interface MusicaService {
    MusicaDto cadastrarMusica(MusicaDto musica);
    List<MusicaDto> obterMusicas();
    long contagem();
    Optional<MusicaDto> obterPorId(String id);
    void removerMusica(String id);
    MusicaDto atualizarMusica(String id, MusicaDto musica);

} 

