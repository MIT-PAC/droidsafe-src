package android.text.style;

// Droidsafe Imports

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
