package android.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.android.internal.R;

public class RadioGroup extends LinearLayout {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.152 -0500", hash_original_field = "C47AF993A50B19E53756FB24F9912A08", hash_generated_field = "0E60C492BFE4F917273C3792086EBFC2")

    private int mCheckedId = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.155 -0500", hash_original_field = "8F07D72633256E02859E81595C975571", hash_generated_field = "03B71B077035EFD15E0CC238CED14ADB")

    private CompoundButton.OnCheckedChangeListener mChildOnCheckedChangeListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.157 -0500", hash_original_field = "A5F2820840D9BCD08A2F8056CB86062F", hash_generated_field = "8EA8A86994F8653D806F8D39B40F3A7A")

    private boolean mProtectFromCheckedChange = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.159 -0500", hash_original_field = "1439B2658D0E6AECB31AD74173388CC7", hash_generated_field = "CADA2218212B45C2541514362AD86DC5")

    private OnCheckedChangeListener mOnCheckedChangeListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.161 -0500", hash_original_field = "0B7FCC6D40B623480D6B038BC197F26E", hash_generated_field = "D6873107348DB82058DBF97E94E973A0")

    private PassThroughHierarchyChangeListener mPassThroughListener;

    /**
     * {@inheritDoc}
     */
    @DSComment("RadioGroup")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.164 -0500", hash_original_method = "3F150AF0F79E2D2E674BD2F6CDCB9019", hash_generated_method = "CD607C8AACC191FD2EFAD1CBF0C9253E")
    
public RadioGroup(Context context) {
        super(context);
        setOrientation(VERTICAL);
        init();
    }

