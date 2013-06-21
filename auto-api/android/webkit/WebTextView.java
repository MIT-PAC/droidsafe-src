package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.ResultReceiver;
import android.text.BoringLayout.Metrics;
import android.text.DynamicLayout;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputType;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.MovementMethod;
import android.text.method.Touch;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsoluteLayout.LayoutParams;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import junit.framework.Assert;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

class WebTextView extends AutoCompleteTextView implements AdapterView.OnItemClickListener {
    private int mRingInset;
    private WebView         mWebView;
    private boolean         mSingle;
    private int             mWidthSpec;
    private int             mHeightSpec;
    private int             mNodePointer;
    private boolean         mGotEnterDown;
    private int             mMaxLength;
    private String          mPreChange;
    private float           mDragStartX;
    private float           mDragStartY;
    private long            mDragStartTime;
    private boolean         mDragSent;
    private boolean         mScrolled;
    private boolean         mFromWebKit;
    private boolean         mFromFocusChange;
    private boolean         mFromSetInputType;
    private boolean         mGotTouchDown;
    private boolean         mHasPerformedLongClick;
    private boolean         mInSetTextAndKeepSelection;
    private char[]          mCharacter = new char[1];
    private boolean mGotDelete;
    private int mDelSelStart;
    private int mDelSelEnd;
    private boolean mAutoFillable;
    private int mQueryId;
    private boolean mAutoFillProfileIsSet;
    private boolean mInsideRemove;
    private MyResultReceiver mReceiver;
    private Handler mHandler;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.221 -0400", hash_original_method = "089095F3BAAFCF9E87F2A27B8FA6A0A2", hash_generated_method = "6D4AA1BCBC3768BF1E02ECA7F7E46856")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     WebTextView(Context context, WebView webView, int autoFillQueryId) {
        super(context, null, com.android.internal.R.attr.webTextViewStyle);
        dsTaint.addTaint(autoFillQueryId);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(webView.dsTaint);
        mMaxLength = -1;
        setAutoFillable(autoFillQueryId);
        TextPaint paint;
        paint = getPaint();
        int flags;
        flags = paint.getFlags() & ~Paint.DEV_KERN_TEXT_FLAG
                | Paint.SUBPIXEL_TEXT_FLAG | Paint.DITHER_FLAG;
        paint.setFlags(flags);
        setTextColor(DebugFlags.DRAW_WEBTEXTVIEW ? Color.RED : Color.BLACK);
        setBackgroundDrawable(DebugFlags.DRAW_WEBTEXTVIEW ? null : new ColorDrawable(Color.WHITE));
        setIncludeFontPadding(false);
        mHandler = new Handler() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.221 -0400", hash_original_method = "9CA3B5083DA9628F4399959A49D35A0D", hash_generated_method = "4CC73758C920072E1BCBEE5D1B1B481B")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public void handleMessage(Message msg) {
                dsTaint.addTaint(msg.dsTaint);
                //Begin case AUTOFILL_FORM 
                mWebView.autoFillForm(mQueryId);
                //End case AUTOFILL_FORM 
                // ---------- Original Method ----------
                //switch (msg.what) {
                //case AUTOFILL_FORM:
                    //mWebView.autoFillForm(mQueryId);
                    //break;
                //}
            }
};
        mReceiver = new MyResultReceiver(mHandler);
        float ringWidth;
        ringWidth = 2f * context.getResources().getDisplayMetrics().density;
        mRingInset = (int) ringWidth;
        setBackgroundDrawable(new BackgroundDrawable(mRingInset));
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(),
                getPaddingBottom());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.221 -0400", hash_original_method = "AE45889DF7F2FB1AD82AA8B5F1FED7F7", hash_generated_method = "73A1633B795500A87A3A0458BD71BE85")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setAutoFillable(int queryId) {
        dsTaint.addTaint(queryId);
        mAutoFillable = mWebView.getSettings().getAutoFillEnabled()
                && (queryId != FORM_NOT_AUTOFILLABLE);
        // ---------- Original Method ----------
        //mAutoFillable = mWebView.getSettings().getAutoFillEnabled()
                //&& (queryId != FORM_NOT_AUTOFILLABLE);
        //mQueryId = queryId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.222 -0400", hash_original_method = "2A0FFA3F53D08ACDC8DCA45FA27A8D22", hash_generated_method = "7762DC9C70A9514315EE3EE177023472")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setPadding(int left, int top, int right, int bottom) {
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(left);
        dsTaint.addTaint(right);
        dsTaint.addTaint(top);
        super.setPadding(left + mRingInset, top + mRingInset,
                right + mRingInset, bottom + mRingInset);
        // ---------- Original Method ----------
        //super.setPadding(left + mRingInset, top + mRingInset,
                //right + mRingInset, bottom + mRingInset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.223 -0400", hash_original_method = "6961E56AC59C570DF49F429D8D391CD8", hash_generated_method = "548BA6494F5B59A0262ACE91D41115AC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        dsTaint.addTaint(event.dsTaint);
        {
            boolean var54D21F6CA47C3F13B3018213ED17168D_1369412527 = (event.isSystem());
            {
                boolean varCEE2CC9A2E312DCEF21BEB8A1D3D2A74_2096056211 = (super.dispatchKeyEvent(event));
            } //End block
        } //End collapsed parenthetic
        boolean down;
        down = event.getAction() != KeyEvent.ACTION_UP;
        int keyCode;
        keyCode = event.getKeyCode();
        boolean isArrowKey;
        isArrowKey = false;
        //Begin case KeyEvent.KEYCODE_DPAD_LEFT KeyEvent.KEYCODE_DPAD_RIGHT KeyEvent.KEYCODE_DPAD_UP KeyEvent.KEYCODE_DPAD_DOWN 
        isArrowKey = true;
        //End case KeyEvent.KEYCODE_DPAD_LEFT KeyEvent.KEYCODE_DPAD_RIGHT KeyEvent.KEYCODE_DPAD_UP KeyEvent.KEYCODE_DPAD_DOWN 
        {
            {
                onEditorAction(EditorInfo.IME_ACTION_NEXT);
            } //End block
        } //End block
        Spannable text;
        text = (Spannable) getText();
        int oldStart;
        oldStart = Selection.getSelectionStart(text);
        int oldEnd;
        oldEnd = Selection.getSelectionEnd(text);
        {
            {
                sendDomEvent(event);
            } //End block
            {
                mGotDelete = true;
                mDelSelStart = oldStart;
                mDelSelEnd = oldEnd;
            } //End block
        } //End block
        {
            {
                boolean var72F8103664F7AA5B2750DCAC9FD4B6CA_452784846 = (isPopupShowing());
                {
                    boolean var97BD0C91372FF8CDE07B475E38FE656A_864586109 = (super.dispatchKeyEvent(event));
                } //End block
            } //End collapsed parenthetic
            {
                InputMethodManager.getInstance(mContext)
                        .hideSoftInputFromWindow(getWindowToken(), 0);
                sendDomEvent(new KeyEvent(KeyEvent.ACTION_DOWN, keyCode));
                sendDomEvent(event);
            } //End block
            boolean varD6051F78D5E57D3CCCE2FBA8ECC49974_310205288 = (super.dispatchKeyEvent(event));
        } //End block
        {
            {
                boolean var72F8103664F7AA5B2750DCAC9FD4B6CA_827413556 = (isPopupShowing());
                {
                    boolean var97BD0C91372FF8CDE07B475E38FE656A_224768817 = (super.dispatchKeyEvent(event));
                } //End block
            } //End collapsed parenthetic
            {
                mWebView.centerKeyPressOnTextField();
            } //End block
            boolean varD6051F78D5E57D3CCCE2FBA8ECC49974_358980454 = (super.dispatchKeyEvent(event));
        } //End block
        {
            boolean var778B744EBE60DF815BEE98852B413FC5_1474831861 = (getLayout() == null);
            {
                measure(mWidthSpec, mHeightSpec);
            } //End block
        } //End collapsed parenthetic
        int oldLength;
        oldLength = text.length();
        boolean maxedOut;
        maxedOut = mMaxLength != -1 && oldLength == mMaxLength;
        String oldText;
        {
            oldText = text.toString();
        } //End block
        {
            oldText = "";
        } //End block
        {
            boolean varD6051F78D5E57D3CCCE2FBA8ECC49974_481373658 = (super.dispatchKeyEvent(event));
            {
                {
                    mGotEnterDown = true;
                } //End block
                {
                    {
                        boolean var3BF1F25582652AF3CD5797A1157BFB20_891830179 = (!oldText.equals(getText().toString()));
                        {
                            Spannable span;
                            span = (Spannable) getText();
                            int newStart;
                            newStart = Selection.getSelectionStart(span);
                            int newEnd;
                            newEnd = Selection.getSelectionEnd(span);
                            mWebView.replaceTextfieldText(0, oldLength, span.toString(),
                            newStart, newEnd);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            mWebView.resetTrackballTime();
            {
                Object var908199CAFC193F17BD0A3FE9AC9B6CAE_1035953471 = (mWebView.onKeyDown(keyCode, event));
                Object var38857E8F00A1A40A83F7362F0A95A91E_665093558 = (mWebView
                    .onKeyUp(keyCode, event));
            } //End flattened ternary
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.223 -0400", hash_original_method = "4890DDDCE957B3D3A5D6757132681BB5", hash_generated_method = "76DCB47AA1E71C53BB543CC186134B24")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void ensureLayout() {
        {
            boolean var778B744EBE60DF815BEE98852B413FC5_1338086271 = (getLayout() == null);
            {
                measure(mWidthSpec, mHeightSpec);
                LayoutParams params;
                params = (LayoutParams) getLayoutParams();
                {
                    layout(params.x, params.y, params.x + params.width,
                        params.y + params.height);
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (getLayout() == null) {
            //measure(mWidthSpec, mHeightSpec);
            //LayoutParams params = (LayoutParams) getLayoutParams();
            //if (params != null) {
                //layout(params.x, params.y, params.x + params.width,
                        //params.y + params.height);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.223 -0400", hash_original_method = "7D5E495C9B289687F8273FA9EA57C0F7", hash_generated_method = "FC911BC72635DEA1E874EDA58755CEAF")
    @DSModeled(DSC.SAFE)
     ResultReceiver getResultReceiver() {
        return (ResultReceiver)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mReceiver;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.224 -0400", hash_original_method = "0D2A49DF88825D4B2D39C3141FFC083A", hash_generated_method = "5725110CBEF0D79BC96804FAFB6AE328")
    @DSModeled(DSC.SAFE)
     boolean isSameTextField(int ptr) {
        dsTaint.addTaint(ptr);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return ptr == mNodePointer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.224 -0400", hash_original_method = "480AEB5EE1C7676DB93788B189E32B71", hash_generated_method = "DFD71753472067ED14494E08B499306B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void lineUpScroll() {
        Layout layout;
        layout = getLayout();
        {
            {
                float maxScrollX;
                maxScrollX = layout.getLineRight(0) - getWidth();
                mWebView.scrollFocusedTextInputX(maxScrollX > 0 ?
                        mScrollX / maxScrollX : 0);
            } //End block
            {
                mWebView.scrollFocusedTextInputY(mScrollY);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //Layout layout = getLayout();
        //if (mWebView != null && layout != null) {
            //if (mSingle) {
                //float maxScrollX = layout.getLineRight(0) - getWidth();
                //if (DebugFlags.WEB_TEXT_VIEW) {
                    //Log.v(LOGTAG, "onTouchEvent x=" + mScrollX + " y="
                            //+ mScrollY + " maxX=" + maxScrollX);
                //}
                //mWebView.scrollFocusedTextInputX(maxScrollX > 0 ?
                        //mScrollX / maxScrollX : 0);
            //} else {
                //mWebView.scrollFocusedTextInputY(mScrollY);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.224 -0400", hash_original_method = "76914D313CC2AB81853EDD1E3C727FFE", hash_generated_method = "27A39B08F4D916E6488244CFF8DED7A1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void makeNewLayout(int w, int hintWidth, Metrics boring,
            Metrics hintBoring, int ellipsisWidth, boolean bringIntoView) {
        dsTaint.addTaint(bringIntoView);
        dsTaint.addTaint(w);
        dsTaint.addTaint(hintBoring.dsTaint);
        dsTaint.addTaint(boring.dsTaint);
        dsTaint.addTaint(ellipsisWidth);
        dsTaint.addTaint(hintWidth);
        super.makeNewLayout(w, hintWidth, boring, hintBoring, ellipsisWidth,
                bringIntoView);
        lineUpScroll();
        // ---------- Original Method ----------
        //super.makeNewLayout(w, hintWidth, boring, hintBoring, ellipsisWidth,
                //bringIntoView);
        //lineUpScroll();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.224 -0400", hash_original_method = "B64466D7D13E6636B7758E5E911C1FF7", hash_generated_method = "EC2561C74429EA4516B5CDD63C4A7081")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public InputConnection onCreateInputConnection(
            EditorInfo outAttrs) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(outAttrs.dsTaint);
        InputConnection connection;
        connection = super.onCreateInputConnection(outAttrs);
        {
            outAttrs.fieldName = mWebView.nativeFocusCandidateName() + "\\"
                    + mWebView.getUrl();
        } //End block
        return (InputConnection)dsTaint.getTaint();
        // ---------- Original Method ----------
        //InputConnection connection = super.onCreateInputConnection(outAttrs);
        //if (mWebView != null) {
            //outAttrs.fieldName = mWebView.nativeFocusCandidateName() + "\\"
                    //+ mWebView.getUrl();
        //}
        //return connection;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.225 -0400", hash_original_method = "804428A0FF8505961E29DE067C3E7206", hash_generated_method = "A0BB5B760C7BED5A127B6B4BA6BB78CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onEditorAction(int actionCode) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(actionCode);
        //Begin case EditorInfo.IME_ACTION_NEXT 
        {
            boolean var61E9772AE146CF8460E5E9E7C7CB61AE_1857014619 = (mWebView.nativeMoveCursorToNextTextInput());
            {
                mWebView.rebuildWebTextView();
                setDefaultSelection();
                mWebView.invalidate();
            } //End block
        } //End collapsed parenthetic
        //End case EditorInfo.IME_ACTION_NEXT 
        //Begin case EditorInfo.IME_ACTION_DONE 
        super.onEditorAction(actionCode);
        //End case EditorInfo.IME_ACTION_DONE 
        //Begin case EditorInfo.IME_ACTION_GO EditorInfo.IME_ACTION_SEARCH 
        InputMethodManager.getInstance(mContext)
                    .hideSoftInputFromWindow(getWindowToken(), 0);
        //End case EditorInfo.IME_ACTION_GO EditorInfo.IME_ACTION_SEARCH 
        //Begin case EditorInfo.IME_ACTION_GO EditorInfo.IME_ACTION_SEARCH 
        sendDomEvent(new KeyEvent(KeyEvent.ACTION_DOWN,
                    KeyEvent.KEYCODE_ENTER));
        //End case EditorInfo.IME_ACTION_GO EditorInfo.IME_ACTION_SEARCH 
        //Begin case EditorInfo.IME_ACTION_GO EditorInfo.IME_ACTION_SEARCH 
        sendDomEvent(new KeyEvent(KeyEvent.ACTION_UP,
                    KeyEvent.KEYCODE_ENTER));
        //End case EditorInfo.IME_ACTION_GO EditorInfo.IME_ACTION_SEARCH 
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.225 -0400", hash_original_method = "199CA847E2A702BC0971D902FFD82329", hash_generated_method = "DCA92E8805054C83961621F132ED6FC2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onFocusChanged(boolean focused, int direction,
            Rect previouslyFocusedRect) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(direction);
        dsTaint.addTaint(previouslyFocusedRect.dsTaint);
        dsTaint.addTaint(focused);
        mFromFocusChange = true;
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
        {
            mWebView.setActive(true);
        } //End block
        {
            mWebView.setActive(false);
        } //End block
        mFromFocusChange = false;
        // ---------- Original Method ----------
        //mFromFocusChange = true;
        //super.onFocusChanged(focused, direction, previouslyFocusedRect);
        //if (focused) {
            //mWebView.setActive(true);
        //} else if (!mInsideRemove) {
            //mWebView.setActive(false);
        //}
        //mFromFocusChange = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.225 -0400", hash_original_method = "A29BC68952EA75E2FA60BFA3E7E77A14", hash_generated_method = "F2F0B847EB665EB33124178F440C0B3A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(id);
        dsTaint.addTaint(position);
        dsTaint.addTaint(parent.dsTaint);
        dsTaint.addTaint(view.dsTaint);
        {
            replaceText("");
            WebSettings settings;
            settings = mWebView.getSettings();
            {
                mWebView.autoFillForm(mQueryId);
            } //End block
            {
                mWebView.getWebChromeClient().setupAutoFill(
                        mHandler.obtainMessage(AUTOFILL_FORM));
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (id == 0 && position == 0) {
            //replaceText("");
            //WebSettings settings = mWebView.getSettings();
            //if (mAutoFillProfileIsSet) {
                //mWebView.autoFillForm(mQueryId);
            //} else {
                //mWebView.getWebChromeClient().setupAutoFill(
                        //mHandler.obtainMessage(AUTOFILL_FORM));
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.226 -0400", hash_original_method = "D3CDB855BC1EDCE86869BE708EA015CC", hash_generated_method = "7D94A5ED7616AD680CBBFB8D6AAA4BE2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(oldt);
        dsTaint.addTaint(t);
        dsTaint.addTaint(oldl);
        dsTaint.addTaint(l);
        super.onScrollChanged(l, t, oldl, oldt);
        lineUpScroll();
        // ---------- Original Method ----------
        //super.onScrollChanged(l, t, oldl, oldt);
        //lineUpScroll();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.226 -0400", hash_original_method = "8C1441039C2AFE6E28B135997E9DB205", hash_generated_method = "E30DE83B7914D94EDCE919474D70D9EC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onSelectionChanged(int selStart, int selEnd) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(selStart);
        dsTaint.addTaint(selEnd);
        {
            mWebView.setSelection(selStart, selEnd);
            lineUpScroll();
        } //End block
        // ---------- Original Method ----------
        //if (!mFromWebKit && !mFromFocusChange && !mFromSetInputType
                //&& mWebView != null && !mInSetTextAndKeepSelection) {
            //if (DebugFlags.WEB_TEXT_VIEW) {
                //Log.v(LOGTAG, "onSelectionChanged selStart=" + selStart
                        //+ " selEnd=" + selEnd);
            //}
            //mWebView.setSelection(selStart, selEnd);
            //lineUpScroll();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.227 -0400", hash_original_method = "86E27647BFDE15D66BF8F4D142CAE4A5", hash_generated_method = "9EE152AF1D862A4918571EB898F7C81E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onTextChanged(CharSequence s,int start,int before,int count) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(count);
        dsTaint.addTaint(s);
        dsTaint.addTaint(start);
        dsTaint.addTaint(before);
        super.onTextChanged(s, start, before, count);
        String postChange;
        postChange = s.toString();
        {
            boolean var69B0C10C334112C2C00F8FB5966E302E_776451161 = (mPreChange == null || mPreChange.equals(postChange) ||
                (mMaxLength > -1 && mPreChange.length() > mMaxLength &&
                mPreChange.substring(0, mMaxLength).equals(postChange)));
        } //End collapsed parenthetic
        {
            {
                updateCachedTextfield();
                {
                    mGotDelete = false;
                    int oldEnd;
                    oldEnd = start + before;
                    {
                        sendDomEvent(new KeyEvent(KeyEvent.ACTION_DOWN,
                                KeyEvent.KEYCODE_DEL));
                        sendDomEvent(new KeyEvent(KeyEvent.ACTION_UP,
                                KeyEvent.KEYCODE_DEL));
                    } //End block
                } //End block
                mWebView.deleteSelection(start, start + before);
            } //End block
            mGotDelete = false;
        } //End block
        mGotDelete = false;
        {
            String replaceButOne;
            replaceButOne = mPreChange.subSequence(start,
                    start + before).toString();
            String replacedString;
            replacedString = s.subSequence(start,
                    start + before).toString();
            {
                boolean var0D4AADC711594525F4030B31B07C7D56_2024648967 = (replaceButOne.equals(replacedString));
                {
                    start += before;
                    before = 0;
                    count = 1;
                } //End block
            } //End collapsed parenthetic
        } //End block
        mPreChange = postChange;
        KeyEvent[] events;
        events = null;
        {
            TextUtils.getChars(s, start + count - 1, start + count, mCharacter, 0);
            KeyCharacterMap kmap;
            kmap = KeyCharacterMap.load(KeyCharacterMap.VIRTUAL_KEYBOARD);
            events = kmap.getEvents(mCharacter);
        } //End block
        boolean useKeyEvents;
        useKeyEvents = (events != null);
        {
            {
                mWebView.setSelection(start, start + before);
            } //End block
            int length;
            length = events.length;
            {
                int i;
                i = 0;
                {
                    {
                        boolean varFC8D0E9132A6E0775D7E4533EF2FB773_666708605 = (!KeyEvent.isModifierKey(events[i].getKeyCode()));
                        {
                            sendDomEvent(events[i]);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            String replace;
            replace = s.subSequence(start,
                    start + count).toString();
            mWebView.replaceTextfieldText(start, start + before, replace,
                    start + count,
                    start + count);
        } //End block
        updateCachedTextfield();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.228 -0400", hash_original_method = "C8E8CDF4C81BBE6A97ACE8DDCE593DE3", hash_generated_method = "B9E9F3D654502B2A40CF00944FCA1FD4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(event.dsTaint);
        {
            Object var9E1FBD251DF7E53AB77C3A31F15B2B38_1631978490 = (event.getAction());
            //Begin case MotionEvent.ACTION_DOWN 
            super.onTouchEvent(event);
            //End case MotionEvent.ACTION_DOWN 
            //Begin case MotionEvent.ACTION_DOWN 
            mDragStartX = event.getX();
            //End case MotionEvent.ACTION_DOWN 
            //Begin case MotionEvent.ACTION_DOWN 
            mDragStartY = event.getY();
            //End case MotionEvent.ACTION_DOWN 
            //Begin case MotionEvent.ACTION_DOWN 
            mDragStartTime = event.getEventTime();
            //End case MotionEvent.ACTION_DOWN 
            //Begin case MotionEvent.ACTION_DOWN 
            mDragSent = false;
            //End case MotionEvent.ACTION_DOWN 
            //Begin case MotionEvent.ACTION_DOWN 
            mScrolled = false;
            //End case MotionEvent.ACTION_DOWN 
            //Begin case MotionEvent.ACTION_DOWN 
            mGotTouchDown = true;
            //End case MotionEvent.ACTION_DOWN 
            //Begin case MotionEvent.ACTION_DOWN 
            mHasPerformedLongClick = false;
            //End case MotionEvent.ACTION_DOWN 
            //Begin case MotionEvent.ACTION_MOVE 
            {
                mGotTouchDown = false;
            } //End block
            //End case MotionEvent.ACTION_MOVE 
            //Begin case MotionEvent.ACTION_MOVE 
            int slop;
            slop = ViewConfiguration.get(mContext).getScaledTouchSlop();
            //End case MotionEvent.ACTION_MOVE 
            //Begin case MotionEvent.ACTION_MOVE 
            Spannable buffer;
            buffer = getText();
            //End case MotionEvent.ACTION_MOVE 
            //Begin case MotionEvent.ACTION_MOVE 
            int initialScrollX;
            initialScrollX = Touch.getInitialScrollX(this, buffer);
            //End case MotionEvent.ACTION_MOVE 
            //Begin case MotionEvent.ACTION_MOVE 
            int initialScrollY;
            initialScrollY = Touch.getInitialScrollY(this, buffer);
            //End case MotionEvent.ACTION_MOVE 
            //Begin case MotionEvent.ACTION_MOVE 
            super.onTouchEvent(event);
            //End case MotionEvent.ACTION_MOVE 
            //Begin case MotionEvent.ACTION_MOVE 
            int dx;
            dx = Math.abs(mScrollX - initialScrollX);
            //End case MotionEvent.ACTION_MOVE 
            //Begin case MotionEvent.ACTION_MOVE 
            int dy;
            dy = Math.abs(mScrollY - initialScrollY);
            //End case MotionEvent.ACTION_MOVE 
            //Begin case MotionEvent.ACTION_MOVE 
            int smallerSlop;
            smallerSlop = slop/2;
            //End case MotionEvent.ACTION_MOVE 
            //Begin case MotionEvent.ACTION_MOVE 
            {
                mScrolled = true;
                cancelLongPress();
            } //End block
            //End case MotionEvent.ACTION_MOVE 
            //Begin case MotionEvent.ACTION_MOVE 
            {
                boolean var9093599EE2DF5C5F4C4285B452695469_274044899 = (Math.abs((int) event.getX() - mDragStartX) < slop
                    && Math.abs((int) event.getY() - mDragStartY) < slop);
            } //End collapsed parenthetic
            //End case MotionEvent.ACTION_MOVE 
            //Begin case MotionEvent.ACTION_MOVE 
            {
                {
                    mWebView.initiateTextFieldDrag(mDragStartX, mDragStartY,
                            mDragStartTime);
                    mDragSent = true;
                } //End block
                boolean scrolled;
                scrolled = mWebView.textFieldDrag(event);
                {
                    mScrolled = true;
                    cancelLongPress();
                } //End block
            } //End block
            //End case MotionEvent.ACTION_MOVE 
            //Begin case MotionEvent.ACTION_UP MotionEvent.ACTION_CANCEL 
            super.onTouchEvent(event);
            //End case MotionEvent.ACTION_UP MotionEvent.ACTION_CANCEL 
            //Begin case MotionEvent.ACTION_UP MotionEvent.ACTION_CANCEL 
            {
                mGotTouchDown = false;
            } //End block
            //End case MotionEvent.ACTION_UP MotionEvent.ACTION_CANCEL 
            //Begin case MotionEvent.ACTION_UP MotionEvent.ACTION_CANCEL 
            {
                cancelLongPress();
                {
                    mWebView.touchUpOnTextField(event);
                } //End block
            } //End block
            //End case MotionEvent.ACTION_UP MotionEvent.ACTION_CANCEL 
            //Begin case MotionEvent.ACTION_UP MotionEvent.ACTION_CANCEL 
            {
                mWebView.onTouchEvent(event);
            } //End block
            //End case MotionEvent.ACTION_UP MotionEvent.ACTION_CANCEL 
            //Begin case MotionEvent.ACTION_UP MotionEvent.ACTION_CANCEL 
            mGotTouchDown = false;
            //End case MotionEvent.ACTION_UP MotionEvent.ACTION_CANCEL 
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.229 -0400", hash_original_method = "39A98F4B040DD226E88FA29A15911D83", hash_generated_method = "85AFA36F9C855B176532943C7F0ADFAE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onTrackballEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(event.dsTaint);
        {
            boolean varBF0DD052E7F558A1BAF9DA85140649CD_1427386134 = (isPopupShowing());
            {
                boolean varA6E78A78BE965F341F5864424E55B8B1_1381087187 = (super.onTrackballEvent(event));
            } //End block
        } //End collapsed parenthetic
        {
            boolean var4AC14C2DF0ECC4D7F899974BD11F2605_2142600032 = (event.getAction() != MotionEvent.ACTION_MOVE);
        } //End collapsed parenthetic
        Spannable text;
        text = getText();
        MovementMethod move;
        move = getMovementMethod();
        {
            boolean var0040A18D22912D1038EED02F5F656E69_1714631208 = (move != null && getLayout() != null &&
            move.onTrackballEvent(this, text, event));
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (isPopupShowing()) {
            //return super.onTrackballEvent(event);
        //}
        //if (event.getAction() != MotionEvent.ACTION_MOVE) {
            //return false;
        //}
        //Spannable text = getText();
        //MovementMethod move = getMovementMethod();
        //if (move != null && getLayout() != null &&
            //move.onTrackballEvent(this, text, event)) {
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.229 -0400", hash_original_method = "3EEE407D8FB8A76E11AC99079A17DC34", hash_generated_method = "ADF067DA551F403749D8999AC0D331D1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean performLongClick() {
        mHasPerformedLongClick = true;
        boolean var98B6A4E762A67C23892FBA15AF127489_1765174940 = (super.performLongClick());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //mHasPerformedLongClick = true;
        //return super.performLongClick();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.230 -0400", hash_original_method = "E890325AD4CF04CF90789A3947029902", hash_generated_method = "EEA778FE9FAF8DB055117852382B7FC0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void remove() {
        InputMethodManager imm;
        imm = InputMethodManager.getInstance(mContext);
        {
            boolean var4D18B3E55AF70DF7121DEC3A80BC5F4E_303147308 = (imm.isActive(this));
            {
                imm.hideSoftInputFromWindow(getWindowToken(), 0);
            } //End block
        } //End collapsed parenthetic
        mInsideRemove = true;
        boolean isFocused;
        isFocused = hasFocus();
        mWebView.removeView(this);
        {
            mWebView.requestFocus();
        } //End block
        mInsideRemove = false;
        mHandler.removeCallbacksAndMessages(null);
        // ---------- Original Method ----------
        //InputMethodManager imm = InputMethodManager.getInstance(mContext);
        //if (imm.isActive(this)) {
            //imm.hideSoftInputFromWindow(getWindowToken(), 0);
        //}
        //mInsideRemove = true;
        //boolean isFocused = hasFocus();
        //mWebView.removeView(this);
        //if (isFocused) {
            //mWebView.requestFocus();
        //}
        //mInsideRemove = false;
        //mHandler.removeCallbacksAndMessages(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.230 -0400", hash_original_method = "2AA5BA571DA39EAF8290098D28F58BC6", hash_generated_method = "218ADB1B5289764B0C38FCA8EBD53D5E")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean requestRectangleOnScreen(Rect rectangle, boolean immediate) {
        dsTaint.addTaint(immediate);
        dsTaint.addTaint(rectangle.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.230 -0400", hash_original_method = "950AB6742CC7236DE25064405668EBFC", hash_generated_method = "4657985F6313AC55FDFE678AB48FC05E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void sendDomEvent(KeyEvent event) {
        dsTaint.addTaint(event.dsTaint);
        mWebView.passToJavaScript(getText().toString(), event);
        // ---------- Original Method ----------
        //mWebView.passToJavaScript(getText().toString(), event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.230 -0400", hash_original_method = "95851FC5190E2011BB56B8769701FDF9", hash_generated_method = "6D06F62C9140EEB0993FA13B0EFB2D96")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setAdapterCustom(AutoCompleteAdapter adapter) {
        dsTaint.addTaint(adapter.dsTaint);
        {
            setInputType(getInputType()
                    | InputType.TYPE_TEXT_FLAG_AUTO_COMPLETE);
            adapter.setTextView(this);
            {
                setOnItemClickListener(this);
            } //End block
            {
                setOnItemClickListener(null);
            } //End block
            showDropDown();
        } //End block
        {
            dismissDropDown();
        } //End block
        super.setAdapter(adapter);
        // ---------- Original Method ----------
        //if (adapter != null) {
            //setInputType(getInputType()
                    //| InputType.TYPE_TEXT_FLAG_AUTO_COMPLETE);
            //adapter.setTextView(this);
            //if (mAutoFillable) {
                //setOnItemClickListener(this);
            //} else {
                //setOnItemClickListener(null);
            //}
            //showDropDown();
        //} else {
            //dismissDropDown();
        //}
        //super.setAdapter(adapter);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.232 -0400", hash_original_method = "10D826035FBCEEF5092B615EC9DFDE75", hash_generated_method = "FFC5835C47674426DAD621FB93FE9D2C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void setDefaultSelection() {
        Spannable text;
        text = (Spannable) getText();
        int selection;
        selection = text.length();
        selection = 0;
        {
            boolean varF4278F67DD911DA82DDA2D9690C72EDB_1637141223 = (Selection.getSelectionStart(text) == selection
                && Selection.getSelectionEnd(text) == selection);
            {
                {
                    mWebView.setSelection(selection, selection);
                } //End block
            } //End block
            {
                Selection.setSelection(text, selection, selection);
            } //End block
        } //End collapsed parenthetic
        mWebView.incrementTextGeneration();
        // ---------- Original Method ----------
        //Spannable text = (Spannable) getText();
        //int selection = mSingle ? text.length() : 0;
        //if (Selection.getSelectionStart(text) == selection
                //&& Selection.getSelectionEnd(text) == selection) {
            //if (mWebView != null) {
                //mWebView.setSelection(selection, selection);
            //}
        //} else {
            //Selection.setSelection(text, selection, selection);
        //}
        //if (mWebView != null) mWebView.incrementTextGeneration();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.233 -0400", hash_original_method = "5F3F3B089AD7E0D8B5861A9F4DCE5D55", hash_generated_method = "2F2DD5334A22A6C8F167BC86426B2187")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setInputType(int type) {
        dsTaint.addTaint(type);
        mFromSetInputType = true;
        super.setInputType(type);
        mFromSetInputType = false;
        // ---------- Original Method ----------
        //mFromSetInputType = true;
        //super.setInputType(type);
        //mFromSetInputType = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.233 -0400", hash_original_method = "6C4324E77F1CB780AA79022DD606C31E", hash_generated_method = "89EDC9CC7091108BCABA8257D6F7E955")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setMaxLength(int maxLength) {
        dsTaint.addTaint(maxLength);
        {
            setFilters(NO_FILTERS);
        } //End block
        {
            setFilters(new InputFilter[] {
                new InputFilter.LengthFilter(maxLength) });
        } //End block
        // ---------- Original Method ----------
        //mMaxLength = maxLength;
        //if (-1 == maxLength) {
            //setFilters(NO_FILTERS);
        //} else {
            //setFilters(new InputFilter[] {
                //new InputFilter.LengthFilter(maxLength) });
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.233 -0400", hash_original_method = "C341AA0EB003F8D508947196584836B7", hash_generated_method = "770B33464BA3733CD62B61F3EAD16014")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void setNodePointer(int ptr) {
        dsTaint.addTaint(ptr);
        {
            setAdapterCustom(null);
        } //End block
        // ---------- Original Method ----------
        //if (ptr != mNodePointer) {
            //mNodePointer = ptr;
            //setAdapterCustom(null);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.236 -0400", hash_original_method = "1A385B6FBFB65985BDFEFA75CA11C93C", hash_generated_method = "4B02A6C518DCA0529A9C15DB5295D933")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void setRect(int x, int y, int width, int height) {
        dsTaint.addTaint(height);
        dsTaint.addTaint(width);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        LayoutParams lp;
        lp = (LayoutParams) getLayoutParams();
        x -= mRingInset;
        y -= mRingInset;
        width += 2 * mRingInset;
        height += 2 * mRingInset;
        boolean needsUpdate;
        needsUpdate = false;
        {
            lp = new LayoutParams(width, height, x, y);
        } //End block
        {
            {
                needsUpdate = true;
                lp.x = x;
                lp.y = y;
                lp.width = width;
                lp.height = height;
            } //End block
        } //End block
        {
            boolean var88AD79EA276C28AD3B3469360BCE1788_239221785 = (getParent() == null);
            {
                mWebView.addView(this, 0, lp);
            } //End block
            {
                setLayoutParams(lp);
            } //End block
        } //End collapsed parenthetic
        mWidthSpec = MeasureSpec.makeMeasureSpec(width, MeasureSpec.EXACTLY);
        mHeightSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.236 -0400", hash_original_method = "CE3949E5C336F8D95926C2F0BAE76623", hash_generated_method = "780EADAB3B1665832CDE4CBCC9C976CC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void setSelectionFromWebKit(int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        Spannable text;
        text = (Spannable) getText();
        int length;
        length = text.length();
        mFromWebKit = true;
        Selection.setSelection(text, start, end);
        mFromWebKit = false;
        // ---------- Original Method ----------
        //if (start < 0 || end < 0) return;
        //Spannable text = (Spannable) getText();
        //int length = text.length();
        //if (start > length || end > length) return;
        //mFromWebKit = true;
        //Selection.setSelection(text, start, end);
        //mFromWebKit = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.237 -0400", hash_original_method = "0E0FB59047FF987C205DC97754DD32D6", hash_generated_method = "46ED449FA39054C279978DD39BFF9DC8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void updateTextSize() {
        Assert.assertNotNull("updateTextSize should only be called from "
                + "mWebView, so mWebView should never be null!", mWebView);
        float size;
        size = mWebView.nativeFocusCandidateTextSize()
                * mWebView.getScale();
        setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
        // ---------- Original Method ----------
        //Assert.assertNotNull("updateTextSize should only be called from "
                //+ "mWebView, so mWebView should never be null!", mWebView);
        //float size = mWebView.nativeFocusCandidateTextSize()
                //* mWebView.getScale();
        //setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.238 -0400", hash_original_method = "FCE77DF28E9B30518950525927BBC7BA", hash_generated_method = "EFE0A32148690A187F7BDE676B316938")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void setTextAndKeepSelection(String text) {
        dsTaint.addTaint(text);
        Editable edit;
        edit = getText();
        {
            boolean var5432E2777F3E47E5271ACDBBC7473721_1575469863 = (edit.toString().equals(text));
        } //End collapsed parenthetic
        int selStart;
        selStart = Selection.getSelectionStart(edit);
        int selEnd;
        selEnd = Selection.getSelectionEnd(edit);
        mInSetTextAndKeepSelection = true;
        edit.replace(0, edit.length(), text);
        int newLength;
        newLength = edit.length();
        selStart = newLength;
        selEnd = newLength;
        Selection.setSelection(edit, selStart, selEnd);
        mInSetTextAndKeepSelection = false;
        InputMethodManager imm;
        imm = InputMethodManager.peekInstance();
        {
            boolean varA8F5F3E7D2555623A6FFCFE24BB87152_1278892101 = (imm != null && imm.isActive(this));
            {
                imm.restartInput(this);
            } //End block
        } //End collapsed parenthetic
        updateCachedTextfield();
        // ---------- Original Method ----------
        //Editable edit = getText();
        //mPreChange = text;
        //if (edit.toString().equals(text)) {
            //return;
        //}
        //int selStart = Selection.getSelectionStart(edit);
        //int selEnd = Selection.getSelectionEnd(edit);
        //mInSetTextAndKeepSelection = true;
        //edit.replace(0, edit.length(), text);
        //int newLength = edit.length();
        //if (selStart > newLength) selStart = newLength;
        //if (selEnd > newLength) selEnd = newLength;
        //Selection.setSelection(edit, selStart, selEnd);
        //mInSetTextAndKeepSelection = false;
        //InputMethodManager imm = InputMethodManager.peekInstance();
        //if (imm != null && imm.isActive(this)) {
            //imm.restartInput(this);
        //}
        //updateCachedTextfield();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.239 -0400", hash_original_method = "9C43235B4CCED4C8A2DC53AB1F7D42B9", hash_generated_method = "31B69A5918D952C231208BE39E1A8E22")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void setType(int type) {
        dsTaint.addTaint(type);
        boolean single;
        single = true;
        int maxLength;
        maxLength = -1;
        int inputType;
        inputType = InputType.TYPE_CLASS_TEXT
                | InputType.TYPE_TEXT_VARIATION_WEB_EDIT_TEXT;
        int imeOptions;
        imeOptions = EditorInfo.IME_FLAG_NO_EXTRACT_UI
                | EditorInfo.IME_FLAG_NO_FULLSCREEN;
        {
            boolean var3E3815771BE6F168CB2B354EC011EE17_1204160389 = (!mWebView.nativeFocusCandidateIsSpellcheck());
            {
                inputType |= InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS;
            } //End block
        } //End collapsed parenthetic
        {
            boolean var44F922C57DB3172B2082134B01A29DB9_1685606286 = (TEXT_AREA != type
                && mWebView.nativeFocusCandidateHasNextTextfield());
            {
                imeOptions |= EditorInfo.IME_FLAG_NAVIGATE_NEXT;
            } //End block
        } //End collapsed parenthetic
        //Begin case NORMAL_TEXT_FIELD 
        imeOptions |= EditorInfo.IME_ACTION_GO;
        //End case NORMAL_TEXT_FIELD 
        //Begin case TEXT_AREA 
        single = false;
        //End case TEXT_AREA 
        //Begin case TEXT_AREA 
        inputType |= InputType.TYPE_TEXT_FLAG_MULTI_LINE
                        | InputType.TYPE_TEXT_FLAG_CAP_SENTENCES
                        | InputType.TYPE_TEXT_FLAG_AUTO_CORRECT;
        //End case TEXT_AREA 
        //Begin case TEXT_AREA 
        imeOptions |= EditorInfo.IME_ACTION_NONE;
        //End case TEXT_AREA 
        //Begin case PASSWORD 
        inputType |= EditorInfo.TYPE_TEXT_VARIATION_WEB_PASSWORD;
        //End case PASSWORD 
        //Begin case PASSWORD 
        imeOptions |= EditorInfo.IME_ACTION_GO;
        //End case PASSWORD 
        //Begin case SEARCH 
        imeOptions |= EditorInfo.IME_ACTION_SEARCH;
        //End case SEARCH 
        //Begin case EMAIL 
        inputType = InputType.TYPE_CLASS_TEXT
                        | InputType.TYPE_TEXT_VARIATION_WEB_EMAIL_ADDRESS;
        //End case EMAIL 
        //Begin case EMAIL 
        imeOptions |= EditorInfo.IME_ACTION_GO;
        //End case EMAIL 
        //Begin case NUMBER 
        inputType = InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_NORMAL
                        | InputType.TYPE_NUMBER_FLAG_SIGNED | InputType.TYPE_NUMBER_FLAG_DECIMAL;
        //End case NUMBER 
        //Begin case NUMBER 
        imeOptions |= EditorInfo.IME_ACTION_NEXT;
        //End case NUMBER 
        //Begin case TELEPHONE 
        inputType = InputType.TYPE_CLASS_PHONE;
        //End case TELEPHONE 
        //Begin case TELEPHONE 
        imeOptions |= EditorInfo.IME_ACTION_NEXT;
        //End case TELEPHONE 
        //Begin case URL 
        imeOptions |= EditorInfo.IME_ACTION_GO;
        //End case URL 
        //Begin case default 
        imeOptions |= EditorInfo.IME_ACTION_GO;
        //End case default 
        setHint(null);
        setThreshold(1);
        boolean autoComplete;
        autoComplete = false;
        {
            mWebView.requestLabel(mWebView.nativeFocusCandidateFramePointer(),
                    mNodePointer);
            maxLength = mWebView.nativeFocusCandidateMaxLength();
            autoComplete = mWebView.nativeFocusCandidateIsAutoComplete();
            {
                String name;
                name = mWebView.nativeFocusCandidateName();
                {
                    boolean varD67362095BA70133EC9349BE62DFEB10_1025101654 = (name != null && name.length() > 0);
                    {
                        mWebView.requestFormData(name, mNodePointer, mAutoFillable,
                            autoComplete);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        mSingle = single;
        setMaxLength(maxLength);
        setHorizontallyScrolling(single);
        setInputType(inputType);
        clearComposingText();
        setImeOptions(imeOptions);
        setVisibility(VISIBLE);
        {
            setAdapterCustom(null);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.240 -0400", hash_original_method = "DC0208EAD79A0BCADD603C831599A0E0", hash_generated_method = "353A0AED74824F2EAB6775FEEFC50847")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void updateCachedTextfield() {
        mWebView.updateCachedTextfield(getText().toString());
        // ---------- Original Method ----------
        //mWebView.updateCachedTextfield(getText().toString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.240 -0400", hash_original_method = "E906B54723AD6F9ED79F8F4825A6BCDE", hash_generated_method = "06FE800A21CD502D4AF1F587D78E1CB7")
    @DSModeled(DSC.SAFE)
     void setAutoFillProfileIsSet(boolean autoFillProfileIsSet) {
        dsTaint.addTaint(autoFillProfileIsSet);
        // ---------- Original Method ----------
        //mAutoFillProfileIsSet = autoFillProfileIsSet;
    }

    
        static String urlForAutoCompleteData(String urlString) {
        URL url = null;
        try {
            url = new URL(urlString);
        } catch (MalformedURLException e) {
            Log.e(LOGTAG, "Unable to parse URL "+url);
        }
        return url != null ? url.getProtocol() + "://" + url.getHost() + url.getPath() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.240 -0400", hash_original_method = "4A2837BA61927EB8FB72E630E60D5F6F", hash_generated_method = "CB4120BCF158448E775B4617586AE912")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setGravityForRtl(boolean rtl) {
        dsTaint.addTaint(rtl);
        int gravity;
        gravity = Gravity.RIGHT;
        gravity = Gravity.LEFT;
        gravity |= mSingle ? Gravity.CENTER_VERTICAL : Gravity.TOP;
        setGravity(gravity);
        // ---------- Original Method ----------
        //int gravity = rtl ? Gravity.RIGHT : Gravity.LEFT;
        //gravity |= mSingle ? Gravity.CENTER_VERTICAL : Gravity.TOP;
        //setGravity(gravity);
    }

    
    private class MyResultReceiver extends ResultReceiver {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.240 -0400", hash_original_method = "B2A067584316D6A9483E42E372CB0982", hash_generated_method = "8363BC6111CF6C29F0430EC9A60CAD32")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public MyResultReceiver(Handler handler) {
            super(handler);
            dsTaint.addTaint(handler.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.241 -0400", hash_original_method = "8968B16CB33DBBA966B5E497FFEF8D80", hash_generated_method = "96F56410872FD04936165A775E2C1902")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected void onReceiveResult(int resultCode, Bundle resultData) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(resultData.dsTaint);
            dsTaint.addTaint(resultCode);
            {
                mWebView.revealSelection();
            } //End block
            // ---------- Original Method ----------
            //if (resultCode == InputMethodManager.RESULT_SHOWN
                    //&& mWebView != null) {
                //mWebView.revealSelection();
            //}
        }

        
    }


    
    private static class BackgroundDrawable extends Drawable {
        private Paint mPaint = new Paint();
        private int mBorderWidth;
        private Rect mInsetRect = new Rect();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.241 -0400", hash_original_method = "A19D023ADE41459A26F3E78681345993", hash_generated_method = "8B183BC2E8654EE5494282E6B829A796")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public BackgroundDrawable(int width) {
            dsTaint.addTaint(width);
            mPaint = new Paint();
            mPaint.setStrokeWidth(width);
            // ---------- Original Method ----------
            //mPaint = new Paint();
            //mPaint.setStrokeWidth(width);
            //mBorderWidth = width;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.241 -0400", hash_original_method = "B7807C75F15BA2C587A7A3AFE401787F", hash_generated_method = "56ECA78ABDFACBA1D4F6E7F870DD61C6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void draw(Canvas canvas) {
            dsTaint.addTaint(canvas.dsTaint);
            mPaint.setColor(0x6633b5e5);
            canvas.drawRect(getBounds(), mPaint);
            mInsetRect.left = getBounds().left + mBorderWidth;
            mInsetRect.top = getBounds().top + mBorderWidth;
            mInsetRect.right = getBounds().right - mBorderWidth;
            mInsetRect.bottom = getBounds().bottom - mBorderWidth;
            mPaint.setColor(Color.WHITE);
            canvas.drawRect(mInsetRect, mPaint);
            // ---------- Original Method ----------
            //mPaint.setColor(0x6633b5e5);
            //canvas.drawRect(getBounds(), mPaint);
            //mInsetRect.left = getBounds().left + mBorderWidth;
            //mInsetRect.top = getBounds().top + mBorderWidth;
            //mInsetRect.right = getBounds().right - mBorderWidth;
            //mInsetRect.bottom = getBounds().bottom - mBorderWidth;
            //mPaint.setColor(Color.WHITE);
            //canvas.drawRect(mInsetRect, mPaint);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.241 -0400", hash_original_method = "5784D116F3F796E4D5324F7E68A41209", hash_generated_method = "44D4A82812B2915BEF6E44EE6FADB3E2")
        @DSModeled(DSC.SAFE)
        @Override
        public void setAlpha(int alpha) {
            dsTaint.addTaint(alpha);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.242 -0400", hash_original_method = "77240A7357C6E5E7293BFF14ACDD79D8", hash_generated_method = "CC674087B871E9CD9FAFA504ED466E83")
        @DSModeled(DSC.SAFE)
        @Override
        public void setColorFilter(ColorFilter cf) {
            dsTaint.addTaint(cf.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.242 -0400", hash_original_method = "AB3D570DA2A917C408AB4F7D8FCD7103", hash_generated_method = "ABA86D69E3485D7E8F9A1E6F7D7F161F")
        @DSModeled(DSC.SAFE)
        @Override
        public int getOpacity() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return PixelFormat.TRANSLUCENT;
        }

        
    }


    
    private static class WebTextViewLayout extends DynamicLayout {
        private float mLineHeight;
        private float mDifference;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.242 -0400", hash_original_method = "84A347E9C0B83549B9D13ECC225F88CE", hash_generated_method = "CC82BF38FD006E1D59CAFE1DA5B8E056")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public WebTextViewLayout(CharSequence base, CharSequence display,
                TextPaint paint,
                int width, Alignment align,
                float spacingMult, float spacingAdd,
                boolean includepad,
                TextUtils.TruncateAt ellipsize, int ellipsizedWidth,
                float lineHeight) {
            super(base, display, paint, width, align, spacingMult, spacingAdd,
                    includepad, ellipsize, ellipsizedWidth);
            dsTaint.addTaint(includepad);
            dsTaint.addTaint(spacingAdd);
            dsTaint.addTaint(ellipsizedWidth);
            dsTaint.addTaint(lineHeight);
            dsTaint.addTaint(align.dsTaint);
            dsTaint.addTaint(width);
            dsTaint.addTaint(base);
            dsTaint.addTaint(spacingMult);
            dsTaint.addTaint(paint.dsTaint);
            dsTaint.addTaint(display);
            dsTaint.addTaint(ellipsize.dsTaint);
            float paintLineHeight;
            paintLineHeight = paint.descent() - paint.ascent();
            {
                mLineHeight = paintLineHeight;
                mDifference = 0f;
            } //End block
            {
                mDifference = (lineHeight - paintLineHeight) / 2;
            } //End block
            // ---------- Original Method ----------
            //float paintLineHeight = paint.descent() - paint.ascent();
            //if (lineHeight == -1f) {
                //mLineHeight = paintLineHeight;
                //mDifference = 0f;
            //} else {
                //mLineHeight = lineHeight;
                //mDifference = (lineHeight - paintLineHeight) / 2;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.242 -0400", hash_original_method = "BD0D404B64FBDA001253C5382CB9CD95", hash_generated_method = "E49C4379BF4C6B6EE19A615CE9ECBFA5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int getLineTop(int line) {
            dsTaint.addTaint(line);
            int varF06BE5757632572D26BC32E78DF81A38_918402305 = (Math.round(mLineHeight * line - mDifference));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return Math.round(mLineHeight * line - mDifference);
        }

        
    }


    
    public static class AutoCompleteAdapter extends ArrayAdapter<String> {
        private TextView mTextView;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.243 -0400", hash_original_method = "8B198F037E06F3C258FC2837A183399D", hash_generated_method = "96788FEDF4668B1023A88A0221E5786D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public AutoCompleteAdapter(Context context, ArrayList<String> entries) {
            super(context, com.android.internal.R.layout
                    .web_text_view_dropdown, entries);
            dsTaint.addTaint(context.dsTaint);
            dsTaint.addTaint(entries.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.243 -0400", hash_original_method = "C6FC0517987C8200BB760FE857B81ECC", hash_generated_method = "D864853253EE86E22EB551E6A8FEF3DC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            dsTaint.addTaint(position);
            dsTaint.addTaint(parent.dsTaint);
            dsTaint.addTaint(convertView.dsTaint);
            TextView tv;
            tv = (TextView) super.getView(position, convertView, parent);
            {
                tv.setTextSize(TypedValue.COMPLEX_UNIT_PX, mTextView.getTextSize());
            } //End block
            return (View)dsTaint.getTaint();
            // ---------- Original Method ----------
            //TextView tv =
                    //(TextView) super.getView(position, convertView, parent);
            //if (tv != null && mTextView != null) {
                //tv.setTextSize(TypedValue.COMPLEX_UNIT_PX, mTextView.getTextSize());
            //}
            //return tv;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.243 -0400", hash_original_method = "C453A8A8AADC44244B92E3146B6F4B07", hash_generated_method = "E79B3A43B8FE281D19D0596FD901657E")
        @DSModeled(DSC.SAFE)
        private void setTextView(TextView tv) {
            dsTaint.addTaint(tv.dsTaint);
            // ---------- Original Method ----------
            //mTextView = tv;
        }

        
    }


    
    static final String LOGTAG = "webtextview";
    private static final InputFilter[] NO_FILTERS = new InputFilter[0];
    static final int FORM_NOT_AUTOFILLABLE = -1;
    private static final int NORMAL_TEXT_FIELD = 0;
    private static final int TEXT_AREA = 1;
    private static final int PASSWORD = 2;
    private static final int SEARCH = 3;
    private static final int EMAIL = 4;
    private static final int NUMBER = 5;
    private static final int TELEPHONE = 6;
    private static final int URL = 7;
    private static final int AUTOFILL_FORM = 100;
}

