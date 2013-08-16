package android.text.style;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface TabStopSpan
extends ParagraphStyle
{
    
    public int getTabStop();

    
    public static class Standard
    implements TabStopSpan
    {
        
        @DSModeled(DSC.SAFE)
        public Standard(int where) {
            mTab = where;
        }

        @DSModeled(DSC.SAFE)
        public int getTabStop() {
            return mTab;
        }

        private int mTab;
    }
}
