package android.emoji;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;

import android.graphics.Bitmap;





public final class EmojiFactory {

    
    @DSModeled(DSC.SAFE)
    public static EmojiFactory newInstance(String class_name) {
		return new EmojiFactory(0, class_name);
	}

    
    @DSModeled(DSC.SAFE)
    public static EmojiFactory newAvailableInstance() {
		return new EmojiFactory(0, "");
	}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.690 -0500", hash_original_field = "34B6C988AEF9552720828C1EB6994ECC", hash_generated_field = "6AC97E1F58C9735B2329D1C9A5ED4485")

    
    private int sCacheSize = 100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.694 -0500", hash_original_field = "3809FB8DE19FF3CFBF1994106A2F0DFF", hash_generated_field = "784016E98C992E67132EEDB525B62E7A")

    private int mNativeEmojiFactory;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.694 -0500", hash_original_field = "ED29A5CAC2A4A14894CD28BA3B1CE29C", hash_generated_field = "886C24C67739C97CF77B8DD239E412F9")

    private String mName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.695 -0500", hash_original_field = "17284B2FCB5B9D4E9C776863230CBE35", hash_generated_field = "7AF93DEFFB076EA51D0A22D3C0D4BF98")

    private Map<Integer, WeakReference<Bitmap>> mCache;
    
