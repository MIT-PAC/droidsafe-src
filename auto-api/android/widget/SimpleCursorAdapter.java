package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.view.View;

public class SimpleCursorAdapter extends ResourceCursorAdapter {
    protected int[] mFrom;
    protected int[] mTo;
    private int mStringConversionColumn = -1;
    private CursorToStringConverter mCursorToStringConverter;
    private ViewBinder mViewBinder;
    String[] mOriginalFrom;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.535 -0400", hash_original_method = "4CA266072E0BEF58A4BC70323B402D31", hash_generated_method = "B16F8A92D9C483F1329D476D83880D0C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public SimpleCursorAdapter(Context context, int layout, Cursor c, String[] from, int[] to) {
        super(context, layout, c);
        dsTaint.addTaint(to[0]);
        dsTaint.addTaint(c.dsTaint);
        dsTaint.addTaint(layout);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(from[0]);
        findColumns(from);
        // ---------- Original Method ----------
        //mTo = to;
        //mOriginalFrom = from;
        //findColumns(from);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.535 -0400", hash_original_method = "07FEC305B6EF36E13BFB609FC3D08908", hash_generated_method = "392DD3CF52BBACF4DA0113D0CAF4D617")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SimpleCursorAdapter(Context context, int layout, Cursor c, String[] from,
            int[] to, int flags) {
        super(context, layout, c, flags);
        dsTaint.addTaint(to[0]);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(c.dsTaint);
        dsTaint.addTaint(layout);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(from[0]);
        findColumns(from);
        // ---------- Original Method ----------
        //mTo = to;
        //mOriginalFrom = from;
        //findColumns(from);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.536 -0400", hash_original_method = "DC8B275A35A5B1D2099C370F56E50BB9", hash_generated_method = "434BA1DD9C3F5A169F1619A52678F327")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        dsTaint.addTaint(cursor.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(view.dsTaint);
        ViewBinder binder;
        binder = mViewBinder;
        int count;
        count = mTo.length;
        int[] from;
        from = mFrom;
        int[] to;
        to = mTo;
        {
            int i;
            i = 0;
            {
                View v;
                v = view.findViewById(to[i]);
                {
                    boolean bound;
                    bound = false;
                    {
                        bound = binder.setViewValue(v, cursor, from[i]);
                    } //End block
                    {
                        String text;
                        text = cursor.getString(from[i]);
                        {
                            text = "";
                        } //End block
                        {
                            setViewText((TextView) v, text);
                        } //End block
                        {
                            setViewImage((ImageView) v, text);
                        } //End block
                        {
                            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(v.getClass().getName() + " is not a " +
                                " view that can be bounds by this SimpleCursorAdapter");
                        } //End block
                    } //End block
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.536 -0400", hash_original_method = "E0E2C9BDE209838004B6CAB60CB87613", hash_generated_method = "CAECD65D9B62B932B579F1D0CC746F3F")
    @DSModeled(DSC.SAFE)
    public ViewBinder getViewBinder() {
        return (ViewBinder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mViewBinder;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.536 -0400", hash_original_method = "119DFC3ED073D5B4FB9A3C0337902379", hash_generated_method = "6A2F46BCFBAFDDF5F790CFEDA9A5804E")
    @DSModeled(DSC.SAFE)
    public void setViewBinder(ViewBinder viewBinder) {
        dsTaint.addTaint(viewBinder.dsTaint);
        // ---------- Original Method ----------
        //mViewBinder = viewBinder;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.537 -0400", hash_original_method = "31A5526470C992FDAE212BFFA88B0730", hash_generated_method = "CE085611AA522476003D6D197DA78852")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setViewImage(ImageView v, String value) {
        dsTaint.addTaint(v.dsTaint);
        dsTaint.addTaint(value);
        try 
        {
            v.setImageResource(Integer.parseInt(value));
        } //End block
        catch (NumberFormatException nfe)
        {
            v.setImageURI(Uri.parse(value));
        } //End block
        // ---------- Original Method ----------
        //try {
            //v.setImageResource(Integer.parseInt(value));
        //} catch (NumberFormatException nfe) {
            //v.setImageURI(Uri.parse(value));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.537 -0400", hash_original_method = "5AA8DD17AC94ADB8D267F5D4267EA13E", hash_generated_method = "73D0869DBE490F835EF3ABD92D71BA20")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setViewText(TextView v, String text) {
        dsTaint.addTaint(v.dsTaint);
        dsTaint.addTaint(text);
        v.setText(text);
        // ---------- Original Method ----------
        //v.setText(text);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.537 -0400", hash_original_method = "505C15BD7A524BAA123874B0B6BE7D4B", hash_generated_method = "0B082FD6D05F694C7CBFB8BFEA869214")
    @DSModeled(DSC.SAFE)
    public int getStringConversionColumn() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mStringConversionColumn;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.537 -0400", hash_original_method = "CAA7C791E82A28ED194AFE600FF6DEEE", hash_generated_method = "1040B8D0174AC5CE546A12B2E567B273")
    @DSModeled(DSC.SAFE)
    public void setStringConversionColumn(int stringConversionColumn) {
        dsTaint.addTaint(stringConversionColumn);
        // ---------- Original Method ----------
        //mStringConversionColumn = stringConversionColumn;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.537 -0400", hash_original_method = "80E6B5584C3F52CF90E7103CF53469C6", hash_generated_method = "6F0AA370C5208B2348CA704DA9C87DC1")
    @DSModeled(DSC.SAFE)
    public CursorToStringConverter getCursorToStringConverter() {
        return (CursorToStringConverter)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mCursorToStringConverter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.537 -0400", hash_original_method = "5D90B32B884A493C1622C9D829A83B10", hash_generated_method = "5097AC3D5D513CAC0893FFF5CCC8423B")
    @DSModeled(DSC.SAFE)
    public void setCursorToStringConverter(CursorToStringConverter cursorToStringConverter) {
        dsTaint.addTaint(cursorToStringConverter.dsTaint);
        // ---------- Original Method ----------
        //mCursorToStringConverter = cursorToStringConverter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.538 -0400", hash_original_method = "600E1910E4ECD6C26E4D3B813A27ACFC", hash_generated_method = "9BC3794A534F3E8B4B5C8CD4F66C4633")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public CharSequence convertToString(Cursor cursor) {
        dsTaint.addTaint(cursor.dsTaint);
        {
            CharSequence var6189414100EEA9A4230F8D8AA3BFB95D_1962737563 = (mCursorToStringConverter.convertToString(cursor));
        } //End block
        {
            CharSequence var7626C22DEBA60A6A21B2A4E0B1DC6C6D_95120217 = (cursor.getString(mStringConversionColumn));
        } //End block
        CharSequence var50DC25DC4A30BE082F62477C1AE559DF_1684867205 = (super.convertToString(cursor));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (mCursorToStringConverter != null) {
            //return mCursorToStringConverter.convertToString(cursor);
        //} else if (mStringConversionColumn > -1) {
            //return cursor.getString(mStringConversionColumn);
        //}
        //return super.convertToString(cursor);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.538 -0400", hash_original_method = "FB1AB395EA625B0EC9BE174CD444F84E", hash_generated_method = "96C268AA0FD10225245989DEC9FB3EDC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void findColumns(String[] from) {
        dsTaint.addTaint(from[0]);
        {
            int i;
            int count;
            count = from.length;
            {
                mFrom = new int[count];
            } //End block
            {
                i = 0;
                {
                    mFrom[i] = mCursor.getColumnIndexOrThrow(from[i]);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            mFrom = null;
        } //End block
        // ---------- Original Method ----------
        //if (mCursor != null) {
            //int i;
            //int count = from.length;
            //if (mFrom == null || mFrom.length != count) {
                //mFrom = new int[count];
            //}
            //for (i = 0; i < count; i++) {
                //mFrom[i] = mCursor.getColumnIndexOrThrow(from[i]);
            //}
        //} else {
            //mFrom = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.538 -0400", hash_original_method = "4582D229162590CE1749F675A6BA90D6", hash_generated_method = "BB04FD6FB862DE67139A602037378C1E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Cursor swapCursor(Cursor c) {
        dsTaint.addTaint(c.dsTaint);
        {
            findColumns(mOriginalFrom);
        } //End block
        Cursor res;
        res = super.swapCursor(c);
        findColumns(mOriginalFrom);
        return (Cursor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mFrom == null) {
            //findColumns(mOriginalFrom);
        //}
        //Cursor res = super.swapCursor(c);
        //findColumns(mOriginalFrom);
        //return res;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.538 -0400", hash_original_method = "6EF93FFBB8E610946B54D3F2EC498321", hash_generated_method = "83ACEF15B1027247518CF6B2B3D4C540")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void changeCursorAndColumns(Cursor c, String[] from, int[] to) {
        dsTaint.addTaint(to[0]);
        dsTaint.addTaint(c.dsTaint);
        dsTaint.addTaint(from[0]);
        {
            findColumns(mOriginalFrom);
        } //End block
        super.changeCursor(c);
        findColumns(mOriginalFrom);
        // ---------- Original Method ----------
        //mOriginalFrom = from;
        //mTo = to;
        //if (mFrom == null) {
            //findColumns(mOriginalFrom);
        //}
        //super.changeCursor(c);
        //findColumns(mOriginalFrom);
    }

    
    public static interface ViewBinder {
        
        boolean setViewValue(View view, Cursor cursor, int columnIndex);
    }
    
    public static interface CursorToStringConverter {
        
        CharSequence convertToString(Cursor cursor);
    }
    
}

