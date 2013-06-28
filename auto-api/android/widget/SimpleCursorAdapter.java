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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.863 -0400", hash_original_field = "EDE7DB5B0C4E79BD52B42E685F59B951", hash_generated_field = "6AD876BF1B2A93FF841DC0A6CDF82D53")

    protected int[] mFrom;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.863 -0400", hash_original_field = "6F69D0C4D879F039DD614BB6C1B21419", hash_generated_field = "793C2D88DE3BA12DDE77A56E8B34D202")

    protected int[] mTo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.863 -0400", hash_original_field = "CEFDB9C920BEC19CE1E004D5AC98B46C", hash_generated_field = "76FAAB307CBAB2502A74F2FD4809A2B4")

    private int mStringConversionColumn = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.863 -0400", hash_original_field = "B735DBCD7F83F11089B3A7B11285F9CD", hash_generated_field = "9EC5CDC29EBE32FECD7EDABDB5C61341")

    private CursorToStringConverter mCursorToStringConverter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.863 -0400", hash_original_field = "DDDBAA0AB795AF915BA6E626A345701D", hash_generated_field = "308F8B2EF2E94DF958649BB3CD716341")

    private ViewBinder mViewBinder;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.863 -0400", hash_original_field = "6B24384939EB196E5C49F9311020A192", hash_generated_field = "393D022CD0A88B84A417682AA08505E2")

    String[] mOriginalFrom;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.864 -0400", hash_original_method = "4CA266072E0BEF58A4BC70323B402D31", hash_generated_method = "B80AC8A6A8977A7A9A1A8ACDC1391CD3")
    @Deprecated
    public  SimpleCursorAdapter(Context context, int layout, Cursor c, String[] from, int[] to) {
        super(context, layout, c);
        mTo = to;
        mOriginalFrom = from;
        findColumns(from);
        addTaint(context.getTaint());
        addTaint(layout);
        addTaint(c.getTaint());
        // ---------- Original Method ----------
        //mTo = to;
        //mOriginalFrom = from;
        //findColumns(from);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.864 -0400", hash_original_method = "07FEC305B6EF36E13BFB609FC3D08908", hash_generated_method = "98E65DF75FB0A629886E91A830466750")
    public  SimpleCursorAdapter(Context context, int layout, Cursor c, String[] from,
            int[] to, int flags) {
        super(context, layout, c, flags);
        mTo = to;
        mOriginalFrom = from;
        findColumns(from);
        addTaint(context.getTaint());
        addTaint(layout);
        addTaint(c.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //mTo = to;
        //mOriginalFrom = from;
        //findColumns(from);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.865 -0400", hash_original_method = "DC8B275A35A5B1D2099C370F56E50BB9", hash_generated_method = "07C18DE3FCBB6DBC83A872C40519FB8E")
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        final ViewBinder binder = mViewBinder;
        final int count = mTo.length;
        final int[] from = mFrom;
        final int[] to = mTo;
        {
            int i = 0;
            {
                final View v = view.findViewById(to[i]);
                {
                    boolean bound = false;
                    {
                        bound = binder.setViewValue(v, cursor, from[i]);
                    } //End block
                    {
                        String text = cursor.getString(from[i]);
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
        addTaint(view.getTaint());
        addTaint(context.getTaint());
        addTaint(cursor.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.865 -0400", hash_original_method = "E0E2C9BDE209838004B6CAB60CB87613", hash_generated_method = "FBC082D3EA224FA088D13355643C15C5")
    public ViewBinder getViewBinder() {
        ViewBinder varB4EAC82CA7396A68D541C85D26508E83_649235411 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_649235411 = mViewBinder;
        varB4EAC82CA7396A68D541C85D26508E83_649235411.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_649235411;
        // ---------- Original Method ----------
        //return mViewBinder;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.865 -0400", hash_original_method = "119DFC3ED073D5B4FB9A3C0337902379", hash_generated_method = "3E071F9EE6E9AEAADA16E4C43987A93F")
    public void setViewBinder(ViewBinder viewBinder) {
        mViewBinder = viewBinder;
        // ---------- Original Method ----------
        //mViewBinder = viewBinder;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.866 -0400", hash_original_method = "31A5526470C992FDAE212BFFA88B0730", hash_generated_method = "A719453AA57C570028BAEB7E56012A90")
    public void setViewImage(ImageView v, String value) {
        try 
        {
            v.setImageResource(Integer.parseInt(value));
        } //End block
        catch (NumberFormatException nfe)
        {
            v.setImageURI(Uri.parse(value));
        } //End block
        addTaint(v.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //try {
            //v.setImageResource(Integer.parseInt(value));
        //} catch (NumberFormatException nfe) {
            //v.setImageURI(Uri.parse(value));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.866 -0400", hash_original_method = "5AA8DD17AC94ADB8D267F5D4267EA13E", hash_generated_method = "9BCC5D52A6F9BAB62DC965ECB5B879C3")
    public void setViewText(TextView v, String text) {
        v.setText(text);
        addTaint(v.getTaint());
        addTaint(text.getTaint());
        // ---------- Original Method ----------
        //v.setText(text);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.867 -0400", hash_original_method = "505C15BD7A524BAA123874B0B6BE7D4B", hash_generated_method = "20DFBC93ECD3C579E06692E3696FCDF1")
    public int getStringConversionColumn() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_526622660 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_526622660;
        // ---------- Original Method ----------
        //return mStringConversionColumn;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.867 -0400", hash_original_method = "CAA7C791E82A28ED194AFE600FF6DEEE", hash_generated_method = "394118E429FB1DEC632B04FC7B5FB220")
    public void setStringConversionColumn(int stringConversionColumn) {
        mStringConversionColumn = stringConversionColumn;
        // ---------- Original Method ----------
        //mStringConversionColumn = stringConversionColumn;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.867 -0400", hash_original_method = "80E6B5584C3F52CF90E7103CF53469C6", hash_generated_method = "E6E2ED613260209580B50E31503F5EB9")
    public CursorToStringConverter getCursorToStringConverter() {
        CursorToStringConverter varB4EAC82CA7396A68D541C85D26508E83_678350861 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_678350861 = mCursorToStringConverter;
        varB4EAC82CA7396A68D541C85D26508E83_678350861.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_678350861;
        // ---------- Original Method ----------
        //return mCursorToStringConverter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.868 -0400", hash_original_method = "5D90B32B884A493C1622C9D829A83B10", hash_generated_method = "A9ACEF1EC294D60B7393749911E2426C")
    public void setCursorToStringConverter(CursorToStringConverter cursorToStringConverter) {
        mCursorToStringConverter = cursorToStringConverter;
        // ---------- Original Method ----------
        //mCursorToStringConverter = cursorToStringConverter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.868 -0400", hash_original_method = "600E1910E4ECD6C26E4D3B813A27ACFC", hash_generated_method = "109BCCA5069206159B2E7E5A73AE2F1A")
    @Override
    public CharSequence convertToString(Cursor cursor) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_248714263 = null; //Variable for return #1
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1065927185 = null; //Variable for return #2
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1232781949 = null; //Variable for return #3
        {
            varB4EAC82CA7396A68D541C85D26508E83_248714263 = mCursorToStringConverter.convertToString(cursor);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1065927185 = cursor.getString(mStringConversionColumn);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1232781949 = super.convertToString(cursor);
        addTaint(cursor.getTaint());
        CharSequence varA7E53CE21691AB073D9660D615818899_1665425216; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1665425216 = varB4EAC82CA7396A68D541C85D26508E83_248714263;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1665425216 = varB4EAC82CA7396A68D541C85D26508E83_1065927185;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1665425216 = varB4EAC82CA7396A68D541C85D26508E83_1232781949;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1665425216.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1665425216;
        // ---------- Original Method ----------
        //if (mCursorToStringConverter != null) {
            //return mCursorToStringConverter.convertToString(cursor);
        //} else if (mStringConversionColumn > -1) {
            //return cursor.getString(mStringConversionColumn);
        //}
        //return super.convertToString(cursor);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.869 -0400", hash_original_method = "FB1AB395EA625B0EC9BE174CD444F84E", hash_generated_method = "D62832C65DA92A4E26A7604426C0AD6A")
    private void findColumns(String[] from) {
        {
            int i;
            int count = from.length;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.869 -0400", hash_original_method = "4582D229162590CE1749F675A6BA90D6", hash_generated_method = "46CDC4B2DCB4BB538479973192CA6085")
    @Override
    public Cursor swapCursor(Cursor c) {
        Cursor varB4EAC82CA7396A68D541C85D26508E83_1554381073 = null; //Variable for return #1
        {
            findColumns(mOriginalFrom);
        } //End block
        Cursor res = super.swapCursor(c);
        findColumns(mOriginalFrom);
        varB4EAC82CA7396A68D541C85D26508E83_1554381073 = res;
        addTaint(c.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1554381073.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1554381073;
        // ---------- Original Method ----------
        //if (mFrom == null) {
            //findColumns(mOriginalFrom);
        //}
        //Cursor res = super.swapCursor(c);
        //findColumns(mOriginalFrom);
        //return res;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.870 -0400", hash_original_method = "6EF93FFBB8E610946B54D3F2EC498321", hash_generated_method = "57D6C8CB936FFD837A894500B9A731D4")
    public void changeCursorAndColumns(Cursor c, String[] from, int[] to) {
        mOriginalFrom = from;
        mTo = to;
        {
            findColumns(mOriginalFrom);
        } //End block
        super.changeCursor(c);
        findColumns(mOriginalFrom);
        addTaint(c.getTaint());
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

