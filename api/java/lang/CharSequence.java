package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface CharSequence {
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.SAFE_OTHERS)
    public int length();
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.SAFE_OTHERS)
    public char charAt(int index);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public CharSequence subSequence(int start, int end);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public String toString();
    
    public class DroidsafeCharSequence implements CharSequence {
    	@DSBan(DSCat.DROIDSAFE_INTERNAL)
    	public DroidsafeCharSequence() {
    		
    	}
    	
		@Override
		@DSComment("Abstract Method")
		@DSSafe(DSCat.SAFE_OTHERS)
		public int length() {
			// TODO Auto-generated method stub
			return getTaintInt();
		}

		@Override
		@DSComment("Abstract Method")
		@DSSafe(DSCat.SAFE_OTHERS)
		public char charAt(int index) {
			// TODO Auto-generated method stub
			return (char)getTaintInt();
		}

		@Override
		@DSComment("Abstract Method")
		@DSSpec(DSCat.ABSTRACT_METHOD)
		public CharSequence subSequence(int start, int end) {
			// TODO Auto-generated method stub
			return this;
		}
		
		
		public String toString() {
			return " " + charAt(0);
		}
    	
    }
}
