package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
        public void onSuggestionsReceived(String query, List<String> suggestions) {}
        public void onChangeComplete(boolean called) {}
        public void onSubmitComplete(boolean called) {}
        public void onResizeComplete(boolean called) {}
        public void onCancelComplete(boolean called) {}
    }

    interface IsSupportedCallback {
        void searchBoxIsSupported(boolean supported);
    }
}
