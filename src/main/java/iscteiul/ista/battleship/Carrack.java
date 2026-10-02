package iscteiul.ista.battleship;

/**
 * Nau: Barco linear de 3 posições.
 * Nota técnica: O switch ignora rotações de 180º (N/S e E/W geram os mesmos blocos).
 */
public class Carrack extends Ship {

    private static final Integer SIZE = 3;
    private static final String NAME = "Nau";

    /**
     * Construtor da Nau.
     *
     * @param bearing Direção do navio. Falta validação de null aqui face ao Galleon.
     * @param pos Coordenada âncora para iniciar o desenho.
     * @throws IllegalArgumentException Se a direção passada não for suportada.
     */
    public Carrack(Compass bearing, IPosition pos) throws IllegalArgumentException {
        super(Carrack.NAME, bearing, pos);

        switch (bearing) {
            case NORTH:
            case SOUTH:
                for (int r = 0; r < SIZE; r++)
                    getPositions().add(new Position(pos.getRow() + r, pos.getColumn()));
                break;
            case EAST:
            case WEST:
                for (int c = 0; c < SIZE; c++)
                    getPositions().add(new Position(pos.getRow(), pos.getColumn() + c));
                break;
            default:
                throw new IllegalArgumentException("ERROR! invalid bearing for the carrack");
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see battleship.Ship#getSize()
     */
    @Override
    public Integer getSize() {
        return Carrack.SIZE;
    }

}