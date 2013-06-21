package android.text.style;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public interface TabStopSpan
extends ParagraphStyle
{
    
    public int getTabStop();

    
    public static class Standard
    implements TabStopSpan
    {
        
        public Standard(int where) {
            mTab = where;
        }

        public int getTabStop() {
            return mTab;
        }

        private int mTab;
    }
}
