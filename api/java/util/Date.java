package java.util;

// Droidsafe Imports
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;

import libcore.icu.LocaleData;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class Date implements Serializable, Cloneable, Comparable<Date> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.071 -0400", hash_original_field = "C50C3B1CA82BA7B7AB55AFDF66A2F6C9", hash_generated_field = "6BC5295E2736F8077860853450F996C9")

    private transient long milliseconds;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.071 -0400", hash_original_method = "117F9B64DCE96B425DE39D6FF0E7C956", hash_generated_method = "B532C1831EBB14D72EFD726653EE6196")
    public  Date() {
        this(System.currentTimeMillis());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.072 -0400", hash_original_method = "1DCF8B1AF6198BC90A64E56405CA39AF", hash_generated_method = "C816810EFAF12567DFEF379FD00BD3EC")
    @Deprecated
    public  Date(int year, int month, int day) {
        addTaint(day);
        addTaint(month);
        addTaint(year);
        GregorianCalendar cal = new GregorianCalendar(false);
        cal.set(1900 + year, month, day);
        milliseconds = cal.getTimeInMillis();
        // ---------- Original Method ----------
        //GregorianCalendar cal = new GregorianCalendar(false);
        //cal.set(1900 + year, month, day);
        //milliseconds = cal.getTimeInMillis();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.072 -0400", hash_original_method = "426C20A19A7753D3CB1FAC13BA7CC9BA", hash_generated_method = "C46DE9D59F584A20197F00253F08E68A")
    @Deprecated
    public  Date(int year, int month, int day, int hour, int minute) {
        addTaint(minute);
        addTaint(hour);
        addTaint(day);
        addTaint(month);
        addTaint(year);
        GregorianCalendar cal = new GregorianCalendar(false);
        cal.set(1900 + year, month, day, hour, minute);
        milliseconds = cal.getTimeInMillis();
        // ---------- Original Method ----------
        //GregorianCalendar cal = new GregorianCalendar(false);
        //cal.set(1900 + year, month, day, hour, minute);
        //milliseconds = cal.getTimeInMillis();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.073 -0400", hash_original_method = "139F1B989333E9F68B465E1B19165668", hash_generated_method = "0EEF3FA43B9CE5E4B8C175E1BF11EA3A")
    @Deprecated
    public  Date(int year, int month, int day, int hour, int minute, int second) {
        addTaint(second);
        addTaint(minute);
        addTaint(hour);
        addTaint(day);
        addTaint(month);
        addTaint(year);
        GregorianCalendar cal = new GregorianCalendar(false);
        cal.set(1900 + year, month, day, hour, minute, second);
        milliseconds = cal.getTimeInMillis();
        // ---------- Original Method ----------
        //GregorianCalendar cal = new GregorianCalendar(false);
        //cal.set(1900 + year, month, day, hour, minute, second);
        //milliseconds = cal.getTimeInMillis();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.073 -0400", hash_original_method = "F91B8E0C111622A18C17EB4FC5AA472B", hash_generated_method = "E4592A518430609A4961F6175BC1CB09")
    public  Date(long milliseconds) {
        this.milliseconds = milliseconds;
        // ---------- Original Method ----------
        //this.milliseconds = milliseconds;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.074 -0400", hash_original_method = "2B1036AFFF9E6DD3B4220E3E27A88A34", hash_generated_method = "3AF303FF71AE81B5072ED58BCD6C559F")
    @Deprecated
    public  Date(String string) {
        milliseconds = parse(string);
        // ---------- Original Method ----------
        //milliseconds = parse(string);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.074 -0400", hash_original_method = "A5A1DDC35C23D543E612D23967A596DA", hash_generated_method = "B4FB08991C3901C37E5E28E9E23A86D7")
    public boolean after(Date date) {
        addTaint(date.getTaint());
        boolean varAA1B5AE06D7D8914F4C88F1B2B9CAF39_469541664 = (milliseconds > date.milliseconds);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_858065924 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_858065924;
        // ---------- Original Method ----------
        //return milliseconds > date.milliseconds;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.074 -0400", hash_original_method = "EB21B83A31DD3DBD1842C230376F433E", hash_generated_method = "27EF1F3A79D9A08119EB431ABDE73215")
    public boolean before(Date date) {
        addTaint(date.getTaint());
        boolean var8F37454CBE5A948B51DA3DDBC3CD8EF2_398190329 = (milliseconds < date.milliseconds);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1982976679 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1982976679;
        // ---------- Original Method ----------
        //return milliseconds < date.milliseconds;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.075 -0400", hash_original_method = "0B6FE6D01B20019581445CB40F5DED3F", hash_generated_method = "D4F5C4C25D6A85AF9286982644B11EA2")
    @Override
    public Object clone() {
        try 
        {
Object var46F3A0D86742C1D6E099C2B166941A33_858302775 =             super.clone();
            var46F3A0D86742C1D6E099C2B166941A33_858302775.addTaint(taint);
            return var46F3A0D86742C1D6E099C2B166941A33_858302775;
        } //End block
        catch (CloneNotSupportedException e)
        {
            AssertionError varA5A331D65C8C3F32D42E49D64BCF4109_1869770929 = new AssertionError(e);
            varA5A331D65C8C3F32D42E49D64BCF4109_1869770929.addTaint(taint);
            throw varA5A331D65C8C3F32D42E49D64BCF4109_1869770929;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return super.clone();
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError(e);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.075 -0400", hash_original_method = "7C9742DC24BA8DF560999557E5DD5087", hash_generated_method = "350D77143DE9E285289458D134410298")
    public int compareTo(Date date) {
        addTaint(date.getTaint());
        if(milliseconds < date.milliseconds)        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_1732476878 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_921617962 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_921617962;
        } //End block
        if(milliseconds == date.milliseconds)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_146880783 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1896176155 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1896176155;
        } //End block
        int varC4CA4238A0B923820DCC509A6F75849B_638628370 = (1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1591174651 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1591174651;
        // ---------- Original Method ----------
        //if (milliseconds < date.milliseconds) {
            //return -1;
        //}
        //if (milliseconds == date.milliseconds) {
            //return 0;
        //}
        //return 1;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.075 -0400", hash_original_method = "DDDF9262D80550B9DB77ACA0997BD3D6", hash_generated_method = "B7BFF23D494EB196EEAD39F7AAA53405")
    @Override
    public boolean equals(Object object) {
        addTaint(object.getTaint());
        boolean var304E96BA8859BEF715EA00BCBC092322_1620986901 = ((object == this) || (object instanceof Date)
                && (milliseconds == ((Date) object).milliseconds));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1072896322 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1072896322;
        // ---------- Original Method ----------
        //return (object == this) || (object instanceof Date)
                //&& (milliseconds == ((Date) object).milliseconds);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.076 -0400", hash_original_method = "9CDBB71B4B3C803B1AA8EE69EFD3E0ED", hash_generated_method = "7548E023529303DD2FEE2DE729245012")
    @Deprecated
    public int getDate() {
        int varE2F6EA00624EB60C2933E928C123A826_1668297217 = (new GregorianCalendar(milliseconds).get(Calendar.DATE));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1699954737 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1699954737;
        // ---------- Original Method ----------
        //return new GregorianCalendar(milliseconds).get(Calendar.DATE);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.076 -0400", hash_original_method = "A7B9A9C37FFBE4D61CB1113163F9DEB3", hash_generated_method = "8C519229911387FE56EE5852BA796DE2")
    @Deprecated
    public int getDay() {
        int varB2F8B9B398FDB94E56389833F5F3960F_1492619129 = (new GregorianCalendar(milliseconds).get(Calendar.DAY_OF_WEEK) - 1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_870968806 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_870968806;
        // ---------- Original Method ----------
        //return new GregorianCalendar(milliseconds).get(Calendar.DAY_OF_WEEK) - 1;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.076 -0400", hash_original_method = "E9FAB79941832FB5BB28A56A75132611", hash_generated_method = "A3863E8A017CCB79B4670FB1AAD985D3")
    @Deprecated
    public int getHours() {
        int var9F064158B6196C9FECB2CFB763A03009_696097967 = (new GregorianCalendar(milliseconds).get(Calendar.HOUR_OF_DAY));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1226458267 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1226458267;
        // ---------- Original Method ----------
        //return new GregorianCalendar(milliseconds).get(Calendar.HOUR_OF_DAY);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.077 -0400", hash_original_method = "905F61D3BDD6A004D6695A8C4C0A588F", hash_generated_method = "D09742B2E24A4C1D05745AA5D43FA662")
    @Deprecated
    public int getMinutes() {
        int var09A9E1FE99091EAD78E67B90E4CF4603_540036607 = (new GregorianCalendar(milliseconds).get(Calendar.MINUTE));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_649613374 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_649613374;
        // ---------- Original Method ----------
        //return new GregorianCalendar(milliseconds).get(Calendar.MINUTE);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.077 -0400", hash_original_method = "62BF86AE189F2A0680B405E29E252A59", hash_generated_method = "0B6B9A148C63BCEC1A6CAB784AD86E6E")
    @Deprecated
    public int getMonth() {
        int var637D8ACF7955DD157D716D483491F8C7_376683098 = (new GregorianCalendar(milliseconds).get(Calendar.MONTH));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1501498995 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1501498995;
        // ---------- Original Method ----------
        //return new GregorianCalendar(milliseconds).get(Calendar.MONTH);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.077 -0400", hash_original_method = "21461173A59BCEF943A6FBABC454A724", hash_generated_method = "295E4E924CE962E4F1D05D749A8B76B2")
    @Deprecated
    public int getSeconds() {
        int varE3AF7E687FBCFDC6C65FC46B025DC11D_773932685 = (new GregorianCalendar(milliseconds).get(Calendar.SECOND));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1725260717 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1725260717;
        // ---------- Original Method ----------
        //return new GregorianCalendar(milliseconds).get(Calendar.SECOND);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.077 -0400", hash_original_method = "6634404A1A66BE1A7302C8A8E427A289", hash_generated_method = "C0AA6CAE2B7AA6B213CB6E0E5805C361")
    public long getTime() {
        long varC50C3B1CA82BA7B7AB55AFDF66A2F6C9_844348592 = (milliseconds);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1885891521 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1885891521;
        // ---------- Original Method ----------
        //return milliseconds;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.078 -0400", hash_original_method = "1B1108BADA7A1EB96631D5AF2C5C5E87", hash_generated_method = "F628EA16D6A2892C878E38308C9861D5")
    @Deprecated
    public int getTimezoneOffset() {
        GregorianCalendar cal = new GregorianCalendar(milliseconds);
        int var802B628393FD498AF64B8F7FDD4E24EC_838482749 = (-(cal.get(Calendar.ZONE_OFFSET) + cal.get(Calendar.DST_OFFSET)) / 60000);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_247007216 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_247007216;
        // ---------- Original Method ----------
        //GregorianCalendar cal = new GregorianCalendar(milliseconds);
        //return -(cal.get(Calendar.ZONE_OFFSET) + cal.get(Calendar.DST_OFFSET)) / 60000;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.078 -0400", hash_original_method = "C799A54F09693A95BB69288113BB6509", hash_generated_method = "373BFB947E038DD1C7106A078EF3132C")
    @Deprecated
    public int getYear() {
        int var0889031199AB7E2784826BF4CFC13EBD_1429203123 = (new GregorianCalendar(milliseconds).get(Calendar.YEAR) - 1900);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_867262934 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_867262934;
        // ---------- Original Method ----------
        //return new GregorianCalendar(milliseconds).get(Calendar.YEAR) - 1900;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.078 -0400", hash_original_method = "B128FED5B5AAAF883404F36E34AD6524", hash_generated_method = "33B898352114790981A8E5393B76C0BF")
    @Override
    public int hashCode() {
        int var4163CD569649CA0E044A164821F626CA_1329220723 = ((int) (milliseconds >>> 32) ^ (int) milliseconds);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_355087273 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_355087273;
        // ---------- Original Method ----------
        //return (int) (milliseconds >>> 32) ^ (int) milliseconds;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.080 -0400", hash_original_method = "CA2D09B2D9B2F9BDCD2321E1B3353343", hash_generated_method = "DA077A0D31A4BA0D3A346A9E0AEF6438")
    @Deprecated
    public void setDate(int day) {
        addTaint(day);
        GregorianCalendar cal = new GregorianCalendar(milliseconds);
        cal.set(Calendar.DATE, day);
        milliseconds = cal.getTimeInMillis();
        // ---------- Original Method ----------
        //GregorianCalendar cal = new GregorianCalendar(milliseconds);
        //cal.set(Calendar.DATE, day);
        //milliseconds = cal.getTimeInMillis();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.080 -0400", hash_original_method = "DAB8B4072C80F91D1F54942852D0B029", hash_generated_method = "B11ACABE13F801BC574E053B51DA69D4")
    @Deprecated
    public void setHours(int hour) {
        addTaint(hour);
        GregorianCalendar cal = new GregorianCalendar(milliseconds);
        cal.set(Calendar.HOUR_OF_DAY, hour);
        milliseconds = cal.getTimeInMillis();
        // ---------- Original Method ----------
        //GregorianCalendar cal = new GregorianCalendar(milliseconds);
        //cal.set(Calendar.HOUR_OF_DAY, hour);
        //milliseconds = cal.getTimeInMillis();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.080 -0400", hash_original_method = "9DC7826FE54BE20D0703E6C2CC9AB71D", hash_generated_method = "E11785CDF9D9F05B15453AB54645991F")
    @Deprecated
    public void setMinutes(int minute) {
        addTaint(minute);
        GregorianCalendar cal = new GregorianCalendar(milliseconds);
        cal.set(Calendar.MINUTE, minute);
        milliseconds = cal.getTimeInMillis();
        // ---------- Original Method ----------
        //GregorianCalendar cal = new GregorianCalendar(milliseconds);
        //cal.set(Calendar.MINUTE, minute);
        //milliseconds = cal.getTimeInMillis();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.081 -0400", hash_original_method = "CBC4CDF52C0128D6B57913B17A16C753", hash_generated_method = "5581F73EB4432E64C6D2D5915F8F1A10")
    @Deprecated
    public void setMonth(int month) {
        addTaint(month);
        GregorianCalendar cal = new GregorianCalendar(milliseconds);
        cal.set(Calendar.MONTH, month);
        milliseconds = cal.getTimeInMillis();
        // ---------- Original Method ----------
        //GregorianCalendar cal = new GregorianCalendar(milliseconds);
        //cal.set(Calendar.MONTH, month);
        //milliseconds = cal.getTimeInMillis();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.081 -0400", hash_original_method = "2FB8CB70BDB70CDBCF22A1F179F9FAD0", hash_generated_method = "2E48A606A8BD86D8FE7CE0775B93E2AD")
    @Deprecated
    public void setSeconds(int second) {
        addTaint(second);
        GregorianCalendar cal = new GregorianCalendar(milliseconds);
        cal.set(Calendar.SECOND, second);
        milliseconds = cal.getTimeInMillis();
        // ---------- Original Method ----------
        //GregorianCalendar cal = new GregorianCalendar(milliseconds);
        //cal.set(Calendar.SECOND, second);
        //milliseconds = cal.getTimeInMillis();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.082 -0400", hash_original_method = "9E6A699B7F6421DBF4934C3ED6E82161", hash_generated_method = "1BF1F7F86998003806F58E7BCFC18FB0")
    public void setTime(long milliseconds) {
        this.milliseconds = milliseconds;
        // ---------- Original Method ----------
        //this.milliseconds = milliseconds;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.083 -0400", hash_original_method = "6618142CAD2C334ADC07B7799C053111", hash_generated_method = "3CD42C19705E3A34126FF41C6BFD9EA8")
    @Deprecated
    public void setYear(int year) {
        addTaint(year);
        GregorianCalendar cal = new GregorianCalendar(milliseconds);
        cal.set(Calendar.YEAR, year + 1900);
        milliseconds = cal.getTimeInMillis();
        // ---------- Original Method ----------
        //GregorianCalendar cal = new GregorianCalendar(milliseconds);
        //cal.set(Calendar.YEAR, year + 1900);
        //milliseconds = cal.getTimeInMillis();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.083 -0400", hash_original_method = "3D40A4C7B327D97106C4C4EC9B9A341F", hash_generated_method = "FF4B358DC56B7DD027472E96F1EB50DD")
    @Deprecated
    public String toGMTString() {
        SimpleDateFormat sdf = new SimpleDateFormat("d MMM y HH:mm:ss 'GMT'", Locale.US);
        TimeZone gmtZone = TimeZone.getTimeZone("GMT");
        sdf.setTimeZone(gmtZone);
        GregorianCalendar gc = new GregorianCalendar(gmtZone);
        gc.setTimeInMillis(milliseconds);
String var3D3DAAC9586EC28FD8E8B7CAD3910303_1563927932 =         sdf.format(this);
        var3D3DAAC9586EC28FD8E8B7CAD3910303_1563927932.addTaint(taint);
        return var3D3DAAC9586EC28FD8E8B7CAD3910303_1563927932;
        // ---------- Original Method ----------
        //SimpleDateFormat sdf = new SimpleDateFormat("d MMM y HH:mm:ss 'GMT'", Locale.US);
        //TimeZone gmtZone = TimeZone.getTimeZone("GMT");
        //sdf.setTimeZone(gmtZone);
        //GregorianCalendar gc = new GregorianCalendar(gmtZone);
        //gc.setTimeInMillis(milliseconds);
        //return sdf.format(this);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.084 -0400", hash_original_method = "D0CA357369B8BFBAFFC49AE023576C24", hash_generated_method = "D03688DE97F1B6D19CD1669476537699")
    @Deprecated
    public String toLocaleString() {
String varB49EBA2640DE06D41F94611F3DCCEEA9_665240744 =         DateFormat.getDateTimeInstance().format(this);
        varB49EBA2640DE06D41F94611F3DCCEEA9_665240744.addTaint(taint);
        return varB49EBA2640DE06D41F94611F3DCCEEA9_665240744;
        // ---------- Original Method ----------
        //return DateFormat.getDateTimeInstance().format(this);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.084 -0400", hash_original_method = "6C5F0B4EE91530ACACAA7ACB374F6D90", hash_generated_method = "EAD6691D4AFD0CDEA554E449B43095F0")
    @Override
    public String toString() {
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
String varE65B3A02759122992CB82C0E651AD408_1060799798 =         result.toString();
        varE65B3A02759122992CB82C0E651AD408_1060799798.addTaint(taint);
        return varE65B3A02759122992CB82C0E651AD408_1060799798;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.086 -0400", hash_original_method = "A8D1E2059FF037BF4B3478BBC82EA0DD", hash_generated_method = "0AC5220109B8F6AD62B51D88635F7C8C")
    private void writeObject(ObjectOutputStream stream) throws IOException {
        addTaint(stream.getTaint());
        stream.defaultWriteObject();
        stream.writeLong(getTime());
        // ---------- Original Method ----------
        //stream.defaultWriteObject();
        //stream.writeLong(getTime());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.086 -0400", hash_original_method = "59F27179ED4F1C5D53DD2971937048C1", hash_generated_method = "BE1A0AEAD9A5F8FAF1B8C4997D3688D3")
    private void readObject(ObjectInputStream stream) throws IOException,
            ClassNotFoundException {
        addTaint(stream.getTaint());
        stream.defaultReadObject();
        setTime(stream.readLong());
        // ---------- Original Method ----------
        //stream.defaultReadObject();
        //setTime(stream.readLong());
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.086 -0400", hash_original_field = "6DABAF8825E691BE8B32888DA82CE337", hash_generated_field = "CD3049977F52AE47136F3048623BF2B1")

    private static final long serialVersionUID = 7523967970034938905L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.086 -0400", hash_original_field = "4947AF7D9064A0E009DBEB30DF2F1525", hash_generated_field = "86DAAEAAB92B64CADF16DC4975B9F626")

    private static int creationYear = new Date().getYear();
}

