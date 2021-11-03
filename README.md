## Atividade avaliativa do módulo de Backend

Nessa atividade, vamos construir um web service RESTful, fazendo um CRUD de
nossas músicas preferidas e comunicando com um banco de dados MongoDB.
Usaremos todos os conceitos vistos das aulas 01 a 08 desse módulo.

**1) Descreva aqui o comando para criação do banco (utilizado no mongosh ou compass), que deverá ser chamado tech4music**

**2-) Descreva o comando para criar a coleção musicas e já inserir 3 músicas abaixo:**

titulo: Forever <br />
artista: Kiss <br />
album: Hot in the Shade <br />
genero: Rock <br />
anoLancamento: 1989 <br />
compositor: Paul Stanley <br />
<br />
titulo: Algo parecido <br />
artista: Skank <br />
album: Os três primeiros <br />
genero: Pop <br />
anoLancamento: 2018 <br />
compositor: Samuel Rosa <br />
<br />
titulo: O que me importa <br />
artista: Marisa Monte <br />
album: Memórias, crônicas e declarações de amor <br />
genero: MPB <br />
anoLancamento: 2000 <br />
compositor: Jose de Ribamar Cury <br />
 
-------------------------------------------------------------------

**3-) Crie um projeto no VS Code, utilizando as extensões Spring Web e Spring Data MongoDB. Crie os pacotes model, repository, service, shared e controller, bem como as classes necessárias para realizar cada funcionalidade esperada no CRUD:**

- model <br />
Musica.java

- repository <br />
MusicaRepository.java

- service <br />
MusicaService.java <br />
MusicaServiceImpl.java

- shared <br />
MusicaDto.java

- controller <br />
MusicaController.java

<br />
Faça a implementação, testando sua aplicação através do Postman <br />
Depois, faça o commit do projeto no Github e encaminhe o link, juntamente com a
resposta dos itens 1 e 2.

