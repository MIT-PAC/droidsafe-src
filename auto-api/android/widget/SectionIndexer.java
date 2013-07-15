package android.widget;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public interface SectionIndexer {
    
    Object[] getSections();
    
    
    int getPositionForSection(int section);
    
    
    int getSectionForPosition(int position);    
}
