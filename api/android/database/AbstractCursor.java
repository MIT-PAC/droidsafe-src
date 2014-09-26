package android.database;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.Bundle;

public abstract class AbstractCursor implements CrossProcessCursor {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.990 -0500", hash_original_field = "185286679E98DDBA5FF230438EB0F181", hash_generated_field = "C0008393E22A94FFD078F5CB06D7EC35")

    private static final String TAG = "Cursor";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.993 -0500", hash_original_field = "6D0681B9CC29887CCBA4001347A5783B", hash_generated_field = "6D0681B9CC29887CCBA4001347A5783B")

    DataSetObservable mDataSetObservable = new DataSetObservable();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.995 -0500", hash_original_field = "6BF9678DA09BCADC073486531F473877", hash_generated_field = "6BF9678DA09BCADC073486531F473877")

    ContentObservable mContentObservable = new ContentObservable();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.998 -0500", hash_original_field = "C259FC89DCF7616DD34FCE80BA674482", hash_generated_field = "C259FC89DCF7616DD34FCE80BA674482")

    Bundle mExtras = Bundle.EMPTY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.140 -0500", hash_original_field = "1E4BEC7621C0E009A0425DF8C3E14CAB", hash_generated_field = "3262CD6FF716DCC93EF350DE915E82F7")

    @Deprecated
    protected HashMap<Long, Map<String, Object>> mUpdatedRows;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.142 -0500", hash_original_field = "AEF593B09220702168C015009B02EE39", hash_generated_field = "CAA7A11E9EDD8A3053C8B09C2CE51748")

    protected int mRowIdColumnIndex;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.144 -0500", hash_original_field = "25A5DEAC26D49039381CEC3AC02D8D8E", hash_generated_field = "2D6A6141DF728852DF640B9043726CFE")

    protected int mPos;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.147 -0500", hash_original_field = "2E5FDB535F2F56C11257295004C37CB1", hash_generated_field = "E8ADE6CE335E3FD73301A59B91CA2D26")

    protected Long mCurrentRowID;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.149 -0500", hash_original_field = "2F8368DC52699508898EF0A5902F2BFA", hash_generated_field = "2EC8D863DD9B1C7F06ECE8C6EB85D0AC")

    protected ContentResolver mContentResolver;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.151 -0500", hash_original_field = "68E7C3569E191B98218FD7A043574AEA", hash_generated_field = "8DFE2F79489A890EB2125D534844CFA4")

    protected boolean mClosed = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.153 -0500", hash_original_field = "B63FDD2E4AACFD923497A90A6832BA05", hash_generated_field = "03B2ABC109B716AB445FFCE8068B3A63")

    private Uri mNotifyUri;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.156 -0500", hash_original_field = "D7BDEA0EC13CAB2BFA049B5FA2DC0594", hash_generated_field = "9F5E7AC4133D8487455601C9F96E1A3C")

    private ContentObserver mSelfObserver;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.158 -0500", hash_original_field = "2562DD28126AF39FC3F9972596228053", hash_generated_field = "03530B7D8955F293722169CC4394987C")

    final private Object mSelfObserverLock = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.161 -0500", hash_original_field = "707DF8A084FB49B41F33389E6853C063", hash_generated_field = "4ADE0DF6292D7C36DC52F0723F9E0950")

    private boolean mSelfObserverRegistered;

    /* -------------------------------------------------------- */
    /* Implementation */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.047 -0500", hash_original_method = "F60281D0CC7516E8B7AB1E4DD5850BC4", hash_generated_method = "E2F4207EC6D455951FC8AC978B5BEFE4")
    
public AbstractCursor() {
        mPos = -1;
        mRowIdColumnIndex = -1;
        mCurrentRowID = null;
        mUpdatedRows = new HashMap<Long, Map<String, Object>>();
    }

