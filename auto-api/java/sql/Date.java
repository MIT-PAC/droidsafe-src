package java.sql;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class Date extends java.util.Date {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.735 -0400", hash_original_method = "54033E67BCAF2131C1DBBD633092C516", hash_generated_method = "E550AE89E8517B64BFE6B6FA0D1DB40B")
    @Deprecated
    public  Date(int theYear, int theMonth, int theDay) {
        super(theYear, theMonth, theDay);
        addTaint(theYear);
        addTaint(theMonth);
        addTaint(theDay);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.735 -0400", hash_original_method = "0597C0984A3A8E2CF9C870E073A794F7", hash_generated_method = "8669F986664A2B6B10801AEBAAF3C66B")
    public  Date(long theDate) {
        super(normalizeTime(theDate));
        addTaint(theDate);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.736 -0400", hash_original_method = "9D3BFA18991740345E9C4B50C3BC1C7B", hash_generated_method = "B603EDE4A99DEFF58BD4E09F4C9C931D")
    @Deprecated
    @Override
    public int getHours() {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1396470679 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1396470679;
        // ---------- Original Method ----------
        //throw new IllegalArgumentException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.736 -0400", hash_original_method = "20D35DA199D26861EF3B1850BF9B2C7B", hash_generated_method = "3ABD37B6AFCABA35F6A693D5DE1265E5")
    @Deprecated
    @Override
    public int getMinutes() {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_365066450 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_365066450;
        // ---------- Original Method ----------
        //throw new IllegalArgumentException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.736 -0400", hash_original_method = "5B3A8174ABF60BC4DD674AADB526CA5F", hash_generated_method = "00AC879094FD9037CD60B16102D808E1")
    @Deprecated
    @Override
    public int getSeconds() {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_639222426 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_639222426;
        // ---------- Original Method ----------
        //throw new IllegalArgumentException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.737 -0400", hash_original_method = "8AEDCDA359475E67EC180A6BBC9EA00B", hash_generated_method = "E2E4DAE80FBC2285AB25FD60AF62D892")
    @Deprecated
    @Override
    public void setHours(int theHours) {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        addTaint(theHours);
        // ---------- Original Method ----------
        //throw new IllegalArgumentException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.737 -0400", hash_original_method = "C3170E6698742DBDFB0C085047CF3D73", hash_generated_method = "F205A426DAA86F314AC9886B785278A7")
    @Deprecated
    @Override
    public void setMinutes(int theMinutes) {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        addTaint(theMinutes);
        // ---------- Original Method ----------
        //throw new IllegalArgumentException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.738 -0400", hash_original_method = "90D475806A3C76BA7C308DE5A81BA772", hash_generated_method = "AA7377D761FA73D20BD814A3813AFA99")
    @Deprecated
    @Override
    public void setSeconds(int theSeconds) {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        addTaint(theSeconds);
        // ---------- Original Method ----------
        //throw new IllegalArgumentException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.738 -0400", hash_original_method = "58DD96CFC8DDA00016DEC24CC6519017", hash_generated_method = "8C64DE439358128A20EE06D3791E7D50")
    @Override
    public void setTime(long theTime) {
        super.setTime(normalizeTime(theTime));
        addTaint(theTime);
        // ---------- Original Method ----------
        //super.setTime(normalizeTime(theTime));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.738 -0400", hash_original_method = "F7971D7A9962AA78000A8292B336C43C", hash_generated_method = "244CA592AAABA202D1A10C8E8C223EF7")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1924686445 = null; //Variable for return #1
        StringBuilder sb;
        sb = new StringBuilder(10);
        format((getYear() + 1900), 4, sb);
        sb.append('-');
        format((getMonth() + 1), 2, sb);
        sb.append('-');
        format(getDate(), 2, sb);
        varB4EAC82CA7396A68D541C85D26508E83_1924686445 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1924686445.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1924686445;
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder(10);
        //format((getYear() + 1900), 4, sb);
        //sb.append('-');
        //format((getMonth() + 1), 2, sb);
        //sb.append('-');
        //format(getDate(), 2, sb);
        //return sb.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.749 -0400", hash_original_method = "D5825B232A74B71A26A12413148003F7", hash_generated_method = "346498E9C0621C99F5062D7FFFF80AE0")
    private void format(int date, int digits, StringBuilder sb) {
        String str;
        str = String.valueOf(date);
        {
            boolean var727C074D045BD0678AEA087149253EBF_256021677 = (digits - str.length() > 0);
            {
                sb.append(PADDING.substring(0, digits - str.length()));
            } //End block
        } //End collapsed parenthetic
        sb.append(str);
        addTaint(date);
        addTaint(digits);
        addTaint(sb.getTaint());
        // ---------- Original Method ----------
        //String str = String.valueOf(date);
        //if (digits - str.length() > 0) {
            //sb.append(PADDING.substring(0, digits - str.length()));
        //}
        //sb.append(str);
    }

    
        public static Date valueOf(String dateString) {
        if (dateString == null) {
            throw new IllegalArgumentException();
        }
        int firstIndex = dateString.indexOf('-');
        int secondIndex = dateString.indexOf('-', firstIndex + 1);
        if (secondIndex == -1 || firstIndex == 0
                || secondIndex + 1 == dateString.length()) {
            throw new IllegalArgumentException();
        }
        int year = Integer.parseInt(dateString.substring(0, firstIndex));
        int month = Integer.parseInt(dateString.substring(firstIndex + 1,
                secondIndex));
        int day = Integer.parseInt(dateString.substring(secondIndex + 1,
                dateString.length()));
        return new Date(year - 1900, month - 1, day);
    }

    
        private static long normalizeTime(long theTime) {
        return theTime;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.749 -0400", hash_original_field = "1DE6E5BE798C55A7A87EB866ED5EB759", hash_generated_field = "A044521EFF7E57BA23BD57C1C9F6B06D")

    private static long serialVersionUID = 1511598038487230103L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.749 -0400", hash_original_field = "4568D9C1340D3E33291AAD404D511851", hash_generated_field = "5F24266443226E749AF032158C60EFCF")

    private static String PADDING = "0000";
}

