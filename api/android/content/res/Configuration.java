package android.content.res;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Locale;

import android.content.pm.ActivityInfo;
import android.os.Parcel;
import android.os.Parcelable;

public final class Configuration implements Parcelable, Comparable<Configuration> {
	/** replacing anonymous inner class */
    private static class MyCreator implements Parcelable.Creator<Configuration> {
        
        @DSSafe(DSCat.SAFE_OTHERS)
        public MyCreator() {

        }
        public Configuration createFromParcel(Parcel source) {
            return new Configuration(source);
        }
        public Configuration[] newArray(int size) {
            return new Configuration[size];
        }
    }

    /**
     * Determine if a new resource needs to be loaded from the bit set of
     * configuration changes returned by {@link #updateFrom(Configuration)}.
     * 
     * @param configChanges The mask of changes configurations as returned by
     * {@link #updateFrom(Configuration)}.
     * @param interestingChanges The configuration changes that the resource
     * can handled, as given in {@link android.util.TypedValue#changingConfigurations}.
     * 
     * @return Return true if the resource needs to be loaded, else false.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.488 -0500", hash_original_method = "C1EC99295C60E8CDF33A346200304D0A", hash_generated_method = "12670E839438D361F4B14561A2A8FD66")
    
public static boolean needNewResources(int configChanges, int interestingChanges) {
        //return (configChanges & (interestingChanges|ActivityInfo.CONFIG_FONT_SCALE)) != 0;
        return toTaintBoolean(configChanges & (interestingChanges|ActivityInfo.CONFIG_FONT_SCALE));
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.303 -0500", hash_original_field = "5D73236DF3C2B1F3FA582709E51BE31B", hash_generated_field = "B346CDA4558DB20C72B6AF98D39CC438")

    public static final int SCREENLAYOUT_SIZE_MASK = 0x0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.305 -0500", hash_original_field = "9F0CF7A4E3A93682F171D823F29999B6", hash_generated_field = "9F5362A941D202AFF041CB2D1CFA608A")

    public static final int SCREENLAYOUT_SIZE_UNDEFINED = 0x00;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.308 -0500", hash_original_field = "F6E1A731F17D0DFAF97B2288C633253A", hash_generated_field = "803804A6E8EF0051FD582511CB210442")

    public static final int SCREENLAYOUT_SIZE_SMALL = 0x01;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.310 -0500", hash_original_field = "32536B7DDC233E60DE747E57CC588E4A", hash_generated_field = "2D871A5AC547C36BADCAEE9D4C5FEE6B")

    public static final int SCREENLAYOUT_SIZE_NORMAL = 0x02;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.312 -0500", hash_original_field = "A8DE1544008FB534D033605CC4B7A215", hash_generated_field = "430CB565357F7CE4159D1181AEEFCD75")

    public static final int SCREENLAYOUT_SIZE_LARGE = 0x03;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.315 -0500", hash_original_field = "C52E2B067090287F1AB6A09A37728883", hash_generated_field = "063E90CA990B679B946724BD1F48FDF8")

    public static final int SCREENLAYOUT_SIZE_XLARGE = 0x04;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.317 -0500", hash_original_field = "68EAAD00DF134F89A66F4D9CA1C6F724", hash_generated_field = "83DF942B9520E78A49689D25D3AA02BF")
    
    public static final int SCREENLAYOUT_LONG_MASK = 0x30;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.319 -0500", hash_original_field = "D1ADF9980E3CAC8B93BC575E3249ABBE", hash_generated_field = "E7FBEB3394EED592FB1D4D7B5D023CBC")

    public static final int SCREENLAYOUT_LONG_UNDEFINED = 0x00;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.322 -0500", hash_original_field = "3EF06EC1774430576F4F8ABF037F86F6", hash_generated_field = "9BFB6EA0D6E07F35DD143CA937C7CE8E")

    public static final int SCREENLAYOUT_LONG_NO = 0x10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.325 -0500", hash_original_field = "EF09FFB2BDD46AC1146B23312C22491C", hash_generated_field = "9E65CE17F1FC653413AE213ED7C2C2BC")

    public static final int SCREENLAYOUT_LONG_YES = 0x20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.327 -0500", hash_original_field = "F7467ED768044924F0CE8F903ED58D57", hash_generated_field = "E64EBA8622584CA6009DEC2FBD315324")

    public static final int SCREENLAYOUT_COMPAT_NEEDED = 0x10000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.334 -0500", hash_original_field = "CEEC978DEB70970BEBA8E38D97DDC503", hash_generated_field = "B0101AA9A1EFC2958B2BD97935F5E43F")

    public static final int TOUCHSCREEN_UNDEFINED = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.336 -0500", hash_original_field = "190872D24844E79A8B53F74D5502ABE1", hash_generated_field = "FC751613C0D874E0D62CAD5911C37168")

    public static final int TOUCHSCREEN_NOTOUCH = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.338 -0500", hash_original_field = "A245060102627647FE42E4620E59D406", hash_generated_field = "C3C62D0D5C3E1FCC186AB5565969A16A")

    public static final int TOUCHSCREEN_STYLUS = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.340 -0500", hash_original_field = "4A8A140BA4816B4AC5D60477E6C7AAD4", hash_generated_field = "EF740BB43C76B625100AB3DDAC1CB848")

    public static final int TOUCHSCREEN_FINGER = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.345 -0500", hash_original_field = "6F47743FE71154B7FE6211479BFA010D", hash_generated_field = "973D7C88B4953DD48CB18EC38FFA7E40")
    
    public static final int KEYBOARD_UNDEFINED = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.347 -0500", hash_original_field = "FAD80681C1A919CB31948CE570E928EB", hash_generated_field = "ED47AEFC2904A88498A3417274EB5B28")

    public static final int KEYBOARD_NOKEYS = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.350 -0500", hash_original_field = "55605F22EB8C0DE3BBCED5850717EDD7", hash_generated_field = "29EA5AF2C91F1AB9B20D2BE16CEA90BA")

    public static final int KEYBOARD_QWERTY = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.352 -0500", hash_original_field = "02D620A43C6F58ADEACBD4A986AEC455", hash_generated_field = "1E094ABA5C5141E80F7EFD80F5FF36B3")

    public static final int KEYBOARD_12KEY = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.357 -0500", hash_original_field = "5BB073DEC4D3FD2F0F6F71EC25DFE6BA", hash_generated_field = "8D5810494CA6F4A6156ED47E6AE64DB8")
    
    public static final int KEYBOARDHIDDEN_UNDEFINED = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.359 -0500", hash_original_field = "932CD61DABBACEDD430754DFBEBA100F", hash_generated_field = "2FC4FFF97A1D643FBF08B0B36322F8C4")

    public static final int KEYBOARDHIDDEN_NO = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.361 -0500", hash_original_field = "E64E9D9551092BCDD95AE0E4BC5BF3EC", hash_generated_field = "6E397BE484C0EF4151CA42CA0FF55845")

    public static final int KEYBOARDHIDDEN_YES = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.363 -0500", hash_original_field = "D5A8D09BCF230E32206BE10DA4763CC9", hash_generated_field = "12C4876D3640B60BB30F8A7D36AC1BE7")

    public static final int KEYBOARDHIDDEN_SOFT = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.369 -0500", hash_original_field = "50E43FBCF9B5C6A85F6C0AB3493BD60F", hash_generated_field = "95E584687387E211D6DEB6D7272BA7E1")
    
    public static final int HARDKEYBOARDHIDDEN_UNDEFINED = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.371 -0500", hash_original_field = "2ED941D7AC3931518761AB8410F95887", hash_generated_field = "498B6D95CC5FFEE7EA277824D6255431")

    public static final int HARDKEYBOARDHIDDEN_NO = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.373 -0500", hash_original_field = "7860AE01C4BA8CCA921B4E1ADE294674", hash_generated_field = "8FD6C4F87C30287D39602C79F45C4E7E")

    public static final int HARDKEYBOARDHIDDEN_YES = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.378 -0500", hash_original_field = "E8EE632CD05BCC59B5CAD9B4A218987C", hash_generated_field = "932D1DB5ECECF03B56E0079FF2C36729")
    
    public static final int NAVIGATION_UNDEFINED = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.380 -0500", hash_original_field = "7433AE12C307F3BA84DAE302D2109344", hash_generated_field = "8D80BAD85677E02C825FEB169936882A")

    public static final int NAVIGATION_NONAV = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.382 -0500", hash_original_field = "5DDAF513C82FE806CC389EC4AAEF1EFA", hash_generated_field = "8C9D8797F167F4EC820DB72CAC4CD715")

    public static final int NAVIGATION_DPAD = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.384 -0500", hash_original_field = "A47A4D961CFAA5CF7065F400BE396A46", hash_generated_field = "FCE06A270F820644B1F88884AE2F271F")

    public static final int NAVIGATION_TRACKBALL = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.386 -0500", hash_original_field = "CF4AA6B0B8D287AEB254C9DE2E2898F4", hash_generated_field = "6FECECA346D65FAC4BD02F6E2A0AB60C")

    public static final int NAVIGATION_WHEEL = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.391 -0500", hash_original_field = "8C8934BCB426CFD1BE2BAA2B435DBFE2", hash_generated_field = "08162A93D56DB79FB6836A1D7BD8E65F")
    
    public static final int NAVIGATIONHIDDEN_UNDEFINED = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.393 -0500", hash_original_field = "28A805EAD48FBBE171AF87CB14539781", hash_generated_field = "E2DD859C53EEC94FC7108000065D16BD")

    public static final int NAVIGATIONHIDDEN_NO = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.396 -0500", hash_original_field = "63F3D010B99909F88835282621A0FD7A", hash_generated_field = "C4DF0E23CF380592463F3B20C09F9634")

    public static final int NAVIGATIONHIDDEN_YES = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.400 -0500", hash_original_field = "FF61189BB21652B1AA647AF4366BE51A", hash_generated_field = "C828CE7228710CDEF23518F65ADADABD")
    
    public static final int ORIENTATION_UNDEFINED = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.403 -0500", hash_original_field = "E0C79F65EFFA668408999FD5406A071F", hash_generated_field = "E8BEF95B801ACE9332F80B0F3A2A2E23")

    public static final int ORIENTATION_PORTRAIT = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.406 -0500", hash_original_field = "B0305037A2831A29A1B2C1045C8FA9B9", hash_generated_field = "15A4FF77941A8BE76B02E2B2E899580C")

    public static final int ORIENTATION_LANDSCAPE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.408 -0500", hash_original_field = "A671AEAE67F5119A2B73CC708F6ED58A", hash_generated_field = "22E9247C76EB276847BFA8251392E5F3")

    public static final int ORIENTATION_SQUARE = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.412 -0500", hash_original_field = "11E3A8265ADFB95CF5FC3A1370156AED", hash_generated_field = "CE645321C68D6EAE4F20040E151DFEBD")

    public static final int UI_MODE_TYPE_MASK = 0x0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.415 -0500", hash_original_field = "2A4094552A5CAB09B4D659B9AD4590CE", hash_generated_field = "75B384221BDBDD1ECBC2C2091A72BCA3")

    public static final int UI_MODE_TYPE_UNDEFINED = 0x00;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.417 -0500", hash_original_field = "1FA64F1D427AE2048A088D70B09C0B26", hash_generated_field = "EF99BB083AF588C21F667D28F38E3849")

    public static final int UI_MODE_TYPE_NORMAL = 0x01;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.419 -0500", hash_original_field = "8DA25F4301C9A65B601512606A40A9BA", hash_generated_field = "BA800E97C02982CCF1CDA6C32F47C9EC")

    public static final int UI_MODE_TYPE_DESK = 0x02;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.422 -0500", hash_original_field = "0E88D4B1A1510526B5F3C001E1B2AB42", hash_generated_field = "F30C183AF3B6AE31DD369E3628B3AF97")

    public static final int UI_MODE_TYPE_CAR = 0x03;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.424 -0500", hash_original_field = "AB2B0FED0E06DEB12F8E456C58AF1E9A", hash_generated_field = "DFC9061FC07194CBAE10078BE0D3B5A8")

    public static final int UI_MODE_TYPE_TELEVISION = 0x04;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.426 -0500", hash_original_field = "4A230A66B848B28BE4DA1CAD32AF49B0", hash_generated_field = "898C0CEDBB65AA44FBAA229A1058F918")

    public static final int UI_MODE_NIGHT_MASK = 0x30;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.428 -0500", hash_original_field = "93DC52756C3B404C88F930F7E7BCACBA", hash_generated_field = "85556771939DEED6E975323A05749A53")

    public static final int UI_MODE_NIGHT_UNDEFINED = 0x00;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.430 -0500", hash_original_field = "7C2436FD8A439815017CB62AC342B989", hash_generated_field = "ED352808DBE642379622C1D8B72F92CB")

    public static final int UI_MODE_NIGHT_NO = 0x10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.433 -0500", hash_original_field = "3EA87D1060671DBF0D433EC49D8F3D09", hash_generated_field = "CB2F7464255937F099EEC6D692D82CCC")

    public static final int UI_MODE_NIGHT_YES = 0x20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.438 -0500", hash_original_field = "D2D67D5AD82B99EAA28FAB4FD7DDBD11", hash_generated_field = "A7CE3388F40BEF0EB84DB64B575D81FB")

    public static final int SCREEN_WIDTH_DP_UNDEFINED = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.442 -0500", hash_original_field = "A2F5C3AE2FA542E2DDC78F714A81CA09", hash_generated_field = "4981084D9255AA8DA4E2488051EAD47D")

    public static final int SCREEN_HEIGHT_DP_UNDEFINED = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.447 -0500", hash_original_field = "02D77116F4BA73410F08A540C29C119E", hash_generated_field = "5CB7CC2CFE40F6BFE0C6F652FED847EA")

    public static final int SMALLEST_SCREEN_WIDTH_DP_UNDEFINED = 0;
    public static final Parcelable.Creator<Configuration> CREATOR = new MyCreator();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.292 -0500", hash_original_field = "AFF403DA59B1CA5DCE0E8E4879A92499", hash_generated_field = "016D232391C2B00F2A8278147A165D44")

    public float fontScale;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.294 -0500", hash_original_field = "B8D429B3E1B3107CAF57EB461C4539D2", hash_generated_field = "76F73DAFF3E7C6F271BA01993CC2C8A0")

    public int mcc;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.296 -0500", hash_original_field = "AC463201802D750E2A6FAF6FEF8708DB", hash_generated_field = "C8C1335BDB14963CECDE57EFB65EFFB2")

    public int mnc;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.298 -0500", hash_original_field = "A25411C3C357716626A9185E220A5EAA", hash_generated_field = "EF7DFF54937494EEB34A3C19D5A51B82")

    public Locale locale;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.301 -0500", hash_original_field = "27AC963CE9E99A4D813249B632A41770", hash_generated_field = "F3C329D4A00E76B33E7CA6034FEEE8BB")

    public boolean userSetLocale;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.329 -0500", hash_original_field = "F8FFD377733A4A2EE491410C01FE792C", hash_generated_field = "75E75221BDD4324EC7A7F0F3380DBC45")

    public int screenLayout;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.342 -0500", hash_original_field = "67EB38516DA9DE4FD338803CF92D7E01", hash_generated_field = "7BD24F9029D9389CC85A72E927933491")

    public int touchscreen;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.354 -0500", hash_original_field = "69E6525951F494F0E9C87CDF58C18C73", hash_generated_field = "D4FF6D7D378EEFA5FEB32686A0ACC1A0")

    public int keyboard;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.365 -0500", hash_original_field = "304787483AE089B1DAAFA432D98A7CCF", hash_generated_field = "9B39F39EEA3B5BB28D62E068260E180D")

    public int keyboardHidden;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.375 -0500", hash_original_field = "DA7D5D25E1EF4B8B1785F319D14C2926", hash_generated_field = "8A23D435735D9E7B81CB249D67B2E8FE")

    public int hardKeyboardHidden;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.388 -0500", hash_original_field = "F62F1296E44702ACAEB9A7DB80960D3F", hash_generated_field = "68D4E1B9231A90B60C9E05FC54251CC3")

    public int navigation;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.398 -0500", hash_original_field = "1788355E24AAE1A3F0AD249977426384", hash_generated_field = "740578DD4AD1CDA0CBD2EBE65083C7DD")

    public int navigationHidden;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.410 -0500", hash_original_field = "3DED072A8BFAA06C394A37F331F7C0C9", hash_generated_field = "039D4A8EAE0AA6D0501E4B6BB899CCE8")

    public int orientation;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.435 -0500", hash_original_field = "8281F85E7434540811DE50196C7D61AF", hash_generated_field = "D3CE92A20BB4AD432061A982E440F89E")

    public int uiMode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.440 -0500", hash_original_field = "4AAB95598FE70C25855CD3843DC22AA8", hash_generated_field = "B4623D6B8749E7B32286E6BED8FF75B9")

    public int screenWidthDp;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.444 -0500", hash_original_field = "AD3EEE877B17B3C2459D3B59F3F4C894", hash_generated_field = "FFF43C61292F4D4B68AA77F5BEB79B0E")

    public int screenHeightDp;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.449 -0500", hash_original_field = "1C28A29076E4B79FACA82C9171575666", hash_generated_field = "B2BA3B7260CF99D8A56816651AD7EA2D")

    public int smallestScreenWidthDp;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.451 -0500", hash_original_field = "5CF0AB20ED206827FAA48C76C3040646", hash_generated_field = "23072A9468BA47F7005C3C4C2BDC4C76")

    public int compatScreenWidthDp;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.453 -0500", hash_original_field = "21A2C2499E51EF6756E315F17E174820", hash_generated_field = "F0CB2F26359485B5DDD1C8D4F0AE43EE")

    public int compatScreenHeightDp;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.455 -0500", hash_original_field = "1B50B8569AFEE267869F820B481EE705", hash_generated_field = "412A44FB6BBF0D556AD1A50E6E2E13C7")

    public int compatSmallestScreenWidthDp;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.457 -0500", hash_original_field = "F632AC9F4C9BFB9D9B1E5761C57ABF85", hash_generated_field = "C81CA55E4FEC275F629D6067F4E91B44")

    public int textLayoutDirection;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.459 -0500", hash_original_field = "C4ECE7ED8A0F11C4F90796D05BE13ED7", hash_generated_field = "602E67FBFEA6A5896A55513E0F9DCC8A")

    public int seq;
    
    /**
     * Construct an invalid Configuration.  You must call {@link #setToDefaults}
     * for this object to be valid.  {@more}
     */
    @DSComment("not sensitive/not an action")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.461 -0500", hash_original_method = "7E58BC7E066573DB3913F9DCCD9EE638", hash_generated_method = "BC67040AAA8A5290C3245C58F180ACA4")
    
public Configuration() {
        setToDefaults();
    }

