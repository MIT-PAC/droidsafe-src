package android.support.v4.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.view.View;
import android.widget.SearchView;
import android.widget.SearchView.OnCloseListener;
import android.widget.SearchView.OnQueryTextListener;

class SearchViewCompatHoneycomb {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.357 -0400", hash_original_method = "A2C9697EF9D9271A85E01FB1EA533B3D", hash_generated_method = "A2C9697EF9D9271A85E01FB1EA533B3D")
    public SearchViewCompatHoneycomb ()
    {
        //Synthesized constructor
    }


        public static View newSearchView(Context context) {
        return new SearchView(context);
    }

    
        public static void setSearchableInfo(View searchView, ComponentName searchableComponent) {
        SearchView sv = ((SearchView) searchView);
        SearchManager searchManager = (SearchManager)
                sv.getContext().getSystemService(Context.SEARCH_SERVICE);
        sv.setSearchableInfo(searchManager.getSearchableInfo(searchableComponent));
    }

    
        public static Object newOnQueryTextListener(final OnQueryTextListenerCompatBridge listener) {
        return new OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return listener.onQueryTextSubmit(query);
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                return listener.onQueryTextChange(newText);
            }
        };
    }

    
        public static void setOnQueryTextListener(Object searchView, Object listener) {
        ((SearchView) searchView).setOnQueryTextListener((OnQueryTextListener) listener);
    }

    
        public static Object newOnCloseListener(final OnCloseListenerCompatBridge listener) {
        return new OnCloseListener() {
            @Override
            public boolean onClose() {
                return listener.onClose();
            }
        };
    }

    
        public static void setOnCloseListener(Object searchView, Object listener) {
        ((SearchView) searchView).setOnCloseListener((OnCloseListener) listener);
    }

    
        public static CharSequence getQuery(View searchView) {
        return ((SearchView) searchView).getQuery();
    }

    
        public static void setQuery(View searchView, CharSequence query, boolean submit) {
        ((SearchView) searchView).setQuery(query, submit);
    }

    
        public static void setQueryHint(View searchView, CharSequence hint) {
        ((SearchView) searchView).setQueryHint(hint);
    }

    
        public static void setIconified(View searchView, boolean iconify) {
        ((SearchView) searchView).setIconified(iconify);
    }

    
        public static boolean isIconified(View searchView) {
        return ((SearchView) searchView).isIconified();
    }

    
        public static void setSubmitButtonEnabled(View searchView, boolean enabled) {
        ((SearchView) searchView).setSubmitButtonEnabled(enabled);
    }

    
        public static boolean isSubmitButtonEnabled(View searchView) {
        return ((SearchView) searchView).isSubmitButtonEnabled();
    }

    
        public static void setQueryRefinementEnabled(View searchView, boolean enable) {
        ((SearchView) searchView).setQueryRefinementEnabled(enable);
    }

    
        public static boolean isQueryRefinementEnabled(View searchView) {
        return ((SearchView) searchView).isQueryRefinementEnabled();
    }

    
        public static void setMaxWidth(View searchView, int maxpixels) {
        ((SearchView) searchView).setMaxWidth(maxpixels);
    }

    
    interface OnQueryTextListenerCompatBridge {
        public boolean onQueryTextSubmit(String query);
        public boolean onQueryTextChange(String newText);
    }
    
    interface OnCloseListenerCompatBridge {
        public boolean onClose();
    }
    
}

