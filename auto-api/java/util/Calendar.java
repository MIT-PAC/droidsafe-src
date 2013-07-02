package java.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.text.DateFormatSymbols;
import libcore.icu.ICU;
import libcore.icu.LocaleData;

public abstract class Calendar implements Serializable, Cloneable, Comparable<Calendar> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.119 -0400", hash_original_field = "968371C4AF5AE99403612957ADE12B5F", hash_generated_field = "CE3F9942C85635B6DB1739E7DBF40F0C")

    protected boolean areFieldsSet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.119 -0400", hash_original_field = "D05B6ED7D2345020440DF396D6DA7F73", hash_generated_field = "E574E68E645EC43F733A1248603B982F")

    protected int[] fields;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.119 -0400", hash_original_field = "7E8AD70F1D9ED8B28FD71C6C1BA4D2B8", hash_generated_field = "213F640A8226820C3FAD694FABC68220")

    protected boolean[] isSet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.119 -0400", hash_original_field = "FCD946B6F697945EC5FCC211FF5C639E", hash_generated_field = "973A26005EDCFC142AE184E74D7A9C44")

    protected boolean isTimeSet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.119 -0400", hash_original_field = "07CC694B9B3FC636710FA08B6922C42B", hash_generated_field = "DF6F7F34B65DA140AA02B5623A896C3D")

    protected long time;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.119 -0400", hash_original_field = "8307D2015BE199A91F71907A46B15858", hash_generated_field = "8B06B22BB0D98B206D493E4536EE7432")

    transient int lastTimeFieldSet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.119 -0400", hash_original_field = "BB814C47C41CB6FE07B13DB029003F44", hash_generated_field = "FB479690428AB835107C0237892E7931")

    transient int lastDateFieldSet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.119 -0400", hash_original_field = "526E2996690A16FF145147ABB1927920", hash_generated_field = "EAF178494884F790222D5DEEC0D047C3")

    private boolean lenient;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.119 -0400", hash_original_field = "3CD3E760E15423653736E26E4D21E54A", hash_generated_field = "AB58B3610E0723B715410016290F0168")

    private int firstDayOfWeek;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.119 -0400", hash_original_field = "84FAA04375A171B334639F6BBA18E901", hash_generated_field = "B89C77A3F2A82BA7436489590490B056")

    private int minimalDaysInFirstWeek;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.119 -0400", hash_original_field = "A84E5F25E7F6D5DE9B82CE3F64D1B8FA", hash_generated_field = "05D717DFC6EF8897D7D254757AEA2790")

    private TimeZone zone;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.120 -0400", hash_original_method = "E09C10A5808D539238E77D59E7FF85D8", hash_generated_method = "374B305B1106BD03A7A9AA8CD5945D9E")
    protected  Calendar() {
        this(TimeZone.getDefault(), Locale.getDefault());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.120 -0400", hash_original_method = "88FEBE5E333C1748D0E9CCFA28BF3B86", hash_generated_method = "B23568CE169B9027DD3E3EEB62FF5C54")
      Calendar(TimeZone timezone) {
        fields = new int[FIELD_COUNT];
        isSet = new boolean[FIELD_COUNT];
        areFieldsSet = isTimeSet = false;
        setLenient(true);
        setTimeZone(timezone);
        addTaint(timezone.getTaint());
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.120 -0400", hash_original_method = "DC052852760F164E5EB6C2F703BBC41B", hash_generated_method = "855FF095591003EE1F29DF1535B724B1")
    protected  Calendar(TimeZone timezone, Locale locale) {
        this(timezone);
        LocaleData localeData = LocaleData.get(locale);
        setFirstDayOfWeek(localeData.firstDayOfWeek.intValue());
        setMinimalDaysInFirstWeek(localeData.minimalDaysInFirstWeek.intValue());
        addTaint(timezone.getTaint());
        addTaint(locale.getTaint());
        
        
        
        
    }

    
    public abstract void add(int field, int value);

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.121 -0400", hash_original_method = "3DBAFBF02CB3C60196FBCDD8387C90F7", hash_generated_method = "CFDACB146CE224ED7B9C4A4385EE8FBF")
    public boolean after(Object calendar) {
        boolean varC69694D50B41BAE5BC1E995D54AE5EB2_933733469 = (getTimeInMillis() > ((Calendar) calendar).getTimeInMillis());
        addTaint(calendar.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_874607522 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_874607522;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.121 -0400", hash_original_method = "AB514F7047FACF0A18BC971364ADD066", hash_generated_method = "F812C5AE9EC2E6C065D0211323B92066")
    public boolean before(Object calendar) {
        boolean var83CAF9DE4789CE7E9E62F32BABBA53AA_110416248 = (getTimeInMillis() < ((Calendar) calendar).getTimeInMillis());
        addTaint(calendar.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_811440759 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_811440759;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.122 -0400", hash_original_method = "A9FFD41082BBDB8FD2EC401621467C0D", hash_generated_method = "66D83B33107F2F620B57A8F5702A86F2")
    public final void clear() {
        {
            int i = 0;
            {
                fields[i] = 0;
                isSet[i] = false;
            } 
        } 
        areFieldsSet = isTimeSet = false;
        
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.122 -0400", hash_original_method = "045ED04F1C7B7EFD467C2025674AC1C4", hash_generated_method = "5601ADC664CA4C20A4642CF90A9811CA")
    public final void clear(int field) {
        fields[field] = 0;
        isSet[field] = false;
        areFieldsSet = isTimeSet = false;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.123 -0400", hash_original_method = "84D98F75151E4961D0916EA8CB3E0C38", hash_generated_method = "AD4C538FF87A355FCBBDE96140118A71")
    @Override
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_505575554 = null; 
        try 
        {
            Calendar clone = (Calendar) super.clone();
            clone.fields = fields.clone();
            clone.isSet = isSet.clone();
            clone.zone = (TimeZone) zone.clone();
            varB4EAC82CA7396A68D541C85D26508E83_505575554 = clone;
        } 
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_505575554.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_505575554;
        
        
            
            
            
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.124 -0400", hash_original_method = "A716BA757DE54F1250A3DB16F903EEB4", hash_generated_method = "38F398104393574509E877BC41F9722F")
    protected void complete() {
        {
            computeTime();
            isTimeSet = true;
        } 
        {
            computeFields();
            areFieldsSet = true;
        } 
        
        
            
            
        
        
            
            
        
    }

    
    protected abstract void computeFields();

    
    protected abstract void computeTime();

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.125 -0400", hash_original_method = "A4F7F4EE453A4994C5225BE31C26C1E8", hash_generated_method = "433788ABF1F10BF6308D83B731502ECF")
    @Override
    public boolean equals(Object object) {
        Calendar cal = (Calendar) object;
        boolean var3802D6DA9375599C027CD4D213836CB6_1218609737 = (getTimeInMillis() == cal.getTimeInMillis()
                && isLenient() == cal.isLenient()
                && getFirstDayOfWeek() == cal.getFirstDayOfWeek()
                && getMinimalDaysInFirstWeek() == cal
                        .getMinimalDaysInFirstWeek()
                && getTimeZone().equals(cal.getTimeZone()));
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1105066825 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1105066825;
        
        
            
        
        
            
        
        
        
                
                
                
                        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.125 -0400", hash_original_method = "E826346499B559368BF751B42F34C786", hash_generated_method = "34CCF79C456C9CF0D631404EC9335F33")
    public int get(int field) {
        complete();
        addTaint(field);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2027700458 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2027700458;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.126 -0400", hash_original_method = "424E8E96F9A12B00FD5C6FDA146C325F", hash_generated_method = "2C5305F5C319EDE90C20FF75F8C5A395")
    public int getActualMaximum(int field) {
        int value;
        int next;
        {
            boolean var745F343A82DFDCC7FF827AFB1EBA87A3_427894792 = (getMaximum(field) == (next = getLeastMaximum(field)));
        } 
        complete();
        long orgTime = time;
        set(field, next);
        {
            value = next;
            roll(field, true);
            next = get(field);
        } 
        time = orgTime;
        areFieldsSet = false;
        addTaint(field);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1834921475 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1834921475;
        
        
        
            
        
        
        
        
        
            
            
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.126 -0400", hash_original_method = "598A84D60F29BB97F62226BCCD8A7F9E", hash_generated_method = "9EB6579DCFD53F053F67618132B4384A")
    public int getActualMinimum(int field) {
        int value;
        int next;
        {
            boolean var0005FEA1504A60840E142CEC4FE92CFB_359325525 = (getMinimum(field) == (next = getGreatestMinimum(field)));
        } 
        complete();
        long orgTime = time;
        set(field, next);
        {
            value = next;
            roll(field, false);
            next = get(field);
        } 
        time = orgTime;
        areFieldsSet = false;
        addTaint(field);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_188420463 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_188420463;
        
        
        
            
        
        
        
        
        
            
            
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static synchronized Locale[] getAvailableLocales() {
        return ICU.getAvailableCalendarLocales();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.127 -0400", hash_original_method = "2210DC8BCE617C61AD2F9503CE7923B1", hash_generated_method = "D80489CC70F728C1856F0499BAE69ECB")
    public int getFirstDayOfWeek() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_269256693 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_269256693;
        
        
    }

    
    public abstract int getGreatestMinimum(int field);

    
    @DSModeled(DSC.SAFE)
    public static synchronized Calendar getInstance() {
        return new GregorianCalendar();
    }

    
    @DSModeled(DSC.SAFE)
    public static synchronized Calendar getInstance(Locale locale) {
        return new GregorianCalendar(locale);
    }

    
    @DSModeled(DSC.SAFE)
    public static synchronized Calendar getInstance(TimeZone timezone) {
        return new GregorianCalendar(timezone);
    }

    
    @DSModeled(DSC.SAFE)
    public static synchronized Calendar getInstance(TimeZone timezone, Locale locale) {
        return new GregorianCalendar(timezone, locale);
    }

    
    public abstract int getLeastMaximum(int field);

    
    public abstract int getMaximum(int field);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.128 -0400", hash_original_method = "104647FF062CF5167F06DB549E6DD4EB", hash_generated_method = "211532FAE8AB75DB6C26CDA2CFB7827F")
    public int getMinimalDaysInFirstWeek() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_261378220 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_261378220;
        
        
    }

    
    public abstract int getMinimum(int field);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.128 -0400", hash_original_method = "0D972793C1A81D3B5C0D23389B920FB5", hash_generated_method = "1093E0F157A3B2E7B084E41B6403E6EC")
    public final Date getTime() {
        Date varB4EAC82CA7396A68D541C85D26508E83_231358171 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_231358171 = new Date(getTimeInMillis());
        varB4EAC82CA7396A68D541C85D26508E83_231358171.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_231358171;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.129 -0400", hash_original_method = "1B58DB6425011C7C1965B5C43056D530", hash_generated_method = "33859DC508FA608DC47D7F9783A90445")
    public long getTimeInMillis() {
        {
            computeTime();
            isTimeSet = true;
        } 
        long var0F5264038205EDFB1AC05FBB0E8C5E94_544405558 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_544405558;
        
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.129 -0400", hash_original_method = "A62BA7A8B3AE52F44B15929DB0809596", hash_generated_method = "4C194E76E5B6C49DE43CDA20DF22DCE7")
    public TimeZone getTimeZone() {
        TimeZone varB4EAC82CA7396A68D541C85D26508E83_1727161588 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1727161588 = zone;
        varB4EAC82CA7396A68D541C85D26508E83_1727161588.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1727161588;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.129 -0400", hash_original_method = "2D54AA953826341AD4FD2AC42B53AEBA", hash_generated_method = "5D05B5CC77DB85190394E534E22B5583")
    @Override
    public int hashCode() {
        int varBC7F165EFAFE0FDF940429CA89DC1BF8_1865951994 = ((isLenient() ? 1237 : 1231) + getFirstDayOfWeek()
                + getMinimalDaysInFirstWeek() + getTimeZone().hashCode()); 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1778306390 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1778306390;
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.130 -0400", hash_original_method = "B2249A52847A00BE88915EAA81CF8D45", hash_generated_method = "574FA8BFAC68FD01788D0D0356B52853")
    protected final int internalGet(int field) {
        addTaint(field);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_878887137 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_878887137;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.130 -0400", hash_original_method = "5DB017D3EE054B32EA01614D92601D4D", hash_generated_method = "92DA01D386000C38A351810B05B6442F")
    public boolean isLenient() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1406174127 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1406174127;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.130 -0400", hash_original_method = "295995F35CFAB02328483B566F7330CE", hash_generated_method = "2064FDE4BEED73A354F07634607BADCC")
    public final boolean isSet(int field) {
        addTaint(field);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2008262299 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2008262299;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.130 -0400", hash_original_method = "F5FA416393576D1F9DD8BCE9349020A6", hash_generated_method = "A70792C1D8B5D0EE9AEA09B3F40C3E62")
    public void roll(int field, int value) {
        boolean increment = value >= 0;
        int count;
        count = value;
        count = -value;
        {
            int i = 0;
            {
                roll(field, increment);
            } 
        } 
        addTaint(field);
        addTaint(value);
        
        
        
        
            
        
    }

    
    public abstract void roll(int field, boolean increment);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.131 -0400", hash_original_method = "41A9E001F522D5852F11FBD319F3A5A6", hash_generated_method = "5AD459A02884BD1AB55AFA548E0373B8")
    public void set(int field, int value) {
        fields[field] = value;
        isSet[field] = true;
        areFieldsSet = isTimeSet = false;
        {
            lastDateFieldSet = field;
        } 
        {
            lastTimeFieldSet = field;
        } 
        {
            lastTimeFieldSet = HOUR;
        } 
        
        
        
        
        
            
        
        
            
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.131 -0400", hash_original_method = "E11C90BCB39036715964798223610892", hash_generated_method = "DBE654682FD8EF8BCAA30D59F502C152")
    public final void set(int year, int month, int day) {
        set(YEAR, year);
        set(MONTH, month);
        set(DATE, day);
        addTaint(year);
        addTaint(month);
        addTaint(day);
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.132 -0400", hash_original_method = "B4EBEBE6ED320058BB13C1E33AF949E4", hash_generated_method = "0126A56BAC87D4D5C42407119E5CE1AC")
    public final void set(int year, int month, int day, int hourOfDay,
            int minute) {
        set(year, month, day);
        set(HOUR_OF_DAY, hourOfDay);
        set(MINUTE, minute);
        addTaint(year);
        addTaint(month);
        addTaint(day);
        addTaint(hourOfDay);
        addTaint(minute);
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.132 -0400", hash_original_method = "071B019FF423902B33C61C7D7703D8F0", hash_generated_method = "218149969F4A3DAF953BEE3F407E9714")
    public final void set(int year, int month, int day, int hourOfDay,
            int minute, int second) {
        set(year, month, day, hourOfDay, minute);
        set(SECOND, second);
        addTaint(year);
        addTaint(month);
        addTaint(day);
        addTaint(hourOfDay);
        addTaint(minute);
        addTaint(second);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.132 -0400", hash_original_method = "9CEC56E07503C11B5926FEE82FE32939", hash_generated_method = "A3F69F8954E7C273CD6DF8888940CD88")
    public void setFirstDayOfWeek(int value) {
        firstDayOfWeek = value;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.133 -0400", hash_original_method = "769D5CCA341B85723A2FDFB2D353BC44", hash_generated_method = "28CC1D5E16959D01C7BF084614507B78")
    public void setLenient(boolean value) {
        lenient = value;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.133 -0400", hash_original_method = "ABF413A19C063DF72268F54419071447", hash_generated_method = "2BBA47AEAE7F0EBBCFCC90A1297DA654")
    public void setMinimalDaysInFirstWeek(int value) {
        minimalDaysInFirstWeek = value;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.133 -0400", hash_original_method = "8326734B6F30C707435A4BD203126230", hash_generated_method = "ED4134B7E122C35F708B1730F0E72BA8")
    public final void setTime(Date date) {
        setTimeInMillis(date.getTime());
        addTaint(date.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.134 -0400", hash_original_method = "2FA47445AF3A8C90A658A67E45128F41", hash_generated_method = "3F1A471A3E96C014EE180B5B9B0EB0C0")
    public void setTimeInMillis(long milliseconds) {
        {
            time = milliseconds;
            isTimeSet = true;
            areFieldsSet = false;
            complete();
        } 
        
        
            
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.134 -0400", hash_original_method = "C71A9CD315A030E06030733CE10A6247", hash_generated_method = "227A37CC71E14E244267359E7E425B06")
    public void setTimeZone(TimeZone timezone) {
        zone = timezone;
        areFieldsSet = false;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.135 -0400", hash_original_method = "FE2881479678F103D2A9794655ED1F87", hash_generated_method = "DE6AECFA0DC5F8B1E27CF63A1B3604B9")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_214362291 = null; 
        StringBuilder result = new StringBuilder(getClass().getName() +
                "[time=" + (isTimeSet ? String.valueOf(time) : "?") +
                ",areFieldsSet=" + areFieldsSet +
                ",lenient=" + lenient +
                ",zone=" + zone.getID() +
                ",firstDayOfWeek=" + firstDayOfWeek +
                ",minimalDaysInFirstWeek=" + minimalDaysInFirstWeek);
        {
            int i = 0;
            {
                result.append(',');
                result.append(FIELD_NAMES[i]);
                result.append('=');
                {
                    result.append(fields[i]);
                } 
                {
                    result.append('?');
                } 
            } 
        } 
        result.append(']');
        varB4EAC82CA7396A68D541C85D26508E83_214362291 = result.toString();
        varB4EAC82CA7396A68D541C85D26508E83_214362291.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_214362291;
        
        
                
                
                
                
                
                
        
            
            
            
            
                
            
                
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.137 -0400", hash_original_method = "91CA2BBC83B63568E9D66A64F5127506", hash_generated_method = "02FB439BC40EF807D7FFEA6B3F8C1C9C")
    public int compareTo(Calendar anotherCalendar) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } 
        long timeInMillis = getTimeInMillis();
        long anotherTimeInMillis = anotherCalendar.getTimeInMillis();
        addTaint(anotherCalendar.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_484379910 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_484379910;
        
        
            
        
        
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.138 -0400", hash_original_method = "3943CE5519C03267AB2522359CAFDF8D", hash_generated_method = "F178F4862F0CA78C26B90ADB4487D98E")
    public String getDisplayName(int field, int style, Locale locale) {
        String varB4EAC82CA7396A68D541C85D26508E83_478712163 = null; 
        {
            style = SHORT;
        } 
        String[] array = getDisplayNameArray(field, style, locale);
        int value = get(field);
        varB4EAC82CA7396A68D541C85D26508E83_478712163 = (array != null) ? array[value] : null;
        addTaint(field);
        addTaint(style);
        addTaint(locale.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_478712163.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_478712163;
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.139 -0400", hash_original_method = "23B9DFD5A49D248BECD0B5B67B00C262", hash_generated_method = "F1F9E456567D4A0EDC71C25F25DA23F2")
    private String[] getDisplayNameArray(int field, int style, Locale locale) {
        String[] varB4EAC82CA7396A68D541C85D26508E83_262724521 = null; 
        String[] varB4EAC82CA7396A68D541C85D26508E83_1308363752 = null; 
        String[] varB4EAC82CA7396A68D541C85D26508E83_1699896899 = null; 
        String[] varB4EAC82CA7396A68D541C85D26508E83_139046761 = null; 
        String[] varB4EAC82CA7396A68D541C85D26508E83_2106997147 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("bad field " + field);
        } 
        checkStyle(style);
        DateFormatSymbols dfs = DateFormatSymbols.getInstance(locale);
        
        varB4EAC82CA7396A68D541C85D26508E83_262724521 = dfs.getAmPmStrings();
        
        
        varB4EAC82CA7396A68D541C85D26508E83_1308363752 = (style == LONG) ? dfs.getWeekdays() : dfs.getShortWeekdays();
        
        
        varB4EAC82CA7396A68D541C85D26508E83_1699896899 = dfs.getEras();
        
        
        varB4EAC82CA7396A68D541C85D26508E83_139046761 = (style == LONG) ? dfs.getMonths() : dfs.getShortMonths();
        
        varB4EAC82CA7396A68D541C85D26508E83_2106997147 = null;
        addTaint(field);
        addTaint(style);
        addTaint(locale.getTaint());
        String[] varA7E53CE21691AB073D9660D615818899_296623462; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_296623462 = varB4EAC82CA7396A68D541C85D26508E83_262724521;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_296623462 = varB4EAC82CA7396A68D541C85D26508E83_1308363752;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_296623462 = varB4EAC82CA7396A68D541C85D26508E83_1699896899;
                break;
            case 4: 
                varA7E53CE21691AB073D9660D615818899_296623462 = varB4EAC82CA7396A68D541C85D26508E83_139046761;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_296623462 = varB4EAC82CA7396A68D541C85D26508E83_2106997147;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_296623462.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_296623462;
        
        
            
        
        
        
        
        
            
        
            
        
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    private static void checkStyle(int style) {
        if (style != ALL_STYLES && style != SHORT && style != LONG) {
            throw new IllegalArgumentException("bad style " + style);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.140 -0400", hash_original_method = "9C5842A520266160609E6030F348A85B", hash_generated_method = "9860AFC90CCCE5B66FC079E3090C0132")
    public Map<String, Integer> getDisplayNames(int field, int style, Locale locale) {
        Map<String, Integer> varB4EAC82CA7396A68D541C85D26508E83_350803403 = null; 
        checkStyle(style);
        complete();
        Map<String, Integer> result = new HashMap<String, Integer>();
        {
            insertValuesInMap(result, getDisplayNameArray(field, SHORT, locale));
        } 
        {
            insertValuesInMap(result, getDisplayNameArray(field, LONG, locale));
        } 
        varB4EAC82CA7396A68D541C85D26508E83_350803403 = result.isEmpty() ? null : result;
        addTaint(field);
        addTaint(style);
        addTaint(locale.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_350803403.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_350803403;
        
        
        
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    private static void insertValuesInMap(Map<String, Integer> map, String[] values) {
        if (values == null) {
            return;
        }
        for (int i = 0; i < values.length; ++i) {
            if (values[i] != null && !values[i].isEmpty()) {
                map.put(values[i], i);
            }
        }
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.140 -0400", hash_original_method = "B466F6EE281116CF7ABF0D209ADAF19B", hash_generated_method = "43725F20FBDCB53C0F360FDBC445E628")
    private void writeObject(ObjectOutputStream stream) throws IOException {
        complete();
        ObjectOutputStream.PutField putFields = stream.putFields();
        putFields.put("areFieldsSet", areFieldsSet);
        putFields.put("fields", this.fields);
        putFields.put("firstDayOfWeek", firstDayOfWeek);
        putFields.put("isSet", isSet);
        putFields.put("isTimeSet", isTimeSet);
        putFields.put("lenient", lenient);
        putFields.put("minimalDaysInFirstWeek", minimalDaysInFirstWeek);
        putFields.put("nextStamp", 2 );
        putFields.put("serialVersionOnStream", 1);
        putFields.put("time", time);
        putFields.put("zone", zone);
        stream.writeFields();
        addTaint(stream.getTaint());
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.141 -0400", hash_original_method = "8FB104B0DF4EC943895E45AF22309DC6", hash_generated_method = "1078A6FC42B03F41D5D7ABFAB67B8D6C")
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField readFields = stream.readFields();
        areFieldsSet = readFields.get("areFieldsSet", false);
        this.fields = (int[]) readFields.get("fields", null);
        firstDayOfWeek = readFields.get("firstDayOfWeek", Calendar.SUNDAY);
        isSet = (boolean[]) readFields.get("isSet", null);
        isTimeSet = readFields.get("isTimeSet", false);
        lenient = readFields.get("lenient", true);
        minimalDaysInFirstWeek = readFields.get("minimalDaysInFirstWeek", 1);
        time = readFields.get("time", 0L);
        zone = (TimeZone) readFields.get("zone", null);
        addTaint(stream.getTaint());
        
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.141 -0400", hash_original_field = "E4ADCFDCE60A36FBBABAF458C95395F2", hash_generated_field = "AF2E0A30DAA7888473F4B1DB6F9AB4E7")

    private static final long serialVersionUID = -1807547505821590642L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.141 -0400", hash_original_field = "B1229A2D5153650048BEFD13F7BB757E", hash_generated_field = "18EBE6A0EA775581ADAF9A3A3B4BDF43")

    public static final int JANUARY = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.141 -0400", hash_original_field = "DF6E031A8886FC157F2E29541B01EE84", hash_generated_field = "DE1A10C1CA4D58A0D0B71D5ED5651C5E")

    public static final int FEBRUARY = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.141 -0400", hash_original_field = "1F991F90B893DA0FC9B5E3150A0B31F5", hash_generated_field = "9A060A9F43E320077FEF91D7F3E16318")

    public static final int MARCH = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.141 -0400", hash_original_field = "DA7AFA3E579A805E2389B9F10AA6618A", hash_generated_field = "84082A64126E6ACD9A8A7166E76E4710")

    public static final int APRIL = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.141 -0400", hash_original_field = "9E16AFF2D9C7EF95B77DD5682A1FC27C", hash_generated_field = "2B49A74DDADD5147E334034FECF80F61")

    public static final int MAY = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.141 -0400", hash_original_field = "3B72053389DAC082B5AAA76E951054CF", hash_generated_field = "40AAE596E48BB3CE7DED4445B6CA7C3A")

    public static final int JUNE = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.141 -0400", hash_original_field = "DD80EBED669229240067FB0B5BBF69AB", hash_generated_field = "57C7088304F19819321C68C4EA4D43FE")

    public static final int JULY = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.141 -0400", hash_original_field = "B0E61FBAFCF5DEA331504C861F86D53F", hash_generated_field = "DD0287EC2BAD39C6AA0CB00681983E13")

    public static final int AUGUST = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.141 -0400", hash_original_field = "F972C9AE2AC61A777387E83C68708780", hash_generated_field = "65D9E0EA51CBB939F331D73F96E8F737")

    public static final int SEPTEMBER = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.141 -0400", hash_original_field = "76343C816DB5711F579A12DCB4F16B8E", hash_generated_field = "5F215B3F48DD52DCA5B05BB8683ACB9E")

    public static final int OCTOBER = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.141 -0400", hash_original_field = "FFCED4181918C72BF900A5CFE0673433", hash_generated_field = "07258F480C131FFB71C8F3192EC866BB")

    public static final int NOVEMBER = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.141 -0400", hash_original_field = "F343818DCC00004297FBA5987DA2AD48", hash_generated_field = "99346885877C320A88C5DEEF1FE5C6A1")

    public static final int DECEMBER = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.141 -0400", hash_original_field = "359C003D4D135BBA6F4DFF63171ED20E", hash_generated_field = "12CB74BD217D91F4A997C4A9B3204153")

    public static final int UNDECIMBER = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.142 -0400", hash_original_field = "6AB76E6F953EFCD0E4C19075388A01EE", hash_generated_field = "F91CDF25E1A1263D08DCDFDA293D2FF1")

    public static final int SUNDAY = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.142 -0400", hash_original_field = "A572F76B8BED75381557BFEF545691E3", hash_generated_field = "4F7898CDA37C0C1672B1DD0225C38742")

    public static final int MONDAY = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.142 -0400", hash_original_field = "5AE9E5F65075AE05DAC98F042ED1B0C3", hash_generated_field = "EE1E35179BDB284983C5FA3C4A5286FB")

    public static final int TUESDAY = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.142 -0400", hash_original_field = "FC721785B80C9BB5B5B7737C8BDFDCB7", hash_generated_field = "B8FE5FF93BBD24C3DBD1BA8DEAA957DF")

    public static final int WEDNESDAY = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.142 -0400", hash_original_field = "E43AB3070A1AA17CFEED597E61B5783E", hash_generated_field = "3D06389FD7761B49C580CD0426877E03")

    public static final int THURSDAY = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.142 -0400", hash_original_field = "056EABFCC97B0D1049792F9B61D89D7E", hash_generated_field = "6793376618E81D6864359810244D7454")

    public static final int FRIDAY = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.142 -0400", hash_original_field = "DDAB7B40FF68250D655CFF3E3B927C17", hash_generated_field = "F33B8115640CE7F59D68A9F20CAEB4A4")

    public static final int SATURDAY = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.142 -0400", hash_original_field = "B33A9FCD83A2AD2D2FCA2CF40C206330", hash_generated_field = "E301476B4E26DF25A92B3AA8A9107617")

    public static final int ERA = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.142 -0400", hash_original_field = "D6E0623B96D61F8FB44E4B0B5753B83A", hash_generated_field = "F11869056FDF683C955988AF5A0DDE34")

    public static final int YEAR = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.142 -0400", hash_original_field = "1C91793E51C3A9062D5AB3332AF15358", hash_generated_field = "7ADEC6D0CDDC20B12462876FAAA80E7F")

    public static final int MONTH = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.142 -0400", hash_original_field = "43752A09F94775E581B1768AA144D6FA", hash_generated_field = "C4712C77A935F7F8EF3A0FAB8653CD50")

    public static final int WEEK_OF_YEAR = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.142 -0400", hash_original_field = "9F122ED36CC75916396FA33C2C541D68", hash_generated_field = "4209CEA320055F2A79C871E83FA19ECD")

    public static final int WEEK_OF_MONTH = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.142 -0400", hash_original_field = "5217925A108CB1DA8D998F2579406C2E", hash_generated_field = "825B85B498FD03FCA906C87FB3805D32")

    public static final int DATE = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.142 -0400", hash_original_field = "70569F6DF5D781813A5CEBBA5E9D1535", hash_generated_field = "EFB6ACBBED425C9038C6D037D0082F4C")

    public static final int DAY_OF_MONTH = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.142 -0400", hash_original_field = "83BC272221DC69D1A6BECC23692E58F5", hash_generated_field = "DDAC1EE15C7150842AE212280B96B617")

    public static final int DAY_OF_YEAR = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.142 -0400", hash_original_field = "18A62D9917C05757630C3CE19504A956", hash_generated_field = "B5836DC3C1EA3C6522AC2F728E1D637D")

    public static final int DAY_OF_WEEK = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.142 -0400", hash_original_field = "69CBE771734DF1A3D673E2868456643B", hash_generated_field = "AECF12E2908165277F0D63DF571281C2")

    public static final int DAY_OF_WEEK_IN_MONTH = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.142 -0400", hash_original_field = "49058FE71FB9FF9EF0D3E1B42F68DEEF", hash_generated_field = "FE3FF3E1A88CE7F17CFA86C2FD588F3A")

    public static final int AM_PM = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.142 -0400", hash_original_field = "14812F95FBEF9C7C394F9A1730D3C99E", hash_generated_field = "EC0B014C2F8D2A70D0DC0E6595B16DC3")

    public static final int HOUR = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.142 -0400", hash_original_field = "6686B3199F3E3DB19B935AF46ED213F6", hash_generated_field = "A6B692656855E13B4647C887CB94655F")

    public static final int HOUR_OF_DAY = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.142 -0400", hash_original_field = "21EBB6113111BB763B80954D2295F080", hash_generated_field = "C1E0602297351F7BD222DD115F481FAA")

    public static final int MINUTE = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.142 -0400", hash_original_field = "1FDA3D33995DEFFD74BED4480C05C8A8", hash_generated_field = "50977DDBE62C0994013A6190F746E76D")

    public static final int SECOND = 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.142 -0400", hash_original_field = "4409B7EC99BB6E1567D784F859E571A7", hash_generated_field = "EBD943872B0DC03F8DA791205BB276E0")

    public static final int MILLISECOND = 14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.142 -0400", hash_original_field = "B8E966FD91FDCC398E806F4E026F8D9D", hash_generated_field = "CF6B5B33A8280CA15F32F4C409683BB7")

    public static final int ZONE_OFFSET = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.142 -0400", hash_original_field = "0287BF812603F678C22B6AE2BF88AD00", hash_generated_field = "5BC57F3FA8E3F55632AF6D9EE7639DD9")

    public static final int DST_OFFSET = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.142 -0400", hash_original_field = "B300B9E126DBB4375CE2F8EF37F91746", hash_generated_field = "C0AD90D0AE4AA2CE7973DC573EBDB44F")

    public static final int FIELD_COUNT = 17;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.142 -0400", hash_original_field = "146EDA96704CAE2AC584EEE531240256", hash_generated_field = "12DF7D953F2E794CDDBE44C8913E7D53")

    public static final int AM = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.142 -0400", hash_original_field = "3706AACC371BBC9704CA8C7AA3744E69", hash_generated_field = "8604262D117A4ECB98B8C2D2F8B21F35")

    public static final int PM = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.142 -0400", hash_original_field = "A3CA4814D4F89191EACA6945C3BBEE09", hash_generated_field = "FDDDB5A7AFE2EF5F55DA4077744BE025")

    public static final int ALL_STYLES = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.142 -0400", hash_original_field = "ECA0228AA5AC43C273D6A21201F7945C", hash_generated_field = "F7ACB78854980F98EB72B4076CEEC364")

    public static final int SHORT = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.142 -0400", hash_original_field = "0873C6DB80D32564A3F9A5C6FBDE5E65", hash_generated_field = "00D4EA5E2F513F125A8CCE9688DB12D7")

    public static final int LONG = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.142 -0400", hash_original_field = "2598ABE24AAF8554D19D3E3571DB67B3", hash_generated_field = "E98760CF948389324CD259C52EDE02C8")

    private static final String[] FIELD_NAMES = { "ERA", "YEAR", "MONTH",
            "WEEK_OF_YEAR", "WEEK_OF_MONTH", "DAY_OF_MONTH", "DAY_OF_YEAR",
            "DAY_OF_WEEK", "DAY_OF_WEEK_IN_MONTH", "AM_PM", "HOUR",
            "HOUR_OF_DAY", "MINUTE", "SECOND", "MILLISECOND",
            "ZONE_OFFSET", "DST_OFFSET" };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.142 -0400", hash_original_field = "CC170D6DBE61DAE7E0149B1156D53E16", hash_generated_field = "38D65C9058142C88025F5AD8AC8D9090")

    private static final ObjectStreamField[] serialPersistentFields = {
        new ObjectStreamField("areFieldsSet", boolean.class),
        new ObjectStreamField("fields", int[].class),
        new ObjectStreamField("firstDayOfWeek", int.class),
        new ObjectStreamField("isSet", boolean[].class),
        new ObjectStreamField("isTimeSet", boolean.class),
        new ObjectStreamField("lenient", boolean.class),
        new ObjectStreamField("minimalDaysInFirstWeek", int.class),
        new ObjectStreamField("nextStamp", int.class),
        new ObjectStreamField("serialVersionOnStream", int.class),
        new ObjectStreamField("time", long.class),
        new ObjectStreamField("zone", TimeZone.class),
    };
}

