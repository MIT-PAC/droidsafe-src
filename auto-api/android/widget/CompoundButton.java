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
    private boolean mChecked;
    private int mButtonResource;
    private boolean mBroadcasting;
    private Drawable mButtonDrawable;
    private OnCheckedChangeListener mOnCheckedChangeListener;
    private OnCheckedChangeListener mOnCheckedChangeWidgetListener;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.379 -0400", hash_original_method = "09BDBE7CE6F05C0EF8277BC374FA0AC6", hash_generated_method = "41DD20B14896048E3989D9FCCE8BA525")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CompoundButton(Context context) {
        this(context, null);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.379 -0400", hash_original_method = "971C0A1E5EDCDBE9454DEBB4776AC79B", hash_generated_method = "292A9003D8F8249B2E7A7026B58A137B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CompoundButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.379 -0400", hash_original_method = "486B323903576A8E24B1C8D9A5D1C983", hash_generated_method = "71491528A3CB29DE73917BC83B1E3328")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CompoundButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(defStyle);
        dsTaint.addTaint(context.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.379 -0400", hash_original_method = "E1B1AD330E2148117F43C315FF6D1DED", hash_generated_method = "3679ED1F891BEC88079198707411C40A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void toggle() {
        setChecked(!mChecked);
        // ---------- Original Method ----------
        //setChecked(!mChecked);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.380 -0400", hash_original_method = "CF8A2026FDAB35E1C88301DD3EB518FB", hash_generated_method = "47DF0C1DF670B626D55351D0FC2F14A3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean performClick() {
        toggle();
        boolean varFDB962A01BB6992CCE0825DD130F7D67_1899186987 = (super.performClick());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //toggle();
        //return super.performClick();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.380 -0400", hash_original_method = "1057BD246BBC96B40BF6B862055C5AB8", hash_generated_method = "617B031E915555E011BB44555F369867")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty
    public boolean isChecked() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mChecked;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.380 -0400", hash_original_method = "CA54800DCB28AE61300AD40B91914282", hash_generated_method = "2839726629972D407C82C084420DFDAF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setChecked(boolean checked) {
        dsTaint.addTaint(checked);
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.380 -0400", hash_original_method = "C2FB0C98D5222F68A09A56AA82371FFE", hash_generated_method = "162D5CD6DD70DC94E38F064351E3D564")
    @DSModeled(DSC.SAFE)
    public void setOnCheckedChangeListener(OnCheckedChangeListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        // ---------- Original Method ----------
        //mOnCheckedChangeListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.381 -0400", hash_original_method = "CC17A77F98E8CA70C4846D647AA35249", hash_generated_method = "5A2B9BE8B8FF1283C337C8A3CD024509")
    @DSModeled(DSC.SAFE)
     void setOnCheckedChangeWidgetListener(OnCheckedChangeListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        // ---------- Original Method ----------
        //mOnCheckedChangeWidgetListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.381 -0400", hash_original_method = "854EF2446DBF034657A969188723C50F", hash_generated_method = "AB22523B1F3D863BC800E98683FD0A7A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setButtonDrawable(int resid) {
        dsTaint.addTaint(resid);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.381 -0400", hash_original_method = "82099279959514BCCDE965E8456BDB6A", hash_generated_method = "AE77F82CD91A6453D2E72B97F50C077F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setButtonDrawable(Drawable d) {
        dsTaint.addTaint(d.dsTaint);
        {
            {
                mButtonDrawable.setCallback(null);
                unscheduleDrawable(mButtonDrawable);
            } //End block
            d.setCallback(this);
            d.setState(getDrawableState());
            d.setVisible(getVisibility() == VISIBLE, false);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.381 -0400", hash_original_method = "E1DFB2AF73729EA8AA28BE1E77594577", hash_generated_method = "E6ACD88241B33A8DDBF7251DC1B35F77")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(event.dsTaint);
        super.onInitializeAccessibilityEvent(event);
        event.setChecked(mChecked);
        // ---------- Original Method ----------
        //super.onInitializeAccessibilityEvent(event);
        //event.setChecked(mChecked);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.382 -0400", hash_original_method = "9295691F1B4364B400425405F52CF8A7", hash_generated_method = "74D094CEFB1D6801D5495141841A0B2D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(info.dsTaint);
        super.onInitializeAccessibilityNodeInfo(info);
        info.setCheckable(true);
        info.setChecked(mChecked);
        // ---------- Original Method ----------
        //super.onInitializeAccessibilityNodeInfo(info);
        //info.setCheckable(true);
        //info.setChecked(mChecked);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.382 -0400", hash_original_method = "B5E74BEF46452CACB638287F10D23674", hash_generated_method = "06F3D7D49D6BF3CF948A1598657A651C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onDraw(Canvas canvas) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(canvas.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.382 -0400", hash_original_method = "E661308564BAD0BE96E34DA026589671", hash_generated_method = "71E74D47FE0A8812194D6CB1578E52FC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected int[] onCreateDrawableState(int extraSpace) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(extraSpace);
        int[] drawableState;
        drawableState = super.onCreateDrawableState(extraSpace + 1);
        {
            boolean varCEC0E711DC0F7C8E920C6F998438D53D_1119623683 = (isChecked());
            {
                mergeDrawableStates(drawableState, CHECKED_STATE_SET);
            } //End block
        } //End collapsed parenthetic
        int[] retVal = new int[1];
        retVal[0] = dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //final int[] drawableState = super.onCreateDrawableState(extraSpace + 1);
        //if (isChecked()) {
            //mergeDrawableStates(drawableState, CHECKED_STATE_SET);
        //}
        //return drawableState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.383 -0400", hash_original_method = "7BF0D1F93DFA890868347E7C98BCCE2C", hash_generated_method = "CA547362BA13BAE1A4D068330EF152B8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.383 -0400", hash_original_method = "63DA0D6846E19577C9E55E51C4E55CAC", hash_generated_method = "7C1FB714BC21F3E633C8464AE3DDE632")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean verifyDrawable(Drawable who) {
        dsTaint.addTaint(who.dsTaint);
        boolean var8BBEA139816D93F09A5C54F2A2C942A4_737851652 = (super.verifyDrawable(who) || who == mButtonDrawable);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return super.verifyDrawable(who) || who == mButtonDrawable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.383 -0400", hash_original_method = "22D17E2BEF2192B0ED8786E02090A3E8", hash_generated_method = "603085D5CFEF4919B14F420F25110E1E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        mButtonDrawable.jumpToCurrentState();
        // ---------- Original Method ----------
        //super.jumpDrawablesToCurrentState();
        //if (mButtonDrawable != null) mButtonDrawable.jumpToCurrentState();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.383 -0400", hash_original_method = "C906A6F68E532E790B1685DD63ECE7DE", hash_generated_method = "F508EB383CD03F3279E58E3A62FF61D6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Parcelable onSaveInstanceState() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        setFreezesText(true);
        Parcelable superState;
        superState = super.onSaveInstanceState();
        SavedState ss;
        ss = new SavedState(superState);
        ss.checked = isChecked();
        return (Parcelable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //setFreezesText(true);
        //Parcelable superState = super.onSaveInstanceState();
        //SavedState ss = new SavedState(superState);
        //ss.checked = isChecked();
        //return ss;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.384 -0400", hash_original_method = "82857D3CD54F7EB52721411B0B0DD538", hash_generated_method = "FA30504C9763782448206F7D635025AB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onRestoreInstanceState(Parcelable state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(state.dsTaint);
        SavedState ss;
        ss = (SavedState) state;
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
        boolean checked;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.384 -0400", hash_original_method = "89EB4EC154F05BF905ECA8E02BBD14BC", hash_generated_method = "AB6E14E26999AC4D7AF1972CF22F65E4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         SavedState(Parcelable superState) {
            super(superState);
            dsTaint.addTaint(superState.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.384 -0400", hash_original_method = "527F999E441AD9A28BC136B181E8236B", hash_generated_method = "3382FC357BEDFEDDAE5B611EF4BCA50D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private SavedState(Parcel in) {
            super(in);
            dsTaint.addTaint(in.dsTaint);
            checked = (Boolean)in.readValue(null);
            // ---------- Original Method ----------
            //checked = (Boolean)in.readValue(null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.384 -0400", hash_original_method = "42336FB9BEBA29D5024EB2A7DFCC6545", hash_generated_method = "2ADB320BC55B6074F8255C537B588506")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void writeToParcel(Parcel out, int flags) {
            dsTaint.addTaint(flags);
            dsTaint.addTaint(out.dsTaint);
            super.writeToParcel(out, flags);
            out.writeValue(checked);
            // ---------- Original Method ----------
            //super.writeToParcel(out, flags);
            //out.writeValue(checked);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.385 -0400", hash_original_method = "F6EC4DB06CBAC48467361A043CC860D0", hash_generated_method = "7AC616253F172DC56DBB2C79B5737177")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public String toString() {
            String varD5C1D90283B549415C90083C4A907E37_2073810381 = ("CompoundButton.SavedState{"
                    + Integer.toHexString(System.identityHashCode(this))
                    + " checked=" + checked + "}");
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return "CompoundButton.SavedState{"
                    //+ Integer.toHexString(System.identityHashCode(this))
                    //+ " checked=" + checked + "}";
        }

        
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.385 -0400", hash_original_method = "E26812089C072DDE1A14AECAA6CD6686", hash_generated_method = "E0B7CDDEF4A88D123C122A6FE2B3F957")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public SavedState createFromParcel(Parcel in) {
                dsTaint.addTaint(in.dsTaint);
                SavedState var41ED8F3548F5060881BBE51AB9112A3F_83214606 = (new SavedState(in));
                return (SavedState)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new SavedState(in);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.385 -0400", hash_original_method = "2D31E9CBAAAE05B696D738324F87FF78", hash_generated_method = "AA0B8CE8511C3DD6D5E1A595B5605339")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public SavedState[] newArray(int size) {
                dsTaint.addTaint(size);
                SavedState[] varB5C72E5BBB181D4CA93D7BAA0B8B5E3D_1733736777 = (new SavedState[size]);
                return (SavedState[])dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new SavedState[size];
            }

            
}; //Transformed anonymous class
    }


    
    public static interface OnCheckedChangeListener {
        
        void onCheckedChanged(CompoundButton buttonView, boolean isChecked);
    }
    
    private static final int[] CHECKED_STATE_SET = {
        R.attr.state_checked
    };
}

