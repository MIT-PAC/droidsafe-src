package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.302 -0400", hash_original_field = "B7985199D35C1155A55567C458443B15", hash_generated_field = "5B3EF9355FF9C7031B185F0E3C8A05A3")

    private boolean mChecked;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.302 -0400", hash_original_field = "911429B0E8C3F9D379452962885E164A", hash_generated_field = "F7281DF8986A8AAA3358888CEF5418EC")

    private int mButtonResource;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.302 -0400", hash_original_field = "CE69191B8D46DC7CD6168E55304ABD24", hash_generated_field = "5933F8BEFDC1D6F561EDC936859AE435")

    private boolean mBroadcasting;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.302 -0400", hash_original_field = "7E16EF1021873CBCE6E6FEB6B7F4EB95", hash_generated_field = "504A761B2A37294B367C41E884729E06")

    private Drawable mButtonDrawable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.302 -0400", hash_original_field = "1A92EAC72E569629103256FCA72C7A7E", hash_generated_field = "CADA2218212B45C2541514362AD86DC5")

    private OnCheckedChangeListener mOnCheckedChangeListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.302 -0400", hash_original_field = "D9409AC53F31501D16A634468204FD89", hash_generated_field = "568693E6FE3597BED062BE1553841524")

    private OnCheckedChangeListener mOnCheckedChangeWidgetListener;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.303 -0400", hash_original_method = "09BDBE7CE6F05C0EF8277BC374FA0AC6", hash_generated_method = "368C048C7070EA937F4D6E8B7BC1059F")
    public  CompoundButton(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.303 -0400", hash_original_method = "971C0A1E5EDCDBE9454DEBB4776AC79B", hash_generated_method = "49AAC351D56302E5F53F0FA6BA95999D")
    public  CompoundButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.311 -0400", hash_original_method = "486B323903576A8E24B1C8D9A5D1C983", hash_generated_method = "5A7601D1695437B3B2C221A8E4FDBE0D")
    public  CompoundButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TypedArray a;
        a = context.obtainStyledAttributes(
                        attrs, com.android.internal.R.styleable.CompoundButton, defStyle, 0);
        Drawable d;
        d = a.getDrawable(com.android.internal.R.styleable.CompoundButton_button);
        {
            setButtonDrawable(d);
        } //End block
        boolean checked;
        checked = a
                .getBoolean(com.android.internal.R.styleable.CompoundButton_checked, false);
        setChecked(checked);
        a.recycle();
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        addTaint(defStyle);
        // ---------- Original Method ----------
        //TypedArray a =
                //context.obtainStyledAttributes(
                        //attrs, com.android.internal.R.styleable.CompoundButton, defStyle, 0);
        //Drawable d = a.getDrawable(com.android.internal.R.styleable.CompoundButton_button);
        //if (d != null) {
            //setButtonDrawable(d);
        //}
        //boolean checked = a
                //.getBoolean(com.android.internal.R.styleable.CompoundButton_checked, false);
        //setChecked(checked);
        //a.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.317 -0400", hash_original_method = "E1B1AD330E2148117F43C315FF6D1DED", hash_generated_method = "3679ED1F891BEC88079198707411C40A")
    public void toggle() {
        setChecked(!mChecked);
        // ---------- Original Method ----------
        //setChecked(!mChecked);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.318 -0400", hash_original_method = "CF8A2026FDAB35E1C88301DD3EB518FB", hash_generated_method = "A23EA046E054AF9934FDDD24A83E0555")
    @Override
    public boolean performClick() {
        toggle();
        boolean varFDB962A01BB6992CCE0825DD130F7D67_1786877299 = (super.performClick());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_200808652 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_200808652;
        // ---------- Original Method ----------
        //toggle();
        //return super.performClick();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.319 -0400", hash_original_method = "1057BD246BBC96B40BF6B862055C5AB8", hash_generated_method = "8A6B6B71B01DD6DC1E749281B9EF5553")
    @ViewDebug.ExportedProperty
    public boolean isChecked() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_62357071 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_62357071;
        // ---------- Original Method ----------
        //return mChecked;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.320 -0400", hash_original_method = "CA54800DCB28AE61300AD40B91914282", hash_generated_method = "70C10E8F0DE900426B29F32EDA7E2523")
    public void setChecked(boolean checked) {
        {
            mChecked = checked;
            refreshDrawableState();
            mBroadcasting = true;
            {
                mOnCheckedChangeListener.onCheckedChanged(this, mChecked);
            } //End block
            {
                mOnCheckedChangeWidgetListener.onCheckedChanged(this, mChecked);
            } //End block
            mBroadcasting = false;
        } //End block
        // ---------- Original Method ----------
        //if (mChecked != checked) {
            //mChecked = checked;
            //refreshDrawableState();
            //if (mBroadcasting) {
                //return;
            //}
            //mBroadcasting = true;
            //if (mOnCheckedChangeListener != null) {
                //mOnCheckedChangeListener.onCheckedChanged(this, mChecked);
            //}
            //if (mOnCheckedChangeWidgetListener != null) {
                //mOnCheckedChangeWidgetListener.onCheckedChanged(this, mChecked);
            //}
            //mBroadcasting = false;            
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.324 -0400", hash_original_method = "C2FB0C98D5222F68A09A56AA82371FFE", hash_generated_method = "E7A52B8D01F324B4A1B6AA133FD3E1C1")
    public void setOnCheckedChangeListener(OnCheckedChangeListener listener) {
        mOnCheckedChangeListener = listener;
        // ---------- Original Method ----------
        //mOnCheckedChangeListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.328 -0400", hash_original_method = "CC17A77F98E8CA70C4846D647AA35249", hash_generated_method = "A56A31C0300B93A41C104B6DF066BB90")
     void setOnCheckedChangeWidgetListener(OnCheckedChangeListener listener) {
        mOnCheckedChangeWidgetListener = listener;
        // ---------- Original Method ----------
        //mOnCheckedChangeWidgetListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.333 -0400", hash_original_method = "854EF2446DBF034657A969188723C50F", hash_generated_method = "21F999BD8B255467959553355F827311")
    public void setButtonDrawable(int resid) {
        mButtonResource = resid;
        Drawable d;
        d = null;
        {
            d = getResources().getDrawable(mButtonResource);
        } //End block
        setButtonDrawable(d);
        // ---------- Original Method ----------
        //if (resid != 0 && resid == mButtonResource) {
            //return;
        //}
        //mButtonResource = resid;
        //Drawable d = null;
        //if (mButtonResource != 0) {
            //d = getResources().getDrawable(mButtonResource);
        //}
        //setButtonDrawable(d);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.353 -0400", hash_original_method = "82099279959514BCCDE965E8456BDB6A", hash_generated_method = "636A3ED6AE58129C71B71C3C175EB41F")
    public void setButtonDrawable(Drawable d) {
        {
            {
                mButtonDrawable.setCallback(null);
                unscheduleDrawable(mButtonDrawable);
            } //End block
            d.setCallback(this);
            d.setState(getDrawableState());
            d.setVisible(getVisibility() == VISIBLE, false);
            mButtonDrawable = d;
            mButtonDrawable.setState(null);
            setMinHeight(mButtonDrawable.getIntrinsicHeight());
        } //End block
        refreshDrawableState();
        // ---------- Original Method ----------
        //if (d != null) {
            //if (mButtonDrawable != null) {
                //mButtonDrawable.setCallback(null);
                //unscheduleDrawable(mButtonDrawable);
            //}
            //d.setCallback(this);
            //d.setState(getDrawableState());
            //d.setVisible(getVisibility() == VISIBLE, false);
            //mButtonDrawable = d;
            //mButtonDrawable.setState(null);
            //setMinHeight(mButtonDrawable.getIntrinsicHeight());
        //}
        //refreshDrawableState();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.353 -0400", hash_original_method = "E1DFB2AF73729EA8AA28BE1E77594577", hash_generated_method = "C5E84CDB159FDC21AE91720249A51759")
    @Override
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onInitializeAccessibilityEvent(event);
        event.setChecked(mChecked);
        addTaint(event.getTaint());
        // ---------- Original Method ----------
        //super.onInitializeAccessibilityEvent(event);
        //event.setChecked(mChecked);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.354 -0400", hash_original_method = "9295691F1B4364B400425405F52CF8A7", hash_generated_method = "E5F7677139F52A01AC2F9D36EBB8FADD")
    @Override
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onInitializeAccessibilityNodeInfo(info);
        info.setCheckable(true);
        info.setChecked(mChecked);
        addTaint(info.getTaint());
        // ---------- Original Method ----------
        //super.onInitializeAccessibilityNodeInfo(info);
        //info.setCheckable(true);
        //info.setChecked(mChecked);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.355 -0400", hash_original_method = "B5E74BEF46452CACB638287F10D23674", hash_generated_method = "D5B5B9A8DFFC4E998EF7A58AED6A07E6")
    @Override
    protected void onDraw(Canvas canvas) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onDraw(canvas);
        Drawable buttonDrawable;
        buttonDrawable = mButtonDrawable;
        {
            int verticalGravity;
            verticalGravity = getGravity() & Gravity.VERTICAL_GRAVITY_MASK;
            int height;
            height = buttonDrawable.getIntrinsicHeight();
            int y;
            y = 0;
            //Begin case Gravity.BOTTOM 
            y = getHeight() - height;
            //End case Gravity.BOTTOM 
            //Begin case Gravity.CENTER_VERTICAL 
            y = (getHeight() - height) / 2;
            //End case Gravity.CENTER_VERTICAL 
            buttonDrawable.setBounds(0, y, buttonDrawable.getIntrinsicWidth(), y + height);
            buttonDrawable.draw(canvas);
        } //End block
        addTaint(canvas.getTaint());
        // ---------- Original Method ----------
        //super.onDraw(canvas);
        //final Drawable buttonDrawable = mButtonDrawable;
        //if (buttonDrawable != null) {
            //final int verticalGravity = getGravity() & Gravity.VERTICAL_GRAVITY_MASK;
            //final int height = buttonDrawable.getIntrinsicHeight();
            //int y = 0;
            //switch (verticalGravity) {
                //case Gravity.BOTTOM:
                    //y = getHeight() - height;
                    //break;
                //case Gravity.CENTER_VERTICAL:
                    //y = (getHeight() - height) / 2;
                    //break;
            //}
            //buttonDrawable.setBounds(0, y, buttonDrawable.getIntrinsicWidth(), y + height);
            //buttonDrawable.draw(canvas);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.356 -0400", hash_original_method = "E661308564BAD0BE96E34DA026589671", hash_generated_method = "5C8793093589CFAEB5E80B505D5F6AFC")
    @Override
    protected int[] onCreateDrawableState(int extraSpace) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        int[] drawableState;
        drawableState = super.onCreateDrawableState(extraSpace + 1);
        {
            boolean varCEC0E711DC0F7C8E920C6F998438D53D_1209462229 = (isChecked());
            {
                mergeDrawableStates(drawableState, CHECKED_STATE_SET);
            } //End block
        } //End collapsed parenthetic
        addTaint(extraSpace);
        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_213835205 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_213835205;
        // ---------- Original Method ----------
        //final int[] drawableState = super.onCreateDrawableState(extraSpace + 1);
        //if (isChecked()) {
            //mergeDrawableStates(drawableState, CHECKED_STATE_SET);
        //}
        //return drawableState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.356 -0400", hash_original_method = "7BF0D1F93DFA890868347E7C98BCCE2C", hash_generated_method = "CA547362BA13BAE1A4D068330EF152B8")
    @Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        {
            int[] myDrawableState;
            myDrawableState = getDrawableState();
            mButtonDrawable.setState(myDrawableState);
            invalidate();
        } //End block
        // ---------- Original Method ----------
        //super.drawableStateChanged();
        //if (mButtonDrawable != null) {
            //int[] myDrawableState = getDrawableState();
            //mButtonDrawable.setState(myDrawableState);
            //invalidate();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.357 -0400", hash_original_method = "63DA0D6846E19577C9E55E51C4E55CAC", hash_generated_method = "6182C37FC5DE6C556084E09D8D3A388D")
    @Override
    protected boolean verifyDrawable(Drawable who) {
        boolean var8BBEA139816D93F09A5C54F2A2C942A4_641461948 = (super.verifyDrawable(who) || who == mButtonDrawable);
        addTaint(who.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1216497095 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1216497095;
        // ---------- Original Method ----------
        //return super.verifyDrawable(who) || who == mButtonDrawable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.357 -0400", hash_original_method = "22D17E2BEF2192B0ED8786E02090A3E8", hash_generated_method = "603085D5CFEF4919B14F420F25110E1E")
    @Override
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        mButtonDrawable.jumpToCurrentState();
        // ---------- Original Method ----------
        //super.jumpDrawablesToCurrentState();
        //if (mButtonDrawable != null) mButtonDrawable.jumpToCurrentState();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.358 -0400", hash_original_method = "C906A6F68E532E790B1685DD63ECE7DE", hash_generated_method = "F905D8CF99EA98567906FFCF2B0B86E0")
    @Override
    public Parcelable onSaveInstanceState() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Parcelable varB4EAC82CA7396A68D541C85D26508E83_1041892931 = null; //Variable for return #1
        setFreezesText(true);
        Parcelable superState;
        superState = super.onSaveInstanceState();
        SavedState ss;
        ss = new SavedState(superState);
        ss.checked = isChecked();
        varB4EAC82CA7396A68D541C85D26508E83_1041892931 = ss;
        varB4EAC82CA7396A68D541C85D26508E83_1041892931.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1041892931;
        // ---------- Original Method ----------
        //setFreezesText(true);
        //Parcelable superState = super.onSaveInstanceState();
        //SavedState ss = new SavedState(superState);
        //ss.checked = isChecked();
        //return ss;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.359 -0400", hash_original_method = "82857D3CD54F7EB52721411B0B0DD538", hash_generated_method = "BA39E0C2B16547FED4F38247351E91F3")
    @Override
    public void onRestoreInstanceState(Parcelable state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        SavedState ss;
        ss = (SavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());
        setChecked(ss.checked);
        requestLayout();
        addTaint(state.getTaint());
        // ---------- Original Method ----------
        //SavedState ss = (SavedState) state;
        //super.onRestoreInstanceState(ss.getSuperState());
        //setChecked(ss.checked);
        //requestLayout();
    }

    
    static class SavedState extends BaseSavedState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.359 -0400", hash_original_field = "3793EA52A7BE2D7DEAFD858FDA50775C", hash_generated_field = "6F0D05495423C9405B09D32CCA18EA7F")

        boolean checked;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.359 -0400", hash_original_method = "89EB4EC154F05BF905ECA8E02BBD14BC", hash_generated_method = "3F4F70129FCB46E4AE0D334AE4D70CF6")
          SavedState(Parcelable superState) {
            super(superState);
            addTaint(superState.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.361 -0400", hash_original_method = "527F999E441AD9A28BC136B181E8236B", hash_generated_method = "D51BA829018FE61D140FB0956773F5A3")
        private  SavedState(Parcel in) {
            super(in);
            checked = (Boolean)in.readValue(null);
            // ---------- Original Method ----------
            //checked = (Boolean)in.readValue(null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.361 -0400", hash_original_method = "42336FB9BEBA29D5024EB2A7DFCC6545", hash_generated_method = "0A4A73E3117FC7A7EE15B410D409C48D")
        @Override
        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeValue(checked);
            addTaint(out.getTaint());
            addTaint(flags);
            // ---------- Original Method ----------
            //super.writeToParcel(out, flags);
            //out.writeValue(checked);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.361 -0400", hash_original_method = "F6EC4DB06CBAC48467361A043CC860D0", hash_generated_method = "4B5816333663A26E516DAA48716B2C73")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1198804912 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1198804912 = "CompoundButton.SavedState{"
                    + Integer.toHexString(System.identityHashCode(this))
                    + " checked=" + checked + "}";
            varB4EAC82CA7396A68D541C85D26508E83_1198804912.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1198804912;
            // ---------- Original Method ----------
            //return "CompoundButton.SavedState{"
                    //+ Integer.toHexString(System.identityHashCode(this))
                    //+ " checked=" + checked + "}";
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.362 -0400", hash_original_field = "7DF6FB2587CB67E9544A859A8F6E8FF3", hash_generated_field = "263FCDD65C2156B1D1E1B4D9AE8D7FFA")

        public static final Parcelable.Creator<SavedState> CREATOR
                = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
    }


    
    public static interface OnCheckedChangeListener {
        
        void onCheckedChanged(CompoundButton buttonView, boolean isChecked);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.383 -0400", hash_original_field = "312B7CC8C1FC8133C5B1FE8103106614", hash_generated_field = "D7B0DC844BB8D3506B70B08443A5B8E0")

    private static int[] CHECKED_STATE_SET = {
        R.attr.state_checked
    };
}

