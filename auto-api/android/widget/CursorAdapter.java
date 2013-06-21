package android.widget;

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

public abstract class CursorAdapter extends BaseAdapter implements Filterable, CursorFilter.CursorFilterClient {
    protected boolean mDataValid;
    protected boolean mAutoRequery;
    protected Cursor mCursor;
    protected Context mContext;
    protected int mRowIDColumn;
    protected ChangeObserver mChangeObserver;
    protected DataSetObserver mDataSetObserver;
    protected CursorFilter mCursorFilter;
    protected FilterQueryProvider mFilterQueryProvider;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.395 -0400", hash_original_method = "8D1D2C00F3993B5859A91333170D7E0C", hash_generated_method = "240E88316E97004F1EF2760239CE6F5B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public CursorAdapter(Context context, Cursor c) {
        dsTaint.addTaint(c.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        init(context, c, FLAG_AUTO_REQUERY);
        // ---------- Original Method ----------
        //init(context, c, FLAG_AUTO_REQUERY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.395 -0400", hash_original_method = "E3D9EE9ED812FDA16E5801F0DB803037", hash_generated_method = "9E05FAF22F45B0A769AE4E5916907E23")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CursorAdapter(Context context, Cursor c, boolean autoRequery) {
        dsTaint.addTaint(c.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(autoRequery);
        init(context, c, autoRequery ? FLAG_AUTO_REQUERY : FLAG_REGISTER_CONTENT_OBSERVER);
        // ---------- Original Method ----------
        //init(context, c, autoRequery ? FLAG_AUTO_REQUERY : FLAG_REGISTER_CONTENT_OBSERVER);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.395 -0400", hash_original_method = "ED5E23B4BC6F3954BD932E88BE4B619F", hash_generated_method = "983070289D36DC662B62D55802BC5AE3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CursorAdapter(Context context, Cursor c, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(c.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        init(context, c, flags);
        // ---------- Original Method ----------
        //init(context, c, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.395 -0400", hash_original_method = "8A3F140CB585945159B363BD7170B858", hash_generated_method = "8F4F35E8C262AB3DDE5EA6BBFF189670")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    protected void init(Context context, Cursor c, boolean autoRequery) {
        dsTaint.addTaint(c.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(autoRequery);
        init(context, c, autoRequery ? FLAG_AUTO_REQUERY : FLAG_REGISTER_CONTENT_OBSERVER);
        // ---------- Original Method ----------
        //init(context, c, autoRequery ? FLAG_AUTO_REQUERY : FLAG_REGISTER_CONTENT_OBSERVER);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.396 -0400", hash_original_method = "E90B8606F5AC4DC9C7FA36F3DBF50072", hash_generated_method = "405FE53C1CF8F550A0590451EFB9A17F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void init(Context context, Cursor c, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(c.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        {
            flags |= FLAG_REGISTER_CONTENT_OBSERVER;
            mAutoRequery = true;
        } //End block
        {
            mAutoRequery = false;
        } //End block
        boolean cursorPresent;
        cursorPresent = c != null;
        mDataValid = cursorPresent;
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.396 -0400", hash_original_method = "ED4C67C6B1C11ED6A644F86CCA800916", hash_generated_method = "857AB707DF9A2F684228CDCBB30082CB")
    @DSModeled(DSC.SAFE)
    public Cursor getCursor() {
        return (Cursor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mCursor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.396 -0400", hash_original_method = "F232C8AA0135C20BD5AF7ACB0020E9DD", hash_generated_method = "6099C4B6BF19647BE819BB7A6D174124")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getCount() {
        {
            int varA0B4CA491E47E321D82FB34DD7E77E5A_799608109 = (mCursor.getCount());
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (mDataValid && mCursor != null) {
            //return mCursor.getCount();
        //} else {
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.397 -0400", hash_original_method = "0491DE82927D7739F3937D1F88D16ECE", hash_generated_method = "5504C8D5BC6985F55D894EBD9AF2A538")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object getItem(int position) {
        dsTaint.addTaint(position);
        {
            mCursor.moveToPosition(position);
        } //End block
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mDataValid && mCursor != null) {
            //mCursor.moveToPosition(position);
            //return mCursor;
        //} else {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.398 -0400", hash_original_method = "34FC88027666F3EEA6FC8DBB36C510AF", hash_generated_method = "5E1EBB84233BE28E429DCDFE4F3448F0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getItemId(int position) {
        dsTaint.addTaint(position);
        {
            {
                boolean var648D0BE9FA954D6C39DFA90BE3F73F88_1949621995 = (mCursor.moveToPosition(position));
                {
                    long varF10BE29D713799722194E8ADDC7A0650_2128189900 = (mCursor.getLong(mRowIDColumn));
                } //End block
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintLong();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.398 -0400", hash_original_method = "047E07C1992C7400A48E08BF432AD584", hash_generated_method = "5B276EFEB8BB899F96DBEA3B21268F19")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean hasStableIds() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.399 -0400", hash_original_method = "04641394EE9B89BDCE0805D3C5BEBDA5", hash_generated_method = "E6ADA6DFD5AECDB09D5D2D5B4E461593")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public View getView(int position, View convertView, ViewGroup parent) {
        dsTaint.addTaint(position);
        dsTaint.addTaint(parent.dsTaint);
        dsTaint.addTaint(convertView.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("this should only be called when the cursor is valid");
        } //End block
        {
            boolean var1091E50B8E5D746C74AE8CDCECCDC654_319740814 = (!mCursor.moveToPosition(position));
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
        return (View)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.399 -0400", hash_original_method = "8987F0888A94923BAC3C282546957FFA", hash_generated_method = "245F235C4CD4893D0D05D6743F622E14")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        dsTaint.addTaint(position);
        dsTaint.addTaint(parent.dsTaint);
        dsTaint.addTaint(convertView.dsTaint);
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
        } //End block
        return (View)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.399 -0400", hash_original_method = "4EAF37DD2AC2B68CF9F2E847E9D5C2B4", hash_generated_method = "FA2F017BF33F83C2F0AE3146BAB43804")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public View newDropDownView(Context context, Cursor cursor, ViewGroup parent) {
        dsTaint.addTaint(cursor.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(parent.dsTaint);
        View varDE5BF6F3702D5D1345F5496759900472_641073145 = (newView(context, cursor, parent));
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return newView(context, cursor, parent);
    }

    
    public abstract void bindView(View view, Context context, Cursor cursor);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.400 -0400", hash_original_method = "A3DB89FF308CDDA8076F4DD4182DC99B", hash_generated_method = "BCDF159A55F2A3393C19F47BD30B6D64")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void changeCursor(Cursor cursor) {
        dsTaint.addTaint(cursor.dsTaint);
        Cursor old;
        old = swapCursor(cursor);
        {
            old.close();
        } //End block
        // ---------- Original Method ----------
        //Cursor old = swapCursor(cursor);
        //if (old != null) {
            //old.close();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.400 -0400", hash_original_method = "3AE932C7E61F472FB82D7B0D8E632CE6", hash_generated_method = "65D9DB85FED05D13A5B8F4A2C990EF36")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Cursor swapCursor(Cursor newCursor) {
        dsTaint.addTaint(newCursor.dsTaint);
        Cursor oldCursor;
        oldCursor = mCursor;
        {
            oldCursor.unregisterContentObserver(mChangeObserver);
            oldCursor.unregisterDataSetObserver(mDataSetObserver);
        } //End block
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
        return (Cursor)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.400 -0400", hash_original_method = "AC3E4A96BAEBA3C91CE9B7B72B03BE17", hash_generated_method = "EF3DC2168EBEF349E6A8FDE94A3C3B7F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharSequence convertToString(Cursor cursor) {
        dsTaint.addTaint(cursor.dsTaint);
        {
            Object varB5DB0C81520616337ADDDB30ACAAE7EA_1504407625 = (cursor.toString());
        } //End flattened ternary
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return cursor == null ? "" : cursor.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.401 -0400", hash_original_method = "0F9BE7C57911E33C85760ED7E36C9D33", hash_generated_method = "A9878360BD31523B0D31C2B61DCA7993")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Cursor runQueryOnBackgroundThread(CharSequence constraint) {
        dsTaint.addTaint(constraint);
        {
            Cursor var803831B16D2557A6515F41928E23F369_373697134 = (mFilterQueryProvider.runQuery(constraint));
        } //End block
        return (Cursor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mFilterQueryProvider != null) {
            //return mFilterQueryProvider.runQuery(constraint);
        //}
        //return mCursor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.401 -0400", hash_original_method = "847708A1CBB9CABD379CEB5384747381", hash_generated_method = "AF129AB77F377DF35D9429EA851DEA69")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Filter getFilter() {
        {
            mCursorFilter = new CursorFilter(this);
        } //End block
        return (Filter)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mCursorFilter == null) {
            //mCursorFilter = new CursorFilter(this);
        //}
        //return mCursorFilter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.401 -0400", hash_original_method = "67EA54121BE0FFEF70F7156625E7E3CE", hash_generated_method = "7739ED694B3CD18B6A1C443EB93B3CD9")
    @DSModeled(DSC.SAFE)
    public FilterQueryProvider getFilterQueryProvider() {
        return (FilterQueryProvider)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mFilterQueryProvider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.402 -0400", hash_original_method = "DB32599181A301EC3439063743E0023E", hash_generated_method = "926EE32BB496D8B7045E577EDCB29610")
    @DSModeled(DSC.SAFE)
    public void setFilterQueryProvider(FilterQueryProvider filterQueryProvider) {
        dsTaint.addTaint(filterQueryProvider.dsTaint);
        // ---------- Original Method ----------
        //mFilterQueryProvider = filterQueryProvider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.402 -0400", hash_original_method = "A04D68B5B58FA27E71C6ECAA728402A5", hash_generated_method = "095A672DD8C68B434750A14C91E8D78D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void onContentChanged() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean varDB256AB1A28B69FFDC6BECF06252DBB3_1984906068 = (mAutoRequery && mCursor != null && !mCursor.isClosed());
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.402 -0400", hash_original_method = "E9F5B54480B866367BA64F4A5A962E11", hash_generated_method = "26A139A9C94CF802391CF18776297177")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ChangeObserver() {
            super(new Handler());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.402 -0400", hash_original_method = "0AAB5F0B0973D030DF154EF2BA0EE06F", hash_generated_method = "734EC4B846BD9CD4571F46A7ABF54491")
        @DSModeled(DSC.SAFE)
        @Override
        public boolean deliverSelfNotifications() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.403 -0400", hash_original_method = "E96460F373279AF9AB8806E159ABA424", hash_generated_method = "4DBE673DE1D01CE6347E62E9EA26C6D4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void onChange(boolean selfChange) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(selfChange);
            onContentChanged();
            // ---------- Original Method ----------
            //onContentChanged();
        }

        
    }


    
    private class MyDataSetObserver extends DataSetObserver {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.403 -0400", hash_original_method = "5E2A8F377B43602FCFED378011E19650", hash_generated_method = "5E2A8F377B43602FCFED378011E19650")
                public MyDataSetObserver ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.403 -0400", hash_original_method = "06FCBC692E549C3C9873F9D5CBAEB7B0", hash_generated_method = "03FD84DC8C544DE0887FEB106D75CC8E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void onChanged() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mDataValid = true;
            notifyDataSetChanged();
            // ---------- Original Method ----------
            //mDataValid = true;
            //notifyDataSetChanged();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.403 -0400", hash_original_method = "EAE7DF88825384424351353A02D60615", hash_generated_method = "A259386E221C67E9FE12B36668278306")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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


    
    @Deprecated public static final int FLAG_AUTO_REQUERY = 0x01;
    public static final int FLAG_REGISTER_CONTENT_OBSERVER = 0x02;
}

