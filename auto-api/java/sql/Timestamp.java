package java.sql;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class Timestamp extends Date {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.223 -0400", hash_original_field = "C86DC03A2B4847378E26EED64B8AE3ED", hash_generated_field = "02AA9EFEAC0A700829C2BFFE89AB3713")

    private int nanos;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.224 -0400", hash_original_method = "48500113F421714EC43BE387D502DA70", hash_generated_method = "E35C3B0CDCABA93E2ECBE80B8FFF563F")
    @SuppressWarnings("deprecation")
    @Deprecated
    public  Timestamp(int theYear, int theMonth, int theDate, int theHour,
            int theMinute, int theSecond, int theNano) throws IllegalArgumentException {
        super(theYear, theMonth, theDate, theHour, theMinute, theSecond);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } 
        nanos = theNano;
        addTaint(theYear);
        addTaint(theMonth);
        addTaint(theDate);
        addTaint(theHour);
        addTaint(theMinute);
        addTaint(theSecond);
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.224 -0400", hash_original_method = "86C700BF2C693DDDD6950F4A0D10E64A", hash_generated_method = "87361398078E1F05ADED5D3267327458")
    public  Timestamp(long theTime) {
        super(theTime);
        setTimeImpl(theTime);
        addTaint(theTime);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.224 -0400", hash_original_method = "BA6D499959EBEE9331B456EE3E086445", hash_generated_method = "F7871D202F8FAF19DAE04B3EC6DD16CB")
    public boolean after(Timestamp theTimestamp) {
        long thisTime = this.getTime();
        long compareTime = theTimestamp.getTime();
        {
            boolean varC7E0A8ECDBDEB9C45D693D31244D4691_576826861 = (this.getNanos() > theTimestamp.getNanos());
        } 
        addTaint(theTimestamp.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_935562063 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_935562063;
        
        
        
        
            
        
        
            
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.224 -0400", hash_original_method = "C18CB1ECE736F4CE544A02EE2F0A015C", hash_generated_method = "CD1F45B312B58A761C972F45C8D1AB10")
    public boolean before(Timestamp theTimestamp) {
        long thisTime = this.getTime();
        long compareTime = theTimestamp.getTime();
        {
            boolean var13BB3933EDD6CEE11A0BFE57866CBDD3_845794539 = (this.getNanos() < theTimestamp.getNanos());
        } 
        addTaint(theTimestamp.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_87643169 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_87643169;
        
        
        
        
            
        
        
            
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.225 -0400", hash_original_method = "05A91DEA116C3E2F5603F3F0D29353F9", hash_generated_method = "F9AF491F3302F8D6AA5F4FA869592677")
    @Override
    public int compareTo(Date theObject) throws ClassCastException {
        int varF6A385886181BF005AD3647EAEA8BF5C_1199214318 = (this.compareTo((Timestamp) theObject));
        addTaint(theObject.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1981747469 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1981747469;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.225 -0400", hash_original_method = "5F716ED3C44AF0E8E5B469B5E8E10C8F", hash_generated_method = "2DE9D721CD32EE6695CADF21DEB291AF")
    public int compareTo(Timestamp theTimestamp) {
        int result = super.compareTo(theTimestamp);
        {
            int thisNano = this.getNanos();
            int thatNano = theTimestamp.getNanos();
        } 
        addTaint(theTimestamp.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_786643590 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_786643590;
        
        
        
            
            
            
                
            
                
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.226 -0400", hash_original_method = "94CEF17B9A7A2098B0DD6F205E7F606C", hash_generated_method = "CA52052EB03B176FA269AEF20BC62B7E")
    @Override
    public boolean equals(Object theObject) {
        {
            boolean var2989606C84A55E870B1DD414579ECC1B_190239355 = (equals((Timestamp) theObject));
        } 
        addTaint(theObject.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1084374221 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1084374221;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.227 -0400", hash_original_method = "42296DC9EADFEA8A232AFEC4CE089FE4", hash_generated_method = "886125F934A808D593F8D212B21A134A")
    public boolean equals(Timestamp theTimestamp) {
        boolean var494EA9017A2F54E6A1BF0612C970EC9D_942012623 = ((this.getTime() == theTimestamp.getTime())
                && (this.getNanos() == theTimestamp.getNanos()));
        addTaint(theTimestamp.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_370765087 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_370765087;
        
        
            
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.227 -0400", hash_original_method = "B1AC9E2AEA3FCD014890A3BD86F2475F", hash_generated_method = "FF0443CB8D001EC169366CCB36DF2982")
    public int getNanos() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_848482046 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_848482046;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.228 -0400", hash_original_method = "66C377BC30C9278F77FB30382314DC3B", hash_generated_method = "44737F7C0503813C4B5FEC0B8C2E89A7")
    @Override
    public long getTime() {
        long theTime = super.getTime();
        theTime = theTime + (nanos / 1000000);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_491122132 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_491122132;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.229 -0400", hash_original_method = "37C2FDD9B2CBC513E6901A3C5AB99296", hash_generated_method = "FFA8FFE97EE7B01A899534BEB0187901")
    public void setNanos(int n) throws IllegalArgumentException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Value out of range");
        } 
        nanos = n;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.229 -0400", hash_original_method = "3EB39E1DE2409F6F629FCF4F69DCED8F", hash_generated_method = "3EEA5E6E3336C2B435BC215F8A2E2DCF")
    @Override
    public void setTime(long theTime) {
        setTimeImpl(theTime);
        addTaint(theTime);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.229 -0400", hash_original_method = "359A4BB179960D3D4DBBF4A52D3B05F3", hash_generated_method = "C1A811D94040964B6CDDDD1176623B2A")
    private void setTimeImpl(long theTime) {
        int milliseconds = (int) (theTime % 1000);
        theTime = theTime - milliseconds;
        {
            theTime = theTime - 1000;
            milliseconds = 1000 + milliseconds;
        } 
        super.setTime(theTime);
        setNanos(milliseconds * 1000000);
        addTaint(theTime);
        
        
        
        
            
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.230 -0400", hash_original_method = "2B0509572F21FC3F2C9AAE0AC4AFD2F5", hash_generated_method = "8754FF918E9AE7A8650A39A9089E4E3C")
    @SuppressWarnings("deprecation")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1705912522 = null; 
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
        {
            sb.append('0');
        } 
        {
            format(nanos, 9, sb);
            {
                boolean varB67D37B2200DC38231B52C2FEB0EE484_310691581 = (sb.charAt(sb.length() - 1) == '0');
                {
                    sb.setLength(sb.length() - 1);
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1705912522 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1705912522.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1705912522;
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
            
        
            
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.231 -0400", hash_original_method = "D5825B232A74B71A26A12413148003F7", hash_generated_method = "AD501C76FF76BDBDBBA4C97BAF987BB5")
    private void format(int date, int digits, StringBuilder sb) {
        String str = String.valueOf(date);
        {
            boolean var727C074D045BD0678AEA087149253EBF_1454779893 = (digits - str.length() > 0);
            {
                sb.append(PADDING.substring(0, digits - str.length()));
            } 
        } 
        sb.append(str);
        addTaint(date);
        addTaint(digits);
        addTaint(sb.getTaint());
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    private static IllegalArgumentException badTimestampString(String s) {
        throw new IllegalArgumentException("Timestamp format must be " +
                "yyyy-MM-dd HH:mm:ss.fffffffff; was '" + s + "'");
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.231 -0400", hash_original_field = "E73AFFAE12B7444132A15838F22C0E12", hash_generated_field = "5666E37C9E24829F13915667F1E900D0")

    private static final long serialVersionUID = 2745179027874758501L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.231 -0400", hash_original_field = "C8A95E01A46ECE8D65AC7ED966ECBDCA", hash_generated_field = "1DE35ED5D2701F5BA25ACDF3A3E82857")

    private static final String TIME_FORMAT_REGEX = "[0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}:[0-9]{2}.*";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.231 -0400", hash_original_field = "B880144999036D9B2CDE9F1014519FEA", hash_generated_field = "7CD6F5F30BFE0B9B9FCAF17A4B57A1F7")

    private static final String PADDING = "000000000";
}

