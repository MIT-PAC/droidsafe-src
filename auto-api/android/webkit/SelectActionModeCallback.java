package android.webkit;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.provider.Browser;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;

class SelectActionModeCallback implements ActionMode.Callback {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.502 -0400", hash_original_field = "72439B8F99EB438C3DA5D9CD798C6786", hash_generated_field = "99346B50377E115231263981E00655CA")

    private WebView mWebView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.502 -0400", hash_original_field = "3B382D379664B509F22D0EB5D96F2BA8", hash_generated_field = "941205D807AC4DF9704A65BDAF4756EC")

    private ActionMode mActionMode;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.503 -0400", hash_original_method = "5762F84230A8FBDA28C52CC5E7905CF7", hash_generated_method = "5762F84230A8FBDA28C52CC5E7905CF7")
    public SelectActionModeCallback ()
    {
        
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.503 -0400", hash_original_method = "2B5F8950C4750F957BA2CE7A16E0E578", hash_generated_method = "3E39CDF9FDEC82BE13585E703DC3AFD8")
     void setWebView(WebView webView) {
        mWebView = webView;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.503 -0400", hash_original_method = "AEE4CA66C11C42A4DFBE3B808BED80FD", hash_generated_method = "66D929DE2C21F83A863FCAAB4BD8A719")
     void finish() {
        {
            mActionMode.finish();
        } 
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.504 -0400", hash_original_method = "EEC72C77A82E33054EA06A487B276F43", hash_generated_method = "09EA263A41DAF9D0E9F1ED18ACE71F98")
    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        
        mode.getMenuInflater().inflate(com.android.internal.R.menu.webview_copy, menu);
        final Context context = mWebView.getContext();
        boolean allowText = context.getResources().getBoolean(
                com.android.internal.R.bool.config_allowActionMenuItemTextWithIcon);
        mode.setTitle(allowText ?
                context.getString(com.android.internal.R.string.textSelectionCABTitle) : null);
        {
            boolean varDC330101E9FCC7E5F1AB6C44D489AA26_429425998 = (!mode.isUiFocusable());
            {
                final MenuItem findOnPageItem = menu.findItem(com.android.internal.R.id.find);
                {
                    findOnPageItem.setVisible(false);
                } 
            } 
        } 
        mActionMode = mode;
        addTaint(menu.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_534944716 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_534944716;
        
        
        
        
                
        
                
        
            
            
                
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.504 -0400", hash_original_method = "E3574021502A1E90BCF4C46DB1841054", hash_generated_method = "65CAEA7C910F01E3530E725B6630D48A")
    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        
        addTaint(mode.getTaint());
        addTaint(menu.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_432455087 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_432455087;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.505 -0400", hash_original_method = "D632FC0DC2F573BE68AD858FDE491D0B", hash_generated_method = "E39729BCE36DA1DFE7C51711201DC331")
    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        
        {
            Object var2B22EE13B3F8EF78698CBA34390A5432_1468683269 = (item.getItemId());
            
            mWebView.copySelection();
            
            
            mode.finish();
            
            
            String selection = mWebView.getSelection();
            
            
            Browser.sendString(mWebView.getContext(), selection);
            
            
            mode.finish();
            
            
            mWebView.selectAll();
            
            
            String sel = mWebView.getSelection();
            
            
            mode.finish();
            
            
            mWebView.showFindDialog(sel, false);
            
            
            mode.finish();
            
            
            Intent i = new Intent(Intent.ACTION_WEB_SEARCH);
            
            
            i.putExtra(SearchManager.EXTRA_NEW_SEARCH, true);
            
            
            i.putExtra(SearchManager.QUERY, mWebView.getSelection());
            
            
            mWebView.getContext().startActivity(i);
            
        } 
        addTaint(mode.getTaint());
        addTaint(item.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_184233273 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_184233273;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.506 -0400", hash_original_method = "E29E2B7D27E4F7A85592500EAD3A4CE6", hash_generated_method = "D313794DBC346D0ACB5AB5EF3194A404")
    @Override
    public void onDestroyActionMode(ActionMode mode) {
        
        mWebView.selectionDone();
        addTaint(mode.getTaint());
        
        
    }

    
}

