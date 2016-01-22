package droidsafe.utils;

/** 
 * Mutable Int class for incrementing / counting maps.
 * 
 * @author mgordon
 *
 */
public class MutableInt implements Comparable<MutableInt> {
    int value; // note that we start at 1 since we're counting

    public MutableInt() {
    	value = 1;
    }
    
    public MutableInt(int i) {
    	value = i;
    }
    
    public void increment () { 
        ++value;      
    }

    public int  value() { 
        return value; 
    }
    
    public void add(int i) {
    	value += i;
    }

	@Override
	public int compareTo(MutableInt o) {
		return Integer.compare(this.value, o.value);
	}
}
