package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.text.DateFormatSymbols;
import libcore.icu.ICU;
import libcore.icu.LocaleData;

public abstract class Calendar implements Serializable, Cloneable, Comparable<Calendar> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.225 -0400", hash_original_field = "968371C4AF5AE99403612957ADE12B5F", hash_generated_field = "CE3F9942C85635B6DB1739E7DBF40F0C")

    protected boolean areFieldsSet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.225 -0400", hash_original_field = "D05B6ED7D2345020440DF396D6DA7F73", hash_generated_field = "E574E68E645EC43F733A1248603B982F")

    protected int[] fields;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.225 -0400", hash_original_field = "7E8AD70F1D9ED8B28FD71C6C1BA4D2B8", hash_generated_field = "213F640A8226820C3FAD694FABC68220")

    protected boolean[] isSet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.225 -0400", hash_original_field = "FCD946B6F697945EC5FCC211FF5C639E", hash_generated_field = "973A26005EDCFC142AE184E74D7A9C44")

    protected boolean isTimeSet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.225 -0400", hash_original_field = "07CC694B9B3FC636710FA08B6922C42B", hash_generated_field = "DF6F7F34B65DA140AA02B5623A896C3D")

    protected long time;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.225 -0400", hash_original_field = "8307D2015BE199A91F71907A46B15858", hash_generated_field = "8B06B22BB0D98B206D493E4536EE7432")

    transient int lastTimeFieldSet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.225 -0400", hash_original_field = "BB814C47C41CB6FE07B13DB029003F44", hash_generated_field = "FB479690428AB835107C0237892E7931")

    transient int lastDateFieldSet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.225 -0400", hash_original_field = "526E2996690A16FF145147ABB1927920", hash_generated_field = "EAF178494884F790222D5DEEC0D047C3")

    private boolean lenient;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.225 -0400", hash_original_field = "3CD3E760E15423653736E26E4D21E54A", hash_generated_field = "AB58B3610E0723B715410016290F0168")

    private int firstDayOfWeek;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.225 -0400", hash_original_field = "84FAA04375A171B334639F6BBA18E901", hash_generated_field = "B89C77A3F2A82BA7436489590490B056")

    private int minimalDaysInFirstWeek;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.225 -0400", hash_original_field = "A84E5F25E7F6D5DE9B82CE3F64D1B8FA", hash_generated_field = "05D717DFC6EF8897D7D254757AEA2790")

    private TimeZone zone;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.226 -0400", hash_original_method = "E09C10A5808D539238E77D59E7FF85D8", hash_generated_method = "374B305B1106BD03A7A9AA8CD5945D9E")
    protected  Calendar() {
        this(TimeZone.getDefault(), Locale.getDefault());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.226 -0400", hash_original_method = "88FEBE5E333C1748D0E9CCFA28BF3B86", hash_generated_method = "173EE3582E48B11E5AC2279E888D102B")
      Calendar(TimeZone timezone) {
        addTaint(timezone.getTaint());
        fields = new int[FIELD_COUNT];
        isSet = new boolean[FIELD_COUNT];
        areFieldsSet = isTimeSet = false;
        setLenient(true);
        setTimeZone(timezone);
        // ---------- Original Method ----------
        //fields = new int[FIELD_COUNT];
        //isSet = new boolean[FIELD_COUNT];
        //areFieldsSet = isTimeSet = false;
        //setLenient(true);
        //setTimeZone(timezone);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.227 -0400", hash_original_method = "DC052852760F164E5EB6C2F703BBC41B", hash_generated_method = "ED1D6E28F6ACA9D7EA6540B2E29A74E0")
    protected  Calendar(TimeZone timezone, Locale locale) {
        this(timezone);
        addTaint(locale.getTaint());
        addTaint(timezone.getTaint());
        LocaleData localeData = LocaleData.get(locale);
        setFirstDayOfWeek(localeData.firstDayOfWeek.intValue());
        setMinimalDaysInFirstWeek(localeData.minimalDaysInFirstWeek.intValue());
        // ---------- Original Method ----------
        //LocaleData localeData = LocaleData.get(locale);
        //setFirstDayOfWeek(localeData.firstDayOfWeek.intValue());
        //setMinimalDaysInFirstWeek(localeData.minimalDaysInFirstWeek.intValue());
    }

    
    public abstract void add(int field, int value);

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.227 -0400", hash_original_method = "3DBAFBF02CB3C60196FBCDD8387C90F7", hash_generated_method = "FDA65216951B2606B6CAF1F7F5CD5A75")
    public boolean after(Object calendar) {
        addTaint(calendar.getTaint());
        if(!(calendar instanceof Calendar))        
        {
            boolean var68934A3E9455FA72420237EB05902327_941768499 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1820916951 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1820916951;
        } //End block
        boolean varFF7E25C72C1E2D368712C2364246BF83_1879570223 = (getTimeInMillis() > ((Calendar) calendar).getTimeInMillis());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1176057035 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1176057035;
        // ---------- Original Method ----------
        //if (!(calendar instanceof Calendar)) {
            //return false;
        //}
        //return getTimeInMillis() > ((Calendar) calendar).getTimeInMillis();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.228 -0400", hash_original_method = "AB514F7047FACF0A18BC971364ADD066", hash_generated_method = "90A0192B4AB9AB6A02619A1D2E71834E")
    public boolean before(Object calendar) {
        addTaint(calendar.getTaint());
        if(!(calendar instanceof Calendar))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1739876631 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1389002387 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1389002387;
        } //End block
        boolean var695699E5B061059CE579036797DC9CCE_849432190 = (getTimeInMillis() < ((Calendar) calendar).getTimeInMillis());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2136171231 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2136171231;
        // ---------- Original Method ----------
        //if (!(calendar instanceof Calendar)) {
            //return false;
        //}
        //return getTimeInMillis() < ((Calendar) calendar).getTimeInMillis();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.229 -0400", hash_original_method = "A9FFD41082BBDB8FD2EC401621467C0D", hash_generated_method = "535C73DAC5BC2261F2168AFD64759BA7")
    public final void clear() {
for(int i = 0;i < FIELD_COUNT;i++)
        {
            fields[i] = 0;
            isSet[i] = false;
        } //End block
        areFieldsSet = isTimeSet = false;
        // ---------- Original Method ----------
        //for (int i = 0; i < FIELD_COUNT; i++) {
            //fields[i] = 0;
            //isSet[i] = false;
        //}
        //areFieldsSet = isTimeSet = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.230 -0400", hash_original_method = "045ED04F1C7B7EFD467C2025674AC1C4", hash_generated_method = "5601ADC664CA4C20A4642CF90A9811CA")
    public final void clear(int field) {
        fields[field] = 0;
        isSet[field] = false;
        areFieldsSet = isTimeSet = false;
        // ---------- Original Method ----------
        //fields[field] = 0;
        //isSet[field] = false;
        //areFieldsSet = isTimeSet = false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.231 -0400", hash_original_method = "84D98F75151E4961D0916EA8CB3E0C38", hash_generated_method = "BFCBED007A44522AC950711D63C4E47A")
    @Override
    public Object clone() {
        try 
        {
            Calendar clone = (Calendar) super.clone();
            clone.fields = fields.clone();
            clone.isSet = isSet.clone();
            clone.zone = (TimeZone) zone.clone();
Object var3DE52045BFD3C1BF3742F994ED6139AD_900954426 =             clone;
            var3DE52045BFD3C1BF3742F994ED6139AD_900954426.addTaint(taint);
            return var3DE52045BFD3C1BF3742F994ED6139AD_900954426;
        } //End block
        catch (CloneNotSupportedException e)
        {
            AssertionError varA5A331D65C8C3F32D42E49D64BCF4109_868846874 = new AssertionError(e);
            varA5A331D65C8C3F32D42E49D64BCF4109_868846874.addTaint(taint);
            throw varA5A331D65C8C3F32D42E49D64BCF4109_868846874;
        } //End block
        // ---------- Original Method ----------
        //try {
            //Calendar clone = (Calendar) super.clone();
            //clone.fields = fields.clone();
            //clone.isSet = isSet.clone();
            //clone.zone = (TimeZone) zone.clone();
            //return clone;
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError(e);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.232 -0400", hash_original_method = "A716BA757DE54F1250A3DB16F903EEB4", hash_generated_method = "A22C3AC0CDB42FA7361AB168FA508AE9")
    protected void complete() {
        if(!isTimeSet)        
        {
            computeTime();
            isTimeSet = true;
        } //End block
        if(!areFieldsSet)        
        {
            computeFields();
            areFieldsSet = true;
        } //End block
        // ---------- Original Method ----------
        //if (!isTimeSet) {
            //computeTime();
            //isTimeSet = true;
        //}
        //if (!areFieldsSet) {
            //computeFields();
            //areFieldsSet = true;
        //}
    }

    
    protected abstract void computeFields();

    
    protected abstract void computeTime();

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.232 -0400", hash_original_method = "A4F7F4EE453A4994C5225BE31C26C1E8", hash_generated_method = "3921588C6346698EAF9C14B31DF21F3D")
    @Override
    public boolean equals(Object object) {
        addTaint(object.getTaint());
        if(this == object)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1672853045 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_217884651 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_217884651;
        } //End block
        if(!(object instanceof Calendar))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1255480595 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_489436735 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_489436735;
        } //End block
        Calendar cal = (Calendar) object;
        boolean varE278EA155ADBB20E94781E347BD9631D_80101173 = (getTimeInMillis() == cal.getTimeInMillis()
                && isLenient() == cal.isLenient()
                && getFirstDayOfWeek() == cal.getFirstDayOfWeek()
                && getMinimalDaysInFirstWeek() == cal
                        .getMinimalDaysInFirstWeek()
                && getTimeZone().equals(cal.getTimeZone()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_89718070 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_89718070;
        // ---------- Original Method ----------
        //if (this == object) {
            //return true;
        //}
        //if (!(object instanceof Calendar)) {
            //return false;
        //}
        //Calendar cal = (Calendar) object;
        //return getTimeInMillis() == cal.getTimeInMillis()
                //&& isLenient() == cal.isLenient()
                //&& getFirstDayOfWeek() == cal.getFirstDayOfWeek()
                //&& getMinimalDaysInFirstWeek() == cal
                        //.getMinimalDaysInFirstWeek()
                //&& getTimeZone().equals(cal.getTimeZone());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.233 -0400", hash_original_method = "E826346499B559368BF751B42F34C786", hash_generated_method = "9AA81B186CDC57324DB04BA7763D9810")
    public int get(int field) {
        addTaint(field);
        complete();
        int var4BAD90A31935F6D6C8FA0FE44F4822FA_1560084510 = (fields[field]);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1887489700 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1887489700;
        // ---------- Original Method ----------
        //complete();
        //return fields[field];
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.234 -0400", hash_original_method = "424E8E96F9A12B00FD5C6FDA146C325F", hash_generated_method = "C229E2D837E159156509C1E27CCBAA24")
    public int getActualMaximum(int field) {
        addTaint(field);
        int value;
        int next;
        if(getMaximum(field) == (next = getLeastMaximum(field)))        
        {
            int varD0CAB90D8D20D57E2F2B9BE52F7DD25D_1102457309 = (next);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_492167774 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_492167774;
        } //End block
        complete();
        long orgTime = time;
        set(field, next);
        do {
            {
                value = next;
                roll(field, true);
                next = get(field);
            } //End block
} while (next > value);
        time = orgTime;
        areFieldsSet = false;
        int var2063C1608D6E0BAF80249C42E2BE5804_1202823732 = (value);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_735281138 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_735281138;
        // ---------- Original Method ----------
        //int value, next;
        //if (getMaximum(field) == (next = getLeastMaximum(field))) {
            //return next;
        //}
        //complete();
        //long orgTime = time;
        //set(field, next);
        //do {
            //value = next;
            //roll(field, true);
            //next = get(field);
        //} while (next > value);
        //time = orgTime;
        //areFieldsSet = false;
        //return value;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.234 -0400", hash_original_method = "598A84D60F29BB97F62226BCCD8A7F9E", hash_generated_method = "EE2154816F9D293255C418A34147A6A6")
    public int getActualMinimum(int field) {
        addTaint(field);
        int value;
        int next;
        if(getMinimum(field) == (next = getGreatestMinimum(field)))        
        {
            int varD0CAB90D8D20D57E2F2B9BE52F7DD25D_1590650070 = (next);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_389671047 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_389671047;
        } //End block
        complete();
        long orgTime = time;
        set(field, next);
        do {
            {
                value = next;
                roll(field, false);
                next = get(field);
            } //End block
} while (next < value);
        time = orgTime;
        areFieldsSet = false;
        int var2063C1608D6E0BAF80249C42E2BE5804_1117943003 = (value);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1469322500 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1469322500;
        // ---------- Original Method ----------
        //int value, next;
        //if (getMinimum(field) == (next = getGreatestMinimum(field))) {
            //return next;
        //}
        //complete();
        //long orgTime = time;
        //set(field, next);
        //do {
            //value = next;
            //roll(field, false);
            //next = get(field);
        //} while (next < value);
        //time = orgTime;
        //areFieldsSet = false;
        //return value;
    }

    
    @DSModeled(DSC.SAFE)
    public static synchronized Locale[] getAvailableLocales() {
        return ICU.getAvailableCalendarLocales();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.235 -0400", hash_original_method = "2210DC8BCE617C61AD2F9503CE7923B1", hash_generated_method = "793EFBC44580997378EDB45ADEFAF8F9")
    public int getFirstDayOfWeek() {
        int var3CD3E760E15423653736E26E4D21E54A_2021429007 = (firstDayOfWeek);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1378816999 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1378816999;
        // ---------- Original Method ----------
        //return firstDayOfWeek;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.236 -0400", hash_original_method = "104647FF062CF5167F06DB549E6DD4EB", hash_generated_method = "4108A3717A3045B6BC73FE523A7255C2")
    public int getMinimalDaysInFirstWeek() {
        int var84FAA04375A171B334639F6BBA18E901_342834353 = (minimalDaysInFirstWeek);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1052788772 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1052788772;
        // ---------- Original Method ----------
        //return minimalDaysInFirstWeek;
    }

    
    public abstract int getMinimum(int field);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.236 -0400", hash_original_method = "0D972793C1A81D3B5C0D23389B920FB5", hash_generated_method = "8F3087DE7D719316AE1A292F1A29B5AA")
    public final Date getTime() {
Date var4FE5A3569B4AD21C5FEAEB352ABA8F58_942431362 =         new Date(getTimeInMillis());
        var4FE5A3569B4AD21C5FEAEB352ABA8F58_942431362.addTaint(taint);
        return var4FE5A3569B4AD21C5FEAEB352ABA8F58_942431362;
        // ---------- Original Method ----------
        //return new Date(getTimeInMillis());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.236 -0400", hash_original_method = "1B58DB6425011C7C1965B5C43056D530", hash_generated_method = "2C2147F30053BE3DE16B32602084E89B")
    public long getTimeInMillis() {
        if(!isTimeSet)        
        {
            computeTime();
            isTimeSet = true;
        } //End block
        long var07CC694B9B3FC636710FA08B6922C42B_1727001190 = (time);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1182420769 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1182420769;
        // ---------- Original Method ----------
        //if (!isTimeSet) {
            //computeTime();
            //isTimeSet = true;
        //}
        //return time;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.236 -0400", hash_original_method = "A62BA7A8B3AE52F44B15929DB0809596", hash_generated_method = "326D92EC6FE15F7819432CC398A1C1E4")
    public TimeZone getTimeZone() {
TimeZone var61F6902A567A932064AABE0702479FA5_1875880445 =         zone;
        var61F6902A567A932064AABE0702479FA5_1875880445.addTaint(taint);
        return var61F6902A567A932064AABE0702479FA5_1875880445;
        // ---------- Original Method ----------
        //return zone;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.236 -0400", hash_original_method = "2D54AA953826341AD4FD2AC42B53AEBA", hash_generated_method = "AB2323B71C1B97E519999A7F0B24329B")
    @Override
    public int hashCode() {
        int var8400CEC4480754309648510DBD04F2D9_650779666 = ((isLenient() ? 1237 : 1231) + getFirstDayOfWeek()
                + getMinimalDaysInFirstWeek() + getTimeZone().hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_300071065 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_300071065;
        // ---------- Original Method ----------
        //return (isLenient() ? 1237 : 1231) + getFirstDayOfWeek()
                //+ getMinimalDaysInFirstWeek() + getTimeZone().hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.236 -0400", hash_original_method = "B2249A52847A00BE88915EAA81CF8D45", hash_generated_method = "3B73D891F97A93C8768CC26EB920940A")
    protected final int internalGet(int field) {
        addTaint(field);
        int var4BAD90A31935F6D6C8FA0FE44F4822FA_1898790941 = (fields[field]);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_754235854 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_754235854;
        // ---------- Original Method ----------
        //return fields[field];
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.236 -0400", hash_original_method = "5DB017D3EE054B32EA01614D92601D4D", hash_generated_method = "661CCC78CF48F6EA9F6013211B19EA25")
    public boolean isLenient() {
        boolean var526E2996690A16FF145147ABB1927920_987931697 = (lenient);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1513372280 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1513372280;
        // ---------- Original Method ----------
        //return lenient;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.237 -0400", hash_original_method = "295995F35CFAB02328483B566F7330CE", hash_generated_method = "7A9C46E0A2C8D3F06AEBFA30A6ED318E")
    public final boolean isSet(int field) {
        addTaint(field);
        boolean var780BC782A05D72914DBE2B24D203741A_983563093 = (isSet[field]);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_133109595 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_133109595;
        // ---------- Original Method ----------
        //return isSet[field];
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.237 -0400", hash_original_method = "F5FA416393576D1F9DD8BCE9349020A6", hash_generated_method = "D28845D088C3F1B473610F38D060B168")
    public void roll(int field, int value) {
        addTaint(value);
        addTaint(field);
        boolean increment = value >= 0;
        int count = increment ? value : -value;
for(int i = 0;i < count;i++)
        {
            roll(field, increment);
        } //End block
        // ---------- Original Method ----------
        //boolean increment = value >= 0;
        //int count = increment ? value : -value;
        //for (int i = 0; i < count; i++) {
            //roll(field, increment);
        //}
    }

    
    public abstract void roll(int field, boolean increment);

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.237 -0400", hash_original_method = "41A9E001F522D5852F11FBD319F3A5A6", hash_generated_method = "F370123754D39C4B902827C19A52C6F1")
    public void set(int field, int value) {
        fields[field] = value;
        isSet[field] = true;
        areFieldsSet = isTimeSet = false;
        if(field > MONTH && field < AM_PM)        
        {
            lastDateFieldSet = field;
        } //End block
        if(field == HOUR || field == HOUR_OF_DAY)        
        {
            lastTimeFieldSet = field;
        } //End block
        if(field == AM_PM)        
        {
            lastTimeFieldSet = HOUR;
        } //End block
        // ---------- Original Method ----------
        //fields[field] = value;
        //isSet[field] = true;
        //areFieldsSet = isTimeSet = false;
        //if (field > MONTH && field < AM_PM) {
            //lastDateFieldSet = field;
        //}
        //if (field == HOUR || field == HOUR_OF_DAY) {
            //lastTimeFieldSet = field;
        //}
        //if (field == AM_PM) {
            //lastTimeFieldSet = HOUR;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.237 -0400", hash_original_method = "E11C90BCB39036715964798223610892", hash_generated_method = "496E4EFF76EE7629705D952B6ADB3338")
    public final void set(int year, int month, int day) {
        addTaint(day);
        addTaint(month);
        addTaint(year);
        set(YEAR, year);
        set(MONTH, month);
        set(DATE, day);
        // ---------- Original Method ----------
        //set(YEAR, year);
        //set(MONTH, month);
        //set(DATE, day);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.237 -0400", hash_original_method = "B4EBEBE6ED320058BB13C1E33AF949E4", hash_generated_method = "09C9A1F8C2609506A6105D86A365B721")
    public final void set(int year, int month, int day, int hourOfDay,
            int minute) {
        addTaint(minute);
        addTaint(hourOfDay);
        addTaint(day);
        addTaint(month);
        addTaint(year);
        set(year, month, day);
        set(HOUR_OF_DAY, hourOfDay);
        set(MINUTE, minute);
        // ---------- Original Method ----------
        //set(year, month, day);
        //set(HOUR_OF_DAY, hourOfDay);
        //set(MINUTE, minute);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.238 -0400", hash_original_method = "071B019FF423902B33C61C7D7703D8F0", hash_generated_method = "BA45F5F86E082EBF9EB5682070510612")
    public final void set(int year, int month, int day, int hourOfDay,
            int minute, int second) {
        addTaint(second);
        addTaint(minute);
        addTaint(hourOfDay);
        addTaint(day);
        addTaint(month);
        addTaint(year);
        set(year, month, day, hourOfDay, minute);
        set(SECOND, second);
        // ---------- Original Method ----------
        //set(year, month, day, hourOfDay, minute);
        //set(SECOND, second);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.238 -0400", hash_original_method = "9CEC56E07503C11B5926FEE82FE32939", hash_generated_method = "A3F69F8954E7C273CD6DF8888940CD88")
    public void setFirstDayOfWeek(int value) {
        firstDayOfWeek = value;
        // ---------- Original Method ----------
        //firstDayOfWeek = value;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.238 -0400", hash_original_method = "769D5CCA341B85723A2FDFB2D353BC44", hash_generated_method = "28CC1D5E16959D01C7BF084614507B78")
    public void setLenient(boolean value) {
        lenient = value;
        // ---------- Original Method ----------
        //lenient = value;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.238 -0400", hash_original_method = "ABF413A19C063DF72268F54419071447", hash_generated_method = "2BBA47AEAE7F0EBBCFCC90A1297DA654")
    public void setMinimalDaysInFirstWeek(int value) {
        minimalDaysInFirstWeek = value;
        // ---------- Original Method ----------
        //minimalDaysInFirstWeek = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.238 -0400", hash_original_method = "8326734B6F30C707435A4BD203126230", hash_generated_method = "90C83C96BAAAADE59E5366DE641ABDCC")
    public final void setTime(Date date) {
        addTaint(date.getTaint());
        setTimeInMillis(date.getTime());
        // ---------- Original Method ----------
        //setTimeInMillis(date.getTime());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.238 -0400", hash_original_method = "2FA47445AF3A8C90A658A67E45128F41", hash_generated_method = "B7657A9496314A0A94626379E623DEBB")
    public void setTimeInMillis(long milliseconds) {
        if(!isTimeSet || !areFieldsSet || time != milliseconds)        
        {
            time = milliseconds;
            isTimeSet = true;
            areFieldsSet = false;
            complete();
        } //End block
        // ---------- Original Method ----------
        //if (!isTimeSet || !areFieldsSet || time != milliseconds) {
            //time = milliseconds;
            //isTimeSet = true;
            //areFieldsSet = false;
            //complete();
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.238 -0400", hash_original_method = "C71A9CD315A030E06030733CE10A6247", hash_generated_method = "227A37CC71E14E244267359E7E425B06")
    public void setTimeZone(TimeZone timezone) {
        zone = timezone;
        areFieldsSet = false;
        // ---------- Original Method ----------
        //zone = timezone;
        //areFieldsSet = false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.239 -0400", hash_original_method = "FE2881479678F103D2A9794655ED1F87", hash_generated_method = "5A682AC450BB739BF700B51F98AF691D")
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(getClass().getName() +
                "[time=" + (isTimeSet ? String.valueOf(time) : "?") +
                ",areFieldsSet=" + areFieldsSet +
                ",lenient=" + lenient +
                ",zone=" + zone.getID() +
                ",firstDayOfWeek=" + firstDayOfWeek +
                ",minimalDaysInFirstWeek=" + minimalDaysInFirstWeek);
for(int i = 0;i < FIELD_COUNT;i++)
        {
            result.append(',');
            result.append(FIELD_NAMES[i]);
            result.append('=');
            if(isSet[i])            
            {
                result.append(fields[i]);
            } //End block
            else
            {
                result.append('?');
            } //End block
        } //End block
        result.append(']');
String varE65B3A02759122992CB82C0E651AD408_2146560972 =         result.toString();
        varE65B3A02759122992CB82C0E651AD408_2146560972.addTaint(taint);
        return varE65B3A02759122992CB82C0E651AD408_2146560972;
        // ---------- Original Method ----------
        //StringBuilder result = new StringBuilder(getClass().getName() +
                //"[time=" + (isTimeSet ? String.valueOf(time) : "?") +
                //",areFieldsSet=" + areFieldsSet +
                //",lenient=" + lenient +
                //",zone=" + zone.getID() +
                //",firstDayOfWeek=" + firstDayOfWeek +
                //",minimalDaysInFirstWeek=" + minimalDaysInFirstWeek);
        //for (int i = 0; i < FIELD_COUNT; i++) {
            //result.append(',');
            //result.append(FIELD_NAMES[i]);
            //result.append('=');
            //if (isSet[i]) {
                //result.append(fields[i]);
            //} else {
                //result.append('?');
            //}
        //}
        //result.append(']');
        //return result.toString();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.239 -0400", hash_original_method = "91CA2BBC83B63568E9D66A64F5127506", hash_generated_method = "958AAEB921A18470092786C31F3D5F46")
    public int compareTo(Calendar anotherCalendar) {
        addTaint(anotherCalendar.getTaint());
        if(anotherCalendar == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_493773516 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_493773516.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_493773516;
        } //End block
        long timeInMillis = getTimeInMillis();
        long anotherTimeInMillis = anotherCalendar.getTimeInMillis();
        if(timeInMillis > anotherTimeInMillis)        
        {
            int varC4CA4238A0B923820DCC509A6F75849B_1023689563 = (1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_452392155 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_452392155;
        } //End block
        if(timeInMillis == anotherTimeInMillis)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_847775331 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1354610386 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1354610386;
        } //End block
        int var6BB61E3B7BCE0931DA574D19D1D82C88_825269198 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_185375126 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_185375126;
        // ---------- Original Method ----------
        //if (anotherCalendar == null) {
            //throw new NullPointerException();
        //}
        //long timeInMillis = getTimeInMillis();
        //long anotherTimeInMillis = anotherCalendar.getTimeInMillis();
        //if (timeInMillis > anotherTimeInMillis) {
            //return 1;
        //}
        //if (timeInMillis == anotherTimeInMillis) {
            //return 0;
        //}
        //return -1;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.239 -0400", hash_original_method = "3943CE5519C03267AB2522359CAFDF8D", hash_generated_method = "A9A8270D3C9DD5EE18714E5031021E73")
    public String getDisplayName(int field, int style, Locale locale) {
        addTaint(locale.getTaint());
        addTaint(style);
        addTaint(field);
        if(style == ALL_STYLES)        
        {
            style = SHORT;
        } //End block
        String[] array = getDisplayNameArray(field, style, locale);
        int value = get(field);
String varBE80B03BFDF52EE6C9453F245B3DB27C_308948707 =         (array != null) ? array[value] : null;
        varBE80B03BFDF52EE6C9453F245B3DB27C_308948707.addTaint(taint);
        return varBE80B03BFDF52EE6C9453F245B3DB27C_308948707;
        // ---------- Original Method ----------
        //if (style == ALL_STYLES) {
            //style = SHORT;
        //}
        //String[] array = getDisplayNameArray(field, style, locale);
        //int value = get(field);
        //return (array != null) ? array[value] : null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.240 -0400", hash_original_method = "23B9DFD5A49D248BECD0B5B67B00C262", hash_generated_method = "FE2370B62952E0EE248F6AFB061DD3BB")
    private String[] getDisplayNameArray(int field, int style, Locale locale) {
        addTaint(locale.getTaint());
        addTaint(style);
        addTaint(field);
        if(field < 0 || field >= FIELD_COUNT)        
        {
            IllegalArgumentException var53540864F866CD912D006722AFBB615C_748788599 = new IllegalArgumentException("bad field " + field);
            var53540864F866CD912D006722AFBB615C_748788599.addTaint(taint);
            throw var53540864F866CD912D006722AFBB615C_748788599;
        } //End block
        checkStyle(style);
        DateFormatSymbols dfs = DateFormatSymbols.getInstance(locale);
switch(field){
        case AM_PM:
String[] var2C7D8C1D7EC09C33B550D70492D039D0_415997800 =         dfs.getAmPmStrings();
        var2C7D8C1D7EC09C33B550D70492D039D0_415997800.addTaint(taint);
        return var2C7D8C1D7EC09C33B550D70492D039D0_415997800;
        case DAY_OF_WEEK:
String[] varF6CACC25CE5B827DCE7468F91AF34D6B_319350077 =         (style == LONG) ? dfs.getWeekdays() : dfs.getShortWeekdays();
        varF6CACC25CE5B827DCE7468F91AF34D6B_319350077.addTaint(taint);
        return varF6CACC25CE5B827DCE7468F91AF34D6B_319350077;
        case ERA:
String[] var350CFA0A743C04A06FAAEBBC08D288F7_1207124337 =         dfs.getEras();
        var350CFA0A743C04A06FAAEBBC08D288F7_1207124337.addTaint(taint);
        return var350CFA0A743C04A06FAAEBBC08D288F7_1207124337;
        case MONTH:
String[] var02443F3A76AE487EA27B8DD484E529A8_142271410 =         (style == LONG) ? dfs.getMonths() : dfs.getShortMonths();
        var02443F3A76AE487EA27B8DD484E529A8_142271410.addTaint(taint);
        return var02443F3A76AE487EA27B8DD484E529A8_142271410;
}String[] var540C13E9E156B687226421B24F2DF178_1546029847 =         null;
        var540C13E9E156B687226421B24F2DF178_1546029847.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1546029847;
        // ---------- Original Method ----------
        //if (field < 0 || field >= FIELD_COUNT) {
            //throw new IllegalArgumentException("bad field " + field);
        //}
        //checkStyle(style);
        //DateFormatSymbols dfs = DateFormatSymbols.getInstance(locale);
        //switch (field) {
        //case AM_PM:
            //return dfs.getAmPmStrings();
        //case DAY_OF_WEEK:
            //return (style == LONG) ? dfs.getWeekdays() : dfs.getShortWeekdays();
        //case ERA:
            //return dfs.getEras();
        //case MONTH:
            //return (style == LONG) ? dfs.getMonths() : dfs.getShortMonths();
        //}
        //return null;
    }

    
    @DSModeled(DSC.SAFE)
    private static void checkStyle(int style) {
        if (style != ALL_STYLES && style != SHORT && style != LONG) {
            throw new IllegalArgumentException("bad style " + style);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.240 -0400", hash_original_method = "9C5842A520266160609E6030F348A85B", hash_generated_method = "6301677C85C93E4F2F6EB1E128606187")
    public Map<String, Integer> getDisplayNames(int field, int style, Locale locale) {
        addTaint(locale.getTaint());
        addTaint(style);
        addTaint(field);
        checkStyle(style);
        complete();
        Map<String, Integer> result = new HashMap<String, Integer>();
        if(style == SHORT || style == ALL_STYLES)        
        {
            insertValuesInMap(result, getDisplayNameArray(field, SHORT, locale));
        } //End block
        if(style == LONG || style == ALL_STYLES)        
        {
            insertValuesInMap(result, getDisplayNameArray(field, LONG, locale));
        } //End block
Map<String, Integer> varB60C0CCEE522AFD4A5CF89ECA4EFF4A9_1405135466 =         result.isEmpty() ? null : result;
        varB60C0CCEE522AFD4A5CF89ECA4EFF4A9_1405135466.addTaint(taint);
        return varB60C0CCEE522AFD4A5CF89ECA4EFF4A9_1405135466;
        // ---------- Original Method ----------
        //checkStyle(style);
        //complete();
        //Map<String, Integer> result = new HashMap<String, Integer>();
        //if (style == SHORT || style == ALL_STYLES) {
            //insertValuesInMap(result, getDisplayNameArray(field, SHORT, locale));
        //}
        //if (style == LONG || style == ALL_STYLES) {
            //insertValuesInMap(result, getDisplayNameArray(field, LONG, locale));
        //}
        //return result.isEmpty() ? null : result;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.241 -0400", hash_original_method = "B466F6EE281116CF7ABF0D209ADAF19B", hash_generated_method = "4E7102DAF281A059419DE4BA790DAD0B")
    private void writeObject(ObjectOutputStream stream) throws IOException {
        addTaint(stream.getTaint());
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
        // ---------- Original Method ----------
        //complete();
        //ObjectOutputStream.PutField putFields = stream.putFields();
        //putFields.put("areFieldsSet", areFieldsSet);
        //putFields.put("fields", this.fields);
        //putFields.put("firstDayOfWeek", firstDayOfWeek);
        //putFields.put("isSet", isSet);
        //putFields.put("isTimeSet", isTimeSet);
        //putFields.put("lenient", lenient);
        //putFields.put("minimalDaysInFirstWeek", minimalDaysInFirstWeek);
        //putFields.put("nextStamp", 2 );
        //putFields.put("serialVersionOnStream", 1);
        //putFields.put("time", time);
        //putFields.put("zone", zone);
        //stream.writeFields();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.241 -0400", hash_original_method = "8FB104B0DF4EC943895E45AF22309DC6", hash_generated_method = "B3ECB270A155681BF1211E2A8EED4CE4")
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        addTaint(stream.getTaint());
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
        // ---------- Original Method ----------
        //ObjectInputStream.GetField readFields = stream.readFields();
        //areFieldsSet = readFields.get("areFieldsSet", false);
        //this.fields = (int[]) readFields.get("fields", null);
        //firstDayOfWeek = readFields.get("firstDayOfWeek", Calendar.SUNDAY);
        //isSet = (boolean[]) readFields.get("isSet", null);
        //isTimeSet = readFields.get("isTimeSet", false);
        //lenient = readFields.get("lenient", true);
        //minimalDaysInFirstWeek = readFields.get("minimalDaysInFirstWeek", 1);
        //time = readFields.get("time", 0L);
        //zone = (TimeZone) readFields.get("zone", null);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.241 -0400", hash_original_field = "E4ADCFDCE60A36FBBABAF458C95395F2", hash_generated_field = "AF2E0A30DAA7888473F4B1DB6F9AB4E7")

    private static final long serialVersionUID = -1807547505821590642L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.241 -0400", hash_original_field = "B1229A2D5153650048BEFD13F7BB757E", hash_generated_field = "18EBE6A0EA775581ADAF9A3A3B4BDF43")

    public static final int JANUARY = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.241 -0400", hash_original_field = "DF6E031A8886FC157F2E29541B01EE84", hash_generated_field = "DE1A10C1CA4D58A0D0B71D5ED5651C5E")

    public static final int FEBRUARY = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.241 -0400", hash_original_field = "1F991F90B893DA0FC9B5E3150A0B31F5", hash_generated_field = "9A060A9F43E320077FEF91D7F3E16318")

    public static final int MARCH = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.242 -0400", hash_original_field = "DA7AFA3E579A805E2389B9F10AA6618A", hash_generated_field = "84082A64126E6ACD9A8A7166E76E4710")

    public static final int APRIL = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.242 -0400", hash_original_field = "9E16AFF2D9C7EF95B77DD5682A1FC27C", hash_generated_field = "2B49A74DDADD5147E334034FECF80F61")

    public static final int MAY = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.242 -0400", hash_original_field = "3B72053389DAC082B5AAA76E951054CF", hash_generated_field = "40AAE596E48BB3CE7DED4445B6CA7C3A")

    public static final int JUNE = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.242 -0400", hash_original_field = "DD80EBED669229240067FB0B5BBF69AB", hash_generated_field = "57C7088304F19819321C68C4EA4D43FE")

    public static final int JULY = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.242 -0400", hash_original_field = "B0E61FBAFCF5DEA331504C861F86D53F", hash_generated_field = "DD0287EC2BAD39C6AA0CB00681983E13")

    public static final int AUGUST = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.242 -0400", hash_original_field = "F972C9AE2AC61A777387E83C68708780", hash_generated_field = "65D9E0EA51CBB939F331D73F96E8F737")

    public static final int SEPTEMBER = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.242 -0400", hash_original_field = "76343C816DB5711F579A12DCB4F16B8E", hash_generated_field = "5F215B3F48DD52DCA5B05BB8683ACB9E")

    public static final int OCTOBER = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.242 -0400", hash_original_field = "FFCED4181918C72BF900A5CFE0673433", hash_generated_field = "07258F480C131FFB71C8F3192EC866BB")

    public static final int NOVEMBER = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.242 -0400", hash_original_field = "F343818DCC00004297FBA5987DA2AD48", hash_generated_field = "99346885877C320A88C5DEEF1FE5C6A1")

    public static final int DECEMBER = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.242 -0400", hash_original_field = "359C003D4D135BBA6F4DFF63171ED20E", hash_generated_field = "12CB74BD217D91F4A997C4A9B3204153")

    public static final int UNDECIMBER = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.242 -0400", hash_original_field = "6AB76E6F953EFCD0E4C19075388A01EE", hash_generated_field = "F91CDF25E1A1263D08DCDFDA293D2FF1")

    public static final int SUNDAY = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.242 -0400", hash_original_field = "A572F76B8BED75381557BFEF545691E3", hash_generated_field = "4F7898CDA37C0C1672B1DD0225C38742")

    public static final int MONDAY = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.242 -0400", hash_original_field = "5AE9E5F65075AE05DAC98F042ED1B0C3", hash_generated_field = "EE1E35179BDB284983C5FA3C4A5286FB")

    public static final int TUESDAY = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.242 -0400", hash_original_field = "FC721785B80C9BB5B5B7737C8BDFDCB7", hash_generated_field = "B8FE5FF93BBD24C3DBD1BA8DEAA957DF")

    public static final int WEDNESDAY = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.242 -0400", hash_original_field = "E43AB3070A1AA17CFEED597E61B5783E", hash_generated_field = "3D06389FD7761B49C580CD0426877E03")

    public static final int THURSDAY = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.242 -0400", hash_original_field = "056EABFCC97B0D1049792F9B61D89D7E", hash_generated_field = "6793376618E81D6864359810244D7454")

    public static final int FRIDAY = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.242 -0400", hash_original_field = "DDAB7B40FF68250D655CFF3E3B927C17", hash_generated_field = "F33B8115640CE7F59D68A9F20CAEB4A4")

    public static final int SATURDAY = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.242 -0400", hash_original_field = "B33A9FCD83A2AD2D2FCA2CF40C206330", hash_generated_field = "E301476B4E26DF25A92B3AA8A9107617")

    public static final int ERA = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.242 -0400", hash_original_field = "D6E0623B96D61F8FB44E4B0B5753B83A", hash_generated_field = "F11869056FDF683C955988AF5A0DDE34")

    public static final int YEAR = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.242 -0400", hash_original_field = "1C91793E51C3A9062D5AB3332AF15358", hash_generated_field = "7ADEC6D0CDDC20B12462876FAAA80E7F")

    public static final int MONTH = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.242 -0400", hash_original_field = "43752A09F94775E581B1768AA144D6FA", hash_generated_field = "C4712C77A935F7F8EF3A0FAB8653CD50")

    public static final int WEEK_OF_YEAR = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.243 -0400", hash_original_field = "9F122ED36CC75916396FA33C2C541D68", hash_generated_field = "4209CEA320055F2A79C871E83FA19ECD")

    public static final int WEEK_OF_MONTH = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.243 -0400", hash_original_field = "5217925A108CB1DA8D998F2579406C2E", hash_generated_field = "825B85B498FD03FCA906C87FB3805D32")

    public static final int DATE = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.243 -0400", hash_original_field = "70569F6DF5D781813A5CEBBA5E9D1535", hash_generated_field = "EFB6ACBBED425C9038C6D037D0082F4C")

    public static final int DAY_OF_MONTH = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.243 -0400", hash_original_field = "83BC272221DC69D1A6BECC23692E58F5", hash_generated_field = "DDAC1EE15C7150842AE212280B96B617")

    public static final int DAY_OF_YEAR = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.243 -0400", hash_original_field = "18A62D9917C05757630C3CE19504A956", hash_generated_field = "B5836DC3C1EA3C6522AC2F728E1D637D")

    public static final int DAY_OF_WEEK = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.243 -0400", hash_original_field = "69CBE771734DF1A3D673E2868456643B", hash_generated_field = "AECF12E2908165277F0D63DF571281C2")

    public static final int DAY_OF_WEEK_IN_MONTH = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.243 -0400", hash_original_field = "49058FE71FB9FF9EF0D3E1B42F68DEEF", hash_generated_field = "FE3FF3E1A88CE7F17CFA86C2FD588F3A")

    public static final int AM_PM = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.243 -0400", hash_original_field = "14812F95FBEF9C7C394F9A1730D3C99E", hash_generated_field = "EC0B014C2F8D2A70D0DC0E6595B16DC3")

    public static final int HOUR = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.243 -0400", hash_original_field = "6686B3199F3E3DB19B935AF46ED213F6", hash_generated_field = "A6B692656855E13B4647C887CB94655F")

    public static final int HOUR_OF_DAY = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.243 -0400", hash_original_field = "21EBB6113111BB763B80954D2295F080", hash_generated_field = "C1E0602297351F7BD222DD115F481FAA")

    public static final int MINUTE = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.243 -0400", hash_original_field = "1FDA3D33995DEFFD74BED4480C05C8A8", hash_generated_field = "50977DDBE62C0994013A6190F746E76D")

    public static final int SECOND = 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.243 -0400", hash_original_field = "4409B7EC99BB6E1567D784F859E571A7", hash_generated_field = "EBD943872B0DC03F8DA791205BB276E0")

    public static final int MILLISECOND = 14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.243 -0400", hash_original_field = "B8E966FD91FDCC398E806F4E026F8D9D", hash_generated_field = "CF6B5B33A8280CA15F32F4C409683BB7")

    public static final int ZONE_OFFSET = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.243 -0400", hash_original_field = "0287BF812603F678C22B6AE2BF88AD00", hash_generated_field = "5BC57F3FA8E3F55632AF6D9EE7639DD9")

    public static final int DST_OFFSET = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.243 -0400", hash_original_field = "B300B9E126DBB4375CE2F8EF37F91746", hash_generated_field = "C0AD90D0AE4AA2CE7973DC573EBDB44F")

    public static final int FIELD_COUNT = 17;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.243 -0400", hash_original_field = "146EDA96704CAE2AC584EEE531240256", hash_generated_field = "12DF7D953F2E794CDDBE44C8913E7D53")

    public static final int AM = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.243 -0400", hash_original_field = "3706AACC371BBC9704CA8C7AA3744E69", hash_generated_field = "8604262D117A4ECB98B8C2D2F8B21F35")

    public static final int PM = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.243 -0400", hash_original_field = "A3CA4814D4F89191EACA6945C3BBEE09", hash_generated_field = "FDDDB5A7AFE2EF5F55DA4077744BE025")

    public static final int ALL_STYLES = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.243 -0400", hash_original_field = "ECA0228AA5AC43C273D6A21201F7945C", hash_generated_field = "F7ACB78854980F98EB72B4076CEEC364")

    public static final int SHORT = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.243 -0400", hash_original_field = "0873C6DB80D32564A3F9A5C6FBDE5E65", hash_generated_field = "00D4EA5E2F513F125A8CCE9688DB12D7")

    public static final int LONG = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.243 -0400", hash_original_field = "2598ABE24AAF8554D19D3E3571DB67B3", hash_generated_field = "E98760CF948389324CD259C52EDE02C8")

    private static final String[] FIELD_NAMES = { "ERA", "YEAR", "MONTH",
            "WEEK_OF_YEAR", "WEEK_OF_MONTH", "DAY_OF_MONTH", "DAY_OF_YEAR",
            "DAY_OF_WEEK", "DAY_OF_WEEK_IN_MONTH", "AM_PM", "HOUR",
            "HOUR_OF_DAY", "MINUTE", "SECOND", "MILLISECOND",
            "ZONE_OFFSET", "DST_OFFSET" };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.244 -0400", hash_original_field = "CC170D6DBE61DAE7E0149B1156D53E16", hash_generated_field = "38D65C9058142C88025F5AD8AC8D9090")

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

