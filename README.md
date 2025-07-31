# Jetpack API Data Visualizer

_Um aplicativo Android de estudo para demonstrar autenticação, consumo de API e UI moderna com Jetpack Compose._

---

## Sobre o Projeto

Este projeto foi criado com o objetivo principal de estudar e aplicar conceitos modernos de desenvolvimento Android. Ele serve como uma demonstração prática das seguintes habilidades:

* **Autenticação de Usuários (Firebase Auth)**.
* **Consumo de API REST**.
* **UI Declarativa (Jetpack Compose)**.
* **Navegação de telas(Navegation Compose)**

O projeto utiliza a [The Rick and Morty API](https://rickandmortyapi.com/) para buscar personagens e exibir suas informações e imagens.

> Este projeto foi inspirado em uma atividade acadêmica da "Trilha de Desenvolvimento Android" oferecida pela [Samsung Ocean](https://github.com/manthuso/android-jogo-vivo-ou-morto)
## Screenshots

| Tela de Login | Tela de Cadastro | Tela Principal |
| :-----------: | :--------------: | :-----------: |
| <img width="180" height="380" alt="image" src="https://github.com/user-attachments/assets/4cd198cc-b6dd-4833-9dd0-4ad5a94e467a" /> | <img width="180" height="380" alt="image" src="https://github.com/user-attachments/assets/f4ee9b10-9fdb-4379-a539-9dbef85d15db" /> | <img width="180" height="380" alt="image" src="https://github.com/user-attachments/assets/d70a244a-8598-414c-8cb0-ebaa92df05fd" /> |
  
   
 

## Tecnologias

* **[Firebase Authentication](https://firebase.google.com/docs/auth)**: Utilizado para gerenciar todo o sistema de cadastro e login de usuários.
* **[Jetpack Compose](https://developer.android.com/jetpack/compose)**: Responsável pela construção de 100% da interface.
* **[Retrofit](https://square.github.io/retrofit/)**: Cliente HTTP para realizar a comunicação com a API REST do Rick and Morty.
* **[Coil](https://coil-kt.github.io/coil/compose/)**: Biblioteca para carregamento assíncrono de imagens.

## Future Features

A ideia original para este projeto é evoluí-lo para um jogo de "Vivo ou Morto".:

-   [ ] Implementar a lógica do jogo, puxando um `id` de personagem aleatório e pedindo para o jogador informar se o personagem da serie se encontra vivo ou morto.
-   [ ] Finalizar a função de "Esqueci minha senha".
-   [ ] Adicionar tratamento de erros para chamadas de rede.
-   [ ] Criar testes unitários para os ViewModels.

## Agradecimentos

* Agradeço ao professor **Mario Scaramuzzini** pelo grande incentivo e mentoria :) .
