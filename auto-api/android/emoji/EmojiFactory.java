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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.506 -0400", hash_original_field = "FC3844AD7E0AD1A2D30D63DA701B5F11", hash_generated_field = "6AC97E1F58C9735B2329D1C9A5ED4485")

    private int sCacheSize = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.506 -0400", hash_original_field = "650F7524EE08C39E1DEFAEA8CCFCE80B", hash_generated_field = "784016E98C992E67132EEDB525B62E7A")

    private int mNativeEmojiFactory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.506 -0400", hash_original_field = "311C2C8498DF6A626CBDB8AA4193499C", hash_generated_field = "886C24C67739C97CF77B8DD239E412F9")

    private String mName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.506 -0400", hash_original_field = "FA75DB4B1A95A78968F552A9DCC88B0C", hash_generated_field = "7AF93DEFFB076EA51D0A22D3C0D4BF98")

    private Map<Integer, WeakReference<Bitmap>> mCache;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.507 -0400", hash_original_method = "3CFB061344A54165CC98223BF316C16E", hash_generated_method = "C7D0D69F38285DF25F7919D10B271128")
    private  EmojiFactory(int nativeEmojiFactory, String name) {
        mNativeEmojiFactory = nativeEmojiFactory;
        mName = name;
        mCache = new CustomLinkedHashMap<Integer, WeakReference<Bitmap>>();
        // ---------- Original Method ----------
        //mNativeEmojiFactory = nativeEmojiFactory;
        //mName = name;
        //mCache = new CustomLinkedHashMap<Integer, WeakReference<Bitmap>>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.508 -0400", hash_original_method = "32C84A5952A8F243E533AA978C471609", hash_generated_method = "1022AB339BCE8F38D8D3090647D24799")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.529 -0400", hash_original_method = "61A4CE5E0B45509C63F06179C920C9C2", hash_generated_method = "B0FCD114996F3DDB6146E79920E7E56A")
    public String name() {
        String varB4EAC82CA7396A68D541C85D26508E83_1232081479 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1232081479 = mName;
        varB4EAC82CA7396A68D541C85D26508E83_1232081479.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1232081479;
        // ---------- Original Method ----------
        //return mName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.531 -0400", hash_original_method = "51D3837892087BC1526F97486EB96A82", hash_generated_method = "53E586A60EF1232DBFF14111F93DA59F")
    public synchronized Bitmap getBitmapFromAndroidPua(int pua) {
        Bitmap varB4EAC82CA7396A68D541C85D26508E83_1071699842 = null; //Variable for return #1
        Bitmap varB4EAC82CA7396A68D541C85D26508E83_1028030206 = null; //Variable for return #2
        Bitmap varB4EAC82CA7396A68D541C85D26508E83_994296516 = null; //Variable for return #3
        WeakReference<Bitmap> cache;
        cache = mCache.get(pua);
        {
            Bitmap ret;
            ret = nativeGetBitmapFromAndroidPua(mNativeEmojiFactory, pua);
            {
                mCache.put(pua, new WeakReference<Bitmap>(ret));
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1071699842 = ret;
        } //End block
        {
            Bitmap tmp;
            tmp = cache.get();
            {
                Bitmap ret;
                ret = nativeGetBitmapFromAndroidPua(mNativeEmojiFactory, pua);
                mCache.put(pua, new WeakReference<Bitmap>(ret));
                varB4EAC82CA7396A68D541C85D26508E83_1028030206 = ret;
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_994296516 = tmp;
            } //End block
        } //End block
        addTaint(pua);
        Bitmap varA7E53CE21691AB073D9660D615818899_385035805; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_385035805 = varB4EAC82CA7396A68D541C85D26508E83_1071699842;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_385035805 = varB4EAC82CA7396A68D541C85D26508E83_1028030206;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_385035805 = varB4EAC82CA7396A68D541C85D26508E83_994296516;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_385035805.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_385035805;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.532 -0400", hash_original_method = "9A7284FF37A5214E9B7F9311E2EF3E6C", hash_generated_method = "ECFF8877564E1DE018B8977ABD73B67F")
    public synchronized Bitmap getBitmapFromVendorSpecificSjis(char sjis) {
        Bitmap varB4EAC82CA7396A68D541C85D26508E83_2092307606 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2092307606 = getBitmapFromAndroidPua(getAndroidPuaFromVendorSpecificSjis(sjis));
        addTaint(sjis);
        varB4EAC82CA7396A68D541C85D26508E83_2092307606.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2092307606;
        // ---------- Original Method ----------
        //return getBitmapFromAndroidPua(getAndroidPuaFromVendorSpecificSjis(sjis));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.533 -0400", hash_original_method = "F5F3B81D8E941B288B2A41FCC9367619", hash_generated_method = "D534FD7B9C860E2E92B20EC8E2FBB6DB")
    public synchronized Bitmap getBitmapFromVendorSpecificPua(int vsp) {
        Bitmap varB4EAC82CA7396A68D541C85D26508E83_1283877980 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1283877980 = getBitmapFromAndroidPua(getAndroidPuaFromVendorSpecificPua(vsp));
        addTaint(vsp);
        varB4EAC82CA7396A68D541C85D26508E83_1283877980.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1283877980;
        // ---------- Original Method ----------
        //return getBitmapFromAndroidPua(getAndroidPuaFromVendorSpecificPua(vsp));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.549 -0400", hash_original_method = "5E0818C254D368AF2876C64915580604", hash_generated_method = "D9F139A0AC219B2A19B50CDE230F2285")
    public int getAndroidPuaFromVendorSpecificSjis(char sjis) {
        int var74C2D334EFE3998285C80D7E5E8A8BE7_286379711 = (nativeGetAndroidPuaFromVendorSpecificSjis(mNativeEmojiFactory, sjis));
        addTaint(sjis);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1801844745 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1801844745;
        // ---------- Original Method ----------
        //return nativeGetAndroidPuaFromVendorSpecificSjis(mNativeEmojiFactory, sjis);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.551 -0400", hash_original_method = "CAA9928E1DDFC9E6AF0D5DC613844580", hash_generated_method = "797AC9010CA6D0D4B2E833F2FCC71D87")
    public int getVendorSpecificSjisFromAndroidPua(int pua) {
        int varD1B8764BBE902D599DA4F2D19767BBAC_1044432062 = (nativeGetVendorSpecificSjisFromAndroidPua(mNativeEmojiFactory, pua));
        addTaint(pua);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_321412017 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_321412017;
        // ---------- Original Method ----------
        //return nativeGetVendorSpecificSjisFromAndroidPua(mNativeEmojiFactory, pua);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.552 -0400", hash_original_method = "BF155C8450604BCD58870D68939F5C48", hash_generated_method = "88AF1C1E08B002F04C77A246A7EC8D20")
    public int getAndroidPuaFromVendorSpecificPua(int vsp) {
        int var70F5CE10206AFB73309604A98CB9FD21_1670602395 = (nativeGetAndroidPuaFromVendorSpecificPua(mNativeEmojiFactory, vsp));
        addTaint(vsp);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_745774481 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_745774481;
        // ---------- Original Method ----------
        //return nativeGetAndroidPuaFromVendorSpecificPua(mNativeEmojiFactory, vsp);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.557 -0400", hash_original_method = "332632D7825438D0B8DBF43F7E76A339", hash_generated_method = "5EB582C9DAA0A63FFA58519627C1F2A5")
    public String getAndroidPuaFromVendorSpecificPua(String vspString) {
        String varB4EAC82CA7396A68D541C85D26508E83_2067768053 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_221738284 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_2067768053 = null;
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
        varB4EAC82CA7396A68D541C85D26508E83_221738284 = new String(codePoints, 0, new_len);
        addTaint(vspString.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1186330798; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1186330798 = varB4EAC82CA7396A68D541C85D26508E83_2067768053;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1186330798 = varB4EAC82CA7396A68D541C85D26508E83_221738284;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1186330798.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1186330798;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.581 -0400", hash_original_method = "B08EB100AB82E54ADADC386CF8B33D33", hash_generated_method = "6173DF7E170C6406D08B30AF8CCED853")
    public int getVendorSpecificPuaFromAndroidPua(int pua) {
        int varD354C24A4941A2811A9CD1AB35D65E36_1079618101 = (nativeGetVendorSpecificPuaFromAndroidPua(mNativeEmojiFactory, pua));
        addTaint(pua);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1906240785 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1906240785;
        // ---------- Original Method ----------
        //return nativeGetVendorSpecificPuaFromAndroidPua(mNativeEmojiFactory, pua);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.586 -0400", hash_original_method = "6085ED2713FAD0096DF7C4BD4C86F8DD", hash_generated_method = "05355169062668E07C0972B9F2A0BBC5")
    public String getVendorSpecificPuaFromAndroidPua(String puaString) {
        String varB4EAC82CA7396A68D541C85D26508E83_997364564 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1206855052 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_997364564 = null;
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
        varB4EAC82CA7396A68D541C85D26508E83_1206855052 = new String(codePoints, 0, new_len);
        addTaint(puaString.getTaint());
        String varA7E53CE21691AB073D9660D615818899_933289758; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_933289758 = varB4EAC82CA7396A68D541C85D26508E83_997364564;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_933289758 = varB4EAC82CA7396A68D541C85D26508E83_1206855052;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_933289758.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_933289758;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        public static EmojiFactory newInstance(String class_name) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        public static EmojiFactory newAvailableInstance() {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.587 -0400", hash_original_method = "E94B589829434939D487652724460608", hash_generated_method = "D1CF1F13E34DAFE81221D70218613955")
    public int getMinimumAndroidPua() {
        int varCB479F1E511B763D23ECFD817A95C207_965055492 = (nativeGetMinimumAndroidPua(mNativeEmojiFactory));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_827682869 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_827682869;
        // ---------- Original Method ----------
        //return nativeGetMinimumAndroidPua(mNativeEmojiFactory);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.603 -0400", hash_original_method = "84EA08D07D32F9FA087FFC75B38A56E8", hash_generated_method = "A5F2C1539EE823D51B2814821F83BDC1")
    public int getMaximumAndroidPua() {
        int var2FC718F3AE897ED82051F97F3361EB32_102977304 = (nativeGetMaximumAndroidPua(mNativeEmojiFactory));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_92697435 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_92697435;
        // ---------- Original Method ----------
        //return nativeGetMaximumAndroidPua(mNativeEmojiFactory);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.604 -0400", hash_original_method = "996F154EA43AB1D5A4C151D656C37CF1", hash_generated_method = "306E1F6D8D2B1E2FAFA21FC83BAC450E")
    private void nativeDestructor(int factory) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.604 -0400", hash_original_method = "3AA105C3169886A719F2BF7A3237E4A3", hash_generated_method = "1FEDBE13E2C3435ECCCBB1756DB5C9E3")
    private Bitmap nativeGetBitmapFromAndroidPua(int nativeEmojiFactory, int AndroidPua) {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.605 -0400", hash_original_method = "3A1554F06CC9CCAF25F7BBE93248CE83", hash_generated_method = "4EE6A9882957E402A218B7C3366B7B12")
    private int nativeGetAndroidPuaFromVendorSpecificSjis(int nativeEmojiFactory,
            char sjis) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1899346141 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1899346141;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.605 -0400", hash_original_method = "C302C3634C2FA6E6CA4CF2CF66D12101", hash_generated_method = "C4FCA8560928889B7DF7DBBE184A9D0F")
    private int nativeGetVendorSpecificSjisFromAndroidPua(int nativeEmojiFactory,
            int pua) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_727061709 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_727061709;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.609 -0400", hash_original_method = "75FE7601C9BA865A32982CD0867F654C", hash_generated_method = "35DB6C96E130195B1A9F5499A2627F5F")
    private int nativeGetAndroidPuaFromVendorSpecificPua(int nativeEmojiFactory,
            int vsp) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_939436233 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_939436233;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.609 -0400", hash_original_method = "B406416ABF41BEA242E5A40B8BA7386A", hash_generated_method = "3F9E078280E0D21EFC6152385C86910E")
    private int nativeGetVendorSpecificPuaFromAndroidPua(int nativeEmojiFactory,
            int pua) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1529382667 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1529382667;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.609 -0400", hash_original_method = "5A805426DAFA5C3640F25323B1C3B8F5", hash_generated_method = "20A164BF26D7532891647E32B276794F")
    private int nativeGetMaximumVendorSpecificPua(int nativeEmojiFactory) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1352875895 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1352875895;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.612 -0400", hash_original_method = "0FF4320BBE7657B90285375F65F4DF9D", hash_generated_method = "95CF035804D3A3B0AC86F052CF42A231")
    private int nativeGetMinimumVendorSpecificPua(int nativeEmojiFactory) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1198811883 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1198811883;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.613 -0400", hash_original_method = "800100FBB9205E441349161A70ADF047", hash_generated_method = "65FCABCE10C83C64FBD17BD065593D74")
    private int nativeGetMaximumAndroidPua(int nativeEmojiFactory) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_728641681 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_728641681;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.613 -0400", hash_original_method = "5875EE70D8D47117F3D06FA307D98BB5", hash_generated_method = "2237194CD3CDEAD2FAE2A113AA51628D")
    private int nativeGetMinimumAndroidPua(int nativeEmojiFactory) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_365008768 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_365008768;
    }

    
    private class CustomLinkedHashMap<K, V> extends LinkedHashMap<K, V> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.614 -0400", hash_original_method = "EFD1513E9BFBC9B14636F3CC7AC41B6C", hash_generated_method = "19A9879B12E07C26C0FDCF805FDF3C6D")
        public  CustomLinkedHashMap() {
            super(16, 0.75f, true);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.614 -0400", hash_original_method = "A5B2DC9A6DACFA347C16D8B42A67BD03", hash_generated_method = "AD58093A49497ECFAAD480DBEB440C1C")
        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            boolean varC11A82D981A81510AE8FF14A739DFE21_634060445 = (size() > sCacheSize);
            addTaint(eldest.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_599451119 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_599451119;
            // ---------- Original Method ----------
            //return size() > sCacheSize;
        }

        
    }


    
}

