package android.webkit;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
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

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.321 -0500", hash_original_method = "E7C0EE7191FE721628D10A594437AF98", hash_generated_method = "8BB30D6F2D888052B6E3DB7A4AD9C829")
    
static String urlForAutoCompleteData(String urlString) {
        // Remove any fragment or query string.
        URL url = null;
        try {
            url = new URL(urlString);
        } catch (MalformedURLException e) {
            Log.e(LOGTAG, "Unable to parse URL "+url);
        }

        return url != null ? url.getProtocol() + "://" + url.getHost() + url.getPath() : null;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.088 -0500", hash_original_field = "F5A01F041F615713784F34400C9DE3D9", hash_generated_field = "0254F437D32CEDBF3502981A041254AF")

    static final String LOGTAG = "webtextview";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.135 -0500", hash_original_field = "8F8BB2875FCC75EB5D66BC4152125391", hash_generated_field = "F264F8C744979293C10FAA74C516992A")

    // with no max length.
    // FIXME: This can be replaced with TextView.NO_FILTERS if that
    // is made public/protected.
    private static final InputFilter[] NO_FILTERS = new InputFilter[0];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.143 -0500", hash_original_field = "8DFAFDF4A1A82044B6B90277E33716DA", hash_generated_field = "379AA10EBF455864227A249DF496EF29")

    // external/webkit/WebKit/android/WebCoreSupport/autofill/WebAutoFill.cpp
    /* package */ static final int FORM_NOT_AUTOFILLABLE = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.164 -0500", hash_original_field = "348E4D3BD2569F1583E1E1579B9AEE1A", hash_generated_field = "07BDA709C40ACAB2A72814731F3205B5")

    private static final int NORMAL_TEXT_FIELD = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.166 -0500", hash_original_field = "3417059329709AD60B74879479C3AD63", hash_generated_field = "E85CA99FFDB1FCA0BBA2ADE14130DF18")

    private static final int TEXT_AREA = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.168 -0500", hash_original_field = "097EFDC78D3CD13329915765BCF4830C", hash_generated_field = "88669A7ECF8EEF75669B4670AD788953")

    private static final int PASSWORD = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.170 -0500", hash_original_field = "7F0E3E7EAF77150199B27292CF978A0D", hash_generated_field = "931884675335103952BCDA72B3A33B39")

    private static final int SEARCH = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.172 -0500", hash_original_field = "9587032ECA2CCE7776B904478A6D4B3B", hash_generated_field = "C1E65F020F8845ABDDEEA059710FDB93")

    private static final int EMAIL = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.174 -0500", hash_original_field = "2AB5F22BC1BF6A31A9CD038E511E1DD7", hash_generated_field = "BDF0B48D549D318EC8823826AC4E082C")

    private static final int NUMBER = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.177 -0500", hash_original_field = "C079DFADDA7C29AA0E39AB7BF856FB79", hash_generated_field = "0F94A2DFCC07B06A8BCB81F5C7D2FF37")

    private static final int TELEPHONE = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.179 -0500", hash_original_field = "10863B5E716B5BA6E1EFACDCDF2E2049", hash_generated_field = "55324EE26E196D00401F672B7D51F357")

    private static final int URL = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.182 -0500", hash_original_field = "ABF0A1FF8914F00747B518320BD6DE21", hash_generated_field = "3F36447E6A0F20CD137DED5CE2B96C90")

    private static final int AUTOFILL_FORM = 100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.090 -0500", hash_original_field = "B2ADA967A81ECE9E2F856FA1E6111C6D", hash_generated_field = "74A54BC69C155F1DB9DBB9FB9549E6B1")

    private int mRingInset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.092 -0500", hash_original_field = "E044D69EE05B24F4B93E3A3B208F5343", hash_generated_field = "99346B50377E115231263981E00655CA")

    private WebView         mWebView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.094 -0500", hash_original_field = "C0E03E3E3516C352DDC0F6EE234F8ED7", hash_generated_field = "3A6B9A9CFCC4CFF9FD3CC2E257ADB30D")

    private boolean         mSingle;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.096 -0500", hash_original_field = "CCFB45CBBFC17CBAA36DE53A9361AB03", hash_generated_field = "79B19EDDE87A329245208E091B047D6F")

    private int             mWidthSpec;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.097 -0500", hash_original_field = "CF9EF6C32593DEA3E72CD5557F090002", hash_generated_field = "29F1336AF2FB76BA06A9DD6873FBA798")

    private int             mHeightSpec;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.100 -0500", hash_original_field = "529146F303093F15E6374B3C5F850AF7", hash_generated_field = "65A351B6E5CCAE66180826263CABE420")

    private int             mNodePointer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.102 -0500", hash_original_field = "436EFEE5E9994C0F1F9F6D4B89B81003", hash_generated_field = "B355EA6AA8842714710DA7492BD3941D")

    // on the enter key.  The method for blocking unmatched key ups prevents
    // the shift key from working properly.
    private boolean         mGotEnterDown;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.104 -0500", hash_original_field = "A28A1F58C95B2AF06985030C8F572BC5", hash_generated_field = "F4895F45485234DF9F7B0249CB2D611D")

    private int             mMaxLength;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.106 -0500", hash_original_field = "82B291F1315192B5B9B5CA091C0DA2D1", hash_generated_field = "3A705522CB6CAACBE2C66EC28202771E")

    // need to send down the DOM events.
    private String          mPreChange;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.108 -0500", hash_original_field = "E7E6376407F1773C16131AFD18C6D1CC", hash_generated_field = "7E7DF9AB06D09573D4C504D8D14E8FB7")

    // when a drag starts
    private float           mDragStartX;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.110 -0500", hash_original_field = "78D8BFA985851C93437FA7E30F1DE9BE", hash_generated_field = "ABB85F1B3BA40F41725FEBBA2D68FCB7")

    private float           mDragStartY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.112 -0500", hash_original_field = "C525FE455DDFFB8A83B954735F7F1540", hash_generated_field = "6E3EDD350FD0D2F013013E766DE599D9")

    private long            mDragStartTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.114 -0500", hash_original_field = "42376F808641610C16E3E868B7095676", hash_generated_field = "FA5A49E5536E1D23955E06CF88D26990")

    private boolean         mDragSent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.117 -0500", hash_original_field = "137E27062EA13FFB563EC13600169CAE", hash_generated_field = "678C164CE6C12C8FFE657D9BCDF4536B")

    // scroll or the web page to scroll.  Gets reset after a touch down.
    private boolean         mScrolled;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.119 -0500", hash_original_field = "72E176854B6E7DF3B09D2414A2A6BE35", hash_generated_field = "D0F45B31E4BF4EA233334EA5017D6540")

    // we do not need to pass the selection back to webkit.
    private boolean         mFromWebKit;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.121 -0500", hash_original_field = "441490EA6206884BE461D24EB54D1530", hash_generated_field = "0E2FA5B1335A8149BDE01F788FDE25B3")

    // gaining focus.  If it is, we do not want to pass it to webkit.  This
    // selection comes from the MovementMethod, but we behave differently.  If
    // WebTextView gained focus from a touch, webkit will determine the
    // selection.
    private boolean         mFromFocusChange;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.124 -0500", hash_original_field = "E6AF6796EDAF4A60625C99C9FBA17553", hash_generated_field = "D243C0720AFAFC8062CE0CE2CA2B92C6")

    // do not want to pass this change to webkit.
    private boolean         mFromSetInputType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.126 -0500", hash_original_field = "877EFE9E5A75887E4961F8EC8988C3EB", hash_generated_field = "B0F96C3D8606AC9C7948E05A7E4901F3")

    private boolean         mGotTouchDown;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.128 -0500", hash_original_field = "543336F528790100BC7858B76D3FA8EE", hash_generated_field = "BF5FBF8762C2246F3F0A57F926825A8D")

    // an ACTION_DOWN MotionEvent
    private boolean         mHasPerformedLongClick;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.131 -0500", hash_original_field = "088044B4461F029FA949FB767199179A", hash_generated_field = "DF5D9447105457646310FED90F470EAD")

    private boolean         mInSetTextAndKeepSelection;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.133 -0500", hash_original_field = "156FF106E2CA7528332FA843DC394EB8", hash_generated_field = "15BD52B268B5068648B98C993A367B20")

    // KeyEvents may be determined.
    private char[]          mCharacter = new char[1];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.137 -0500", hash_original_field = "BAD7C36297EC5D68ECEC17D244E58887", hash_generated_field = "3306DB73D9EE9AE7E28434AEFB79B1E7")

    // we can simply pass a delete key instead of calling deleteSelection.
    private boolean mGotDelete;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.139 -0500", hash_original_field = "1DBF2F8D119B408685AA4E8AD9254423", hash_generated_field = "2CF38EE8C3AB172E07962BA75C82A9B5")

    private int mDelSelStart;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.141 -0500", hash_original_field = "E6C5B3B9883951C59FD88B5E3ECF6487", hash_generated_field = "D82137E88C0E3DBDD263016B18A71ED7")

    private int mDelSelEnd;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.145 -0500", hash_original_field = "66041FF16B2AD3B395E344D195D0F70D", hash_generated_field = "D46CADD5A6770F085C96392C484CE8BB")

    private boolean mAutoFillable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.148 -0500", hash_original_field = "3F8A5995BB61124C69E19BBF96B72914", hash_generated_field = "1A9B7D5E459A03CD29A94A18A042A141")

    private int mQueryId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.150 -0500", hash_original_field = "F977A0BA497AFAFE231127C111461230", hash_generated_field = "2BCE54AE988047B9C3EAA8097538934B")

    private boolean mAutoFillProfileIsSet;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.152 -0500", hash_original_field = "425788D9C9F99832B72E28FB01720D8E", hash_generated_field = "00442313770EF6954B32CB7701F672E8")

    // calling remove().
    private boolean mInsideRemove;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.161 -0500", hash_original_field = "5AD96CF0422CFB185172E2ED0566180D", hash_generated_field = "E09CD7B1F21A80E07EFF4D82C84FA850")

    private MyResultReceiver mReceiver;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.184 -0500", hash_original_field = "A163099B522120C606A3CA562F90E927", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

    private Handler mHandler;

    /**
     * Create a new WebTextView.
     * @param   context The Context for this WebTextView.
     * @param   webView The WebView that created this.
     */
    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.190 -0500", hash_original_method = "089095F3BAAFCF9E87F2A27B8FA6A0A2", hash_generated_method = "892FA8861B9A775F545FC8DB36D3E7C4")
    
WebTextView(Context context, WebView webView, int autoFillQueryId) {
        super(context, null, com.android.internal.R.attr.webTextViewStyle);
        mWebView = webView;
        mMaxLength = -1;
        setAutoFillable(autoFillQueryId);
        // Turn on subpixel text, and turn off kerning, so it better matches
        // the text in webkit.
        TextPaint paint = getPaint();
        int flags = paint.getFlags() & ~Paint.DEV_KERN_TEXT_FLAG
                | Paint.SUBPIXEL_TEXT_FLAG | Paint.DITHER_FLAG;
        paint.setFlags(flags);

        // Set the text color to black, regardless of the theme.  This ensures
        // that other applications that use embedded WebViews will properly
        // display the text in password textfields.
        setTextColor(DebugFlags.DRAW_WEBTEXTVIEW ? Color.RED : Color.BLACK);
        setBackgroundDrawable(DebugFlags.DRAW_WEBTEXTVIEW ? null : new ColorDrawable(Color.WHITE));

        // This helps to align the text better with the text in the web page.
        setIncludeFontPadding(false);

        mHandler = new Handler() {
            @DSSafe(DSCat.SAFE_LIST)
        @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                case AUTOFILL_FORM:
                    mWebView.autoFillForm(mQueryId);
                    break;
                }
            }
        };
        mReceiver = new MyResultReceiver(mHandler);
        float ringWidth = 2f * context.getResources().getDisplayMetrics().density;
        mRingInset = (int) ringWidth;
        setBackgroundDrawable(new BackgroundDrawable(mRingInset));
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(),
                getPaddingBottom());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.213 -0500", hash_original_method = "AE45889DF7F2FB1AD82AA8B5F1FED7F7", hash_generated_method = "91C2029C52A1E840852E45D5B0A7BA4C")
    
