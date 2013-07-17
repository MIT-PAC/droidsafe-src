package android.emoji;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.graphics.Bitmap;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;

public final class EmojiFactory {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.497 -0400", hash_original_field = "FC3844AD7E0AD1A2D30D63DA701B5F11", hash_generated_field = "6AC97E1F58C9735B2329D1C9A5ED4485")

    private int sCacheSize = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.497 -0400", hash_original_field = "650F7524EE08C39E1DEFAEA8CCFCE80B", hash_generated_field = "784016E98C992E67132EEDB525B62E7A")

    private int mNativeEmojiFactory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.497 -0400", hash_original_field = "311C2C8498DF6A626CBDB8AA4193499C", hash_generated_field = "886C24C67739C97CF77B8DD239E412F9")

    private String mName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.497 -0400", hash_original_field = "FA75DB4B1A95A78968F552A9DCC88B0C", hash_generated_field = "7AF93DEFFB076EA51D0A22D3C0D4BF98")

    private Map<Integer, WeakReference<Bitmap>> mCache;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.498 -0400", hash_original_method = "3CFB061344A54165CC98223BF316C16E", hash_generated_method = "C7D0D69F38285DF25F7919D10B271128")
    private  EmojiFactory(int nativeEmojiFactory, String name) {
        mNativeEmojiFactory = nativeEmojiFactory;
        mName = name;
        mCache = new CustomLinkedHashMap<Integer, WeakReference<Bitmap>>();
        // ---------- Original Method ----------
        //mNativeEmojiFactory = nativeEmojiFactory;
        //mName = name;
        //mCache = new CustomLinkedHashMap<Integer, WeakReference<Bitmap>>();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.499 -0400", hash_original_method = "32C84A5952A8F243E533AA978C471609", hash_generated_method = "1022AB339BCE8F38D8D3090647D24799")
    @Override
    protected void finalize() throws Throwable {
        try 
        {
            nativeDestructor(mNativeEmojiFactory);
        } //End block
        finally 
        {
            super.finalize();
        } //End block
        // ---------- Original Method ----------
        //try {
            //nativeDestructor(mNativeEmojiFactory);
        //} finally {
            //super.finalize();
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.499 -0400", hash_original_method = "61A4CE5E0B45509C63F06179C920C9C2", hash_generated_method = "D491DB6FF21DDA6EE282F92BBD554F4D")
    public String name() {
String varDBF15A5FB8102A5C28D5046A0E92E443_2000875739 =         mName;
        varDBF15A5FB8102A5C28D5046A0E92E443_2000875739.addTaint(taint);
        return varDBF15A5FB8102A5C28D5046A0E92E443_2000875739;
        // ---------- Original Method ----------
        //return mName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.500 -0400", hash_original_method = "51D3837892087BC1526F97486EB96A82", hash_generated_method = "AFF1D2FF6C1697AF8FB2D9CDA121CB5E")
    public synchronized Bitmap getBitmapFromAndroidPua(int pua) {
        addTaint(pua);
        WeakReference<Bitmap> cache = mCache.get(pua);
        if(cache == null)        
        {
            Bitmap ret = nativeGetBitmapFromAndroidPua(mNativeEmojiFactory, pua);
            if(ret != null)            
            {
                mCache.put(pua, new WeakReference<Bitmap>(ret));
            } //End block
Bitmap varEDFF4FBBF053B5DC2B444ADFA049EE0F_1543434190 =             ret;
            varEDFF4FBBF053B5DC2B444ADFA049EE0F_1543434190.addTaint(taint);
            return varEDFF4FBBF053B5DC2B444ADFA049EE0F_1543434190;
        } //End block
        else
        {
            Bitmap tmp = cache.get();
            if(tmp == null)            
            {
                Bitmap ret = nativeGetBitmapFromAndroidPua(mNativeEmojiFactory, pua);
                mCache.put(pua, new WeakReference<Bitmap>(ret));
Bitmap varEDFF4FBBF053B5DC2B444ADFA049EE0F_122324484 =                 ret;
                varEDFF4FBBF053B5DC2B444ADFA049EE0F_122324484.addTaint(taint);
                return varEDFF4FBBF053B5DC2B444ADFA049EE0F_122324484;
            } //End block
            else
            {
Bitmap var3F12A0424932F6B5155AA6C49B63FE6E_524775330 =                 tmp;
                var3F12A0424932F6B5155AA6C49B63FE6E_524775330.addTaint(taint);
                return var3F12A0424932F6B5155AA6C49B63FE6E_524775330;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //WeakReference<Bitmap> cache = mCache.get(pua);
        //if (cache == null) {
            //Bitmap ret = nativeGetBitmapFromAndroidPua(mNativeEmojiFactory, pua);
            //if (ret != null) {
               //mCache.put(pua, new WeakReference<Bitmap>(ret));
            //}
            //return ret;
        //} else {
            //Bitmap tmp = cache.get();
            //if (tmp == null) {
                //Bitmap ret = nativeGetBitmapFromAndroidPua(mNativeEmojiFactory, pua);
                //mCache.put(pua, new WeakReference<Bitmap>(ret));
                //return ret;
            //} else {
                //return tmp;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.501 -0400", hash_original_method = "9A7284FF37A5214E9B7F9311E2EF3E6C", hash_generated_method = "2008E7B8D24484A4B8E4095D3220636F")
    public synchronized Bitmap getBitmapFromVendorSpecificSjis(char sjis) {
        addTaint(sjis);
Bitmap varC5F7FE1D4DC4CA1B8DCAD3328E5279D5_1241136235 =         getBitmapFromAndroidPua(getAndroidPuaFromVendorSpecificSjis(sjis));
        varC5F7FE1D4DC4CA1B8DCAD3328E5279D5_1241136235.addTaint(taint);
        return varC5F7FE1D4DC4CA1B8DCAD3328E5279D5_1241136235;
        // ---------- Original Method ----------
        //return getBitmapFromAndroidPua(getAndroidPuaFromVendorSpecificSjis(sjis));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.501 -0400", hash_original_method = "F5F3B81D8E941B288B2A41FCC9367619", hash_generated_method = "E5374F4F241F38BC4D9897AEAE971299")
    public synchronized Bitmap getBitmapFromVendorSpecificPua(int vsp) {
        addTaint(vsp);
Bitmap var75D3E4F7EF5701CC303BB7D9BB089B97_891853793 =         getBitmapFromAndroidPua(getAndroidPuaFromVendorSpecificPua(vsp));
        var75D3E4F7EF5701CC303BB7D9BB089B97_891853793.addTaint(taint);
        return var75D3E4F7EF5701CC303BB7D9BB089B97_891853793;
        // ---------- Original Method ----------
        //return getBitmapFromAndroidPua(getAndroidPuaFromVendorSpecificPua(vsp));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.502 -0400", hash_original_method = "5E0818C254D368AF2876C64915580604", hash_generated_method = "F9ECE2F0E0B0ED6F7AC86C8F451CD9B4")
    public int getAndroidPuaFromVendorSpecificSjis(char sjis) {
        addTaint(sjis);
        int var3843C29FECC0974F690319631B11D9A6_1447118408 = (nativeGetAndroidPuaFromVendorSpecificSjis(mNativeEmojiFactory, sjis));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_846301184 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_846301184;
        // ---------- Original Method ----------
        //return nativeGetAndroidPuaFromVendorSpecificSjis(mNativeEmojiFactory, sjis);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.503 -0400", hash_original_method = "CAA9928E1DDFC9E6AF0D5DC613844580", hash_generated_method = "A49AC859CC5C4610BFA381AD7D570CEE")
    public int getVendorSpecificSjisFromAndroidPua(int pua) {
        addTaint(pua);
        int var942FA451A0910B7923574FD7D5787C79_365586042 = (nativeGetVendorSpecificSjisFromAndroidPua(mNativeEmojiFactory, pua));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1206430817 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1206430817;
        // ---------- Original Method ----------
        //return nativeGetVendorSpecificSjisFromAndroidPua(mNativeEmojiFactory, pua);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.503 -0400", hash_original_method = "BF155C8450604BCD58870D68939F5C48", hash_generated_method = "AD457A3974C91883A755A4F68E77DD81")
    public int getAndroidPuaFromVendorSpecificPua(int vsp) {
        addTaint(vsp);
        int var2A8F1EC31A04DB09EF9435EA3EA99842_2048108369 = (nativeGetAndroidPuaFromVendorSpecificPua(mNativeEmojiFactory, vsp));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1682745944 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1682745944;
        // ---------- Original Method ----------
        //return nativeGetAndroidPuaFromVendorSpecificPua(mNativeEmojiFactory, vsp);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.505 -0400", hash_original_method = "332632D7825438D0B8DBF43F7E76A339", hash_generated_method = "A03448831456695AC3D4582EE9C4748A")
    public String getAndroidPuaFromVendorSpecificPua(String vspString) {
        addTaint(vspString.getTaint());
        if(vspString == null)        
        {
String var540C13E9E156B687226421B24F2DF178_815505407 =             null;
            var540C13E9E156B687226421B24F2DF178_815505407.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_815505407;
        } //End block
        int minVsp = nativeGetMinimumVendorSpecificPua(mNativeEmojiFactory);
        int maxVsp = nativeGetMaximumVendorSpecificPua(mNativeEmojiFactory);
        int len = vspString.length();
        int[] codePoints = new int[vspString.codePointCount(0, len)];
        int new_len = 0;
for(int i = 0;i < len;i = vspString.offsetByCodePoints(i, 1),new_len++)
        {
            int codePoint = vspString.codePointAt(i);
            if(minVsp <= codePoint && codePoint <= maxVsp)            
            {
                int newCodePoint = getAndroidPuaFromVendorSpecificPua(codePoint);
                if(newCodePoint > 0)                
                {
                    codePoints[new_len] = newCodePoint;
                    continue;
                } //End block
            } //End block
            codePoints[new_len] = codePoint;
        } //End block
String var3AC7A0B6507C070325418D20C396FDAC_1491981683 =         new String(codePoints, 0, new_len);
        var3AC7A0B6507C070325418D20C396FDAC_1491981683.addTaint(taint);
        return var3AC7A0B6507C070325418D20C396FDAC_1491981683;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.506 -0400", hash_original_method = "B08EB100AB82E54ADADC386CF8B33D33", hash_generated_method = "C419FBA9D4EBFF3EC1D45F0FA02E3098")
    public int getVendorSpecificPuaFromAndroidPua(int pua) {
        addTaint(pua);
        int var3B3B4178179080EADE1EBBBD31DFB279_1535883286 = (nativeGetVendorSpecificPuaFromAndroidPua(mNativeEmojiFactory, pua));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1571601191 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1571601191;
        // ---------- Original Method ----------
        //return nativeGetVendorSpecificPuaFromAndroidPua(mNativeEmojiFactory, pua);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.508 -0400", hash_original_method = "6085ED2713FAD0096DF7C4BD4C86F8DD", hash_generated_method = "027B5E5C02FF86D5623DE0292DA5C946")
    public String getVendorSpecificPuaFromAndroidPua(String puaString) {
        addTaint(puaString.getTaint());
        if(puaString == null)        
        {
String var540C13E9E156B687226421B24F2DF178_636107842 =             null;
            var540C13E9E156B687226421B24F2DF178_636107842.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_636107842;
        } //End block
        int minVsp = nativeGetMinimumAndroidPua(mNativeEmojiFactory);
        int maxVsp = nativeGetMaximumAndroidPua(mNativeEmojiFactory);
        int len = puaString.length();
        int[] codePoints = new int[puaString.codePointCount(0, len)];
        int new_len = 0;
for(int i = 0;i < len;i = puaString.offsetByCodePoints(i, 1),new_len++)
        {
            int codePoint = puaString.codePointAt(i);
            if(minVsp <= codePoint && codePoint <= maxVsp)            
            {
                int newCodePoint = getVendorSpecificPuaFromAndroidPua(codePoint);
                if(newCodePoint > 0)                
                {
                    codePoints[new_len] = newCodePoint;
                    continue;
                } //End block
            } //End block
            codePoints[new_len] = codePoint;
        } //End block
String var3AC7A0B6507C070325418D20C396FDAC_1536079929 =         new String(codePoints, 0, new_len);
        var3AC7A0B6507C070325418D20C396FDAC_1536079929.addTaint(taint);
        return var3AC7A0B6507C070325418D20C396FDAC_1536079929;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    public static EmojiFactory newInstance(String class_name) {
		return new EmojiFactory(0, class_name);
	}

    
    @DSModeled(DSC.SAFE)
    public static EmojiFactory newAvailableInstance() {
		return new EmojiFactory(0, "");
	}

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.509 -0400", hash_original_method = "E94B589829434939D487652724460608", hash_generated_method = "9D84CFCAA98B6F65E8FDFCF75F8741F3")
    public int getMinimumAndroidPua() {
        int var6D01B26D80C78B9F3068F6781CD3B69C_8402789 = (nativeGetMinimumAndroidPua(mNativeEmojiFactory));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_460382424 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_460382424;
        // ---------- Original Method ----------
        //return nativeGetMinimumAndroidPua(mNativeEmojiFactory);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.510 -0400", hash_original_method = "84EA08D07D32F9FA087FFC75B38A56E8", hash_generated_method = "458A2198BBCE23875469B6001E4888D7")
    public int getMaximumAndroidPua() {
        int var2A941F107A5D696EC71FA20E6118A915_1992272826 = (nativeGetMaximumAndroidPua(mNativeEmojiFactory));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_55198529 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_55198529;
        // ---------- Original Method ----------
        //return nativeGetMaximumAndroidPua(mNativeEmojiFactory);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.511 -0400", hash_original_method = "996F154EA43AB1D5A4C151D656C37CF1", hash_generated_method = "306E1F6D8D2B1E2FAFA21FC83BAC450E")
    private void nativeDestructor(int factory) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.143 -0400", hash_original_method = "3AA105C3169886A719F2BF7A3237E4A3", hash_generated_method = "1FEDBE13E2C3435ECCCBB1756DB5C9E3")
	private Bitmap nativeGetBitmapFromAndroidPua(int nativeEmojiFactory, int AndroidPua) {
		Bitmap bm = new Bitmap();
		bm.addTaint(this.taint);
		return bm;
	}

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.512 -0400", hash_original_method = "3A1554F06CC9CCAF25F7BBE93248CE83", hash_generated_method = "DFC54DDD2A8205CEADE929626101FE73")
    private int nativeGetAndroidPuaFromVendorSpecificSjis(int nativeEmojiFactory,
            char sjis) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1575940476 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1575940476;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.513 -0400", hash_original_method = "C302C3634C2FA6E6CA4CF2CF66D12101", hash_generated_method = "50FBA7AB93A48F42310E87F205EEEE52")
    private int nativeGetVendorSpecificSjisFromAndroidPua(int nativeEmojiFactory,
            int pua) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_231742064 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_231742064;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.514 -0400", hash_original_method = "75FE7601C9BA865A32982CD0867F654C", hash_generated_method = "7D90B7CDC53A19BE11D1C11EA2464ADE")
    private int nativeGetAndroidPuaFromVendorSpecificPua(int nativeEmojiFactory,
            int vsp) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_91850128 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_91850128;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.515 -0400", hash_original_method = "B406416ABF41BEA242E5A40B8BA7386A", hash_generated_method = "E7F16FC6F6C9F1179F322D842F4CE08F")
    private int nativeGetVendorSpecificPuaFromAndroidPua(int nativeEmojiFactory,
            int pua) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_349548508 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_349548508;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.516 -0400", hash_original_method = "5A805426DAFA5C3640F25323B1C3B8F5", hash_generated_method = "546B834EEC188C2B306B74BB33FEAB47")
    private int nativeGetMaximumVendorSpecificPua(int nativeEmojiFactory) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1790069327 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1790069327;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.518 -0400", hash_original_method = "0FF4320BBE7657B90285375F65F4DF9D", hash_generated_method = "E7BC0E809E78A9164386CACBFBF6F54C")
    private int nativeGetMinimumVendorSpecificPua(int nativeEmojiFactory) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_161486182 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_161486182;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.519 -0400", hash_original_method = "800100FBB9205E441349161A70ADF047", hash_generated_method = "13F73A7876B7812C4DFBA1FA4AA72E51")
    private int nativeGetMaximumAndroidPua(int nativeEmojiFactory) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1442319966 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1442319966;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.519 -0400", hash_original_method = "5875EE70D8D47117F3D06FA307D98BB5", hash_generated_method = "FD6115741B8337852CD1AB815D2B2C59")
    private int nativeGetMinimumAndroidPua(int nativeEmojiFactory) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1011081419 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1011081419;
    }

    
    private class CustomLinkedHashMap<K, V> extends LinkedHashMap<K, V> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.520 -0400", hash_original_method = "EFD1513E9BFBC9B14636F3CC7AC41B6C", hash_generated_method = "19A9879B12E07C26C0FDCF805FDF3C6D")
        public  CustomLinkedHashMap() {
            super(16, 0.75f, true);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.520 -0400", hash_original_method = "A5B2DC9A6DACFA347C16D8B42A67BD03", hash_generated_method = "EC97EDD5FB7C2E4D1C259743CD8A274D")
        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            addTaint(eldest.getTaint());
            boolean var4BED03B42BC7B15B15FFD29FAB19079E_533963383 = (size() > sCacheSize);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_957433386 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_957433386;
            // ---------- Original Method ----------
            //return size() > sCacheSize;
        }

        
    }


    
}

