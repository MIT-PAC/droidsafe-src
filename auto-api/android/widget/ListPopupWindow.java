package android.widget;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.306 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.306 -0400", hash_original_field = "E863CEB96C01242A6262A422DC21BA91", hash_generated_field = "DD5B28EB4059D1AC7E72BAEDE50FACDF")

    private PopupWindow mPopup;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.306 -0400", hash_original_field = "59E9F255F2F17EC006AE601269EA8540", hash_generated_field = "90F29768206AB431EA361CD94838716F")

    private ListAdapter mAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.306 -0400", hash_original_field = "4322C05E16B4F2C2D1AB5006F3431B02", hash_generated_field = "680F69659AC661E81526EC1B57AD0760")

    private DropDownListView mDropDownList;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.306 -0400", hash_original_field = "D134F22E4058DC5F7CFE7175F4F7430C", hash_generated_field = "95C5FD2B2227A2419A547D55212619CB")

    private int mDropDownHeight = ViewGroup.LayoutParams.WRAP_CONTENT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.306 -0400", hash_original_field = "4B650C8F2373468D630EB87118B7597E", hash_generated_field = "DE8B8CD76D1AB415FF96E39AF3C5D34E")

    private int mDropDownWidth = ViewGroup.LayoutParams.WRAP_CONTENT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.306 -0400", hash_original_field = "D7D5E41A0CA1EEEE2C5B6053B9E223EC", hash_generated_field = "E0B55CC77CB214A3579F9BF96330095D")

    private int mDropDownHorizontalOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.306 -0400", hash_original_field = "9A3E0C1905215D1560AFB5329CF32615", hash_generated_field = "3B23099D02FB8FF58FFC662868C0BB03")

    private int mDropDownVerticalOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.306 -0400", hash_original_field = "3D416D3AD24A140B66574A53F35D71B5", hash_generated_field = "EF2837EA9E1F32EA5B98F304DCD2B02D")

    private boolean mDropDownVerticalOffsetSet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.306 -0400", hash_original_field = "7F1912418791E473B7718B11A0CB1A0C", hash_generated_field = "A2A88CD1765159B88DD7DB6DD2826AA7")

    private boolean mDropDownAlwaysVisible = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.306 -0400", hash_original_field = "67337D864119F82F72A3E7E7A32EC92E", hash_generated_field = "D1BD29312DE39A83C4D6D5BDC2010A61")

    private boolean mForceIgnoreOutsideTouch = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.306 -0400", hash_original_field = "5510B09AA8FF17E498AD062C90FAC109", hash_generated_field = "B5EDBF08EC87E5E419CCBD4768539463")

    int mListItemExpandMaximum = Integer.MAX_VALUE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.306 -0400", hash_original_field = "9E5EAA17126782F8C703F935360DD7EB", hash_generated_field = "5F49A121459BF7DF82F93F51F66D9AFA")

    private View mPromptView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.306 -0400", hash_original_field = "4884FB6D2D0EBDBDEEE548951A32A380", hash_generated_field = "D0EDBCF4B24F722A68C83DBD4FA7D38D")

    private int mPromptPosition = POSITION_PROMPT_ABOVE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.306 -0400", hash_original_field = "C61FA2E7C36AC7AB9C40A5C4B482DC3A", hash_generated_field = "3BA4BCC5F225A10F755FE4D117871D40")

    private DataSetObserver mObserver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.306 -0400", hash_original_field = "6DF5C0BD5FF25E15FDCEDCD4ECB331FC", hash_generated_field = "0AD13AB5208CE821A0A2BF31AEC73CB4")

    private View mDropDownAnchorView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.306 -0400", hash_original_field = "834760B22D3D31098FFF241394D6BBE1", hash_generated_field = "D7FBC36DD90F3884476AF7A145F7D085")

    private Drawable mDropDownListHighlight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.306 -0400", hash_original_field = "1AE585B9A4195C50494CD4717922829E", hash_generated_field = "91F251C39E992AB6E9A1F97E1DB2D65A")

    private AdapterView.OnItemClickListener mItemClickListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.306 -0400", hash_original_field = "AC663E6C1E4BAD60BFB3B64BE97350A7", hash_generated_field = "B20A14E839638431419A27C6FA2EB183")

    private AdapterView.OnItemSelectedListener mItemSelectedListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.306 -0400", hash_original_field = "7D90B69C280C66541572056B61B44881", hash_generated_field = "821F70C70BBBE64322F054DCBDCBD65D")

    private final ResizePopupRunnable mResizePopupRunnable = new ResizePopupRunnable();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.306 -0400", hash_original_field = "C9722EDCCBF64142855D27EF1F728783", hash_generated_field = "C2DF6DA91E71FE1B73AF2F99DA491C65")

    private final PopupTouchInterceptor mTouchInterceptor = new PopupTouchInterceptor();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.306 -0400", hash_original_field = "681C9FD7FBE6DFAFD31A369FD3AF23EF", hash_generated_field = "7119F706A3F3F75D0AB9F70CFDF2D458")

    private final PopupScrollListener mScrollListener = new PopupScrollListener();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.306 -0400", hash_original_field = "DA8630584E936BC465CBD5DBD2061129", hash_generated_field = "368F7081BBFDFED86D539FFD5855A591")

    private final ListSelectorHider mHideSelector = new ListSelectorHider();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.306 -0400", hash_original_field = "008C495499355199D0B743FAC72B6D16", hash_generated_field = "61A25C839F09B3FC31C414DE40E67DB5")

    private Runnable mShowDropDownRunnable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.306 -0400", hash_original_field = "6781893E9FA50A9B7103FD3F674E566B", hash_generated_field = "2E60E17486AAEB1A4E1F1878A0354061")

    private Handler mHandler = new Handler();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.306 -0400", hash_original_field = "DF43B278CEE8933271AB3D9F9E312F86", hash_generated_field = "AFFA54D19F07A10EE8847CF76FC95323")

    private Rect mTempRect = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.306 -0400", hash_original_field = "126D90D638B8925B7E67DD1602EB9153", hash_generated_field = "2CBF8E91F49F039C5D23189C3E7CE590")

    private boolean mModal;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.307 -0400", hash_original_method = "EE0C6E46788D5D6F0175B90B5CCF0B4A", hash_generated_method = "A7BDC1A593955EB85983C7550497CC46")
    public  ListPopupWindow(Context context) {
        this(context, null, com.android.internal.R.attr.listPopupWindowStyle, 0);
        addTaint(context.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.307 -0400", hash_original_method = "C9E1E41EEB8F4220F08A0D28BC21C4EB", hash_generated_method = "18B187239D13E4CAE8D3E88BD9F775EF")
    public  ListPopupWindow(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.listPopupWindowStyle, 0);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.308 -0400", hash_original_method = "449FC27C9387B8AAB93C584A7B8B7579", hash_generated_method = "E80FD58555827A6DBB4D558FF46333EB")
    public  ListPopupWindow(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        addTaint(defStyleAttr);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.308 -0400", hash_original_method = "F8B1DB93A85ECDB9C2D2CE8639D222AE", hash_generated_method = "FE5B87D971B39F25483B906D7F81739C")
    public  ListPopupWindow(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        mContext = context;
        mPopup = new PopupWindow(context, attrs, defStyleAttr, defStyleRes);
        mPopup.setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED);
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.308 -0400", hash_original_method = "B55D1F7EE07C2CDF60B7B314069C1E48", hash_generated_method = "EDAB9113CCCC22D9A06FD8121B5B6D2C")
    public void setAdapter(ListAdapter adapter) {
        {
            mObserver = new PopupDataSetObserver();
        } 
        {
            mAdapter.unregisterDataSetObserver(mObserver);
        } 
        mAdapter = adapter;
        {
            adapter.registerDataSetObserver(mObserver);
        } 
        {
            mDropDownList.setAdapter(mAdapter);
        } 
        
        
            
        
            
        
        
        
            
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.309 -0400", hash_original_method = "7CC61A3797371517F86E3D676D22847C", hash_generated_method = "CE87A26F1F31625F1A82E312F687DB1A")
    public void setPromptPosition(int position) {
        mPromptPosition = position;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.309 -0400", hash_original_method = "DF9D97B46096A1E4CCF9033CE8B43A47", hash_generated_method = "7434BEED001C6256EF266C41169D2719")
    public int getPromptPosition() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2076169326 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2076169326;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.309 -0400", hash_original_method = "320A57FA9129485B3F1A01EDA8808ED5", hash_generated_method = "D0A4E10B11955C6EF4D4A7F65C74F2BF")
    public void setModal(boolean modal) {
        mModal = true;
        mPopup.setFocusable(modal);
        addTaint(modal);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.309 -0400", hash_original_method = "195244B0122E9C532D039816F791192C", hash_generated_method = "11C80E1E5F1D78A55D1A4F715989B465")
    public boolean isModal() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1449386719 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1449386719;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.310 -0400", hash_original_method = "B51F6D3B2B582EB2529861E286FFBDAA", hash_generated_method = "C259F7A19612B2ACBFCE0BD237FE9AAB")
    public void setForceIgnoreOutsideTouch(boolean forceIgnoreOutsideTouch) {
        mForceIgnoreOutsideTouch = forceIgnoreOutsideTouch;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.310 -0400", hash_original_method = "0D7558B683A811B4FB459E3A92DCFACB", hash_generated_method = "6C5818E602B53931F3E1B0DBF55A9DBB")
    public void setDropDownAlwaysVisible(boolean dropDownAlwaysVisible) {
        mDropDownAlwaysVisible = dropDownAlwaysVisible;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.310 -0400", hash_original_method = "452BC62A357E5A143092E81C66B09D6A", hash_generated_method = "9352573F9A21D2912334D835FF02AF95")
    public boolean isDropDownAlwaysVisible() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_634429333 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_634429333;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.311 -0400", hash_original_method = "E80B835CA17A4D3E815EC079FA1EE953", hash_generated_method = "8A780C7809C5C55408662AB78E3D6AE7")
    public void setSoftInputMode(int mode) {
        mPopup.setSoftInputMode(mode);
        addTaint(mode);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.311 -0400", hash_original_method = "EF5235E70AE7C9521CFD0F4410B9073C", hash_generated_method = "6AC0F5A5B808DB8F668C2C34D5D80F3B")
    public int getSoftInputMode() {
        int var33219CA59686C86DFE930490FC0C5D79_766702166 = (mPopup.getSoftInputMode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1555025574 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1555025574;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.311 -0400", hash_original_method = "00D6E099D8DC922D12B17B03F893B884", hash_generated_method = "FF67F34E40E9A65B6F576056899652DB")
    public void setListSelector(Drawable selector) {
        mDropDownListHighlight = selector;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.312 -0400", hash_original_method = "48A20BD7A1656DF8848E524613AD69C1", hash_generated_method = "A85769A4AE868C1F2F170DE77A4F57FB")
    public Drawable getBackground() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1870786126 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1870786126 = mPopup.getBackground();
        varB4EAC82CA7396A68D541C85D26508E83_1870786126.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1870786126;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.312 -0400", hash_original_method = "53EE8E67A046C4A20122C0C008F8CCAA", hash_generated_method = "BD70D3B0AFF0C8D7DB54CAD63485854E")
    public void setBackgroundDrawable(Drawable d) {
        mPopup.setBackgroundDrawable(d);
        addTaint(d.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.312 -0400", hash_original_method = "CF4F09D135A7A5849055A447382D076E", hash_generated_method = "1F08BBCFEFAD3E761FCB230941BBB65B")
    public void setAnimationStyle(int animationStyle) {
        mPopup.setAnimationStyle(animationStyle);
        addTaint(animationStyle);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.312 -0400", hash_original_method = "A53F654A1BF514C432C9F43DB9ED5E7B", hash_generated_method = "06DDC2CAA11C8AB15534265637751476")
    public int getAnimationStyle() {
        int varFF59793919A82B1D3C72ECF85DD5BB92_904538235 = (mPopup.getAnimationStyle());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2054338314 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2054338314;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.313 -0400", hash_original_method = "875C75F19631B214BE64A011FD6A41E4", hash_generated_method = "BCD62A5BA0C845990A3E38AE220F9F1E")
    public View getAnchorView() {
        View varB4EAC82CA7396A68D541C85D26508E83_367212713 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_367212713 = mDropDownAnchorView;
        varB4EAC82CA7396A68D541C85D26508E83_367212713.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_367212713;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.313 -0400", hash_original_method = "91753F7FEC6E3180927B7B9D55B8E090", hash_generated_method = "63EE2FBCA0AADA3A31B95FC73D9580CE")
    public void setAnchorView(View anchor) {
        mDropDownAnchorView = anchor;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.313 -0400", hash_original_method = "2C5F7D64A15BDC64E0A7D1677E996184", hash_generated_method = "F5BC61D68DDBC90AF51AE19DCA81209A")
    public int getHorizontalOffset() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_619298921 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_619298921;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.313 -0400", hash_original_method = "37914D7AC2B7A80AA5FE528B058A9DBC", hash_generated_method = "C126BA21DD750A9AFE1BD084B715A818")
    public void setHorizontalOffset(int offset) {
        mDropDownHorizontalOffset = offset;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.313 -0400", hash_original_method = "06BDE5646BE562A7D86252C676418C82", hash_generated_method = "68156A531BCBA3E671497BE58B49138D")
    public int getVerticalOffset() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1103405322 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1103405322;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.314 -0400", hash_original_method = "F61671411958DBF85FB58F84EEE162C4", hash_generated_method = "2B910F94073C3EC07961DBEFFADDA58F")
    public void setVerticalOffset(int offset) {
        mDropDownVerticalOffset = offset;
        mDropDownVerticalOffsetSet = true;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.314 -0400", hash_original_method = "6205F90E667ADE4444482E9AC195FB48", hash_generated_method = "5BD08E1F3C54234B0AA89E9F1C2C5B1C")
    public int getWidth() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1688136883 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1688136883;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.314 -0400", hash_original_method = "1FDBBF009B47D57DAE1EE309EAA8DA19", hash_generated_method = "9D744DA174B0219B1092FF60AD2FCB92")
    public void setWidth(int width) {
        mDropDownWidth = width;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.314 -0400", hash_original_method = "1CC81B1489D8EBDAA358E87EA72284F9", hash_generated_method = "1D5AE1AB512CBE1E1137C76DB1C43C1A")
    public void setContentWidth(int width) {
        Drawable popupBackground = mPopup.getBackground();
        {
            popupBackground.getPadding(mTempRect);
            mDropDownWidth = mTempRect.left + mTempRect.right + width;
        } 
        {
            setWidth(width);
        } 
        
        
        
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.315 -0400", hash_original_method = "2B0617362C23A2A1F29E0E83641579F9", hash_generated_method = "15102EDB6ED2F2F1245D2DAD7077BB5E")
    public int getHeight() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1508233350 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1508233350;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.315 -0400", hash_original_method = "CAA84DCA25312E828BE740B15493FB25", hash_generated_method = "4DA8EB017D81399AC9FA9C78A28822F1")
    public void setHeight(int height) {
        mDropDownHeight = height;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.315 -0400", hash_original_method = "500645EE5CDA87E171AAE4D175AC763E", hash_generated_method = "2D5D314BA37B280C0EC1EB015FA6FF32")
    public void setOnItemClickListener(AdapterView.OnItemClickListener clickListener) {
        mItemClickListener = clickListener;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.315 -0400", hash_original_method = "77C1F384A6316C978289202E5719DEEE", hash_generated_method = "9F10FF9A076A5EE31B9093767F0F184A")
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener selectedListener) {
        mItemSelectedListener = selectedListener;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.315 -0400", hash_original_method = "F870D6C36930B52993EA962C5CEE4741", hash_generated_method = "AEDEF20FDB033FB98E6AB86506718EBD")
    public void setPromptView(View prompt) {
        boolean showing = isShowing();
        {
            removePromptView();
        } 
        mPromptView = prompt;
        {
            show();
        } 
        
        
        
            
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.316 -0400", hash_original_method = "6F8BB8AB5CFBCAF655CCF7F8C4D42CCD", hash_generated_method = "12A7B7B2D0ABC916C160864A366BF13A")
    public void postShow() {
        mHandler.post(mShowDropDownRunnable);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.317 -0400", hash_original_method = "B0532D10D967B708828191A62293AA30", hash_generated_method = "71D858384C4330D1056E79EA067D1672")
    public void show() {
        int height = buildDropDown();
        int widthSpec = 0;
        int heightSpec = 0;
        boolean noInputMethod = isInputMethodNotNeeded();
        mPopup.setAllowScrollingAnchorParent(!noInputMethod);
        {
            boolean var26FEA7C5EC762AEBD619B9EAE248324D_1366898948 = (mPopup.isShowing());
            {
                {
                    widthSpec = -1;
                } 
                {
                    widthSpec = getAnchorView().getWidth();
                } 
                {
                    widthSpec = mDropDownWidth;
                } 
                {
                    heightSpec = noInputMethod ? height : ViewGroup.LayoutParams.MATCH_PARENT;
                    {
                        mPopup.setWindowLayoutMode(
                            mDropDownWidth == ViewGroup.LayoutParams.MATCH_PARENT ?
                                    ViewGroup.LayoutParams.MATCH_PARENT : 0, 0);
                    } 
                    {
                        mPopup.setWindowLayoutMode(
                            mDropDownWidth == ViewGroup.LayoutParams.MATCH_PARENT ?
                                    ViewGroup.LayoutParams.MATCH_PARENT : 0,
                            ViewGroup.LayoutParams.MATCH_PARENT);
                    } 
                } 
                {
                    heightSpec = height;
                } 
                {
                    heightSpec = mDropDownHeight;
                } 
                mPopup.setOutsideTouchable(!mForceIgnoreOutsideTouch && !mDropDownAlwaysVisible);
                mPopup.update(getAnchorView(), mDropDownHorizontalOffset,
                    mDropDownVerticalOffset, widthSpec, heightSpec);
            } 
            {
                {
                    widthSpec = ViewGroup.LayoutParams.MATCH_PARENT;
                } 
                {
                    {
                        mPopup.setWidth(getAnchorView().getWidth());
                    } 
                    {
                        mPopup.setWidth(mDropDownWidth);
                    } 
                } 
                {
                    heightSpec = ViewGroup.LayoutParams.MATCH_PARENT;
                } 
                {
                    {
                        mPopup.setHeight(height);
                    } 
                    {
                        mPopup.setHeight(mDropDownHeight);
                    } 
                } 
                mPopup.setWindowLayoutMode(widthSpec, heightSpec);
                mPopup.setClipToScreenEnabled(true);
                mPopup.setOutsideTouchable(!mForceIgnoreOutsideTouch && !mDropDownAlwaysVisible);
                mPopup.setTouchInterceptor(mTouchInterceptor);
                mPopup.showAsDropDown(getAnchorView(),
                    mDropDownHorizontalOffset, mDropDownVerticalOffset);
                mDropDownList.setSelection(ListView.INVALID_POSITION);
                {
                    boolean varFBD33AEB1C7B877FCB56A03F8E624BE0_1671856782 = (!mModal || mDropDownList.isInTouchMode());
                    {
                        clearListSelection();
                    } 
                } 
                {
                    mHandler.post(mHideSelector);
                } 
            } 
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.317 -0400", hash_original_method = "B4B1B4676A26C0E0D07AD81974E2090B", hash_generated_method = "9DC863547F53C27A47992D34B3B95A71")
    public void dismiss() {
        mPopup.dismiss();
        removePromptView();
        mPopup.setContentView(null);
        mDropDownList = null;
        mHandler.removeCallbacks(mResizePopupRunnable);
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.317 -0400", hash_original_method = "C7BE29500BF4339E2FDC892E2A139524", hash_generated_method = "62B9243C5E27763C5D78A4507C1AE897")
    public void setOnDismissListener(PopupWindow.OnDismissListener listener) {
        mPopup.setOnDismissListener(listener);
        addTaint(listener.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.317 -0400", hash_original_method = "202D4492803683737094012DDF6DD86F", hash_generated_method = "48C2AEB2401450EC6625310B3FE26886")
    private void removePromptView() {
        {
            final ViewParent parent = mPromptView.getParent();
            {
                final ViewGroup group = (ViewGroup) parent;
                group.removeView(mPromptView);
            } 
        } 
        
        
            
            
                
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.318 -0400", hash_original_method = "288B7DB6446AD4FA82AB3ACE9506A35B", hash_generated_method = "7AD2713FA630DB6E27D0A251E2CCE4A4")
    public void setInputMethodMode(int mode) {
        mPopup.setInputMethodMode(mode);
        addTaint(mode);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.318 -0400", hash_original_method = "341CBB053B214C5E0FB1B54637325DA3", hash_generated_method = "52EDC7EB05013C99222808628C992638")
    public int getInputMethodMode() {
        int varCAD19FC29631D9DEB0E193028B2569D9_1584103995 = (mPopup.getInputMethodMode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1839107357 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1839107357;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.318 -0400", hash_original_method = "119CA9359C56E2DDD442B9A05EFE812C", hash_generated_method = "DE0D2B662BFC53C10EEFF2E8E4923394")
    public void setSelection(int position) {
        DropDownListView list = mDropDownList;
        {
            boolean varE1BD8FEF0D9A15DF839CE93664F6E4FF_467545788 = (isShowing() && list != null);
            {
                list.mListSelectionHidden = false;
                list.setSelection(position);
                {
                    boolean var24E210557EA947C11E8431EB5891287F_724401533 = (list.getChoiceMode() != ListView.CHOICE_MODE_NONE);
                    {
                        list.setItemChecked(position, true);
                    } 
                } 
            } 
        } 
        addTaint(position);
        
        
        
            
            
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.319 -0400", hash_original_method = "5E25633D1BEAE372BF50698DAAA66CA7", hash_generated_method = "81FB08F99D3A1B7D44D07E8682A59967")
    public void clearListSelection() {
        final DropDownListView list = mDropDownList;
        {
            list.mListSelectionHidden = true;
            list.hideSelector();
            list.requestLayout();
        } 
        
        
        
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.319 -0400", hash_original_method = "CA9C4C0CD645F38E1AAA797FE00ECFCE", hash_generated_method = "B79F6D3064F305AC02CB95E4DA2AC562")
    public boolean isShowing() {
        boolean varC4D0BEF5C8B8A88A8F0203AF22B9D645_953300805 = (mPopup.isShowing());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1785549870 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1785549870;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.320 -0400", hash_original_method = "C5EEC00F4CE1C916DAF561B7CF397229", hash_generated_method = "D838C09D8EF44484282EF73FFEBE7D21")
    public boolean isInputMethodNotNeeded() {
        boolean varCB697D8A9E9B8855A49BA45F9E6E55D8_926315097 = (mPopup.getInputMethodMode() == INPUT_METHOD_NOT_NEEDED);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1217147444 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1217147444;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.320 -0400", hash_original_method = "5D56F9149CAA09C31AB36A31C90B128D", hash_generated_method = "76FE2FA8299816BD0A2DE07C3148C651")
    public boolean performItemClick(int position) {
        {
            boolean var4A685BA46E35F21FC0CB2BDAFA9CFEA5_118777730 = (isShowing());
            {
                {
                    final DropDownListView list = mDropDownList;
                    final View child = list.getChildAt(position - list.getFirstVisiblePosition());
                    final ListAdapter adapter = list.getAdapter();
                    mItemClickListener.onItemClick(list, child, position, adapter.getItemId(position));
                } 
            } 
        } 
        addTaint(position);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_700853587 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_700853587;
        
        
            
                
                
                
                
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.321 -0400", hash_original_method = "E481FD4B78A135BB1B6DC4E83167B196", hash_generated_method = "C3990CF343FBDCE7B26CCB7E05266D51")
    public Object getSelectedItem() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1475117661 = null; 
        Object varB4EAC82CA7396A68D541C85D26508E83_2051269113 = null; 
        {
            boolean var67F0F8A90F47989DCF9FDFD2C3F61D76_556323827 = (!isShowing());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1475117661 = null;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_2051269113 = mDropDownList.getSelectedItem();
        Object varA7E53CE21691AB073D9660D615818899_1848986385; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1848986385 = varB4EAC82CA7396A68D541C85D26508E83_1475117661;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1848986385 = varB4EAC82CA7396A68D541C85D26508E83_2051269113;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1848986385.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1848986385;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.321 -0400", hash_original_method = "055DCA84E8C7B3F34F7D7819C2CD5AC3", hash_generated_method = "6712EDBFC3B2DE422D50D7333588ADF0")
    public int getSelectedItemPosition() {
        {
            boolean var67F0F8A90F47989DCF9FDFD2C3F61D76_1374693410 = (!isShowing());
        } 
        int varFFCD2483F75EA19D2EC4EA912FAF68BC_628412113 = (mDropDownList.getSelectedItemPosition());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_222180366 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_222180366;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.322 -0400", hash_original_method = "4492784EC84C61BD8D41E43112FEBCD0", hash_generated_method = "04047E856E3926FCCBFB19FB95656B50")
    public long getSelectedItemId() {
        {
            boolean var67F0F8A90F47989DCF9FDFD2C3F61D76_1041176736 = (!isShowing());
        } 
        long var831263C88E6FFB9B4AA451205D89724F_732483507 = (mDropDownList.getSelectedItemId());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_539660909 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_539660909;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.323 -0400", hash_original_method = "A94FEEC1ECDAC3555C21CB10FFC68C47", hash_generated_method = "B555E569EC63130F367941648304815C")
    public View getSelectedView() {
        View varB4EAC82CA7396A68D541C85D26508E83_1891189882 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_1901058170 = null; 
        {
            boolean var67F0F8A90F47989DCF9FDFD2C3F61D76_887039918 = (!isShowing());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1891189882 = null;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1901058170 = mDropDownList.getSelectedView();
        View varA7E53CE21691AB073D9660D615818899_890115027; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_890115027 = varB4EAC82CA7396A68D541C85D26508E83_1891189882;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_890115027 = varB4EAC82CA7396A68D541C85D26508E83_1901058170;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_890115027.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_890115027;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.323 -0400", hash_original_method = "D21142DAF85C899FDAA3783E4BBEC12E", hash_generated_method = "38CA2881FC39D5B01C368EA0EDCD0505")
    public ListView getListView() {
        ListView varB4EAC82CA7396A68D541C85D26508E83_29458922 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_29458922 = mDropDownList;
        varB4EAC82CA7396A68D541C85D26508E83_29458922.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_29458922;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.324 -0400", hash_original_method = "21262ED785FC4787FB1F1DE7107BCA92", hash_generated_method = "7D6D8AA3A24EB925896215A339982186")
     void setListItemExpandMax(int max) {
        mListItemExpandMaximum = max;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.325 -0400", hash_original_method = "D4938DA23F7CC8247819641EDCB20246", hash_generated_method = "68EABA36A652DC1FEF8A2D14AFCE7E16")
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        
        {
            boolean var4A685BA46E35F21FC0CB2BDAFA9CFEA5_1834688421 = (isShowing());
            {
                {
                    boolean var6B6417BC9ADDCAB4E3C4BC8A5D054B03_1787312698 = (keyCode != KeyEvent.KEYCODE_SPACE
                    && (mDropDownList.getSelectedItemPosition() >= 0
                            || (keyCode != KeyEvent.KEYCODE_ENTER
                                    && keyCode != KeyEvent.KEYCODE_DPAD_CENTER)));
                    {
                        int curIndex = mDropDownList.getSelectedItemPosition();
                        boolean consumed;
                        final boolean below = !mPopup.isAboveAnchor();
                        final ListAdapter adapter = mAdapter;
                        boolean allEnabled;
                        int firstItem = Integer.MAX_VALUE;
                        int lastItem = Integer.MIN_VALUE;
                        {
                            allEnabled = adapter.areAllItemsEnabled();
                            firstItem = allEnabled ? 0 :
                            mDropDownList.lookForSelectablePosition(0, true);
                            lastItem = allEnabled ? adapter.getCount() - 1 :
                            mDropDownList.lookForSelectablePosition(adapter.getCount() - 1, false);
                        } 
                        {
                            clearListSelection();
                            mPopup.setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED);
                            show();
                        } 
                        {
                            mDropDownList.mListSelectionHidden = false;
                        } 
                        consumed = mDropDownList.onKeyDown(keyCode, event);
                        {
                            mPopup.setInputMethodMode(PopupWindow.INPUT_METHOD_NOT_NEEDED);
                            mDropDownList.requestFocusFromTouch();
                            show();
                        } 
                    } 
                } 
            } 
        } 
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1866578590 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1866578590;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.325 -0400", hash_original_method = "CD01E8977B386E95EB43DA8A15EDF875", hash_generated_method = "95534EA393693022B0E6C6CA37919674")
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        
        {
            boolean var94A367403F58644D7C7080281BCAEB6B_804370751 = (isShowing() && mDropDownList.getSelectedItemPosition() >= 0);
            {
                boolean consumed = mDropDownList.onKeyUp(keyCode, event);
                {
                    
                    dismiss();
                    
                } 
            } 
        } 
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_813971905 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_813971905;
        
        
            
            
                
                    
                    
                        
                        
                
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.326 -0400", hash_original_method = "5D81C652E72C1CAFD12E9CC95CD171E7", hash_generated_method = "D72826BA07AFCD5B1B12D6E1ED57F0ED")
    public boolean onKeyPreIme(int keyCode, KeyEvent event) {
        
        {
            boolean var405C80F78320ACCD1F0C2596742EF82D_1942065009 = (keyCode == KeyEvent.KEYCODE_BACK && isShowing());
            {
                final View anchorView = mDropDownAnchorView;
                {
                    boolean var51947D54DEEA690F1B41A17DE6323711_1313650805 = (event.getAction() == KeyEvent.ACTION_DOWN && event.getRepeatCount() == 0);
                    {
                        KeyEvent.DispatcherState state = anchorView.getKeyDispatcherState();
                        {
                            state.startTracking(event, this);
                        } 
                    } 
                    {
                        boolean varA6D964A9D1A4D1D485BD8D60F2BFCDEE_285851310 = (event.getAction() == KeyEvent.ACTION_UP);
                        {
                            KeyEvent.DispatcherState state = anchorView.getKeyDispatcherState();
                            {
                                state.handleUpEvent(event);
                            } 
                            {
                                boolean varBE09C907F92D135687297C67489D82A5_2035106257 = (event.isTracking() && !event.isCanceled());
                                {
                                    dismiss();
                                } 
                            } 
                        } 
                    } 
                } 
            } 
        } 
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2137120454 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2137120454;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.328 -0400", hash_original_method = "F5C740553BB47CFEBEC052FD2A1DEFBA", hash_generated_method = "B8DB4C9333D7DE5ABC6CA7F6AF57F55B")
    private int buildDropDown() {
        ViewGroup dropDownView;
        int otherHeights = 0;
        {
            Context context = mContext;
            mShowDropDownRunnable = new Runnable() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.327 -0400", hash_original_method = "CEA8CEF9AA7B34E441550DF384140083", hash_generated_method = "795147A1541BC244103F9F244100892D")
                public void run() {
                    View view = getAnchorView();
                    {
                        boolean varB5043B80B6F8EE24E2CA3965BAE7CC2D_312827849 = (view != null && view.getWindowToken() != null);
                        {
                            show();
                        } 
                    } 
                    
                    
                    
                        
                    
                }
};
            mDropDownList = new DropDownListView(context, !mModal);
            {
                mDropDownList.setSelector(mDropDownListHighlight);
            } 
            mDropDownList.setAdapter(mAdapter);
            mDropDownList.setOnItemClickListener(mItemClickListener);
            mDropDownList.setFocusable(true);
            mDropDownList.setFocusableInTouchMode(true);
            mDropDownList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.327 -0400", hash_original_method = "A3D9BDCD43F35F92A348E2938D25FA58", hash_generated_method = "C7E487604C140F3DB1013223B257F6D8")
                public void onItemSelected(AdapterView<?> parent, View view,
                        int position, long id) {
                    
                    {
                        DropDownListView dropDownList = mDropDownList;
                        {
                            dropDownList.mListSelectionHidden = false;
                        } 
                    } 
                    addTaint(parent.getTaint());
                    addTaint(view.getTaint());
                    addTaint(position);
                    addTaint(id);
                    
                    
                        
                        
                            
                        
                    
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.327 -0400", hash_original_method = "ABAE53FB2582432DFD925A1EB74EEC53", hash_generated_method = "12A103C6C860E1CA8C576C5166DA4783")
                public void onNothingSelected(AdapterView<?> parent) {
                    
                    addTaint(parent.getTaint());
                    
                }
});
            mDropDownList.setOnScrollListener(mScrollListener);
            {
                mDropDownList.setOnItemSelectedListener(mItemSelectedListener);
            } 
            dropDownView = mDropDownList;
            View hintView = mPromptView;
            {
                LinearLayout hintContainer = new LinearLayout(context);
                hintContainer.setOrientation(LinearLayout.VERTICAL);
                LinearLayout.LayoutParams hintParams = new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, 0, 1.0f
                );
                
                hintContainer.addView(dropDownView, hintParams);
                
                
                hintContainer.addView(hintView);
                
                
                hintContainer.addView(hintView);
                
                
                hintContainer.addView(dropDownView, hintParams);
                
                int widthSpec = MeasureSpec.makeMeasureSpec(mDropDownWidth, MeasureSpec.AT_MOST);
                int heightSpec = MeasureSpec.UNSPECIFIED;
                hintView.measure(widthSpec, heightSpec);
                hintParams = (LinearLayout.LayoutParams) hintView.getLayoutParams();
                otherHeights = hintView.getMeasuredHeight() + hintParams.topMargin
                        + hintParams.bottomMargin;
                dropDownView = hintContainer;
            } 
            mPopup.setContentView(dropDownView);
        } 
        {
            dropDownView = (ViewGroup) mPopup.getContentView();
            final View view = mPromptView;
            {
                LinearLayout.LayoutParams hintParams = (LinearLayout.LayoutParams) view.getLayoutParams();
                otherHeights = view.getMeasuredHeight() + hintParams.topMargin
                        + hintParams.bottomMargin;
            } 
        } 
        int padding = 0;
        Drawable background = mPopup.getBackground();
        {
            background.getPadding(mTempRect);
            padding = mTempRect.top + mTempRect.bottom;
            {
                mDropDownVerticalOffset = -mTempRect.top;
            } 
        } 
        boolean ignoreBottomDecorations = mPopup.getInputMethodMode() == PopupWindow.INPUT_METHOD_NOT_NEEDED;
        final int maxHeight = mPopup.getMaxAvailableHeight(
                getAnchorView(), mDropDownVerticalOffset, ignoreBottomDecorations);
        final int listContent = mDropDownList.measureHeightOfChildren(MeasureSpec.UNSPECIFIED,
                0, ListView.NO_POSITION, maxHeight - otherHeights, -1);
        otherHeights += padding;
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_253879185 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_253879185;
        
        
    }

    
    private static class DropDownListView extends ListView {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.328 -0400", hash_original_field = "E0414B5920D6C693B394C4CB80A1503E", hash_generated_field = "3F3C05952474F71A545A45E3C3CCA4F6")

        private boolean mListSelectionHidden;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.328 -0400", hash_original_field = "A1134304A98C0563BC9A1734CC3114E9", hash_generated_field = "527E1B04AF4AD8C6C618A0336B748CF0")

        private boolean mHijackFocus;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.329 -0400", hash_original_method = "BBC42F17FDBB7B5F7851EFDC7F6F1B4C", hash_generated_method = "96C1BAD710AF44C19B44694AB6585CFD")
        public  DropDownListView(Context context, boolean hijackFocus) {
            super(context, null, com.android.internal.R.attr.dropDownListViewStyle);
            mHijackFocus = hijackFocus;
            setCacheColorHint(0);
            addTaint(context.getTaint());
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.329 -0400", hash_original_method = "3F1E6A7533EB0FC6DBDDA209BB95D590", hash_generated_method = "27683D4F9065C3AAF72614553239F5AB")
        @Override
         View obtainView(int position, boolean[] isScrap) {
            View varB4EAC82CA7396A68D541C85D26508E83_488932407 = null; 
            View view = super.obtainView(position, isScrap);
            {
                ((TextView) view).setHorizontallyScrolling(true);
            } 
            varB4EAC82CA7396A68D541C85D26508E83_488932407 = view;
            addTaint(position);
            addTaint(isScrap[0]);
            varB4EAC82CA7396A68D541C85D26508E83_488932407.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_488932407;
            
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.329 -0400", hash_original_method = "4691130934AB8C0281F78748C377FD01", hash_generated_method = "13003EBD6ECA86D94C7BF97F278E8795")
        @Override
        public boolean isInTouchMode() {
            boolean varCB3639C670B5B423000979DCEC75E658_1914526597 = ((mHijackFocus && mListSelectionHidden) || super.isInTouchMode());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1367367339 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1367367339;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.330 -0400", hash_original_method = "561EA8BFAB26A78C0A50D34CA2B435FA", hash_generated_method = "3C0E0B8E72F93A05B71DFA9B1657D4BA")
        @Override
        public boolean hasWindowFocus() {
            boolean var0940CCD88AFB8F7CE2228B535D86CA58_1453356160 = (mHijackFocus || super.hasWindowFocus());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1845246683 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1845246683;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.330 -0400", hash_original_method = "C2BF4E069A702887BC745C139DC71739", hash_generated_method = "E6B108A51ABA614A8AF808BA09656465")
        @Override
        public boolean isFocused() {
            boolean var56C93152DFB9CA3165D7CC2B9542D965_1494474619 = (mHijackFocus || super.isFocused());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_807501825 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_807501825;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.330 -0400", hash_original_method = "1102992DDCFDFABDAA31FDFA580154D8", hash_generated_method = "32546CA4A8EF4D9A7BB93CE212879CFA")
        @Override
        public boolean hasFocus() {
            boolean varEE54D6BCCFD3521CE60CAD79A56FB942_1902901639 = (mHijackFocus || super.hasFocus());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1425956993 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1425956993;
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.330 -0400", hash_original_field = "735D9F3E915D51AB1338FB552E49756B", hash_generated_field = "23928DA4DE83E1135FB8A9793C3625F7")

        private static final String TAG = ListPopupWindow.TAG + ".DropDownListView";
    }


    
    private class PopupDataSetObserver extends DataSetObserver {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.330 -0400", hash_original_method = "2B87497157622859499FF49FBED7C822", hash_generated_method = "2B87497157622859499FF49FBED7C822")
        public PopupDataSetObserver ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.331 -0400", hash_original_method = "6E4DA5A5D077D6C0AA24FD2BF6BDF53A", hash_generated_method = "81F62F0B59E332BD89D6DE2904A7DE99")
        @Override
        public void onChanged() {
            
            {
                boolean varC328115627DFB8318D2C3484959F5057_2092529159 = (isShowing());
                {
                    show();
                } 
            } 
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.331 -0400", hash_original_method = "BEB5883597D4F7E6EC69D5E4B00F4808", hash_generated_method = "77ED6FEC41ABFE0FF7B87CF1F8DE3B8B")
        @Override
        public void onInvalidated() {
            
            dismiss();
            
            
        }

        
    }


    
    private class ListSelectorHider implements Runnable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.331 -0400", hash_original_method = "850B001590E034AECBB57C89D4E5B01F", hash_generated_method = "850B001590E034AECBB57C89D4E5B01F")
        public ListSelectorHider ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.331 -0400", hash_original_method = "9AD729468BC88951DC9B447B72E180D0", hash_generated_method = "33F921B8E266BA77FD9A621DF2DFDB10")
        public void run() {
            clearListSelection();
            
            
        }

        
    }


    
    private class ResizePopupRunnable implements Runnable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.331 -0400", hash_original_method = "3BE1DF808B5AE0104DCA795D143316E5", hash_generated_method = "3BE1DF808B5AE0104DCA795D143316E5")
        public ResizePopupRunnable ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.332 -0400", hash_original_method = "A0D6625363C0412112380631C620D963", hash_generated_method = "3583834767CD0122653E6638B655196D")
        public void run() {
            {
                boolean varE9C71312359CF178D4C417E85CE87FC0_1721484223 = (mDropDownList != null && mDropDownList.getCount() > mDropDownList.getChildCount() &&
                    mDropDownList.getChildCount() <= mListItemExpandMaximum);
                {
                    mPopup.setInputMethodMode(PopupWindow.INPUT_METHOD_NOT_NEEDED);
                    show();
                } 
            } 
            
            
                    
                
                
            
        }

        
    }


    
    private class PopupTouchInterceptor implements OnTouchListener {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.332 -0400", hash_original_method = "EC3EA52176E4094388A66835C5736568", hash_generated_method = "EC3EA52176E4094388A66835C5736568")
        public PopupTouchInterceptor ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.333 -0400", hash_original_method = "6DB51D562B35DA9065539F31B98AD12D", hash_generated_method = "3E30742451A3E0CB0CF815F1BE6566D6")
        public boolean onTouch(View v, MotionEvent event) {
            
            final int action = event.getAction();
            final int x = (int) event.getX();
            final int y = (int) event.getY();
            {
                boolean var82507E865584DF35A671D82C7F963539_126600991 = (action == MotionEvent.ACTION_DOWN &&
                    mPopup != null && mPopup.isShowing() &&
                    (x >= 0 && x < mPopup.getWidth() && y >= 0 && y < mPopup.getHeight()));
                {
                    mHandler.postDelayed(mResizePopupRunnable, EXPAND_LIST_TIMEOUT);
                } 
                {
                    mHandler.removeCallbacks(mResizePopupRunnable);
                } 
            } 
            addTaint(v.getTaint());
            addTaint(event.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1029259338 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1029259338;
            
            
            
            
            
                    
                    
                
            
                
            
            
        }

        
    }


    
    private class PopupScrollListener implements ListView.OnScrollListener {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.333 -0400", hash_original_method = "F5F35EF888BB5CF4AB79CAB2F875B0A7", hash_generated_method = "F5F35EF888BB5CF4AB79CAB2F875B0A7")
        public PopupScrollListener ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.334 -0400", hash_original_method = "6B5691236DBDB14CA060F218338C51C6", hash_generated_method = "1E0CD89024A89C685CED8A22BF60B332")
        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount,
                int totalItemCount) {
            
            addTaint(view.getTaint());
            addTaint(firstVisibleItem);
            addTaint(visibleItemCount);
            addTaint(totalItemCount);
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.334 -0400", hash_original_method = "50D93865D772C2EF3B15BE53BF421FFA", hash_generated_method = "93527C574EF41A4CEDE69A8D7DCD5D76")
        public void onScrollStateChanged(AbsListView view, int scrollState) {
            
            {
                boolean var812725D6D4B7B7F1E2BFD35C1B20C4F6_1914203384 = (scrollState == SCROLL_STATE_TOUCH_SCROLL &&
                    !isInputMethodNotNeeded() && mPopup.getContentView() != null);
                {
                    mHandler.removeCallbacks(mResizePopupRunnable);
                    mResizePopupRunnable.run();
                } 
            } 
            addTaint(view.getTaint());
            addTaint(scrollState);
            
            
                    
                
                
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.334 -0400", hash_original_field = "FA4B0EF0ADB967172D8AF881D69A7EE4", hash_generated_field = "0887B70F50539FED12873EB1C34B6CEE")

    private static final String TAG = "ListPopupWindow";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.334 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.334 -0400", hash_original_field = "68B838238909FB59ACCFE6BF19B2B1D1", hash_generated_field = "F8D801998654223FA4FA41D41E9F5E7A")

    private static final int EXPAND_LIST_TIMEOUT = 250;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.334 -0400", hash_original_field = "7B4B6CB98FF46E17C95AE7FB67DB235A", hash_generated_field = "513C25DC2079D3E3F448C17AD7E45103")

    public static final int POSITION_PROMPT_ABOVE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.334 -0400", hash_original_field = "5E3D14DE82B660BC80724E775E94D316", hash_generated_field = "0DC2E01EB82FA75DF06F7820DDC407FC")

    public static final int POSITION_PROMPT_BELOW = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.334 -0400", hash_original_field = "5EC7C72B178102C05F771491BC0D99A1", hash_generated_field = "66FD18D4009B660D801EA24128E20B3A")

    public static final int MATCH_PARENT = ViewGroup.LayoutParams.MATCH_PARENT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.334 -0400", hash_original_field = "EEA327AFC1E7F44AF04BCB821C60E1A3", hash_generated_field = "09891BB8998BC15D0579567ED28F8125")

    public static final int WRAP_CONTENT = ViewGroup.LayoutParams.WRAP_CONTENT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.334 -0400", hash_original_field = "8CBFEBDAE91B592B8753E76C2C0664B2", hash_generated_field = "25DC4C7F5035D071A009268061A8DECC")

    public static final int INPUT_METHOD_FROM_FOCUSABLE = PopupWindow.INPUT_METHOD_FROM_FOCUSABLE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.334 -0400", hash_original_field = "464A9898C4B4354000EAA45DF3916F99", hash_generated_field = "BC380AA3102B060D07B4A59A29280852")

    public static final int INPUT_METHOD_NEEDED = PopupWindow.INPUT_METHOD_NEEDED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.334 -0400", hash_original_field = "C9A9B031ECCD576838FE185F697EFC96", hash_generated_field = "B45F005145864928FF3B5CE220951262")

    public static final int INPUT_METHOD_NOT_NEEDED = PopupWindow.INPUT_METHOD_NOT_NEEDED;
}

