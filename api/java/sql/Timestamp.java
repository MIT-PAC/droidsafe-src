package java.sql;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;






public class Timestamp extends Date {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.220 -0400", hash_original_field = "C86DC03A2B4847378E26EED64B8AE3ED", hash_generated_field = "02AA9EFEAC0A700829C2BFFE89AB3713")

    private int nanos;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.220 -0400", hash_original_method = "48500113F421714EC43BE387D502DA70", hash_generated_method = "BF2AB5EB539294F91593391AFD12BBBD")
    @SuppressWarnings("deprecation")
    @Deprecated
    public  Timestamp(int theYear, int theMonth, int theDate, int theHour,
            int theMinute, int theSecond, int theNano) throws IllegalArgumentException {
        super(theYear, theMonth, theDate, theHour, theMinute, theSecond);
        addTaint(theSecond);
        addTaint(theMinute);
        addTaint(theHour);
        addTaint(theDate);
        addTaint(theMonth);
        addTaint(theYear);
        if(theNano < 0 || theNano > 999999999)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1257589732 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_1257589732.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_1257589732;
        } //End block
        nanos = theNano;
        // ---------- Original Method ----------
        //if (theNano < 0 || theNano > 999999999) {
            //throw new IllegalArgumentException();
        //}
        //nanos = theNano;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.221 -0400", hash_original_method = "86C700BF2C693DDDD6950F4A0D10E64A", hash_generated_method = "84330280926F7AD4D6E75A5D229E7A6E")
    public  Timestamp(long theTime) {
        super(theTime);
        addTaint(theTime);
        setTimeImpl(theTime);
        // ---------- Original Method ----------
        //setTimeImpl(theTime);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.232 -0400", hash_original_method = "BA6D499959EBEE9331B456EE3E086445", hash_generated_method = "88DD815B8269F71D8161AC11EBBA1712")
    public boolean after(Timestamp theTimestamp) {
        addTaint(theTimestamp.getTaint());
        long thisTime = this.getTime();
        long compareTime = theTimestamp.getTime();
        if(thisTime > compareTime)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1349736789 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2035764549 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2035764549;
        } //End block
        else
        if(thisTime < compareTime)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1087715655 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1233265626 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1233265626;
        } //End block
        else
        if(this.getNanos() > theTimestamp.getNanos())        
        {
            boolean varB326B5062B2F0E69046810717534CB09_437122110 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_896047986 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_896047986;
        } //End block
        else
        {
            boolean var68934A3E9455FA72420237EB05902327_21045314 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_311129204 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_311129204;
        } //End block
        // ---------- Original Method ----------
        //long thisTime = this.getTime();
        //long compareTime = theTimestamp.getTime();
        //if (thisTime > compareTime) {
            //return true;
        //}
        //else if (thisTime < compareTime) {
            //return false;
        //}
        //else if (this.getNanos() > theTimestamp.getNanos()) {
            //return true;
        //} else {
            //return false;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.264 -0400", hash_original_method = "C18CB1ECE736F4CE544A02EE2F0A015C", hash_generated_method = "367E9C64307C8E994B1AABB118D5DA35")
    public boolean before(Timestamp theTimestamp) {
        addTaint(theTimestamp.getTaint());
        long thisTime = this.getTime();
        long compareTime = theTimestamp.getTime();
        if(thisTime < compareTime)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1471369257 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_446615179 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_446615179;
        } //End block
        else
        if(thisTime > compareTime)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1072138883 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2027243944 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2027243944;
        } //End block
        else
        if(this.getNanos() < theTimestamp.getNanos())        
        {
            boolean varB326B5062B2F0E69046810717534CB09_116530819 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1240472949 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1240472949;
        } //End block
        else
        {
            boolean var68934A3E9455FA72420237EB05902327_144010251 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1835820642 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1835820642;
        } //End block
        // ---------- Original Method ----------
        //long thisTime = this.getTime();
        //long compareTime = theTimestamp.getTime();
        //if (thisTime < compareTime) {
            //return true;
        //}
        //else if (thisTime > compareTime) {
            //return false;
        //}
        //else if (this.getNanos() < theTimestamp.getNanos()) {
            //return true;
        //} else {
            //return false;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.264 -0400", hash_original_method = "05A91DEA116C3E2F5603F3F0D29353F9", hash_generated_method = "F1A2421495770EF3CF7EA772D467DA8B")
    @Override
    public int compareTo(Date theObject) throws ClassCastException {
        addTaint(theObject.getTaint());
        int varA7B650528C4FDA9DE26FC930D880E43B_584002675 = (this.compareTo((Timestamp) theObject));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1696922896 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1696922896;
        // ---------- Original Method ----------
        //return this.compareTo((Timestamp) theObject);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.264 -0400", hash_original_method = "5F716ED3C44AF0E8E5B469B5E8E10C8F", hash_generated_method = "5B16723A407B4535D42A246088D1959B")
    public int compareTo(Timestamp theTimestamp) {
        addTaint(theTimestamp.getTaint());
        int result = super.compareTo(theTimestamp);
        if(result == 0)        
        {
            int thisNano = this.getNanos();
            int thatNano = theTimestamp.getNanos();
            if(thisNano > thatNano)            
            {
                int varC4CA4238A0B923820DCC509A6F75849B_411280577 = (1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_532994053 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_532994053;
            } //End block
            else
            if(thisNano == thatNano)            
            {
                int varCFCD208495D565EF66E7DFF9F98764DA_28253963 = (0);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_421256388 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_421256388;
            } //End block
            else
            {
                int var6BB61E3B7BCE0931DA574D19D1D82C88_1829481328 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1482185349 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1482185349;
            } //End block
        } //End block
        int varB4A88417B3D0170D754C647C30B7216A_744276294 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1081720798 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1081720798;
        // ---------- Original Method ----------
        //int result = super.compareTo(theTimestamp);
        //if (result == 0) {
            //int thisNano = this.getNanos();
            //int thatNano = theTimestamp.getNanos();
            //if (thisNano > thatNano) {
                //return 1;
            //} else if (thisNano == thatNano) {
                //return 0;
            //} else {
                //return -1;
            //}
        //}
        //return result;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.265 -0400", hash_original_method = "94CEF17B9A7A2098B0DD6F205E7F606C", hash_generated_method = "31C6AB0C5A5E9B54A0950ADA6B39E3A5")
    @Override
    public boolean equals(Object theObject) {
        addTaint(theObject.getTaint());
        if(theObject instanceof Timestamp)        
        {
            boolean var7FF9EFB5886E232BC0F5ED29599DD02B_1480646864 = (equals((Timestamp) theObject));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_772077937 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_772077937;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1760757253 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_538811092 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_538811092;
        // ---------- Original Method ----------
        //if (theObject instanceof Timestamp) {
            //return equals((Timestamp) theObject);
        //}
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.265 -0400", hash_original_method = "42296DC9EADFEA8A232AFEC4CE089FE4", hash_generated_method = "58AE621BA3BDB06B5F2FBE2C7DF9129B")
    public boolean equals(Timestamp theTimestamp) {
        addTaint(theTimestamp.getTaint());
        if(theTimestamp == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_609969267 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2111163976 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2111163976;
        } //End block
        boolean var977037762EAFF8411442F8122B3582E8_1608292490 = ((this.getTime() == theTimestamp.getTime())
                && (this.getNanos() == theTimestamp.getNanos()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1192687933 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1192687933;
        // ---------- Original Method ----------
        //if (theTimestamp == null) {
            //return false;
        //}
        //return (this.getTime() == theTimestamp.getTime())
                //&& (this.getNanos() == theTimestamp.getNanos());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.265 -0400", hash_original_method = "B1AC9E2AEA3FCD014890A3BD86F2475F", hash_generated_method = "A564F5D35742332A835E9B91AB842599")
    public int getNanos() {
        int varC86DC03A2B4847378E26EED64B8AE3ED_1503098612 = (nanos);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1644915303 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1644915303;
        // ---------- Original Method ----------
        //return nanos;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.265 -0400", hash_original_method = "66C377BC30C9278F77FB30382314DC3B", hash_generated_method = "0A36C16872D2F7D911ED6C9EB14B57A9")
    @Override
    public long getTime() {
        long theTime = super.getTime();
        theTime = theTime + (nanos / 1000000);
        long varE26C8DED340AE9B01E278D81BE18E9A2_648544556 = (theTime);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1587564167 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1587564167;
        // ---------- Original Method ----------
        //long theTime = super.getTime();
        //theTime = theTime + (nanos / 1000000);
        //return theTime;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.265 -0400", hash_original_method = "37C2FDD9B2CBC513E6901A3C5AB99296", hash_generated_method = "C7B115E3FDC6D59D077C52C31DD920E3")
    public void setNanos(int n) throws IllegalArgumentException {
        if((n < 0) || (n > 999999999))        
        {
            IllegalArgumentException var7B0EF1CF5B4106FB746E6A999DFB2A76_564070913 = new IllegalArgumentException("Value out of range");
            var7B0EF1CF5B4106FB746E6A999DFB2A76_564070913.addTaint(taint);
            throw var7B0EF1CF5B4106FB746E6A999DFB2A76_564070913;
        } //End block
        nanos = n;
        // ---------- Original Method ----------
        //if ((n < 0) || (n > 999999999)) {
            //throw new IllegalArgumentException("Value out of range");
        //}
        //nanos = n;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.265 -0400", hash_original_method = "3EB39E1DE2409F6F629FCF4F69DCED8F", hash_generated_method = "87402F5134D21F7283A10FB9F5092411")
    @Override
    public void setTime(long theTime) {
        addTaint(theTime);
        setTimeImpl(theTime);
        // ---------- Original Method ----------
        //setTimeImpl(theTime);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.265 -0400", hash_original_method = "359A4BB179960D3D4DBBF4A52D3B05F3", hash_generated_method = "3F7BC2954FAF3FF9DEFB2575BEC40B8E")
    private void setTimeImpl(long theTime) {
        addTaint(theTime);
        int milliseconds = (int) (theTime % 1000);
        theTime = theTime - milliseconds;
        if(milliseconds < 0)        
        {
            theTime = theTime - 1000;
            milliseconds = 1000 + milliseconds;
        } //End block
        super.setTime(theTime);
        setNanos(milliseconds * 1000000);
        // ---------- Original Method ----------
        //int milliseconds = (int) (theTime % 1000);
        //theTime = theTime - milliseconds;
        //if (milliseconds < 0) {
            //theTime = theTime - 1000;
            //milliseconds = 1000 + milliseconds;
        //}
        //super.setTime(theTime);
        //setNanos(milliseconds * 1000000);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.266 -0400", hash_original_method = "2B0509572F21FC3F2C9AAE0AC4AFD2F5", hash_generated_method = "294C67EF0ADA1EB046B3D441E6E81E19")
    @SuppressWarnings("deprecation")
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(29);
        format((getYear() + 1900), 4, sb);
        sb.append('-');
        format((getMonth() + 1), 2, sb);
        sb.append('-');
        format(getDate(), 2, sb);
        sb.append(' ');
        format(getHours(), 2, sb);
        sb.append(':');
        format(getMinutes(), 2, sb);
        sb.append(':');
        format(getSeconds(), 2, sb);
        sb.append('.');
        if(nanos == 0)        
        {
            sb.append('0');
        } //End block
        else
        {
            format(nanos, 9, sb);
            while
(sb.charAt(sb.length() - 1) == '0')            
            {
                sb.setLength(sb.length() - 1);
            } //End block
        } //End block
String var2460B846747F8B22185AD8BE722266A5_1413189233 =         sb.toString();
        var2460B846747F8B22185AD8BE722266A5_1413189233.addTaint(taint);
        return var2460B846747F8B22185AD8BE722266A5_1413189233;
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder(29);
        //format((getYear() + 1900), 4, sb);
        //sb.append('-');
        //format((getMonth() + 1), 2, sb);
        //sb.append('-');
        //format(getDate(), 2, sb);
        //sb.append(' ');
        //format(getHours(), 2, sb);
        //sb.append(':');
        //format(getMinutes(), 2, sb);
        //sb.append(':');
        //format(getSeconds(), 2, sb);
        //sb.append('.');
        //if (nanos == 0) {
            //sb.append('0');
        //} else {
            //format(nanos, 9, sb);
            //while (sb.charAt(sb.length() - 1) == '0') {
                //sb.setLength(sb.length() - 1);
            //}
        //}
        //return sb.toString();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.266 -0400", hash_original_method = "D5825B232A74B71A26A12413148003F7", hash_generated_method = "3B6BC052A730CD4CC839ACA88FCF6674")
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

    
    public static Timestamp valueOf(String s) throws IllegalArgumentException {
        if (s == null) {
            throw new IllegalArgumentException("Argument cannot be null");
        }
        s = s.trim();
        if (!Pattern.matches(TIME_FORMAT_REGEX, s)) {
            throw badTimestampString(s);
        }
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ParsePosition pp = new ParsePosition(0);
        Date theDate;
        try {
            theDate = df.parse(s, pp);
        } catch (Exception e) {
            throw badTimestampString(s);
        }
        if (theDate == null) {
            throw badTimestampString(s);
        }
        int position = pp.getIndex();
        int remaining = s.length() - position;
        int theNanos;
        if (remaining == 0) {
            theNanos = 0;
        } else {
            if ((s.length() - position) < ".n".length()) {
                throw badTimestampString(s);
            }
            if ((s.length() - position) > ".nnnnnnnnn".length()) {
                throw badTimestampString(s);
            }
            if (s.charAt(position) != '.') {
                throw new NumberFormatException("Bad input string format: expected '.' not '" +
                        s.charAt(position) + "' in \"" + s + "\"");
            }
            int nanoLength = s.length() - position - 1;
            String theNanoString = s.substring(position + 1, position + 1
                    + nanoLength);
            theNanoString = theNanoString + "000000000";
            theNanoString = theNanoString.substring(0, 9);
            try {
                theNanos = Integer.parseInt(theNanoString);
            } catch (Exception e) {
                throw badTimestampString(s);
            }
        }
        if (theNanos < 0 || theNanos > 999999999) {
            throw badTimestampString(s);
        }
        Timestamp theTimestamp = new Timestamp(theDate.getTime());
        theTimestamp.setNanos(theNanos);
        return theTimestamp;
    }

    
    @DSModeled(DSC.BAN)
    private static IllegalArgumentException badTimestampString(String s) {
        throw new IllegalArgumentException("Timestamp format must be " +
                "yyyy-MM-dd HH:mm:ss.fffffffff; was '" + s + "'");
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.266 -0400", hash_original_field = "E73AFFAE12B7444132A15838F22C0E12", hash_generated_field = "5666E37C9E24829F13915667F1E900D0")

    private static final long serialVersionUID = 2745179027874758501L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.266 -0400", hash_original_field = "C8A95E01A46ECE8D65AC7ED966ECBDCA", hash_generated_field = "1DE35ED5D2701F5BA25ACDF3A3E82857")

    private static final String TIME_FORMAT_REGEX = "[0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}:[0-9]{2}.*";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.266 -0400", hash_original_field = "B880144999036D9B2CDE9F1014519FEA", hash_generated_field = "7CD6F5F30BFE0B9B9FCAF17A4B57A1F7")

    private static final String PADDING = "000000000";
}

