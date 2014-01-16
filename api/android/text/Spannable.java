package android.text;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface Spannable
extends Spanned
{
    
    public void setSpan(Object what, int start, int end, int flags);
    
    public void removeSpan(Object what);
    
    public static class Factory {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.420 -0500", hash_original_field = "55B004A6311ACDD2F2CC41A6D302D9CC", hash_generated_field = "D38268B7ECC673F62ED2EB1F6B1FFA6B")

        private static Spannable.Factory sInstance = new Spannable.Factory();

        /**
         * Returns the standard Spannable Factory.
         */ 
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.423 -0500", hash_original_method = "854342FB7AA07CACA3CB649964786E1F", hash_generated_method = "010373F6EA859BB9A59E2F60718E25C2")
        
public static Spannable.Factory getInstance() {
            return sInstance;
        }
        
        private Factory() {
        	//Synthetic method
        }

        /**
         * Returns a new SpannableString from the specified CharSequence.
         * You can override this to provide a different kind of Spannable.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:13.425 -0500", hash_original_method = "EE26FD92F5BDD12B70225AE1B2FCF67F", hash_generated_method = "5AD200519B3A1311651581156BABDB06")
        
public Spannable newSpannable(CharSequence source) {
            return new SpannableString(source);
        }
    }
}
