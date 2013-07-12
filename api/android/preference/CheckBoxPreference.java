package android.preference;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;

public class CheckBoxPreference extends TwoStatePreference {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.162 -0400", hash_original_method = "0F16DADCBE1918B293B8D2F1611CB9A4", hash_generated_method = "CE64A25D1E7D287B20D519420D8E20B9")
    public  CheckBoxPreference(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        addTaint(defStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        TypedArray a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.CheckBoxPreference, defStyle, 0);
        setSummaryOn(a.getString(com.android.internal.R.styleable.CheckBoxPreference_summaryOn));
        setSummaryOff(a.getString(com.android.internal.R.styleable.CheckBoxPreference_summaryOff));
        setDisableDependentsState(a.getBoolean(
                com.android.internal.R.styleable.CheckBoxPreference_disableDependentsState, false));
        a.recycle();
        
        
                
        
        
        
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.162 -0400", hash_original_method = "5BAF688B2DF41A97AF3D677D6FF48D6E", hash_generated_method = "E192B17B96012DEB73E342F8AB87F197")
    public  CheckBoxPreference(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.checkBoxPreferenceStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.162 -0400", hash_original_method = "18AEC3D719265C2FC8E8B7F461A380C1", hash_generated_method = "08ED9C50853F463326FD616F53D1F8A8")
    public  CheckBoxPreference(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.163 -0400", hash_original_method = "BFAE06CFE69D4939F40B9B050EA1DB64", hash_generated_method = "7871F857AAAB1147566CC48D6239F053")
    @Override
    protected void onBindView(View view) {
        
        addTaint(view.getTaint());
        super.onBindView(view);
        View checkboxView = view.findViewById(com.android.internal.R.id.checkbox);
    if(checkboxView != null && checkboxView instanceof Checkable)        
        {
            ((Checkable) checkboxView).setChecked(mChecked);
            sendAccessibilityEvent(checkboxView);
        } 
        syncSummaryView(view);
        
        
        
        
            
            
        
        
    }

    
}

