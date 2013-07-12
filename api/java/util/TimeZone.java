package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.Serializable;
import libcore.icu.TimeZones;
import libcore.util.ZoneInfoDB;

public abstract class TimeZone implements Serializable, Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.245 -0400", hash_original_field = "B718ADEC73E04CE3EC720DD11A06A308", hash_generated_field = "771D545AF32E3EF0A7656F85E986567C")

    private String ID;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.246 -0400", hash_original_method = "9668D4D4A28DB894D48B4297168D73B9", hash_generated_method = "8E92B7E01B365C66B79257355E0DA018")
    public  TimeZone() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.246 -0400", hash_original_method = "0B6FE6D01B20019581445CB40F5DED3F", hash_generated_method = "ACD7AC76CAD67952C67257995D40D826")
    @Override
    public Object clone() {
        try 
        {
Object var46F3A0D86742C1D6E099C2B166941A33_1344232092 =             super.clone();
            var46F3A0D86742C1D6E099C2B166941A33_1344232092.addTaint(taint);
            return var46F3A0D86742C1D6E099C2B166941A33_1344232092;
        } //End block
        catch (CloneNotSupportedException e)
        {
            AssertionError varA5A331D65C8C3F32D42E49D64BCF4109_1033697551 = new AssertionError(e);
            varA5A331D65C8C3F32D42E49D64BCF4109_1033697551.addTaint(taint);
            throw varA5A331D65C8C3F32D42E49D64BCF4109_1033697551;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return super.clone();
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError(e);
        //}
    }

    
        public static synchronized String[] getAvailableIDs() {
        return ZoneInfoDB.getAvailableIDs();
    }

    
        public static synchronized String[] getAvailableIDs(int offsetMillis) {
        return ZoneInfoDB.getAvailableIDs(offsetMillis);
    }

    
        public static synchronized TimeZone getDefault() {
        if (defaultTimeZone == null) {
            defaultTimeZone = ZoneInfoDB.getSystemDefault();
        }
        return (TimeZone) defaultTimeZone.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.247 -0400", hash_original_method = "E1D5D6F100BA788FCF57724352534F76", hash_generated_method = "4851EEFBEB99C1088F8E05230107D393")
    public final String getDisplayName() {
String var5F1E216CDC734C0F06A2C8CAF0DFFBB4_1842850761 =         getDisplayName(false, LONG, Locale.getDefault());
        var5F1E216CDC734C0F06A2C8CAF0DFFBB4_1842850761.addTaint(taint);
        return var5F1E216CDC734C0F06A2C8CAF0DFFBB4_1842850761;
        // ---------- Original Method ----------
        //return getDisplayName(false, LONG, Locale.getDefault());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.247 -0400", hash_original_method = "813ED5DCC833F8E276BEA923F4174960", hash_generated_method = "F7F8A61C41EA755D9006124A9289F76B")
    public final String getDisplayName(Locale locale) {
        addTaint(locale.getTaint());
String var4374B9FA1903B21ADAA622AFADA909DC_295762666 =         getDisplayName(false, LONG, locale);
        var4374B9FA1903B21ADAA622AFADA909DC_295762666.addTaint(taint);
        return var4374B9FA1903B21ADAA622AFADA909DC_295762666;
        // ---------- Original Method ----------
        //return getDisplayName(false, LONG, locale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.248 -0400", hash_original_method = "084F77DA9DC739656E2D52FB38C28132", hash_generated_method = "DA966346D4FFAB8A9B25BD1B1CCC254F")
    public final String getDisplayName(boolean daylightTime, int style) {
        addTaint(style);
        addTaint(daylightTime);
String var6AAF92CBF5B6719712FC74B20FF20545_499354266 =         getDisplayName(daylightTime, style, Locale.getDefault());
        var6AAF92CBF5B6719712FC74B20FF20545_499354266.addTaint(taint);
        return var6AAF92CBF5B6719712FC74B20FF20545_499354266;
        // ---------- Original Method ----------
        //return getDisplayName(daylightTime, style, Locale.getDefault());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.249 -0400", hash_original_method = "4F4A34040AF2984EDE789FC8C17113CE", hash_generated_method = "D7046D3ACE49B5304AB2498982F8CB42")
    public String getDisplayName(boolean daylightTime, int style, Locale locale) {
        addTaint(locale.getTaint());
        addTaint(style);
        addTaint(daylightTime);
    if(style != SHORT && style != LONG)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1659523562 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_1659523562.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_1659523562;
        } //End block
        boolean useDaylight = daylightTime && useDaylightTime();
        String[][] zoneStrings = TimeZones.getZoneStrings(locale);
        String result = TimeZones.getDisplayName(zoneStrings, getID(), daylightTime, style);
    if(result != null)        
        {
String varDC838461EE2FA0CA4C9BBB70A15456B0_113415347 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_113415347.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_113415347;
        } //End block
        int offset = getRawOffset();
    if(useDaylight && this instanceof SimpleTimeZone)        
        {
            offset += getDSTSavings();
        } //End block
        offset /= 60000;
        char sign = '+';
    if(offset < 0)        
        {
            sign = '-';
            offset = -offset;
        } //End block
        StringBuilder builder = new StringBuilder(9);
        builder.append("GMT");
        builder.append(sign);
        appendNumber(builder, 2, offset / 60);
        builder.append(':');
        appendNumber(builder, 2, offset % 60);
String varF4CF030572656354ACFDF83FEE21D7A6_897053107 =         builder.toString();
        varF4CF030572656354ACFDF83FEE21D7A6_897053107.addTaint(taint);
        return varF4CF030572656354ACFDF83FEE21D7A6_897053107;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.249 -0400", hash_original_method = "7CED7894325BE9D599DFC54349DF84F9", hash_generated_method = "C746D457280AEDCD29D2AAAB9CB38C60")
    private void appendNumber(StringBuilder builder, int count, int value) {
        addTaint(value);
        addTaint(count);
        addTaint(builder.getTaint());
        String string = Integer.toString(value);
for(int i = 0;i < count - string.length();i++)
        {
            builder.append('0');
        } //End block
        builder.append(string);
        // ---------- Original Method ----------
        //String string = Integer.toString(value);
        //for (int i = 0; i < count - string.length(); i++) {
            //builder.append('0');
        //}
        //builder.append(string);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.250 -0400", hash_original_method = "6351E64C485F9179F5E10C6B44486847", hash_generated_method = "479FD41000DDF9806BA2E5207B02A0DB")
    public String getID() {
String varA5429A949488C23EB72A92C2F2C63667_868529678 =         ID;
        varA5429A949488C23EB72A92C2F2C63667_868529678.addTaint(taint);
        return varA5429A949488C23EB72A92C2F2C63667_868529678;
        // ---------- Original Method ----------
        //return ID;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.250 -0400", hash_original_method = "88FDDC2A48FC14F19CA7C51175C63814", hash_generated_method = "227236845EA4FDC64078D1E25666F7F9")
    public int getDSTSavings() {
        int varDE7EEA295B1303B84ECAC29561C90EAF_476423441 = (useDaylightTime() ? 3600000 : 0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1625909011 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1625909011;
        // ---------- Original Method ----------
        //return useDaylightTime() ? 3600000 : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.251 -0400", hash_original_method = "C756709CC23E72027C31097576D8FC0B", hash_generated_method = "CC3F7B72052536CA2D997A6FF677F09B")
    public int getOffset(long time) {
        addTaint(time);
    if(inDaylightTime(new Date(time)))        
        {
            int varDE27DA43E00201ED16F13BB186434B29_696913535 = (getRawOffset() + getDSTSavings());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1649730844 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1649730844;
        } //End block
        int varB9E0D5E948172A8866E27FE0BD9D4C92_89979242 = (getRawOffset());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_51515003 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_51515003;
        // ---------- Original Method ----------
        //if (inDaylightTime(new Date(time))) {
            //return getRawOffset() + getDSTSavings();
        //}
        //return getRawOffset();
    }

    
    public abstract int getOffset(int era, int year, int month, int day,
            int dayOfWeek, int timeOfDayMillis);

    
    public abstract int getRawOffset();

    
        public static synchronized TimeZone getTimeZone(String id) {
        TimeZone zone = ZoneInfoDB.getTimeZone(id);
        if (zone != null) {
            return zone;
        }
        if (zone == null && id.length() > 3 && id.startsWith("GMT")) {
            zone = getCustomTimeZone(id);
        }
        if (zone == null) {
            zone = (TimeZone) GMT.clone();
        }
        return zone;
    }

    
        private static TimeZone getCustomTimeZone(String id) {
        char sign = id.charAt(3);
        if (sign != '+' && sign != '-') {
            return null;
        }
        int[] position = new int[1];
        String formattedName = formatTimeZoneName(id, 4);
        int hour = parseNumber(formattedName, 4, position);
        if (hour < 0 || hour > 23) {
            return null;
        }
        int index = position[0];
        if (index == -1) {
            return null;
        }
        int raw = hour * 3600000;
        if (index < formattedName.length() && formattedName.charAt(index) == ':') {
            int minute = parseNumber(formattedName, index + 1, position);
            if (position[0] == -1 || minute < 0 || minute > 59) {
                return null;
            }
            raw += minute * 60000;
        } else if (hour >= 30 || index > 6) {
            raw = (hour / 100 * 3600000) + (hour % 100 * 60000);
        }
        if (sign == '-') {
            raw = -raw;
        }
        return new SimpleTimeZone(raw, formattedName);
    }

    
        private static String formatTimeZoneName(String name, int offset) {
        StringBuilder buf = new StringBuilder();
        int index = offset, length = name.length();
        buf.append(name.substring(0, offset));
        while (index < length) {
            if (Character.digit(name.charAt(index), 10) != -1) {
                buf.append(name.charAt(index));
                if ((length - (index + 1)) == 2) {
                    buf.append(':');
                }
            } else if (name.charAt(index) == ':') {
                buf.append(':');
            }
            index++;
        }
        if (buf.toString().indexOf(":") == -1) {
            buf.append(':');
            buf.append("00");
        }
        if (buf.toString().indexOf(":") == 5) {
            buf.insert(4, '0');
        }
        return buf.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.252 -0400", hash_original_method = "7F1959D5E252281790218EA5AF7B09B6", hash_generated_method = "4B81A601966BF7E3281A4BC5FC3233BC")
    public boolean hasSameRules(TimeZone timeZone) {
        addTaint(timeZone.getTaint());
    if(timeZone == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1068815580 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_299796290 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_299796290;
        } //End block
        boolean var06C4D27F918CD5167DEAE2AAEAA0A07D_1678376528 = (getRawOffset() == timeZone.getRawOffset());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2026933679 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2026933679;
        // ---------- Original Method ----------
        //if (timeZone == null) {
            //return false;
        //}
        //return getRawOffset() == timeZone.getRawOffset();
    }

    
    public abstract boolean inDaylightTime(Date time);

    
        private static int parseNumber(String string, int offset, int[] position) {
        int index = offset, length = string.length(), digit, result = 0;
        while (index < length
                && (digit = Character.digit(string.charAt(index), 10)) != -1) {
            index++;
            result = result * 10 + digit;
        }
        position[0] = index == offset ? -1 : index;
        return result;
    }

    
        public static synchronized void setDefault(TimeZone timeZone) {
        defaultTimeZone = timeZone != null ? (TimeZone) timeZone.clone() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.256 -0400", hash_original_method = "085ABCA184084E0387E0912A6F36E37B", hash_generated_method = "A8225D195ED84B752DDBB5D6745D35A0")
    public void setID(String id) {
    if(id == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_911448447 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_911448447.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_911448447;
        } //End block
        ID = id;
        // ---------- Original Method ----------
        //if (id == null) {
            //throw new NullPointerException();
        //}
        //ID = id;
    }

    
    public abstract void setRawOffset(int offsetMillis);

    
    public abstract boolean useDaylightTime();

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.256 -0400", hash_original_field = "A587EBC60576AE59123FD6EE4ACC1509", hash_generated_field = "264833884098E3465C064523C6821E70")

    private static final long serialVersionUID = 3581463369166924961L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.257 -0400", hash_original_field = "AB4915390C381EF5996BBC8C05836AF5", hash_generated_field = "F0EC76EF0A1325A66146C39A7A2DD364")

    public static final int SHORT = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.257 -0400", hash_original_field = "3BAE48DEAAE333CB107BC1132F4F4146", hash_generated_field = "F5FF9843F59090FE170F992D775343D2")

    public static final int LONG = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.257 -0400", hash_original_field = "C171914A8DC07BC9CEEB93EBFAE6BC81", hash_generated_field = "AD5768C44D2B4CA0FC370EAC906753D1")

    static final TimeZone GMT = new SimpleTimeZone(0, "GMT");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.257 -0400", hash_original_field = "D0491A75C542D67DF607F8F1BED6615E", hash_generated_field = "C615B22DCB0D6F7D43244D81DC929B8B")

    private static TimeZone defaultTimeZone;
}

