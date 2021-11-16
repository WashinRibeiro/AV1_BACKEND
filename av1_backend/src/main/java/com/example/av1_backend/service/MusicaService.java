package com.example.av1_backend.service;

import java.util.List;
import java.util.Optional;

import com.example.av1_backend.shared.MusicaDto;

public interface MusicaService {
    MusicaDto cadastrarMusica(MusicaDto musica);
    MusicaDto atualizarMusica(String id, MusicaDto musica);
    List<MusicaDto> obterMusicas();
    Optional<MusicaDto> obterPorId(String id);
    void removerMusica(String id);
    long contagem();
}
    

