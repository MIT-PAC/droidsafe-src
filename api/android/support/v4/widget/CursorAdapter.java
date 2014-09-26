package android.support.v4.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;

public abstract class CursorAdapter extends BaseAdapter implements Filterable, CursorFilter.CursorFilterClient {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:26.177 -0500", hash_original_field = "EA16372B4C1173D920973EDB21B112D9", hash_generated_field = "D9CAE4B2CBE505B43F3EFB7D2BDDB501")

    @Deprecated
    public static final int FLAG_AUTO_REQUERY = 0x01;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:26.180 -0500", hash_original_field = "7835C7E601DD9901BDB0140A5CD3FD69", hash_generated_field = "C59D2793A8DEA8140E412BF31A6EBB7E")

    public static final int FLAG_REGISTER_CONTENT_OBSERVER = 0x02;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:26.154 -0500", hash_original_field = "B1D41B144FE2C3B3FB30350D877CFB27", hash_generated_field = "0CBC614058D2BA6AB3F2707AA19CB55C")

    protected boolean mDataValid;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:26.156 -0500", hash_original_field = "19F1F658626457CA1C4F5410DB58539E", hash_generated_field = "CC60514C576103ECED880F96B2127BFB")

    protected boolean mAutoRequery;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:26.159 -0500", hash_original_field = "4A85E902ED72E65A9AF8F6ED265E4F89", hash_generated_field = "B2F25E19BD844FCC3F1C8464C0B5BC23")

