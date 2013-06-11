package android.database;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCursor implements CrossProcessCursor {
    private static final String TAG = "Cursor";
    DataSetObservable mDataSetObservable = new DataSetObservable();
    ContentObservable mContentObservable = new ContentObservable();
    Bundle mExtras = Bundle.EMPTY;
    @Deprecated
    protected HashMap<Long, Map<String, Object>> mUpdatedRows;
    protected int mRowIdColumnIndex;
    protected int mPos;
    protected Long mCurrentRowID;
    protected ContentResolver mContentResolver;
    protected boolean mClosed = false;
    private Uri mNotifyUri;
    private ContentObserver mSelfObserver;
    final private Object mSelfObserverLock = new Object();
    private boolean mSelfObserverRegistered;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.540 -0400", hash_original_method = "F60281D0CC7516E8B7AB1E4DD5850BC4", hash_generated_method = "A271EA34FD442DA8E3BE8D398214FEAE")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.541 -0400", hash_original_method = "DA5F8C1E79CBE35B90A3C92DA2B8F28D", hash_generated_method = "591C387801B9F0D67F0A284855E8703A")
    @DSModeled(DSC.SAFE)
    public int getType(int column) {
        dsTaint.addTaint(column);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return FIELD_TYPE_STRING;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.541 -0400", hash_original_method = "5BC3F93BAD50F14F34AFA39612F89CC6", hash_generated_method = "A7CDF90170FBA191D4C2B035DED70FDA")
    @DSModeled(DSC.SAFE)
    public byte[] getBlob(int column) {
        dsTaint.addTaint(column);
        throw new UnsupportedOperationException("getBlob is not supported");
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException("getBlob is not supported");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.541 -0400", hash_original_method = "DD0E28415E6C930BA9DBA04095F3A7EA", hash_generated_method = "B25919085723C9D527E42B41CA052E69")
    @DSModeled(DSC.SAFE)
    public CursorWindow getWindow() {
        return (CursorWindow)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.542 -0400", hash_original_method = "97CA757ED7462ACFFD2DF70EB3327BE9", hash_generated_method = "1A3A6C85FA0453B0EC73313B6EF043FD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getColumnCount() {
        int varE598DA0DE038A65D9C059A044E9E4C36_92264038 = (getColumnNames().length);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getColumnNames().length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.542 -0400", hash_original_method = "FE85B15F7B4AB77AD59F907B33A4DE11", hash_generated_method = "1F8ECED9BEC78E4807451DB31352F4CC")
    @DSModeled(DSC.SAFE)
    public void deactivate() {
        onDeactivateOrClose();
        // ---------- Original Method ----------
        //onDeactivateOrClose();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.542 -0400", hash_original_method = "5696E4CEEE521AD3C05FDA1D1F1B30F5", hash_generated_method = "8A992EBD1A1B248991920F67C7199539")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.542 -0400", hash_original_method = "6C342ADEDDD7EC7E0C1CE765BD80D8D1", hash_generated_method = "422518A340CE10C07D4A8E433AD047B4")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.542 -0400", hash_original_method = "B825EEA007B34E9E28068D61BE8C7018", hash_generated_method = "0E80242423912E1366BA961031DAA7D9")
    @DSModeled(DSC.SAFE)
    public boolean isClosed() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mClosed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.542 -0400", hash_original_method = "75E7685835D22353FA19EABDEF4435E7", hash_generated_method = "24B939CB1FB13B4AE91CFC402C1850EA")
    @DSModeled(DSC.SAFE)
    public void close() {
        mClosed = true;
        mContentObservable.unregisterAll();
        onDeactivateOrClose();
        // ---------- Original Method ----------
        //mClosed = true;
        //mContentObservable.unregisterAll();
        //onDeactivateOrClose();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.543 -0400", hash_original_method = "316C43B210EB72CE31C6D4E542FB15C5", hash_generated_method = "F13FF5CAE95AFAB5E46088630A031448")
    @DSModeled(DSC.SAFE)
    public boolean onMove(int oldPosition, int newPosition) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(newPosition);
        dsTaint.addTaint(oldPosition);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.543 -0400", hash_original_method = "8CF2CB9941A08AAA09DBF5869325E31C", hash_generated_method = "E2E35C36E51853DB0AFE686097F659FF")
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
                boolean varB3C493CCA0A5FEEBFBA4E5B6E1AC0832_317326447 = (data == null || data.length < result.length());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.543 -0400", hash_original_method = "EC88CAE72DCB37222F19A173793DEE6F", hash_generated_method = "44B9C4E51097EF92CC8528F577D1CEF7")
    @DSModeled(DSC.SAFE)
    public final int getPosition() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mPos;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.543 -0400", hash_original_method = "65BBCEF155E9F61984647ADC3CD9D8D5", hash_generated_method = "569882D3CB182EF16492ADE2F62F930E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean moveToPosition(int position) {
        dsTaint.addTaint(position);
        final int count;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.544 -0400", hash_original_method = "6FC66EDC6A2293E690F6FEA8028519D4", hash_generated_method = "75432ED8B023B28E9484F537AF940082")
    @DSModeled(DSC.SAFE)
    @Override
    public void fillWindow(int position, CursorWindow window) {
        dsTaint.addTaint(position);
        dsTaint.addTaint(window.dsTaint);
        DatabaseUtils.cursorFillWindow(this, position, window);
        // ---------- Original Method ----------
        //DatabaseUtils.cursorFillWindow(this, position, window);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.544 -0400", hash_original_method = "389B6720AF899474C54E777E5A800C06", hash_generated_method = "2936E0A6DA822D3C14CA95DC6C51FD77")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean move(int offset) {
        dsTaint.addTaint(offset);
        boolean varA63C7CEC1F816BE1838C38173C94CB20_273796195 = (moveToPosition(mPos + offset));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return moveToPosition(mPos + offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.544 -0400", hash_original_method = "B3EA5CAC0D9EF5BCE0C71FFF26BBF7DF", hash_generated_method = "3F322FE3616B59ACC1ACA72893BEE637")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean moveToFirst() {
        boolean var7169217BA523AE68C1F7B0C7563B6D2F_326330355 = (moveToPosition(0));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return moveToPosition(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.544 -0400", hash_original_method = "A0FD9DA9666B94596708F3F8CB94A387", hash_generated_method = "6E867059FEBE9E42135192663746617D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean moveToLast() {
        boolean var883322E63C74EFF5BA3E9BBFA1EB0817_89462760 = (moveToPosition(getCount() - 1));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return moveToPosition(getCount() - 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.544 -0400", hash_original_method = "44D940C3A0E42253110DBD8C1211FDCC", hash_generated_method = "A0D80EC12C836DB2EDD0BA2A02411E0E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean moveToNext() {
        boolean var6557A178A7D0E5B123127618582893AA_2071824515 = (moveToPosition(mPos + 1));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return moveToPosition(mPos + 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.545 -0400", hash_original_method = "70B7D1CBA52F6D8A8ABC528A78C51C39", hash_generated_method = "505810E2927FCE96A9A83DB8C105D9D2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean moveToPrevious() {
        boolean var62DFA72D2B670D9088C02CC6B3B7A7B4_1827456634 = (moveToPosition(mPos - 1));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return moveToPosition(mPos - 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.545 -0400", hash_original_method = "9906FDA9BB1856CC0A1F7D5381F7AEF7", hash_generated_method = "8FF6BA9839D6494C4B84672A9319A48A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean isFirst() {
        boolean varADB2B3DA6A35A98BE1B5E66B40FE6B61_950740189 = (mPos == 0 && getCount() != 0);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mPos == 0 && getCount() != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.545 -0400", hash_original_method = "5D098944D57453F70DEC79DF938E50E8", hash_generated_method = "F432030B0D5DD49A9E8F50AD430EA979")
    @DSModeled(DSC.SAFE)
    public final boolean isLast() {
        int cnt;
        cnt = getCount();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //int cnt = getCount();
        //return mPos == (cnt - 1) && cnt != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.545 -0400", hash_original_method = "BEAF42FFABF4F6277016BED9CE1900CE", hash_generated_method = "AC7D03B7400126C03F326DE747919865")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean isBeforeFirst() {
        {
            boolean var1E308F1B2924DF35832B0C6653D5399D_781064403 = (getCount() == 0);
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (getCount() == 0) {
            //return true;
        //}
        //return mPos == -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.546 -0400", hash_original_method = "EBC209D2038AD2122CD62927CB78B2F3", hash_generated_method = "694B03A12B86FBD737FE53D5B4A84BB2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean isAfterLast() {
        {
            boolean var1E308F1B2924DF35832B0C6653D5399D_2025421122 = (getCount() == 0);
        } //End collapsed parenthetic
        boolean var0FABA7953C222ACDE339B5487276FBD9_1913583556 = (mPos == getCount());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (getCount() == 0) {
            //return true;
        //}
        //return mPos == getCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.546 -0400", hash_original_method = "1BC2DDCF2F027B280B5593E829676223", hash_generated_method = "6FE5A23EB87330B0C6A73157C50B81DE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getColumnIndex(String columnName) {
        dsTaint.addTaint(columnName);
        final int periodIndex;
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
                    boolean var8A92D03C059C3C4A74106A947683F96E_608627849 = (columnNames[i].equalsIgnoreCase(columnName));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            {
                boolean varFC53D64D8090E12EDE66C4B1525878D8_421798304 = (getCount() > 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.546 -0400", hash_original_method = "7BAA81DCDF7699C82AB2A31918E9C0C1", hash_generated_method = "BC2552B7AF9F3021E1049D4A4E6D5998")
    @DSModeled(DSC.SAFE)
    public int getColumnIndexOrThrow(String columnName) {
        dsTaint.addTaint(columnName);
        final int index;
        index = getColumnIndex(columnName);
        {
            throw new IllegalArgumentException("column '" + columnName + "' does not exist");
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //final int index = getColumnIndex(columnName);
        //if (index < 0) {
            //throw new IllegalArgumentException("column '" + columnName + "' does not exist");
        //}
        //return index;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.546 -0400", hash_original_method = "2C8B9F57D7BABEC67595057D4A416343", hash_generated_method = "59D54675B485015F00C16134DFB46364")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getColumnName(int columnIndex) {
        dsTaint.addTaint(columnIndex);
        String var2071FD3E4F686DB35A30EE516361B518_1343056781 = (getColumnNames()[columnIndex]);
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getColumnNames()[columnIndex];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.547 -0400", hash_original_method = "969C8D7FAD299958455EEA8274658457", hash_generated_method = "42D263B1E83A219973C01A6B58DAB1F1")
    @DSModeled(DSC.SAFE)
    public void registerContentObserver(ContentObserver observer) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(observer.dsTaint);
        mContentObservable.registerObserver(observer);
        // ---------- Original Method ----------
        //mContentObservable.registerObserver(observer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.547 -0400", hash_original_method = "0986E51B80B8DF6AE5336EB6410DC9C5", hash_generated_method = "AA529AD8D6185D5AA4D93D4B78CCC65B")
    @DSModeled(DSC.SAFE)
    public void unregisterContentObserver(ContentObserver observer) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(observer.dsTaint);
        {
            mContentObservable.unregisterObserver(observer);
        } //End block
        // ---------- Original Method ----------
        //if (!mClosed) {
            //mContentObservable.unregisterObserver(observer);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.547 -0400", hash_original_method = "C09BE1AB0F1EB5BF63EC2A314B1EC0E8", hash_generated_method = "B39AD203FA3D26698B93CB86583F192E")
    @DSModeled(DSC.SAFE)
    protected void notifyDataSetChange() {
        mDataSetObservable.notifyChanged();
        // ---------- Original Method ----------
        //mDataSetObservable.notifyChanged();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.547 -0400", hash_original_method = "9CE71984FA039D61518575C1361CCA79", hash_generated_method = "0ADB28AA71DA90C2F368E938F0D64956")
    @DSModeled(DSC.SAFE)
    protected DataSetObservable getDataSetObservable() {
        return (DataSetObservable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mDataSetObservable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.547 -0400", hash_original_method = "5BE178AB760CC925EF7E1111F1B4915D", hash_generated_method = "811252175843CCDF842E079E3B96FACD")
    @DSModeled(DSC.SAFE)
    public void registerDataSetObserver(DataSetObserver observer) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(observer.dsTaint);
        mDataSetObservable.registerObserver(observer);
        // ---------- Original Method ----------
        //mDataSetObservable.registerObserver(observer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.547 -0400", hash_original_method = "8548074F279CEB9C75C60995B3E76B4B", hash_generated_method = "CBB7E927B1F7161B4FF823B366BA6706")
    @DSModeled(DSC.SAFE)
    public void unregisterDataSetObserver(DataSetObserver observer) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(observer.dsTaint);
        mDataSetObservable.unregisterObserver(observer);
        // ---------- Original Method ----------
        //mDataSetObservable.unregisterObserver(observer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.548 -0400", hash_original_method = "46E00F9025A0D5563AEDF0BD12648840", hash_generated_method = "247C6601A943A0D3EF3F5F028123375C")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.548 -0400", hash_original_method = "265F32C67EE2A711D5C4BAD496137660", hash_generated_method = "50BBAC57A8AA772B87ADB8801DD48495")
    @DSModeled(DSC.SPEC)
    public void setNotificationUri(ContentResolver cr, Uri notifyUri) {
        //DSFIXME:  CODE0009: Possible callback target function detected
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.548 -0400", hash_original_method = "DDB9421669E815EA51C0F68469B23471", hash_generated_method = "E2604D85E415344FF70A9241D9C0F502")
    @DSModeled(DSC.SPEC)
    public Uri getNotificationUri() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return (Uri)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mNotifyUri;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.548 -0400", hash_original_method = "95EB5F956072F4428350A5713DB4F16C", hash_generated_method = "0630D156785E7E754DC6AB00107AB61F")
    @DSModeled(DSC.SAFE)
    public boolean getWantsAllOnMoveCalls() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.548 -0400", hash_original_method = "FFD927D835EC033CA0D5789154520D3B", hash_generated_method = "07AEC52227AF9598A1CB1C0E1C7071D6")
    @DSModeled(DSC.SAFE)
    public void setExtras(Bundle extras) {
        dsTaint.addTaint(extras.dsTaint);
        mExtras = (extras == null) ? Bundle.EMPTY : extras;
        // ---------- Original Method ----------
        //mExtras = (extras == null) ? Bundle.EMPTY : extras;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.549 -0400", hash_original_method = "CF33C86C13BFD55DE499066ECC955562", hash_generated_method = "6A426F46B05FC9BFE882ECE023FE1517")
    @DSModeled(DSC.SAFE)
    public Bundle getExtras() {
        return (Bundle)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mExtras;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.549 -0400", hash_original_method = "0DCA3EA5579BB07DA7E61D916C230104", hash_generated_method = "9BAE41E0A112C18324327FB2DCC297BD")
    @DSModeled(DSC.SAFE)
    public Bundle respond(Bundle extras) {
        dsTaint.addTaint(extras.dsTaint);
        return (Bundle)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return Bundle.EMPTY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.549 -0400", hash_original_method = "038210FB7F6D7350A83F25D9DA43B6B8", hash_generated_method = "AD706E5D287BAD17C8DF158F25D06326")
    @DSModeled(DSC.SAFE)
    @Deprecated
    protected boolean isFieldUpdated(int columnIndex) {
        dsTaint.addTaint(columnIndex);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.549 -0400", hash_original_method = "C12342D6451FF7A0A51B2EFC9932FDFD", hash_generated_method = "F0DC8C9284F7A758D28C9724E561A8A6")
    @DSModeled(DSC.SAFE)
    @Deprecated
    protected Object getUpdatedField(int columnIndex) {
        dsTaint.addTaint(columnIndex);
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.549 -0400", hash_original_method = "D69CAFAFBC9C61DD3802AD1DC7C32FD3", hash_generated_method = "2424598918DFB41983B092ED1C65FE61")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void checkPosition() {
        {
            boolean var63B4E4AC12944E47003AF0905D5ED5FF_2106027352 = (-1 == mPos || getCount() == mPos);
            {
                throw new CursorIndexOutOfBoundsException(mPos, getCount());
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (-1 == mPos || getCount() == mPos) {
            //throw new CursorIndexOutOfBoundsException(mPos, getCount());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.549 -0400", hash_original_method = "F26D041066C4F03E188153BABFEE500A", hash_generated_method = "E891B2111FEE4905977CA85B177AB593")
    @DSModeled(DSC.SAFE)
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.550 -0400", hash_original_method = "F9E51D895511CEE60B782983BAF87140", hash_generated_method = "190BB3E7F3504B505B03C006E6B9F1DE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SelfContentObserver(AbstractCursor cursor) {
            super(null);
            dsTaint.addTaint(cursor.dsTaint);
            mCursor = new WeakReference<AbstractCursor>(cursor);
            // ---------- Original Method ----------
            //mCursor = new WeakReference<AbstractCursor>(cursor);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.550 -0400", hash_original_method = "A5B2D8696143266ED24B145CF029F206", hash_generated_method = "04AF9B9E52102CC0A16782543D266E43")
        @DSModeled(DSC.SAFE)
        @Override
        public boolean deliverSelfNotifications() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.550 -0400", hash_original_method = "DA6E4383047955D7231484890E1F062B", hash_generated_method = "B26EC6EB9ACE0EE11488E33FE1CCFC7B")
        @DSModeled(DSC.SAFE)
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


    
}


