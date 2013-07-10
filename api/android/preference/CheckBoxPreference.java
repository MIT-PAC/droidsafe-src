package android.preference;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;

public class CheckBoxPreference extends TwoStatePreference {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.731 -0400", hash_original_method = "0F16DADCBE1918B293B8D2F1611CB9A4", hash_generated_method = "9FD6DD679D4C7DF6B4A160724249AF7F")
    public  CheckBoxPreference(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TypedArray a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.CheckBoxPreference, defStyle, 0);
        setSummaryOn(a.getString(com.android.internal.R.styleable.CheckBoxPreference_summaryOn));
        setSummaryOff(a.getString(com.android.internal.R.styleable.CheckBoxPreference_summaryOff));
        setDisableDependentsState(a.getBoolean(
                com.android.internal.R.styleable.CheckBoxPreference_disableDependentsState, false));
        a.recycle();
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        addTaint(defStyle);
        
        
                
        
        
        
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.731 -0400", hash_original_method = "5BAF688B2DF41A97AF3D677D6FF48D6E", hash_generated_method = "91EF9A2B9607620CF8C2798CB4A4C7D0")
    public  CheckBoxPreference(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.checkBoxPreferenceStyle);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.731 -0400", hash_original_method = "18AEC3D719265C2FC8E8B7F461A380C1", hash_generated_method = "08ED9C50853F463326FD616F53D1F8A8")
    public  CheckBoxPreference(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.732 -0400", hash_original_method = "BFAE06CFE69D4939F40B9B050EA1DB64", hash_generated_method = "031089AD583399AD603CC9C50128B6A9")
    @Override
    protected void onBindView(View view) {
        
        super.onBindView(view);
        View checkboxView = view.findViewById(com.android.internal.R.id.checkbox);
        {
            ((Checkable) checkboxView).setChecked(mChecked);
            sendAccessibilityEvent(checkboxView);
        } 
        syncSummaryView(view);
        addTaint(view.getTaint());
        
        
        
        
            
            
        
        
    }

    
}

