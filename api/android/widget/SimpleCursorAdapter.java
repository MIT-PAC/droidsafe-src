package android.widget;

// Droidsafe Imports
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.view.View;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class SimpleCursorAdapter extends ResourceCursorAdapter {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.008 -0400", hash_original_field = "EDE7DB5B0C4E79BD52B42E685F59B951", hash_generated_field = "6AD876BF1B2A93FF841DC0A6CDF82D53")

    protected int[] mFrom;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.008 -0400", hash_original_field = "6F69D0C4D879F039DD614BB6C1B21419", hash_generated_field = "793C2D88DE3BA12DDE77A56E8B34D202")

    protected int[] mTo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.008 -0400", hash_original_field = "CEFDB9C920BEC19CE1E004D5AC98B46C", hash_generated_field = "76FAAB307CBAB2502A74F2FD4809A2B4")

    private int mStringConversionColumn = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.008 -0400", hash_original_field = "B735DBCD7F83F11089B3A7B11285F9CD", hash_generated_field = "9EC5CDC29EBE32FECD7EDABDB5C61341")

    private CursorToStringConverter mCursorToStringConverter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.008 -0400", hash_original_field = "DDDBAA0AB795AF915BA6E626A345701D", hash_generated_field = "308F8B2EF2E94DF958649BB3CD716341")

    private ViewBinder mViewBinder;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.008 -0400", hash_original_field = "6B24384939EB196E5C49F9311020A192", hash_generated_field = "393D022CD0A88B84A417682AA08505E2")

    String[] mOriginalFrom;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.009 -0400", hash_original_method = "4CA266072E0BEF58A4BC70323B402D31", hash_generated_method = "D4EC842A580A19EF5EC4D153D5B9C6B0")
    @Deprecated
    public  SimpleCursorAdapter(Context context, int layout, Cursor c, String[] from, int[] to) {
        super(context, layout, c);
        addTaint(c.getTaint());
        addTaint(layout);
        addTaint(context.getTaint());
        mTo = to;
        mOriginalFrom = from;
        findColumns(from);
        // ---------- Original Method ----------
        //mTo = to;
        //mOriginalFrom = from;
        //findColumns(from);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.010 -0400", hash_original_method = "07FEC305B6EF36E13BFB609FC3D08908", hash_generated_method = "F320B5A94D3A47CF71AB8A17263C3779")
    public  SimpleCursorAdapter(Context context, int layout, Cursor c, String[] from,
            int[] to, int flags) {
        super(context, layout, c, flags);
        addTaint(flags);
        addTaint(c.getTaint());
        addTaint(layout);
        addTaint(context.getTaint());
        mTo = to;
        mOriginalFrom = from;
        findColumns(from);
        // ---------- Original Method ----------
        //mTo = to;
        //mOriginalFrom = from;
        //findColumns(from);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.011 -0400", hash_original_method = "DC8B275A35A5B1D2099C370F56E50BB9", hash_generated_method = "B794107BA52DBC04CE787349AB62E0C9")
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        addTaint(cursor.getTaint());
        addTaint(context.getTaint());
        addTaint(view.getTaint());
        final ViewBinder binder = mViewBinder;
        final int count = mTo.length;
        final int[] from = mFrom;
        final int[] to = mTo;
for(int i = 0;i < count;i++)
        {
            final View v = view.findViewById(to[i]);
            if(v != null)            
            {
                boolean bound = false;
                if(binder != null)                
                {
                    bound = binder.setViewValue(v, cursor, from[i]);
                } //End block
                if(!bound)                
                {
                    String text = cursor.getString(from[i]);
                    if(text == null)                    
                    {
                        text = "";
                    } //End block
                    if(v instanceof TextView)                    
                    {
                        setViewText((TextView) v, text);
                    } //End block
                    else
                    if(v instanceof ImageView)                    
                    {
                        setViewImage((ImageView) v, text);
                    } //End block
                    else
                    {
                        IllegalStateException var749A7EC8D8FCA3CD7C0859119811E4C2_947506020 = new IllegalStateException(v.getClass().getName() + " is not a " +
                                " view that can be bounds by this SimpleCursorAdapter");
                        var749A7EC8D8FCA3CD7C0859119811E4C2_947506020.addTaint(taint);
                        throw var749A7EC8D8FCA3CD7C0859119811E4C2_947506020;
                    } //End block
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.012 -0400", hash_original_method = "E0E2C9BDE209838004B6CAB60CB87613", hash_generated_method = "C0F0A72F2E8815A99D09BBC411E73420")
    public ViewBinder getViewBinder() {
ViewBinder var3599647BDC732C2D53724CC7D8743271_1233704137 =         mViewBinder;
        var3599647BDC732C2D53724CC7D8743271_1233704137.addTaint(taint);
        return var3599647BDC732C2D53724CC7D8743271_1233704137;
        // ---------- Original Method ----------
        //return mViewBinder;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.013 -0400", hash_original_method = "119DFC3ED073D5B4FB9A3C0337902379", hash_generated_method = "3E071F9EE6E9AEAADA16E4C43987A93F")
    public void setViewBinder(ViewBinder viewBinder) {
        mViewBinder = viewBinder;
        // ---------- Original Method ----------
        //mViewBinder = viewBinder;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.014 -0400", hash_original_method = "31A5526470C992FDAE212BFFA88B0730", hash_generated_method = "E06B0A7D875362159E7B590763BC1C85")
    public void setViewImage(ImageView v, String value) {
        addTaint(value.getTaint());
        addTaint(v.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.014 -0400", hash_original_method = "5AA8DD17AC94ADB8D267F5D4267EA13E", hash_generated_method = "6059A05BA24D864572F36CFBDDA47D36")
    public void setViewText(TextView v, String text) {
        addTaint(text.getTaint());
        addTaint(v.getTaint());
        v.setText(text);
        // ---------- Original Method ----------
        //v.setText(text);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.014 -0400", hash_original_method = "505C15BD7A524BAA123874B0B6BE7D4B", hash_generated_method = "D4B199B20F56E96D9C69A68F62619D63")
    public int getStringConversionColumn() {
        int var73FDABBD0F6BEA9973ECC8B05CD8B242_1804665567 = (mStringConversionColumn);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1385699584 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1385699584;
        // ---------- Original Method ----------
        //return mStringConversionColumn;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.015 -0400", hash_original_method = "CAA7C791E82A28ED194AFE600FF6DEEE", hash_generated_method = "394118E429FB1DEC632B04FC7B5FB220")
    public void setStringConversionColumn(int stringConversionColumn) {
        mStringConversionColumn = stringConversionColumn;
        // ---------- Original Method ----------
        //mStringConversionColumn = stringConversionColumn;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.015 -0400", hash_original_method = "80E6B5584C3F52CF90E7103CF53469C6", hash_generated_method = "90BEB2D9F4EAE92BE8E349F71513B464")
    public CursorToStringConverter getCursorToStringConverter() {
CursorToStringConverter var860B777AC20C8FD62D683E658AB1E21B_1185554490 =         mCursorToStringConverter;
        var860B777AC20C8FD62D683E658AB1E21B_1185554490.addTaint(taint);
        return var860B777AC20C8FD62D683E658AB1E21B_1185554490;
        // ---------- Original Method ----------
        //return mCursorToStringConverter;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.016 -0400", hash_original_method = "5D90B32B884A493C1622C9D829A83B10", hash_generated_method = "A9ACEF1EC294D60B7393749911E2426C")
    public void setCursorToStringConverter(CursorToStringConverter cursorToStringConverter) {
        mCursorToStringConverter = cursorToStringConverter;
        // ---------- Original Method ----------
        //mCursorToStringConverter = cursorToStringConverter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.016 -0400", hash_original_method = "600E1910E4ECD6C26E4D3B813A27ACFC", hash_generated_method = "9122BF95EBDF2CD92463E56EBD4907F0")
    @Override
    public CharSequence convertToString(Cursor cursor) {
        addTaint(cursor.getTaint());
        if(mCursorToStringConverter != null)        
        {
CharSequence varDA1BE9D6B1D28918A3D63DE5E10084B4_986236428 =             mCursorToStringConverter.convertToString(cursor);
            varDA1BE9D6B1D28918A3D63DE5E10084B4_986236428.addTaint(taint);
            return varDA1BE9D6B1D28918A3D63DE5E10084B4_986236428;
        } //End block
        else
        if(mStringConversionColumn > -1)        
        {
CharSequence varBFECB79E7C1A67A8A7F77434B8A59A0D_220195286 =             cursor.getString(mStringConversionColumn);
            varBFECB79E7C1A67A8A7F77434B8A59A0D_220195286.addTaint(taint);
            return varBFECB79E7C1A67A8A7F77434B8A59A0D_220195286;
        } //End block
CharSequence var081817866C3B88B7C446C3ACFBAD57D7_1158493341 =         super.convertToString(cursor);
        var081817866C3B88B7C446C3ACFBAD57D7_1158493341.addTaint(taint);
        return var081817866C3B88B7C446C3ACFBAD57D7_1158493341;
        // ---------- Original Method ----------
        //if (mCursorToStringConverter != null) {
            //return mCursorToStringConverter.convertToString(cursor);
        //} else if (mStringConversionColumn > -1) {
            //return cursor.getString(mStringConversionColumn);
        //}
        //return super.convertToString(cursor);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.017 -0400", hash_original_method = "FB1AB395EA625B0EC9BE174CD444F84E", hash_generated_method = "1CEB9E15C6F76DE34215B06CC30C3FD7")
    private void findColumns(String[] from) {
        if(mCursor != null)        
        {
            int i;
            int count = from.length;
            if(mFrom == null || mFrom.length != count)            
            {
                mFrom = new int[count];
            } //End block
for(i = 0;i < count;i++)
            {
                mFrom[i] = mCursor.getColumnIndexOrThrow(from[i]);
            } //End block
        } //End block
        else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.018 -0400", hash_original_method = "4582D229162590CE1749F675A6BA90D6", hash_generated_method = "C7F286197648E2EB718C217F428175BA")
    @Override
    public Cursor swapCursor(Cursor c) {
        addTaint(c.getTaint());
        if(mFrom == null)        
        {
            findColumns(mOriginalFrom);
        } //End block
        Cursor res = super.swapCursor(c);
        findColumns(mOriginalFrom);
Cursor varB5053E025797B3BF768F5C37934C244D_1086164366 =         res;
        varB5053E025797B3BF768F5C37934C244D_1086164366.addTaint(taint);
        return varB5053E025797B3BF768F5C37934C244D_1086164366;
        // ---------- Original Method ----------
        //if (mFrom == null) {
            //findColumns(mOriginalFrom);
        //}
        //Cursor res = super.swapCursor(c);
        //findColumns(mOriginalFrom);
        //return res;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.018 -0400", hash_original_method = "6EF93FFBB8E610946B54D3F2EC498321", hash_generated_method = "9265D01264E1A78A7E0ECD1200CF4812")
    public void changeCursorAndColumns(Cursor c, String[] from, int[] to) {
        addTaint(c.getTaint());
        mOriginalFrom = from;
        mTo = to;
        if(mFrom == null)        
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