public void setAutoFillable(int queryId) {
        mAutoFillable = mWebView.getSettings().getAutoFillEnabled()
                && (queryId != FORM_NOT_AUTOFILLABLE);
        mQueryId = queryId;
    }

    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.216 -0500", hash_original_method = "2A0FFA3F53D08ACDC8DCA45FA27A8D22", hash_generated_method = "F3ED041DD4098EE31940CF4DC8551478")
    
@Override
    public void setPadding(int left, int top, int right, int bottom) {
        super.setPadding(left + mRingInset, top + mRingInset,
                right + mRingInset, bottom + mRingInset);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.221 -0500", hash_original_method = "6961E56AC59C570DF49F429D8D391CD8", hash_generated_method = "F9AB970B1A6776B3DC94065303140A42")
    
@Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.isSystem()) {
            return super.dispatchKeyEvent(event);
        }
        // Treat ACTION_DOWN and ACTION MULTIPLE the same
        boolean down = event.getAction() != KeyEvent.ACTION_UP;
        int keyCode = event.getKeyCode();

        boolean isArrowKey = false;
        switch(keyCode) {
            case KeyEvent.KEYCODE_DPAD_LEFT:
            case KeyEvent.KEYCODE_DPAD_RIGHT:
            case KeyEvent.KEYCODE_DPAD_UP:
            case KeyEvent.KEYCODE_DPAD_DOWN:
                isArrowKey = true;
                break;
        }

        if (KeyEvent.KEYCODE_TAB == keyCode) {
            if (down) {
                onEditorAction(EditorInfo.IME_ACTION_NEXT);
            }
            return true;
        }
        Spannable text = (Spannable) getText();
        int oldStart = Selection.getSelectionStart(text);
        int oldEnd = Selection.getSelectionEnd(text);
        // Normally the delete key's dom events are sent via onTextChanged.
        // However, if the cursor is at the beginning of the field, which
        // includes the case where it has zero length, then the text is not
        // changed, so send the events immediately.
        if (KeyEvent.KEYCODE_DEL == keyCode) {
            if (oldStart == 0 && oldEnd == 0) {
                sendDomEvent(event);
                return true;
            }
            if (down) {
                mGotDelete = true;
                mDelSelStart = oldStart;
                mDelSelEnd = oldEnd;
            }
        }

        if (mSingle && (KeyEvent.KEYCODE_ENTER == keyCode
                    || KeyEvent.KEYCODE_NUMPAD_ENTER == keyCode)) {
            if (isPopupShowing()) {
                return super.dispatchKeyEvent(event);
            }
            if (!down) {
                // Hide the keyboard, since the user has just submitted this
                // form.  The submission happens thanks to the two calls
                // to sendDomEvent.
                InputMethodManager.getInstance(mContext)
                        .hideSoftInputFromWindow(getWindowToken(), 0);
                sendDomEvent(new KeyEvent(KeyEvent.ACTION_DOWN, keyCode));
                sendDomEvent(event);
            }
            return super.dispatchKeyEvent(event);
        } else if (KeyEvent.KEYCODE_DPAD_CENTER == keyCode) {
            // Note that this handles center key and trackball.
            if (isPopupShowing()) {
                return super.dispatchKeyEvent(event);
            }
            // Center key should be passed to a potential onClick
            if (!down) {
                mWebView.centerKeyPressOnTextField();
            }
            // Pass to super to handle longpress.
            return super.dispatchKeyEvent(event);
        }

        // Ensure there is a layout so arrow keys are handled properly.
        if (getLayout() == null) {
            measure(mWidthSpec, mHeightSpec);
        }

        int oldLength = text.length();
        boolean maxedOut = mMaxLength != -1 && oldLength == mMaxLength;
        // If we are at max length, and there is a selection rather than a
        // cursor, we need to store the text to compare later, since the key
        // may have changed the string.
        String oldText;
        if (maxedOut && oldEnd != oldStart) {
            oldText = text.toString();
        } else {
            oldText = "";
        }
        if (super.dispatchKeyEvent(event)) {
            // If the WebTextView handled the key it was either an alphanumeric
            // key, a delete, or a movement within the text. All of those are
            // ok to pass to javascript.

            // UNLESS there is a max length determined by the html.  In that
            // case, if the string was already at the max length, an
            // alphanumeric key will be erased by the LengthFilter,
            // so do not pass down to javascript, and instead
            // return true.  If it is an arrow key or a delete key, we can go
            // ahead and pass it down.
            if (KeyEvent.KEYCODE_ENTER == keyCode
                        || KeyEvent.KEYCODE_NUMPAD_ENTER == keyCode) {
                // For multi-line text boxes, newlines will
                // trigger onTextChanged for key down (which will send both
                // key up and key down) but not key up.
                mGotEnterDown = true;
            }
            if (maxedOut && !isArrowKey && keyCode != KeyEvent.KEYCODE_DEL) {
                if (oldEnd == oldStart) {
                    // Return true so the key gets dropped.
                    return true;
                } else if (!oldText.equals(getText().toString())) {
                    // FIXME: This makes the text work properly, but it
                    // does not pass down the key event, so it may not
                    // work for a textfield that has the type of
                    // behavior of GoogleSuggest.  That said, it is
                    // unlikely that a site would combine the two in
                    // one textfield.
                    Spannable span = (Spannable) getText();
                    int newStart = Selection.getSelectionStart(span);
                    int newEnd = Selection.getSelectionEnd(span);
                    mWebView.replaceTextfieldText(0, oldLength, span.toString(),
                            newStart, newEnd);
                    return true;
                }
            }
            /* FIXME:
             * In theory, we would like to send the events for the arrow keys.
             * However, the TextView can arbitrarily change the selection (i.e.
             * long press followed by using the trackball).  Therefore, we keep
             * in sync with the TextView via onSelectionChanged.  If we also
             * send the DOM event, we lose the correct selection.
            if (isArrowKey) {
                // Arrow key does not change the text, but we still want to send
                // the DOM events.
                sendDomEvent(event);
            }
             */
            return true;
        }
        // Ignore the key up event for newlines. This prevents
        // multiple newlines in the native textarea.
        if (mGotEnterDown && !down) {
            return true;
        }
        // if it is a navigation key, pass it to WebView
        if (isArrowKey) {
            // WebView check the trackballtime in onKeyDown to avoid calling
            // native from both trackball and key handling. As this is called
            // from WebTextView, we always want WebView to check with native.
            // Reset trackballtime to ensure it.
            mWebView.resetTrackballTime();
            return down ? mWebView.onKeyDown(keyCode, event) : mWebView
                    .onKeyUp(keyCode, event);
        }
        return false;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.223 -0500", hash_original_method = "4890DDDCE957B3D3A5D6757132681BB5", hash_generated_method = "59BE804D0613033D1B47046048A5B41B")
    