    /**
     * Makes a deep copy suitable for modification.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.463 -0500", hash_original_method = "152BBD78ACB87D16BE4EC07F107E0DF8", hash_generated_method = "FE82D2B1F6EB0C509E44BD0A381CFAFA")
    
public Configuration(Configuration o) {
        setTo(o);
    }

    /**
     * Construct this Configuration object, reading from the Parcel.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.507 -0500", hash_original_method = "8A45855DAEA6DBD5399558BF539AE2C5", hash_generated_method = "B33F295FC71427932B72309EBDA781D2")
    
private Configuration(Parcel source) {
        readFromParcel(source);
    }
    
    /**
     * Check if the Configuration's current {@link #screenLayout} is at
     * least the given size.
     *
     * @param size The desired size, either {@link #SCREENLAYOUT_SIZE_SMALL},
     * {@link #SCREENLAYOUT_SIZE_NORMAL}, {@link #SCREENLAYOUT_SIZE_LARGE}, or
     * {@link #SCREENLAYOUT_SIZE_XLARGE}.
     * @return Returns true if the current screen layout size is at least
     * the given size.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.332 -0500", hash_original_method = "7CF138C6ADBDA7579D8D5CA6B783C43E", hash_generated_method = "F102ED8C450F6F6D1DC8C244F017697B")
    
public boolean isLayoutSizeAtLeast(int size) {
        int cur = screenLayout&SCREENLAYOUT_SIZE_MASK;
        if (cur == SCREENLAYOUT_SIZE_UNDEFINED) return false;
        return toTaintBoolean(cur + size);
    }
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public void setTo(Configuration o) {
	    addTaint(o.getTaint());
    }
    
    public String toString() {
        String str = new String();
        str.addTaint(getTaint());
        return str;
    }
    
    public void setToDefaults() {
    }

    /** {@hide} */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.477 -0500", hash_original_method = "7A9BC90479DED562CC828BA992C8D29B", hash_generated_method = "3F600FAB8862BDD19EA379E4E0BB5A9B")
    
@Deprecated public void makeDefault() {
        setToDefaults();
    }
    
