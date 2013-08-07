package android.webkit;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import junit.framework.Assert;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
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





class WebTextView extends AutoCompleteTextView implements AdapterView.OnItemClickListener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.035 -0400", hash_original_field = "E629B0C9798771544E235B84F0C22269", hash_generated_field = "74A54BC69C155F1DB9DBB9FB9549E6B1")

    private int mRingInset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.035 -0400", hash_original_field = "72439B8F99EB438C3DA5D9CD798C6786", hash_generated_field = "99346B50377E115231263981E00655CA")

    private WebView mWebView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.035 -0400", hash_original_field = "F0FE499F79D022F7EE0AD5934915C0F5", hash_generated_field = "3A6B9A9CFCC4CFF9FD3CC2E257ADB30D")

    private boolean mSingle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.035 -0400", hash_original_field = "784EBB049D389964BB33C898356CBEDC", hash_generated_field = "79B19EDDE87A329245208E091B047D6F")

    private int mWidthSpec;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.035 -0400", hash_original_field = "C9EF5DE00AF5ABEBE891F814360EB726", hash_generated_field = "29F1336AF2FB76BA06A9DD6873FBA798")

    private int mHeightSpec;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.035 -0400", hash_original_field = "8EC2B8F7347514BC797C322C068958BF", hash_generated_field = "65A351B6E5CCAE66180826263CABE420")

    private int mNodePointer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.035 -0400", hash_original_field = "FEBC8896022DC5B351158697E56AB1F3", hash_generated_field = "C3260837F48C92F4F567EBA0AF2C9376")

    private boolean mGotEnterDown;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.035 -0400", hash_original_field = "52011B5EA55DD2D5E5F405BACDC95435", hash_generated_field = "F4895F45485234DF9F7B0249CB2D611D")

    private int mMaxLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.035 -0400", hash_original_field = "C91ACB9BF83EFE4A34DE978ACB49D2FE", hash_generated_field = "D21A7BBDB0D9AA0CB8CC9D00BD1A9E57")

    private String mPreChange;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.035 -0400", hash_original_field = "8E15E12FD32BAAD541B21159716F394A", hash_generated_field = "C949C69DB847CFA28D0EB672B5F3194B")

    private float mDragStartX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.035 -0400", hash_original_field = "19E9B380614BC97E973AFAC735624545", hash_generated_field = "ABB85F1B3BA40F41725FEBBA2D68FCB7")

    private float mDragStartY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.035 -0400", hash_original_field = "E5A38CF43278A378E674AF82517747CD", hash_generated_field = "6E3EDD350FD0D2F013013E766DE599D9")

    private long mDragStartTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.035 -0400", hash_original_field = "7E8FD35E0E13D6D3F1DDF734E67581E6", hash_generated_field = "FA5A49E5536E1D23955E06CF88D26990")

    private boolean mDragSent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.035 -0400", hash_original_field = "796EDAAD366B1D04F5EB6FF6C0D1C5BC", hash_generated_field = "9CDF2EC7A068A2DE91761DE787E720C4")

    private boolean mScrolled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.035 -0400", hash_original_field = "67817EA809EA9F1C23056F1BA7A85F4C", hash_generated_field = "083C7463D465B1DDC06E0B472C1A9573")

    private boolean mFromWebKit;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.035 -0400", hash_original_field = "73AD53C3F83E1A8B4247B3BEF325BBA6", hash_generated_field = "CB6337D6B961D14342EAF2F83F7DF48D")

    private boolean mFromFocusChange;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.035 -0400", hash_original_field = "50D0156FAF8D8CD73E7E2DB4428DB14E", hash_generated_field = "B1F1F20A3974D3104E18AFBE0FDC68F5")

    private boolean mFromSetInputType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.035 -0400", hash_original_field = "3190920D715F610F81C5FD65C185C657", hash_generated_field = "B0F96C3D8606AC9C7948E05A7E4901F3")

    private boolean mGotTouchDown;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.035 -0400", hash_original_field = "B81C45043BA225BD35B5D476365853C6", hash_generated_field = "E96D278DCBB2486BABE91B0B1F485A2C")

    private boolean mHasPerformedLongClick;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.035 -0400", hash_original_field = "7FB500E5FDE560E73625CFD1DFEF752E", hash_generated_field = "DF5D9447105457646310FED90F470EAD")

    private boolean mInSetTextAndKeepSelection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.035 -0400", hash_original_field = "54CF12A90BD31D49BEEC7F1C057508F6", hash_generated_field = "6609AE5368A22032BC95D8A4F540825D")

    private char[] mCharacter = new char[1];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.035 -0400", hash_original_field = "F1533E5D1FD44B78E1B0B14191128D39", hash_generated_field = "9AAA9180D5C6EA2B6F39383B0109CA19")

    private boolean mGotDelete;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.035 -0400", hash_original_field = "22C881D2E0A56905D55ED6675B3549E0", hash_generated_field = "2CF38EE8C3AB172E07962BA75C82A9B5")

    private int mDelSelStart;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.035 -0400", hash_original_field = "7C3A751C4FF039E4FAA7F5CAE39FD464", hash_generated_field = "D82137E88C0E3DBDD263016B18A71ED7")

    private int mDelSelEnd;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.035 -0400", hash_original_field = "2A3109A682991470C8E7A9944372B1F8", hash_generated_field = "D46CADD5A6770F085C96392C484CE8BB")

    private boolean mAutoFillable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.035 -0400", hash_original_field = "427104C070D8C07CDE4241C4F45B4A38", hash_generated_field = "1A9B7D5E459A03CD29A94A18A042A141")

    private int mQueryId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.035 -0400", hash_original_field = "82043C068B61F18A751B8FC8336B6170", hash_generated_field = "2BCE54AE988047B9C3EAA8097538934B")

    private boolean mAutoFillProfileIsSet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.035 -0400", hash_original_field = "90B41CF9E5879026F7DA6EAAE140E666", hash_generated_field = "B10B7E3578A05C072780A4670FC3EEEE")

    private boolean mInsideRemove;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.036 -0400", hash_original_field = "572851143F58D86B2089A8B56ED682F4", hash_generated_field = "E09CD7B1F21A80E07EFF4D82C84FA850")

    private MyResultReceiver mReceiver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.036 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

    private Handler mHandler;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.036 -0400", hash_original_method = "089095F3BAAFCF9E87F2A27B8FA6A0A2", hash_generated_method = "7E113602158EE934AC5BB02F052E6EF6")
      WebTextView(Context context, WebView webView, int autoFillQueryId) {
        super(context, null, com.android.internal.R.attr.webTextViewStyle);
        addTaint(autoFillQueryId);
        addTaint(context.getTaint());
        mWebView = webView;
        mMaxLength = -1;
        setAutoFillable(autoFillQueryId);
        TextPaint paint = getPaint();
        int flags = paint.getFlags() & ~Paint.DEV_KERN_TEXT_FLAG
                | Paint.SUBPIXEL_TEXT_FLAG | Paint.DITHER_FLAG;
        paint.setFlags(flags);
        setTextColor(DebugFlags.DRAW_WEBTEXTVIEW ? Color.RED : Color.BLACK);
        setBackgroundDrawable(DebugFlags.DRAW_WEBTEXTVIEW ? null : new ColorDrawable(Color.WHITE));
        setIncludeFontPadding(false);
        mHandler = new Handler() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.036 -0400", hash_original_method = "9CA3B5083DA9628F4399959A49D35A0D", hash_generated_method = "0BE838F1BCF3D920E62FBD0B75BEC74C")
        @Override
        public void handleMessage(Message msg) {
            addTaint(msg.getTaint());
switch(msg.what){
            case AUTOFILL_FORM:
            mWebView.autoFillForm(mQueryId);
            break;
}
            // ---------- Original Method ----------
            //switch (msg.what) {
                //case AUTOFILL_FORM:
                    //mWebView.autoFillForm(mQueryId);
                    //break;
                //}
        }
};
        mReceiver = new MyResultReceiver(mHandler);
        float ringWidth = 2f * context.getResources().getDisplayMetrics().density;
        mRingInset = (int) ringWidth;
        setBackgroundDrawable(new BackgroundDrawable(mRingInset));
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(),
                getPaddingBottom());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.037 -0400", hash_original_method = "AE45889DF7F2FB1AD82AA8B5F1FED7F7", hash_generated_method = "777A71D3EFDBD434D2FC45D0739EED0C")
    public void setAutoFillable(int queryId) {
        mAutoFillable = mWebView.getSettings().getAutoFillEnabled()
                && (queryId != FORM_NOT_AUTOFILLABLE);
        mQueryId = queryId;
        // ---------- Original Method ----------
        //mAutoFillable = mWebView.getSettings().getAutoFillEnabled()
                //&& (queryId != FORM_NOT_AUTOFILLABLE);
        //mQueryId = queryId;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.037 -0400", hash_original_method = "2A0FFA3F53D08ACDC8DCA45FA27A8D22", hash_generated_method = "426F579092A52D99353D2B5998FAE9AD")
    @Override
    public void setPadding(int left, int top, int right, int bottom) {
        addTaint(bottom);
        addTaint(right);
        addTaint(top);
        addTaint(left);
        super.setPadding(left + mRingInset, top + mRingInset,
                right + mRingInset, bottom + mRingInset);
        // ---------- Original Method ----------
        //super.setPadding(left + mRingInset, top + mRingInset,
                //right + mRingInset, bottom + mRingInset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.038 -0400", hash_original_method = "6961E56AC59C570DF49F429D8D391CD8", hash_generated_method = "731347EE4B6EE618D13AA38C9C03B8F9")
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        addTaint(event.getTaint());
        if(event.isSystem())        
        {
            boolean var639DD27D10E8FF69097B1398D445D1B9_2025035111 = (super.dispatchKeyEvent(event));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2145767962 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2145767962;
        } //End block
        boolean down = event.getAction() != KeyEvent.ACTION_UP;
        int keyCode = event.getKeyCode();
        boolean isArrowKey = false;
switch(keyCode){
        case KeyEvent.KEYCODE_DPAD_LEFT:
        case KeyEvent.KEYCODE_DPAD_RIGHT:
        case KeyEvent.KEYCODE_DPAD_UP:
        case KeyEvent.KEYCODE_DPAD_DOWN:
        isArrowKey = true;
        break;
}        if(KeyEvent.KEYCODE_TAB == keyCode)        
        {
            if(down)            
            {
                onEditorAction(EditorInfo.IME_ACTION_NEXT);
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_897911569 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_197786481 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_197786481;
        } //End block
        Spannable text = (Spannable) getText();
        int oldStart = Selection.getSelectionStart(text);
        int oldEnd = Selection.getSelectionEnd(text);
        if(KeyEvent.KEYCODE_DEL == keyCode)        
        {
            if(oldStart == 0 && oldEnd == 0)            
            {
                sendDomEvent(event);
                boolean varB326B5062B2F0E69046810717534CB09_1944356989 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_80915671 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_80915671;
            } //End block
            if(down)            
            {
                mGotDelete = true;
                mDelSelStart = oldStart;
                mDelSelEnd = oldEnd;
            } //End block
        } //End block
        if(mSingle && (KeyEvent.KEYCODE_ENTER == keyCode
                    || KeyEvent.KEYCODE_NUMPAD_ENTER == keyCode))        
        {
            if(isPopupShowing())            
            {
                boolean var639DD27D10E8FF69097B1398D445D1B9_1551743124 = (super.dispatchKeyEvent(event));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1381095574 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1381095574;
            } //End block
            if(!down)            
            {
                InputMethodManager.getInstance(mContext)
                        .hideSoftInputFromWindow(getWindowToken(), 0);
                sendDomEvent(new KeyEvent(KeyEvent.ACTION_DOWN, keyCode));
                sendDomEvent(event);
            } //End block
            boolean var639DD27D10E8FF69097B1398D445D1B9_1069004156 = (super.dispatchKeyEvent(event));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1804025384 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1804025384;
        } //End block
        else
        if(KeyEvent.KEYCODE_DPAD_CENTER == keyCode)        
        {
            if(isPopupShowing())            
            {
                boolean var639DD27D10E8FF69097B1398D445D1B9_1960735724 = (super.dispatchKeyEvent(event));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_202899436 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_202899436;
            } //End block
            if(!down)            
            {
                mWebView.centerKeyPressOnTextField();
            } //End block
            boolean var639DD27D10E8FF69097B1398D445D1B9_271349178 = (super.dispatchKeyEvent(event));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1666713000 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1666713000;
        } //End block
        if(getLayout() == null)        
        {
            measure(mWidthSpec, mHeightSpec);
        } //End block
        int oldLength = text.length();
        boolean maxedOut = mMaxLength != -1 && oldLength == mMaxLength;
        String oldText;
        if(maxedOut && oldEnd != oldStart)        
        {
            oldText = text.toString();
        } //End block
        else
        {
            oldText = "";
        } //End block
        if(super.dispatchKeyEvent(event))        
        {
            if(KeyEvent.KEYCODE_ENTER == keyCode
                        || KeyEvent.KEYCODE_NUMPAD_ENTER == keyCode)            
            {
                mGotEnterDown = true;
            } //End block
            if(maxedOut && !isArrowKey && keyCode != KeyEvent.KEYCODE_DEL)            
            {
                if(oldEnd == oldStart)                
                {
                    boolean varB326B5062B2F0E69046810717534CB09_690419915 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1108674606 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1108674606;
                } //End block
                else
                if(!oldText.equals(getText().toString()))                
                {
                    Spannable span = (Spannable) getText();
                    int newStart = Selection.getSelectionStart(span);
                    int newEnd = Selection.getSelectionEnd(span);
                    mWebView.replaceTextfieldText(0, oldLength, span.toString(),
                            newStart, newEnd);
                    boolean varB326B5062B2F0E69046810717534CB09_232960846 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1259663802 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1259663802;
                } //End block
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_1643023902 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_121811596 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_121811596;
        } //End block
        if(mGotEnterDown && !down)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1343025770 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_729998817 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_729998817;
        } //End block
        if(isArrowKey)        
        {
            mWebView.resetTrackballTime();
            boolean varF90466788DB99DF92F458E45FD073CF5_1187881300 = (down ? mWebView.onKeyDown(keyCode, event) : mWebView
                    .onKeyUp(keyCode, event));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1997833368 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1997833368;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1098413557 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1718816459 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1718816459;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.038 -0400", hash_original_method = "4890DDDCE957B3D3A5D6757132681BB5", hash_generated_method = "ED4B7E9EBA405B5DA87F1DAB2AF0F4F3")
     void ensureLayout() {
        if(getLayout() == null)        
        {
            measure(mWidthSpec, mHeightSpec);
            LayoutParams params = (LayoutParams) getLayoutParams();
            if(params != null)            
            {
                layout(params.x, params.y, params.x + params.width,
                        params.y + params.height);
            } //End block
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.038 -0400", hash_original_method = "7D5E495C9B289687F8273FA9EA57C0F7", hash_generated_method = "2183898153930F31B51DCC78910538A2")
     ResultReceiver getResultReceiver() {
ResultReceiver var92BB1EAD1A7B04A11F11D488BE72928A_863724196 =         mReceiver;
        var92BB1EAD1A7B04A11F11D488BE72928A_863724196.addTaint(taint);
        return var92BB1EAD1A7B04A11F11D488BE72928A_863724196;
        // ---------- Original Method ----------
        //return mReceiver;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.038 -0400", hash_original_method = "0D2A49DF88825D4B2D39C3141FFC083A", hash_generated_method = "FC184D5D19765A182E09DAC1F95BDD4E")
     boolean isSameTextField(int ptr) {
        addTaint(ptr);
        boolean varD762C1F7B903AB959D3C9EF57114B5DB_713070335 = (ptr == mNodePointer);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1500742854 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1500742854;
        // ---------- Original Method ----------
        //return ptr == mNodePointer;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.038 -0400", hash_original_method = "480AEB5EE1C7676DB93788B189E32B71", hash_generated_method = "CFD2B1EB16C70F7E0ABD10DA0A1C02E9")
    private void lineUpScroll() {
        Layout layout = getLayout();
        if(mWebView != null && layout != null)        
        {
            if(mSingle)            
            {
                float maxScrollX = layout.getLineRight(0) - getWidth();
                if(DebugFlags.WEB_TEXT_VIEW)                
                {
                } //End block
                mWebView.scrollFocusedTextInputX(maxScrollX > 0 ?
                        mScrollX / maxScrollX : 0);
            } //End block
            else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.039 -0400", hash_original_method = "76914D313CC2AB81853EDD1E3C727FFE", hash_generated_method = "B86F4C0B13345A3066076DAA8B4D5ECC")
    @Override
    protected void makeNewLayout(int w, int hintWidth, Metrics boring,
            Metrics hintBoring, int ellipsisWidth, boolean bringIntoView) {
        addTaint(bringIntoView);
        addTaint(ellipsisWidth);
        addTaint(hintBoring.getTaint());
        addTaint(boring.getTaint());
        addTaint(hintWidth);
        addTaint(w);
        super.makeNewLayout(w, hintWidth, boring, hintBoring, ellipsisWidth,
                bringIntoView);
        lineUpScroll();
        // ---------- Original Method ----------
        //super.makeNewLayout(w, hintWidth, boring, hintBoring, ellipsisWidth,
                //bringIntoView);
        //lineUpScroll();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.039 -0400", hash_original_method = "B64466D7D13E6636B7758E5E911C1FF7", hash_generated_method = "6830C80C9E0620C6E28138A714D09E3C")
    @Override
    public InputConnection onCreateInputConnection(
            EditorInfo outAttrs) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(outAttrs.getTaint());
        InputConnection connection = super.onCreateInputConnection(outAttrs);
        if(mWebView != null)        
        {
            outAttrs.fieldName = mWebView.nativeFocusCandidateName() + "\\"
                    + mWebView.getUrl();
        } //End block
InputConnection var9911BB1C5F1522C1630847C40E8BC67E_196071367 =         connection;
        var9911BB1C5F1522C1630847C40E8BC67E_196071367.addTaint(taint);
        return var9911BB1C5F1522C1630847C40E8BC67E_196071367;
        // ---------- Original Method ----------
        //InputConnection connection = super.onCreateInputConnection(outAttrs);
        //if (mWebView != null) {
            //outAttrs.fieldName = mWebView.nativeFocusCandidateName() + "\\"
                    //+ mWebView.getUrl();
        //}
        //return connection;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.039 -0400", hash_original_method = "804428A0FF8505961E29DE067C3E7206", hash_generated_method = "C3F111AD14178CE70473B85DA1229BFD")
    @Override
    public void onEditorAction(int actionCode) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(actionCode);
switch(actionCode){
        case EditorInfo.IME_ACTION_NEXT:
        if(mWebView.nativeMoveCursorToNextTextInput())        
        {
            mWebView.rebuildWebTextView();
            setDefaultSelection();
            mWebView.invalidate();
        } //End block
        break;
        case EditorInfo.IME_ACTION_DONE:
        super.onEditorAction(actionCode);
        break;
        case EditorInfo.IME_ACTION_GO:
        case EditorInfo.IME_ACTION_SEARCH:
        InputMethodManager.getInstance(mContext)
                    .hideSoftInputFromWindow(getWindowToken(), 0);
        sendDomEvent(new KeyEvent(KeyEvent.ACTION_DOWN,
                    KeyEvent.KEYCODE_ENTER));
        sendDomEvent(new KeyEvent(KeyEvent.ACTION_UP,
                    KeyEvent.KEYCODE_ENTER));
        default:
        break;
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.039 -0400", hash_original_method = "199CA847E2A702BC0971D902FFD82329", hash_generated_method = "4CF551F1B06A56ECD6A9FA8676CDB5AD")
    @Override
    protected void onFocusChanged(boolean focused, int direction,
            Rect previouslyFocusedRect) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(previouslyFocusedRect.getTaint());
        addTaint(direction);
        addTaint(focused);
        mFromFocusChange = true;
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
        if(focused)        
        {
            mWebView.setActive(true);
        } //End block
        else
        if(!mInsideRemove)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.040 -0400", hash_original_method = "A29BC68952EA75E2FA60BFA3E7E77A14", hash_generated_method = "5F66268F73CE77DC1DE348768C490FCE")
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(id);
        addTaint(position);
        addTaint(view.getTaint());
        addTaint(parent.getTaint());
        if(id == 0 && position == 0)        
        {
            replaceText("");
            WebSettings settings = mWebView.getSettings();
            if(mAutoFillProfileIsSet)            
            {
                mWebView.autoFillForm(mQueryId);
            } //End block
            else
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.040 -0400", hash_original_method = "D3CDB855BC1EDCE86869BE708EA015CC", hash_generated_method = "0FC5C74D509F77AB0352511318DAA8D2")
    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(oldt);
        addTaint(oldl);
        addTaint(t);
        addTaint(l);
        super.onScrollChanged(l, t, oldl, oldt);
        lineUpScroll();
        // ---------- Original Method ----------
        //super.onScrollChanged(l, t, oldl, oldt);
        //lineUpScroll();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.040 -0400", hash_original_method = "8C1441039C2AFE6E28B135997E9DB205", hash_generated_method = "E4CB20CBA1B21B2292F0C68076E9C147")
    @Override
    protected void onSelectionChanged(int selStart, int selEnd) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(selEnd);
        addTaint(selStart);
        if(!mFromWebKit && !mFromFocusChange && !mFromSetInputType
                && mWebView != null && !mInSetTextAndKeepSelection)        
        {
            if(DebugFlags.WEB_TEXT_VIEW)            
            {
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.040 -0400", hash_original_method = "86E27647BFDE15D66BF8F4D142CAE4A5", hash_generated_method = "C07B6E53123F7ACA7ED7EF3728630AE4")
    @Override
    protected void onTextChanged(CharSequence s,int start,int before,int count) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(count);
        addTaint(before);
        addTaint(start);
        addTaint(s.getTaint());
        super.onTextChanged(s, start, before, count);
        String postChange = s.toString();
        if(mPreChange == null || mPreChange.equals(postChange) ||
                (mMaxLength > -1 && mPreChange.length() > mMaxLength &&
                mPreChange.substring(0, mMaxLength).equals(postChange)))        
        {
            return;
        } //End block
        if(0 == count)        
        {
            if(before > 0)            
            {
                updateCachedTextfield();
                if(mGotDelete)                
                {
                    mGotDelete = false;
                    int oldEnd = start + before;
                    if(mDelSelEnd == oldEnd
                            && (mDelSelStart == start
                            || (mDelSelStart == oldEnd && before == 1)))                    
                    {
                        sendDomEvent(new KeyEvent(KeyEvent.ACTION_DOWN,
                                KeyEvent.KEYCODE_DEL));
                        sendDomEvent(new KeyEvent(KeyEvent.ACTION_UP,
                                KeyEvent.KEYCODE_DEL));
                        return;
                    } //End block
                } //End block
                mWebView.deleteSelection(start, start + before);
            } //End block
            mGotDelete = false;
            return;
        } //End block
        mGotDelete = false;
        if(count > 1 && before == count - 1)        
        {
            String replaceButOne = mPreChange.subSequence(start,
                    start + before).toString();
            String replacedString = s.subSequence(start,
                    start + before).toString();
            if(replaceButOne.equals(replacedString))            
            {
                start += before;
                before = 0;
                count = 1;
            } //End block
        } //End block
        mPreChange = postChange;
        KeyEvent[] events = null;
        if(count == 1)        
        {
            TextUtils.getChars(s, start + count - 1, start + count, mCharacter, 0);
            KeyCharacterMap kmap = KeyCharacterMap.load(KeyCharacterMap.VIRTUAL_KEYBOARD);
            events = kmap.getEvents(mCharacter);
        } //End block
        boolean useKeyEvents = (events != null);
        if(useKeyEvents)        
        {
            if(DebugFlags.WEB_TEXT_VIEW)            
            {
            } //End block
            if(!mInSetTextAndKeepSelection)            
            {
                mWebView.setSelection(start, start + before);
            } //End block
            int length = events.length;
for(int i = 0;i < length;i++)
            {
                if(!KeyEvent.isModifierKey(events[i].getKeyCode()))                
                {
                    sendDomEvent(events[i]);
                } //End block
            } //End block
        } //End block
        else
        {
            String replace = s.subSequence(start,
                    start + count).toString();
            mWebView.replaceTextfieldText(start, start + before, replace,
                    start + count,
                    start + count);
        } //End block
        updateCachedTextfield();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.041 -0400", hash_original_method = "C8E8CDF4C81BBE6A97ACE8DDCE593DE3", hash_generated_method = "A971FC5DB5B0D9E31141DB1165C7D3A5")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
switch(event.getAction()){
        case MotionEvent.ACTION_DOWN:
        super.onTouchEvent(event);
        mDragStartX = event.getX();
        mDragStartY = event.getY();
        mDragStartTime = event.getEventTime();
        mDragSent = false;
        mScrolled = false;
        mGotTouchDown = true;
        mHasPerformedLongClick = false;
        break;
        case MotionEvent.ACTION_MOVE:
        if(mHasPerformedLongClick)        
        {
            mGotTouchDown = false;
            boolean var68934A3E9455FA72420237EB05902327_913243485 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1622811578 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1622811578;
        } //End block
        int slop = ViewConfiguration.get(mContext).getScaledTouchSlop();
        Spannable buffer = getText();
        int initialScrollX = Touch.getInitialScrollX(this, buffer);
        int initialScrollY = Touch.getInitialScrollY(this, buffer);
        super.onTouchEvent(event);
        int dx = Math.abs(mScrollX - initialScrollX);
        int dy = Math.abs(mScrollY - initialScrollY);
        int smallerSlop = slop/2;
        if(dx > smallerSlop || dy > smallerSlop)        
        {
            mScrolled = true;
            cancelLongPress();
            boolean varB326B5062B2F0E69046810717534CB09_861514125 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1425958392 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1425958392;
        } //End block
        if(Math.abs((int) event.getX() - mDragStartX) < slop
                    && Math.abs((int) event.getY() - mDragStartY) < slop)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_838615763 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1315307880 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1315307880;
        } //End block
        if(mWebView != null)        
        {
            if(!mDragSent)            
            {
                mWebView.initiateTextFieldDrag(mDragStartX, mDragStartY,
                            mDragStartTime);
                mDragSent = true;
            } //End block
            boolean scrolled = mWebView.textFieldDrag(event);
            if(scrolled)            
            {
                mScrolled = true;
                cancelLongPress();
                boolean varB326B5062B2F0E69046810717534CB09_678079087 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1306615221 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1306615221;
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1914204313 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1845776339 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1845776339;
        case MotionEvent.ACTION_UP:
        case MotionEvent.ACTION_CANCEL:
        super.onTouchEvent(event);
        if(mHasPerformedLongClick)        
        {
            mGotTouchDown = false;
            boolean var68934A3E9455FA72420237EB05902327_1285170915 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1463714692 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1463714692;
        } //End block
        if(!mScrolled)        
        {
            cancelLongPress();
            if(mGotTouchDown && mWebView != null)            
            {
                mWebView.touchUpOnTextField(event);
            } //End block
        } //End block
        if(mWebView != null && mDragSent)        
        {
            mWebView.onTouchEvent(event);
        } //End block
        mGotTouchDown = false;
        break;
        default:
        break;
}        boolean varB326B5062B2F0E69046810717534CB09_133004673 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_499623405 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_499623405;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.042 -0400", hash_original_method = "39A98F4B040DD226E88FA29A15911D83", hash_generated_method = "E2E8C75B690BE62694294B48806B539E")
    @Override
    public boolean onTrackballEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        if(isPopupShowing())        
        {
            boolean varBF585A2510916F6245CF607EE867BAC0_1534979670 = (super.onTrackballEvent(event));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_619106532 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_619106532;
        } //End block
        if(event.getAction() != MotionEvent.ACTION_MOVE)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1373213434 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_917881942 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_917881942;
        } //End block
        Spannable text = getText();
        MovementMethod move = getMovementMethod();
        if(move != null && getLayout() != null &&
            move.onTrackballEvent(this, text, event))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_397301244 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1694154093 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1694154093;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_2107838650 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1932745050 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1932745050;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.042 -0400", hash_original_method = "3EEE407D8FB8A76E11AC99079A17DC34", hash_generated_method = "4B11C88560009BBC5F856A9398737BF4")
    @Override
    public boolean performLongClick() {
        mHasPerformedLongClick = true;
        boolean var55D6A0DF0F5A5E2B1EE1FA3768B96A22_719395843 = (super.performLongClick());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1668511242 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1668511242;
        // ---------- Original Method ----------
        //mHasPerformedLongClick = true;
        //return super.performLongClick();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.042 -0400", hash_original_method = "E890325AD4CF04CF90789A3947029902", hash_generated_method = "BC197A6168B60C3069D315DE4474B75B")
     void remove() {
        InputMethodManager imm = InputMethodManager.getInstance(mContext);
        if(imm.isActive(this))        
        {
            imm.hideSoftInputFromWindow(getWindowToken(), 0);
        } //End block
        mInsideRemove = true;
        boolean isFocused = hasFocus();
        mWebView.removeView(this);
        if(isFocused)        
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.042 -0400", hash_original_method = "2AA5BA571DA39EAF8290098D28F58BC6", hash_generated_method = "C23482CB83B697045D556089B732BC8B")
    @Override
    public boolean requestRectangleOnScreen(Rect rectangle, boolean immediate) {
        addTaint(immediate);
        addTaint(rectangle.getTaint());
        boolean varB326B5062B2F0E69046810717534CB09_1234800202 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1412716258 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1412716258;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.042 -0400", hash_original_method = "950AB6742CC7236DE25064405668EBFC", hash_generated_method = "CE7A01C7486F7EFAAC98C7D6E699475F")
    private void sendDomEvent(KeyEvent event) {
        addTaint(event.getTaint());
        mWebView.passToJavaScript(getText().toString(), event);
        // ---------- Original Method ----------
        //mWebView.passToJavaScript(getText().toString(), event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.043 -0400", hash_original_method = "95851FC5190E2011BB56B8769701FDF9", hash_generated_method = "E20F45C9FCF58CDEF59D19C7E171D450")
    public void setAdapterCustom(AutoCompleteAdapter adapter) {
        addTaint(adapter.getTaint());
        if(adapter != null)        
        {
            setInputType(getInputType()
                    | InputType.TYPE_TEXT_FLAG_AUTO_COMPLETE);
            adapter.setTextView(this);
            if(mAutoFillable)            
            {
                setOnItemClickListener(this);
            } //End block
            else
            {
                setOnItemClickListener(null);
            } //End block
            showDropDown();
        } //End block
        else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.043 -0400", hash_original_method = "10D826035FBCEEF5092B615EC9DFDE75", hash_generated_method = "B072FB2BE3A6E94DE006DBDBDE47F869")
     void setDefaultSelection() {
        Spannable text = (Spannable) getText();
        int selection = mSingle ? text.length() : 0;
        if(Selection.getSelectionStart(text) == selection
                && Selection.getSelectionEnd(text) == selection)        
        {
            if(mWebView != null)            
            {
                mWebView.setSelection(selection, selection);
            } //End block
        } //End block
        else
        {
            Selection.setSelection(text, selection, selection);
        } //End block
        if(mWebView != null)        
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.043 -0400", hash_original_method = "5F3F3B089AD7E0D8B5861A9F4DCE5D55", hash_generated_method = "EB4C58D1E72B47E8A37D47F29CF6B122")
    @Override
    public void setInputType(int type) {
        addTaint(type);
        mFromSetInputType = true;
        super.setInputType(type);
        mFromSetInputType = false;
        // ---------- Original Method ----------
        //mFromSetInputType = true;
        //super.setInputType(type);
        //mFromSetInputType = false;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.043 -0400", hash_original_method = "6C4324E77F1CB780AA79022DD606C31E", hash_generated_method = "00AFB86BB31B20C4F47A23EA72B0CEE6")
    private void setMaxLength(int maxLength) {
        mMaxLength = maxLength;
        if(-1 == maxLength)        
        {
            setFilters(NO_FILTERS);
        } //End block
        else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.043 -0400", hash_original_method = "C341AA0EB003F8D508947196584836B7", hash_generated_method = "4D7B0BEC9834A42C8E4654682B07BA85")
     void setNodePointer(int ptr) {
        if(ptr != mNodePointer)        
        {
            mNodePointer = ptr;
            setAdapterCustom(null);
        } //End block
        // ---------- Original Method ----------
        //if (ptr != mNodePointer) {
            //mNodePointer = ptr;
            //setAdapterCustom(null);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.044 -0400", hash_original_method = "1A385B6FBFB65985BDFEFA75CA11C93C", hash_generated_method = "ED04B00F0C15CAD59749CFC4706A66B7")
     void setRect(int x, int y, int width, int height) {
        addTaint(y);
        addTaint(x);
        LayoutParams lp = (LayoutParams) getLayoutParams();
        x -= mRingInset;
        y -= mRingInset;
        width += 2 * mRingInset;
        height += 2 * mRingInset;
        boolean needsUpdate = false;
        if(null == lp)        
        {
            lp = new LayoutParams(width, height, x, y);
        } //End block
        else
        {
            if((lp.x != x) || (lp.y != y) || (lp.width != width)
                    || (lp.height != height))            
            {
                needsUpdate = true;
                lp.x = x;
                lp.y = y;
                lp.width = width;
                lp.height = height;
            } //End block
        } //End block
        if(getParent() == null)        
        {
            mWebView.addView(this, 0, lp);
        } //End block
        else
        if(needsUpdate)        
        {
            setLayoutParams(lp);
        } //End block
        mWidthSpec = MeasureSpec.makeMeasureSpec(width, MeasureSpec.EXACTLY);
        mHeightSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.066 -0400", hash_original_method = "CE3949E5C336F8D95926C2F0BAE76623", hash_generated_method = "6366711B8EFD75954168952FB2746FC4")
     void setSelectionFromWebKit(int start, int end) {
        addTaint(end);
        addTaint(start);
        if(start < 0 || end < 0)        
        return;
        Spannable text = (Spannable) getText();
        int length = text.length();
        if(start > length || end > length)        
        return;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.067 -0400", hash_original_method = "0E0FB59047FF987C205DC97754DD32D6", hash_generated_method = "E11D55D9F9950208F0B8C264A3D805A9")
     void updateTextSize() {
        Assert.assertNotNull("updateTextSize should only be called from "
                + "mWebView, so mWebView should never be null!", mWebView);
        float size = mWebView.nativeFocusCandidateTextSize()
                * mWebView.getScale();
        setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
        // ---------- Original Method ----------
        //Assert.assertNotNull("updateTextSize should only be called from "
                //+ "mWebView, so mWebView should never be null!", mWebView);
        //float size = mWebView.nativeFocusCandidateTextSize()
                //* mWebView.getScale();
        //setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.067 -0400", hash_original_method = "FCE77DF28E9B30518950525927BBC7BA", hash_generated_method = "6516707DF939BD164481990C08A14A02")
     void setTextAndKeepSelection(String text) {
        Editable edit = getText();
        mPreChange = text;
        if(edit.toString().equals(text))        
        {
            return;
        } //End block
        int selStart = Selection.getSelectionStart(edit);
        int selEnd = Selection.getSelectionEnd(edit);
        mInSetTextAndKeepSelection = true;
        edit.replace(0, edit.length(), text);
        int newLength = edit.length();
        if(selStart > newLength)        
        selStart = newLength;
        if(selEnd > newLength)        
        selEnd = newLength;
        Selection.setSelection(edit, selStart, selEnd);
        mInSetTextAndKeepSelection = false;
        InputMethodManager imm = InputMethodManager.peekInstance();
        if(imm != null && imm.isActive(this))        
        {
            imm.restartInput(this);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.071 -0400", hash_original_method = "9C43235B4CCED4C8A2DC53AB1F7D42B9", hash_generated_method = "CF5550D93223C2191EC65D361AD01F3E")
     void setType(int type) {
        addTaint(type);
        if(mWebView == null)        
        return;
        boolean single = true;
        int maxLength = -1;
        int inputType = InputType.TYPE_CLASS_TEXT
                | InputType.TYPE_TEXT_VARIATION_WEB_EDIT_TEXT;
        int imeOptions = EditorInfo.IME_FLAG_NO_EXTRACT_UI
                | EditorInfo.IME_FLAG_NO_FULLSCREEN;
        if(!mWebView.nativeFocusCandidateIsSpellcheck())        
        {
            inputType |= InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS;
        } //End block
        if(TEXT_AREA != type
                && mWebView.nativeFocusCandidateHasNextTextfield())        
        {
            imeOptions |= EditorInfo.IME_FLAG_NAVIGATE_NEXT;
        } //End block
switch(type){
        case NORMAL_TEXT_FIELD:
        imeOptions |= EditorInfo.IME_ACTION_GO;
        break;
        case TEXT_AREA:
        single = false;
        inputType |= InputType.TYPE_TEXT_FLAG_MULTI_LINE
                        | InputType.TYPE_TEXT_FLAG_CAP_SENTENCES
                        | InputType.TYPE_TEXT_FLAG_AUTO_CORRECT;
        imeOptions |= EditorInfo.IME_ACTION_NONE;
        break;
        case PASSWORD:
        inputType |= EditorInfo.TYPE_TEXT_VARIATION_WEB_PASSWORD;
        imeOptions |= EditorInfo.IME_ACTION_GO;
        break;
        case SEARCH:
        imeOptions |= EditorInfo.IME_ACTION_SEARCH;
        break;
        case EMAIL:
        inputType = InputType.TYPE_CLASS_TEXT
                        | InputType.TYPE_TEXT_VARIATION_WEB_EMAIL_ADDRESS;
        imeOptions |= EditorInfo.IME_ACTION_GO;
        break;
        case NUMBER:
        inputType = InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_NORMAL
                        | InputType.TYPE_NUMBER_FLAG_SIGNED | InputType.TYPE_NUMBER_FLAG_DECIMAL;
        imeOptions |= EditorInfo.IME_ACTION_NEXT;
        break;
        case TELEPHONE:
        inputType = InputType.TYPE_CLASS_PHONE;
        imeOptions |= EditorInfo.IME_ACTION_NEXT;
        break;
        case URL:
        imeOptions |= EditorInfo.IME_ACTION_GO;
        break;
        default:
        imeOptions |= EditorInfo.IME_ACTION_GO;
        break;
}        setHint(null);
        setThreshold(1);
        boolean autoComplete = false;
        if(single)        
        {
            mWebView.requestLabel(mWebView.nativeFocusCandidateFramePointer(),
                    mNodePointer);
            maxLength = mWebView.nativeFocusCandidateMaxLength();
            autoComplete = mWebView.nativeFocusCandidateIsAutoComplete();
            if(type != PASSWORD && (mAutoFillable || autoComplete))            
            {
                String name = mWebView.nativeFocusCandidateName();
                if(name != null && name.length() > 0)                
                {
                    mWebView.requestFormData(name, mNodePointer, mAutoFillable,
                            autoComplete);
                } //End block
            } //End block
        } //End block
        mSingle = single;
        setMaxLength(maxLength);
        setHorizontallyScrolling(single);
        setInputType(inputType);
        clearComposingText();
        setImeOptions(imeOptions);
        setVisibility(VISIBLE);
        if(!autoComplete)        
        {
            setAdapterCustom(null);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.072 -0400", hash_original_method = "DC0208EAD79A0BCADD603C831599A0E0", hash_generated_method = "353A0AED74824F2EAB6775FEEFC50847")
     void updateCachedTextfield() {
        mWebView.updateCachedTextfield(getText().toString());
        // ---------- Original Method ----------
        //mWebView.updateCachedTextfield(getText().toString());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.072 -0400", hash_original_method = "E906B54723AD6F9ED79F8F4825A6BCDE", hash_generated_method = "00DFCCEAEBCA5AF7E29ED7EACECB08F0")
     void setAutoFillProfileIsSet(boolean autoFillProfileIsSet) {
        mAutoFillProfileIsSet = autoFillProfileIsSet;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.073 -0400", hash_original_method = "4A2837BA61927EB8FB72E630E60D5F6F", hash_generated_method = "4EAE14A0863CDC9DCC68B8BAA0892114")
    public void setGravityForRtl(boolean rtl) {
        addTaint(rtl);
        int gravity = rtl ? Gravity.RIGHT : Gravity.LEFT;
        gravity |= mSingle ? Gravity.CENTER_VERTICAL : Gravity.TOP;
        setGravity(gravity);
        // ---------- Original Method ----------
        //int gravity = rtl ? Gravity.RIGHT : Gravity.LEFT;
        //gravity |= mSingle ? Gravity.CENTER_VERTICAL : Gravity.TOP;
        //setGravity(gravity);
    }

    
    private class MyResultReceiver extends ResultReceiver {
        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.073 -0400", hash_original_method = "B2A067584316D6A9483E42E372CB0982", hash_generated_method = "68249943C085278FACB82801440E2E68")
        public  MyResultReceiver(Handler handler) {
            super(handler);
            addTaint(handler.getTaint());
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.082 -0400", hash_original_method = "8968B16CB33DBBA966B5E497FFEF8D80", hash_generated_method = "DD922F53C155BE28083B412536DAB0AC")
        @Override
        protected void onReceiveResult(int resultCode, Bundle resultData) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(resultData.getTaint());
            addTaint(resultCode);
            if(resultCode == InputMethodManager.RESULT_SHOWN
                    && mWebView != null)            
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.082 -0400", hash_original_field = "1F593C5E1FA9C53F92379484654564D2", hash_generated_field = "04B4E10AE3E38C24827628B090CB2FA5")

        private Paint mPaint = new Paint();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.082 -0400", hash_original_field = "03374CE06B404E7E86A0B34197FB2079", hash_generated_field = "42F6FF6ED2F2BB89D0174DF2E15B171E")

        private int mBorderWidth;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.082 -0400", hash_original_field = "639B0CA9A647A32015C0F0585C02AEF4", hash_generated_field = "A3E5C64B3DE033797510B24E6CF68D4E")

        private Rect mInsetRect = new Rect();
        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.082 -0400", hash_original_method = "A19D023ADE41459A26F3E78681345993", hash_generated_method = "B7182D490DEE1E3239DF8910CDE3BDE3")
        public  BackgroundDrawable(int width) {
            mPaint = new Paint();
            mPaint.setStrokeWidth(width);
            mBorderWidth = width;
            // ---------- Original Method ----------
            //mPaint = new Paint();
            //mPaint.setStrokeWidth(width);
            //mBorderWidth = width;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.083 -0400", hash_original_method = "B7807C75F15BA2C587A7A3AFE401787F", hash_generated_method = "ED1A24047C556D01C3B5A6638E2BD4E2")
        @Override
        public void draw(Canvas canvas) {
            addTaint(canvas.getTaint());
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

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.083 -0400", hash_original_method = "5784D116F3F796E4D5324F7E68A41209", hash_generated_method = "DCDCC287CA9BC5217D3FA2BC94984F3E")
        @Override
        public void setAlpha(int alpha) {
            addTaint(alpha);
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.083 -0400", hash_original_method = "77240A7357C6E5E7293BFF14ACDD79D8", hash_generated_method = "18D8B35FAE562ED5B4F19A1CD78B9AEE")
        @Override
        public void setColorFilter(ColorFilter cf) {
            addTaint(cf.getTaint());
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.083 -0400", hash_original_method = "AB3D570DA2A917C408AB4F7D8FCD7103", hash_generated_method = "08C75F82E439A1FFF21EDAAAE3C984EA")
        @Override
        public int getOpacity() {
            int var26C79996E92FCFBDC98A49C80BC91AD0_1676828812 = (PixelFormat.TRANSLUCENT);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_360664225 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_360664225;
            // ---------- Original Method ----------
            //return PixelFormat.TRANSLUCENT;
        }

        
    }


    
    private static class WebTextViewLayout extends DynamicLayout {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.084 -0400", hash_original_field = "1870F0C40BC256036B03019DC84F1A7C", hash_generated_field = "01BDC3B4754FD272E9D33AE0E0EEA1AE")

        private float mLineHeight;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.084 -0400", hash_original_field = "9D6DE39C350B06606B906F81E8424D93", hash_generated_field = "22BC403FE7CFAEB14C6EE927FBD48C96")

        private float mDifference;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.085 -0400", hash_original_method = "84A347E9C0B83549B9D13ECC225F88CE", hash_generated_method = "9AEFAEB7A9FFE1DB6F538907373B6DCA")
        public  WebTextViewLayout(CharSequence base, CharSequence display,
                TextPaint paint,
                int width, Alignment align,
                float spacingMult, float spacingAdd,
                boolean includepad,
                TextUtils.TruncateAt ellipsize, int ellipsizedWidth,
                float lineHeight) {
            super(base, display, paint, width, align, spacingMult, spacingAdd,
                    includepad, ellipsize, ellipsizedWidth);
            addTaint(ellipsizedWidth);
            addTaint(ellipsize.getTaint());
            addTaint(includepad);
            addTaint(spacingAdd);
            addTaint(spacingMult);
            addTaint(align.getTaint());
            addTaint(width);
            addTaint(paint.getTaint());
            addTaint(display.getTaint());
            addTaint(base.getTaint());
            float paintLineHeight = paint.descent() - paint.ascent();
            if(lineHeight == -1f)            
            {
                mLineHeight = paintLineHeight;
                mDifference = 0f;
            } //End block
            else
            {
                mLineHeight = lineHeight;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.085 -0400", hash_original_method = "BD0D404B64FBDA001253C5382CB9CD95", hash_generated_method = "1BDDE8E99B8B0CD83BA28160C27FFE63")
        @Override
        public int getLineTop(int line) {
            addTaint(line);
            int var56728EC2CA63827C80DE6FD3123A1ECF_1183267495 = (Math.round(mLineHeight * line - mDifference));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1396222335 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1396222335;
            // ---------- Original Method ----------
            //return Math.round(mLineHeight * line - mDifference);
        }

        
    }


    
    public static class AutoCompleteAdapter extends ArrayAdapter<String> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.085 -0400", hash_original_field = "59FFF1360E9B57BB348C2BF9F881659F", hash_generated_field = "B044D5C32398EDC8D922234EFA4F1DF3")

        private TextView mTextView;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.086 -0400", hash_original_method = "8B198F037E06F3C258FC2837A183399D", hash_generated_method = "5B3A494C60FB70D96FA4FA2C1A2FD82B")
        public  AutoCompleteAdapter(Context context, ArrayList<String> entries) {
            super(context, com.android.internal.R.layout
                    .web_text_view_dropdown, entries);
            addTaint(entries.getTaint());
            addTaint(context.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.086 -0400", hash_original_method = "C6FC0517987C8200BB760FE857B81ECC", hash_generated_method = "40530DBF5B50EBDCDF4E40E33C9DD09C")
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            addTaint(parent.getTaint());
            addTaint(convertView.getTaint());
            addTaint(position);
            TextView tv = (TextView) super.getView(position, convertView, parent);
            if(tv != null && mTextView != null)            
            {
                tv.setTextSize(TypedValue.COMPLEX_UNIT_PX, mTextView.getTextSize());
            } //End block
View var8BB2C09B3FFE775E9F9FBFEC00A28511_1545284613 =             tv;
            var8BB2C09B3FFE775E9F9FBFEC00A28511_1545284613.addTaint(taint);
            return var8BB2C09B3FFE775E9F9FBFEC00A28511_1545284613;
            // ---------- Original Method ----------
            //TextView tv =
                    //(TextView) super.getView(position, convertView, parent);
            //if (tv != null && mTextView != null) {
                //tv.setTextSize(TypedValue.COMPLEX_UNIT_PX, mTextView.getTextSize());
            //}
            //return tv;
        }

        
                @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.087 -0400", hash_original_method = "C453A8A8AADC44244B92E3146B6F4B07", hash_generated_method = "E29443429247A5B5E60DF42163779843")
        private void setTextView(TextView tv) {
            mTextView = tv;
            // ---------- Original Method ----------
            //mTextView = tv;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.087 -0400", hash_original_field = "04C9575A87A9055B7CAF07BF7E360965", hash_generated_field = "0254F437D32CEDBF3502981A041254AF")

    static final String LOGTAG = "webtextview";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.087 -0400", hash_original_field = "A0DA38A5AAD1658278F1D161AF84C1BC", hash_generated_field = "EDD7FE0B7D12EE9C3486272F367681B2")

    private static final InputFilter[] NO_FILTERS = new InputFilter[0];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.087 -0400", hash_original_field = "15FD60C697B363DBE4679F91A997C35D", hash_generated_field = "9B5049942EDE85325728F92E651A3B9C")

    static final int FORM_NOT_AUTOFILLABLE = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.087 -0400", hash_original_field = "C38438E09D0F9CE92D1B34BAB4BF4666", hash_generated_field = "07BDA709C40ACAB2A72814731F3205B5")

    private static final int NORMAL_TEXT_FIELD = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.087 -0400", hash_original_field = "D189112F8ADACAF512C50AF3CB22BC4F", hash_generated_field = "E85CA99FFDB1FCA0BBA2ADE14130DF18")

    private static final int TEXT_AREA = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.087 -0400", hash_original_field = "F16F418DD0339574597733B844BE3741", hash_generated_field = "88669A7ECF8EEF75669B4670AD788953")

    private static final int PASSWORD = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.087 -0400", hash_original_field = "CF4F7700F5D247F409D439E023DABD7D", hash_generated_field = "931884675335103952BCDA72B3A33B39")

    private static final int SEARCH = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.087 -0400", hash_original_field = "0BF00C6641A84E5A88493EED05C8ACAE", hash_generated_field = "C1E65F020F8845ABDDEEA059710FDB93")

    private static final int EMAIL = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.087 -0400", hash_original_field = "3CBBD51483016DACC5E4950C131ACF41", hash_generated_field = "BDF0B48D549D318EC8823826AC4E082C")

    private static final int NUMBER = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.087 -0400", hash_original_field = "D60D529056D6B8D97DD44C28A7C4CD83", hash_generated_field = "0F94A2DFCC07B06A8BCB81F5C7D2FF37")

    private static final int TELEPHONE = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.087 -0400", hash_original_field = "DC13EA1236A891796ED81728D536C82A", hash_generated_field = "55324EE26E196D00401F672B7D51F357")

    private static final int URL = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:54.087 -0400", hash_original_field = "040BFA0BBC00732D439F4CFC8F1A8319", hash_generated_field = "3F36447E6A0F20CD137DED5CE2B96C90")

    private static final int AUTOFILL_FORM = 100;
}