void ensureLayout() {
        if (getLayout() == null) {
            // Ensure we have a Layout
            measure(mWidthSpec, mHeightSpec);
            LayoutParams params = (LayoutParams) getLayoutParams();
            if (params != null) {
                layout(params.x, params.y, params.x + params.width,
                        params.y + params.height);
            }
        }
    }

    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.225 -0500", hash_original_method = "7D5E495C9B289687F8273FA9EA57C0F7", hash_generated_method = "7D5E495C9B289687F8273FA9EA57C0F7")
    
ResultReceiver getResultReceiver() { return mReceiver; }

    /**
     *  Determine whether this WebTextView currently represents the node
     *  represented by ptr.
     *  @param  ptr Pointer to a node to compare to.
     *  @return boolean Whether this WebTextView already represents the node
     *          pointed to by ptr.
     */
    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.227 -0500", hash_original_method = "0D2A49DF88825D4B2D39C3141FFC083A", hash_generated_method = "0D2A49DF88825D4B2D39C3141FFC083A")
    
boolean isSameTextField(int ptr) {
        return ptr == mNodePointer;
    }

    /**
     * Ensure that the underlying text field/area is lined up with the WebTextView.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.230 -0500", hash_original_method = "480AEB5EE1C7676DB93788B189E32B71", hash_generated_method = "F26DE7DE8F4A6B544C3DD8C910560523")
    
private void lineUpScroll() {
        Layout layout = getLayout();
        if (mWebView != null && layout != null) {
            if (mSingle) {
                // textfields only need to be lined up horizontally.
                float maxScrollX = layout.getLineRight(0) - getWidth();
                if (DebugFlags.WEB_TEXT_VIEW) {
                    Log.v(LOGTAG, "onTouchEvent x=" + mScrollX + " y="
                            + mScrollY + " maxX=" + maxScrollX);
                }
                mWebView.scrollFocusedTextInputX(maxScrollX > 0 ?
                        mScrollX / maxScrollX : 0);
            } else {
                // textareas only need to be lined up vertically.
                mWebView.scrollFocusedTextInputY(mScrollY);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.232 -0500", hash_original_method = "76914D313CC2AB81853EDD1E3C727FFE", hash_generated_method = "ED2686C700E4B554033C5202D61F1E6E")
    
@Override
    protected void makeNewLayout(int w, int hintWidth, Metrics boring,
            Metrics hintBoring, int ellipsisWidth, boolean bringIntoView) {
        // Necessary to get a Layout to work with, and to do the other work that
        // makeNewLayout does.
        super.makeNewLayout(w, hintWidth, boring, hintBoring, ellipsisWidth,
                bringIntoView);
        lineUpScroll();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.246 -0500", hash_original_method = "B64466D7D13E6636B7758E5E911C1FF7", hash_generated_method = "5CD655410193DF56117232194F2916DC")
    
@Override public InputConnection onCreateInputConnection(
            EditorInfo outAttrs) {
        InputConnection connection = super.onCreateInputConnection(outAttrs);
        if (mWebView != null) {
            // Use the name of the textfield + the url.  Use backslash as an
            // arbitrary separator.
            outAttrs.fieldName = mWebView.nativeFocusCandidateName() + "\\"
                    + mWebView.getUrl();
        }
        return connection;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.249 -0500", hash_original_method = "804428A0FF8505961E29DE067C3E7206", hash_generated_method = "E04612FA6908AD8BA7343BF21C1AFE59")
    
@Override
    public void onEditorAction(int actionCode) {
        switch (actionCode) {
        case EditorInfo.IME_ACTION_NEXT:
            if (mWebView.nativeMoveCursorToNextTextInput()) {
                // Preemptively rebuild the WebTextView, so that the action will
                // be set properly.
                mWebView.rebuildWebTextView();
                setDefaultSelection();
                mWebView.invalidate();
            }
            break;
        case EditorInfo.IME_ACTION_DONE:
            super.onEditorAction(actionCode);
            break;
        case EditorInfo.IME_ACTION_GO:
        case EditorInfo.IME_ACTION_SEARCH:
            // Send an enter and hide the soft keyboard
            InputMethodManager.getInstance(mContext)
                    .hideSoftInputFromWindow(getWindowToken(), 0);
            sendDomEvent(new KeyEvent(KeyEvent.ACTION_DOWN,
                    KeyEvent.KEYCODE_ENTER));
            sendDomEvent(new KeyEvent(KeyEvent.ACTION_UP,
                    KeyEvent.KEYCODE_ENTER));

        default:
            break;
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.252 -0500", hash_original_method = "199CA847E2A702BC0971D902FFD82329", hash_generated_method = "F288CE8DD2AF09B9FE6C3059735F0EA5")
    
@Override
    protected void onFocusChanged(boolean focused, int direction,
            Rect previouslyFocusedRect) {
        mFromFocusChange = true;
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
        if (focused) {
            mWebView.setActive(true);
        } else if (!mInsideRemove) {
            mWebView.setActive(false);
        }
        mFromFocusChange = false;
    }

    // AdapterView.OnItemClickListener implementation

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.255 -0500", hash_original_method = "A29BC68952EA75E2FA60BFA3E7E77A14", hash_generated_method = "D4842C9399A02E0E6FE70016B0DCE206")
    
@Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (id == 0 && position == 0) {
            // Blank out the text box while we wait for WebCore to fill the form.
            replaceText("");
            WebSettings settings = mWebView.getSettings();
            if (mAutoFillProfileIsSet) {
                // Call a webview method to tell WebCore to autofill the form.
                mWebView.autoFillForm(mQueryId);
            } else {
                // There is no autofill profile setup yet and the user has
                // elected to try and set one up. Call through to the
                // embedder to action that.
                mWebView.getWebChromeClient().setupAutoFill(
                        mHandler.obtainMessage(AUTOFILL_FORM));
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.257 -0500", hash_original_method = "D3CDB855BC1EDCE86869BE708EA015CC", hash_generated_method = "EC03FFF327C7105D8D505BA4C3EC9444")
    
@Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        lineUpScroll();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.259 -0500", hash_original_method = "8C1441039C2AFE6E28B135997E9DB205", hash_generated_method = "F3CF137B79103E1A2B104E54117E7B77")
    
@Override
    protected void onSelectionChanged(int selStart, int selEnd) {
        if (!mFromWebKit && !mFromFocusChange && !mFromSetInputType
                && mWebView != null && !mInSetTextAndKeepSelection) {
            if (DebugFlags.WEB_TEXT_VIEW) {
                Log.v(LOGTAG, "onSelectionChanged selStart=" + selStart
                        + " selEnd=" + selEnd);
            }
            mWebView.setSelection(selStart, selEnd);
            lineUpScroll();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.263 -0500", hash_original_method = "86E27647BFDE15D66BF8F4D142CAE4A5", hash_generated_method = "27E4DF585B8FED9BB7AC1DDE800CCA8E")
    
@Override
    protected void onTextChanged(CharSequence s,int start,int before,int count){
        super.onTextChanged(s, start, before, count);
        String postChange = s.toString();
        // Prevent calls to setText from invoking onTextChanged (since this will
        // mean we are on a different textfield).  Also prevent the change when
        // going from a textfield with a string of text to one with a smaller
        // limit on text length from registering the onTextChanged event.
        if (mPreChange == null || mPreChange.equals(postChange) ||
                (mMaxLength > -1 && mPreChange.length() > mMaxLength &&
                mPreChange.substring(0, mMaxLength).equals(postChange))) {
            return;
        }
        if (0 == count) {
            if (before > 0) {
                // For this and all changes to the text, update our cache
                updateCachedTextfield();
                if (mGotDelete) {
                    mGotDelete = false;
                    int oldEnd = start + before;
                    if (mDelSelEnd == oldEnd
                            && (mDelSelStart == start
                            || (mDelSelStart == oldEnd && before == 1))) {
                        // If the selection is set up properly before the
                        // delete, send the DOM events.
                        sendDomEvent(new KeyEvent(KeyEvent.ACTION_DOWN,
                                KeyEvent.KEYCODE_DEL));
                        sendDomEvent(new KeyEvent(KeyEvent.ACTION_UP,
                                KeyEvent.KEYCODE_DEL));
                        return;
                    }
                }
                // This was simply a delete or a cut, so just delete the
                // selection.
                mWebView.deleteSelection(start, start + before);
            }
            mGotDelete = false;
            // before should never be negative, so whether it was a cut
            // (handled above), or before is 0, in which case nothing has
            // changed, we should return.
            return;
        }
        // Ensure that this flag gets cleared, since with autocorrect on, a
        // delete key press may have a more complex result than deleting one
        // character or the existing selection, so it will not get cleared
        // above.
        mGotDelete = false;
        // Prefer sending javascript events, so when adding one character,
        // don't replace the unchanged text.
        if (count > 1 && before == count - 1) {
            String replaceButOne =  mPreChange.subSequence(start,
                    start + before).toString();
            String replacedString = s.subSequence(start,
                    start + before).toString();
            if (replaceButOne.equals(replacedString)) {
                // we're just adding one character
                start += before;
                before = 0;
                count = 1;
            }
        }
        mPreChange = postChange;
        // Find the last character being replaced.  If it can be represented by
        // events, we will pass them to native so we can see javascript events.
        // Otherwise, replace the text being changed in the textfield.
        KeyEvent[] events = null;
        if (count == 1) {
            TextUtils.getChars(s, start + count - 1, start + count, mCharacter, 0);
            KeyCharacterMap kmap = KeyCharacterMap.load(KeyCharacterMap.VIRTUAL_KEYBOARD);
            events = kmap.getEvents(mCharacter);
        }
        boolean useKeyEvents = (events != null);
        if (useKeyEvents) {
            // This corrects the selection which may have been affected by the
            // trackball or auto-correct.
            if (DebugFlags.WEB_TEXT_VIEW) {
                Log.v(LOGTAG, "onTextChanged start=" + start
                        + " start + before=" + (start + before));
            }
            if (!mInSetTextAndKeepSelection) {
                mWebView.setSelection(start, start + before);
            }
            int length = events.length;
            for (int i = 0; i < length; i++) {
                // We never send modifier keys to native code so don't send them
                // here either.
                if (!KeyEvent.isModifierKey(events[i].getKeyCode())) {
                    sendDomEvent(events[i]);
                }
            }
        } else {
            String replace = s.subSequence(start,
                    start + count).toString();
            mWebView.replaceTextfieldText(start, start + before, replace,
                    start + count,
                    start + count);
        }
        updateCachedTextfield();
    }

    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.268 -0500", hash_original_method = "C8E8CDF4C81BBE6A97ACE8DDCE593DE3", hash_generated_method = "56ECBCE6B983396F7B59F8D557B636FD")
    
@Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
        case MotionEvent.ACTION_DOWN:
            super.onTouchEvent(event);
            // This event may be the start of a drag, so store it to pass to the
            // WebView if it is.
            mDragStartX = event.getX();
            mDragStartY = event.getY();
            mDragStartTime = event.getEventTime();
            mDragSent = false;
            mScrolled = false;
            mGotTouchDown = true;
            mHasPerformedLongClick = false;
            break;
        case MotionEvent.ACTION_MOVE:
            if (mHasPerformedLongClick) {
                mGotTouchDown = false;
                return false;
            }
            int slop = ViewConfiguration.get(mContext).getScaledTouchSlop();
            Spannable buffer = getText();
            int initialScrollX = Touch.getInitialScrollX(this, buffer);
            int initialScrollY = Touch.getInitialScrollY(this, buffer);
            super.onTouchEvent(event);
            int dx = Math.abs(mScrollX - initialScrollX);
            int dy = Math.abs(mScrollY - initialScrollY);
            // Use a smaller slop when checking to see if we've moved far enough
            // to scroll the text, because experimentally, slop has shown to be
            // to big for the case of a small textfield.
            int smallerSlop = slop/2;
            if (dx > smallerSlop || dy > smallerSlop) {
                // Scrolling is handled in onScrollChanged.
                mScrolled = true;
                cancelLongPress();
                return true;
            }
            if (Math.abs((int) event.getX() - mDragStartX) < slop
                    && Math.abs((int) event.getY() - mDragStartY) < slop) {
                // If the user has not scrolled further than slop, we should not
                // send the drag.  Instead, do nothing, and when the user lifts
                // their finger, we will change the selection.
                return true;
            }
            if (mWebView != null) {
                // Only want to set the initial state once.
                if (!mDragSent) {
                    mWebView.initiateTextFieldDrag(mDragStartX, mDragStartY,
                            mDragStartTime);
                    mDragSent = true;
                }
                boolean scrolled = mWebView.textFieldDrag(event);
                if (scrolled) {
                    mScrolled = true;
                    cancelLongPress();
                    return true;
                }
            }
            return false;
        case MotionEvent.ACTION_UP:
        case MotionEvent.ACTION_CANCEL:
            super.onTouchEvent(event);
            if (mHasPerformedLongClick) {
                mGotTouchDown = false;
                return false;
            }
            if (!mScrolled) {
                // If the page scrolled, or the TextView scrolled, we do not
                // want to change the selection
                cancelLongPress();
                if (mGotTouchDown && mWebView != null) {
                    mWebView.touchUpOnTextField(event);
                }
            }
            // Necessary for the WebView to reset its state
            if (mWebView != null && mDragSent) {
                mWebView.onTouchEvent(event);
            }
            mGotTouchDown = false;
            break;
        default:
            break;
        }
        return true;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.270 -0500", hash_original_method = "39A98F4B040DD226E88FA29A15911D83", hash_generated_method = "DA9AE56B8BB4FFD858D0586D3517FFFF")
    
@Override
    public boolean onTrackballEvent(MotionEvent event) {
        if (isPopupShowing()) {
            return super.onTrackballEvent(event);
        }
        if (event.getAction() != MotionEvent.ACTION_MOVE) {
            return false;
        }
        Spannable text = getText();
        MovementMethod move = getMovementMethod();
        if (move != null && getLayout() != null &&
            move.onTrackballEvent(this, text, event)) {
            // Selection is changed in onSelectionChanged
            return true;
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.272 -0500", hash_original_method = "3EEE407D8FB8A76E11AC99079A17DC34", hash_generated_method = "BCFB147068376B57DC697414479E7395")
    
@Override
    public boolean performLongClick() {
        mHasPerformedLongClick = true;
        return super.performLongClick();
    }

    /**
     * Remove this WebTextView from its host WebView, and return
     * focus to the host.
     */
    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.274 -0500", hash_original_method = "E890325AD4CF04CF90789A3947029902", hash_generated_method = "3B75490E6FBB8EBCBCA6C1BB22DDEA67")
    