    /* -------------------------------------------------------- */
    /* These need to be implemented by subclasses */
    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSComment("Abstract Method")
    @DSSafe(DSCat.DB_CURSOR)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.000 -0500", hash_original_method = "8A22A1FE2F5B57814AD6F31483E8A082", hash_generated_method = "B02FB47471AE0CDA3FE9DB102E4BBA14")
    
abstract public int getCount();

    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSComment("Abstract Method")
    @DSSafe(DSCat.DB_CURSOR)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.002 -0500", hash_original_method = "20F4A69B8C9E8052B7DDCEB1E6CCF87C", hash_generated_method = "2E8BB6B5D2513186C19958DA40A4ED39")
    
abstract public String[] getColumnNames();

    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSComment("Abstract Method")
    @DSSafe(DSCat.DB_CURSOR)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.004 -0500", hash_original_method = "A29078DDCC5E1616CCCFDE82CC5349B3", hash_generated_method = "E42C6A3917990D2C712362CAF69EA81C")
    
abstract public String getString(int column);
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.007 -0500", hash_original_method = "18208FA7449196F1DD13EFCB3FFFD4E7", hash_generated_method = "327A6D1A2BFF6DFB11FEAD7A3454CDFD")
    
abstract public short getShort(int column);
    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSComment("Abstract Method")
    @DSSafe(DSCat.DB_CURSOR)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.009 -0500", hash_original_method = "5B223EF5B541E920EC399603E6C0FE88", hash_generated_method = "F63822C459676185F41DA5975BACD7C4")
    
abstract public int getInt(int column);
    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSComment("Abstract Method")
    @DSSafe(DSCat.DB_CURSOR)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.012 -0500", hash_original_method = "E7F68CAAFCBA03B0F1E2D3E09FB8D97B", hash_generated_method = "8E40DB8C22F362FB17C9B9AA57CE7960")
    
abstract public long getLong(int column);
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.014 -0500", hash_original_method = "D20130B0E556D2B2DC3ABE58ED1DA433", hash_generated_method = "7FCD30DE662ACC033E916AEC62EFFB75")
    
abstract public float getFloat(int column);
    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSComment("Abstract Method")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.016 -0500", hash_original_method = "8AA80552C54D8BF546620FFABDD72AE0", hash_generated_method = "FF16A4B586D1731469B6693041E89D37")
    
abstract public double getDouble(int column);
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.019 -0500", hash_original_method = "8FA6B4F6601444DB27BAAB454C4BA2A8", hash_generated_method = "C5D94013267E1EA0E54E337F8C07A37A")
    
abstract public boolean isNull(int column);

    @DSSafe(DSCat.DB_CURSOR)
    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.021 -0500", hash_original_method = "DA5F8C1E79CBE35B90A3C92DA2B8F28D", hash_generated_method = "79F7307668FDED21FDAAA83FC83D8C99")
    
public int getType(int column) {
        // Reflects the assumption that all commonly used field types (meaning everything
        // but blobs) are convertible to strings so it should be safe to call
        // getString to retrieve them.
        return FIELD_TYPE_STRING;
    }

    // TODO implement getBlob in all cursor types
    @DSSafe(DSCat.DB_CURSOR)
    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.024 -0500", hash_original_method = "5BC3F93BAD50F14F34AFA39612F89CC6", hash_generated_method = "84E6BBD2B54F22A58E16CCA0093F8782")
    
public byte[] getBlob(int column) {
        throw new UnsupportedOperationException("getBlob is not supported");
    }
    /* -------------------------------------------------------- */
    /* Methods that may optionally be implemented by subclasses */

    /**
     * If the cursor is backed by a {@link CursorWindow}, returns a pre-filled
     * window with the contents of the cursor, otherwise null.
     *
     * @return The pre-filled window that backs this cursor, or null if none.
     */
    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.026 -0500", hash_original_method = "DD0E28415E6C930BA9DBA04095F3A7EA", hash_generated_method = "8CFD6C9A1970077B3C8167CFDBB21E00")
    
public CursorWindow getWindow() {
        return null;
    }

