package android.widget;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import com.android.internal.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class RadioGroup extends LinearLayout {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.162 -0400", hash_original_field = "CD9E757D941282FD5AF72E8B3AF603EF", hash_generated_field = "0E60C492BFE4F917273C3792086EBFC2")

    private int mCheckedId = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.162 -0400", hash_original_field = "16BCD0E47EDF07E5C608F2D93867FDA7", hash_generated_field = "03B71B077035EFD15E0CC238CED14ADB")

    private CompoundButton.OnCheckedChangeListener mChildOnCheckedChangeListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.162 -0400", hash_original_field = "151803A514C91A7054BFCCA115E08530", hash_generated_field = "8EA8A86994F8653D806F8D39B40F3A7A")

    private boolean mProtectFromCheckedChange = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.162 -0400", hash_original_field = "1A92EAC72E569629103256FCA72C7A7E", hash_generated_field = "CADA2218212B45C2541514362AD86DC5")

    private OnCheckedChangeListener mOnCheckedChangeListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.162 -0400", hash_original_field = "49134BEE5179245030E696FDD8403D38", hash_generated_field = "D6873107348DB82058DBF97E94E973A0")

    private PassThroughHierarchyChangeListener mPassThroughListener;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.162 -0400", hash_original_method = "3F150AF0F79E2D2E674BD2F6CDCB9019", hash_generated_method = "7380C2A907EA3CE49CD22E9F8BD4493B")
    public  RadioGroup(Context context) {
        super(context);
        addTaint(context.getTaint());
        setOrientation(VERTICAL);
        init();
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.163 -0400", hash_original_method = "90AD2839FB0C3C5CF6A003259AE74157", hash_generated_method = "8390D6BAC505632718805CE6B6BE6C76")
    public  RadioGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        TypedArray attributes = context.obtainStyledAttributes(
                attrs, com.android.internal.R.styleable.RadioGroup, com.android.internal.R.attr.radioButtonStyle, 0);
        int value = attributes.getResourceId(R.styleable.RadioGroup_checkedButton, View.NO_ID);
    if(value != View.NO_ID)        
        {
            mCheckedId = value;
        } 
        final int index = attributes.getInt(com.android.internal.R.styleable.RadioGroup_orientation, VERTICAL);
        setOrientation(index);
        attributes.recycle();
        init();
        
        
                
        
        
            
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.163 -0400", hash_original_method = "BF04917C1358A32EDE5746B4072D7D20", hash_generated_method = "2A140ABC2C96227F957D97D7A9C8FD90")
    private void init() {
        mChildOnCheckedChangeListener = new CheckedStateTracker();
        mPassThroughListener = new PassThroughHierarchyChangeListener();
        super.setOnHierarchyChangeListener(mPassThroughListener);
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.164 -0400", hash_original_method = "E023B2331F5B7D82E6BF896494CABA17", hash_generated_method = "7FA4E96971EEFFA6A54848F49887181B")
    @Override
    public void setOnHierarchyChangeListener(OnHierarchyChangeListener listener) {
        mPassThroughListener.mOnHierarchyChangeListener = listener;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.164 -0400", hash_original_method = "DD6500FC505DB421A3CAF1F1EB2A0C5C", hash_generated_method = "DBF8F24808C572F56A4F32B014BEF670")
    @Override
    protected void onFinishInflate() {
        
        super.onFinishInflate();
    if(mCheckedId != -1)        
        {
            mProtectFromCheckedChange = true;
            setCheckedStateForView(mCheckedId, true);
            mProtectFromCheckedChange = false;
            setCheckedId(mCheckedId);
        } 
        
        
        
            
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.165 -0400", hash_original_method = "CB461CEACD94E412C8E6191745000CDB", hash_generated_method = "685740A2F6D21CE832492C784D50DE22")
    @Override
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        addTaint(params.getTaint());
        addTaint(index);
        addTaint(child.getTaint());
    if(child instanceof RadioButton)        
        {
            final RadioButton button = (RadioButton) child;
    if(button.isChecked())            
            {
                mProtectFromCheckedChange = true;
    if(mCheckedId != -1)                
                {
                    setCheckedStateForView(mCheckedId, false);
                } 
                mProtectFromCheckedChange = false;
                setCheckedId(button.getId());
            } 
        } 
        super.addView(child, index, params);
        
        
            
            
                
                
                    
                
                
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.166 -0400", hash_original_method = "09268A2A1BCE88884506BAA643569A97", hash_generated_method = "A662C16298D4282D2CC1024FF3D026AE")
    public void check(int id) {
        addTaint(id);
    if(id != -1 && (id == mCheckedId))        
        {
            return;
        } 
    if(mCheckedId != -1)        
        {
            setCheckedStateForView(mCheckedId, false);
        } 
    if(id != -1)        
        {
            setCheckedStateForView(id, true);
        } 
        setCheckedId(id);
        
        
            
        
        
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.167 -0400", hash_original_method = "5FA05BD652ABFE7F3AF547784FD6946B", hash_generated_method = "B97F800B9977A6A9C7F55A446C7F3D8E")
    private void setCheckedId(int id) {
        mCheckedId = id;
    if(mOnCheckedChangeListener != null)        
        {
            mOnCheckedChangeListener.onCheckedChanged(this, mCheckedId);
        } 
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.167 -0400", hash_original_method = "C9C9D7D4FE388186AB4F88F5226CFA81", hash_generated_method = "4B27C4883D03C940AFBC001E8032FDA5")
    private void setCheckedStateForView(int viewId, boolean checked) {
        addTaint(checked);
        addTaint(viewId);
        View checkedView = findViewById(viewId);
    if(checkedView != null && checkedView instanceof RadioButton)        
        {
            ((RadioButton) checkedView).setChecked(checked);
        } 
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.168 -0400", hash_original_method = "037226FCADAD9E6B157688A3599D3985", hash_generated_method = "4E7CCBBB1B50F6FD1945ECEEEDBB325B")
    public int getCheckedRadioButtonId() {
        int var1628F13DF17E9E9D9F9B263B8D9EDD6C_764768180 = (mCheckedId);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_660943281 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_660943281;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.168 -0400", hash_original_method = "E28523184AF4023EBEA953058E4D04A2", hash_generated_method = "D8007F290A68FFDEA50A5A5C241BC5A3")
    public void clearCheck() {
        check(-1);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.168 -0400", hash_original_method = "C2FB0C98D5222F68A09A56AA82371FFE", hash_generated_method = "E7A52B8D01F324B4A1B6AA133FD3E1C1")
    public void setOnCheckedChangeListener(OnCheckedChangeListener listener) {
        mOnCheckedChangeListener = listener;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.168 -0400", hash_original_method = "D352CF2A356795872216EFA2E7D695F4", hash_generated_method = "74174512ED020F217249C7AB79F81C3E")
    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        addTaint(attrs.getTaint());
LayoutParams var2B042AB9A3A848AB14156E90F264A184_1394145876 =         new RadioGroup.LayoutParams(getContext(), attrs);
        var2B042AB9A3A848AB14156E90F264A184_1394145876.addTaint(taint);
        return var2B042AB9A3A848AB14156E90F264A184_1394145876;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.168 -0400", hash_original_method = "B6F650811616014198C7164725061E28", hash_generated_method = "694C4212BDCCF369FC09D39DA131287D")
    @Override
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        addTaint(p.getTaint());
        boolean var820C2E66152EA2081C50BE1DBC60B484_1983527581 = (p instanceof RadioGroup.LayoutParams);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2115726777 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2115726777;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.169 -0400", hash_original_method = "4DB39C46ED4EFC166BB2C749224E802D", hash_generated_method = "7F20CB949FEF98A9432D7617EB5F6A87")
    @Override
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
LinearLayout.LayoutParams var65BA47367D3E2EC837A3E887EEE5A3B3_2053469250 =         new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        var65BA47367D3E2EC837A3E887EEE5A3B3_2053469250.addTaint(taint);
        return var65BA47367D3E2EC837A3E887EEE5A3B3_2053469250;
        
        
    }

    
    public static class LayoutParams extends LinearLayout.LayoutParams {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.169 -0400", hash_original_method = "35869249D2D5BC08819A8507F87D33FD", hash_generated_method = "7441F800C0B184928DB48A9DD8178D32")
        public  LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            addTaint(attrs.getTaint());
            addTaint(c.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.169 -0400", hash_original_method = "979C42732F8B715475115A738CE7596D", hash_generated_method = "503F8BCA6BB39449EFF41178BE64A21C")
        public  LayoutParams(int w, int h) {
            super(w, h);
            addTaint(h);
            addTaint(w);
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.170 -0400", hash_original_method = "A72C7A56D1748794301804B2844F1EFE", hash_generated_method = "AD66C54810C851C0FD6D6C80005AA288")
        public  LayoutParams(int w, int h, float initWeight) {
            super(w, h, initWeight);
            addTaint(initWeight);
            addTaint(h);
            addTaint(w);
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.170 -0400", hash_original_method = "DE4ED36682A1028E303BDCC28A48E06F", hash_generated_method = "66B55E9EFECAB48B3D28D153941B8308")
        public  LayoutParams(ViewGroup.LayoutParams p) {
            super(p);
            addTaint(p.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.170 -0400", hash_original_method = "CC87BD4B8C067788FA2BA37DBA116F62", hash_generated_method = "BDFD9CE52FB4D6304CCFF1CA731BA0A9")
        public  LayoutParams(MarginLayoutParams source) {
            super(source);
            addTaint(source.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.171 -0400", hash_original_method = "B48B8CC58D894F8848FAA9A802B21490", hash_generated_method = "BE9441930F647CDBC21F70E945BB2254")
        @Override
        protected void setBaseAttributes(TypedArray a,
                int widthAttr, int heightAttr) {
            addTaint(heightAttr);
            addTaint(widthAttr);
            addTaint(a.getTaint());
    if(a.hasValue(widthAttr))            
            {
                width = a.getLayoutDimension(widthAttr, "layout_width");
            } 
            else
            {
                width = WRAP_CONTENT;
            } 
    if(a.hasValue(heightAttr))            
            {
                height = a.getLayoutDimension(heightAttr, "layout_height");
            } 
            else
            {
                height = WRAP_CONTENT;
            } 
            
            
                
            
                
            
            
                
            
                
            
        }

        
    }


    
    private class CheckedStateTracker implements CompoundButton.OnCheckedChangeListener {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.171 -0400", hash_original_method = "E2AC7F511959AF87F19610FB00EDC800", hash_generated_method = "E2AC7F511959AF87F19610FB00EDC800")
        public CheckedStateTracker ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.171 -0400", hash_original_method = "E56141A548162EED06032B62A97D492B", hash_generated_method = "CCBD7BC0FCE5FA51DEF368DFD17DD2F2")
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            
            addTaint(isChecked);
            addTaint(buttonView.getTaint());
    if(mProtectFromCheckedChange)            
            {
                return;
            } 
            mProtectFromCheckedChange = true;
    if(mCheckedId != -1)            
            {
                setCheckedStateForView(mCheckedId, false);
            } 
            mProtectFromCheckedChange = false;
            int id = buttonView.getId();
            setCheckedId(id);
            
            
                
            
            
            
                
            
            
            
            
        }

        
    }


    
    private class PassThroughHierarchyChangeListener implements ViewGroup.OnHierarchyChangeListener {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.172 -0400", hash_original_field = "3F7DB39F9660F69EF1A4D273C271814A", hash_generated_field = "ADB5398B42E06BDFAAB3C7B984E67131")

        private ViewGroup.OnHierarchyChangeListener mOnHierarchyChangeListener;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.172 -0400", hash_original_method = "0DD100C097C91E6D30F06426909CA640", hash_generated_method = "0DD100C097C91E6D30F06426909CA640")
        public PassThroughHierarchyChangeListener ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.172 -0400", hash_original_method = "9AE0BCF025F178DCB126CF7F54B6A426", hash_generated_method = "61BAB28359F7BBE5C1A863CDBFFF5D03")
        public void onChildViewAdded(View parent, View child) {
            
            addTaint(child.getTaint());
            addTaint(parent.getTaint());
    if(parent == RadioGroup.this && child instanceof RadioButton)            
            {
                int id = child.getId();
    if(id == View.NO_ID)                
                {
                    id = child.hashCode();
                    child.setId(id);
                } 
                ((RadioButton) child).setOnCheckedChangeWidgetListener(
                        mChildOnCheckedChangeListener);
            } 
    if(mOnHierarchyChangeListener != null)            
            {
                mOnHierarchyChangeListener.onChildViewAdded(parent, child);
            } 
            
            
                
                
                    
                    
                
                
                        
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.172 -0400", hash_original_method = "14A14DEA096CEDEB26071DA272A91074", hash_generated_method = "F34FCFF6D75202C41CA842071553CB8D")
        public void onChildViewRemoved(View parent, View child) {
            
            addTaint(child.getTaint());
            addTaint(parent.getTaint());
    if(parent == RadioGroup.this && child instanceof RadioButton)            
            {
                ((RadioButton) child).setOnCheckedChangeWidgetListener(null);
            } 
    if(mOnHierarchyChangeListener != null)            
            {
                mOnHierarchyChangeListener.onChildViewRemoved(parent, child);
            } 
            
            
                
            
            
                
            
        }

        
    }


    
    public interface OnCheckedChangeListener {
        
        public void onCheckedChanged(RadioGroup group, int checkedId);
    }
    
}

