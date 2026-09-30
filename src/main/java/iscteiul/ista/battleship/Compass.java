/**
 *
 */
package iscteiul.ista.battleship;

/**
 * Representa as direções da bússola (pontos cardeais) usadas para 
 * definir a orientação dos navios no tabuleiro do jogo.
 * 
 * @author fba
 * @author Martim Correia Nº129843
 */
public enum Compass {
    /** Direção Norte,Sul,ESte,Oeste,Invalida (representada por 'n,s,e,o,u',respetivamente) */
    NORTH('n'), SOUTH('s'), EAST('e'), WEST('o'), UNKNOWN('u');
  
    private final char c;
    /**
     * Construtor do enumerado.
     * 
     * @param c O carácter que representa a direção.
     */
    Compass(char c) {
        this.c = c;
    }
    /**
     * Obtém o carácter associado a esta direção.
     * 
     * @return O carácter correspondente (ex: 'n' para NORTH, 'o' para WEST).
     */
    public char getDirection() {
        return c;
    }
    /**
     * Devolve a representação em formato de texto (String) da direção.
     * 
     * @return Uma String contendo o carácter representativo da direção.
     */
    @Override
    public String toString() {
        return "" + c;
    }
    /**
     * Converte um carácter na direção correspondente do enumerado Compass.
     * 
     * @param ch O carácter a converter ('n', 's', 'e', 'o').
     * @return O valor do enumerado correspondente à direção, ou UNKNOWN se o carácter não for reconhecido.
     */
    static Compass charToCompass(char ch) {
        Compass bearing;
        switch (ch) {
            case 'n':
                bearing = NORTH;
                break;
            case 's':
                bearing = SOUTH;
                break;
            case 'e':
                bearing = EAST;
                break;
            case 'o':
                bearing = WEST;
                break;
            default:
                bearing = UNKNOWN;
        }

        return bearing;
    }
}
