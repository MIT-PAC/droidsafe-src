package droidsafe.utils;

import java.io.Serializable;

public class IntRange implements Comparable, Serializable {

    private static final long serialVersionUID = -509438439792027883L;

    public int min;
    public int max;
    
    public IntRange(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof IntRange) {
            IntRange other = (IntRange) o;
            int diff = this.min - other.min;
            if (diff == 0)
                diff = this.max - other.max;
            return diff;
        }
        return -1;
    }
    
    public String toString() {
        return "[" + min + ", " + max + "]";
    }

}
