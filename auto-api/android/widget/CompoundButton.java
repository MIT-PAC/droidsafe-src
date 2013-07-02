package android.widget;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import com.android.internal.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewDebug;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

public abstract class CompoundButton extends Button implements Checkable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.258 -0400", hash_original_field = "B7985199D35C1155A55567C458443B15", hash_generated_field = "5B3EF9355FF9C7031B185F0E3C8A05A3")

    private boolean mChecked;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.258 -0400", hash_original_field = "911429B0E8C3F9D379452962885E164A", hash_generated_field = "F7281DF8986A8AAA3358888CEF5418EC")

    private int mButtonResource;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.258 -0400", hash_original_field = "CE69191B8D46DC7CD6168E55304ABD24", hash_generated_field = "5933F8BEFDC1D6F561EDC936859AE435")

    private boolean mBroadcasting;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.258 -0400", hash_original_field = "7E16EF1021873CBCE6E6FEB6B7F4EB95", hash_generated_field = "504A761B2A37294B367C41E884729E06")

    private Drawable mButtonDrawable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.258 -0400", hash_original_field = "1A92EAC72E569629103256FCA72C7A7E", hash_generated_field = "CADA2218212B45C2541514362AD86DC5")

    private OnCheckedChangeListener mOnCheckedChangeListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.258 -0400", hash_original_field = "D9409AC53F31501D16A634468204FD89", hash_generated_field = "568693E6FE3597BED062BE1553841524")

    private OnCheckedChangeListener mOnCheckedChangeWidgetListener;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.258 -0400", hash_original_method = "09BDBE7CE6F05C0EF8277BC374FA0AC6", hash_generated_method = "368C048C7070EA937F4D6E8B7BC1059F")
    public  CompoundButton(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.259 -0400", hash_original_method = "971C0A1E5EDCDBE9454DEBB4776AC79B", hash_generated_method = "49AAC351D56302E5F53F0FA6BA95999D")
    public  CompoundButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.259 -0400", hash_original_method = "486B323903576A8E24B1C8D9A5D1C983", hash_generated_method = "9B28A2248AE8563ACA3A64335A532EC8")
    public  CompoundButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TypedArray a = context.obtainStyledAttributes(
                        attrs, com.android.internal.R.styleable.CompoundButton, defStyle, 0);
        Drawable d = a.getDrawable(com.android.internal.R.styleable.CompoundButton_button);
        {
            setButtonDrawable(d);
        } 
        boolean checked = a
                .getBoolean(com.android.internal.R.styleable.CompoundButton_checked, false);
        setChecked(checked);
        a.recycle();
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        addTaint(defStyle);
        
        
                
                        
        
        
            
        
        
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.259 -0400", hash_original_method = "E1B1AD330E2148117F43C315FF6D1DED", hash_generated_method = "3679ED1F891BEC88079198707411C40A")
    public void toggle() {
        setChecked(!mChecked);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.259 -0400", hash_original_method = "CF8A2026FDAB35E1C88301DD3EB518FB", hash_generated_method = "A99EA5877C17C9FE69880156AA173A28")
    @Override
    public boolean performClick() {
        toggle();
        boolean varFDB962A01BB6992CCE0825DD130F7D67_1025805437 = (super.performClick());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_75374864 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_75374864;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.259 -0400", hash_original_method = "1057BD246BBC96B40BF6B862055C5AB8", hash_generated_method = "96C973E86354251944468AAA1BD08B93")
    @ViewDebug.ExportedProperty
    public boolean isChecked() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1118824113 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1118824113;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.260 -0400", hash_original_method = "CA54800DCB28AE61300AD40B91914282", hash_generated_method = "70C10E8F0DE900426B29F32EDA7E2523")
    public void setChecked(boolean checked) {
        {
            mChecked = checked;
            refreshDrawableState();
            mBroadcasting = true;
            {
                mOnCheckedChangeListener.onCheckedChanged(this, mChecked);
            } 
            {
                mOnCheckedChangeWidgetListener.onCheckedChanged(this, mChecked);
            } 
            mBroadcasting = false;
        } 
        
        
            
            
            
                
            
            
            
                
            
            
                
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.260 -0400", hash_original_method = "C2FB0C98D5222F68A09A56AA82371FFE", hash_generated_method = "E7A52B8D01F324B4A1B6AA133FD3E1C1")
    public void setOnCheckedChangeListener(OnCheckedChangeListener listener) {
        mOnCheckedChangeListener = listener;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.260 -0400", hash_original_method = "CC17A77F98E8CA70C4846D647AA35249", hash_generated_method = "A56A31C0300B93A41C104B6DF066BB90")
     void setOnCheckedChangeWidgetListener(OnCheckedChangeListener listener) {
        mOnCheckedChangeWidgetListener = listener;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.261 -0400", hash_original_method = "854EF2446DBF034657A969188723C50F", hash_generated_method = "E41B233F065032080AF18174C3E0861E")
    public void setButtonDrawable(int resid) {
        mButtonResource = resid;
        Drawable d = null;
        {
            d = getResources().getDrawable(mButtonResource);
        } 
        setButtonDrawable(d);
        
        
            
        
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.262 -0400", hash_original_method = "82099279959514BCCDE965E8456BDB6A", hash_generated_method = "636A3ED6AE58129C71B71C3C175EB41F")
    public void setButtonDrawable(Drawable d) {
        {
            {
                mButtonDrawable.setCallback(null);
                unscheduleDrawable(mButtonDrawable);
            } 
            d.setCallback(this);
            d.setState(getDrawableState());
            d.setVisible(getVisibility() == VISIBLE, false);
            mButtonDrawable = d;
            mButtonDrawable.setState(null);
            setMinHeight(mButtonDrawable.getIntrinsicHeight());
        } 
        refreshDrawableState();
        
        
            
                
                
            
            
            
            
            
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.262 -0400", hash_original_method = "E1DFB2AF73729EA8AA28BE1E77594577", hash_generated_method = "C5E84CDB159FDC21AE91720249A51759")
    @Override
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        
        super.onInitializeAccessibilityEvent(event);
        event.setChecked(mChecked);
        addTaint(event.getTaint());
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.262 -0400", hash_original_method = "9295691F1B4364B400425405F52CF8A7", hash_generated_method = "E5F7677139F52A01AC2F9D36EBB8FADD")
    @Override
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        
        super.onInitializeAccessibilityNodeInfo(info);
        info.setCheckable(true);
        info.setChecked(mChecked);
        addTaint(info.getTaint());
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.263 -0400", hash_original_method = "B5E74BEF46452CACB638287F10D23674", hash_generated_method = "D7EB464763E5303E823EEEABC3675224")
    @Override
    protected void onDraw(Canvas canvas) {
        
        super.onDraw(canvas);
        final Drawable buttonDrawable = mButtonDrawable;
        {
            final int verticalGravity = getGravity() & Gravity.VERTICAL_GRAVITY_MASK;
            final int height = buttonDrawable.getIntrinsicHeight();
            int y = 0;
            
            y = getHeight() - height;
            
            
            y = (getHeight() - height) / 2;
            
            buttonDrawable.setBounds(0, y, buttonDrawable.getIntrinsicWidth(), y + height);
            buttonDrawable.draw(canvas);
        } 
        addTaint(canvas.getTaint());
        
        
        
        
            
            
            
            
                
                    
                    
                
                    
                    
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.263 -0400", hash_original_method = "E661308564BAD0BE96E34DA026589671", hash_generated_method = "1A3A19989A625203CEA0EB9F35E9C51E")
    @Override
    protected int[] onCreateDrawableState(int extraSpace) {
        
        final int[] drawableState = super.onCreateDrawableState(extraSpace + 1);
        {
            boolean varCEC0E711DC0F7C8E920C6F998438D53D_1170067887 = (isChecked());
            {
                mergeDrawableStates(drawableState, CHECKED_STATE_SET);
            } 
        } 
        addTaint(extraSpace);
        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_294454296 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_294454296;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.264 -0400", hash_original_method = "7BF0D1F93DFA890868347E7C98BCCE2C", hash_generated_method = "50CFF55BAA340DA1A68A04E9854A9BBF")
    @Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        {
            int[] myDrawableState = getDrawableState();
            mButtonDrawable.setState(myDrawableState);
            invalidate();
        } 
        
        
        
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.264 -0400", hash_original_method = "63DA0D6846E19577C9E55E51C4E55CAC", hash_generated_method = "2C68D987EFB6E27EFB530419F09B0ED3")
    @Override
    protected boolean verifyDrawable(Drawable who) {
        boolean var8BBEA139816D93F09A5C54F2A2C942A4_540681273 = (super.verifyDrawable(who) || who == mButtonDrawable);
        addTaint(who.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1049802358 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1049802358;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.264 -0400", hash_original_method = "22D17E2BEF2192B0ED8786E02090A3E8", hash_generated_method = "603085D5CFEF4919B14F420F25110E1E")
    @Override
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        mButtonDrawable.jumpToCurrentState();
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.265 -0400", hash_original_method = "C906A6F68E532E790B1685DD63ECE7DE", hash_generated_method = "556DE7F728804C77CA957AD6C38884B8")
    @Override
    public Parcelable onSaveInstanceState() {
        
        Parcelable varB4EAC82CA7396A68D541C85D26508E83_844942286 = null; 
        setFreezesText(true);
        Parcelable superState = super.onSaveInstanceState();
        SavedState ss = new SavedState(superState);
        ss.checked = isChecked();
        varB4EAC82CA7396A68D541C85D26508E83_844942286 = ss;
        varB4EAC82CA7396A68D541C85D26508E83_844942286.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_844942286;
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.265 -0400", hash_original_method = "82857D3CD54F7EB52721411B0B0DD538", hash_generated_method = "86831017281667B27B19A6A49DA53A9B")
    @Override
    public void onRestoreInstanceState(Parcelable state) {
        
        SavedState ss = (SavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());
        setChecked(ss.checked);
        requestLayout();
        addTaint(state.getTaint());
        
        
        
        
        
    }

    
    static class SavedState extends BaseSavedState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.265 -0400", hash_original_field = "3793EA52A7BE2D7DEAFD858FDA50775C", hash_generated_field = "6F0D05495423C9405B09D32CCA18EA7F")

        boolean checked;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.266 -0400", hash_original_method = "89EB4EC154F05BF905ECA8E02BBD14BC", hash_generated_method = "3F4F70129FCB46E4AE0D334AE4D70CF6")
          SavedState(Parcelable superState) {
            super(superState);
            addTaint(superState.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.266 -0400", hash_original_method = "527F999E441AD9A28BC136B181E8236B", hash_generated_method = "D51BA829018FE61D140FB0956773F5A3")
        private  SavedState(Parcel in) {
            super(in);
            checked = (Boolean)in.readValue(null);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.266 -0400", hash_original_method = "42336FB9BEBA29D5024EB2A7DFCC6545", hash_generated_method = "0A4A73E3117FC7A7EE15B410D409C48D")
        @Override
        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeValue(checked);
            addTaint(out.getTaint());
            addTaint(flags);
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.267 -0400", hash_original_method = "F6EC4DB06CBAC48467361A043CC860D0", hash_generated_method = "5580B0342A4DF504586826B44A1899E0")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_2059220859 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_2059220859 = "CompoundButton.SavedState{"
                    + Integer.toHexString(System.identityHashCode(this))
                    + " checked=" + checked + "}";
            varB4EAC82CA7396A68D541C85D26508E83_2059220859.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_2059220859;
            
            
                    
                    
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.267 -0400", hash_original_field = "7DF6FB2587CB67E9544A859A8F6E8FF3", hash_generated_field = "263FCDD65C2156B1D1E1B4D9AE8D7FFA")

        public static final Parcelable.Creator<SavedState> CREATOR
                = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
        
        public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }
        
        
        public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        
    }


    
    public static interface OnCheckedChangeListener {
        
        void onCheckedChanged(CompoundButton buttonView, boolean isChecked);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.267 -0400", hash_original_field = "312B7CC8C1FC8133C5B1FE8103106614", hash_generated_field = "648B080756031EA789B9ECD9F36CC170")

    private static final int[] CHECKED_STATE_SET = {
        R.attr.state_checked
    };
}

