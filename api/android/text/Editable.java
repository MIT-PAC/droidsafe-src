package android.text;




// Droidsafe Imports
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
        private static Editable.Factory sInstance = new Editable.Factory();

        
        @DSModeled(DSC.SAFE)
        public static Editable.Factory getInstance() {
            return sInstance;
        }

        
        @DSModeled(DSC.SAFE)
        public Editable newEditable(CharSequence source) {
            return new SpannableStringBuilder(source);
        }
    }
}
