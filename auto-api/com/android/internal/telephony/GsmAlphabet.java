package com.android.internal.telephony;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import com.android.internal.R;
import java.util.ArrayList;
import java.util.List;
import static android.telephony.SmsMessage.ENCODING_7BIT;
import static android.telephony.SmsMessage.MAX_USER_DATA_SEPTETS;
import static android.telephony.SmsMessage.MAX_USER_DATA_SEPTETS_WITH_HEADER;

public class GsmAlphabet {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.229 -0400", hash_original_method = "ACEB66A7A5EB57C667A16876F7FFD7A1", hash_generated_method = "9D914C4804B753FB0D925E0024275993")
    private  GsmAlphabet() {
        
    }

    
    @DSModeled(DSC.SAFE)
    public static int charToGsm(char c) {
        try {
            return charToGsm(c, false);
        } catch (EncodeException ex) {
            return sCharsToGsmTables[0].get(' ', ' ');
        }
    }

    
    @DSModeled(DSC.SAFE)
    public static int charToGsm(char c, boolean throwException) throws EncodeException {
        int ret;
        ret = sCharsToGsmTables[0].get(c, -1);
        if (ret == -1) {
            ret = sCharsToShiftTables[0].get(c, -1);
            if (ret == -1) {
                if (throwException) {
                    throw new EncodeException(c);
                } else {
                    return sCharsToGsmTables[0].get(' ', ' ');
                }
            } else {
                return GSM_EXTENDED_ESCAPE;
            }
        }
        return ret;
    }

    
    @DSModeled(DSC.SAFE)
    public static int charToGsmExtended(char c) {
        int ret;
        ret = sCharsToShiftTables[0].get(c, -1);
        if (ret == -1) {
            return sCharsToGsmTables[0].get(' ', ' ');
        }
        return ret;
    }

    
    @DSModeled(DSC.SAFE)
    public static char gsmToChar(int gsmChar) {
        if (gsmChar >= 0 && gsmChar < 128) {
            return sLanguageTables[0].charAt(gsmChar);
        } else {
            return ' ';
        }
    }

    
    @DSModeled(DSC.SAFE)
    public static char gsmExtendedToChar(int gsmChar) {
        if (gsmChar == GSM_EXTENDED_ESCAPE) {
            return ' ';
        } else if (gsmChar >= 0 && gsmChar < 128) {
            char c = sLanguageShiftTables[0].charAt(gsmChar);
            if (c == ' ') {
                return sLanguageTables[0].charAt(gsmChar);
            } else {
                return c;
            }
        } else {
            return ' ';     
        }
    }

    
    @DSModeled(DSC.SAFE)
    public static byte[] stringToGsm7BitPackedWithHeader(String data, byte[] header) throws EncodeException {
        return stringToGsm7BitPackedWithHeader(data, header, 0, 0);
    }

    
    @DSModeled(DSC.SAFE)
    public static byte[] stringToGsm7BitPackedWithHeader(String data, byte[] header,
            int languageTable, int languageShiftTable) throws EncodeException {
        if (header == null || header.length == 0) {
            return stringToGsm7BitPacked(data, languageTable, languageShiftTable);
        }
        int headerBits = (header.length + 1) * 8;
        int headerSeptets = (headerBits + 6) / 7;
        byte[] ret = stringToGsm7BitPacked(data, headerSeptets, true, languageTable,
                languageShiftTable);
        ret[1] = (byte)header.length;
        System.arraycopy(header, 0, ret, 2, header.length);
        return ret;
    }

    
    @DSModeled(DSC.SAFE)
    public static byte[] stringToGsm7BitPacked(String data) throws EncodeException {
        return stringToGsm7BitPacked(data, 0, true, 0, 0);
    }

    
    @DSModeled(DSC.SAFE)
    public static byte[] stringToGsm7BitPacked(String data, int languageTable,
            int languageShiftTable) throws EncodeException {
        return stringToGsm7BitPacked(data, 0, true, languageTable, languageShiftTable);
    }

    
    @DSModeled(DSC.SAFE)
    public static byte[] stringToGsm7BitPacked(String data, int startingSeptetOffset,
            boolean throwException, int languageTable, int languageShiftTable) throws EncodeException {
        int dataLen = data.length();
        int septetCount = countGsmSeptetsUsingTables(data, !throwException,
                languageTable, languageShiftTable);
        if (septetCount == -1) {
            throw new EncodeException("countGsmSeptetsUsingTables(): unencodable char");
        }
        septetCount += startingSeptetOffset;
        if (septetCount > 255) {
            throw new EncodeException("Payload cannot exceed 255 septets");
        }
        int byteCount = ((septetCount * 7) + 7) / 8;
        byte[] ret = new byte[byteCount + 1];
        SparseIntArray charToLanguageTable = sCharsToGsmTables[languageTable];
        SparseIntArray charToShiftTable = sCharsToShiftTables[languageShiftTable];
        for (int i = 0, septets = startingSeptetOffset, bitOffset = startingSeptetOffset * 7;
                 i < dataLen && septets < septetCount;
                 i++, bitOffset += 7) {
            char c = data.charAt(i);
            int v = charToLanguageTable.get(c, -1);
            if (v == -1) {
                v = charToShiftTable.get(c, -1);  
                if (v == -1) {
                    if (throwException) {
                        throw new EncodeException("stringToGsm7BitPacked(): unencodable char");
                    } else {
                        v = charToLanguageTable.get(' ', ' ');   
                    }
                } else {
                    packSmsChar(ret, bitOffset, GSM_EXTENDED_ESCAPE);
                    bitOffset += 7;
                    septets++;
                }
            }
            packSmsChar(ret, bitOffset, v);
            septets++;
        }
        ret[0] = (byte) (septetCount);
        return ret;
    }

    
    @DSModeled(DSC.SAFE)
    private static void packSmsChar(byte[] packedChars, int bitOffset, int value) {
        int byteOffset = bitOffset / 8;
        int shift = bitOffset % 8;
        packedChars[++byteOffset] |= value << shift;
        if (shift > 1) {
            packedChars[++byteOffset] = (byte)(value >> (8 - shift));
        }
    }

    
    @DSModeled(DSC.SAFE)
    public static String gsm7BitPackedToString(byte[] pdu, int offset,
            int lengthSeptets) {
        return gsm7BitPackedToString(pdu, offset, lengthSeptets, 0, 0, 0);
    }

    
    @DSModeled(DSC.SAFE)
    public static String gsm7BitPackedToString(byte[] pdu, int offset,
            int lengthSeptets, int numPaddingBits, int languageTable, int shiftTable) {
        StringBuilder ret = new StringBuilder(lengthSeptets);
        if (languageTable < 0 || languageTable > sLanguageTables.length) {
            Log.w(TAG, "unknown language table " + languageTable + ", using default");
            languageTable = 0;
        }
        if (shiftTable < 0 || shiftTable > sLanguageShiftTables.length) {
            Log.w(TAG, "unknown single shift table " + shiftTable + ", using default");
            shiftTable = 0;
        }
        try {
            boolean prevCharWasEscape = false;
            String languageTableToChar = sLanguageTables[languageTable];
            String shiftTableToChar = sLanguageShiftTables[shiftTable];
            if (languageTableToChar.isEmpty()) {
                Log.w(TAG, "no language table for code " + languageTable + ", using default");
                languageTableToChar = sLanguageTables[0];
            }
            if (shiftTableToChar.isEmpty()) {
                Log.w(TAG, "no single shift table for code " + shiftTable + ", using default");
                shiftTableToChar = sLanguageShiftTables[0];
            }
            for (int i = 0 ; i < lengthSeptets ; i++) {
                int bitOffset = (7 * i) + numPaddingBits;
                int byteOffset = bitOffset / 8;
                int shift = bitOffset % 8;
                int gsmVal;
                gsmVal = (0x7f & (pdu[offset + byteOffset] >> shift));
                if (shift > 1) {
                    gsmVal &= 0x7f >> (shift - 1);
                    gsmVal |= 0x7f & (pdu[offset + byteOffset + 1] << (8 - shift));
                }
                if (prevCharWasEscape) {
                    if (gsmVal == GSM_EXTENDED_ESCAPE) {
                        ret.append(' ');    
                    } else {
                        char c = shiftTableToChar.charAt(gsmVal);
                        if (c == ' ') {
                            ret.append(languageTableToChar.charAt(gsmVal));
                        } else {
                            ret.append(c);
                        }
                    }
                    prevCharWasEscape = false;
                } else if (gsmVal == GSM_EXTENDED_ESCAPE) {
                    prevCharWasEscape = true;
                } else {
                    ret.append(languageTableToChar.charAt(gsmVal));
                }
            }
        } catch (RuntimeException ex) {
            Log.e(TAG, "Error GSM 7 bit packed: ", ex);
            return null;
        }
        return ret.toString();
    }

    
    @DSModeled(DSC.SAFE)
    public static String gsm8BitUnpackedToString(byte[] data, int offset, int length) {
        return gsm8BitUnpackedToString(data, offset, length, "");
    }

    
    @DSModeled(DSC.SAFE)
    public static String gsm8BitUnpackedToString(byte[] data, int offset, int length, String characterset) {
        boolean isMbcs = false;
        Charset charset = null;
        ByteBuffer mbcsBuffer = null;
        if (!TextUtils.isEmpty(characterset)
                && !characterset.equalsIgnoreCase("us-ascii")
                && Charset.isSupported(characterset)) {
            isMbcs = true;
            charset = Charset.forName(characterset);
            mbcsBuffer = ByteBuffer.allocate(2);
        }
        String languageTableToChar = sLanguageTables[0];
        String shiftTableToChar = sLanguageShiftTables[0];
        StringBuilder ret = new StringBuilder(length);
        boolean prevWasEscape = false;
        for (int i = offset ; i < offset + length ; i++) {
            int c = data[i] & 0xff;
            if (c == 0xff) {
                break;
            } else if (c == GSM_EXTENDED_ESCAPE) {
                if (prevWasEscape) {
                    ret.append(' ');
                    prevWasEscape = false;
                } else {
                    prevWasEscape = true;
                }
            } else {
                if (prevWasEscape) {
                    char shiftChar = shiftTableToChar.charAt(c);
                    if (shiftChar == ' ') {
                        ret.append(languageTableToChar.charAt(c));
                    } else {
                        ret.append(shiftChar);
                    }
                } else {
                    if (!isMbcs || c < 0x80 || i + 1 >= offset + length) {
                        ret.append(languageTableToChar.charAt(c));
                    } else {
                        mbcsBuffer.clear();
                        mbcsBuffer.put(data, i++, 2);
                        mbcsBuffer.flip();
                        ret.append(charset.decode(mbcsBuffer).toString());
                    }
                }
                prevWasEscape = false;
            }
        }
        return ret.toString();
    }

    
    @DSModeled(DSC.SAFE)
    public static byte[] stringToGsm8BitPacked(String s) {
        byte[] ret;
        int septets = countGsmSeptetsUsingTables(s, true, 0, 0);
        ret = new byte[septets];
        stringToGsm8BitUnpackedField(s, ret, 0, ret.length);
        return ret;
    }

    
    @DSModeled(DSC.SAFE)
    public static void stringToGsm8BitUnpackedField(String s, byte dest[], int offset, int length) {
        int outByteIndex = offset;
        SparseIntArray charToLanguageTable = sCharsToGsmTables[0];
        SparseIntArray charToShiftTable = sCharsToShiftTables[0];
        for (int i = 0, sz = s.length()
                ; i < sz && (outByteIndex - offset) < length
                ; i++
        ) {
            char c = s.charAt(i);
            int v = charToLanguageTable.get(c, -1);
            if (v == -1) {
                v = charToShiftTable.get(c, -1);
                if (v == -1) {
                    v = charToLanguageTable.get(' ', ' ');  
                } else {
                    if (! (outByteIndex + 1 - offset < length)) {
                        break;
                    }
                    dest[outByteIndex++] = GSM_EXTENDED_ESCAPE;
                }
            }
            dest[outByteIndex++] = (byte)v;
        }
        while((outByteIndex - offset) < length) {
            dest[outByteIndex++] = (byte)0xff;
        }
    }

    
    @DSModeled(DSC.SAFE)
    public static int countGsmSeptets(char c) {
        try {
            return countGsmSeptets(c, false);
        } catch (EncodeException ex) {
            return 0;
        }
    }

    
    @DSModeled(DSC.SAFE)
    public static int countGsmSeptets(char c, boolean throwsException) throws EncodeException {
        if (sCharsToGsmTables[0].get(c, -1) != -1) {
            return 1;
        }
        if (sCharsToShiftTables[0].get(c, -1) != -1) {
            return 2;
        }
        if (throwsException) {
            throw new EncodeException(c);
        } else {
            return 1;
        }
    }

    
    @DSModeled(DSC.SAFE)
    public static int countGsmSeptetsUsingTables(CharSequence s, boolean use7bitOnly,
            int languageTable, int languageShiftTable) {
        int count = 0;
        int sz = s.length();
        SparseIntArray charToLanguageTable = sCharsToGsmTables[languageTable];
        SparseIntArray charToShiftTable = sCharsToShiftTables[languageShiftTable];
        for (int i = 0; i < sz; i++) {
            char c = s.charAt(i);
            if (c == GSM_EXTENDED_ESCAPE) {
                Log.w(TAG, "countGsmSeptets() string contains Escape character, skipping.");
                continue;
            }
            if (charToLanguageTable.get(c, -1) != -1) {
                count++;
            } else if (charToShiftTable.get(c, -1) != -1) {
                count += 2; 
            } else if (use7bitOnly) {
                count++;    
            } else {
                return -1;  
            }
        }
        return count;
    }

    
    public static SmsMessageBase.TextEncodingDetails countGsmSeptets(CharSequence s, boolean use7bitOnly) {
        if (sEnabledSingleShiftTables.length + sEnabledLockingShiftTables.length == 0) {
            SmsMessageBase.TextEncodingDetails ted = new SmsMessageBase.TextEncodingDetails();
            int septets = GsmAlphabet.countGsmSeptetsUsingTables(s, use7bitOnly, 0, 0);
            if (septets == -1) {
                return null;
            }
            ted.codeUnitSize = ENCODING_7BIT;
            ted.codeUnitCount = septets;
            if (septets > MAX_USER_DATA_SEPTETS) {
                ted.msgCount = (septets + (MAX_USER_DATA_SEPTETS_WITH_HEADER - 1)) /
                        MAX_USER_DATA_SEPTETS_WITH_HEADER;
                ted.codeUnitsRemaining = (ted.msgCount *
                        MAX_USER_DATA_SEPTETS_WITH_HEADER) - septets;
            } else {
                ted.msgCount = 1;
                ted.codeUnitsRemaining = MAX_USER_DATA_SEPTETS - septets;
            }
            ted.codeUnitSize = ENCODING_7BIT;
            return ted;
        }
        int maxSingleShiftCode = sHighestEnabledSingleShiftCode;
        List<LanguagePairCount> lpcList = new ArrayList<LanguagePairCount>(
                sEnabledLockingShiftTables.length + 1);
        lpcList.add(new LanguagePairCount(0));
        for (int i : sEnabledLockingShiftTables) {
            if (i != 0 && !sLanguageTables[i].isEmpty()) {
                lpcList.add(new LanguagePairCount(i));
            }
        }
        int sz = s.length();
        for (int i = 0; i < sz && !lpcList.isEmpty(); i++) {
            char c = s.charAt(i);
            if (c == GSM_EXTENDED_ESCAPE) {
                Log.w(TAG, "countGsmSeptets() string contains Escape character, ignoring!");
                continue;
            }
            for (LanguagePairCount lpc : lpcList) {
                int tableIndex = sCharsToGsmTables[lpc.languageCode].get(c, -1);
                if (tableIndex == -1) {
                    for (int table = 0; table <= maxSingleShiftCode; table++) {
                        if (lpc.septetCounts[table] != -1) {
                            int shiftTableIndex = sCharsToShiftTables[table].get(c, -1);
                            if (shiftTableIndex == -1) {
                                if (use7bitOnly) {
                                    lpc.septetCounts[table]++;
                                    lpc.unencodableCounts[table]++;
                                } else {
                                    lpc.septetCounts[table] = -1;
                                }
                            } else {
                                lpc.septetCounts[table] += 2;
                            }
                        }
                    }
                } else {
                    for (int table = 0; table <= maxSingleShiftCode; table++) {
                        if (lpc.septetCounts[table] != -1) {
                            lpc.septetCounts[table]++;
                        }
                    }
                }
            }
        }
        SmsMessageBase.TextEncodingDetails ted = new SmsMessageBase.TextEncodingDetails();
        ted.msgCount = Integer.MAX_VALUE;
        ted.codeUnitSize = ENCODING_7BIT;
        int minUnencodableCount = Integer.MAX_VALUE;
        for (LanguagePairCount lpc : lpcList) {
            for (int shiftTable = 0; shiftTable <= maxSingleShiftCode; shiftTable++) {
                int septets = lpc.septetCounts[shiftTable];
                if (septets == -1) {
                    continue;
                }
                int udhLength;
                if (lpc.languageCode != 0 && shiftTable != 0) {
                    udhLength = UDH_SEPTET_COST_LENGTH + UDH_SEPTET_COST_TWO_SHIFT_TABLES;
                } else if (lpc.languageCode != 0 || shiftTable != 0) {
                    udhLength = UDH_SEPTET_COST_LENGTH + UDH_SEPTET_COST_ONE_SHIFT_TABLE;
                } else {
                    udhLength = 0;
                }
                int msgCount;
                int septetsRemaining;
                if (septets + udhLength > MAX_USER_DATA_SEPTETS) {
                    if (udhLength == 0) {
                        udhLength = UDH_SEPTET_COST_LENGTH;
                    }
                    udhLength += UDH_SEPTET_COST_CONCATENATED_MESSAGE;
                    int septetsPerMessage = MAX_USER_DATA_SEPTETS - udhLength;
                    msgCount = (septets + septetsPerMessage - 1) / septetsPerMessage;
                    septetsRemaining = (msgCount * septetsPerMessage) - septets;
                } else {
                    msgCount = 1;
                    septetsRemaining = MAX_USER_DATA_SEPTETS - udhLength - septets;
                }
                int unencodableCount = lpc.unencodableCounts[shiftTable];
                if (use7bitOnly && unencodableCount > minUnencodableCount) {
                    continue;
                }
                if ((use7bitOnly && unencodableCount < minUnencodableCount)
                        || msgCount < ted.msgCount || (msgCount == ted.msgCount
                        && septetsRemaining > ted.codeUnitsRemaining)) {
                    minUnencodableCount = unencodableCount;
                    ted.msgCount = msgCount;
                    ted.codeUnitCount = septets;
                    ted.codeUnitsRemaining = septetsRemaining;
                    ted.languageTable = lpc.languageCode;
                    ted.languageShiftTable = shiftTable;
                }
            }
        }
        if (ted.msgCount == Integer.MAX_VALUE) {
            return null;
        }
        return ted;
    }

    
    @DSModeled(DSC.SAFE)
    public static int findGsmSeptetLimitIndex(String s, int start, int limit, int langTable, int langShiftTable) {
        int accumulator = 0;
        int size = s.length();
        SparseIntArray charToLangTable = sCharsToGsmTables[langTable];
        SparseIntArray charToLangShiftTable = sCharsToShiftTables[langShiftTable];
        for (int i = start; i < size; i++) {
            int encodedSeptet = charToLangTable.get(s.charAt(i), -1);
            if (encodedSeptet == -1) {
                encodedSeptet = charToLangShiftTable.get(s.charAt(i), -1);
                if (encodedSeptet == -1) {
                    accumulator++;
                } else {
                    accumulator += 2;  
                }
            } else {
                accumulator++;
            }
            if (accumulator > limit) {
                return i;
            }
        }
        return size;
    }

    
    @DSModeled(DSC.SAFE)
    static synchronized void setEnabledSingleShiftTables(int[] tables) {
        sEnabledSingleShiftTables = tables;
        if (tables.length > 0) {
            sHighestEnabledSingleShiftCode = tables[tables.length - 1];
        } else {
            sHighestEnabledSingleShiftCode = 0;
        }
    }

    
    @DSModeled(DSC.SAFE)
    static synchronized void setEnabledLockingShiftTables(int[] tables) {
        sEnabledLockingShiftTables = tables;
    }

    
    @DSModeled(DSC.SAFE)
    static synchronized int[] getEnabledSingleShiftTables() {
        return sEnabledSingleShiftTables;
    }

    
    @DSModeled(DSC.SAFE)
    static synchronized int[] getEnabledLockingShiftTables() {
        return sEnabledLockingShiftTables;
    }

    
    private static class LanguagePairCount {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.235 -0400", hash_original_field = "3A3CB397ADE05A407F0D792E87F6F299", hash_generated_field = "751385C2D4084786D52A9F254B89775D")

