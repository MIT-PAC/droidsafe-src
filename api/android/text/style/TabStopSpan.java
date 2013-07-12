package android.text.style;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

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
