package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public interface SectionIndexer {
    
    Object[] getSections();
    
    
    int getPositionForSection(int section);
    
    
    int getSectionForPosition(int position);    
}
