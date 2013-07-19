package android.net;

// Droidsafe Imports
import android.os.RemoteException;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;

public class ThrottleManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.325 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "6BB94C28B991564A2654192146B5BDD6")

    private IThrottleManager mService;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.325 -0400", hash_original_method = "A34F832700CA864903AE32FE53CD267E", hash_generated_method = "3F4BC6E2219D8CDC47CEDF2CEA3212F6")
    @SuppressWarnings({"UnusedDeclaration"})
    private  ThrottleManager() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.325 -0400", hash_original_method = "1E8483A92A1408237E2885FBEDD54340", hash_generated_method = "5BAA81ACE2D9663C0B54B6AC96DFBA11")
    public  ThrottleManager(IThrottleManager service) {
        if(service == null)        
        {
            IllegalArgumentException varE23043D91EBD904FCFFC9118BB5AE827_170684066 = new IllegalArgumentException(
                "ThrottleManager() cannot be constructed with null service");
            varE23043D91EBD904FCFFC9118BB5AE827_170684066.addTaint(taint);
            throw varE23043D91EBD904FCFFC9118BB5AE827_170684066;
        } //End block
        mService = service;
        // ---------- Original Method ----------
        //if (service == null) {
            //throw new IllegalArgumentException(
                //"ThrottleManager() cannot be constructed with null service");
        //}
        //mService = service;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.326 -0400", hash_original_method = "2AA7855A594B5700D93ECFB7D9A7B7C4", hash_generated_method = "B14ADC7D9113494E2BC83444859FAEA6")
    public long getResetTime(String iface) {
        addTaint(iface.getTaint());
        try 
        {
            long var85A0DCA92FF226DB0736DF7D9B8E2D5E_1147841283 = (mService.getResetTime(iface));
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1249519599 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1249519599;
        } //End block
        catch (RemoteException e)
        {
            long var6BB61E3B7BCE0931DA574D19D1D82C88_1347476097 = (-1);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_562052288 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_562052288;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.getResetTime(iface);
        //} catch (RemoteException e) {
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.326 -0400", hash_original_method = "71ECD56B8A0A75240BCCEB36337D3BA2", hash_generated_method = "1DC678A92BCA20B29978F42AF3515F7C")
    public long getPeriodStartTime(String iface) {
        addTaint(iface.getTaint());
        try 
        {
            long var9CFA7BF2BE0EDEA09F6EEAE7F87E2344_755388867 = (mService.getPeriodStartTime(iface));
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_482644164 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_482644164;
        } //End block
        catch (RemoteException e)
        {
            long var6BB61E3B7BCE0931DA574D19D1D82C88_530063390 = (-1);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_405751592 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_405751592;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.getPeriodStartTime(iface);
        //} catch (RemoteException e) {
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.326 -0400", hash_original_method = "8241A155E8F913EC462AEA4A2F5ED1F8", hash_generated_method = "3150BACF0FB1FEA078EB739F48835BF1")
    public long getByteCount(String iface, int direction, int period, int ago) {
        addTaint(ago);
        addTaint(period);
        addTaint(direction);
        addTaint(iface.getTaint());
        try 
        {
            long varCE8B0BFAAFE3039AF58C1CE59D5E1AD4_837049023 = (mService.getByteCount(iface, direction, period, ago));
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_692359978 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_692359978;
        } //End block
        catch (RemoteException e)
        {
            long var6BB61E3B7BCE0931DA574D19D1D82C88_50876862 = (-1);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1777726533 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1777726533;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.getByteCount(iface, direction, period, ago);
        //} catch (RemoteException e) {
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.326 -0400", hash_original_method = "1E5CE1E6E971F0A1DB09E08194D8A23E", hash_generated_method = "4E825E3F7C7746FA44E49F380FDB7877")
    public long getCliffThreshold(String iface, int cliff) {
        addTaint(cliff);
        addTaint(iface.getTaint());
        try 
        {
            long var1FC8A02CBE85C503650F222A730DBB6E_757715114 = (mService.getCliffThreshold(iface, cliff));
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1160309231 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1160309231;
        } //End block
        catch (RemoteException e)
        {
            long var6BB61E3B7BCE0931DA574D19D1D82C88_858861405 = (-1);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_371202160 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_371202160;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.getCliffThreshold(iface, cliff);
        //} catch (RemoteException e) {
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.326 -0400", hash_original_method = "1E0667CC63B486C17ACE24556BBA89F5", hash_generated_method = "8268A1A0F93A6F7ABC31CDD37894427B")
    public int getCliffLevel(String iface, int cliff) {
        addTaint(cliff);
        addTaint(iface.getTaint());
        try 
        {
            int varA8C2FB3FEE7084B2F9CE86DE6BD45AE7_2053149110 = (mService.getCliffLevel(iface, cliff));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1656643023 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1656643023;
        } //End block
        catch (RemoteException e)
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_1153866002 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_75051381 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_75051381;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.getCliffLevel(iface, cliff);
        //} catch (RemoteException e) {
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.327 -0400", hash_original_method = "BE6DD87215E82DDA8E4A2908333DC9D4", hash_generated_method = "7ED58CFFA641BA3E8FF2F386AFA97940")
    public String getHelpUri() {
        try 
        {
String varED1817BFB721597A8484A0DA62292CDF_2147235073 =             mService.getHelpUri();
            varED1817BFB721597A8484A0DA62292CDF_2147235073.addTaint(taint);
            return varED1817BFB721597A8484A0DA62292CDF_2147235073;
        } //End block
        catch (RemoteException e)
        {
String var540C13E9E156B687226421B24F2DF178_429186726 =             null;
            var540C13E9E156B687226421B24F2DF178_429186726.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_429186726;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.getHelpUri();
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.327 -0400", hash_original_field = "E9D69712E7BD9375036DE9821C2D19DA", hash_generated_field = "6898D21EE81972732398F7476E57A4E5")

    public static final String THROTTLE_POLL_ACTION = "android.net.thrott.POLL_ACTION";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.327 -0400", hash_original_field = "45DF59F8529C3039D220FA9A81B7DE53", hash_generated_field = "C60D73AECC3BBEBC845B460B2C0FC207")

    public static final String EXTRA_CYCLE_READ = "cycleRead";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.327 -0400", hash_original_field = "CA2C178B5867009B1D9948449EEB4B60", hash_generated_field = "614D6C44EC9F28B2D5FB5646A9D9B2A1")

    public static final String EXTRA_CYCLE_WRITE = "cycleWrite";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.327 -0400", hash_original_field = "8B307471FC2FDB8B0241A3005FD30F39", hash_generated_field = "B0C2C07165B22D87786F95B5CF4A95EC")

    public static final String EXTRA_CYCLE_START = "cycleStart";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.327 -0400", hash_original_field = "77A13DCB1FC5A1BCAFBEBD72C218E5DB", hash_generated_field = "915B8CD3CA64A3EEA22D5D810E05B311")

    public static final String EXTRA_CYCLE_END = "cycleEnd";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.327 -0400", hash_original_field = "43D8C343C4660ECEEB34D2608D0694C2", hash_generated_field = "ED12FBB3FB48078997AB63E809995555")

    public static final String THROTTLE_ACTION = "android.net.thrott.THROTTLE_ACTION";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.327 -0400", hash_original_field = "0744B50E5CE685401A4B17EA53DBC041", hash_generated_field = "122B5A88AD4F5DA97CF614FC9CB7112B")

    public static final String EXTRA_THROTTLE_LEVEL = "level";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.327 -0400", hash_original_field = "6DD887D9924C025779C4436D9C4E493A", hash_generated_field = "FB3DCC9354DA96058DD89B592250B71F")

    public static final String POLICY_CHANGED_ACTION = "android.net.thrott.POLICY_CHANGED_ACTION";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.327 -0400", hash_original_field = "7C81C04C5B7BF8E649135D77EF16EBFA", hash_generated_field = "07E577AB923A1F0E031C2D3766146C02")

    public static final int DIRECTION_TX = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.327 -0400", hash_original_field = "A266203E9BDE616672C5DBE29DA2B690", hash_generated_field = "834CDF39C9CC543B48AE086B421ECA77")

    public static final int DIRECTION_RX = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.327 -0400", hash_original_field = "780622D25A9EEB18DB77E0E9941A55AA", hash_generated_field = "87522BCD580B6A5AFD35F6902B2D1E21")

    public static final int PERIOD_CYCLE  = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.327 -0400", hash_original_field = "48F80B54C34B64ED0DC206F654FB4AD8", hash_generated_field = "E8BFFBAA705E3AF3D0A7C53DEE7C7008")

    public static final int PERIOD_YEAR   = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.327 -0400", hash_original_field = "B2A32047683D7BE4A79A7185CAD3BCFC", hash_generated_field = "08FFC80FB898CB6A4543FB0922959EFB")

    public static final int PERIOD_MONTH  = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.327 -0400", hash_original_field = "17F496D35701D7BB7BE1E1D7079312D9", hash_generated_field = "32735A8A4863C7888B70468A911092C3")

    public static final int PERIOD_WEEK   = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.327 -0400", hash_original_field = "6BC136E64CC12071F89E082D061A2E2E", hash_generated_field = "C6E0E63CC773D681BAE66CBD36FD943C")

    public static final int PERIOD_7DAY   = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.327 -0400", hash_original_field = "4B521D604C2763135D3E2D7812A3B20F", hash_generated_field = "7F5C827CE30965E88157F824EED66B89")

    public static final int PERIOD_DAY    = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.327 -0400", hash_original_field = "2FE213A4131D9CB13C10A0E7C508B5D2", hash_generated_field = "93FC7C33BAAB08F424FB1D467A0AF63A")

    public static final int PERIOD_24HOUR = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.327 -0400", hash_original_field = "79C5F9E65EE9F3A233677000A4E7750D", hash_generated_field = "8564FC078F4F6D5F682451C9CA7511B0")

    public static final int PERIOD_HOUR   = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.327 -0400", hash_original_field = "BD57BB81BAF388CBB2BB491F08B3F3DA", hash_generated_field = "DEB645AC680C218CA74E35EE0F48291C")

    public static final int PERIOD_60MIN  = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.327 -0400", hash_original_field = "15C7210CA8C1F826393F8A54D5B6ED5B", hash_generated_field = "F93352F76A6EE829F15E2FF62662F7EC")

    public static final int PERIOD_MINUTE = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.327 -0400", hash_original_field = "059D0AD6CA74A705C1B0E696BC076009", hash_generated_field = "9399D0B1B6AB08F0D2EF7457960FA4E0")

    public static final int PERIOD_60SEC  = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.327 -0400", hash_original_field = "FE59F7E5D092060C00CD5A4E372D73F3", hash_generated_field = "8BD9177938B69E4736C243116A5F85CB")

    public static final int PERIOD_SECOND = 11;
}

