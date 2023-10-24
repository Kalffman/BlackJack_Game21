# Game 21

## Definição

Este projeto disponibiliza a execução do jogo de baralho 21.

O objetivo do jogo é somar as cartas que você recebeu até chegar ao número 
21 sem excedê-lo.

As cartas numéricas têm o mesmo valor indicado na própria carta, enquanto as cartas
de figura (valete, dama e rei) valem 10 pontos cada, com exceção do ás, que 
pode valer um ponto ou 11 pontos.


### Exemplo:

| carta           | pontos  |
|-----------------|---------|
| 2 de paus       | 2       |
| 6 de copas      | 6       |
| Valete de ouro  | 10      |
| Damas de espada | 10      |
| Ás de ouro      | 1 ou 10 |


## Como subir a aplicação

Este projeto foi desenvolvido com o Java 21(LTS) que pode ser 
baixado por este [link](https://www.graalvm.org/downloads/#). Porém pode ser executado normalmente pela versão 17(LTS)

Para executar a aplicação execute o seguinte comando no diretório raiz do projeto:

```shell
./gradlew build :application:bootRun
```

## Acesso aos recursos

Estará disponível os contratos da aplicação (swagger) no seguinte endereço:

http://localhost:8080/game-21/swagger-ui.html
