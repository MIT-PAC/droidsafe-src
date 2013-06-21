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
    private Context mContext;
    private PopupWindow mPopup;
    private ListAdapter mAdapter;
    private DropDownListView mDropDownList;
    private int mDropDownHeight = ViewGroup.LayoutParams.WRAP_CONTENT;
    private int mDropDownWidth = ViewGroup.LayoutParams.WRAP_CONTENT;
    private int mDropDownHorizontalOffset;
    private int mDropDownVerticalOffset;
    private boolean mDropDownVerticalOffsetSet;
    private boolean mDropDownAlwaysVisible = false;
    private boolean mForceIgnoreOutsideTouch = false;
    int mListItemExpandMaximum = Integer.MAX_VALUE;
    private View mPromptView;
    private int mPromptPosition = POSITION_PROMPT_ABOVE;
    private DataSetObserver mObserver;
    private View mDropDownAnchorView;
    private Drawable mDropDownListHighlight;
    private AdapterView.OnItemClickListener mItemClickListener;
    private AdapterView.OnItemSelectedListener mItemSelectedListener;
    private ResizePopupRunnable mResizePopupRunnable = new ResizePopupRunnable();
    private PopupTouchInterceptor mTouchInterceptor = new PopupTouchInterceptor();
    private PopupScrollListener mScrollListener = new PopupScrollListener();
    private ListSelectorHider mHideSelector = new ListSelectorHider();
    private Runnable mShowDropDownRunnable;
    private Handler mHandler = new Handler();
    private Rect mTempRect = new Rect();
    private boolean mModal;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.462 -0400", hash_original_method = "EE0C6E46788D5D6F0175B90B5CCF0B4A", hash_generated_method = "FBB8442FB6B464D9F1DA47A5FFD468E7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ListPopupWindow(Context context) {
        this(context, null, com.android.internal.R.attr.listPopupWindowStyle, 0);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.462 -0400", hash_original_method = "C9E1E41EEB8F4220F08A0D28BC21C4EB", hash_generated_method = "69841AB302BF9660CC1BFECABF1997FF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ListPopupWindow(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.listPopupWindowStyle, 0);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.462 -0400", hash_original_method = "449FC27C9387B8AAB93C584A7B8B7579", hash_generated_method = "4B1F078E4B89CCC06BF87DBCEBA0339E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ListPopupWindow(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
        dsTaint.addTaint(defStyleAttr);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.462 -0400", hash_original_method = "F8B1DB93A85ECDB9C2D2CE8639D222AE", hash_generated_method = "6DA1DF8D8F96086EEEAE195E89FEED81")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ListPopupWindow(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        dsTaint.addTaint(defStyleRes);
        dsTaint.addTaint(defStyleAttr);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        mPopup = new PopupWindow(context, attrs, defStyleAttr, defStyleRes);
        mPopup.setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED);
        // ---------- Original Method ----------
        //mContext = context;
        //mPopup = new PopupWindow(context, attrs, defStyleAttr, defStyleRes);
        //mPopup.setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.463 -0400", hash_original_method = "B55D1F7EE07C2CDF60B7B314069C1E48", hash_generated_method = "331AD05E95E066405B5A1B1A5BD7483A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setAdapter(ListAdapter adapter) {
        dsTaint.addTaint(adapter.dsTaint);
        {
            mObserver = new PopupDataSetObserver();
        } //End block
        {
            mAdapter.unregisterDataSetObserver(mObserver);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.463 -0400", hash_original_method = "7CC61A3797371517F86E3D676D22847C", hash_generated_method = "F3EADF6D106CA80F888594A28445E62F")
    @DSModeled(DSC.SAFE)
    public void setPromptPosition(int position) {
        dsTaint.addTaint(position);
        // ---------- Original Method ----------
        //mPromptPosition = position;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.463 -0400", hash_original_method = "DF9D97B46096A1E4CCF9033CE8B43A47", hash_generated_method = "5ED19F3ACD1FCDD8AE3F4AE39E42872C")
    @DSModeled(DSC.SAFE)
    public int getPromptPosition() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mPromptPosition;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.463 -0400", hash_original_method = "320A57FA9129485B3F1A01EDA8808ED5", hash_generated_method = "4BE6495788BEBEDDDAEDCF2C9874C12F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setModal(boolean modal) {
        dsTaint.addTaint(modal);
        mModal = true;
        mPopup.setFocusable(modal);
        // ---------- Original Method ----------
        //mModal = true;
        //mPopup.setFocusable(modal);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.463 -0400", hash_original_method = "195244B0122E9C532D039816F791192C", hash_generated_method = "648FB71B8C53BEC60E137DD0136886E4")
    @DSModeled(DSC.SAFE)
    public boolean isModal() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mModal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.463 -0400", hash_original_method = "B51F6D3B2B582EB2529861E286FFBDAA", hash_generated_method = "B727BF8B134742DA7EAAEEE703BF6314")
    @DSModeled(DSC.SAFE)
    public void setForceIgnoreOutsideTouch(boolean forceIgnoreOutsideTouch) {
        dsTaint.addTaint(forceIgnoreOutsideTouch);
        // ---------- Original Method ----------
        //mForceIgnoreOutsideTouch = forceIgnoreOutsideTouch;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.464 -0400", hash_original_method = "0D7558B683A811B4FB459E3A92DCFACB", hash_generated_method = "11441E5BB8AD025CE04BC0420A212186")
    @DSModeled(DSC.SAFE)
    public void setDropDownAlwaysVisible(boolean dropDownAlwaysVisible) {
        dsTaint.addTaint(dropDownAlwaysVisible);
        // ---------- Original Method ----------
        //mDropDownAlwaysVisible = dropDownAlwaysVisible;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.464 -0400", hash_original_method = "452BC62A357E5A143092E81C66B09D6A", hash_generated_method = "22D4B5E918F8115DC2ED0D0AF25B7A17")
    @DSModeled(DSC.SAFE)
    public boolean isDropDownAlwaysVisible() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mDropDownAlwaysVisible;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.464 -0400", hash_original_method = "E80B835CA17A4D3E815EC079FA1EE953", hash_generated_method = "342012C9E9EA96C00FF6CCF1F4F699BE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSoftInputMode(int mode) {
        dsTaint.addTaint(mode);
        mPopup.setSoftInputMode(mode);
        // ---------- Original Method ----------
        //mPopup.setSoftInputMode(mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.464 -0400", hash_original_method = "EF5235E70AE7C9521CFD0F4410B9073C", hash_generated_method = "E2E5E693546A49DCD164EB61EFA874B0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getSoftInputMode() {
        int var33219CA59686C86DFE930490FC0C5D79_1524248143 = (mPopup.getSoftInputMode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mPopup.getSoftInputMode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.464 -0400", hash_original_method = "00D6E099D8DC922D12B17B03F893B884", hash_generated_method = "9B55D03C3FAE5C11C31B62A59D71A444")
    @DSModeled(DSC.SAFE)
    public void setListSelector(Drawable selector) {
        dsTaint.addTaint(selector.dsTaint);
        // ---------- Original Method ----------
        //mDropDownListHighlight = selector;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.464 -0400", hash_original_method = "48A20BD7A1656DF8848E524613AD69C1", hash_generated_method = "56E6BAA57721B5705CD19867AF943EE8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Drawable getBackground() {
        Drawable var3AB612EC6D572A5289EDC1AB98187ABD_1228839369 = (mPopup.getBackground());
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mPopup.getBackground();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.465 -0400", hash_original_method = "53EE8E67A046C4A20122C0C008F8CCAA", hash_generated_method = "F65904FE370602BB063554EE780E3E0D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setBackgroundDrawable(Drawable d) {
        dsTaint.addTaint(d.dsTaint);
        mPopup.setBackgroundDrawable(d);
        // ---------- Original Method ----------
        //mPopup.setBackgroundDrawable(d);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.465 -0400", hash_original_method = "CF4F09D135A7A5849055A447382D076E", hash_generated_method = "46C1BA10CF90DCFFA3A693886A0A7681")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setAnimationStyle(int animationStyle) {
        dsTaint.addTaint(animationStyle);
        mPopup.setAnimationStyle(animationStyle);
        // ---------- Original Method ----------
        //mPopup.setAnimationStyle(animationStyle);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.465 -0400", hash_original_method = "A53F654A1BF514C432C9F43DB9ED5E7B", hash_generated_method = "D43347CF6B8EC213E92C0AD52F39E66F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getAnimationStyle() {
        int varFF59793919A82B1D3C72ECF85DD5BB92_1359104618 = (mPopup.getAnimationStyle());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mPopup.getAnimationStyle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.465 -0400", hash_original_method = "875C75F19631B214BE64A011FD6A41E4", hash_generated_method = "76EB6A9A94772967B8E81008B382EA95")
    @DSModeled(DSC.SAFE)
    public View getAnchorView() {
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mDropDownAnchorView;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.465 -0400", hash_original_method = "91753F7FEC6E3180927B7B9D55B8E090", hash_generated_method = "FE3E8D326BCE0D283ABA4E1CAC2B3B74")
    @DSModeled(DSC.SAFE)
    public void setAnchorView(View anchor) {
        dsTaint.addTaint(anchor.dsTaint);
        // ---------- Original Method ----------
        //mDropDownAnchorView = anchor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.465 -0400", hash_original_method = "2C5F7D64A15BDC64E0A7D1677E996184", hash_generated_method = "E5B6AF7FCB1C63A5A6164ACEF149668C")
    @DSModeled(DSC.SAFE)
    public int getHorizontalOffset() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mDropDownHorizontalOffset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.466 -0400", hash_original_method = "37914D7AC2B7A80AA5FE528B058A9DBC", hash_generated_method = "9AA2B62F8DFFE1A3DDDF0772ACCE1004")
    @DSModeled(DSC.SAFE)
    public void setHorizontalOffset(int offset) {
        dsTaint.addTaint(offset);
        // ---------- Original Method ----------
        //mDropDownHorizontalOffset = offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.466 -0400", hash_original_method = "06BDE5646BE562A7D86252C676418C82", hash_generated_method = "C0BEF10E5803EEAFE66833658D610CAA")
    @DSModeled(DSC.SAFE)
    public int getVerticalOffset() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (!mDropDownVerticalOffsetSet) {
            //return 0;
        //}
        //return mDropDownVerticalOffset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.466 -0400", hash_original_method = "F61671411958DBF85FB58F84EEE162C4", hash_generated_method = "95DE0BB0A798AFBF5FEFBC33F139EFA8")
    @DSModeled(DSC.SAFE)
    public void setVerticalOffset(int offset) {
        dsTaint.addTaint(offset);
        mDropDownVerticalOffsetSet = true;
        // ---------- Original Method ----------
        //mDropDownVerticalOffset = offset;
        //mDropDownVerticalOffsetSet = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.466 -0400", hash_original_method = "6205F90E667ADE4444482E9AC195FB48", hash_generated_method = "9405A4B20CE1C9C7DCD2B68C4F206504")
    @DSModeled(DSC.SAFE)
    public int getWidth() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mDropDownWidth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.466 -0400", hash_original_method = "1FDBBF009B47D57DAE1EE309EAA8DA19", hash_generated_method = "6B75FF4E18FEE493BEFB97D11E309CC5")
    @DSModeled(DSC.SAFE)
    public void setWidth(int width) {
        dsTaint.addTaint(width);
        // ---------- Original Method ----------
        //mDropDownWidth = width;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.466 -0400", hash_original_method = "1CC81B1489D8EBDAA358E87EA72284F9", hash_generated_method = "C615C95D3FB9B6C2518C8FA8CFEB3EC5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setContentWidth(int width) {
        dsTaint.addTaint(width);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.466 -0400", hash_original_method = "2B0617362C23A2A1F29E0E83641579F9", hash_generated_method = "2041EC38BDE55D06BBD374A5939D906C")
    @DSModeled(DSC.SAFE)
    public int getHeight() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mDropDownHeight;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.467 -0400", hash_original_method = "CAA84DCA25312E828BE740B15493FB25", hash_generated_method = "BF257870231457BC784CCBFEE43F9690")
    @DSModeled(DSC.SAFE)
    public void setHeight(int height) {
        dsTaint.addTaint(height);
        // ---------- Original Method ----------
        //mDropDownHeight = height;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.467 -0400", hash_original_method = "500645EE5CDA87E171AAE4D175AC763E", hash_generated_method = "D3D8C6932EBC5AC427D2503A8745B358")
    @DSModeled(DSC.SAFE)
    public void setOnItemClickListener(AdapterView.OnItemClickListener clickListener) {
        dsTaint.addTaint(clickListener.dsTaint);
        // ---------- Original Method ----------
        //mItemClickListener = clickListener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.467 -0400", hash_original_method = "77C1F384A6316C978289202E5719DEEE", hash_generated_method = "9695AAF86F9F57167326549B9912956C")
    @DSModeled(DSC.SAFE)
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener selectedListener) {
        dsTaint.addTaint(selectedListener.dsTaint);
        // ---------- Original Method ----------
        //mItemSelectedListener = selectedListener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.467 -0400", hash_original_method = "F870D6C36930B52993EA962C5CEE4741", hash_generated_method = "7ED615DF15740C68CC539DAD65A83813")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setPromptView(View prompt) {
        dsTaint.addTaint(prompt.dsTaint);
        boolean showing;
        showing = isShowing();
        {
            removePromptView();
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.467 -0400", hash_original_method = "6F8BB8AB5CFBCAF655CCF7F8C4D42CCD", hash_generated_method = "12A7B7B2D0ABC916C160864A366BF13A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void postShow() {
        mHandler.post(mShowDropDownRunnable);
        // ---------- Original Method ----------
        //mHandler.post(mShowDropDownRunnable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.468 -0400", hash_original_method = "B0532D10D967B708828191A62293AA30", hash_generated_method = "8E8F28401541F3484CC797ADCED6C877")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
            boolean var26FEA7C5EC762AEBD619B9EAE248324D_230070607 = (mPopup.isShowing());
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
                    boolean varFBD33AEB1C7B877FCB56A03F8E624BE0_431181374 = (!mModal || mDropDownList.isInTouchMode());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.468 -0400", hash_original_method = "B4B1B4676A26C0E0D07AD81974E2090B", hash_generated_method = "9DC863547F53C27A47992D34B3B95A71")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.468 -0400", hash_original_method = "C7BE29500BF4339E2FDC892E2A139524", hash_generated_method = "E74F1F385F910BCC14CB0DE0BFF329A3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOnDismissListener(PopupWindow.OnDismissListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        mPopup.setOnDismissListener(listener);
        // ---------- Original Method ----------
        //mPopup.setOnDismissListener(listener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.469 -0400", hash_original_method = "202D4492803683737094012DDF6DD86F", hash_generated_method = "B1682D1A5E8AA8C5501D211FDA6B4E2D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.469 -0400", hash_original_method = "288B7DB6446AD4FA82AB3ACE9506A35B", hash_generated_method = "4E47A6DC8E26A2613C225AF8B4530FC4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setInputMethodMode(int mode) {
        dsTaint.addTaint(mode);
        mPopup.setInputMethodMode(mode);
        // ---------- Original Method ----------
        //mPopup.setInputMethodMode(mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.469 -0400", hash_original_method = "341CBB053B214C5E0FB1B54637325DA3", hash_generated_method = "CD5C2EA9D1CA70160D78CC45FAD9D547")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getInputMethodMode() {
        int varCAD19FC29631D9DEB0E193028B2569D9_1830116153 = (mPopup.getInputMethodMode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mPopup.getInputMethodMode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.469 -0400", hash_original_method = "119CA9359C56E2DDD442B9A05EFE812C", hash_generated_method = "3B4C90368A10F0A1CC60217E6048456C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSelection(int position) {
        dsTaint.addTaint(position);
        DropDownListView list;
        list = mDropDownList;
        {
            boolean varE1BD8FEF0D9A15DF839CE93664F6E4FF_484377319 = (isShowing() && list != null);
            {
                list.mListSelectionHidden = false;
                list.setSelection(position);
                {
                    boolean var24E210557EA947C11E8431EB5891287F_2053827689 = (list.getChoiceMode() != ListView.CHOICE_MODE_NONE);
                    {
                        list.setItemChecked(position, true);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.470 -0400", hash_original_method = "5E25633D1BEAE372BF50698DAAA66CA7", hash_generated_method = "5B75B5FAE8DA730475AB27B8203D5277")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.470 -0400", hash_original_method = "CA9C4C0CD645F38E1AAA797FE00ECFCE", hash_generated_method = "C36D4786D4599FDEAF77A68ECC2ABEB5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isShowing() {
        boolean varC4D0BEF5C8B8A88A8F0203AF22B9D645_134065522 = (mPopup.isShowing());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mPopup.isShowing();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.470 -0400", hash_original_method = "C5EEC00F4CE1C916DAF561B7CF397229", hash_generated_method = "B66EF2A6C85A771FCF1EEAC5E25D259E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isInputMethodNotNeeded() {
        boolean varCB697D8A9E9B8855A49BA45F9E6E55D8_1388462221 = (mPopup.getInputMethodMode() == INPUT_METHOD_NOT_NEEDED);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mPopup.getInputMethodMode() == INPUT_METHOD_NOT_NEEDED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.470 -0400", hash_original_method = "5D56F9149CAA09C31AB36A31C90B128D", hash_generated_method = "F29F4A39EAE4D20ED69FDDF7AEAA5F0B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean performItemClick(int position) {
        dsTaint.addTaint(position);
        {
            boolean var4A685BA46E35F21FC0CB2BDAFA9CFEA5_1126338364 = (isShowing());
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
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.470 -0400", hash_original_method = "E481FD4B78A135BB1B6DC4E83167B196", hash_generated_method = "53023D1D4507DC3A342A66AC85C10679")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object getSelectedItem() {
        {
            boolean var67F0F8A90F47989DCF9FDFD2C3F61D76_1542961867 = (!isShowing());
        } //End collapsed parenthetic
        Object varDCAEB0121C65E21CAF3EA0A803D8A2FC_18859632 = (mDropDownList.getSelectedItem());
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (!isShowing()) {
            //return null;
        //}
        //return mDropDownList.getSelectedItem();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.471 -0400", hash_original_method = "055DCA84E8C7B3F34F7D7819C2CD5AC3", hash_generated_method = "B96520526535253D67F743FE87A5A4A5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getSelectedItemPosition() {
        {
            boolean var67F0F8A90F47989DCF9FDFD2C3F61D76_195856677 = (!isShowing());
        } //End collapsed parenthetic
        int varFFCD2483F75EA19D2EC4EA912FAF68BC_26678285 = (mDropDownList.getSelectedItemPosition());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (!isShowing()) {
            //return ListView.INVALID_POSITION;
        //}
        //return mDropDownList.getSelectedItemPosition();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.471 -0400", hash_original_method = "4492784EC84C61BD8D41E43112FEBCD0", hash_generated_method = "9E371E59803B655FAC5FB52F9D27D932")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getSelectedItemId() {
        {
            boolean var67F0F8A90F47989DCF9FDFD2C3F61D76_561573452 = (!isShowing());
        } //End collapsed parenthetic
        long var831263C88E6FFB9B4AA451205D89724F_1007207234 = (mDropDownList.getSelectedItemId());
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //if (!isShowing()) {
            //return ListView.INVALID_ROW_ID;
        //}
        //return mDropDownList.getSelectedItemId();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.471 -0400", hash_original_method = "A94FEEC1ECDAC3555C21CB10FFC68C47", hash_generated_method = "DCCF355261B7061634D166CFFABF46A7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public View getSelectedView() {
        {
            boolean var67F0F8A90F47989DCF9FDFD2C3F61D76_247162934 = (!isShowing());
        } //End collapsed parenthetic
        View varF44B134504552721A48B746347D62CC1_1899143542 = (mDropDownList.getSelectedView());
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (!isShowing()) {
            //return null;
        //}
        //return mDropDownList.getSelectedView();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.471 -0400", hash_original_method = "D21142DAF85C899FDAA3783E4BBEC12E", hash_generated_method = "4CCFEA14CAB5B9DF12E7C82E8C1B6560")
    @DSModeled(DSC.SAFE)
    public ListView getListView() {
        return (ListView)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mDropDownList;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.471 -0400", hash_original_method = "21262ED785FC4787FB1F1DE7107BCA92", hash_generated_method = "16F19DF7842EED5531620920252E2EC7")
    @DSModeled(DSC.SAFE)
     void setListItemExpandMax(int max) {
        dsTaint.addTaint(max);
        // ---------- Original Method ----------
        //mListItemExpandMaximum = max;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.472 -0400", hash_original_method = "D4938DA23F7CC8247819641EDCB20246", hash_generated_method = "57BAA4C66BC3EE1D9AAE2363FD0671D2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(event.dsTaint);
        {
            boolean var4A685BA46E35F21FC0CB2BDAFA9CFEA5_1292440411 = (isShowing());
            {
                {
                    boolean var6B6417BC9ADDCAB4E3C4BC8A5D054B03_1360197731 = (keyCode != KeyEvent.KEYCODE_SPACE
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
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.472 -0400", hash_original_method = "CD01E8977B386E95EB43DA8A15EDF875", hash_generated_method = "FE7E64CAD42BE7B848337BB40FC7515E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(event.dsTaint);
        {
            boolean var94A367403F58644D7C7080281BCAEB6B_1804468079 = (isShowing() && mDropDownList.getSelectedItemPosition() >= 0);
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
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.473 -0400", hash_original_method = "5D81C652E72C1CAFD12E9CC95CD171E7", hash_generated_method = "261D2F7C92A4AADAEAF6F9F7AAF454AE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean onKeyPreIme(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(event.dsTaint);
        {
            boolean var405C80F78320ACCD1F0C2596742EF82D_713558366 = (keyCode == KeyEvent.KEYCODE_BACK && isShowing());
            {
                View anchorView;
                anchorView = mDropDownAnchorView;
                {
                    boolean var51947D54DEEA690F1B41A17DE6323711_5858313 = (event.getAction() == KeyEvent.ACTION_DOWN && event.getRepeatCount() == 0);
                    {
                        KeyEvent.DispatcherState state;
                        state = anchorView.getKeyDispatcherState();
                        {
                            state.startTracking(event, this);
                        } //End block
                    } //End block
                    {
                        boolean varA6D964A9D1A4D1D485BD8D60F2BFCDEE_636537095 = (event.getAction() == KeyEvent.ACTION_UP);
                        {
                            KeyEvent.DispatcherState state;
                            state = anchorView.getKeyDispatcherState();
                            {
                                state.handleUpEvent(event);
                            } //End block
                            {
                                boolean varBE09C907F92D135687297C67489D82A5_1416557005 = (event.isTracking() && !event.isCanceled());
                                {
                                    dismiss();
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.474 -0400", hash_original_method = "F5C740553BB47CFEBEC052FD2A1DEFBA", hash_generated_method = "B0711B679A1D2CF3D047423604C5598C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int buildDropDown() {
        ViewGroup dropDownView;
        int otherHeights;
        otherHeights = 0;
        {
            Context context;
            context = mContext;
            mShowDropDownRunnable = new Runnable() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.473 -0400", hash_original_method = "CEA8CEF9AA7B34E441550DF384140083", hash_generated_method = "39E5B71BBC5C3812C3D449BE4DD54E04")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                public void run() {
                    View view;
                    view = getAnchorView();
                    {
                        boolean varB5043B80B6F8EE24E2CA3965BAE7CC2D_1335070072 = (view != null && view.getWindowToken() != null);
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
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.474 -0400", hash_original_method = "A3D9BDCD43F35F92A348E2938D25FA58", hash_generated_method = "4CD78F36C2789417151845F89CC8CF51")
                @DSModeled(DSC.SAFE)
                public void onItemSelected(AdapterView<?> parent, View view,
                        int position, long id) {
                    //DSFIXME:  CODE0009: Possible callback target function detected
                    dsTaint.addTaint(id);
                    dsTaint.addTaint(position);
                    dsTaint.addTaint(parent.dsTaint);
                    dsTaint.addTaint(view.dsTaint);
                    {
                        DropDownListView dropDownList;
                        dropDownList = mDropDownList;
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
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.474 -0400", hash_original_method = "ABAE53FB2582432DFD925A1EB74EEC53", hash_generated_method = "3FB99829E9C79551CC3785956805D331")
                @DSModeled(DSC.SAFE)
                public void onNothingSelected(AdapterView<?> parent) {
                    //DSFIXME:  CODE0009: Possible callback target function detected
                    dsTaint.addTaint(parent.dsTaint);
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
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private static class DropDownListView extends ListView {
        private boolean mListSelectionHidden;
        private boolean mHijackFocus;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.475 -0400", hash_original_method = "BBC42F17FDBB7B5F7851EFDC7F6F1B4C", hash_generated_method = "4AD3122378F46405B4531AEC949D1722")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public DropDownListView(Context context, boolean hijackFocus) {
            super(context, null, com.android.internal.R.attr.dropDownListViewStyle);
            dsTaint.addTaint(hijackFocus);
            dsTaint.addTaint(context.dsTaint);
            setCacheColorHint(0);
            // ---------- Original Method ----------
            //mHijackFocus = hijackFocus;
            //setCacheColorHint(0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.475 -0400", hash_original_method = "3F1E6A7533EB0FC6DBDDA209BB95D590", hash_generated_method = "1DD116C8B77AAEEC43CBC72803FE63A4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
         View obtainView(int position, boolean[] isScrap) {
            dsTaint.addTaint(position);
            dsTaint.addTaint(isScrap[0]);
            View view;
            view = super.obtainView(position, isScrap);
            {
                ((TextView) view).setHorizontallyScrolling(true);
            } //End block
            return (View)dsTaint.getTaint();
            // ---------- Original Method ----------
            //View view = super.obtainView(position, isScrap);
            //if (view instanceof TextView) {
                //((TextView) view).setHorizontallyScrolling(true);
            //}
            //return view;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.475 -0400", hash_original_method = "4691130934AB8C0281F78748C377FD01", hash_generated_method = "0763D8A900DF1B0D6947298F4A19760A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean isInTouchMode() {
            boolean varCB3639C670B5B423000979DCEC75E658_1675843398 = ((mHijackFocus && mListSelectionHidden) || super.isInTouchMode());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return (mHijackFocus && mListSelectionHidden) || super.isInTouchMode();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.475 -0400", hash_original_method = "561EA8BFAB26A78C0A50D34CA2B435FA", hash_generated_method = "6401A3094EFEC74E51FBFF301CE3A3AB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean hasWindowFocus() {
            boolean var0940CCD88AFB8F7CE2228B535D86CA58_556073395 = (mHijackFocus || super.hasWindowFocus());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return mHijackFocus || super.hasWindowFocus();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.476 -0400", hash_original_method = "C2BF4E069A702887BC745C139DC71739", hash_generated_method = "ED162FCFE8158916D2F5D89998650C4B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean isFocused() {
            boolean var56C93152DFB9CA3165D7CC2B9542D965_1400723605 = (mHijackFocus || super.isFocused());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return mHijackFocus || super.isFocused();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.476 -0400", hash_original_method = "1102992DDCFDFABDAA31FDFA580154D8", hash_generated_method = "1F2E2F1616C74F3E69FAD55D3330D5BC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean hasFocus() {
            boolean varEE54D6BCCFD3521CE60CAD79A56FB942_404333715 = (mHijackFocus || super.hasFocus());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return mHijackFocus || super.hasFocus();
        }

        
        private static final String TAG = ListPopupWindow.TAG + ".DropDownListView";
    }


    
    private class PopupDataSetObserver extends DataSetObserver {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.476 -0400", hash_original_method = "18147E3C812B85F2382843E6ADAF110B", hash_generated_method = "18147E3C812B85F2382843E6ADAF110B")
                public PopupDataSetObserver ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.476 -0400", hash_original_method = "6E4DA5A5D077D6C0AA24FD2BF6BDF53A", hash_generated_method = "72673ED8A16BAD75738DA75647702563")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void onChanged() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                boolean varC328115627DFB8318D2C3484959F5057_1324362629 = (isShowing());
                {
                    show();
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //if (isShowing()) {
                //show();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.476 -0400", hash_original_method = "BEB5883597D4F7E6EC69D5E4B00F4808", hash_generated_method = "77ED6FEC41ABFE0FF7B87CF1F8DE3B8B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void onInvalidated() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dismiss();
            // ---------- Original Method ----------
            //dismiss();
        }

        
    }


    
    private class ListSelectorHider implements Runnable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.476 -0400", hash_original_method = "F3F097DD8720C87819096F435861894B", hash_generated_method = "F3F097DD8720C87819096F435861894B")
                public ListSelectorHider ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.476 -0400", hash_original_method = "9AD729468BC88951DC9B447B72E180D0", hash_generated_method = "33F921B8E266BA77FD9A621DF2DFDB10")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void run() {
            clearListSelection();
            // ---------- Original Method ----------
            //clearListSelection();
        }

        
    }


    
    private class ResizePopupRunnable implements Runnable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.476 -0400", hash_original_method = "91B25A9931F292828B5A54C887396F19", hash_generated_method = "91B25A9931F292828B5A54C887396F19")
                public ResizePopupRunnable ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.477 -0400", hash_original_method = "A0D6625363C0412112380631C620D963", hash_generated_method = "081CE1029629C797F8893767253E7276")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void run() {
            {
                boolean varE9C71312359CF178D4C417E85CE87FC0_1209444476 = (mDropDownList != null && mDropDownList.getCount() > mDropDownList.getChildCount() &&
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.477 -0400", hash_original_method = "E66C997F3C2F28BCF1426B2EF42703EA", hash_generated_method = "E66C997F3C2F28BCF1426B2EF42703EA")
                public PopupTouchInterceptor ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.477 -0400", hash_original_method = "6DB51D562B35DA9065539F31B98AD12D", hash_generated_method = "AABAE2A363C87656A6BEF190B86BD33A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean onTouch(View v, MotionEvent event) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(v.dsTaint);
            dsTaint.addTaint(event.dsTaint);
            int action;
            action = event.getAction();
            int x;
            x = (int) event.getX();
            int y;
            y = (int) event.getY();
            {
                boolean var82507E865584DF35A671D82C7F963539_1374645045 = (action == MotionEvent.ACTION_DOWN &&
                    mPopup != null && mPopup.isShowing() &&
                    (x >= 0 && x < mPopup.getWidth() && y >= 0 && y < mPopup.getHeight()));
                {
                    mHandler.postDelayed(mResizePopupRunnable, EXPAND_LIST_TIMEOUT);
                } //End block
                {
                    mHandler.removeCallbacks(mResizePopupRunnable);
                } //End block
            } //End collapsed parenthetic
            return dsTaint.getTaintBoolean();
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.477 -0400", hash_original_method = "8203CD546DEF5B5E2DBBAD3667B8D139", hash_generated_method = "8203CD546DEF5B5E2DBBAD3667B8D139")
                public PopupScrollListener ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.477 -0400", hash_original_method = "6B5691236DBDB14CA060F218338C51C6", hash_generated_method = "B76B229D4EB38550950AC1CC76B3D640")
        @DSModeled(DSC.SAFE)
        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount,
                int totalItemCount) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(totalItemCount);
            dsTaint.addTaint(view.dsTaint);
            dsTaint.addTaint(visibleItemCount);
            dsTaint.addTaint(firstVisibleItem);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.478 -0400", hash_original_method = "50D93865D772C2EF3B15BE53BF421FFA", hash_generated_method = "2F1C4FBDB055C3E03801FAFB68591A02")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onScrollStateChanged(AbsListView view, int scrollState) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(view.dsTaint);
            dsTaint.addTaint(scrollState);
            {
                boolean var812725D6D4B7B7F1E2BFD35C1B20C4F6_1876958782 = (scrollState == SCROLL_STATE_TOUCH_SCROLL &&
                    !isInputMethodNotNeeded() && mPopup.getContentView() != null);
                {
                    mHandler.removeCallbacks(mResizePopupRunnable);
                    mResizePopupRunnable.run();
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //if (scrollState == SCROLL_STATE_TOUCH_SCROLL &&
                    //!isInputMethodNotNeeded() && mPopup.getContentView() != null) {
                //mHandler.removeCallbacks(mResizePopupRunnable);
                //mResizePopupRunnable.run();
            //}
        }

        
    }


    
    private static final String TAG = "ListPopupWindow";
    private static final boolean DEBUG = false;
    private static final int EXPAND_LIST_TIMEOUT = 250;
    public static final int POSITION_PROMPT_ABOVE = 0;
    public static final int POSITION_PROMPT_BELOW = 1;
    public static final int MATCH_PARENT = ViewGroup.LayoutParams.MATCH_PARENT;
    public static final int WRAP_CONTENT = ViewGroup.LayoutParams.WRAP_CONTENT;
    public static final int INPUT_METHOD_FROM_FOCUSABLE = PopupWindow.INPUT_METHOD_FROM_FOCUSABLE;
    public static final int INPUT_METHOD_NEEDED = PopupWindow.INPUT_METHOD_NEEDED;
    public static final int INPUT_METHOD_NOT_NEEDED = PopupWindow.INPUT_METHOD_NOT_NEEDED;
}

