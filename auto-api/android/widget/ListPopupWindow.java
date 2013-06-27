package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.910 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.910 -0400", hash_original_field = "E863CEB96C01242A6262A422DC21BA91", hash_generated_field = "DD5B28EB4059D1AC7E72BAEDE50FACDF")

    private PopupWindow mPopup;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.910 -0400", hash_original_field = "59E9F255F2F17EC006AE601269EA8540", hash_generated_field = "90F29768206AB431EA361CD94838716F")

    private ListAdapter mAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.910 -0400", hash_original_field = "4322C05E16B4F2C2D1AB5006F3431B02", hash_generated_field = "680F69659AC661E81526EC1B57AD0760")

    private DropDownListView mDropDownList;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.910 -0400", hash_original_field = "D134F22E4058DC5F7CFE7175F4F7430C", hash_generated_field = "95C5FD2B2227A2419A547D55212619CB")

    private int mDropDownHeight = ViewGroup.LayoutParams.WRAP_CONTENT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.910 -0400", hash_original_field = "4B650C8F2373468D630EB87118B7597E", hash_generated_field = "DE8B8CD76D1AB415FF96E39AF3C5D34E")

    private int mDropDownWidth = ViewGroup.LayoutParams.WRAP_CONTENT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.910 -0400", hash_original_field = "D7D5E41A0CA1EEEE2C5B6053B9E223EC", hash_generated_field = "E0B55CC77CB214A3579F9BF96330095D")

    private int mDropDownHorizontalOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.910 -0400", hash_original_field = "9A3E0C1905215D1560AFB5329CF32615", hash_generated_field = "3B23099D02FB8FF58FFC662868C0BB03")

    private int mDropDownVerticalOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.910 -0400", hash_original_field = "3D416D3AD24A140B66574A53F35D71B5", hash_generated_field = "EF2837EA9E1F32EA5B98F304DCD2B02D")

    private boolean mDropDownVerticalOffsetSet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.910 -0400", hash_original_field = "7F1912418791E473B7718B11A0CB1A0C", hash_generated_field = "A2A88CD1765159B88DD7DB6DD2826AA7")

    private boolean mDropDownAlwaysVisible = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.910 -0400", hash_original_field = "67337D864119F82F72A3E7E7A32EC92E", hash_generated_field = "D1BD29312DE39A83C4D6D5BDC2010A61")

    private boolean mForceIgnoreOutsideTouch = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.910 -0400", hash_original_field = "5510B09AA8FF17E498AD062C90FAC109", hash_generated_field = "B5EDBF08EC87E5E419CCBD4768539463")

    int mListItemExpandMaximum = Integer.MAX_VALUE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.910 -0400", hash_original_field = "9E5EAA17126782F8C703F935360DD7EB", hash_generated_field = "5F49A121459BF7DF82F93F51F66D9AFA")

    private View mPromptView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.910 -0400", hash_original_field = "4884FB6D2D0EBDBDEEE548951A32A380", hash_generated_field = "D0EDBCF4B24F722A68C83DBD4FA7D38D")

    private int mPromptPosition = POSITION_PROMPT_ABOVE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.910 -0400", hash_original_field = "C61FA2E7C36AC7AB9C40A5C4B482DC3A", hash_generated_field = "3BA4BCC5F225A10F755FE4D117871D40")

    private DataSetObserver mObserver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.910 -0400", hash_original_field = "6DF5C0BD5FF25E15FDCEDCD4ECB331FC", hash_generated_field = "0AD13AB5208CE821A0A2BF31AEC73CB4")

    private View mDropDownAnchorView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.911 -0400", hash_original_field = "834760B22D3D31098FFF241394D6BBE1", hash_generated_field = "D7FBC36DD90F3884476AF7A145F7D085")

    private Drawable mDropDownListHighlight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.911 -0400", hash_original_field = "1AE585B9A4195C50494CD4717922829E", hash_generated_field = "91F251C39E992AB6E9A1F97E1DB2D65A")

    private AdapterView.OnItemClickListener mItemClickListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.911 -0400", hash_original_field = "AC663E6C1E4BAD60BFB3B64BE97350A7", hash_generated_field = "B20A14E839638431419A27C6FA2EB183")

    private AdapterView.OnItemSelectedListener mItemSelectedListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.911 -0400", hash_original_field = "7D90B69C280C66541572056B61B44881", hash_generated_field = "D30BFBC7D37BB87848D25B70F40DFB63")

    private ResizePopupRunnable mResizePopupRunnable = new ResizePopupRunnable();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.911 -0400", hash_original_field = "C9722EDCCBF64142855D27EF1F728783", hash_generated_field = "581CA1588A2FD5C07791EE3D8C598C7C")

    private PopupTouchInterceptor mTouchInterceptor = new PopupTouchInterceptor();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.911 -0400", hash_original_field = "681C9FD7FBE6DFAFD31A369FD3AF23EF", hash_generated_field = "FF947642DBEB1E530E52AE692E85EEC7")

    private PopupScrollListener mScrollListener = new PopupScrollListener();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.911 -0400", hash_original_field = "DA8630584E936BC465CBD5DBD2061129", hash_generated_field = "89E1BE5F8AF6DF7D0588D612253EE3EE")

    private ListSelectorHider mHideSelector = new ListSelectorHider();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.911 -0400", hash_original_field = "008C495499355199D0B743FAC72B6D16", hash_generated_field = "61A25C839F09B3FC31C414DE40E67DB5")

    private Runnable mShowDropDownRunnable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.911 -0400", hash_original_field = "6781893E9FA50A9B7103FD3F674E566B", hash_generated_field = "2E60E17486AAEB1A4E1F1878A0354061")

    private Handler mHandler = new Handler();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.911 -0400", hash_original_field = "DF43B278CEE8933271AB3D9F9E312F86", hash_generated_field = "AFFA54D19F07A10EE8847CF76FC95323")

    private Rect mTempRect = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.911 -0400", hash_original_field = "126D90D638B8925B7E67DD1602EB9153", hash_generated_field = "2CBF8E91F49F039C5D23189C3E7CE590")

    private boolean mModal;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.911 -0400", hash_original_method = "EE0C6E46788D5D6F0175B90B5CCF0B4A", hash_generated_method = "A7BDC1A593955EB85983C7550497CC46")
    public  ListPopupWindow(Context context) {
        this(context, null, com.android.internal.R.attr.listPopupWindowStyle, 0);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.912 -0400", hash_original_method = "C9E1E41EEB8F4220F08A0D28BC21C4EB", hash_generated_method = "18B187239D13E4CAE8D3E88BD9F775EF")
    public  ListPopupWindow(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.listPopupWindowStyle, 0);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.912 -0400", hash_original_method = "449FC27C9387B8AAB93C584A7B8B7579", hash_generated_method = "E80FD58555827A6DBB4D558FF46333EB")
    public  ListPopupWindow(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        addTaint(defStyleAttr);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.913 -0400", hash_original_method = "F8B1DB93A85ECDB9C2D2CE8639D222AE", hash_generated_method = "FE5B87D971B39F25483B906D7F81739C")
    public  ListPopupWindow(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        mContext = context;
        mPopup = new PopupWindow(context, attrs, defStyleAttr, defStyleRes);
        mPopup.setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED);
        // ---------- Original Method ----------
        //mContext = context;
        //mPopup = new PopupWindow(context, attrs, defStyleAttr, defStyleRes);
        //mPopup.setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.913 -0400", hash_original_method = "B55D1F7EE07C2CDF60B7B314069C1E48", hash_generated_method = "EDAB9113CCCC22D9A06FD8121B5B6D2C")
    public void setAdapter(ListAdapter adapter) {
        {
            mObserver = new PopupDataSetObserver();
        } //End block
        {
            mAdapter.unregisterDataSetObserver(mObserver);
        } //End block
        mAdapter = adapter;
        {
            adapter.registerDataSetObserver(mObserver);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.913 -0400", hash_original_method = "7CC61A3797371517F86E3D676D22847C", hash_generated_method = "CE87A26F1F31625F1A82E312F687DB1A")
    public void setPromptPosition(int position) {
        mPromptPosition = position;
        // ---------- Original Method ----------
        //mPromptPosition = position;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.922 -0400", hash_original_method = "DF9D97B46096A1E4CCF9033CE8B43A47", hash_generated_method = "0878A3BA79699611AFAE276207931D9A")
    public int getPromptPosition() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_920145148 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_920145148;
        // ---------- Original Method ----------
        //return mPromptPosition;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.923 -0400", hash_original_method = "320A57FA9129485B3F1A01EDA8808ED5", hash_generated_method = "D0A4E10B11955C6EF4D4A7F65C74F2BF")
    public void setModal(boolean modal) {
        mModal = true;
        mPopup.setFocusable(modal);
        addTaint(modal);
        // ---------- Original Method ----------
        //mModal = true;
        //mPopup.setFocusable(modal);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.923 -0400", hash_original_method = "195244B0122E9C532D039816F791192C", hash_generated_method = "C7DF73441F8A8A3EE8558421E7AF89C1")
    public boolean isModal() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1488845301 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1488845301;
        // ---------- Original Method ----------
        //return mModal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.924 -0400", hash_original_method = "B51F6D3B2B582EB2529861E286FFBDAA", hash_generated_method = "C259F7A19612B2ACBFCE0BD237FE9AAB")
    public void setForceIgnoreOutsideTouch(boolean forceIgnoreOutsideTouch) {
        mForceIgnoreOutsideTouch = forceIgnoreOutsideTouch;
        // ---------- Original Method ----------
        //mForceIgnoreOutsideTouch = forceIgnoreOutsideTouch;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.924 -0400", hash_original_method = "0D7558B683A811B4FB459E3A92DCFACB", hash_generated_method = "6C5818E602B53931F3E1B0DBF55A9DBB")
    public void setDropDownAlwaysVisible(boolean dropDownAlwaysVisible) {
        mDropDownAlwaysVisible = dropDownAlwaysVisible;
        // ---------- Original Method ----------
        //mDropDownAlwaysVisible = dropDownAlwaysVisible;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.925 -0400", hash_original_method = "452BC62A357E5A143092E81C66B09D6A", hash_generated_method = "B7B7375B31F0E597F95FDBEAB6986AF7")
    public boolean isDropDownAlwaysVisible() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1258451738 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1258451738;
        // ---------- Original Method ----------
        //return mDropDownAlwaysVisible;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.926 -0400", hash_original_method = "E80B835CA17A4D3E815EC079FA1EE953", hash_generated_method = "8A780C7809C5C55408662AB78E3D6AE7")
    public void setSoftInputMode(int mode) {
        mPopup.setSoftInputMode(mode);
        addTaint(mode);
        // ---------- Original Method ----------
        //mPopup.setSoftInputMode(mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.926 -0400", hash_original_method = "EF5235E70AE7C9521CFD0F4410B9073C", hash_generated_method = "CB33AB16BDC3F94101F5E81E1DB17A65")
    public int getSoftInputMode() {
        int var33219CA59686C86DFE930490FC0C5D79_279789903 = (mPopup.getSoftInputMode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_11930218 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_11930218;
        // ---------- Original Method ----------
        //return mPopup.getSoftInputMode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.926 -0400", hash_original_method = "00D6E099D8DC922D12B17B03F893B884", hash_generated_method = "FF67F34E40E9A65B6F576056899652DB")
    public void setListSelector(Drawable selector) {
        mDropDownListHighlight = selector;
        // ---------- Original Method ----------
        //mDropDownListHighlight = selector;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.927 -0400", hash_original_method = "48A20BD7A1656DF8848E524613AD69C1", hash_generated_method = "39A57B26DBEEEBCF4C8C3906A428954F")
    public Drawable getBackground() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_524995318 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_524995318 = mPopup.getBackground();
        varB4EAC82CA7396A68D541C85D26508E83_524995318.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_524995318;
        // ---------- Original Method ----------
        //return mPopup.getBackground();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.941 -0400", hash_original_method = "53EE8E67A046C4A20122C0C008F8CCAA", hash_generated_method = "BD70D3B0AFF0C8D7DB54CAD63485854E")
    public void setBackgroundDrawable(Drawable d) {
        mPopup.setBackgroundDrawable(d);
        addTaint(d.getTaint());
        // ---------- Original Method ----------
        //mPopup.setBackgroundDrawable(d);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.941 -0400", hash_original_method = "CF4F09D135A7A5849055A447382D076E", hash_generated_method = "1F08BBCFEFAD3E761FCB230941BBB65B")
    public void setAnimationStyle(int animationStyle) {
        mPopup.setAnimationStyle(animationStyle);
        addTaint(animationStyle);
        // ---------- Original Method ----------
        //mPopup.setAnimationStyle(animationStyle);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.942 -0400", hash_original_method = "A53F654A1BF514C432C9F43DB9ED5E7B", hash_generated_method = "6AFC69E40D02B61B4FD270E038DB7065")
    public int getAnimationStyle() {
        int varFF59793919A82B1D3C72ECF85DD5BB92_665390405 = (mPopup.getAnimationStyle());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1737378861 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1737378861;
        // ---------- Original Method ----------
        //return mPopup.getAnimationStyle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.942 -0400", hash_original_method = "875C75F19631B214BE64A011FD6A41E4", hash_generated_method = "0A4BDB48E5054326E1CD625BDC877657")
    public View getAnchorView() {
        View varB4EAC82CA7396A68D541C85D26508E83_1283262503 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1283262503 = mDropDownAnchorView;
        varB4EAC82CA7396A68D541C85D26508E83_1283262503.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1283262503;
        // ---------- Original Method ----------
        //return mDropDownAnchorView;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.942 -0400", hash_original_method = "91753F7FEC6E3180927B7B9D55B8E090", hash_generated_method = "63EE2FBCA0AADA3A31B95FC73D9580CE")
    public void setAnchorView(View anchor) {
        mDropDownAnchorView = anchor;
        // ---------- Original Method ----------
        //mDropDownAnchorView = anchor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.943 -0400", hash_original_method = "2C5F7D64A15BDC64E0A7D1677E996184", hash_generated_method = "A17E1968FAB625DB14ECB49A428EFCEB")
    public int getHorizontalOffset() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2078837746 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2078837746;
        // ---------- Original Method ----------
        //return mDropDownHorizontalOffset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.943 -0400", hash_original_method = "37914D7AC2B7A80AA5FE528B058A9DBC", hash_generated_method = "C126BA21DD750A9AFE1BD084B715A818")
    public void setHorizontalOffset(int offset) {
        mDropDownHorizontalOffset = offset;
        // ---------- Original Method ----------
        //mDropDownHorizontalOffset = offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.943 -0400", hash_original_method = "06BDE5646BE562A7D86252C676418C82", hash_generated_method = "201F1053F66D3F66D04F3E04E36DAB58")
    public int getVerticalOffset() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_506566963 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_506566963;
        // ---------- Original Method ----------
        //if (!mDropDownVerticalOffsetSet) {
            //return 0;
        //}
        //return mDropDownVerticalOffset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.944 -0400", hash_original_method = "F61671411958DBF85FB58F84EEE162C4", hash_generated_method = "2B910F94073C3EC07961DBEFFADDA58F")
    public void setVerticalOffset(int offset) {
        mDropDownVerticalOffset = offset;
        mDropDownVerticalOffsetSet = true;
        // ---------- Original Method ----------
        //mDropDownVerticalOffset = offset;
        //mDropDownVerticalOffsetSet = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.944 -0400", hash_original_method = "6205F90E667ADE4444482E9AC195FB48", hash_generated_method = "7C5A580594ECA04161DACE808B3A59F1")
    public int getWidth() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_646798144 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_646798144;
        // ---------- Original Method ----------
        //return mDropDownWidth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.944 -0400", hash_original_method = "1FDBBF009B47D57DAE1EE309EAA8DA19", hash_generated_method = "9D744DA174B0219B1092FF60AD2FCB92")
    public void setWidth(int width) {
        mDropDownWidth = width;
        // ---------- Original Method ----------
        //mDropDownWidth = width;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.945 -0400", hash_original_method = "1CC81B1489D8EBDAA358E87EA72284F9", hash_generated_method = "D8F2A9A166B03FC4CF67E68184EA0457")
    public void setContentWidth(int width) {
        Drawable popupBackground;
        popupBackground = mPopup.getBackground();
        {
            popupBackground.getPadding(mTempRect);
            mDropDownWidth = mTempRect.left + mTempRect.right + width;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.956 -0400", hash_original_method = "2B0617362C23A2A1F29E0E83641579F9", hash_generated_method = "17C5B31113C64ADF8C9D016E38F12119")
    public int getHeight() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1249154917 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1249154917;
        // ---------- Original Method ----------
        //return mDropDownHeight;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.956 -0400", hash_original_method = "CAA84DCA25312E828BE740B15493FB25", hash_generated_method = "4DA8EB017D81399AC9FA9C78A28822F1")
    public void setHeight(int height) {
        mDropDownHeight = height;
        // ---------- Original Method ----------
        //mDropDownHeight = height;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.957 -0400", hash_original_method = "500645EE5CDA87E171AAE4D175AC763E", hash_generated_method = "2D5D314BA37B280C0EC1EB015FA6FF32")
    public void setOnItemClickListener(AdapterView.OnItemClickListener clickListener) {
        mItemClickListener = clickListener;
        // ---------- Original Method ----------
        //mItemClickListener = clickListener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.957 -0400", hash_original_method = "77C1F384A6316C978289202E5719DEEE", hash_generated_method = "9F10FF9A076A5EE31B9093767F0F184A")
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener selectedListener) {
        mItemSelectedListener = selectedListener;
        // ---------- Original Method ----------
        //mItemSelectedListener = selectedListener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.957 -0400", hash_original_method = "F870D6C36930B52993EA962C5CEE4741", hash_generated_method = "F18E394AADFED2CBAD3CAB42B1BB0CA9")
    public void setPromptView(View prompt) {
        boolean showing;
        showing = isShowing();
        {
            removePromptView();
        } //End block
        mPromptView = prompt;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.962 -0400", hash_original_method = "6F8BB8AB5CFBCAF655CCF7F8C4D42CCD", hash_generated_method = "12A7B7B2D0ABC916C160864A366BF13A")
    public void postShow() {
        mHandler.post(mShowDropDownRunnable);
        // ---------- Original Method ----------
        //mHandler.post(mShowDropDownRunnable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.963 -0400", hash_original_method = "B0532D10D967B708828191A62293AA30", hash_generated_method = "AD09038629FE977B45B0EDDDEF05920F")
    public void show() {
        int height;
        height = buildDropDown();
        int widthSpec;
        widthSpec = 0;
        int heightSpec;
        heightSpec = 0;
        boolean noInputMethod;
        noInputMethod = isInputMethodNotNeeded();
        mPopup.setAllowScrollingAnchorParent(!noInputMethod);
        {
            boolean var26FEA7C5EC762AEBD619B9EAE248324D_890840807 = (mPopup.isShowing());
            {
                {
                    widthSpec = -1;
                } //End block
                {
                    widthSpec = getAnchorView().getWidth();
                } //End block
                {
                    widthSpec = mDropDownWidth;
                } //End block
                {
                    heightSpec = noInputMethod ? height : ViewGroup.LayoutParams.MATCH_PARENT;
                    {
                        mPopup.setWindowLayoutMode(
                            mDropDownWidth == ViewGroup.LayoutParams.MATCH_PARENT ?
                                    ViewGroup.LayoutParams.MATCH_PARENT : 0, 0);
                    } //End block
                    {
                        mPopup.setWindowLayoutMode(
                            mDropDownWidth == ViewGroup.LayoutParams.MATCH_PARENT ?
                                    ViewGroup.LayoutParams.MATCH_PARENT : 0,
                            ViewGroup.LayoutParams.MATCH_PARENT);
                    } //End block
                } //End block
                {
                    heightSpec = height;
                } //End block
                {
                    heightSpec = mDropDownHeight;
                } //End block
                mPopup.setOutsideTouchable(!mForceIgnoreOutsideTouch && !mDropDownAlwaysVisible);
                mPopup.update(getAnchorView(), mDropDownHorizontalOffset,
                    mDropDownVerticalOffset, widthSpec, heightSpec);
            } //End block
            {
                {
                    widthSpec = ViewGroup.LayoutParams.MATCH_PARENT;
                } //End block
                {
                    {
                        mPopup.setWidth(getAnchorView().getWidth());
                    } //End block
                    {
                        mPopup.setWidth(mDropDownWidth);
                    } //End block
                } //End block
                {
                    heightSpec = ViewGroup.LayoutParams.MATCH_PARENT;
                } //End block
                {
                    {
                        mPopup.setHeight(height);
                    } //End block
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
                {
                    boolean varFBD33AEB1C7B877FCB56A03F8E624BE0_646071693 = (!mModal || mDropDownList.isInTouchMode());
                    {
                        clearListSelection();
                    } //End block
                } //End collapsed parenthetic
                {
                    mHandler.post(mHideSelector);
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.964 -0400", hash_original_method = "B4B1B4676A26C0E0D07AD81974E2090B", hash_generated_method = "9DC863547F53C27A47992D34B3B95A71")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.965 -0400", hash_original_method = "C7BE29500BF4339E2FDC892E2A139524", hash_generated_method = "62B9243C5E27763C5D78A4507C1AE897")
    public void setOnDismissListener(PopupWindow.OnDismissListener listener) {
        mPopup.setOnDismissListener(listener);
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
        //mPopup.setOnDismissListener(listener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.965 -0400", hash_original_method = "202D4492803683737094012DDF6DD86F", hash_generated_method = "B1682D1A5E8AA8C5501D211FDA6B4E2D")
    private void removePromptView() {
        {
            ViewParent parent;
            parent = mPromptView.getParent();
            {
                ViewGroup group;
                group = (ViewGroup) parent;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.965 -0400", hash_original_method = "288B7DB6446AD4FA82AB3ACE9506A35B", hash_generated_method = "7AD2713FA630DB6E27D0A251E2CCE4A4")
    public void setInputMethodMode(int mode) {
        mPopup.setInputMethodMode(mode);
        addTaint(mode);
        // ---------- Original Method ----------
        //mPopup.setInputMethodMode(mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.965 -0400", hash_original_method = "341CBB053B214C5E0FB1B54637325DA3", hash_generated_method = "68298A089DBACECA4DA96ECF208D7AFE")
    public int getInputMethodMode() {
        int varCAD19FC29631D9DEB0E193028B2569D9_1869678799 = (mPopup.getInputMethodMode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1005639564 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1005639564;
        // ---------- Original Method ----------
        //return mPopup.getInputMethodMode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.984 -0400", hash_original_method = "119CA9359C56E2DDD442B9A05EFE812C", hash_generated_method = "C3001F7A6F3FDF3A47D8C2623AA247DF")
    public void setSelection(int position) {
        DropDownListView list;
        list = mDropDownList;
        {
            boolean varE1BD8FEF0D9A15DF839CE93664F6E4FF_91566601 = (isShowing() && list != null);
            {
                list.mListSelectionHidden = false;
                list.setSelection(position);
                {
                    boolean var24E210557EA947C11E8431EB5891287F_1105863327 = (list.getChoiceMode() != ListView.CHOICE_MODE_NONE);
                    {
                        list.setItemChecked(position, true);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(position);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.985 -0400", hash_original_method = "5E25633D1BEAE372BF50698DAAA66CA7", hash_generated_method = "5B75B5FAE8DA730475AB27B8203D5277")
    public void clearListSelection() {
        DropDownListView list;
        list = mDropDownList;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.985 -0400", hash_original_method = "CA9C4C0CD645F38E1AAA797FE00ECFCE", hash_generated_method = "D16E74AE27ADFA71C14FA40D5A4983F7")
    public boolean isShowing() {
        boolean varC4D0BEF5C8B8A88A8F0203AF22B9D645_1515217223 = (mPopup.isShowing());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_883570527 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_883570527;
        // ---------- Original Method ----------
        //return mPopup.isShowing();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.985 -0400", hash_original_method = "C5EEC00F4CE1C916DAF561B7CF397229", hash_generated_method = "D560FC097DE548C40FBAFE50A27CB399")
    public boolean isInputMethodNotNeeded() {
        boolean varCB697D8A9E9B8855A49BA45F9E6E55D8_1209044742 = (mPopup.getInputMethodMode() == INPUT_METHOD_NOT_NEEDED);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1371883047 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1371883047;
        // ---------- Original Method ----------
        //return mPopup.getInputMethodMode() == INPUT_METHOD_NOT_NEEDED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.990 -0400", hash_original_method = "5D56F9149CAA09C31AB36A31C90B128D", hash_generated_method = "4145A6C113CE9C6AF91F2045AEA79DF3")
    public boolean performItemClick(int position) {
        {
            boolean var4A685BA46E35F21FC0CB2BDAFA9CFEA5_764045713 = (isShowing());
            {
                {
                    DropDownListView list;
                    list = mDropDownList;
                    View child;
                    child = list.getChildAt(position - list.getFirstVisiblePosition());
                    ListAdapter adapter;
                    adapter = list.getAdapter();
                    mItemClickListener.onItemClick(list, child, position, adapter.getItemId(position));
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(position);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1119782686 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1119782686;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.991 -0400", hash_original_method = "E481FD4B78A135BB1B6DC4E83167B196", hash_generated_method = "21A143B4855E522AC5181F4BA97D0F96")
    public Object getSelectedItem() {
        Object varB4EAC82CA7396A68D541C85D26508E83_962155282 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_893160857 = null; //Variable for return #2
        {
            boolean var67F0F8A90F47989DCF9FDFD2C3F61D76_1524380127 = (!isShowing());
            {
                varB4EAC82CA7396A68D541C85D26508E83_962155282 = null;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_893160857 = mDropDownList.getSelectedItem();
        Object varA7E53CE21691AB073D9660D615818899_826224404; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_826224404 = varB4EAC82CA7396A68D541C85D26508E83_962155282;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_826224404 = varB4EAC82CA7396A68D541C85D26508E83_893160857;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_826224404.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_826224404;
        // ---------- Original Method ----------
        //if (!isShowing()) {
            //return null;
        //}
        //return mDropDownList.getSelectedItem();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.002 -0400", hash_original_method = "055DCA84E8C7B3F34F7D7819C2CD5AC3", hash_generated_method = "2D9E4C32ED4612400DFD58B31C7E6206")
    public int getSelectedItemPosition() {
        {
            boolean var67F0F8A90F47989DCF9FDFD2C3F61D76_1399213577 = (!isShowing());
        } //End collapsed parenthetic
        int varFFCD2483F75EA19D2EC4EA912FAF68BC_414081733 = (mDropDownList.getSelectedItemPosition());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2026145102 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2026145102;
        // ---------- Original Method ----------
        //if (!isShowing()) {
            //return ListView.INVALID_POSITION;
        //}
        //return mDropDownList.getSelectedItemPosition();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.003 -0400", hash_original_method = "4492784EC84C61BD8D41E43112FEBCD0", hash_generated_method = "AA4415C66EA145DA6444563A176775F0")
    public long getSelectedItemId() {
        {
            boolean var67F0F8A90F47989DCF9FDFD2C3F61D76_948632363 = (!isShowing());
        } //End collapsed parenthetic
        long var831263C88E6FFB9B4AA451205D89724F_1053343066 = (mDropDownList.getSelectedItemId());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_2038757645 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_2038757645;
        // ---------- Original Method ----------
        //if (!isShowing()) {
            //return ListView.INVALID_ROW_ID;
        //}
        //return mDropDownList.getSelectedItemId();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.004 -0400", hash_original_method = "A94FEEC1ECDAC3555C21CB10FFC68C47", hash_generated_method = "2B25E89F6FF00D31EAEC249F6B271585")
    public View getSelectedView() {
        View varB4EAC82CA7396A68D541C85D26508E83_140837498 = null; //Variable for return #1
        View varB4EAC82CA7396A68D541C85D26508E83_1048108805 = null; //Variable for return #2
        {
            boolean var67F0F8A90F47989DCF9FDFD2C3F61D76_484315773 = (!isShowing());
            {
                varB4EAC82CA7396A68D541C85D26508E83_140837498 = null;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1048108805 = mDropDownList.getSelectedView();
        View varA7E53CE21691AB073D9660D615818899_540509043; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_540509043 = varB4EAC82CA7396A68D541C85D26508E83_140837498;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_540509043 = varB4EAC82CA7396A68D541C85D26508E83_1048108805;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_540509043.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_540509043;
        // ---------- Original Method ----------
        //if (!isShowing()) {
            //return null;
        //}
        //return mDropDownList.getSelectedView();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.004 -0400", hash_original_method = "D21142DAF85C899FDAA3783E4BBEC12E", hash_generated_method = "CA66385A437CA742B5B38CE94040B6AE")
    public ListView getListView() {
        ListView varB4EAC82CA7396A68D541C85D26508E83_986353012 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_986353012 = mDropDownList;
        varB4EAC82CA7396A68D541C85D26508E83_986353012.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_986353012;
        // ---------- Original Method ----------
        //return mDropDownList;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.005 -0400", hash_original_method = "21262ED785FC4787FB1F1DE7107BCA92", hash_generated_method = "7D6D8AA3A24EB925896215A339982186")
     void setListItemExpandMax(int max) {
        mListItemExpandMaximum = max;
        // ---------- Original Method ----------
        //mListItemExpandMaximum = max;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.012 -0400", hash_original_method = "D4938DA23F7CC8247819641EDCB20246", hash_generated_method = "BD5CE70AE8D8F6082669D8FF60279C34")
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var4A685BA46E35F21FC0CB2BDAFA9CFEA5_1329242148 = (isShowing());
            {
                {
                    boolean var6B6417BC9ADDCAB4E3C4BC8A5D054B03_1909386320 = (keyCode != KeyEvent.KEYCODE_SPACE
                    && (mDropDownList.getSelectedItemPosition() >= 0
                            || (keyCode != KeyEvent.KEYCODE_ENTER
                                    && keyCode != KeyEvent.KEYCODE_DPAD_CENTER)));
                    {
                        int curIndex;
                        curIndex = mDropDownList.getSelectedItemPosition();
                        boolean consumed;
                        boolean below;
                        below = !mPopup.isAboveAnchor();
                        ListAdapter adapter;
                        adapter = mAdapter;
                        boolean allEnabled;
                        int firstItem;
                        firstItem = Integer.MAX_VALUE;
                        int lastItem;
                        lastItem = Integer.MIN_VALUE;
                        {
                            allEnabled = adapter.areAllItemsEnabled();
                            firstItem = allEnabled ? 0 :
                            mDropDownList.lookForSelectablePosition(0, true);
                            lastItem = allEnabled ? adapter.getCount() - 1 :
                            mDropDownList.lookForSelectablePosition(adapter.getCount() - 1, false);
                        } //End block
                        {
                            clearListSelection();
                            mPopup.setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED);
                            show();
                        } //End block
                        {
                            mDropDownList.mListSelectionHidden = false;
                        } //End block
                        consumed = mDropDownList.onKeyDown(keyCode, event);
                        {
                            mPopup.setInputMethodMode(PopupWindow.INPUT_METHOD_NOT_NEEDED);
                            mDropDownList.requestFocusFromTouch();
                            show();
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_376389658 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_376389658;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.013 -0400", hash_original_method = "CD01E8977B386E95EB43DA8A15EDF875", hash_generated_method = "E4124C187A5738A93FDF8471A678ED83")
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var94A367403F58644D7C7080281BCAEB6B_1414507103 = (isShowing() && mDropDownList.getSelectedItemPosition() >= 0);
            {
                boolean consumed;
                consumed = mDropDownList.onKeyUp(keyCode, event);
                {
                    //Begin case KeyEvent.KEYCODE_ENTER KeyEvent.KEYCODE_DPAD_CENTER 
                    dismiss();
                    //End case KeyEvent.KEYCODE_ENTER KeyEvent.KEYCODE_DPAD_CENTER 
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_550761991 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_550761991;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.024 -0400", hash_original_method = "5D81C652E72C1CAFD12E9CC95CD171E7", hash_generated_method = "D64BAFCD9A047C976E18A82C1BD41CDD")
    public boolean onKeyPreIme(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var405C80F78320ACCD1F0C2596742EF82D_492685495 = (keyCode == KeyEvent.KEYCODE_BACK && isShowing());
            {
                View anchorView;
                anchorView = mDropDownAnchorView;
                {
                    boolean var51947D54DEEA690F1B41A17DE6323711_203837712 = (event.getAction() == KeyEvent.ACTION_DOWN && event.getRepeatCount() == 0);
                    {
                        KeyEvent.DispatcherState state;
                        state = anchorView.getKeyDispatcherState();
                        {
                            state.startTracking(event, this);
                        } //End block
                    } //End block
                    {
                        boolean varA6D964A9D1A4D1D485BD8D60F2BFCDEE_260811538 = (event.getAction() == KeyEvent.ACTION_UP);
                        {
                            KeyEvent.DispatcherState state;
                            state = anchorView.getKeyDispatcherState();
                            {
                                state.handleUpEvent(event);
                            } //End block
                            {
                                boolean varBE09C907F92D135687297C67489D82A5_1960540990 = (event.isTracking() && !event.isCanceled());
                                {
                                    dismiss();
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1753953194 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1753953194;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.043 -0400", hash_original_method = "F5C740553BB47CFEBEC052FD2A1DEFBA", hash_generated_method = "883A1C4B18969E285A374ECB0C9ECC24")
    private int buildDropDown() {
        ViewGroup dropDownView;
        int otherHeights;
        otherHeights = 0;
        {
            Context context;
            context = mContext;
            mShowDropDownRunnable = new Runnable() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.040 -0400", hash_original_method = "CEA8CEF9AA7B34E441550DF384140083", hash_generated_method = "F8487C6129AA3E99E58B1867A33B76AA")
                public void run() {
                    View view;
                    view = getAnchorView();
                    {
                        boolean varB5043B80B6F8EE24E2CA3965BAE7CC2D_196410221 = (view != null && view.getWindowToken() != null);
                        {
                            show();
                        } //End block
                    } //End collapsed parenthetic
                    // ---------- Original Method ----------
                    //View view = getAnchorView();
                    //if (view != null && view.getWindowToken() != null) {
                        //show();
                    //}
                }
};
            mDropDownList = new DropDownListView(context, !mModal);
            {
                mDropDownList.setSelector(mDropDownListHighlight);
            } //End block
            mDropDownList.setAdapter(mAdapter);
            mDropDownList.setOnItemClickListener(mItemClickListener);
            mDropDownList.setFocusable(true);
            mDropDownList.setFocusableInTouchMode(true);
            mDropDownList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.040 -0400", hash_original_method = "A3D9BDCD43F35F92A348E2938D25FA58", hash_generated_method = "8E974429B925D1589C5CC95F07AC25E9")
                public void onItemSelected(AdapterView<?> parent, View view,
                        int position, long id) {
                    //DSFIXME:  CODE0009: Possible callback target function detected
                    {
                        DropDownListView dropDownList;
                        dropDownList = mDropDownList;
                        {
                            dropDownList.mListSelectionHidden = false;
                        } //End block
                    } //End block
                    addTaint(parent.getTaint());
                    addTaint(view.getTaint());
                    addTaint(position);
                    addTaint(id);
                    // ---------- Original Method ----------
                    //if (position != -1) {
                        //DropDownListView dropDownList = mDropDownList;
                        //if (dropDownList != null) {
                            //dropDownList.mListSelectionHidden = false;
                        //}
                    //}
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.041 -0400", hash_original_method = "ABAE53FB2582432DFD925A1EB74EEC53", hash_generated_method = "12A103C6C860E1CA8C576C5166DA4783")
                public void onNothingSelected(AdapterView<?> parent) {
                    //DSFIXME:  CODE0009: Possible callback target function detected
                    addTaint(parent.getTaint());
                    // ---------- Original Method ----------
                }
});
            mDropDownList.setOnScrollListener(mScrollListener);
            {
                mDropDownList.setOnItemSelectedListener(mItemSelectedListener);
            } //End block
            dropDownView = mDropDownList;
            View hintView;
            hintView = mPromptView;
            {
                LinearLayout hintContainer;
                hintContainer = new LinearLayout(context);
                hintContainer.setOrientation(LinearLayout.VERTICAL);
                LinearLayout.LayoutParams hintParams;
                hintParams = new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, 0, 1.0f
                );
                //Begin case POSITION_PROMPT_BELOW 
                hintContainer.addView(dropDownView, hintParams);
                //End case POSITION_PROMPT_BELOW 
                //Begin case POSITION_PROMPT_BELOW 
                hintContainer.addView(hintView);
                //End case POSITION_PROMPT_BELOW 
                //Begin case POSITION_PROMPT_ABOVE 
                hintContainer.addView(hintView);
                //End case POSITION_PROMPT_ABOVE 
                //Begin case POSITION_PROMPT_ABOVE 
                hintContainer.addView(dropDownView, hintParams);
                //End case POSITION_PROMPT_ABOVE 
                int widthSpec;
                widthSpec = MeasureSpec.makeMeasureSpec(mDropDownWidth, MeasureSpec.AT_MOST);
                int heightSpec;
                heightSpec = MeasureSpec.UNSPECIFIED;
                hintView.measure(widthSpec, heightSpec);
                hintParams = (LinearLayout.LayoutParams) hintView.getLayoutParams();
                otherHeights = hintView.getMeasuredHeight() + hintParams.topMargin
                        + hintParams.bottomMargin;
                dropDownView = hintContainer;
            } //End block
            mPopup.setContentView(dropDownView);
        } //End block
        {
            dropDownView = (ViewGroup) mPopup.getContentView();
            View view;
            view = mPromptView;
            {
                LinearLayout.LayoutParams hintParams;
                hintParams = (LinearLayout.LayoutParams) view.getLayoutParams();
                otherHeights = view.getMeasuredHeight() + hintParams.topMargin
                        + hintParams.bottomMargin;
            } //End block
        } //End block
        int padding;
        padding = 0;
        Drawable background;
        background = mPopup.getBackground();
        {
            background.getPadding(mTempRect);
            padding = mTempRect.top + mTempRect.bottom;
            {
                mDropDownVerticalOffset = -mTempRect.top;
            } //End block
        } //End block
        boolean ignoreBottomDecorations;
        ignoreBottomDecorations = mPopup.getInputMethodMode() == PopupWindow.INPUT_METHOD_NOT_NEEDED;
        int maxHeight;
        maxHeight = mPopup.getMaxAvailableHeight(
                getAnchorView(), mDropDownVerticalOffset, ignoreBottomDecorations);
        int listContent;
        listContent = mDropDownList.measureHeightOfChildren(MeasureSpec.UNSPECIFIED,
                0, ListView.NO_POSITION, maxHeight - otherHeights, -1);
        otherHeights += padding;
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_922191916 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_922191916;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private static class DropDownListView extends ListView {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.043 -0400", hash_original_field = "E0414B5920D6C693B394C4CB80A1503E", hash_generated_field = "3F3C05952474F71A545A45E3C3CCA4F6")

        private boolean mListSelectionHidden;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.043 -0400", hash_original_field = "A1134304A98C0563BC9A1734CC3114E9", hash_generated_field = "527E1B04AF4AD8C6C618A0336B748CF0")

        private boolean mHijackFocus;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.044 -0400", hash_original_method = "BBC42F17FDBB7B5F7851EFDC7F6F1B4C", hash_generated_method = "96C1BAD710AF44C19B44694AB6585CFD")
        public  DropDownListView(Context context, boolean hijackFocus) {
            super(context, null, com.android.internal.R.attr.dropDownListViewStyle);
            mHijackFocus = hijackFocus;
            setCacheColorHint(0);
            addTaint(context.getTaint());
            // ---------- Original Method ----------
            //mHijackFocus = hijackFocus;
            //setCacheColorHint(0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.044 -0400", hash_original_method = "3F1E6A7533EB0FC6DBDDA209BB95D590", hash_generated_method = "C47CCDF0F08A1EC96A38A46325E477C1")
        @Override
         View obtainView(int position, boolean[] isScrap) {
            View varB4EAC82CA7396A68D541C85D26508E83_589854689 = null; //Variable for return #1
            View view;
            view = super.obtainView(position, isScrap);
            {
                ((TextView) view).setHorizontallyScrolling(true);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_589854689 = view;
            addTaint(position);
            addTaint(isScrap[0]);
            varB4EAC82CA7396A68D541C85D26508E83_589854689.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_589854689;
            // ---------- Original Method ----------
            //View view = super.obtainView(position, isScrap);
            //if (view instanceof TextView) {
                //((TextView) view).setHorizontallyScrolling(true);
            //}
            //return view;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.045 -0400", hash_original_method = "4691130934AB8C0281F78748C377FD01", hash_generated_method = "77754FB3E1E17C72115A68850C856FF7")
        @Override
        public boolean isInTouchMode() {
            boolean varCB3639C670B5B423000979DCEC75E658_1121992735 = ((mHijackFocus && mListSelectionHidden) || super.isInTouchMode());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1631438471 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1631438471;
            // ---------- Original Method ----------
            //return (mHijackFocus && mListSelectionHidden) || super.isInTouchMode();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.064 -0400", hash_original_method = "561EA8BFAB26A78C0A50D34CA2B435FA", hash_generated_method = "DF679870C2FB90698544B5100180EDA4")
        @Override
        public boolean hasWindowFocus() {
            boolean var0940CCD88AFB8F7CE2228B535D86CA58_954207282 = (mHijackFocus || super.hasWindowFocus());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1666518924 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1666518924;
            // ---------- Original Method ----------
            //return mHijackFocus || super.hasWindowFocus();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.064 -0400", hash_original_method = "C2BF4E069A702887BC745C139DC71739", hash_generated_method = "FCCEEE3D53786040E8305E78E5D38579")
        @Override
        public boolean isFocused() {
            boolean var56C93152DFB9CA3165D7CC2B9542D965_1365047718 = (mHijackFocus || super.isFocused());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1269490285 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1269490285;
            // ---------- Original Method ----------
            //return mHijackFocus || super.isFocused();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.064 -0400", hash_original_method = "1102992DDCFDFABDAA31FDFA580154D8", hash_generated_method = "74D1424AD9A429D78FCB100042D27A03")
        @Override
        public boolean hasFocus() {
            boolean varEE54D6BCCFD3521CE60CAD79A56FB942_1096980595 = (mHijackFocus || super.hasFocus());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_336253125 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_336253125;
            // ---------- Original Method ----------
            //return mHijackFocus || super.hasFocus();
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.065 -0400", hash_original_field = "735D9F3E915D51AB1338FB552E49756B", hash_generated_field = "D61B54E0F1F9A0D258615A7DA0AB1D17")

        private static String TAG = ListPopupWindow.TAG + ".DropDownListView";
    }


    
    private class PopupDataSetObserver extends DataSetObserver {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.065 -0400", hash_original_method = "2B87497157622859499FF49FBED7C822", hash_generated_method = "2B87497157622859499FF49FBED7C822")
        public PopupDataSetObserver ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.065 -0400", hash_original_method = "6E4DA5A5D077D6C0AA24FD2BF6BDF53A", hash_generated_method = "93E6868B91B7E81E74562042B76E2626")
        @Override
        public void onChanged() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                boolean varC328115627DFB8318D2C3484959F5057_1139652912 = (isShowing());
                {
                    show();
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //if (isShowing()) {
                //show();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.065 -0400", hash_original_method = "BEB5883597D4F7E6EC69D5E4B00F4808", hash_generated_method = "77ED6FEC41ABFE0FF7B87CF1F8DE3B8B")
        @Override
        public void onInvalidated() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dismiss();
            // ---------- Original Method ----------
            //dismiss();
        }

        
    }


    
    private class ListSelectorHider implements Runnable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.065 -0400", hash_original_method = "850B001590E034AECBB57C89D4E5B01F", hash_generated_method = "850B001590E034AECBB57C89D4E5B01F")
        public ListSelectorHider ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.125 -0400", hash_original_method = "9AD729468BC88951DC9B447B72E180D0", hash_generated_method = "33F921B8E266BA77FD9A621DF2DFDB10")
        public void run() {
            clearListSelection();
            // ---------- Original Method ----------
            //clearListSelection();
        }

        
    }


    
    private class ResizePopupRunnable implements Runnable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.125 -0400", hash_original_method = "3BE1DF808B5AE0104DCA795D143316E5", hash_generated_method = "3BE1DF808B5AE0104DCA795D143316E5")
        public ResizePopupRunnable ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.126 -0400", hash_original_method = "A0D6625363C0412112380631C620D963", hash_generated_method = "87CDFA9E95A02C420248DAED2F10AA8C")
        public void run() {
            {
                boolean varE9C71312359CF178D4C417E85CE87FC0_2145241907 = (mDropDownList != null && mDropDownList.getCount() > mDropDownList.getChildCount() &&
                    mDropDownList.getChildCount() <= mListItemExpandMaximum);
                {
                    mPopup.setInputMethodMode(PopupWindow.INPUT_METHOD_NOT_NEEDED);
                    show();
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //if (mDropDownList != null && mDropDownList.getCount() > mDropDownList.getChildCount() &&
                    //mDropDownList.getChildCount() <= mListItemExpandMaximum) {
                //mPopup.setInputMethodMode(PopupWindow.INPUT_METHOD_NOT_NEEDED);
                //show();
            //}
        }

        
    }


    
    private class PopupTouchInterceptor implements OnTouchListener {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.127 -0400", hash_original_method = "EC3EA52176E4094388A66835C5736568", hash_generated_method = "EC3EA52176E4094388A66835C5736568")
        public PopupTouchInterceptor ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.127 -0400", hash_original_method = "6DB51D562B35DA9065539F31B98AD12D", hash_generated_method = "BE27C95A0CF1C1EAA48772A526A89F2B")
        public boolean onTouch(View v, MotionEvent event) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            int action;
            action = event.getAction();
            int x;
            x = (int) event.getX();
            int y;
            y = (int) event.getY();
            {
                boolean var82507E865584DF35A671D82C7F963539_964540148 = (action == MotionEvent.ACTION_DOWN &&
                    mPopup != null && mPopup.isShowing() &&
                    (x >= 0 && x < mPopup.getWidth() && y >= 0 && y < mPopup.getHeight()));
                {
                    mHandler.postDelayed(mResizePopupRunnable, EXPAND_LIST_TIMEOUT);
                } //End block
                {
                    mHandler.removeCallbacks(mResizePopupRunnable);
                } //End block
            } //End collapsed parenthetic
            addTaint(v.getTaint());
            addTaint(event.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1424646440 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1424646440;
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.130 -0400", hash_original_method = "F5F35EF888BB5CF4AB79CAB2F875B0A7", hash_generated_method = "F5F35EF888BB5CF4AB79CAB2F875B0A7")
        public PopupScrollListener ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.131 -0400", hash_original_method = "6B5691236DBDB14CA060F218338C51C6", hash_generated_method = "1E0CD89024A89C685CED8A22BF60B332")
        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount,
                int totalItemCount) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(view.getTaint());
            addTaint(firstVisibleItem);
            addTaint(visibleItemCount);
            addTaint(totalItemCount);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.131 -0400", hash_original_method = "50D93865D772C2EF3B15BE53BF421FFA", hash_generated_method = "44B0E012A21D2917A1722D3FFF815BA1")
        public void onScrollStateChanged(AbsListView view, int scrollState) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                boolean var812725D6D4B7B7F1E2BFD35C1B20C4F6_2101098794 = (scrollState == SCROLL_STATE_TOUCH_SCROLL &&
                    !isInputMethodNotNeeded() && mPopup.getContentView() != null);
                {
                    mHandler.removeCallbacks(mResizePopupRunnable);
                    mResizePopupRunnable.run();
                } //End block
            } //End collapsed parenthetic
            addTaint(view.getTaint());
            addTaint(scrollState);
            // ---------- Original Method ----------
            //if (scrollState == SCROLL_STATE_TOUCH_SCROLL &&
                    //!isInputMethodNotNeeded() && mPopup.getContentView() != null) {
                //mHandler.removeCallbacks(mResizePopupRunnable);
                //mResizePopupRunnable.run();
            //}
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.134 -0400", hash_original_field = "FA4B0EF0ADB967172D8AF881D69A7EE4", hash_generated_field = "34333DAC95AD8BB31B3EAAE98AEEB38C")

    private static String TAG = "ListPopupWindow";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.134 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "E83DF1E2E661A92B1AFDA8C473D190B2")

    private static boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.134 -0400", hash_original_field = "68B838238909FB59ACCFE6BF19B2B1D1", hash_generated_field = "DE17B25CFE8CD0EE1803542825370868")

    private static int EXPAND_LIST_TIMEOUT = 250;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.134 -0400", hash_original_field = "7B4B6CB98FF46E17C95AE7FB67DB235A", hash_generated_field = "513C25DC2079D3E3F448C17AD7E45103")

    public static final int POSITION_PROMPT_ABOVE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.134 -0400", hash_original_field = "5E3D14DE82B660BC80724E775E94D316", hash_generated_field = "0DC2E01EB82FA75DF06F7820DDC407FC")

    public static final int POSITION_PROMPT_BELOW = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.134 -0400", hash_original_field = "5EC7C72B178102C05F771491BC0D99A1", hash_generated_field = "66FD18D4009B660D801EA24128E20B3A")

    public static final int MATCH_PARENT = ViewGroup.LayoutParams.MATCH_PARENT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.134 -0400", hash_original_field = "EEA327AFC1E7F44AF04BCB821C60E1A3", hash_generated_field = "09891BB8998BC15D0579567ED28F8125")

    public static final int WRAP_CONTENT = ViewGroup.LayoutParams.WRAP_CONTENT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.134 -0400", hash_original_field = "8CBFEBDAE91B592B8753E76C2C0664B2", hash_generated_field = "25DC4C7F5035D071A009268061A8DECC")

    public static final int INPUT_METHOD_FROM_FOCUSABLE = PopupWindow.INPUT_METHOD_FROM_FOCUSABLE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.134 -0400", hash_original_field = "464A9898C4B4354000EAA45DF3916F99", hash_generated_field = "BC380AA3102B060D07B4A59A29280852")

    public static final int INPUT_METHOD_NEEDED = PopupWindow.INPUT_METHOD_NEEDED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:09.134 -0400", hash_original_field = "C9A9B031ECCD576838FE185F697EFC96", hash_generated_field = "B45F005145864928FF3B5CE220951262")

    public static final int INPUT_METHOD_NOT_NEEDED = PopupWindow.INPUT_METHOD_NOT_NEEDED;
}

