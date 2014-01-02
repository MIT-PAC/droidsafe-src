package android.os;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import com.android.internal.telephony.TelephonyProperties;






public class Build {

    /**
     * Returns the version string for the radio firmware.  May return
     * null (if, for instance, the radio is not currently on).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.607 -0500", hash_original_method = "3B8999FDFEE854B82721B15385523740", hash_generated_method = "6AA38C91E136D282F6E7B93D837E38E3")
    
public static String getRadioVersion() {
        return SystemProperties.get(TelephonyProperties.PROPERTY_BASEBAND_VERSION, null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.609 -0500", hash_original_method = "418D9C5925500F64D1F7A5BD4EFEEBDF", hash_generated_method = "5447853DC2CC16B9C3F64D805AE1C559")
    
private static String getString(String property) {
        return SystemProperties.get(property, UNKNOWN);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.612 -0500", hash_original_method = "C6E00A05CF4577B1F2FE54583AF3AC48", hash_generated_method = "12919BF320CA15FB8D6B906889F09136")
    
private static long getLong(String property) {
        try {
            return Long.parseLong(SystemProperties.get(property));
        } catch (NumberFormatException e) {
            return -1;
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.490 -0500", hash_original_field = "5A462897EA48AEA5F9A0CB0CCF53A323", hash_generated_field = "D26D08A366C3AD1AEBD8031F18AE7AA6")

    public static final String UNKNOWN = "unknown";

    
    public static class VERSION {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.530 -0500", hash_original_field = "957A353EF9C9CF8728D8F01A81ADB47D", hash_generated_field = "C89B4CFA69E781BDF05F6069340308C9")

        public static final String INCREMENTAL = getString("ro.build.version.incremental");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.532 -0500", hash_original_field = "9C62B4246976198008C7712990DC0D22", hash_generated_field = "F5C028C2137BB93CE7D71E101B5F94CC")

        public static final String RELEASE = getString("ro.build.version.release");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.535 -0500", hash_original_field = "850829589D6A9079D98AB758470936AE", hash_generated_field = "FF1B3309B0474CD6080F564C045641E9")

        @Deprecated
        public static final String SDK = getString("ro.build.version.sdk");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.537 -0500", hash_original_field = "1F67B2A079B16701D95BF35C821341CE", hash_generated_field = "C49FCDE56C7E66322A64898DF51ED3E3")

        public static final int SDK_INT = SystemProperties.getInt(
                "ro.build.version.sdk", 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.540 -0500", hash_original_field = "98BDDC2EB40EDE0A302D9F31C6CFA907", hash_generated_field = "B183E8F566F9BE590DC2EB77C5CEFE87")

        public static final String CODENAME = getString("ro.build.version.codename");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.543 -0500", hash_original_field = "2A892ABBD29EE1EDB4A693F7EB266066", hash_generated_field = "404E1DC62F6ADEBB5B39435D883D4C3C")

        public static final int RESOURCES_SDK_INT = SDK_INT
                + ("REL".equals(CODENAME) ? 0 : 1);
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.723 -0400", hash_original_method = "36407A5836A03DF2FB40C80D8028F841", hash_generated_method = "36407A5836A03DF2FB40C80D8028F841")
        public VERSION ()
        {
            //Synthesized constructor
        }
    }


    
    public static class VERSION_CODES {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.548 -0500", hash_original_field = "4C3AD6045E45B15453C0B270B4C25AE2", hash_generated_field = "013C5374890283317202E565BA7C0DD8")

        public static final int CUR_DEVELOPMENT = 10000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.550 -0500", hash_original_field = "8AA02E02D1676564AFC7D545CAEB4C70", hash_generated_field = "53FE49F548020C3B12657019DE8011B3")

        public static final int BASE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.552 -0500", hash_original_field = "8AFDB45879DEE6151BFF2C2CEBEBB96E", hash_generated_field = "F1AB0625553050CAECA9F205E9909896")

        public static final int BASE_1_1 = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.555 -0500", hash_original_field = "704D864E4F828E1C2521813C877ED8DC", hash_generated_field = "C90EBB1511EDF4068EE2ED18961DDE1E")

        public static final int CUPCAKE = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.558 -0500", hash_original_field = "312A5508E2DAC03BA67810D51AF0A4B2", hash_generated_field = "7D0086B2183D9EFAB6434136F44169C3")

        public static final int DONUT = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.560 -0500", hash_original_field = "069086451D70606C12B611B5E55864A7", hash_generated_field = "21BB985D8F8C996BE6AAFCC84DF7B467")

        public static final int ECLAIR = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.563 -0500", hash_original_field = "FD2DDF03454EC19A1731362EEA59C00E", hash_generated_field = "9119DB8577251F22294365F7832764E9")

        public static final int ECLAIR_0_1 = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.565 -0500", hash_original_field = "91608493A27111E7C97C987AFFB0163D", hash_generated_field = "53F16CA907D56C805DED36ADD1D402C3")

        public static final int ECLAIR_MR1 = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.567 -0500", hash_original_field = "D21DBE9231A768DE1B2ECAE3C37C31DD", hash_generated_field = "502F3269CAD7345923B8EBA81E8C3043")

        public static final int FROYO = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.570 -0500", hash_original_field = "29019AEA93042BFD07F366756D78EF65", hash_generated_field = "360820858495495DD567E270F15C13DE")

        public static final int GINGERBREAD = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.572 -0500", hash_original_field = "8740B87C65CF707A3BAE1C4A3A54B3F3", hash_generated_field = "7B71C9BDE79D8D02E29BEBCF4ADD7AA6")

        public static final int GINGERBREAD_MR1 = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.575 -0500", hash_original_field = "96C0E1C589D3827CD74FAEAD9361F1E8", hash_generated_field = "FE9D8CC695B770C0FC501CB895B84BC8")

        public static final int HONEYCOMB = 11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.578 -0500", hash_original_field = "30C3D31D89718A5BF2EC780D05068B56", hash_generated_field = "510B8DF55D991C35F59B7CF8861D6218")

        public static final int HONEYCOMB_MR1 = 12;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.580 -0500", hash_original_field = "EF83AE16297A9123361C7E9193BBA0CE", hash_generated_field = "7F724420EAE33876C21699E21E85F304")

        public static final int HONEYCOMB_MR2 = 13;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.583 -0500", hash_original_field = "FE43A4EF69DC36BB10BBDB70BE694F2C", hash_generated_field = "A2C202D6D6F66FF8502DCBEFA44DB368")

        public static final int ICE_CREAM_SANDWICH = 14;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.586 -0500", hash_original_field = "23643A88208C9FE23BA6707A9F022D33", hash_generated_field = "D1849482125E5D16B4D655BFA9F6B3EC")

        public static final int ICE_CREAM_SANDWICH_MR1 = 15;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.724 -0400", hash_original_method = "0B6BCBBF45E050C1684E109EABF935A3", hash_generated_method = "0B6BCBBF45E050C1684E109EABF935A3")
        public VERSION_CODES ()
        {
            //Synthesized constructor
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.492 -0500", hash_original_field = "4B6738290A4B592E6639593B470400B9", hash_generated_field = "3E8D01EE51048AE4927E3F95374F0B08")

    public static final String ID = getString("ro.build.id");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.495 -0500", hash_original_field = "A9E8CC04A9CA26A1B98B432EE4E71C96", hash_generated_field = "3A0CB0015E49C875434E804A57FEE8E7")

    public static final String DISPLAY = getString("ro.build.display.id");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.497 -0500", hash_original_field = "7532F676C9FC00772664F8FB2A4E2BD1", hash_generated_field = "6A916C7902B116E6322021C3C3FFBD0D")

    public static final String PRODUCT = getString("ro.product.name");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.499 -0500", hash_original_field = "43910683B08D04160D3988AC9B04EFAC", hash_generated_field = "6D0995E719D47C2DED874FBE04D077EB")

    public static final String DEVICE = getString("ro.product.device");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.502 -0500", hash_original_field = "EC7CCE8CF66C3300F37657850372200F", hash_generated_field = "F930ABBBE769FF7BCA11CF95F4857FE4")

    public static final String BOARD = getString("ro.product.board");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.505 -0500", hash_original_field = "A5257305350B2A615BDCF1C6B72C0A6B", hash_generated_field = "DA27D00529F687F8F1AB5EC641473FC0")

    public static final String CPU_ABI = getString("ro.product.cpu.abi");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.507 -0500", hash_original_field = "53DC7519070ED4B3E716C13BF863091A", hash_generated_field = "2B26FB44DC1FCBA4774A671C3A370A02")

    public static final String CPU_ABI2 = getString("ro.product.cpu.abi2");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.511 -0500", hash_original_field = "5612EE96B7B37F5F40E832D5E0977FEF", hash_generated_field = "8673410180926F4864926E70E7DB8C35")

    public static final String MANUFACTURER = getString("ro.product.manufacturer");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.514 -0500", hash_original_field = "07308F64BC2D3298CAD0F6C6711B7032", hash_generated_field = "84066B41BFAB1C9DC9828B72DD24BC55")

    public static final String BRAND = getString("ro.product.brand");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.516 -0500", hash_original_field = "401DCF0ECF5232716760B03416FF969B", hash_generated_field = "E324D91DC88236BEC08B77702D9F5A0B")

    public static final String MODEL = getString("ro.product.model");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.519 -0500", hash_original_field = "947C79326FBDB4D69C0370F6165473A3", hash_generated_field = "223EAB7D6A4825BCD1D2D1069523B8A3")

    public static final String BOOTLOADER = getString("ro.bootloader");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.521 -0500", hash_original_field = "6FC1A70892EA942CE95823D1B641DF44", hash_generated_field = "B7E8FBE8D52EC528CC148EA4B7E0E330")

    @Deprecated
    public static final String RADIO = getString(TelephonyProperties.PROPERTY_BASEBAND_VERSION);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.524 -0500", hash_original_field = "259E6285AD1D80A1B815AB0026874228", hash_generated_field = "696620FC6256F2894B0251F902ADCFF7")

    public static final String HARDWARE = getString("ro.hardware");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.527 -0500", hash_original_field = "78ECC24C1056AFBCBB1752B4885C480D", hash_generated_field = "230CFAFA659CB7B3AB39C893C858E483")
 
    public static final String SERIAL = getString("ro.serialno");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.591 -0500", hash_original_field = "64E0DEADDA74E0E3F15EC75FB5665D50", hash_generated_field = "8B879673081842EC6D5239A6B8105A2D")

    public static final String TYPE = getString("ro.build.type");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.593 -0500", hash_original_field = "77CF3E032321FEDD882305C0F4A808DD", hash_generated_field = "6451D2016E64C5C4DAAFC277237D9E94")

    public static final String TAGS = getString("ro.build.tags");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.595 -0500", hash_original_field = "329687BBEF8586C09E775F0E9A22A6D9", hash_generated_field = "7FF1712A74A190A6E8E56BD1537A0655")

    public static final String FINGERPRINT = getString("ro.build.fingerprint");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.597 -0500", hash_original_field = "A63ED4ABD234F08D49E74F4C9B683940", hash_generated_field = "0A4A2F105116903F5CEAFC5099E5B530")

    public static final long TIME = getLong("ro.build.date.utc") * 1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.600 -0500", hash_original_field = "F5FC6D24E2468D236B6B090792CF05FE", hash_generated_field = "551A811F14B6DCD9413E81A3F48228C4")

    public static final String USER = getString("ro.build.user");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.602 -0500", hash_original_field = "7B30C501AC55CC2A872AAB687E267479", hash_generated_field = "CDB33749EF1F295BDBAAADF7D959CA81")

    public static final String HOST = getString("ro.build.host");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.605 -0500", hash_original_field = "2A53E827BB49BE245E477F01A7D756B7", hash_generated_field = "5EB7AEF1F40A52B5B756AB1950C61CE0")

    public static final boolean IS_DEBUGGABLE =
            SystemProperties.getInt("ro.debuggable", 0) == 1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.718 -0400", hash_original_method = "F7D4D478B3FB8EE28A8245D7D32DBDD3", hash_generated_method = "F7D4D478B3FB8EE28A8245D7D32DBDD3")
    public Build ()
    {
        //Synthesized constructor
    }
}

