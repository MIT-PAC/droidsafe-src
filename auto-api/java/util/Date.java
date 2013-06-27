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
import java.io.Serializable;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import libcore.icu.LocaleData;

public class Date implements Serializable, Cloneable, Comparable<Date> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.400 -0400", hash_original_field = "C50C3B1CA82BA7B7AB55AFDF66A2F6C9", hash_generated_field = "6BC5295E2736F8077860853450F996C9")

    private transient long milliseconds;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.400 -0400", hash_original_method = "117F9B64DCE96B425DE39D6FF0E7C956", hash_generated_method = "B532C1831EBB14D72EFD726653EE6196")
    public  Date() {
        this(System.currentTimeMillis());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.400 -0400", hash_original_method = "1DCF8B1AF6198BC90A64E56405CA39AF", hash_generated_method = "42EBE80C16F2E61E26E7AF0BEE24E1E4")
    @Deprecated
    public  Date(int year, int month, int day) {
        GregorianCalendar cal;
        cal = new GregorianCalendar(false);
        cal.set(1900 + year, month, day);
        milliseconds = cal.getTimeInMillis();
        addTaint(year);
        addTaint(month);
        addTaint(day);
        // ---------- Original Method ----------
        //GregorianCalendar cal = new GregorianCalendar(false);
        //cal.set(1900 + year, month, day);
        //milliseconds = cal.getTimeInMillis();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.495 -0400", hash_original_method = "426C20A19A7753D3CB1FAC13BA7CC9BA", hash_generated_method = "8A443EF9AEB79D1D7A4B6CEDDBAB43BF")
    @Deprecated
    public  Date(int year, int month, int day, int hour, int minute) {
        GregorianCalendar cal;
        cal = new GregorianCalendar(false);
        cal.set(1900 + year, month, day, hour, minute);
        milliseconds = cal.getTimeInMillis();
        addTaint(year);
        addTaint(month);
        addTaint(day);
        addTaint(hour);
        addTaint(minute);
        // ---------- Original Method ----------
        //GregorianCalendar cal = new GregorianCalendar(false);
        //cal.set(1900 + year, month, day, hour, minute);
        //milliseconds = cal.getTimeInMillis();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.496 -0400", hash_original_method = "139F1B989333E9F68B465E1B19165668", hash_generated_method = "24B9FFF692253DB8843676AED6E96618")
    @Deprecated
    public  Date(int year, int month, int day, int hour, int minute, int second) {
        GregorianCalendar cal;
        cal = new GregorianCalendar(false);
        cal.set(1900 + year, month, day, hour, minute, second);
        milliseconds = cal.getTimeInMillis();
        addTaint(year);
        addTaint(month);
        addTaint(day);
        addTaint(hour);
        addTaint(minute);
        addTaint(second);
        // ---------- Original Method ----------
        //GregorianCalendar cal = new GregorianCalendar(false);
        //cal.set(1900 + year, month, day, hour, minute, second);
        //milliseconds = cal.getTimeInMillis();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.496 -0400", hash_original_method = "F91B8E0C111622A18C17EB4FC5AA472B", hash_generated_method = "E4592A518430609A4961F6175BC1CB09")
    public  Date(long milliseconds) {
        this.milliseconds = milliseconds;
        // ---------- Original Method ----------
        //this.milliseconds = milliseconds;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.497 -0400", hash_original_method = "2B1036AFFF9E6DD3B4220E3E27A88A34", hash_generated_method = "3AF303FF71AE81B5072ED58BCD6C559F")
    @Deprecated
    public  Date(String string) {
        milliseconds = parse(string);
        // ---------- Original Method ----------
        //milliseconds = parse(string);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.497 -0400", hash_original_method = "A5A1DDC35C23D543E612D23967A596DA", hash_generated_method = "0E217706AF9970235CC042AB798B83F9")
    public boolean after(Date date) {
        addTaint(date.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2016319979 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2016319979;
        // ---------- Original Method ----------
        //return milliseconds > date.milliseconds;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.497 -0400", hash_original_method = "EB21B83A31DD3DBD1842C230376F433E", hash_generated_method = "3380A074ED3BD9695503E6BFDCA112FA")
    public boolean before(Date date) {
        addTaint(date.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_601413855 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_601413855;
        // ---------- Original Method ----------
        //return milliseconds < date.milliseconds;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.498 -0400", hash_original_method = "0B6FE6D01B20019581445CB40F5DED3F", hash_generated_method = "5E933BD86D77B84B33498EE7E9120262")
    @Override
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_836855664 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_836855664 = super.clone();
        } //End block
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_836855664.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_836855664;
        // ---------- Original Method ----------
        //try {
            //return super.clone();
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.499 -0400", hash_original_method = "7C9742DC24BA8DF560999557E5DD5087", hash_generated_method = "EEE7A2AC557ECC880C3E311BB4319E1E")
    public int compareTo(Date date) {
        addTaint(date.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1117560034 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1117560034;
        // ---------- Original Method ----------
        //if (milliseconds < date.milliseconds) {
            //return -1;
        //}
        //if (milliseconds == date.milliseconds) {
            //return 0;
        //}
        //return 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.499 -0400", hash_original_method = "DDDF9262D80550B9DB77ACA0997BD3D6", hash_generated_method = "DB7559102EC209A6B544C196D9C79461")
    @Override
    public boolean equals(Object object) {
        boolean varEAE97717131044CA6F192EFDC5FF5D60_828167960 = ((object == this) || (object instanceof Date)
                && (milliseconds == ((Date) object).milliseconds));
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_331187632 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_331187632;
        // ---------- Original Method ----------
        //return (object == this) || (object instanceof Date)
                //&& (milliseconds == ((Date) object).milliseconds);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.499 -0400", hash_original_method = "9CDBB71B4B3C803B1AA8EE69EFD3E0ED", hash_generated_method = "2B9C79C6CF71D286087EC9288C6737CF")
    @Deprecated
    public int getDate() {
        int varC0A714720A6D4DAC31FEF058D8440CD7_1107700053 = (new GregorianCalendar(milliseconds).get(Calendar.DATE));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_29868558 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_29868558;
        // ---------- Original Method ----------
        //return new GregorianCalendar(milliseconds).get(Calendar.DATE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.500 -0400", hash_original_method = "A7B9A9C37FFBE4D61CB1113163F9DEB3", hash_generated_method = "E509ACEA3CEF9E3477110B855B1D1310")
    @Deprecated
    public int getDay() {
        int var3FE3B012F56C52737C59335A2FCB89A8_232781876 = (new GregorianCalendar(milliseconds).get(Calendar.DAY_OF_WEEK) - 1);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_284057675 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_284057675;
        // ---------- Original Method ----------
        //return new GregorianCalendar(milliseconds).get(Calendar.DAY_OF_WEEK) - 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.500 -0400", hash_original_method = "E9FAB79941832FB5BB28A56A75132611", hash_generated_method = "441B7EF1E93DC16A7A104CC4C5BCFB08")
    @Deprecated
    public int getHours() {
        int var4CFAA335C0802D591C180C590651DB9C_2111441519 = (new GregorianCalendar(milliseconds).get(Calendar.HOUR_OF_DAY));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_188708844 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_188708844;
        // ---------- Original Method ----------
        //return new GregorianCalendar(milliseconds).get(Calendar.HOUR_OF_DAY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.500 -0400", hash_original_method = "905F61D3BDD6A004D6695A8C4C0A588F", hash_generated_method = "14D539811109E603A5252585F63A2020")
    @Deprecated
    public int getMinutes() {
        int varB9975022E7FEA5A13782580C91D0E1A8_1198342128 = (new GregorianCalendar(milliseconds).get(Calendar.MINUTE));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1471727599 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1471727599;
        // ---------- Original Method ----------
        //return new GregorianCalendar(milliseconds).get(Calendar.MINUTE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.504 -0400", hash_original_method = "62BF86AE189F2A0680B405E29E252A59", hash_generated_method = "E773838C13D19E9D8BD39208C104814E")
    @Deprecated
    public int getMonth() {
        int varBFC3339A9B04E6CFC333A192D60231AA_2095755979 = (new GregorianCalendar(milliseconds).get(Calendar.MONTH));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1374839283 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1374839283;
        // ---------- Original Method ----------
        //return new GregorianCalendar(milliseconds).get(Calendar.MONTH);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.504 -0400", hash_original_method = "21461173A59BCEF943A6FBABC454A724", hash_generated_method = "CBEC1269EC0EE38EB958091C091A5E64")
    @Deprecated
    public int getSeconds() {
        int varA854ACC5DFBE36B1C5F437CD467A3D27_482120510 = (new GregorianCalendar(milliseconds).get(Calendar.SECOND));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1702791594 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1702791594;
        // ---------- Original Method ----------
        //return new GregorianCalendar(milliseconds).get(Calendar.SECOND);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.504 -0400", hash_original_method = "6634404A1A66BE1A7302C8A8E427A289", hash_generated_method = "92D9DAD3D3BE7742C8537F5715E802C6")
    public long getTime() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_721140285 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_721140285;
        // ---------- Original Method ----------
        //return milliseconds;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.504 -0400", hash_original_method = "1B1108BADA7A1EB96631D5AF2C5C5E87", hash_generated_method = "0C286D8F46ED680DEC3A4CB7682AF96B")
    @Deprecated
    public int getTimezoneOffset() {
        GregorianCalendar cal;
        cal = new GregorianCalendar(milliseconds);
        int varFFFB7142DA303EFC159034F99D5D2BAC_1327538576 = (-(cal.get(Calendar.ZONE_OFFSET) + cal.get(Calendar.DST_OFFSET)) / 60000);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1911385533 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1911385533;
        // ---------- Original Method ----------
        //GregorianCalendar cal = new GregorianCalendar(milliseconds);
        //return -(cal.get(Calendar.ZONE_OFFSET) + cal.get(Calendar.DST_OFFSET)) / 60000;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.510 -0400", hash_original_method = "C799A54F09693A95BB69288113BB6509", hash_generated_method = "D26FF5610D9DA229E8261E40BDBE41CB")
    @Deprecated
    public int getYear() {
        int var8A0F590C032321D56632D8913269C9D8_1954220194 = (new GregorianCalendar(milliseconds).get(Calendar.YEAR) - 1900);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2141968753 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2141968753;
        // ---------- Original Method ----------
        //return new GregorianCalendar(milliseconds).get(Calendar.YEAR) - 1900;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.510 -0400", hash_original_method = "B128FED5B5AAAF883404F36E34AD6524", hash_generated_method = "2B57E9B939E996449064F61FBAD7DCA3")
    @Override
    public int hashCode() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_720078369 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_720078369;
        // ---------- Original Method ----------
        //return (int) (milliseconds >>> 32) ^ (int) milliseconds;
    }

    
        private static int parse(String string, String[] array) {
        for (int i = 0, alength = array.length, slength = string.length(); i < alength; i++) {
            if (string.regionMatches(true, 0, array[i], 0, slength)) {
                return i;
            }
        }
        return -1;
    }

    
        @Deprecated
    public static long parse(String string) {
        if (string == null) {
            throw new IllegalArgumentException("The string argument is null");
        }
        char sign = 0;
        int commentLevel = 0;
        int offset = 0, length = string.length(), state = 0;
        int year = -1, month = -1, date = -1;
        int hour = -1, minute = -1, second = -1, zoneOffset = 0, minutesOffset = 0;
        boolean zone = false;
        final int PAD = 0, LETTERS = 1, NUMBERS = 2;
        StringBuilder buffer = new StringBuilder();
        while (offset <= length) {
            char next = offset < length ? string.charAt(offset) : '\r';
            offset++;
            if (next == '(') {
                commentLevel++;
            }
            if (commentLevel > 0) {
                if (next == ')') {
                    commentLevel--;
                }
                if (commentLevel == 0) {
                    next = ' ';
                } else {
                    continue;
                }
            }
            int nextState = PAD;
            if ('a' <= next && next <= 'z' || 'A' <= next && next <= 'Z') {
                nextState = LETTERS;
            } else if ('0' <= next && next <= '9') {
                nextState = NUMBERS;
            } else if (!Character.isSpace(next) && ",+-:/".indexOf(next) == -1) {
                throw new IllegalArgumentException();
            }
            if (state == NUMBERS && nextState != NUMBERS) {
                int digit = Integer.parseInt(buffer.toString());
                buffer.setLength(0);
                if (sign == '+' || sign == '-') {
                    if (zoneOffset == 0) {
                        zone = true;
                        if (next == ':') {
                            minutesOffset = sign == '-' ? -Integer
                                    .parseInt(string.substring(offset,
                                            offset + 2)) : Integer
                                    .parseInt(string.substring(offset,
                                            offset + 2));
                            offset += 2;
                        }
                        zoneOffset = sign == '-' ? -digit : digit;
                        sign = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else if (digit >= 70) {
                    if (year == -1
                            && (Character.isSpace(next) || next == ','
                                    || next == '/' || next == '\r')) {
                        year = digit;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else if (next == ':') {
                    if (hour == -1) {
                        hour = digit;
                    } else if (minute == -1) {
                        minute = digit;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else if (next == '/') {
                    if (month == -1) {
                        month = digit - 1;
                    } else if (date == -1) {
                        date = digit;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else if (Character.isSpace(next) || next == ','
                        || next == '-' || next == '\r') {
                    if (hour != -1 && minute == -1) {
                        minute = digit;
                    } else if (minute != -1 && second == -1) {
                        second = digit;
                    } else if (date == -1) {
                        date = digit;
                    } else if (year == -1) {
                        year = digit;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else if (year == -1 && month != -1 && date != -1) {
                    year = digit;
                } else {
                    throw new IllegalArgumentException();
                }
            } else if (state == LETTERS && nextState != LETTERS) {
                String text = buffer.toString().toUpperCase(Locale.US);
                buffer.setLength(0);
                if (text.length() == 1) {
                    throw new IllegalArgumentException();
                }
                if (text.equals("AM")) {
                    if (hour == 12) {
                        hour = 0;
                    } else if (hour < 1 || hour > 12) {
                        throw new IllegalArgumentException();
                    }
                } else if (text.equals("PM")) {
                    if (hour == 12) {
                        hour = 0;
                    } else if (hour < 1 || hour > 12) {
                        throw new IllegalArgumentException();
                    }
                    hour += 12;
                } else {
                    DateFormatSymbols symbols = new DateFormatSymbols(Locale.US);
                    String[] weekdays = symbols.getWeekdays(), months = symbols
                            .getMonths();
                    int value;
                    if (parse(text, weekdays) != -1) {
                    } else if (month == -1 && (month = parse(text, months)) != -1) {
                    } else if (text.equals("GMT") || text.equals("UT") || text.equals("UTC")) {
                        zone = true;
                        zoneOffset = 0;
                    } else if ((value = zone(text)) != 0) {
                        zone = true;
                        zoneOffset = value;
                    } else {
                        throw new IllegalArgumentException();
                    }
                }
            }
            if (next == '+' || (year != -1 && next == '-')) {
                sign = next;
            } else if (!Character.isSpace(next) && next != ','
                    && nextState != NUMBERS) {
                sign = 0;
            }
            if (nextState == LETTERS || nextState == NUMBERS) {
                buffer.append(next);
            }
            state = nextState;
        }
        if (year != -1 && month != -1 && date != -1) {
            if (hour == -1) {
                hour = 0;
            }
            if (minute == -1) {
                minute = 0;
            }
            if (second == -1) {
                second = 0;
            }
            if (year < (creationYear - 80)) {
                year += 2000;
            } else if (year < 100) {
                year += 1900;
            }
            minute -= minutesOffset;
            if (zone) {
                if (zoneOffset >= 24 || zoneOffset <= -24) {
                    hour -= zoneOffset / 100;
                    minute -= zoneOffset % 100;
                } else {
                    hour -= zoneOffset;
                }
                return UTC(year - 1900, month, date, hour, minute, second);
            }
            return new Date(year - 1900, month, date, hour, minute, second)
                    .getTime();
        }
        throw new IllegalArgumentException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.517 -0400", hash_original_method = "CA2D09B2D9B2F9BDCD2321E1B3353343", hash_generated_method = "6B2F4B21EBFF9F4B9A21D3AA8E527B8B")
    @Deprecated
    public void setDate(int day) {
        GregorianCalendar cal;
        cal = new GregorianCalendar(milliseconds);
        cal.set(Calendar.DATE, day);
        milliseconds = cal.getTimeInMillis();
        addTaint(day);
        // ---------- Original Method ----------
        //GregorianCalendar cal = new GregorianCalendar(milliseconds);
        //cal.set(Calendar.DATE, day);
        //milliseconds = cal.getTimeInMillis();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.524 -0400", hash_original_method = "DAB8B4072C80F91D1F54942852D0B029", hash_generated_method = "FFF93D7DE63A955C4A11813C998514DC")
    @Deprecated
    public void setHours(int hour) {
        GregorianCalendar cal;
        cal = new GregorianCalendar(milliseconds);
        cal.set(Calendar.HOUR_OF_DAY, hour);
        milliseconds = cal.getTimeInMillis();
        addTaint(hour);
        // ---------- Original Method ----------
        //GregorianCalendar cal = new GregorianCalendar(milliseconds);
        //cal.set(Calendar.HOUR_OF_DAY, hour);
        //milliseconds = cal.getTimeInMillis();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.524 -0400", hash_original_method = "9DC7826FE54BE20D0703E6C2CC9AB71D", hash_generated_method = "5ABDB5B66AB28427E045882AE29BB89B")
    @Deprecated
    public void setMinutes(int minute) {
        GregorianCalendar cal;
        cal = new GregorianCalendar(milliseconds);
        cal.set(Calendar.MINUTE, minute);
        milliseconds = cal.getTimeInMillis();
        addTaint(minute);
        // ---------- Original Method ----------
        //GregorianCalendar cal = new GregorianCalendar(milliseconds);
        //cal.set(Calendar.MINUTE, minute);
        //milliseconds = cal.getTimeInMillis();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.536 -0400", hash_original_method = "CBC4CDF52C0128D6B57913B17A16C753", hash_generated_method = "563D59F0BDCA70F29E2445E94ACFD858")
    @Deprecated
    public void setMonth(int month) {
        GregorianCalendar cal;
        cal = new GregorianCalendar(milliseconds);
        cal.set(Calendar.MONTH, month);
        milliseconds = cal.getTimeInMillis();
        addTaint(month);
        // ---------- Original Method ----------
        //GregorianCalendar cal = new GregorianCalendar(milliseconds);
        //cal.set(Calendar.MONTH, month);
        //milliseconds = cal.getTimeInMillis();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.537 -0400", hash_original_method = "2FB8CB70BDB70CDBCF22A1F179F9FAD0", hash_generated_method = "8D4AC931509D00634674B6EB8FE9C46E")
    @Deprecated
    public void setSeconds(int second) {
        GregorianCalendar cal;
        cal = new GregorianCalendar(milliseconds);
        cal.set(Calendar.SECOND, second);
        milliseconds = cal.getTimeInMillis();
        addTaint(second);
        // ---------- Original Method ----------
        //GregorianCalendar cal = new GregorianCalendar(milliseconds);
        //cal.set(Calendar.SECOND, second);
        //milliseconds = cal.getTimeInMillis();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.537 -0400", hash_original_method = "9E6A699B7F6421DBF4934C3ED6E82161", hash_generated_method = "1BF1F7F86998003806F58E7BCFC18FB0")
    public void setTime(long milliseconds) {
        this.milliseconds = milliseconds;
        // ---------- Original Method ----------
        //this.milliseconds = milliseconds;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.537 -0400", hash_original_method = "6618142CAD2C334ADC07B7799C053111", hash_generated_method = "BA0111D76D8891984B7057FB284000BA")
    @Deprecated
    public void setYear(int year) {
        GregorianCalendar cal;
        cal = new GregorianCalendar(milliseconds);
        cal.set(Calendar.YEAR, year + 1900);
        milliseconds = cal.getTimeInMillis();
        addTaint(year);
        // ---------- Original Method ----------
        //GregorianCalendar cal = new GregorianCalendar(milliseconds);
        //cal.set(Calendar.YEAR, year + 1900);
        //milliseconds = cal.getTimeInMillis();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.538 -0400", hash_original_method = "3D40A4C7B327D97106C4C4EC9B9A341F", hash_generated_method = "FB024166DE75E2DD2C9026DC602C857F")
    @Deprecated
    public String toGMTString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1152397573 = null; //Variable for return #1
        SimpleDateFormat sdf;
        sdf = new SimpleDateFormat("d MMM y HH:mm:ss 'GMT'", Locale.US);
        TimeZone gmtZone;
        gmtZone = TimeZone.getTimeZone("GMT");
        sdf.setTimeZone(gmtZone);
        GregorianCalendar gc;
        gc = new GregorianCalendar(gmtZone);
        gc.setTimeInMillis(milliseconds);
        varB4EAC82CA7396A68D541C85D26508E83_1152397573 = sdf.format(this);
        varB4EAC82CA7396A68D541C85D26508E83_1152397573.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1152397573;
        // ---------- Original Method ----------
        //SimpleDateFormat sdf = new SimpleDateFormat("d MMM y HH:mm:ss 'GMT'", Locale.US);
        //TimeZone gmtZone = TimeZone.getTimeZone("GMT");
        //sdf.setTimeZone(gmtZone);
        //GregorianCalendar gc = new GregorianCalendar(gmtZone);
        //gc.setTimeInMillis(milliseconds);
        //return sdf.format(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.538 -0400", hash_original_method = "D0CA357369B8BFBAFFC49AE023576C24", hash_generated_method = "6E3A3B788258357776BB6BAB43455AB5")
    @Deprecated
    public String toLocaleString() {
        String varB4EAC82CA7396A68D541C85D26508E83_79890835 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_79890835 = DateFormat.getDateTimeInstance().format(this);
        varB4EAC82CA7396A68D541C85D26508E83_79890835.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_79890835;
        // ---------- Original Method ----------
        //return DateFormat.getDateTimeInstance().format(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.539 -0400", hash_original_method = "6C5F0B4EE91530ACACAA7ACB374F6D90", hash_generated_method = "A78C5AE14070874E5BA563B3C6509145")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1048291857 = null; //Variable for return #1
        LocaleData localeData;
        localeData = LocaleData.get(Locale.US);
        Calendar cal;
        cal = new GregorianCalendar(milliseconds);
        TimeZone tz;
        tz = cal.getTimeZone();
        StringBuilder result;
        result = new StringBuilder();
        result.append(localeData.shortWeekdayNames[cal.get(Calendar.DAY_OF_WEEK)]);
        result.append(' ');
        result.append(localeData.shortMonthNames[cal.get(Calendar.MONTH)]);
        result.append(' ');
        appendTwoDigits(result, cal.get(Calendar.DAY_OF_MONTH));
        result.append(' ');
        appendTwoDigits(result, cal.get(Calendar.HOUR_OF_DAY));
        result.append(':');
        appendTwoDigits(result, cal.get(Calendar.MINUTE));
        result.append(':');
        appendTwoDigits(result, cal.get(Calendar.SECOND));
        result.append(' ');
        result.append(tz.getDisplayName(tz.inDaylightTime(this), TimeZone.SHORT));
        result.append(' ');
        result.append(cal.get(Calendar.YEAR));
        varB4EAC82CA7396A68D541C85D26508E83_1048291857 = result.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1048291857.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1048291857;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        private static void appendTwoDigits(StringBuilder sb, int n) {
        if (n < 10) {
            sb.append('0');
        }
        sb.append(n);
    }

    
        @Deprecated
    public static long UTC(int year, int month, int day, int hour, int minute,
            int second) {
        GregorianCalendar cal = new GregorianCalendar(false);
        cal.setTimeZone(TimeZone.getTimeZone("GMT"));
        cal.set(1900 + year, month, day, hour, minute, second);
        return cal.getTimeInMillis();
    }

    
        private static int zone(String text) {
        if (text.equals("EST")) {
            return -5;
        }
        if (text.equals("EDT")) {
            return -4;
        }
        if (text.equals("CST")) {
            return -6;
        }
        if (text.equals("CDT")) {
            return -5;
        }
        if (text.equals("MST")) {
            return -7;
        }
        if (text.equals("MDT")) {
            return -6;
        }
        if (text.equals("PST")) {
            return -8;
        }
        if (text.equals("PDT")) {
            return -7;
        }
        return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.546 -0400", hash_original_method = "A8D1E2059FF037BF4B3478BBC82EA0DD", hash_generated_method = "D941496548829BA80238A66E48377FDD")
    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeLong(getTime());
        addTaint(stream.getTaint());
        // ---------- Original Method ----------
        //stream.defaultWriteObject();
        //stream.writeLong(getTime());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.546 -0400", hash_original_method = "59F27179ED4F1C5D53DD2971937048C1", hash_generated_method = "169EA75C72F39D2155567E20EB5C4D83")
    private void readObject(ObjectInputStream stream) throws IOException,
            ClassNotFoundException {
        stream.defaultReadObject();
        setTime(stream.readLong());
        addTaint(stream.getTaint());
        // ---------- Original Method ----------
        //stream.defaultReadObject();
        //setTime(stream.readLong());
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.546 -0400", hash_original_field = "6DABAF8825E691BE8B32888DA82CE337", hash_generated_field = "1ED3C6A04E73692B15D262722B887799")

    private static long serialVersionUID = 7523967970034938905L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.546 -0400", hash_original_field = "4947AF7D9064A0E009DBEB30DF2F1525", hash_generated_field = "86DAAEAAB92B64CADF16DC4975B9F626")

    private static int creationYear = new Date().getYear();
}

