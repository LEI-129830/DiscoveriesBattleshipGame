package iscteiul.ista.battleship;

/**
 * Representa uma Nau (Carrack) na mecânica do jogo Batalha Naval.
 * <p>
 * Trata-se de uma embarcação linear rígida de dimensão 3 que se estende
 * de forma unilinear a partir de um ponto âncora, variando conforme a orientação.
 * </p>
 *
 * @see Ship
 * @see IPosition
 * @see Compass
 */
public class Carrack extends Ship {

    /** Número fixo de células ocupadas pela Nau. */
    private static final Integer SIZE = 3;

    /** Designação textual da embarcação para efeitos de registo e apresentação. */
    private static final String NAME = "Nau";

    /**
     * Constrói uma nova Nau com uma orientação e posição âncora definidas.
     * <p>
     * Consoante o rumo ({@link Compass}) fornecido, calcula e adiciona as
     * 3 posições contíguas ocupadas pelo navio à coleção interna herdada.
     * </p>
     *
     * @param bearing Orientação cardeal da embarcação ({@code NORTH}, {@code SOUTH}, {@code EAST} ou {@code WEST}).
     * @param pos Posição inicial (âncora) de referência a partir da qual o corpo é gerado.
     * @throws NullPointerException Se a orientação {@code bearing} for nula.
     * @throws IllegalArgumentException Se o rumo especificado não corresponder a uma direção válida suportada.
     */
    public Carrack(Compass bearing, IPosition pos) throws IllegalArgumentException {
        super(Carrack.NAME, bearing, pos);

        if (bearing == null) {
            throw new NullPointerException("ERROR! invalid bearing for the carrack");
        }

        switch (bearing) {
            case NORTH:
            case SOUTH:
                for (int r = 0; r < SIZE; r++) {
                    getPositions().add(new Position(pos.getRow() + r, pos.getColumn()));
                }
                break;
            case EAST:
            case WEST:
                for (int c = 0; c < SIZE; c++) {
                    getPositions().add(new Position(pos.getRow(), pos.getColumn() + c));
                }
                break;
            default:
                throw new IllegalArgumentException("ERROR! invalid bearing for the carrack");
        }
    }

    /**
     * Devolve o tamanho da Nau.
     *
     * @return O número de posições ocupadas pela embarcação (sempre 3).
     */
    @Override
    public Integer getSize() {
        return Carrack.SIZE;
    }
}