package android.drm.mobile1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.*;

public class DrmRawContent {
    public static final String DRM_MIMETYPE_MESSAGE_STRING = "application/vnd.oma.drm.message";
    public static final String DRM_MIMETYPE_CONTENT_STRING = "application/vnd.oma.drm.content";
    public static final int DRM_FORWARD_LOCK = 1;
    public static final int DRM_COMBINED_DELIVERY = 2;
    public static final int DRM_SEPARATE_DELIVERY = 3;
    public static final int DRM_SEPARATE_DELIVERY_DM = 4;
    public static final int DRM_UNKNOWN_DATA_LEN = -1;
    private static final int DRM_MIMETYPE_MESSAGE = 1;
    private static final int DRM_MIMETYPE_CONTENT = 2;
    private static final int JNI_DRM_SUCCESS = 0;
    private static final int JNI_DRM_FAILURE = -1;
    private static final int JNI_DRM_EOF = -2;
    private static final int JNI_DRM_UNKNOWN_DATA_LEN = -3;
    private BufferedInputStream inData;
    private int inDataLen;
    private int id;
    private String rightsIssuer;
    private String mediaType;
    private int rawType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.853 -0400", hash_original_method = "48C7554EE3F27E9D89A6C35F1696C3B9", hash_generated_method = "E01BDE8DBDBA56C3107D6B502D65271A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DrmRawContent(InputStream inRawdata, int len, String mimeTypeStr) throws DrmException, IOException {
        dsTaint.addTaint(inRawdata.dsTaint);
        dsTaint.addTaint(len);
        dsTaint.addTaint(mimeTypeStr);
        int mimeType;
        id = -1;
        inData = new BufferedInputStream(inRawdata, 1024);
        {
            boolean var7EE688A05B8D5A201735D4DD3044B9AC_1953581501 = (DRM_MIMETYPE_MESSAGE_STRING.equals(mimeTypeStr));
            mimeType = DRM_MIMETYPE_MESSAGE;
            {
                boolean var7621B0F1DFB4A1AC4044FC1343037B20_1167377192 = (DRM_MIMETYPE_CONTENT_STRING.equals(mimeTypeStr));
                mimeType = DRM_MIMETYPE_CONTENT;
                throw new IllegalArgumentException("mimeType must be DRM_MIMETYPE_MESSAGE or DRM_MIMETYPE_CONTENT");
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        throw new IllegalArgumentException("len must be > 0");
        id = nativeConstructDrmContent(inData, inDataLen, mimeType);
        throw new DrmException("nativeConstructDrmContent() returned JNI_DRM_FAILURE");
        rightsIssuer = nativeGetRightsAddress();
        rawType = nativeGetDeliveryMethod();
        throw new DrmException("nativeGetDeliveryMethod() returned JNI_DRM_FAILURE");
        mediaType = nativeGetContentType();
        throw new DrmException("nativeGetContentType() returned null");
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.853 -0400", hash_original_method = "DA61D867171B37EBE3ABF3A7818C6279", hash_generated_method = "FCFA11F4D7204A9487834712DA9DC5F7")
    @DSModeled(DSC.SAFE)
    public String getRightsAddress() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return rightsIssuer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.853 -0400", hash_original_method = "D6292E91B10AADE74CDCC0EA78647873", hash_generated_method = "BC4008A6F9418EBEF53CA29F65DC3F30")
    @DSModeled(DSC.SAFE)
    public int getRawType() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return rawType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.853 -0400", hash_original_method = "3A81FD63CF04F4BFFAA8D4F0C3F30C0B", hash_generated_method = "66056EE09F29B0D6055BA9CEABDB1259")
    @DSModeled(DSC.SAFE)
    public InputStream getContentInputStream(DrmRights rights) {
        dsTaint.addTaint(rights.dsTaint);
        throw new NullPointerException();
        return (InputStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (null == rights)
            //throw new NullPointerException();
        //return new DrmInputStream(rights);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.854 -0400", hash_original_method = "B3F2608C469A4E7BAEFC0D100E327F2C", hash_generated_method = "5F75CC2AF4FE8DA5DA69FA0B8D315DE1")
    @DSModeled(DSC.SAFE)
    public String getContentType() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mediaType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.854 -0400", hash_original_method = "1DD68310D2E0F74333AF2EE851C2CA4C", hash_generated_method = "004598AB3F13D9F4D3D86D22B173ADC9")
    @DSModeled(DSC.SAFE)
    public int getContentLength(DrmRights rights) throws DrmException {
        dsTaint.addTaint(rights.dsTaint);
        throw new NullPointerException();
        int mediaLen;
        mediaLen = nativeGetContentLength();
        throw new DrmException("nativeGetContentLength() returned JNI_DRM_FAILURE");
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (null == rights)
            //throw new NullPointerException();
        //int mediaLen = nativeGetContentLength();
        //if (JNI_DRM_FAILURE == mediaLen)
            //throw new DrmException("nativeGetContentLength() returned JNI_DRM_FAILURE");
        //if (JNI_DRM_UNKNOWN_DATA_LEN == mediaLen)
            //return DRM_UNKNOWN_DATA_LEN;
        //return mediaLen;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.854 -0400", hash_original_method = "C7FDCF3FD928AB15F38956E64BA9E194", hash_generated_method = "D93863088697DD120FB66BCD3EEB8469")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int nativeConstructDrmContent(InputStream data, int len, int mimeType) {
        dsTaint.addTaint(data.dsTaint);
        dsTaint.addTaint(len);
        dsTaint.addTaint(mimeType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.854 -0400", hash_original_method = "F8C7C9754DABA7F76C3A7CE0927D169C", hash_generated_method = "1CDB7616066ED0ABBEAF41BDAA3F99B3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String nativeGetRightsAddress() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.854 -0400", hash_original_method = "DEB2FF4C98D7FB31135AB87CA522046D", hash_generated_method = "F9FD7CDA8127A1D3A7B86BD1EBAE5E7B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int nativeGetDeliveryMethod() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.854 -0400", hash_original_method = "EB4FD7737CAA6B47FAF861D2CF75741C", hash_generated_method = "4618AAA07C716ABF48656F914B9649CC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int nativeReadContent(byte[] buf, int bufOff, int len, int mediaOff) {
        dsTaint.addTaint(mediaOff);
        dsTaint.addTaint(len);
        dsTaint.addTaint(buf);
        dsTaint.addTaint(bufOff);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.855 -0400", hash_original_method = "9C49D7586D5C53FF58306596D0BFC464", hash_generated_method = "60805D94E84C435FE4BF7C18398B071A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String nativeGetContentType() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.855 -0400", hash_original_method = "B76F89F97A3E0D25504A6F7E11289FEA", hash_generated_method = "B10CF3C5EF333EADAB7E962A9D8E1D8D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int nativeGetContentLength() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.855 -0400", hash_original_method = "45E7CB171B397E7ACAF01FE08BEFF46E", hash_generated_method = "5C7B2750D5C1E217ACF8FE3DFB46EE04")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void finalize() {
    }

    
    class DrmInputStream extends InputStream {
        private boolean isClosed;
        private int offset;
        private byte[] b;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.855 -0400", hash_original_method = "757FC08885175457E85C9AB1294F9204", hash_generated_method = "ADC25CEBF478052E9280663605D41EE7")
        @DSModeled(DSC.SAFE)
        public DrmInputStream(DrmRights rights) {
            dsTaint.addTaint(rights.dsTaint);
            isClosed = false;
            offset = 0;
            b = new byte[1];
            // ---------- Original Method ----------
            //isClosed = false;
            //offset = 0;
            //b = new byte[1];
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.855 -0400", hash_original_method = "DD7664962C7714C7E289B90A25098018", hash_generated_method = "2A69DE21F78D7BFA6B9B1EC5DB72C59B")
        @DSModeled(DSC.SAFE)
        public int available() throws IOException {
            int len;
            len = nativeGetContentLength();
            throw new IOException();
            int availableLen;
            availableLen = len - offset;
            throw new IOException();
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //int len = nativeGetContentLength();
            //if (JNI_DRM_FAILURE == len)
                //throw new IOException();
            //if (JNI_DRM_UNKNOWN_DATA_LEN == len)
                //return 0;
            //int availableLen = len - offset;
            //if (availableLen < 0)
                //throw new IOException();
            //return availableLen;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.856 -0400", hash_original_method = "287241C29465CA302A7D4AC4EAA3FF8F", hash_generated_method = "7AC368F992BE9EB019587DDD1FF29F1C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int read() throws IOException {
            int res;
            res = read(b, 0, 1);
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //int res;
            //res = read(b, 0, 1);
            //if (-1 == res)
                //return -1;
            //return b[0] & 0xff;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.856 -0400", hash_original_method = "03121A7AC3B4E7519E88953F37DA485C", hash_generated_method = "953B35008844B13962C3C22237662315")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int read(byte[] b) throws IOException {
            dsTaint.addTaint(b);
            int var622F29548219192F8BB382FD386339B9_833564953 = (read(b, 0, b.length));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return read(b, 0, b.length);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.856 -0400", hash_original_method = "E3473D498149E2AB489389364DA9079E", hash_generated_method = "CFFE72AB9098864EB74CFD12FDD45B24")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int read(byte[] b, int off, int len) throws IOException {
            dsTaint.addTaint(b);
            dsTaint.addTaint(off);
            dsTaint.addTaint(len);
            throw new NullPointerException();
            throw new IndexOutOfBoundsException();
            throw new IOException();
            len = nativeReadContent(b, off, len, offset);
            throw new IOException();
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //if (null == b)
                //throw new NullPointerException();
            //if (off < 0 || len < 0 || off + len > b.length)
                //throw new IndexOutOfBoundsException();
            //if (true == isClosed)
                //throw new IOException();
            //if (0 == len)
                //return 0;
            //len = nativeReadContent(b, off, len, offset);
            //if (JNI_DRM_FAILURE == len)
                //throw new IOException();
            //else if (JNI_DRM_EOF == len)
                //return -1;
            //offset += len;
            //return len;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.857 -0400", hash_original_method = "12DAC0CE56878A53F37AFF65E12010EB", hash_generated_method = "DBAA4FD3517D5C6FBE92DAB042582601")
        @DSModeled(DSC.SAFE)
        public boolean markSupported() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.857 -0400", hash_original_method = "99EDC8CF58ACEFC383E40E1B1F253896", hash_generated_method = "502E9DF43E60E0844736159A25558D29")
        @DSModeled(DSC.SAFE)
        public void mark(int readlimit) {
            dsTaint.addTaint(readlimit);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.857 -0400", hash_original_method = "B2B0ACE34E24898AD20F33154DDE5ADD", hash_generated_method = "A3553D42BB3F5C8F04A7F0447970A087")
        @DSModeled(DSC.SAFE)
        public void reset() throws IOException {
            throw new IOException();
            // ---------- Original Method ----------
            //throw new IOException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.857 -0400", hash_original_method = "373BCB0654FCF6410EF04A71B1FD669C", hash_generated_method = "0E5320F9AC9AE0EA7759E2C84B72934E")
        @DSModeled(DSC.SAFE)
        public long skip(long n) throws IOException {
            dsTaint.addTaint(n);
            return dsTaint.getTaintLong();
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.857 -0400", hash_original_method = "10D4C3BAF156E237AD0273689BD4B9BB", hash_generated_method = "6BEA210FF99A7A7CF8E4A9F114B0B905")
        @DSModeled(DSC.SAFE)
        public void close() {
            isClosed = true;
            // ---------- Original Method ----------
            //isClosed = true;
        }

        
    }


    
    static {
        try {
            System.loadLibrary("drm1_jni");
        }
        catch (UnsatisfiedLinkError ule) {
            System.err.println("WARNING: Could not load libdrm1_jni.so");
        }
    }
    
}