    protected Cursor mCursor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:26.161 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "B3359F86E29A965BC1436888E98C55A8")

    protected Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:26.163 -0500", hash_original_field = "89BD3C46261F31D492DE087CA452C3A8", hash_generated_field = "D171985E89089CA8F80C6B5FBFB3B7FC")

    protected int mRowIDColumn;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:26.166 -0500", hash_original_field = "D758510466FA79764489FEAEF75D1CBF", hash_generated_field = "0B2ED6761CBC919A48EB4B9FE2D4AB13")

    protected ChangeObserver mChangeObserver;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:26.169 -0500", hash_original_field = "CA23E511E6F9771CC47A35D664CF38CE", hash_generated_field = "6298A8B1998B846614DE1298AEE64EC1")

    protected DataSetObserver mDataSetObserver;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:26.172 -0500", hash_original_field = "D8ABE48EC8BFB2495B7981C7614D0425", hash_generated_field = "877855864A02D71926B6F9A3E734D57C")

    protected CursorFilter mCursorFilter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:26.174 -0500", hash_original_field = "1ED12A81CCABC2DD00A04189F4483A39", hash_generated_field = "D73E6E7F3D302B62FF44A580BEDA187E")

    protected FilterQueryProvider mFilterQueryProvider;

    /**
     * Constructor that always enables auto-requery.
     *
     * @deprecated This option is discouraged, as it results in Cursor queries
     * being performed on the application's UI thread and thus can cause poor
     * responsiveness or even Application Not Responding errors.  As an alternative,
     * use {@link android.app.LoaderManager} with a {@link android.content.CursorLoader}.
     *
     * @param c The cursor from which to get the data.
     * @param context The context
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:26.194 -0500", hash_original_method = "8D1D2C00F3993B5859A91333170D7E0C", hash_generated_method = "4C377DA66825F64CF4C1260A56CCE8C3")
    
@Deprecated
    public CursorAdapter(Context context, Cursor c) {
        init(context, c, FLAG_AUTO_REQUERY);
    }

    /**
     * Constructor that allows control over auto-requery.  It is recommended
     * you not use this, but instead {@link #CursorAdapter(Context, Cursor, int)}.
     * When using this constructor, {@link #FLAG_REGISTER_CONTENT_OBSERVER}
     * will always be set.
     *
     * @param c The cursor from which to get the data.
     * @param context The context
     * @param autoRequery If true the adapter will call requery() on the
     *                    cursor whenever it changes so the most recent
     *                    data is always displayed.  Using true here is discouraged.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:26.197 -0500", hash_original_method = "E3D9EE9ED812FDA16E5801F0DB803037", hash_generated_method = "9177FA971129F5CD41797232E6A18730")
    
public CursorAdapter(Context context, Cursor c, boolean autoRequery) {
        init(context, c, autoRequery ? FLAG_AUTO_REQUERY : FLAG_REGISTER_CONTENT_OBSERVER);
    }

    /**
     * Recommended constructor.
     *
     * @param c The cursor from which to get the data.
     * @param context The context
     * @param flags Flags used to determine the behavior of the adapter; may
     * be any combination of {@link #FLAG_AUTO_REQUERY} and
     * {@link #FLAG_REGISTER_CONTENT_OBSERVER}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:26.199 -0500", hash_original_method = "ED5E23B4BC6F3954BD932E88BE4B619F", hash_generated_method = "56CE5F5ADD8AF24CC6D468307BCB3C3E")
    
public CursorAdapter(Context context, Cursor c, int flags) {
        init(context, c, flags);
    }

    /**
     * @deprecated Don't use this, use the normal constructor.  This will
     * be removed in the future.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:26.202 -0500", hash_original_method = "8A3F140CB585945159B363BD7170B858", hash_generated_method = "94F4075EB549C26DF4BA3A48DD40B5B4")
    
@Deprecated
    protected void init(Context context, Cursor c, boolean autoRequery) {
        init(context, c, autoRequery ? FLAG_AUTO_REQUERY : FLAG_REGISTER_CONTENT_OBSERVER);
    }

    @DSComment("Package priviledge")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:26.204 -0500", hash_original_method = "E90B8606F5AC4DC9C7FA36F3DBF50072", hash_generated_method = "E90B8606F5AC4DC9C7FA36F3DBF50072")
    
void init(Context context, Cursor c, int flags) {
        if ((flags & FLAG_AUTO_REQUERY) == FLAG_AUTO_REQUERY) {
            flags |= FLAG_REGISTER_CONTENT_OBSERVER;
            mAutoRequery = true;
        } else {
            mAutoRequery = false;
        }
        boolean cursorPresent = c != null;
        mCursor = c;
        mDataValid = cursorPresent;
        mContext = context;
        mRowIDColumn = cursorPresent ? c.getColumnIndexOrThrow("_id") : -1;
        if ((flags & FLAG_REGISTER_CONTENT_OBSERVER) == FLAG_REGISTER_CONTENT_OBSERVER) {
            mChangeObserver = new ChangeObserver();
            mDataSetObserver = new MyDataSetObserver();
        } else {
            mChangeObserver = null;
            mDataSetObserver = null;
        }

        if (cursorPresent) {
            if (mChangeObserver != null) c.registerContentObserver(mChangeObserver);
            if (mDataSetObserver != null) c.registerDataSetObserver(mDataSetObserver);
        }
    }

    /**
     * Returns the cursor.
     * @return the cursor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:26.206 -0500", hash_original_method = "ED4C67C6B1C11ED6A644F86CCA800916", hash_generated_method = "C2683DC62F0FF2A1098E741198B98052")
    
public Cursor getCursor() {
        return mCursor;
    }

    /**
     * @see android.widget.ListAdapter#getCount()
     */
    @DSSource({DSSourceKind.DATABASE})
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:26.208 -0500", hash_original_method = "F232C8AA0135C20BD5AF7ACB0020E9DD", hash_generated_method = "C69E75834B9D32F830A7C80BCB4D4998")
    
public int getCount() {
        if (mDataValid && mCursor != null) {
            return mCursor.getCount();
        } else {
            return 0;
        }
    }
    
    /**
     * @see android.widget.ListAdapter#getItem(int)
     */
    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:26.211 -0500", hash_original_method = "0491DE82927D7739F3937D1F88D16ECE", hash_generated_method = "2B83690C2B24F7C2A5847C0FD57AC51D")
    
