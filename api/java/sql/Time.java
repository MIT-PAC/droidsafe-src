package java.sql;

// Droidsafe Imports
import java.util.Date;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class Time extends Date {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.174 -0400", hash_original_method = "90AD2E582B6AD132E43906287427EB15", hash_generated_method = "689231C1F3CAD771BF3F0548AB3C32EA")
    @SuppressWarnings("deprecation")
    @Deprecated
    public  Time(int theHour, int theMinute, int theSecond) {
        super(70, 0, 1, theHour, theMinute, theSecond);
        addTaint(theSecond);
        addTaint(theMinute);
        addTaint(theHour);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.175 -0400", hash_original_method = "B92128F71421A4A6F232F0ACA6BED466", hash_generated_method = "978E08BF8DDBC1030801843B432DADC7")
    public  Time(long theTime) {
        super(theTime);
        addTaint(theTime);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.175 -0400", hash_original_method = "B5DD06F1BCDFBA8A25753DB83CF1DFDC", hash_generated_method = "D22287C16817D8D03FC1904D698AD1D3")
    @SuppressWarnings("deprecation")
    @Deprecated
    @Override
    public int getDate() {
        IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1803971038 = new IllegalArgumentException();
        var5783EF97022AA508B74A1E3EA38534AF_1803971038.addTaint(taint);
        throw var5783EF97022AA508B74A1E3EA38534AF_1803971038;
        // ---------- Original Method ----------
        //throw new IllegalArgumentException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.175 -0400", hash_original_method = "665EBFB3A2ED57C64152ECE07C939E3F", hash_generated_method = "708A391FF2E7E4E07B5D8AE6387C56D9")
    @SuppressWarnings("deprecation")
    @Deprecated
    @Override
    public int getDay() {
        IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1187459863 = new IllegalArgumentException();
        var5783EF97022AA508B74A1E3EA38534AF_1187459863.addTaint(taint);
        throw var5783EF97022AA508B74A1E3EA38534AF_1187459863;
        // ---------- Original Method ----------
        //throw new IllegalArgumentException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.176 -0400", hash_original_method = "69C5A301771AF98F1D4892C6CE16968D", hash_generated_method = "60976D42A45C3CCFA71664919BBC752A")
    @SuppressWarnings("deprecation")
    @Deprecated
    @Override
    public int getMonth() {
        IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_2080496044 = new IllegalArgumentException();
        var5783EF97022AA508B74A1E3EA38534AF_2080496044.addTaint(taint);
        throw var5783EF97022AA508B74A1E3EA38534AF_2080496044;
        // ---------- Original Method ----------
        //throw new IllegalArgumentException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.176 -0400", hash_original_method = "7CCE4B7904CC8188031B8C2C69560853", hash_generated_method = "4E68BCDD3C57F86F8C5D6D559187F639")
    @SuppressWarnings("deprecation")
    @Deprecated
    @Override
    public int getYear() {
        IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_818968951 = new IllegalArgumentException();
        var5783EF97022AA508B74A1E3EA38534AF_818968951.addTaint(taint);
        throw var5783EF97022AA508B74A1E3EA38534AF_818968951;
        // ---------- Original Method ----------
        //throw new IllegalArgumentException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.176 -0400", hash_original_method = "06E47849A7E1FF17AD4998EA261CC682", hash_generated_method = "856E796A3C297A833642E55F6C85F6AB")
    @SuppressWarnings("deprecation")
    @Deprecated
    @Override
    public void setDate(int i) {
        addTaint(i);
        IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_471485485 = new IllegalArgumentException();
        var5783EF97022AA508B74A1E3EA38534AF_471485485.addTaint(taint);
        throw var5783EF97022AA508B74A1E3EA38534AF_471485485;
        // ---------- Original Method ----------
        //throw new IllegalArgumentException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.177 -0400", hash_original_method = "C1F6FF91AA347F0EE969BFBA7872CFEF", hash_generated_method = "D4BEE4A64181524CE9F108A6EE7F06A5")
    @SuppressWarnings("deprecation")
    @Deprecated
    @Override
    public void setMonth(int i) {
        addTaint(i);
        IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1356712130 = new IllegalArgumentException();
        var5783EF97022AA508B74A1E3EA38534AF_1356712130.addTaint(taint);
        throw var5783EF97022AA508B74A1E3EA38534AF_1356712130;
        // ---------- Original Method ----------
        //throw new IllegalArgumentException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.177 -0400", hash_original_method = "C3860AE5740D96D0AEE02219E848BE80", hash_generated_method = "045C6167CE6697565825E94D4BB11765")
    @SuppressWarnings("deprecation")
    @Deprecated
    @Override
    public void setYear(int i) {
        addTaint(i);
        IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1872689112 = new IllegalArgumentException();
        var5783EF97022AA508B74A1E3EA38534AF_1872689112.addTaint(taint);
        throw var5783EF97022AA508B74A1E3EA38534AF_1872689112;
        // ---------- Original Method ----------
        //throw new IllegalArgumentException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.177 -0400", hash_original_method = "5C30660C9B840F0068D4ACA53BC409AF", hash_generated_method = "0290DDF634ED42C3C1C7C3841CDD37EB")
    @Override
    public void setTime(long time) {
        addTaint(time);
        super.setTime(time);
        // ---------- Original Method ----------
        //super.setTime(time);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.178 -0400", hash_original_method = "DF37E49816EA2C75935CB3795350B39F", hash_generated_method = "DF240C0D7D322ECDCF8D95C9BD86F2E4")
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(8);
        format(getHours(), 2, sb);
        sb.append(':');
        format(getMinutes(), 2, sb);
        sb.append(':');
        format(getSeconds(), 2, sb);
String var2460B846747F8B22185AD8BE722266A5_50684734 =         sb.toString();
        var2460B846747F8B22185AD8BE722266A5_50684734.addTaint(taint);
        return var2460B846747F8B22185AD8BE722266A5_50684734;
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder(8);
        //format(getHours(), 2, sb);
        //sb.append(':');
        //format(getMinutes(), 2, sb);
        //sb.append(':');
        //format(getSeconds(), 2, sb);
        //return sb.toString();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.178 -0400", hash_original_method = "D5825B232A74B71A26A12413148003F7", hash_generated_method = "3B6BC052A730CD4CC839ACA88FCF6674")
    private void format(int date, int digits, StringBuilder sb) {
        addTaint(sb.getTaint());
        addTaint(digits);
        addTaint(date);
        String str = String.valueOf(date);
        if(digits - str.length() > 0)        
        {
            sb.append(PADDING.substring(0, digits - str.length()));
        } //End block
        sb.append(str);
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.179 -0400", hash_original_field = "1401318ECC8D1FCA234DD9C3B4F30F64", hash_generated_field = "4135C293268358DD66284F75791C870B")

    private static final long serialVersionUID = 8397324403548013681L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.179 -0400", hash_original_field = "89C021B92219B7CE37A13E910A83FD32", hash_generated_field = "87ECBDD5C24F81CDDFA22805D091687F")

    private static final String PADDING = "00";
}

