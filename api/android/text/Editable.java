package android.text;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface Editable
extends CharSequence, GetChars, Spannable, Appendable
{
    
    public Editable replace(int st, int en, CharSequence source, int start, int end);
    
    public Editable replace(int st, int en, CharSequence text);
    
    public Editable insert(int where, CharSequence text, int start, int end);
    
    public Editable insert(int where, CharSequence text);
    
    public Editable delete(int st, int en);
    
    public Editable append(CharSequence text);
    
    public Editable append(CharSequence text, int start, int end);
    
    public Editable append(char text);
    
    public void clear();
    
    public void clearSpans();
    
    public void setFilters(InputFilter[] filters);
    
    public InputFilter[] getFilters();
    
    public static class Factory {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:12.811 -0500", hash_original_field = "65E9316609C84FFB5CA83C3D42FAE896", hash_generated_field = "B3CC448774E7F8087983631BC24BCBA2")

        private static Editable.Factory sInstance = new Editable.Factory();

        /**
         * Returns the standard Editable Factory.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:12.814 -0500", hash_original_method = "9A0E6307B69C9A35763295D22146612F", hash_generated_method = "7E23A453D9DEAF97B61DCAC37ED207A7")
        
public static Editable.Factory getInstance() {
            return sInstance;
        }
        
        private Factory() {
        	//Synthensized constructor
        }

        /**
         * Returns a new SpannedStringBuilder from the specified
         * CharSequence.  You can override this to provide
         * a different kind of Spanned.
         */
        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:12.817 -0500", hash_original_method = "94DC09761C02587DB61BD4F9F3F80E82", hash_generated_method = "65F50A661763606C8326FD0B68BE9239")
        
public Editable newEditable(CharSequence source) {
            return new SpannableStringBuilder(source);
        }
    }
}
