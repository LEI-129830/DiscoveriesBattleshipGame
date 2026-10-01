/**
 *
 */
package iscteiul.ista.battleship;

public class Galleon extends Ship {
    private static final Integer SIZE = 5;          //Tamanho imutável da embarcação
    private static final String NAME = "Galeao";    //Nome da embarcação

    /**
     * @param bearing
     * @param pos
     */

    //Construtor
    public Galleon(Compass bearing, IPosition pos) throws IllegalArgumentException {
        //Inicializa o Barco na superclasse
        super(Galleon.NAME, bearing, pos);

        if (bearing == null)        //previne a propagação de Null Pointer
            throw new NullPointerException("ERROR! invalid bearing for the galleon");
        //Calculo do "Shape" para as funções privadas de acordo com a direção a seguir
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
     * Desenha um "T" apontado a Norte.
     * Ex: [0,0] [0,1] [0,2]
     *           [1,1]
     *           [2,1]
     */
    private void fillNorth(IPosition pos) {
        //Linha Horizontal de 3 blocos
        for (int i = 0; i < 3; i++) {
            getPositions().add(new Position(pos.getRow(), pos.getColumn() + i));
        }
        //Linha vertical do T
        getPositions().add(new Position(pos.getRow() + 1, pos.getColumn() + 1));
        getPositions().add(new Position(pos.getRow() + 2, pos.getColumn() + 1));
    }

    //Desenha o Navio virado para Sul (a apontar para cima)
    private void fillSouth(IPosition pos) {
        //Linha Vertical
        for (int i = 0; i < 2; i++) {
            getPositions().add(new Position(pos.getRow() + i, pos.getColumn()));
        }
        //Base horizonatal
        for (int j = 2; j < 5; j++) {
            getPositions().add(new Position(pos.getRow() + 2, pos.getColumn() + j - 3));
        }
    }

    //Desenha o Navio virado para Este
    private void fillEast(IPosition pos) {
        getPositions().add(new Position(pos.getRow(), pos.getColumn()));
        for (int i = 1; i < 4; i++) {
            getPositions().add(new Position(pos.getRow() + 1, pos.getColumn() + i - 3));
        }
        getPositions().add(new Position(pos.getRow() + 2, pos.getColumn()));
    }

    //Desenha o Navio virado para Oeste
    private void fillWest(IPosition pos) {
        getPositions().add(new Position(pos.getRow(), pos.getColumn()));
        for (int i = 1; i < 4; i++) {
            getPositions().add(new Position(pos.getRow() + 1, pos.getColumn() + i - 1));
        }
        getPositions().add(new Position(pos.getRow() + 2, pos.getColumn()));
    }

}
