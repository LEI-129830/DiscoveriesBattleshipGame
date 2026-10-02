package iscteiul.ista.battleship;

/**
 * Representa um Galeão (Galleon) no jogo Batalha Naval.
 * <p>
 * O Galeão é uma embarcação de tamanho 5 com geometria não linear (formato em T).
 * A distribuição das suas posições na matriz de jogo depende da orientação cardeal
 * fornecida na sua instanciação.
 * </p>
 *
 * @see Ship
 * @see IPosition
 * @see Compass
 */
public class Galleon extends Ship {

    /** Número fixo de células ocupadas pelo Galeão. */
    private static final Integer SIZE = 5;

    /** Designação textual da embarcação. */
    private static final String NAME = "Galeao";

    /**
     * Constrói e inicializa um Galeão com orientação e coordenada de origem especificadas.
     * <p>
     * Delega a montagem da geometria do casco em T para métodos especializados
     * consoante a orientação cardeal passada por argumento.
     * </p>
     *
     * @param bearing Ponto cardeal de orientação ({@link Compass}).
     * @param pos Ponto de ancoragem a partir do qual as restantes células são calculadas.
     * @throws NullPointerException Se {@code bearing} for {@code null}.
     * @throws IllegalArgumentException Se for fornecido um rumo não reconhecido pelo algoritmo.
     */
    public Galleon(Compass bearing, IPosition pos) throws IllegalArgumentException {
        super(Galleon.NAME, bearing, pos);

        if (bearing == null) {
            throw new NullPointerException("ERROR! invalid bearing for the galleon");
        }

        switch (bearing) {
            case NORTH:
                fillNorth(pos);
                break;
            case EAST:
                fillEast(pos);
                break;
            case SOUTH:
                fillSouth(pos);
                break;
            case WEST:
                fillWest(pos);
                break;
            default:
                throw new IllegalArgumentException("ERROR! invalid bearing for the galleon");
        }
    }

    /**
     * Devolve a dimensão total ocupada pelo Galeão.
     *
     * @return O número de blocos do navio (sempre 5).
     */
    @Override
    public Integer getSize() {
        return Galleon.SIZE;
    }

    /**
     * Preenche as 5 coordenadas da embarcação com orientação Norte (formato de T vertical padrão).
     *
     * @param pos Coordenada de topo esquerda da barra horizontal superior.
     */
    private void fillNorth(IPosition pos) {
        for (int i = 0; i < 3; i++) {
            getPositions().add(new Position(pos.getRow(), pos.getColumn() + i));
        }
        getPositions().add(new Position(pos.getRow() + 1, pos.getColumn() + 1));
        getPositions().add(new Position(pos.getRow() + 2, pos.getColumn() + 1));
    }

    /**
     * Preenche as 5 coordenadas da embarcação com orientação Sul (formato de T invertido).
     *
     * @param pos Coordenada de topo da haste vertical.
     */
    private void fillSouth(IPosition pos) {
        for (int i = 0; i < 2; i++) {
            getPositions().add(new Position(pos.getRow() + i, pos.getColumn()));
        }
        for (int j = 2; j < 5; j++) {
            getPositions().add(new Position(pos.getRow() + 2, pos.getColumn() + j - 3));
        }
    }

    /**
     * Preenche as 5 coordenadas da embarcação com orientação Este (T voltado para a esquerda).
     *
     * @param pos Coordenada da extremidade superior da barra vertical traseira.
     */
    private void fillEast(IPosition pos) {
        getPositions().add(new Position(pos.getRow(), pos.getColumn()));
        for (int i = 1; i < 4; i++) {
            getPositions().add(new Position(pos.getRow() + 1, pos.getColumn() + i - 3));
        }
        getPositions().add(new Position(pos.getRow() + 2, pos.getColumn()));
    }

    /**
     * Preenche as 5 coordenadas da embarcação com orientação Oeste (T voltado para a direita).
     *
     * @param pos Coordenada da extremidade superior da barra vertical traseira.
     */
    private void fillWest(IPosition pos) {
        getPositions().add(new Position(pos.getRow(), pos.getColumn()));
        for (int i = 1; i < 4; i++) {
            getPositions().add(new Position(pos.getRow() + 1, pos.getColumn() + i - 1));
        }
        getPositions().add(new Position(pos.getRow() + 2, pos.getColumn()));
    }
}