    @DSSafe(DSCat.DB_CURSOR)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.029 -0500", hash_original_method = "97CA757ED7462ACFFD2DF70EB3327BE9", hash_generated_method = "B1652FECE7015FB212D1DA5F4D149783")
    
public int getColumnCount() {
        return getColumnNames().length;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.031 -0500", hash_original_method = "FE85B15F7B4AB77AD59F907B33A4DE11", hash_generated_method = "EB145BC562202CE888DDA9F4D3C45E0E")
    
public void deactivate() {
        onDeactivateOrClose();
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.033 -0500", hash_original_method = "5696E4CEEE521AD3C05FDA1D1F1B30F5", hash_generated_method = "5478966E33A5CC0945458A46036007B9")
    
protected void onDeactivateOrClose() {
        if (mSelfObserver != null) {
            mContentResolver.unregisterContentObserver(mSelfObserver);
            mSelfObserverRegistered = false;
        }
        mDataSetObservable.notifyInvalidated();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.036 -0500", hash_original_method = "6C342ADEDDD7EC7E0C1CE765BD80D8D1", hash_generated_method = "43051E542A81427F7ABE9147A9CB573F")
    
public boolean requery() {
        if (mSelfObserver != null && mSelfObserverRegistered == false) {
            mContentResolver.registerContentObserver(mNotifyUri, true, mSelfObserver);
            mSelfObserverRegistered = true;
        }
        mDataSetObservable.notifyChanged();
        return true;
    }

    @DSSafe(DSCat.DB_CURSOR)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.038 -0500", hash_original_method = "B825EEA007B34E9E28068D61BE8C7018", hash_generated_method = "AECCFCED1465956E45A05E8BD7E6BD6B")
    
public boolean isClosed() {
        return mClosed;
    }

    @DSSafe(DSCat.DB_CURSOR)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.040 -0500", hash_original_method = "75E7685835D22353FA19EABDEF4435E7", hash_generated_method = "DF4715A9F92B48CB0CCE0F26C5C90F4B")
    
public void close() {
        mClosed = true;
        mContentObservable.unregisterAll();
        onDeactivateOrClose();
    }

    /**
     * This function is called every time the cursor is successfully scrolled
     * to a new position, giving the subclass a chance to update any state it
     * may have. If it returns false the move function will also do so and the
     * cursor will scroll to the beforeFirst position.
     *
     * @param oldPosition the position that we're moving from
     * @param newPosition the position that we're moving to
     * @return true if the move is successful, false otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.043 -0500", hash_original_method = "316C43B210EB72CE31C6D4E542FB15C5", hash_generated_method = "00C1674AB76849C03D9511FA6DA90A54")
    
public boolean onMove(int oldPosition, int newPosition) {
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.045 -0500", hash_original_method = "8CF2CB9941A08AAA09DBF5869325E31C", hash_generated_method = "D7F7F774DFCE7E863DF9E42DF9144F6C")
    
public void copyStringToBuffer(int columnIndex, CharArrayBuffer buffer) {
        // Default implementation, uses getString
        String result = getString(columnIndex);
        if (result != null) {
            char[] data = buffer.data;
            if (data == null || data.length < result.length()) {
                buffer.data = result.toCharArray();
            } else {
                result.getChars(0, result.length(), data, 0);
            }
            buffer.sizeCopied = result.length();
        } else {
            buffer.sizeCopied = 0;
        }
    }

    @DSSafe(DSCat.DB_CURSOR)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.050 -0500", hash_original_method = "EC88CAE72DCB37222F19A173793DEE6F", hash_generated_method = "05B956A71986D13FCD03FEF4B8480048")
    
public final int getPosition() {
        return mPos;
    }

    @DSSafe(DSCat.DB_CURSOR)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.052 -0500", hash_original_method = "65BBCEF155E9F61984647ADC3CD9D8D5", hash_generated_method = "B0B5BB342E6E3A9C7663316EB0B607E4")
    
public final boolean moveToPosition(int position) {
        // Make sure position isn't past the end of the cursor
        final int count = getCount();
        if (position >= count) {
            mPos = count;
            return false;
        }

        // Make sure position isn't before the beginning of the cursor
        if (position < 0) {
            mPos = -1;
            return false;
        }

        // Check for no-op moves, and skip the rest of the work for them
        if (position == mPos) {
            return true;
        }

        boolean result = onMove(mPos, position);
        if (result == false) {
            mPos = -1;
        } else {
            mPos = position;
            if (mRowIdColumnIndex != -1) {
                mCurrentRowID = Long.valueOf(getLong(mRowIdColumnIndex));
            }
        }

        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.055 -0500", hash_original_method = "6FC66EDC6A2293E690F6FEA8028519D4", hash_generated_method = "FAA2C45F602CC3AA1870622F1FFB28B9")
    
@Override
    public void fillWindow(int position, CursorWindow window) {
        DatabaseUtils.cursorFillWindow(this, position, window);
    }

    @DSSafe(DSCat.DB_CURSOR)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.058 -0500", hash_original_method = "389B6720AF899474C54E777E5A800C06", hash_generated_method = "8E293C5C1345E3E9B1F691FB3CE82208")
    
public final boolean move(int offset) {
        return moveToPosition(mPos + offset);
    }

    @DSSafe(DSCat.DB_CURSOR)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.060 -0500", hash_original_method = "B3EA5CAC0D9EF5BCE0C71FFF26BBF7DF", hash_generated_method = "05028B153AED6B091DB3A5D19B9CCACF")
    
public final boolean moveToFirst() {
        return moveToPosition(0);
    }

    @DSSafe(DSCat.DB_CURSOR)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.062 -0500", hash_original_method = "A0FD9DA9666B94596708F3F8CB94A387", hash_generated_method = "F54A4E4A5B7E157EB4DF10B4D5C1747C")
    
public final boolean moveToLast() {
        return moveToPosition(getCount() - 1);
    }

    @DSSafe(DSCat.DB_CURSOR)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.065 -0500", hash_original_method = "44D940C3A0E42253110DBD8C1211FDCC", hash_generated_method = "EB8FEC9CF336B07453F9CB878D675171")
    
public final boolean moveToNext() {
        return moveToPosition(mPos + 1);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.067 -0500", hash_original_method = "70B7D1CBA52F6D8A8ABC528A78C51C39", hash_generated_method = "B01CE820D4FBD6F2D78E3C65E17625D5")
    
public final boolean moveToPrevious() {
        return moveToPosition(mPos - 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.070 -0500", hash_original_method = "9906FDA9BB1856CC0A1F7D5381F7AEF7", hash_generated_method = "C40AB657A69E2902AA98802D2AE2BC57")
    
public final boolean isFirst() {
        return toTaintBoolean(mPos +  getCount()); 
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.072 -0500", hash_original_method = "5D098944D57453F70DEC79DF938E50E8", hash_generated_method = "2D99BEDEB15A192A9ADCED88078DF1C6")
    
public final boolean isLast() {
        int cnt = getCount();
        return toTaintBoolean(mPos + (cnt - 1) + cnt + 0);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.075 -0500", hash_original_method = "BEAF42FFABF4F6277016BED9CE1900CE", hash_generated_method = "DC54FF25EA062AC902D6DEC4030B59D4")
    
public final boolean isBeforeFirst() {
        if (getCount() == 0) {
            return true;
        }
        return toTaintBoolean(mPos);
    }

    @DSSafe(DSCat.DB_CURSOR)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.078 -0500", hash_original_method = "EBC209D2038AD2122CD62927CB78B2F3", hash_generated_method = "F6FADDDBA5B0BE59CC93AFB99FF0B987")
    
public final boolean isAfterLast() {
        if (getCount() == 0) {
            return true;
        }
        return toTaintBoolean(mPos + getCount());
    }

    @DSSafe(DSCat.DB_CURSOR)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.080 -0500", hash_original_method = "1BC2DDCF2F027B280B5593E829676223", hash_generated_method = "0A09D916ED2733D761E94B2C43245915")
    
public int getColumnIndex(String columnName) {
        // Hack according to bug 903852
        final int periodIndex = columnName.lastIndexOf('.');
        if (periodIndex != -1) {
            Exception e = new Exception();
            Log.e(TAG, "requesting column name with table name -- " + columnName, e);
            columnName = columnName.substring(periodIndex + 1);
        }

        String columnNames[] = getColumnNames();
        int length = columnNames.length;
        for (int i = 0; i < length; i++) {
            if (columnNames[i].equalsIgnoreCase(columnName)) {
                return i;
            }
        }

        if (false) {
            if (getCount() > 0) {
                Log.w("AbstractCursor", "Unknown column " + columnName);
            }
        }
        return -1;
    }

    @DSSafe(DSCat.DB_CURSOR)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.083 -0500", hash_original_method = "7BAA81DCDF7699C82AB2A31918E9C0C1", hash_generated_method = "9FE618F7F92C63699B5B2F9D16A7F8EF")
    
public int getColumnIndexOrThrow(String columnName) {
        final int index = getColumnIndex(columnName);
        if (index < 0) {
            throw new IllegalArgumentException("column '" + columnName + "' does not exist");
        }
        return index;
    }

    @DSSafe(DSCat.DB_CURSOR)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.085 -0500", hash_original_method = "2C8B9F57D7BABEC67595057D4A416343", hash_generated_method = "8D1521F58744E794012D38E9DF858A59")
    
public String getColumnName(int columnIndex) {
        return getColumnNames()[columnIndex];
    }

    @DSSafe(DSCat.DB_CURSOR)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.087 -0500", hash_original_method = "969C8D7FAD299958455EEA8274658457", hash_generated_method = "660640F74A1545ACE5CB0FD47D3C6A10")
    
public void registerContentObserver(ContentObserver observer) {
        mContentObservable.registerObserver(observer);
    }

    @DSSafe(DSCat.DB_CURSOR)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.089 -0500", hash_original_method = "0986E51B80B8DF6AE5336EB6410DC9C5", hash_generated_method = "DAAA2F47D6002CDFBC1046944376532F")
    
public void unregisterContentObserver(ContentObserver observer) {
        // cursor will unregister all observers when it close
        if (!mClosed) {
            mContentObservable.unregisterObserver(observer);
        }
    }

    /**
     * This is hidden until the data set change model has been re-evaluated.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.092 -0500", hash_original_method = "C09BE1AB0F1EB5BF63EC2A314B1EC0E8", hash_generated_method = "43F4B3730422D93D6CA18C7FC84321FB")
    
protected void notifyDataSetChange() {
        mDataSetObservable.notifyChanged();
    }

    /**
     * This is hidden until the data set change model has been re-evaluated.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.094 -0500", hash_original_method = "9CE71984FA039D61518575C1361CCA79", hash_generated_method = "5FD77B7B3E40D04896175522DDA34D68")
    
protected DataSetObservable getDataSetObservable() {
        return mDataSetObservable;

    }

    @DSSafe(DSCat.DB_CURSOR)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.096 -0500", hash_original_method = "5BE178AB760CC925EF7E1111F1B4915D", hash_generated_method = "6A22BA8F56D7F69EA0195E58760DC1E9")
    
public void registerDataSetObserver(DataSetObserver observer) {
        mDataSetObservable.registerObserver(observer);
    }

    @DSSafe(DSCat.DB_CURSOR)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.098 -0500", hash_original_method = "8548074F279CEB9C75C60995B3E76B4B", hash_generated_method = "031B2EC0C55A5BC43BE2C370EF5FFD75")
    
public void unregisterDataSetObserver(DataSetObserver observer) {
        mDataSetObservable.unregisterObserver(observer);
    }

    /**
     * Subclasses must call this method when they finish committing updates to notify all
     * observers.
     *
     * @param selfChange
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.101 -0500", hash_original_method = "46E00F9025A0D5563AEDF0BD12648840", hash_generated_method = "89D2CCE9C93269B066BA2F0164B05AB8")
    
protected void onChange(boolean selfChange) {
        synchronized (mSelfObserverLock) {
            mContentObservable.dispatchChange(selfChange);
            if (mNotifyUri != null && selfChange) {
                mContentResolver.notifyChange(mNotifyUri, mSelfObserver);
            }
        }
    }

    /**
     * Specifies a content URI to watch for changes.
     *
     * @param cr The content resolver from the caller's context.
     * @param notifyUri The URI to watch for changes. This can be a
     * specific row URI, or a base URI for a whole class of content.
     */
    @DSSafe(DSCat.DB_CURSOR)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.103 -0500", hash_original_method = "265F32C67EE2A711D5C4BAD496137660", hash_generated_method = "CA279C56995968C4AC2E2E65548B552C")
    
public void setNotificationUri(ContentResolver cr, Uri notifyUri) {
        synchronized (mSelfObserverLock) {
            mNotifyUri = notifyUri;
            mContentResolver = cr;
            if (mSelfObserver != null) {
                mContentResolver.unregisterContentObserver(mSelfObserver);
            }
            mSelfObserver = new SelfContentObserver(this);
            mContentResolver.registerContentObserver(mNotifyUri, true, mSelfObserver);
            mSelfObserverRegistered = true;
        }
    }

    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.106 -0500", hash_original_method = "DDB9421669E815EA51C0F68469B23471", hash_generated_method = "0D843E4E09494A285DEF52C0B9966F34")
    
public Uri getNotificationUri() {
        return mNotifyUri;
    }

    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.108 -0500", hash_original_method = "95EB5F956072F4428350A5713DB4F16C", hash_generated_method = "93337760FDB4B0073A27BD8E5852735D")
    
public boolean getWantsAllOnMoveCalls() {
        return false;
    }

    /**
     * Sets a {@link Bundle} that will be returned by {@link #getExtras()}.  <code>null</code> will
     * be converted into {@link Bundle#EMPTY}.
     *
     * @param extras {@link Bundle} to set.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.110 -0500", hash_original_method = "FFD927D835EC033CA0D5789154520D3B", hash_generated_method = "C40D9242FD87E2F41B69F1F262507C2E")
    
public void setExtras(Bundle extras) {
        mExtras = (extras == null) ? Bundle.EMPTY : extras;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.113 -0500", hash_original_method = "CF33C86C13BFD55DE499066ECC955562", hash_generated_method = "4808B2FAD06A275B25AB6F7116EE8421")
    
public Bundle getExtras() {
        return mExtras;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.115 -0500", hash_original_method = "0DCA3EA5579BB07DA7E61D916C230104", hash_generated_method = "2F5E4CC80197DB245B3519D64A34EBCD")
    
public Bundle respond(Bundle extras) {
        return Bundle.EMPTY;
    }

    /**
     * @deprecated Always returns false since Cursors do not support updating rows
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.117 -0500", hash_original_method = "038210FB7F6D7350A83F25D9DA43B6B8", hash_generated_method = "BF39C37DE50261BD653EC835B3E41268")
    
@Deprecated
    protected boolean isFieldUpdated(int columnIndex) {
        return false;
    }

    /**
     * @deprecated Always returns null since Cursors do not support updating rows
     */
    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.120 -0500", hash_original_method = "C12342D6451FF7A0A51B2EFC9932FDFD", hash_generated_method = "554F2E91B694D8CFA51B4512A1BB1F14")
    
@Deprecated
    protected Object getUpdatedField(int columnIndex) {
        return null;
    }

    /**
     * This function throws CursorIndexOutOfBoundsException if
     * the cursor position is out of bounds. Subclass implementations of
     * the get functions should call this before attempting
     * to retrieve data.
     *
     * @throws CursorIndexOutOfBoundsException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.122 -0500", hash_original_method = "D69CAFAFBC9C61DD3802AD1DC7C32FD3", hash_generated_method = "2DCD26533070C1021199E03F1B2034EB")
    
protected void checkPosition() {
        if (-1 == mPos || getCount() == mPos) {
            throw new CursorIndexOutOfBoundsException(mPos, getCount());
        }
    }
    
    protected static class SelfContentObserver extends ContentObserver {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.127 -0500", hash_original_field = "703A671C4ACC07BD23149F0A5FD18BB7", hash_generated_field = "703A671C4ACC07BD23149F0A5FD18BB7")

        WeakReference<AbstractCursor> mCursor;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.131 -0500", hash_original_method = "F9E51D895511CEE60B782983BAF87140", hash_generated_method = "60B3FE5B04D29CC3F7FB0AFCC5335434")
        
public SelfContentObserver(AbstractCursor cursor) {
            super(null);
            mCursor = new WeakReference<AbstractCursor>(cursor);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.133 -0500", hash_original_method = "A5B2D8696143266ED24B145CF029F206", hash_generated_method = "8F6E1C6D28F6496F2D75E93CC19BBECB")
        
@Override
        public boolean deliverSelfNotifications() {
            return false;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.136 -0500", hash_original_method = "DA6E4383047955D7231484890E1F062B", hash_generated_method = "86BBA883FA222386509FC693307BACE7")
        
@Override
        public void onChange(boolean selfChange) {
            AbstractCursor cursor = mCursor.get();
            if (cursor != null) {
                cursor.onChange(false);
            }
        }
        
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.124 -0500", hash_original_method = "F26D041066C4F03E188153BABFEE500A", hash_generated_method = "B4A7453FF0BF5575568A8D38A84AF984")
    
@Override
    protected void finalize() {
        if (mSelfObserver != null && mSelfObserverRegistered == true) {
            mContentResolver.unregisterContentObserver(mSelfObserver);
        }
    }
}

