package android.emoji;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.graphics.Bitmap;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;

public final class EmojiFactory {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.946 -0400", hash_original_field = "FC3844AD7E0AD1A2D30D63DA701B5F11", hash_generated_field = "6AC97E1F58C9735B2329D1C9A5ED4485")

    private int sCacheSize = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.946 -0400", hash_original_field = "650F7524EE08C39E1DEFAEA8CCFCE80B", hash_generated_field = "784016E98C992E67132EEDB525B62E7A")

    private int mNativeEmojiFactory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.946 -0400", hash_original_field = "311C2C8498DF6A626CBDB8AA4193499C", hash_generated_field = "886C24C67739C97CF77B8DD239E412F9")

    private String mName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.946 -0400", hash_original_field = "FA75DB4B1A95A78968F552A9DCC88B0C", hash_generated_field = "7AF93DEFFB076EA51D0A22D3C0D4BF98")

    private Map<Integer, WeakReference<Bitmap>> mCache;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.955 -0400", hash_original_method = "3CFB061344A54165CC98223BF316C16E", hash_generated_method = "C7D0D69F38285DF25F7919D10B271128")
    private  EmojiFactory(int nativeEmojiFactory, String name) {
        mNativeEmojiFactory = nativeEmojiFactory;
        mName = name;
        mCache = new CustomLinkedHashMap<Integer, WeakReference<Bitmap>>();
        // ---------- Original Method ----------
        //mNativeEmojiFactory = nativeEmojiFactory;
        //mName = name;
        //mCache = new CustomLinkedHashMap<Integer, WeakReference<Bitmap>>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.960 -0400", hash_original_method = "32C84A5952A8F243E533AA978C471609", hash_generated_method = "1022AB339BCE8F38D8D3090647D24799")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.978 -0400", hash_original_method = "61A4CE5E0B45509C63F06179C920C9C2", hash_generated_method = "599517F45F293192027F98F9045232FB")
    public String name() {
        String varB4EAC82CA7396A68D541C85D26508E83_1305613348 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1305613348 = mName;
        varB4EAC82CA7396A68D541C85D26508E83_1305613348.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1305613348;
        // ---------- Original Method ----------
        //return mName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.981 -0400", hash_original_method = "51D3837892087BC1526F97486EB96A82", hash_generated_method = "72D141D35321E7B1A45DD7C0B2165A06")
    public synchronized Bitmap getBitmapFromAndroidPua(int pua) {
        Bitmap varB4EAC82CA7396A68D541C85D26508E83_961560336 = null; //Variable for return #1
        Bitmap varB4EAC82CA7396A68D541C85D26508E83_923455601 = null; //Variable for return #2
        Bitmap varB4EAC82CA7396A68D541C85D26508E83_1258265844 = null; //Variable for return #3
        WeakReference<Bitmap> cache;
        cache = mCache.get(pua);
        {
            Bitmap ret;
            ret = nativeGetBitmapFromAndroidPua(mNativeEmojiFactory, pua);
            {
                mCache.put(pua, new WeakReference<Bitmap>(ret));
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_961560336 = ret;
        } //End block
        {
            Bitmap tmp;
            tmp = cache.get();
            {
                Bitmap ret;
                ret = nativeGetBitmapFromAndroidPua(mNativeEmojiFactory, pua);
                mCache.put(pua, new WeakReference<Bitmap>(ret));
                varB4EAC82CA7396A68D541C85D26508E83_923455601 = ret;
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_1258265844 = tmp;
            } //End block
        } //End block
        addTaint(pua);
        Bitmap varA7E53CE21691AB073D9660D615818899_479740667; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_479740667 = varB4EAC82CA7396A68D541C85D26508E83_961560336;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_479740667 = varB4EAC82CA7396A68D541C85D26508E83_923455601;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_479740667 = varB4EAC82CA7396A68D541C85D26508E83_1258265844;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_479740667.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_479740667;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.982 -0400", hash_original_method = "9A7284FF37A5214E9B7F9311E2EF3E6C", hash_generated_method = "A05E3DE3F28BEC593CFEC16ADED88C2C")
    public synchronized Bitmap getBitmapFromVendorSpecificSjis(char sjis) {
        Bitmap varB4EAC82CA7396A68D541C85D26508E83_1558913937 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1558913937 = getBitmapFromAndroidPua(getAndroidPuaFromVendorSpecificSjis(sjis));
        addTaint(sjis);
        varB4EAC82CA7396A68D541C85D26508E83_1558913937.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1558913937;
        // ---------- Original Method ----------
        //return getBitmapFromAndroidPua(getAndroidPuaFromVendorSpecificSjis(sjis));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.005 -0400", hash_original_method = "F5F3B81D8E941B288B2A41FCC9367619", hash_generated_method = "FD91000B7141253DA12E09BD916F9025")
    public synchronized Bitmap getBitmapFromVendorSpecificPua(int vsp) {
        Bitmap varB4EAC82CA7396A68D541C85D26508E83_1368480402 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1368480402 = getBitmapFromAndroidPua(getAndroidPuaFromVendorSpecificPua(vsp));
        addTaint(vsp);
        varB4EAC82CA7396A68D541C85D26508E83_1368480402.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1368480402;
        // ---------- Original Method ----------
        //return getBitmapFromAndroidPua(getAndroidPuaFromVendorSpecificPua(vsp));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.006 -0400", hash_original_method = "5E0818C254D368AF2876C64915580604", hash_generated_method = "4BCDF27A9742D74FAE38E6F68F57790E")
    public int getAndroidPuaFromVendorSpecificSjis(char sjis) {
        int var74C2D334EFE3998285C80D7E5E8A8BE7_1924077188 = (nativeGetAndroidPuaFromVendorSpecificSjis(mNativeEmojiFactory, sjis));
        addTaint(sjis);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1939572097 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1939572097;
        // ---------- Original Method ----------
        //return nativeGetAndroidPuaFromVendorSpecificSjis(mNativeEmojiFactory, sjis);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.006 -0400", hash_original_method = "CAA9928E1DDFC9E6AF0D5DC613844580", hash_generated_method = "28F7B9D6FEF9A0B33B8143E96F2493E5")
    public int getVendorSpecificSjisFromAndroidPua(int pua) {
        int varD1B8764BBE902D599DA4F2D19767BBAC_1284224718 = (nativeGetVendorSpecificSjisFromAndroidPua(mNativeEmojiFactory, pua));
        addTaint(pua);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_987164873 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_987164873;
        // ---------- Original Method ----------
        //return nativeGetVendorSpecificSjisFromAndroidPua(mNativeEmojiFactory, pua);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.011 -0400", hash_original_method = "BF155C8450604BCD58870D68939F5C48", hash_generated_method = "F6970FFBCC60DC41445FD4EEF5C37348")
    public int getAndroidPuaFromVendorSpecificPua(int vsp) {
        int var70F5CE10206AFB73309604A98CB9FD21_834857314 = (nativeGetAndroidPuaFromVendorSpecificPua(mNativeEmojiFactory, vsp));
        addTaint(vsp);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1615365025 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1615365025;
        // ---------- Original Method ----------
        //return nativeGetAndroidPuaFromVendorSpecificPua(mNativeEmojiFactory, vsp);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.029 -0400", hash_original_method = "332632D7825438D0B8DBF43F7E76A339", hash_generated_method = "5B43A5E78207F12477790EC059AC8979")
    public String getAndroidPuaFromVendorSpecificPua(String vspString) {
        String varB4EAC82CA7396A68D541C85D26508E83_1790504925 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1692965378 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1790504925 = null;
        } //End block
        int minVsp;
        minVsp = nativeGetMinimumVendorSpecificPua(mNativeEmojiFactory);
        int maxVsp;
        maxVsp = nativeGetMaximumVendorSpecificPua(mNativeEmojiFactory);
        int len;
        len = vspString.length();
        int[] codePoints;
        codePoints = new int[vspString.codePointCount(0, len)];
        int new_len;
        new_len = 0;
        {
            int i;
            i = 0;
            i = vspString.offsetByCodePoints(i, 1);
            {
                int codePoint;
                codePoint = vspString.codePointAt(i);
                {
                    int newCodePoint;
                    newCodePoint = getAndroidPuaFromVendorSpecificPua(codePoint);
                    {
                        codePoints[new_len] = newCodePoint;
                    } //End block
                } //End block
                codePoints[new_len] = codePoint;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1692965378 = new String(codePoints, 0, new_len);
        addTaint(vspString.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1160971250; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1160971250 = varB4EAC82CA7396A68D541C85D26508E83_1790504925;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1160971250 = varB4EAC82CA7396A68D541C85D26508E83_1692965378;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1160971250.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1160971250;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.034 -0400", hash_original_method = "B08EB100AB82E54ADADC386CF8B33D33", hash_generated_method = "6813C170888F4F70024513C1DDBA1A2C")
    public int getVendorSpecificPuaFromAndroidPua(int pua) {
        int varD354C24A4941A2811A9CD1AB35D65E36_165013740 = (nativeGetVendorSpecificPuaFromAndroidPua(mNativeEmojiFactory, pua));
        addTaint(pua);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1843457765 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1843457765;
        // ---------- Original Method ----------
        //return nativeGetVendorSpecificPuaFromAndroidPua(mNativeEmojiFactory, pua);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.049 -0400", hash_original_method = "6085ED2713FAD0096DF7C4BD4C86F8DD", hash_generated_method = "4C05EAA189E52AB651369E3A91090BC2")
    public String getVendorSpecificPuaFromAndroidPua(String puaString) {
        String varB4EAC82CA7396A68D541C85D26508E83_515571880 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_436343561 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_515571880 = null;
        } //End block
        int minVsp;
        minVsp = nativeGetMinimumAndroidPua(mNativeEmojiFactory);
        int maxVsp;
        maxVsp = nativeGetMaximumAndroidPua(mNativeEmojiFactory);
        int len;
        len = puaString.length();
        int[] codePoints;
        codePoints = new int[puaString.codePointCount(0, len)];
        int new_len;
        new_len = 0;
        {
            int i;
            i = 0;
            i = puaString.offsetByCodePoints(i, 1);
            {
                int codePoint;
                codePoint = puaString.codePointAt(i);
                {
                    int newCodePoint;
                    newCodePoint = getVendorSpecificPuaFromAndroidPua(codePoint);
                    {
                        codePoints[new_len] = newCodePoint;
                    } //End block
                } //End block
                codePoints[new_len] = codePoint;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_436343561 = new String(codePoints, 0, new_len);
        addTaint(puaString.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1192130503; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1192130503 = varB4EAC82CA7396A68D541C85D26508E83_515571880;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1192130503 = varB4EAC82CA7396A68D541C85D26508E83_436343561;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1192130503.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1192130503;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        public static EmojiFactory newInstance(String class_name) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        public static EmojiFactory newAvailableInstance() {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.062 -0400", hash_original_method = "E94B589829434939D487652724460608", hash_generated_method = "01CDA2950A3A42C93808A7C0EE9EA3F3")
    public int getMinimumAndroidPua() {
        int varCB479F1E511B763D23ECFD817A95C207_512052288 = (nativeGetMinimumAndroidPua(mNativeEmojiFactory));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1984814288 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1984814288;
        // ---------- Original Method ----------
        //return nativeGetMinimumAndroidPua(mNativeEmojiFactory);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.062 -0400", hash_original_method = "84EA08D07D32F9FA087FFC75B38A56E8", hash_generated_method = "AB941894B133704DBDD38183D1CFF6A4")
    public int getMaximumAndroidPua() {
        int var2FC718F3AE897ED82051F97F3361EB32_298532956 = (nativeGetMaximumAndroidPua(mNativeEmojiFactory));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1359801714 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1359801714;
        // ---------- Original Method ----------
        //return nativeGetMaximumAndroidPua(mNativeEmojiFactory);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.063 -0400", hash_original_method = "996F154EA43AB1D5A4C151D656C37CF1", hash_generated_method = "306E1F6D8D2B1E2FAFA21FC83BAC450E")
    private void nativeDestructor(int factory) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.063 -0400", hash_original_method = "3AA105C3169886A719F2BF7A3237E4A3", hash_generated_method = "1FEDBE13E2C3435ECCCBB1756DB5C9E3")
    private Bitmap nativeGetBitmapFromAndroidPua(int nativeEmojiFactory, int AndroidPua) {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.064 -0400", hash_original_method = "3A1554F06CC9CCAF25F7BBE93248CE83", hash_generated_method = "55F9594FB1E91CF15AACA9E70C9ED9A2")
    private int nativeGetAndroidPuaFromVendorSpecificSjis(int nativeEmojiFactory,
            char sjis) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1071094382 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1071094382;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.064 -0400", hash_original_method = "C302C3634C2FA6E6CA4CF2CF66D12101", hash_generated_method = "243D5A4FC6978B7E8B61A56A4F642C3E")
    private int nativeGetVendorSpecificSjisFromAndroidPua(int nativeEmojiFactory,
            int pua) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1675063349 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1675063349;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.065 -0400", hash_original_method = "75FE7601C9BA865A32982CD0867F654C", hash_generated_method = "D1D2591B4B21DE8DE3DACB4564E2C76A")
    private int nativeGetAndroidPuaFromVendorSpecificPua(int nativeEmojiFactory,
            int vsp) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_777240112 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_777240112;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.077 -0400", hash_original_method = "B406416ABF41BEA242E5A40B8BA7386A", hash_generated_method = "35FD91F544310E9FF0CFF9F9A591AF43")
    private int nativeGetVendorSpecificPuaFromAndroidPua(int nativeEmojiFactory,
            int pua) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1437948902 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1437948902;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.078 -0400", hash_original_method = "5A805426DAFA5C3640F25323B1C3B8F5", hash_generated_method = "1C0384DF5B6CF9A4166861A52A6B0535")
    private int nativeGetMaximumVendorSpecificPua(int nativeEmojiFactory) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_336731338 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_336731338;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.078 -0400", hash_original_method = "0FF4320BBE7657B90285375F65F4DF9D", hash_generated_method = "5186C05C7932BBAE12724E0C6E7D7C9D")
    private int nativeGetMinimumVendorSpecificPua(int nativeEmojiFactory) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1176786482 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1176786482;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.078 -0400", hash_original_method = "800100FBB9205E441349161A70ADF047", hash_generated_method = "874E23474CFF7390CDB2F89A937E9601")
    private int nativeGetMaximumAndroidPua(int nativeEmojiFactory) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1610622746 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1610622746;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.079 -0400", hash_original_method = "5875EE70D8D47117F3D06FA307D98BB5", hash_generated_method = "313F43F59A5F1AD359912924AF8393EB")
    private int nativeGetMinimumAndroidPua(int nativeEmojiFactory) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1925663384 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1925663384;
    }

    
    private class CustomLinkedHashMap<K, V> extends LinkedHashMap<K, V> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.088 -0400", hash_original_method = "EFD1513E9BFBC9B14636F3CC7AC41B6C", hash_generated_method = "19A9879B12E07C26C0FDCF805FDF3C6D")
        public  CustomLinkedHashMap() {
            super(16, 0.75f, true);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.103 -0400", hash_original_method = "A5B2DC9A6DACFA347C16D8B42A67BD03", hash_generated_method = "359C6BBA333B9F65D5E33F63421629B9")
        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            boolean varC11A82D981A81510AE8FF14A739DFE21_1895000755 = (size() > sCacheSize);
            addTaint(eldest.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_847447224 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_847447224;
            // ---------- Original Method ----------
            //return size() > sCacheSize;
        }

        
    }


    
}

