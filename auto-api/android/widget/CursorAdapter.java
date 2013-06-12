package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    @Deprecated
    public static final int FLAG_AUTO_REQUERY = 0x01;
    public static final int FLAG_REGISTER_CONTENT_OBSERVER = 0x02;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.486 -0400", hash_original_method = "8D1D2C00F3993B5859A91333170D7E0C", hash_generated_method = "4F2A01C071078168E200A801B0ED324D")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public CursorAdapter(Context context, Cursor c) {
        dsTaint.addTaint(c.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        init(context, c, FLAG_AUTO_REQUERY);
        // ---------- Original Method ----------
        //init(context, c, FLAG_AUTO_REQUERY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.486 -0400", hash_original_method = "E3D9EE9ED812FDA16E5801F0DB803037", hash_generated_method = "FB576E56C40D23A46BB92EBABD77D576")
    @DSModeled(DSC.SAFE)
    public CursorAdapter(Context context, Cursor c, boolean autoRequery) {
        dsTaint.addTaint(c.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(autoRequery);
        init(context, c, autoRequery ? FLAG_AUTO_REQUERY : FLAG_REGISTER_CONTENT_OBSERVER);
        // ---------- Original Method ----------
        //init(context, c, autoRequery ? FLAG_AUTO_REQUERY : FLAG_REGISTER_CONTENT_OBSERVER);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.486 -0400", hash_original_method = "ED5E23B4BC6F3954BD932E88BE4B619F", hash_generated_method = "268EC029ACA944AFAB3F512B4107E52C")
    @DSModeled(DSC.SAFE)
    public CursorAdapter(Context context, Cursor c, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(c.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        init(context, c, flags);
        // ---------- Original Method ----------
        //init(context, c, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.486 -0400", hash_original_method = "8A3F140CB585945159B363BD7170B858", hash_generated_method = "50CDB5ED9BF42329DC6234F35C2D1E39")
    @DSModeled(DSC.SAFE)
    @Deprecated
    protected void init(Context context, Cursor c, boolean autoRequery) {
        dsTaint.addTaint(c.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(autoRequery);
        init(context, c, autoRequery ? FLAG_AUTO_REQUERY : FLAG_REGISTER_CONTENT_OBSERVER);
        // ---------- Original Method ----------
        //init(context, c, autoRequery ? FLAG_AUTO_REQUERY : FLAG_REGISTER_CONTENT_OBSERVER);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.486 -0400", hash_original_method = "E90B8606F5AC4DC9C7FA36F3DBF50072", hash_generated_method = "7D0E6179D63A84F4595044126FA1F4B3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.487 -0400", hash_original_method = "ED4C67C6B1C11ED6A644F86CCA800916", hash_generated_method = "6AAAD0B295363A8D1B0A3A4BD004D799")
    @DSModeled(DSC.SAFE)
    public Cursor getCursor() {
        return (Cursor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mCursor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.487 -0400", hash_original_method = "F232C8AA0135C20BD5AF7ACB0020E9DD", hash_generated_method = "D87307D4F0920A9BA9DD7C4EEC5C4E86")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getCount() {
        {
            int varA0B4CA491E47E321D82FB34DD7E77E5A_152646740 = (mCursor.getCount());
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (mDataValid && mCursor != null) {
            //return mCursor.getCount();
        //} else {
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.487 -0400", hash_original_method = "0491DE82927D7739F3937D1F88D16ECE", hash_generated_method = "13D3F347BF64536B4528CE53FFA0A7E7")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.487 -0400", hash_original_method = "34FC88027666F3EEA6FC8DBB36C510AF", hash_generated_method = "15774361F3EF03ABAB97D876750F73B7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getItemId(int position) {
        dsTaint.addTaint(position);
        {
            {
                boolean var648D0BE9FA954D6C39DFA90BE3F73F88_202157951 = (mCursor.moveToPosition(position));
                {
                    long varF10BE29D713799722194E8ADDC7A0650_447519347 = (mCursor.getLong(mRowIDColumn));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.487 -0400", hash_original_method = "047E07C1992C7400A48E08BF432AD584", hash_generated_method = "DA90C3D565BEDC7BC16C2533428675F8")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean hasStableIds() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.487 -0400", hash_original_method = "04641394EE9B89BDCE0805D3C5BEBDA5", hash_generated_method = "05B66D1EE0651555592CB37A45B542AA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public View getView(int position, View convertView, ViewGroup parent) {
        dsTaint.addTaint(position);
        dsTaint.addTaint(parent.dsTaint);
        dsTaint.addTaint(convertView.dsTaint);
        {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        } //End block
        {
            boolean var1091E50B8E5D746C74AE8CDCECCDC654_1268203118 = (!mCursor.moveToPosition(position));
            {
                throw new IllegalStateException("couldn't move cursor to position " + position);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.487 -0400", hash_original_method = "8987F0888A94923BAC3C282546957FFA", hash_generated_method = "78FD19EC51F66775F3BF9A221122FB3F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.487 -0400", hash_original_method = "4EAF37DD2AC2B68CF9F2E847E9D5C2B4", hash_generated_method = "4A91F3A7856F9164D5A8D62557B1D1E6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public View newDropDownView(Context context, Cursor cursor, ViewGroup parent) {
        dsTaint.addTaint(cursor.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(parent.dsTaint);
        View varDE5BF6F3702D5D1345F5496759900472_428595807 = (newView(context, cursor, parent));
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return newView(context, cursor, parent);
    }

    
    public abstract void bindView(View view, Context context, Cursor cursor);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.487 -0400", hash_original_method = "A3DB89FF308CDDA8076F4DD4182DC99B", hash_generated_method = "ED70B831360B2CBEA03F3AAA6F231371")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.487 -0400", hash_original_method = "3AE932C7E61F472FB82D7B0D8E632CE6", hash_generated_method = "DA5983086159C10FF83118C703202D28")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.488 -0400", hash_original_method = "AC3E4A96BAEBA3C91CE9B7B72B03BE17", hash_generated_method = "A72343E8DC400CB7FD24421E0B41F7F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharSequence convertToString(Cursor cursor) {
        dsTaint.addTaint(cursor.dsTaint);
        {
            Object varB5DB0C81520616337ADDDB30ACAAE7EA_624789019 = (cursor.toString());
        } //End flattened ternary
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return cursor == null ? "" : cursor.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.488 -0400", hash_original_method = "0F9BE7C57911E33C85760ED7E36C9D33", hash_generated_method = "8E4D1F4B2C8D0CB44793737FCD7A3C14")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Cursor runQueryOnBackgroundThread(CharSequence constraint) {
        dsTaint.addTaint(constraint);
        {
            Cursor var803831B16D2557A6515F41928E23F369_346911478 = (mFilterQueryProvider.runQuery(constraint));
        } //End block
        return (Cursor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mFilterQueryProvider != null) {
            //return mFilterQueryProvider.runQuery(constraint);
        //}
        //return mCursor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.488 -0400", hash_original_method = "847708A1CBB9CABD379CEB5384747381", hash_generated_method = "642A2802D0E564F504F39C6D59B94DBD")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.488 -0400", hash_original_method = "67EA54121BE0FFEF70F7156625E7E3CE", hash_generated_method = "182459B900F165437ADCD759030BEE8C")
    @DSModeled(DSC.SAFE)
    public FilterQueryProvider getFilterQueryProvider() {
        return (FilterQueryProvider)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mFilterQueryProvider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.488 -0400", hash_original_method = "DB32599181A301EC3439063743E0023E", hash_generated_method = "DB78DF7F1DE3E9A34F128D7FA19E6914")
    @DSModeled(DSC.SAFE)
    public void setFilterQueryProvider(FilterQueryProvider filterQueryProvider) {
        dsTaint.addTaint(filterQueryProvider.dsTaint);
        // ---------- Original Method ----------
        //mFilterQueryProvider = filterQueryProvider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.488 -0400", hash_original_method = "A04D68B5B58FA27E71C6ECAA728402A5", hash_generated_method = "29EE0C3A444D6979A74F39FC7C43D5BF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void onContentChanged() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean varDB256AB1A28B69FFDC6BECF06252DBB3_1308124113 = (mAutoRequery && mCursor != null && !mCursor.isClosed());
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.488 -0400", hash_original_method = "E9F5B54480B866367BA64F4A5A962E11", hash_generated_method = "D2C33D19AFF856F92F1D5C6337C09649")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ChangeObserver() {
            super(new Handler());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.488 -0400", hash_original_method = "0AAB5F0B0973D030DF154EF2BA0EE06F", hash_generated_method = "1766BB4DDD039EEA1A219E0359C6F50E")
        @DSModeled(DSC.SAFE)
        @Override
        public boolean deliverSelfNotifications() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.488 -0400", hash_original_method = "E96460F373279AF9AB8806E159ABA424", hash_generated_method = "C2833F2718F3371819CF64834D7DB415")
        @DSModeled(DSC.SAFE)
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.488 -0400", hash_original_method = "06FCBC692E549C3C9873F9D5CBAEB7B0", hash_generated_method = "CE8DE0B562E079D73274FF9F83438AF1")
        @DSModeled(DSC.SAFE)
        @Override
        public void onChanged() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mDataValid = true;
            notifyDataSetChanged();
            // ---------- Original Method ----------
            //mDataValid = true;
            //notifyDataSetChanged();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.488 -0400", hash_original_method = "EAE7DF88825384424351353A02D60615", hash_generated_method = "6A71C12A4F78759E5E706D50DD9ECFE0")
        @DSModeled(DSC.SAFE)
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


    
}


