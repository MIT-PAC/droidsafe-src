package android.widget;

// Droidsafe Imports
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

import com.android.internal.R;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public abstract class CompoundButton extends Button implements Checkable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.999 -0400", hash_original_field = "B7985199D35C1155A55567C458443B15", hash_generated_field = "5B3EF9355FF9C7031B185F0E3C8A05A3")

    private boolean mChecked;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.999 -0400", hash_original_field = "911429B0E8C3F9D379452962885E164A", hash_generated_field = "F7281DF8986A8AAA3358888CEF5418EC")

    private int mButtonResource;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.999 -0400", hash_original_field = "CE69191B8D46DC7CD6168E55304ABD24", hash_generated_field = "5933F8BEFDC1D6F561EDC936859AE435")

    private boolean mBroadcasting;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.999 -0400", hash_original_field = "7E16EF1021873CBCE6E6FEB6B7F4EB95", hash_generated_field = "504A761B2A37294B367C41E884729E06")

    private Drawable mButtonDrawable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.999 -0400", hash_original_field = "1A92EAC72E569629103256FCA72C7A7E", hash_generated_field = "CADA2218212B45C2541514362AD86DC5")

    private OnCheckedChangeListener mOnCheckedChangeListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.999 -0400", hash_original_field = "D9409AC53F31501D16A634468204FD89", hash_generated_field = "568693E6FE3597BED062BE1553841524")

    private OnCheckedChangeListener mOnCheckedChangeWidgetListener;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.999 -0400", hash_original_method = "09BDBE7CE6F05C0EF8277BC374FA0AC6", hash_generated_method = "368C048C7070EA937F4D6E8B7BC1059F")
    public  CompoundButton(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.000 -0400", hash_original_method = "971C0A1E5EDCDBE9454DEBB4776AC79B", hash_generated_method = "7353B66FF27C4970D2E44CE0EAEB9515")
    public  CompoundButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.001 -0400", hash_original_method = "486B323903576A8E24B1C8D9A5D1C983", hash_generated_method = "359F4B0FAC9D447060113734E42DDE5B")
    public  CompoundButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        addTaint(defStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        TypedArray a = context.obtainStyledAttributes(
                        attrs, com.android.internal.R.styleable.CompoundButton, defStyle, 0);
        Drawable d = a.getDrawable(com.android.internal.R.styleable.CompoundButton_button);
        if(d != null)        
        {
            setButtonDrawable(d);
        } //End block
        boolean checked = a
                .getBoolean(com.android.internal.R.styleable.CompoundButton_checked, false);
        setChecked(checked);
        a.recycle();
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.001 -0400", hash_original_method = "E1B1AD330E2148117F43C315FF6D1DED", hash_generated_method = "3679ED1F891BEC88079198707411C40A")
    public void toggle() {
        setChecked(!mChecked);
        // ---------- Original Method ----------
        //setChecked(!mChecked);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.001 -0400", hash_original_method = "CF8A2026FDAB35E1C88301DD3EB518FB", hash_generated_method = "47EBCE36427ECEEA5BA67D9CFB45236E")
    @Override
    public boolean performClick() {
        toggle();
        boolean varBAE6DB88A1184B017FD0C595C5A7DECE_46006984 = (super.performClick());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1459806586 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1459806586;
        // ---------- Original Method ----------
        //toggle();
        //return super.performClick();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.002 -0400", hash_original_method = "1057BD246BBC96B40BF6B862055C5AB8", hash_generated_method = "988B7BCD7218CB601573575804998758")
    @ViewDebug.ExportedProperty
    public boolean isChecked() {
        boolean varB7985199D35C1155A55567C458443B15_1437175263 = (mChecked);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1389811453 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1389811453;
        // ---------- Original Method ----------
        //return mChecked;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.003 -0400", hash_original_method = "CA54800DCB28AE61300AD40B91914282", hash_generated_method = "2E9859E3BD82B02F24A5D1C213A27F35")
    public void setChecked(boolean checked) {
        if(mChecked != checked)        
        {
            mChecked = checked;
            refreshDrawableState();
            if(mBroadcasting)            
            {
                return;
            } //End block
            mBroadcasting = true;
            if(mOnCheckedChangeListener != null)            
            {
                mOnCheckedChangeListener.onCheckedChanged(this, mChecked);
            } //End block
            if(mOnCheckedChangeWidgetListener != null)            
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.004 -0400", hash_original_method = "C2FB0C98D5222F68A09A56AA82371FFE", hash_generated_method = "E7A52B8D01F324B4A1B6AA133FD3E1C1")
    public void setOnCheckedChangeListener(OnCheckedChangeListener listener) {
        mOnCheckedChangeListener = listener;
        // ---------- Original Method ----------
        //mOnCheckedChangeListener = listener;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.004 -0400", hash_original_method = "CC17A77F98E8CA70C4846D647AA35249", hash_generated_method = "A56A31C0300B93A41C104B6DF066BB90")
     void setOnCheckedChangeWidgetListener(OnCheckedChangeListener listener) {
        mOnCheckedChangeWidgetListener = listener;
        // ---------- Original Method ----------
        //mOnCheckedChangeWidgetListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.005 -0400", hash_original_method = "854EF2446DBF034657A969188723C50F", hash_generated_method = "019C7FF9F36371F1FBA9D22F4CADF7D7")
    public void setButtonDrawable(int resid) {
        if(resid != 0 && resid == mButtonResource)        
        {
            return;
        } //End block
        mButtonResource = resid;
        Drawable d = null;
        if(mButtonResource != 0)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.006 -0400", hash_original_method = "82099279959514BCCDE965E8456BDB6A", hash_generated_method = "E1A5BDA7C9A4C3627AC3AAC6A277A051")
    public void setButtonDrawable(Drawable d) {
        if(d != null)        
        {
            if(mButtonDrawable != null)            
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.007 -0400", hash_original_method = "E1DFB2AF73729EA8AA28BE1E77594577", hash_generated_method = "76E27B80562C985CD49B030FF046F855")
    @Override
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        super.onInitializeAccessibilityEvent(event);
        event.setChecked(mChecked);
        // ---------- Original Method ----------
        //super.onInitializeAccessibilityEvent(event);
        //event.setChecked(mChecked);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.007 -0400", hash_original_method = "9295691F1B4364B400425405F52CF8A7", hash_generated_method = "F5460BFFB79998D9BC1B4FE82C0244AD")
    @Override
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(info.getTaint());
        super.onInitializeAccessibilityNodeInfo(info);
        info.setCheckable(true);
        info.setChecked(mChecked);
        // ---------- Original Method ----------
        //super.onInitializeAccessibilityNodeInfo(info);
        //info.setCheckable(true);
        //info.setChecked(mChecked);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.008 -0400", hash_original_method = "B5E74BEF46452CACB638287F10D23674", hash_generated_method = "17C79038C25E0BCBF4CE5F11890B2316")
    @Override
    protected void onDraw(Canvas canvas) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(canvas.getTaint());
        super.onDraw(canvas);
        final Drawable buttonDrawable = mButtonDrawable;
        if(buttonDrawable != null)        
        {
            final int verticalGravity = getGravity() & Gravity.VERTICAL_GRAVITY_MASK;
            final int height = buttonDrawable.getIntrinsicHeight();
            int y = 0;
switch(verticalGravity){
            case Gravity.BOTTOM:
            y = getHeight() - height;
            break;
            case Gravity.CENTER_VERTICAL:
            y = (getHeight() - height) / 2;
            break;
}            buttonDrawable.setBounds(0, y, buttonDrawable.getIntrinsicWidth(), y + height);
            buttonDrawable.draw(canvas);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.010 -0400", hash_original_method = "E661308564BAD0BE96E34DA026589671", hash_generated_method = "4EAC628E56F2A59C8991B7C13D5EEC53")
    @Override
    protected int[] onCreateDrawableState(int extraSpace) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(extraSpace);
        final int[] drawableState = super.onCreateDrawableState(extraSpace + 1);
        if(isChecked())        
        {
            mergeDrawableStates(drawableState, CHECKED_STATE_SET);
        } //End block
        int[] var7A12E87773589D809FD51F1A26B9BDA9_26638819 = (drawableState);
                int[] varB4CCCA26F9DB9189C32F33E82D425CFB_2048619823 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_2048619823;
        // ---------- Original Method ----------
        //final int[] drawableState = super.onCreateDrawableState(extraSpace + 1);
        //if (isChecked()) {
            //mergeDrawableStates(drawableState, CHECKED_STATE_SET);
        //}
        //return drawableState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.010 -0400", hash_original_method = "7BF0D1F93DFA890868347E7C98BCCE2C", hash_generated_method = "EAEC5B0B26F54C2574850E1A7B2E074C")
    @Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if(mButtonDrawable != null)        
        {
            int[] myDrawableState = getDrawableState();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.011 -0400", hash_original_method = "63DA0D6846E19577C9E55E51C4E55CAC", hash_generated_method = "54E2AA1D6575A997C3416B9FC23772A1")
    @Override
    protected boolean verifyDrawable(Drawable who) {
        addTaint(who.getTaint());
        boolean var0A5CAA2536AE615FDE8DCB73439B116D_212865108 = (super.verifyDrawable(who) || who == mButtonDrawable);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1544448006 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1544448006;
        // ---------- Original Method ----------
        //return super.verifyDrawable(who) || who == mButtonDrawable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.011 -0400", hash_original_method = "22D17E2BEF2192B0ED8786E02090A3E8", hash_generated_method = "84625F90FB1A4178475DE2BA57AD445C")
    @Override
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if(mButtonDrawable != null)        
        mButtonDrawable.jumpToCurrentState();
        // ---------- Original Method ----------
        //super.jumpDrawablesToCurrentState();
        //if (mButtonDrawable != null) mButtonDrawable.jumpToCurrentState();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.012 -0400", hash_original_method = "C906A6F68E532E790B1685DD63ECE7DE", hash_generated_method = "599DC22562ADFFE15E503E86AD337C8B")
    @Override
    public Parcelable onSaveInstanceState() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        setFreezesText(true);
        Parcelable superState = super.onSaveInstanceState();
        SavedState ss = new SavedState(superState);
        ss.checked = isChecked();
Parcelable var182E37827114C3F455816E0E29D81D76_388557675 =         ss;
        var182E37827114C3F455816E0E29D81D76_388557675.addTaint(taint);
        return var182E37827114C3F455816E0E29D81D76_388557675;
        // ---------- Original Method ----------
        //setFreezesText(true);
        //Parcelable superState = super.onSaveInstanceState();
        //SavedState ss = new SavedState(superState);
        //ss.checked = isChecked();
        //return ss;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.012 -0400", hash_original_method = "82857D3CD54F7EB52721411B0B0DD538", hash_generated_method = "32CC6D8B526C9BA090BE711C8896619C")
    @Override
    public void onRestoreInstanceState(Parcelable state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(state.getTaint());
        SavedState ss = (SavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());
        setChecked(ss.checked);
        requestLayout();
        // ---------- Original Method ----------
        //SavedState ss = (SavedState) state;
        //super.onRestoreInstanceState(ss.getSuperState());
        //setChecked(ss.checked);
        //requestLayout();
    }

    
    static class SavedState extends BaseSavedState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.012 -0400", hash_original_field = "3793EA52A7BE2D7DEAFD858FDA50775C", hash_generated_field = "6F0D05495423C9405B09D32CCA18EA7F")

        boolean checked;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.012 -0400", hash_original_method = "89EB4EC154F05BF905ECA8E02BBD14BC", hash_generated_method = "3F4F70129FCB46E4AE0D334AE4D70CF6")
          SavedState(Parcelable superState) {
            super(superState);
            addTaint(superState.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.012 -0400", hash_original_method = "527F999E441AD9A28BC136B181E8236B", hash_generated_method = "D51BA829018FE61D140FB0956773F5A3")
        private  SavedState(Parcel in) {
            super(in);
            checked = (Boolean)in.readValue(null);
            // ---------- Original Method ----------
            //checked = (Boolean)in.readValue(null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.012 -0400", hash_original_method = "42336FB9BEBA29D5024EB2A7DFCC6545", hash_generated_method = "00AF90A3F46EBE530FBD107483734C01")
        @Override
        public void writeToParcel(Parcel out, int flags) {
            addTaint(flags);
            addTaint(out.getTaint());
            super.writeToParcel(out, flags);
            out.writeValue(checked);
            // ---------- Original Method ----------
            //super.writeToParcel(out, flags);
            //out.writeValue(checked);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.013 -0400", hash_original_method = "F6EC4DB06CBAC48467361A043CC860D0", hash_generated_method = "E2721326BED87EF028A0FE4DFFD86476")
        @Override
        public String toString() {
String var75C72613A101136F5AE898E5495772E0_9710418 =             "CompoundButton.SavedState{"
                    + Integer.toHexString(System.identityHashCode(this))
                    + " checked=" + checked + "}";
            var75C72613A101136F5AE898E5495772E0_9710418.addTaint(taint);
            return var75C72613A101136F5AE898E5495772E0_9710418;
            // ---------- Original Method ----------
            //return "CompoundButton.SavedState{"
                    //+ Integer.toHexString(System.identityHashCode(this))
                    //+ " checked=" + checked + "}";
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.013 -0400", hash_original_field = "7DF6FB2587CB67E9544A859A8F6E8FF3", hash_generated_field = "263FCDD65C2156B1D1E1B4D9AE8D7FFA")

        public static final Parcelable.Creator<SavedState> CREATOR
                = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
        // orphaned legacy method
        public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }
        
        // orphaned legacy method
        public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        
    }


    
    public static interface OnCheckedChangeListener {
        
        void onCheckedChanged(CompoundButton buttonView, boolean isChecked);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.013 -0400", hash_original_field = "312B7CC8C1FC8133C5B1FE8103106614", hash_generated_field = "648B080756031EA789B9ECD9F36CC170")

    private static final int[] CHECKED_STATE_SET = {
        R.attr.state_checked
    };
}

