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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.606 -0400", hash_original_field = "0F85706FF7ACEA880EA803CB0E63A48D", hash_generated_field = "58BF9FCCDFB47B7346A31DF060279244")

    private View mCustomView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.606 -0400", hash_original_field = "2AB1BE4B6823B3E4EBFA67B16F6DBB6D", hash_generated_field = "586B4299BBF875661CEB2131396A9E01")

    private EditText mEditText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.606 -0400", hash_original_field = "353AD1DE9A5D502D3C9A38D9848FA6CD", hash_generated_field = "3CA347429489873C0681EBD304FF196C")

    private TextView mMatches;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.606 -0400", hash_original_field = "72439B8F99EB438C3DA5D9CD798C6786", hash_generated_field = "99346B50377E115231263981E00655CA")

    private WebView mWebView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.606 -0400", hash_original_field = "BF2A01F10E67DAFA01668D8D4043BDC6", hash_generated_field = "F361F819B88ED86D16FB0FFD42B19716")

    private InputMethodManager mInput;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.606 -0400", hash_original_field = "0D8AC9B29D5FDF7FAC18EB1269D7F6D0", hash_generated_field = "8872E9F5EB468B447DB47434F2C2FEC9")

    private Resources mResources;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.606 -0400", hash_original_field = "41FAC5B025B543B3C8CC1A6686C13F34", hash_generated_field = "BFF89ED6114A41C587042AF90B1A6652")

    private boolean mMatchesFound;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.606 -0400", hash_original_field = "113FD5785A9BBA71ADC0F265CDF7C1ED", hash_generated_field = "52C43CDF0CC2B40EC1B6DAC0A4A1D836")

    private int mNumberOfMatches;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.606 -0400", hash_original_field = "3B382D379664B509F22D0EB5D96F2BA8", hash_generated_field = "941205D807AC4DF9704A65BDAF4756EC")

    private ActionMode mActionMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.606 -0400", hash_original_field = "67FC07F6472A7CF0FC43C91CA1D4DE06", hash_generated_field = "78FDC6EA268F3080B428BCC4885254FD")

    private Rect mGlobalVisibleRect = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.606 -0400", hash_original_field = "182F4E4C854FDC192EE5021ED6D73891", hash_generated_field = "B98693B51D24477EB14AD942E0AB2A10")

    private Point mGlobalVisibleOffset = new Point();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.607 -0400", hash_original_method = "5CA1E327210858D6ED3D49BC86FCA935", hash_generated_method = "F61130A40DB08F4A6E303A559B1F3744")
      FindActionModeCallback(Context context) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.607 -0400", hash_original_method = "9621A971A6C9D9BC000280709C19BFE5", hash_generated_method = "56DFA8D664739E61C2F6F1F2786312A0")
     void finish() {
        mActionMode.finish();
        // ---------- Original Method ----------
        //mActionMode.finish();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.608 -0400", hash_original_method = "CA5CD09DA796000F712B45157C41B130", hash_generated_method = "6234178EFA3022E14E7CD14745AB0320")
     void setText(String text) {
        mEditText.setText(text);
        Spannable span = (Spannable) mEditText.getText();
        int length = span.length();
        Selection.setSelection(span, length, length);
        span.setSpan(this, 0, length, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        mMatchesFound = false;
        addTaint(text.getTaint());
        // ---------- Original Method ----------
        //mEditText.setText(text);
        //Spannable span = (Spannable) mEditText.getText();
        //int length = span.length();
        //Selection.setSelection(span, length, length);
        //span.setSpan(this, 0, length, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        //mMatchesFound = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.608 -0400", hash_original_method = "767FD2233AC1DA09E02B0F553ABE32CD", hash_generated_method = "2602BFC01A2CF8CAB06C8D5C65A7E21B")
     void setWebView(WebView webView) {
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError("WebView supplied to "
                    + "FindActionModeCallback cannot be null");
        } //End block
        mWebView = webView;
        // ---------- Original Method ----------
        //if (null == webView) {
            //throw new AssertionError("WebView supplied to "
                    //+ "FindActionModeCallback cannot be null");
        //}
        //mWebView = webView;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.609 -0400", hash_original_method = "517F2A554CEE09599D2CC8534059CD71", hash_generated_method = "8D74751BEA3B5EB16FF1656C4323A626")
    private void findNext(boolean next) {
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(
                    "No WebView for FindActionModeCallback::findNext");
        } //End block
        {
            findAll();
        } //End block
        mWebView.findNext(next);
        updateMatchesString();
        addTaint(next);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.610 -0400", hash_original_method = "BDE9946C9B792224811CE0EAAEBAA6D6", hash_generated_method = "9AAD7D73EA96C493FBBAA4D82A752BD5")
     void findAll() {
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(
                    "No WebView for FindActionModeCallback::findAll");
        } //End block
        CharSequence find = mEditText.getText();
        {
            boolean var5BFB9DBB0BDAA240D4B93834B31881CD_1766084055 = (0 == find.length());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.611 -0400", hash_original_method = "B14DB7FB68096A0CF2748CFEA9518F79", hash_generated_method = "65A7F4013D689C1D187A7CDFB99DE6BD")
    public void showSoftInput() {
        mInput.startGettingWindowFocus(mEditText.getRootView());
        mInput.focusIn(mEditText);
        mInput.showSoftInput(mEditText, 0);
        // ---------- Original Method ----------
        //mInput.startGettingWindowFocus(mEditText.getRootView());
        //mInput.focusIn(mEditText);
        //mInput.showSoftInput(mEditText, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.611 -0400", hash_original_method = "9E7B5524BD9C2F1CDB061DB60C13ABB6", hash_generated_method = "DF8262429EEF61D69B655993320B6881")
    private void updateMatchesString() {
        String template = mResources.getQuantityString(
                com.android.internal.R.plurals.matches_found, mNumberOfMatches,
                mWebView.findIndex() + 1, mNumberOfMatches);
        mMatches.setText(template);
        // ---------- Original Method ----------
        //String template = mResources.getQuantityString(
                //com.android.internal.R.plurals.matches_found, mNumberOfMatches,
                //mWebView.findIndex() + 1, mNumberOfMatches);
        //mMatches.setText(template);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.611 -0400", hash_original_method = "AFE6187BDD69B153F64B909F5043D2E4", hash_generated_method = "7DE81D841858914A4E07A059D1CC1996")
    @Override
    public boolean onLongClick(View v) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(v.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2044957996 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2044957996;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.611 -0400", hash_original_method = "BC3DE2C393D342A1AF9020DC35D5D78A", hash_generated_method = "E20611D366204E7ACD098EF7B08BC47D")
    @Override
    public void onClick(View v) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        findNext(true);
        addTaint(v.getTaint());
        // ---------- Original Method ----------
        //findNext(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.612 -0400", hash_original_method = "1F388F0F12B5A9063A03CB19D68FC9E8", hash_generated_method = "4D9F19F3797E3B373A189E533C5FFADB")
    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean varDC330101E9FCC7E5F1AB6C44D489AA26_1071273616 = (!mode.isUiFocusable());
        } //End collapsed parenthetic
        mode.setCustomView(mCustomView);
        mode.getMenuInflater().inflate(com.android.internal.R.menu.webview_find,
                menu);
        mActionMode = mode;
        Editable edit = mEditText.getText();
        Selection.setSelection(edit, edit.length());
        mMatches.setVisibility(View.GONE);
        mMatchesFound = false;
        mMatches.setText("0");
        mEditText.requestFocus();
        addTaint(menu.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1941075899 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1941075899;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.612 -0400", hash_original_method = "9709E7A513557072D77260776E1367DF", hash_generated_method = "4A7F9E2BBC690464AD983425DF357D1E")
    @Override
    public void onDestroyActionMode(ActionMode mode) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mActionMode = null;
        mWebView.notifyFindDialogDismissed();
        mInput.hideSoftInputFromWindow(mWebView.getWindowToken(), 0);
        addTaint(mode.getTaint());
        // ---------- Original Method ----------
        //mActionMode = null;
        //mWebView.notifyFindDialogDismissed();
        //mInput.hideSoftInputFromWindow(mWebView.getWindowToken(), 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.613 -0400", hash_original_method = "6F9DAEA6D666DAEBDC5BF41A6DC31573", hash_generated_method = "7ADEADCFECC234D4DD5F3D923F6BD079")
    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(mode.getTaint());
        addTaint(menu.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1465966990 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1465966990;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.613 -0400", hash_original_method = "B3FE74B35E145494B17BBBE1B965B753", hash_generated_method = "7776E9CE78E80E5E58E7388695715EBB")
    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(
                    "No WebView for FindActionModeCallback::onActionItemClicked");
        } //End block
        mInput.hideSoftInputFromWindow(mWebView.getWindowToken(), 0);
        {
            Object var2B22EE13B3F8EF78698CBA34390A5432_892232410 = (item.getItemId());
            //Begin case com.android.internal.R.id.find_prev 
            findNext(false);
            //End case com.android.internal.R.id.find_prev 
            //Begin case com.android.internal.R.id.find_next 
            findNext(true);
            //End case com.android.internal.R.id.find_next 
        } //End collapsed parenthetic
        addTaint(mode.getTaint());
        addTaint(item.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1674575621 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1674575621;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.614 -0400", hash_original_method = "46932DA0618614AAF15434EFCC9FAF04", hash_generated_method = "CE696FAE02394D0C52F9F992D2DE20A0")
    @Override
    public void beforeTextChanged(CharSequence s,
                                  int start,
                                  int count,
                                  int after) {
        addTaint(s.getTaint());
        addTaint(start);
        addTaint(count);
        addTaint(after);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.614 -0400", hash_original_method = "D02F824F0ADEF2C4CBD52950D34DEBE7", hash_generated_method = "23F217B3EC0D77EF8529213570FC0B87")
    @Override
    public void onTextChanged(CharSequence s,
                              int start,
                              int before,
                              int count) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        findAll();
        addTaint(s.getTaint());
        addTaint(start);
        addTaint(before);
        addTaint(count);
        // ---------- Original Method ----------
        //findAll();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.615 -0400", hash_original_method = "2B62725FCE5BAC340D42F3403AAE31A5", hash_generated_method = "4E9426C0C70F36D91AD564261B4FF2B0")
    @Override
    public void afterTextChanged(Editable s) {
        addTaint(s.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.615 -0400", hash_original_method = "B54267537E703324F4E153FA58838A53", hash_generated_method = "23F76046AB205B2E2802293D296E3A77")
    public int getActionModeGlobalBottom() {
        View view = (View) mCustomView.getParent();
        {
            view = mCustomView;
        } //End block
        view.getGlobalVisibleRect(mGlobalVisibleRect, mGlobalVisibleOffset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_62817708 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_62817708;
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

