package com.android.internal.telephony.cat;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.715 -0400", hash_original_method = "814762139FDC16047D72234D9356528B", hash_generated_method = "814762139FDC16047D72234D9356528B")
    public ResponseData ()
    {
        
    }


    public abstract void format(ByteArrayOutputStream buf);

    
    @DSModeled(DSC.SAFE)
    public static void writeLength(ByteArrayOutputStream buf, int length) {
        if (length > 0x7F) {
            buf.write(0x81);
        }
        buf.write(length);
    }

    
}

class SelectItemResponseData extends ResponseData {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.715 -0400", hash_original_field = "B80BB7740288FDA1F201890375A60C8F", hash_generated_field = "D0FAB3735D60E909B66356CA0D9609D4")

    private int id;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.716 -0400", hash_original_method = "88F47DF9733601EED859AE224777BF09", hash_generated_method = "8FDACCA548D165B7C04215788EACD650")
    public  SelectItemResponseData(int id) {
        super();
        this.id = id;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.716 -0400", hash_original_method = "FAE871B2C12637F0B15E3EAC43330DD6", hash_generated_method = "08CB218F19B7394F85B963923961E0D4")
    @Override
    public void format(ByteArrayOutputStream buf) {
        int tag = 0x80 | ComprehensionTlvTag.ITEM_ID.value();
        buf.write(tag);
        buf.write(1);
        buf.write(id);
        addTaint(buf.getTaint());
        
        
        
        
        
    }

    
}

class GetInkeyInputResponseData extends ResponseData {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.716 -0400", hash_original_field = "DD314C6D6EABE02C565F3D911E9E1EF7", hash_generated_field = "7A163219ACAA280A67D5C441240B368C")

    private boolean mIsUcs2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.716 -0400", hash_original_field = "BB782F269FEF78F47416E841759943A1", hash_generated_field = "C7E1E0CC35595105CCA5F93C6C3DF701")

    private boolean mIsPacked;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.716 -0400", hash_original_field = "B9079E8B656C8BCC4787A04D5B6FE574", hash_generated_field = "98AE801F3C8B2189363BF9443058020F")

    private boolean mIsYesNo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.716 -0400", hash_original_field = "780AD5259707B9C806D32F27397DBE32", hash_generated_field = "0BD5F3C992962F453EE25C1AA0328C36")

    private boolean mYesNoResponse;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.716 -0400", hash_original_field = "9B183E32C2A5DEF03E509F1D90AACA42", hash_generated_field = "8CCEC3CAA13C0879C8CF36F964AE6DFC")

