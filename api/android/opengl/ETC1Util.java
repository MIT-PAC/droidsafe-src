package android.opengl;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;






public class ETC1Util {
    /**
     * Convenience method to load an ETC1 texture whether or not the active OpenGL context
     * supports the ETC1 texture compression format.
     * @param target the texture target.
     * @param level the texture level
     * @param border the border size. Typically 0.
     * @param fallbackFormat the format to use if ETC1 texture compression is not supported.
     * Must be GL_RGB.
     * @param fallbackType the type to use if ETC1 texture compression is not supported.
     * Can be either GL_UNSIGNED_SHORT_5_6_5, which implies 16-bits-per-pixel,
     * or GL_UNSIGNED_BYTE, which implies 24-bits-per-pixel.
     * @param input the input stream containing an ETC1 texture in PKM format.
     * @throws IOException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:31.508 -0500", hash_original_method = "ACCA642D1FA9BF396A2137FABFB57E8E", hash_generated_method = "D7B2AD787E61C65024C69BB205A2F498")
    public static void loadTexture(int target, int level, int border,
            int fallbackFormat, int fallbackType, InputStream input)
        throws IOException {
        loadTexture(target, level, border, fallbackFormat, fallbackType, createTexture(input));
    }

    /**
     * Convenience method to load an ETC1 texture whether or not the active OpenGL context
     * supports the ETC1 texture compression format.
     * @param target the texture target.
     * @param level the texture level
     * @param border the border size. Typically 0.
     * @param fallbackFormat the format to use if ETC1 texture compression is not supported.
     * Must be GL_RGB.
     * @param fallbackType the type to use if ETC1 texture compression is not supported.
     * Can be either GL_UNSIGNED_SHORT_5_6_5, which implies 16-bits-per-pixel,
     * or GL_UNSIGNED_BYTE, which implies 24-bits-per-pixel.
     * @param texture the ETC1 to load.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:31.509 -0500", hash_original_method = "B1073C897629A80ACF121B885B215CE1", hash_generated_method = "860CAEA16F17D025A9FE6B9E6EA8EF38")
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

    /**
     * Check if ETC1 texture compression is supported by the active OpenGL ES context.
     * @return true if the active OpenGL ES context supports ETC1 texture compression.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:31.510 -0500", hash_original_method = "BEFAB7C1C327FAD32E2DCE511F8876B3", hash_generated_method = "EFFB6AC003C8227D3A9CFA86DFBEAD77")
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

    /**
     * Create a new ETC1Texture from an input stream containing a PKM formatted compressed texture.
     * @param input an input stream containing a PKM formatted compressed texture.
     * @return an ETC1Texture read from the input stream.
     * @throws IOException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:31.518 -0500", hash_original_method = "DB70AA378C6CA75A97E2143D1A039441", hash_generated_method = "3A1052EDADDDC32BAF9C16CC5ECEDA67")
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

    /**
     * Helper function that compresses an image into an ETC1Texture.
     * @param input a native order direct buffer containing the image data
     * @param width the width of the image in pixels
     * @param height the height of the image in pixels
     * @param pixelSize the size of a pixel in bytes (2 or 3)
     * @param stride the width of a line of the image in bytes
     * @return the ETC1 texture.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:31.519 -0500", hash_original_method = "67BF4A34EF6FC5C0D25A8D063BB6A336", hash_generated_method = "9C47A17BBE50DDFC2AC16A06FC1F4AE1")
    public static ETC1Texture compressTexture(Buffer input, int width, int height, int pixelSize, int stride){
        int encodedImageSize = ETC1.getEncodedDataSize(width, height);
        ByteBuffer compressedImage = ByteBuffer.allocateDirect(encodedImageSize).
            order(ByteOrder.nativeOrder());
        ETC1.encodeImage(input, width, height, 3, stride, compressedImage);
        return new ETC1Texture(width, height, compressedImage);
    }

    /**
     * Helper function that writes an ETC1Texture to an output stream formatted as a PKM file.
     * @param texture the input texture.
     * @param output the stream to write the formatted texture data to.
     * @throws IOException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:31.520 -0500", hash_original_method = "D30344A99981D107D0972206045C7C70", hash_generated_method = "CCD5696868A6D4B61DC4FA02D7346CDA")
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.918 -0400", hash_original_method = "16CF83B5F57C13CA789F8B6C84B3B95D", hash_generated_method = "16CF83B5F57C13CA789F8B6C84B3B95D")
    public ETC1Util ()
    {
        //Synthesized constructor
    }

    
    public static class ETC1Texture {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:31.514 -0500", hash_original_field = "AF6410B200BC05DCA2CF0BE65165448A", hash_generated_field = "380984B6D3BA888BD05804A5D24041AE")


        private int mWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:31.515 -0500", hash_original_field = "7DDAE255893B528E7BEBEC203BC2D9F3", hash_generated_field = "9A13F430E09A05B31C551CE62B9A37C1")

        private int mHeight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:31.516 -0500", hash_original_field = "293D080A7BBEF89F83DE805A99AB053E", hash_generated_field = "176DCD6E97A5BFA4944582E1ADA54B06")

        private ByteBuffer mData;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:31.511 -0500", hash_original_method = "A36B04D2CAAE3BFE84C1C2073669215A", hash_generated_method = "86E856A67A4BF7F24590D5427C1840B1")
        public ETC1Texture(int width, int height, ByteBuffer data) {
            mWidth = width;
            mHeight = height;
            mData = data;
        }

        /**
         * Get the width of the texture in pixels.
         * @return the width of the texture in pixels.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:31.512 -0500", hash_original_method = "AA9BA105372BFC95AFBABED408315F5C", hash_generated_method = "76288D230877FA0A2BAF233CBE4CB19E")
        public int getWidth() { return mWidth; }

        /**
         * Get the height of the texture in pixels.
         * @return the width of the texture in pixels.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:31.513 -0500", hash_original_method = "0304EDCF78FF45B68A7EB91BFEAAA2CD", hash_generated_method = "7B60B7C518DA05BF980E6A0812F1B814")
        public int getHeight() { return mHeight; }

        /**
         * Get the compressed data of the texture.
         * @return the texture data.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:31.514 -0500", hash_original_method = "137D4A62628C4DE393FDFDF6B76B5AB1", hash_generated_method = "FC12873DAC55231F326D166DACA7A1AD")
        public ByteBuffer getData() { return mData; }

        
    }


    
}

