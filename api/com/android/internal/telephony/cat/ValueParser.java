package com.android.internal.telephony.cat;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import com.android.internal.telephony.GsmAlphabet;
import com.android.internal.telephony.IccUtils;
import com.android.internal.telephony.cat.Duration.TimeUnit;





abstract class ValueParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:21.076 -0400", hash_original_method = "536C7A90AC0042B9CC31730ED4B5756F", hash_generated_method = "536C7A90AC0042B9CC31730ED4B5756F")
    public ValueParser ()
    {
        //Synthesized constructor
    }


    static CommandDetails retrieveCommandDetails(ComprehensionTlv ctlv) throws ResultException {
        CommandDetails cmdDet = new CommandDetails();
        byte[] rawValue = ctlv.getRawValue();
        int valueIndex = ctlv.getValueIndex();
        try {
            cmdDet.compRequired = ctlv.isComprehensionRequired();
            cmdDet.commandNumber = rawValue[valueIndex] & 0xff;
            cmdDet.typeOfCommand = rawValue[valueIndex + 1] & 0xff;
            cmdDet.commandQualifier = rawValue[valueIndex + 2] & 0xff;
            return cmdDet;
        } catch (IndexOutOfBoundsException e) {
            throw new ResultException(ResultCode.CMD_DATA_NOT_UNDERSTOOD);
        }
    }

    
    static DeviceIdentities retrieveDeviceIdentities(ComprehensionTlv ctlv) throws ResultException {
        DeviceIdentities devIds = new DeviceIdentities();
        byte[] rawValue = ctlv.getRawValue();
        int valueIndex = ctlv.getValueIndex();
        try {
            devIds.sourceId = rawValue[valueIndex] & 0xff;
            devIds.destinationId = rawValue[valueIndex + 1] & 0xff;
            return devIds;
        } catch (IndexOutOfBoundsException e) {
            throw new ResultException(ResultCode.REQUIRED_VALUES_MISSING);
        }
    }

    
    @DSModeled(DSC.SPEC)
    static Duration retrieveDuration(ComprehensionTlv ctlv) throws ResultException {
        int timeInterval = 0;
        TimeUnit timeUnit = TimeUnit.SECOND;
        byte[] rawValue = ctlv.getRawValue();
        int valueIndex = ctlv.getValueIndex();
        try {
            timeUnit = TimeUnit.values()[(rawValue[valueIndex] & 0xff)];
            timeInterval = rawValue[valueIndex + 1] & 0xff;
        } catch (IndexOutOfBoundsException e) {
            throw new ResultException(ResultCode.CMD_DATA_NOT_UNDERSTOOD);
        }
        return new Duration(timeInterval, timeUnit);
    }

    
    @DSModeled(DSC.SPEC)
    static Item retrieveItem(ComprehensionTlv ctlv) throws ResultException {
        Item item = null;
        byte[] rawValue = ctlv.getRawValue();
        int valueIndex = ctlv.getValueIndex();
        int length = ctlv.getLength();
        if (length != 0) {
            int textLen = length - 1;
            try {
                int id = rawValue[valueIndex] & 0xff;
                String text = IccUtils.adnStringFieldToString(rawValue,
                        valueIndex + 1, textLen);
                item = new Item(id, text);
            } catch (IndexOutOfBoundsException e) {
                throw new ResultException(ResultCode.CMD_DATA_NOT_UNDERSTOOD);
            }
        }
        return item;
    }

    
    static int retrieveItemId(ComprehensionTlv ctlv) throws ResultException {
        int id = 0;
        byte[] rawValue = ctlv.getRawValue();
        int valueIndex = ctlv.getValueIndex();
        try {
            id = rawValue[valueIndex] & 0xff;
        } catch (IndexOutOfBoundsException e) {
            throw new ResultException(ResultCode.CMD_DATA_NOT_UNDERSTOOD);
        }
        return id;
    }

    
    @DSModeled(DSC.SPEC)
    static IconId retrieveIconId(ComprehensionTlv ctlv) throws ResultException {
        IconId id = new IconId();
        byte[] rawValue = ctlv.getRawValue();
        int valueIndex = ctlv.getValueIndex();
        try {
            id.selfExplanatory = (rawValue[valueIndex++] & 0xff) == 0x00;
            id.recordNumber = rawValue[valueIndex] & 0xff;
        } catch (IndexOutOfBoundsException e) {
            throw new ResultException(ResultCode.CMD_DATA_NOT_UNDERSTOOD);
        }
        return id;
    }

    
    @DSModeled(DSC.SPEC)
    static ItemsIconId retrieveItemsIconId(ComprehensionTlv ctlv) throws ResultException {
        CatLog.d("ValueParser", "retrieveItemsIconId:");
        ItemsIconId id = new ItemsIconId();
        byte[] rawValue = ctlv.getRawValue();
        int valueIndex = ctlv.getValueIndex();
        int numOfItems = ctlv.getLength() - 1;
        id.recordNumbers = new int[numOfItems];
        try {
            id.selfExplanatory = (rawValue[valueIndex++] & 0xff) == 0x00;
            for (int index = 0; index < numOfItems;) {
                id.recordNumbers[index++] = rawValue[valueIndex++];
            }
        } catch (IndexOutOfBoundsException e) {
            throw new ResultException(ResultCode.CMD_DATA_NOT_UNDERSTOOD);
        }
        return id;
    }

    
    static List<TextAttribute> retrieveTextAttribute(ComprehensionTlv ctlv) throws ResultException {
        ArrayList<TextAttribute> lst = new ArrayList<TextAttribute>();
        byte[] rawValue = ctlv.getRawValue();
        int valueIndex = ctlv.getValueIndex();
        int length = ctlv.getLength();
        if (length != 0) {
            int itemCount = length / 4;
            try {
                for (int i = 0; i < itemCount; i++, valueIndex += 4) {
                    int start = rawValue[valueIndex] & 0xff;
                    int textLength = rawValue[valueIndex + 1] & 0xff;
                    int format = rawValue[valueIndex + 2] & 0xff;
                    int colorValue = rawValue[valueIndex + 3] & 0xff;
                    int alignValue = format & 0x03;
                    TextAlignment align = TextAlignment.fromInt(alignValue);
                    int sizeValue = (format >> 2) & 0x03;
                    FontSize size = FontSize.fromInt(sizeValue);
                    if (size == null) {
                        size = FontSize.NORMAL;
                    }
                    boolean bold = (format & 0x10) != 0;
                    boolean italic = (format & 0x20) != 0;
                    boolean underlined = (format & 0x40) != 0;
                    boolean strikeThrough = (format & 0x80) != 0;
                    TextColor color = TextColor.fromInt(colorValue);
                    TextAttribute attr = new TextAttribute(start, textLength,
                            align, size, bold, italic, underlined,
                            strikeThrough, color);
                    lst.add(attr);
                }
                return lst;
            } catch (IndexOutOfBoundsException e) {
                throw new ResultException(ResultCode.CMD_DATA_NOT_UNDERSTOOD);
            }
        }
        return null;
    }

    
    @DSModeled(DSC.SPEC)
    static String retrieveAlphaId(ComprehensionTlv ctlv) throws ResultException {
        if (ctlv != null) {
            byte[] rawValue = ctlv.getRawValue();
            int valueIndex = ctlv.getValueIndex();
            int length = ctlv.getLength();
            if (length != 0) {
                try {
                    return IccUtils.adnStringFieldToString(rawValue, valueIndex,
                            length);
                } catch (IndexOutOfBoundsException e) {
                    throw new ResultException(ResultCode.CMD_DATA_NOT_UNDERSTOOD);
                }
            } else {
                return CatService.STK_DEFAULT;
            }
        } else {
            return CatService.STK_DEFAULT;
        }
    }

    
    static String retrieveTextString(ComprehensionTlv ctlv) throws ResultException {
        byte[] rawValue = ctlv.getRawValue();
        int valueIndex = ctlv.getValueIndex();
        byte codingScheme = 0x00;
        String text = null;
        int textLen = ctlv.getLength();
        if (textLen == 0) {
            return text;
        } else {
            textLen -= 1;
        }
        try {
            codingScheme = (byte) (rawValue[valueIndex] & 0x0c);
            if (codingScheme == 0x00) { 
                text = GsmAlphabet.gsm7BitPackedToString(rawValue,
                        valueIndex + 1, (textLen * 8) / 7);
            } else if (codingScheme == 0x04) { 
                text = GsmAlphabet.gsm8BitUnpackedToString(rawValue,
                        valueIndex + 1, textLen);
            } else if (codingScheme == 0x08) { 
                text = new String(rawValue, valueIndex + 1, textLen, "UTF-16");
            } else {
                throw new ResultException(ResultCode.CMD_DATA_NOT_UNDERSTOOD);
            }
            return text;
        } catch (IndexOutOfBoundsException e) {
            throw new ResultException(ResultCode.CMD_DATA_NOT_UNDERSTOOD);
        } catch (UnsupportedEncodingException e) {
            throw new ResultException(ResultCode.CMD_DATA_NOT_UNDERSTOOD);
        }
    }

    
}

