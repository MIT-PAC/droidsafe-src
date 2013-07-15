package android.database;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public abstract class AbstractWindowedCursor extends AbstractCursor {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.913 -0400", hash_original_field = "F4214BE1FFE044F8CA79EEDDDED72016", hash_generated_field = "12D5C423EDB86BC0F7511811E7121A5B")

    protected CursorWindow mWindow;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.913 -0400", hash_original_method = "45FA808929D52C3FF25B9987C9B4DFA0", hash_generated_method = "45FA808929D52C3FF25B9987C9B4DFA0")
    public AbstractWindowedCursor ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.914 -0400", hash_original_method = "87598253341A04422FF4D21C2BB371F4", hash_generated_method = "49E2942D3D627D7AC3BFAD58C870695E")
    @Override
    public byte[] getBlob(int columnIndex) {
        addTaint(columnIndex);
        checkPosition();
        byte[] var9FD2B9A55B3FDEC958C8AB6027815BB5_1179400582 = (mWindow.getBlob(mPos, columnIndex));
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1178422835 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1178422835;
        // ---------- Original Method ----------
        //checkPosition();
        //return mWindow.getBlob(mPos, columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.916 -0400", hash_original_method = "80DC04F99A2A57F6C5D41327EC1C50ED", hash_generated_method = "64C6F85C17AA86CF4CD66B03C926ED71")
    @Override
    public String getString(int columnIndex) {
        addTaint(columnIndex);
        checkPosition();
String var40A8596F3179C0E714867EBE523A53EA_49173144 =         mWindow.getString(mPos, columnIndex);
        var40A8596F3179C0E714867EBE523A53EA_49173144.addTaint(taint);
        return var40A8596F3179C0E714867EBE523A53EA_49173144;
        // ---------- Original Method ----------
        //checkPosition();
        //return mWindow.getString(mPos, columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.917 -0400", hash_original_method = "7A0E01C330FD8C9E9BBB19344D3EAAEA", hash_generated_method = "775DB13C3E0A284894CEF26E0B2CDE76")
    @Override
    public void copyStringToBuffer(int columnIndex, CharArrayBuffer buffer) {
        addTaint(buffer.getTaint());
        addTaint(columnIndex);
        checkPosition();
        mWindow.copyStringToBuffer(mPos, columnIndex, buffer);
        // ---------- Original Method ----------
        //checkPosition();
        //mWindow.copyStringToBuffer(mPos, columnIndex, buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.917 -0400", hash_original_method = "831E6CBBE62E24F365C378674B05306E", hash_generated_method = "6035C0117638FBD448EAE3A9798D122F")
    @Override
    public short getShort(int columnIndex) {
        addTaint(columnIndex);
        checkPosition();
        short var3306429051E1A16869D45F516DC45653_1570553134 = (mWindow.getShort(mPos, columnIndex));
                short var4F09DAA9D95BCB166A302407A0E0BABE_1856437600 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1856437600;
        // ---------- Original Method ----------
        //checkPosition();
        //return mWindow.getShort(mPos, columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.918 -0400", hash_original_method = "A77BC22B3B7D8AA9E2F50FAA1FFFE93C", hash_generated_method = "67A994C6154007E44C60486FCF1B68B3")
    @Override
    public int getInt(int columnIndex) {
        addTaint(columnIndex);
        checkPosition();
        int varE21E2155C11C9B1871BF69B5C144000B_10581835 = (mWindow.getInt(mPos, columnIndex));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1629447832 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1629447832;
        // ---------- Original Method ----------
        //checkPosition();
        //return mWindow.getInt(mPos, columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.920 -0400", hash_original_method = "32AD2A447F72132C95E38AB4CD7276EC", hash_generated_method = "C459BBD7E014189E6560FCF456A78070")
    @Override
    public long getLong(int columnIndex) {
        addTaint(columnIndex);
        checkPosition();
        long var5AF4672D1A6A4DC06469C0A1800FCA1B_1202256416 = (mWindow.getLong(mPos, columnIndex));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_700811754 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_700811754;
        // ---------- Original Method ----------
        //checkPosition();
        //return mWindow.getLong(mPos, columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.921 -0400", hash_original_method = "97A96E7B6D9585C7632D24C9ACC936B0", hash_generated_method = "3250F56AB7A01486C684CB787569917C")
    @Override
    public float getFloat(int columnIndex) {
        addTaint(columnIndex);
        checkPosition();
        float var5404B8E23489FD4E89DEC36D2E49461D_2042463569 = (mWindow.getFloat(mPos, columnIndex));
                float var546ADE640B6EDFBC8A086EF31347E768_1929955424 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1929955424;
        // ---------- Original Method ----------
        //checkPosition();
        //return mWindow.getFloat(mPos, columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.922 -0400", hash_original_method = "5EA94253BE97AB01CBE30DAF30AB624B", hash_generated_method = "82B90BDDFD047C3237BFF60DD66C7D31")
    @Override
    public double getDouble(int columnIndex) {
        addTaint(columnIndex);
        checkPosition();
        double varA82C10BBC45A43EE148D106ADEF5DB67_539386094 = (mWindow.getDouble(mPos, columnIndex));
                double varE8CD7DA078A86726031AD64F35F5A6C0_1804893200 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1804893200;
        // ---------- Original Method ----------
        //checkPosition();
        //return mWindow.getDouble(mPos, columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.922 -0400", hash_original_method = "6A9D95B36787857467112609FB3E833C", hash_generated_method = "FF2FFAC02AABF90DC0130CF547ABB66A")
    @Override
    public boolean isNull(int columnIndex) {
        addTaint(columnIndex);
        checkPosition();
        boolean var14EEE1B35255300486FF56051C9F8187_1502739485 = (mWindow.getType(mPos, columnIndex) == Cursor.FIELD_TYPE_NULL);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1630781329 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1630781329;
        // ---------- Original Method ----------
        //checkPosition();
        //return mWindow.getType(mPos, columnIndex) == Cursor.FIELD_TYPE_NULL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.923 -0400", hash_original_method = "8C706BE21B67BF56FAAF00C967A8C37B", hash_generated_method = "58146641B526E07CF8B7065AFC703153")
    @Deprecated
    public boolean isBlob(int columnIndex) {
        addTaint(columnIndex);
        boolean var23CC87B5BACE008168EEE4FDA3187FEB_19065238 = (getType(columnIndex) == Cursor.FIELD_TYPE_BLOB);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1369090182 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1369090182;
        // ---------- Original Method ----------
        //return getType(columnIndex) == Cursor.FIELD_TYPE_BLOB;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.923 -0400", hash_original_method = "BDCD863F6E874A96AC9E7E0E4D765E55", hash_generated_method = "DAE90D2C9E99BF7759240C2D73FD0A80")
    @Deprecated
    public boolean isString(int columnIndex) {
        addTaint(columnIndex);
        boolean varF31CAFEC42A62120925122D9CD690071_1138949865 = (getType(columnIndex) == Cursor.FIELD_TYPE_STRING);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_386713540 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_386713540;
        // ---------- Original Method ----------
        //return getType(columnIndex) == Cursor.FIELD_TYPE_STRING;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.923 -0400", hash_original_method = "C215029524CB115AA1C1047DC544E060", hash_generated_method = "02E842E418C9EA0D662115EB01C40A33")
    @Deprecated
    public boolean isLong(int columnIndex) {
        addTaint(columnIndex);
        boolean varBB39C526DEC36DF73B64BDBDBCE5EB16_1337389418 = (getType(columnIndex) == Cursor.FIELD_TYPE_INTEGER);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_875853103 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_875853103;
        // ---------- Original Method ----------
        //return getType(columnIndex) == Cursor.FIELD_TYPE_INTEGER;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.924 -0400", hash_original_method = "C5D9D79A9E5267D689CC2AB9EDF1D366", hash_generated_method = "5E8B8D923F90ADB53405FC4FC4414E4A")
    @Deprecated
    public boolean isFloat(int columnIndex) {
        addTaint(columnIndex);
        boolean var53A154F70D90ADECA84F77DF03305194_1467861402 = (getType(columnIndex) == Cursor.FIELD_TYPE_FLOAT);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1697562224 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1697562224;
        // ---------- Original Method ----------
        //return getType(columnIndex) == Cursor.FIELD_TYPE_FLOAT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.924 -0400", hash_original_method = "CEEA013C273D2B30A1533873F1614E01", hash_generated_method = "A571548D2352DDC8243300BF0E534D01")
    @Override
    public int getType(int columnIndex) {
        addTaint(columnIndex);
        checkPosition();
        int varD2999FC5F8BA0280AFE4B53985F7ADDD_672960886 = (mWindow.getType(mPos, columnIndex));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1557606850 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1557606850;
        // ---------- Original Method ----------
        //checkPosition();
        //return mWindow.getType(mPos, columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.925 -0400", hash_original_method = "46B0DF4A07DF4EB7D2CA6A3ED3C216CA", hash_generated_method = "1E6157E78EAB0D9EEF5FF093771B46AF")
    @Override
    protected void checkPosition() {
        super.checkPosition();
    if(mWindow == null)        
        {
            StaleDataException var1C5A4A13B7788E921673AB6289B9A7A5_405056679 = new StaleDataException("Attempting to access a closed CursorWindow." +
                    "Most probable cause: cursor is deactivated prior to calling this method.");
            var1C5A4A13B7788E921673AB6289B9A7A5_405056679.addTaint(taint);
            throw var1C5A4A13B7788E921673AB6289B9A7A5_405056679;
        } //End block
        // ---------- Original Method ----------
        //super.checkPosition();
        //if (mWindow == null) {
            //throw new StaleDataException("Attempting to access a closed CursorWindow." +
                    //"Most probable cause: cursor is deactivated prior to calling this method.");
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.925 -0400", hash_original_method = "1266B4A96CD75271FEBF68638404515E", hash_generated_method = "9AEA790E6562D4B25672835461187558")
    @Override
    public CursorWindow getWindow() {
CursorWindow var125511BCCBD4CDF7BDF315F5AA8A1CE3_218997043 =         mWindow;
        var125511BCCBD4CDF7BDF315F5AA8A1CE3_218997043.addTaint(taint);
        return var125511BCCBD4CDF7BDF315F5AA8A1CE3_218997043;
        // ---------- Original Method ----------
        //return mWindow;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.926 -0400", hash_original_method = "EEBD6C49E5EC72817DC3243A2E7FCB7D", hash_generated_method = "C7E6D06D224C647CC6BCC3442181E2B0")
    public void setWindow(CursorWindow window) {
    if(window != mWindow)        
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.926 -0400", hash_original_method = "CE7634279B030B3367B24B82DE682EB0", hash_generated_method = "7767F3905CAD770048AA1A89484A3FDC")
    public boolean hasWindow() {
        boolean var0855AC450DF2010BCC62E60CEF96871E_1095282332 = (mWindow != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_425583798 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_425583798;
        // ---------- Original Method ----------
        //return mWindow != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.927 -0400", hash_original_method = "53135D68273D9C60BFA0802F12D5EFAC", hash_generated_method = "A02CDFF16FC796F08C7ECD03C0B558F5")
    protected void closeWindow() {
    if(mWindow != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.928 -0400", hash_original_method = "5B67F8BB651F008F63750FC6E33E54E8", hash_generated_method = "816A65FA914C2F24D019945062AC1401")
    protected void clearOrCreateWindow(String name) {
    if(mWindow == null)        
        {
            mWindow = new CursorWindow(name);
        } //End block
        else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.929 -0400", hash_original_method = "C8847040621704A6986D97364F312269", hash_generated_method = "6CD575C7E400F361AFC0582D59EEEF79")
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

