package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.SystemProperties;

public class DisplayMetrics {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.848 -0400", hash_original_field = "00F4C6DBDEA8622C7E341E3D7263B034", hash_generated_field = "B99C241A9032782F9313A0A1CCE989D4")

    public int widthPixels;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.848 -0400", hash_original_field = "1A4FE2305B1BE2E36B99BD2F16DAA528", hash_generated_field = "1C86B8AE2921805813A3732A7C556D8A")

    public int heightPixels;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.848 -0400", hash_original_field = "35F3675343000D6BB5F10CE451A571A4", hash_generated_field = "21D5C0AED090079F742CEF78065ADC39")

    public float density;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.848 -0400", hash_original_field = "500AED84829AD317C448658B165992DB", hash_generated_field = "670A9E62EFD5BE44F0E7F99804BAB388")

    public int densityDpi;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.849 -0400", hash_original_field = "49AF755ECEE2CD28C613C4F1ECB28A23", hash_generated_field = "620AB5D4109AD5F129A08F4ECB7E526F")

    public float scaledDensity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.849 -0400", hash_original_field = "8076CEAA574F9BD4B147C8C82EBB2A2A", hash_generated_field = "BDFDA8DBA6CA012FE92D5EEAF2557E1E")

    public float xdpi;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.849 -0400", hash_original_field = "064DD25414DB382674590AD64CE5525C", hash_generated_field = "9C7C2B3D30FB7EBA78D5D824A1C13A7C")

    public float ydpi;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.849 -0400", hash_original_field = "C41552E6AD396A6758F4EF1E85C77AB9", hash_generated_field = "E1505AA7232D58383DD9D62BA7CFD497")

    public int noncompatWidthPixels;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.849 -0400", hash_original_field = "66B87D7D3CB8C09C18FC1FFFF7B03D74", hash_generated_field = "E7040A96B5AACC503D05F1C0846DA09C")

    public int noncompatHeightPixels;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.849 -0400", hash_original_field = "22E9994587E62584B43A7C9AC56649B3", hash_generated_field = "A5055A335414D923A27D32550E0D3A50")

    public float noncompatDensity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.849 -0400", hash_original_field = "97A61B267DBA50AA7B2A9A8C483236F5", hash_generated_field = "0E882AE5D7A94F2FE548CA1F7A73B1DD")

    public float noncompatScaledDensity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.849 -0400", hash_original_field = "AB1AA24DB735536009784EDDB554C457", hash_generated_field = "2AA8F922A9909FDF0239515586B77B9B")

    public float noncompatXdpi;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.849 -0400", hash_original_field = "23C510E5866763500123ABA63BCA5547", hash_generated_field = "E7D21E9F11C660B9441D398BA879C05D")

