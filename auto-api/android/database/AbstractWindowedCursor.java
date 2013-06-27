package android.database;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class AbstractWindowedCursor extends AbstractCursor {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.655 -0400", hash_original_field = "F4214BE1FFE044F8CA79EEDDDED72016", hash_generated_field = "12D5C423EDB86BC0F7511811E7121A5B")

    protected CursorWindow mWindow;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.656 -0400", hash_original_method = "45FA808929D52C3FF25B9987C9B4DFA0", hash_generated_method = "45FA808929D52C3FF25B9987C9B4DFA0")
    public AbstractWindowedCursor ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.656 -0400", hash_original_method = "87598253341A04422FF4D21C2BB371F4", hash_generated_method = "7AD9BD62C276C835AE873886955D7699")
    @Override
    public byte[] getBlob(int columnIndex) {
        checkPosition();
        byte[] var39FD5C6F5EEE292DAA371D30702452CA_1187637248 = (mWindow.getBlob(mPos, columnIndex));
        addTaint(columnIndex);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_2106821060 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_2106821060;
        // ---------- Original Method ----------
        //checkPosition();
        //return mWindow.getBlob(mPos, columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.662 -0400", hash_original_method = "80DC04F99A2A57F6C5D41327EC1C50ED", hash_generated_method = "E586A1D68F98A21A3FB9D2C664E313D4")
    @Override
    public String getString(int columnIndex) {
        String varB4EAC82CA7396A68D541C85D26508E83_838394443 = null; //Variable for return #1
        checkPosition();
        varB4EAC82CA7396A68D541C85D26508E83_838394443 = mWindow.getString(mPos, columnIndex);
        addTaint(columnIndex);
        varB4EAC82CA7396A68D541C85D26508E83_838394443.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_838394443;
        // ---------- Original Method ----------
        //checkPosition();
        //return mWindow.getString(mPos, columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.663 -0400", hash_original_method = "7A0E01C330FD8C9E9BBB19344D3EAAEA", hash_generated_method = "F2BD4BCD04B5CC1BAE5B1AB3FBD50B16")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.679 -0400", hash_original_method = "831E6CBBE62E24F365C378674B05306E", hash_generated_method = "3229CBEF5CFA9F8889AE32420239A5E0")
    @Override
    public short getShort(int columnIndex) {
        checkPosition();
        short var33D291ABA4A9FF3F3B0A08FA7044AC09_1932468398 = (mWindow.getShort(mPos, columnIndex));
        addTaint(columnIndex);
        short var4F09DAA9D95BCB166A302407A0E0BABE_1429302568 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1429302568;
        // ---------- Original Method ----------
        //checkPosition();
        //return mWindow.getShort(mPos, columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.680 -0400", hash_original_method = "A77BC22B3B7D8AA9E2F50FAA1FFFE93C", hash_generated_method = "DF6A1E94DD99643EB7B1A1A7BFAE71C9")
    @Override
    public int getInt(int columnIndex) {
        checkPosition();
        int varBF0BF538CDEEB1D98B0D0E7C018BDC71_1990415734 = (mWindow.getInt(mPos, columnIndex));
        addTaint(columnIndex);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1893457720 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1893457720;
        // ---------- Original Method ----------
        //checkPosition();
        //return mWindow.getInt(mPos, columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.681 -0400", hash_original_method = "32AD2A447F72132C95E38AB4CD7276EC", hash_generated_method = "DD3103762C764A35991C4220AF59F315")
    @Override
    public long getLong(int columnIndex) {
        checkPosition();
        long varFA2C7C48C4088D541253B207931A64FB_1023590348 = (mWindow.getLong(mPos, columnIndex));
        addTaint(columnIndex);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1580365200 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1580365200;
        // ---------- Original Method ----------
        //checkPosition();
        //return mWindow.getLong(mPos, columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.682 -0400", hash_original_method = "97A96E7B6D9585C7632D24C9ACC936B0", hash_generated_method = "4C386117A4753AB7C77E16D9B830DFAC")
    @Override
    public float getFloat(int columnIndex) {
        checkPosition();
        float varB8D197C8B9C000D5F71776D01520E3DC_1136531318 = (mWindow.getFloat(mPos, columnIndex));
        addTaint(columnIndex);
        float var546ADE640B6EDFBC8A086EF31347E768_597418127 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_597418127;
        // ---------- Original Method ----------
        //checkPosition();
        //return mWindow.getFloat(mPos, columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.730 -0400", hash_original_method = "5EA94253BE97AB01CBE30DAF30AB624B", hash_generated_method = "311E39FE76127708A306FE59D91D25D2")
    @Override
    public double getDouble(int columnIndex) {
        checkPosition();
        double var07BF2FFD7FAADC555D8393932B080255_133595837 = (mWindow.getDouble(mPos, columnIndex));
        addTaint(columnIndex);
        double varE8CD7DA078A86726031AD64F35F5A6C0_631397670 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_631397670;
        // ---------- Original Method ----------
        //checkPosition();
        //return mWindow.getDouble(mPos, columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.732 -0400", hash_original_method = "6A9D95B36787857467112609FB3E833C", hash_generated_method = "F73E043FE205C94191B6F1B32BF3D79C")
    @Override
    public boolean isNull(int columnIndex) {
        checkPosition();
        boolean var8ECA20BFB733E435005F16959D7BD187_1968985397 = (mWindow.getType(mPos, columnIndex) == Cursor.FIELD_TYPE_NULL);
        addTaint(columnIndex);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_495137949 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_495137949;
        // ---------- Original Method ----------
        //checkPosition();
        //return mWindow.getType(mPos, columnIndex) == Cursor.FIELD_TYPE_NULL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.732 -0400", hash_original_method = "8C706BE21B67BF56FAAF00C967A8C37B", hash_generated_method = "6B2AC13F2432BF2C1E7F12568E1ADB08")
    @Deprecated
    public boolean isBlob(int columnIndex) {
        boolean varF7680A757356092A9E6DEAF98C515184_159373705 = (getType(columnIndex) == Cursor.FIELD_TYPE_BLOB);
        addTaint(columnIndex);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1847202123 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1847202123;
        // ---------- Original Method ----------
        //return getType(columnIndex) == Cursor.FIELD_TYPE_BLOB;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.733 -0400", hash_original_method = "BDCD863F6E874A96AC9E7E0E4D765E55", hash_generated_method = "D3E6A7380A1A06BA453E3BB6D482CEDC")
    @Deprecated
    public boolean isString(int columnIndex) {
        boolean var8B4BEEBC34AE9EB53A790B71F8A585F6_851423250 = (getType(columnIndex) == Cursor.FIELD_TYPE_STRING);
        addTaint(columnIndex);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2098944572 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2098944572;
        // ---------- Original Method ----------
        //return getType(columnIndex) == Cursor.FIELD_TYPE_STRING;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.733 -0400", hash_original_method = "C215029524CB115AA1C1047DC544E060", hash_generated_method = "A4B11379D3B12BE3A66725F655504617")
    @Deprecated
    public boolean isLong(int columnIndex) {
        boolean var28EDD7C01277563172CDB5F1313EBEF5_2023907064 = (getType(columnIndex) == Cursor.FIELD_TYPE_INTEGER);
        addTaint(columnIndex);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2083810715 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2083810715;
        // ---------- Original Method ----------
        //return getType(columnIndex) == Cursor.FIELD_TYPE_INTEGER;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.734 -0400", hash_original_method = "C5D9D79A9E5267D689CC2AB9EDF1D366", hash_generated_method = "A8893E28B605385BAE4B4AD20FF6BE98")
    @Deprecated
    public boolean isFloat(int columnIndex) {
        boolean var76AADF030CE2B68747D5053865BB78CB_2115134610 = (getType(columnIndex) == Cursor.FIELD_TYPE_FLOAT);
        addTaint(columnIndex);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_25923862 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_25923862;
        // ---------- Original Method ----------
        //return getType(columnIndex) == Cursor.FIELD_TYPE_FLOAT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.735 -0400", hash_original_method = "CEEA013C273D2B30A1533873F1614E01", hash_generated_method = "48EF3410C8005214FDE75F8378C6AC7A")
    @Override
    public int getType(int columnIndex) {
        checkPosition();
        int var926F08F366F078B1AC685748290DCC25_1286253455 = (mWindow.getType(mPos, columnIndex));
        addTaint(columnIndex);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1907170890 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1907170890;
        // ---------- Original Method ----------
        //checkPosition();
        //return mWindow.getType(mPos, columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.735 -0400", hash_original_method = "46B0DF4A07DF4EB7D2CA6A3ED3C216CA", hash_generated_method = "58764678C2B3816DC53D87F7D957FF78")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.740 -0400", hash_original_method = "1266B4A96CD75271FEBF68638404515E", hash_generated_method = "68C6C0E63B8B82F392361479B1AE2403")
    @Override
    public CursorWindow getWindow() {
        CursorWindow varB4EAC82CA7396A68D541C85D26508E83_35474322 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_35474322 = mWindow;
        varB4EAC82CA7396A68D541C85D26508E83_35474322.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_35474322;
        // ---------- Original Method ----------
        //return mWindow;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.740 -0400", hash_original_method = "EEBD6C49E5EC72817DC3243A2E7FCB7D", hash_generated_method = "07B4E89DFA79D1362BD838457DA42649")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.760 -0400", hash_original_method = "CE7634279B030B3367B24B82DE682EB0", hash_generated_method = "1781D5B095DFCE15452C19F7D746CD4C")
    public boolean hasWindow() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_866469367 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_866469367;
        // ---------- Original Method ----------
        //return mWindow != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.761 -0400", hash_original_method = "53135D68273D9C60BFA0802F12D5EFAC", hash_generated_method = "EF65761FAAC84B0E50AC8B689921A05C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.771 -0400", hash_original_method = "5B67F8BB651F008F63750FC6E33E54E8", hash_generated_method = "5BCF8A027B1171361D9BD17E476D782F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.772 -0400", hash_original_method = "C8847040621704A6986D97364F312269", hash_generated_method = "6CD575C7E400F361AFC0582D59EEEF79")
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