        int languageCode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.235 -0400", hash_original_field = "C952B21C8E1E6EA1BFBDA4335931DBF0", hash_generated_field = "2ABCA39022907433C3B5065AE66DDA55")

        int[] septetCounts;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.235 -0400", hash_original_field = "FA96D72628AD78B424E796DF9177A4C4", hash_generated_field = "538C50EAF301EE2CC9D2096166C6CEE7")

        int[] unencodableCounts;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.235 -0400", hash_original_method = "62389A632F9774EDFBFC18A0B528AAFD", hash_generated_method = "2330F9A8261C0C983D54268587DF7AC9")
          LanguagePairCount(int code) {
            this.languageCode = code;
            int maxSingleShiftCode = sHighestEnabledSingleShiftCode;
            septetCounts = new int[maxSingleShiftCode + 1];
            unencodableCounts = new int[maxSingleShiftCode + 1];
            {
                int i = 1;
                int tableOffset = 0;
                {
                    {
                        septetCounts[i] = -1;
                    } 
                } 
            } 
            {
                septetCounts[1] = -1;
            } 
            {
                septetCounts[2] = -1;
            } 
            
            
            
            
            
            
                
                    
                
                    
                
            
            
                
            
                
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.236 -0400", hash_original_field = "1E54D398F6654D474F0F5192DC98EDCC", hash_generated_field = "EFF0BA8EAA7A2E5FCD3601D1F8EC46DA")

    private static final String TAG = "GSM";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.236 -0400", hash_original_field = "83E2E53BC5D628A00F74973C0828D312", hash_generated_field = "01B4701196E8E146FCB4ABE9EBFE561A")

    public static final byte GSM_EXTENDED_ESCAPE = 0x1B;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.236 -0400", hash_original_field = "AD6F7CFC9406C3F8AD68F0A7C4F3C303", hash_generated_field = "E7C187193C05B2BE92F97B401ABD1A56")

    public static final int UDH_SEPTET_COST_LENGTH = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.236 -0400", hash_original_field = "22BA7F2F78CC9082AE110ABA358462A3", hash_generated_field = "CBFC8557EFC74CEEF14352FADE5BCE44")

    public static final int UDH_SEPTET_COST_ONE_SHIFT_TABLE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.236 -0400", hash_original_field = "65DB77D05C33F2258AC9F6FC92FAC80D", hash_generated_field = "E0214C53588E79AF1E1679ED35E28F19")

    public static final int UDH_SEPTET_COST_TWO_SHIFT_TABLES = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.236 -0400", hash_original_field = "C21D2E8F2D7CB95111AB1184C353F100", hash_generated_field = "8F3BC9CF64CC8917571C6ADB052B3A62")

    public static final int UDH_SEPTET_COST_CONCATENATED_MESSAGE = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.236 -0400", hash_original_field = "6825F1DFB1958CFDF02A05E7F173EC56", hash_generated_field = "B45451A3D3324EFBFEB9E27D9B614D45")

    private static SparseIntArray[] sCharsToGsmTables;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.236 -0400", hash_original_field = "A56B9E2E62E4459E7628AF163CFE0E20", hash_generated_field = "0B96A40055A95B2257379B3584AA9523")

    private static SparseIntArray[] sCharsToShiftTables;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.236 -0400", hash_original_field = "8957A49BB200B611FDBE5403C52866A1", hash_generated_field = "2ECC027C28F9F71EED05C10584CA030F")

    private static int[] sEnabledSingleShiftTables;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.236 -0400", hash_original_field = "AD983259565FC9E37CFB9D682F9AD1A8", hash_generated_field = "3A09A08C6E3D262BBDA43B757C45805B")

    private static int[] sEnabledLockingShiftTables;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.236 -0400", hash_original_field = "AFBC260B8EF65D7E5411FF4A74B35187", hash_generated_field = "912597CF8776978E6C995535FD23DDFD")

    private static int sHighestEnabledSingleShiftCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.236 -0400", hash_original_field = "583F60D042B2E4ED9B0B63C2F42E4376", hash_generated_field = "2FB715E5FB56BF92B1C0C9951328990A")

    private static final String[] sLanguageTables = {
        
        "@\u00a3$\u00a5\u00e8\u00e9\u00f9\u00ec\u00f2\u00c7\n\u00d8\u00f8\r\u00c5\u00e5\u0394_"
            
            + "\u03a6\u0393\u039b\u03a9\u03a0\u03a8\u03a3\u0398\u039e\uffff\u00c6\u00e6\u00df"
            
            + "\u00c9 !\"#\u00a4%&'()*+,-./0123456789:;<=>?\u00a1ABCDEFGHIJKLMNOPQRSTUVWXYZ"
            
            + "\u00c4\u00d6\u00d1\u00dc\u00a7\u00bfabcdefghijklmnopqrstuvwxyz\u00e4\u00f6\u00f1"
            
            + "\u00fc\u00e0",

        
        "@\u00a3$\u00a5\u20ac\u00e9\u00f9\u0131\u00f2\u00c7\n\u011e\u011f\r\u00c5\u00e5\u0394_"
            
            + "\u03a6\u0393\u039b\u03a9\u03a0\u03a8\u03a3\u0398\u039e\uffff\u015e\u015f\u00df"
            
            + "\u00c9 !\"#\u00a4%&'()*+,-./0123456789:;<=>?\u0130ABCDEFGHIJKLMNOPQRSTUVWXYZ"
            
            + "\u00c4\u00d6\u00d1\u00dc\u00a7\u00e7abcdefghijklmnopqrstuvwxyz\u00e4\u00f6\u00f1"
            
            + "\u00fc\u00e0",

        
        "",

        
        "@\u00a3$\u00a5\u00ea\u00e9\u00fa\u00ed\u00f3\u00e7\n\u00d4\u00f4\r\u00c1\u00e1\u0394_"
            
            + "\u00aa\u00c7\u00c0\u221e^\\\u20ac\u00d3|\uffff\u00c2\u00e2\u00ca\u00c9 !\"#\u00ba"
            
            + "%&'()*+,-./0123456789:;<=>?\u00cdABCDEFGHIJKLMNOPQRSTUVWXYZ\u00c3\u00d5\u00da\u00dc"
            
            + "\u00a7~abcdefghijklmnopqrstuvwxyz\u00e3\u00f5`\u00fc\u00e0",

        
        "\u0981\u0982\u0983\u0985\u0986\u0987\u0988\u0989\u098a\u098b\n\u098c \r \u098f\u0990"
            
            + "  \u0993\u0994\u0995\u0996\u0997\u0998\u0999\u099a\uffff\u099b\u099c\u099d\u099e"
            
            + " !\u099f\u09a0\u09a1\u09a2\u09a3\u09a4)(\u09a5\u09a6,\u09a7.\u09a80123456789:; "
            
            + "\u09aa\u09ab?\u09ac\u09ad\u09ae\u09af\u09b0 \u09b2   \u09b6\u09b7\u09b8\u09b9"
            
            + "\u09bc\u09bd\u09be\u09bf\u09c0\u09c1\u09c2\u09c3\u09c4  \u09c7\u09c8  \u09cb\u09cc"
            
            + "\u09cd\u09ceabcdefghijklmnopqrstuvwxyz\u09d7\u09dc\u09dd\u09f0\u09f1",

        
        "\u0a81\u0a82\u0a83\u0a85\u0a86\u0a87\u0a88\u0a89\u0a8a\u0a8b\n\u0a8c\u0a8d\r \u0a8f\u0a90"
            
            + "\u0a91 \u0a93\u0a94\u0a95\u0a96\u0a97\u0a98\u0a99\u0a9a\uffff\u0a9b\u0a9c\u0a9d"
            
            + "\u0a9e !\u0a9f\u0aa0\u0aa1\u0aa2\u0aa3\u0aa4)(\u0aa5\u0aa6,\u0aa7.\u0aa80123456789:;"
            
            + " \u0aaa\u0aab?\u0aac\u0aad\u0aae\u0aaf\u0ab0 \u0ab2\u0ab3 \u0ab5\u0ab6\u0ab7\u0ab8"
            
            + "\u0ab9\u0abc\u0abd\u0abe\u0abf\u0ac0\u0ac1\u0ac2\u0ac3\u0ac4\u0ac5 \u0ac7\u0ac8"
            
            + "\u0ac9 \u0acb\u0acc\u0acd\u0ad0abcdefghijklmnopqrstuvwxyz\u0ae0\u0ae1\u0ae2\u0ae3"
            
            + "\u0af1",

        
        "\u0901\u0902\u0903\u0905\u0906\u0907\u0908\u0909\u090a\u090b\n\u090c\u090d\r\u090e\u090f"
            
            + "\u0910\u0911\u0912\u0913\u0914\u0915\u0916\u0917\u0918\u0919\u091a\uffff\u091b\u091c"
            
            + "\u091d\u091e !\u091f\u0920\u0921\u0922\u0923\u0924)(\u0925\u0926,\u0927.\u0928012345"
            
            + "6789:;\u0929\u092a\u092b?\u092c\u092d\u092e\u092f\u0930\u0931\u0932\u0933\u0934"
            
            + "\u0935\u0936\u0937\u0938\u0939\u093c\u093d\u093e\u093f\u0940\u0941\u0942\u0943\u0944"
            
            + "\u0945\u0946\u0947\u0948\u0949\u094a\u094b\u094c\u094d\u0950abcdefghijklmnopqrstuvwx"
            
            + "yz\u0972\u097b\u097c\u097e\u097f",

        
        " \u0c82\u0c83\u0c85\u0c86\u0c87\u0c88\u0c89\u0c8a\u0c8b\n\u0c8c \r\u0c8e\u0c8f\u0c90 "
            
            + "\u0c92\u0c93\u0c94\u0c95\u0c96\u0c97\u0c98\u0c99\u0c9a\uffff\u0c9b\u0c9c\u0c9d\u0c9e"
            
            + " !\u0c9f\u0ca0\u0ca1\u0ca2\u0ca3\u0ca4)(\u0ca5\u0ca6,\u0ca7.\u0ca80123456789:; "
            
            + "\u0caa\u0cab?\u0cac\u0cad\u0cae\u0caf\u0cb0\u0cb1\u0cb2\u0cb3 \u0cb5\u0cb6\u0cb7"
            
            + "\u0cb8\u0cb9\u0cbc\u0cbd\u0cbe\u0cbf\u0cc0\u0cc1\u0cc2\u0cc3\u0cc4 \u0cc6\u0cc7"
            
            + "\u0cc8 \u0cca\u0ccb\u0ccc\u0ccd\u0cd5abcdefghijklmnopqrstuvwxyz\u0cd6\u0ce0\u0ce1"
            
            + "\u0ce2\u0ce3",

        
        " \u0d02\u0d03\u0d05\u0d06\u0d07\u0d08\u0d09\u0d0a\u0d0b\n\u0d0c \r\u0d0e\u0d0f\u0d10 "
            
            + "\u0d12\u0d13\u0d14\u0d15\u0d16\u0d17\u0d18\u0d19\u0d1a\uffff\u0d1b\u0d1c\u0d1d\u0d1e"
            
            + " !\u0d1f\u0d20\u0d21\u0d22\u0d23\u0d24)(\u0d25\u0d26,\u0d27.\u0d280123456789:; "
            
            + "\u0d2a\u0d2b?\u0d2c\u0d2d\u0d2e\u0d2f\u0d30\u0d31\u0d32\u0d33\u0d34\u0d35\u0d36"
            
            + "\u0d37\u0d38\u0d39 \u0d3d\u0d3e\u0d3f\u0d40\u0d41\u0d42\u0d43\u0d44 \u0d46\u0d47"
            
            + "\u0d48 \u0d4a\u0d4b\u0d4c\u0d4d\u0d57abcdefghijklmnopqrstuvwxyz\u0d60\u0d61\u0d62"
            
            + "\u0d63\u0d79",

        
        "\u0b01\u0b02\u0b03\u0b05\u0b06\u0b07\u0b08\u0b09\u0b0a\u0b0b\n\u0b0c \r \u0b0f\u0b10  "
            
            + "\u0b13\u0b14\u0b15\u0b16\u0b17\u0b18\u0b19\u0b1a\uffff\u0b1b\u0b1c\u0b1d\u0b1e !"
            
            + "\u0b1f\u0b20\u0b21\u0b22\u0b23\u0b24)(\u0b25\u0b26,\u0b27.\u0b280123456789:; \u0b2a"
            
            + "\u0b2b?\u0b2c\u0b2d\u0b2e\u0b2f\u0b30 \u0b32\u0b33 \u0b35\u0b36\u0b37\u0b38\u0b39"
            
            + "\u0b3c\u0b3d\u0b3e\u0b3f\u0b40\u0b41\u0b42\u0b43\u0b44  \u0b47\u0b48  \u0b4b\u0b4c"
            
            + "\u0b4d\u0b56abcdefghijklmnopqrstuvwxyz\u0b57\u0b60\u0b61\u0b62\u0b63",

        
        "\u0a01\u0a02\u0a03\u0a05\u0a06\u0a07\u0a08\u0a09\u0a0a \n  \r \u0a0f\u0a10  \u0a13\u0a14"
            
            + "\u0a15\u0a16\u0a17\u0a18\u0a19\u0a1a\uffff\u0a1b\u0a1c\u0a1d\u0a1e !\u0a1f\u0a20"
            
            + "\u0a21\u0a22\u0a23\u0a24)(\u0a25\u0a26,\u0a27.\u0a280123456789:; \u0a2a\u0a2b?\u0a2c"
            
            + "\u0a2d\u0a2e\u0a2f\u0a30 \u0a32\u0a33 \u0a35\u0a36 \u0a38\u0a39\u0a3c \u0a3e\u0a3f"
            
            + "\u0a40\u0a41\u0a42    \u0a47\u0a48  \u0a4b\u0a4c\u0a4d\u0a51abcdefghijklmnopqrstuvwx"
            
            + "yz\u0a70\u0a71\u0a72\u0a73\u0a74",

        
        " \u0b82\u0b83\u0b85\u0b86\u0b87\u0b88\u0b89\u0b8a \n  \r\u0b8e\u0b8f\u0b90 \u0b92\u0b93"
            
            + "\u0b94\u0b95   \u0b99\u0b9a\uffff \u0b9c \u0b9e !\u0b9f   \u0ba3\u0ba4)(  , .\u0ba8"
            
            + "0123456789:;\u0ba9\u0baa ?  \u0bae\u0baf\u0bb0\u0bb1\u0bb2\u0bb3\u0bb4\u0bb5\u0bb6"
            
            + "\u0bb7\u0bb8\u0bb9  \u0bbe\u0bbf\u0bc0\u0bc1\u0bc2   \u0bc6\u0bc7\u0bc8 \u0bca\u0bcb"
            
            + "\u0bcc\u0bcd\u0bd0abcdefghijklmnopqrstuvwxyz\u0bd7\u0bf0\u0bf1\u0bf2\u0bf9",

        
        "\u0c01\u0c02\u0c03\u0c05\u0c06\u0c07\u0c08\u0c09\u0c0a\u0c0b\n\u0c0c \r\u0c0e\u0c0f\u0c10"
            
            + " \u0c12\u0c13\u0c14\u0c15\u0c16\u0c17\u0c18\u0c19\u0c1a\uffff\u0c1b\u0c1c\u0c1d"
            
            + "\u0c1e !\u0c1f\u0c20\u0c21\u0c22\u0c23\u0c24)(\u0c25\u0c26,\u0c27.\u0c280123456789:;"
            
            + " \u0c2a\u0c2b?\u0c2c\u0c2d\u0c2e\u0c2f\u0c30\u0c31\u0c32\u0c33 \u0c35\u0c36\u0c37"
            
            + "\u0c38\u0c39 \u0c3d\u0c3e\u0c3f\u0c40\u0c41\u0c42\u0c43\u0c44 \u0c46\u0c47\u0c48 "
            
            + "\u0c4a\u0c4b\u0c4c\u0c4d\u0c55abcdefghijklmnopqrstuvwxyz\u0c56\u0c60\u0c61\u0c62"
            
            + "\u0c63",

        
        "\u0627\u0622\u0628\u067b\u0680\u067e\u06a6\u062a\u06c2\u067f\n\u0679\u067d\r\u067a\u067c"
            
            + "\u062b\u062c\u0681\u0684\u0683\u0685\u0686\u0687\u062d\u062e\u062f\uffff\u068c\u0688"
            
            + "\u0689\u068a !\u068f\u068d\u0630\u0631\u0691\u0693)(\u0699\u0632,\u0696.\u0698012345"
            
            + "6789:;\u069a\u0633\u0634?\u0635\u0636\u0637\u0638\u0639\u0641\u0642\u06a9\u06aa"
            
            + "\u06ab\u06af\u06b3\u06b1\u0644\u0645\u0646\u06ba\u06bb\u06bc\u0648\u06c4\u06d5\u06c1"
            
            + "\u06be\u0621\u06cc\u06d0\u06d2\u064d\u0650\u064f\u0657\u0654abcdefghijklmnopqrstuvwx"
            
            + "yz\u0655\u0651\u0653\u0656\u0670"
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.236 -0400", hash_original_field = "ED8E1D9DAF8EC0116220715DF9C5259D", hash_generated_field = "122ADAB93F7862CCCD44F5ECE5220A35")

    private static final String[] sLanguageShiftTables = new String[]{
        
        "          \u000c         ^                   {}     \\            [~] |               "
            
            + "                     \u20ac                          ",

        
        "          \u000c         ^                   {}     \\            [~] |      \u011e "
            
            + "\u0130         \u015e               \u00e7 \u20ac \u011f \u0131         \u015f"
            
            + "            ",

        
        "         \u00e7\u000c         ^                   {}     \\            [~] |\u00c1  "
            
            + "     \u00cd     \u00d3     \u00da           \u00e1   \u20ac   \u00ed     \u00f3   "
            
            + "  \u00fa          ",

        
        "     \u00ea   \u00e7\u000c\u00d4\u00f4 \u00c1\u00e1  \u03a6\u0393^\u03a9\u03a0\u03a8\u03a3"
            
            + "\u0398     \u00ca        {}     \\            [~] |\u00c0       \u00cd     "
            
            + "\u00d3     \u00da     \u00c3\u00d5    \u00c2   \u20ac   \u00ed     \u00f3     "
            
            + "\u00fa     \u00e3\u00f5  \u00e2",

        
        "@\u00a3$\u00a5\u00bf\"\u00a4%&'\u000c*+ -/<=>\u00a1^\u00a1_#*\u09e6\u09e7 \u09e8\u09e9"
            
            + "\u09ea\u09eb\u09ec\u09ed\u09ee\u09ef\u09df\u09e0\u09e1\u09e2{}\u09e3\u09f2\u09f3"
            
            + "\u09f4\u09f5\\\u09f6\u09f7\u09f8\u09f9\u09fa       [~] |ABCDEFGHIJKLMNO"
            
            + "PQRSTUVWXYZ          \u20ac                          ",

        
        "@\u00a3$\u00a5\u00bf\"\u00a4%&'\u000c*+ -/<=>\u00a1^\u00a1_#*\u0964\u0965 \u0ae6\u0ae7"
            
            + "\u0ae8\u0ae9\u0aea\u0aeb\u0aec\u0aed\u0aee\u0aef  {}     \\            [~] "
            
            + "|ABCDEFGHIJKLMNOPQRSTUVWXYZ          \u20ac                          ",

        
        "@\u00a3$\u00a5\u00bf\"\u00a4%&'\u000c*+ -/<=>\u00a1^\u00a1_#*\u0964\u0965 \u0966\u0967"
            
            + "\u0968\u0969\u096a\u096b\u096c\u096d\u096e\u096f\u0951\u0952{}\u0953\u0954\u0958"
            
            + "\u0959\u095a\\\u095b\u095c\u095d\u095e\u095f\u0960\u0961\u0962\u0963\u0970\u0971"
            
            + " [~] |ABCDEFGHIJKLMNOPQRSTUVWXYZ          \u20ac                          ",

        
        "@\u00a3$\u00a5\u00bf\"\u00a4%&'\u000c*+ -/<=>\u00a1^\u00a1_#*\u0964\u0965 \u0ce6\u0ce7"
            
            + "\u0ce8\u0ce9\u0cea\u0ceb\u0cec\u0ced\u0cee\u0cef\u0cde\u0cf1{}\u0cf2    \\        "
            
            + "    [~] |ABCDEFGHIJKLMNOPQRSTUVWXYZ          \u20ac                          ",

        
        "@\u00a3$\u00a5\u00bf\"\u00a4%&'\u000c*+ -/<=>\u00a1^\u00a1_#*\u0964\u0965 \u0d66\u0d67"
            
            + "\u0d68\u0d69\u0d6a\u0d6b\u0d6c\u0d6d\u0d6e\u0d6f\u0d70\u0d71{}\u0d72\u0d73\u0d74"
            
            + "\u0d75\u0d7a\\\u0d7b\u0d7c\u0d7d\u0d7e\u0d7f       [~] |ABCDEFGHIJKLMNOPQRSTUVWXYZ"
            
            + "          \u20ac                          ",

        
        "@\u00a3$\u00a5\u00bf\"\u00a4%&'\u000c*+ -/<=>\u00a1^\u00a1_#*\u0964\u0965 \u0b66\u0b67"
            
            + "\u0b68\u0b69\u0b6a\u0b6b\u0b6c\u0b6d\u0b6e\u0b6f\u0b5c\u0b5d{}\u0b5f\u0b70\u0b71  "
            
            + "\\            [~] |ABCDEFGHIJKLMNOPQRSTUVWXYZ          \u20ac                     "
            
            + "     ",

        
        "@\u00a3$\u00a5\u00bf\"\u00a4%&'\u000c*+ -/<=>\u00a1^\u00a1_#*\u0964\u0965 \u0a66\u0a67"
            
            + "\u0a68\u0a69\u0a6a\u0a6b\u0a6c\u0a6d\u0a6e\u0a6f\u0a59\u0a5a{}\u0a5b\u0a5c\u0a5e"
            
            + "\u0a75 \\            [~] |ABCDEFGHIJKLMNOPQRSTUVWXYZ          \u20ac            "
            
            + "              ",

        
        "@\u00a3$\u00a5\u00bf\"\u00a4%&'\u000c*+ -/<=>\u00a1^\u00a1_#*\u0964\u0965 \u0be6\u0be7"
            
            + "\u0be8\u0be9\u0bea\u0beb\u0bec\u0bed\u0bee\u0bef\u0bf3\u0bf4{}\u0bf5\u0bf6\u0bf7"
            
            + "\u0bf8\u0bfa\\            [~] |ABCDEFGHIJKLMNOPQRSTUVWXYZ          \u20ac       "
            
            + "                   ",

        
        "@\u00a3$\u00a5\u00bf\"\u00a4%&'\u000c*+ -/<=>\u00a1^\u00a1_#*   \u0c66\u0c67\u0c68\u0c69"
            
            + "\u0c6a\u0c6b\u0c6c\u0c6d\u0c6e\u0c6f\u0c58\u0c59{}\u0c78\u0c79\u0c7a\u0c7b\u0c7c\\"
            
            + "\u0c7d\u0c7e\u0c7f         [~] |ABCDEFGHIJKLMNOPQRSTUVWXYZ          \u20ac        "
            
            + "                  ",

        
        "@\u00a3$\u00a5\u00bf\"\u00a4%&'\u000c*+ -/<=>\u00a1^\u00a1_#*\u0600\u0601 \u06f0\u06f1"
            
            + "\u06f2\u06f3\u06f4\u06f5\u06f6\u06f7\u06f8\u06f9\u060c\u060d{}\u060e\u060f\u0610"
            
            + "\u0611\u0612\\\u0613\u0614\u061b\u061f\u0640\u0652\u0658\u066b\u066c\u0672\u0673"
            
            + "\u06cd[~]\u06d4|ABCDEFGHIJKLMNOPQRSTUVWXYZ          \u20ac                          "
    };
    static {
        Resources r = Resources.getSystem();
        sEnabledSingleShiftTables = r.getIntArray(R.array.config_sms_enabled_single_shift_tables);
        sEnabledLockingShiftTables = r.getIntArray(R.array.config_sms_enabled_locking_shift_tables);
        int numTables = sLanguageTables.length;
        int numShiftTables = sLanguageShiftTables.length;
        if (numTables != numShiftTables) {
            Log.e(TAG, "Error: language tables array length " + numTables +
                    " != shift tables array length " + numShiftTables);
        }
        if (sEnabledSingleShiftTables.length > 0) {
            sHighestEnabledSingleShiftCode =
                    sEnabledSingleShiftTables[sEnabledSingleShiftTables.length-1];
        } else {
            sHighestEnabledSingleShiftCode = 0;
        }
        sCharsToGsmTables = new SparseIntArray[numTables];
        for (int i = 0; i < numTables; i++) {
            String table = sLanguageTables[i];
            int tableLen = table.length();
            if (tableLen != 0 && tableLen != 128) {
                Log.e(TAG, "Error: language tables index " + i +
                        " length " + tableLen + " (expected 128 or 0)");
            }
            SparseIntArray charToGsmTable = new SparseIntArray(tableLen);
            sCharsToGsmTables[i] = charToGsmTable;
            for (int j = 0; j < tableLen; j++) {
                char c = table.charAt(j);
                charToGsmTable.put(c, j);
            }
        }
        sCharsToShiftTables = new SparseIntArray[numTables];
        for (int i = 0; i < numShiftTables; i++) {
            String shiftTable = sLanguageShiftTables[i];
            int shiftTableLen = shiftTable.length();
            if (shiftTableLen != 0 && shiftTableLen != 128) {
                Log.e(TAG, "Error: language shift tables index " + i +
                        " length " + shiftTableLen + " (expected 128 or 0)");
            }
            SparseIntArray charToShiftTable = new SparseIntArray(shiftTableLen);
            sCharsToShiftTables[i] = charToShiftTable;
            for (int j = 0; j < shiftTableLen; j++) {
                char c = shiftTable.charAt(j);
                if (c != ' ') {
                    charToShiftTable.put(c, j);
                }
            }
        }
    }
    
}

