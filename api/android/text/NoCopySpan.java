package android.text;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface NoCopySpan {
    
    public class Concrete implements NoCopySpan {
    	@DSModeled(DSC.SAFE)
        public Concrete() {
    		//Synthesized constructor
    	}
    }
}
