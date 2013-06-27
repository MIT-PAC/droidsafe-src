package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.485 -0400", hash_original_method = "ACEB66A7A5EB57C667A16876F7FFD7A1", hash_generated_method = "9D914C4804B753FB0D925E0024275993")
    private  GsmAlphabet() {
        // ---------- Original Method ----------
    }

    
        public static int charToGsm(char c) {
        try {
            return charToGsm(c, false);
        } catch (EncodeException ex) {
            return sCharsToGsmTables[0].get(' ', ' ');
        }
    }

    
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

    
        public static int charToGsmExtended(char c) {
        int ret;
        ret = sCharsToShiftTables[0].get(c, -1);
        if (ret == -1) {
            return sCharsToGsmTables[0].get(' ', ' ');
        }
        return ret;
    }

    
        public static char gsmToChar(int gsmChar) {
        if (gsmChar >= 0 && gsmChar < 128) {
            return sLanguageTables[0].charAt(gsmChar);
        } else {
            return ' ';
        }
    }

    
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

    
        public static byte[] stringToGsm7BitPackedWithHeader(String data, byte[] header) throws EncodeException {
        return stringToGsm7BitPackedWithHeader(data, header, 0, 0);
    }

    
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

    
        public static byte[] stringToGsm7BitPacked(String data) throws EncodeException {
        return stringToGsm7BitPacked(data, 0, true, 0, 0);
    }

    
        public static byte[] stringToGsm7BitPacked(String data, int languageTable,
            int languageShiftTable) throws EncodeException {
        return stringToGsm7BitPacked(data, 0, true, languageTable, languageShiftTable);
    }

    
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

    
        private static void packSmsChar(byte[] packedChars, int bitOffset, int value) {
        int byteOffset = bitOffset / 8;
        int shift = bitOffset % 8;
        packedChars[++byteOffset] |= value << shift;
        if (shift > 1) {
            packedChars[++byteOffset] = (byte)(value >> (8 - shift));
        }
    }

    
        public static String gsm7BitPackedToString(byte[] pdu, int offset,
            int lengthSeptets) {
        return gsm7BitPackedToString(pdu, offset, lengthSeptets, 0, 0, 0);
    }

    
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

    
        public static String gsm8BitUnpackedToString(byte[] data, int offset, int length) {
        return gsm8BitUnpackedToString(data, offset, length, "");
    }

    
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

    
        public static byte[] stringToGsm8BitPacked(String s) {
        byte[] ret;
        int septets = countGsmSeptetsUsingTables(s, true, 0, 0);
        ret = new byte[septets];
        stringToGsm8BitUnpackedField(s, ret, 0, ret.length);
        return ret;
    }

    
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

    
        public static int countGsmSeptets(char c) {
        try {
            return countGsmSeptets(c, false);
        } catch (EncodeException ex) {
            return 0;
        }
    }

    
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

    
        static synchronized void setEnabledSingleShiftTables(int[] tables) {
        sEnabledSingleShiftTables = tables;
        if (tables.length > 0) {
            sHighestEnabledSingleShiftCode = tables[tables.length - 1];
        } else {
            sHighestEnabledSingleShiftCode = 0;
        }
    }

    
        static synchronized void setEnabledLockingShiftTables(int[] tables) {
        sEnabledLockingShiftTables = tables;
    }

    
        static synchronized int[] getEnabledSingleShiftTables() {
        return sEnabledSingleShiftTables;
    }

    
        static synchronized int[] getEnabledLockingShiftTables() {
        return sEnabledLockingShiftTables;
    }

    
    private static class LanguagePairCount {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.516 -0400", hash_original_field = "3A3CB397ADE05A407F0D792E87F6F299", hash_generated_field = "751385C2D4084786D52A9F254B89775D")

        int languageCode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.516 -0400", hash_original_field = "C952B21C8E1E6EA1BFBDA4335931DBF0", hash_generated_field = "2ABCA39022907433C3B5065AE66DDA55")

        int[] septetCounts;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.516 -0400", hash_original_field = "FA96D72628AD78B424E796DF9177A4C4", hash_generated_field = "538C50EAF301EE2CC9D2096166C6CEE7")

        int[] unencodableCounts;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.516 -0400", hash_original_method = "62389A632F9774EDFBFC18A0B528AAFD", hash_generated_method = "77B6E0FF290915DCA003EDAF16CAAD47")
          LanguagePairCount(int code) {
            this.languageCode = code;
            int maxSingleShiftCode;
            maxSingleShiftCode = sHighestEnabledSingleShiftCode;
            septetCounts = new int[maxSingleShiftCode + 1];
            unencodableCounts = new int[maxSingleShiftCode + 1];
            {
                int i, tableOffset;
                i = 1;
                tableOffset = 0;
                {
                    {
                        septetCounts[i] = -1;
                    } //End block
                } //End block
            } //End collapsed parenthetic
            {
                septetCounts[1] = -1;
            } //End block
            {
                septetCounts[2] = -1;
            } //End block
            // ---------- Original Method ----------
            //this.languageCode = code;
            //int maxSingleShiftCode = sHighestEnabledSingleShiftCode;
            //septetCounts = new int[maxSingleShiftCode + 1];
            //unencodableCounts = new int[maxSingleShiftCode + 1];
            //for (int i = 1, tableOffset = 0; i <= maxSingleShiftCode; i++) {
                //if (sEnabledSingleShiftTables[tableOffset] == i) {
                    //tableOffset++;
                //} else {
                    //septetCounts[i] = -1;   
                //}
            //}
            //if (code == 1 && maxSingleShiftCode >= 1) {
                //septetCounts[1] = -1;   
            //} else if (code == 3 && maxSingleShiftCode >= 2) {
                //septetCounts[2] = -1;   
            //}
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.517 -0400", hash_original_field = "1E54D398F6654D474F0F5192DC98EDCC", hash_generated_field = "8BC77F4B5E1482D39A3C5083797AFB8D")

    private static String TAG = "GSM";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.517 -0400", hash_original_field = "83E2E53BC5D628A00F74973C0828D312", hash_generated_field = "01B4701196E8E146FCB4ABE9EBFE561A")

    public static final byte GSM_EXTENDED_ESCAPE = 0x1B;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.517 -0400", hash_original_field = "AD6F7CFC9406C3F8AD68F0A7C4F3C303", hash_generated_field = "E7C187193C05B2BE92F97B401ABD1A56")

    public static final int UDH_SEPTET_COST_LENGTH = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.517 -0400", hash_original_field = "22BA7F2F78CC9082AE110ABA358462A3", hash_generated_field = "CBFC8557EFC74CEEF14352FADE5BCE44")

    public static final int UDH_SEPTET_COST_ONE_SHIFT_TABLE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.517 -0400", hash_original_field = "65DB77D05C33F2258AC9F6FC92FAC80D", hash_generated_field = "E0214C53588E79AF1E1679ED35E28F19")

    public static final int UDH_SEPTET_COST_TWO_SHIFT_TABLES = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.517 -0400", hash_original_field = "C21D2E8F2D7CB95111AB1184C353F100", hash_generated_field = "8F3BC9CF64CC8917571C6ADB052B3A62")

    public static final int UDH_SEPTET_COST_CONCATENATED_MESSAGE = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.517 -0400", hash_original_field = "6825F1DFB1958CFDF02A05E7F173EC56", hash_generated_field = "B45451A3D3324EFBFEB9E27D9B614D45")

    private static SparseIntArray[] sCharsToGsmTables;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.517 -0400", hash_original_field = "A56B9E2E62E4459E7628AF163CFE0E20", hash_generated_field = "0B96A40055A95B2257379B3584AA9523")

    private static SparseIntArray[] sCharsToShiftTables;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.517 -0400", hash_original_field = "8957A49BB200B611FDBE5403C52866A1", hash_generated_field = "2ECC027C28F9F71EED05C10584CA030F")

    private static int[] sEnabledSingleShiftTables;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.517 -0400", hash_original_field = "AD983259565FC9E37CFB9D682F9AD1A8", hash_generated_field = "3A09A08C6E3D262BBDA43B757C45805B")

    private static int[] sEnabledLockingShiftTables;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.517 -0400", hash_original_field = "AFBC260B8EF65D7E5411FF4A74B35187", hash_generated_field = "912597CF8776978E6C995535FD23DDFD")

    private static int sHighestEnabledSingleShiftCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.517 -0400", hash_original_field = "583F60D042B2E4ED9B0B63C2F42E4376", hash_generated_field = "6D4102DB6985579C55768C98771F28C2")

    private static String[] sLanguageTables = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.517 -0400", hash_original_field = "ED8E1D9DAF8EC0116220715DF9C5259D", hash_generated_field = "E0D6A460783E477257863C11E7B23ADE")

    private static String[] sLanguageShiftTables = new String[]{
        
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

