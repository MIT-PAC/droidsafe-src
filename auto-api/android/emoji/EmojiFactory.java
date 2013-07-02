package android.emoji;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.graphics.Bitmap;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;

public final class EmojiFactory {
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.131 -0400", hash_original_field = "FC3844AD7E0AD1A2D30D63DA701B5F11", hash_generated_field = "6AC97E1F58C9735B2329D1C9A5ED4485")
	private int sCacheSize = 100;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.132 -0400", hash_original_field = "650F7524EE08C39E1DEFAEA8CCFCE80B", hash_generated_field = "784016E98C992E67132EEDB525B62E7A")
	private int mNativeEmojiFactory;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.132 -0400", hash_original_field = "311C2C8498DF6A626CBDB8AA4193499C", hash_generated_field = "886C24C67739C97CF77B8DD239E412F9")
	private String mName;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.132 -0400", hash_original_field = "FA75DB4B1A95A78968F552A9DCC88B0C", hash_generated_field = "7AF93DEFFB076EA51D0A22D3C0D4BF98")
	private Map<Integer, WeakReference<Bitmap>> mCache;

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.133 -0400", hash_original_method = "3CFB061344A54165CC98223BF316C16E", hash_generated_method = "C7D0D69F38285DF25F7919D10B271128")
	private EmojiFactory(int nativeEmojiFactory, String name) {
		mNativeEmojiFactory = nativeEmojiFactory;
		mName = name;
		mCache = new CustomLinkedHashMap<Integer, WeakReference<Bitmap>>();
		
		
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.133 -0400", hash_original_method = "32C84A5952A8F243E533AA978C471609", hash_generated_method = "1022AB339BCE8F38D8D3090647D24799")
	@Override
	protected void finalize() throws Throwable {
		try {
			nativeDestructor(mNativeEmojiFactory);
		} 
		finally {
			super.finalize();
		} 
			
			
			
		
		
		
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.134 -0400", hash_original_method = "61A4CE5E0B45509C63F06179C920C9C2", hash_generated_method = "DF39247D3E5BA7E18EA866F31EA81CBB")
	public String name() {
		String varB4EAC82CA7396A68D541C85D26508E83_784923669 = null; 
																		
																		
																		
		varB4EAC82CA7396A68D541C85D26508E83_784923669 = mName;
		varB4EAC82CA7396A68D541C85D26508E83_784923669.addTaint(getTaint()); 
																			
																			
																			
		return varB4EAC82CA7396A68D541C85D26508E83_784923669;
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.136 -0400", hash_original_method = "51D3837892087BC1526F97486EB96A82", hash_generated_method = "EACF3D5BF73777F7FAAD0F6178DBB582")
	public synchronized Bitmap getBitmapFromAndroidPua(int pua) {
		Bitmap varB4EAC82CA7396A68D541C85D26508E83_1075674105 = null; 
																		
																		
																		
		Bitmap varB4EAC82CA7396A68D541C85D26508E83_1137147639 = null; 
																		
																		
																		
		Bitmap varB4EAC82CA7396A68D541C85D26508E83_1983840721 = null; 
																		
																		
																		
		WeakReference<Bitmap> cache = mCache.get(pua);
		{
			Bitmap ret = nativeGetBitmapFromAndroidPua(mNativeEmojiFactory, pua);
			{
				mCache.put(pua, new WeakReference<Bitmap>(ret));
			} 
			varB4EAC82CA7396A68D541C85D26508E83_1075674105 = ret;
		} 
		{
			Bitmap tmp = cache.get();
			{
				Bitmap ret = nativeGetBitmapFromAndroidPua(mNativeEmojiFactory, pua);
				mCache.put(pua, new WeakReference<Bitmap>(ret));
				varB4EAC82CA7396A68D541C85D26508E83_1137147639 = ret;
			} 
			{
				varB4EAC82CA7396A68D541C85D26508E83_1983840721 = tmp;
			} 
		} 
		addTaint(pua);
		Bitmap varA7E53CE21691AB073D9660D615818899_2038965472; 
																
		switch (DroidSafeAndroidRuntime.switchControl) {
		case 1: 
			varA7E53CE21691AB073D9660D615818899_2038965472 = varB4EAC82CA7396A68D541C85D26508E83_1075674105;
			break;
		case 2: 
			varA7E53CE21691AB073D9660D615818899_2038965472 = varB4EAC82CA7396A68D541C85D26508E83_1137147639;
			break;
		default:
			varA7E53CE21691AB073D9660D615818899_2038965472 = varB4EAC82CA7396A68D541C85D26508E83_1983840721;
			break;
		}
		varA7E53CE21691AB073D9660D615818899_2038965472.addTaint(getTaint()); 
																				
																				
																				
		return varA7E53CE21691AB073D9660D615818899_2038965472;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.137 -0400", hash_original_method = "9A7284FF37A5214E9B7F9311E2EF3E6C", hash_generated_method = "5C454CE63424141A43A4FB2FE59CCED9")
	public synchronized Bitmap getBitmapFromVendorSpecificSjis(char sjis) {
		Bitmap varB4EAC82CA7396A68D541C85D26508E83_1541062137 = null; 
																		
																		
																		
		varB4EAC82CA7396A68D541C85D26508E83_1541062137 = getBitmapFromAndroidPua(getAndroidPuaFromVendorSpecificSjis(sjis));
		addTaint(sjis);
		varB4EAC82CA7396A68D541C85D26508E83_1541062137.addTaint(getTaint()); 
																				
																				
																				
		return varB4EAC82CA7396A68D541C85D26508E83_1541062137;
		
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.137 -0400", hash_original_method = "F5F3B81D8E941B288B2A41FCC9367619", hash_generated_method = "3895AC0933C77DB07F324AED749BA2DE")
	public synchronized Bitmap getBitmapFromVendorSpecificPua(int vsp) {
		Bitmap varB4EAC82CA7396A68D541C85D26508E83_1739316414 = null; 
																		
																		
																		
		varB4EAC82CA7396A68D541C85D26508E83_1739316414 = getBitmapFromAndroidPua(getAndroidPuaFromVendorSpecificPua(vsp));
		addTaint(vsp);
		varB4EAC82CA7396A68D541C85D26508E83_1739316414.addTaint(getTaint()); 
																				
																				
																				
		return varB4EAC82CA7396A68D541C85D26508E83_1739316414;
		
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.138 -0400", hash_original_method = "5E0818C254D368AF2876C64915580604", hash_generated_method = "0BD7E4A927022D6117C16EBFB968E45C")
	public int getAndroidPuaFromVendorSpecificSjis(char sjis) {
		int var74C2D334EFE3998285C80D7E5E8A8BE7_804882243 = (nativeGetAndroidPuaFromVendorSpecificSjis(mNativeEmojiFactory, sjis));
		addTaint(sjis);
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_360249760 = getTaintInt();
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_360249760;
		
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.138 -0400", hash_original_method = "CAA9928E1DDFC9E6AF0D5DC613844580", hash_generated_method = "30BCAB367D46BF1142DF6F9367CDD865")
	public int getVendorSpecificSjisFromAndroidPua(int pua) {
		int varD1B8764BBE902D599DA4F2D19767BBAC_441506412 = (nativeGetVendorSpecificSjisFromAndroidPua(mNativeEmojiFactory, pua));
		addTaint(pua);
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1655942951 = getTaintInt();
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1655942951;
		
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.139 -0400", hash_original_method = "BF155C8450604BCD58870D68939F5C48", hash_generated_method = "546066348CF25E2109E1F94786E4B8D0")
	public int getAndroidPuaFromVendorSpecificPua(int vsp) {
		int var70F5CE10206AFB73309604A98CB9FD21_788638480 = (nativeGetAndroidPuaFromVendorSpecificPua(mNativeEmojiFactory, vsp));
		addTaint(vsp);
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1817603021 = getTaintInt();
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1817603021;
		
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.140 -0400", hash_original_method = "332632D7825438D0B8DBF43F7E76A339", hash_generated_method = "0415DB4D4219EAC7B1198B0ACC2090BA")
	public String getAndroidPuaFromVendorSpecificPua(String vspString) {
		String varB4EAC82CA7396A68D541C85D26508E83_1105543467 = null; 
																		
																		
																		
		String varB4EAC82CA7396A68D541C85D26508E83_1275648027 = null; 
																		
																		
																		
		{
			varB4EAC82CA7396A68D541C85D26508E83_1105543467 = null;
		} 
		int minVsp = nativeGetMinimumVendorSpecificPua(mNativeEmojiFactory);
		int maxVsp = nativeGetMaximumVendorSpecificPua(mNativeEmojiFactory);
		int len = vspString.length();
		int[] codePoints = new int[vspString.codePointCount(0, len)];
		int new_len = 0;
		{
			int i = 0;
			i = vspString.offsetByCodePoints(i, 1);
			{
				int codePoint = vspString.codePointAt(i);
				{
					int newCodePoint = getAndroidPuaFromVendorSpecificPua(codePoint);
					{
						codePoints[new_len] = newCodePoint;
					} 
				} 
				codePoints[new_len] = codePoint;
			} 
		} 
		varB4EAC82CA7396A68D541C85D26508E83_1275648027 = new String(codePoints, 0, new_len);
		addTaint(vspString.getTaint());
		String varA7E53CE21691AB073D9660D615818899_1072852029; 
																
		switch (DroidSafeAndroidRuntime.switchControl) {
		case 1: 
			varA7E53CE21691AB073D9660D615818899_1072852029 = varB4EAC82CA7396A68D541C85D26508E83_1105543467;
			break;
		default:
			varA7E53CE21691AB073D9660D615818899_1072852029 = varB4EAC82CA7396A68D541C85D26508E83_1275648027;
			break;
		}
		varA7E53CE21691AB073D9660D615818899_1072852029.addTaint(getTaint()); 
																				
																				
																				
		return varA7E53CE21691AB073D9660D615818899_1072852029;
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.140 -0400", hash_original_method = "B08EB100AB82E54ADADC386CF8B33D33", hash_generated_method = "930480BFAF06B0210B4E7FB2A05095B2")
	public int getVendorSpecificPuaFromAndroidPua(int pua) {
		int varD354C24A4941A2811A9CD1AB35D65E36_1910327943 = (nativeGetVendorSpecificPuaFromAndroidPua(mNativeEmojiFactory, pua));
		addTaint(pua);
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_776645945 = getTaintInt();
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_776645945;
		
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.141 -0400", hash_original_method = "6085ED2713FAD0096DF7C4BD4C86F8DD", hash_generated_method = "C71818A884C225BD83CA44C695586B61")
	public String getVendorSpecificPuaFromAndroidPua(String puaString) {
		String varB4EAC82CA7396A68D541C85D26508E83_753618903 = null; 
																		
																		
																		
		String varB4EAC82CA7396A68D541C85D26508E83_1060552897 = null; 
																		
																		
																		
		{
			varB4EAC82CA7396A68D541C85D26508E83_753618903 = null;
		} 
		int minVsp = nativeGetMinimumAndroidPua(mNativeEmojiFactory);
		int maxVsp = nativeGetMaximumAndroidPua(mNativeEmojiFactory);
		int len = puaString.length();
		int[] codePoints = new int[puaString.codePointCount(0, len)];
		int new_len = 0;
		{
			int i = 0;
			i = puaString.offsetByCodePoints(i, 1);
			{
				int codePoint = puaString.codePointAt(i);
				{
					int newCodePoint = getVendorSpecificPuaFromAndroidPua(codePoint);
					{
						codePoints[new_len] = newCodePoint;
					} 
				} 
				codePoints[new_len] = codePoint;
			} 
		} 
		varB4EAC82CA7396A68D541C85D26508E83_1060552897 = new String(codePoints, 0, new_len);
		addTaint(puaString.getTaint());
		String varA7E53CE21691AB073D9660D615818899_795724688; 
																
		switch (DroidSafeAndroidRuntime.switchControl) {
		case 1: 
			varA7E53CE21691AB073D9660D615818899_795724688 = varB4EAC82CA7396A68D541C85D26508E83_753618903;
			break;
		default:
			varA7E53CE21691AB073D9660D615818899_795724688 = varB4EAC82CA7396A68D541C85D26508E83_1060552897;
			break;
		}
		varA7E53CE21691AB073D9660D615818899_795724688.addTaint(getTaint()); 
																			
																			
																			
		return varA7E53CE21691AB073D9660D615818899_795724688;
		
		
	}

	public static EmojiFactory newInstance(String class_name) {
		return new EmojiFactory(0, class_name);
	}

	public static EmojiFactory newAvailableInstance() {
		return new EmojiFactory(0, "");
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.142 -0400", hash_original_method = "E94B589829434939D487652724460608", hash_generated_method = "52681C04D5CD6C24DF22B21C0B64290B")
	public int getMinimumAndroidPua() {
		int varCB479F1E511B763D23ECFD817A95C207_871238901 = (nativeGetMinimumAndroidPua(mNativeEmojiFactory));
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1789386822 = getTaintInt();
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1789386822;
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.143 -0400", hash_original_method = "84EA08D07D32F9FA087FFC75B38A56E8", hash_generated_method = "480AA9CF96283C4196E08D41B4801277")
	public int getMaximumAndroidPua() {
		int var2FC718F3AE897ED82051F97F3361EB32_2008940556 = (nativeGetMaximumAndroidPua(mNativeEmojiFactory));
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1498386436 = getTaintInt();
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1498386436;
		
		
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.143 -0400", hash_original_method = "996F154EA43AB1D5A4C151D656C37CF1", hash_generated_method = "306E1F6D8D2B1E2FAFA21FC83BAC450E")
	private void nativeDestructor(int factory) {
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.143 -0400", hash_original_method = "3AA105C3169886A719F2BF7A3237E4A3", hash_generated_method = "1FEDBE13E2C3435ECCCBB1756DB5C9E3")
	private Bitmap nativeGetBitmapFromAndroidPua(int nativeEmojiFactory, int AndroidPua) {
		Bitmap bm = new Bitmap();
		bm.addTaint(this.taint);
		return bm;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.144 -0400", hash_original_method = "3A1554F06CC9CCAF25F7BBE93248CE83", hash_generated_method = "024A4F7E074CCA637606B0AAEE9997FE")
	private int nativeGetAndroidPuaFromVendorSpecificSjis(int nativeEmojiFactory, char sjis) {
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1973003923 = getTaintInt();
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1973003923;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.144 -0400", hash_original_method = "C302C3634C2FA6E6CA4CF2CF66D12101", hash_generated_method = "E24C97FA03F1A6F7FD296BE6A65A98FA")
	private int nativeGetVendorSpecificSjisFromAndroidPua(int nativeEmojiFactory, int pua) {
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1464973851 = getTaintInt();
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1464973851;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.144 -0400", hash_original_method = "75FE7601C9BA865A32982CD0867F654C", hash_generated_method = "97C72E41FBCE79CE6CB3CC4B020B8163")
	private int nativeGetAndroidPuaFromVendorSpecificPua(int nativeEmojiFactory, int vsp) {
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1144551433 = getTaintInt();
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1144551433;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.145 -0400", hash_original_method = "B406416ABF41BEA242E5A40B8BA7386A", hash_generated_method = "70F27FA5240E55D36824312018BDCDF3")
	private int nativeGetVendorSpecificPuaFromAndroidPua(int nativeEmojiFactory, int pua) {
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1065149731 = getTaintInt();
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1065149731;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.145 -0400", hash_original_method = "5A805426DAFA5C3640F25323B1C3B8F5", hash_generated_method = "4662032D57F799662C66FEAE75C1E3F5")
	private int nativeGetMaximumVendorSpecificPua(int nativeEmojiFactory) {
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1579659992 = getTaintInt();
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1579659992;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.146 -0400", hash_original_method = "0FF4320BBE7657B90285375F65F4DF9D", hash_generated_method = "DD5CE30082CF6A49B29B054F0B5FC890")
	private int nativeGetMinimumVendorSpecificPua(int nativeEmojiFactory) {
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1362804657 = getTaintInt();
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1362804657;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.146 -0400", hash_original_method = "800100FBB9205E441349161A70ADF047", hash_generated_method = "ABBD3E3CD285BA26DA18ADDAF4C2F2CE")
	private int nativeGetMaximumAndroidPua(int nativeEmojiFactory) {
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1456716692 = getTaintInt();
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1456716692;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.146 -0400", hash_original_method = "5875EE70D8D47117F3D06FA307D98BB5", hash_generated_method = "7445C83CCCC183B9A7177DA991C91CAB")
	private int nativeGetMinimumAndroidPua(int nativeEmojiFactory) {
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_673692276 = getTaintInt();
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_673692276;
	}

	private class CustomLinkedHashMap<K, V> extends LinkedHashMap<K, V> {

		@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.147 -0400", hash_original_method = "EFD1513E9BFBC9B14636F3CC7AC41B6C", hash_generated_method = "19A9879B12E07C26C0FDCF805FDF3C6D")
		public CustomLinkedHashMap() {
			super(16, 0.75f, true);
			
		}

		@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.148 -0400", hash_original_method = "A5B2DC9A6DACFA347C16D8B42A67BD03", hash_generated_method = "344D3A26E6FF2BE7A7B503A3816673A5")
		@Override
		protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
			boolean varC11A82D981A81510AE8FF14A739DFE21_1116224563 = (size() > sCacheSize);
			addTaint(eldest.getTaint());
			boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1618468444 = getTaintBoolean();
			return var84E2C64F38F78BA3EA5C905AB5A2DA27_1618468444;
			
			
		}

	}

}
