package android.webkit;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;




public abstract class WebBackForwardListClient {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.340 -0400", hash_original_method = "3EE15C74E8939A7E4FFBB261B684E6CA", hash_generated_method = "3EE15C74E8939A7E4FFBB261B684E6CA")
    public WebBackForwardListClient ()
    {
        //Synthesized constructor
    }

    /**
     * Notify the client that <var>item</var> has been added to the
     * WebBackForwardList.
     * @param item The newly created WebHistoryItem
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.838 -0500", hash_original_method = "1F6D8177500DFC3D1F576E07196A0774", hash_generated_method = "98B7C3854156F83ED7D3C6F9613B5879")
    
public void onNewHistoryItem(WebHistoryItem item) { }

    /**
     * Notify the client that the <var>item</var> at <var>index</var> is now
     * the current history item.
     * @param item A WebHistoryItem
     * @param index The new history index
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.841 -0500", hash_original_method = "DA8164C67D7B3779FDED447EEF1649BA", hash_generated_method = "D1F90A23A260AF74142BEABDA486C7C2")
    
public void onIndexChanged(WebHistoryItem item, int index) { }

    
}

