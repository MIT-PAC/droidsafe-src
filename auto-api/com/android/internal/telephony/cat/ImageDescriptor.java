package com.android.internal.telephony.cat;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public class ImageDescriptor {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.587 -0400", hash_original_field = "EAAE26A6FB20ED3EF54FB23BFA0B1FCC", hash_generated_field = "1589F848FE4FF192F7CCE1B9F9E85747")

    int width;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.587 -0400", hash_original_field = "B435E227D5DD201E1768B2BCB2E0AA81", hash_generated_field = "CE84F1587D182C1F0A32D7CD44443A18")

    int height;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.587 -0400", hash_original_field = "FB0C8E26071D3ADB58083A9B80FFD492", hash_generated_field = "7A4C0F8CCF555035587B540158C1ED93")

    int codingScheme;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.587 -0400", hash_original_field = "3F634A414D187368BC41638F11235CDC", hash_generated_field = "9998212AA5ED787718F88D7656A58119")

    int imageId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.587 -0400", hash_original_field = "24F4DDC8DC798AC5E1D5774B4BFF10AC", hash_generated_field = "1753376ABE62298B19764C7AC3D38675")

    int highOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.587 -0400", hash_original_field = "DB617A99F852E617C30C755001E367DF", hash_generated_field = "8BAAEC3311E4143ED3DC8A0EE29C40C4")

    int lowOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.587 -0400", hash_original_field = "2FA47F7C65FEC19CC163B195725E3844", hash_generated_field = "136C4DD872F8065EECD33F6CD4E7556E")

    int length;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.588 -0400", hash_original_method = "9D6AA19EA5B9D87B22803CD155673A0E", hash_generated_method = "C7915BDAFA725EF1255F3327B87FD7AD")
      ImageDescriptor() {
        width = 0;
        height = 0;
        codingScheme = 0;
        imageId = 0;
        highOffset = 0;
        lowOffset = 0;
        length = 0;
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.588 -0400", hash_original_field = "BAB035C2D852D1169C41BE86760D23E7", hash_generated_field = "C2F01D7F81D7E9D08700B627DDF8C2E3")

    static final int CODING_SCHEME_BASIC = 0x11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.588 -0400", hash_original_field = "BF63E0DB3A77D807B1B59B5E6DBE4ABD", hash_generated_field = "8A766D809237D2BE330A2E343E9F05E2")

    static final int CODING_SCHEME_COLOUR = 0x21;
}

