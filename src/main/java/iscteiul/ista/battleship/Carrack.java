/**
 *
 */
package iscteiul.ista.battleship;

public class Carrack extends Ship {
    private static final Integer SIZE = 3;
    private static final String NAME = "Nau";

    /**
     * @param bearing
     * @param pos
     */
    public Carrack(Compass bearing, IPosition pos) throws IllegalArgumentException {
        super(Carrack.NAME, bearing, pos);

        //direção -> cálculo da geometria do navio na grelha
        switch (bearing) {
            case NORTH:
            case SOUTH:
                // Se for NORTE ou SUL, o navio é criado numa linha vertical para baixo
                for (int r = 0; r < SIZE; r++)
                    // Incrementa as linhas. A coluna mantém-se estátic
                    getPositions().add(new Position(pos.getRow() + r, pos.getColumn()));
                break;
            case EAST:
            case WEST:
                // Se for ESTE ou OESTE, o navio é desenhado numa linha horizontal para a direita
                for (int c = 0; c < SIZE; c++)
                    //Apenas as colunas são incrementadas. A linha mantém se estática
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
    }       //Retorna o 3 Blocos que a Carrack ocupa

}
