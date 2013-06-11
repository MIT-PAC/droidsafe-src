package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.382 -0400", hash_original_method = "4CA266072E0BEF58A4BC70323B402D31", hash_generated_method = "48654CECD14F562EFDE789B307704D64")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public SimpleCursorAdapter(Context context, int layout, Cursor c, String[] from, int[] to) {
        super(context, layout, c);
        dsTaint.addTaint(to);
        dsTaint.addTaint(c.dsTaint);
        dsTaint.addTaint(layout);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(from);
        findColumns(from);
        // ---------- Original Method ----------
        //mTo = to;
        //mOriginalFrom = from;
        //findColumns(from);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.382 -0400", hash_original_method = "07FEC305B6EF36E13BFB609FC3D08908", hash_generated_method = "624C22CB814941595C8FD66C7F29E3F8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SimpleCursorAdapter(Context context, int layout, Cursor c, String[] from,
            int[] to, int flags) {
        super(context, layout, c, flags);
        dsTaint.addTaint(to);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(c.dsTaint);
        dsTaint.addTaint(layout);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(from);
        findColumns(from);
        // ---------- Original Method ----------
        //mTo = to;
        //mOriginalFrom = from;
        //findColumns(from);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.382 -0400", hash_original_method = "DC8B275A35A5B1D2099C370F56E50BB9", hash_generated_method = "C0359FFD6863E8D6B44EA03C7CAABE29")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        dsTaint.addTaint(cursor.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(view.dsTaint);
        final ViewBinder binder;
        binder = mViewBinder;
        final int count;
        count = mTo.length;
        final int[] from;
        from = mFrom;
        final int[] to;
        to = mTo;
        {
            int i;
            i = 0;
            {
                final View v;
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
                            throw new IllegalStateException(v.getClass().getName() + " is not a " +
                                " view that can be bounds by this SimpleCursorAdapter");
                        } //End block
                    } //End block
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.382 -0400", hash_original_method = "E0E2C9BDE209838004B6CAB60CB87613", hash_generated_method = "B7C159CD5C78FC330018146E62554154")
    @DSModeled(DSC.SAFE)
    public ViewBinder getViewBinder() {
        return (ViewBinder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mViewBinder;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.382 -0400", hash_original_method = "119DFC3ED073D5B4FB9A3C0337902379", hash_generated_method = "10FA99797254E1FF2740D41E30C9C036")
    @DSModeled(DSC.SAFE)
    public void setViewBinder(ViewBinder viewBinder) {
        dsTaint.addTaint(viewBinder.dsTaint);
        // ---------- Original Method ----------
        //mViewBinder = viewBinder;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.382 -0400", hash_original_method = "31A5526470C992FDAE212BFFA88B0730", hash_generated_method = "52BA9C00ABE30DB5A65057B0EDEC3108")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.382 -0400", hash_original_method = "5AA8DD17AC94ADB8D267F5D4267EA13E", hash_generated_method = "384D35A4211CAE94D41E30B25BF180C5")
    @DSModeled(DSC.SAFE)
    public void setViewText(TextView v, String text) {
        dsTaint.addTaint(v.dsTaint);
        dsTaint.addTaint(text);
        v.setText(text);
        // ---------- Original Method ----------
        //v.setText(text);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.382 -0400", hash_original_method = "505C15BD7A524BAA123874B0B6BE7D4B", hash_generated_method = "BE25F6D3833170D0749AA62E581BB02F")
    @DSModeled(DSC.SAFE)
    public int getStringConversionColumn() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mStringConversionColumn;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.382 -0400", hash_original_method = "CAA7C791E82A28ED194AFE600FF6DEEE", hash_generated_method = "92B2158C99C9EED0E4490F3CCEBE8C87")
    @DSModeled(DSC.SAFE)
    public void setStringConversionColumn(int stringConversionColumn) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(stringConversionColumn);
        // ---------- Original Method ----------
        //mStringConversionColumn = stringConversionColumn;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.382 -0400", hash_original_method = "80E6B5584C3F52CF90E7103CF53469C6", hash_generated_method = "46CD3F2DCEF4F203D0528BBF903C7749")
    @DSModeled(DSC.SAFE)
    public CursorToStringConverter getCursorToStringConverter() {
        return (CursorToStringConverter)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mCursorToStringConverter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.382 -0400", hash_original_method = "5D90B32B884A493C1622C9D829A83B10", hash_generated_method = "A20738075AF65423ED53784BEFA32A04")
    @DSModeled(DSC.SAFE)
    public void setCursorToStringConverter(CursorToStringConverter cursorToStringConverter) {
        dsTaint.addTaint(cursorToStringConverter.dsTaint);
        // ---------- Original Method ----------
        //mCursorToStringConverter = cursorToStringConverter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.382 -0400", hash_original_method = "600E1910E4ECD6C26E4D3B813A27ACFC", hash_generated_method = "EAA259648A5CBCF418C2B851752EB983")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public CharSequence convertToString(Cursor cursor) {
        dsTaint.addTaint(cursor.dsTaint);
        {
            CharSequence var6189414100EEA9A4230F8D8AA3BFB95D_267806777 = (mCursorToStringConverter.convertToString(cursor));
        } //End block
        {
            CharSequence var7626C22DEBA60A6A21B2A4E0B1DC6C6D_560959302 = (cursor.getString(mStringConversionColumn));
        } //End block
        CharSequence var50DC25DC4A30BE082F62477C1AE559DF_812239729 = (super.convertToString(cursor));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (mCursorToStringConverter != null) {
            //return mCursorToStringConverter.convertToString(cursor);
        //} else if (mStringConversionColumn > -1) {
            //return cursor.getString(mStringConversionColumn);
        //}
        //return super.convertToString(cursor);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.383 -0400", hash_original_method = "FB1AB395EA625B0EC9BE174CD444F84E", hash_generated_method = "C3B2B16DFE1C5F108E15FF760D9415FC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void findColumns(String[] from) {
        dsTaint.addTaint(from);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.383 -0400", hash_original_method = "4582D229162590CE1749F675A6BA90D6", hash_generated_method = "2E1F561320CB2454C257D1D3EDA305D9")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.383 -0400", hash_original_method = "6EF93FFBB8E610946B54D3F2EC498321", hash_generated_method = "8415435408E2B7565D5B8DB8E27F1AF8")
    @DSModeled(DSC.SAFE)
    public void changeCursorAndColumns(Cursor c, String[] from, int[] to) {
        dsTaint.addTaint(to);
        dsTaint.addTaint(c.dsTaint);
        dsTaint.addTaint(from);
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


