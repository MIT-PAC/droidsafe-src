package com.android.internal.telephony.cat;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.412 -0400", hash_original_method = "814762139FDC16047D72234D9356528B", hash_generated_method = "814762139FDC16047D72234D9356528B")
    public ResponseData ()
    {
        //Synthesized constructor
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.413 -0400", hash_original_field = "B80BB7740288FDA1F201890375A60C8F", hash_generated_field = "D0FAB3735D60E909B66356CA0D9609D4")

    private int id;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.413 -0400", hash_original_method = "88F47DF9733601EED859AE224777BF09", hash_generated_method = "8FDACCA548D165B7C04215788EACD650")
    public  SelectItemResponseData(int id) {
        super();
        this.id = id;
        // ---------- Original Method ----------
        //this.id = id;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.414 -0400", hash_original_method = "FAE871B2C12637F0B15E3EAC43330DD6", hash_generated_method = "CECB634E554E8BC6CEBD7D9B1BFD2352")
    @Override
    public void format(ByteArrayOutputStream buf) {
        addTaint(buf.getTaint());
        int tag = 0x80 | ComprehensionTlvTag.ITEM_ID.value();
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.414 -0400", hash_original_field = "DD314C6D6EABE02C565F3D911E9E1EF7", hash_generated_field = "7A163219ACAA280A67D5C441240B368C")

    private boolean mIsUcs2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.414 -0400", hash_original_field = "BB782F269FEF78F47416E841759943A1", hash_generated_field = "C7E1E0CC35595105CCA5F93C6C3DF701")

    private boolean mIsPacked;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.414 -0400", hash_original_field = "B9079E8B656C8BCC4787A04D5B6FE574", hash_generated_field = "98AE801F3C8B2189363BF9443058020F")

    private boolean mIsYesNo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.414 -0400", hash_original_field = "780AD5259707B9C806D32F27397DBE32", hash_generated_field = "0BD5F3C992962F453EE25C1AA0328C36")

    private boolean mYesNoResponse;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.414 -0400", hash_original_field = "9B183E32C2A5DEF03E509F1D90AACA42", hash_generated_field = "8CCEC3CAA13C0879C8CF36F964AE6DFC")

    public String mInData;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.415 -0400", hash_original_method = "C406233D38E0F3E58D00D02791A05027", hash_generated_method = "695D3A66BAC879130627520F8DC3C22A")
    public  GetInkeyInputResponseData(String inData, boolean ucs2, boolean packed) {
        super();
        this.mIsUcs2 = ucs2;
        this.mIsPacked = packed;
        this.mInData = inData;
        this.mIsYesNo = false;
        // ---------- Original Method ----------
        //this.mIsUcs2 = ucs2;
        //this.mIsPacked = packed;
        //this.mInData = inData;
        //this.mIsYesNo = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.416 -0400", hash_original_method = "3E22EF603F248A198EBAA27D03FAD9D9", hash_generated_method = "6C46507AEDB6686D6B987AB23A7B2504")
    public  GetInkeyInputResponseData(boolean yesNoResponse) {
        super();
        this.mIsUcs2 = false;
        this.mIsPacked = false;
        this.mInData = "";
        this.mIsYesNo = true;
        this.mYesNoResponse = yesNoResponse;
        // ---------- Original Method ----------
        //this.mIsUcs2 = false;
        //this.mIsPacked = false;
        //this.mInData = "";
        //this.mIsYesNo = true;
        //this.mYesNoResponse = yesNoResponse;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.418 -0400", hash_original_method = "E3DE4DD341771272E5ED5B0598896B15", hash_generated_method = "3A9AECD6FEC65F2700888AC23DA8AB15")
    @Override
    public void format(ByteArrayOutputStream buf) {
        addTaint(buf.getTaint());
    if(buf == null)        
        {
            return;
        } //End block
        int tag = 0x80 | ComprehensionTlvTag.TEXT_STRING.value();
        buf.write(tag);
        byte[] data;
    if(mIsYesNo)        
        {
            data = new byte[1];
            data[0] = mYesNoResponse ? GET_INKEY_YES : GET_INKEY_NO;
        } //End block
        else
    if(mInData != null && mInData.length() > 0)        
        {
            try 
            {
    if(mIsUcs2)                
                {
                    data = mInData.getBytes("UTF-16");
                } //End block
                else
    if(mIsPacked)                
                {
                    int size = mInData.length();
                    byte[] tempData = GsmAlphabet
                            .stringToGsm7BitPacked(mInData, 0, 0);
                    data = new byte[size];
                    System.arraycopy(tempData, 1, data, 0, size);
                } //End block
                else
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
        else
        {
            data = new byte[0];
        } //End block
        writeLength(buf, data.length + 1);
    if(mIsUcs2)        
        {
            buf.write(0x08);
        } //End block
        else
    if(mIsPacked)        
        {
            buf.write(0x00);
        } //End block
        else
        {
            buf.write(0x04);
        } //End block
for(byte b : data)
        {
            buf.write(b);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.418 -0400", hash_original_field = "2E593AC04927F7A67E8FCA33F461E452", hash_generated_field = "9D940471AD91F9981E205232344ACB7E")

    protected static final byte GET_INKEY_YES = 0x01;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.419 -0400", hash_original_field = "FA311FB5C3BB3E489151126FDCB57CF7", hash_generated_field = "41FDA2BEBCE7070771A64B9759D1B302")

    protected static final byte GET_INKEY_NO = 0x00;
}

class LanguageResponseData extends ResponseData {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.419 -0400", hash_original_field = "7572559CA86E781BA8FE8073A0B725C6", hash_generated_field = "A84B1735D4DE391663408D2BFC463BA0")

    private String lang;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.419 -0400", hash_original_method = "9749992F218E6C6526070AE3BD9D1725", hash_generated_method = "3C29681DBE25379AD559230B3B193A5D")
    public  LanguageResponseData(String lang) {
        super();
        this.lang = lang;
        // ---------- Original Method ----------
        //this.lang = lang;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.420 -0400", hash_original_method = "0658244A9E7567A9FE447A4F6CD905F4", hash_generated_method = "4DD6D439ACF035ECB43B356A4BE97C82")
    @Override
    public void format(ByteArrayOutputStream buf) {
        addTaint(buf.getTaint());
    if(buf == null)        
        {
            return;
        } //End block
        int tag = 0x80 | ComprehensionTlvTag.LANGUAGE.value();
        buf.write(tag);
        byte[] data;
    if(lang != null && lang.length() > 0)        
        {
            data = GsmAlphabet.stringToGsm8BitPacked(lang);
        } //End block
        else
        {
            data = new byte[0];
        } //End block
        buf.write(data.length);
for(byte b : data)
        {
            buf.write(b);
        } //End block
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.420 -0400", hash_original_field = "A0E7B2A565119C0A7EC3126A16016113", hash_generated_field = "B6148CD104B71A9E8E7074ADA88973DC")

    private Calendar calendar;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.420 -0400", hash_original_method = "26136AA860D2CA0BB937B819E5CFDD9D", hash_generated_method = "4F6BBC2786F3BE4258FAD407CA694BE3")
    public  DTTZResponseData(Calendar cal) {
        super();
        calendar = cal;
        // ---------- Original Method ----------
        //calendar = cal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.422 -0400", hash_original_method = "3B6DBE61112682FA3D432448D0A26FBC", hash_generated_method = "1DD020A8BF61E1AB7A5B9EF0F9050AC9")
    @Override
    public void format(ByteArrayOutputStream buf) {
        addTaint(buf.getTaint());
    if(buf == null)        
        {
            return;
        } //End block
        int tag = 0x80 | CommandType.PROVIDE_LOCAL_INFORMATION.value();
        buf.write(tag);
        byte[] data = new byte[8];
        data[0] = 0x07;
    if(calendar == null)        
        {
            calendar = Calendar.getInstance();
        } //End block
        data[1] = byteToBCD(calendar.get(java.util.Calendar.YEAR) % 100);
        data[2] = byteToBCD(calendar.get(java.util.Calendar.MONTH) + 1);
        data[3] = byteToBCD(calendar.get(java.util.Calendar.DATE));
        data[4] = byteToBCD(calendar.get(java.util.Calendar.HOUR_OF_DAY));
        data[5] = byteToBCD(calendar.get(java.util.Calendar.MINUTE));
        data[6] = byteToBCD(calendar.get(java.util.Calendar.SECOND));
        String tz = SystemProperties.get("persist.sys.timezone", "");
    if(TextUtils.isEmpty(tz))        
        {
            data[7] = (byte) 0xFF;
        } //End block
        else
        {
            TimeZone zone = TimeZone.getTimeZone(tz);
            int zoneOffset = zone.getRawOffset() + zone.getDSTSavings();
            data[7] = getTZOffSetByte(zoneOffset);
        } //End block
for(byte b : data)
        {
            buf.write(b);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.422 -0400", hash_original_method = "8DC11942C3F1A663AB0155C3D476E532", hash_generated_method = "C66EC30D305CD1E1BAB0EAC9A78AC3D3")
    private byte byteToBCD(int value) {
        addTaint(value);
    if(value < 0 && value > 99)        
        {
            CatLog.d(this, "Err: byteToBCD conversion Value is " + value +
                           " Value has to be between 0 and 99");
            byte varCFCD208495D565EF66E7DFF9F98764DA_1448834412 = (0);
                        byte var40EA57D3EE3C07BF1C102B466E1C3091_1940649979 = getTaintByte();
            return var40EA57D3EE3C07BF1C102B466E1C3091_1940649979;
        } //End block
        byte var8C4E17D9A63FEDD9BDE42F898AFA6D50_1725812709 = ((byte) ((value / 10) | ((value % 10) << 4)));
                byte var40EA57D3EE3C07BF1C102B466E1C3091_47718312 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_47718312;
        // ---------- Original Method ----------
        //if (value < 0 && value > 99) {
            //CatLog.d(this, "Err: byteToBCD conversion Value is " + value +
                           //" Value has to be between 0 and 99");
            //return 0;
        //}
        //return (byte) ((value / 10) | ((value % 10) << 4));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.423 -0400", hash_original_method = "024E89671E7DB3E94FD073693C0532F0", hash_generated_method = "64229C4F0344157EE3F42075892DF7AA")
    private byte getTZOffSetByte(long offSetVal) {
        addTaint(offSetVal);
        boolean isNegative = (offSetVal < 0);
        long tzOffset = offSetVal / (15 * 60 * 1000);
        tzOffset = (isNegative ? -1 : 1) * tzOffset;
        byte bcdVal = byteToBCD((int) tzOffset);
        byte var3F88E896D91080236C3DCE7DFF23DE22_2027228773 = (isNegative ?  (bcdVal |= 0x08) : bcdVal);
                byte var40EA57D3EE3C07BF1C102B466E1C3091_308853846 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_308853846;
        // ---------- Original Method ----------
        //boolean isNegative = (offSetVal < 0);
        //long tzOffset = offSetVal / (15 * 60 * 1000);
        //tzOffset = (isNegative ? -1 : 1) * tzOffset;
        //byte bcdVal = byteToBCD((int) tzOffset);
        //return isNegative ?  (bcdVal |= 0x08) : bcdVal;
    }

    
}

