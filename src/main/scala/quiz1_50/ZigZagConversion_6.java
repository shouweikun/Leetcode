package quiz1_50;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by john_liu on 2018/7/29.
 */
public class ZigZagConversion_6 {
    public String convert(String s, int numRows) {
        if (numRows <= 1) return s;
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(s.length(), numRows); i++) {
            rows.add(new StringBuilder());
        }
        boolean goingDown = false;
        int currentRow = 0;
        for (char c : s.toCharArray()) {
            rows.get(currentRow).append(c);
            if (currentRow == 0 || currentRow == numRows - 1) goingDown = !goingDown;
            currentRow += goingDown ? 1 : -1;
        }

        Iterator<StringBuilder> iter= rows.iterator();
        StringBuilder re = new StringBuilder();
        while(iter.hasNext()){
            re.append(iter.next());
        }

        return re.toString();
    }
}
