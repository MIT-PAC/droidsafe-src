package org.apache.commons.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.Serializable;

public final class IOCase implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.936 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.947 -0400", hash_original_field = "7BDC8A923EA34AF94C5D36604D0FB3DC", hash_generated_field = "8CB56C87B0269066CFF96D607DC1BAB7")

    private transient boolean sensitive;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.947 -0400", hash_original_method = "923C527E378097C1219119EB83365F82", hash_generated_method = "92452AF0D193B153BEDBB1685F178A29")
    private  IOCase(String name, boolean sensitive) {
        this.name = name;
        this.sensitive = sensitive;
        // ---------- Original Method ----------
        //this.name = name;
        //this.sensitive = sensitive;
    }

    
        public static IOCase forName(String name) {
        if (IOCase.SENSITIVE.name.equals(name)){
            return IOCase.SENSITIVE;
        }
        if (IOCase.INSENSITIVE.name.equals(name)){
            return IOCase.INSENSITIVE;
        }
        if (IOCase.SYSTEM.name.equals(name)){
            return IOCase.SYSTEM;
        }
        throw new IllegalArgumentException("Invalid IOCase name: " + name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.948 -0400", hash_original_method = "75E6AD44795DF0269F8B428E9F990646", hash_generated_method = "75C5E293F3BAAF6B18839C982240F7C0")
    private Object readResolve() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1057599767 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1057599767 = forName(name);
        varB4EAC82CA7396A68D541C85D26508E83_1057599767.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1057599767;
        // ---------- Original Method ----------
        //return forName(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.949 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "323AECC8620DC5BDA264764AA37E6475")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1003591816 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1003591816 = name;
        varB4EAC82CA7396A68D541C85D26508E83_1003591816.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1003591816;
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.949 -0400", hash_original_method = "D4D1A27073CB69531CAF258DC4B9AC95", hash_generated_method = "25AADC62B792E1DD01ACE1622A48FB2E")
    public boolean isCaseSensitive() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_151070933 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_151070933;
        // ---------- Original Method ----------
        //return sensitive;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.950 -0400", hash_original_method = "FCED5C8D6D9F97DBA9E3BA0A98F2A945", hash_generated_method = "E14060E52904DAC74A705E114177B115")
    public int checkCompareTo(String str1, String str2) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("The strings must not be null");
        } //End block
        {
            Object var5C0ABD88345A4252A95EF43F779FDAA1_1926580071 = (str1.compareTo(str2));
            Object varE285333B0417D48426DDEA781A4E1CED_406228714 = (str1.compareToIgnoreCase(str2));
        } //End flattened ternary
        addTaint(str1.getTaint());
        addTaint(str2.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1895084987 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1895084987;
        // ---------- Original Method ----------
        //if (str1 == null || str2 == null) {
            //throw new NullPointerException("The strings must not be null");
        //}
        //return sensitive ? str1.compareTo(str2) : str1.compareToIgnoreCase(str2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.951 -0400", hash_original_method = "A1834B40E07842ED206E79B7DD652E98", hash_generated_method = "621D3775AD2B7CB63DA75C0E80A5BBAF")
    public boolean checkEquals(String str1, String str2) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("The strings must not be null");
        } //End block
        {
            Object var97ED97CDDFE38BD6BC786171BDF02FAE_965649612 = (str1.equals(str2));
            Object varA582878C61EBD92E1F4B58F2012AFFD8_1216931298 = (str1.equalsIgnoreCase(str2));
        } //End flattened ternary
        addTaint(str1.getTaint());
        addTaint(str2.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_387012403 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_387012403;
        // ---------- Original Method ----------
        //if (str1 == null || str2 == null) {
            //throw new NullPointerException("The strings must not be null");
        //}
        //return sensitive ? str1.equals(str2) : str1.equalsIgnoreCase(str2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.960 -0400", hash_original_method = "DE959B82FAE20A2C02C6F6668F717E02", hash_generated_method = "97B922F1322C9F5B720137FDABF670F8")
    public boolean checkStartsWith(String str, String start) {
        boolean varEDC34A4747CF71F35B315AC3E8198FC0_1335412741 = (str.regionMatches(!sensitive, 0, start, 0, start.length()));
        addTaint(str.getTaint());
        addTaint(start.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_666776235 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_666776235;
        // ---------- Original Method ----------
        //return str.regionMatches(!sensitive, 0, start, 0, start.length());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.960 -0400", hash_original_method = "5DEB3C8085F8F60F4136227F14208410", hash_generated_method = "2079D84176DDDBB921FC6230979E971E")
    public boolean checkEndsWith(String str, String end) {
        int endLen;
        endLen = end.length();
        boolean varE1E5943EACC9E3F817E33528C780155E_800835856 = (str.regionMatches(!sensitive, str.length() - endLen, end, 0, endLen));
        addTaint(str.getTaint());
        addTaint(end.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1704137503 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1704137503;
        // ---------- Original Method ----------
        //int endLen = end.length();
        //return str.regionMatches(!sensitive, str.length() - endLen, end, 0, endLen);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.961 -0400", hash_original_method = "8D9B60D64D088F60BE3CDF32B6A1EFAB", hash_generated_method = "7230DF0047E5E2B5C55CF0C5FF5D929B")
    public int checkIndexOf(String str, int strStartIndex, String search) {
        int endIndex;
        endIndex = str.length() - search.length();
        {
            {
                int i;
                i = strStartIndex;
                {
                    {
                        boolean var0B0235FC995B1B9A78D7E0CF77A646F8_495560458 = (checkRegionMatches(str, i, search));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(str.getTaint());
        addTaint(strStartIndex);
        addTaint(search.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1338667968 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1338667968;
        // ---------- Original Method ----------
        //int endIndex = str.length() - search.length();
        //if (endIndex >= strStartIndex) {
            //for (int i = strStartIndex; i <= endIndex; i++) {
                //if (checkRegionMatches(str, i, search)) {
                    //return i;
                //}
            //}
        //}
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.961 -0400", hash_original_method = "F30BBDDAAC2E6AD203135C0D7804F286", hash_generated_method = "52A172EDA2316BB33BCECD8E7F32AC96")
    public boolean checkRegionMatches(String str, int strStartIndex, String search) {
        boolean var40ECF95786974EE0FD7D74DC9D6CA099_1653873531 = (str.regionMatches(!sensitive, strStartIndex, search, 0, search.length()));
        addTaint(str.getTaint());
        addTaint(strStartIndex);
        addTaint(search.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_682706782 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_682706782;
        // ---------- Original Method ----------
        //return str.regionMatches(!sensitive, strStartIndex, search, 0, search.length());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.962 -0400", hash_original_method = "0EB66BA5E965B83E191719250E0A82FF", hash_generated_method = "0464581BA628359B883950A50E9C4096")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1756425294 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1756425294 = name;
        varB4EAC82CA7396A68D541C85D26508E83_1756425294.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1756425294;
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.962 -0400", hash_original_field = "7BC414DFDB759C41973242D0A494C43D", hash_generated_field = "330382E58EBF50A44FA8DEE9CA480DDC")

    public static final IOCase SENSITIVE = new IOCase("Sensitive", true);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.962 -0400", hash_original_field = "0D0E7F12109CD59DA294EAAB2C0AFBD5", hash_generated_field = "6C98626F646DC5FDB3D239DAA2B28981")

    public static final IOCase INSENSITIVE = new IOCase("Insensitive", false);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.962 -0400", hash_original_field = "13A53C050D6A22B7FC8D9EC8A2C33153", hash_generated_field = "5830A4A67AFD721DB0E9D0F8F7239E9D")

    public static final IOCase SYSTEM = new IOCase("System", !FilenameUtils.isSystemWindows());
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.962 -0400", hash_original_field = "96E0DA518258D6AA4BA7372877DD9765", hash_generated_field = "907D55B8A6703884A07350EDD14CB8ED")

    private static long serialVersionUID = -6343169151696340687L;
}

