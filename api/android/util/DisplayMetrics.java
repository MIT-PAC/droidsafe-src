package android.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class DisplayMetrics {
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int getDeviceDensity() {
        return 0;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:22.912 -0500", hash_original_field = "06DD28C787CA9673056A87404B9FFE96", hash_generated_field = "00F247A9966DF404621082BE869F383A")

    public static final int DENSITY_LOW = 120;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:22.914 -0500", hash_original_field = "5B1F19F430618F3E7124C4035D4792FC", hash_generated_field = "F6B6822EB511A0440CFF0E0AA0D72933")

    public static final int DENSITY_MEDIUM = 160;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:22.917 -0500", hash_original_field = "FF609A1B25E6AF5066C67414EC2F89EA", hash_generated_field = "FC2A87F9CD918C8DCFBB5E80F8156C50")

    public static final int DENSITY_TV = 213;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:22.919 -0500", hash_original_field = "DA0DBD661E946D292F62BD563F62B5E2", hash_generated_field = "34B51C3776D02254279035654DE35665")

    public static final int DENSITY_HIGH = 240;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:22.921 -0500", hash_original_field = "E0BC233B3068538B1A9FD4EAE1297BF1", hash_generated_field = "8D29280625B76F116660F09DDF1CB74E")

    public static final int DENSITY_XHIGH = 320;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:22.924 -0500", hash_original_field = "FDE246DB316EEEB815CED4EEFD8B37AF", hash_generated_field = "E79022919EF73A413AA696089BE397AA")

    public static final int DENSITY_DEFAULT = DENSITY_MEDIUM;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:22.927 -0500", hash_original_field = "955B3B43BB8E7661DF305D37455A4BC5", hash_generated_field = "A3C35CF54D9D6D6E8A0352738E6656F4")

    public static final int DENSITY_DEVICE = getDeviceDensity();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:22.929 -0500", hash_original_field = "F82C0D9DC6F80E7FE2DD4DCF84D09FAA", hash_generated_field = "B99C241A9032782F9313A0A1CCE989D4")

    public int widthPixels;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:22.931 -0500", hash_original_field = "A771AF92B2693539C802A113AB51454C", hash_generated_field = "1C86B8AE2921805813A3732A7C556D8A")

    public int heightPixels;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:22.933 -0500", hash_original_field = "B2DA43015928871B786634ACA7F73D31", hash_generated_field = "21D5C0AED090079F742CEF78065ADC39")

    public float density;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:22.935 -0500", hash_original_field = "9752EC30A5C02C683B84AACFE9670FBE", hash_generated_field = "670A9E62EFD5BE44F0E7F99804BAB388")

    public int densityDpi;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:22.937 -0500", hash_original_field = "81793D8C3FD91AF9E401188222EAFD59", hash_generated_field = "620AB5D4109AD5F129A08F4ECB7E526F")

    public float scaledDensity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:22.939 -0500", hash_original_field = "34C14F9D6536C01FDF3BBF503D53D7FA", hash_generated_field = "BDFDA8DBA6CA012FE92D5EEAF2557E1E")

    public float xdpi;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:22.941 -0500", hash_original_field = "056E5398A685C037192340F9E91B8225", hash_generated_field = "9C7C2B3D30FB7EBA78D5D824A1C13A7C")

    public float ydpi;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:22.943 -0500", hash_original_field = "80D8AFD611705B9090BBE3E74BE33653", hash_generated_field = "E1505AA7232D58383DD9D62BA7CFD497")

    public int noncompatWidthPixels;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:22.945 -0500", hash_original_field = "CCA4F849C6D3BFB0DBCFA2ACDD121777", hash_generated_field = "E7040A96B5AACC503D05F1C0846DA09C")

    public int noncompatHeightPixels;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:22.947 -0500", hash_original_field = "30DC0598C00726A9390F1E47D1FE909E", hash_generated_field = "A5055A335414D923A27D32550E0D3A50")

    public float noncompatDensity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:22.949 -0500", hash_original_field = "1134D5A8AB25EADC4F762D409BDAA2A3", hash_generated_field = "0E882AE5D7A94F2FE548CA1F7A73B1DD")

    public float noncompatScaledDensity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:22.951 -0500", hash_original_field = "BC3288F5BBB6739B89D64F2F13539075", hash_generated_field = "2AA8F922A9909FDF0239515586B77B9B")

    public float noncompatXdpi;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:22.953 -0500", hash_original_field = "7A76B8DB0D7311E4E1524870DE48AEFA", hash_generated_field = "E7D21E9F11C660B9441D398BA879C05D")

    public float noncompatYdpi;
public int noncompatDensityDpi;

    @DSComment("not sensitive/not an action")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:22.956 -0500", hash_original_method = "72B3D95037FCF3814777C19051FFD99D", hash_generated_method = "29C6DAE2839B5BA5C8B8A981B32ADBD1")
    
public DisplayMetrics() {
    }
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public void setTo(DisplayMetrics o) {
        addTaint(o.getTaint());
    }
    
    public void setToDefaults() {
    }
    
    @Override
	
    public String toString() {
        String str = new String();
        str.addTaint(getTaint());
        return str;
    }
}

