package android.emoji;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.graphics.Bitmap;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;

public final class EmojiFactory {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.643 -0400", hash_original_field = "FC3844AD7E0AD1A2D30D63DA701B5F11", hash_generated_field = "6AC97E1F58C9735B2329D1C9A5ED4485")

    private int sCacheSize = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.643 -0400", hash_original_field = "650F7524EE08C39E1DEFAEA8CCFCE80B", hash_generated_field = "784016E98C992E67132EEDB525B62E7A")

    private int mNativeEmojiFactory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.643 -0400", hash_original_field = "311C2C8498DF6A626CBDB8AA4193499C", hash_generated_field = "886C24C67739C97CF77B8DD239E412F9")

    private String mName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.643 -0400", hash_original_field = "FA75DB4B1A95A78968F552A9DCC88B0C", hash_generated_field = "7AF93DEFFB076EA51D0A22D3C0D4BF98")

    private Map<Integer, WeakReference<Bitmap>> mCache;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.644 -0400", hash_original_method = "3CFB061344A54165CC98223BF316C16E", hash_generated_method = "C7D0D69F38285DF25F7919D10B271128")
    private  EmojiFactory(int nativeEmojiFactory, String name) {
        mNativeEmojiFactory = nativeEmojiFactory;
        mName = name;
        mCache = new CustomLinkedHashMap<Integer, WeakReference<Bitmap>>();
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.644 -0400", hash_original_method = "32C84A5952A8F243E533AA978C471609", hash_generated_method = "1022AB339BCE8F38D8D3090647D24799")
    @Override
    protected void finalize() throws Throwable {
        try 
        {
            nativeDestructor(mNativeEmojiFactory);
        } 
        finally 
        {
            super.finalize();
        } 
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.645 -0400", hash_original_method = "61A4CE5E0B45509C63F06179C920C9C2", hash_generated_method = "90AD13F1A0BAD69D758E89DA16A900CA")
    public String name() {
String varDBF15A5FB8102A5C28D5046A0E92E443_316774322 =         mName;
        varDBF15A5FB8102A5C28D5046A0E92E443_316774322.addTaint(taint);
        return varDBF15A5FB8102A5C28D5046A0E92E443_316774322;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.646 -0400", hash_original_method = "51D3837892087BC1526F97486EB96A82", hash_generated_method = "6A432033D4DB535DF40507D80FB4FB31")
    public synchronized Bitmap getBitmapFromAndroidPua(int pua) {
        addTaint(pua);
        WeakReference<Bitmap> cache = mCache.get(pua);
    if(cache == null)        
        {
            Bitmap ret = nativeGetBitmapFromAndroidPua(mNativeEmojiFactory, pua);
    if(ret != null)            
            {
                mCache.put(pua, new WeakReference<Bitmap>(ret));
            } 
Bitmap varEDFF4FBBF053B5DC2B444ADFA049EE0F_1689154499 =             ret;
            varEDFF4FBBF053B5DC2B444ADFA049EE0F_1689154499.addTaint(taint);
            return varEDFF4FBBF053B5DC2B444ADFA049EE0F_1689154499;
        } 
        else
        {
            Bitmap tmp = cache.get();
    if(tmp == null)            
            {
                Bitmap ret = nativeGetBitmapFromAndroidPua(mNativeEmojiFactory, pua);
                mCache.put(pua, new WeakReference<Bitmap>(ret));
Bitmap varEDFF4FBBF053B5DC2B444ADFA049EE0F_1459485911 =                 ret;
                varEDFF4FBBF053B5DC2B444ADFA049EE0F_1459485911.addTaint(taint);
                return varEDFF4FBBF053B5DC2B444ADFA049EE0F_1459485911;
            } 
            else
            {
Bitmap var3F12A0424932F6B5155AA6C49B63FE6E_1579020898 =                 tmp;
                var3F12A0424932F6B5155AA6C49B63FE6E_1579020898.addTaint(taint);
                return var3F12A0424932F6B5155AA6C49B63FE6E_1579020898;
            } 
        } 
        
        
        
            
            
               
            
            
        
            
            
                
                
                
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.647 -0400", hash_original_method = "9A7284FF37A5214E9B7F9311E2EF3E6C", hash_generated_method = "AFC835255CE598379C759A2E4D572875")
    public synchronized Bitmap getBitmapFromVendorSpecificSjis(char sjis) {
        addTaint(sjis);
Bitmap varC5F7FE1D4DC4CA1B8DCAD3328E5279D5_182224930 =         getBitmapFromAndroidPua(getAndroidPuaFromVendorSpecificSjis(sjis));
        varC5F7FE1D4DC4CA1B8DCAD3328E5279D5_182224930.addTaint(taint);
        return varC5F7FE1D4DC4CA1B8DCAD3328E5279D5_182224930;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.648 -0400", hash_original_method = "F5F3B81D8E941B288B2A41FCC9367619", hash_generated_method = "5C6C07017D91D094AB4BA6D118033D30")
    public synchronized Bitmap getBitmapFromVendorSpecificPua(int vsp) {
        addTaint(vsp);
Bitmap var75D3E4F7EF5701CC303BB7D9BB089B97_196377460 =         getBitmapFromAndroidPua(getAndroidPuaFromVendorSpecificPua(vsp));
        var75D3E4F7EF5701CC303BB7D9BB089B97_196377460.addTaint(taint);
        return var75D3E4F7EF5701CC303BB7D9BB089B97_196377460;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.649 -0400", hash_original_method = "5E0818C254D368AF2876C64915580604", hash_generated_method = "360839972FE975509B6DEF83823EB94E")
    public int getAndroidPuaFromVendorSpecificSjis(char sjis) {
        addTaint(sjis);
        int var3843C29FECC0974F690319631B11D9A6_362701282 = (nativeGetAndroidPuaFromVendorSpecificSjis(mNativeEmojiFactory, sjis));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_241630265 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_241630265;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.651 -0400", hash_original_method = "CAA9928E1DDFC9E6AF0D5DC613844580", hash_generated_method = "5384A094CF75EE382FB330915EC8DE41")
    public int getVendorSpecificSjisFromAndroidPua(int pua) {
        addTaint(pua);
        int var942FA451A0910B7923574FD7D5787C79_365936696 = (nativeGetVendorSpecificSjisFromAndroidPua(mNativeEmojiFactory, pua));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1794280673 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1794280673;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.652 -0400", hash_original_method = "BF155C8450604BCD58870D68939F5C48", hash_generated_method = "B768037CEFFC6DFC5813BB2AF2F6672D")
    public int getAndroidPuaFromVendorSpecificPua(int vsp) {
        addTaint(vsp);
        int var2A8F1EC31A04DB09EF9435EA3EA99842_231249046 = (nativeGetAndroidPuaFromVendorSpecificPua(mNativeEmojiFactory, vsp));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1712351201 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1712351201;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.654 -0400", hash_original_method = "332632D7825438D0B8DBF43F7E76A339", hash_generated_method = "AE71651B66A0C30F50B650155FB4285F")
    public String getAndroidPuaFromVendorSpecificPua(String vspString) {
        addTaint(vspString.getTaint());
    if(vspString == null)        
        {
String var540C13E9E156B687226421B24F2DF178_15187833 =             null;
            var540C13E9E156B687226421B24F2DF178_15187833.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_15187833;
        } 
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
                } 
            } 
            codePoints[new_len] = codePoint;
        } 
String var3AC7A0B6507C070325418D20C396FDAC_355235545 =         new String(codePoints, 0, new_len);
        var3AC7A0B6507C070325418D20C396FDAC_355235545.addTaint(taint);
        return var3AC7A0B6507C070325418D20C396FDAC_355235545;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.654 -0400", hash_original_method = "B08EB100AB82E54ADADC386CF8B33D33", hash_generated_method = "172910644B5F9B04494B18B0BBE99D86")
    public int getVendorSpecificPuaFromAndroidPua(int pua) {
        addTaint(pua);
        int var3B3B4178179080EADE1EBBBD31DFB279_1114608777 = (nativeGetVendorSpecificPuaFromAndroidPua(mNativeEmojiFactory, pua));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1411611369 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1411611369;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.655 -0400", hash_original_method = "6085ED2713FAD0096DF7C4BD4C86F8DD", hash_generated_method = "B540A87BCFC92814D851791824B5B8DC")
    public String getVendorSpecificPuaFromAndroidPua(String puaString) {
        addTaint(puaString.getTaint());
    if(puaString == null)        
        {
String var540C13E9E156B687226421B24F2DF178_152773081 =             null;
            var540C13E9E156B687226421B24F2DF178_152773081.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_152773081;
        } 
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
                } 
            } 
            codePoints[new_len] = codePoint;
        } 
String var3AC7A0B6507C070325418D20C396FDAC_1524006264 =         new String(codePoints, 0, new_len);
        var3AC7A0B6507C070325418D20C396FDAC_1524006264.addTaint(taint);
        return var3AC7A0B6507C070325418D20C396FDAC_1524006264;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static EmojiFactory newInstance(String class_name) {
		return new EmojiFactory(0, class_name);
	}

    
    @DSModeled(DSC.SAFE)
    public static EmojiFactory newAvailableInstance() {
		return new EmojiFactory(0, "");
	}

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.657 -0400", hash_original_method = "E94B589829434939D487652724460608", hash_generated_method = "5988F62B1F56185836AFA88C2C5FE472")
    public int getMinimumAndroidPua() {
        int var6D01B26D80C78B9F3068F6781CD3B69C_1279084378 = (nativeGetMinimumAndroidPua(mNativeEmojiFactory));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_387320954 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_387320954;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.657 -0400", hash_original_method = "84EA08D07D32F9FA087FFC75B38A56E8", hash_generated_method = "C75BB0421116AD3ACA26114DB8D2C788")
    public int getMaximumAndroidPua() {
        int var2A941F107A5D696EC71FA20E6118A915_1484419939 = (nativeGetMaximumAndroidPua(mNativeEmojiFactory));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1370894794 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1370894794;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.658 -0400", hash_original_method = "996F154EA43AB1D5A4C151D656C37CF1", hash_generated_method = "306E1F6D8D2B1E2FAFA21FC83BAC450E")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.659 -0400", hash_original_method = "3A1554F06CC9CCAF25F7BBE93248CE83", hash_generated_method = "21CA195DD228E0FBB5ECD548ED946C8B")
    private int nativeGetAndroidPuaFromVendorSpecificSjis(int nativeEmojiFactory,
            char sjis) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1044772772 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1044772772;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.659 -0400", hash_original_method = "C302C3634C2FA6E6CA4CF2CF66D12101", hash_generated_method = "6EDAC1F68D9E30094C781ABA076D7923")
    private int nativeGetVendorSpecificSjisFromAndroidPua(int nativeEmojiFactory,
            int pua) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1096241702 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1096241702;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.659 -0400", hash_original_method = "75FE7601C9BA865A32982CD0867F654C", hash_generated_method = "6F2BF72A91E1D9E20595A0C05C408AED")
    private int nativeGetAndroidPuaFromVendorSpecificPua(int nativeEmojiFactory,
            int vsp) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_699965412 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_699965412;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.660 -0400", hash_original_method = "B406416ABF41BEA242E5A40B8BA7386A", hash_generated_method = "81CF200C96B75B89467FB201B3A95950")
    private int nativeGetVendorSpecificPuaFromAndroidPua(int nativeEmojiFactory,
            int pua) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1124028382 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1124028382;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.660 -0400", hash_original_method = "5A805426DAFA5C3640F25323B1C3B8F5", hash_generated_method = "4483C9E3FFD90919837075CC0124182D")
    private int nativeGetMaximumVendorSpecificPua(int nativeEmojiFactory) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1747136477 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1747136477;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.660 -0400", hash_original_method = "0FF4320BBE7657B90285375F65F4DF9D", hash_generated_method = "7E2C76CDDF3A45A429FA3A1D42E608C7")
    private int nativeGetMinimumVendorSpecificPua(int nativeEmojiFactory) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_633485327 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_633485327;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.661 -0400", hash_original_method = "800100FBB9205E441349161A70ADF047", hash_generated_method = "1D0A7425A10509C8F49E7B3A9F8AEEF2")
    private int nativeGetMaximumAndroidPua(int nativeEmojiFactory) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_681663681 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_681663681;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.661 -0400", hash_original_method = "5875EE70D8D47117F3D06FA307D98BB5", hash_generated_method = "AB432FE5CAE37393F1FBBFA2A316E078")
    private int nativeGetMinimumAndroidPua(int nativeEmojiFactory) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1414624735 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1414624735;
    }

    
    private class CustomLinkedHashMap<K, V> extends LinkedHashMap<K, V> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.661 -0400", hash_original_method = "EFD1513E9BFBC9B14636F3CC7AC41B6C", hash_generated_method = "19A9879B12E07C26C0FDCF805FDF3C6D")
        public  CustomLinkedHashMap() {
            super(16, 0.75f, true);
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.662 -0400", hash_original_method = "A5B2DC9A6DACFA347C16D8B42A67BD03", hash_generated_method = "EB1019A52F54BE85E08E8437607FAB02")
        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            addTaint(eldest.getTaint());
            boolean var4BED03B42BC7B15B15FFD29FAB19079E_1168400156 = (size() > sCacheSize);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_817459959 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_817459959;
            
            
        }

        
    }


    
}

