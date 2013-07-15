package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import com.android.internal.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;

public class DatePickerDialog extends AlertDialog implements OnClickListener, OnDateChangedListener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.725 -0400", hash_original_field = "56B92357D639465E83CEBBB96147679C", hash_generated_field = "05F9D0F5474453E7C5E8E716C553678E")

    private DatePicker mDatePicker;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.725 -0400", hash_original_field = "8BC3249FA92CB067727BCB813629244A", hash_generated_field = "931F1F97D88ABEED90A7F56976F06E7A")

    private OnDateSetListener mCallBack;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.727 -0400", hash_original_method = "45DFC999AB5975804639ACA9BF45B7CD", hash_generated_method = "DDA21E49F8F3CD86AA040CA68EFE20B2")
    public  DatePickerDialog(Context context,
            OnDateSetListener callBack,
            int year,
            int monthOfYear,
            int dayOfMonth) {
        this(context, 0, callBack, year, monthOfYear, dayOfMonth);
        addTaint(dayOfMonth);
        addTaint(monthOfYear);
        addTaint(year);
        addTaint(callBack.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.729 -0400", hash_original_method = "6DE1DD9A3E1C9A1CF6C571076F7EF456", hash_generated_method = "6A830B39C37A7E72D17B7EB52EA143E0")
    public  DatePickerDialog(Context context,
            int theme,
            OnDateSetListener callBack,
            int year,
            int monthOfYear,
            int dayOfMonth) {
        super(context, theme);
        addTaint(dayOfMonth);
        addTaint(monthOfYear);
        addTaint(year);
        addTaint(theme);
        addTaint(context.getTaint());
        mCallBack = callBack;
        Context themeContext = getContext();
        setButton(BUTTON_POSITIVE, themeContext.getText(R.string.date_time_set), this);
        setButton(BUTTON_NEGATIVE, themeContext.getText(R.string.cancel), (OnClickListener) null);
        setIcon(0);
        setTitle(R.string.date_picker_dialog_title);
        LayoutInflater inflater = (LayoutInflater) themeContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.date_picker_dialog, null);
        setView(view);
        mDatePicker = (DatePicker) view.findViewById(R.id.datePicker);
        mDatePicker.init(year, monthOfYear, dayOfMonth, this);
        // ---------- Original Method ----------
        //mCallBack = callBack;
        //Context themeContext = getContext();
        //setButton(BUTTON_POSITIVE, themeContext.getText(R.string.date_time_set), this);
        //setButton(BUTTON_NEGATIVE, themeContext.getText(R.string.cancel), (OnClickListener) null);
        //setIcon(0);
        //setTitle(R.string.date_picker_dialog_title);
        //LayoutInflater inflater =
                //(LayoutInflater) themeContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //View view = inflater.inflate(R.layout.date_picker_dialog, null);
        //setView(view);
        //mDatePicker = (DatePicker) view.findViewById(R.id.datePicker);
        //mDatePicker.init(year, monthOfYear, dayOfMonth, this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.730 -0400", hash_original_method = "570F8D0CC141D3B1D2B15B140C7533C1", hash_generated_method = "16C39278F3143831DA3553CD5BC45543")
    public void onClick(DialogInterface dialog, int which) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(which);
        addTaint(dialog.getTaint());
    if(mCallBack != null)        
        {
            mDatePicker.clearFocus();
            mCallBack.onDateSet(mDatePicker, mDatePicker.getYear(),
                    mDatePicker.getMonth(), mDatePicker.getDayOfMonth());
        } //End block
        // ---------- Original Method ----------
        //if (mCallBack != null) {
            //mDatePicker.clearFocus();
            //mCallBack.onDateSet(mDatePicker, mDatePicker.getYear(),
                    //mDatePicker.getMonth(), mDatePicker.getDayOfMonth());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.732 -0400", hash_original_method = "5B2F5D001AB6D47E96CA9095E2255728", hash_generated_method = "0691471494E36896916BBBDC1BE3F0D5")
    public void onDateChanged(DatePicker view, int year,
            int month, int day) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(day);
        addTaint(month);
        addTaint(year);
        addTaint(view.getTaint());
        mDatePicker.init(year, month, day, null);
        // ---------- Original Method ----------
        //mDatePicker.init(year, month, day, null);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.733 -0400", hash_original_method = "54FCA4CF326BECF6DDD25A8F55E4D660", hash_generated_method = "38E347DD6ADEFF38D1E6619E32E2ECA1")
    public DatePicker getDatePicker() {
DatePicker varD27B4AF16BDD34A107C6FB34013DD24E_702538829 =         mDatePicker;
        varD27B4AF16BDD34A107C6FB34013DD24E_702538829.addTaint(taint);
        return varD27B4AF16BDD34A107C6FB34013DD24E_702538829;
        // ---------- Original Method ----------
        //return mDatePicker;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.734 -0400", hash_original_method = "4D6EF653FEC320B1F3AFFECE700796E5", hash_generated_method = "8623244D2F8CE5D4C17990FAFEFE3E01")
    public void updateDate(int year, int monthOfYear, int dayOfMonth) {
        addTaint(dayOfMonth);
        addTaint(monthOfYear);
        addTaint(year);
        mDatePicker.updateDate(year, monthOfYear, dayOfMonth);
        // ---------- Original Method ----------
        //mDatePicker.updateDate(year, monthOfYear, dayOfMonth);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.734 -0400", hash_original_method = "66D833569B1DDDA11BC9B393F8A7D6F5", hash_generated_method = "799934ED3D4C71404768DF632150F38F")
    @Override
    public Bundle onSaveInstanceState() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Bundle state = super.onSaveInstanceState();
        state.putInt(YEAR, mDatePicker.getYear());
        state.putInt(MONTH, mDatePicker.getMonth());
        state.putInt(DAY, mDatePicker.getDayOfMonth());
Bundle var37C56C9D63C623261861C16DCFB73F6D_378397728 =         state;
        var37C56C9D63C623261861C16DCFB73F6D_378397728.addTaint(taint);
        return var37C56C9D63C623261861C16DCFB73F6D_378397728;
        // ---------- Original Method ----------
        //Bundle state = super.onSaveInstanceState();
        //state.putInt(YEAR, mDatePicker.getYear());
        //state.putInt(MONTH, mDatePicker.getMonth());
        //state.putInt(DAY, mDatePicker.getDayOfMonth());
        //return state;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.735 -0400", hash_original_method = "B84D42280083F8905ED43E1BDBCA6009", hash_generated_method = "486D25150A1CEDCFA4046F2340606D2C")
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(savedInstanceState.getTaint());
        super.onRestoreInstanceState(savedInstanceState);
        int year = savedInstanceState.getInt(YEAR);
        int month = savedInstanceState.getInt(MONTH);
        int day = savedInstanceState.getInt(DAY);
        mDatePicker.init(year, month, day, this);
        // ---------- Original Method ----------
        //super.onRestoreInstanceState(savedInstanceState);
        //int year = savedInstanceState.getInt(YEAR);
        //int month = savedInstanceState.getInt(MONTH);
        //int day = savedInstanceState.getInt(DAY);
        //mDatePicker.init(year, month, day, this);
    }

    
    public interface OnDateSetListener {

        
        void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.735 -0400", hash_original_field = "F0CAC65281DDCA10EA96F4B6C5A597B5", hash_generated_field = "715BF2B6EED4C3FE3E86E3A39D84F985")

    private static final String YEAR = "year";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.735 -0400", hash_original_field = "A7791802B14149DA1F910F6FBADEF4EC", hash_generated_field = "C2C6B9A79A0675D8FE71673F79432CD1")

    private static final String MONTH = "month";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.736 -0400", hash_original_field = "127E10169D72431CD44ABBA7BDB75CFD", hash_generated_field = "3B4FA25F51A207549D78B5EB901DC517")

    private static final String DAY = "day";
}

