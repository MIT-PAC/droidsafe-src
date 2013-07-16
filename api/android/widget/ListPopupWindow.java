package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewParent;

public class ListPopupWindow {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.569 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.569 -0400", hash_original_field = "E863CEB96C01242A6262A422DC21BA91", hash_generated_field = "DD5B28EB4059D1AC7E72BAEDE50FACDF")

    private PopupWindow mPopup;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.569 -0400", hash_original_field = "59E9F255F2F17EC006AE601269EA8540", hash_generated_field = "90F29768206AB431EA361CD94838716F")

    private ListAdapter mAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.569 -0400", hash_original_field = "4322C05E16B4F2C2D1AB5006F3431B02", hash_generated_field = "680F69659AC661E81526EC1B57AD0760")

    private DropDownListView mDropDownList;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.569 -0400", hash_original_field = "D134F22E4058DC5F7CFE7175F4F7430C", hash_generated_field = "95C5FD2B2227A2419A547D55212619CB")

    private int mDropDownHeight = ViewGroup.LayoutParams.WRAP_CONTENT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.570 -0400", hash_original_field = "4B650C8F2373468D630EB87118B7597E", hash_generated_field = "DE8B8CD76D1AB415FF96E39AF3C5D34E")

    private int mDropDownWidth = ViewGroup.LayoutParams.WRAP_CONTENT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.570 -0400", hash_original_field = "D7D5E41A0CA1EEEE2C5B6053B9E223EC", hash_generated_field = "E0B55CC77CB214A3579F9BF96330095D")

    private int mDropDownHorizontalOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.570 -0400", hash_original_field = "9A3E0C1905215D1560AFB5329CF32615", hash_generated_field = "3B23099D02FB8FF58FFC662868C0BB03")

    private int mDropDownVerticalOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.570 -0400", hash_original_field = "3D416D3AD24A140B66574A53F35D71B5", hash_generated_field = "EF2837EA9E1F32EA5B98F304DCD2B02D")

    private boolean mDropDownVerticalOffsetSet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.570 -0400", hash_original_field = "7F1912418791E473B7718B11A0CB1A0C", hash_generated_field = "A2A88CD1765159B88DD7DB6DD2826AA7")

    private boolean mDropDownAlwaysVisible = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.570 -0400", hash_original_field = "67337D864119F82F72A3E7E7A32EC92E", hash_generated_field = "D1BD29312DE39A83C4D6D5BDC2010A61")

    private boolean mForceIgnoreOutsideTouch = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.570 -0400", hash_original_field = "5510B09AA8FF17E498AD062C90FAC109", hash_generated_field = "B5EDBF08EC87E5E419CCBD4768539463")

    int mListItemExpandMaximum = Integer.MAX_VALUE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.570 -0400", hash_original_field = "9E5EAA17126782F8C703F935360DD7EB", hash_generated_field = "5F49A121459BF7DF82F93F51F66D9AFA")

    private View mPromptView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.570 -0400", hash_original_field = "4884FB6D2D0EBDBDEEE548951A32A380", hash_generated_field = "D0EDBCF4B24F722A68C83DBD4FA7D38D")

    private int mPromptPosition = POSITION_PROMPT_ABOVE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.570 -0400", hash_original_field = "C61FA2E7C36AC7AB9C40A5C4B482DC3A", hash_generated_field = "3BA4BCC5F225A10F755FE4D117871D40")

    private DataSetObserver mObserver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.570 -0400", hash_original_field = "6DF5C0BD5FF25E15FDCEDCD4ECB331FC", hash_generated_field = "0AD13AB5208CE821A0A2BF31AEC73CB4")

    private View mDropDownAnchorView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.570 -0400", hash_original_field = "834760B22D3D31098FFF241394D6BBE1", hash_generated_field = "D7FBC36DD90F3884476AF7A145F7D085")

    private Drawable mDropDownListHighlight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.570 -0400", hash_original_field = "1AE585B9A4195C50494CD4717922829E", hash_generated_field = "91F251C39E992AB6E9A1F97E1DB2D65A")

    private AdapterView.OnItemClickListener mItemClickListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.570 -0400", hash_original_field = "AC663E6C1E4BAD60BFB3B64BE97350A7", hash_generated_field = "B20A14E839638431419A27C6FA2EB183")

    private AdapterView.OnItemSelectedListener mItemSelectedListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.570 -0400", hash_original_field = "7D90B69C280C66541572056B61B44881", hash_generated_field = "821F70C70BBBE64322F054DCBDCBD65D")

    private final ResizePopupRunnable mResizePopupRunnable = new ResizePopupRunnable();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.571 -0400", hash_original_field = "C9722EDCCBF64142855D27EF1F728783", hash_generated_field = "C2DF6DA91E71FE1B73AF2F99DA491C65")

    private final PopupTouchInterceptor mTouchInterceptor = new PopupTouchInterceptor();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.571 -0400", hash_original_field = "681C9FD7FBE6DFAFD31A369FD3AF23EF", hash_generated_field = "7119F706A3F3F75D0AB9F70CFDF2D458")

    private final PopupScrollListener mScrollListener = new PopupScrollListener();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.571 -0400", hash_original_field = "DA8630584E936BC465CBD5DBD2061129", hash_generated_field = "368F7081BBFDFED86D539FFD5855A591")

    private final ListSelectorHider mHideSelector = new ListSelectorHider();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.571 -0400", hash_original_field = "008C495499355199D0B743FAC72B6D16", hash_generated_field = "61A25C839F09B3FC31C414DE40E67DB5")

    private Runnable mShowDropDownRunnable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.571 -0400", hash_original_field = "6781893E9FA50A9B7103FD3F674E566B", hash_generated_field = "2E60E17486AAEB1A4E1F1878A0354061")

    private Handler mHandler = new Handler();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.571 -0400", hash_original_field = "DF43B278CEE8933271AB3D9F9E312F86", hash_generated_field = "AFFA54D19F07A10EE8847CF76FC95323")

    private Rect mTempRect = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.571 -0400", hash_original_field = "126D90D638B8925B7E67DD1602EB9153", hash_generated_field = "2CBF8E91F49F039C5D23189C3E7CE590")

