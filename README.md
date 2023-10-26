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

Este projeto foi desenvolvido com o Java 21(LTS), que pode ser 
baixado por este [link](https://www.graalvm.org/downloads/#), e pode pode ser executado normalmente pela versão 17(LTS)

O projeto tem integração com o docker-compose, então vale lembrar de instalar o [docker 
desktop](https://www.docker.com/products/docker-desktop/) e deixá-lo ativo durante a execução do seguinte passo.  

Para executar a aplicação execute o seguinte comando no diretório raiz do projeto:

```shell
./gradlew build :application:bootRun
```

## Acesso aos recursos

Estará disponível os contratos da aplicação (swagger) no seguinte endereço:

http://localhost:8080/game-21/swagger-ui/index.html

## Como jogar

### 1. Crie uma nova partida

```shell
curl -X 'POST' \
  'http://localhost:8080/game-21/v1/match' \
  -H 'accept: application/json' \
  -d ''
```

Response Exemplo
```json
{
  "id": "7453c86e-ee0f-44eb-9d53-86904c9fb50e",
  "shufflerType": "MACHINE",
  "players": [],
  "round": 1,
  "started": false,
  "finished": false
}
```

Obtenha o id gerado da partida e siga os próximos passos.

### 2. Inscrever-se na partida

A partida aceita múltiplos jogadores porém deve inscrever-se um por vez. 

```shell
curl -X 'PUT' \
'http://localhost:8080/game-21/v1/match/7453c86e-ee0f-44eb-9d53-86904c9fb50e/sign-in' \
-H 'accept: application/json' \
-H 'Content-Type: application/json' \
-d '{
  "name": "jeff"
}'
```

Response Exemplo
```json
{
  "id": "7453c86e-ee0f-44eb-9d53-86904c9fb50e",
  "shufflerType": "MACHINE",
  "players": [
    {
      "name": "jeff",
      "hands": [],
      "points": 0,
      "status": "CAN_PLAY"
    }
  ],
  "round": 1,
  "started": false,
  "finished": false
}
```

### 3. Puxar a carta

A partida irá retornar os status de todos os jogadores a cada movimento de puxar a carta. 
Então poderá seguir aqui até finalizar a partida.

```shell
curl -X 'PUT' \
  'http://localhost:8080/game-21/v1/match/7453c86e-ee0f-44eb-9d53-86904c9fb50e/pull-card' \
  -H 'accept: application/json' \
  -H 'playerName: jeff'
```

Response Exemplo
```json
{
  "id": "7453c86e-ee0f-44eb-9d53-86904c9fb50e",
  "shufflerType": "MACHINE",
  "players": [
    {
      "name": "jeff",
      "hands": [
        "7 de copas",
        "3 de paus",
        "ás de copas"
      ],
      "points": 20,
      "status": "CAN_PLAY"
    }
  ],
  "round": 4,
  "started": true,
  "finished": false
}
```

Tenha um bom jogo!