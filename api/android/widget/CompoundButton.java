package android.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
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

public abstract class CompoundButton extends Button implements Checkable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:39.491 -0500", hash_original_field = "73791D998AED7A27216E6912B00269F9", hash_generated_field = "648B080756031EA789B9ECD9F36CC170")

    private static final int[] CHECKED_STATE_SET = {
        R.attr.state_checked
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:39.478 -0500", hash_original_field = "2095822BEB25A977611B30C48AE7794D", hash_generated_field = "5B3EF9355FF9C7031B185F0E3C8A05A3")

    private boolean mChecked;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:39.480 -0500", hash_original_field = "4CDA572AF5E30E2775A283FDE28E4575", hash_generated_field = "F7281DF8986A8AAA3358888CEF5418EC")

    private int mButtonResource;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:39.482 -0500", hash_original_field = "98B52A97DE87CD3851E1D06D5176AC82", hash_generated_field = "5933F8BEFDC1D6F561EDC936859AE435")

    private boolean mBroadcasting;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:39.484 -0500", hash_original_field = "F73A84BBB64A66FE06E33F1EE8B25EA2", hash_generated_field = "504A761B2A37294B367C41E884729E06")

    private Drawable mButtonDrawable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:39.486 -0500", hash_original_field = "1439B2658D0E6AECB31AD74173388CC7", hash_generated_field = "CADA2218212B45C2541514362AD86DC5")

    private OnCheckedChangeListener mOnCheckedChangeListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:39.488 -0500", hash_original_field = "7E275FDDBD30E02A10D633AE63660818", hash_generated_field = "568693E6FE3597BED062BE1553841524")

    private OnCheckedChangeListener mOnCheckedChangeWidgetListener;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:39.493 -0500", hash_original_method = "09BDBE7CE6F05C0EF8277BC374FA0AC6", hash_generated_method = "A9E97A4AFA342D66315064AF0A314479")
    
public CompoundButton(Context context) {
        this(context, null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:39.496 -0500", hash_original_method = "971C0A1E5EDCDBE9454DEBB4776AC79B", hash_generated_method = "B5D87F626977611FCBCE617C5544201D")
    
public CompoundButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:39.499 -0500", hash_original_method = "486B323903576A8E24B1C8D9A5D1C983", hash_generated_method = "BA463A9F24DA6CA2DE55B2F8FE60A76E")
    
public CompoundButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        TypedArray a =
                context.obtainStyledAttributes(
                        attrs, com.android.internal.R.styleable.CompoundButton, defStyle, 0);

        Drawable d = a.getDrawable(com.android.internal.R.styleable.CompoundButton_button);
        if (d != null) {
            setButtonDrawable(d);
        }

        boolean checked = a
                .getBoolean(com.android.internal.R.styleable.CompoundButton_checked, false);
        setChecked(checked);

        a.recycle();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:39.502 -0500", hash_original_method = "E1B1AD330E2148117F43C315FF6D1DED", hash_generated_method = "A3C4A23427194F6EB8A02F7BC58C147C")
    
public void toggle() {
        setChecked(!mChecked);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:39.504 -0500", hash_original_method = "CF8A2026FDAB35E1C88301DD3EB518FB", hash_generated_method = "E995524FB81F1A095AF2DEC4C1C3BD04")
    
@Override
    public boolean performClick() {
        /*
         * XXX: These are tiny, need some surrounding 'expanded touch area',
         * which will need to be implemented in Button if we only override
         * performClick()
         */

        /* When clicked, toggle the state */
        toggle();
        return super.performClick();
    }

    @DSComment("CompoundButton, check modeling")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:39.506 -0500", hash_original_method = "1057BD246BBC96B40BF6B862055C5AB8", hash_generated_method = "6384B5CB9EB85B7EDD0B1D464AE9B509")
    
@ViewDebug.ExportedProperty
    public boolean isChecked() {
        return mChecked;
    }

    /**
     * <p>Changes the checked state of this button.</p>
     *
     * @param checked true to check the button, false to uncheck it
     */
    @DSComment("CompoundButton, check modeling")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:39.508 -0500", hash_original_method = "CA54800DCB28AE61300AD40B91914282", hash_generated_method = "BF57FD9BFBC7DE9244EEAE833AD837D1")
    
public void setChecked(boolean checked) {
        if (mChecked != checked) {
            mChecked = checked;
            refreshDrawableState();

            // Avoid infinite recursions if setChecked() is called from a listener
            if (mBroadcasting) {
                return;
            }

            mBroadcasting = true;
            if (mOnCheckedChangeListener != null) {
                mOnCheckedChangeListener.onCheckedChanged(this, mChecked);
            }
            if (mOnCheckedChangeWidgetListener != null) {
                mOnCheckedChangeWidgetListener.onCheckedChanged(this, mChecked);
            }

            mBroadcasting = false;            
        }
    }

    /**
     * Register a callback to be invoked when the checked state of this button
     * changes.
     *
     * @param listener the callback to call on checked state change
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:39.511 -0500", hash_original_method = "C2FB0C98D5222F68A09A56AA82371FFE", hash_generated_method = "2005422FD19D8F4D4652659CAEDD0423")
    
public void setOnCheckedChangeListener(OnCheckedChangeListener listener) {
        mOnCheckedChangeListener = listener;
    }

    /**
     * Register a callback to be invoked when the checked state of this button
     * changes. This callback is used for internal purpose only.
     *
     * @param listener the callback to call on checked state change
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:39.513 -0500", hash_original_method = "CC17A77F98E8CA70C4846D647AA35249", hash_generated_method = "CC17A77F98E8CA70C4846D647AA35249")
    
void setOnCheckedChangeWidgetListener(OnCheckedChangeListener listener) {
        mOnCheckedChangeWidgetListener = listener;
    }

    /**
     * Set the background to a given Drawable, identified by its resource id.
     *
     * @param resid the resource id of the drawable to use as the background 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:39.518 -0500", hash_original_method = "854EF2446DBF034657A969188723C50F", hash_generated_method = "3CE1A8DDDF8B30EEB3124E5E85F2F198")
    
public void setButtonDrawable(int resid) {
        if (resid != 0 && resid == mButtonResource) {
            return;
        }

        mButtonResource = resid;

        Drawable d = null;
        if (mButtonResource != 0) {
            d = getResources().getDrawable(mButtonResource);
        }
        setButtonDrawable(d);
    }

    /**
     * Set the background to a given Drawable
     *
     * @param d The Drawable to use as the background
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:39.520 -0500", hash_original_method = "82099279959514BCCDE965E8456BDB6A", hash_generated_method = "9D54109BC3C0A1AB62EDECFB7896D15B")
    
public void setButtonDrawable(Drawable d) {
        if (d != null) {
            if (mButtonDrawable != null) {
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:39.523 -0500", hash_original_method = "E1DFB2AF73729EA8AA28BE1E77594577", hash_generated_method = "E0A307C13A2B0EF8859DF8BD8C2E8931")
    
@Override
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        super.onInitializeAccessibilityEvent(event);
        event.setChecked(mChecked);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:39.525 -0500", hash_original_method = "9295691F1B4364B400425405F52CF8A7", hash_generated_method = "3C95A34B06BA9302E44D6DF4D25FF9D4")
    
@Override
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
        info.setCheckable(true);
        info.setChecked(mChecked);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:39.527 -0500", hash_original_method = "B5E74BEF46452CACB638287F10D23674", hash_generated_method = "DCE37863D022A43FE950C1923111FD02")
    
@Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        final Drawable buttonDrawable = mButtonDrawable;
        if (buttonDrawable != null) {
            final int verticalGravity = getGravity() & Gravity.VERTICAL_GRAVITY_MASK;
            final int height = buttonDrawable.getIntrinsicHeight();

            int y = 0;

            switch (verticalGravity) {
                case Gravity.BOTTOM:
                    y = getHeight() - height;
                    break;
                case Gravity.CENTER_VERTICAL:
                    y = (getHeight() - height) / 2;
                    break;
            }

            buttonDrawable.setBounds(0, y, buttonDrawable.getIntrinsicWidth(), y + height);
            buttonDrawable.draw(canvas);
        }
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:39.530 -0500", hash_original_method = "E661308564BAD0BE96E34DA026589671", hash_generated_method = "5E8E36BFCD9C1913662CF74C63EBB21F")
    
@Override
    protected int[] onCreateDrawableState(int extraSpace) {
        final int[] drawableState = super.onCreateDrawableState(extraSpace + 1);
        if (isChecked()) {
            mergeDrawableStates(drawableState, CHECKED_STATE_SET);
        }
        return drawableState;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:39.532 -0500", hash_original_method = "7BF0D1F93DFA890868347E7C98BCCE2C", hash_generated_method = "F9238D1991B9E94BC397105FF8F9EBE0")
    
@Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        
        if (mButtonDrawable != null) {
            int[] myDrawableState = getDrawableState();
            
            // Set the state of the Drawable
            mButtonDrawable.setState(myDrawableState);
            
            invalidate();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:39.535 -0500", hash_original_method = "63DA0D6846E19577C9E55E51C4E55CAC", hash_generated_method = "7B1D5D8568D0176CDCBC5D2BFB8263D6")
    
@Override
    protected boolean verifyDrawable(Drawable who) {
        return super.verifyDrawable(who) || who == mButtonDrawable;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:39.537 -0500", hash_original_method = "22D17E2BEF2192B0ED8786E02090A3E8", hash_generated_method = "B517655E25EC3A8C6C07D412C81F72B8")
    
@Override
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (mButtonDrawable != null) mButtonDrawable.jumpToCurrentState();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:39.563 -0500", hash_original_method = "C906A6F68E532E790B1685DD63ECE7DE", hash_generated_method = "46FED10CEEBE0245DEE3DC6ADC684074")
    
@Override
    public Parcelable onSaveInstanceState() {
        // Force our ancestor class to save its state
        setFreezesText(true);
        Parcelable superState = super.onSaveInstanceState();

        SavedState ss = new SavedState(superState);

        ss.checked = isChecked();
        return ss;
    }
    
    static class SavedState extends BaseSavedState {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:39.558 -0500", hash_original_field = "AD99978CDC5E698C2A4DD1DC3100EFC5", hash_generated_field = "263FCDD65C2156B1D1E1B4D9AE8D7FFA")

        public static final Parcelable.Creator<SavedState> CREATOR
                = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:39.541 -0500", hash_original_field = "6F0D05495423C9405B09D32CCA18EA7F", hash_generated_field = "6F0D05495423C9405B09D32CCA18EA7F")

        boolean checked;

        /**
         * Constructor called from {@link CompoundButton#onSaveInstanceState()}
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:39.543 -0500", hash_original_method = "89EB4EC154F05BF905ECA8E02BBD14BC", hash_generated_method = "89EB4EC154F05BF905ECA8E02BBD14BC")
        
SavedState(Parcelable superState) {
            super(superState);
        }
        
        /**
         * Constructor called from {@link #CREATOR}
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:39.546 -0500", hash_original_method = "527F999E441AD9A28BC136B181E8236B", hash_generated_method = "9934F70C9F95110BECB37EFB5CF3AC07")
        
private SavedState(Parcel in) {
            super(in);
            checked = (Boolean)in.readValue(null);
        }

        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:39.548 -0500", hash_original_method = "42336FB9BEBA29D5024EB2A7DFCC6545", hash_generated_method = "32FB3B94878A334A33C984AE7E9B31D2")
        
@Override
        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeValue(checked);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:39.551 -0500", hash_original_method = "F6EC4DB06CBAC48467361A043CC860D0", hash_generated_method = "CBCC82CA4F42622C18DE4E08230CA602")
        
@Override
        public String toString() {
            return "CompoundButton.SavedState{"
                    + Integer.toHexString(System.identityHashCode(this))
                    + " checked=" + checked + "}";
        }
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:39.566 -0500", hash_original_method = "82857D3CD54F7EB52721411B0B0DD538", hash_generated_method = "F662563F5F7128AD9A4ABAE598C094A3")
    
@Override
    public void onRestoreInstanceState(Parcelable state) {
        SavedState ss = (SavedState) state;
  
        super.onRestoreInstanceState(ss.getSuperState());
        setChecked(ss.checked);
        requestLayout();
    }
}

