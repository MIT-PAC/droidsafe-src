package android.webkit;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:03.244 -0500", hash_original_field = "ADD711F109703E2EAF61E2AD917F3FB6", hash_generated_field = "58BF9FCCDFB47B7346A31DF060279244")

    private View mCustomView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:03.246 -0500", hash_original_field = "A9B59832B2888AF35E1650CB0335B219", hash_generated_field = "586B4299BBF875661CEB2131396A9E01")

    private EditText mEditText;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:03.248 -0500", hash_original_field = "718ED45EE79B1FA41100DBF9A32E49BC", hash_generated_field = "3CA347429489873C0681EBD304FF196C")

    private TextView mMatches;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:03.251 -0500", hash_original_field = "E044D69EE05B24F4B93E3A3B208F5343", hash_generated_field = "99346B50377E115231263981E00655CA")

    private WebView mWebView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:03.253 -0500", hash_original_field = "F37200A1BCE9BAC85E65C4E631BD3AFB", hash_generated_field = "F361F819B88ED86D16FB0FFD42B19716")

    private InputMethodManager mInput;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:03.255 -0500", hash_original_field = "8C221FB485568FEFC5ABDDF092AD743A", hash_generated_field = "8872E9F5EB468B447DB47434F2C2FEC9")

    private Resources mResources;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:03.257 -0500", hash_original_field = "9C97C36E7FBC5FC0CA26CAD32D33AAE8", hash_generated_field = "BFF89ED6114A41C587042AF90B1A6652")

    private boolean mMatchesFound;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:03.259 -0500", hash_original_field = "6D5A6D0963C44A39DDEE18C4AD231DC6", hash_generated_field = "52C43CDF0CC2B40EC1B6DAC0A4A1D836")

    private int mNumberOfMatches;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:03.261 -0500", hash_original_field = "B7BD8B12490FD42C33E24469AF6B48C1", hash_generated_field = "941205D807AC4DF9704A65BDAF4756EC")

    private ActionMode mActionMode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:03.303 -0500", hash_original_field = "90077AFE710D9C661C47363315C10CE3", hash_generated_field = "78FDC6EA268F3080B428BCC4885254FD")

    private Rect mGlobalVisibleRect = new Rect();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:03.305 -0500", hash_original_field = "9AA4B9AE03BF45798C8FEA9679CC2EE3", hash_generated_field = "B98693B51D24477EB14AD942E0AB2A10")

    private Point mGlobalVisibleOffset = new Point();

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:03.264 -0500", hash_original_method = "5CA1E327210858D6ED3D49BC86FCA935", hash_generated_method = "54322D49FDA0112AD84229345493DF79")
    
