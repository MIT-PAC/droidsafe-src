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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.907 -0400", hash_original_field = "E629B0C9798771544E235B84F0C22269", hash_generated_field = "74A54BC69C155F1DB9DBB9FB9549E6B1")

    private int mRingInset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.907 -0400", hash_original_field = "72439B8F99EB438C3DA5D9CD798C6786", hash_generated_field = "99346B50377E115231263981E00655CA")

    private WebView mWebView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.907 -0400", hash_original_field = "F0FE499F79D022F7EE0AD5934915C0F5", hash_generated_field = "3A6B9A9CFCC4CFF9FD3CC2E257ADB30D")

    private boolean mSingle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.907 -0400", hash_original_field = "784EBB049D389964BB33C898356CBEDC", hash_generated_field = "79B19EDDE87A329245208E091B047D6F")

    private int mWidthSpec;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.907 -0400", hash_original_field = "C9EF5DE00AF5ABEBE891F814360EB726", hash_generated_field = "29F1336AF2FB76BA06A9DD6873FBA798")

    private int mHeightSpec;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.907 -0400", hash_original_field = "8EC2B8F7347514BC797C322C068958BF", hash_generated_field = "65A351B6E5CCAE66180826263CABE420")

    private int mNodePointer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.907 -0400", hash_original_field = "FEBC8896022DC5B351158697E56AB1F3", hash_generated_field = "C3260837F48C92F4F567EBA0AF2C9376")

    private boolean mGotEnterDown;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.907 -0400", hash_original_field = "52011B5EA55DD2D5E5F405BACDC95435", hash_generated_field = "F4895F45485234DF9F7B0249CB2D611D")

    private int mMaxLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.907 -0400", hash_original_field = "C91ACB9BF83EFE4A34DE978ACB49D2FE", hash_generated_field = "D21A7BBDB0D9AA0CB8CC9D00BD1A9E57")

    private String mPreChange;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.907 -0400", hash_original_field = "8E15E12FD32BAAD541B21159716F394A", hash_generated_field = "C949C69DB847CFA28D0EB672B5F3194B")

    private float mDragStartX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.907 -0400", hash_original_field = "19E9B380614BC97E973AFAC735624545", hash_generated_field = "ABB85F1B3BA40F41725FEBBA2D68FCB7")

    private float mDragStartY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.907 -0400", hash_original_field = "E5A38CF43278A378E674AF82517747CD", hash_generated_field = "6E3EDD350FD0D2F013013E766DE599D9")

    private long mDragStartTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.907 -0400", hash_original_field = "7E8FD35E0E13D6D3F1DDF734E67581E6", hash_generated_field = "FA5A49E5536E1D23955E06CF88D26990")

    private boolean mDragSent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.907 -0400", hash_original_field = "796EDAAD366B1D04F5EB6FF6C0D1C5BC", hash_generated_field = "9CDF2EC7A068A2DE91761DE787E720C4")

    private boolean mScrolled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.907 -0400", hash_original_field = "67817EA809EA9F1C23056F1BA7A85F4C", hash_generated_field = "083C7463D465B1DDC06E0B472C1A9573")

    private boolean mFromWebKit;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.907 -0400", hash_original_field = "73AD53C3F83E1A8B4247B3BEF325BBA6", hash_generated_field = "CB6337D6B961D14342EAF2F83F7DF48D")

    private boolean mFromFocusChange;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.907 -0400", hash_original_field = "50D0156FAF8D8CD73E7E2DB4428DB14E", hash_generated_field = "B1F1F20A3974D3104E18AFBE0FDC68F5")

    private boolean mFromSetInputType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.907 -0400", hash_original_field = "3190920D715F610F81C5FD65C185C657", hash_generated_field = "B0F96C3D8606AC9C7948E05A7E4901F3")

    private boolean mGotTouchDown;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.907 -0400", hash_original_field = "B81C45043BA225BD35B5D476365853C6", hash_generated_field = "E96D278DCBB2486BABE91B0B1F485A2C")

    private boolean mHasPerformedLongClick;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.907 -0400", hash_original_field = "7FB500E5FDE560E73625CFD1DFEF752E", hash_generated_field = "DF5D9447105457646310FED90F470EAD")

    private boolean mInSetTextAndKeepSelection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.908 -0400", hash_original_field = "54CF12A90BD31D49BEEC7F1C057508F6", hash_generated_field = "6609AE5368A22032BC95D8A4F540825D")

    private char[] mCharacter = new char[1];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.908 -0400", hash_original_field = "F1533E5D1FD44B78E1B0B14191128D39", hash_generated_field = "9AAA9180D5C6EA2B6F39383B0109CA19")

    private boolean mGotDelete;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.908 -0400", hash_original_field = "22C881D2E0A56905D55ED6675B3549E0", hash_generated_field = "2CF38EE8C3AB172E07962BA75C82A9B5")

    private int mDelSelStart;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.908 -0400", hash_original_field = "7C3A751C4FF039E4FAA7F5CAE39FD464", hash_generated_field = "D82137E88C0E3DBDD263016B18A71ED7")

    private int mDelSelEnd;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.908 -0400", hash_original_field = "2A3109A682991470C8E7A9944372B1F8", hash_generated_field = "D46CADD5A6770F085C96392C484CE8BB")

    private boolean mAutoFillable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.908 -0400", hash_original_field = "427104C070D8C07CDE4241C4F45B4A38", hash_generated_field = "1A9B7D5E459A03CD29A94A18A042A141")

    private int mQueryId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.908 -0400", hash_original_field = "82043C068B61F18A751B8FC8336B6170", hash_generated_field = "2BCE54AE988047B9C3EAA8097538934B")

    private boolean mAutoFillProfileIsSet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.908 -0400", hash_original_field = "90B41CF9E5879026F7DA6EAAE140E666", hash_generated_field = "B10B7E3578A05C072780A4670FC3EEEE")

    private boolean mInsideRemove;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.908 -0400", hash_original_field = "572851143F58D86B2089A8B56ED682F4", hash_generated_field = "E09CD7B1F21A80E07EFF4D82C84FA850")

    private MyResultReceiver mReceiver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.908 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

    private Handler mHandler;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.921 -0400", hash_original_method = "089095F3BAAFCF9E87F2A27B8FA6A0A2", hash_generated_method = "70D3D0D9C6399F093D302162402A3165")
      WebTextView(Context context, WebView webView, int autoFillQueryId) {
        super(context, null, com.android.internal.R.attr.webTextViewStyle);
        mWebView = webView;
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
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.921 -0400", hash_original_method = "9CA3B5083DA9628F4399959A49D35A0D", hash_generated_method = "2DE82FA3FCBAE95C8EB28789ABC6EA02")
            @Override
            public void handleMessage(Message msg) {
                //Begin case AUTOFILL_FORM 
                mWebView.autoFillForm(mQueryId);
                //End case AUTOFILL_FORM 
                addTaint(msg.getTaint());
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
        addTaint(context.getTaint());
        addTaint(autoFillQueryId);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.928 -0400", hash_original_method = "AE45889DF7F2FB1AD82AA8B5F1FED7F7", hash_generated_method = "777A71D3EFDBD434D2FC45D0739EED0C")
    public void setAutoFillable(int queryId) {
        mAutoFillable = mWebView.getSettings().getAutoFillEnabled()
                && (queryId != FORM_NOT_AUTOFILLABLE);
        mQueryId = queryId;
        // ---------- Original Method ----------
        //mAutoFillable = mWebView.getSettings().getAutoFillEnabled()
                //&& (queryId != FORM_NOT_AUTOFILLABLE);
        //mQueryId = queryId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.929 -0400", hash_original_method = "2A0FFA3F53D08ACDC8DCA45FA27A8D22", hash_generated_method = "861FFC6380FF6795E54BB76F4063D536")
    @Override
    public void setPadding(int left, int top, int right, int bottom) {
        super.setPadding(left + mRingInset, top + mRingInset,
                right + mRingInset, bottom + mRingInset);
        addTaint(left);
        addTaint(top);
        addTaint(right);
        addTaint(bottom);
        // ---------- Original Method ----------
        //super.setPadding(left + mRingInset, top + mRingInset,
                //right + mRingInset, bottom + mRingInset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.942 -0400", hash_original_method = "6961E56AC59C570DF49F429D8D391CD8", hash_generated_method = "8FBC8C6F63DFD1C7ADB4ABA7B7F6F98B")
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        {
            boolean var54D21F6CA47C3F13B3018213ED17168D_595575562 = (event.isSystem());
            {
                boolean varCEE2CC9A2E312DCEF21BEB8A1D3D2A74_1955192819 = (super.dispatchKeyEvent(event));
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
                boolean var72F8103664F7AA5B2750DCAC9FD4B6CA_41889710 = (isPopupShowing());
                {
                    boolean var97BD0C91372FF8CDE07B475E38FE656A_1571405615 = (super.dispatchKeyEvent(event));
                } //End block
            } //End collapsed parenthetic
            {
                InputMethodManager.getInstance(mContext)
                        .hideSoftInputFromWindow(getWindowToken(), 0);
                sendDomEvent(new KeyEvent(KeyEvent.ACTION_DOWN, keyCode));
                sendDomEvent(event);
            } //End block
            boolean varD6051F78D5E57D3CCCE2FBA8ECC49974_1462277188 = (super.dispatchKeyEvent(event));
        } //End block
        {
            {
                boolean var72F8103664F7AA5B2750DCAC9FD4B6CA_1452583977 = (isPopupShowing());
                {
                    boolean var97BD0C91372FF8CDE07B475E38FE656A_844124819 = (super.dispatchKeyEvent(event));
                } //End block
            } //End collapsed parenthetic
            {
                mWebView.centerKeyPressOnTextField();
            } //End block
            boolean varD6051F78D5E57D3CCCE2FBA8ECC49974_1239657144 = (super.dispatchKeyEvent(event));
        } //End block
        {
            boolean var778B744EBE60DF815BEE98852B413FC5_1054370802 = (getLayout() == null);
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
            boolean varD6051F78D5E57D3CCCE2FBA8ECC49974_1478910215 = (super.dispatchKeyEvent(event));
            {
                {
                    mGotEnterDown = true;
                } //End block
                {
                    {
                        boolean var3BF1F25582652AF3CD5797A1157BFB20_1253810111 = (!oldText.equals(getText().toString()));
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
                Object var908199CAFC193F17BD0A3FE9AC9B6CAE_1941226488 = (mWebView.onKeyDown(keyCode, event));
                Object var38857E8F00A1A40A83F7362F0A95A91E_448547281 = (mWebView
                    .onKeyUp(keyCode, event));
            } //End flattened ternary
        } //End block
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1501823799 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1501823799;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.942 -0400", hash_original_method = "4890DDDCE957B3D3A5D6757132681BB5", hash_generated_method = "960E281529C269A8210D70F56A58117F")
     void ensureLayout() {
        {
            boolean var778B744EBE60DF815BEE98852B413FC5_824047243 = (getLayout() == null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.943 -0400", hash_original_method = "7D5E495C9B289687F8273FA9EA57C0F7", hash_generated_method = "56F9013AB0787CB1DB39A1FD0ED1B38A")
     ResultReceiver getResultReceiver() {
        ResultReceiver varB4EAC82CA7396A68D541C85D26508E83_1572676415 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1572676415 = mReceiver;
        varB4EAC82CA7396A68D541C85D26508E83_1572676415.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1572676415;
        // ---------- Original Method ----------
        //return mReceiver;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.943 -0400", hash_original_method = "0D2A49DF88825D4B2D39C3141FFC083A", hash_generated_method = "5319B39DF6D74F0220F12AD972EC9143")
     boolean isSameTextField(int ptr) {
        addTaint(ptr);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_71369696 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_71369696;
        // ---------- Original Method ----------
        //return ptr == mNodePointer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.944 -0400", hash_original_method = "480AEB5EE1C7676DB93788B189E32B71", hash_generated_method = "DFD71753472067ED14494E08B499306B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.944 -0400", hash_original_method = "76914D313CC2AB81853EDD1E3C727FFE", hash_generated_method = "5821F9E64F6F0CE7BE049A6983D569A3")
    @Override
    protected void makeNewLayout(int w, int hintWidth, Metrics boring,
            Metrics hintBoring, int ellipsisWidth, boolean bringIntoView) {
        super.makeNewLayout(w, hintWidth, boring, hintBoring, ellipsisWidth,
                bringIntoView);
        lineUpScroll();
        addTaint(w);
        addTaint(hintWidth);
        addTaint(boring.getTaint());
        addTaint(hintBoring.getTaint());
        addTaint(ellipsisWidth);
        addTaint(bringIntoView);
        // ---------- Original Method ----------
        //super.makeNewLayout(w, hintWidth, boring, hintBoring, ellipsisWidth,
                //bringIntoView);
        //lineUpScroll();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.949 -0400", hash_original_method = "B64466D7D13E6636B7758E5E911C1FF7", hash_generated_method = "FC77921B0A6BDBE1717E73E81FE5A1C3")
    @Override
    public InputConnection onCreateInputConnection(
            EditorInfo outAttrs) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        InputConnection varB4EAC82CA7396A68D541C85D26508E83_1437205721 = null; //Variable for return #1
        InputConnection connection;
        connection = super.onCreateInputConnection(outAttrs);
        {
            outAttrs.fieldName = mWebView.nativeFocusCandidateName() + "\\"
                    + mWebView.getUrl();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1437205721 = connection;
        addTaint(outAttrs.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1437205721.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1437205721;
        // ---------- Original Method ----------
        //InputConnection connection = super.onCreateInputConnection(outAttrs);
        //if (mWebView != null) {
            //outAttrs.fieldName = mWebView.nativeFocusCandidateName() + "\\"
                    //+ mWebView.getUrl();
        //}
        //return connection;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.949 -0400", hash_original_method = "804428A0FF8505961E29DE067C3E7206", hash_generated_method = "D14CF1B92B4560589E8C537FB3B13C87")
    @Override
    public void onEditorAction(int actionCode) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        //Begin case EditorInfo.IME_ACTION_NEXT 
        {
            boolean var61E9772AE146CF8460E5E9E7C7CB61AE_839058745 = (mWebView.nativeMoveCursorToNextTextInput());
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
        addTaint(actionCode);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.956 -0400", hash_original_method = "199CA847E2A702BC0971D902FFD82329", hash_generated_method = "7CE2FCAB2D00F05F42E15869ECBD15B0")
    @Override
    protected void onFocusChanged(boolean focused, int direction,
            Rect previouslyFocusedRect) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mFromFocusChange = true;
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
        {
            mWebView.setActive(true);
        } //End block
        {
            mWebView.setActive(false);
        } //End block
        mFromFocusChange = false;
        addTaint(focused);
        addTaint(direction);
        addTaint(previouslyFocusedRect.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.957 -0400", hash_original_method = "A29BC68952EA75E2FA60BFA3E7E77A14", hash_generated_method = "9045BBBB8603CC9F5C5E1D1719358961")
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //DSFIXME:  CODE0009: Possible callback target function detected
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
        addTaint(parent.getTaint());
        addTaint(view.getTaint());
        addTaint(position);
        addTaint(id);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.971 -0400", hash_original_method = "D3CDB855BC1EDCE86869BE708EA015CC", hash_generated_method = "24F0587FCCA742AE4B60DC2FCB2DD653")
    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onScrollChanged(l, t, oldl, oldt);
        lineUpScroll();
        addTaint(l);
        addTaint(t);
        addTaint(oldl);
        addTaint(oldt);
        // ---------- Original Method ----------
        //super.onScrollChanged(l, t, oldl, oldt);
        //lineUpScroll();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.972 -0400", hash_original_method = "8C1441039C2AFE6E28B135997E9DB205", hash_generated_method = "CDB3F6F8F58BD83D2E2273E21C6F4FF3")
    @Override
    protected void onSelectionChanged(int selStart, int selEnd) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            mWebView.setSelection(selStart, selEnd);
            lineUpScroll();
        } //End block
        addTaint(selStart);
        addTaint(selEnd);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.973 -0400", hash_original_method = "86E27647BFDE15D66BF8F4D142CAE4A5", hash_generated_method = "0BA37316CCECC6878810737B26347A93")
    @Override
    protected void onTextChanged(CharSequence s,int start,int before,int count) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onTextChanged(s, start, before, count);
        String postChange;
        postChange = s.toString();
        {
            boolean var69B0C10C334112C2C00F8FB5966E302E_1182064568 = (mPreChange == null || mPreChange.equals(postChange) ||
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
                boolean var0D4AADC711594525F4030B31B07C7D56_1703164446 = (replaceButOne.equals(replacedString));
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
                        boolean varFC8D0E9132A6E0775D7E4533EF2FB773_2058239705 = (!KeyEvent.isModifierKey(events[i].getKeyCode()));
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
        addTaint(s.getTaint());
        addTaint(start);
        addTaint(before);
        addTaint(count);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.983 -0400", hash_original_method = "C8E8CDF4C81BBE6A97ACE8DDCE593DE3", hash_generated_method = "C668DB7536420EE1E5CE8B62745595BA")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            Object var9E1FBD251DF7E53AB77C3A31F15B2B38_2059181571 = (event.getAction());
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
                boolean var9093599EE2DF5C5F4C4285B452695469_32364309 = (Math.abs((int) event.getX() - mDragStartX) < slop
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_139905462 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_139905462;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.995 -0400", hash_original_method = "39A98F4B040DD226E88FA29A15911D83", hash_generated_method = "9FEB9E2210880C678A68406E5A3E3FE0")
    @Override
    public boolean onTrackballEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean varBF0DD052E7F558A1BAF9DA85140649CD_51014831 = (isPopupShowing());
            {
                boolean varA6E78A78BE965F341F5864424E55B8B1_750124604 = (super.onTrackballEvent(event));
            } //End block
        } //End collapsed parenthetic
        {
            boolean var4AC14C2DF0ECC4D7F899974BD11F2605_232911178 = (event.getAction() != MotionEvent.ACTION_MOVE);
        } //End collapsed parenthetic
        Spannable text;
        text = getText();
        MovementMethod move;
        move = getMovementMethod();
        {
            boolean var0040A18D22912D1038EED02F5F656E69_2124074821 = (move != null && getLayout() != null &&
            move.onTrackballEvent(this, text, event));
        } //End collapsed parenthetic
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_632101995 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_632101995;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.996 -0400", hash_original_method = "3EEE407D8FB8A76E11AC99079A17DC34", hash_generated_method = "53F3FDFF00DACF14E2AA28C8D6523205")
    @Override
    public boolean performLongClick() {
        mHasPerformedLongClick = true;
        boolean var98B6A4E762A67C23892FBA15AF127489_966690406 = (super.performLongClick());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_832255815 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_832255815;
        // ---------- Original Method ----------
        //mHasPerformedLongClick = true;
        //return super.performLongClick();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.996 -0400", hash_original_method = "E890325AD4CF04CF90789A3947029902", hash_generated_method = "F7DE8EE35F54ED21EA76CFB2189113CC")
     void remove() {
        InputMethodManager imm;
        imm = InputMethodManager.getInstance(mContext);
        {
            boolean var4D18B3E55AF70DF7121DEC3A80BC5F4E_443945654 = (imm.isActive(this));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.996 -0400", hash_original_method = "2AA5BA571DA39EAF8290098D28F58BC6", hash_generated_method = "796AF4967E265E5E47F6E5FD7DFF9F5C")
    @Override
    public boolean requestRectangleOnScreen(Rect rectangle, boolean immediate) {
        addTaint(rectangle.getTaint());
        addTaint(immediate);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_572188308 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_572188308;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.997 -0400", hash_original_method = "950AB6742CC7236DE25064405668EBFC", hash_generated_method = "396D2A9A5FE83ACAC0DC89C9320D6361")
    private void sendDomEvent(KeyEvent event) {
        mWebView.passToJavaScript(getText().toString(), event);
        addTaint(event.getTaint());
        // ---------- Original Method ----------
        //mWebView.passToJavaScript(getText().toString(), event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.997 -0400", hash_original_method = "95851FC5190E2011BB56B8769701FDF9", hash_generated_method = "E8219A698D2FBA36049F4B23E2CC0214")
    public void setAdapterCustom(AutoCompleteAdapter adapter) {
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
        addTaint(adapter.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.998 -0400", hash_original_method = "10D826035FBCEEF5092B615EC9DFDE75", hash_generated_method = "5ABD4707123BD09DB40E915BB7B2E17E")
     void setDefaultSelection() {
        Spannable text;
        text = (Spannable) getText();
        int selection;
        selection = text.length();
        selection = 0;
        {
            boolean varF4278F67DD911DA82DDA2D9690C72EDB_1282022002 = (Selection.getSelectionStart(text) == selection
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.998 -0400", hash_original_method = "5F3F3B089AD7E0D8B5861A9F4DCE5D55", hash_generated_method = "53B0753D53166C12354A2B62A3B07A9E")
    @Override
    public void setInputType(int type) {
        mFromSetInputType = true;
        super.setInputType(type);
        mFromSetInputType = false;
        addTaint(type);
        // ---------- Original Method ----------
        //mFromSetInputType = true;
        //super.setInputType(type);
        //mFromSetInputType = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.010 -0400", hash_original_method = "6C4324E77F1CB780AA79022DD606C31E", hash_generated_method = "65A7D4B6B0972AC9343C484B2DC39669")
    private void setMaxLength(int maxLength) {
        mMaxLength = maxLength;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.011 -0400", hash_original_method = "C341AA0EB003F8D508947196584836B7", hash_generated_method = "4D73E5A03DBEA5507C167C2D432CDEBA")
     void setNodePointer(int ptr) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.012 -0400", hash_original_method = "1A385B6FBFB65985BDFEFA75CA11C93C", hash_generated_method = "BA2F1356D5DEF51E6BCFAE17CCA03687")
     void setRect(int x, int y, int width, int height) {
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
            boolean var88AD79EA276C28AD3B3469360BCE1788_2130729808 = (getParent() == null);
            {
                mWebView.addView(this, 0, lp);
            } //End block
            {
                setLayoutParams(lp);
            } //End block
        } //End collapsed parenthetic
        mWidthSpec = MeasureSpec.makeMeasureSpec(width, MeasureSpec.EXACTLY);
        mHeightSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY);
        addTaint(x);
        addTaint(y);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.022 -0400", hash_original_method = "CE3949E5C336F8D95926C2F0BAE76623", hash_generated_method = "9ADDFA6B277AB70338A8E7A2E59B002A")
     void setSelectionFromWebKit(int start, int end) {
        Spannable text;
        text = (Spannable) getText();
        int length;
        length = text.length();
        mFromWebKit = true;
        Selection.setSelection(text, start, end);
        mFromWebKit = false;
        addTaint(start);
        addTaint(end);
        // ---------- Original Method ----------
        //if (start < 0 || end < 0) return;
        //Spannable text = (Spannable) getText();
        //int length = text.length();
        //if (start > length || end > length) return;
        //mFromWebKit = true;
        //Selection.setSelection(text, start, end);
        //mFromWebKit = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.023 -0400", hash_original_method = "0E0FB59047FF987C205DC97754DD32D6", hash_generated_method = "46ED449FA39054C279978DD39BFF9DC8")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.024 -0400", hash_original_method = "FCE77DF28E9B30518950525927BBC7BA", hash_generated_method = "9D7229BF75F2F8A04062EC0939AFB69E")
     void setTextAndKeepSelection(String text) {
        Editable edit;
        edit = getText();
        mPreChange = text;
        {
            boolean var5432E2777F3E47E5271ACDBBC7473721_1723932530 = (edit.toString().equals(text));
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
            boolean varA8F5F3E7D2555623A6FFCFE24BB87152_1076742084 = (imm != null && imm.isActive(this));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.120 -0400", hash_original_method = "9C43235B4CCED4C8A2DC53AB1F7D42B9", hash_generated_method = "A9A745B19354288CB3D0A4BFE342201A")
     void setType(int type) {
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
            boolean var3E3815771BE6F168CB2B354EC011EE17_1263899864 = (!mWebView.nativeFocusCandidateIsSpellcheck());
            {
                inputType |= InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS;
            } //End block
        } //End collapsed parenthetic
        {
            boolean var44F922C57DB3172B2082134B01A29DB9_1669097377 = (TEXT_AREA != type
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
                    boolean varD67362095BA70133EC9349BE62DFEB10_1106042435 = (name != null && name.length() > 0);
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
        addTaint(type);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.122 -0400", hash_original_method = "DC0208EAD79A0BCADD603C831599A0E0", hash_generated_method = "353A0AED74824F2EAB6775FEEFC50847")
     void updateCachedTextfield() {
        mWebView.updateCachedTextfield(getText().toString());
        // ---------- Original Method ----------
        //mWebView.updateCachedTextfield(getText().toString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.122 -0400", hash_original_method = "E906B54723AD6F9ED79F8F4825A6BCDE", hash_generated_method = "00DFCCEAEBCA5AF7E29ED7EACECB08F0")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.134 -0400", hash_original_method = "4A2837BA61927EB8FB72E630E60D5F6F", hash_generated_method = "F69E1B7B32D599014467719A0F2018E4")
    public void setGravityForRtl(boolean rtl) {
        int gravity;
        gravity = Gravity.RIGHT;
        gravity = Gravity.LEFT;
        gravity |= mSingle ? Gravity.CENTER_VERTICAL : Gravity.TOP;
        setGravity(gravity);
        addTaint(rtl);
        // ---------- Original Method ----------
        //int gravity = rtl ? Gravity.RIGHT : Gravity.LEFT;
        //gravity |= mSingle ? Gravity.CENTER_VERTICAL : Gravity.TOP;
        //setGravity(gravity);
    }

    
    private class MyResultReceiver extends ResultReceiver {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.134 -0400", hash_original_method = "B2A067584316D6A9483E42E372CB0982", hash_generated_method = "68249943C085278FACB82801440E2E68")
        public  MyResultReceiver(Handler handler) {
            super(handler);
            addTaint(handler.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.135 -0400", hash_original_method = "8968B16CB33DBBA966B5E497FFEF8D80", hash_generated_method = "EFC129D13CAE4BD8DF24A8EBEF95758D")
        @Override
        protected void onReceiveResult(int resultCode, Bundle resultData) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                mWebView.revealSelection();
            } //End block
            addTaint(resultCode);
            addTaint(resultData.getTaint());
            // ---------- Original Method ----------
            //if (resultCode == InputMethodManager.RESULT_SHOWN
                    //&& mWebView != null) {
                //mWebView.revealSelection();
            //}
        }

        
    }


    
    private static class BackgroundDrawable extends Drawable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.135 -0400", hash_original_field = "1F593C5E1FA9C53F92379484654564D2", hash_generated_field = "04B4E10AE3E38C24827628B090CB2FA5")

        private Paint mPaint = new Paint();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.135 -0400", hash_original_field = "03374CE06B404E7E86A0B34197FB2079", hash_generated_field = "42F6FF6ED2F2BB89D0174DF2E15B171E")

        private int mBorderWidth;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.135 -0400", hash_original_field = "639B0CA9A647A32015C0F0585C02AEF4", hash_generated_field = "A3E5C64B3DE033797510B24E6CF68D4E")

        private Rect mInsetRect = new Rect();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.136 -0400", hash_original_method = "A19D023ADE41459A26F3E78681345993", hash_generated_method = "B7182D490DEE1E3239DF8910CDE3BDE3")
        public  BackgroundDrawable(int width) {
            mPaint = new Paint();
            mPaint.setStrokeWidth(width);
            mBorderWidth = width;
            // ---------- Original Method ----------
            //mPaint = new Paint();
            //mPaint.setStrokeWidth(width);
            //mBorderWidth = width;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.145 -0400", hash_original_method = "B7807C75F15BA2C587A7A3AFE401787F", hash_generated_method = "F3E4C0CCC46D1CB344FC07FC56A40726")
        @Override
        public void draw(Canvas canvas) {
            mPaint.setColor(0x6633b5e5);
            canvas.drawRect(getBounds(), mPaint);
            mInsetRect.left = getBounds().left + mBorderWidth;
            mInsetRect.top = getBounds().top + mBorderWidth;
            mInsetRect.right = getBounds().right - mBorderWidth;
            mInsetRect.bottom = getBounds().bottom - mBorderWidth;
            mPaint.setColor(Color.WHITE);
            canvas.drawRect(mInsetRect, mPaint);
            addTaint(canvas.getTaint());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.146 -0400", hash_original_method = "5784D116F3F796E4D5324F7E68A41209", hash_generated_method = "DCDCC287CA9BC5217D3FA2BC94984F3E")
        @Override
        public void setAlpha(int alpha) {
            addTaint(alpha);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.146 -0400", hash_original_method = "77240A7357C6E5E7293BFF14ACDD79D8", hash_generated_method = "18D8B35FAE562ED5B4F19A1CD78B9AEE")
        @Override
        public void setColorFilter(ColorFilter cf) {
            addTaint(cf.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.157 -0400", hash_original_method = "AB3D570DA2A917C408AB4F7D8FCD7103", hash_generated_method = "7D1B02EB53DF8EE69EE50661FA849202")
        @Override
        public int getOpacity() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1629029141 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1629029141;
            // ---------- Original Method ----------
            //return PixelFormat.TRANSLUCENT;
        }

        
    }


    
    private static class WebTextViewLayout extends DynamicLayout {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.157 -0400", hash_original_field = "1870F0C40BC256036B03019DC84F1A7C", hash_generated_field = "01BDC3B4754FD272E9D33AE0E0EEA1AE")

        private float mLineHeight;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.157 -0400", hash_original_field = "9D6DE39C350B06606B906F81E8424D93", hash_generated_field = "22BC403FE7CFAEB14C6EE927FBD48C96")

        private float mDifference;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.159 -0400", hash_original_method = "84A347E9C0B83549B9D13ECC225F88CE", hash_generated_method = "03E0728705FAB5CEED3177E687A65029")
        public  WebTextViewLayout(CharSequence base, CharSequence display,
                TextPaint paint,
                int width, Alignment align,
                float spacingMult, float spacingAdd,
                boolean includepad,
                TextUtils.TruncateAt ellipsize, int ellipsizedWidth,
                float lineHeight) {
            super(base, display, paint, width, align, spacingMult, spacingAdd,
                    includepad, ellipsize, ellipsizedWidth);
            float paintLineHeight;
            paintLineHeight = paint.descent() - paint.ascent();
            {
                mLineHeight = paintLineHeight;
                mDifference = 0f;
            } //End block
            {
                mLineHeight = lineHeight;
                mDifference = (lineHeight - paintLineHeight) / 2;
            } //End block
            addTaint(base.getTaint());
            addTaint(display.getTaint());
            addTaint(paint.getTaint());
            addTaint(width);
            addTaint(align.getTaint());
            addTaint(spacingMult);
            addTaint(spacingAdd);
            addTaint(includepad);
            addTaint(ellipsize.getTaint());
            addTaint(ellipsizedWidth);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.159 -0400", hash_original_method = "BD0D404B64FBDA001253C5382CB9CD95", hash_generated_method = "1D4F99292FDAD65116DE2BCCF0A7764E")
        @Override
        public int getLineTop(int line) {
            int varF06BE5757632572D26BC32E78DF81A38_2137829962 = (Math.round(mLineHeight * line - mDifference));
            addTaint(line);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1052218557 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1052218557;
            // ---------- Original Method ----------
            //return Math.round(mLineHeight * line - mDifference);
        }

        
    }


    
    public static class AutoCompleteAdapter extends ArrayAdapter<String> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.159 -0400", hash_original_field = "59FFF1360E9B57BB348C2BF9F881659F", hash_generated_field = "B044D5C32398EDC8D922234EFA4F1DF3")

        private TextView mTextView;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.160 -0400", hash_original_method = "8B198F037E06F3C258FC2837A183399D", hash_generated_method = "F0CD92B8012075D68AFABE568C13D2D3")
        public  AutoCompleteAdapter(Context context, ArrayList<String> entries) {
            super(context, com.android.internal.R.layout
                    .web_text_view_dropdown, entries);
            addTaint(context.getTaint());
            addTaint(entries.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.172 -0400", hash_original_method = "C6FC0517987C8200BB760FE857B81ECC", hash_generated_method = "2A59EB423E2BBC77CDA4C1B6B27A5ED7")
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View varB4EAC82CA7396A68D541C85D26508E83_4612750 = null; //Variable for return #1
            TextView tv;
            tv = (TextView) super.getView(position, convertView, parent);
            {
                tv.setTextSize(TypedValue.COMPLEX_UNIT_PX, mTextView.getTextSize());
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_4612750 = tv;
            addTaint(position);
            addTaint(convertView.getTaint());
            addTaint(parent.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_4612750.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_4612750;
            // ---------- Original Method ----------
            //TextView tv =
                    //(TextView) super.getView(position, convertView, parent);
            //if (tv != null && mTextView != null) {
                //tv.setTextSize(TypedValue.COMPLEX_UNIT_PX, mTextView.getTextSize());
            //}
            //return tv;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.173 -0400", hash_original_method = "C453A8A8AADC44244B92E3146B6F4B07", hash_generated_method = "E29443429247A5B5E60DF42163779843")
        private void setTextView(TextView tv) {
            mTextView = tv;
            // ---------- Original Method ----------
            //mTextView = tv;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.173 -0400", hash_original_field = "04C9575A87A9055B7CAF07BF7E360965", hash_generated_field = "CDE5BEFF4D0FECA30185D3BE973ACE71")

    static String LOGTAG = "webtextview";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.173 -0400", hash_original_field = "A0DA38A5AAD1658278F1D161AF84C1BC", hash_generated_field = "5EFB7145770F29A6A7C59573A11D8B1E")

    private static InputFilter[] NO_FILTERS = new InputFilter[0];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.173 -0400", hash_original_field = "15FD60C697B363DBE4679F91A997C35D", hash_generated_field = "16473B99E4B30B1A75E7E768D1A607FF")

    static int FORM_NOT_AUTOFILLABLE = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.173 -0400", hash_original_field = "C38438E09D0F9CE92D1B34BAB4BF4666", hash_generated_field = "52D6EE2C370C7E414A5008529C011FAC")

    private static int NORMAL_TEXT_FIELD = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.173 -0400", hash_original_field = "D189112F8ADACAF512C50AF3CB22BC4F", hash_generated_field = "C1D68D95FA080FF886E2126CABBE4C9B")

    private static int TEXT_AREA = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.173 -0400", hash_original_field = "F16F418DD0339574597733B844BE3741", hash_generated_field = "0246ED392741CF035C84576073079A7D")

    private static int PASSWORD = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.173 -0400", hash_original_field = "CF4F7700F5D247F409D439E023DABD7D", hash_generated_field = "5BE344D8F92DA03485F81562B8425302")

    private static int SEARCH = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.173 -0400", hash_original_field = "0BF00C6641A84E5A88493EED05C8ACAE", hash_generated_field = "FE949822C1CC5EF190649B14120F01B8")

    private static int EMAIL = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.173 -0400", hash_original_field = "3CBBD51483016DACC5E4950C131ACF41", hash_generated_field = "30DA556611BD40B72B3390B8D164A3F6")

    private static int NUMBER = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.173 -0400", hash_original_field = "D60D529056D6B8D97DD44C28A7C4CD83", hash_generated_field = "D69CDA4768BA6711846C0FD5F79080BE")

    private static int TELEPHONE = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.173 -0400", hash_original_field = "DC13EA1236A891796ED81728D536C82A", hash_generated_field = "835013DC77149A0879939460B956A1A7")

    private static int URL = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.173 -0400", hash_original_field = "040BFA0BBC00732D439F4CFC8F1A8319", hash_generated_field = "EA8D778A5F9AE8CAE50D229252CFC7ED")

    private static int AUTOFILL_FORM = 100;
}