void remove() {
        // hide the soft keyboard when the edit text is out of focus
        InputMethodManager imm = InputMethodManager.getInstance(mContext);
        if (imm.isActive(this)) {
            imm.hideSoftInputFromWindow(getWindowToken(), 0);
        }
        mInsideRemove = true;
        boolean isFocused = hasFocus();
        mWebView.removeView(this);
        if (isFocused) {
            mWebView.requestFocus();
        }
        mInsideRemove = false;
        mHandler.removeCallbacksAndMessages(null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.277 -0500", hash_original_method = "2AA5BA571DA39EAF8290098D28F58BC6", hash_generated_method = "02E162E1AE0A3E1E681D563B5E57CC26")
    
@Override
    public boolean requestRectangleOnScreen(Rect rectangle, boolean immediate) {
        // Do nothing, since webkit will put the textfield on screen.
        return true;
    }

    /**
     *  Send the DOM events for the specified event.
     *  @param event    KeyEvent to be translated into a DOM event.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.279 -0500", hash_original_method = "950AB6742CC7236DE25064405668EBFC", hash_generated_method = "74BE81AA68D09D9F104563220CA4F0BA")
    
private void sendDomEvent(KeyEvent event) {
        mWebView.passToJavaScript(getText().toString(), event);
    }

    /**
     *  Always use this instead of setAdapter, as this has features specific to
     *  the WebTextView.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.281 -0500", hash_original_method = "95851FC5190E2011BB56B8769701FDF9", hash_generated_method = "272502A4309DB82F507EA3068CA744AE")
    
public void setAdapterCustom(AutoCompleteAdapter adapter) {
        if (adapter != null) {
            setInputType(getInputType()
                    | InputType.TYPE_TEXT_FLAG_AUTO_COMPLETE);
            adapter.setTextView(this);
            if (mAutoFillable) {
                setOnItemClickListener(this);
            } else {
                setOnItemClickListener(null);
            }
            showDropDown();
        } else {
            dismissDropDown();
        }
        super.setAdapter(adapter);
    }
    
    private class MyResultReceiver extends ResultReceiver {

        /**
         * @param handler
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.158 -0500", hash_original_method = "B2A067584316D6A9483E42E372CB0982", hash_generated_method = "A41C8E4ADB44A2C6EBA3F71185D6E695")
        
public MyResultReceiver(Handler handler) {
            super(handler);
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.155 -0500", hash_original_method = "8968B16CB33DBBA966B5E497FFEF8D80", hash_generated_method = "CCC55D4B4BA407F6FE8868F9845703A7")
        
@Override
        protected void onReceiveResult(int resultCode, Bundle resultData) {
            if (resultCode == InputMethodManager.RESULT_SHOWN
                    && mWebView != null) {
                mWebView.revealSelection();
            }
        }
        
    }
    
    private static class BackgroundDrawable extends Drawable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.193 -0500", hash_original_field = "1D0586880E5CE88B4198E05E1760434E", hash_generated_field = "04B4E10AE3E38C24827628B090CB2FA5")

        private Paint mPaint = new Paint();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.196 -0500", hash_original_field = "01EC123D331F96E92A48B93553DD9DEC", hash_generated_field = "42F6FF6ED2F2BB89D0174DF2E15B171E")

        private int mBorderWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.198 -0500", hash_original_field = "951E700C208EA17C016A0102D4CE5602", hash_generated_field = "A3E5C64B3DE033797510B24E6CF68D4E")

        private Rect mInsetRect = new Rect();

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.200 -0500", hash_original_method = "A19D023ADE41459A26F3E78681345993", hash_generated_method = "8F6081E9CAD3F59950B52A5C8220F0F5")
        
public BackgroundDrawable(int width) {
            mPaint = new Paint();
            mPaint.setStrokeWidth(width);
            mBorderWidth = width;
        }

        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.203 -0500", hash_original_method = "B7807C75F15BA2C587A7A3AFE401787F", hash_generated_method = "C145239FD715E0A4B3F788877C70A998")
        
@Override
        public void draw(Canvas canvas) {
            mPaint.setColor(0x6633b5e5);
            canvas.drawRect(getBounds(), mPaint);
            mInsetRect.addTaint(getBounds().getTaintInt() + mBorderWidth);
            /*
            mInsetRect.left = getBounds().left + mBorderWidth;
            mInsetRect.top = getBounds().top + mBorderWidth;
            mInsetRect.right = getBounds().right - mBorderWidth;
            mInsetRect.bottom = getBounds().bottom - mBorderWidth;
            */
            mPaint.setColor(Color.WHITE);
            canvas.drawRect(mInsetRect, mPaint);
        }

        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.205 -0500", hash_original_method = "5784D116F3F796E4D5324F7E68A41209", hash_generated_method = "8822FC2DF74FC5FF281E781185C4613D")
        
@Override
        public void setAlpha(int alpha) {
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.208 -0500", hash_original_method = "77240A7357C6E5E7293BFF14ACDD79D8", hash_generated_method = "56040A1AD41AD2B6F2B268D1523EBD1A")
        
@Override
        public void setColorFilter(ColorFilter cf) {
        }

        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.210 -0500", hash_original_method = "AB3D570DA2A917C408AB4F7D8FCD7103", hash_generated_method = "92E82009FE448BF0B4121CF0FFF496C7")
        
@Override
        public int getOpacity() {
            return PixelFormat.TRANSLUCENT;
        }
        
    }
    
    private static class WebTextViewLayout extends DynamicLayout {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.235 -0500", hash_original_field = "E96655635C6ECAD1BB5CE801E2F562CD", hash_generated_field = "01BDC3B4754FD272E9D33AE0E0EEA1AE")

        private float mLineHeight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.237 -0500", hash_original_field = "1743DD8ACE6E9C6025DD08AC26D06DFA", hash_generated_field = "22BC403FE7CFAEB14C6EE927FBD48C96")

        private float mDifference;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.240 -0500", hash_original_method = "84A347E9C0B83549B9D13ECC225F88CE", hash_generated_method = "C96EA998B95C4A638C506F67E970718B")
        
public WebTextViewLayout(CharSequence base, CharSequence display,
                TextPaint paint,
                int width, Alignment align,
                float spacingMult, float spacingAdd,
                boolean includepad,
                TextUtils.TruncateAt ellipsize, int ellipsizedWidth,
                float lineHeight) {
            super(base, display, paint, width, align, spacingMult, spacingAdd,
                    includepad, ellipsize, ellipsizedWidth);
            float paintLineHeight = paint.descent() - paint.ascent();
            if (lineHeight == -1f) {
                mLineHeight = paintLineHeight;
                mDifference = 0f;
            } else {
                mLineHeight = lineHeight;
                // Through trial and error, I found this calculation to improve
                // the accuracy of line placement.
                mDifference = (lineHeight - paintLineHeight) / 2;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.242 -0500", hash_original_method = "BD0D404B64FBDA001253C5382CB9CD95", hash_generated_method = "8AE1DAFB4E37546C46DCDD1CB805EF74")
        
@Override
        public int getLineTop(int line) {
            return Math.round(mLineHeight * line - mDifference);
        }
        
    }
    
    public static class AutoCompleteAdapter extends ArrayAdapter<String> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.284 -0500", hash_original_field = "49AF0A2A014C0E7F98E27CA30429A8B6", hash_generated_field = "B044D5C32398EDC8D922234EFA4F1DF3")

        private TextView mTextView;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.287 -0500", hash_original_method = "8B198F037E06F3C258FC2837A183399D", hash_generated_method = "CC820E455EDF0A51E015BAE8B8232F3D")
        
public AutoCompleteAdapter(Context context, ArrayList<String> entries) {
            super(context, com.android.internal.R.layout
                    .web_text_view_dropdown, entries);
        }

        /**
         * {@inheritDoc}
         */
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.290 -0500", hash_original_method = "C6FC0517987C8200BB760FE857B81ECC", hash_generated_method = "AB8BBDB6105054F60B08743B51D4B3B1")
        
@Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView tv =
                    (TextView) super.getView(position, convertView, parent);
            if (tv != null && mTextView != null) {
                tv.setTextSize(TypedValue.COMPLEX_UNIT_PX, mTextView.getTextSize());
            }
            return tv;
        }

        /**
         * Set the TextView so we can match its text size.
         */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.292 -0500", hash_original_method = "C453A8A8AADC44244B92E3146B6F4B07", hash_generated_method = "67DDC76070F4F873C0B78644EA67760A")
        
private void setTextView(TextView tv) {
            mTextView = tv;
        }
        
    }

    /**
     * Sets the selection when the user clicks on a textfield or textarea with
     * the trackball or center key, or starts typing into it without clicking on
     * it.
     */
    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.296 -0500", hash_original_method = "10D826035FBCEEF5092B615EC9DFDE75", hash_generated_method = "CA68E96BBBB3D013102EF9EF16F172F2")
    
void setDefaultSelection() {
        Spannable text = (Spannable) getText();
        int selection = mSingle ? text.length() : 0;
        if (Selection.getSelectionStart(text) == selection
                && Selection.getSelectionEnd(text) == selection) {
            // The selection of the UI copy is set correctly, but the
            // WebTextView still needs to inform the webkit thread to set the
            // selection.  Normally that is done in onSelectionChanged, but
            // onSelectionChanged will not be called because the UI copy is not
            // changing.  (This can happen when the WebTextView takes focus.
            // That onSelectionChanged was blocked because the selection set
            // when focusing is not necessarily the desirable selection for
            // WebTextView.)
            if (mWebView != null) {
                mWebView.setSelection(selection, selection);
            }
        } else {
            Selection.setSelection(text, selection, selection);
        }
        if (mWebView != null) mWebView.incrementTextGeneration();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.298 -0500", hash_original_method = "5F3F3B089AD7E0D8B5861A9F4DCE5D55", hash_generated_method = "0B9FA14057E7819AE176154088D1509A")
    
@Override
    public void setInputType(int type) {
        mFromSetInputType = true;
        super.setInputType(type);
        mFromSetInputType = false;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.300 -0500", hash_original_method = "6C4324E77F1CB780AA79022DD606C31E", hash_generated_method = "34275D7B6F708CFD3DA3920123302E4D")
    
private void setMaxLength(int maxLength) {
        mMaxLength = maxLength;
        if (-1 == maxLength) {
            setFilters(NO_FILTERS);
        } else {
            setFilters(new InputFilter[] {
                new InputFilter.LengthFilter(maxLength) });
        }
    }

    /**
     *  Set the pointer for this node so it can be determined which node this
     *  WebTextView represents.
     *  @param  ptr Integer representing the pointer to the node which this
     *          WebTextView represents.
     */
    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.302 -0500", hash_original_method = "C341AA0EB003F8D508947196584836B7", hash_generated_method = "C341AA0EB003F8D508947196584836B7")
    
void setNodePointer(int ptr) {
        if (ptr != mNodePointer) {
            mNodePointer = ptr;
            setAdapterCustom(null);
        }
    }

    /**
     * Determine the position and size of WebTextView, and add it to the
     * WebView's view heirarchy.  All parameters are presumed to be in
     * view coordinates.  Also requests Focus and sets the cursor to not
     * request to be in view.
     * @param x         x-position of the textfield.
     * @param y         y-position of the textfield.
     * @param width     width of the textfield.
     * @param height    height of the textfield.
     */
    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.305 -0500", hash_original_method = "1A385B6FBFB65985BDFEFA75CA11C93C", hash_generated_method = "18F4A9F8A37403451C0CAC8437D278B7")
    
void setRect(int x, int y, int width, int height) {
        LayoutParams lp = (LayoutParams) getLayoutParams();
        x -= mRingInset;
        y -= mRingInset;
        width += 2 * mRingInset;
        height += 2 * mRingInset;
        boolean needsUpdate = false;
        if (null == lp) {
            lp = new LayoutParams(width, height, x, y);
        } else {
            if ((lp.x != x) || (lp.y != y) || (lp.width != width)
                    || (lp.height != height)) {
                needsUpdate = true;
                lp.x = x;
                lp.y = y;
                lp.width = width;
                lp.height = height;
            }
        }
        if (getParent() == null) {
            // Insert the view so that it's drawn first (at index 0)
            mWebView.addView(this, 0, lp);
        } else if (needsUpdate) {
            setLayoutParams(lp);
        }
        // Set up a measure spec so a layout can always be recreated.
        mWidthSpec = MeasureSpec.makeMeasureSpec(width, MeasureSpec.EXACTLY);
        mHeightSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY);
    }

    /**
     * Set the selection, and disable our onSelectionChanged action.
     */
    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.307 -0500", hash_original_method = "CE3949E5C336F8D95926C2F0BAE76623", hash_generated_method = "CE3949E5C336F8D95926C2F0BAE76623")
    
void setSelectionFromWebKit(int start, int end) {
        if (start < 0 || end < 0) return;
        Spannable text = (Spannable) getText();
        int length = text.length();
        if (start > length || end > length) return;
        mFromWebKit = true;
        Selection.setSelection(text, start, end);
        mFromWebKit = false;
    }

    /**
     * Update the text size according to the size of the focus candidate's text
     * size in mWebView.  Should only be called from mWebView.
     */
    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.309 -0500", hash_original_method = "0E0FB59047FF987C205DC97754DD32D6", hash_generated_method = "F1412A9895E136A58AC23FEB82DCADFB")
    
void updateTextSize() {
        Assert.assertNotNull("updateTextSize should only be called from "
                + "mWebView, so mWebView should never be null!", mWebView);
        // Note that this is approximately WebView.contentToViewDimension,
        // without being rounded.
        float size = mWebView.nativeFocusCandidateTextSize()
                * mWebView.getScale();
        setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
    }

    /**
     * Set the text to the new string, but use the old selection, making sure
     * to keep it within the new string.
     * @param   text    The new text to place in the textfield.
     */
    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.311 -0500", hash_original_method = "FCE77DF28E9B30518950525927BBC7BA", hash_generated_method = "66D04F62B92EBC05536F1496455B46C2")
    
void setTextAndKeepSelection(String text) {
        Editable edit = getText();
        mPreChange = text;
        if (edit.toString().equals(text)) {
            return;
        }
        int selStart = Selection.getSelectionStart(edit);
        int selEnd = Selection.getSelectionEnd(edit);
        mInSetTextAndKeepSelection = true;
        edit.replace(0, edit.length(), text);
        int newLength = edit.length();
        if (selStart > newLength) selStart = newLength;
        if (selEnd > newLength) selEnd = newLength;
        Selection.setSelection(edit, selStart, selEnd);
        mInSetTextAndKeepSelection = false;
        InputMethodManager imm = InputMethodManager.peekInstance();
        if (imm != null && imm.isActive(this)) {
            // Since the text has changed, do not allow the IME to replace the
            // existing text as though it were a completion.
            imm.restartInput(this);
        }
        updateCachedTextfield();
    }

    /**
     * Called by WebView.rebuildWebTextView().  Based on the type of the <input>
     * element, set up the WebTextView, its InputType, and IME Options properly.
     * @param type int corresponding to enum "Type" defined in CachedInput.h.
     *              Does not correspond to HTMLInputElement::InputType so this
     *              is unaffected if that changes, and also because that has no
     *              type corresponding to textarea (which is its own tag).
     */
    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.315 -0500", hash_original_method = "9C43235B4CCED4C8A2DC53AB1F7D42B9", hash_generated_method = "E5C1B8FB447755748A4CC3216D199DD4")
    
void setType(int type) {
        if (mWebView == null) return;
        boolean single = true;
        int maxLength = -1;
        int inputType = InputType.TYPE_CLASS_TEXT
                | InputType.TYPE_TEXT_VARIATION_WEB_EDIT_TEXT;
        int imeOptions = EditorInfo.IME_FLAG_NO_EXTRACT_UI
                | EditorInfo.IME_FLAG_NO_FULLSCREEN;
        if (!mWebView.nativeFocusCandidateIsSpellcheck()) {
            inputType |= InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS;
        }
        if (TEXT_AREA != type
                && mWebView.nativeFocusCandidateHasNextTextfield()) {
            imeOptions |= EditorInfo.IME_FLAG_NAVIGATE_NEXT;
        }
        switch (type) {
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
                // inputType needs to be overwritten because of the different text variation.
                inputType = InputType.TYPE_CLASS_TEXT
                        | InputType.TYPE_TEXT_VARIATION_WEB_EMAIL_ADDRESS;
                imeOptions |= EditorInfo.IME_ACTION_GO;
                break;
            case NUMBER:
                // inputType needs to be overwritten because of the different class.
                inputType = InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_NORMAL
                        | InputType.TYPE_NUMBER_FLAG_SIGNED | InputType.TYPE_NUMBER_FLAG_DECIMAL;
                // Number and telephone do not have both a Tab key and an
                // action, so set the action to NEXT
                imeOptions |= EditorInfo.IME_ACTION_NEXT;
                break;
            case TELEPHONE:
                // inputType needs to be overwritten because of the different class.
                inputType = InputType.TYPE_CLASS_PHONE;
                imeOptions |= EditorInfo.IME_ACTION_NEXT;
                break;
            case URL:
                // TYPE_TEXT_VARIATION_URI prevents Tab key from showing, so
                // exclude it for now.
                imeOptions |= EditorInfo.IME_ACTION_GO;
                break;
            default:
                imeOptions |= EditorInfo.IME_ACTION_GO;
                break;
        }
        setHint(null);
        setThreshold(1);
        boolean autoComplete = false;
        if (single) {
            mWebView.requestLabel(mWebView.nativeFocusCandidateFramePointer(),
                    mNodePointer);
            maxLength = mWebView.nativeFocusCandidateMaxLength();
            autoComplete = mWebView.nativeFocusCandidateIsAutoComplete();
            if (type != PASSWORD && (mAutoFillable || autoComplete)) {
                String name = mWebView.nativeFocusCandidateName();
                if (name != null && name.length() > 0) {
                    mWebView.requestFormData(name, mNodePointer, mAutoFillable,
                            autoComplete);
                }
            }
        }
        mSingle = single;
        setMaxLength(maxLength);
        setHorizontallyScrolling(single);
        setInputType(inputType);
        clearComposingText();
        setImeOptions(imeOptions);
        setVisibility(VISIBLE);
        if (!autoComplete) {
            setAdapterCustom(null);
        }
    }

    /**
     *  Update the cache to reflect the current text.
     */
    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.317 -0500", hash_original_method = "DC0208EAD79A0BCADD603C831599A0E0", hash_generated_method = "DC0208EAD79A0BCADD603C831599A0E0")
    
void updateCachedTextfield() {
        mWebView.updateCachedTextfield(getText().toString());
    }

    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.319 -0500", hash_original_method = "E906B54723AD6F9ED79F8F4825A6BCDE", hash_generated_method = "E906B54723AD6F9ED79F8F4825A6BCDE")
    
void setAutoFillProfileIsSet(boolean autoFillProfileIsSet) {
        mAutoFillProfileIsSet = autoFillProfileIsSet;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:40.324 -0500", hash_original_method = "4A2837BA61927EB8FB72E630E60D5F6F", hash_generated_method = "EB3AD198E94BEE06288A613B10E1B931")
    
public void setGravityForRtl(boolean rtl) {
        int gravity = rtl ? Gravity.RIGHT : Gravity.LEFT;
        gravity |= mSingle ? Gravity.CENTER_VERTICAL : Gravity.TOP;
        setGravity(gravity);
    }
}

