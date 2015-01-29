package android.preference;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;

public class CheckBoxPreference extends TwoStatePreference {

    @DSComment("Perference UI, only change preference is spec")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:25.881 -0500", hash_original_method = "0F16DADCBE1918B293B8D2F1611CB9A4", hash_generated_method = "B667D154E92E896C41095BC6B5570722")
    
public CheckBoxPreference(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        
        TypedArray a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.CheckBoxPreference, defStyle, 0);
        setSummaryOn(a.getString(com.android.internal.R.styleable.CheckBoxPreference_summaryOn));
        setSummaryOff(a.getString(com.android.internal.R.styleable.CheckBoxPreference_summaryOff));
        setDisableDependentsState(a.getBoolean(
                com.android.internal.R.styleable.CheckBoxPreference_disableDependentsState, false));
        a.recycle();
    }

    @DSComment("Perference UI, only change preference is spec")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:25.883 -0500", hash_original_method = "5BAF688B2DF41A97AF3D677D6FF48D6E", hash_generated_method = "FDFEF114544B247CF58305BE4B522736")
    
public CheckBoxPreference(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.checkBoxPreferenceStyle);
    }

    @DSComment("Perference UI, only change preference is spec")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:25.886 -0500", hash_original_method = "18AEC3D719265C2FC8E8B7F461A380C1", hash_generated_method = "EB6AA4716E56F964B64FE646BF746047")
    
public CheckBoxPreference(Context context) {
        this(context, null);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:25.888 -0500", hash_original_method = "BFAE06CFE69D4939F40B9B050EA1DB64", hash_generated_method = "95E4B1642A869B2C34E4AC55781D9110")
    
@Override
    protected void onBindView(View view) {
        super.onBindView(view);

        View checkboxView = view.findViewById(com.android.internal.R.id.checkbox);
        if (checkboxView != null && checkboxView instanceof Checkable) {
            ((Checkable) checkboxView).setChecked(mChecked);
            sendAccessibilityEvent(checkboxView);
        }

        syncSummaryView(view);
    }
    
}

