package android.database;

// Droidsafe Imports
import droidsafe.annotations.*;





public abstract class AbstractWindowedCursor extends AbstractCursor {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.426 -0400", hash_original_field = "F4214BE1FFE044F8CA79EEDDDED72016", hash_generated_field = "12D5C423EDB86BC0F7511811E7121A5B")

    protected CursorWindow mWindow;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.426 -0400", hash_original_method = "45FA808929D52C3FF25B9987C9B4DFA0", hash_generated_method = "45FA808929D52C3FF25B9987C9B4DFA0")
    public AbstractWindowedCursor ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.426 -0400", hash_original_method = "87598253341A04422FF4D21C2BB371F4", hash_generated_method = "BABC63D8328967FEFE5C7816E3C1913F")
    @Override
    public byte[] getBlob(int columnIndex) {
        addTaint(columnIndex);
        checkPosition();
        byte[] var9FD2B9A55B3FDEC958C8AB6027815BB5_1465289360 = (mWindow.getBlob(mPos, columnIndex));
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_2030687577 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_2030687577;
        // ---------- Original Method ----------
        //checkPosition();
        //return mWindow.getBlob(mPos, columnIndex);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.427 -0400", hash_original_method = "80DC04F99A2A57F6C5D41327EC1C50ED", hash_generated_method = "BB9CF57AE86E39B0F5074C6900D4C7A1")
    @Override
    public String getString(int columnIndex) {
        addTaint(columnIndex);
        checkPosition();
String var40A8596F3179C0E714867EBE523A53EA_1604783932 =         mWindow.getString(mPos, columnIndex);
        var40A8596F3179C0E714867EBE523A53EA_1604783932.addTaint(taint);
        return var40A8596F3179C0E714867EBE523A53EA_1604783932;
        // ---------- Original Method ----------
        //checkPosition();
        //return mWindow.getString(mPos, columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.427 -0400", hash_original_method = "7A0E01C330FD8C9E9BBB19344D3EAAEA", hash_generated_method = "775DB13C3E0A284894CEF26E0B2CDE76")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.428 -0400", hash_original_method = "831E6CBBE62E24F365C378674B05306E", hash_generated_method = "363B066BE3194B3DC0F4A7399D8F7B98")
    @Override
    public short getShort(int columnIndex) {
        addTaint(columnIndex);
        checkPosition();
        short var3306429051E1A16869D45F516DC45653_737357713 = (mWindow.getShort(mPos, columnIndex));
                short var4F09DAA9D95BCB166A302407A0E0BABE_514941043 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_514941043;
        // ---------- Original Method ----------
        //checkPosition();
        //return mWindow.getShort(mPos, columnIndex);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.428 -0400", hash_original_method = "A77BC22B3B7D8AA9E2F50FAA1FFFE93C", hash_generated_method = "1648E27C48A6A229C04C06D516644BA4")
    @Override
    public int getInt(int columnIndex) {
        addTaint(columnIndex);
        checkPosition();
        int varE21E2155C11C9B1871BF69B5C144000B_791616006 = (mWindow.getInt(mPos, columnIndex));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1767049236 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1767049236;
        // ---------- Original Method ----------
        //checkPosition();
        //return mWindow.getInt(mPos, columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.429 -0400", hash_original_method = "32AD2A447F72132C95E38AB4CD7276EC", hash_generated_method = "EA8C3CEF884875A76AFBFD16D758D15F")
    @Override
    public long getLong(int columnIndex) {
        addTaint(columnIndex);
        checkPosition();
        long var5AF4672D1A6A4DC06469C0A1800FCA1B_1611840697 = (mWindow.getLong(mPos, columnIndex));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1142857075 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1142857075;
        // ---------- Original Method ----------
        //checkPosition();
        //return mWindow.getLong(mPos, columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.429 -0400", hash_original_method = "97A96E7B6D9585C7632D24C9ACC936B0", hash_generated_method = "91898865853B783EBE7338458B486760")
    @Override
    public float getFloat(int columnIndex) {
        addTaint(columnIndex);
        checkPosition();
        float var5404B8E23489FD4E89DEC36D2E49461D_279559883 = (mWindow.getFloat(mPos, columnIndex));
                float var546ADE640B6EDFBC8A086EF31347E768_1256755684 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1256755684;
        // ---------- Original Method ----------
        //checkPosition();
        //return mWindow.getFloat(mPos, columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.430 -0400", hash_original_method = "5EA94253BE97AB01CBE30DAF30AB624B", hash_generated_method = "EACC3B96FED603223D4DBE45F10AD025")
    @Override
    public double getDouble(int columnIndex) {
        addTaint(columnIndex);
        checkPosition();
        double varA82C10BBC45A43EE148D106ADEF5DB67_1493677156 = (mWindow.getDouble(mPos, columnIndex));
                double varE8CD7DA078A86726031AD64F35F5A6C0_865938508 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_865938508;
        // ---------- Original Method ----------
        //checkPosition();
        //return mWindow.getDouble(mPos, columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.430 -0400", hash_original_method = "6A9D95B36787857467112609FB3E833C", hash_generated_method = "954A02AE74BBABD87D5BDA7BE21BA0BA")
    @Override
    public boolean isNull(int columnIndex) {
        addTaint(columnIndex);
        checkPosition();
        boolean var14EEE1B35255300486FF56051C9F8187_76359089 = (mWindow.getType(mPos, columnIndex) == Cursor.FIELD_TYPE_NULL);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1759877228 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1759877228;
        // ---------- Original Method ----------
        //checkPosition();
        //return mWindow.getType(mPos, columnIndex) == Cursor.FIELD_TYPE_NULL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.431 -0400", hash_original_method = "8C706BE21B67BF56FAAF00C967A8C37B", hash_generated_method = "C1683680DB51566D36DB12A8F14D2324")
    @Deprecated
    public boolean isBlob(int columnIndex) {
        addTaint(columnIndex);
        boolean var23CC87B5BACE008168EEE4FDA3187FEB_2060577405 = (getType(columnIndex) == Cursor.FIELD_TYPE_BLOB);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2025672851 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2025672851;
        // ---------- Original Method ----------
        //return getType(columnIndex) == Cursor.FIELD_TYPE_BLOB;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.432 -0400", hash_original_method = "BDCD863F6E874A96AC9E7E0E4D765E55", hash_generated_method = "C240BFF4C0CB53A63A8BA7E998E8140C")
    @Deprecated
    public boolean isString(int columnIndex) {
        addTaint(columnIndex);
        boolean varF31CAFEC42A62120925122D9CD690071_1913241872 = (getType(columnIndex) == Cursor.FIELD_TYPE_STRING);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_9954697 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_9954697;
        // ---------- Original Method ----------
        //return getType(columnIndex) == Cursor.FIELD_TYPE_STRING;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.432 -0400", hash_original_method = "C215029524CB115AA1C1047DC544E060", hash_generated_method = "2916120F8C7D00BAFFA68EFF3F313216")
    @Deprecated
    public boolean isLong(int columnIndex) {
        addTaint(columnIndex);
        boolean varBB39C526DEC36DF73B64BDBDBCE5EB16_2092067872 = (getType(columnIndex) == Cursor.FIELD_TYPE_INTEGER);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_314013734 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_314013734;
        // ---------- Original Method ----------
        //return getType(columnIndex) == Cursor.FIELD_TYPE_INTEGER;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.433 -0400", hash_original_method = "C5D9D79A9E5267D689CC2AB9EDF1D366", hash_generated_method = "A957596AF5FB33B5A518B71100D1ADEB")
    @Deprecated
    public boolean isFloat(int columnIndex) {
        addTaint(columnIndex);
        boolean var53A154F70D90ADECA84F77DF03305194_1195089309 = (getType(columnIndex) == Cursor.FIELD_TYPE_FLOAT);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2059015897 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2059015897;
        // ---------- Original Method ----------
        //return getType(columnIndex) == Cursor.FIELD_TYPE_FLOAT;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.433 -0400", hash_original_method = "CEEA013C273D2B30A1533873F1614E01", hash_generated_method = "493BF98C968F90F82CFCD770A5D75065")
    @Override
    public int getType(int columnIndex) {
        addTaint(columnIndex);
        checkPosition();
        int varD2999FC5F8BA0280AFE4B53985F7ADDD_1952966776 = (mWindow.getType(mPos, columnIndex));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1318033641 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1318033641;
        // ---------- Original Method ----------
        //checkPosition();
        //return mWindow.getType(mPos, columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.433 -0400", hash_original_method = "46B0DF4A07DF4EB7D2CA6A3ED3C216CA", hash_generated_method = "2692F206DEF989DE4513FFEADE352592")
    @Override
    protected void checkPosition() {
        super.checkPosition();
        if(mWindow == null)        
        {
            StaleDataException var1C5A4A13B7788E921673AB6289B9A7A5_1018320858 = new StaleDataException("Attempting to access a closed CursorWindow." +
                    "Most probable cause: cursor is deactivated prior to calling this method.");
            var1C5A4A13B7788E921673AB6289B9A7A5_1018320858.addTaint(taint);
            throw var1C5A4A13B7788E921673AB6289B9A7A5_1018320858;
        } //End block
        // ---------- Original Method ----------
        //super.checkPosition();
        //if (mWindow == null) {
            //throw new StaleDataException("Attempting to access a closed CursorWindow." +
                    //"Most probable cause: cursor is deactivated prior to calling this method.");
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.434 -0400", hash_original_method = "1266B4A96CD75271FEBF68638404515E", hash_generated_method = "3E80459423F0CE5379DD76931D2C08C1")
    @Override
    public CursorWindow getWindow() {
CursorWindow var125511BCCBD4CDF7BDF315F5AA8A1CE3_1302098756 =         mWindow;
        var125511BCCBD4CDF7BDF315F5AA8A1CE3_1302098756.addTaint(taint);
        return var125511BCCBD4CDF7BDF315F5AA8A1CE3_1302098756;
        // ---------- Original Method ----------
        //return mWindow;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.435 -0400", hash_original_method = "EEBD6C49E5EC72817DC3243A2E7FCB7D", hash_generated_method = "C7E6D06D224C647CC6BCC3442181E2B0")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.435 -0400", hash_original_method = "CE7634279B030B3367B24B82DE682EB0", hash_generated_method = "6C014E7A243EC0DFC706F607748AE807")
    public boolean hasWindow() {
        boolean var0855AC450DF2010BCC62E60CEF96871E_1301474140 = (mWindow != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_72872740 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_72872740;
        // ---------- Original Method ----------
        //return mWindow != null;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.436 -0400", hash_original_method = "53135D68273D9C60BFA0802F12D5EFAC", hash_generated_method = "A02CDFF16FC796F08C7ECD03C0B558F5")
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.437 -0400", hash_original_method = "5B67F8BB651F008F63750FC6E33E54E8", hash_generated_method = "816A65FA914C2F24D019945062AC1401")
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.438 -0400", hash_original_method = "C8847040621704A6986D97364F312269", hash_generated_method = "6CD575C7E400F361AFC0582D59EEEF79")
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

