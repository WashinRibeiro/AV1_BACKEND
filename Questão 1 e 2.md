**1 - Descreva aqui o comando para criação do banco (utilizado no mongosh ou compass), que deverá ser chamado tech4music**

> use tech4music <br />

< 'switched to db tech4music'

----------------------------------------------------------------

**2 - Descreva o comando para criar a coleção musicas e já inserir 3 músicas abaixo:**

> db.musicas.insert([ <br />
  { <br />
  titulo: 'Forever', <br />
  artista: 'Kiss', <br />
  album: 'Hot in the Shade', <br />
  genero: 'Rock', <br />
  anoLancamento: 1989, <br />
  compositor: 'Paul Stanley' <br />
  }, <br />
  { <br />
  titulo: 'Algo parecido', <br />
  artista: 'Skank', <br />
  album: 'Os três primeiros', <br />
  genero: 'Pop', <br />
  anoLancamento: 2018, <br />
  compositor: 'Samuel Rosa' <br />
  }, <br />
  { <br />
  titulo: 'O que me importa', <br />
  artista: 'Marisa Monte', <br />
  album: 'Memórias, crônicas e declarações de amor', <br />
  genero: 'MPB', <br />
  anoLancamento: 2000, <br />
  compositor: 'Jose de Ribamar Cury' <br />
  } <br />
]) <br />

< { acknowledged: true, <br />
  insertedIds: <br />
   { '0': ObjectId("617e9f51e5ec986c5ca1bd59"), <br />
     '1': ObjectId("617e9f51e5ec986c5ca1bd5a"), <br />
     '2': ObjectId("617e9f51e5ec986c5ca1bd5b") } }