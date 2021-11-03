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


    //---------------------------------- EXPLICAÇÂO --------------------------------------------------------------
    
    // pegamos o retorno da busca por Id efetuada pelo repositório e verificamos se ela trouxe algum resultado
    @Override
    public Optional<MusicaDto> obterPorId(String id) {
        Optional<Musica> musica = repo.findById(id);

        // Em caso positivo, retornamos um Optional cujo valor é o resultado do mapeamento do objeto encontrado 
        // para um novo objeto do tipo PessoaDto
        if (musica.isPresent()) {
            MusicaDto musicaDto = mapper.map(musica.get(), MusicaDto.class);
            return Optional.of(musicaDto);
        }
        
        // Se não encontrar, retorna um optional vazio (empty em inglês)
        return Optional.empty(); 
    }
    //--------------------------------------------------------------------------------------------------------------




    /* Este caso é um pouco diferente, pois recebemos um DTO e precisamos
    salvar Pessoa no banco de dados. Assim, primeiro devemos mapear o
    objeto enviado para uma instância de Pessoa e, só então, enviá-la para o
    repositório. Em seguida, pegamos o retorno do método save() e o
    utilizamos como saída do método, mas não sem antes mapeá-lo para um
    DTO */
    @Override
    public MusicaDto cadastrarMusica(MusicaDto musicaDto) {
        Musica musica = mapper.map(musicaDto, Musica.class);
        musica = repo.save(musica);
        MusicaDto dto = mapper.map(musica, MusicaDto.class);
        
        return dto;
    }
    



    /* pegamos o retorno do método findAll() no repositório e, através de seu stream, mapeamos
    cada um de seus objetos para um DTO, recuperando, ao final, uma nova
    lista desses DTOs. Se essa lista voltar vazia do banco de dados, não
    acontecerá erro, mas gerará como resultado uma lista vazia de DTOs */
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



    //__________________________ POR ENQUANTO NÃO MEXIIII _____________________________________
    @Override
    public List<Musica> encontrarPorAno(int anoLancamento) {
        return repo.encontrarPorAno(anoLancamento);
    }
    //_________________________________________________________________________________________

    

    @Override
    public void removerMusica(String id) {
        repo.deleteById(id);  
    }


    @Override
    public long contagem() {
        return repo.count();
    }
    

} 