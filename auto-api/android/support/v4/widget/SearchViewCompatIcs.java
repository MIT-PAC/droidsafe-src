package android.support.v4.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.view.View;
import android.widget.SearchView;

class SearchViewCompatIcs {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.364 -0400", hash_original_method = "829770254765AD904A52B224D6B8E92F", hash_generated_method = "829770254765AD904A52B224D6B8E92F")
    public SearchViewCompatIcs ()
    {
        //Synthesized constructor
    }


        public static View newSearchView(Context context) {
        return new MySearchView(context);
    }

    
        public static void setImeOptions(View searchView, int imeOptions) {
        ((SearchView) searchView).setImeOptions(imeOptions);
    }

    
        public static void setInputType(View searchView, int inputType) {
        ((SearchView) searchView).setInputType(inputType);
    }

    
    public static class MySearchView extends SearchView {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.365 -0400", hash_original_method = "58DCF89988C851B95306F376E575AD93", hash_generated_method = "1B46275644FF1532A5143B3D69C7546C")
        public  MySearchView(Context context) {
            super(context);
            addTaint(context.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.365 -0400", hash_original_method = "E5687251D1F88E61D23992BF3CD9FD01", hash_generated_method = "707A7D2086ABF458189A6D11CFF71E0A")
        @Override
        public void onActionViewCollapsed() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            setQuery("", false);
            super.onActionViewCollapsed();
            // ---------- Original Method ----------
            //setQuery("", false);
            //super.onActionViewCollapsed();
        }

        
    }


    
}

