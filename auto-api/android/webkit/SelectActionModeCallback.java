package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.provider.Browser;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;

class SelectActionModeCallback implements ActionMode.Callback {
    private WebView mWebView;
    private ActionMode mActionMode;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.738 -0400", hash_original_method = "9A70CE9C6D302823ADCE4222577CBD67", hash_generated_method = "9A70CE9C6D302823ADCE4222577CBD67")
        public SelectActionModeCallback ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.739 -0400", hash_original_method = "2B5F8950C4750F957BA2CE7A16E0E578", hash_generated_method = "A81A6A241B9E7676FB033BC2DCE1B645")
    @DSModeled(DSC.SAFE)
     void setWebView(WebView webView) {
        dsTaint.addTaint(webView.dsTaint);
        // ---------- Original Method ----------
        //mWebView = webView;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.739 -0400", hash_original_method = "AEE4CA66C11C42A4DFBE3B808BED80FD", hash_generated_method = "66D929DE2C21F83A863FCAAB4BD8A719")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void finish() {
        {
            mActionMode.finish();
        } //End block
        // ---------- Original Method ----------
        //if (mActionMode != null) {
            //mActionMode.finish();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.739 -0400", hash_original_method = "EEC72C77A82E33054EA06A487B276F43", hash_generated_method = "1A7BFF4F7C35A5C0D6775A62727B457A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(menu.dsTaint);
        dsTaint.addTaint(mode.dsTaint);
        mode.getMenuInflater().inflate(com.android.internal.R.menu.webview_copy, menu);
        Context context;
        context = mWebView.getContext();
        boolean allowText;
        allowText = context.getResources().getBoolean(
                com.android.internal.R.bool.config_allowActionMenuItemTextWithIcon);
        mode.setTitle(allowText ?
                context.getString(com.android.internal.R.string.textSelectionCABTitle) : null);
        {
            boolean varDC330101E9FCC7E5F1AB6C44D489AA26_1633174677 = (!mode.isUiFocusable());
            {
                MenuItem findOnPageItem;
                findOnPageItem = menu.findItem(com.android.internal.R.id.find);
                {
                    findOnPageItem.setVisible(false);
                } //End block
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //mode.getMenuInflater().inflate(com.android.internal.R.menu.webview_copy, menu);
        //final Context context = mWebView.getContext();
        //boolean allowText = context.getResources().getBoolean(
                //com.android.internal.R.bool.config_allowActionMenuItemTextWithIcon);
        //mode.setTitle(allowText ?
                //context.getString(com.android.internal.R.string.textSelectionCABTitle) : null);
        //if (!mode.isUiFocusable()) {
            //final MenuItem findOnPageItem = menu.findItem(com.android.internal.R.id.find);
            //if (findOnPageItem != null) {
                //findOnPageItem.setVisible(false);
            //}
        //}
        //mActionMode = mode;
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.740 -0400", hash_original_method = "E3574021502A1E90BCF4C46DB1841054", hash_generated_method = "C15F922494B6CF421D187054AEFB832B")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(menu.dsTaint);
        dsTaint.addTaint(mode.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.740 -0400", hash_original_method = "D632FC0DC2F573BE68AD858FDE491D0B", hash_generated_method = "2669054340AEBFD483F6B855F2BBDACD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(item.dsTaint);
        dsTaint.addTaint(mode.dsTaint);
        {
            Object var2B22EE13B3F8EF78698CBA34390A5432_1819120791 = (item.getItemId());
            //Begin case android.R.id.copy 
            mWebView.copySelection();
            //End case android.R.id.copy 
            //Begin case android.R.id.copy 
            mode.finish();
            //End case android.R.id.copy 
            //Begin case com.android.internal.R.id.share 
            String selection;
            selection = mWebView.getSelection();
            //End case com.android.internal.R.id.share 
            //Begin case com.android.internal.R.id.share 
            Browser.sendString(mWebView.getContext(), selection);
            //End case com.android.internal.R.id.share 
            //Begin case com.android.internal.R.id.share 
            mode.finish();
            //End case com.android.internal.R.id.share 
            //Begin case com.android.internal.R.id.select_all 
            mWebView.selectAll();
            //End case com.android.internal.R.id.select_all 
            //Begin case com.android.internal.R.id.find 
            String sel;
            sel = mWebView.getSelection();
            //End case com.android.internal.R.id.find 
            //Begin case com.android.internal.R.id.find 
            mode.finish();
            //End case com.android.internal.R.id.find 
            //Begin case com.android.internal.R.id.find 
            mWebView.showFindDialog(sel, false);
            //End case com.android.internal.R.id.find 
            //Begin case com.android.internal.R.id.websearch 
            mode.finish();
            //End case com.android.internal.R.id.websearch 
            //Begin case com.android.internal.R.id.websearch 
            Intent i;
            i = new Intent(Intent.ACTION_WEB_SEARCH);
            //End case com.android.internal.R.id.websearch 
            //Begin case com.android.internal.R.id.websearch 
            i.putExtra(SearchManager.EXTRA_NEW_SEARCH, true);
            //End case com.android.internal.R.id.websearch 
            //Begin case com.android.internal.R.id.websearch 
            i.putExtra(SearchManager.QUERY, mWebView.getSelection());
            //End case com.android.internal.R.id.websearch 
            //Begin case com.android.internal.R.id.websearch 
            mWebView.getContext().startActivity(i);
            //End case com.android.internal.R.id.websearch 
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.740 -0400", hash_original_method = "E29E2B7D27E4F7A85592500EAD3A4CE6", hash_generated_method = "829F25B31E5F3DBCEFC80C0835DA32DC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onDestroyActionMode(ActionMode mode) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(mode.dsTaint);
        mWebView.selectionDone();
        // ---------- Original Method ----------
        //mWebView.selectionDone();
    }

    
}

