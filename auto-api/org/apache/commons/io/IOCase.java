package org.apache.commons.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.Serializable;

public final class IOCase implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.350 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.350 -0400", hash_original_field = "7BDC8A923EA34AF94C5D36604D0FB3DC", hash_generated_field = "8CB56C87B0269066CFF96D607DC1BAB7")

    private transient boolean sensitive;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.352 -0400", hash_original_method = "923C527E378097C1219119EB83365F82", hash_generated_method = "92452AF0D193B153BEDBB1685F178A29")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.354 -0400", hash_original_method = "75E6AD44795DF0269F8B428E9F990646", hash_generated_method = "C5A0F44DFEB923517646EBE69A78EB6A")
    private Object readResolve() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1191653229 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1191653229 = forName(name);
        varB4EAC82CA7396A68D541C85D26508E83_1191653229.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1191653229;
        // ---------- Original Method ----------
        //return forName(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.355 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "D3E2C244F06FEA346FC6D5FEFDA71BD3")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1078289472 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1078289472 = name;
        varB4EAC82CA7396A68D541C85D26508E83_1078289472.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1078289472;
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.355 -0400", hash_original_method = "D4D1A27073CB69531CAF258DC4B9AC95", hash_generated_method = "94AB3A10B46180F1C2874185005CB47C")
    public boolean isCaseSensitive() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_956021501 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_956021501;
        // ---------- Original Method ----------
        //return sensitive;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.356 -0400", hash_original_method = "FCED5C8D6D9F97DBA9E3BA0A98F2A945", hash_generated_method = "68B3A46EB259B6111967FC38E1ED4A6B")
    public int checkCompareTo(String str1, String str2) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("The strings must not be null");
        } //End block
        {
            Object var5C0ABD88345A4252A95EF43F779FDAA1_176420617 = (str1.compareTo(str2));
            Object varE285333B0417D48426DDEA781A4E1CED_1127893459 = (str1.compareToIgnoreCase(str2));
        } //End flattened ternary
        addTaint(str1.getTaint());
        addTaint(str2.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_749637447 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_749637447;
        // ---------- Original Method ----------
        //if (str1 == null || str2 == null) {
            //throw new NullPointerException("The strings must not be null");
        //}
        //return sensitive ? str1.compareTo(str2) : str1.compareToIgnoreCase(str2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.357 -0400", hash_original_method = "A1834B40E07842ED206E79B7DD652E98", hash_generated_method = "BEAC8E5B502489C4317E4F9F131D42EE")
    public boolean checkEquals(String str1, String str2) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("The strings must not be null");
        } //End block
        {
            Object var97ED97CDDFE38BD6BC786171BDF02FAE_1575704670 = (str1.equals(str2));
            Object varA582878C61EBD92E1F4B58F2012AFFD8_571846346 = (str1.equalsIgnoreCase(str2));
        } //End flattened ternary
        addTaint(str1.getTaint());
        addTaint(str2.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_894966012 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_894966012;
        // ---------- Original Method ----------
        //if (str1 == null || str2 == null) {
            //throw new NullPointerException("The strings must not be null");
        //}
        //return sensitive ? str1.equals(str2) : str1.equalsIgnoreCase(str2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.357 -0400", hash_original_method = "DE959B82FAE20A2C02C6F6668F717E02", hash_generated_method = "D83375036B28D66AEFB37EDAD36C9090")
    public boolean checkStartsWith(String str, String start) {
        boolean varEDC34A4747CF71F35B315AC3E8198FC0_749669892 = (str.regionMatches(!sensitive, 0, start, 0, start.length()));
        addTaint(str.getTaint());
        addTaint(start.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1495609220 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1495609220;
        // ---------- Original Method ----------
        //return str.regionMatches(!sensitive, 0, start, 0, start.length());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.357 -0400", hash_original_method = "5DEB3C8085F8F60F4136227F14208410", hash_generated_method = "8D6117168D321D772CF79C49A654B12D")
    public boolean checkEndsWith(String str, String end) {
        int endLen = end.length();
        boolean varE1E5943EACC9E3F817E33528C780155E_1558619529 = (str.regionMatches(!sensitive, str.length() - endLen, end, 0, endLen));
        addTaint(str.getTaint());
        addTaint(end.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_509526792 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_509526792;
        // ---------- Original Method ----------
        //int endLen = end.length();
        //return str.regionMatches(!sensitive, str.length() - endLen, end, 0, endLen);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.358 -0400", hash_original_method = "8D9B60D64D088F60BE3CDF32B6A1EFAB", hash_generated_method = "72CFA7F7FE4CBA643442FEB6A369B3DF")
    public int checkIndexOf(String str, int strStartIndex, String search) {
        int endIndex = str.length() - search.length();
        {
            {
                int i = strStartIndex;
                {
                    {
                        boolean var0B0235FC995B1B9A78D7E0CF77A646F8_1982952288 = (checkRegionMatches(str, i, search));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(str.getTaint());
        addTaint(strStartIndex);
        addTaint(search.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_348099349 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_348099349;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.358 -0400", hash_original_method = "F30BBDDAAC2E6AD203135C0D7804F286", hash_generated_method = "1ADEE5AAAEAC1EBDE72DC6A36D3D4494")
    public boolean checkRegionMatches(String str, int strStartIndex, String search) {
        boolean var40ECF95786974EE0FD7D74DC9D6CA099_611425562 = (str.regionMatches(!sensitive, strStartIndex, search, 0, search.length()));
        addTaint(str.getTaint());
        addTaint(strStartIndex);
        addTaint(search.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_102313832 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_102313832;
        // ---------- Original Method ----------
        //return str.regionMatches(!sensitive, strStartIndex, search, 0, search.length());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.359 -0400", hash_original_method = "0EB66BA5E965B83E191719250E0A82FF", hash_generated_method = "FB5CDB4ADD6CF1AAB39BED4502DD2EDD")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1770216081 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1770216081 = name;
        varB4EAC82CA7396A68D541C85D26508E83_1770216081.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1770216081;
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.359 -0400", hash_original_field = "7BC414DFDB759C41973242D0A494C43D", hash_generated_field = "330382E58EBF50A44FA8DEE9CA480DDC")

    public static final IOCase SENSITIVE = new IOCase("Sensitive", true);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.359 -0400", hash_original_field = "0D0E7F12109CD59DA294EAAB2C0AFBD5", hash_generated_field = "6C98626F646DC5FDB3D239DAA2B28981")

    public static final IOCase INSENSITIVE = new IOCase("Insensitive", false);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.359 -0400", hash_original_field = "13A53C050D6A22B7FC8D9EC8A2C33153", hash_generated_field = "5830A4A67AFD721DB0E9D0F8F7239E9D")

    public static final IOCase SYSTEM = new IOCase("System", !FilenameUtils.isSystemWindows());
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.359 -0400", hash_original_field = "96E0DA518258D6AA4BA7372877DD9765", hash_generated_field = "BE8DCAAE6B2CE5E933163A69B770E39B")

    private static final long serialVersionUID = -6343169151696340687L;
}

