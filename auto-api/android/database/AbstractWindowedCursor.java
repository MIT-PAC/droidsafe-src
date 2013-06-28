package android.database;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class AbstractWindowedCursor extends AbstractCursor {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.558 -0400", hash_original_field = "F4214BE1FFE044F8CA79EEDDDED72016", hash_generated_field = "12D5C423EDB86BC0F7511811E7121A5B")

    protected CursorWindow mWindow;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.558 -0400", hash_original_method = "45FA808929D52C3FF25B9987C9B4DFA0", hash_generated_method = "45FA808929D52C3FF25B9987C9B4DFA0")
    public AbstractWindowedCursor ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.559 -0400", hash_original_method = "87598253341A04422FF4D21C2BB371F4", hash_generated_method = "C1C2AACDFF232F7928D7F2115BC63E35")
    @Override
    public byte[] getBlob(int columnIndex) {
        checkPosition();
        byte[] var39FD5C6F5EEE292DAA371D30702452CA_1171129504 = (mWindow.getBlob(mPos, columnIndex));
        addTaint(columnIndex);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1480735828 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1480735828;
        // ---------- Original Method ----------
        //checkPosition();
        //return mWindow.getBlob(mPos, columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.560 -0400", hash_original_method = "80DC04F99A2A57F6C5D41327EC1C50ED", hash_generated_method = "41D60BCE1951893034653DFFFA08D066")
    @Override
    public String getString(int columnIndex) {
        String varB4EAC82CA7396A68D541C85D26508E83_1272283939 = null; //Variable for return #1
        checkPosition();
        varB4EAC82CA7396A68D541C85D26508E83_1272283939 = mWindow.getString(mPos, columnIndex);
        addTaint(columnIndex);
        varB4EAC82CA7396A68D541C85D26508E83_1272283939.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1272283939;
        // ---------- Original Method ----------
        //checkPosition();
        //return mWindow.getString(mPos, columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.560 -0400", hash_original_method = "7A0E01C330FD8C9E9BBB19344D3EAAEA", hash_generated_method = "F2BD4BCD04B5CC1BAE5B1AB3FBD50B16")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.561 -0400", hash_original_method = "831E6CBBE62E24F365C378674B05306E", hash_generated_method = "A38949BDFF0A629E74E1BB633541D263")
    @Override
    public short getShort(int columnIndex) {
        checkPosition();
        short var33D291ABA4A9FF3F3B0A08FA7044AC09_584150902 = (mWindow.getShort(mPos, columnIndex));
        addTaint(columnIndex);
        short var4F09DAA9D95BCB166A302407A0E0BABE_435916763 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_435916763;
        // ---------- Original Method ----------
        //checkPosition();
        //return mWindow.getShort(mPos, columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.561 -0400", hash_original_method = "A77BC22B3B7D8AA9E2F50FAA1FFFE93C", hash_generated_method = "9F7D51BE307CCBC59032B93CCB64CA27")
    @Override
    public int getInt(int columnIndex) {
        checkPosition();
        int varBF0BF538CDEEB1D98B0D0E7C018BDC71_1155987565 = (mWindow.getInt(mPos, columnIndex));
        addTaint(columnIndex);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_396162477 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_396162477;
        // ---------- Original Method ----------
        //checkPosition();
        //return mWindow.getInt(mPos, columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.561 -0400", hash_original_method = "32AD2A447F72132C95E38AB4CD7276EC", hash_generated_method = "DA03A101D5B18F12FD8E5C6DD7526944")
    @Override
    public long getLong(int columnIndex) {
        checkPosition();
        long varFA2C7C48C4088D541253B207931A64FB_1733885925 = (mWindow.getLong(mPos, columnIndex));
        addTaint(columnIndex);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1440821656 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1440821656;
        // ---------- Original Method ----------
        //checkPosition();
        //return mWindow.getLong(mPos, columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.562 -0400", hash_original_method = "97A96E7B6D9585C7632D24C9ACC936B0", hash_generated_method = "50BC4A7545D4369B2F5C3C6C338C4315")
    @Override
    public float getFloat(int columnIndex) {
        checkPosition();
        float varB8D197C8B9C000D5F71776D01520E3DC_1876218310 = (mWindow.getFloat(mPos, columnIndex));
        addTaint(columnIndex);
        float var546ADE640B6EDFBC8A086EF31347E768_1130024390 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1130024390;
        // ---------- Original Method ----------
        //checkPosition();
        //return mWindow.getFloat(mPos, columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.562 -0400", hash_original_method = "5EA94253BE97AB01CBE30DAF30AB624B", hash_generated_method = "D9A9F05EE49AAE455B3261AE8D028D97")
    @Override
    public double getDouble(int columnIndex) {
        checkPosition();
        double var07BF2FFD7FAADC555D8393932B080255_2029986402 = (mWindow.getDouble(mPos, columnIndex));
        addTaint(columnIndex);
        double varE8CD7DA078A86726031AD64F35F5A6C0_1786944396 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1786944396;
        // ---------- Original Method ----------
        //checkPosition();
        //return mWindow.getDouble(mPos, columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.563 -0400", hash_original_method = "6A9D95B36787857467112609FB3E833C", hash_generated_method = "0E1D785D75553F2CE47574A5CEDD0B02")
    @Override
    public boolean isNull(int columnIndex) {
        checkPosition();
        boolean var8ECA20BFB733E435005F16959D7BD187_1514145809 = (mWindow.getType(mPos, columnIndex) == Cursor.FIELD_TYPE_NULL);
        addTaint(columnIndex);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1062148149 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1062148149;
        // ---------- Original Method ----------
        //checkPosition();
        //return mWindow.getType(mPos, columnIndex) == Cursor.FIELD_TYPE_NULL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.563 -0400", hash_original_method = "8C706BE21B67BF56FAAF00C967A8C37B", hash_generated_method = "1AA61EFEB5721860ADF3CDDBEE2D84F3")
    @Deprecated
    public boolean isBlob(int columnIndex) {
        boolean varF7680A757356092A9E6DEAF98C515184_1019185523 = (getType(columnIndex) == Cursor.FIELD_TYPE_BLOB);
        addTaint(columnIndex);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1783124476 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1783124476;
        // ---------- Original Method ----------
        //return getType(columnIndex) == Cursor.FIELD_TYPE_BLOB;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.564 -0400", hash_original_method = "BDCD863F6E874A96AC9E7E0E4D765E55", hash_generated_method = "FD69930035B9391DA14457570C89E6F0")
    @Deprecated
    public boolean isString(int columnIndex) {
        boolean var8B4BEEBC34AE9EB53A790B71F8A585F6_1226284335 = (getType(columnIndex) == Cursor.FIELD_TYPE_STRING);
        addTaint(columnIndex);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_314975395 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_314975395;
        // ---------- Original Method ----------
        //return getType(columnIndex) == Cursor.FIELD_TYPE_STRING;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.564 -0400", hash_original_method = "C215029524CB115AA1C1047DC544E060", hash_generated_method = "BF867FEEC4F9CFB593124409AD8BD33D")
    @Deprecated
    public boolean isLong(int columnIndex) {
        boolean var28EDD7C01277563172CDB5F1313EBEF5_75437034 = (getType(columnIndex) == Cursor.FIELD_TYPE_INTEGER);
        addTaint(columnIndex);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_430847565 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_430847565;
        // ---------- Original Method ----------
        //return getType(columnIndex) == Cursor.FIELD_TYPE_INTEGER;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.564 -0400", hash_original_method = "C5D9D79A9E5267D689CC2AB9EDF1D366", hash_generated_method = "50CDEDCDD90A4184631686595975EA1F")
    @Deprecated
    public boolean isFloat(int columnIndex) {
        boolean var76AADF030CE2B68747D5053865BB78CB_249331254 = (getType(columnIndex) == Cursor.FIELD_TYPE_FLOAT);
        addTaint(columnIndex);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_540318089 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_540318089;
        // ---------- Original Method ----------
        //return getType(columnIndex) == Cursor.FIELD_TYPE_FLOAT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.565 -0400", hash_original_method = "CEEA013C273D2B30A1533873F1614E01", hash_generated_method = "8DE92744E95C4D8FD32B2889BAF8762C")
    @Override
    public int getType(int columnIndex) {
        checkPosition();
        int var926F08F366F078B1AC685748290DCC25_1793422937 = (mWindow.getType(mPos, columnIndex));
        addTaint(columnIndex);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_208461574 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_208461574;
        // ---------- Original Method ----------
        //checkPosition();
        //return mWindow.getType(mPos, columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.566 -0400", hash_original_method = "46B0DF4A07DF4EB7D2CA6A3ED3C216CA", hash_generated_method = "58764678C2B3816DC53D87F7D957FF78")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.567 -0400", hash_original_method = "1266B4A96CD75271FEBF68638404515E", hash_generated_method = "251B3A263CF13A51CA5FF69351AF0B00")
    @Override
    public CursorWindow getWindow() {
        CursorWindow varB4EAC82CA7396A68D541C85D26508E83_2102947717 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2102947717 = mWindow;
        varB4EAC82CA7396A68D541C85D26508E83_2102947717.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2102947717;
        // ---------- Original Method ----------
        //return mWindow;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.567 -0400", hash_original_method = "EEBD6C49E5EC72817DC3243A2E7FCB7D", hash_generated_method = "07B4E89DFA79D1362BD838457DA42649")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.569 -0400", hash_original_method = "CE7634279B030B3367B24B82DE682EB0", hash_generated_method = "124113338C3EEC45943525C7B5EA8F3D")
    public boolean hasWindow() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_962778252 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_962778252;
        // ---------- Original Method ----------
        //return mWindow != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.569 -0400", hash_original_method = "53135D68273D9C60BFA0802F12D5EFAC", hash_generated_method = "EF65761FAAC84B0E50AC8B689921A05C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.570 -0400", hash_original_method = "5B67F8BB651F008F63750FC6E33E54E8", hash_generated_method = "5BCF8A027B1171361D9BD17E476D782F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.570 -0400", hash_original_method = "C8847040621704A6986D97364F312269", hash_generated_method = "6CD575C7E400F361AFC0582D59EEEF79")
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

