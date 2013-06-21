package com.android.internal.telephony.cat;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class ImageDescriptor {
    int width;
    int height;
    int codingScheme;
    int imageId;
    int highOffset;
    int lowOffset;
    int length;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.917 -0400", hash_original_method = "9D6AA19EA5B9D87B22803CD155673A0E", hash_generated_method = "C7915BDAFA725EF1255F3327B87FD7AD")
    @DSModeled(DSC.SAFE)
     ImageDescriptor() {
        width = 0;
        height = 0;
        codingScheme = 0;
        imageId = 0;
        highOffset = 0;
        lowOffset = 0;
        length = 0;
        // ---------- Original Method ----------
        //width = 0;
        //height = 0;
        //codingScheme = 0;
        //imageId = 0;
        //highOffset = 0;
        //lowOffset = 0;
        //length = 0;
    }

    
        static ImageDescriptor parse(byte[] rawData, int valueIndex) {
        ImageDescriptor d = new ImageDescriptor();
        try {
            d.width = rawData[valueIndex++] & 0xff;
            d.height = rawData[valueIndex++] & 0xff;
            d.codingScheme = rawData[valueIndex++] & 0xff;
            d.imageId = (rawData[valueIndex++] & 0xff) << 8;
            d.imageId |= rawData[valueIndex++] & 0xff;
            d.highOffset = (rawData[valueIndex++] & 0xff); 
            d.lowOffset = rawData[valueIndex++] & 0xff; 
            d.length = ((rawData[valueIndex++] & 0xff) << 8 | (rawData[valueIndex++] & 0xff));
        } catch (IndexOutOfBoundsException e) {
            CatLog.d("ImageDescripter", "parse; failed parsing image descriptor");
            d = null;
        }
        return d;
    }

    
    static final int CODING_SCHEME_BASIC = 0x11;
    static final int CODING_SCHEME_COLOUR = 0x21;
}

