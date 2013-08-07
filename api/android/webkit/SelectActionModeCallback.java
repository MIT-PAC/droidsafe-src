package android.webkit;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.provider.Browser;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;





class SelectActionModeCallback implements ActionMode.Callback {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.905 -0400", hash_original_field = "72439B8F99EB438C3DA5D9CD798C6786", hash_generated_field = "99346B50377E115231263981E00655CA")

    private WebView mWebView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.905 -0400", hash_original_field = "3B382D379664B509F22D0EB5D96F2BA8", hash_generated_field = "941205D807AC4DF9704A65BDAF4756EC")

    private ActionMode mActionMode;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.905 -0400", hash_original_method = "5762F84230A8FBDA28C52CC5E7905CF7", hash_generated_method = "5762F84230A8FBDA28C52CC5E7905CF7")
    public SelectActionModeCallback ()
    {
        //Synthesized constructor
    }


        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.905 -0400", hash_original_method = "2B5F8950C4750F957BA2CE7A16E0E578", hash_generated_method = "3E39CDF9FDEC82BE13585E703DC3AFD8")
     void setWebView(WebView webView) {
        mWebView = webView;
        // ---------- Original Method ----------
        //mWebView = webView;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.905 -0400", hash_original_method = "AEE4CA66C11C42A4DFBE3B808BED80FD", hash_generated_method = "848AAC59B3BD368E981A795DAFD47D8B")
     void finish() {
        if(mActionMode != null)        
        {
            mActionMode.finish();
        } //End block
        // ---------- Original Method ----------
        //if (mActionMode != null) {
            //mActionMode.finish();
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.906 -0400", hash_original_method = "EEC72C77A82E33054EA06A487B276F43", hash_generated_method = "F356CD49C2354B3C5C0127729DF491E0")
    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(menu.getTaint());
        mode.getMenuInflater().inflate(com.android.internal.R.menu.webview_copy, menu);
        final Context context = mWebView.getContext();
        boolean allowText = context.getResources().getBoolean(
                com.android.internal.R.bool.config_allowActionMenuItemTextWithIcon);
        mode.setTitle(allowText ?
                context.getString(com.android.internal.R.string.textSelectionCABTitle) : null);
        if(!mode.isUiFocusable())        
        {
            final MenuItem findOnPageItem = menu.findItem(com.android.internal.R.id.find);
            if(findOnPageItem != null)            
            {
                findOnPageItem.setVisible(false);
            } //End block
        } //End block
        mActionMode = mode;
        boolean varB326B5062B2F0E69046810717534CB09_1240786380 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_644756145 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_644756145;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.907 -0400", hash_original_method = "E3574021502A1E90BCF4C46DB1841054", hash_generated_method = "6B24B5FAB720F51EA06812B9259F1761")
    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(menu.getTaint());
        addTaint(mode.getTaint());
        boolean varB326B5062B2F0E69046810717534CB09_539843876 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1234081159 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1234081159;
        // ---------- Original Method ----------
        //return true;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.908 -0400", hash_original_method = "D632FC0DC2F573BE68AD858FDE491D0B", hash_generated_method = "8BCD3FE8C4C8B1C04CD5BA483D6D214C")
    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(item.getTaint());
        addTaint(mode.getTaint());
switch(item.getItemId()){
        case android.R.id.copy:
        mWebView.copySelection();
        mode.finish();
        break;
        case com.android.internal.R.id.share:
        String selection = mWebView.getSelection();
        Browser.sendString(mWebView.getContext(), selection);
        mode.finish();
        break;
        case com.android.internal.R.id.select_all:
        mWebView.selectAll();
        break;
        case com.android.internal.R.id.find:
        String sel = mWebView.getSelection();
        mode.finish();
        mWebView.showFindDialog(sel, false);
        break;
        case com.android.internal.R.id.websearch:
        mode.finish();
        Intent i = new Intent(Intent.ACTION_WEB_SEARCH);
        i.putExtra(SearchManager.EXTRA_NEW_SEARCH, true);
        i.putExtra(SearchManager.QUERY, mWebView.getSelection());
        mWebView.getContext().startActivity(i);
        break;
        default:
        boolean var68934A3E9455FA72420237EB05902327_978820122 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_449890688 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_449890688;
}        boolean varB326B5062B2F0E69046810717534CB09_683806594 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_781129125 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_781129125;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.908 -0400", hash_original_method = "E29E2B7D27E4F7A85592500EAD3A4CE6", hash_generated_method = "0BEC8B85CEDC36CB2FB7360EC291E524")
    @Override
    public void onDestroyActionMode(ActionMode mode) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(mode.getTaint());
        mWebView.selectionDone();
        // ---------- Original Method ----------
        //mWebView.selectionDone();
    }

    
}

