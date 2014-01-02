package com.android.internal.telephony.cat;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;



public class ImageDescriptor {

    /**
     * Extract descriptor information about image instance.
     *
     * @param rawData
     * @param valueIndex
     * @return ImageDescriptor
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.680 -0500", hash_original_method = "4B0B8276597CEA521E1E338B4AADD471", hash_generated_method = "9283ED1C2044F4178961436920D7FF12")
    
static ImageDescriptor parse(byte[] rawData, int valueIndex) {
        ImageDescriptor d = new ImageDescriptor();
        try {
            d.width = rawData[valueIndex++] & 0xff;
            d.height = rawData[valueIndex++] & 0xff;
            d.codingScheme = rawData[valueIndex++] & 0xff;

            // parse image id
            d.imageId = (rawData[valueIndex++] & 0xff) << 8;
            d.imageId |= rawData[valueIndex++] & 0xff;
            // parse offset
            d.highOffset = (rawData[valueIndex++] & 0xff); // high byte offset
            d.lowOffset = rawData[valueIndex++] & 0xff; // low byte offset

            d.length = ((rawData[valueIndex++] & 0xff) << 8 | (rawData[valueIndex++] & 0xff));
        } catch (IndexOutOfBoundsException e) {
            CatLog.d("ImageDescripter", "parse; failed parsing image descriptor");
            d = null;
        }
        return d;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.673 -0500", hash_original_field = "AF59108B908857B594C56487BB342407", hash_generated_field = "C2F01D7F81D7E9D08700B627DDF8C2E3")

    static final int CODING_SCHEME_BASIC = 0x11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.675 -0500", hash_original_field = "2F624C213F2DA9F4E7456447850DE470", hash_generated_field = "8A766D809237D2BE330A2E343E9F05E2")

    static final int CODING_SCHEME_COLOUR = 0x21;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.656 -0500", hash_original_field = "1589F848FE4FF192F7CCE1B9F9E85747", hash_generated_field = "1589F848FE4FF192F7CCE1B9F9E85747")

    int width;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.658 -0500", hash_original_field = "CE84F1587D182C1F0A32D7CD44443A18", hash_generated_field = "CE84F1587D182C1F0A32D7CD44443A18")

    int height;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.661 -0500", hash_original_field = "7A4C0F8CCF555035587B540158C1ED93", hash_generated_field = "7A4C0F8CCF555035587B540158C1ED93")

    int codingScheme;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.664 -0500", hash_original_field = "9998212AA5ED787718F88D7656A58119", hash_generated_field = "9998212AA5ED787718F88D7656A58119")

    int imageId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.666 -0500", hash_original_field = "1753376ABE62298B19764C7AC3D38675", hash_generated_field = "1753376ABE62298B19764C7AC3D38675")

    int highOffset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.668 -0500", hash_original_field = "8BAAEC3311E4143ED3DC8A0EE29C40C4", hash_generated_field = "8BAAEC3311E4143ED3DC8A0EE29C40C4")

    int lowOffset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.670 -0500", hash_original_field = "136C4DD872F8065EECD33F6CD4E7556E", hash_generated_field = "136C4DD872F8065EECD33F6CD4E7556E")

    int length;

    // public static final int ID_LENGTH = 9;
    // ID_LENGTH substituted by IccFileHandlerBase.GET_RESPONSE_EF_IMG_SIZE_BYTES

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.678 -0500", hash_original_method = "9D6AA19EA5B9D87B22803CD155673A0E", hash_generated_method = "9D6AA19EA5B9D87B22803CD155673A0E")
    
ImageDescriptor() {
        width = 0;
        height = 0;
        codingScheme = 0;
        imageId = 0;
        highOffset = 0;
        lowOffset = 0;
        length = 0;
    }
}