    private boolean mModal;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.571 -0400", hash_original_method = "EE0C6E46788D5D6F0175B90B5CCF0B4A", hash_generated_method = "A7BDC1A593955EB85983C7550497CC46")
    public  ListPopupWindow(Context context) {
        this(context, null, com.android.internal.R.attr.listPopupWindowStyle, 0);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.572 -0400", hash_original_method = "C9E1E41EEB8F4220F08A0D28BC21C4EB", hash_generated_method = "E9354EF42BD00D22F68A2E1595357874")
    public  ListPopupWindow(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.listPopupWindowStyle, 0);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.572 -0400", hash_original_method = "449FC27C9387B8AAB93C584A7B8B7579", hash_generated_method = "7FCB64E8D3DEF5879FC67D60B221DB6A")
    public  ListPopupWindow(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
        addTaint(defStyleAttr);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.573 -0400", hash_original_method = "F8B1DB93A85ECDB9C2D2CE8639D222AE", hash_generated_method = "FE5B87D971B39F25483B906D7F81739C")
    public  ListPopupWindow(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        mContext = context;
        mPopup = new PopupWindow(context, attrs, defStyleAttr, defStyleRes);
        mPopup.setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED);
        // ---------- Original Method ----------
        //mContext = context;
        //mPopup = new PopupWindow(context, attrs, defStyleAttr, defStyleRes);
        //mPopup.setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.574 -0400", hash_original_method = "B55D1F7EE07C2CDF60B7B314069C1E48", hash_generated_method = "3F5C80D4629C1AC86C25B2A68F594407")
    public void setAdapter(ListAdapter adapter) {
    if(mObserver == null)        
        {
            mObserver = new PopupDataSetObserver();
        } //End block
        else
    if(mAdapter != null)        
        {
            mAdapter.unregisterDataSetObserver(mObserver);
        } //End block
        mAdapter = adapter;
    if(mAdapter != null)        
        {
            adapter.registerDataSetObserver(mObserver);
        } //End block
    if(mDropDownList != null)        
        {
            mDropDownList.setAdapter(mAdapter);
        } //End block
        // ---------- Original Method ----------
        //if (mObserver == null) {
            //mObserver = new PopupDataSetObserver();
        //} else if (mAdapter != null) {
            //mAdapter.unregisterDataSetObserver(mObserver);
        //}
        //mAdapter = adapter;
        //if (mAdapter != null) {
            //adapter.registerDataSetObserver(mObserver);
        //}
        //if (mDropDownList != null) {
            //mDropDownList.setAdapter(mAdapter);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.574 -0400", hash_original_method = "7CC61A3797371517F86E3D676D22847C", hash_generated_method = "CE87A26F1F31625F1A82E312F687DB1A")
    public void setPromptPosition(int position) {
        mPromptPosition = position;
        // ---------- Original Method ----------
        //mPromptPosition = position;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.574 -0400", hash_original_method = "DF9D97B46096A1E4CCF9033CE8B43A47", hash_generated_method = "F950C601B0B82A2E25DD824936C24290")
    public int getPromptPosition() {
        int var95DB2E6BA8E93C0D3FFA9A095A684BEB_1393121843 = (mPromptPosition);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_169169707 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_169169707;
        // ---------- Original Method ----------
        //return mPromptPosition;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.575 -0400", hash_original_method = "320A57FA9129485B3F1A01EDA8808ED5", hash_generated_method = "CCC0E91E124615C44FD084559DF2166E")
    public void setModal(boolean modal) {
        addTaint(modal);
        mModal = true;
        mPopup.setFocusable(modal);
        // ---------- Original Method ----------
        //mModal = true;
        //mPopup.setFocusable(modal);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.575 -0400", hash_original_method = "195244B0122E9C532D039816F791192C", hash_generated_method = "9331CC482AE2849ACD06A17343DCB9F0")
    public boolean isModal() {
        boolean var126D90D638B8925B7E67DD1602EB9153_1727047864 = (mModal);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1302675896 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1302675896;
        // ---------- Original Method ----------
        //return mModal;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.575 -0400", hash_original_method = "B51F6D3B2B582EB2529861E286FFBDAA", hash_generated_method = "C259F7A19612B2ACBFCE0BD237FE9AAB")
    public void setForceIgnoreOutsideTouch(boolean forceIgnoreOutsideTouch) {
        mForceIgnoreOutsideTouch = forceIgnoreOutsideTouch;
        // ---------- Original Method ----------
        //mForceIgnoreOutsideTouch = forceIgnoreOutsideTouch;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.576 -0400", hash_original_method = "0D7558B683A811B4FB459E3A92DCFACB", hash_generated_method = "6C5818E602B53931F3E1B0DBF55A9DBB")
    public void setDropDownAlwaysVisible(boolean dropDownAlwaysVisible) {
        mDropDownAlwaysVisible = dropDownAlwaysVisible;
        // ---------- Original Method ----------
        //mDropDownAlwaysVisible = dropDownAlwaysVisible;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.576 -0400", hash_original_method = "452BC62A357E5A143092E81C66B09D6A", hash_generated_method = "9C0B002EC271B803D150A0DA873037A5")
    public boolean isDropDownAlwaysVisible() {
        boolean var943ED63B762C4367544DC0A05775D6AA_1182459586 = (mDropDownAlwaysVisible);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_533555302 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_533555302;
        // ---------- Original Method ----------
        //return mDropDownAlwaysVisible;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.576 -0400", hash_original_method = "E80B835CA17A4D3E815EC079FA1EE953", hash_generated_method = "2FD8F7EF1EFF864F6CD4306E3D75BDA2")
    public void setSoftInputMode(int mode) {
        addTaint(mode);
        mPopup.setSoftInputMode(mode);
        // ---------- Original Method ----------
        //mPopup.setSoftInputMode(mode);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.576 -0400", hash_original_method = "EF5235E70AE7C9521CFD0F4410B9073C", hash_generated_method = "CE94840FC2120F4556B4D052EBA89732")
    public int getSoftInputMode() {
        int var964404E9EAF1CA05AB3CAF30EE68B324_1352586600 = (mPopup.getSoftInputMode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_433026435 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_433026435;
        // ---------- Original Method ----------
        //return mPopup.getSoftInputMode();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.577 -0400", hash_original_method = "00D6E099D8DC922D12B17B03F893B884", hash_generated_method = "FF67F34E40E9A65B6F576056899652DB")
    public void setListSelector(Drawable selector) {
        mDropDownListHighlight = selector;
        // ---------- Original Method ----------
        //mDropDownListHighlight = selector;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.577 -0400", hash_original_method = "48A20BD7A1656DF8848E524613AD69C1", hash_generated_method = "1DEBE3875A23A154F5291021F0FD9D5D")
    public Drawable getBackground() {
Drawable var7BDA07CC732F6A99E383B1984680564C_1391030963 =         mPopup.getBackground();
        var7BDA07CC732F6A99E383B1984680564C_1391030963.addTaint(taint);
        return var7BDA07CC732F6A99E383B1984680564C_1391030963;
        // ---------- Original Method ----------
        //return mPopup.getBackground();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.577 -0400", hash_original_method = "53EE8E67A046C4A20122C0C008F8CCAA", hash_generated_method = "AF6AA1D78ED766D9CBC696E0057BE10C")
    public void setBackgroundDrawable(Drawable d) {
        addTaint(d.getTaint());
        mPopup.setBackgroundDrawable(d);
        // ---------- Original Method ----------
        //mPopup.setBackgroundDrawable(d);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.577 -0400", hash_original_method = "CF4F09D135A7A5849055A447382D076E", hash_generated_method = "0DCFB58E124A9F127ACBB80FEF5C665B")
    public void setAnimationStyle(int animationStyle) {
        addTaint(animationStyle);
        mPopup.setAnimationStyle(animationStyle);
        // ---------- Original Method ----------
        //mPopup.setAnimationStyle(animationStyle);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.578 -0400", hash_original_method = "A53F654A1BF514C432C9F43DB9ED5E7B", hash_generated_method = "4FD58AA93503F56DA9C89989BE3D1B41")
    public int getAnimationStyle() {
        int var816B0EC48DB4C372BCF76D1AAEC8966A_1037322788 = (mPopup.getAnimationStyle());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_263251455 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_263251455;
        // ---------- Original Method ----------
        //return mPopup.getAnimationStyle();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.578 -0400", hash_original_method = "875C75F19631B214BE64A011FD6A41E4", hash_generated_method = "BD1A8C23DDBDB3815DF711FEC18339B9")
    public View getAnchorView() {
View var0AB2834B220EB17FD3E645A276A93F12_587737865 =         mDropDownAnchorView;
        var0AB2834B220EB17FD3E645A276A93F12_587737865.addTaint(taint);
        return var0AB2834B220EB17FD3E645A276A93F12_587737865;
        // ---------- Original Method ----------
        //return mDropDownAnchorView;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.578 -0400", hash_original_method = "91753F7FEC6E3180927B7B9D55B8E090", hash_generated_method = "63EE2FBCA0AADA3A31B95FC73D9580CE")
    public void setAnchorView(View anchor) {
        mDropDownAnchorView = anchor;
        // ---------- Original Method ----------
        //mDropDownAnchorView = anchor;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.578 -0400", hash_original_method = "2C5F7D64A15BDC64E0A7D1677E996184", hash_generated_method = "DF45F86F3588E23957294BDCBB2C4224")
    public int getHorizontalOffset() {
        int varD7D5E41A0CA1EEEE2C5B6053B9E223EC_601131283 = (mDropDownHorizontalOffset);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1181392809 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1181392809;
        // ---------- Original Method ----------
        //return mDropDownHorizontalOffset;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.579 -0400", hash_original_method = "37914D7AC2B7A80AA5FE528B058A9DBC", hash_generated_method = "C126BA21DD750A9AFE1BD084B715A818")
    public void setHorizontalOffset(int offset) {
        mDropDownHorizontalOffset = offset;
        // ---------- Original Method ----------
        //mDropDownHorizontalOffset = offset;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.579 -0400", hash_original_method = "06BDE5646BE562A7D86252C676418C82", hash_generated_method = "02BD73DED1D6431892E7A6F17110EF17")
    public int getVerticalOffset() {
    if(!mDropDownVerticalOffsetSet)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_705765369 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_870305798 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_870305798;
        } //End block
        int var9A3E0C1905215D1560AFB5329CF32615_270436569 = (mDropDownVerticalOffset);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_278165955 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_278165955;
        // ---------- Original Method ----------
        //if (!mDropDownVerticalOffsetSet) {
            //return 0;
        //}
        //return mDropDownVerticalOffset;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.580 -0400", hash_original_method = "F61671411958DBF85FB58F84EEE162C4", hash_generated_method = "2B910F94073C3EC07961DBEFFADDA58F")
    public void setVerticalOffset(int offset) {
        mDropDownVerticalOffset = offset;
        mDropDownVerticalOffsetSet = true;
        // ---------- Original Method ----------
        //mDropDownVerticalOffset = offset;
        //mDropDownVerticalOffsetSet = true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.580 -0400", hash_original_method = "6205F90E667ADE4444482E9AC195FB48", hash_generated_method = "9253430CB033DF6B314A6F70816B0DEB")
    public int getWidth() {
        int var56AD5481B6A7DF9BE8EA5BE42BC8A2A2_602535535 = (mDropDownWidth);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_653592066 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_653592066;
        // ---------- Original Method ----------
        //return mDropDownWidth;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.580 -0400", hash_original_method = "1FDBBF009B47D57DAE1EE309EAA8DA19", hash_generated_method = "9D744DA174B0219B1092FF60AD2FCB92")
    public void setWidth(int width) {
        mDropDownWidth = width;
        // ---------- Original Method ----------
        //mDropDownWidth = width;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.581 -0400", hash_original_method = "1CC81B1489D8EBDAA358E87EA72284F9", hash_generated_method = "B062CF3F22DF7B6E3FBD05CE3C919E7F")
    public void setContentWidth(int width) {
        Drawable popupBackground = mPopup.getBackground();
    if(popupBackground != null)        
        {
            popupBackground.getPadding(mTempRect);
            mDropDownWidth = mTempRect.left + mTempRect.right + width;
        } //End block
        else
        {
            setWidth(width);
        } //End block
        // ---------- Original Method ----------
        //Drawable popupBackground = mPopup.getBackground();
        //if (popupBackground != null) {
            //popupBackground.getPadding(mTempRect);
            //mDropDownWidth = mTempRect.left + mTempRect.right + width;
        //} else {
            //setWidth(width);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.581 -0400", hash_original_method = "2B0617362C23A2A1F29E0E83641579F9", hash_generated_method = "26C193581D4EA836C34B57DD3EB64683")
    public int getHeight() {
        int var499A6C77C04E8F3C1E288985743EBBD9_1542163232 = (mDropDownHeight);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_981313948 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_981313948;
        // ---------- Original Method ----------
        //return mDropDownHeight;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.581 -0400", hash_original_method = "CAA84DCA25312E828BE740B15493FB25", hash_generated_method = "4DA8EB017D81399AC9FA9C78A28822F1")
    public void setHeight(int height) {
        mDropDownHeight = height;
        // ---------- Original Method ----------
        //mDropDownHeight = height;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.582 -0400", hash_original_method = "500645EE5CDA87E171AAE4D175AC763E", hash_generated_method = "2D5D314BA37B280C0EC1EB015FA6FF32")
    public void setOnItemClickListener(AdapterView.OnItemClickListener clickListener) {
        mItemClickListener = clickListener;
        // ---------- Original Method ----------
        //mItemClickListener = clickListener;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.582 -0400", hash_original_method = "77C1F384A6316C978289202E5719DEEE", hash_generated_method = "9F10FF9A076A5EE31B9093767F0F184A")
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener selectedListener) {
        mItemSelectedListener = selectedListener;
        // ---------- Original Method ----------
        //mItemSelectedListener = selectedListener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.583 -0400", hash_original_method = "F870D6C36930B52993EA962C5CEE4741", hash_generated_method = "D624D413BB2A631ED403F1ED0B6B8FE2")
    public void setPromptView(View prompt) {
        boolean showing = isShowing();
    if(showing)        
        {
            removePromptView();
        } //End block
        mPromptView = prompt;
    if(showing)        
        {
            show();
        } //End block
        // ---------- Original Method ----------
        //boolean showing = isShowing();
        //if (showing) {
            //removePromptView();
        //}
        //mPromptView = prompt;
        //if (showing) {
            //show();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.583 -0400", hash_original_method = "6F8BB8AB5CFBCAF655CCF7F8C4D42CCD", hash_generated_method = "12A7B7B2D0ABC916C160864A366BF13A")
    public void postShow() {
        mHandler.post(mShowDropDownRunnable);
        // ---------- Original Method ----------
        //mHandler.post(mShowDropDownRunnable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.586 -0400", hash_original_method = "B0532D10D967B708828191A62293AA30", hash_generated_method = "9561E37C144618A91CB5D590D08F845B")
    public void show() {
        int height = buildDropDown();
        int widthSpec = 0;
        int heightSpec = 0;
        boolean noInputMethod = isInputMethodNotNeeded();
        mPopup.setAllowScrollingAnchorParent(!noInputMethod);
    if(mPopup.isShowing())        
        {
    if(mDropDownWidth == ViewGroup.LayoutParams.MATCH_PARENT)            
            {
                widthSpec = -1;
            } //End block
            else
    if(mDropDownWidth == ViewGroup.LayoutParams.WRAP_CONTENT)            
            {
                widthSpec = getAnchorView().getWidth();
            } //End block
            else
            {
                widthSpec = mDropDownWidth;
            } //End block
    if(mDropDownHeight == ViewGroup.LayoutParams.MATCH_PARENT)            
            {
                heightSpec = noInputMethod ? height : ViewGroup.LayoutParams.MATCH_PARENT;
    if(noInputMethod)                
                {
                    mPopup.setWindowLayoutMode(
                            mDropDownWidth == ViewGroup.LayoutParams.MATCH_PARENT ?
                                    ViewGroup.LayoutParams.MATCH_PARENT : 0, 0);
                } //End block
                else
                {
                    mPopup.setWindowLayoutMode(
                            mDropDownWidth == ViewGroup.LayoutParams.MATCH_PARENT ?
                                    ViewGroup.LayoutParams.MATCH_PARENT : 0,
                            ViewGroup.LayoutParams.MATCH_PARENT);
                } //End block
            } //End block
            else
    if(mDropDownHeight == ViewGroup.LayoutParams.WRAP_CONTENT)            
            {
                heightSpec = height;
            } //End block
            else
            {
                heightSpec = mDropDownHeight;
            } //End block
            mPopup.setOutsideTouchable(!mForceIgnoreOutsideTouch && !mDropDownAlwaysVisible);
            mPopup.update(getAnchorView(), mDropDownHorizontalOffset,
                    mDropDownVerticalOffset, widthSpec, heightSpec);
        } //End block
        else
        {
    if(mDropDownWidth == ViewGroup.LayoutParams.MATCH_PARENT)            
            {
                widthSpec = ViewGroup.LayoutParams.MATCH_PARENT;
            } //End block
            else
            {
    if(mDropDownWidth == ViewGroup.LayoutParams.WRAP_CONTENT)                
                {
                    mPopup.setWidth(getAnchorView().getWidth());
                } //End block
                else
                {
                    mPopup.setWidth(mDropDownWidth);
                } //End block
            } //End block
    if(mDropDownHeight == ViewGroup.LayoutParams.MATCH_PARENT)            
            {
                heightSpec = ViewGroup.LayoutParams.MATCH_PARENT;
            } //End block
            else
            {
    if(mDropDownHeight == ViewGroup.LayoutParams.WRAP_CONTENT)                
                {
                    mPopup.setHeight(height);
                } //End block
                else
                {
                    mPopup.setHeight(mDropDownHeight);
                } //End block
            } //End block
            mPopup.setWindowLayoutMode(widthSpec, heightSpec);
            mPopup.setClipToScreenEnabled(true);
            mPopup.setOutsideTouchable(!mForceIgnoreOutsideTouch && !mDropDownAlwaysVisible);
            mPopup.setTouchInterceptor(mTouchInterceptor);
            mPopup.showAsDropDown(getAnchorView(),
                    mDropDownHorizontalOffset, mDropDownVerticalOffset);
            mDropDownList.setSelection(ListView.INVALID_POSITION);
    if(!mModal || mDropDownList.isInTouchMode())            
            {
                clearListSelection();
            } //End block
    if(!mModal)            
            {
                mHandler.post(mHideSelector);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.588 -0400", hash_original_method = "B4B1B4676A26C0E0D07AD81974E2090B", hash_generated_method = "9DC863547F53C27A47992D34B3B95A71")
    public void dismiss() {
        mPopup.dismiss();
        removePromptView();
        mPopup.setContentView(null);
        mDropDownList = null;
        mHandler.removeCallbacks(mResizePopupRunnable);
        // ---------- Original Method ----------
        //mPopup.dismiss();
        //removePromptView();
        //mPopup.setContentView(null);
        //mDropDownList = null;
        //mHandler.removeCallbacks(mResizePopupRunnable);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.588 -0400", hash_original_method = "C7BE29500BF4339E2FDC892E2A139524", hash_generated_method = "3AF4A97BA15B7F497640EC707509DB4A")
    public void setOnDismissListener(PopupWindow.OnDismissListener listener) {
        addTaint(listener.getTaint());
        mPopup.setOnDismissListener(listener);
        // ---------- Original Method ----------
        //mPopup.setOnDismissListener(listener);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.589 -0400", hash_original_method = "202D4492803683737094012DDF6DD86F", hash_generated_method = "E7D37E557811E1F27F4B96C54D2FAFEC")
    private void removePromptView() {
    if(mPromptView != null)        
        {
            final ViewParent parent = mPromptView.getParent();
    if(parent instanceof ViewGroup)            
            {
                final ViewGroup group = (ViewGroup) parent;
                group.removeView(mPromptView);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mPromptView != null) {
            //final ViewParent parent = mPromptView.getParent();
            //if (parent instanceof ViewGroup) {
                //final ViewGroup group = (ViewGroup) parent;
                //group.removeView(mPromptView);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.589 -0400", hash_original_method = "288B7DB6446AD4FA82AB3ACE9506A35B", hash_generated_method = "6B4243715DFEC3599FE3FE90A636D6D2")
    public void setInputMethodMode(int mode) {
        addTaint(mode);
        mPopup.setInputMethodMode(mode);
        // ---------- Original Method ----------
        //mPopup.setInputMethodMode(mode);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.589 -0400", hash_original_method = "341CBB053B214C5E0FB1B54637325DA3", hash_generated_method = "D75B89D01B40CCE85225A5BBC6B8DBB4")
    public int getInputMethodMode() {
        int var5A145EEE78AACF161EAD0CCBA6449D66_1299292769 = (mPopup.getInputMethodMode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2022694994 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2022694994;
        // ---------- Original Method ----------
        //return mPopup.getInputMethodMode();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.590 -0400", hash_original_method = "119CA9359C56E2DDD442B9A05EFE812C", hash_generated_method = "6AD9EB2E181CEEFA2EBBAFD072878336")
    public void setSelection(int position) {
        addTaint(position);
        DropDownListView list = mDropDownList;
    if(isShowing() && list != null)        
        {
            list.mListSelectionHidden = false;
            list.setSelection(position);
    if(list.getChoiceMode() != ListView.CHOICE_MODE_NONE)            
            {
                list.setItemChecked(position, true);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //DropDownListView list = mDropDownList;
        //if (isShowing() && list != null) {
            //list.mListSelectionHidden = false;
            //list.setSelection(position);
            //if (list.getChoiceMode() != ListView.CHOICE_MODE_NONE) {
                //list.setItemChecked(position, true);
            //}
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.591 -0400", hash_original_method = "5E25633D1BEAE372BF50698DAAA66CA7", hash_generated_method = "6F3A6B5295DECA5E206B687D3202D2F6")
    public void clearListSelection() {
        final DropDownListView list = mDropDownList;
    if(list != null)        
        {
            list.mListSelectionHidden = true;
            list.hideSelector();
            list.requestLayout();
        } //End block
        // ---------- Original Method ----------
        //final DropDownListView list = mDropDownList;
        //if (list != null) {
            //list.mListSelectionHidden = true;
            //list.hideSelector();
            //list.requestLayout();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.592 -0400", hash_original_method = "CA9C4C0CD645F38E1AAA797FE00ECFCE", hash_generated_method = "0FC786B315E4235B117CB04056E9C617")
    public boolean isShowing() {
        boolean var85306F04F495AA80A9692FCC104D9D40_1591511933 = (mPopup.isShowing());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1984842095 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1984842095;
        // ---------- Original Method ----------
        //return mPopup.isShowing();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.594 -0400", hash_original_method = "C5EEC00F4CE1C916DAF561B7CF397229", hash_generated_method = "C95C72D3AED6DD464371AEA1FA7DD9CC")
    public boolean isInputMethodNotNeeded() {
        boolean var72A051B02AB9B817782B9C116F4B4AB3_26114793 = (mPopup.getInputMethodMode() == INPUT_METHOD_NOT_NEEDED);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1440274802 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1440274802;
        // ---------- Original Method ----------
        //return mPopup.getInputMethodMode() == INPUT_METHOD_NOT_NEEDED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.596 -0400", hash_original_method = "5D56F9149CAA09C31AB36A31C90B128D", hash_generated_method = "B73E88AD4B4ABD4D3841026C6EFF2394")
    public boolean performItemClick(int position) {
        addTaint(position);
    if(isShowing())        
        {
    if(mItemClickListener != null)            
            {
                final DropDownListView list = mDropDownList;
                final View child = list.getChildAt(position - list.getFirstVisiblePosition());
                final ListAdapter adapter = list.getAdapter();
                mItemClickListener.onItemClick(list, child, position, adapter.getItemId(position));
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_1245234652 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_803053866 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_803053866;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1246273297 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_742295690 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_742295690;
        // ---------- Original Method ----------
        //if (isShowing()) {
            //if (mItemClickListener != null) {
                //final DropDownListView list = mDropDownList;
                //final View child = list.getChildAt(position - list.getFirstVisiblePosition());
                //final ListAdapter adapter = list.getAdapter();
                //mItemClickListener.onItemClick(list, child, position, adapter.getItemId(position));
            //}
            //return true;
        //}
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.597 -0400", hash_original_method = "E481FD4B78A135BB1B6DC4E83167B196", hash_generated_method = "9406A6AF8AA4AF9445C334A1F1EDFBCB")
    public Object getSelectedItem() {
    if(!isShowing())        
        {
Object var540C13E9E156B687226421B24F2DF178_407678023 =             null;
            var540C13E9E156B687226421B24F2DF178_407678023.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_407678023;
        } //End block
Object varBFC298C836B1964BD2B82A432050A888_2023393764 =         mDropDownList.getSelectedItem();
        varBFC298C836B1964BD2B82A432050A888_2023393764.addTaint(taint);
        return varBFC298C836B1964BD2B82A432050A888_2023393764;
        // ---------- Original Method ----------
        //if (!isShowing()) {
            //return null;
        //}
        //return mDropDownList.getSelectedItem();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.598 -0400", hash_original_method = "055DCA84E8C7B3F34F7D7819C2CD5AC3", hash_generated_method = "BBC07D914E229F3E64B32CD02559F1DD")
    public int getSelectedItemPosition() {
    if(!isShowing())        
        {
            int varC8E7BCCECB416A2058499EBEF4359AA2_1273980174 = (ListView.INVALID_POSITION);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1794984924 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1794984924;
        } //End block
        int varD149CDA53C4C6378A76A986ACD9B4D9F_1139270921 = (mDropDownList.getSelectedItemPosition());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1232751145 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1232751145;
        // ---------- Original Method ----------
        //if (!isShowing()) {
            //return ListView.INVALID_POSITION;
        //}
        //return mDropDownList.getSelectedItemPosition();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.599 -0400", hash_original_method = "4492784EC84C61BD8D41E43112FEBCD0", hash_generated_method = "55C18317697095E3CF1EFB878B0D9F06")
    public long getSelectedItemId() {
    if(!isShowing())        
        {
            long var846671D8A4B86FA5CCE80364B710CCB1_991082770 = (ListView.INVALID_ROW_ID);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1986407282 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1986407282;
        } //End block
        long varAAD2853214DF8CD44EB04325A5B4D605_803360771 = (mDropDownList.getSelectedItemId());
                long var0F5264038205EDFB1AC05FBB0E8C5E94_246494287 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_246494287;
        // ---------- Original Method ----------
        //if (!isShowing()) {
            //return ListView.INVALID_ROW_ID;
        //}
        //return mDropDownList.getSelectedItemId();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.599 -0400", hash_original_method = "A94FEEC1ECDAC3555C21CB10FFC68C47", hash_generated_method = "02D567FDAE9B10D41064BAC0322EDAAE")
    public View getSelectedView() {
    if(!isShowing())        
        {
View var540C13E9E156B687226421B24F2DF178_1811690552 =             null;
            var540C13E9E156B687226421B24F2DF178_1811690552.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1811690552;
        } //End block
View varFD47A4584B44CB306821B10C638E0889_30977776 =         mDropDownList.getSelectedView();
        varFD47A4584B44CB306821B10C638E0889_30977776.addTaint(taint);
        return varFD47A4584B44CB306821B10C638E0889_30977776;
        // ---------- Original Method ----------
        //if (!isShowing()) {
            //return null;
        //}
        //return mDropDownList.getSelectedView();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.600 -0400", hash_original_method = "D21142DAF85C899FDAA3783E4BBEC12E", hash_generated_method = "F1DD1E9CEA3304DEC8788C04C82BCA16")
    public ListView getListView() {
ListView var92F502D0F67611E603B0EE7DA4A0DC3B_963953038 =         mDropDownList;
        var92F502D0F67611E603B0EE7DA4A0DC3B_963953038.addTaint(taint);
        return var92F502D0F67611E603B0EE7DA4A0DC3B_963953038;
        // ---------- Original Method ----------
        //return mDropDownList;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.600 -0400", hash_original_method = "21262ED785FC4787FB1F1DE7107BCA92", hash_generated_method = "7D6D8AA3A24EB925896215A339982186")
     void setListItemExpandMax(int max) {
        mListItemExpandMaximum = max;
        // ---------- Original Method ----------
        //mListItemExpandMaximum = max;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.601 -0400", hash_original_method = "D4938DA23F7CC8247819641EDCB20246", hash_generated_method = "960D8567F47D96385C6B79EACFE3FFD3")
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(keyCode);
    if(isShowing())        
        {
    if(keyCode != KeyEvent.KEYCODE_SPACE
                    && (mDropDownList.getSelectedItemPosition() >= 0
                            || (keyCode != KeyEvent.KEYCODE_ENTER
                                    && keyCode != KeyEvent.KEYCODE_DPAD_CENTER)))            
            {
                int curIndex = mDropDownList.getSelectedItemPosition();
                boolean consumed;
                final boolean below = !mPopup.isAboveAnchor();
                final ListAdapter adapter = mAdapter;
                boolean allEnabled;
                int firstItem = Integer.MAX_VALUE;
                int lastItem = Integer.MIN_VALUE;
    if(adapter != null)                
                {
                    allEnabled = adapter.areAllItemsEnabled();
                    firstItem = allEnabled ? 0 :
                            mDropDownList.lookForSelectablePosition(0, true);
                    lastItem = allEnabled ? adapter.getCount() - 1 :
                            mDropDownList.lookForSelectablePosition(adapter.getCount() - 1, false);
                } //End block
    if((below && keyCode == KeyEvent.KEYCODE_DPAD_UP && curIndex <= firstItem) ||
                        (!below && keyCode == KeyEvent.KEYCODE_DPAD_DOWN && curIndex >= lastItem))                
                {
                    clearListSelection();
                    mPopup.setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED);
                    show();
                    boolean varB326B5062B2F0E69046810717534CB09_1399865009 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1771145764 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1771145764;
                } //End block
                else
                {
                    mDropDownList.mListSelectionHidden = false;
                } //End block
                consumed = mDropDownList.onKeyDown(keyCode, event);
    if(DEBUG){ }    if(consumed)                
                {
                    mPopup.setInputMethodMode(PopupWindow.INPUT_METHOD_NOT_NEEDED);
                    mDropDownList.requestFocusFromTouch();
                    show();
switch(keyCode){
                    case KeyEvent.KEYCODE_ENTER:
                    case KeyEvent.KEYCODE_DPAD_CENTER:
                    case KeyEvent.KEYCODE_DPAD_DOWN:
                    case KeyEvent.KEYCODE_DPAD_UP:
                    boolean varB326B5062B2F0E69046810717534CB09_922595695 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_145009747 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_145009747;
}
                } //End block
                else
                {
    if(below && keyCode == KeyEvent.KEYCODE_DPAD_DOWN)                    
                    {
    if(curIndex == lastItem)                        
                        {
                            boolean varB326B5062B2F0E69046810717534CB09_1294072390 = (true);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_584659009 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_584659009;
                        } //End block
                    } //End block
                    else
    if(!below && keyCode == KeyEvent.KEYCODE_DPAD_UP &&
                            curIndex == firstItem)                    
                    {
                        boolean varB326B5062B2F0E69046810717534CB09_733127225 = (true);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1417013129 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1417013129;
                    } //End block
                } //End block
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1946214076 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_271449685 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_271449685;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.603 -0400", hash_original_method = "CD01E8977B386E95EB43DA8A15EDF875", hash_generated_method = "33DC8BB6316889179B55CDEB1A4582D1")
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(keyCode);
    if(isShowing() && mDropDownList.getSelectedItemPosition() >= 0)        
        {
            boolean consumed = mDropDownList.onKeyUp(keyCode, event);
    if(consumed)            
            {
switch(keyCode){
                case KeyEvent.KEYCODE_ENTER:
                case KeyEvent.KEYCODE_DPAD_CENTER:
                dismiss();
                break;
}
            } //End block
            boolean var48FE8558CE14C4C865198444C538ECC5_1819058186 = (consumed);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1820338588 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1820338588;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1421314998 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_821923813 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_821923813;
        // ---------- Original Method ----------
        //if (isShowing() && mDropDownList.getSelectedItemPosition() >= 0) {
            //boolean consumed = mDropDownList.onKeyUp(keyCode, event);
            //if (consumed) {
                //switch (keyCode) {
                    //case KeyEvent.KEYCODE_ENTER:
                    //case KeyEvent.KEYCODE_DPAD_CENTER:
                        //dismiss();
                        //break;
                //}
            //}
            //return consumed;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.604 -0400", hash_original_method = "5D81C652E72C1CAFD12E9CC95CD171E7", hash_generated_method = "7BE8962CDF3C98380BA55523E6A649B1")
    public boolean onKeyPreIme(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(keyCode);
    if(keyCode == KeyEvent.KEYCODE_BACK && isShowing())        
        {
            final View anchorView = mDropDownAnchorView;
    if(event.getAction() == KeyEvent.ACTION_DOWN && event.getRepeatCount() == 0)            
            {
                KeyEvent.DispatcherState state = anchorView.getKeyDispatcherState();
    if(state != null)                
                {
                    state.startTracking(event, this);
                } //End block
                boolean varB326B5062B2F0E69046810717534CB09_457575278 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_297985952 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_297985952;
            } //End block
            else
    if(event.getAction() == KeyEvent.ACTION_UP)            
            {
                KeyEvent.DispatcherState state = anchorView.getKeyDispatcherState();
    if(state != null)                
                {
                    state.handleUpEvent(event);
                } //End block
    if(event.isTracking() && !event.isCanceled())                
                {
                    dismiss();
                    boolean varB326B5062B2F0E69046810717534CB09_171852208 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_178825025 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_178825025;
                } //End block
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1023194908 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_646536270 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_646536270;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.608 -0400", hash_original_method = "F5C740553BB47CFEBEC052FD2A1DEFBA", hash_generated_method = "6DCA1F5492EE763B2304E398399FF7B8")
    private int buildDropDown() {
        ViewGroup dropDownView;
        int otherHeights = 0;
    if(mDropDownList == null)        
        {
            Context context = mContext;
            mShowDropDownRunnable = new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.606 -0400", hash_original_method = "CEA8CEF9AA7B34E441550DF384140083", hash_generated_method = "865BB501FB55236CD8DAD0675D4AAE97")
        public void run() {
            View view = getAnchorView();
    if(view != null && view.getWindowToken() != null)            
            {
                show();
            } //End block
            // ---------- Original Method ----------
            //View view = getAnchorView();
            //if (view != null && view.getWindowToken() != null) {
                        //show();
                    //}
        }
};
            mDropDownList = new DropDownListView(context, !mModal);
    if(mDropDownListHighlight != null)            
            {
                mDropDownList.setSelector(mDropDownListHighlight);
            } //End block
            mDropDownList.setAdapter(mAdapter);
            mDropDownList.setOnItemClickListener(mItemClickListener);
            mDropDownList.setFocusable(true);
            mDropDownList.setFocusableInTouchMode(true);
            mDropDownList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.607 -0400", hash_original_method = "A3D9BDCD43F35F92A348E2938D25FA58", hash_generated_method = "74226FB73AB9EEEF38DBB48E2D25743C")
        public void onItemSelected(AdapterView<?> parent, View view,
                        int position, long id) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(id);
            addTaint(position);
            addTaint(view.getTaint());
            addTaint(parent.getTaint());
    if(position != -1)            
            {
                DropDownListView dropDownList = mDropDownList;
    if(dropDownList != null)                
                {
                    dropDownList.mListSelectionHidden = false;
                } //End block
            } //End block
            // ---------- Original Method ----------
            //if (position != -1) {
                        //DropDownListView dropDownList = mDropDownList;
                        //if (dropDownList != null) {
                            //dropDownList.mListSelectionHidden = false;
                        //}
                    //}
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.607 -0400", hash_original_method = "ABAE53FB2582432DFD925A1EB74EEC53", hash_generated_method = "12A103C6C860E1CA8C576C5166DA4783")
        public void onNothingSelected(AdapterView<?> parent) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(parent.getTaint());
            // ---------- Original Method ----------
        }
});
            mDropDownList.setOnScrollListener(mScrollListener);
    if(mItemSelectedListener != null)            
            {
                mDropDownList.setOnItemSelectedListener(mItemSelectedListener);
            } //End block
            dropDownView = mDropDownList;
            View hintView = mPromptView;
    if(hintView != null)            
            {
                LinearLayout hintContainer = new LinearLayout(context);
                hintContainer.setOrientation(LinearLayout.VERTICAL);
                LinearLayout.LayoutParams hintParams = new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, 0, 1.0f
                );
switch(mPromptPosition){
                case POSITION_PROMPT_BELOW:
                hintContainer.addView(dropDownView, hintParams);
                hintContainer.addView(hintView);
                break;
                case POSITION_PROMPT_ABOVE:
                hintContainer.addView(hintView);
                hintContainer.addView(dropDownView, hintParams);
                break;
                default:
                break;
}                int widthSpec = MeasureSpec.makeMeasureSpec(mDropDownWidth, MeasureSpec.AT_MOST);
                int heightSpec = MeasureSpec.UNSPECIFIED;
                hintView.measure(widthSpec, heightSpec);
                hintParams = (LinearLayout.LayoutParams) hintView.getLayoutParams();
                otherHeights = hintView.getMeasuredHeight() + hintParams.topMargin
                        + hintParams.bottomMargin;
                dropDownView = hintContainer;
            } //End block
            mPopup.setContentView(dropDownView);
        } //End block
        else
        {
            dropDownView = (ViewGroup) mPopup.getContentView();
            final View view = mPromptView;
    if(view != null)            
            {
                LinearLayout.LayoutParams hintParams = (LinearLayout.LayoutParams) view.getLayoutParams();
                otherHeights = view.getMeasuredHeight() + hintParams.topMargin
                        + hintParams.bottomMargin;
            } //End block
        } //End block
        int padding = 0;
        Drawable background = mPopup.getBackground();
    if(background != null)        
        {
            background.getPadding(mTempRect);
            padding = mTempRect.top + mTempRect.bottom;
    if(!mDropDownVerticalOffsetSet)            
            {
                mDropDownVerticalOffset = -mTempRect.top;
            } //End block
        } //End block
        boolean ignoreBottomDecorations = mPopup.getInputMethodMode() == PopupWindow.INPUT_METHOD_NOT_NEEDED;
        final int maxHeight = mPopup.getMaxAvailableHeight(
                getAnchorView(), mDropDownVerticalOffset, ignoreBottomDecorations);
    if(mDropDownAlwaysVisible || mDropDownHeight == ViewGroup.LayoutParams.MATCH_PARENT)        
        {
            int var16E8D192DC05F014B65DD9ACA2DA23F9_1491184462 = (maxHeight + padding);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1500982763 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1500982763;
        } //End block
        final int listContent = mDropDownList.measureHeightOfChildren(MeasureSpec.UNSPECIFIED,
                0, ListView.NO_POSITION, maxHeight - otherHeights, -1);
    if(listContent > 0)        
        otherHeights += padding;
        int var62740D805AEE83AFF5A185B2395270D8_157736309 = (listContent + otherHeights);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1098641296 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1098641296;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private static class DropDownListView extends ListView {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.609 -0400", hash_original_field = "E0414B5920D6C693B394C4CB80A1503E", hash_generated_field = "3F3C05952474F71A545A45E3C3CCA4F6")

        private boolean mListSelectionHidden;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.609 -0400", hash_original_field = "A1134304A98C0563BC9A1734CC3114E9", hash_generated_field = "527E1B04AF4AD8C6C618A0336B748CF0")

        private boolean mHijackFocus;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.610 -0400", hash_original_method = "BBC42F17FDBB7B5F7851EFDC7F6F1B4C", hash_generated_method = "9C5D886DB88C15A579FD9405B4368B51")
        public  DropDownListView(Context context, boolean hijackFocus) {
            super(context, null, com.android.internal.R.attr.dropDownListViewStyle);
            addTaint(context.getTaint());
            mHijackFocus = hijackFocus;
            setCacheColorHint(0);
            // ---------- Original Method ----------
            //mHijackFocus = hijackFocus;
            //setCacheColorHint(0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.610 -0400", hash_original_method = "3F1E6A7533EB0FC6DBDDA209BB95D590", hash_generated_method = "B693C075C835CF75AFAAFCF7346F0B25")
        @Override
         View obtainView(int position, boolean[] isScrap) {
            addTaint(isScrap[0]);
            addTaint(position);
            View view = super.obtainView(position, isScrap);
    if(view instanceof TextView)            
            {
                ((TextView) view).setHorizontallyScrolling(true);
            } //End block
View var057D265746AE9672AFE5F9FF6338071D_624483759 =             view;
            var057D265746AE9672AFE5F9FF6338071D_624483759.addTaint(taint);
            return var057D265746AE9672AFE5F9FF6338071D_624483759;
            // ---------- Original Method ----------
            //View view = super.obtainView(position, isScrap);
            //if (view instanceof TextView) {
                //((TextView) view).setHorizontallyScrolling(true);
            //}
            //return view;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.610 -0400", hash_original_method = "4691130934AB8C0281F78748C377FD01", hash_generated_method = "608BC013E5B215C524F1B15116E2EFC8")
        @Override
        public boolean isInTouchMode() {
            boolean var9A6A904ACA238B53C94445664DEC9B40_2080283747 = ((mHijackFocus && mListSelectionHidden) || super.isInTouchMode());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_986368368 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_986368368;
            // ---------- Original Method ----------
            //return (mHijackFocus && mListSelectionHidden) || super.isInTouchMode();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.611 -0400", hash_original_method = "561EA8BFAB26A78C0A50D34CA2B435FA", hash_generated_method = "BF1F18741781DDB672829CBE60677F19")
        @Override
        public boolean hasWindowFocus() {
            boolean varE188AF81DE2DB57394893F6192A3A574_1756887678 = (mHijackFocus || super.hasWindowFocus());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_120754572 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_120754572;
            // ---------- Original Method ----------
            //return mHijackFocus || super.hasWindowFocus();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.611 -0400", hash_original_method = "C2BF4E069A702887BC745C139DC71739", hash_generated_method = "A2D62FCAE556B303E36926455F04CEFE")
        @Override
        public boolean isFocused() {
            boolean varE683E8433F8213EA96763C9DB60A49AE_68739785 = (mHijackFocus || super.isFocused());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1187831912 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1187831912;
            // ---------- Original Method ----------
            //return mHijackFocus || super.isFocused();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.611 -0400", hash_original_method = "1102992DDCFDFABDAA31FDFA580154D8", hash_generated_method = "18401ECB2975B6E9DC8722531906C476")
        @Override
        public boolean hasFocus() {
            boolean var0555C256E13B08F236D25775D5B707A5_641505642 = (mHijackFocus || super.hasFocus());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1085357016 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1085357016;
            // ---------- Original Method ----------
            //return mHijackFocus || super.hasFocus();
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.611 -0400", hash_original_field = "735D9F3E915D51AB1338FB552E49756B", hash_generated_field = "23928DA4DE83E1135FB8A9793C3625F7")

        private static final String TAG = ListPopupWindow.TAG + ".DropDownListView";
    }


    
    private class PopupDataSetObserver extends DataSetObserver {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.611 -0400", hash_original_method = "2B87497157622859499FF49FBED7C822", hash_generated_method = "2B87497157622859499FF49FBED7C822")
        public PopupDataSetObserver ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.612 -0400", hash_original_method = "6E4DA5A5D077D6C0AA24FD2BF6BDF53A", hash_generated_method = "7456C947FFBE552E1D6E82B11D3D8B56")
        @Override
        public void onChanged() {
            //DSFIXME:  CODE0009: Possible callback target function detected
    if(isShowing())            
            {
                show();
            } //End block
            // ---------- Original Method ----------
            //if (isShowing()) {
                //show();
            //}
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.612 -0400", hash_original_method = "BEB5883597D4F7E6EC69D5E4B00F4808", hash_generated_method = "77ED6FEC41ABFE0FF7B87CF1F8DE3B8B")
        @Override
        public void onInvalidated() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dismiss();
            // ---------- Original Method ----------
            //dismiss();
        }

        
    }


    
    private class ListSelectorHider implements Runnable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.612 -0400", hash_original_method = "850B001590E034AECBB57C89D4E5B01F", hash_generated_method = "850B001590E034AECBB57C89D4E5B01F")
        public ListSelectorHider ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.612 -0400", hash_original_method = "9AD729468BC88951DC9B447B72E180D0", hash_generated_method = "33F921B8E266BA77FD9A621DF2DFDB10")
        public void run() {
            clearListSelection();
            // ---------- Original Method ----------
            //clearListSelection();
        }

        
    }


    
    private class ResizePopupRunnable implements Runnable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.613 -0400", hash_original_method = "3BE1DF808B5AE0104DCA795D143316E5", hash_generated_method = "3BE1DF808B5AE0104DCA795D143316E5")
        public ResizePopupRunnable ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.613 -0400", hash_original_method = "A0D6625363C0412112380631C620D963", hash_generated_method = "E5AD7BD2D568181CEDE615E1BBA0D397")
        public void run() {
    if(mDropDownList != null && mDropDownList.getCount() > mDropDownList.getChildCount() &&
                    mDropDownList.getChildCount() <= mListItemExpandMaximum)            
            {
                mPopup.setInputMethodMode(PopupWindow.INPUT_METHOD_NOT_NEEDED);
                show();
            } //End block
            // ---------- Original Method ----------
            //if (mDropDownList != null && mDropDownList.getCount() > mDropDownList.getChildCount() &&
                    //mDropDownList.getChildCount() <= mListItemExpandMaximum) {
                //mPopup.setInputMethodMode(PopupWindow.INPUT_METHOD_NOT_NEEDED);
                //show();
            //}
        }

        
    }


    
    private class PopupTouchInterceptor implements OnTouchListener {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.613 -0400", hash_original_method = "EC3EA52176E4094388A66835C5736568", hash_generated_method = "EC3EA52176E4094388A66835C5736568")
        public PopupTouchInterceptor ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.614 -0400", hash_original_method = "6DB51D562B35DA9065539F31B98AD12D", hash_generated_method = "BBA39650591E97DAF1BB655EB79DC78C")
        public boolean onTouch(View v, MotionEvent event) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(event.getTaint());
            addTaint(v.getTaint());
            final int action = event.getAction();
            final int x = (int) event.getX();
            final int y = (int) event.getY();
    if(action == MotionEvent.ACTION_DOWN &&
                    mPopup != null && mPopup.isShowing() &&
                    (x >= 0 && x < mPopup.getWidth() && y >= 0 && y < mPopup.getHeight()))            
            {
                mHandler.postDelayed(mResizePopupRunnable, EXPAND_LIST_TIMEOUT);
            } //End block
            else
    if(action == MotionEvent.ACTION_UP)            
            {
                mHandler.removeCallbacks(mResizePopupRunnable);
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_1143594586 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_462612788 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_462612788;
            // ---------- Original Method ----------
            //final int action = event.getAction();
            //final int x = (int) event.getX();
            //final int y = (int) event.getY();
            //if (action == MotionEvent.ACTION_DOWN &&
                    //mPopup != null && mPopup.isShowing() &&
                    //(x >= 0 && x < mPopup.getWidth() && y >= 0 && y < mPopup.getHeight())) {
                //mHandler.postDelayed(mResizePopupRunnable, EXPAND_LIST_TIMEOUT);
            //} else if (action == MotionEvent.ACTION_UP) {
                //mHandler.removeCallbacks(mResizePopupRunnable);
            //}
            //return false;
        }

        
    }


    
    private class PopupScrollListener implements ListView.OnScrollListener {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.614 -0400", hash_original_method = "F5F35EF888BB5CF4AB79CAB2F875B0A7", hash_generated_method = "F5F35EF888BB5CF4AB79CAB2F875B0A7")
        public PopupScrollListener ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.615 -0400", hash_original_method = "6B5691236DBDB14CA060F218338C51C6", hash_generated_method = "35BC055BB67FFF42F36C6DE7B71D1A03")
        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount,
                int totalItemCount) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(totalItemCount);
            addTaint(visibleItemCount);
            addTaint(firstVisibleItem);
            addTaint(view.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.616 -0400", hash_original_method = "50D93865D772C2EF3B15BE53BF421FFA", hash_generated_method = "991F51A7E325FC1E45E5672B58928011")
        public void onScrollStateChanged(AbsListView view, int scrollState) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(scrollState);
            addTaint(view.getTaint());
    if(scrollState == SCROLL_STATE_TOUCH_SCROLL &&
                    !isInputMethodNotNeeded() && mPopup.getContentView() != null)            
            {
                mHandler.removeCallbacks(mResizePopupRunnable);
                mResizePopupRunnable.run();
            } //End block
            // ---------- Original Method ----------
            //if (scrollState == SCROLL_STATE_TOUCH_SCROLL &&
                    //!isInputMethodNotNeeded() && mPopup.getContentView() != null) {
                //mHandler.removeCallbacks(mResizePopupRunnable);
                //mResizePopupRunnable.run();
            //}
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.616 -0400", hash_original_field = "FA4B0EF0ADB967172D8AF881D69A7EE4", hash_generated_field = "0887B70F50539FED12873EB1C34B6CEE")

    private static final String TAG = "ListPopupWindow";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.616 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.617 -0400", hash_original_field = "68B838238909FB59ACCFE6BF19B2B1D1", hash_generated_field = "F8D801998654223FA4FA41D41E9F5E7A")

    private static final int EXPAND_LIST_TIMEOUT = 250;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.617 -0400", hash_original_field = "7B4B6CB98FF46E17C95AE7FB67DB235A", hash_generated_field = "513C25DC2079D3E3F448C17AD7E45103")

    public static final int POSITION_PROMPT_ABOVE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.617 -0400", hash_original_field = "5E3D14DE82B660BC80724E775E94D316", hash_generated_field = "0DC2E01EB82FA75DF06F7820DDC407FC")

    public static final int POSITION_PROMPT_BELOW = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.617 -0400", hash_original_field = "5EC7C72B178102C05F771491BC0D99A1", hash_generated_field = "66FD18D4009B660D801EA24128E20B3A")

    public static final int MATCH_PARENT = ViewGroup.LayoutParams.MATCH_PARENT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.617 -0400", hash_original_field = "EEA327AFC1E7F44AF04BCB821C60E1A3", hash_generated_field = "09891BB8998BC15D0579567ED28F8125")

    public static final int WRAP_CONTENT = ViewGroup.LayoutParams.WRAP_CONTENT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.617 -0400", hash_original_field = "8CBFEBDAE91B592B8753E76C2C0664B2", hash_generated_field = "25DC4C7F5035D071A009268061A8DECC")

    public static final int INPUT_METHOD_FROM_FOCUSABLE = PopupWindow.INPUT_METHOD_FROM_FOCUSABLE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.617 -0400", hash_original_field = "464A9898C4B4354000EAA45DF3916F99", hash_generated_field = "BC380AA3102B060D07B4A59A29280852")

    public static final int INPUT_METHOD_NEEDED = PopupWindow.INPUT_METHOD_NEEDED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.617 -0400", hash_original_field = "C9A9B031ECCD576838FE185F697EFC96", hash_generated_field = "B45F005145864928FF3B5CE220951262")

    public static final int INPUT_METHOD_NOT_NEEDED = PopupWindow.INPUT_METHOD_NOT_NEEDED;
}

