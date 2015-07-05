package wucalv.experimental.graph;

/**
 * User: wucalv
 * Date: 7/5/15 12:45 PM
 */
public enum Moves {

    KnightMove(new KnightMove())
    ;

    private Move move;

    Moves(Move move) {
        this.move = move;
    }

    public Move getMove() {
        return move;
    }
}
