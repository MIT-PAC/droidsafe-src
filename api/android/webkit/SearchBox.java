package android.webkit;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.List;

public interface SearchBox {
    
    void setQuery(String query);

    
    void setVerbatim(boolean verbatim);

    
    void setSelection(int selectionStart, int selectionEnd);

    
    void setDimensions(int x, int y, int width, int height);

    
    void onchange(SearchBoxListener listener);
    void onsubmit(SearchBoxListener listener);
    void onresize(SearchBoxListener listener);
    void oncancel(SearchBoxListener listener);

    
    void addSearchBoxListener(SearchBoxListener l);
    void removeSearchBoxListener(SearchBoxListener l);

    
    void isSupported(IsSupportedCallback callback);

    
    public abstract class SearchBoxListener {
        @DSModeled(DSC.SAFE)
        public void onSuggestionsReceived(String query, List<String> suggestions) {}
        @DSModeled(DSC.BAN)
        public void onChangeComplete(boolean called) {}
        @DSModeled(DSC.BAN)
        public void onSubmitComplete(boolean called) {}
        @DSModeled(DSC.BAN)
        public void onResizeComplete(boolean called) {}
        @DSModeled(DSC.BAN)
        public void onCancelComplete(boolean called) {}
    }

    interface IsSupportedCallback {
        void searchBoxIsSupported(boolean supported);
    }
}
