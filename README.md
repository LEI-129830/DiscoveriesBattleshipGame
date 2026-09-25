# Battleship

## Sobre
A Batalha Naval é um jogo de estratégia para dois jogadores, no qual cada participante posiciona secretamente os seus navios numa 
grelha e tenta descobrir a localização da frota adversária através de ataques coordenados. O objetivo é afundar todos os navios do 
oponente antes que este consiga destruir os seus, combinando estratégia, lógica e sorte.

Para mais informações sobre o jogo, consulte [aqui](https://pt.wikipedia.org/wiki/Batalha_naval_(jogo)).

## Identificação da Equipa
**Nickname do Grupo:** [Lubrificadores de softwares]
**Curso:** [LEI] 2026/2027

| Número de Aluno | Nome do Aluno |
| :--- | :--- |
| [129843] | [Martim Correia] |
| [129834] | [Rafael Silva] |
| [129850] | [Gonçalo Sobral] |
| [129830] | [Flávio Santos] |
## Frota dos Descobrimentos

| Navio Atual (Batalha Naval) | Navio Descobrimentos                                | Dimensão | Quantidade |
| :--- |:----------------------------------------------------| :--- | :--- |
| Porta-aviões | [Galeão](https://pt.wikipedia.org/wiki/Gale%C3%A3o) | 5 | 1 |
| Navio de 4 canhões | [Fragata](https://pt.wikipedia.org/wiki/Fragata)    | 4 | 1 |
| Navio de 3 canhões | [Nau](https://pt.wikipedia.org/wiki/Nau)            | 3 | 2 |
| Navio de 2 canhões | [Caravela](https://pt.wikipedia.org/wiki/Caravela)  | 2 | 3 |
| Submarino | [Barca](https://pt.wikipedia.org/wiki/Barca)        | 1 | 4 |

## Exemplo de Mapa

Durante o jogo, cada jogador vê duas grelhas: **o seu mar**, onde estão os seus navios e os tiros que o adversário acertou, e **o mar do adversário**, onde só é visível o resultado dos seus próprios tiros.

```
        O MEU MAR                 MAR DO ADVERSÁRIO
    1 2 3 4 5 6 7 8 9 10          1 2 3 4 5 6 7 8 9 10
 1  ~ N N N ~ ~ ~ ~ C ~        1  ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
 2  ~ N X N ~ ~ ~ ~ C ~        2  ~ ~ ~ O ~ ~ ~ ~ ~ ~
 3  ~ ~ ~ ~ ~ ~ ~ ~ ~ ~        3  ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
 4  G G G G G ~ ~ ~ ~ ~        4  ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
 5  ~ ~ ~ ~ ~ ~ F ~ ~ C        5  ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
 6  C ~ ~ O ~ ~ F ~ ~ C        6  ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
 7  C ~ ~ ~ ~ ~ F ~ ~ ~        7  ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
 8  ~ ~ ~ B ~ ~ F ~ ~ ~        8  ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
 9  ~ B ~ ~ ~ ~ ~ ~ ~ ~        9  ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
10  ~ ~ ~ B ~ ~ B ~ ~ ~       10  ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
```

**Legenda:**

| Símbolo | Significado |
| :--- | :--- |
| `~` | Água |
| `G` | Galeão |
| `F` | Fragata |
| `N` | Nau |
| `C` | Caravela |
| `B` | Barca |
| `X` | Tiro que acertou num navio |
| `O` | Tiro que falhou |

No mar do adversário, apenas os símbolos `X` e `O` são visíveis - a posição dos navios inimigos nunca é revelada.