    /**
     * {@inheritDoc}
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.167 -0500", hash_original_method = "90AD2839FB0C3C5CF6A003259AE74157", hash_generated_method = "69E782FDA7881A382953429DF0F9F7B4")
    
public RadioGroup(Context context, AttributeSet attrs) {
        super(context, attrs);

        // retrieve selected radio button as requested by the user in the
        // XML layout file
        TypedArray attributes = context.obtainStyledAttributes(
                attrs, com.android.internal.R.styleable.RadioGroup, com.android.internal.R.attr.radioButtonStyle, 0);

        int value = attributes.getResourceId(R.styleable.RadioGroup_checkedButton, View.NO_ID);
        if (value != View.NO_ID) {
            mCheckedId = value;
        }

        final int index = attributes.getInt(com.android.internal.R.styleable.RadioGroup_orientation, VERTICAL);
        setOrientation(index);

        attributes.recycle();
        init();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.169 -0500", hash_original_method = "BF04917C1358A32EDE5746B4072D7D20", hash_generated_method = "092D531ED22915F12D228E20373014E8")
    
private void init() {
        mChildOnCheckedChangeListener = new CheckedStateTracker();
        mPassThroughListener = new PassThroughHierarchyChangeListener();
        super.setOnHierarchyChangeListener(mPassThroughListener);
    }

    /**
     * {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.172 -0500", hash_original_method = "E023B2331F5B7D82E6BF896494CABA17", hash_generated_method = "AF74A4B1FE64A7C419FFF3963B6269E6")
    
@Override
    public void setOnHierarchyChangeListener(OnHierarchyChangeListener listener) {
        // the user listener is delegated to our pass-through listener
        mPassThroughListener.mOnHierarchyChangeListener = listener;
    }

    /**
     * {@inheritDoc}
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.174 -0500", hash_original_method = "DD6500FC505DB421A3CAF1F1EB2A0C5C", hash_generated_method = "267EBD4680E132898E3C56F6E7B22752")
    
@Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        // checks the appropriate radio button as requested in the XML file
        if (mCheckedId != -1) {
            mProtectFromCheckedChange = true;
            setCheckedStateForView(mCheckedId, true);
            mProtectFromCheckedChange = false;
            setCheckedId(mCheckedId);
        }
    }

    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.176 -0500", hash_original_method = "CB461CEACD94E412C8E6191745000CDB", hash_generated_method = "B97E4410DC386F72E2A2E736E308EE13")
    
@Override
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        if (child instanceof RadioButton) {
            final RadioButton button = (RadioButton) child;
            if (button.isChecked()) {
                mProtectFromCheckedChange = true;
                if (mCheckedId != -1) {
                    setCheckedStateForView(mCheckedId, false);
                }
                mProtectFromCheckedChange = false;
                setCheckedId(button.getId());
            }
        }

        super.addView(child, index, params);
    }

    /**
     * <p>Sets the selection to the radio button whose identifier is passed in
     * parameter. Using -1 as the selection identifier clears the selection;
     * such an operation is equivalent to invoking {@link #clearCheck()}.</p>
     *
     * @param id the unique id of the radio button to select in this group
     *
     * @see #getCheckedRadioButtonId()
     * @see #clearCheck()
     */
    @DSComment("RadioGroup")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.179 -0500", hash_original_method = "09268A2A1BCE88884506BAA643569A97", hash_generated_method = "18261EA61F80E2DD498F7E8562AA92D5")
    
public void check(int id) {
        // don't even bother
        if (id != -1 && (id == mCheckedId)) {
            return;
        }

        if (mCheckedId != -1) {
            setCheckedStateForView(mCheckedId, false);
        }

        if (id != -1) {
            setCheckedStateForView(id, true);
        }

        setCheckedId(id);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.181 -0500", hash_original_method = "5FA05BD652ABFE7F3AF547784FD6946B", hash_generated_method = "1ABE797A75A958D4D9D46CFE872E6665")
    
private void setCheckedId(int id) {
        mCheckedId = id;
        if (mOnCheckedChangeListener != null) {
            mOnCheckedChangeListener.onCheckedChanged(this, mCheckedId);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.183 -0500", hash_original_method = "C9C9D7D4FE388186AB4F88F5226CFA81", hash_generated_method = "ACEF9C7829489C0561227FBD2BF1F5A5")
    
private void setCheckedStateForView(int viewId, boolean checked) {
        View checkedView = findViewById(viewId);
        if (checkedView != null && checkedView instanceof RadioButton) {
            ((RadioButton) checkedView).setChecked(checked);
        }
    }

    /**
     * <p>Returns the identifier of the selected radio button in this group.
     * Upon empty selection, the returned value is -1.</p>
     *
     * @return the unique id of the selected radio button in this group
     *
     * @see #check(int)
     * @see #clearCheck()
     */
    @DSComment("RadioGroup")
    @DSSafe(DSCat.GUI)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.185 -0500", hash_original_method = "037226FCADAD9E6B157688A3599D3985", hash_generated_method = "CA799BFEF6959DBCC5E4B26BE6AA9F99")
    
public int getCheckedRadioButtonId() {
        return mCheckedId;
    }

    /**
     * <p>Clears the selection. When the selection is cleared, no radio button
     * in this group is selected and {@link #getCheckedRadioButtonId()} returns
     * null.</p>
     *
     * @see #check(int)
     * @see #getCheckedRadioButtonId()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.187 -0500", hash_original_method = "E28523184AF4023EBEA953058E4D04A2", hash_generated_method = "5EC70AFE9558DD8C5492D929A49D4E3F")
    
public void clearCheck() {
        check(-1);
    }

    /**
     * <p>Register a callback to be invoked when the checked radio button
     * changes in this group.</p>
     *
     * @param listener the callback to call on checked state change
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.189 -0500", hash_original_method = "C2FB0C98D5222F68A09A56AA82371FFE", hash_generated_method = "2005422FD19D8F4D4652659CAEDD0423")
    @DSVerified("Calling/dispatching callbacks")
    @DSSafe(DSCat.ANDROID_CALLBACK)
public void setOnCheckedChangeListener(OnCheckedChangeListener listener) {
        mOnCheckedChangeListener = listener;
        if (listener != null) {
            listener.onCheckedChanged(this, DSUtils.FAKE_INT);
        }
    }

    /**
     * {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.191 -0500", hash_original_method = "D352CF2A356795872216EFA2E7D695F4", hash_generated_method = "060B8431BC28B8585E3CB6FF3A98A5CD")
    
@Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new RadioGroup.LayoutParams(getContext(), attrs);
    }

    /**
     * {@inheritDoc}
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.193 -0500", hash_original_method = "B6F650811616014198C7164725061E28", hash_generated_method = "F665D68F1DC1CA6C2EA0A47864080DB1")
    
@Override
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        return p instanceof RadioGroup.LayoutParams;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.196 -0500", hash_original_method = "4DB39C46ED4EFC166BB2C749224E802D", hash_generated_method = "5CEB0C2180DDEEAAE00B4E9D2E5ABEEF")
    
@Override
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
    }
    
    public static class LayoutParams extends LinearLayout.LayoutParams {
        /**
         * {@inheritDoc}
         */
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.200 -0500", hash_original_method = "35869249D2D5BC08819A8507F87D33FD", hash_generated_method = "72A2ECA2CF4C647C2D28F670D4DC27E1")
        
public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
        }

        /**
         * {@inheritDoc}
         */
        @DSComment("")
        @DSSafe(DSCat.DATA_STRUCTURE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.202 -0500", hash_original_method = "979C42732F8B715475115A738CE7596D", hash_generated_method = "A7516D57E99F3298A4CB1C063C44A289")
        
public LayoutParams(int w, int h) {
            super(w, h);
        }

        /**
         * {@inheritDoc}
         */
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.205 -0500", hash_original_method = "A72C7A56D1748794301804B2844F1EFE", hash_generated_method = "D9C12FAB2BFA4A4083C418C192DB9624")
        
public LayoutParams(int w, int h, float initWeight) {
            super(w, h, initWeight);
        }

        /**
         * {@inheritDoc}
         */
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.208 -0500", hash_original_method = "DE4ED36682A1028E303BDCC28A48E06F", hash_generated_method = "AA7E78F64C1B2029CADFD7AA230FA359")
        
public LayoutParams(ViewGroup.LayoutParams p) {
            super(p);
        }

        /**
         * {@inheritDoc}
         */
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.211 -0500", hash_original_method = "CC87BD4B8C067788FA2BA37DBA116F62", hash_generated_method = "A83E3EC70AE7CFFC0495D4E169E975D9")
        
public LayoutParams(MarginLayoutParams source) {
            super(source);
        }

        /**
         * <p>Fixes the child's width to
         * {@link android.view.ViewGroup.LayoutParams#WRAP_CONTENT} and the child's
         * height to  {@link android.view.ViewGroup.LayoutParams#WRAP_CONTENT}
         * when not specified in the XML file.</p>
         *
         * @param a the styled attributes set
         * @param widthAttr the width attribute to fetch
         * @param heightAttr the height attribute to fetch
         */
        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.213 -0500", hash_original_method = "B48B8CC58D894F8848FAA9A802B21490", hash_generated_method = "2926E02E4D8CFF91F30DF8B86F4F32D9")
        
@Override
        protected void setBaseAttributes(TypedArray a,
                int widthAttr, int heightAttr) {

            if (a.hasValue(widthAttr)) {
                width = a.getLayoutDimension(widthAttr, "layout_width");
            } else {
                width = WRAP_CONTENT;
            }
            
            if (a.hasValue(heightAttr)) {
                height = a.getLayoutDimension(heightAttr, "layout_height");
            } else {
                height = WRAP_CONTENT;
            }
        }
        
    }
    
    private class CheckedStateTracker implements CompoundButton.OnCheckedChangeListener {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.213 -0400", hash_original_method = "E2AC7F511959AF87F19610FB00EDC800", hash_generated_method = "E2AC7F511959AF87F19610FB00EDC800")
        public CheckedStateTracker ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.220 -0500", hash_original_method = "E56141A548162EED06032B62A97D492B", hash_generated_method = "B91BC49251EAE47F445CC91D609B0303")
        
public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            // prevents from infinite recursion
            if (mProtectFromCheckedChange) {
                return;
            }

            mProtectFromCheckedChange = true;
            if (mCheckedId != -1) {
                setCheckedStateForView(mCheckedId, false);
            }
            mProtectFromCheckedChange = false;

            int id = buttonView.getId();
            setCheckedId(id);
        }
        
    }
    
    private class PassThroughHierarchyChangeListener implements ViewGroup.OnHierarchyChangeListener {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.225 -0500", hash_original_field = "D01F937FCB17217561DE5F8FD1984593", hash_generated_field = "ADB5398B42E06BDFAAB3C7B984E67131")

        private ViewGroup.OnHierarchyChangeListener mOnHierarchyChangeListener;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.214 -0400", hash_original_method = "0DD100C097C91E6D30F06426909CA640", hash_generated_method = "0DD100C097C91E6D30F06426909CA640")
        public PassThroughHierarchyChangeListener ()
        {
            //Synthesized constructor
        }

        /**
         * {@inheritDoc}
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.228 -0500", hash_original_method = "9AE0BCF025F178DCB126CF7F54B6A426", hash_generated_method = "2864E12F07F68E25F4C02B9CB0ACC8A4")
        
public void onChildViewAdded(View parent, View child) {
            if (parent == RadioGroup.this && child instanceof RadioButton) {
                int id = child.getId();
                // generates an id if it's missing
                if (id == View.NO_ID) {
                    id = child.hashCode();
                    child.setId(id);
                }
                ((RadioButton) child).setOnCheckedChangeWidgetListener(
                        mChildOnCheckedChangeListener);
            }

            if (mOnHierarchyChangeListener != null) {
                mOnHierarchyChangeListener.onChildViewAdded(parent, child);
            }
        }

        /**
         * {@inheritDoc}
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.230 -0500", hash_original_method = "14A14DEA096CEDEB26071DA272A91074", hash_generated_method = "92A3E8C44EC42C5D25360940F92B1BD8")
        
public void onChildViewRemoved(View parent, View child) {
            if (parent == RadioGroup.this && child instanceof RadioButton) {
                ((RadioButton) child).setOnCheckedChangeWidgetListener(null);
            }

            if (mOnHierarchyChangeListener != null) {
                mOnHierarchyChangeListener.onChildViewRemoved(parent, child);
            }
        }
        
    }
    
    public interface OnCheckedChangeListener {
        
        @DSVerified
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public void onCheckedChanged(RadioGroup group, int checkedId);
    }
    
}

