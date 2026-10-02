/**
 * Define as operações principais de um jogo de Batalha Naval.
 * Responsável por gerir os tiros efetuados e fornecer informações sobre o estado
 * atual do jogo e da frota.
 *
 * @author fba
 * @author Martim Correia Nº129843
 */
package iscteiul.ista.battleship;

import java.util.List;

public interface IGame {
    /**
     * Efetua um disparo na posição especificada do tabuleiro.
     * Deve atualizar o estado do jogo consoante o tiro seja válido, repetido,
     * acerte num navio ou resulte num afundamento do respetivo navio.
     *
     * @param pos A posição alvo do disparo.
     * @return O objeto IShip se este tiro resultar no afundamento desse navio; null caso contrário.
     */
    IShip fire(IPosition pos);
    /**
     * Obtém o histórico de todos os tiros válidos efetuados durante o jogo.
     *
     * @return Uma lista de IPosition contendo as coordenadas dos tiros.
     */
    List<IPosition> getShots();
    /**
     * Obtém o número total de tiros que foram disparados para posições já anteriormente atacadas.
     *
     * @return O número de tiros repetidos.
     */
    int getRepeatedShots();
    /**
     * Obtém o número total de tiros inválidos.
     *
     * @return O número de tiros inválidos.
     */
    int getInvalidShots();
    /**
     * Obtém o número total de tiros que acertaram com sucesso em partes de navios.
     *
     * @return O número de acertos (tiros certeiros).
     */
    int getHits();
    /**
     * Obtém o número total de navios da frota que já foram afundados.
     *
     * @return O número de navios afundados.
     */
    int getSunkShips();
    /**
     * Obtém o número de navios da frota que ainda não foram totalmente afundados.
     *
     * @return O número de navios restantes.
     */
    int getRemainingShips();
    /**
     * Imprime na consola uma representação visual do tabuleiro, assinalando todos os tiros válidos a efetuar.
     */
    void printValidShots();
    /**
     * Imprime na consola uma representação visual do tabuleiro, revelando o posicionamento atual de toda a frota.
     */
    void printFleet();
}