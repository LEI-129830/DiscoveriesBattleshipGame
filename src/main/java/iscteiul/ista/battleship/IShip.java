/**
 *
 */
package iscteiul.ista.battleship;

import java.util.List;

public interface IShip {
    /**
     * Retorna a categoria do navio
     *
     * @return a categoria do navio
     */
    String getCategory();

    /**
     * Retorna o tamanho do navio, corresponde ao numero de posicoes que ocupa no tabuleiro
     *
     * @return a tamanho do navio
     */
    Integer getSize();

    /**
     * Retorna todas as posicoes ocupadas pelo navio
     *
     * @return As posicoes ocupadas pelo navio
     */
    List<IPosition> getPositions();

    /**
     * Retorna a posicao de referencia do navio utilizada para colocar o navio no tabuleiro
     *
     * @return A posicao de referencia do navio
     */
    IPosition getPosition();

    /**
     * Retorna a direcao na qual o navio esta orientado
     *
     * @return A orientacao/direcao do navio
     */
    Compass getBearing();

    /**
     * Indica se o navio ainda tem pelo menos uma posicao que nao foi atingida
     *
     * @return True se o navio ainda estiver a flutuar, false se tiver afundado
     */
    boolean stillFloating();

    /**
     * Retorna a menor linha ocupada pelo navio
     *
     * @return A linha da posicao mais a norte/superior do navio
     */
    int getTopMostPos();

    /**
     * Retorna a maior linha ocupada pelo navio
     *
     * @return A linha da posicao mais a sul/inferior do navio
     */
    int getBottomMostPos();

    /**
     * Retorna a menor coluna ocupada pelo navio
     *
     * @return A coluna da posicao mais a oeste do navio
     */
    int getLeftMostPos();

    /**
     * Retorna a maior coluna ocupada pelo navio
     *
     * @return A coluna da posicao mais a este do navio
     */
    int getRightMostPos();

    /**
     * Verifica se o navio ocupa uma dada posicao do tabuleiro
     *
     * @param pos A posicao a ser verificada
     * @return True se o navio ocupa a posicao dada, false caso contrario
     */
    boolean occupies(IPosition pos);

    /**
     * Verifica se este navio  esta demasiado perto de outro navio.
     * Dois navios estao demasiado perto um do outro quando pelo menos uma posicao de um navio
     * e adjacente a uma posicao do outro
     *
     * @param other O outro navio
     * @return
     */
    boolean tooCloseTo(IShip other);

    /**
     * Verifica se este navio possui uma posicao que e adjacente a uma dada posicao
     *
     * @param pos A posicao a verificar
     * @return True se a posicao esta demasiado perto do navio, false caso contrario
     */
    boolean tooCloseTo(IPosition pos);

    /**
     * Dispara um tiro na posicao especificada. Se essa posicao pertencer a este
     * navio, a posicao correspondente do navio e marcada como atingida
     *
     * @param pos A posicao do navio a ser atirada
     */
    void shoot(IPosition pos);
}
