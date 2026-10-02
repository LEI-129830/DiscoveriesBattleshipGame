package iscteiul.ista.battleship;

/**
 * Galeão: Navio de 5 blocos com formato em 'T'.
 * Atenção à geometria: A ocupação na matriz muda significativamente consoante a orientação (bearing).
 */
public class Galleon extends Ship {

    // Tamanho fixo de 5 posições.
    private static final Integer SIZE = 5;
    private static final String NAME = "Galeao";

    /**
     * Construtor do Galeão.
     *
     * @param bearing Bússola com a direção (N, S, E, W).
     * @param pos Posição âncora usada como ponto de partida para calcular a geometria do barco.
     * @throws NullPointerException Se a direção (bearing) for nula, para evitar estoiros no switch.
     * @throws IllegalArgumentException Se for passada uma direção não mapeada.
     */
    public Galleon(Compass bearing, IPosition pos) throws IllegalArgumentException {
        super(Galleon.NAME, bearing, pos);

        // Fail-fast
        if (bearing == null)
            throw new NullPointerException("ERROR! invalid bearing for the galleon");

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

    /*
     * (non-Javadoc)
     *
     * @see battleship.Ship#getSize()
     */
    @Override
    public Integer getSize() {
        return Galleon.SIZE;
    }

    /**
     * Desenha o Galeão virado a Norte.
     * Topo horizontal (3 blocos) na linha da âncora, seguido da haste a descer.
     *
     * @param pos Coordenada base (canto superior esquerdo do "T").
     */
    private void fillNorth(IPosition pos) {
        for (int i = 0; i < 3; i++) {
            getPositions().add(new Position(pos.getRow(), pos.getColumn() + i));
        }
        getPositions().add(new Position(pos.getRow() + 1, pos.getColumn() + 1));
        getPositions().add(new Position(pos.getRow() + 2, pos.getColumn() + 1));
    }

    /**
     * Desenha o Galeão virado a Sul.
     * Haste vertical primeiro, base horizontal em baixo.
     * Cuidado: Risco de index negativo na coluna quando j=2 (pos.getColumn() - 1).
     *
     * @param pos Coordenada base (topo da haste vertical).
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
     * Desenha o Galeão virado a Este.
     * Cuidado: Risco de index negativo na coluna no mastro central (pos.getColumn() - 2).
     *
     * @param pos Coordenada base (ponta superior).
     */
    private void fillEast(IPosition pos) {
        getPositions().add(new Position(pos.getRow(), pos.getColumn()));
        for (int i = 1; i < 4; i++) {
            getPositions().add(new Position(pos.getRow() + 1, pos.getColumn() + i - 3));
        }
        getPositions().add(new Position(pos.getRow() + 2, pos.getColumn()));
    }

    /**
     * Desenha o Galeão virado a Oeste.
     *
     * @param pos Coordenada base (ponta superior).
     */
    private void fillWest(IPosition pos) {
        getPositions().add(new Position(pos.getRow(), pos.getColumn()));
        for (int i = 1; i < 4; i++) {
            getPositions().add(new Position(pos.getRow() + 1, pos.getColumn() + i - 1));
        }
        getPositions().add(new Position(pos.getRow() + 2, pos.getColumn()));
    }

}