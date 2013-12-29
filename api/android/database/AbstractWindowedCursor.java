package android.database;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;





public abstract class AbstractWindowedCursor extends AbstractCursor {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:03.178 -0500", hash_original_field = "93AE6FA4C4A8276F74A13C6549F253EE", hash_generated_field = "12D5C423EDB86BC0F7511811E7121A5B")

    protected CursorWindow mWindow;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.426 -0400", hash_original_method = "45FA808929D52C3FF25B9987C9B4DFA0", hash_generated_method = "45FA808929D52C3FF25B9987C9B4DFA0")
    public AbstractWindowedCursor ()
    {
        //Synthesized constructor
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:03.179 -0500", hash_original_method = "87598253341A04422FF4D21C2BB371F4", hash_generated_method = "21FE6FECFF3DC1D03A016E10D2E7469B")
    @Override
public byte[] getBlob(int columnIndex) {
        checkPosition();
        return mWindow.getBlob(mPos, columnIndex);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:03.179 -0500", hash_original_method = "80DC04F99A2A57F6C5D41327EC1C50ED", hash_generated_method = "C992940AFCBA03006566656CC0E01999")
    @Override
public String getString(int columnIndex) {
        checkPosition();
        return mWindow.getString(mPos, columnIndex);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:03.180 -0500", hash_original_method = "7A0E01C330FD8C9E9BBB19344D3EAAEA", hash_generated_method = "E5FEC28FF3BEDEE05108BAC9759B7CE6")
    @Override
public void copyStringToBuffer(int columnIndex, CharArrayBuffer buffer) {
        checkPosition();
        mWindow.copyStringToBuffer(mPos, columnIndex, buffer);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:03.181 -0500", hash_original_method = "831E6CBBE62E24F365C378674B05306E", hash_generated_method = "AF601FC0748CE8BD8D2F6BB17BBCC91E")
    @Override
public short getShort(int columnIndex) {
        checkPosition();
        return mWindow.getShort(mPos, columnIndex);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:03.182 -0500", hash_original_method = "A77BC22B3B7D8AA9E2F50FAA1FFFE93C", hash_generated_method = "D9878E6509B31529282362BE1FFF8794")
    @Override
public int getInt(int columnIndex) {
        checkPosition();
        return mWindow.getInt(mPos, columnIndex);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:03.183 -0500", hash_original_method = "32AD2A447F72132C95E38AB4CD7276EC", hash_generated_method = "5C325188E6F256F8EE3948C10BDA5743")
    @Override
public long getLong(int columnIndex) {
        checkPosition();
        return mWindow.getLong(mPos, columnIndex);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:03.184 -0500", hash_original_method = "97A96E7B6D9585C7632D24C9ACC936B0", hash_generated_method = "0324D059EA65C756A5319EA17FA224C9")
    @Override
public float getFloat(int columnIndex) {
        checkPosition();
        return mWindow.getFloat(mPos, columnIndex);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:03.185 -0500", hash_original_method = "5EA94253BE97AB01CBE30DAF30AB624B", hash_generated_method = "C772109F3B2AEBA8C88E7AC2EB6A2C1B")
    @Override
public double getDouble(int columnIndex) {
        checkPosition();
        return mWindow.getDouble(mPos, columnIndex);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:03.185 -0500", hash_original_method = "6A9D95B36787857467112609FB3E833C", hash_generated_method = "0574AE2F88F1D2EA13B6EFC29DB13855")
    @Override
public boolean isNull(int columnIndex) {
        checkPosition();
        return mWindow.getType(mPos, columnIndex) == Cursor.FIELD_TYPE_NULL;
    }

    /**
     * @deprecated Use {@link #getType}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:03.186 -0500", hash_original_method = "8C706BE21B67BF56FAAF00C967A8C37B", hash_generated_method = "F611B0DE79DCC83E996B634F54232DB9")
    @Deprecated
public boolean isBlob(int columnIndex) {
        return getType(columnIndex) == Cursor.FIELD_TYPE_BLOB;
    }

    /**
     * @deprecated Use {@link #getType}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:03.187 -0500", hash_original_method = "BDCD863F6E874A96AC9E7E0E4D765E55", hash_generated_method = "47FACEE6283D192B5CDD208EAD46D72D")
    @Deprecated
public boolean isString(int columnIndex) {
        return getType(columnIndex) == Cursor.FIELD_TYPE_STRING;
    }

    /**
     * @deprecated Use {@link #getType}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:03.188 -0500", hash_original_method = "C215029524CB115AA1C1047DC544E060", hash_generated_method = "E133CBE01B278AE6DD081D8689C2BF20")
    @Deprecated
public boolean isLong(int columnIndex) {
        return getType(columnIndex) == Cursor.FIELD_TYPE_INTEGER;
    }

    /**
     * @deprecated Use {@link #getType}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:03.189 -0500", hash_original_method = "C5D9D79A9E5267D689CC2AB9EDF1D366", hash_generated_method = "7B01637EE64D20BBBAD0FE592AC7AE09")
    @Deprecated
public boolean isFloat(int columnIndex) {
        return getType(columnIndex) == Cursor.FIELD_TYPE_FLOAT;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:03.190 -0500", hash_original_method = "CEEA013C273D2B30A1533873F1614E01", hash_generated_method = "92C7A4CC93BCFF4C40C086DA167A8234")
    @Override
public int getType(int columnIndex) {
        checkPosition();
        return mWindow.getType(mPos, columnIndex);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:03.190 -0500", hash_original_method = "46B0DF4A07DF4EB7D2CA6A3ED3C216CA", hash_generated_method = "7506EB4944A9F11628C23E38E0D66C97")
    @Override
protected void checkPosition() {
        super.checkPosition();
        
        if (mWindow == null) {
            throw new StaleDataException("Attempting to access a closed CursorWindow." +
                    "Most probable cause: cursor is deactivated prior to calling this method.");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:03.192 -0500", hash_original_method = "1266B4A96CD75271FEBF68638404515E", hash_generated_method = "DA83358F960B5A246BB2A379BDDBCF42")
    @Override
public CursorWindow getWindow() {
        return mWindow;
    }

    /**
     * Sets a new cursor window for the cursor to use.
     * <p>
     * The cursor takes ownership of the provided cursor window; the cursor window
     * will be closed when the cursor is closed or when the cursor adopts a new
     * cursor window.
     * </p><p>
     * If the cursor previously had a cursor window, then it is closed when the
     * new cursor window is assigned.
     * </p>
     *
     * @param window The new cursor window, typically a remote cursor window.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:03.192 -0500", hash_original_method = "EEBD6C49E5EC72817DC3243A2E7FCB7D", hash_generated_method = "E797CD5417CCFF8FE58219DEF59E2004")
    public void setWindow(CursorWindow window) {
        if (window != mWindow) {
            closeWindow();
            mWindow = window;
        }
    }

    /**
     * Returns true if the cursor has an associated cursor window.
     *
     * @return True if the cursor has an associated cursor window.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:03.193 -0500", hash_original_method = "CE7634279B030B3367B24B82DE682EB0", hash_generated_method = "E794DC69B772C88CA8008EEA960D60CF")
    public boolean hasWindow() {
        return mWindow != null;
    }

    /**
     * Closes the cursor window and sets {@link #mWindow} to null.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:03.194 -0500", hash_original_method = "53135D68273D9C60BFA0802F12D5EFAC", hash_generated_method = "1C5148BDAA864CB3B2BDCA42A67A1D20")
    protected void closeWindow() {
        if (mWindow != null) {
            mWindow.close();
            mWindow = null;
        }
    }

    /**
     * If there is a window, clear it.
     * Otherwise, creates a new window.
     *
     * @param name The window name.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:03.195 -0500", hash_original_method = "5B67F8BB651F008F63750FC6E33E54E8", hash_generated_method = "2C3C30068D027B23EB056019115F81F5")
    protected void clearOrCreateWindow(String name) {
        if (mWindow == null) {
            mWindow = new CursorWindow(name);
        } else {
            mWindow.clear();
        }
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:03.195 -0500", hash_original_method = "C8847040621704A6986D97364F312269", hash_generated_method = "0DEC5A96AFCC34287D6335068F718116")
    @Override
protected void onDeactivateOrClose() {
        super.onDeactivateOrClose();
        closeWindow();
    }

    
}

