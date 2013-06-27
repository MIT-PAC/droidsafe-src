package android.database;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class AbstractWindowedCursor extends AbstractCursor {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.426 -0400", hash_original_field = "F4214BE1FFE044F8CA79EEDDDED72016", hash_generated_field = "12D5C423EDB86BC0F7511811E7121A5B")

    protected CursorWindow mWindow;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.426 -0400", hash_original_method = "45FA808929D52C3FF25B9987C9B4DFA0", hash_generated_method = "45FA808929D52C3FF25B9987C9B4DFA0")
    public AbstractWindowedCursor ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.440 -0400", hash_original_method = "87598253341A04422FF4D21C2BB371F4", hash_generated_method = "6367B337A3151CE937445156846FE231")
    @Override
    public byte[] getBlob(int columnIndex) {
        checkPosition();
        byte[] var39FD5C6F5EEE292DAA371D30702452CA_1944499210 = (mWindow.getBlob(mPos, columnIndex));
        addTaint(columnIndex);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_63444765 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_63444765;
        // ---------- Original Method ----------
        //checkPosition();
        //return mWindow.getBlob(mPos, columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.442 -0400", hash_original_method = "80DC04F99A2A57F6C5D41327EC1C50ED", hash_generated_method = "6C46FE0D5D88C6844783C3CDE406450A")
    @Override
    public String getString(int columnIndex) {
        String varB4EAC82CA7396A68D541C85D26508E83_1694518849 = null; //Variable for return #1
        checkPosition();
        varB4EAC82CA7396A68D541C85D26508E83_1694518849 = mWindow.getString(mPos, columnIndex);
        addTaint(columnIndex);
        varB4EAC82CA7396A68D541C85D26508E83_1694518849.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1694518849;
        // ---------- Original Method ----------
        //checkPosition();
        //return mWindow.getString(mPos, columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.455 -0400", hash_original_method = "7A0E01C330FD8C9E9BBB19344D3EAAEA", hash_generated_method = "F2BD4BCD04B5CC1BAE5B1AB3FBD50B16")
    @Override
    public void copyStringToBuffer(int columnIndex, CharArrayBuffer buffer) {
        checkPosition();
        mWindow.copyStringToBuffer(mPos, columnIndex, buffer);
        addTaint(columnIndex);
        addTaint(buffer.getTaint());
        // ---------- Original Method ----------
        //checkPosition();
        //mWindow.copyStringToBuffer(mPos, columnIndex, buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.457 -0400", hash_original_method = "831E6CBBE62E24F365C378674B05306E", hash_generated_method = "B7D5DA44C74DF3C731FE627ADD868F8A")
    @Override
    public short getShort(int columnIndex) {
        checkPosition();
        short var33D291ABA4A9FF3F3B0A08FA7044AC09_509988942 = (mWindow.getShort(mPos, columnIndex));
        addTaint(columnIndex);
        short var4F09DAA9D95BCB166A302407A0E0BABE_1668732372 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1668732372;
        // ---------- Original Method ----------
        //checkPosition();
        //return mWindow.getShort(mPos, columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.458 -0400", hash_original_method = "A77BC22B3B7D8AA9E2F50FAA1FFFE93C", hash_generated_method = "ACF35F48A6EC3F35FC85B95FC6ECD509")
    @Override
    public int getInt(int columnIndex) {
        checkPosition();
        int varBF0BF538CDEEB1D98B0D0E7C018BDC71_2091228380 = (mWindow.getInt(mPos, columnIndex));
        addTaint(columnIndex);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1822129824 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1822129824;
        // ---------- Original Method ----------
        //checkPosition();
        //return mWindow.getInt(mPos, columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.459 -0400", hash_original_method = "32AD2A447F72132C95E38AB4CD7276EC", hash_generated_method = "2475D86084392239C1E7C50AF0129739")
    @Override
    public long getLong(int columnIndex) {
        checkPosition();
        long varFA2C7C48C4088D541253B207931A64FB_433024670 = (mWindow.getLong(mPos, columnIndex));
        addTaint(columnIndex);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1802943139 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1802943139;
        // ---------- Original Method ----------
        //checkPosition();
        //return mWindow.getLong(mPos, columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.485 -0400", hash_original_method = "97A96E7B6D9585C7632D24C9ACC936B0", hash_generated_method = "E692A7241571743BA9B6419E845D415F")
    @Override
    public float getFloat(int columnIndex) {
        checkPosition();
        float varB8D197C8B9C000D5F71776D01520E3DC_713929555 = (mWindow.getFloat(mPos, columnIndex));
        addTaint(columnIndex);
        float var546ADE640B6EDFBC8A086EF31347E768_283668264 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_283668264;
        // ---------- Original Method ----------
        //checkPosition();
        //return mWindow.getFloat(mPos, columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.486 -0400", hash_original_method = "5EA94253BE97AB01CBE30DAF30AB624B", hash_generated_method = "23BA2C7F99DA8AE410859463F4AFB24F")
    @Override
    public double getDouble(int columnIndex) {
        checkPosition();
        double var07BF2FFD7FAADC555D8393932B080255_201569497 = (mWindow.getDouble(mPos, columnIndex));
        addTaint(columnIndex);
        double varE8CD7DA078A86726031AD64F35F5A6C0_618334735 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_618334735;
        // ---------- Original Method ----------
        //checkPosition();
        //return mWindow.getDouble(mPos, columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.490 -0400", hash_original_method = "6A9D95B36787857467112609FB3E833C", hash_generated_method = "057F9168ABA37E809D9713DCABC2AF57")
    @Override
    public boolean isNull(int columnIndex) {
        checkPosition();
        boolean var8ECA20BFB733E435005F16959D7BD187_1821754006 = (mWindow.getType(mPos, columnIndex) == Cursor.FIELD_TYPE_NULL);
        addTaint(columnIndex);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1758913258 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1758913258;
        // ---------- Original Method ----------
        //checkPosition();
        //return mWindow.getType(mPos, columnIndex) == Cursor.FIELD_TYPE_NULL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.490 -0400", hash_original_method = "8C706BE21B67BF56FAAF00C967A8C37B", hash_generated_method = "966E5353559DB44ED9E142304E05ABA9")
    @Deprecated
    public boolean isBlob(int columnIndex) {
        boolean varF7680A757356092A9E6DEAF98C515184_495154737 = (getType(columnIndex) == Cursor.FIELD_TYPE_BLOB);
        addTaint(columnIndex);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1463198988 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1463198988;
        // ---------- Original Method ----------
        //return getType(columnIndex) == Cursor.FIELD_TYPE_BLOB;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.491 -0400", hash_original_method = "BDCD863F6E874A96AC9E7E0E4D765E55", hash_generated_method = "F920DB373B632709B93E30A464AA6DDB")
    @Deprecated
    public boolean isString(int columnIndex) {
        boolean var8B4BEEBC34AE9EB53A790B71F8A585F6_1574160927 = (getType(columnIndex) == Cursor.FIELD_TYPE_STRING);
        addTaint(columnIndex);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_872787743 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_872787743;
        // ---------- Original Method ----------
        //return getType(columnIndex) == Cursor.FIELD_TYPE_STRING;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.494 -0400", hash_original_method = "C215029524CB115AA1C1047DC544E060", hash_generated_method = "FCE8C856DFD2653AADEB7AC852C4ABD6")
    @Deprecated
    public boolean isLong(int columnIndex) {
        boolean var28EDD7C01277563172CDB5F1313EBEF5_525575529 = (getType(columnIndex) == Cursor.FIELD_TYPE_INTEGER);
        addTaint(columnIndex);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_844682387 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_844682387;
        // ---------- Original Method ----------
        //return getType(columnIndex) == Cursor.FIELD_TYPE_INTEGER;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.508 -0400", hash_original_method = "C5D9D79A9E5267D689CC2AB9EDF1D366", hash_generated_method = "4AA852847EDF7CAE6831170A9B18471A")
    @Deprecated
    public boolean isFloat(int columnIndex) {
        boolean var76AADF030CE2B68747D5053865BB78CB_1733433218 = (getType(columnIndex) == Cursor.FIELD_TYPE_FLOAT);
        addTaint(columnIndex);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_330110981 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_330110981;
        // ---------- Original Method ----------
        //return getType(columnIndex) == Cursor.FIELD_TYPE_FLOAT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.509 -0400", hash_original_method = "CEEA013C273D2B30A1533873F1614E01", hash_generated_method = "FEE5544B62E358D37A2D0241339771CB")
    @Override
    public int getType(int columnIndex) {
        checkPosition();
        int var926F08F366F078B1AC685748290DCC25_783149469 = (mWindow.getType(mPos, columnIndex));
        addTaint(columnIndex);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_250669021 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_250669021;
        // ---------- Original Method ----------
        //checkPosition();
        //return mWindow.getType(mPos, columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.510 -0400", hash_original_method = "46B0DF4A07DF4EB7D2CA6A3ED3C216CA", hash_generated_method = "58764678C2B3816DC53D87F7D957FF78")
    @Override
    protected void checkPosition() {
        super.checkPosition();
        {
            if (DroidSafeAndroidRuntime.control) throw new StaleDataException("Attempting to access a closed CursorWindow." +
                    "Most probable cause: cursor is deactivated prior to calling this method.");
        } //End block
        // ---------- Original Method ----------
        //super.checkPosition();
        //if (mWindow == null) {
            //throw new StaleDataException("Attempting to access a closed CursorWindow." +
                    //"Most probable cause: cursor is deactivated prior to calling this method.");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.512 -0400", hash_original_method = "1266B4A96CD75271FEBF68638404515E", hash_generated_method = "D813C54DECC7027F3166C48BE1DC7C32")
    @Override
    public CursorWindow getWindow() {
        CursorWindow varB4EAC82CA7396A68D541C85D26508E83_1782444549 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1782444549 = mWindow;
        varB4EAC82CA7396A68D541C85D26508E83_1782444549.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1782444549;
        // ---------- Original Method ----------
        //return mWindow;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.539 -0400", hash_original_method = "EEBD6C49E5EC72817DC3243A2E7FCB7D", hash_generated_method = "07B4E89DFA79D1362BD838457DA42649")
    public void setWindow(CursorWindow window) {
        {
            closeWindow();
            mWindow = window;
        } //End block
        // ---------- Original Method ----------
        //if (window != mWindow) {
            //closeWindow();
            //mWindow = window;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.539 -0400", hash_original_method = "CE7634279B030B3367B24B82DE682EB0", hash_generated_method = "A10818AE3AD8ACB79B426071890A3751")
    public boolean hasWindow() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1315646360 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1315646360;
        // ---------- Original Method ----------
        //return mWindow != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.551 -0400", hash_original_method = "53135D68273D9C60BFA0802F12D5EFAC", hash_generated_method = "EF65761FAAC84B0E50AC8B689921A05C")
    protected void closeWindow() {
        {
            mWindow.close();
            mWindow = null;
        } //End block
        // ---------- Original Method ----------
        //if (mWindow != null) {
            //mWindow.close();
            //mWindow = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.552 -0400", hash_original_method = "5B67F8BB651F008F63750FC6E33E54E8", hash_generated_method = "5BCF8A027B1171361D9BD17E476D782F")
    protected void clearOrCreateWindow(String name) {
        {
            mWindow = new CursorWindow(name);
        } //End block
        {
            mWindow.clear();
        } //End block
        // ---------- Original Method ----------
        //if (mWindow == null) {
            //mWindow = new CursorWindow(name);
        //} else {
            //mWindow.clear();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.553 -0400", hash_original_method = "C8847040621704A6986D97364F312269", hash_generated_method = "6CD575C7E400F361AFC0582D59EEEF79")
    @Override
    protected void onDeactivateOrClose() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onDeactivateOrClose();
        closeWindow();
        // ---------- Original Method ----------
        //super.onDeactivateOrClose();
        //closeWindow();
    }

    
}