public Object getItem(int position) {
        if (mDataValid && mCursor != null) {
            mCursor.moveToPosition(position);
            return mCursor;
        } else {
            return null;
        }
    }

    /**
     * @see android.widget.ListAdapter#getItemId(int)
     */
    @DSSource({DSSourceKind.DATABASE})
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:26.213 -0500", hash_original_method = "34FC88027666F3EEA6FC8DBB36C510AF", hash_generated_method = "D7B5335648F010B9AF2FEB739B203066")
    
public long getItemId(int position) {
        if (mDataValid && mCursor != null) {
            if (mCursor.moveToPosition(position)) {
                return mCursor.getLong(mRowIDColumn);
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }
    
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:26.215 -0500", hash_original_method = "047E07C1992C7400A48E08BF432AD584", hash_generated_method = "393A59784E726D5BE49F0B29F763EDD7")
    
@Override
    public boolean hasStableIds() {
        return true;
    }

    /**
     * @see android.widget.ListAdapter#getView(int, View, ViewGroup)
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:26.219 -0500", hash_original_method = "04641394EE9B89BDCE0805D3C5BEBDA5", hash_generated_method = "DE47E3A9E8938A879091E0DCD9DCBB47")
    
public View getView(int position, View convertView, ViewGroup parent) {
        if (!mDataValid) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
        if (!mCursor.moveToPosition(position)) {
            throw new IllegalStateException("couldn't move cursor to position " + position);
        }
        View v;
        if (convertView == null) {
            v = newView(mContext, mCursor, parent);
        } else {
            v = convertView;
        }
        bindView(v, mContext, mCursor);
        return v;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:26.221 -0500", hash_original_method = "8987F0888A94923BAC3C282546957FFA", hash_generated_method = "AA71827E42827321A45A0050ADDEB24F")
    
@Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        if (mDataValid) {
            mCursor.moveToPosition(position);
            View v;
            if (convertView == null) {
                v = newDropDownView(mContext, mCursor, parent);
            } else {
                v = convertView;
            }
            bindView(v, mContext, mCursor);
            return v;
        } else {
            return null;
        }
    }
    
    /**
     * Makes a new view to hold the data pointed to by cursor.
     * @param context Interface to application's global information
     * @param cursor The cursor from which to get the data. The cursor is already
     * moved to the correct position.
     * @param parent The parent to which the new view is attached to
     * @return the newly created view.
     */
    @DSComment("Abstract Method")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:26.223 -0500", hash_original_method = "EE6A21FD9B62596982E99001153626A6", hash_generated_method = "CF45D1D614F206164A24A59CD2225216")
    
public abstract View newView(Context context, Cursor cursor, ViewGroup parent);

    /**
     * Makes a new drop down view to hold the data pointed to by cursor.
     * @param context Interface to application's global information
     * @param cursor The cursor from which to get the data. The cursor is already
     * moved to the correct position.
     * @param parent The parent to which the new view is attached to
     * @return the newly created view.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:26.226 -0500", hash_original_method = "4EAF37DD2AC2B68CF9F2E847E9D5C2B4", hash_generated_method = "5AE8A92A3E307F742AA8A763AF9271C1")
    
public View newDropDownView(Context context, Cursor cursor, ViewGroup parent) {
        return newView(context, cursor, parent);
    }

    /**
     * Bind an existing view to the data pointed to by cursor
     * @param view Existing view, returned earlier by newView
     * @param context Interface to application's global information
     * @param cursor The cursor from which to get the data. The cursor is already
     * moved to the correct position.
     */
    @DSComment("Abstract Method")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:26.228 -0500", hash_original_method = "862EB494F53DC650925859B90E73BA8D", hash_generated_method = "B890DE80D4A3B58521CB62A64CF3811E")
    
public abstract void bindView(View view, Context context, Cursor cursor);
    
    /**
     * Change the underlying cursor to a new cursor. If there is an existing cursor it will be
     * closed.
     * 
     * @param cursor The new cursor to be used
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:26.230 -0500", hash_original_method = "A3DB89FF308CDDA8076F4DD4182DC99B", hash_generated_method = "D6E23DB93BD6815A1322DD8DDE2D2D57")
    
public void changeCursor(Cursor cursor) {
        Cursor old = swapCursor(cursor);
        if (old != null) {
            old.close();
        }
    }

    /**
     * Swap in a new Cursor, returning the old Cursor.  Unlike
     * {@link #changeCursor(Cursor)}, the returned old Cursor is <em>not</em>
     * closed.
     *
     * @param newCursor The new cursor to be used.
     * @return Returns the previously set Cursor, or null if there wasa not one.
     * If the given new Cursor is the same instance is the previously set
     * Cursor, null is also returned.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:26.233 -0500", hash_original_method = "3AE932C7E61F472FB82D7B0D8E632CE6", hash_generated_method = "CE2E8D958EB4A03214BB0FCF770CFC17")
    
public Cursor swapCursor(Cursor newCursor) {
        if (newCursor == mCursor) {
            return null;
        }
        Cursor oldCursor = mCursor;
        if (oldCursor != null) {
            if (mChangeObserver != null) oldCursor.unregisterContentObserver(mChangeObserver);
            if (mDataSetObserver != null) oldCursor.unregisterDataSetObserver(mDataSetObserver);
        }
        mCursor = newCursor;
        if (newCursor != null) {
            if (mChangeObserver != null) newCursor.registerContentObserver(mChangeObserver);
            if (mDataSetObserver != null) newCursor.registerDataSetObserver(mDataSetObserver);
            mRowIDColumn = newCursor.getColumnIndexOrThrow("_id");
            mDataValid = true;
            // notify the observers about the new cursor
            notifyDataSetChanged();
        } else {
            mRowIDColumn = -1;
            mDataValid = false;
            // notify the observers about the lack of a data set
            notifyDataSetInvalidated();
        }
        return oldCursor;
    }

    /**
     * <p>Converts the cursor into a CharSequence. Subclasses should override this
     * method to convert their results. The default implementation returns an
     * empty String for null values or the default String representation of
     * the value.</p>
     *
     * @param cursor the cursor to convert to a CharSequence
     * @return a CharSequence representing the value
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:26.235 -0500", hash_original_method = "AC3E4A96BAEBA3C91CE9B7B72B03BE17", hash_generated_method = "6B89865200507DE42E51170FD21FEDC5")
    
public CharSequence convertToString(Cursor cursor) {
        return cursor == null ? "" : cursor.toString();
    }

    /**
     * Runs a query with the specified constraint. This query is requested
     * by the filter attached to this adapter.
     *
     * The query is provided by a
     * {@link android.widget.FilterQueryProvider}.
     * If no provider is specified, the current cursor is not filtered and returned.
     *
     * After this method returns the resulting cursor is passed to {@link #changeCursor(Cursor)}
     * and the previous cursor is closed.
     *
     * This method is always executed on a background thread, not on the
     * application's main thread (or UI thread.)
     * 
     * Contract: when constraint is null or empty, the original results,
     * prior to any filtering, must be returned.
     *
     * @param constraint the constraint with which the query must be filtered
     *
     * @return a Cursor representing the results of the new query
     *
     * @see #getFilter()
     * @see #getFilterQueryProvider()
     * @see #setFilterQueryProvider(android.widget.FilterQueryProvider)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:26.237 -0500", hash_original_method = "0F9BE7C57911E33C85760ED7E36C9D33", hash_generated_method = "5F7BE9B3FD55D8757F5D41047CD6CB7C")
    @DSVerified
    @DSSpec(DSCat.DATABASE) 
public Cursor runQueryOnBackgroundThread(CharSequence constraint) {
        if (mFilterQueryProvider != null) {
            return mFilterQueryProvider.runQuery(constraint);
        }

        return mCursor;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:26.240 -0500", hash_original_method = "847708A1CBB9CABD379CEB5384747381", hash_generated_method = "0192CB7998F4F8D0B8576F5328585468")
    
public Filter getFilter() {
        if (mCursorFilter == null) {
            mCursorFilter = new CursorFilter(this);
        }
        return mCursorFilter;
    }

    /**
     * Returns the query filter provider used for filtering. When the
     * provider is null, no filtering occurs.
     *
     * @return the current filter query provider or null if it does not exist
     *
     * @see #setFilterQueryProvider(android.widget.FilterQueryProvider)
     * @see #runQueryOnBackgroundThread(CharSequence)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:26.242 -0500", hash_original_method = "67EA54121BE0FFEF70F7156625E7E3CE", hash_generated_method = "5E9D53977A28C53BC6F0A075B9601152")
    
public FilterQueryProvider getFilterQueryProvider() {
        return mFilterQueryProvider;
    }
    
    private class ChangeObserver extends ContentObserver {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:26.249 -0500", hash_original_method = "E9F5B54480B866367BA64F4A5A962E11", hash_generated_method = "E23CF0978D3E04ECD9968CA70095A877")
        
public ChangeObserver() {
            super(new Handler());
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:26.252 -0500", hash_original_method = "0AAB5F0B0973D030DF154EF2BA0EE06F", hash_generated_method = "11A1AD60FCFEC7497B90886D427B8601")
        
@Override
        public boolean deliverSelfNotifications() {
            return true;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:26.254 -0500", hash_original_method = "E96460F373279AF9AB8806E159ABA424", hash_generated_method = "FE6E4E239777D858CE4B7F313EA96B2A")
        
@Override
        public void onChange(boolean selfChange) {
            onContentChanged();
        }
        
    }
    
    private class MyDataSetObserver extends DataSetObserver {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.999 -0400", hash_original_method = "B8855E81B638DE0F5C9202168EAE6D42", hash_generated_method = "B8855E81B638DE0F5C9202168EAE6D42")
        public MyDataSetObserver ()
        {
            //Synthesized constructor
        }
        @DSSafe(DSCat.ANDROID_CALLBACK)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:26.259 -0500", hash_original_method = "06FCBC692E549C3C9873F9D5CBAEB7B0", hash_generated_method = "F5BB92C0C1031FB7986568365B0C538E")
        
@Override
        public void onChanged() {
            mDataValid = true;
            notifyDataSetChanged();
        }

        @DSSafe(DSCat.ANDROID_CALLBACK)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:26.261 -0500", hash_original_method = "EAE7DF88825384424351353A02D60615", hash_generated_method = "9A1B7B95D5725934EBA7C54C4B809ED7")
        
@Override
        public void onInvalidated() {
            mDataValid = false;
            notifyDataSetInvalidated();
        }
        
    }

    /**
     * Sets the query filter provider used to filter the current Cursor.
     * The provider's
     * {@link android.widget.FilterQueryProvider#runQuery(CharSequence)}
     * method is invoked when filtering is requested by a client of
     * this adapter.
     *
     * @param filterQueryProvider the filter query provider or null to remove it
     *
     * @see #getFilterQueryProvider()
     * @see #runQueryOnBackgroundThread(CharSequence)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:26.244 -0500", hash_original_method = "DB32599181A301EC3439063743E0023E", hash_generated_method = "6EE317667BB9ED8B884FEF999EC255FF")
    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS)
public void setFilterQueryProvider(FilterQueryProvider filterQueryProvider) {
        mFilterQueryProvider = filterQueryProvider;
    }

    /**
     * Called when the {@link ContentObserver} on the cursor receives a change notification.
     * The default implementation provides the auto-requery logic, but may be overridden by
     * sub classes.
     * 
     * @see ContentObserver#onChange(boolean)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:26.246 -0500", hash_original_method = "A04D68B5B58FA27E71C6ECAA728402A5", hash_generated_method = "50F672FCCBB94C76F107B3C88A4DAAA0")
    
protected void onContentChanged() {
        if (mAutoRequery && mCursor != null && !mCursor.isClosed()) {
            if (false) Log.v("Cursor", "Auto requerying " + mCursor + " due to update");
            mDataValid = mCursor.requery();
        }
    }
}