    public String mInData;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.716 -0400", hash_original_method = "C406233D38E0F3E58D00D02791A05027", hash_generated_method = "695D3A66BAC879130627520F8DC3C22A")
    public  GetInkeyInputResponseData(String inData, boolean ucs2, boolean packed) {
        super();
        this.mIsUcs2 = ucs2;
        this.mIsPacked = packed;
        this.mInData = inData;
        this.mIsYesNo = false;
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.717 -0400", hash_original_method = "3E22EF603F248A198EBAA27D03FAD9D9", hash_generated_method = "6C46507AEDB6686D6B987AB23A7B2504")
    public  GetInkeyInputResponseData(boolean yesNoResponse) {
        super();
        this.mIsUcs2 = false;
        this.mIsPacked = false;
        this.mInData = "";
        this.mIsYesNo = true;
        this.mYesNoResponse = yesNoResponse;
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.725 -0400", hash_original_method = "E3DE4DD341771272E5ED5B0598896B15", hash_generated_method = "8462FAF75D490045536F9167D46D8EA0")
    @Override
    public void format(ByteArrayOutputStream buf) {
        int tag = 0x80 | ComprehensionTlvTag.TEXT_STRING.value();
        buf.write(tag);
        byte[] data;
        {
            data = new byte[1];
            data[0] = mYesNoResponse ? GET_INKEY_YES : GET_INKEY_NO;
        } 
        {
            boolean varAF7BC449AD8E34CF362E47CF5B49C901_1048914615 = (mInData != null && mInData.length() > 0);
            {
                try 
                {
                    {
                        data = mInData.getBytes("UTF-16");
                    } 
                    {
                        int size = mInData.length();
                        byte[] tempData = GsmAlphabet
                            .stringToGsm7BitPacked(mInData, 0, 0);
                        data = new byte[size];
                        System.arraycopy(tempData, 1, data, 0, size);
                    } 
                    {
                        data = GsmAlphabet.stringToGsm8BitPacked(mInData);
                    } 
                } 
                catch (UnsupportedEncodingException e)
                {
                    data = new byte[0];
                } 
                catch (EncodeException e)
                {
                    data = new byte[0];
                } 
            } 
            {
                data = new byte[0];
            } 
        } 
        writeLength(buf, data.length + 1);
        {
            buf.write(0x08);
        } 
        {
            buf.write(0x00);
        } 
        {
            buf.write(0x04);
        } 
        {
            byte b = data[0];
            {
                buf.write(b);
            } 
        } 
        addTaint(buf.getTaint());
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.725 -0400", hash_original_field = "2E593AC04927F7A67E8FCA33F461E452", hash_generated_field = "9D940471AD91F9981E205232344ACB7E")

    protected static final byte GET_INKEY_YES = 0x01;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.726 -0400", hash_original_field = "FA311FB5C3BB3E489151126FDCB57CF7", hash_generated_field = "41FDA2BEBCE7070771A64B9759D1B302")

    protected static final byte GET_INKEY_NO = 0x00;
}

class LanguageResponseData extends ResponseData {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.726 -0400", hash_original_field = "7572559CA86E781BA8FE8073A0B725C6", hash_generated_field = "A84B1735D4DE391663408D2BFC463BA0")

    private String lang;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.726 -0400", hash_original_method = "9749992F218E6C6526070AE3BD9D1725", hash_generated_method = "3C29681DBE25379AD559230B3B193A5D")
    public  LanguageResponseData(String lang) {
        super();
        this.lang = lang;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.730 -0400", hash_original_method = "0658244A9E7567A9FE447A4F6CD905F4", hash_generated_method = "C405539A45D646822A212ACC281AD016")
    @Override
    public void format(ByteArrayOutputStream buf) {
        int tag = 0x80 | ComprehensionTlvTag.LANGUAGE.value();
        buf.write(tag);
        byte[] data;
        {
            boolean var8027EECC5D064BEF0A00D9F8174F99D0_1331139599 = (lang != null && lang.length() > 0);
            {
                data = GsmAlphabet.stringToGsm8BitPacked(lang);
            } 
            {
                data = new byte[0];
            } 
        } 
        buf.write(data.length);
        {
            byte b = data[0];
            {
                buf.write(b);
            } 
        } 
        addTaint(buf.getTaint());
        
        
            
        
        
        
        
        
            
        
        
            
        
        
        
            
        
    }

    
}

class DTTZResponseData extends ResponseData {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.731 -0400", hash_original_field = "A0E7B2A565119C0A7EC3126A16016113", hash_generated_field = "B6148CD104B71A9E8E7074ADA88973DC")

    private Calendar calendar;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.731 -0400", hash_original_method = "26136AA860D2CA0BB937B819E5CFDD9D", hash_generated_method = "4F6BBC2786F3BE4258FAD407CA694BE3")
    public  DTTZResponseData(Calendar cal) {
        super();
        calendar = cal;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.740 -0400", hash_original_method = "3B6DBE61112682FA3D432448D0A26FBC", hash_generated_method = "4B7D8A04B8F6124DC63EB52A17450149")
    @Override
    public void format(ByteArrayOutputStream buf) {
        int tag = 0x80 | CommandType.PROVIDE_LOCAL_INFORMATION.value();
        buf.write(tag);
        byte[] data = new byte[8];
        data[0] = 0x07;
        {
            calendar = Calendar.getInstance();
        } 
        data[1] = byteToBCD(calendar.get(java.util.Calendar.YEAR) % 100);
        data[2] = byteToBCD(calendar.get(java.util.Calendar.MONTH) + 1);
        data[3] = byteToBCD(calendar.get(java.util.Calendar.DATE));
        data[4] = byteToBCD(calendar.get(java.util.Calendar.HOUR_OF_DAY));
        data[5] = byteToBCD(calendar.get(java.util.Calendar.MINUTE));
        data[6] = byteToBCD(calendar.get(java.util.Calendar.SECOND));
        String tz = SystemProperties.get("persist.sys.timezone", "");
        {
            boolean varBE27629B530FF8FC4D965B3B47C97135_1408319867 = (TextUtils.isEmpty(tz));
            {
                data[7] = (byte) 0xFF;
            } 
            {
                TimeZone zone = TimeZone.getTimeZone(tz);
                int zoneOffset = zone.getRawOffset() + zone.getDSTSavings();
                data[7] = getTZOffSetByte(zoneOffset);
            } 
        } 
        {
            byte b = data[0];
            {
                buf.write(b);
            } 
        } 
        addTaint(buf.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.741 -0400", hash_original_method = "8DC11942C3F1A663AB0155C3D476E532", hash_generated_method = "648754F12720334656C0A45620B07C9A")
    private byte byteToBCD(int value) {
        {
            CatLog.d(this, "Err: byteToBCD conversion Value is " + value +
                           " Value has to be between 0 and 99");
        } 
        addTaint(value);
        byte var40EA57D3EE3C07BF1C102B466E1C3091_213356495 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_213356495;
        
        
            
                           
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.741 -0400", hash_original_method = "024E89671E7DB3E94FD073693C0532F0", hash_generated_method = "53B02B315399AB83ED691808B4499DA8")
    private byte getTZOffSetByte(long offSetVal) {
        boolean isNegative = (offSetVal < 0);
        long tzOffset = offSetVal / (15 * 60 * 1000);
        tzOffset = (isNegative ? -1 : 1) * tzOffset;
        byte bcdVal = byteToBCD((int) tzOffset);
        addTaint(offSetVal);
        byte var40EA57D3EE3C07BF1C102B466E1C3091_1382554106 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_1382554106;
        
        
        
        
        
        
    }

    
}

