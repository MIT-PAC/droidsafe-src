package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    protected boolean areFieldsSet;
    protected int[] fields;
    protected boolean[] isSet;
    protected boolean isTimeSet;
    protected long time;
    transient int lastTimeFieldSet;
    transient int lastDateFieldSet;
    private boolean lenient;
    private int firstDayOfWeek;
    private int minimalDaysInFirstWeek;
    private TimeZone zone;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.137 -0400", hash_original_method = "E09C10A5808D539238E77D59E7FF85D8", hash_generated_method = "374B305B1106BD03A7A9AA8CD5945D9E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected Calendar() {
        this(TimeZone.getDefault(), Locale.getDefault());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.137 -0400", hash_original_method = "88FEBE5E333C1748D0E9CCFA28BF3B86", hash_generated_method = "93E8F1FFA12BCD12B25C3A8CC8909194")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Calendar(TimeZone timezone) {
        dsTaint.addTaint(timezone.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.138 -0400", hash_original_method = "DC052852760F164E5EB6C2F703BBC41B", hash_generated_method = "F89A0AC6798E6D7FB5AD9ED7DAFCFD9B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected Calendar(TimeZone timezone, Locale locale) {
        this(timezone);
        dsTaint.addTaint(timezone.dsTaint);
        dsTaint.addTaint(locale.dsTaint);
        LocaleData localeData;
        localeData = LocaleData.get(locale);
        setFirstDayOfWeek(localeData.firstDayOfWeek.intValue());
        setMinimalDaysInFirstWeek(localeData.minimalDaysInFirstWeek.intValue());
        // ---------- Original Method ----------
        //LocaleData localeData = LocaleData.get(locale);
        //setFirstDayOfWeek(localeData.firstDayOfWeek.intValue());
        //setMinimalDaysInFirstWeek(localeData.minimalDaysInFirstWeek.intValue());
    }

    
    public abstract void add(int field, int value);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.138 -0400", hash_original_method = "3DBAFBF02CB3C60196FBCDD8387C90F7", hash_generated_method = "B53EA1FADA134EFCDA29B5C0710CB8A5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean after(Object calendar) {
        dsTaint.addTaint(calendar.dsTaint);
        boolean varC69694D50B41BAE5BC1E995D54AE5EB2_2016218540 = (getTimeInMillis() > ((Calendar) calendar).getTimeInMillis());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (!(calendar instanceof Calendar)) {
            //return false;
        //}
        //return getTimeInMillis() > ((Calendar) calendar).getTimeInMillis();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.138 -0400", hash_original_method = "AB514F7047FACF0A18BC971364ADD066", hash_generated_method = "50B8E02C63057191422DDBE3D12B8721")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean before(Object calendar) {
        dsTaint.addTaint(calendar.dsTaint);
        boolean var83CAF9DE4789CE7E9E62F32BABBA53AA_1124621675 = (getTimeInMillis() < ((Calendar) calendar).getTimeInMillis());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (!(calendar instanceof Calendar)) {
            //return false;
        //}
        //return getTimeInMillis() < ((Calendar) calendar).getTimeInMillis();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.138 -0400", hash_original_method = "A9FFD41082BBDB8FD2EC401621467C0D", hash_generated_method = "996D4F5CB7BEBBCD3FE2A50F9BD86702")
    @DSModeled(DSC.SAFE)
    public final void clear() {
        {
            int i;
            i = 0;
            {
                fields[i] = 0;
                isSet[i] = false;
            } //End block
        } //End collapsed parenthetic
        areFieldsSet = isTimeSet = false;
        // ---------- Original Method ----------
        //for (int i = 0; i < FIELD_COUNT; i++) {
            //fields[i] = 0;
            //isSet[i] = false;
        //}
        //areFieldsSet = isTimeSet = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.139 -0400", hash_original_method = "045ED04F1C7B7EFD467C2025674AC1C4", hash_generated_method = "A97FB52945ABEC8DB8A60FA8A8D7DE15")
    @DSModeled(DSC.SAFE)
    public final void clear(int field) {
        dsTaint.addTaint(field);
        fields[field] = 0;
        isSet[field] = false;
        areFieldsSet = isTimeSet = false;
        // ---------- Original Method ----------
        //fields[field] = 0;
        //isSet[field] = false;
        //areFieldsSet = isTimeSet = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.139 -0400", hash_original_method = "84D98F75151E4961D0916EA8CB3E0C38", hash_generated_method = "94A4FC6437AE28D2CDAD1BA44664554B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Object clone() {
        try 
        {
            Calendar clone;
            clone = (Calendar) super.clone();
            clone.fields = fields.clone();
            clone.isSet = isSet.clone();
            clone.zone = (TimeZone) zone.clone();
        } //End block
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
        } //End block
        return (Object)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.139 -0400", hash_original_method = "A716BA757DE54F1250A3DB16F903EEB4", hash_generated_method = "38F398104393574509E877BC41F9722F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void complete() {
        {
            computeTime();
            isTimeSet = true;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.140 -0400", hash_original_method = "A4F7F4EE453A4994C5225BE31C26C1E8", hash_generated_method = "92C5AA36B0C491279AB0A8CCED41BC05")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object object) {
        dsTaint.addTaint(object.dsTaint);
        Calendar cal;
        cal = (Calendar) object;
        boolean var3802D6DA9375599C027CD4D213836CB6_1770754866 = (getTimeInMillis() == cal.getTimeInMillis()
                && isLenient() == cal.isLenient()
                && getFirstDayOfWeek() == cal.getFirstDayOfWeek()
                && getMinimalDaysInFirstWeek() == cal
                        .getMinimalDaysInFirstWeek()
                && getTimeZone().equals(cal.getTimeZone()));
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.140 -0400", hash_original_method = "E826346499B559368BF751B42F34C786", hash_generated_method = "8F6F0F3380539373580CFC32254E2F60")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int get(int field) {
        dsTaint.addTaint(field);
        complete();
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //complete();
        //return fields[field];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.140 -0400", hash_original_method = "424E8E96F9A12B00FD5C6FDA146C325F", hash_generated_method = "2E1BB20B9538F0764E58C336057FE602")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getActualMaximum(int field) {
        dsTaint.addTaint(field);
        int value, next;
        {
            boolean var745F343A82DFDCC7FF827AFB1EBA87A3_389400187 = (getMaximum(field) == (next = getLeastMaximum(field)));
        } //End collapsed parenthetic
        complete();
        long orgTime;
        orgTime = time;
        set(field, next);
        {
            value = next;
            roll(field, true);
            next = get(field);
        } //End block
        time = orgTime;
        areFieldsSet = false;
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.140 -0400", hash_original_method = "598A84D60F29BB97F62226BCCD8A7F9E", hash_generated_method = "0C86B9B3521A4B9235FF4038064A3AD4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getActualMinimum(int field) {
        dsTaint.addTaint(field);
        int value, next;
        {
            boolean var0005FEA1504A60840E142CEC4FE92CFB_727087781 = (getMinimum(field) == (next = getGreatestMinimum(field)));
        } //End collapsed parenthetic
        complete();
        long orgTime;
        orgTime = time;
        set(field, next);
        {
            value = next;
            roll(field, false);
            next = get(field);
        } //End block
        time = orgTime;
        areFieldsSet = false;
        return dsTaint.getTaintInt();
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

    
        public static synchronized Locale[] getAvailableLocales() {
        return ICU.getAvailableCalendarLocales();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.141 -0400", hash_original_method = "2210DC8BCE617C61AD2F9503CE7923B1", hash_generated_method = "3AD2D9A95B6A1DE38BB8C71CDA85FE9A")
    @DSModeled(DSC.SAFE)
    public int getFirstDayOfWeek() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return firstDayOfWeek;
    }

    
    public abstract int getGreatestMinimum(int field);

    
        public static synchronized Calendar getInstance() {
        return new GregorianCalendar();
    }

    
        public static synchronized Calendar getInstance(Locale locale) {
        return new GregorianCalendar(locale);
    }

    
        public static synchronized Calendar getInstance(TimeZone timezone) {
        return new GregorianCalendar(timezone);
    }

    
        public static synchronized Calendar getInstance(TimeZone timezone, Locale locale) {
        return new GregorianCalendar(timezone, locale);
    }

    
    public abstract int getLeastMaximum(int field);

    
    public abstract int getMaximum(int field);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.142 -0400", hash_original_method = "104647FF062CF5167F06DB549E6DD4EB", hash_generated_method = "AF4864129D5CA143A148A0076F342874")
    @DSModeled(DSC.SAFE)
    public int getMinimalDaysInFirstWeek() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return minimalDaysInFirstWeek;
    }

    
    public abstract int getMinimum(int field);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.142 -0400", hash_original_method = "0D972793C1A81D3B5C0D23389B920FB5", hash_generated_method = "30F1DC07525AD83E8702F3337B6A6D11")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Date getTime() {
        Date varB983BF063908D17282121C79A6F49C45_564155706 = (new Date(getTimeInMillis()));
        return (Date)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new Date(getTimeInMillis());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.142 -0400", hash_original_method = "1B58DB6425011C7C1965B5C43056D530", hash_generated_method = "A7024A7E8BFB877180D4B7612E3ACF9D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getTimeInMillis() {
        {
            computeTime();
            isTimeSet = true;
        } //End block
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //if (!isTimeSet) {
            //computeTime();
            //isTimeSet = true;
        //}
        //return time;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.142 -0400", hash_original_method = "A62BA7A8B3AE52F44B15929DB0809596", hash_generated_method = "A97C2C7CA81230D93D53746B0B4390FF")
    @DSModeled(DSC.SAFE)
    public TimeZone getTimeZone() {
        return (TimeZone)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return zone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.143 -0400", hash_original_method = "2D54AA953826341AD4FD2AC42B53AEBA", hash_generated_method = "3061A645EE5336BE2543CB9A63752868")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int varBC7F165EFAFE0FDF940429CA89DC1BF8_385212552 = ((isLenient() ? 1237 : 1231) + getFirstDayOfWeek()
                + getMinimalDaysInFirstWeek() + getTimeZone().hashCode()); //DSFIXME:  CODE0008: Nested ternary operator in expression
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (isLenient() ? 1237 : 1231) + getFirstDayOfWeek()
                //+ getMinimalDaysInFirstWeek() + getTimeZone().hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.143 -0400", hash_original_method = "B2249A52847A00BE88915EAA81CF8D45", hash_generated_method = "225A9568BFE7C697BDA4FF66DED6F05A")
    @DSModeled(DSC.SAFE)
    protected final int internalGet(int field) {
        dsTaint.addTaint(field);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return fields[field];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.143 -0400", hash_original_method = "5DB017D3EE054B32EA01614D92601D4D", hash_generated_method = "023928762C8EFA31CE2415AACFAC9E0A")
    @DSModeled(DSC.SAFE)
    public boolean isLenient() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return lenient;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.143 -0400", hash_original_method = "295995F35CFAB02328483B566F7330CE", hash_generated_method = "6A27D6AB2D9C40851F9D953E18221C0F")
    @DSModeled(DSC.SAFE)
    public final boolean isSet(int field) {
        dsTaint.addTaint(field);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isSet[field];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.143 -0400", hash_original_method = "F5FA416393576D1F9DD8BCE9349020A6", hash_generated_method = "9B4D8181EED9A40DEDA51E802E6A750F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void roll(int field, int value) {
        dsTaint.addTaint(field);
        dsTaint.addTaint(value);
        boolean increment;
        increment = value >= 0;
        int count;
        count = value;
        count = -value;
        {
            int i;
            i = 0;
            {
                roll(field, increment);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //boolean increment = value >= 0;
        //int count = increment ? value : -value;
        //for (int i = 0; i < count; i++) {
            //roll(field, increment);
        //}
    }

    
    public abstract void roll(int field, boolean increment);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.144 -0400", hash_original_method = "41A9E001F522D5852F11FBD319F3A5A6", hash_generated_method = "5C2F5DC15C40E737ECCBEC3691C0C4D7")
    @DSModeled(DSC.SAFE)
    public void set(int field, int value) {
        dsTaint.addTaint(field);
        dsTaint.addTaint(value);
        fields[field] = value;
        isSet[field] = true;
        areFieldsSet = isTimeSet = false;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.144 -0400", hash_original_method = "E11C90BCB39036715964798223610892", hash_generated_method = "62A36446FBEFF73DD7820A52886AC585")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void set(int year, int month, int day) {
        dsTaint.addTaint(month);
        dsTaint.addTaint(year);
        dsTaint.addTaint(day);
        set(YEAR, year);
        set(MONTH, month);
        set(DATE, day);
        // ---------- Original Method ----------
        //set(YEAR, year);
        //set(MONTH, month);
        //set(DATE, day);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.144 -0400", hash_original_method = "B4EBEBE6ED320058BB13C1E33AF949E4", hash_generated_method = "310D8C7B52DBF5A7121C9D3F7E48009F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void set(int year, int month, int day, int hourOfDay,
            int minute) {
        dsTaint.addTaint(minute);
        dsTaint.addTaint(month);
        dsTaint.addTaint(year);
        dsTaint.addTaint(day);
        dsTaint.addTaint(hourOfDay);
        set(year, month, day);
        set(HOUR_OF_DAY, hourOfDay);
        set(MINUTE, minute);
        // ---------- Original Method ----------
        //set(year, month, day);
        //set(HOUR_OF_DAY, hourOfDay);
        //set(MINUTE, minute);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.144 -0400", hash_original_method = "071B019FF423902B33C61C7D7703D8F0", hash_generated_method = "DB3DACC4C769F569D44C4F4179E5B98C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void set(int year, int month, int day, int hourOfDay,
            int minute, int second) {
        dsTaint.addTaint(minute);
        dsTaint.addTaint(second);
        dsTaint.addTaint(month);
        dsTaint.addTaint(year);
        dsTaint.addTaint(day);
        dsTaint.addTaint(hourOfDay);
        set(year, month, day, hourOfDay, minute);
        set(SECOND, second);
        // ---------- Original Method ----------
        //set(year, month, day, hourOfDay, minute);
        //set(SECOND, second);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.145 -0400", hash_original_method = "9CEC56E07503C11B5926FEE82FE32939", hash_generated_method = "AB93C5DC9CA3C7F3C8BF4B948752ECE8")
    @DSModeled(DSC.SAFE)
    public void setFirstDayOfWeek(int value) {
        dsTaint.addTaint(value);
        // ---------- Original Method ----------
        //firstDayOfWeek = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.145 -0400", hash_original_method = "769D5CCA341B85723A2FDFB2D353BC44", hash_generated_method = "6229DAD69448003942850062AD07AE54")
    @DSModeled(DSC.SAFE)
    public void setLenient(boolean value) {
        dsTaint.addTaint(value);
        // ---------- Original Method ----------
        //lenient = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.145 -0400", hash_original_method = "ABF413A19C063DF72268F54419071447", hash_generated_method = "6789FC5CFDDDDAA44CA2A106AD793F07")
    @DSModeled(DSC.SAFE)
    public void setMinimalDaysInFirstWeek(int value) {
        dsTaint.addTaint(value);
        // ---------- Original Method ----------
        //minimalDaysInFirstWeek = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.145 -0400", hash_original_method = "8326734B6F30C707435A4BD203126230", hash_generated_method = "4FAA8F858DBC7F937CE82E7CBDEE3618")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void setTime(Date date) {
        dsTaint.addTaint(date.dsTaint);
        setTimeInMillis(date.getTime());
        // ---------- Original Method ----------
        //setTimeInMillis(date.getTime());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.145 -0400", hash_original_method = "2FA47445AF3A8C90A658A67E45128F41", hash_generated_method = "D85409460CE7FC00EC3A6C699429A0E6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTimeInMillis(long milliseconds) {
        dsTaint.addTaint(milliseconds);
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.145 -0400", hash_original_method = "C71A9CD315A030E06030733CE10A6247", hash_generated_method = "B94ABB3F2FA1C2DEADE97A45DA7793AD")
    @DSModeled(DSC.SAFE)
    public void setTimeZone(TimeZone timezone) {
        dsTaint.addTaint(timezone.dsTaint);
        areFieldsSet = false;
        // ---------- Original Method ----------
        //zone = timezone;
        //areFieldsSet = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.146 -0400", hash_original_method = "FE2881479678F103D2A9794655ED1F87", hash_generated_method = "EC863B6EDF00ABAEB3272DF49100D279")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        StringBuilder result;
        result = new StringBuilder(getClass().getName() +
                "[time=" + (isTimeSet ? String.valueOf(time) : "?") +
                ",areFieldsSet=" + areFieldsSet +
                ",lenient=" + lenient +
                ",zone=" + zone.getID() +
                ",firstDayOfWeek=" + firstDayOfWeek +
                ",minimalDaysInFirstWeek=" + minimalDaysInFirstWeek);//DSFIXME:  CODE0008: Nested ternary operator in expression
        {
            int i;
            i = 0;
            {
                result.append(',');
                result.append(FIELD_NAMES[i]);
                result.append('=');
                {
                    result.append(fields[i]);
                } //End block
                {
                    result.append('?');
                } //End block
            } //End block
        } //End collapsed parenthetic
        result.append(']');
        String varEA70154FDA28CC59402440C6317B57EF_724707766 = (result.toString());
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.146 -0400", hash_original_method = "91CA2BBC83B63568E9D66A64F5127506", hash_generated_method = "3D9002EF744F7741EB17346DAF93205E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int compareTo(Calendar anotherCalendar) {
        dsTaint.addTaint(anotherCalendar.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        long timeInMillis;
        timeInMillis = getTimeInMillis();
        long anotherTimeInMillis;
        anotherTimeInMillis = anotherCalendar.getTimeInMillis();
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.146 -0400", hash_original_method = "3943CE5519C03267AB2522359CAFDF8D", hash_generated_method = "70A54CF1C7D027771C85C51FCE74D23C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getDisplayName(int field, int style, Locale locale) {
        dsTaint.addTaint(field);
        dsTaint.addTaint(style);
        dsTaint.addTaint(locale.dsTaint);
        {
            style = SHORT;
        } //End block
        String[] array;
        array = getDisplayNameArray(field, style, locale);
        int value;
        value = get(field);
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (style == ALL_STYLES) {
            //style = SHORT;
        //}
        //String[] array = getDisplayNameArray(field, style, locale);
        //int value = get(field);
        //return (array != null) ? array[value] : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.147 -0400", hash_original_method = "23B9DFD5A49D248BECD0B5B67B00C262", hash_generated_method = "63A29976720E6D7B6E9D341B4D72FBFA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String[] getDisplayNameArray(int field, int style, Locale locale) {
        dsTaint.addTaint(field);
        dsTaint.addTaint(style);
        dsTaint.addTaint(locale.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("bad field " + field);
        } //End block
        checkStyle(style);
        DateFormatSymbols dfs;
        dfs = DateFormatSymbols.getInstance(locale);
        //Begin case AM_PM 
        String[] var94657DBCCC673371DAAEF3C06C13E439_1021057114 = (dfs.getAmPmStrings());
        //End case AM_PM 
        //Begin case DAY_OF_WEEK 
        {
            Object var18E3AFB56FDD884D02896129BF5E7AA6_1050145315 = (dfs.getWeekdays());
            Object var408F047F34D6268E39C81F4141361D3B_2144311889 = (dfs.getShortWeekdays());
        } //End flattened ternary
        //End case DAY_OF_WEEK 
        //Begin case ERA 
        String[] varE1B083EDFFAB9E20B873AEB3B6AB56E4_1081045131 = (dfs.getEras());
        //End case ERA 
        //Begin case MONTH 
        {
            Object var1CAECC5A44A60026DFDE2B7292C32CC2_1436436650 = (dfs.getMonths());
            Object var13E74B3595A58625BCDA52A19A2FE351_41591444 = (dfs.getShortMonths());
        } //End flattened ternary
        //End case MONTH 
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
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

    
        private static void checkStyle(int style) {
        if (style != ALL_STYLES && style != SHORT && style != LONG) {
            throw new IllegalArgumentException("bad style " + style);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.148 -0400", hash_original_method = "9C5842A520266160609E6030F348A85B", hash_generated_method = "83B5F63FC09A723478E167462D49C850")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Map<String, Integer> getDisplayNames(int field, int style, Locale locale) {
        dsTaint.addTaint(field);
        dsTaint.addTaint(style);
        dsTaint.addTaint(locale.dsTaint);
        checkStyle(style);
        complete();
        Map<String, Integer> result;
        result = new HashMap<String, Integer>();
        {
            insertValuesInMap(result, getDisplayNameArray(field, SHORT, locale));
        } //End block
        {
            insertValuesInMap(result, getDisplayNameArray(field, LONG, locale));
        } //End block
        {
            boolean var9F1BA72A2528ED972975BD3023E0E3C9_728109373 = (result.isEmpty());
        } //End flattened ternary
        return (Map<String, Integer>)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.148 -0400", hash_original_method = "B466F6EE281116CF7ABF0D209ADAF19B", hash_generated_method = "7890E609923D989F5B5B50C76075EBE4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void writeObject(ObjectOutputStream stream) throws IOException {
        dsTaint.addTaint(stream.dsTaint);
        complete();
        ObjectOutputStream.PutField putFields;
        putFields = stream.putFields();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.148 -0400", hash_original_method = "8FB104B0DF4EC943895E45AF22309DC6", hash_generated_method = "64C94C6B36F20CC457FBD9568C75DE30")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        dsTaint.addTaint(stream.dsTaint);
        ObjectInputStream.GetField readFields;
        readFields = stream.readFields();
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

    
    private static final long serialVersionUID = -1807547505821590642L;
    public static final int JANUARY = 0;
    public static final int FEBRUARY = 1;
    public static final int MARCH = 2;
    public static final int APRIL = 3;
    public static final int MAY = 4;
    public static final int JUNE = 5;
    public static final int JULY = 6;
    public static final int AUGUST = 7;
    public static final int SEPTEMBER = 8;
    public static final int OCTOBER = 9;
    public static final int NOVEMBER = 10;
    public static final int DECEMBER = 11;
    public static final int UNDECIMBER = 12;
    public static final int SUNDAY = 1;
    public static final int MONDAY = 2;
    public static final int TUESDAY = 3;
    public static final int WEDNESDAY = 4;
    public static final int THURSDAY = 5;
    public static final int FRIDAY = 6;
    public static final int SATURDAY = 7;
    public static final int ERA = 0;
    public static final int YEAR = 1;
    public static final int MONTH = 2;
    public static final int WEEK_OF_YEAR = 3;
    public static final int WEEK_OF_MONTH = 4;
    public static final int DATE = 5;
    public static final int DAY_OF_MONTH = 5;
    public static final int DAY_OF_YEAR = 6;
    public static final int DAY_OF_WEEK = 7;
    public static final int DAY_OF_WEEK_IN_MONTH = 8;
    public static final int AM_PM = 9;
    public static final int HOUR = 10;
    public static final int HOUR_OF_DAY = 11;
    public static final int MINUTE = 12;
    public static final int SECOND = 13;
    public static final int MILLISECOND = 14;
    public static final int ZONE_OFFSET = 15;
    public static final int DST_OFFSET = 16;
    public static final int FIELD_COUNT = 17;
    public static final int AM = 0;
    public static final int PM = 1;
    public static final int ALL_STYLES = 0;
    public static final int SHORT = 1;
    public static final int LONG = 2;
    private static final String[] FIELD_NAMES = { "ERA", "YEAR", "MONTH",
            "WEEK_OF_YEAR", "WEEK_OF_MONTH", "DAY_OF_MONTH", "DAY_OF_YEAR",
            "DAY_OF_WEEK", "DAY_OF_WEEK_IN_MONTH", "AM_PM", "HOUR",
            "HOUR_OF_DAY", "MINUTE", "SECOND", "MILLISECOND",
            "ZONE_OFFSET", "DST_OFFSET" };
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

