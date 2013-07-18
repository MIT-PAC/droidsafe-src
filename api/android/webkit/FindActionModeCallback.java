package android.webkit;

// Droidsafe Imports
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
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

class FindActionModeCallback implements ActionMode.Callback, TextWatcher, View.OnLongClickListener, View.OnClickListener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.422 -0400", hash_original_field = "0F85706FF7ACEA880EA803CB0E63A48D", hash_generated_field = "58BF9FCCDFB47B7346A31DF060279244")

    private View mCustomView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.422 -0400", hash_original_field = "2AB1BE4B6823B3E4EBFA67B16F6DBB6D", hash_generated_field = "586B4299BBF875661CEB2131396A9E01")

    private EditText mEditText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.422 -0400", hash_original_field = "353AD1DE9A5D502D3C9A38D9848FA6CD", hash_generated_field = "3CA347429489873C0681EBD304FF196C")

    private TextView mMatches;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.422 -0400", hash_original_field = "72439B8F99EB438C3DA5D9CD798C6786", hash_generated_field = "99346B50377E115231263981E00655CA")

    private WebView mWebView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.423 -0400", hash_original_field = "BF2A01F10E67DAFA01668D8D4043BDC6", hash_generated_field = "F361F819B88ED86D16FB0FFD42B19716")

    private InputMethodManager mInput;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.423 -0400", hash_original_field = "0D8AC9B29D5FDF7FAC18EB1269D7F6D0", hash_generated_field = "8872E9F5EB468B447DB47434F2C2FEC9")

    private Resources mResources;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.423 -0400", hash_original_field = "41FAC5B025B543B3C8CC1A6686C13F34", hash_generated_field = "BFF89ED6114A41C587042AF90B1A6652")

    private boolean mMatchesFound;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.423 -0400", hash_original_field = "113FD5785A9BBA71ADC0F265CDF7C1ED", hash_generated_field = "52C43CDF0CC2B40EC1B6DAC0A4A1D836")

    private int mNumberOfMatches;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.423 -0400", hash_original_field = "3B382D379664B509F22D0EB5D96F2BA8", hash_generated_field = "941205D807AC4DF9704A65BDAF4756EC")

    private ActionMode mActionMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.423 -0400", hash_original_field = "67FC07F6472A7CF0FC43C91CA1D4DE06", hash_generated_field = "78FDC6EA268F3080B428BCC4885254FD")

    private Rect mGlobalVisibleRect = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.423 -0400", hash_original_field = "182F4E4C854FDC192EE5021ED6D73891", hash_generated_field = "B98693B51D24477EB14AD942E0AB2A10")

    private Point mGlobalVisibleOffset = new Point();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.424 -0400", hash_original_method = "5CA1E327210858D6ED3D49BC86FCA935", hash_generated_method = "F61130A40DB08F4A6E303A559B1F3744")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.424 -0400", hash_original_method = "9621A971A6C9D9BC000280709C19BFE5", hash_generated_method = "56DFA8D664739E61C2F6F1F2786312A0")
     void finish() {
        mActionMode.finish();
        // ---------- Original Method ----------
        //mActionMode.finish();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.425 -0400", hash_original_method = "CA5CD09DA796000F712B45157C41B130", hash_generated_method = "304A193E4872BA697D07B1C14019B9BC")
     void setText(String text) {
        addTaint(text.getTaint());
        mEditText.setText(text);
        Spannable span = (Spannable) mEditText.getText();
        int length = span.length();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.426 -0400", hash_original_method = "767FD2233AC1DA09E02B0F553ABE32CD", hash_generated_method = "E79ED45333620F082D4B3046476A8AC1")
     void setWebView(WebView webView) {
        if(null == webView)        
        {
            AssertionError var43FB8F42973E42D8B62E2EAE746A00EE_1672970266 = new AssertionError("WebView supplied to "
                    + "FindActionModeCallback cannot be null");
            var43FB8F42973E42D8B62E2EAE746A00EE_1672970266.addTaint(taint);
            throw var43FB8F42973E42D8B62E2EAE746A00EE_1672970266;
        } //End block
        mWebView = webView;
        // ---------- Original Method ----------
        //if (null == webView) {
            //throw new AssertionError("WebView supplied to "
                    //+ "FindActionModeCallback cannot be null");
        //}
        //mWebView = webView;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.426 -0400", hash_original_method = "517F2A554CEE09599D2CC8534059CD71", hash_generated_method = "7622C119AEF99C935EE7F15C77C06FBE")
    private void findNext(boolean next) {
        addTaint(next);
        if(mWebView == null)        
        {
            AssertionError var7B5F6EBAA0D1EDF747FDA996A1D04A78_1793881245 = new AssertionError(
                    "No WebView for FindActionModeCallback::findNext");
            var7B5F6EBAA0D1EDF747FDA996A1D04A78_1793881245.addTaint(taint);
            throw var7B5F6EBAA0D1EDF747FDA996A1D04A78_1793881245;
        } //End block
        if(!mMatchesFound)        
        {
            findAll();
            return;
        } //End block
        if(0 == mNumberOfMatches)        
        {
            return;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.427 -0400", hash_original_method = "BDE9946C9B792224811CE0EAAEBAA6D6", hash_generated_method = "AB6CE08AFCF8020F0411E9E6C94BC551")
     void findAll() {
        if(mWebView == null)        
        {
            AssertionError varF57140D10CBD5755090DBB8BE382371F_193437838 = new AssertionError(
                    "No WebView for FindActionModeCallback::findAll");
            varF57140D10CBD5755090DBB8BE382371F_193437838.addTaint(taint);
            throw varF57140D10CBD5755090DBB8BE382371F_193437838;
        } //End block
        CharSequence find = mEditText.getText();
        if(0 == find.length())        
        {
            mWebView.clearMatches();
            mMatches.setVisibility(View.GONE);
            mMatchesFound = false;
        } //End block
        else
        {
            mMatchesFound = true;
            mMatches.setVisibility(View.VISIBLE);
            mNumberOfMatches = mWebView.findAll(find.toString());
            if(0 == mNumberOfMatches)            
            {
                mMatches.setText(mResources.getString(
                        com.android.internal.R.string.no_matches));
            } //End block
            else
            {
                updateMatchesString();
            } //End block
        } //End block
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.428 -0400", hash_original_method = "B14DB7FB68096A0CF2748CFEA9518F79", hash_generated_method = "65A7F4013D689C1D187A7CDFB99DE6BD")
    public void showSoftInput() {
        mInput.startGettingWindowFocus(mEditText.getRootView());
        mInput.focusIn(mEditText);
        mInput.showSoftInput(mEditText, 0);
        // ---------- Original Method ----------
        //mInput.startGettingWindowFocus(mEditText.getRootView());
        //mInput.focusIn(mEditText);
        //mInput.showSoftInput(mEditText, 0);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.428 -0400", hash_original_method = "9E7B5524BD9C2F1CDB061DB60C13ABB6", hash_generated_method = "DF8262429EEF61D69B655993320B6881")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.428 -0400", hash_original_method = "AFE6187BDD69B153F64B909F5043D2E4", hash_generated_method = "99049F6A365C066B084495EB6B89E704")
    @Override
    public boolean onLongClick(View v) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(v.getTaint());
        boolean varB326B5062B2F0E69046810717534CB09_1256423266 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_717498629 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_717498629;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.428 -0400", hash_original_method = "BC3DE2C393D342A1AF9020DC35D5D78A", hash_generated_method = "C775AF136713AF9B3FF1F2A5DF0E1188")
    @Override
    public void onClick(View v) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(v.getTaint());
        findNext(true);
        // ---------- Original Method ----------
        //findNext(true);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.429 -0400", hash_original_method = "1F388F0F12B5A9063A03CB19D68FC9E8", hash_generated_method = "19E5E702CD5F805F8497713273E71D76")
    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(menu.getTaint());
        if(!mode.isUiFocusable())        
        {
            boolean var68934A3E9455FA72420237EB05902327_1930250050 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_725035090 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_725035090;
        } //End block
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
        boolean varB326B5062B2F0E69046810717534CB09_779730664 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_508998852 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_508998852;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.429 -0400", hash_original_method = "9709E7A513557072D77260776E1367DF", hash_generated_method = "F44E3CEFDA3BCE2E578FFBCFC586E4C5")
    @Override
    public void onDestroyActionMode(ActionMode mode) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(mode.getTaint());
        mActionMode = null;
        mWebView.notifyFindDialogDismissed();
        mInput.hideSoftInputFromWindow(mWebView.getWindowToken(), 0);
        // ---------- Original Method ----------
        //mActionMode = null;
        //mWebView.notifyFindDialogDismissed();
        //mInput.hideSoftInputFromWindow(mWebView.getWindowToken(), 0);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.430 -0400", hash_original_method = "6F9DAEA6D666DAEBDC5BF41A6DC31573", hash_generated_method = "872CFCA2E04B42D7CE839454FBC25F79")
    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(menu.getTaint());
        addTaint(mode.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_396668239 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1155396138 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1155396138;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.430 -0400", hash_original_method = "B3FE74B35E145494B17BBBE1B965B753", hash_generated_method = "6DF3B262E9C44255234A3C6D0FA7A10F")
    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(item.getTaint());
        addTaint(mode.getTaint());
        if(mWebView == null)        
        {
            AssertionError varE62A7D8B07D1B987485F8902AB886A4F_544843926 = new AssertionError(
                    "No WebView for FindActionModeCallback::onActionItemClicked");
            varE62A7D8B07D1B987485F8902AB886A4F_544843926.addTaint(taint);
            throw varE62A7D8B07D1B987485F8902AB886A4F_544843926;
        } //End block
        mInput.hideSoftInputFromWindow(mWebView.getWindowToken(), 0);
switch(item.getItemId()){
        case com.android.internal.R.id.find_prev:
        findNext(false);
        break;
        case com.android.internal.R.id.find_next:
        findNext(true);
        break;
        default:
        boolean var68934A3E9455FA72420237EB05902327_2012935716 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1660738345 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1660738345;
}        boolean varB326B5062B2F0E69046810717534CB09_684196262 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_975788295 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_975788295;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.431 -0400", hash_original_method = "46932DA0618614AAF15434EFCC9FAF04", hash_generated_method = "3FCEEE4D826A68B3157D53F259506F87")
    @Override
    public void beforeTextChanged(CharSequence s,
                                  int start,
                                  int count,
                                  int after) {
        addTaint(after);
        addTaint(count);
        addTaint(start);
        addTaint(s.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.431 -0400", hash_original_method = "D02F824F0ADEF2C4CBD52950D34DEBE7", hash_generated_method = "03B3AE9B77CDDE359F93FCF9CEC00AA6")
    @Override
    public void onTextChanged(CharSequence s,
                              int start,
                              int before,
                              int count) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(count);
        addTaint(before);
        addTaint(start);
        addTaint(s.getTaint());
        findAll();
        // ---------- Original Method ----------
        //findAll();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.431 -0400", hash_original_method = "2B62725FCE5BAC340D42F3403AAE31A5", hash_generated_method = "4E9426C0C70F36D91AD564261B4FF2B0")
    @Override
    public void afterTextChanged(Editable s) {
        addTaint(s.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.432 -0400", hash_original_method = "B54267537E703324F4E153FA58838A53", hash_generated_method = "D8316F3B46D6E178237C2CF28DCE9326")
    public int getActionModeGlobalBottom() {
        if(mActionMode == null)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1269480983 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2117572083 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2117572083;
        } //End block
        View view = (View) mCustomView.getParent();
        if(view == null)        
        {
            view = mCustomView;
        } //End block
        view.getGlobalVisibleRect(mGlobalVisibleRect, mGlobalVisibleOffset);
        int var7D98A6186BB8D8F09FE1E74764C83D17_1334222851 = (mGlobalVisibleRect.bottom);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_428141076 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_428141076;
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

