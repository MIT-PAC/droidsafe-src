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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.292 -0400", hash_original_field = "3B4F79EB44FC121408BC3C80FFBD1BB3", hash_generated_field = "0CBC614058D2BA6AB3F2707AA19CB55C")

    protected boolean mDataValid;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.292 -0400", hash_original_field = "0D93DBF5D05325C47239982B2066443E", hash_generated_field = "CC60514C576103ECED880F96B2127BFB")

    protected boolean mAutoRequery;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.292 -0400", hash_original_field = "F54BB255BEA99BFE91A331B490610EDF", hash_generated_field = "B2F25E19BD844FCC3F1C8464C0B5BC23")

    protected Cursor mCursor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.292 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "B3359F86E29A965BC1436888E98C55A8")

    protected Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.292 -0400", hash_original_field = "BF335D1644B21D2E183AE8CEBD065849", hash_generated_field = "D171985E89089CA8F80C6B5FBFB3B7FC")

    protected int mRowIDColumn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.292 -0400", hash_original_field = "D05C668BF160CCF90E808AC728390BD6", hash_generated_field = "0B2ED6761CBC919A48EB4B9FE2D4AB13")

    protected ChangeObserver mChangeObserver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.292 -0400", hash_original_field = "1AB0B744C03B78F09E9DEC3C88684ED1", hash_generated_field = "6298A8B1998B846614DE1298AEE64EC1")

    protected DataSetObserver mDataSetObserver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.292 -0400", hash_original_field = "8FDC902C8C8CE5C4E9195BA5E99E5F2F", hash_generated_field = "877855864A02D71926B6F9A3E734D57C")

    protected CursorFilter mCursorFilter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.301 -0400", hash_original_field = "BD5F6DFBCB536410495C51FF99920D88", hash_generated_field = "D73E6E7F3D302B62FF44A580BEDA187E")

    protected FilterQueryProvider mFilterQueryProvider;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.301 -0400", hash_original_method = "8D1D2C00F3993B5859A91333170D7E0C", hash_generated_method = "48FAEFDEF8F25E73E1A1498E7B961248")
    @Deprecated
    public  CursorAdapter(Context context, Cursor c) {
        init(context, c, FLAG_AUTO_REQUERY);
        addTaint(context.getTaint());
        addTaint(c.getTaint());
        // ---------- Original Method ----------
        //init(context, c, FLAG_AUTO_REQUERY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.302 -0400", hash_original_method = "E3D9EE9ED812FDA16E5801F0DB803037", hash_generated_method = "0A7D409470DE519DBC1012F997A8EE96")
    public  CursorAdapter(Context context, Cursor c, boolean autoRequery) {
        init(context, c, autoRequery ? FLAG_AUTO_REQUERY : FLAG_REGISTER_CONTENT_OBSERVER);
        addTaint(context.getTaint());
        addTaint(c.getTaint());
        addTaint(autoRequery);
        // ---------- Original Method ----------
        //init(context, c, autoRequery ? FLAG_AUTO_REQUERY : FLAG_REGISTER_CONTENT_OBSERVER);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.302 -0400", hash_original_method = "ED5E23B4BC6F3954BD932E88BE4B619F", hash_generated_method = "7D88ABFC9E1BAF2F82B378CF7A2A48FB")
    public  CursorAdapter(Context context, Cursor c, int flags) {
        init(context, c, flags);
        addTaint(context.getTaint());
        addTaint(c.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //init(context, c, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.303 -0400", hash_original_method = "8A3F140CB585945159B363BD7170B858", hash_generated_method = "87DB3DBCAAB7E8DC93A13F703C32BA46")
    @Deprecated
    protected void init(Context context, Cursor c, boolean autoRequery) {
        init(context, c, autoRequery ? FLAG_AUTO_REQUERY : FLAG_REGISTER_CONTENT_OBSERVER);
        addTaint(context.getTaint());
        addTaint(c.getTaint());
        addTaint(autoRequery);
        // ---------- Original Method ----------
        //init(context, c, autoRequery ? FLAG_AUTO_REQUERY : FLAG_REGISTER_CONTENT_OBSERVER);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.304 -0400", hash_original_method = "E90B8606F5AC4DC9C7FA36F3DBF50072", hash_generated_method = "A39465A13C1E720F1A71852313E74362")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.315 -0400", hash_original_method = "ED4C67C6B1C11ED6A644F86CCA800916", hash_generated_method = "3B807A2C0C98C6B6759771C449277878")
    public Cursor getCursor() {
        Cursor varB4EAC82CA7396A68D541C85D26508E83_1265665963 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1265665963 = mCursor;
        varB4EAC82CA7396A68D541C85D26508E83_1265665963.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1265665963;
        // ---------- Original Method ----------
        //return mCursor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.315 -0400", hash_original_method = "F232C8AA0135C20BD5AF7ACB0020E9DD", hash_generated_method = "F7383A01454B4E8985F8A417441BF3EA")
    public int getCount() {
        {
            int varA0B4CA491E47E321D82FB34DD7E77E5A_712058237 = (mCursor.getCount());
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1393272648 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1393272648;
        // ---------- Original Method ----------
        //if (mDataValid && mCursor != null) {
            //return mCursor.getCount();
        //} else {
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.316 -0400", hash_original_method = "0491DE82927D7739F3937D1F88D16ECE", hash_generated_method = "05563D7FF041CDE275EF02557D2BE745")
    public Object getItem(int position) {
        Object varB4EAC82CA7396A68D541C85D26508E83_125587674 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_1297223933 = null; //Variable for return #2
        {
            mCursor.moveToPosition(position);
            varB4EAC82CA7396A68D541C85D26508E83_125587674 = mCursor;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1297223933 = null;
        } //End block
        addTaint(position);
        Object varA7E53CE21691AB073D9660D615818899_1897039800; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1897039800 = varB4EAC82CA7396A68D541C85D26508E83_125587674;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1897039800 = varB4EAC82CA7396A68D541C85D26508E83_1297223933;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1897039800.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1897039800;
        // ---------- Original Method ----------
        //if (mDataValid && mCursor != null) {
            //mCursor.moveToPosition(position);
            //return mCursor;
        //} else {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.320 -0400", hash_original_method = "34FC88027666F3EEA6FC8DBB36C510AF", hash_generated_method = "5BA07F42049D8E32DE14F4A5E83EF61F")
    public long getItemId(int position) {
        {
            {
                boolean var648D0BE9FA954D6C39DFA90BE3F73F88_151006015 = (mCursor.moveToPosition(position));
                {
                    long varF10BE29D713799722194E8ADDC7A0650_431538297 = (mCursor.getLong(mRowIDColumn));
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(position);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1472024974 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1472024974;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.320 -0400", hash_original_method = "047E07C1992C7400A48E08BF432AD584", hash_generated_method = "90F25A42B34A077BDB9F71A650695C68")
    @Override
    public boolean hasStableIds() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2062114284 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2062114284;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.321 -0400", hash_original_method = "04641394EE9B89BDCE0805D3C5BEBDA5", hash_generated_method = "99FCE12A3BCF04678FC72FED9ECDA507")
    public View getView(int position, View convertView, ViewGroup parent) {
        View varB4EAC82CA7396A68D541C85D26508E83_1738511942 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("this should only be called when the cursor is valid");
        } //End block
        {
            boolean var1091E50B8E5D746C74AE8CDCECCDC654_636535346 = (!mCursor.moveToPosition(position));
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
        varB4EAC82CA7396A68D541C85D26508E83_1738511942 = v;
        addTaint(position);
        addTaint(convertView.getTaint());
        addTaint(parent.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1738511942.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1738511942;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.338 -0400", hash_original_method = "8987F0888A94923BAC3C282546957FFA", hash_generated_method = "BD070A57B2E74CE11043622A4A48FA1F")
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        View varB4EAC82CA7396A68D541C85D26508E83_525672428 = null; //Variable for return #1
        View varB4EAC82CA7396A68D541C85D26508E83_480456613 = null; //Variable for return #2
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
            varB4EAC82CA7396A68D541C85D26508E83_525672428 = v;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_480456613 = null;
        } //End block
        addTaint(position);
        addTaint(convertView.getTaint());
        addTaint(parent.getTaint());
        View varA7E53CE21691AB073D9660D615818899_1443137664; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1443137664 = varB4EAC82CA7396A68D541C85D26508E83_525672428;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1443137664 = varB4EAC82CA7396A68D541C85D26508E83_480456613;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1443137664.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1443137664;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.340 -0400", hash_original_method = "4EAF37DD2AC2B68CF9F2E847E9D5C2B4", hash_generated_method = "3A6F18DC2E7D4DA5E0A80A36BAAB48FA")
    public View newDropDownView(Context context, Cursor cursor, ViewGroup parent) {
        View varB4EAC82CA7396A68D541C85D26508E83_941756482 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_941756482 = newView(context, cursor, parent);
        addTaint(context.getTaint());
        addTaint(cursor.getTaint());
        addTaint(parent.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_941756482.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_941756482;
        // ---------- Original Method ----------
        //return newView(context, cursor, parent);
    }

    
    public abstract void bindView(View view, Context context, Cursor cursor);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.351 -0400", hash_original_method = "A3DB89FF308CDDA8076F4DD4182DC99B", hash_generated_method = "4F0A27966FD8E7B748B6A41D07544B20")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.353 -0400", hash_original_method = "3AE932C7E61F472FB82D7B0D8E632CE6", hash_generated_method = "F69BDCDE2AF739A695D026C0C5232D8F")
    public Cursor swapCursor(Cursor newCursor) {
        Cursor varB4EAC82CA7396A68D541C85D26508E83_556315620 = null; //Variable for return #1
        Cursor varB4EAC82CA7396A68D541C85D26508E83_1464163990 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_556315620 = null;
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
        varB4EAC82CA7396A68D541C85D26508E83_1464163990 = oldCursor;
        Cursor varA7E53CE21691AB073D9660D615818899_1330630742; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1330630742 = varB4EAC82CA7396A68D541C85D26508E83_556315620;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1330630742 = varB4EAC82CA7396A68D541C85D26508E83_1464163990;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1330630742.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1330630742;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.354 -0400", hash_original_method = "AC3E4A96BAEBA3C91CE9B7B72B03BE17", hash_generated_method = "91F8BAB8CE74D6A23568A1F326434CDB")
    public CharSequence convertToString(Cursor cursor) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_277744709 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_277744709 = cursor == null ? "" : cursor.toString();
        addTaint(cursor.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_277744709.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_277744709;
        // ---------- Original Method ----------
        //return cursor == null ? "" : cursor.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.368 -0400", hash_original_method = "0F9BE7C57911E33C85760ED7E36C9D33", hash_generated_method = "37B3469FE82F18356ED5CAE996D2159C")
    public Cursor runQueryOnBackgroundThread(CharSequence constraint) {
        Cursor varB4EAC82CA7396A68D541C85D26508E83_259111712 = null; //Variable for return #1
        Cursor varB4EAC82CA7396A68D541C85D26508E83_512779032 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_259111712 = mFilterQueryProvider.runQuery(constraint);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_512779032 = mCursor;
        addTaint(constraint.getTaint());
        Cursor varA7E53CE21691AB073D9660D615818899_1669130626; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1669130626 = varB4EAC82CA7396A68D541C85D26508E83_259111712;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1669130626 = varB4EAC82CA7396A68D541C85D26508E83_512779032;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1669130626.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1669130626;
        // ---------- Original Method ----------
        //if (mFilterQueryProvider != null) {
            //return mFilterQueryProvider.runQuery(constraint);
        //}
        //return mCursor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.369 -0400", hash_original_method = "847708A1CBB9CABD379CEB5384747381", hash_generated_method = "8572944D904CF569F383E60D7B23293F")
    public Filter getFilter() {
        Filter varB4EAC82CA7396A68D541C85D26508E83_2071182232 = null; //Variable for return #1
        {
            mCursorFilter = new CursorFilter(this);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2071182232 = mCursorFilter;
        varB4EAC82CA7396A68D541C85D26508E83_2071182232.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2071182232;
        // ---------- Original Method ----------
        //if (mCursorFilter == null) {
            //mCursorFilter = new CursorFilter(this);
        //}
        //return mCursorFilter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.385 -0400", hash_original_method = "67EA54121BE0FFEF70F7156625E7E3CE", hash_generated_method = "8FC1374FE6227AE7E555A47C73A58138")
    public FilterQueryProvider getFilterQueryProvider() {
        FilterQueryProvider varB4EAC82CA7396A68D541C85D26508E83_701143749 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_701143749 = mFilterQueryProvider;
        varB4EAC82CA7396A68D541C85D26508E83_701143749.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_701143749;
        // ---------- Original Method ----------
        //return mFilterQueryProvider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.385 -0400", hash_original_method = "DB32599181A301EC3439063743E0023E", hash_generated_method = "3AC0EC2BF9C403B489B89218AE938BE8")
    public void setFilterQueryProvider(FilterQueryProvider filterQueryProvider) {
        mFilterQueryProvider = filterQueryProvider;
        // ---------- Original Method ----------
        //mFilterQueryProvider = filterQueryProvider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.388 -0400", hash_original_method = "A04D68B5B58FA27E71C6ECAA728402A5", hash_generated_method = "5E7030C95F9C665BFC9B1F69C548FAB3")
    protected void onContentChanged() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean varDB256AB1A28B69FFDC6BECF06252DBB3_1238896097 = (mAutoRequery && mCursor != null && !mCursor.isClosed());
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.389 -0400", hash_original_method = "E9F5B54480B866367BA64F4A5A962E11", hash_generated_method = "26A139A9C94CF802391CF18776297177")
        public  ChangeObserver() {
            super(new Handler());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.399 -0400", hash_original_method = "0AAB5F0B0973D030DF154EF2BA0EE06F", hash_generated_method = "624F205C00A74EAC9252C6591F03F8AE")
        @Override
        public boolean deliverSelfNotifications() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1134456211 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1134456211;
            // ---------- Original Method ----------
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.406 -0400", hash_original_method = "E96460F373279AF9AB8806E159ABA424", hash_generated_method = "14BD20B741BA4562A3870DA491571B1B")
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.407 -0400", hash_original_method = "B8855E81B638DE0F5C9202168EAE6D42", hash_generated_method = "B8855E81B638DE0F5C9202168EAE6D42")
        public MyDataSetObserver ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.407 -0400", hash_original_method = "06FCBC692E549C3C9873F9D5CBAEB7B0", hash_generated_method = "03FD84DC8C544DE0887FEB106D75CC8E")
        @Override
        public void onChanged() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mDataValid = true;
            notifyDataSetChanged();
            // ---------- Original Method ----------
            //mDataValid = true;
            //notifyDataSetChanged();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.408 -0400", hash_original_method = "EAE7DF88825384424351353A02D60615", hash_generated_method = "A259386E221C67E9FE12B36668278306")
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.408 -0400", hash_original_field = "2EF3F106DC7E3BA78E6E398F434B8920", hash_generated_field = "D9CAE4B2CBE505B43F3EFB7D2BDDB501")

    @Deprecated
    public static final int FLAG_AUTO_REQUERY = 0x01;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.408 -0400", hash_original_field = "BE5963518D8DE05171E5A52BE4F89E2F", hash_generated_field = "C59D2793A8DEA8140E412BF31A6EBB7E")

    public static final int FLAG_REGISTER_CONTENT_OBSERVER = 0x02;
}

