package android.database;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.ContentResolver;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCursor implements CrossProcessCursor {
    DataSetObservable mDataSetObservable = new DataSetObservable();
    ContentObservable mContentObservable = new ContentObservable();
    Bundle mExtras = Bundle.EMPTY;
    @Deprecated protected HashMap<Long, Map<String, Object>> mUpdatedRows;
    protected int mRowIdColumnIndex;
    protected int mPos;
    protected Long mCurrentRowID;
    protected ContentResolver mContentResolver;
    protected boolean mClosed = false;
    private Uri mNotifyUri;
    private ContentObserver mSelfObserver;
    private Object mSelfObserverLock = new Object();
    private boolean mSelfObserverRegistered;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.784 -0400", hash_original_method = "F60281D0CC7516E8B7AB1E4DD5850BC4", hash_generated_method = "3B5E09C25C600EDC4F66CDCD37507170")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AbstractCursor() {
        mPos = -1;
        mRowIdColumnIndex = -1;
        mCurrentRowID = null;
        mUpdatedRows = new HashMap<Long, Map<String, Object>>();
        // ---------- Original Method ----------
        //mPos = -1;
        //mRowIdColumnIndex = -1;
        //mCurrentRowID = null;
        //mUpdatedRows = new HashMap<Long, Map<String, Object>>();
    }

    
    abstract public int getCount();

    
    abstract public String[] getColumnNames();

    
    abstract public String getString(int column);

    
    abstract public short getShort(int column);

    
    abstract public int getInt(int column);

    
    abstract public long getLong(int column);

    
    abstract public float getFloat(int column);

    
    abstract public double getDouble(int column);

    
    abstract public boolean isNull(int column);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.793 -0400", hash_original_method = "DA5F8C1E79CBE35B90A3C92DA2B8F28D", hash_generated_method = "42432289036085FD5A0BFD741E9DFB7D")
    @DSModeled(DSC.SAFE)
    public int getType(int column) {
        dsTaint.addTaint(column);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return FIELD_TYPE_STRING;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.793 -0400", hash_original_method = "5BC3F93BAD50F14F34AFA39612F89CC6", hash_generated_method = "4DAF896FCB5A766334BA00BFF2BB10E6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] getBlob(int column) {
        dsTaint.addTaint(column);
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("getBlob is not supported");
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException("getBlob is not supported");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.794 -0400", hash_original_method = "DD0E28415E6C930BA9DBA04095F3A7EA", hash_generated_method = "8B53AEC943D9BAFA435CF6B9A84EF810")
    @DSModeled(DSC.SAFE)
    public CursorWindow getWindow() {
        return (CursorWindow)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.794 -0400", hash_original_method = "97CA757ED7462ACFFD2DF70EB3327BE9", hash_generated_method = "888FBB85688CE49C3E29E1A0B8AF7DFB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getColumnCount() {
        int varE598DA0DE038A65D9C059A044E9E4C36_1517698858 = (getColumnNames().length);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getColumnNames().length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.794 -0400", hash_original_method = "FE85B15F7B4AB77AD59F907B33A4DE11", hash_generated_method = "17FE726C99E84E75E28F21C8A3D0BF8F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void deactivate() {
        onDeactivateOrClose();
        // ---------- Original Method ----------
        //onDeactivateOrClose();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.795 -0400", hash_original_method = "5696E4CEEE521AD3C05FDA1D1F1B30F5", hash_generated_method = "1A88E5AE7EDDB03D758D160469F2BE50")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void onDeactivateOrClose() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            mContentResolver.unregisterContentObserver(mSelfObserver);
            mSelfObserverRegistered = false;
        } //End block
        mDataSetObservable.notifyInvalidated();
        // ---------- Original Method ----------
        //if (mSelfObserver != null) {
            //mContentResolver.unregisterContentObserver(mSelfObserver);
            //mSelfObserverRegistered = false;
        //}
        //mDataSetObservable.notifyInvalidated();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.795 -0400", hash_original_method = "6C342ADEDDD7EC7E0C1CE765BD80D8D1", hash_generated_method = "7D04A8C380C3AB60D47C742BF4126FCB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean requery() {
        {
            mContentResolver.registerContentObserver(mNotifyUri, true, mSelfObserver);
            mSelfObserverRegistered = true;
        } //End block
        mDataSetObservable.notifyChanged();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mSelfObserver != null && mSelfObserverRegistered == false) {
            //mContentResolver.registerContentObserver(mNotifyUri, true, mSelfObserver);
            //mSelfObserverRegistered = true;
        //}
        //mDataSetObservable.notifyChanged();
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.795 -0400", hash_original_method = "B825EEA007B34E9E28068D61BE8C7018", hash_generated_method = "062C4E9ADC5A2E925A8AD80D6896BD48")
    @DSModeled(DSC.SAFE)
    public boolean isClosed() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mClosed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.795 -0400", hash_original_method = "75E7685835D22353FA19EABDEF4435E7", hash_generated_method = "2BF4E0E42FFFCB99FDCE632E9C0D4D96")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void close() {
        mClosed = true;
        mContentObservable.unregisterAll();
        onDeactivateOrClose();
        // ---------- Original Method ----------
        //mClosed = true;
        //mContentObservable.unregisterAll();
        //onDeactivateOrClose();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.796 -0400", hash_original_method = "316C43B210EB72CE31C6D4E542FB15C5", hash_generated_method = "A5BA08037F31E1277D0447C93FE90ED0")
    @DSModeled(DSC.SAFE)
    public boolean onMove(int oldPosition, int newPosition) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(newPosition);
        dsTaint.addTaint(oldPosition);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.806 -0400", hash_original_method = "8CF2CB9941A08AAA09DBF5869325E31C", hash_generated_method = "F0115DF00A3F3956E27EA58BCF4BE78C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void copyStringToBuffer(int columnIndex, CharArrayBuffer buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(columnIndex);
        String result;
        result = getString(columnIndex);
        {
            char[] data;
            data = buffer.data;
            {
                boolean varB3C493CCA0A5FEEBFBA4E5B6E1AC0832_605870548 = (data == null || data.length < result.length());
                {
                    buffer.data = result.toCharArray();
                } //End block
                {
                    result.getChars(0, result.length(), data, 0);
                } //End block
            } //End collapsed parenthetic
            buffer.sizeCopied = result.length();
        } //End block
        {
            buffer.sizeCopied = 0;
        } //End block
        // ---------- Original Method ----------
        //String result = getString(columnIndex);
        //if (result != null) {
            //char[] data = buffer.data;
            //if (data == null || data.length < result.length()) {
                //buffer.data = result.toCharArray();
            //} else {
                //result.getChars(0, result.length(), data, 0);
            //}
            //buffer.sizeCopied = result.length();
        //} else {
            //buffer.sizeCopied = 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.806 -0400", hash_original_method = "EC88CAE72DCB37222F19A173793DEE6F", hash_generated_method = "124A96BC3BF8A07B4C2DBABE9C37D702")
    @DSModeled(DSC.SAFE)
    public final int getPosition() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mPos;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.807 -0400", hash_original_method = "65BBCEF155E9F61984647ADC3CD9D8D5", hash_generated_method = "88A2AEE3C861BA0211EF984E3D912260")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean moveToPosition(int position) {
        dsTaint.addTaint(position);
        int count;
        count = getCount();
        {
            mPos = count;
        } //End block
        {
            mPos = -1;
        } //End block
        boolean result;
        result = onMove(mPos, position);
        {
            mPos = -1;
        } //End block
        {
            {
                mCurrentRowID = Long.valueOf(getLong(mRowIdColumnIndex));
            } //End block
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //final int count = getCount();
        //if (position >= count) {
            //mPos = count;
            //return false;
        //}
        //if (position < 0) {
            //mPos = -1;
            //return false;
        //}
        //if (position == mPos) {
            //return true;
        //}
        //boolean result = onMove(mPos, position);
        //if (result == false) {
            //mPos = -1;
        //} else {
            //mPos = position;
            //if (mRowIdColumnIndex != -1) {
                //mCurrentRowID = Long.valueOf(getLong(mRowIdColumnIndex));
            //}
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.808 -0400", hash_original_method = "6FC66EDC6A2293E690F6FEA8028519D4", hash_generated_method = "633971343A6EC2948BE3D1F22B80473B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void fillWindow(int position, CursorWindow window) {
        dsTaint.addTaint(position);
        dsTaint.addTaint(window.dsTaint);
        DatabaseUtils.cursorFillWindow(this, position, window);
        // ---------- Original Method ----------
        //DatabaseUtils.cursorFillWindow(this, position, window);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.809 -0400", hash_original_method = "389B6720AF899474C54E777E5A800C06", hash_generated_method = "9452DDF8725147E566BE100E91C8D8AC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean move(int offset) {
        dsTaint.addTaint(offset);
        boolean varA63C7CEC1F816BE1838C38173C94CB20_391570541 = (moveToPosition(mPos + offset));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return moveToPosition(mPos + offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.810 -0400", hash_original_method = "B3EA5CAC0D9EF5BCE0C71FFF26BBF7DF", hash_generated_method = "8BF8D8D966EA2C7F0C11CF970DD36317")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean moveToFirst() {
        boolean var7169217BA523AE68C1F7B0C7563B6D2F_1646761889 = (moveToPosition(0));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return moveToPosition(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.811 -0400", hash_original_method = "A0FD9DA9666B94596708F3F8CB94A387", hash_generated_method = "F3E73FB2F0B5FD7FEABFED60DD1A750B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean moveToLast() {
        boolean var883322E63C74EFF5BA3E9BBFA1EB0817_779161361 = (moveToPosition(getCount() - 1));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return moveToPosition(getCount() - 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.812 -0400", hash_original_method = "44D940C3A0E42253110DBD8C1211FDCC", hash_generated_method = "035FB1FEE875B4A643D9248A86367BD4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean moveToNext() {
        boolean var6557A178A7D0E5B123127618582893AA_1060399034 = (moveToPosition(mPos + 1));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return moveToPosition(mPos + 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.812 -0400", hash_original_method = "70B7D1CBA52F6D8A8ABC528A78C51C39", hash_generated_method = "4974EB77DDFB7369048BE89A6D33DE17")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean moveToPrevious() {
        boolean var62DFA72D2B670D9088C02CC6B3B7A7B4_349501942 = (moveToPosition(mPos - 1));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return moveToPosition(mPos - 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.814 -0400", hash_original_method = "9906FDA9BB1856CC0A1F7D5381F7AEF7", hash_generated_method = "F0B39D45DFA1EF473F024A89781E7E49")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean isFirst() {
        boolean varADB2B3DA6A35A98BE1B5E66B40FE6B61_310193875 = (mPos == 0 && getCount() != 0);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mPos == 0 && getCount() != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.815 -0400", hash_original_method = "5D098944D57453F70DEC79DF938E50E8", hash_generated_method = "D7261EC53FD41E54F366E1EDD6FC203E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean isLast() {
        int cnt;
        cnt = getCount();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //int cnt = getCount();
        //return mPos == (cnt - 1) && cnt != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.816 -0400", hash_original_method = "BEAF42FFABF4F6277016BED9CE1900CE", hash_generated_method = "97A23692BF66988127915DE76EEFE395")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean isBeforeFirst() {
        {
            boolean var1E308F1B2924DF35832B0C6653D5399D_1834793147 = (getCount() == 0);
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (getCount() == 0) {
            //return true;
        //}
        //return mPos == -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.816 -0400", hash_original_method = "EBC209D2038AD2122CD62927CB78B2F3", hash_generated_method = "FBA71A0082435A0DD757198F56E4027C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean isAfterLast() {
        {
            boolean var1E308F1B2924DF35832B0C6653D5399D_1449226990 = (getCount() == 0);
        } //End collapsed parenthetic
        boolean var0FABA7953C222ACDE339B5487276FBD9_908015011 = (mPos == getCount());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (getCount() == 0) {
            //return true;
        //}
        //return mPos == getCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.817 -0400", hash_original_method = "1BC2DDCF2F027B280B5593E829676223", hash_generated_method = "6DAD6B606842D77CCEB823E458DFD7B7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getColumnIndex(String columnName) {
        dsTaint.addTaint(columnName);
        int periodIndex;
        periodIndex = columnName.lastIndexOf('.');
        {
            Exception e;
            e = new Exception();
            columnName = columnName.substring(periodIndex + 1);
        } //End block
        String columnNames[];
        columnNames = getColumnNames();
        int length;
        length = columnNames.length;
        {
            int i;
            i = 0;
            {
                {
                    boolean var8A92D03C059C3C4A74106A947683F96E_1825788377 = (columnNames[i].equalsIgnoreCase(columnName));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            {
                boolean varFC53D64D8090E12EDE66C4B1525878D8_1548657501 = (getCount() > 0);
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //final int periodIndex = columnName.lastIndexOf('.');
        //if (periodIndex != -1) {
            //Exception e = new Exception();
            //Log.e(TAG, "requesting column name with table name -- " + columnName, e);
            //columnName = columnName.substring(periodIndex + 1);
        //}
        //String columnNames[] = getColumnNames();
        //int length = columnNames.length;
        //for (int i = 0; i < length; i++) {
            //if (columnNames[i].equalsIgnoreCase(columnName)) {
                //return i;
            //}
        //}
        //if (false) {
            //if (getCount() > 0) {
                //Log.w("AbstractCursor", "Unknown column " + columnName);
            //}
        //}
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.817 -0400", hash_original_method = "7BAA81DCDF7699C82AB2A31918E9C0C1", hash_generated_method = "98139FF886C007407954E225DECF7562")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getColumnIndexOrThrow(String columnName) {
        dsTaint.addTaint(columnName);
        int index;
        index = getColumnIndex(columnName);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("column '" + columnName + "' does not exist");
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //final int index = getColumnIndex(columnName);
        //if (index < 0) {
            //throw new IllegalArgumentException("column '" + columnName + "' does not exist");
        //}
        //return index;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.817 -0400", hash_original_method = "2C8B9F57D7BABEC67595057D4A416343", hash_generated_method = "2A672817849F8643FF33B74C8B2CE655")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getColumnName(int columnIndex) {
        dsTaint.addTaint(columnIndex);
        String var2071FD3E4F686DB35A30EE516361B518_548313344 = (getColumnNames()[columnIndex]);
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getColumnNames()[columnIndex];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.818 -0400", hash_original_method = "969C8D7FAD299958455EEA8274658457", hash_generated_method = "6285F50948A2D047C2F8E141FE8C9E90")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerContentObserver(ContentObserver observer) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(observer.dsTaint);
        mContentObservable.registerObserver(observer);
        // ---------- Original Method ----------
        //mContentObservable.registerObserver(observer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.818 -0400", hash_original_method = "0986E51B80B8DF6AE5336EB6410DC9C5", hash_generated_method = "4CA1204B0B685D55D4F85729CFC8AC9E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterContentObserver(ContentObserver observer) {
        dsTaint.addTaint(observer.dsTaint);
        {
            mContentObservable.unregisterObserver(observer);
        } //End block
        // ---------- Original Method ----------
        //if (!mClosed) {
            //mContentObservable.unregisterObserver(observer);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.818 -0400", hash_original_method = "C09BE1AB0F1EB5BF63EC2A314B1EC0E8", hash_generated_method = "362A8921CADC3161CC20FD83BD5E4602")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void notifyDataSetChange() {
        mDataSetObservable.notifyChanged();
        // ---------- Original Method ----------
        //mDataSetObservable.notifyChanged();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.819 -0400", hash_original_method = "9CE71984FA039D61518575C1361CCA79", hash_generated_method = "53A88933A1A9D4706FB74137F947E001")
    @DSModeled(DSC.SAFE)
    protected DataSetObservable getDataSetObservable() {
        return (DataSetObservable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mDataSetObservable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.819 -0400", hash_original_method = "5BE178AB760CC925EF7E1111F1B4915D", hash_generated_method = "FC77F1E3F279C66541FD7DA4F64358F4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerDataSetObserver(DataSetObserver observer) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(observer.dsTaint);
        mDataSetObservable.registerObserver(observer);
        // ---------- Original Method ----------
        //mDataSetObservable.registerObserver(observer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.819 -0400", hash_original_method = "8548074F279CEB9C75C60995B3E76B4B", hash_generated_method = "C1751D77F2D779318A80DD109F1E6D00")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterDataSetObserver(DataSetObserver observer) {
        dsTaint.addTaint(observer.dsTaint);
        mDataSetObservable.unregisterObserver(observer);
        // ---------- Original Method ----------
        //mDataSetObservable.unregisterObserver(observer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.820 -0400", hash_original_method = "46E00F9025A0D5563AEDF0BD12648840", hash_generated_method = "F65D3999BB632B4D0CD1831AE8B4260B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void onChange(boolean selfChange) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(selfChange);
        {
            mContentObservable.dispatchChange(selfChange);
            {
                mContentResolver.notifyChange(mNotifyUri, mSelfObserver);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized (mSelfObserverLock) {
            //mContentObservable.dispatchChange(selfChange);
            //if (mNotifyUri != null && selfChange) {
                //mContentResolver.notifyChange(mNotifyUri, mSelfObserver);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.822 -0400", hash_original_method = "265F32C67EE2A711D5C4BAD496137660", hash_generated_method = "6CBE7F3F51F79FC2116E1874FE73C972")
    @DSModeled(DSC.SPEC)
    public void setNotificationUri(ContentResolver cr, Uri notifyUri) {
        dsTaint.addTaint(cr.dsTaint);
        dsTaint.addTaint(notifyUri.dsTaint);
        {
            {
                mContentResolver.unregisterContentObserver(mSelfObserver);
            } //End block
            mSelfObserver = new SelfContentObserver(this);
            mContentResolver.registerContentObserver(mNotifyUri, true, mSelfObserver);
            mSelfObserverRegistered = true;
        } //End block
        // ---------- Original Method ----------
        //synchronized (mSelfObserverLock) {
            //mNotifyUri = notifyUri;
            //mContentResolver = cr;
            //if (mSelfObserver != null) {
                //mContentResolver.unregisterContentObserver(mSelfObserver);
            //}
            //mSelfObserver = new SelfContentObserver(this);
            //mContentResolver.registerContentObserver(mNotifyUri, true, mSelfObserver);
            //mSelfObserverRegistered = true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.823 -0400", hash_original_method = "DDB9421669E815EA51C0F68469B23471", hash_generated_method = "7F4746D14C9EA7994065084FDCDC3D14")
    @DSModeled(DSC.SPEC)
    public Uri getNotificationUri() {
        return (Uri)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mNotifyUri;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.823 -0400", hash_original_method = "95EB5F956072F4428350A5713DB4F16C", hash_generated_method = "0743E50CE490F5D11D908B7FAB507449")
    @DSModeled(DSC.SAFE)
    public boolean getWantsAllOnMoveCalls() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.823 -0400", hash_original_method = "FFD927D835EC033CA0D5789154520D3B", hash_generated_method = "5D4EA0DED19B9ABB5E8C702295A672FC")
    @DSModeled(DSC.SAFE)
    public void setExtras(Bundle extras) {
        dsTaint.addTaint(extras.dsTaint);
        mExtras = (extras == null) ? Bundle.EMPTY : extras;
        // ---------- Original Method ----------
        //mExtras = (extras == null) ? Bundle.EMPTY : extras;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.824 -0400", hash_original_method = "CF33C86C13BFD55DE499066ECC955562", hash_generated_method = "5467DB301C93271E15B2B85B3DDE4C93")
    @DSModeled(DSC.SAFE)
    public Bundle getExtras() {
        return (Bundle)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mExtras;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.824 -0400", hash_original_method = "0DCA3EA5579BB07DA7E61D916C230104", hash_generated_method = "634275E652210744BEA34DB46178FD06")
    @DSModeled(DSC.SAFE)
    public Bundle respond(Bundle extras) {
        dsTaint.addTaint(extras.dsTaint);
        return (Bundle)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return Bundle.EMPTY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.824 -0400", hash_original_method = "038210FB7F6D7350A83F25D9DA43B6B8", hash_generated_method = "E6B09E8F2ED884D7EFE8216BFD4F02CC")
    @DSModeled(DSC.SAFE)
    @Deprecated
    protected boolean isFieldUpdated(int columnIndex) {
        dsTaint.addTaint(columnIndex);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.825 -0400", hash_original_method = "C12342D6451FF7A0A51B2EFC9932FDFD", hash_generated_method = "4D42EEBBC835998838F33EE1A03EF0EA")
    @DSModeled(DSC.SAFE)
    @Deprecated
    protected Object getUpdatedField(int columnIndex) {
        dsTaint.addTaint(columnIndex);
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.825 -0400", hash_original_method = "D69CAFAFBC9C61DD3802AD1DC7C32FD3", hash_generated_method = "FC2FC3400845C1E582F8034558AA4FE0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void checkPosition() {
        {
            boolean var63B4E4AC12944E47003AF0905D5ED5FF_1167801500 = (-1 == mPos || getCount() == mPos);
            {
                if (DroidSafeAndroidRuntime.control) throw new CursorIndexOutOfBoundsException(mPos, getCount());
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (-1 == mPos || getCount() == mPos) {
            //throw new CursorIndexOutOfBoundsException(mPos, getCount());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.825 -0400", hash_original_method = "F26D041066C4F03E188153BABFEE500A", hash_generated_method = "527FAC0CAA846B70BB6AE3177A20EE40")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void finalize() {
        {
            mContentResolver.unregisterContentObserver(mSelfObserver);
        } //End block
        // ---------- Original Method ----------
        //if (mSelfObserver != null && mSelfObserverRegistered == true) {
            //mContentResolver.unregisterContentObserver(mSelfObserver);
        //}
    }

    
    protected static class SelfContentObserver extends ContentObserver {
        WeakReference<AbstractCursor> mCursor;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.826 -0400", hash_original_method = "F9E51D895511CEE60B782983BAF87140", hash_generated_method = "EA2D927889FD7BAF0D1A277AB0F02B87")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SelfContentObserver(AbstractCursor cursor) {
            super(null);
            dsTaint.addTaint(cursor.dsTaint);
            mCursor = new WeakReference<AbstractCursor>(cursor);
            // ---------- Original Method ----------
            //mCursor = new WeakReference<AbstractCursor>(cursor);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.837 -0400", hash_original_method = "A5B2D8696143266ED24B145CF029F206", hash_generated_method = "F715171AD0DE912B03270516F086F02E")
        @DSModeled(DSC.SAFE)
        @Override
        public boolean deliverSelfNotifications() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.837 -0400", hash_original_method = "DA6E4383047955D7231484890E1F062B", hash_generated_method = "F4114780C23FCA10E581BFB821D2A5FE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void onChange(boolean selfChange) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(selfChange);
            AbstractCursor cursor;
            cursor = mCursor.get();
            {
                cursor.onChange(false);
            } //End block
            // ---------- Original Method ----------
            //AbstractCursor cursor = mCursor.get();
            //if (cursor != null) {
                //cursor.onChange(false);
            //}
        }

        
    }


    
    private static final String TAG = "Cursor";
}

