package android.widget;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.287 -0400", hash_original_field = "3B4F79EB44FC121408BC3C80FFBD1BB3", hash_generated_field = "0CBC614058D2BA6AB3F2707AA19CB55C")

    protected boolean mDataValid;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.287 -0400", hash_original_field = "0D93DBF5D05325C47239982B2066443E", hash_generated_field = "CC60514C576103ECED880F96B2127BFB")

    protected boolean mAutoRequery;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.287 -0400", hash_original_field = "F54BB255BEA99BFE91A331B490610EDF", hash_generated_field = "B2F25E19BD844FCC3F1C8464C0B5BC23")

    protected Cursor mCursor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.287 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "B3359F86E29A965BC1436888E98C55A8")

    protected Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.287 -0400", hash_original_field = "BF335D1644B21D2E183AE8CEBD065849", hash_generated_field = "D171985E89089CA8F80C6B5FBFB3B7FC")

    protected int mRowIDColumn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.287 -0400", hash_original_field = "D05C668BF160CCF90E808AC728390BD6", hash_generated_field = "0B2ED6761CBC919A48EB4B9FE2D4AB13")

    protected ChangeObserver mChangeObserver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.287 -0400", hash_original_field = "1AB0B744C03B78F09E9DEC3C88684ED1", hash_generated_field = "6298A8B1998B846614DE1298AEE64EC1")

    protected DataSetObserver mDataSetObserver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.287 -0400", hash_original_field = "8FDC902C8C8CE5C4E9195BA5E99E5F2F", hash_generated_field = "877855864A02D71926B6F9A3E734D57C")

    protected CursorFilter mCursorFilter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.287 -0400", hash_original_field = "BD5F6DFBCB536410495C51FF99920D88", hash_generated_field = "D73E6E7F3D302B62FF44A580BEDA187E")

    protected FilterQueryProvider mFilterQueryProvider;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.288 -0400", hash_original_method = "8D1D2C00F3993B5859A91333170D7E0C", hash_generated_method = "48FAEFDEF8F25E73E1A1498E7B961248")
    @Deprecated
    public  CursorAdapter(Context context, Cursor c) {
        init(context, c, FLAG_AUTO_REQUERY);
        addTaint(context.getTaint());
        addTaint(c.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.288 -0400", hash_original_method = "E3D9EE9ED812FDA16E5801F0DB803037", hash_generated_method = "0A7D409470DE519DBC1012F997A8EE96")
    public  CursorAdapter(Context context, Cursor c, boolean autoRequery) {
        init(context, c, autoRequery ? FLAG_AUTO_REQUERY : FLAG_REGISTER_CONTENT_OBSERVER);
        addTaint(context.getTaint());
        addTaint(c.getTaint());
        addTaint(autoRequery);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.288 -0400", hash_original_method = "ED5E23B4BC6F3954BD932E88BE4B619F", hash_generated_method = "7D88ABFC9E1BAF2F82B378CF7A2A48FB")
    public  CursorAdapter(Context context, Cursor c, int flags) {
        init(context, c, flags);
        addTaint(context.getTaint());
        addTaint(c.getTaint());
        addTaint(flags);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.289 -0400", hash_original_method = "8A3F140CB585945159B363BD7170B858", hash_generated_method = "87DB3DBCAAB7E8DC93A13F703C32BA46")
    @Deprecated
    protected void init(Context context, Cursor c, boolean autoRequery) {
        init(context, c, autoRequery ? FLAG_AUTO_REQUERY : FLAG_REGISTER_CONTENT_OBSERVER);
        addTaint(context.getTaint());
        addTaint(c.getTaint());
        addTaint(autoRequery);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.289 -0400", hash_original_method = "E90B8606F5AC4DC9C7FA36F3DBF50072", hash_generated_method = "E6FF9828C9566A80DA623EEA39BD6CE0")
     void init(Context context, Cursor c, int flags) {
        {
            flags |= FLAG_REGISTER_CONTENT_OBSERVER;
            mAutoRequery = true;
        } 
        {
            mAutoRequery = false;
        } 
        boolean cursorPresent = c != null;
        mCursor = c;
        mDataValid = cursorPresent;
        mContext = context;
        mRowIDColumn = cursorPresent ? c.getColumnIndexOrThrow("_id") : -1;
        {
            mChangeObserver = new ChangeObserver();
            mDataSetObserver = new MyDataSetObserver();
        } 
        {
            mChangeObserver = null;
            mDataSetObserver = null;
        } 
        {
            c.registerContentObserver(mChangeObserver);
            c.registerDataSetObserver(mDataSetObserver);
        } 
        addTaint(flags);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.290 -0400", hash_original_method = "ED4C67C6B1C11ED6A644F86CCA800916", hash_generated_method = "98B7BE06BFFD69F2E1A82E9375A2D482")
    public Cursor getCursor() {
        Cursor varB4EAC82CA7396A68D541C85D26508E83_2017963006 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2017963006 = mCursor;
        varB4EAC82CA7396A68D541C85D26508E83_2017963006.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2017963006;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.291 -0400", hash_original_method = "F232C8AA0135C20BD5AF7ACB0020E9DD", hash_generated_method = "101933E1F300EF76C8D71DAA7B395088")
    public int getCount() {
        {
            int varA0B4CA491E47E321D82FB34DD7E77E5A_1061213309 = (mCursor.getCount());
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1626056273 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1626056273;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.292 -0400", hash_original_method = "0491DE82927D7739F3937D1F88D16ECE", hash_generated_method = "82BECB3E3EDE0E18EC6B342C3D6F1FA8")
    public Object getItem(int position) {
        Object varB4EAC82CA7396A68D541C85D26508E83_902122280 = null; 
        Object varB4EAC82CA7396A68D541C85D26508E83_1565292422 = null; 
        {
            mCursor.moveToPosition(position);
            varB4EAC82CA7396A68D541C85D26508E83_902122280 = mCursor;
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1565292422 = null;
        } 
        addTaint(position);
        Object varA7E53CE21691AB073D9660D615818899_676276194; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_676276194 = varB4EAC82CA7396A68D541C85D26508E83_902122280;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_676276194 = varB4EAC82CA7396A68D541C85D26508E83_1565292422;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_676276194.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_676276194;
        
        
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.293 -0400", hash_original_method = "34FC88027666F3EEA6FC8DBB36C510AF", hash_generated_method = "D3597F39CBD21357D3759ACF8F035558")
    public long getItemId(int position) {
        {
            {
                boolean var648D0BE9FA954D6C39DFA90BE3F73F88_2063189261 = (mCursor.moveToPosition(position));
                {
                    long varF10BE29D713799722194E8ADDC7A0650_1785645347 = (mCursor.getLong(mRowIDColumn));
                } 
            } 
        } 
        addTaint(position);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_465152904 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_465152904;
        
        
            
                
            
                
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.293 -0400", hash_original_method = "047E07C1992C7400A48E08BF432AD584", hash_generated_method = "F883B157A223BA564EF6BE8BEA7DD93A")
    @Override
    public boolean hasStableIds() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_731919041 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_731919041;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.294 -0400", hash_original_method = "04641394EE9B89BDCE0805D3C5BEBDA5", hash_generated_method = "EB8986F61B75B9D69B882BA3674185D8")
    public View getView(int position, View convertView, ViewGroup parent) {
        View varB4EAC82CA7396A68D541C85D26508E83_63252617 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("this should only be called when the cursor is valid");
        } 
        {
            boolean var1091E50B8E5D746C74AE8CDCECCDC654_14911568 = (!mCursor.moveToPosition(position));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("couldn't move cursor to position " + position);
            } 
        } 
        View v;
        {
            v = newView(mContext, mCursor, parent);
        } 
        {
            v = convertView;
        } 
        bindView(v, mContext, mCursor);
        varB4EAC82CA7396A68D541C85D26508E83_63252617 = v;
        addTaint(position);
        addTaint(convertView.getTaint());
        addTaint(parent.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_63252617.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_63252617;
        
        
            
        
        
            
        
        
        
            
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.295 -0400", hash_original_method = "8987F0888A94923BAC3C282546957FFA", hash_generated_method = "1A9CCE07D5837548085610C6480B07C0")
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        View varB4EAC82CA7396A68D541C85D26508E83_1810017791 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_599916293 = null; 
        {
            mCursor.moveToPosition(position);
            View v;
            {
                v = newDropDownView(mContext, mCursor, parent);
            } 
            {
                v = convertView;
            } 
            bindView(v, mContext, mCursor);
            varB4EAC82CA7396A68D541C85D26508E83_1810017791 = v;
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_599916293 = null;
        } 
        addTaint(position);
        addTaint(convertView.getTaint());
        addTaint(parent.getTaint());
        View varA7E53CE21691AB073D9660D615818899_1107033543; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1107033543 = varB4EAC82CA7396A68D541C85D26508E83_1810017791;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1107033543 = varB4EAC82CA7396A68D541C85D26508E83_599916293;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1107033543.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1107033543;
        
        
            
            
            
                
            
                
            
            
            
        
            
        
    }

    
    public abstract View newView(Context context, Cursor cursor, ViewGroup parent);

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.296 -0400", hash_original_method = "4EAF37DD2AC2B68CF9F2E847E9D5C2B4", hash_generated_method = "7F598A8C598C36F1D75A554A7967E39E")
    public View newDropDownView(Context context, Cursor cursor, ViewGroup parent) {
        View varB4EAC82CA7396A68D541C85D26508E83_918651490 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_918651490 = newView(context, cursor, parent);
        addTaint(context.getTaint());
        addTaint(cursor.getTaint());
        addTaint(parent.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_918651490.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_918651490;
        
        
    }

    
    public abstract void bindView(View view, Context context, Cursor cursor);

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.296 -0400", hash_original_method = "A3DB89FF308CDDA8076F4DD4182DC99B", hash_generated_method = "582922BF06D3B728CCDFA9514919B96D")
    public void changeCursor(Cursor cursor) {
        Cursor old = swapCursor(cursor);
        {
            old.close();
        } 
        addTaint(cursor.getTaint());
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.297 -0400", hash_original_method = "3AE932C7E61F472FB82D7B0D8E632CE6", hash_generated_method = "21F02BA5BAF9E8D5E9FC017C1CCA05D9")
    public Cursor swapCursor(Cursor newCursor) {
        Cursor varB4EAC82CA7396A68D541C85D26508E83_2024105820 = null; 
        Cursor varB4EAC82CA7396A68D541C85D26508E83_2010016241 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_2024105820 = null;
        } 
        Cursor oldCursor = mCursor;
        {
            oldCursor.unregisterContentObserver(mChangeObserver);
            oldCursor.unregisterDataSetObserver(mDataSetObserver);
        } 
        mCursor = newCursor;
        {
            newCursor.registerContentObserver(mChangeObserver);
            newCursor.registerDataSetObserver(mDataSetObserver);
            mRowIDColumn = newCursor.getColumnIndexOrThrow("_id");
            mDataValid = true;
            notifyDataSetChanged();
        } 
        {
            mRowIDColumn = -1;
            mDataValid = false;
            notifyDataSetInvalidated();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_2010016241 = oldCursor;
        Cursor varA7E53CE21691AB073D9660D615818899_1330318122; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1330318122 = varB4EAC82CA7396A68D541C85D26508E83_2024105820;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1330318122 = varB4EAC82CA7396A68D541C85D26508E83_2010016241;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1330318122.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1330318122;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.298 -0400", hash_original_method = "AC3E4A96BAEBA3C91CE9B7B72B03BE17", hash_generated_method = "376F4A212B0C8B3B0CB613796357BF14")
    public CharSequence convertToString(Cursor cursor) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1211504541 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1211504541 = cursor == null ? "" : cursor.toString();
        addTaint(cursor.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1211504541.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1211504541;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.298 -0400", hash_original_method = "0F9BE7C57911E33C85760ED7E36C9D33", hash_generated_method = "4B0EC8D15B3BB85328A4EFAAB9D3222D")
    public Cursor runQueryOnBackgroundThread(CharSequence constraint) {
        Cursor varB4EAC82CA7396A68D541C85D26508E83_1852928708 = null; 
        Cursor varB4EAC82CA7396A68D541C85D26508E83_827570343 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1852928708 = mFilterQueryProvider.runQuery(constraint);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_827570343 = mCursor;
        addTaint(constraint.getTaint());
        Cursor varA7E53CE21691AB073D9660D615818899_407082396; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_407082396 = varB4EAC82CA7396A68D541C85D26508E83_1852928708;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_407082396 = varB4EAC82CA7396A68D541C85D26508E83_827570343;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_407082396.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_407082396;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.299 -0400", hash_original_method = "847708A1CBB9CABD379CEB5384747381", hash_generated_method = "0EDB0E552B4E4D2F07D40E87784AB92D")
    public Filter getFilter() {
        Filter varB4EAC82CA7396A68D541C85D26508E83_1070498063 = null; 
        {
            mCursorFilter = new CursorFilter(this);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1070498063 = mCursorFilter;
        varB4EAC82CA7396A68D541C85D26508E83_1070498063.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1070498063;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.299 -0400", hash_original_method = "67EA54121BE0FFEF70F7156625E7E3CE", hash_generated_method = "DF7782DAE4F81AE7122C8CEE8903BD8E")
    public FilterQueryProvider getFilterQueryProvider() {
        FilterQueryProvider varB4EAC82CA7396A68D541C85D26508E83_1557451250 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1557451250 = mFilterQueryProvider;
        varB4EAC82CA7396A68D541C85D26508E83_1557451250.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1557451250;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.299 -0400", hash_original_method = "DB32599181A301EC3439063743E0023E", hash_generated_method = "3AC0EC2BF9C403B489B89218AE938BE8")
    public void setFilterQueryProvider(FilterQueryProvider filterQueryProvider) {
        mFilterQueryProvider = filterQueryProvider;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.300 -0400", hash_original_method = "A04D68B5B58FA27E71C6ECAA728402A5", hash_generated_method = "04C7D75FBD2D388FC19B216D6AA86778")
    protected void onContentChanged() {
        
        {
            boolean varDB256AB1A28B69FFDC6BECF06252DBB3_1282738310 = (mAutoRequery && mCursor != null && !mCursor.isClosed());
            {
                mDataValid = mCursor.requery();
            } 
        } 
        
        
            
            
        
    }

    
    private class ChangeObserver extends ContentObserver {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.300 -0400", hash_original_method = "E9F5B54480B866367BA64F4A5A962E11", hash_generated_method = "26A139A9C94CF802391CF18776297177")
        public  ChangeObserver() {
            super(new Handler());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.301 -0400", hash_original_method = "0AAB5F0B0973D030DF154EF2BA0EE06F", hash_generated_method = "0CA9F0828C0D6C04703103DD9ED732B1")
        @Override
        public boolean deliverSelfNotifications() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_137290832 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_137290832;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.301 -0400", hash_original_method = "E96460F373279AF9AB8806E159ABA424", hash_generated_method = "14BD20B741BA4562A3870DA491571B1B")
        @Override
        public void onChange(boolean selfChange) {
            
            onContentChanged();
            addTaint(selfChange);
            
            
        }

        
    }


    
    private class MyDataSetObserver extends DataSetObserver {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.301 -0400", hash_original_method = "B8855E81B638DE0F5C9202168EAE6D42", hash_generated_method = "B8855E81B638DE0F5C9202168EAE6D42")
        public MyDataSetObserver ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.302 -0400", hash_original_method = "06FCBC692E549C3C9873F9D5CBAEB7B0", hash_generated_method = "03FD84DC8C544DE0887FEB106D75CC8E")
        @Override
        public void onChanged() {
            
            mDataValid = true;
            notifyDataSetChanged();
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.303 -0400", hash_original_method = "EAE7DF88825384424351353A02D60615", hash_generated_method = "A259386E221C67E9FE12B36668278306")
        @Override
        public void onInvalidated() {
            
            mDataValid = false;
            notifyDataSetInvalidated();
            
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.303 -0400", hash_original_field = "2EF3F106DC7E3BA78E6E398F434B8920", hash_generated_field = "D9CAE4B2CBE505B43F3EFB7D2BDDB501")

    @Deprecated
    public static final int FLAG_AUTO_REQUERY = 0x01;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.303 -0400", hash_original_field = "BE5963518D8DE05171E5A52BE4F89E2F", hash_generated_field = "C59D2793A8DEA8140E412BF31A6EBB7E")

    public static final int FLAG_REGISTER_CONTENT_OBSERVER = 0x02;
}

