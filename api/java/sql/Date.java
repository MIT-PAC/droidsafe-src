package java.sql;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class Date extends java.util.Date {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.148 -0400", hash_original_method = "54033E67BCAF2131C1DBBD633092C516", hash_generated_method = "0F8920CDA87ACA0287FF1F11A1689C5D")
    @Deprecated
    public  Date(int theYear, int theMonth, int theDay) {
        super(theYear, theMonth, theDay);
        addTaint(theDay);
        addTaint(theMonth);
        addTaint(theYear);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.148 -0400", hash_original_method = "0597C0984A3A8E2CF9C870E073A794F7", hash_generated_method = "8669F986664A2B6B10801AEBAAF3C66B")
    public  Date(long theDate) {
        super(normalizeTime(theDate));
        addTaint(theDate);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.148 -0400", hash_original_method = "9D3BFA18991740345E9C4B50C3BC1C7B", hash_generated_method = "9C1DEE78C5CE68BFB3B06266E094DBC0")
    @Deprecated
    @Override
    public int getHours() {
        IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_266069305 = new IllegalArgumentException();
        var5783EF97022AA508B74A1E3EA38534AF_266069305.addTaint(taint);
        throw var5783EF97022AA508B74A1E3EA38534AF_266069305;
        // ---------- Original Method ----------
        //throw new IllegalArgumentException();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.148 -0400", hash_original_method = "20D35DA199D26861EF3B1850BF9B2C7B", hash_generated_method = "BC655FD66CB8E6D965F38B2F8557793D")
    @Deprecated
    @Override
    public int getMinutes() {
        IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1708961646 = new IllegalArgumentException();
        var5783EF97022AA508B74A1E3EA38534AF_1708961646.addTaint(taint);
        throw var5783EF97022AA508B74A1E3EA38534AF_1708961646;
        // ---------- Original Method ----------
        //throw new IllegalArgumentException();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.149 -0400", hash_original_method = "5B3A8174ABF60BC4DD674AADB526CA5F", hash_generated_method = "645BA620ED2C1C646E9909B14E9AD23B")
    @Deprecated
    @Override
    public int getSeconds() {
        IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_530064200 = new IllegalArgumentException();
        var5783EF97022AA508B74A1E3EA38534AF_530064200.addTaint(taint);
        throw var5783EF97022AA508B74A1E3EA38534AF_530064200;
        // ---------- Original Method ----------
        //throw new IllegalArgumentException();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.149 -0400", hash_original_method = "8AEDCDA359475E67EC180A6BBC9EA00B", hash_generated_method = "11C1386C97CBCFC47D0E7A80FE8B54DC")
    @Deprecated
    @Override
    public void setHours(int theHours) {
        addTaint(theHours);
        IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1465579441 = new IllegalArgumentException();
        var5783EF97022AA508B74A1E3EA38534AF_1465579441.addTaint(taint);
        throw var5783EF97022AA508B74A1E3EA38534AF_1465579441;
        // ---------- Original Method ----------
        //throw new IllegalArgumentException();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.149 -0400", hash_original_method = "C3170E6698742DBDFB0C085047CF3D73", hash_generated_method = "0BC8429DC7596A45D61C336499AB10BD")
    @Deprecated
    @Override
    public void setMinutes(int theMinutes) {
        addTaint(theMinutes);
        IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_29551304 = new IllegalArgumentException();
        var5783EF97022AA508B74A1E3EA38534AF_29551304.addTaint(taint);
        throw var5783EF97022AA508B74A1E3EA38534AF_29551304;
        // ---------- Original Method ----------
        //throw new IllegalArgumentException();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.150 -0400", hash_original_method = "90D475806A3C76BA7C308DE5A81BA772", hash_generated_method = "D2E9BE80B363D2FB91844E4BC25258CC")
    @Deprecated
    @Override
    public void setSeconds(int theSeconds) {
        addTaint(theSeconds);
        IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_225717654 = new IllegalArgumentException();
        var5783EF97022AA508B74A1E3EA38534AF_225717654.addTaint(taint);
        throw var5783EF97022AA508B74A1E3EA38534AF_225717654;
        // ---------- Original Method ----------
        //throw new IllegalArgumentException();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.150 -0400", hash_original_method = "58DD96CFC8DDA00016DEC24CC6519017", hash_generated_method = "F7EA085E57B4B6E067D6A4897E08BD3E")
    @Override
    public void setTime(long theTime) {
        addTaint(theTime);
        super.setTime(normalizeTime(theTime));
        // ---------- Original Method ----------
        //super.setTime(normalizeTime(theTime));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.150 -0400", hash_original_method = "F7971D7A9962AA78000A8292B336C43C", hash_generated_method = "938BC90942718992828F1686E3AA91F5")
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(10);
        format((getYear() + 1900), 4, sb);
        sb.append('-');
        format((getMonth() + 1), 2, sb);
        sb.append('-');
        format(getDate(), 2, sb);
String var2460B846747F8B22185AD8BE722266A5_473867838 =         sb.toString();
        var2460B846747F8B22185AD8BE722266A5_473867838.addTaint(taint);
        return var2460B846747F8B22185AD8BE722266A5_473867838;
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder(10);
        //format((getYear() + 1900), 4, sb);
        //sb.append('-');
        //format((getMonth() + 1), 2, sb);
        //sb.append('-');
        //format(getDate(), 2, sb);
        //return sb.toString();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.151 -0400", hash_original_method = "D5825B232A74B71A26A12413148003F7", hash_generated_method = "3B6BC052A730CD4CC839ACA88FCF6674")
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

    
    @DSModeled(DSC.SAFE)
    private static long normalizeTime(long theTime) {
        return theTime;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.152 -0400", hash_original_field = "1DE6E5BE798C55A7A87EB866ED5EB759", hash_generated_field = "AB50B4CB64B1076350F49E3C7CD4E9DD")

    private static final long serialVersionUID = 1511598038487230103L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.152 -0400", hash_original_field = "4568D9C1340D3E33291AAD404D511851", hash_generated_field = "E91DD4FD05D62E2720598D28C18C7C9E")

    private static final String PADDING = "0000";
}

