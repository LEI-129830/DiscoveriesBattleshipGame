/**
 *
 */
package iscteiul.ista.battleship;

/**
 * @author fba
 */
public interface IPosition {

    //Retorna o Indice da Linha
    int getRow();

    //Retorna o Indice da Coluna
    int getColumn();

    //Faz a comparação e avalia a igualdade de coordenadas entre este objeto e outro
    boolean equals(Object other);

    /**
     * Valida a proximidade imediata em relação a outra posição (vizinhança ortogonal ou diagonal).
     * Crítico para impor regras de colocação de navios (ex: impedir navios colados).
     */
    boolean isAdjacentTo(IPosition other);

    //Responsavel pela Transição de Estado, marca se a posição é parte de, ou, um navio
    void occupy();

    //Ao Disparar, faz a Transição de estado. Regista o disparo nesta coordenada
    void shoot();

    //Designa se uma casa está ocupada, retorna true se for um barco/pedaço de barco, ou false se for agua
    boolean isOccupied();

    //Designa se um navio/pedaço de navio que a casa contem já foi atingido, retornando True se sim, False se não
    boolean isHit();
}
