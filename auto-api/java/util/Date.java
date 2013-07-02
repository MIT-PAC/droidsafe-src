package java.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.682 -0400", hash_original_field = "C50C3B1CA82BA7B7AB55AFDF66A2F6C9", hash_generated_field = "6BC5295E2736F8077860853450F996C9")

    private transient long milliseconds;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.683 -0400", hash_original_method = "117F9B64DCE96B425DE39D6FF0E7C956", hash_generated_method = "B532C1831EBB14D72EFD726653EE6196")
    public  Date() {
        this(System.currentTimeMillis());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.683 -0400", hash_original_method = "1DCF8B1AF6198BC90A64E56405CA39AF", hash_generated_method = "9CA6C15E410426C21B190C8221186C3C")
    @Deprecated
    public  Date(int year, int month, int day) {
        GregorianCalendar cal = new GregorianCalendar(false);
        cal.set(1900 + year, month, day);
        milliseconds = cal.getTimeInMillis();
        addTaint(year);
        addTaint(month);
        addTaint(day);
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.683 -0400", hash_original_method = "426C20A19A7753D3CB1FAC13BA7CC9BA", hash_generated_method = "A374D7F66AD4F27C96E79FAF1658430B")
    @Deprecated
    public  Date(int year, int month, int day, int hour, int minute) {
        GregorianCalendar cal = new GregorianCalendar(false);
        cal.set(1900 + year, month, day, hour, minute);
        milliseconds = cal.getTimeInMillis();
        addTaint(year);
        addTaint(month);
        addTaint(day);
        addTaint(hour);
        addTaint(minute);
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.684 -0400", hash_original_method = "139F1B989333E9F68B465E1B19165668", hash_generated_method = "F24A41548F6E789B85B53926412E8454")
    @Deprecated
    public  Date(int year, int month, int day, int hour, int minute, int second) {
        GregorianCalendar cal = new GregorianCalendar(false);
        cal.set(1900 + year, month, day, hour, minute, second);
        milliseconds = cal.getTimeInMillis();
        addTaint(year);
        addTaint(month);
        addTaint(day);
        addTaint(hour);
        addTaint(minute);
        addTaint(second);
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.684 -0400", hash_original_method = "F91B8E0C111622A18C17EB4FC5AA472B", hash_generated_method = "E4592A518430609A4961F6175BC1CB09")
    public  Date(long milliseconds) {
        this.milliseconds = milliseconds;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.684 -0400", hash_original_method = "2B1036AFFF9E6DD3B4220E3E27A88A34", hash_generated_method = "3AF303FF71AE81B5072ED58BCD6C559F")
    @Deprecated
    public  Date(String string) {
        milliseconds = parse(string);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.685 -0400", hash_original_method = "A5A1DDC35C23D543E612D23967A596DA", hash_generated_method = "A706579DAA012F162D69B24553B0ECC5")
    public boolean after(Date date) {
        addTaint(date.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1144844212 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1144844212;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.685 -0400", hash_original_method = "EB21B83A31DD3DBD1842C230376F433E", hash_generated_method = "2CBF3B0EDB2E56C2F7C2BEBABF259C79")
    public boolean before(Date date) {
        addTaint(date.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_969375699 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_969375699;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.686 -0400", hash_original_method = "0B6FE6D01B20019581445CB40F5DED3F", hash_generated_method = "DB767528711EC3A6BB9E2EBBACD9B409")
    @Override
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_550801307 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_550801307 = super.clone();
        } 
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_550801307.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_550801307;
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.687 -0400", hash_original_method = "7C9742DC24BA8DF560999557E5DD5087", hash_generated_method = "B5DF5AE64C489FC3C6DF363242EA7BD9")
    public int compareTo(Date date) {
        addTaint(date.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1952891331 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1952891331;
        
        
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.689 -0400", hash_original_method = "DDDF9262D80550B9DB77ACA0997BD3D6", hash_generated_method = "342A9538C5BEC6118E8C630E2DB3248D")
    @Override
    public boolean equals(Object object) {
        boolean varEAE97717131044CA6F192EFDC5FF5D60_1858018187 = ((object == this) || (object instanceof Date)
                && (milliseconds == ((Date) object).milliseconds));
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1600671052 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1600671052;
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.690 -0400", hash_original_method = "9CDBB71B4B3C803B1AA8EE69EFD3E0ED", hash_generated_method = "257DEEDD6C1581919289FD310D8C4622")
    @Deprecated
    public int getDate() {
        int varC0A714720A6D4DAC31FEF058D8440CD7_146816356 = (new GregorianCalendar(milliseconds).get(Calendar.DATE));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1848272040 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1848272040;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.690 -0400", hash_original_method = "A7B9A9C37FFBE4D61CB1113163F9DEB3", hash_generated_method = "A37C1BCA1F06423A997372CD05CA6CF5")
    @Deprecated
    public int getDay() {
        int var3FE3B012F56C52737C59335A2FCB89A8_206608645 = (new GregorianCalendar(milliseconds).get(Calendar.DAY_OF_WEEK) - 1);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1600667917 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1600667917;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.691 -0400", hash_original_method = "E9FAB79941832FB5BB28A56A75132611", hash_generated_method = "0F0460BFA2E8659807D85C7EA1513DD7")
    @Deprecated
    public int getHours() {
        int var4CFAA335C0802D591C180C590651DB9C_1283744169 = (new GregorianCalendar(milliseconds).get(Calendar.HOUR_OF_DAY));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1257189745 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1257189745;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.691 -0400", hash_original_method = "905F61D3BDD6A004D6695A8C4C0A588F", hash_generated_method = "C0A86857DD8F0F5A7F46642105845EAA")
    @Deprecated
    public int getMinutes() {
        int varB9975022E7FEA5A13782580C91D0E1A8_790649195 = (new GregorianCalendar(milliseconds).get(Calendar.MINUTE));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1740926790 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1740926790;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.692 -0400", hash_original_method = "62BF86AE189F2A0680B405E29E252A59", hash_generated_method = "9195A740B65B1A66E5192C41D5B80528")
    @Deprecated
    public int getMonth() {
        int varBFC3339A9B04E6CFC333A192D60231AA_53612657 = (new GregorianCalendar(milliseconds).get(Calendar.MONTH));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_272476735 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_272476735;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.692 -0400", hash_original_method = "21461173A59BCEF943A6FBABC454A724", hash_generated_method = "16B1FAD5A338DEBD925349390F7D0A92")
    @Deprecated
    public int getSeconds() {
        int varA854ACC5DFBE36B1C5F437CD467A3D27_1332636397 = (new GregorianCalendar(milliseconds).get(Calendar.SECOND));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_543828832 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_543828832;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.693 -0400", hash_original_method = "6634404A1A66BE1A7302C8A8E427A289", hash_generated_method = "9397C246A3F8F27FAAE6800D14741624")
    public long getTime() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_660664982 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_660664982;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.693 -0400", hash_original_method = "1B1108BADA7A1EB96631D5AF2C5C5E87", hash_generated_method = "27F09F532B5C2C3098700FE5443623BB")
    @Deprecated
    public int getTimezoneOffset() {
        GregorianCalendar cal = new GregorianCalendar(milliseconds);
        int varFFFB7142DA303EFC159034F99D5D2BAC_1226754118 = (-(cal.get(Calendar.ZONE_OFFSET) + cal.get(Calendar.DST_OFFSET)) / 60000);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_280810894 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_280810894;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.693 -0400", hash_original_method = "C799A54F09693A95BB69288113BB6509", hash_generated_method = "FEF16BE53E6F0E4C284678294C4845CB")
    @Deprecated
    public int getYear() {
        int var8A0F590C032321D56632D8913269C9D8_256767287 = (new GregorianCalendar(milliseconds).get(Calendar.YEAR) - 1900);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1092949430 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1092949430;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.694 -0400", hash_original_method = "B128FED5B5AAAF883404F36E34AD6524", hash_generated_method = "ED33AACA2CE09F88A240B4C36C85418E")
    @Override
    public int hashCode() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_176407387 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_176407387;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    private static int parse(String string, String[] array) {
        for (int i = 0, alength = array.length, slength = string.length(); i < alength; i++) {
            if (string.regionMatches(true, 0, array[i], 0, slength)) {
                return i;
            }
        }
        return -1;
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.695 -0400", hash_original_method = "CA2D09B2D9B2F9BDCD2321E1B3353343", hash_generated_method = "1B11DDA4776A29207A0D2CC38EFE79E8")
    @Deprecated
    public void setDate(int day) {
        GregorianCalendar cal = new GregorianCalendar(milliseconds);
        cal.set(Calendar.DATE, day);
        milliseconds = cal.getTimeInMillis();
        addTaint(day);
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.695 -0400", hash_original_method = "DAB8B4072C80F91D1F54942852D0B029", hash_generated_method = "945B8907E86861BC403D6EB24E89E6F9")
    @Deprecated
    public void setHours(int hour) {
        GregorianCalendar cal = new GregorianCalendar(milliseconds);
        cal.set(Calendar.HOUR_OF_DAY, hour);
        milliseconds = cal.getTimeInMillis();
        addTaint(hour);
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.696 -0400", hash_original_method = "9DC7826FE54BE20D0703E6C2CC9AB71D", hash_generated_method = "5F36FAC0760FAEF6D4412306188FFE5E")
    @Deprecated
    public void setMinutes(int minute) {
        GregorianCalendar cal = new GregorianCalendar(milliseconds);
        cal.set(Calendar.MINUTE, minute);
        milliseconds = cal.getTimeInMillis();
        addTaint(minute);
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.696 -0400", hash_original_method = "CBC4CDF52C0128D6B57913B17A16C753", hash_generated_method = "03D145079BF3543D66A2C5F5D182D1B9")
    @Deprecated
    public void setMonth(int month) {
        GregorianCalendar cal = new GregorianCalendar(milliseconds);
        cal.set(Calendar.MONTH, month);
        milliseconds = cal.getTimeInMillis();
        addTaint(month);
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.697 -0400", hash_original_method = "2FB8CB70BDB70CDBCF22A1F179F9FAD0", hash_generated_method = "26544554C6B19F79A04B8A671F71A918")
    @Deprecated
    public void setSeconds(int second) {
        GregorianCalendar cal = new GregorianCalendar(milliseconds);
        cal.set(Calendar.SECOND, second);
        milliseconds = cal.getTimeInMillis();
        addTaint(second);
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.698 -0400", hash_original_method = "9E6A699B7F6421DBF4934C3ED6E82161", hash_generated_method = "1BF1F7F86998003806F58E7BCFC18FB0")
    public void setTime(long milliseconds) {
        this.milliseconds = milliseconds;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.699 -0400", hash_original_method = "6618142CAD2C334ADC07B7799C053111", hash_generated_method = "82A5E2F461DC7592283D1E31AD680DE1")
    @Deprecated
    public void setYear(int year) {
        GregorianCalendar cal = new GregorianCalendar(milliseconds);
        cal.set(Calendar.YEAR, year + 1900);
        milliseconds = cal.getTimeInMillis();
        addTaint(year);
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.700 -0400", hash_original_method = "3D40A4C7B327D97106C4C4EC9B9A341F", hash_generated_method = "B29305B64E1C60526F2A8937C1B65E98")
    @Deprecated
    public String toGMTString() {
        String varB4EAC82CA7396A68D541C85D26508E83_719009702 = null; 
        SimpleDateFormat sdf = new SimpleDateFormat("d MMM y HH:mm:ss 'GMT'", Locale.US);
        TimeZone gmtZone = TimeZone.getTimeZone("GMT");
        sdf.setTimeZone(gmtZone);
        GregorianCalendar gc = new GregorianCalendar(gmtZone);
        gc.setTimeInMillis(milliseconds);
        varB4EAC82CA7396A68D541C85D26508E83_719009702 = sdf.format(this);
        varB4EAC82CA7396A68D541C85D26508E83_719009702.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_719009702;
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.701 -0400", hash_original_method = "D0CA357369B8BFBAFFC49AE023576C24", hash_generated_method = "07C6269C13FB59D052C8B5F18717D545")
    @Deprecated
    public String toLocaleString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1851471745 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1851471745 = DateFormat.getDateTimeInstance().format(this);
        varB4EAC82CA7396A68D541C85D26508E83_1851471745.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1851471745;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.702 -0400", hash_original_method = "6C5F0B4EE91530ACACAA7ACB374F6D90", hash_generated_method = "A65C9EADC95B0C18A0F8C7AC081055AF")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_850331451 = null; 
        LocaleData localeData = LocaleData.get(Locale.US);
        Calendar cal = new GregorianCalendar(milliseconds);
        TimeZone tz = cal.getTimeZone();
        StringBuilder result = new StringBuilder();
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
        varB4EAC82CA7396A68D541C85D26508E83_850331451 = result.toString();
        varB4EAC82CA7396A68D541C85D26508E83_850331451.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_850331451;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    private static void appendTwoDigits(StringBuilder sb, int n) {
        if (n < 10) {
            sb.append('0');
        }
        sb.append(n);
    }

    
    @DSModeled(DSC.SAFE)
    @Deprecated
    public static long UTC(int year, int month, int day, int hour, int minute,
            int second) {
        GregorianCalendar cal = new GregorianCalendar(false);
        cal.setTimeZone(TimeZone.getTimeZone("GMT"));
        cal.set(1900 + year, month, day, hour, minute, second);
        return cal.getTimeInMillis();
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.704 -0400", hash_original_method = "A8D1E2059FF037BF4B3478BBC82EA0DD", hash_generated_method = "D941496548829BA80238A66E48377FDD")
    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeLong(getTime());
        addTaint(stream.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.704 -0400", hash_original_method = "59F27179ED4F1C5D53DD2971937048C1", hash_generated_method = "169EA75C72F39D2155567E20EB5C4D83")
    private void readObject(ObjectInputStream stream) throws IOException,
            ClassNotFoundException {
        stream.defaultReadObject();
        setTime(stream.readLong());
        addTaint(stream.getTaint());
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.704 -0400", hash_original_field = "6DABAF8825E691BE8B32888DA82CE337", hash_generated_field = "CD3049977F52AE47136F3048623BF2B1")

    private static final long serialVersionUID = 7523967970034938905L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.704 -0400", hash_original_field = "4947AF7D9064A0E009DBEB30DF2F1525", hash_generated_field = "86DAAEAAB92B64CADF16DC4975B9F626")

    private static int creationYear = new Date().getYear();
}

