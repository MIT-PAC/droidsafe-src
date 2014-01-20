package android.text;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface NoCopySpan {
    
    public class Concrete implements NoCopySpan {
    	
        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        public Concrete() {
    		//Synthesized constructor
    	}
    }
}
