package com.android.internal.telephony.cat;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.internal.telephony.EncodeException;
import com.android.internal.telephony.GsmAlphabet;
import java.util.Calendar;
import java.util.TimeZone;
import android.os.SystemProperties;
import android.text.TextUtils;
import com.android.internal.telephony.cat.AppInterface.CommandType;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

abstract class ResponseData {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.967 -0400", hash_original_method = "35A3C43837512FE87B6AB425039DE5F3", hash_generated_method = "35A3C43837512FE87B6AB425039DE5F3")
        public ResponseData ()
    {
    }


    public abstract void format(ByteArrayOutputStream buf);

    
        public static void writeLength(ByteArrayOutputStream buf, int length) {
        if (length > 0x7F) {
            buf.write(0x81);
        }
        buf.write(length);
    }

    
}

class SelectItemResponseData extends ResponseData {
    private int id;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.968 -0400", hash_original_method = "88F47DF9733601EED859AE224777BF09", hash_generated_method = "2B5DB15CD8B41D5D8BC0A232614265D9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SelectItemResponseData(int id) {
        super();
        dsTaint.addTaint(id);
        // ---------- Original Method ----------
        //this.id = id;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.968 -0400", hash_original_method = "FAE871B2C12637F0B15E3EAC43330DD6", hash_generated_method = "8A92CA26D79A32D91A6F7D59A22A07FC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void format(ByteArrayOutputStream buf) {
        dsTaint.addTaint(buf.dsTaint);
        int tag;
        tag = 0x80 | ComprehensionTlvTag.ITEM_ID.value();
        buf.write(tag);
        buf.write(1);
        buf.write(id);
        // ---------- Original Method ----------
        //int tag = 0x80 | ComprehensionTlvTag.ITEM_ID.value();
        //buf.write(tag);
        //buf.write(1);
        //buf.write(id);
    }

    
}