    public float noncompatYdpi;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.849 -0400", hash_original_method = "72B3D95037FCF3814777C19051FFD99D", hash_generated_method = "2E9FDC4700C3C30CD4E712DF6E2BF6E3")
    public  DisplayMetrics() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.852 -0400", hash_original_method = "D037FDEFC3DBB26170014E91328ECE75", hash_generated_method = "6DE88EBBD112C6976B1E762E9C4AF96A")
    public void setTo(DisplayMetrics o) {
        widthPixels = o.widthPixels;
        heightPixels = o.heightPixels;
        density = o.density;
        densityDpi = o.densityDpi;
        scaledDensity = o.scaledDensity;
        xdpi = o.xdpi;
        ydpi = o.ydpi;
        noncompatWidthPixels = o.noncompatWidthPixels;
        noncompatHeightPixels = o.noncompatHeightPixels;
        noncompatDensity = o.noncompatDensity;
        noncompatScaledDensity = o.noncompatScaledDensity;
        noncompatXdpi = o.noncompatXdpi;
        noncompatYdpi = o.noncompatYdpi;
        // ---------- Original Method ----------
        //widthPixels = o.widthPixels;
        //heightPixels = o.heightPixels;
        //density = o.density;
        //densityDpi = o.densityDpi;
        //scaledDensity = o.scaledDensity;
        //xdpi = o.xdpi;
        //ydpi = o.ydpi;
        //noncompatWidthPixels = o.noncompatWidthPixels;
        //noncompatHeightPixels = o.noncompatHeightPixels;
        //noncompatDensity = o.noncompatDensity;
        //noncompatScaledDensity = o.noncompatScaledDensity;
        //noncompatXdpi = o.noncompatXdpi;
        //noncompatYdpi = o.noncompatYdpi;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.853 -0400", hash_original_method = "31EFDB43C431C1F23D54785D2F7319F2", hash_generated_method = "0FE93195343B6E74E337464525C71129")
    public void setToDefaults() {
        widthPixels = 0;
        heightPixels = 0;
        density = DENSITY_DEVICE / (float) DENSITY_DEFAULT;
        densityDpi = DENSITY_DEVICE;
        scaledDensity = density;
        xdpi = DENSITY_DEVICE;
        ydpi = DENSITY_DEVICE;
        noncompatWidthPixels = 0;
        noncompatHeightPixels = 0;
        // ---------- Original Method ----------
        //widthPixels = 0;
        //heightPixels = 0;
        //density = DENSITY_DEVICE / (float) DENSITY_DEFAULT;
        //densityDpi = DENSITY_DEVICE;
        //scaledDensity = density;
        //xdpi = DENSITY_DEVICE;
        //ydpi = DENSITY_DEVICE;
        //noncompatWidthPixels = 0;
        //noncompatHeightPixels = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.853 -0400", hash_original_method = "C565A2D49552DFC4E4E40856CD671AE3", hash_generated_method = "486193BCD40269B619EEDF02CAB84F53")
    @Override
    public String toString() {
String varB7BF8DE5B505C57E0EF72407430C5108_850413790 =         "DisplayMetrics{density=" + density + ", width=" + widthPixels +
            ", height=" + heightPixels + ", scaledDensity=" + scaledDensity +
            ", xdpi=" + xdpi + ", ydpi=" + ydpi + "}";
        varB7BF8DE5B505C57E0EF72407430C5108_850413790.addTaint(taint);
        return varB7BF8DE5B505C57E0EF72407430C5108_850413790;
        // ---------- Original Method ----------
        //return "DisplayMetrics{density=" + density + ", width=" + widthPixels +
            //", height=" + heightPixels + ", scaledDensity=" + scaledDensity +
            //", xdpi=" + xdpi + ", ydpi=" + ydpi + "}";
    }

    
        private static int getDeviceDensity() {
        return SystemProperties.getInt("qemu.sf.lcd_density",
                SystemProperties.getInt("ro.sf.lcd_density", DENSITY_DEFAULT));
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.854 -0400", hash_original_field = "BB4FF5593DB9AE63CFC9B6F070389438", hash_generated_field = "00F247A9966DF404621082BE869F383A")

    public static final int DENSITY_LOW = 120;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.854 -0400", hash_original_field = "A2E8F5BC49545E1E0F28172AFF4207D7", hash_generated_field = "F6B6822EB511A0440CFF0E0AA0D72933")

    public static final int DENSITY_MEDIUM = 160;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.854 -0400", hash_original_field = "9394C2BB4821CDF38E1F1EA0F6211863", hash_generated_field = "FC2A87F9CD918C8DCFBB5E80F8156C50")

    public static final int DENSITY_TV = 213;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.854 -0400", hash_original_field = "D9E342BF5857BF69D6C1FB7941CAFF2D", hash_generated_field = "34B51C3776D02254279035654DE35665")

    public static final int DENSITY_HIGH = 240;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.854 -0400", hash_original_field = "507C1CAA88AEE09C04EE42E5CEFFF6BB", hash_generated_field = "8D29280625B76F116660F09DDF1CB74E")

    public static final int DENSITY_XHIGH = 320;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.854 -0400", hash_original_field = "6AA1C2966BF56593D7259539B7DF1C79", hash_generated_field = "E79022919EF73A413AA696089BE397AA")

    public static final int DENSITY_DEFAULT = DENSITY_MEDIUM;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.854 -0400", hash_original_field = "A25657F465A5CD656C17FA21EE07DC0F", hash_generated_field = "A3C35CF54D9D6D6E8A0352738E6656F4")

    public static final int DENSITY_DEVICE = getDeviceDensity();
}

