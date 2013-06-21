package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

class FindActionModeCallback implements ActionMode.Callback, TextWatcher, View.OnLongClickListener, View.OnClickListener {
    private View mCustomView;
    private EditText mEditText;
    private TextView mMatches;
    private WebView mWebView;
    private InputMethodManager mInput;
    private Resources mResources;
    private boolean mMatchesFound;
    private int mNumberOfMatches;
    private ActionMode mActionMode;
    private Rect mGlobalVisibleRect = new Rect();
    private Point mGlobalVisibleOffset = new Point();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.215 -0400", hash_original_method = "5CA1E327210858D6ED3D49BC86FCA935", hash_generated_method = "219DC4E4A1C762BD62DC472D9A075CA6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     FindActionModeCallback(Context context) {
        dsTaint.addTaint(context.dsTaint);
        mCustomView = LayoutInflater.from(context).inflate(
                com.android.internal.R.layout.webview_find, null);
        mEditText = (EditText) mCustomView.findViewById(
                com.android.internal.R.id.edit);
        mEditText.setOnLongClickListener(this);
        mEditText.setOnClickListener(this);
        setText("");
        mMatches = (TextView) mCustomView.findViewById(
                com.android.internal.R.id.matches);
        mInput = (InputMethodManager)
                context.getSystemService(Context.INPUT_METHOD_SERVICE);
        mResources = context.getResources();
        // ---------- Original Method ----------
        //mCustomView = LayoutInflater.from(context).inflate(
                //com.android.internal.R.layout.webview_find, null);
        //mEditText = (EditText) mCustomView.findViewById(
                //com.android.internal.R.id.edit);
        //mEditText.setOnLongClickListener(this);
        //mEditText.setOnClickListener(this);
        //setText("");
        //mMatches = (TextView) mCustomView.findViewById(
                //com.android.internal.R.id.matches);
        //mInput = (InputMethodManager)
                //context.getSystemService(Context.INPUT_METHOD_SERVICE);
        //mResources = context.getResources();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.215 -0400", hash_original_method = "9621A971A6C9D9BC000280709C19BFE5", hash_generated_method = "56DFA8D664739E61C2F6F1F2786312A0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void finish() {
        mActionMode.finish();
        // ---------- Original Method ----------
        //mActionMode.finish();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.215 -0400", hash_original_method = "CA5CD09DA796000F712B45157C41B130", hash_generated_method = "853651AF281393477DF202D046525C4F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void setText(String text) {
        dsTaint.addTaint(text);
        mEditText.setText(text);
        Spannable span;
        span = (Spannable) mEditText.getText();
        int length;
        length = span.length();
        Selection.setSelection(span, length, length);
        span.setSpan(this, 0, length, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        mMatchesFound = false;
        // ---------- Original Method ----------
        //mEditText.setText(text);
        //Spannable span = (Spannable) mEditText.getText();
        //int length = span.length();
        //Selection.setSelection(span, length, length);
        //span.setSpan(this, 0, length, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        //mMatchesFound = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.216 -0400", hash_original_method = "767FD2233AC1DA09E02B0F553ABE32CD", hash_generated_method = "77921FCFDEAAAEC03CC5B69AA9FADB95")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void setWebView(WebView webView) {
        dsTaint.addTaint(webView.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError("WebView supplied to "
                    + "FindActionModeCallback cannot be null");
        } //End block
        // ---------- Original Method ----------
        //if (null == webView) {
            //throw new AssertionError("WebView supplied to "
                    //+ "FindActionModeCallback cannot be null");
        //}
        //mWebView = webView;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.216 -0400", hash_original_method = "517F2A554CEE09599D2CC8534059CD71", hash_generated_method = "9F4FBF32F8F0758A39EE3DC501913E6C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void findNext(boolean next) {
        dsTaint.addTaint(next);
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(
                    "No WebView for FindActionModeCallback::findNext");
        } //End block
        {
            findAll();
        } //End block
        mWebView.findNext(next);
        updateMatchesString();
        // ---------- Original Method ----------
        //if (mWebView == null) {
            //throw new AssertionError(
                    //"No WebView for FindActionModeCallback::findNext");
        //}
        //if (!mMatchesFound) {
            //findAll();
            //return;
        //}
        //if (0 == mNumberOfMatches) {
            //return;
        //}
        //mWebView.findNext(next);
        //updateMatchesString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.216 -0400", hash_original_method = "BDE9946C9B792224811CE0EAAEBAA6D6", hash_generated_method = "6C8772A4EBAB6463EB1CEB76DC89B93A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void findAll() {
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(
                    "No WebView for FindActionModeCallback::findAll");
        } //End block
        CharSequence find;
        find = mEditText.getText();
        {
            boolean var5BFB9DBB0BDAA240D4B93834B31881CD_1210042821 = (0 == find.length());
            {
                mWebView.clearMatches();
                mMatches.setVisibility(View.GONE);
                mMatchesFound = false;
            } //End block
            {
                mMatchesFound = true;
                mMatches.setVisibility(View.VISIBLE);
                mNumberOfMatches = mWebView.findAll(find.toString());
                {
                    mMatches.setText(mResources.getString(
                        com.android.internal.R.string.no_matches));
                } //End block
                {
                    updateMatchesString();
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (mWebView == null) {
            //throw new AssertionError(
                    //"No WebView for FindActionModeCallback::findAll");
        //}
        //CharSequence find = mEditText.getText();
        //if (0 == find.length()) {
            //mWebView.clearMatches();
            //mMatches.setVisibility(View.GONE);
            //mMatchesFound = false;
        //} else {
            //mMatchesFound = true;
            //mMatches.setVisibility(View.VISIBLE);
            //mNumberOfMatches = mWebView.findAll(find.toString());
            //if (0 == mNumberOfMatches) {
                //mMatches.setText(mResources.getString(
                        //com.android.internal.R.string.no_matches));
            //} else {
                //updateMatchesString();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.216 -0400", hash_original_method = "B14DB7FB68096A0CF2748CFEA9518F79", hash_generated_method = "65A7F4013D689C1D187A7CDFB99DE6BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void showSoftInput() {
        mInput.startGettingWindowFocus(mEditText.getRootView());
        mInput.focusIn(mEditText);
        mInput.showSoftInput(mEditText, 0);
        // ---------- Original Method ----------
        //mInput.startGettingWindowFocus(mEditText.getRootView());
        //mInput.focusIn(mEditText);
        //mInput.showSoftInput(mEditText, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.217 -0400", hash_original_method = "9E7B5524BD9C2F1CDB061DB60C13ABB6", hash_generated_method = "961FA361BB7D259B5711B4B3BFD8551C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void updateMatchesString() {
        String template;
        template = mResources.getQuantityString(
                com.android.internal.R.plurals.matches_found, mNumberOfMatches,
                mWebView.findIndex() + 1, mNumberOfMatches);
        mMatches.setText(template);
        // ---------- Original Method ----------
        //String template = mResources.getQuantityString(
                //com.android.internal.R.plurals.matches_found, mNumberOfMatches,
                //mWebView.findIndex() + 1, mNumberOfMatches);
        //mMatches.setText(template);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.217 -0400", hash_original_method = "AFE6187BDD69B153F64B909F5043D2E4", hash_generated_method = "73B62434C8762B2F58D40A0DE5A306AB")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean onLongClick(View v) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(v.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.217 -0400", hash_original_method = "BC3DE2C393D342A1AF9020DC35D5D78A", hash_generated_method = "E6E0A23318D6EBEB58EEBAC455087592")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onClick(View v) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(v.dsTaint);
        findNext(true);
        // ---------- Original Method ----------
        //findNext(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.217 -0400", hash_original_method = "1F388F0F12B5A9063A03CB19D68FC9E8", hash_generated_method = "643A5992C7448C0F94BB811DEC666B49")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(menu.dsTaint);
        dsTaint.addTaint(mode.dsTaint);
        {
            boolean varDC330101E9FCC7E5F1AB6C44D489AA26_835465453 = (!mode.isUiFocusable());
        } //End collapsed parenthetic
        mode.setCustomView(mCustomView);
        mode.getMenuInflater().inflate(com.android.internal.R.menu.webview_find,
                menu);
        Editable edit;
        edit = mEditText.getText();
        Selection.setSelection(edit, edit.length());
        mMatches.setVisibility(View.GONE);
        mMatchesFound = false;
        mMatches.setText("0");
        mEditText.requestFocus();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (!mode.isUiFocusable()) {
            //return false;
        //}
        //mode.setCustomView(mCustomView);
        //mode.getMenuInflater().inflate(com.android.internal.R.menu.webview_find,
                //menu);
        //mActionMode = mode;
        //Editable edit = mEditText.getText();
        //Selection.setSelection(edit, edit.length());
        //mMatches.setVisibility(View.GONE);
        //mMatchesFound = false;
        //mMatches.setText("0");
        //mEditText.requestFocus();
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.218 -0400", hash_original_method = "9709E7A513557072D77260776E1367DF", hash_generated_method = "C911C144AC7E12237ECB27231DE3EC52")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onDestroyActionMode(ActionMode mode) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(mode.dsTaint);
        mActionMode = null;
        mWebView.notifyFindDialogDismissed();
        mInput.hideSoftInputFromWindow(mWebView.getWindowToken(), 0);
        // ---------- Original Method ----------
        //mActionMode = null;
        //mWebView.notifyFindDialogDismissed();
        //mInput.hideSoftInputFromWindow(mWebView.getWindowToken(), 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.218 -0400", hash_original_method = "6F9DAEA6D666DAEBDC5BF41A6DC31573", hash_generated_method = "B34D0118BF13F47274A51B9031AC45F9")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(menu.dsTaint);
        dsTaint.addTaint(mode.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.218 -0400", hash_original_method = "B3FE74B35E145494B17BBBE1B965B753", hash_generated_method = "A9E1C623D33592A6CDB840CE724F386C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(item.dsTaint);
        dsTaint.addTaint(mode.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(
                    "No WebView for FindActionModeCallback::onActionItemClicked");
        } //End block
        mInput.hideSoftInputFromWindow(mWebView.getWindowToken(), 0);
        {
            Object var2B22EE13B3F8EF78698CBA34390A5432_498104940 = (item.getItemId());
            //Begin case com.android.internal.R.id.find_prev 
            findNext(false);
            //End case com.android.internal.R.id.find_prev 
            //Begin case com.android.internal.R.id.find_next 
            findNext(true);
            //End case com.android.internal.R.id.find_next 
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mWebView == null) {
            //throw new AssertionError(
                    //"No WebView for FindActionModeCallback::onActionItemClicked");
        //}
        //mInput.hideSoftInputFromWindow(mWebView.getWindowToken(), 0);
        //switch(item.getItemId()) {
            //case com.android.internal.R.id.find_prev:
                //findNext(false);
                //break;
            //case com.android.internal.R.id.find_next:
                //findNext(true);
                //break;
            //default:
                //return false;
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.219 -0400", hash_original_method = "46932DA0618614AAF15434EFCC9FAF04", hash_generated_method = "894C551EBACE88C7C7432AAC82B1E41F")
    @DSModeled(DSC.SAFE)
    @Override
    public void beforeTextChanged(CharSequence s,
                                  int start,
                                  int count,
                                  int after) {
        dsTaint.addTaint(after);
        dsTaint.addTaint(count);
        dsTaint.addTaint(s);
        dsTaint.addTaint(start);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.219 -0400", hash_original_method = "D02F824F0ADEF2C4CBD52950D34DEBE7", hash_generated_method = "152F2EEF277769366E37FE938DE2A86C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onTextChanged(CharSequence s,
                              int start,
                              int before,
                              int count) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(count);
        dsTaint.addTaint(s);
        dsTaint.addTaint(start);
        dsTaint.addTaint(before);
        findAll();
        // ---------- Original Method ----------
        //findAll();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.219 -0400", hash_original_method = "2B62725FCE5BAC340D42F3403AAE31A5", hash_generated_method = "B6C8627EFA50245637F4B76DCEB0FFB7")
    @DSModeled(DSC.SAFE)
    @Override
    public void afterTextChanged(Editable s) {
        dsTaint.addTaint(s.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.219 -0400", hash_original_method = "B54267537E703324F4E153FA58838A53", hash_generated_method = "97BC4B20CF246F2ADE84BD5A602C3CD2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getActionModeGlobalBottom() {
        View view;
        view = (View) mCustomView.getParent();
        {
            view = mCustomView;
        } //End block
        view.getGlobalVisibleRect(mGlobalVisibleRect, mGlobalVisibleOffset);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (mActionMode == null) {
            //return 0;
        //}
        //View view = (View) mCustomView.getParent();
        //if (view == null) {
            //view = mCustomView;
        //}
        //view.getGlobalVisibleRect(mGlobalVisibleRect, mGlobalVisibleOffset);
        //return mGlobalVisibleRect.bottom;
    }

    
}

