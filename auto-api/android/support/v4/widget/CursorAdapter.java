package android.support.v4.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;

public abstract class CursorAdapter extends BaseAdapter implements Filterable, CursorFilter.CursorFilterClient {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.808 -0400", hash_original_field = "3B4F79EB44FC121408BC3C80FFBD1BB3", hash_generated_field = "0CBC614058D2BA6AB3F2707AA19CB55C")

    protected boolean mDataValid;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.808 -0400", hash_original_field = "0D93DBF5D05325C47239982B2066443E", hash_generated_field = "CC60514C576103ECED880F96B2127BFB")

    protected boolean mAutoRequery;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.808 -0400", hash_original_field = "F54BB255BEA99BFE91A331B490610EDF", hash_generated_field = "B2F25E19BD844FCC3F1C8464C0B5BC23")

    protected Cursor mCursor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.808 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "B3359F86E29A965BC1436888E98C55A8")

    protected Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.808 -0400", hash_original_field = "BF335D1644B21D2E183AE8CEBD065849", hash_generated_field = "D171985E89089CA8F80C6B5FBFB3B7FC")

    protected int mRowIDColumn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.809 -0400", hash_original_field = "D05C668BF160CCF90E808AC728390BD6", hash_generated_field = "0B2ED6761CBC919A48EB4B9FE2D4AB13")

    protected ChangeObserver mChangeObserver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.809 -0400", hash_original_field = "1AB0B744C03B78F09E9DEC3C88684ED1", hash_generated_field = "6298A8B1998B846614DE1298AEE64EC1")

    protected DataSetObserver mDataSetObserver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.809 -0400", hash_original_field = "8FDC902C8C8CE5C4E9195BA5E99E5F2F", hash_generated_field = "877855864A02D71926B6F9A3E734D57C")

    protected CursorFilter mCursorFilter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.809 -0400", hash_original_field = "BD5F6DFBCB536410495C51FF99920D88", hash_generated_field = "D73E6E7F3D302B62FF44A580BEDA187E")

    protected FilterQueryProvider mFilterQueryProvider;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.809 -0400", hash_original_method = "8D1D2C00F3993B5859A91333170D7E0C", hash_generated_method = "48FAEFDEF8F25E73E1A1498E7B961248")
    @Deprecated
    public  CursorAdapter(Context context, Cursor c) {
        init(context, c, FLAG_AUTO_REQUERY);
        addTaint(context.getTaint());
        addTaint(c.getTaint());
        // ---------- Original Method ----------
        //init(context, c, FLAG_AUTO_REQUERY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.810 -0400", hash_original_method = "E3D9EE9ED812FDA16E5801F0DB803037", hash_generated_method = "0A7D409470DE519DBC1012F997A8EE96")
    public  CursorAdapter(Context context, Cursor c, boolean autoRequery) {
        init(context, c, autoRequery ? FLAG_AUTO_REQUERY : FLAG_REGISTER_CONTENT_OBSERVER);
        addTaint(context.getTaint());
        addTaint(c.getTaint());
        addTaint(autoRequery);
        // ---------- Original Method ----------
        //init(context, c, autoRequery ? FLAG_AUTO_REQUERY : FLAG_REGISTER_CONTENT_OBSERVER);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.811 -0400", hash_original_method = "ED5E23B4BC6F3954BD932E88BE4B619F", hash_generated_method = "7D88ABFC9E1BAF2F82B378CF7A2A48FB")
    public  CursorAdapter(Context context, Cursor c, int flags) {
        init(context, c, flags);
        addTaint(context.getTaint());
        addTaint(c.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //init(context, c, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.811 -0400", hash_original_method = "8A3F140CB585945159B363BD7170B858", hash_generated_method = "87DB3DBCAAB7E8DC93A13F703C32BA46")
    @Deprecated
    protected void init(Context context, Cursor c, boolean autoRequery) {
        init(context, c, autoRequery ? FLAG_AUTO_REQUERY : FLAG_REGISTER_CONTENT_OBSERVER);
        addTaint(context.getTaint());
        addTaint(c.getTaint());
        addTaint(autoRequery);
        // ---------- Original Method ----------
        //init(context, c, autoRequery ? FLAG_AUTO_REQUERY : FLAG_REGISTER_CONTENT_OBSERVER);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.836 -0400", hash_original_method = "E90B8606F5AC4DC9C7FA36F3DBF50072", hash_generated_method = "A39465A13C1E720F1A71852313E74362")
     void init(Context context, Cursor c, int flags) {
        {
            flags |= FLAG_REGISTER_CONTENT_OBSERVER;
            mAutoRequery = true;
        } //End block
        {
            mAutoRequery = false;
        } //End block
        boolean cursorPresent;
        cursorPresent = c != null;
        mCursor = c;
        mDataValid = cursorPresent;
        mContext = context;
        mRowIDColumn = cursorPresent ? c.getColumnIndexOrThrow("_id") : -1;
        {
            mChangeObserver = new ChangeObserver();
            mDataSetObserver = new MyDataSetObserver();
        } //End block
        {
            mChangeObserver = null;
            mDataSetObserver = null;
        } //End block
        {
            c.registerContentObserver(mChangeObserver);
            c.registerDataSetObserver(mDataSetObserver);
        } //End block
        addTaint(flags);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.838 -0400", hash_original_method = "ED4C67C6B1C11ED6A644F86CCA800916", hash_generated_method = "A559A20F971C52E0F64EEE77A22929AA")
    public Cursor getCursor() {
        Cursor varB4EAC82CA7396A68D541C85D26508E83_830055726 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_830055726 = mCursor;
        varB4EAC82CA7396A68D541C85D26508E83_830055726.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_830055726;
        // ---------- Original Method ----------
        //return mCursor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.838 -0400", hash_original_method = "F232C8AA0135C20BD5AF7ACB0020E9DD", hash_generated_method = "BC722DAA64F9F995156D66E15B42141A")
    public int getCount() {
        {
            int varA0B4CA491E47E321D82FB34DD7E77E5A_714021648 = (mCursor.getCount());
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_102853002 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_102853002;
        // ---------- Original Method ----------
        //if (mDataValid && mCursor != null) {
            //return mCursor.getCount();
        //} else {
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.839 -0400", hash_original_method = "0491DE82927D7739F3937D1F88D16ECE", hash_generated_method = "F57D3E4EE9D3A72EF3DC4173A8FD161B")
    public Object getItem(int position) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1774206452 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_2082314083 = null; //Variable for return #2
        {
            mCursor.moveToPosition(position);
            varB4EAC82CA7396A68D541C85D26508E83_1774206452 = mCursor;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_2082314083 = null;
        } //End block
        addTaint(position);
        Object varA7E53CE21691AB073D9660D615818899_204565874; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_204565874 = varB4EAC82CA7396A68D541C85D26508E83_1774206452;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_204565874 = varB4EAC82CA7396A68D541C85D26508E83_2082314083;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_204565874.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_204565874;
        // ---------- Original Method ----------
        //if (mDataValid && mCursor != null) {
            //mCursor.moveToPosition(position);
            //return mCursor;
        //} else {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.840 -0400", hash_original_method = "34FC88027666F3EEA6FC8DBB36C510AF", hash_generated_method = "F6BA75E6C01675B53B3590A566FE3059")
    public long getItemId(int position) {
        {
            {
                boolean var648D0BE9FA954D6C39DFA90BE3F73F88_1497000582 = (mCursor.moveToPosition(position));
                {
                    long varF10BE29D713799722194E8ADDC7A0650_1283186776 = (mCursor.getLong(mRowIDColumn));
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(position);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_2010740510 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_2010740510;
        // ---------- Original Method ----------
        //if (mDataValid && mCursor != null) {
            //if (mCursor.moveToPosition(position)) {
                //return mCursor.getLong(mRowIDColumn);
            //} else {
                //return 0;
            //}
        //} else {
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.840 -0400", hash_original_method = "047E07C1992C7400A48E08BF432AD584", hash_generated_method = "67C734A5939A0E5370FE263C29FBE8B0")
    @Override
    public boolean hasStableIds() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1071989109 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1071989109;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.849 -0400", hash_original_method = "04641394EE9B89BDCE0805D3C5BEBDA5", hash_generated_method = "C391CE8D48B42208536D33F94C6FF5FC")
    public View getView(int position, View convertView, ViewGroup parent) {
        View varB4EAC82CA7396A68D541C85D26508E83_2009287492 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("this should only be called when the cursor is valid");
        } //End block
        {
            boolean var1091E50B8E5D746C74AE8CDCECCDC654_1105030063 = (!mCursor.moveToPosition(position));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("couldn't move cursor to position " + position);
            } //End block
        } //End collapsed parenthetic
        View v;
        {
            v = newView(mContext, mCursor, parent);
        } //End block
        {
            v = convertView;
        } //End block
        bindView(v, mContext, mCursor);
        varB4EAC82CA7396A68D541C85D26508E83_2009287492 = v;
        addTaint(position);
        addTaint(convertView.getTaint());
        addTaint(parent.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2009287492.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2009287492;
        // ---------- Original Method ----------
        //if (!mDataValid) {
            //throw new IllegalStateException("this should only be called when the cursor is valid");
        //}
        //if (!mCursor.moveToPosition(position)) {
            //throw new IllegalStateException("couldn't move cursor to position " + position);
        //}
        //View v;
        //if (convertView == null) {
            //v = newView(mContext, mCursor, parent);
        //} else {
            //v = convertView;
        //}
        //bindView(v, mContext, mCursor);
        //return v;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.851 -0400", hash_original_method = "8987F0888A94923BAC3C282546957FFA", hash_generated_method = "8FC696B82208CB819499C41925B000CD")
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        View varB4EAC82CA7396A68D541C85D26508E83_1099653920 = null; //Variable for return #1
        View varB4EAC82CA7396A68D541C85D26508E83_443272428 = null; //Variable for return #2
        {
            mCursor.moveToPosition(position);
            View v;
            {
                v = newDropDownView(mContext, mCursor, parent);
            } //End block
            {
                v = convertView;
            } //End block
            bindView(v, mContext, mCursor);
            varB4EAC82CA7396A68D541C85D26508E83_1099653920 = v;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_443272428 = null;
        } //End block
        addTaint(position);
        addTaint(convertView.getTaint());
        addTaint(parent.getTaint());
        View varA7E53CE21691AB073D9660D615818899_1715118316; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1715118316 = varB4EAC82CA7396A68D541C85D26508E83_1099653920;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1715118316 = varB4EAC82CA7396A68D541C85D26508E83_443272428;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1715118316.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1715118316;
        // ---------- Original Method ----------
        //if (mDataValid) {
            //mCursor.moveToPosition(position);
            //View v;
            //if (convertView == null) {
                //v = newDropDownView(mContext, mCursor, parent);
            //} else {
                //v = convertView;
            //}
            //bindView(v, mContext, mCursor);
            //return v;
        //} else {
            //return null;
        //}
    }

    
    public abstract View newView(Context context, Cursor cursor, ViewGroup parent);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.859 -0400", hash_original_method = "4EAF37DD2AC2B68CF9F2E847E9D5C2B4", hash_generated_method = "78DD302E1D54726C7FC5149F2ED1C831")
    public View newDropDownView(Context context, Cursor cursor, ViewGroup parent) {
        View varB4EAC82CA7396A68D541C85D26508E83_1177723972 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1177723972 = newView(context, cursor, parent);
        addTaint(context.getTaint());
        addTaint(cursor.getTaint());
        addTaint(parent.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1177723972.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1177723972;
        // ---------- Original Method ----------
        //return newView(context, cursor, parent);
    }

    
    public abstract void bindView(View view, Context context, Cursor cursor);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.869 -0400", hash_original_method = "A3DB89FF308CDDA8076F4DD4182DC99B", hash_generated_method = "4F0A27966FD8E7B748B6A41D07544B20")
    public void changeCursor(Cursor cursor) {
        Cursor old;
        old = swapCursor(cursor);
        {
            old.close();
        } //End block
        addTaint(cursor.getTaint());
        // ---------- Original Method ----------
        //Cursor old = swapCursor(cursor);
        //if (old != null) {
            //old.close();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.871 -0400", hash_original_method = "3AE932C7E61F472FB82D7B0D8E632CE6", hash_generated_method = "ECAD76E0DF1C96089B3E7AEDE8A12FB6")
    public Cursor swapCursor(Cursor newCursor) {
        Cursor varB4EAC82CA7396A68D541C85D26508E83_1348070106 = null; //Variable for return #1
        Cursor varB4EAC82CA7396A68D541C85D26508E83_1996844378 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1348070106 = null;
        } //End block
        Cursor oldCursor;
        oldCursor = mCursor;
        {
            oldCursor.unregisterContentObserver(mChangeObserver);
            oldCursor.unregisterDataSetObserver(mDataSetObserver);
        } //End block
        mCursor = newCursor;
        {
            newCursor.registerContentObserver(mChangeObserver);
            newCursor.registerDataSetObserver(mDataSetObserver);
            mRowIDColumn = newCursor.getColumnIndexOrThrow("_id");
            mDataValid = true;
            notifyDataSetChanged();
        } //End block
        {
            mRowIDColumn = -1;
            mDataValid = false;
            notifyDataSetInvalidated();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1996844378 = oldCursor;
        Cursor varA7E53CE21691AB073D9660D615818899_992251841; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_992251841 = varB4EAC82CA7396A68D541C85D26508E83_1348070106;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_992251841 = varB4EAC82CA7396A68D541C85D26508E83_1996844378;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_992251841.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_992251841;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.885 -0400", hash_original_method = "AC3E4A96BAEBA3C91CE9B7B72B03BE17", hash_generated_method = "68EA60026A21D7E7937FB527D43876BD")
    public CharSequence convertToString(Cursor cursor) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_970244259 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_970244259 = cursor == null ? "" : cursor.toString();
        addTaint(cursor.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_970244259.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_970244259;
        // ---------- Original Method ----------
        //return cursor == null ? "" : cursor.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.886 -0400", hash_original_method = "0F9BE7C57911E33C85760ED7E36C9D33", hash_generated_method = "D3DDCA5B175861052845C9CBCC2A2D9A")
    public Cursor runQueryOnBackgroundThread(CharSequence constraint) {
        Cursor varB4EAC82CA7396A68D541C85D26508E83_503416239 = null; //Variable for return #1
        Cursor varB4EAC82CA7396A68D541C85D26508E83_196466397 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_503416239 = mFilterQueryProvider.runQuery(constraint);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_196466397 = mCursor;
        addTaint(constraint.getTaint());
        Cursor varA7E53CE21691AB073D9660D615818899_9844998; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_9844998 = varB4EAC82CA7396A68D541C85D26508E83_503416239;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_9844998 = varB4EAC82CA7396A68D541C85D26508E83_196466397;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_9844998.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_9844998;
        // ---------- Original Method ----------
        //if (mFilterQueryProvider != null) {
            //return mFilterQueryProvider.runQuery(constraint);
        //}
        //return mCursor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.900 -0400", hash_original_method = "847708A1CBB9CABD379CEB5384747381", hash_generated_method = "CDDBEBAD3F7D15FD086465D53E91FFF9")
    public Filter getFilter() {
        Filter varB4EAC82CA7396A68D541C85D26508E83_1933300241 = null; //Variable for return #1
        {
            mCursorFilter = new CursorFilter(this);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1933300241 = mCursorFilter;
        varB4EAC82CA7396A68D541C85D26508E83_1933300241.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1933300241;
        // ---------- Original Method ----------
        //if (mCursorFilter == null) {
            //mCursorFilter = new CursorFilter(this);
        //}
        //return mCursorFilter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.900 -0400", hash_original_method = "67EA54121BE0FFEF70F7156625E7E3CE", hash_generated_method = "00BB125AD53369EFA8B1FF1D11820009")
    public FilterQueryProvider getFilterQueryProvider() {
        FilterQueryProvider varB4EAC82CA7396A68D541C85D26508E83_1033560054 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1033560054 = mFilterQueryProvider;
        varB4EAC82CA7396A68D541C85D26508E83_1033560054.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1033560054;
        // ---------- Original Method ----------
        //return mFilterQueryProvider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.901 -0400", hash_original_method = "DB32599181A301EC3439063743E0023E", hash_generated_method = "3AC0EC2BF9C403B489B89218AE938BE8")
    public void setFilterQueryProvider(FilterQueryProvider filterQueryProvider) {
        mFilterQueryProvider = filterQueryProvider;
        // ---------- Original Method ----------
        //mFilterQueryProvider = filterQueryProvider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.901 -0400", hash_original_method = "A04D68B5B58FA27E71C6ECAA728402A5", hash_generated_method = "8C895FBADFB853DB6C18C6229B68FA97")
    protected void onContentChanged() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean varDB256AB1A28B69FFDC6BECF06252DBB3_799977947 = (mAutoRequery && mCursor != null && !mCursor.isClosed());
            {
                mDataValid = mCursor.requery();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (mAutoRequery && mCursor != null && !mCursor.isClosed()) {
            //if (false) Log.v("Cursor", "Auto requerying " + mCursor + " due to update");
            //mDataValid = mCursor.requery();
        //}
    }

    
    private class ChangeObserver extends ContentObserver {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.902 -0400", hash_original_method = "E9F5B54480B866367BA64F4A5A962E11", hash_generated_method = "26A139A9C94CF802391CF18776297177")
        public  ChangeObserver() {
            super(new Handler());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.902 -0400", hash_original_method = "0AAB5F0B0973D030DF154EF2BA0EE06F", hash_generated_method = "FC493EEA60A798ED85A5E4F4F7A8BBAD")
        @Override
        public boolean deliverSelfNotifications() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1046657708 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1046657708;
            // ---------- Original Method ----------
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.906 -0400", hash_original_method = "E96460F373279AF9AB8806E159ABA424", hash_generated_method = "14BD20B741BA4562A3870DA491571B1B")
        @Override
        public void onChange(boolean selfChange) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            onContentChanged();
            addTaint(selfChange);
            // ---------- Original Method ----------
            //onContentChanged();
        }

        
    }


    
    private class MyDataSetObserver extends DataSetObserver {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.906 -0400", hash_original_method = "B8855E81B638DE0F5C9202168EAE6D42", hash_generated_method = "B8855E81B638DE0F5C9202168EAE6D42")
        public MyDataSetObserver ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.923 -0400", hash_original_method = "06FCBC692E549C3C9873F9D5CBAEB7B0", hash_generated_method = "03FD84DC8C544DE0887FEB106D75CC8E")
        @Override
        public void onChanged() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mDataValid = true;
            notifyDataSetChanged();
            // ---------- Original Method ----------
            //mDataValid = true;
            //notifyDataSetChanged();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.924 -0400", hash_original_method = "EAE7DF88825384424351353A02D60615", hash_generated_method = "A259386E221C67E9FE12B36668278306")
        @Override
        public void onInvalidated() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mDataValid = false;
            notifyDataSetInvalidated();
            // ---------- Original Method ----------
            //mDataValid = false;
            //notifyDataSetInvalidated();
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.924 -0400", hash_original_field = "2EF3F106DC7E3BA78E6E398F434B8920", hash_generated_field = "D9CAE4B2CBE505B43F3EFB7D2BDDB501")

    @Deprecated
    public static final int FLAG_AUTO_REQUERY = 0x01;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.924 -0400", hash_original_field = "BE5963518D8DE05171E5A52BE4F89E2F", hash_generated_field = "C59D2793A8DEA8140E412BF31A6EBB7E")

    public static final int FLAG_REGISTER_CONTENT_OBSERVER = 0x02;
}