    /**
     * @noinspection UnusedDeclaration
     */
    /*
     * Private constructor that must received an already allocated native
     * EmojiFactory int (pointer).
     *
     * This can be called from JNI code.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.696 -0500", hash_original_method = "3CFB061344A54165CC98223BF316C16E", hash_generated_method = "EF6071B5D14F9C099CD84F30B7283806")
    private EmojiFactory(int nativeEmojiFactory, String name) {
        mNativeEmojiFactory = nativeEmojiFactory;
        mName = name;
        mCache = new CustomLinkedHashMap<Integer, WeakReference<Bitmap>>();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.697 -0500", hash_original_method = "32C84A5952A8F243E533AA978C471609", hash_generated_method = "760B0FA72D8CB66FD717B888FC1AF79B")
    @Override
protected void finalize() throws Throwable {
        try {
            nativeDestructor(mNativeEmojiFactory);
        } finally {
            super.finalize();
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.698 -0500", hash_original_method = "61A4CE5E0B45509C63F06179C920C9C2", hash_generated_method = "C07DB7F208C0D33007DC255F3AB7A3F4")
    public String name() {
        return mName;
    }
    
    /**
     * Returns Bitmap object corresponding to the AndroidPua.
     * 
     * Note that each Bitmap is cached by this class, which means that, if you modify a
     * Bitmap object (using setPos() method), all same emoji Bitmap will be modified.
     * If it is unacceptable, please copy the object before modifying it.
     *  
     * @param pua A unicode codepoint.
     * @return Bitmap object when this factory knows the Bitmap relevant to the codepoint.
     * Otherwise null is returned.  
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.699 -0500", hash_original_method = "51D3837892087BC1526F97486EB96A82", hash_generated_method = "31DE90672EEB09E659C8B6C245AD3C5D")
    public synchronized Bitmap getBitmapFromAndroidPua(int pua) {
        WeakReference<Bitmap> cache = mCache.get(pua);
        if (cache == null) {
            Bitmap ret = nativeGetBitmapFromAndroidPua(mNativeEmojiFactory, pua);
            // There is no need to cache returned null, since in most cases it means there
            // is no map from the AndroidPua to a specific image. In other words, it usually does
            // not include the cost of creating Bitmap object.
            if (ret != null) {
               mCache.put(pua, new WeakReference<Bitmap>(ret));
            }
            return ret;
        } else {
            Bitmap tmp = cache.get();
            if (tmp == null) {
                Bitmap ret = nativeGetBitmapFromAndroidPua(mNativeEmojiFactory, pua);
                mCache.put(pua, new WeakReference<Bitmap>(ret));
                return ret;
            } else {
                return tmp;
            }
        }
    }

    /**
     * Returns Bitmap object corresponding to the vendor specified sjis.
     * 
     * See comments in getBitmapFromAndroidPua().
     * 
     * @param sjis sjis code specific to each career(vendor)
     * @return Bitmap object when this factory knows the Bitmap relevant to the code. Otherwise
     * null is returned.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.699 -0500", hash_original_method = "9A7284FF37A5214E9B7F9311E2EF3E6C", hash_generated_method = "8758B57401D2A7362DDAD3B9AF892FA5")
    public synchronized Bitmap getBitmapFromVendorSpecificSjis(char sjis) {
        return getBitmapFromAndroidPua(getAndroidPuaFromVendorSpecificSjis(sjis));
    }

    /**
     * Returns Bitmap object corresponding to the vendor specific Unicode.
     * 
     * See comments in getBitmapFromAndroidPua().
     * 
     * @param vsp vendor specific PUA.
     * @return Bitmap object when this factory knows the Bitmap relevant to the code. Otherwise
     * null is returned.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.700 -0500", hash_original_method = "F5F3B81D8E941B288B2A41FCC9367619", hash_generated_method = "02FCB5B09C95BFB34E0B3D4A1C86BACD")
    public synchronized Bitmap getBitmapFromVendorSpecificPua(int vsp) {
        return getBitmapFromAndroidPua(getAndroidPuaFromVendorSpecificPua(vsp));
    }
    
    /**
     * Returns Unicode PUA for Android corresponding to the vendor specific sjis.
     * 
     * @param sjis vendor specific sjis
     * @return Unicode PUA for Android, or -1 if there's no map for the sjis.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.701 -0500", hash_original_method = "5E0818C254D368AF2876C64915580604", hash_generated_method = "40282940B9EC925ED3F1E6FCD9570564")
    public int getAndroidPuaFromVendorSpecificSjis(char sjis) {
        return nativeGetAndroidPuaFromVendorSpecificSjis(mNativeEmojiFactory, sjis);
    }
    
    /**
     * Returns vendor specific sjis corresponding to the Unicode AndroidPua.
     * 
     * @param pua Unicode PUA for Android,
     * @return vendor specific sjis, or -1 if there's no map for the AndroidPua.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.702 -0500", hash_original_method = "CAA9928E1DDFC9E6AF0D5DC613844580", hash_generated_method = "6825ADAC1FFDD121E6CFB037EFD3E46D")
    public int getVendorSpecificSjisFromAndroidPua(int pua) {
        return nativeGetVendorSpecificSjisFromAndroidPua(mNativeEmojiFactory, pua);
    }
    
    /**
     * Returns Unicode PUA for Android corresponding to the vendor specific Unicode.
     * 
     * @param vsp vendor specific PUA.
     * @return Unicode PUA for Android, or -1 if there's no map for the
     * Unicode.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.703 -0500", hash_original_method = "BF155C8450604BCD58870D68939F5C48", hash_generated_method = "CC812665B631AA676D90401606774D14")
    public int getAndroidPuaFromVendorSpecificPua(int vsp) {
        return nativeGetAndroidPuaFromVendorSpecificPua(mNativeEmojiFactory, vsp);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.704 -0500", hash_original_method = "332632D7825438D0B8DBF43F7E76A339", hash_generated_method = "8CD3921A434071F3F5D856ECC35439D0")
    public String getAndroidPuaFromVendorSpecificPua(String vspString) {
        if (vspString == null) {
            return null;
        }
        int minVsp = nativeGetMinimumVendorSpecificPua(mNativeEmojiFactory);
        int maxVsp = nativeGetMaximumVendorSpecificPua(mNativeEmojiFactory);
        int len = vspString.length();
        int[] codePoints = new int[vspString.codePointCount(0, len)];

        int new_len = 0;
        for (int i = 0; i < len; i = vspString.offsetByCodePoints(i, 1), new_len++) {
            int codePoint = vspString.codePointAt(i);
            if (minVsp <= codePoint && codePoint <= maxVsp) {
                int newCodePoint = getAndroidPuaFromVendorSpecificPua(codePoint);
                if (newCodePoint > 0) {
                    codePoints[new_len] = newCodePoint;
                    continue;
                }
            }
            codePoints[new_len] = codePoint;
        }
        return new String(codePoints, 0, new_len);
    }
    
    /**
     * Returns vendor specific Unicode corresponding to the Unicode AndroidPua.
     * 
     * @param pua Unicode PUA for Android,
     * @return vendor specific sjis, or -1 if there's no map for the AndroidPua.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.704 -0500", hash_original_method = "B08EB100AB82E54ADADC386CF8B33D33", hash_generated_method = "8A5063C7C4112249E268668B66B0AE67")
    public int getVendorSpecificPuaFromAndroidPua(int pua) {
        return nativeGetVendorSpecificPuaFromAndroidPua(mNativeEmojiFactory, pua);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.705 -0500", hash_original_method = "6085ED2713FAD0096DF7C4BD4C86F8DD", hash_generated_method = "19D394CC7FFEE219C930C99726B3C910")
    public String getVendorSpecificPuaFromAndroidPua(String puaString) {
        if (puaString == null) {
            return null;
        }
        int minVsp = nativeGetMinimumAndroidPua(mNativeEmojiFactory);
        int maxVsp = nativeGetMaximumAndroidPua(mNativeEmojiFactory);
        int len = puaString.length();
        int[] codePoints = new int[puaString.codePointCount(0, len)];

        int new_len = 0;
        for (int i = 0; i < len; i = puaString.offsetByCodePoints(i, 1), new_len++) {
            int codePoint = puaString.codePointAt(i);
            if (minVsp <= codePoint && codePoint <= maxVsp) {
                int newCodePoint = getVendorSpecificPuaFromAndroidPua(codePoint);
                if (newCodePoint > 0) {
                    codePoints[new_len] = newCodePoint;
                    continue;
                }
            }
            codePoints[new_len] = codePoint;
        }
        return new String(codePoints, 0, new_len);
    }

    /**
     * Returns the lowest code point corresponding to an Android
     * emoji character.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.709 -0500", hash_original_method = "E94B589829434939D487652724460608", hash_generated_method = "6C3A76D47CF3A2F33CF7F3C57B0DBB1D")
    public int getMinimumAndroidPua() {
        return nativeGetMinimumAndroidPua(mNativeEmojiFactory);
    }

    /**
     * Returns the highest code point corresponding to an Android
     * emoji character.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.709 -0500", hash_original_method = "84EA08D07D32F9FA087FFC75B38A56E8", hash_generated_method = "DA6C0FA2F7D45A06E6AABC5C2F964F64")
    public int getMaximumAndroidPua() {
        return nativeGetMaximumAndroidPua(mNativeEmojiFactory);
    }
    
    // native methods
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:35:15.061 -0500", hash_original_method = "996F154EA43AB1D5A4C151D656C37CF1", hash_generated_method = "F9F8F4543399EA99193F64427768F130")
    private native void nativeDestructor(int factory);

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.143 -0400", hash_original_method = "3AA105C3169886A719F2BF7A3237E4A3", hash_generated_method = "1FEDBE13E2C3435ECCCBB1756DB5C9E3")
	private Bitmap nativeGetBitmapFromAndroidPua(int nativeEmojiFactory, int AndroidPua) {
		Bitmap bm = new Bitmap();
		bm.addTaint(this.taint);
		return bm;
	}
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:35:15.063 -0500", hash_original_method = "3A1554F06CC9CCAF25F7BBE93248CE83", hash_generated_method = "A4A836C0A0DB2C7B6DC257B311DB334F")
    private native int nativeGetAndroidPuaFromVendorSpecificSjis(int nativeEmojiFactory,
            char sjis);
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:35:15.064 -0500", hash_original_method = "C302C3634C2FA6E6CA4CF2CF66D12101", hash_generated_method = "EAB0777A99DBFC5CD21E43000D951714")
    private native int nativeGetVendorSpecificSjisFromAndroidPua(int nativeEmojiFactory,
            int pua);
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:35:15.066 -0500", hash_original_method = "75FE7601C9BA865A32982CD0867F654C", hash_generated_method = "EA25D36981E4762DAA08C68F911C4117")
    private native int nativeGetAndroidPuaFromVendorSpecificPua(int nativeEmojiFactory,
            int vsp);
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:35:15.067 -0500", hash_original_method = "B406416ABF41BEA242E5A40B8BA7386A", hash_generated_method = "F86E4888B11126B3F65C1F924A04B73F")
    private native int nativeGetVendorSpecificPuaFromAndroidPua(int nativeEmojiFactory,
            int pua);
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:35:15.068 -0500", hash_original_method = "5A805426DAFA5C3640F25323B1C3B8F5", hash_generated_method = "964E3584337F323E3049DCC0036D3433")
    private native int nativeGetMaximumVendorSpecificPua(int nativeEmojiFactory);
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:35:15.070 -0500", hash_original_method = "0FF4320BBE7657B90285375F65F4DF9D", hash_generated_method = "70D4C21520CBA1B7839A81609C0E4EBD")
    private native int nativeGetMinimumVendorSpecificPua(int nativeEmojiFactory);
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:35:15.072 -0500", hash_original_method = "800100FBB9205E441349161A70ADF047", hash_generated_method = "BF6F278B9BE9D085AA251112593F1116")
    private native int nativeGetMaximumAndroidPua(int nativeEmojiFactory);
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:35:15.073 -0500", hash_original_method = "5875EE70D8D47117F3D06FA307D98BB5", hash_generated_method = "AD615D656BBBC0A4881B1CC27D1A5A6E")
    private native int nativeGetMinimumAndroidPua(int nativeEmojiFactory);

    
    private class CustomLinkedHashMap<K, V> extends LinkedHashMap<K, V> {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.691 -0500", hash_original_method = "EFD1513E9BFBC9B14636F3CC7AC41B6C", hash_generated_method = "9C26E7D98A173E7409299B5546E8D52F")
        public CustomLinkedHashMap() {
            // These magic numbers are gotten from the source code of
            // LinkedHashMap.java and HashMap.java.
            super(16, 0.75f, true);
        }
        
        /*
         * If size() becomes more than sCacheSize, least recently used cache
         * is erased. 
         * @see java.util.LinkedHashMap#removeEldestEntry(java.util.Map.Entry)
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.692 -0500", hash_original_method = "A5B2DC9A6DACFA347C16D8B42A67BD03", hash_generated_method = "33EA5EBFD6029F7C69E3082D566C402E")
        @Override
protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size() > sCacheSize;
        }

        
    }


    
}

