package org.apache.commons.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.Serializable;

public final class IOCase implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.781 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.781 -0400", hash_original_field = "7BDC8A923EA34AF94C5D36604D0FB3DC", hash_generated_field = "8CB56C87B0269066CFF96D607DC1BAB7")

    private transient boolean sensitive;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.782 -0400", hash_original_method = "923C527E378097C1219119EB83365F82", hash_generated_method = "92452AF0D193B153BEDBB1685F178A29")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.783 -0400", hash_original_method = "75E6AD44795DF0269F8B428E9F990646", hash_generated_method = "47A1E422FA8BAC6B0D7CF27D8DDEA0EF")
    private Object readResolve() {
        Object varB4EAC82CA7396A68D541C85D26508E83_669784404 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_669784404 = forName(name);
        varB4EAC82CA7396A68D541C85D26508E83_669784404.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_669784404;
        // ---------- Original Method ----------
        //return forName(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.783 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "F84AF2BE14FA7348F8E8A3D6CCA5BEE2")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1180690958 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1180690958 = name;
        varB4EAC82CA7396A68D541C85D26508E83_1180690958.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1180690958;
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.791 -0400", hash_original_method = "D4D1A27073CB69531CAF258DC4B9AC95", hash_generated_method = "6B463F0F10CF33086770B0AB75E6F2F5")
    public boolean isCaseSensitive() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_769012727 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_769012727;
        // ---------- Original Method ----------
        //return sensitive;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.797 -0400", hash_original_method = "FCED5C8D6D9F97DBA9E3BA0A98F2A945", hash_generated_method = "2B967C8DF612EAC5832CAFDB03C3AA3F")
    public int checkCompareTo(String str1, String str2) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("The strings must not be null");
        } //End block
        {
            Object var5C0ABD88345A4252A95EF43F779FDAA1_1052606264 = (str1.compareTo(str2));
            Object varE285333B0417D48426DDEA781A4E1CED_1169421712 = (str1.compareToIgnoreCase(str2));
        } //End flattened ternary
        addTaint(str1.getTaint());
        addTaint(str2.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1598270106 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1598270106;
        // ---------- Original Method ----------
        //if (str1 == null || str2 == null) {
            //throw new NullPointerException("The strings must not be null");
        //}
        //return sensitive ? str1.compareTo(str2) : str1.compareToIgnoreCase(str2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.802 -0400", hash_original_method = "A1834B40E07842ED206E79B7DD652E98", hash_generated_method = "9344D4026A30218EBE73179F1246FA0B")
    public boolean checkEquals(String str1, String str2) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("The strings must not be null");
        } //End block
        {
            Object var97ED97CDDFE38BD6BC786171BDF02FAE_64528989 = (str1.equals(str2));
            Object varA582878C61EBD92E1F4B58F2012AFFD8_702180600 = (str1.equalsIgnoreCase(str2));
        } //End flattened ternary
        addTaint(str1.getTaint());
        addTaint(str2.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1714662622 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1714662622;
        // ---------- Original Method ----------
        //if (str1 == null || str2 == null) {
            //throw new NullPointerException("The strings must not be null");
        //}
        //return sensitive ? str1.equals(str2) : str1.equalsIgnoreCase(str2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.802 -0400", hash_original_method = "DE959B82FAE20A2C02C6F6668F717E02", hash_generated_method = "94EDCD18E11FB920407636D9841CFE32")
    public boolean checkStartsWith(String str, String start) {
        boolean varEDC34A4747CF71F35B315AC3E8198FC0_117029804 = (str.regionMatches(!sensitive, 0, start, 0, start.length()));
        addTaint(str.getTaint());
        addTaint(start.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_429354528 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_429354528;
        // ---------- Original Method ----------
        //return str.regionMatches(!sensitive, 0, start, 0, start.length());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.803 -0400", hash_original_method = "5DEB3C8085F8F60F4136227F14208410", hash_generated_method = "D83EEB12F22463391A6D7F12811C6D83")
    public boolean checkEndsWith(String str, String end) {
        int endLen;
        endLen = end.length();
        boolean varE1E5943EACC9E3F817E33528C780155E_1388128955 = (str.regionMatches(!sensitive, str.length() - endLen, end, 0, endLen));
        addTaint(str.getTaint());
        addTaint(end.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_206869841 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_206869841;
        // ---------- Original Method ----------
        //int endLen = end.length();
        //return str.regionMatches(!sensitive, str.length() - endLen, end, 0, endLen);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.804 -0400", hash_original_method = "8D9B60D64D088F60BE3CDF32B6A1EFAB", hash_generated_method = "079A6E0CA06938582B4771EB228C8F54")
    public int checkIndexOf(String str, int strStartIndex, String search) {
        int endIndex;
        endIndex = str.length() - search.length();
        {
            {
                int i;
                i = strStartIndex;
                {
                    {
                        boolean var0B0235FC995B1B9A78D7E0CF77A646F8_1846141222 = (checkRegionMatches(str, i, search));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(str.getTaint());
        addTaint(strStartIndex);
        addTaint(search.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_789411507 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_789411507;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.805 -0400", hash_original_method = "F30BBDDAAC2E6AD203135C0D7804F286", hash_generated_method = "4FBF41A59AD182D52C0AE7FB8E5ED59C")
    public boolean checkRegionMatches(String str, int strStartIndex, String search) {
        boolean var40ECF95786974EE0FD7D74DC9D6CA099_1087784983 = (str.regionMatches(!sensitive, strStartIndex, search, 0, search.length()));
        addTaint(str.getTaint());
        addTaint(strStartIndex);
        addTaint(search.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1496716345 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1496716345;
        // ---------- Original Method ----------
        //return str.regionMatches(!sensitive, strStartIndex, search, 0, search.length());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.813 -0400", hash_original_method = "0EB66BA5E965B83E191719250E0A82FF", hash_generated_method = "D9760DCC9B55A79B5BCD2E561B179630")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_533425166 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_533425166 = name;
        varB4EAC82CA7396A68D541C85D26508E83_533425166.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_533425166;
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.814 -0400", hash_original_field = "7BC414DFDB759C41973242D0A494C43D", hash_generated_field = "330382E58EBF50A44FA8DEE9CA480DDC")

    public static final IOCase SENSITIVE = new IOCase("Sensitive", true);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.814 -0400", hash_original_field = "0D0E7F12109CD59DA294EAAB2C0AFBD5", hash_generated_field = "6C98626F646DC5FDB3D239DAA2B28981")

    public static final IOCase INSENSITIVE = new IOCase("Insensitive", false);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.814 -0400", hash_original_field = "13A53C050D6A22B7FC8D9EC8A2C33153", hash_generated_field = "5830A4A67AFD721DB0E9D0F8F7239E9D")

    public static final IOCase SYSTEM = new IOCase("System", !FilenameUtils.isSystemWindows());
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.814 -0400", hash_original_field = "96E0DA518258D6AA4BA7372877DD9765", hash_generated_field = "907D55B8A6703884A07350EDD14CB8ED")

    private static long serialVersionUID = -6343169151696340687L;
}

