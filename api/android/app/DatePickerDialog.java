package android.app;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;

import com.android.internal.R;






public class DatePickerDialog extends AlertDialog implements OnClickListener, OnDateChangedListener {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:11.801 -0500", hash_original_field = "B7AA87D32B28FE478384212C097AD19C", hash_generated_field = "715BF2B6EED4C3FE3E86E3A39D84F985")


    private static final String YEAR = "year";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:11.802 -0500", hash_original_field = "9F0A6B6AAD4D53826F6C9703A75F40C4", hash_generated_field = "C2C6B9A79A0675D8FE71673F79432CD1")

    private static final String MONTH = "month";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:11.803 -0500", hash_original_field = "386E6909E0E6F9A03979FCD89BE3314C", hash_generated_field = "3B4FA25F51A207549D78B5EB901DC517")

    private static final String DAY = "day";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:11.804 -0500", hash_original_field = "20EE245A73140962C286D6A7892043E8", hash_generated_field = "05F9D0F5474453E7C5E8E716C553678E")


    private  DatePicker mDatePicker;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:11.804 -0500", hash_original_field = "48507B2C122CE1DA71AAD77532BFB39C", hash_generated_field = "931F1F97D88ABEED90A7F56976F06E7A")

    private  OnDateSetListener mCallBack;

    /**
     * @param context The context the dialog is to run in.
     * @param callBack How the parent is notified that the date is set.
     * @param year The initial year of the dialog.
     * @param monthOfYear The initial month of the dialog.
     * @param dayOfMonth The initial day of the dialog.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:11.806 -0500", hash_original_method = "45DFC999AB5975804639ACA9BF45B7CD", hash_generated_method = "C131E8D30866BA9A0E6E72D918391F7C")
    public DatePickerDialog(Context context,
            OnDateSetListener callBack,
            int year,
            int monthOfYear,
            int dayOfMonth) {
        this(context, 0, callBack, year, monthOfYear, dayOfMonth);
    }

    /**
     * @param context The context the dialog is to run in.
     * @param theme the theme to apply to this dialog
     * @param callBack How the parent is notified that the date is set.
     * @param year The initial year of the dialog.
     * @param monthOfYear The initial month of the dialog.
     * @param dayOfMonth The initial day of the dialog.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:11.807 -0500", hash_original_method = "6DE1DD9A3E1C9A1CF6C571076F7EF456", hash_generated_method = "4CAB26F69036C1FC7BDB5F99ED71E6D9")
    public DatePickerDialog(Context context,
            int theme,
            OnDateSetListener callBack,
            int year,
            int monthOfYear,
            int dayOfMonth) {
        super(context, theme);

        mCallBack = callBack;

        Context themeContext = getContext();
        setButton(BUTTON_POSITIVE, themeContext.getText(R.string.date_time_set), this);
        setButton(BUTTON_NEGATIVE, themeContext.getText(R.string.cancel), (OnClickListener) null);
        setIcon(0);
        setTitle(R.string.date_picker_dialog_title);

        LayoutInflater inflater =
                (LayoutInflater) themeContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.date_picker_dialog, null);
        setView(view);
        mDatePicker = (DatePicker) view.findViewById(R.id.datePicker);
        mDatePicker.init(year, monthOfYear, dayOfMonth, this);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:11.808 -0500", hash_original_method = "570F8D0CC141D3B1D2B15B140C7533C1", hash_generated_method = "52C59E61F92863688756C3CD6E6DA3F8")
    public void onClick(DialogInterface dialog, int which) {
        if (mCallBack != null) {
            mDatePicker.clearFocus();
            mCallBack.onDateSet(mDatePicker, mDatePicker.getYear(),
                    mDatePicker.getMonth(), mDatePicker.getDayOfMonth());
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:11.809 -0500", hash_original_method = "5B2F5D001AB6D47E96CA9095E2255728", hash_generated_method = "99027F4232922A8F8A8C1890B242D6D1")
    public void onDateChanged(DatePicker view, int year,
            int month, int day) {
        mDatePicker.init(year, month, day, null);
    }

    /**
     * Gets the {@link DatePicker} contained in this dialog.
     *
     * @return The calendar view.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:11.810 -0500", hash_original_method = "54FCA4CF326BECF6DDD25A8F55E4D660", hash_generated_method = "4FECB11BA435634CBC04D39C1DE3148C")
    public DatePicker getDatePicker() {
        return mDatePicker;
    }

    
    public interface OnDateSetListener {

        
        void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth);
    }

    /**
     * Sets the current date.
     *
     * @param year The date year.
     * @param monthOfYear The date month.
     * @param dayOfMonth The date day of month.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:11.810 -0500", hash_original_method = "4D6EF653FEC320B1F3AFFECE700796E5", hash_generated_method = "C64DE5D357B4A8FF089E462A3F4CCD17")
    public void updateDate(int year, int monthOfYear, int dayOfMonth) {
        mDatePicker.updateDate(year, monthOfYear, dayOfMonth);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:11.811 -0500", hash_original_method = "66D833569B1DDDA11BC9B393F8A7D6F5", hash_generated_method = "E343E9E8239D6DD1D305FA6AF69FDFBA")
    @Override
public Bundle onSaveInstanceState() {
        Bundle state = super.onSaveInstanceState();
        state.putInt(YEAR, mDatePicker.getYear());
        state.putInt(MONTH, mDatePicker.getMonth());
        state.putInt(DAY, mDatePicker.getDayOfMonth());
        return state;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:11.812 -0500", hash_original_method = "B84D42280083F8905ED43E1BDBCA6009", hash_generated_method = "5997227DAA681715D673AE64C70B6464")
    @Override
public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        int year = savedInstanceState.getInt(YEAR);
        int month = savedInstanceState.getInt(MONTH);
        int day = savedInstanceState.getInt(DAY);
        mDatePicker.init(year, month, day, this);
    }
}