FindActionModeCallback(Context context) {
        mCustomView = LayoutInflater.from(context).inflate(
                com.android.internal.R.layout.webview_find, null);
        mEditText = (EditText) mCustomView.findViewById(
                com.android.internal.R.id.edit);
        // Override long click so that select ActionMode is not opened, which
        // would exit find ActionMode.
        mEditText.setOnLongClickListener(this);
        mEditText.setOnClickListener(this);
        setText("");
        mMatches = (TextView) mCustomView.findViewById(
                com.android.internal.R.id.matches);
        mInput = (InputMethodManager)
                context.getSystemService(Context.INPUT_METHOD_SERVICE);
        mResources = context.getResources();
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:03.266 -0500", hash_original_method = "9621A971A6C9D9BC000280709C19BFE5", hash_generated_method = "9621A971A6C9D9BC000280709C19BFE5")
    
void finish() {
        mActionMode.finish();
    }

    /*
     * Place text in the text field so it can be searched for.  Need to press
     * the find next or find previous button to find all of the matches.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:03.268 -0500", hash_original_method = "CA5CD09DA796000F712B45157C41B130", hash_generated_method = "CCD73340064A2FE99A144E130A5D2F5A")
    
void setText(String text) {
        mEditText.setText(text);
        Spannable span = (Spannable) mEditText.getText();
        int length = span.length();
        // Ideally, we would like to set the selection to the whole field,
        // but this brings up the Text selection CAB, which dismisses this
        // one.
        Selection.setSelection(span, length, length);
        // Necessary each time we set the text, so that this will watch
        // changes to it.
        span.setSpan(this, 0, length, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        mMatchesFound = false;
    }

    /*
     * Set the WebView to search.  Must be non null, and set before calling
     * startActionMode.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:03.270 -0500", hash_original_method = "767FD2233AC1DA09E02B0F553ABE32CD", hash_generated_method = "767FD2233AC1DA09E02B0F553ABE32CD")
    
void setWebView(WebView webView) {
        if (null == webView) {
            throw new AssertionError("WebView supplied to "
                    + "FindActionModeCallback cannot be null");
        }
        mWebView = webView;
    }

    /*
     * Move the highlight to the next match.
     * @param next If true, find the next match further down in the document.
     *             If false, find the previous match, up in the document.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:03.272 -0500", hash_original_method = "517F2A554CEE09599D2CC8534059CD71", hash_generated_method = "6B4BF8DBD12C2F243D72527D3C5734E3")
    
private void findNext(boolean next) {
        if (mWebView == null) {
            throw new AssertionError(
                    "No WebView for FindActionModeCallback::findNext");
        }
        if (!mMatchesFound) {
            findAll();
            return;
        }
        if (0 == mNumberOfMatches) {
            // There are no matches, so moving to the next match will not do
            // anything.
            return;
        }
        mWebView.findNext(next);
        updateMatchesString();
    }

    /*
     * Highlight all the instances of the string from mEditText in mWebView.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:03.274 -0500", hash_original_method = "BDE9946C9B792224811CE0EAAEBAA6D6", hash_generated_method = "BDE9946C9B792224811CE0EAAEBAA6D6")
    
void findAll() {
        if (mWebView == null) {
            throw new AssertionError(
                    "No WebView for FindActionModeCallback::findAll");
        }
        CharSequence find = mEditText.getText();
        if (0 == find.length()) {
            mWebView.clearMatches();
            mMatches.setVisibility(View.GONE);
            mMatchesFound = false;
        } else {
            mMatchesFound = true;
            mMatches.setVisibility(View.VISIBLE);
            mNumberOfMatches = mWebView.findAll(find.toString());
            if (0 == mNumberOfMatches) {
                mMatches.setText(mResources.getString(
                        com.android.internal.R.string.no_matches));
            } else {
                updateMatchesString();
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:03.277 -0500", hash_original_method = "B14DB7FB68096A0CF2748CFEA9518F79", hash_generated_method = "2EDF84B2F0E916C428786D45FC18C77F")
    
public void showSoftInput() {
        mInput.startGettingWindowFocus(mEditText.getRootView());
        mInput.focusIn(mEditText);
        mInput.showSoftInput(mEditText, 0);
    }

    /*
     * Update the string which tells the user how many matches were found, and
     * which match is currently highlighted.
     * Not to be called when mNumberOfMatches is 0.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:03.279 -0500", hash_original_method = "9E7B5524BD9C2F1CDB061DB60C13ABB6", hash_generated_method = "D8DCF844B8114098608B66B191F7780C")
    
private void updateMatchesString() {
        String template = mResources.getQuantityString(
                com.android.internal.R.plurals.matches_found, mNumberOfMatches,
                mWebView.findIndex() + 1, mNumberOfMatches);

        mMatches.setText(template);
    }

    // OnLongClickListener implementation

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:03.281 -0500", hash_original_method = "AFE6187BDD69B153F64B909F5043D2E4", hash_generated_method = "8A5F302DE51CA62A44C34FF1D4E65254")
    
@Override
    public boolean onLongClick(View v) { return true; }

    // OnClickListener implementation

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:03.283 -0500", hash_original_method = "BC3DE2C393D342A1AF9020DC35D5D78A", hash_generated_method = "A004290575AD073A7D4D1213A122E755")
    
@Override
    public void onClick(View v) {
        findNext(true);
    }

    // ActionMode.Callback implementation

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:03.286 -0500", hash_original_method = "1F388F0F12B5A9063A03CB19D68FC9E8", hash_generated_method = "7EC6F992846B397AF326B99267A6F5F3")
    
@Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        if (!mode.isUiFocusable()) {
            // If the action mode we're running in is not focusable the user
            // will not be able to type into the find on page field. This
            // should only come up when we're running in a dialog which is
            // already less than ideal; disable the option for now.
            return false;
        }

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
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:03.288 -0500", hash_original_method = "9709E7A513557072D77260776E1367DF", hash_generated_method = "D5072C51D02606643722DBF145DA2B3E")
    
@Override
    public void onDestroyActionMode(ActionMode mode) {
        mActionMode = null;
        mWebView.notifyFindDialogDismissed();
        mInput.hideSoftInputFromWindow(mWebView.getWindowToken(), 0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:03.291 -0500", hash_original_method = "6F9DAEA6D666DAEBDC5BF41A6DC31573", hash_generated_method = "9747241BE45539F55CE85977F54744BD")
    
@Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:03.293 -0500", hash_original_method = "B3FE74B35E145494B17BBBE1B965B753", hash_generated_method = "D69F4A150C6E6EDC74BAD9F415587213")
    
@Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        if (mWebView == null) {
            throw new AssertionError(
                    "No WebView for FindActionModeCallback::onActionItemClicked");
        }
        mInput.hideSoftInputFromWindow(mWebView.getWindowToken(), 0);
        switch(item.getItemId()) {
            case com.android.internal.R.id.find_prev:
                findNext(false);
                break;
            case com.android.internal.R.id.find_next:
                findNext(true);
                break;
            default:
                return false;
        }
        return true;
    }

    // TextWatcher implementation

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:03.296 -0500", hash_original_method = "46932DA0618614AAF15434EFCC9FAF04", hash_generated_method = "F8EC100AD660763625E941FBB544DA96")
    
@Override
    public void beforeTextChanged(CharSequence s,
                                  int start,
                                  int count,
                                  int after) {
        // Does nothing.  Needed to implement TextWatcher.
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:03.298 -0500", hash_original_method = "D02F824F0ADEF2C4CBD52950D34DEBE7", hash_generated_method = "A0CDE817DE03465C2F8CBA4012E33D49")
    
@Override
    public void onTextChanged(CharSequence s,
                              int start,
                              int before,
                              int count) {
        findAll();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:03.301 -0500", hash_original_method = "2B62725FCE5BAC340D42F3403AAE31A5", hash_generated_method = "7162C4A3DAA6CFC047FB1956C53A22DF")
    
@Override
    public void afterTextChanged(Editable s) {
        // Does nothing.  Needed to implement TextWatcher.
    }
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:03.307 -0500", hash_original_method = "B54267537E703324F4E153FA58838A53", hash_generated_method = "EA08B2D78BAF275FDB507535D4FA9EAF")
    
public int getActionModeGlobalBottom() {
        if (mActionMode == null) {
            return 0;
        }
        View view = (View) mCustomView.getParent();
        if (view == null) {
            view = mCustomView;
        }
        view.getGlobalVisibleRect(mGlobalVisibleRect, mGlobalVisibleOffset);
        return mGlobalVisibleRect.bottom;
    }
    
}

