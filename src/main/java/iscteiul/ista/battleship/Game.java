/**
 *
 */
package iscteiul.ista.battleship;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa uma sessão do jogo Batalha Naval.
 * Gere a frota do jogador, os tiros disparados e as estatísticas do jogo
 * (tiros certeiros, afundamentos, tiros inválidos e repetidos).
 *
 * @author fba
 * @author [Martim Correia Nº129843]
 */
public class Game implements IGame {
    private IFleet fleet;
    private List<IPosition> shots;

    private Integer countInvalidShots;
    private Integer countRepeatedShots;
    private Integer countHits;
    private Integer countSinks;


    /**
     * Constrói uma nova instância do Jogo com a frota especificada.
     *
     * @param fleet A frota de navios a ser usada no jogo.
     */
    public Game(IFleet fleet) {
        shots = new ArrayList<>();
        countInvalidShots = 0;
        countRepeatedShots = 0;
        this.fleet = fleet;
    }

    /**
     * Dispara um tiro na posição especificada.
     * Atualiza as estatísticas do jogo (inválidos, repetidos, acertos e afundamentos) em conformidade.
     *
     * @param pos A posição no tabuleiro onde disparar.
     * @return O objeto IShip se o tiro resultou no afundamento de um navio; null caso contrário.
     */
    @Override
    public IShip fire(IPosition pos) {
        if (!validShot(pos))
            countInvalidShots++;
        else { // valid shot!
            if (repeatedShot(pos))
                countRepeatedShots++;
            else {
                shots.add(pos);
                IShip s = fleet.shipAt(pos);
                if (s != null) {
                    s.shoot(pos);
                    countHits++;
                    if (!s.stillFloating()) {
                        countSinks++;
                        return s;
                    }
                }
            }
        }
        return null;
    }

    /**
     * Obtém a lista de todos os tiros válidos e não repetidos disparados até ao momento.
     *
     * @return Uma lista de IPosition que representa os tiros válidos.
     */
    @Override
    public List<IPosition> getShots() {
        return shots;
    }

    /**
     * Obtém o número total de tiros repetidos disparados no jogo.
     *
     * @return O número de tiros repetidos.
     */
    @Override
    public int getRepeatedShots() {
        return this.countRepeatedShots;
    }

    /**
     * Obtém o número total de tiros inválidos (fora dos limites) disparados no jogo.
     *
     * @return O número de tiros inválidos.
     */
    @Override
    public int getInvalidShots() {
        return this.countInvalidShots;
    }

    /**
     * Obtém o número total de tiros que acertaram em navios.
     *
     * @return O número de tiros certeiros (acertos).
     */
    @Override
    public int getHits() {
        return this.countHits;
    }

    /**
     * Obtém o número total de navios que foram totalmente afundados.
     *
     * @return O número de navios afundados.
     */
    @Override
    public int getSunkShips() {
        return this.countSinks;
    }

    /**
     * Obtém o número de navios que ainda estão a flutuar (não afundados).
     *
     * @return O número de navios restantes.
     */
    @Override
    public int getRemainingShips() {
        List<IShip> floatingShips = fleet.getFloatingShips();
        return floatingShips.size();
    }
    /**
     * Verifica se uma determinada posição está dentro dos limites do tabuleiro.
     *
     * @param pos A posição a validar.
     * @return true se a posição estiver dentro do tabuleiro, false caso contrário.
     */
    private boolean validShot(IPosition pos) {
        return (pos.getRow() >= 0 && pos.getRow() <= Fleet.BOARD_SIZE && pos.getColumn() >= 0
                && pos.getColumn() <= Fleet.BOARD_SIZE);
    }
    /**
     * Verifica se um tiro na posição dada já foi disparado anteriormente.
     *
     * @param pos A posição a verificar.
     * @return true se a posição já estiver na lista de tiros, false caso contrário.
     */
    private boolean repeatedShot(IPosition pos) {
        for (int i = 0; i < shots.size(); i++)
            if (shots.get(i).equals(pos))
                return true;
        return false;
    }

    /**
     * Imprime uma representação visual do tabuleiro na consola, colocando um
     * marcador específico nas posições indicadas.
     *
     * @param positions Uma lista de posições a serem marcadas no tabuleiro.
     * @param marker O carácter usado para marcar as posições fornecidas.
     */
    public void printBoard(List<IPosition> positions, Character marker) {
        char[][] map = new char[Fleet.BOARD_SIZE][Fleet.BOARD_SIZE];

        for (int r = 0; r < Fleet.BOARD_SIZE; r++)
            for (int c = 0; c < Fleet.BOARD_SIZE; c++)
                map[r][c] = '.';

        for (IPosition pos : positions)
            map[pos.getRow()][pos.getColumn()] = marker;

        for (int row = 0; row < Fleet.BOARD_SIZE; row++) {
            for (int col = 0; col < Fleet.BOARD_SIZE; col++)
                System.out.print(map[row][col]);
            System.out.println();
        }

    }


    /**
     * Imprime o tabuleiro mostrando todos os tiros válidos que foram disparados, marcados com 'X'.
     */
    public void printValidShots() {
        printBoard(getShots(), 'X');
    }

    /**
     * Imprime o tabuleiro mostrando a disposição atual da frota, marcada com '#'.
     */
    public void printFleet() {
        List<IPosition> shipPositions = new ArrayList<IPosition>();

        for (IShip s : fleet.getShips())
            shipPositions.addAll(s.getPositions());

        printBoard(shipPositions, '#');
    }

}