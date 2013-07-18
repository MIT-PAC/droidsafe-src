package android.text;

// Droidsafe Imports

public interface SpanWatcher extends NoCopySpan {
    
    public void onSpanAdded(Spannable text, Object what, int start, int end);
    
    public void onSpanRemoved(Spannable text, Object what, int start, int end); 
    
    public void onSpanChanged(Spannable text, Object what, int ostart, int oend,
                              int nstart, int nend);
}