class GetInkeyInputResponseData extends ResponseData {
    private boolean mIsUcs2;
    private boolean mIsPacked;
    private boolean mIsYesNo;
    private boolean mYesNoResponse;
    public String mInData;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.968 -0400", hash_original_method = "C406233D38E0F3E58D00D02791A05027", hash_generated_method = "78B3401D6D0EFEDC34B15354F8E69A55")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public GetInkeyInputResponseData(String inData, boolean ucs2, boolean packed) {
        super();
        dsTaint.addTaint(packed);
        dsTaint.addTaint(ucs2);
        dsTaint.addTaint(inData);
        this.mIsYesNo = false;
        // ---------- Original Method ----------
        //this.mIsUcs2 = ucs2;
        //this.mIsPacked = packed;
        //this.mInData = inData;
        //this.mIsYesNo = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.969 -0400", hash_original_method = "3E22EF603F248A198EBAA27D03FAD9D9", hash_generated_method = "A8E682917DB5626323ED9D0F971DB1B4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public GetInkeyInputResponseData(boolean yesNoResponse) {
        super();
        dsTaint.addTaint(yesNoResponse);
        this.mIsUcs2 = false;
        this.mIsPacked = false;
        this.mInData = "";
        this.mIsYesNo = true;
        // ---------- Original Method ----------
        //this.mIsUcs2 = false;
        //this.mIsPacked = false;
        //this.mInData = "";
        //this.mIsYesNo = true;
        //this.mYesNoResponse = yesNoResponse;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.977 -0400", hash_original_method = "E3DE4DD341771272E5ED5B0598896B15", hash_generated_method = "9FE0828B7514E5ED77B6A8D0284FB199")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void format(ByteArrayOutputStream buf) {
        dsTaint.addTaint(buf.dsTaint);
        int tag;
        tag = 0x80 | ComprehensionTlvTag.TEXT_STRING.value();
        buf.write(tag);
        byte[] data;
        {
            data = new byte[1];
            data[0] = mYesNoResponse ? GET_INKEY_YES : GET_INKEY_NO;
        } //End block
        {
            boolean varAF7BC449AD8E34CF362E47CF5B49C901_577371306 = (mInData != null && mInData.length() > 0);
            {
                try 
                {
                    {
                        data = mInData.getBytes("UTF-16");
                    } //End block
                    {
                        int size;
                        size = mInData.length();
                        byte[] tempData;
                        tempData = GsmAlphabet
                            .stringToGsm7BitPacked(mInData, 0, 0);
                        data = new byte[size];
                        System.arraycopy(tempData, 1, data, 0, size);
                    } //End block
                    {
                        data = GsmAlphabet.stringToGsm8BitPacked(mInData);
                    } //End block
                } //End block
                catch (UnsupportedEncodingException e)
                {
                    data = new byte[0];
                } //End block
                catch (EncodeException e)
                {
                    data = new byte[0];
                } //End block
            } //End block
            {
                data = new byte[0];
            } //End block
        } //End collapsed parenthetic
        writeLength(buf, data.length + 1);
        {
            buf.write(0x08);
        } //End block
        {
            buf.write(0x00);
        } //End block
        {
            buf.write(0x04);
        } //End block
        {
            byte b = data[0];
            {
                buf.write(b);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    protected static final byte GET_INKEY_YES = 0x01;
    protected static final byte GET_INKEY_NO = 0x00;
}

class LanguageResponseData extends ResponseData {
    private String lang;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.977 -0400", hash_original_method = "9749992F218E6C6526070AE3BD9D1725", hash_generated_method = "CDA8307AB2B48C5724A8735808A33EFE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LanguageResponseData(String lang) {
        super();
        dsTaint.addTaint(lang);
        // ---------- Original Method ----------
        //this.lang = lang;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.981 -0400", hash_original_method = "0658244A9E7567A9FE447A4F6CD905F4", hash_generated_method = "22C0C3F34C725034EF1F12CC475074E9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void format(ByteArrayOutputStream buf) {
        dsTaint.addTaint(buf.dsTaint);
        int tag;
        tag = 0x80 | ComprehensionTlvTag.LANGUAGE.value();
        buf.write(tag);
        byte[] data;
        {
            boolean var8027EECC5D064BEF0A00D9F8174F99D0_122376687 = (lang != null && lang.length() > 0);
            {
                data = GsmAlphabet.stringToGsm8BitPacked(lang);
            } //End block
            {
                data = new byte[0];
            } //End block
        } //End collapsed parenthetic
        buf.write(data.length);
        {
            byte b = data[0];
            {
                buf.write(b);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (buf == null) {
            //return;
        //}
        //int tag = 0x80 | ComprehensionTlvTag.LANGUAGE.value();
        //buf.write(tag);
        //byte[] data;
        //if (lang != null && lang.length() > 0) {
            //data = GsmAlphabet.stringToGsm8BitPacked(lang);
        //}
        //else {
            //data = new byte[0];
        //}
        //buf.write(data.length);
        //for (byte b : data) {
            //buf.write(b);
        //}
    }

    
}

class DTTZResponseData extends ResponseData {
    private Calendar calendar;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.981 -0400", hash_original_method = "26136AA860D2CA0BB937B819E5CFDD9D", hash_generated_method = "B650278F1E2C9FB30C8FC564909B1E7C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DTTZResponseData(Calendar cal) {
        super();
        dsTaint.addTaint(cal.dsTaint);
        // ---------- Original Method ----------
        //calendar = cal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.992 -0400", hash_original_method = "3B6DBE61112682FA3D432448D0A26FBC", hash_generated_method = "6E90832060040AF1CD1C8D29775FE7DD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void format(ByteArrayOutputStream buf) {
        dsTaint.addTaint(buf.dsTaint);
        int tag;
        tag = 0x80 | CommandType.PROVIDE_LOCAL_INFORMATION.value();
        buf.write(tag);
        byte[] data;
        data = new byte[8];
        data[0] = 0x07;
        {
            calendar = Calendar.getInstance();
        } //End block
        data[1] = byteToBCD(calendar.get(java.util.Calendar.YEAR) % 100);
        data[2] = byteToBCD(calendar.get(java.util.Calendar.MONTH) + 1);
        data[3] = byteToBCD(calendar.get(java.util.Calendar.DATE));
        data[4] = byteToBCD(calendar.get(java.util.Calendar.HOUR_OF_DAY));
        data[5] = byteToBCD(calendar.get(java.util.Calendar.MINUTE));
        data[6] = byteToBCD(calendar.get(java.util.Calendar.SECOND));
        String tz;
        tz = SystemProperties.get("persist.sys.timezone", "");
        {
            boolean varBE27629B530FF8FC4D965B3B47C97135_75756603 = (TextUtils.isEmpty(tz));
            {
                data[7] = (byte) 0xFF;
            } //End block
            {
                TimeZone zone;
                zone = TimeZone.getTimeZone(tz);
                int zoneOffset;
                zoneOffset = zone.getRawOffset() + zone.getDSTSavings();
                data[7] = getTZOffSetByte(zoneOffset);
            } //End block
        } //End collapsed parenthetic
        {
            byte b = data[0];
            {
                buf.write(b);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.992 -0400", hash_original_method = "8DC11942C3F1A663AB0155C3D476E532", hash_generated_method = "FBAD4743D63304AB14E66228DF93D07D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private byte byteToBCD(int value) {
        dsTaint.addTaint(value);
        {
            CatLog.d(this, "Err: byteToBCD conversion Value is " + value +
                           " Value has to be between 0 and 99");
        } //End block
        return dsTaint.getTaintByte();
        // ---------- Original Method ----------
        //if (value < 0 && value > 99) {
            //CatLog.d(this, "Err: byteToBCD conversion Value is " + value +
                           //" Value has to be between 0 and 99");
            //return 0;
        //}
        //return (byte) ((value / 10) | ((value % 10) << 4));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.993 -0400", hash_original_method = "024E89671E7DB3E94FD073693C0532F0", hash_generated_method = "49C190739D12FEFAC9E415CCDBB93FA7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private byte getTZOffSetByte(long offSetVal) {
        dsTaint.addTaint(offSetVal);
        boolean isNegative;
        isNegative = (offSetVal < 0);
        long tzOffset;
        tzOffset = offSetVal / (15 * 60 * 1000);
        tzOffset = (isNegative ? -1 : 1) * tzOffset;
        byte bcdVal;
        bcdVal = byteToBCD((int) tzOffset);
        return dsTaint.getTaintByte();
        // ---------- Original Method ----------
        //boolean isNegative = (offSetVal < 0);
        //long tzOffset = offSetVal / (15 * 60 * 1000);
        //tzOffset = (isNegative ? -1 : 1) * tzOffset;
        //byte bcdVal = byteToBCD((int) tzOffset);
        //return isNegative ?  (bcdVal |= 0x08) : bcdVal;
    }

    
}

