# Quizzer
#### [Projeto inspirado em uma atividade acadêmica realizada na "Trilha de Desenvolvimento Android" pela Samsung Ocean ](https://github.com/manthuso/android-jogo-vivo-ou-morto)

Este é um projeto Android simples que tem duas partes: um sistema de autenticação e a base para um mini-jogo.

Atualmente, o projeto já tem uma tela funcional de Login e Cadastro de usuários, com autenticação pelo Firebase. Toda a interface dessas telas foi feita com Jetpack Compose.

O nome "Quizzer" é por causa que a ideia é ser um mini-jogo de "Vivo ou Morto" com os personagens de Rick and Morty, da qual ele puxaria algum personagem aleatorio e o jogador precisaria informar se o personagem está vivo ou morto. A base dessa implementação já esta *_quase_* pronta, o app já usa o Retrofit para se comunicar com a The Rick and Morty API e tenta buscar os dados dos personagens.

O que ainda falta fazer é a tela do jogo em si e implementar o Glide para carregar a imagem de um personagem. A partir daí, o jogador poderá responder se o personagem está vivo ou morto na série.

---

## O que Resta implementar:
  - Terminar o _CharacterCard_ 
  - Ajustar o sistema para puxar um _id_ aleatorio de personagem para o jogo
  - Implementar o Glide para fazer a leitura dos personagens
  - Terminar a função de SignOut e ForgotPassword
## 🛠️ Tecnologias Utilizadas

* **[Firebase Authentication](https://firebase.google.com/docs/auth)**: Gerencia todo o sistema de cadastro e login de usuários.
* **[Jetpack Compose](https://developer.android.com/jetpack/compose)**: Kit de ferramentas para construir a interface do usuário de forma declarativa e moderna.
* **[Retrofit](https://square.github.io/retrofit/)**: Cliente HTTP para fazer a comunicação com a API externa de forma simples e organizada.
* **[The Rick and Morty API](https://rickandmortyapi.com/)**: Fonte de dados dos personagens para o quiz.
* **[Glide](https://github.com/bumptech/glide)**: Biblioteca para carregamento e cache de imagens (a ser implementada).

## Agradecimentos:
  - Professor Mario Scaramuzzini pela ideia, mentoria durante as aulas android, e pelo incentivo :) <3
