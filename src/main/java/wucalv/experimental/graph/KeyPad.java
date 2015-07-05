package wucalv.experimental.graph;

import java.util.Set;

import com.gs.collections.api.map.MutableMap;
import com.gs.collections.impl.factory.Maps;
import com.gs.collections.impl.list.mutable.FastList;

/**
 *
 *
 */
public class KeyPad {

    static final String INVALID = "*";

    private FastList<String[]> rows = FastList.newList();

    private MutableMap<String, Point> keyMap = Maps.mutable.of();

    private Point boundary;

    KeyPad() {
    }

    void buildRowsByChar(String data) {
        String[] row = new String[data.length()];
        for(int i=0; i<data.length(); i++) {
            row[i] = data.substring(i, i+1);
        }
        rows.add(row);
        int rowCount = rows.size() - 1, column = 0;
        for(String s : row) {
            keyMap.put(s, new Point(column++, rowCount));
        }
        keyMap.removeKey(INVALID);
    }

    public String getKey(Point point) {
        return getKey(point.getX(), point.getY());
    }

    public String getKey(int x, int y) {
        if(x >= getColumnSize() || y >= getRowSize()) {
            return INVALID;
        }
        return rows.get(y)[x];
    }

    public int getColumnSize() {
        return rows.get(0).length;
    }

    public int getRowSize() {
        return rows.size();
    }

    public Point getBoundary() {
        if(boundary == null) {
            boundary = new Point(getColumnSize(), getRowSize());
        }
        return boundary;
    }

    public boolean isValid(String c) {
        return !c.equals(INVALID);
    }

    public Set<String> getAllKeys() {
        return keyMap.keySet();
    }

    public Point getPoint(String key) {
        return keyMap.get(key);
    }
}
