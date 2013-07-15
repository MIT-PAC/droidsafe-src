package android.opengl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ETC1Util {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:30.175 -0400", hash_original_method = "16CF83B5F57C13CA789F8B6C84B3B95D", hash_generated_method = "16CF83B5F57C13CA789F8B6C84B3B95D")
    public ETC1Util ()
    {
        //Synthesized constructor
    }


        public static void loadTexture(int target, int level, int border,
            int fallbackFormat, int fallbackType, InputStream input) throws IOException {
        loadTexture(target, level, border, fallbackFormat, fallbackType, createTexture(input));
    }

    
        public static void loadTexture(int target, int level, int border,
            int fallbackFormat, int fallbackType, ETC1Texture texture) {
        if (fallbackFormat != GLES10.GL_RGB) {
            throw new IllegalArgumentException("fallbackFormat must be GL_RGB");
        }
        if (! (fallbackType == GLES10.GL_UNSIGNED_SHORT_5_6_5
                || fallbackType == GLES10.GL_UNSIGNED_BYTE)) {
            throw new IllegalArgumentException("Unsupported fallbackType");
        }
        int width = texture.getWidth();
        int height = texture.getHeight();
        Buffer data = texture.getData();
        if (isETC1Supported()) {
            int imageSize = data.remaining();
            GLES10.glCompressedTexImage2D(target, level, ETC1.ETC1_RGB8_OES, width, height,
                    border, imageSize, data);
        } else {
            boolean useShorts = fallbackType != GLES10.GL_UNSIGNED_BYTE;
            int pixelSize = useShorts ? 2 : 3;
            int stride = pixelSize * width;
            ByteBuffer decodedData = ByteBuffer.allocateDirect(stride*height)
                .order(ByteOrder.nativeOrder());
            ETC1.decodeImage(data, decodedData, width, height, pixelSize, stride);
            GLES10.glTexImage2D(target, level, fallbackFormat, width, height, border,
                    fallbackFormat, fallbackType, decodedData);
        }
    }

    
        public static boolean isETC1Supported() {
        int[] results = new int[20];
        GLES10.glGetIntegerv(GLES10.GL_NUM_COMPRESSED_TEXTURE_FORMATS, results, 0);
        int numFormats = results[0];
        if (numFormats > results.length) {
            results = new int[numFormats];
        }
        GLES10.glGetIntegerv(GLES10.GL_COMPRESSED_TEXTURE_FORMATS, results, 0);
        for (int i = 0; i < numFormats; i++) {
            if (results[i] == ETC1.ETC1_RGB8_OES) {
                return true;
            }
        }
        return false;
    }

    
        @DSModeled(DSC.SPEC)
    public static ETC1Texture createTexture(InputStream input) throws IOException {
        int width = 0;
        int height = 0;
        byte[] ioBuffer = new byte[4096];
        {
            if (input.read(ioBuffer, 0, ETC1.ETC_PKM_HEADER_SIZE) != ETC1.ETC_PKM_HEADER_SIZE) {
                throw new IOException("Unable to read PKM file header.");
            }
            ByteBuffer headerBuffer = ByteBuffer.allocateDirect(ETC1.ETC_PKM_HEADER_SIZE)
                .order(ByteOrder.nativeOrder());
            headerBuffer.put(ioBuffer, 0, ETC1.ETC_PKM_HEADER_SIZE).position(0);
            if (!ETC1.isValid(headerBuffer)) {
                throw new IOException("Not a PKM file.");
            }
            width = ETC1.getWidth(headerBuffer);
            height = ETC1.getHeight(headerBuffer);
        }
        int encodedSize = ETC1.getEncodedDataSize(width, height);
        ByteBuffer dataBuffer = ByteBuffer.allocateDirect(encodedSize).order(ByteOrder.nativeOrder());
        for (int i = 0; i < encodedSize; ) {
            int chunkSize = Math.min(ioBuffer.length, encodedSize - i);
            if (input.read(ioBuffer, 0, chunkSize) != chunkSize) {
                throw new IOException("Unable to read PKM file data.");
            }
            dataBuffer.put(ioBuffer, 0, chunkSize);
            i += chunkSize;
        }
        dataBuffer.position(0);
        return new ETC1Texture(width, height, dataBuffer);
    }

    
        public static ETC1Texture compressTexture(Buffer input, int width, int height, int pixelSize, int stride) {
        int encodedImageSize = ETC1.getEncodedDataSize(width, height);
        ByteBuffer compressedImage = ByteBuffer.allocateDirect(encodedImageSize).
            order(ByteOrder.nativeOrder());
        ETC1.encodeImage(input, width, height, 3, stride, compressedImage);
        return new ETC1Texture(width, height, compressedImage);
    }

    
        @DSModeled(DSC.SPEC)
    public static void writeTexture(ETC1Texture texture, OutputStream output) throws IOException {
        ByteBuffer dataBuffer = texture.getData();
        int originalPosition = dataBuffer.position();
        try {
            int width = texture.getWidth();
            int height = texture.getHeight();
            ByteBuffer header = ByteBuffer.allocateDirect(ETC1.ETC_PKM_HEADER_SIZE).order(ByteOrder.nativeOrder());
            ETC1.formatHeader(header, width, height);
            byte[] ioBuffer = new byte[4096];
            header.get(ioBuffer, 0, ETC1.ETC_PKM_HEADER_SIZE);
            output.write(ioBuffer, 0, ETC1.ETC_PKM_HEADER_SIZE);
            int encodedSize = ETC1.getEncodedDataSize(width, height);
            for (int i = 0; i < encodedSize; ) {
                int chunkSize = Math.min(ioBuffer.length, encodedSize - i);
                dataBuffer.get(ioBuffer, 0, chunkSize);
                output.write(ioBuffer, 0, chunkSize);
                i += chunkSize;
            }
        } finally {
            dataBuffer.position(originalPosition);
        }
    }

    
    public static class ETC1Texture {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:30.178 -0400", hash_original_field = "A3DB1626A190732E588FD0D14FC8FB31", hash_generated_field = "380984B6D3BA888BD05804A5D24041AE")

        private int mWidth;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:30.178 -0400", hash_original_field = "483542B05A951AA16D89C7F809C20811", hash_generated_field = "9A13F430E09A05B31C551CE62B9A37C1")

        private int mHeight;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:30.178 -0400", hash_original_field = "B7DE4FF1B7CCEFDA36733D8B6DFF2904", hash_generated_field = "176DCD6E97A5BFA4944582E1ADA54B06")

        private ByteBuffer mData;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:30.178 -0400", hash_original_method = "A36B04D2CAAE3BFE84C1C2073669215A", hash_generated_method = "05C505EED6C5AF4458D1D3C64F881687")
        public  ETC1Texture(int width, int height, ByteBuffer data) {
            mWidth = width;
            mHeight = height;
            mData = data;
            // ---------- Original Method ----------
            //mWidth = width;
            //mHeight = height;
            //mData = data;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:30.179 -0400", hash_original_method = "AA9BA105372BFC95AFBABED408315F5C", hash_generated_method = "E8594FEC9F1976093E07F297BFC5651E")
        public int getWidth() {
            int varA3DB1626A190732E588FD0D14FC8FB31_252443041 = (mWidth);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_288929885 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_288929885;
            // ---------- Original Method ----------
            //return mWidth;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:30.179 -0400", hash_original_method = "0304EDCF78FF45B68A7EB91BFEAAA2CD", hash_generated_method = "12437E34A1F42958B2E8A619BFD53898")
        public int getHeight() {
            int var483542B05A951AA16D89C7F809C20811_1762100921 = (mHeight);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1221663397 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1221663397;
            // ---------- Original Method ----------
            //return mHeight;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:30.179 -0400", hash_original_method = "137D4A62628C4DE393FDFDF6B76B5AB1", hash_generated_method = "7913D2190E172973B80E4E70BD576936")
        public ByteBuffer getData() {
ByteBuffer var623C3F1D556EBC2E104B1DFEC3C5702A_843467256 =             mData;
            var623C3F1D556EBC2E104B1DFEC3C5702A_843467256.addTaint(taint);
            return var623C3F1D556EBC2E104B1DFEC3C5702A_843467256;
            // ---------- Original Method ----------
            //return mData;
        }

        
    }


    
}

