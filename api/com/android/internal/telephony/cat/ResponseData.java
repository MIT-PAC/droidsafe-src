package com.android.internal.telephony.cat;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.TimeZone;

import android.os.SystemProperties;
import android.text.TextUtils;

import com.android.internal.telephony.EncodeException;
import com.android.internal.telephony.GsmAlphabet;
import com.android.internal.telephony.cat.AppInterface.CommandType;

abstract class ResponseData {

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.968 -0500", hash_original_method = "0B6CCB67FFDA5A49673B369424217ADB", hash_generated_method = "10E67E0C3714C85C626F98C3076D7381")
    
public static void writeLength(ByteArrayOutputStream buf, int length) {
        // As per ETSI 102.220 Sec7.1.2, if the total length is greater
        // than 0x7F, it should be coded in two bytes and the first byte
        // should be 0x81.
        if (length > 0x7F) {
            buf.write(0x81);
        }
        buf.write(length);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.492 -0400", hash_original_method = "814762139FDC16047D72234D9356528B", hash_generated_method = "814762139FDC16047D72234D9356528B")
    public ResponseData ()
    {
        //Synthesized constructor
    }
    /**
     * Format the data appropriate for TERMINAL RESPONSE and write it into
     * the ByteArrayOutputStream object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.966 -0500", hash_original_method = "6FB3ECF3A8313AEBC30BD8DDB91C09D0", hash_generated_method = "096DB2CD17C028C2B6A86B512C1A899B")
    
public abstract void format(ByteArrayOutputStream buf);
    
}

class SelectItemResponseData extends ResponseData {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.971 -0500", hash_original_field = "53E65FEF28E32C7EDCD1B07B4F5A0DE3", hash_generated_field = "D0FAB3735D60E909B66356CA0D9609D4")

    private int id;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.975 -0500", hash_original_method = "88F47DF9733601EED859AE224777BF09", hash_generated_method = "6F715C0BCDF01FEA68DEC6EEB9B4986D")
    
public SelectItemResponseData(int id) {
        super();
        this.id = id;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.977 -0500", hash_original_method = "FAE871B2C12637F0B15E3EAC43330DD6", hash_generated_method = "9F8115C35957E28FA7109103FF0441C7")
    
@Override
    public void format(ByteArrayOutputStream buf) {
        // Item identifier object
        int tag = 0x80 | ComprehensionTlvTag.ITEM_ID.value();
        buf.write(tag); // tag
        buf.write(1); // length
        buf.write(id); // identifier of item chosen
    }
    
}

class GetInkeyInputResponseData extends ResponseData {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.993 -0500", hash_original_field = "9179F5D1F2C10C2E8B468B60FC4604EB", hash_generated_field = "9D940471AD91F9981E205232344ACB7E")

    protected static final byte GET_INKEY_YES = 0x01;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.995 -0500", hash_original_field = "9A8617C46E4CC5744D9A8B542D882EA1", hash_generated_field = "41FDA2BEBCE7070771A64B9759D1B302")

    protected static final byte GET_INKEY_NO = 0x00;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.980 -0500", hash_original_field = "D05DEA13F64477ECAE4EF65DA350F89A", hash_generated_field = "7A163219ACAA280A67D5C441240B368C")

    private boolean mIsUcs2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.982 -0500", hash_original_field = "18DA4AF05A91CB4E035CD34FCFE12E7C", hash_generated_field = "C7E1E0CC35595105CCA5F93C6C3DF701")

    private boolean mIsPacked;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.985 -0500", hash_original_field = "32944C4306ABB7026BC418823F4EFC19", hash_generated_field = "98AE801F3C8B2189363BF9443058020F")

    private boolean mIsYesNo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.987 -0500", hash_original_field = "D0CE39920376903F2EFD1E5E81B0DDA2", hash_generated_field = "0BD5F3C992962F453EE25C1AA0328C36")

    private boolean mYesNoResponse;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.990 -0500", hash_original_field = "CAE0BFDF2120359AFC56C2872C45476F", hash_generated_field = "8CCEC3CAA13C0879C8CF36F964AE6DFC")

    public String mInData;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.998 -0500", hash_original_method = "C406233D38E0F3E58D00D02791A05027", hash_generated_method = "0AF97EA1CD4DAE9A769E06070FDD2C77")
    
public GetInkeyInputResponseData(String inData, boolean ucs2, boolean packed) {
        super();
        this.mIsUcs2 = ucs2;
        this.mIsPacked = packed;
        this.mInData = inData;
        this.mIsYesNo = false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:06.001 -0500", hash_original_method = "3E22EF603F248A198EBAA27D03FAD9D9", hash_generated_method = "EEA4A2B27DB123B9DF57FEEDD5BC11F0")
    
public GetInkeyInputResponseData(boolean yesNoResponse) {
        super();
        this.mIsUcs2 = false;
        this.mIsPacked = false;
        this.mInData = "";
        this.mIsYesNo = true;
        this.mYesNoResponse = yesNoResponse;
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:06.004 -0500", hash_original_method = "E3DE4DD341771272E5ED5B0598896B15", hash_generated_method = "CB11B03EEC533EFF3CFA7A28C5614904")
    
@Override
    public void format(ByteArrayOutputStream buf) {
        if (buf == null) {
            return;
        }

        // Text string object
        int tag = 0x80 | ComprehensionTlvTag.TEXT_STRING.value();
        buf.write(tag); // tag

        byte[] data;

        if (mIsYesNo) {
            data = new byte[1];
            data[0] = mYesNoResponse ? GET_INKEY_YES : GET_INKEY_NO;
        } else if (mInData != null && mInData.length() > 0) {
            try {
                if (mIsUcs2) {
                    data = mInData.getBytes("UTF-16");
                } else if (mIsPacked) {
                    int size = mInData.length();

                    byte[] tempData = GsmAlphabet
                            .stringToGsm7BitPacked(mInData, 0, 0);
                    data = new byte[size];
                    // Since stringToGsm7BitPacked() set byte 0 in the
                    // returned byte array to the count of septets used...
                    // copy to a new array without byte 0.
                    System.arraycopy(tempData, 1, data, 0, size);
                } else {
                    data = GsmAlphabet.stringToGsm8BitPacked(mInData);
                }
            } catch (UnsupportedEncodingException e) {
                data = new byte[0];
            } catch (EncodeException e) {
                data = new byte[0];
            }
        } else {
            data = new byte[0];
        }

        // length - one more for data coding scheme.
        writeLength(buf, data.length + 1);

        // data coding scheme
        if (mIsUcs2) {
            buf.write(0x08); // UCS2
        } else if (mIsPacked) {
            buf.write(0x00); // 7 bit packed
        } else {
            buf.write(0x04); // 8 bit unpacked
        }

        for (byte b : data) {
            buf.write(b);
        }
    }
}

class LanguageResponseData extends ResponseData {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:06.007 -0500", hash_original_field = "BAE3F1E3578AC55F6BA92E884601419C", hash_generated_field = "A84B1735D4DE391663408D2BFC463BA0")

    private String lang;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:06.011 -0500", hash_original_method = "9749992F218E6C6526070AE3BD9D1725", hash_generated_method = "94577568B7C91FC722349CEEFBCA83CB")
    
public LanguageResponseData(String lang) {
        super();
        this.lang = lang;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:06.014 -0500", hash_original_method = "0658244A9E7567A9FE447A4F6CD905F4", hash_generated_method = "73B9BC49AB91478E03041A1CB4F9C3BC")
    
@Override
    public void format(ByteArrayOutputStream buf) {
        if (buf == null) {
            return;
        }

        // Text string object
        int tag = 0x80 | ComprehensionTlvTag.LANGUAGE.value();
        buf.write(tag); // tag

        byte[] data;

        if (lang != null && lang.length() > 0) {
            data = GsmAlphabet.stringToGsm8BitPacked(lang);
        }
        else {
            data = new byte[0];
        }

        buf.write(data.length);

        for (byte b : data) {
            buf.write(b);
        }
    }
    
}

class DTTZResponseData extends ResponseData {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:06.017 -0500", hash_original_field = "1FBDCBF1EBCF702B875F63B227467209", hash_generated_field = "B6148CD104B71A9E8E7074ADA88973DC")

    private Calendar calendar;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:06.019 -0500", hash_original_method = "26136AA860D2CA0BB937B819E5CFDD9D", hash_generated_method = "CD8CEBEA0D1EA7A8CBA643E9A2647831")
    
public DTTZResponseData(Calendar cal) {
        super();
        calendar = cal;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:06.022 -0500", hash_original_method = "3B6DBE61112682FA3D432448D0A26FBC", hash_generated_method = "3F1FF4BEF079CE35B10D9B0109F1FBD5")
    
@Override
    public void format(ByteArrayOutputStream buf) {
        if (buf == null) {
            return;
        }

        // DTTZ object
        int tag = 0x80 | CommandType.PROVIDE_LOCAL_INFORMATION.value();
        buf.write(tag); // tag

        byte[] data = new byte[8];

        data[0] = 0x07; // Write length of DTTZ data

        if (calendar == null) {
            calendar = Calendar.getInstance();
        }
        // Fill year byte
        data[1] = byteToBCD(calendar.get(java.util.Calendar.YEAR) % 100);

        // Fill month byte
        data[2] = byteToBCD(calendar.get(java.util.Calendar.MONTH) + 1);

        // Fill day byte
        data[3] = byteToBCD(calendar.get(java.util.Calendar.DATE));

        // Fill hour byte
        data[4] = byteToBCD(calendar.get(java.util.Calendar.HOUR_OF_DAY));

        // Fill minute byte
        data[5] = byteToBCD(calendar.get(java.util.Calendar.MINUTE));

        // Fill second byte
        data[6] = byteToBCD(calendar.get(java.util.Calendar.SECOND));

        String tz = SystemProperties.get("persist.sys.timezone", "");
        if (TextUtils.isEmpty(tz)) {
            data[7] = (byte) 0xFF;    // set FF in terminal response
        } else {
            TimeZone zone = TimeZone.getTimeZone(tz);
            int zoneOffset = zone.getRawOffset() + zone.getDSTSavings();
            data[7] = getTZOffSetByte(zoneOffset);
        }

        for (byte b : data) {
            buf.write(b);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:06.025 -0500", hash_original_method = "8DC11942C3F1A663AB0155C3D476E532", hash_generated_method = "B70F52F97FF1301795377794A9A46DA9")
    
private byte byteToBCD(int value) {
        if (value < 0 && value > 99) {
            CatLog.d(this, "Err: byteToBCD conversion Value is " + value +
                           " Value has to be between 0 and 99");
            return 0;
        }

        return (byte) ((value / 10) | ((value % 10) << 4));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:06.027 -0500", hash_original_method = "024E89671E7DB3E94FD073693C0532F0", hash_generated_method = "43B31C648F1D850CEAF13F9D4610C915")
    
private byte getTZOffSetByte(long offSetVal) {
        boolean isNegative = (offSetVal < 0);

        /*
         * The 'offSetVal' is in milliseconds. Convert it to hours and compute
         * offset While sending T.R to UICC, offset is expressed is 'quarters of
         * hours'
         */

         long tzOffset = offSetVal / (15 * 60 * 1000);
         tzOffset = (isNegative ? -1 : 1) * tzOffset;
         byte bcdVal = byteToBCD((int) tzOffset);
         // For negative offsets, put '1' in the msb
         return isNegative ?  (bcdVal |= 0x08) : bcdVal;
    }
    
}