    public int updateFrom(Configuration delta) {
        addTaint(delta.getTaint());
        return getTaintInt();
    }

    /**
     * Return a bit mask of the differences between this Configuration
     * object and the given one.  Does not change the values of either.  Any
     * undefined fields in <var>delta</var> are ignored.
     * @return Returns a bit mask indicating which configuration
     * values has changed, containing any combination of
     * {@link android.content.pm.ActivityInfo#CONFIG_FONT_SCALE
     * PackageManager.ActivityInfo.CONFIG_FONT_SCALE},
     * {@link android.content.pm.ActivityInfo#CONFIG_MCC
     * PackageManager.ActivityInfo.CONFIG_MCC},
     * {@link android.content.pm.ActivityInfo#CONFIG_MNC
     * PackageManager.ActivityInfo.CONFIG_MNC},
     * {@link android.content.pm.ActivityInfo#CONFIG_LOCALE
     * PackageManager.ActivityInfo.CONFIG_LOCALE},
     * {@link android.content.pm.ActivityInfo#CONFIG_TOUCHSCREEN
     * PackageManager.ActivityInfo.CONFIG_TOUCHSCREEN},
     * {@link android.content.pm.ActivityInfo#CONFIG_KEYBOARD
     * PackageManager.ActivityInfo.CONFIG_KEYBOARD},
     * {@link android.content.pm.ActivityInfo#CONFIG_NAVIGATION
     * PackageManager.ActivityInfo.CONFIG_NAVIGATION},
     * {@link android.content.pm.ActivityInfo#CONFIG_ORIENTATION
     * PackageManager.ActivityInfo.CONFIG_ORIENTATION},
     * {@link android.content.pm.ActivityInfo#CONFIG_SCREEN_LAYOUT
     * PackageManager.ActivityInfo.CONFIG_SCREEN_LAYOUT}, or
     * {@link android.content.pm.ActivityInfo#CONFIG_SCREEN_SIZE
     * PackageManager.ActivityInfo.CONFIG_SCREEN_SIZE}, or
     * {@link android.content.pm.ActivityInfo#CONFIG_SMALLEST_SCREEN_SIZE
     * PackageManager.ActivityInfo.CONFIG_SMALLEST_SCREEN_SIZE}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.485 -0500", hash_original_method = "386D1A4CE5F28E1920F878E4D6E46D78", hash_generated_method = "13FCC9F1C8F20B4AA75AF0A3B7E0605B")
    
public int diff(Configuration delta) {
        int changed = 0;
        if (delta.fontScale > 0 && fontScale != delta.fontScale) {
            changed |= ActivityInfo.CONFIG_FONT_SCALE;
        }
        if (delta.mcc != 0 && mcc != delta.mcc) {
            changed |= ActivityInfo.CONFIG_MCC;
        }
        if (delta.mnc != 0 && mnc != delta.mnc) {
            changed |= ActivityInfo.CONFIG_MNC;
        }
        if (delta.locale != null
                && (locale == null || !locale.equals(delta.locale))) {
            changed |= ActivityInfo.CONFIG_LOCALE;
        }
        if (delta.touchscreen != TOUCHSCREEN_UNDEFINED
                && touchscreen != delta.touchscreen) {
            changed |= ActivityInfo.CONFIG_TOUCHSCREEN;
        }
        if (delta.keyboard != KEYBOARD_UNDEFINED
                && keyboard != delta.keyboard) {
            changed |= ActivityInfo.CONFIG_KEYBOARD;
        }
        if (delta.keyboardHidden != KEYBOARDHIDDEN_UNDEFINED
                && keyboardHidden != delta.keyboardHidden) {
            changed |= ActivityInfo.CONFIG_KEYBOARD_HIDDEN;
        }
        if (delta.hardKeyboardHidden != HARDKEYBOARDHIDDEN_UNDEFINED
                && hardKeyboardHidden != delta.hardKeyboardHidden) {
            changed |= ActivityInfo.CONFIG_KEYBOARD_HIDDEN;
        }
        if (delta.navigation != NAVIGATION_UNDEFINED
                && navigation != delta.navigation) {
            changed |= ActivityInfo.CONFIG_NAVIGATION;
        }
        if (delta.navigationHidden != NAVIGATIONHIDDEN_UNDEFINED
                && navigationHidden != delta.navigationHidden) {
            changed |= ActivityInfo.CONFIG_KEYBOARD_HIDDEN;
        }
        if (delta.orientation != ORIENTATION_UNDEFINED
                && orientation != delta.orientation) {
            changed |= ActivityInfo.CONFIG_ORIENTATION;
        }
        if (delta.screenLayout != SCREENLAYOUT_SIZE_UNDEFINED
                && screenLayout != delta.screenLayout) {
            changed |= ActivityInfo.CONFIG_SCREEN_LAYOUT;
        }
        if (delta.uiMode != (UI_MODE_TYPE_UNDEFINED|UI_MODE_NIGHT_UNDEFINED)
                && uiMode != delta.uiMode) {
            changed |= ActivityInfo.CONFIG_UI_MODE;
        }
        if (delta.screenWidthDp != SCREEN_WIDTH_DP_UNDEFINED
                && screenWidthDp != delta.screenWidthDp) {
            changed |= ActivityInfo.CONFIG_SCREEN_SIZE;
        }
        if (delta.screenHeightDp != SCREEN_HEIGHT_DP_UNDEFINED
                && screenHeightDp != delta.screenHeightDp) {
            changed |= ActivityInfo.CONFIG_SCREEN_SIZE;
        }
        if (delta.smallestScreenWidthDp != SMALLEST_SCREEN_WIDTH_DP_UNDEFINED
                && smallestScreenWidthDp != delta.smallestScreenWidthDp) {
            changed |= ActivityInfo.CONFIG_SMALLEST_SCREEN_SIZE;
        }
        
        return changed;
    }
    
    /**
     * @hide Return true if the sequence of 'other' is better than this.  Assumes
     * that 'this' is your current sequence and 'other' is a new one you have
     * received some how and want to compare with what you have.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.490 -0500", hash_original_method = "B2BFCC713F7EA940A38F0F416218BA87", hash_generated_method = "4216753DB0C3E577A8D7A4ED6B0EC876")
    
public boolean isOtherSeqNewer(Configuration other) {
        if (other == null) {
            // Sanity check.
            return false;
        }
        if (other.seq == 0) {
            // If the other sequence is not specified, then we must assume
            // it is newer since we don't know any better.
            return true;
        }
        if (seq == 0) {
            // If this sequence is not specified, then we also consider the
            // other is better.  Yes we have a preference for other.  Sue us.
            return true;
        }
        int diff = other.seq - seq;
        if (diff > 0x10000) {
            // If there has been a sufficiently large jump, assume the
            // sequence has wrapped around.
            return false;
        }
        return toTaintBoolean(diff);
    }
    
    /**
     * Parcelable methods
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.492 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.495 -0500", hash_original_method = "1BC6CD0BF36648989C04BB1E69C07CD0", hash_generated_method = "A432DD74909B6BDE9E732F32A2C3A6DE")
    
public void writeToParcel(Parcel dest, int flags) {
        dest.writeFloat(fontScale);
        dest.writeInt(mcc);
        dest.writeInt(mnc);
        if (locale == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeString(locale.getLanguage());
            dest.writeString(locale.getCountry());
            dest.writeString(locale.getVariant());
        }
        if(userSetLocale) {
            dest.writeInt(1);
        } else {
            dest.writeInt(0);
        }
        dest.writeInt(touchscreen);
        dest.writeInt(keyboard);
        dest.writeInt(keyboardHidden);
        dest.writeInt(hardKeyboardHidden);
        dest.writeInt(navigation);
        dest.writeInt(navigationHidden);
        dest.writeInt(orientation);
        dest.writeInt(screenLayout);
        dest.writeInt(uiMode);
        dest.writeInt(screenWidthDp);
        dest.writeInt(screenHeightDp);
        dest.writeInt(smallestScreenWidthDp);
        dest.writeInt(compatScreenWidthDp);
        dest.writeInt(compatScreenHeightDp);
        dest.writeInt(compatSmallestScreenWidthDp);
        dest.writeInt(textLayoutDirection);
        dest.writeInt(seq);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.498 -0500", hash_original_method = "D035835FD349CA35BBAA1421EFF90B4A", hash_generated_method = "9A0D4970DF71D5B53C9FE648DE46A9B0")
    
public void readFromParcel(Parcel source) {
        fontScale = source.readFloat();
        mcc = source.readInt();
        mnc = source.readInt();
        if (source.readInt() != 0) {
            locale = new Locale(source.readString(), source.readString(),
                    source.readString());
        }
        userSetLocale = (source.readInt()==1);
        touchscreen = source.readInt();
        keyboard = source.readInt();
        keyboardHidden = source.readInt();
        hardKeyboardHidden = source.readInt();
        navigation = source.readInt();
        navigationHidden = source.readInt();
        orientation = source.readInt();
        screenLayout = source.readInt();
        uiMode = source.readInt();
        screenWidthDp = source.readInt();
        screenHeightDp = source.readInt();
        smallestScreenWidthDp = source.readInt();
        compatScreenWidthDp = source.readInt();
        compatScreenHeightDp = source.readInt();
        compatSmallestScreenWidthDp = source.readInt();
        textLayoutDirection = source.readInt();
        seq = source.readInt();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.511 -0500", hash_original_method = "A5C14F26D7300C5E96037FF80E52AAB2", hash_generated_method = "64596BC59B6F386A70FF15732D4AE4FC")
    
public int compareTo(Configuration that) {
        int n;
        float a = this.fontScale;
        float b = that.fontScale;
        if (a < b) return -1;
        if (a > b) return 1;
        n = this.mcc - that.mcc;
        if (n != 0) return n;
        n = this.mnc - that.mnc;
        if (n != 0) return n;
        if (this.locale == null) {
            if (that.locale != null) return 1;
        } else if (that.locale == null) {
            return -1;
        } else {
            n = this.locale.getLanguage().compareTo(that.locale.getLanguage());
            if (n != 0) return n;
            n = this.locale.getCountry().compareTo(that.locale.getCountry());
            if (n != 0) return n;
            n = this.locale.getVariant().compareTo(that.locale.getVariant());
            if (n != 0) return n;
        }
        n = this.touchscreen - that.touchscreen;
        if (n != 0) return n;
        n = this.keyboard - that.keyboard;
        if (n != 0) return n;
        n = this.keyboardHidden - that.keyboardHidden;
        if (n != 0) return n;
        n = this.hardKeyboardHidden - that.hardKeyboardHidden;
        if (n != 0) return n;
        n = this.navigation - that.navigation;
        if (n != 0) return n;
        n = this.navigationHidden - that.navigationHidden;
        if (n != 0) return n;
        n = this.orientation - that.orientation;
        if (n != 0) return n;
        n = this.screenLayout - that.screenLayout;
        if (n != 0) return n;
        n = this.uiMode - that.uiMode;
        if (n != 0) return n;
        n = this.screenWidthDp - that.screenWidthDp;
        if (n != 0) return n;
        n = this.screenHeightDp - that.screenHeightDp;
        if (n != 0) return n;
        n = this.smallestScreenWidthDp - that.smallestScreenWidthDp;
        //if (n != 0) return n;
        return n;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.514 -0500", hash_original_method = "7EC3698B1B9649830BA1D150A7700ABF", hash_generated_method = "CF6B507335C7E6C826E8ED1B8C3C0355")
    
public boolean equals(Configuration that) {
        if (that == null) return false;
        if (that == this) return true;
        //return this.compareTo(that) == 0;
        return toTaintBoolean(this.compareTo(that));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.516 -0500", hash_original_method = "EE31E2EDAF6F402A909910F793361153", hash_generated_method = "57B2634122888BCF4E17A8B21DDBC6B1")
    
public boolean equals(Object that) {
        try {
            return equals((Configuration)that);
        } catch (ClassCastException e) {
        }
        return false;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:05.518 -0500", hash_original_method = "046D4D394490FA85ED827B86F99F4B68", hash_generated_method = "DEEA1E3D7B219C47EF3049F7CBC03159")
    
public int hashCode() {
        int result = 17;
        result = 31 * result + Float.floatToIntBits(fontScale);
        result = 31 * result + mcc;
        result = 31 * result + mnc;
        result = 31 * result + (locale != null ? locale.hashCode() : 0);
        result = 31 * result + touchscreen;
        result = 31 * result + keyboard;
        result = 31 * result + keyboardHidden;
        result = 31 * result + hardKeyboardHidden;
        result = 31 * result + navigation;
        result = 31 * result + navigationHidden;
        result = 31 * result + orientation;
        result = 31 * result + screenLayout;
        result = 31 * result + uiMode;
        result = 31 * result + screenWidthDp;
        result = 31 * result + screenHeightDp;
        result = 31 * result + smallestScreenWidthDp;
        return result;
    }
}

