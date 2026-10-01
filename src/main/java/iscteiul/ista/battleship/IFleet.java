/**
 *
 */
package iscteiul.ista.battleship;

import java.util.List;

/**
 * Representa uma frota de navios posicionados num tabuleiro de jogo
 * <p>
 * Uma frota gere um conjunto de navios geridos por um jogador,
 * garantindo que os navios ficam todos dentro do tabuleiro e não se sobrepoem a outros navios
 * e disponbiliza operações de consulta sobre os navios que contém (por categoria, estado de flutuação, ou posição)
 */
public interface IFleet {
    /** Tamanho do tabuleiro (o tabuleiro é quadrado) */
    Integer BOARD_SIZE = 10;

    /** Número máximo de navios por Fleet */
    Integer FLEET_SIZE = 10;

    /**
     * Devolve todos os navios atualmente na frota
     * @return lista de navios pertencentes a esta frota.
     */
    List<IShip> getShips();

    /**
     * Tenta adicionar o navio à frota
     * <p>
     * O navio só é adicionado se a frota não estiver cheia, se o navio couber no tabuleiro
     * e se ele não se sobrepor a outro navio
     * @param s o navio a adicionar
     * @return {@code true} se o navio foi adicionado com sucesso, {@code false} caso contrário
     */
    boolean addShip(IShip s);

    /**
     * Devolve todos os navios da frota pertencentes a uma dada categoria
     * @param category categoria de navios a filtrar (ex: "Galeão", "Barca", etc.)
     * @return Devolve uma lista de navios que pertencem à categoria inserida
     */
    List<IShip> getShipsLike(String category);

    /**
     * Devolve todas os navios da frota que ainda não foram afundados
     * @return lista de navios a flutuar
     */
    List<IShip> getFloatingShips();

    /**
     * Devolve o navio, se existir, na posição indicada
     * @param pos posição a verificar
     * @return o navio que ocupa {@code pos} ou {@code null} se nenhum navio a ocupar
     */
    IShip shipAt(IPosition pos);

    /**
     * Imprime o estado atual da frota, os navios a flutuar
     * e os navios agrupados por categoria
     */
    void printStatus();
}
