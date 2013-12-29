package android.webkit;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.provider.Browser;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;





class SelectActionModeCallback implements ActionMode.Callback {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:21.459 -0500", hash_original_field = "E044D69EE05B24F4B93E3A3B208F5343", hash_generated_field = "99346B50377E115231263981E00655CA")

    private WebView mWebView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:21.461 -0500", hash_original_field = "B7BD8B12490FD42C33E24469AF6B48C1", hash_generated_field = "941205D807AC4DF9704A65BDAF4756EC")

    private ActionMode mActionMode;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.905 -0400", hash_original_method = "5762F84230A8FBDA28C52CC5E7905CF7", hash_generated_method = "5762F84230A8FBDA28C52CC5E7905CF7")
    public SelectActionModeCallback ()
    {
        //Synthesized constructor
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:21.461 -0500", hash_original_method = "2B5F8950C4750F957BA2CE7A16E0E578", hash_generated_method = "2B5F8950C4750F957BA2CE7A16E0E578")
    void setWebView(WebView webView) {
        mWebView = webView;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:21.462 -0500", hash_original_method = "AEE4CA66C11C42A4DFBE3B808BED80FD", hash_generated_method = "5A55D270C47FEE6C8E965210FE81FBE1")
    void finish() {
        // It is possible that onCreateActionMode was never called, in the case
        // where there is no ActionBar, for example.
        if (mActionMode != null) {
            mActionMode.finish();
        }
    }

    // ActionMode.Callback implementation

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:21.463 -0500", hash_original_method = "EEC72C77A82E33054EA06A487B276F43", hash_generated_method = "AF754D748711D481813985DE90BC2147")
    @Override
public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        mode.getMenuInflater().inflate(com.android.internal.R.menu.webview_copy, menu);

        final Context context = mWebView.getContext();
        boolean allowText = context.getResources().getBoolean(
                com.android.internal.R.bool.config_allowActionMenuItemTextWithIcon);
        mode.setTitle(allowText ?
                context.getString(com.android.internal.R.string.textSelectionCABTitle) : null);

        if (!mode.isUiFocusable()) {
            // If the action mode UI we're running in isn't capable of taking window focus
            // the user won't be able to type into the find on page UI. Disable this functionality.
            // (Note that this should only happen in floating dialog windows.)
            // This can be removed once we can handle multiple focusable windows at a time
            // in a better way.
            final MenuItem findOnPageItem = menu.findItem(com.android.internal.R.id.find);
            if (findOnPageItem != null) {
                findOnPageItem.setVisible(false);
            }
        }
        mActionMode = mode;
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:21.464 -0500", hash_original_method = "E3574021502A1E90BCF4C46DB1841054", hash_generated_method = "084A3D8BB1217CF825528FA834954073")
    @Override
public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:21.465 -0500", hash_original_method = "D632FC0DC2F573BE68AD858FDE491D0B", hash_generated_method = "1CF49B9308BED87EFB310233BE40AB41")
    @Override
public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        switch(item.getItemId()) {
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
                String sel= mWebView.getSelection();
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
                return false;
        }
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:21.466 -0500", hash_original_method = "E29E2B7D27E4F7A85592500EAD3A4CE6", hash_generated_method = "D8E4B01526975F85C955D25C8585AC34")
    @Override
public void onDestroyActionMode(ActionMode mode) {
        mWebView.selectionDone();
    }

    
}

