package java.sql;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class Timestamp extends Date {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.275 -0400", hash_original_field = "C86DC03A2B4847378E26EED64B8AE3ED", hash_generated_field = "02AA9EFEAC0A700829C2BFFE89AB3713")

    private int nanos;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.275 -0400", hash_original_method = "48500113F421714EC43BE387D502DA70", hash_generated_method = "E35C3B0CDCABA93E2ECBE80B8FFF563F")
    @SuppressWarnings("deprecation")
    @Deprecated
    public  Timestamp(int theYear, int theMonth, int theDate, int theHour,
            int theMinute, int theSecond, int theNano) throws IllegalArgumentException {
        super(theYear, theMonth, theDate, theHour, theMinute, theSecond);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        nanos = theNano;
        addTaint(theYear);
        addTaint(theMonth);
        addTaint(theDate);
        addTaint(theHour);
        addTaint(theMinute);
        addTaint(theSecond);
        // ---------- Original Method ----------
        //if (theNano < 0 || theNano > 999999999) {
            //throw new IllegalArgumentException();
        //}
        //nanos = theNano;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.302 -0400", hash_original_method = "86C700BF2C693DDDD6950F4A0D10E64A", hash_generated_method = "87361398078E1F05ADED5D3267327458")
    public  Timestamp(long theTime) {
        super(theTime);
        setTimeImpl(theTime);
        addTaint(theTime);
        // ---------- Original Method ----------
        //setTimeImpl(theTime);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.304 -0400", hash_original_method = "BA6D499959EBEE9331B456EE3E086445", hash_generated_method = "7B3A3250F3CA437B3B3B8727EEE61E3E")
    public boolean after(Timestamp theTimestamp) {
        long thisTime;
        thisTime = this.getTime();
        long compareTime;
        compareTime = theTimestamp.getTime();
        {
            boolean varC7E0A8ECDBDEB9C45D693D31244D4691_1104146113 = (this.getNanos() > theTimestamp.getNanos());
        } //End collapsed parenthetic
        addTaint(theTimestamp.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_760915664 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_760915664;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.304 -0400", hash_original_method = "C18CB1ECE736F4CE544A02EE2F0A015C", hash_generated_method = "95FB350FEA1B2FEA2D496ABA56750C35")
    public boolean before(Timestamp theTimestamp) {
        long thisTime;
        thisTime = this.getTime();
        long compareTime;
        compareTime = theTimestamp.getTime();
        {
            boolean var13BB3933EDD6CEE11A0BFE57866CBDD3_1293384321 = (this.getNanos() < theTimestamp.getNanos());
        } //End collapsed parenthetic
        addTaint(theTimestamp.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2068505330 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2068505330;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.304 -0400", hash_original_method = "05A91DEA116C3E2F5603F3F0D29353F9", hash_generated_method = "F2C6DFC4DA2F62840151AC007AE553E0")
    @Override
    public int compareTo(Date theObject) throws ClassCastException {
        int varF6A385886181BF005AD3647EAEA8BF5C_1000110493 = (this.compareTo((Timestamp) theObject));
        addTaint(theObject.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1349874676 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1349874676;
        // ---------- Original Method ----------
        //return this.compareTo((Timestamp) theObject);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.307 -0400", hash_original_method = "5F716ED3C44AF0E8E5B469B5E8E10C8F", hash_generated_method = "F7EE868FE36AF70D3E44CA73BEAA02B1")
    public int compareTo(Timestamp theTimestamp) {
        int result;
        result = super.compareTo(theTimestamp);
        {
            int thisNano;
            thisNano = this.getNanos();
            int thatNano;
            thatNano = theTimestamp.getNanos();
        } //End block
        addTaint(theTimestamp.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_73898771 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_73898771;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.308 -0400", hash_original_method = "94CEF17B9A7A2098B0DD6F205E7F606C", hash_generated_method = "34B22C73334632C25EBFE9594D5319B9")
    @Override
    public boolean equals(Object theObject) {
        {
            boolean var2989606C84A55E870B1DD414579ECC1B_377892893 = (equals((Timestamp) theObject));
        } //End block
        addTaint(theObject.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1452688979 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1452688979;
        // ---------- Original Method ----------
        //if (theObject instanceof Timestamp) {
            //return equals((Timestamp) theObject);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.308 -0400", hash_original_method = "42296DC9EADFEA8A232AFEC4CE089FE4", hash_generated_method = "8F580FF2A300BE91060BB84248C43125")
    public boolean equals(Timestamp theTimestamp) {
        boolean var494EA9017A2F54E6A1BF0612C970EC9D_229106762 = ((this.getTime() == theTimestamp.getTime())
                && (this.getNanos() == theTimestamp.getNanos()));
        addTaint(theTimestamp.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1765225699 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1765225699;
        // ---------- Original Method ----------
        //if (theTimestamp == null) {
            //return false;
        //}
        //return (this.getTime() == theTimestamp.getTime())
                //&& (this.getNanos() == theTimestamp.getNanos());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.308 -0400", hash_original_method = "B1AC9E2AEA3FCD014890A3BD86F2475F", hash_generated_method = "8CC96CD9A2EF8150FF0314F5241E8D79")
    public int getNanos() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1831343659 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1831343659;
        // ---------- Original Method ----------
        //return nanos;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.309 -0400", hash_original_method = "66C377BC30C9278F77FB30382314DC3B", hash_generated_method = "67FC3313C700F5C92154E889BD912B1C")
    @Override
    public long getTime() {
        long theTime;
        theTime = super.getTime();
        theTime = theTime + (nanos / 1000000);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1640344508 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1640344508;
        // ---------- Original Method ----------
        //long theTime = super.getTime();
        //theTime = theTime + (nanos / 1000000);
        //return theTime;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.309 -0400", hash_original_method = "37C2FDD9B2CBC513E6901A3C5AB99296", hash_generated_method = "FFA8FFE97EE7B01A899534BEB0187901")
    public void setNanos(int n) throws IllegalArgumentException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Value out of range");
        } //End block
        nanos = n;
        // ---------- Original Method ----------
        //if ((n < 0) || (n > 999999999)) {
            //throw new IllegalArgumentException("Value out of range");
        //}
        //nanos = n;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.309 -0400", hash_original_method = "3EB39E1DE2409F6F629FCF4F69DCED8F", hash_generated_method = "3EEA5E6E3336C2B435BC215F8A2E2DCF")
    @Override
    public void setTime(long theTime) {
        setTimeImpl(theTime);
        addTaint(theTime);
        // ---------- Original Method ----------
        //setTimeImpl(theTime);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.310 -0400", hash_original_method = "359A4BB179960D3D4DBBF4A52D3B05F3", hash_generated_method = "1FDC1A5305BAFC2BB2CBFF501460559C")
    private void setTimeImpl(long theTime) {
        int milliseconds;
        milliseconds = (int) (theTime % 1000);
        theTime = theTime - milliseconds;
        {
            theTime = theTime - 1000;
            milliseconds = 1000 + milliseconds;
        } //End block
        super.setTime(theTime);
        setNanos(milliseconds * 1000000);
        addTaint(theTime);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.315 -0400", hash_original_method = "2B0509572F21FC3F2C9AAE0AC4AFD2F5", hash_generated_method = "E874E4B1611504326A26CCCB88C4DBAF")
    @SuppressWarnings("deprecation")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_868998676 = null; //Variable for return #1
        StringBuilder sb;
        sb = new StringBuilder(29);
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
        } //End block
        {
            format(nanos, 9, sb);
            {
                boolean varB67D37B2200DC38231B52C2FEB0EE484_648438861 = (sb.charAt(sb.length() - 1) == '0');
                {
                    sb.setLength(sb.length() - 1);
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_868998676 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_868998676.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_868998676;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.315 -0400", hash_original_method = "D5825B232A74B71A26A12413148003F7", hash_generated_method = "8530261BF22F1BCD514A4CCDD9B707CE")
    private void format(int date, int digits, StringBuilder sb) {
        String str;
        str = String.valueOf(date);
        {
            boolean var727C074D045BD0678AEA087149253EBF_1663428709 = (digits - str.length() > 0);
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

    
        private static IllegalArgumentException badTimestampString(String s) {
        throw new IllegalArgumentException("Timestamp format must be " +
                "yyyy-MM-dd HH:mm:ss.fffffffff; was '" + s + "'");
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.324 -0400", hash_original_field = "E73AFFAE12B7444132A15838F22C0E12", hash_generated_field = "F764924DA68AE2F9DB3C4E27072F530B")

    private static long serialVersionUID = 2745179027874758501L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.324 -0400", hash_original_field = "C8A95E01A46ECE8D65AC7ED966ECBDCA", hash_generated_field = "2FC44AF80F3E331AD983EA4CFCC3B53A")

    private static String TIME_FORMAT_REGEX = "[0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}:[0-9]{2}.*";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.324 -0400", hash_original_field = "B880144999036D9B2CDE9F1014519FEA", hash_generated_field = "25CD3716563CC11E458D14E157CC5BFB")

    private static String PADDING = "000000000";
}

