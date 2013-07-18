package android.widget;

// Droidsafe Imports

public interface SectionIndexer {
    
    Object[] getSections();
    
    
    int getPositionForSection(int section);
    
    
    int getSectionForPosition(int position);    
}
