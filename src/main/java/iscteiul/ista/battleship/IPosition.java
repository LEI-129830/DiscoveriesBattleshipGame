package iscteiul.ista.battleship;

/**
 * Interface que define o contrato para a representação de uma coordenada
 * e gestão do respetivo estado no tabuleiro do jogo Batalha Naval.
 * <p>
 * Combina a especificação espacial (linha e coluna) com o ciclo de vida
 * da célula (presença de embarcação e histórico de disparos recebidos).
 * </p>
 *
 */
public interface IPosition {

    /**
     * Obtém o índice da linha correspondente a esta posição na grelha.
     *
     * @return Valor inteiro representativo da linha (eixo vertical, base 0).
     */
    int getRow();

    /**
     * Obtém o índice da coluna correspondente a esta posição na grelha.
     *
     * @return Valor inteiro representativo da coluna (eixo horizontal, base 0).
     */
    int getColumn();

    /**
     * Verifica a igualdade espacial entre esta instância e outro objeto.
     * <p>
     * Duas posições devem ser consideradas equivalentes se e só se
     * partilharem exatamente os mesmos índices de linha e coluna.
     * </p>
     *
     * @param other Objeto com o qual esta posição será comparada.
     * @return {@code true} se o objeto fornecido for uma instância de {@code IPosition}
     *         com coordenadas idênticas; {@code false} caso contrário.
     */
    boolean equals(Object other);

    /**
     * Determina se esta posição é adjacente a outra posição na grelha.
     * <p>
     * Considera-se adjacente qualquer célula vizinha contígua, quer por
     * ligação ortogonal (horizontal/vertical) quer por ligação diagonal.
     * </p>
     *
     * @param other Posição de destino a ser avaliada em relação a esta.
     * @return {@code true} se as posições forem contíguas no tabuleiro;
     *         {@code false} caso contrário ou se {@code other} for nulo.
     */
    boolean isAdjacentTo(IPosition other);

    /**
     * Altera o estado da célula, marcando-a como ocupada por uma embarcação.
     */
    void occupy();

    /**
     * Regista a ocorrência de um disparo direcionado a esta coordenada.
     */
    void shoot();

    /**
     * Avalia se a coordenada atual contém uma embarcação.
     *
     * @return {@code true} se a posição estiver ocupada por um segmento de navio;
     *         {@code false} se for água desimpedida.
     */
    boolean isOccupied();

    /**
     * Avalia se a coordenada atual já foi alvo de um disparo de artilharia.
     *
     * @return {@code true} se a coordenada já foi alvejada;
     *         {@code false} caso ainda não tenha recebido disparos.
     */
    boolean isHit();
}