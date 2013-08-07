package android.os;

// Droidsafe Imports
import droidsafe.annotations.*;
import com.android.internal.telephony.TelephonyProperties;






public class Build {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.718 -0400", hash_original_method = "F7D4D478B3FB8EE28A8245D7D32DBDD3", hash_generated_method = "F7D4D478B3FB8EE28A8245D7D32DBDD3")
    public Build ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SPEC)
    public static String getRadioVersion() {
        return SystemProperties.get(TelephonyProperties.PROPERTY_BASEBAND_VERSION, null);
    }

    
    @DSModeled(DSC.BAN)
    private static String getString(String property) {
        return SystemProperties.get(property, UNKNOWN);
    }

    
    @DSModeled(DSC.BAN)
    private static long getLong(String property) {
        try {
            return Long.parseLong(SystemProperties.get(property));
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    
    public static class VERSION {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.723 -0400", hash_original_method = "36407A5836A03DF2FB40C80D8028F841", hash_generated_method = "36407A5836A03DF2FB40C80D8028F841")
        public VERSION ()
        {
            //Synthesized constructor
        }


        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.723 -0400", hash_original_field = "23E683997A50D0DC370165BB9CE03044", hash_generated_field = "C89B4CFA69E781BDF05F6069340308C9")

        public static final String INCREMENTAL = getString("ro.build.version.incremental");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.723 -0400", hash_original_field = "0CA03A23C8F277213C9DDE2DB998F382", hash_generated_field = "F5C028C2137BB93CE7D71E101B5F94CC")

        public static final String RELEASE = getString("ro.build.version.release");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.723 -0400", hash_original_field = "6871F734C6CA0DE67E08315E8AB474FB", hash_generated_field = "FF1B3309B0474CD6080F564C045641E9")

        @Deprecated
        public static final String SDK = getString("ro.build.version.sdk");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.723 -0400", hash_original_field = "C0A627347C928D39A5BAD09E3467007F", hash_generated_field = "C49FCDE56C7E66322A64898DF51ED3E3")

        public static final int SDK_INT = SystemProperties.getInt(
                "ro.build.version.sdk", 0);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.723 -0400", hash_original_field = "15AC8450F3A7EFADF8CDB5D613BD57B3", hash_generated_field = "B183E8F566F9BE590DC2EB77C5CEFE87")

        public static final String CODENAME = getString("ro.build.version.codename");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.723 -0400", hash_original_field = "7FA8166EC890672D1ADDA0E669F50005", hash_generated_field = "404E1DC62F6ADEBB5B39435D883D4C3C")

        public static final int RESOURCES_SDK_INT = SDK_INT
                + ("REL".equals(CODENAME) ? 0 : 1);
    }


    
    public static class VERSION_CODES {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.724 -0400", hash_original_method = "0B6BCBBF45E050C1684E109EABF935A3", hash_generated_method = "0B6BCBBF45E050C1684E109EABF935A3")
        public VERSION_CODES ()
        {
            //Synthesized constructor
        }


        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.724 -0400", hash_original_field = "7468DF7AE596FA4B62F6CF788AAF19C3", hash_generated_field = "013C5374890283317202E565BA7C0DD8")

        public static final int CUR_DEVELOPMENT = 10000;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.724 -0400", hash_original_field = "8D39C296B3AEFA93E6AEB26BEC4537A5", hash_generated_field = "53FE49F548020C3B12657019DE8011B3")

        public static final int BASE = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.724 -0400", hash_original_field = "2190BC6B1317FC064D11C36A425FD872", hash_generated_field = "F1AB0625553050CAECA9F205E9909896")

        public static final int BASE_1_1 = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.724 -0400", hash_original_field = "FB7DC77CA85D97836191EA3828F27750", hash_generated_field = "C90EBB1511EDF4068EE2ED18961DDE1E")

        public static final int CUPCAKE = 3;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.724 -0400", hash_original_field = "B9AF3B63F3DC4E53085E11D4B012AECE", hash_generated_field = "7D0086B2183D9EFAB6434136F44169C3")

        public static final int DONUT = 4;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.724 -0400", hash_original_field = "CF8D476296EA6BA14A50DB340CBB7FE3", hash_generated_field = "21BB985D8F8C996BE6AAFCC84DF7B467")

        public static final int ECLAIR = 5;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.724 -0400", hash_original_field = "88116AE353959EFE7DF575280335136F", hash_generated_field = "9119DB8577251F22294365F7832764E9")

        public static final int ECLAIR_0_1 = 6;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.724 -0400", hash_original_field = "4A8BA469C88A41250EDBCA0F38672567", hash_generated_field = "53F16CA907D56C805DED36ADD1D402C3")

        public static final int ECLAIR_MR1 = 7;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.724 -0400", hash_original_field = "2F3039255BBAE0B10868628DA8524C5E", hash_generated_field = "502F3269CAD7345923B8EBA81E8C3043")

        public static final int FROYO = 8;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.724 -0400", hash_original_field = "01381E47D75B454E303526AC2A53776B", hash_generated_field = "360820858495495DD567E270F15C13DE")

        public static final int GINGERBREAD = 9;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.724 -0400", hash_original_field = "98528E0F432BFDFF2A45D438BD3611ED", hash_generated_field = "7B71C9BDE79D8D02E29BEBCF4ADD7AA6")

        public static final int GINGERBREAD_MR1 = 10;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.724 -0400", hash_original_field = "AF64DCC553B411957BAC29B7B8E4FB66", hash_generated_field = "FE9D8CC695B770C0FC501CB895B84BC8")

        public static final int HONEYCOMB = 11;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.725 -0400", hash_original_field = "F8066545BDAF3BEB135BB8F5ADAC0C5D", hash_generated_field = "510B8DF55D991C35F59B7CF8861D6218")

        public static final int HONEYCOMB_MR1 = 12;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.725 -0400", hash_original_field = "22387306B5FBE5A292619B99A352778C", hash_generated_field = "7F724420EAE33876C21699E21E85F304")

        public static final int HONEYCOMB_MR2 = 13;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.725 -0400", hash_original_field = "DFFD93FF8AF412BA3D667096962BA55B", hash_generated_field = "A2C202D6D6F66FF8502DCBEFA44DB368")

        public static final int ICE_CREAM_SANDWICH = 14;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.725 -0400", hash_original_field = "6506F2509AE45C790B270013BA74B574", hash_generated_field = "D1849482125E5D16B4D655BFA9F6B3EC")

        public static final int ICE_CREAM_SANDWICH_MR1 = 15;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.725 -0400", hash_original_field = "7AA41D1CAB44B370FE59A92AB56FAFFA", hash_generated_field = "D26D08A366C3AD1AEBD8031F18AE7AA6")

    public static final String UNKNOWN = "unknown";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.725 -0400", hash_original_field = "3E79B3CEACF98768CEF7CD968EFDF3B3", hash_generated_field = "3E8D01EE51048AE4927E3F95374F0B08")

    public static final String ID = getString("ro.build.id");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.725 -0400", hash_original_field = "8A0DB1979348BF7B1C06FBF0245BF83F", hash_generated_field = "3A0CB0015E49C875434E804A57FEE8E7")

    public static final String DISPLAY = getString("ro.build.display.id");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.725 -0400", hash_original_field = "6FB5FFC8A28F4DD775AB99441ACF8B3B", hash_generated_field = "6A916C7902B116E6322021C3C3FFBD0D")

    public static final String PRODUCT = getString("ro.product.name");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.725 -0400", hash_original_field = "98A73A20A08372FFA229B22E624EA460", hash_generated_field = "6D0995E719D47C2DED874FBE04D077EB")

    public static final String DEVICE = getString("ro.product.device");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.725 -0400", hash_original_field = "9772A201050FCC767548CFC651950D89", hash_generated_field = "F930ABBBE769FF7BCA11CF95F4857FE4")

    public static final String BOARD = getString("ro.product.board");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.725 -0400", hash_original_field = "78B6D5F964B791E26923E44E9167C187", hash_generated_field = "DA27D00529F687F8F1AB5EC641473FC0")

    public static final String CPU_ABI = getString("ro.product.cpu.abi");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.725 -0400", hash_original_field = "0474E940026FFA3293A48A9B42497CF1", hash_generated_field = "2B26FB44DC1FCBA4774A671C3A370A02")

    public static final String CPU_ABI2 = getString("ro.product.cpu.abi2");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.725 -0400", hash_original_field = "2029140986973A6D709ABEABA5AD5E34", hash_generated_field = "8673410180926F4864926E70E7DB8C35")

    public static final String MANUFACTURER = getString("ro.product.manufacturer");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.725 -0400", hash_original_field = "DE3C72DEBB1815D6E75445A3D7F5C7DF", hash_generated_field = "84066B41BFAB1C9DC9828B72DD24BC55")

    public static final String BRAND = getString("ro.product.brand");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.725 -0400", hash_original_field = "8F5B813EDE250FB6110152F02CD32AA5", hash_generated_field = "E324D91DC88236BEC08B77702D9F5A0B")

    public static final String MODEL = getString("ro.product.model");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.726 -0400", hash_original_field = "E5CAB4E7F88FADC33A96B91D97BE3F61", hash_generated_field = "223EAB7D6A4825BCD1D2D1069523B8A3")

    public static final String BOOTLOADER = getString("ro.bootloader");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.726 -0400", hash_original_field = "9171DDA9130FB208C24AACB83A6386ED", hash_generated_field = "B7E8FBE8D52EC528CC148EA4B7E0E330")

    @Deprecated
    public static final String RADIO = getString(TelephonyProperties.PROPERTY_BASEBAND_VERSION);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.729 -0400", hash_original_field = "FA3CDC53C7F44E6AB72FA1DFD8DCC663", hash_generated_field = "696620FC6256F2894B0251F902ADCFF7")

    public static final String HARDWARE = getString("ro.hardware");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.729 -0400", hash_original_field = "6D0E3206B52562CE76283958A8D83957", hash_generated_field = "230CFAFA659CB7B3AB39C893C858E483")

    public static final String SERIAL = getString("ro.serialno");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.729 -0400", hash_original_field = "691B3B4163BBF4FD691D804523837ECF", hash_generated_field = "8B879673081842EC6D5239A6B8105A2D")

    public static final String TYPE = getString("ro.build.type");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.729 -0400", hash_original_field = "923CDF33894F9B66F0890AA138BD7F12", hash_generated_field = "6451D2016E64C5C4DAAFC277237D9E94")

    public static final String TAGS = getString("ro.build.tags");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.729 -0400", hash_original_field = "26E073BCD81430401BB3CCB6E837293A", hash_generated_field = "7FF1712A74A190A6E8E56BD1537A0655")

    public static final String FINGERPRINT = getString("ro.build.fingerprint");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.729 -0400", hash_original_field = "19D4B927153C95C0B2BCCD2A7A419511", hash_generated_field = "0A4A2F105116903F5CEAFC5099E5B530")

    public static final long TIME = getLong("ro.build.date.utc") * 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.729 -0400", hash_original_field = "1D700C10019AB2C05631596A8BD48096", hash_generated_field = "551A811F14B6DCD9413E81A3F48228C4")

    public static final String USER = getString("ro.build.user");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.729 -0400", hash_original_field = "A1B7017BBDE2C4728C0FB6B620312148", hash_generated_field = "CDB33749EF1F295BDBAAADF7D959CA81")

    public static final String HOST = getString("ro.build.host");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.729 -0400", hash_original_field = "7A8F555217F0D07FBCFABF4C1B0EAE00", hash_generated_field = "5EB7AEF1F40A52B5B756AB1950C61CE0")

    public static final boolean IS_DEBUGGABLE =
            SystemProperties.getInt("ro.debuggable", 0) == 1;
}

