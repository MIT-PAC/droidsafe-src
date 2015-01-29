package android.text.style;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface TabStopSpan
extends ParagraphStyle
{
    
    public int getTabStop();
    
    public static class Standard
    implements TabStopSpan
    {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:07.991 -0500", hash_original_field = "4BC812B90A94413C7439DF4CF4255888", hash_generated_field = "6E2269694724CADEC4B6853DD87D10D1")

        private int mTab;
        /**
         * Constructor.
         *
         * @param where the offset of the tab stop from the leading margin of
         *        the line
         */
        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:07.985 -0500", hash_original_method = "720C0ED25DC1847E4BC2629F7465CAE3", hash_generated_method = "26FAB9EDA7788FBC614EDA74F49A27F0")
        
public Standard(int where) {
            mTab = where;
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:07.988 -0500", hash_original_method = "0DF4C046B7295A23AFAA7AF561BE8FDC", hash_generated_method = "7879A0DBC77AABBF0A9C3CA6BBF97C52")
        
public int getTabStop() {
            return mTab;
        }
    }
}
