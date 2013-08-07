package android.widget;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface SectionIndexer {
    
    Object[] getSections();
    
    
    int getPositionForSection(int section);
    
    
    int getSectionForPosition(int position);    
}
