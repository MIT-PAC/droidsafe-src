package java.sql;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Date;

public class Time extends Date {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.216 -0400", hash_original_method = "90AD2E582B6AD132E43906287427EB15", hash_generated_method = "C6155BC6D5BCEB1219C7B3EBD90678D3")
    @SuppressWarnings("deprecation")
    @Deprecated
    public  Time(int theHour, int theMinute, int theSecond) {
        super(70, 0, 1, theHour, theMinute, theSecond);
        addTaint(theHour);
        addTaint(theMinute);
        addTaint(theSecond);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.217 -0400", hash_original_method = "B92128F71421A4A6F232F0ACA6BED466", hash_generated_method = "978E08BF8DDBC1030801843B432DADC7")
    public  Time(long theTime) {
        super(theTime);
        addTaint(theTime);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.217 -0400", hash_original_method = "B5DD06F1BCDFBA8A25753DB83CF1DFDC", hash_generated_method = "2C2AD89856936E1E4B723BF696D85C6E")
    @SuppressWarnings("deprecation")
    @Deprecated
    @Override
    public int getDate() {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1914010801 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1914010801;
        // ---------- Original Method ----------
        //throw new IllegalArgumentException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.217 -0400", hash_original_method = "665EBFB3A2ED57C64152ECE07C939E3F", hash_generated_method = "E5D01C8A74D7FA5713978550334F6041")
    @SuppressWarnings("deprecation")
    @Deprecated
    @Override
    public int getDay() {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_144818899 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_144818899;
        // ---------- Original Method ----------
        //throw new IllegalArgumentException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.218 -0400", hash_original_method = "69C5A301771AF98F1D4892C6CE16968D", hash_generated_method = "BAA33E7A6F6BE930611BD33253FA5564")
    @SuppressWarnings("deprecation")
    @Deprecated
    @Override
    public int getMonth() {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_618883607 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_618883607;
        // ---------- Original Method ----------
        //throw new IllegalArgumentException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.218 -0400", hash_original_method = "7CCE4B7904CC8188031B8C2C69560853", hash_generated_method = "2F85E6D889EB3E3F882E4BF1D1F15A1D")
    @SuppressWarnings("deprecation")
    @Deprecated
    @Override
    public int getYear() {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1983565070 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1983565070;
        // ---------- Original Method ----------
        //throw new IllegalArgumentException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.218 -0400", hash_original_method = "06E47849A7E1FF17AD4998EA261CC682", hash_generated_method = "4C613960F303BF64186607BC8511A4EA")
    @SuppressWarnings("deprecation")
    @Deprecated
    @Override
    public void setDate(int i) {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        addTaint(i);
        // ---------- Original Method ----------
        //throw new IllegalArgumentException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.219 -0400", hash_original_method = "C1F6FF91AA347F0EE969BFBA7872CFEF", hash_generated_method = "7AB1C05A7DAC288981B569F42B15CCD8")
    @SuppressWarnings("deprecation")
    @Deprecated
    @Override
    public void setMonth(int i) {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        addTaint(i);
        // ---------- Original Method ----------
        //throw new IllegalArgumentException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.219 -0400", hash_original_method = "C3860AE5740D96D0AEE02219E848BE80", hash_generated_method = "C78FC2D26232B6CF40C58802EAE75244")
    @SuppressWarnings("deprecation")
    @Deprecated
    @Override
    public void setYear(int i) {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        addTaint(i);
        // ---------- Original Method ----------
        //throw new IllegalArgumentException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.219 -0400", hash_original_method = "5C30660C9B840F0068D4ACA53BC409AF", hash_generated_method = "2C69EFB89739CAEB1FD1FA8FA67E5F13")
    @Override
    public void setTime(long time) {
        super.setTime(time);
        addTaint(time);
        // ---------- Original Method ----------
        //super.setTime(time);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.220 -0400", hash_original_method = "DF37E49816EA2C75935CB3795350B39F", hash_generated_method = "BBF47835124C935CD9BAF179AD9E3E94")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1441965839 = null; //Variable for return #1
        StringBuilder sb;
        sb = new StringBuilder(8);
        format(getHours(), 2, sb);
        sb.append(':');
        format(getMinutes(), 2, sb);
        sb.append(':');
        format(getSeconds(), 2, sb);
        varB4EAC82CA7396A68D541C85D26508E83_1441965839 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1441965839.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1441965839;
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder(8);
        //format(getHours(), 2, sb);
        //sb.append(':');
        //format(getMinutes(), 2, sb);
        //sb.append(':');
        //format(getSeconds(), 2, sb);
        //return sb.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.221 -0400", hash_original_method = "D5825B232A74B71A26A12413148003F7", hash_generated_method = "1BC02478D7253124267D305EE1DE4D6A")
    private void format(int date, int digits, StringBuilder sb) {
        String str;
        str = String.valueOf(date);
        {
            boolean var727C074D045BD0678AEA087149253EBF_727555513 = (digits - str.length() > 0);
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

    
        public static Time valueOf(String timeString) {
        if (timeString == null) {
            throw new IllegalArgumentException();
        }
        int firstIndex = timeString.indexOf(':');
        int secondIndex = timeString.indexOf(':', firstIndex + 1);
        if (secondIndex == -1 || firstIndex == 0
                || secondIndex + 1 == timeString.length()) {
            throw new IllegalArgumentException();
        }
        int hour = Integer.parseInt(timeString.substring(0, firstIndex));
        int minute = Integer.parseInt(timeString.substring(firstIndex + 1,
                secondIndex));
        int second = Integer.parseInt(timeString.substring(secondIndex + 1,
                timeString.length()));
        return new Time(hour, minute, second);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.221 -0400", hash_original_field = "1401318ECC8D1FCA234DD9C3B4F30F64", hash_generated_field = "5D0602D24951F79F81EF4F1B70EC6894")

    private static long serialVersionUID = 8397324403548013681L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.221 -0400", hash_original_field = "89C021B92219B7CE37A13E910A83FD32", hash_generated_field = "878ED479B907DA22B7158B1C05BB3712")

    private static String PADDING = "00";
}

