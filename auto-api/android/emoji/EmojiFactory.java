package android.emoji;

// Droidsafe Imports
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;

import android.graphics.Bitmap;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;
// import Iterator to deal with enhanced for loop translation

public final class EmojiFactory {
    private int sCacheSize = 100;
    private int mNativeEmojiFactory;
    private String mName;
    private Map<Integer, WeakReference<Bitmap>> mCache;
    
    @DSModeled(DSC.BAN) // Added to support native method calls that return an EmojiFactory
    private EmojiFactory() {
    	
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.877 -0400", hash_original_method = "3CFB061344A54165CC98223BF316C16E", hash_generated_method = "10D340B315458066E4CAA6C8D5571368")
    @DSModeled(DSC.SAFE)
    private EmojiFactory(int nativeEmojiFactory, String name) {
        dsTaint.addTaint(nativeEmojiFactory);
        dsTaint.addTaint(name);
        mCache = new CustomLinkedHashMap<Integer, WeakReference<Bitmap>>();
        // ---------- Original Method ----------
        //mNativeEmojiFactory = nativeEmojiFactory;
        //mName = name;
        //mCache = new CustomLinkedHashMap<Integer, WeakReference<Bitmap>>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.877 -0400", hash_original_method = "32C84A5952A8F243E533AA978C471609", hash_generated_method = "E7EF23898D3FF06F0AF760AC73FEBD3B")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.878 -0400", hash_original_method = "61A4CE5E0B45509C63F06179C920C9C2", hash_generated_method = "53220572DAFCECACDD8BD94775891392")
    @DSModeled(DSC.SAFE)
    public String name() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.878 -0400", hash_original_method = "51D3837892087BC1526F97486EB96A82", hash_generated_method = "25B04552FFB8375CFAD95A61DA82D6E7")
    @DSModeled(DSC.SAFE)
    public synchronized Bitmap getBitmapFromAndroidPua(int pua) {
        dsTaint.addTaint(pua);
        WeakReference<Bitmap> cache;
        cache = mCache.get(pua);
        {
            Bitmap ret;
            ret = nativeGetBitmapFromAndroidPua(mNativeEmojiFactory, pua);
            {
                mCache.put(pua, new WeakReference<Bitmap>(ret));
            } //End block
        } //End block
        {
            Bitmap tmp;
            tmp = cache.get();
            {
                Bitmap ret;
                ret = nativeGetBitmapFromAndroidPua(mNativeEmojiFactory, pua);
                mCache.put(pua, new WeakReference<Bitmap>(ret));
            } //End block
        } //End block
        return (Bitmap)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.878 -0400", hash_original_method = "9A7284FF37A5214E9B7F9311E2EF3E6C", hash_generated_method = "6A5749A7D3BAEAEB38E059FD5EDAD6E7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized Bitmap getBitmapFromVendorSpecificSjis(char sjis) {
        dsTaint.addTaint(sjis);
        Bitmap varCA8CEB83AA8EA8E2575DEAAD2AA611F7_760869283 = (getBitmapFromAndroidPua(getAndroidPuaFromVendorSpecificSjis(sjis)));
        return (Bitmap)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getBitmapFromAndroidPua(getAndroidPuaFromVendorSpecificSjis(sjis));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.879 -0400", hash_original_method = "F5F3B81D8E941B288B2A41FCC9367619", hash_generated_method = "8C06B85FAF9981210F54F7A69ADE5031")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized Bitmap getBitmapFromVendorSpecificPua(int vsp) {
        dsTaint.addTaint(vsp);
        Bitmap var6F7C48042B60FF94F4F57B0EE542334F_372175663 = (getBitmapFromAndroidPua(getAndroidPuaFromVendorSpecificPua(vsp)));
        return (Bitmap)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getBitmapFromAndroidPua(getAndroidPuaFromVendorSpecificPua(vsp));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.879 -0400", hash_original_method = "5E0818C254D368AF2876C64915580604", hash_generated_method = "B9E1CD02DF7DDD6872197AA65F6A435A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getAndroidPuaFromVendorSpecificSjis(char sjis) {
        dsTaint.addTaint(sjis);
        int var74C2D334EFE3998285C80D7E5E8A8BE7_246245195 = (nativeGetAndroidPuaFromVendorSpecificSjis(mNativeEmojiFactory, sjis));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return nativeGetAndroidPuaFromVendorSpecificSjis(mNativeEmojiFactory, sjis);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.879 -0400", hash_original_method = "CAA9928E1DDFC9E6AF0D5DC613844580", hash_generated_method = "23FED82F4D01F7B94546112C32B26B66")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getVendorSpecificSjisFromAndroidPua(int pua) {
        dsTaint.addTaint(pua);
        int varD1B8764BBE902D599DA4F2D19767BBAC_2060599051 = (nativeGetVendorSpecificSjisFromAndroidPua(mNativeEmojiFactory, pua));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return nativeGetVendorSpecificSjisFromAndroidPua(mNativeEmojiFactory, pua);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.879 -0400", hash_original_method = "BF155C8450604BCD58870D68939F5C48", hash_generated_method = "A4DBC467979B570085F0CA89EEAA0230")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getAndroidPuaFromVendorSpecificPua(int vsp) {
        dsTaint.addTaint(vsp);
        int var70F5CE10206AFB73309604A98CB9FD21_564012513 = (nativeGetAndroidPuaFromVendorSpecificPua(mNativeEmojiFactory, vsp));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return nativeGetAndroidPuaFromVendorSpecificPua(mNativeEmojiFactory, vsp);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.880 -0400", hash_original_method = "332632D7825438D0B8DBF43F7E76A339", hash_generated_method = "4FBE322F37B7F2620EA19570D9C0C158")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getAndroidPuaFromVendorSpecificPua(String vspString) {
        dsTaint.addTaint(vspString);
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
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.880 -0400", hash_original_method = "B08EB100AB82E54ADADC386CF8B33D33", hash_generated_method = "027EA8C9EF1255CAB3A1292DB9874A1B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getVendorSpecificPuaFromAndroidPua(int pua) {
        dsTaint.addTaint(pua);
        int varD354C24A4941A2811A9CD1AB35D65E36_1204525292 = (nativeGetVendorSpecificPuaFromAndroidPua(mNativeEmojiFactory, pua));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return nativeGetVendorSpecificPuaFromAndroidPua(mNativeEmojiFactory, pua);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.881 -0400", hash_original_method = "6085ED2713FAD0096DF7C4BD4C86F8DD", hash_generated_method = "E30D767D9464E2A00214BD53DCF1F4FD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getVendorSpecificPuaFromAndroidPua(String puaString) {
        dsTaint.addTaint(puaString);
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
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.881 -0400", hash_original_method = "423346FA0C16BA32B457763E80C8224E", hash_generated_method = "9B237D4C55695E1384CB5D3FE3CAAB3F")
    @DSModeled(DSC.BAN)
    public static EmojiFactory newInstance(String class_name) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return new EmojiFactory();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.881 -0400", hash_original_method = "75D3977F7B3982A73421732EA4218450", hash_generated_method = "9096D1C587991621D42EA7B734675E17")
    public static EmojiFactory newAvailableInstance() {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return new EmojiFactory();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.881 -0400", hash_original_method = "E94B589829434939D487652724460608", hash_generated_method = "316470257DB4E708F26602ED09CF02AF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getMinimumAndroidPua() {
        int varCB479F1E511B763D23ECFD817A95C207_1867845419 = (nativeGetMinimumAndroidPua(mNativeEmojiFactory));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return nativeGetMinimumAndroidPua(mNativeEmojiFactory);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.882 -0400", hash_original_method = "84EA08D07D32F9FA087FFC75B38A56E8", hash_generated_method = "5039F58BB3EED4ABBD34CFF602B18C84")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getMaximumAndroidPua() {
        int var2FC718F3AE897ED82051F97F3361EB32_376102507 = (nativeGetMaximumAndroidPua(mNativeEmojiFactory));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return nativeGetMaximumAndroidPua(mNativeEmojiFactory);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.882 -0400", hash_original_method = "996F154EA43AB1D5A4C151D656C37CF1", hash_generated_method = "23529D17CCAEA42CC0E0031B2D39D79E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeDestructor(int factory) {
        dsTaint.addTaint(factory);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.882 -0400", hash_original_method = "3AA105C3169886A719F2BF7A3237E4A3", hash_generated_method = "DAB2B48A55238A742AF8B508F8865FA4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Bitmap nativeGetBitmapFromAndroidPua(int nativeEmojiFactory, int AndroidPua) {
        dsTaint.addTaint(AndroidPua);
        dsTaint.addTaint(nativeEmojiFactory);
        return new Bitmap();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.882 -0400", hash_original_method = "3A1554F06CC9CCAF25F7BBE93248CE83", hash_generated_method = "F1B0201F2BB3741B8DB28C45229C9459")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int nativeGetAndroidPuaFromVendorSpecificSjis(int nativeEmojiFactory,
            char sjis) {
        dsTaint.addTaint(sjis);
        dsTaint.addTaint(nativeEmojiFactory);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.882 -0400", hash_original_method = "C302C3634C2FA6E6CA4CF2CF66D12101", hash_generated_method = "4AB7051A61775635866A9342CBB73392")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int nativeGetVendorSpecificSjisFromAndroidPua(int nativeEmojiFactory,
            int pua) {
        dsTaint.addTaint(nativeEmojiFactory);
        dsTaint.addTaint(pua);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.882 -0400", hash_original_method = "75FE7601C9BA865A32982CD0867F654C", hash_generated_method = "432F1476D21312AC6A381DACC2EA6711")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int nativeGetAndroidPuaFromVendorSpecificPua(int nativeEmojiFactory,
            int vsp) {
        dsTaint.addTaint(nativeEmojiFactory);
        dsTaint.addTaint(vsp);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.883 -0400", hash_original_method = "B406416ABF41BEA242E5A40B8BA7386A", hash_generated_method = "238F59B6133EB6C3773EFE8840602BFA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int nativeGetVendorSpecificPuaFromAndroidPua(int nativeEmojiFactory,
            int pua) {
        dsTaint.addTaint(nativeEmojiFactory);
        dsTaint.addTaint(pua);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.883 -0400", hash_original_method = "5A805426DAFA5C3640F25323B1C3B8F5", hash_generated_method = "2A1F661433A1A2E9AB78958E1253C5CD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int nativeGetMaximumVendorSpecificPua(int nativeEmojiFactory) {
        dsTaint.addTaint(nativeEmojiFactory);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.883 -0400", hash_original_method = "0FF4320BBE7657B90285375F65F4DF9D", hash_generated_method = "0AA292D9196DD562714C7C811BB55A24")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int nativeGetMinimumVendorSpecificPua(int nativeEmojiFactory) {
        dsTaint.addTaint(nativeEmojiFactory);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.883 -0400", hash_original_method = "800100FBB9205E441349161A70ADF047", hash_generated_method = "C4CD1DB12CAAA494CB2FD56A6F4AFECB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int nativeGetMaximumAndroidPua(int nativeEmojiFactory) {
        dsTaint.addTaint(nativeEmojiFactory);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.883 -0400", hash_original_method = "5875EE70D8D47117F3D06FA307D98BB5", hash_generated_method = "91DB16AD1C6FFE8B30622133A7AE44E2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int nativeGetMinimumAndroidPua(int nativeEmojiFactory) {
        dsTaint.addTaint(nativeEmojiFactory);
        return dsTaint.getTaintInt();
    }

    
    private class CustomLinkedHashMap<K, V> extends LinkedHashMap<K, V> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.883 -0400", hash_original_method = "EFD1513E9BFBC9B14636F3CC7AC41B6C", hash_generated_method = "A7F34779F2A8558A5C723E1E3F71DE58")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public CustomLinkedHashMap() {
            super(16, 0.75f, true);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.884 -0400", hash_original_method = "A5B2DC9A6DACFA347C16D8B42A67BD03", hash_generated_method = "CB0A5BF8CA47DDB8E9AC3944EF7E85A5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            dsTaint.addTaint(eldest.dsTaint);
            boolean varC11A82D981A81510AE8FF14A739DFE21_202985243 = (size() > sCacheSize);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return size() > sCacheSize;
        }

        
    }


    
}


