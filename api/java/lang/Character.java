package java.lang;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

public class Character {

	public static final Class<Character> TYPE = new Class<Character>();
	
	@DSModeled(DSC.SAFE)
	public static Character valueOf(char c) {
        return new Character();
    }
	
	@DSModeled(DSC.SAFE)
	public String toString() {
        return new String();
    }
}
