package android.text;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface Spannable
extends Spanned
{
    
    public void setSpan(Object what, int start, int end, int flags);

    
    public void removeSpan(Object what);

    
    public static class Factory {
        private static Spannable.Factory sInstance = new Spannable.Factory();
        
        @DSModeled(DSC.SAFE)
        private Factory() {
        	//Synthetic method
        }

         
        @DSModeled(DSC.SAFE)
        public static Spannable.Factory getInstance() {
            return sInstance;
        }

        
        @DSModeled(DSC.SAFE)
        public Spannable newSpannable(CharSequence source) {
            return new SpannableString(source);
        }
    }
}
