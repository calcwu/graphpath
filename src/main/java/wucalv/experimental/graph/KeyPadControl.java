package wucalv.experimental.graph;

import com.gs.collections.impl.list.mutable.FastList;

/**
 * User: wucalv
 * Date: 7/5/15 12:33 PM
 */
public class KeyPadControl {

    private KeyPad keyPad;

    public KeyPadControl(KeyPad keyPad) {
        this.keyPad = keyPad;
    }

    public String[] getPossibleMoves(Moves moves, String from) {
        return getPossibleMoves(moves.getMove(), keyPad.getPoint(from));
    }

    public String[] getPossibleMoves(Moves moves, Point point) {
        return getPossibleMoves(moves.getMove(), point);
    }

    private String[] getPossibleMoves(Move move, Point fromPoint) {
        Point[] points = move.getNextMoves(fromPoint, keyPad.getBoundary());
        FastList<String> keys = FastList.newList();
        for(Point p : points) {
            String key = keyPad.getKey(p);
            if(keyPad.isValid(key)) {
                keys.add(key);
            }
        }
        return keys.toArray(new String[keys.size()]);
    }

}
