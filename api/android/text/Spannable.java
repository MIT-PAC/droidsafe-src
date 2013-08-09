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
        
        private Factory() {
        	//Synthetic method
        }

         
        public static Spannable.Factory getInstance() {
            return sInstance;
        }

        
        public Spannable newSpannable(CharSequence source) {
            return new SpannableString(source);
        }
    }
}
