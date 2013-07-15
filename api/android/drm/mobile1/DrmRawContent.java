package android.drm.mobile1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.*;

public class DrmRawContent {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.539 -0400", hash_original_field = "DF0FB53804F83C514B241A9C79BB3524", hash_generated_field = "A35457D5EC6175629B73FEE1B6FC7118")

    private BufferedInputStream inData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.539 -0400", hash_original_field = "46A1A54293FA048C1684287235802184", hash_generated_field = "7857E9BFAB78C608EC1696A66F8974D8")

    private int inDataLen;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.539 -0400", hash_original_field = "B80BB7740288FDA1F201890375A60C8F", hash_generated_field = "D0FAB3735D60E909B66356CA0D9609D4")

    private int id;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.539 -0400", hash_original_field = "EA62E21364A0FD2D40BD1E4F002FEF85", hash_generated_field = "4877FDB686907EE9662E107E49F39E17")

    private String rightsIssuer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.540 -0400", hash_original_field = "D6C5501C210B715686FB7B21E248FDAC", hash_generated_field = "C674ADD25B97CF9C03558A1EC7937BAD")

    private String mediaType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.540 -0400", hash_original_field = "8F1D7FF479440B0DBA160755D4F5AE82", hash_generated_field = "ED45BCA90194A65359E902CD54F1901B")

    private int rawType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.542 -0400", hash_original_method = "48C7554EE3F27E9D89A6C35F1696C3B9", hash_generated_method = "60044D21649755A17621DDD5A560DBEC")
    public  DrmRawContent(InputStream inRawdata, int len, String mimeTypeStr) throws DrmException, IOException {
        addTaint(mimeTypeStr.getTaint());
        int mimeType;
        id = -1;
        inData = new BufferedInputStream(inRawdata, 1024);
        inDataLen = len;
    if(DRM_MIMETYPE_MESSAGE_STRING.equals(mimeTypeStr))        
        mimeType = DRM_MIMETYPE_MESSAGE;
        else
    if(DRM_MIMETYPE_CONTENT_STRING.equals(mimeTypeStr))        
        mimeType = DRM_MIMETYPE_CONTENT;
        else
        {
        IllegalArgumentException varC1AC898D5980425ED38BC1F0FE296BAD_876381803 = new IllegalArgumentException("mimeType must be DRM_MIMETYPE_MESSAGE or DRM_MIMETYPE_CONTENT");
        varC1AC898D5980425ED38BC1F0FE296BAD_876381803.addTaint(taint);
        throw varC1AC898D5980425ED38BC1F0FE296BAD_876381803;
        }
    if(len <= 0)        
        {
        IllegalArgumentException varC37689C2859946115D35F473C770D60B_290411060 = new IllegalArgumentException("len must be > 0");
        varC37689C2859946115D35F473C770D60B_290411060.addTaint(taint);
        throw varC37689C2859946115D35F473C770D60B_290411060;
        }
        id = nativeConstructDrmContent(inData, inDataLen, mimeType);
    if(JNI_DRM_FAILURE == id)        
        {
        DrmException varBD1CD7991A3ED3D30171F28ED0C5511A_1554284614 = new DrmException("nativeConstructDrmContent() returned JNI_DRM_FAILURE");
        varBD1CD7991A3ED3D30171F28ED0C5511A_1554284614.addTaint(taint);
        throw varBD1CD7991A3ED3D30171F28ED0C5511A_1554284614;
        }
        rightsIssuer = nativeGetRightsAddress();
        rawType = nativeGetDeliveryMethod();
    if(JNI_DRM_FAILURE == rawType)        
        {
        DrmException var954F18AEAB0DBC60650ADB08CD405850_1969329095 = new DrmException("nativeGetDeliveryMethod() returned JNI_DRM_FAILURE");
        var954F18AEAB0DBC60650ADB08CD405850_1969329095.addTaint(taint);
        throw var954F18AEAB0DBC60650ADB08CD405850_1969329095;
        }
        mediaType = nativeGetContentType();
    if(null == mediaType)        
        {
        DrmException varCA0996A387EEDA1227FE56DEB1AB8ABA_363084200 = new DrmException("nativeGetContentType() returned null");
        varCA0996A387EEDA1227FE56DEB1AB8ABA_363084200.addTaint(taint);
        throw varCA0996A387EEDA1227FE56DEB1AB8ABA_363084200;
        }
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.543 -0400", hash_original_method = "DA61D867171B37EBE3ABF3A7818C6279", hash_generated_method = "E7D99E48242EC75F1262F0FDFA2BF508")
    public String getRightsAddress() {
String var1501B764E92923618CF5009F66D8B536_1113923262 =         rightsIssuer;
        var1501B764E92923618CF5009F66D8B536_1113923262.addTaint(taint);
        return var1501B764E92923618CF5009F66D8B536_1113923262;
        // ---------- Original Method ----------
        //return rightsIssuer;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.543 -0400", hash_original_method = "D6292E91B10AADE74CDCC0EA78647873", hash_generated_method = "6B9EA911300B207C89CCAAD338D1998C")
    public int getRawType() {
        int var8F1D7FF479440B0DBA160755D4F5AE82_590053675 = (rawType);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1213913355 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1213913355;
        // ---------- Original Method ----------
        //return rawType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.544 -0400", hash_original_method = "3A81FD63CF04F4BFFAA8D4F0C3F30C0B", hash_generated_method = "CE692CBD70616B550039B2829B6FCD65")
    public InputStream getContentInputStream(DrmRights rights) {
        addTaint(rights.getTaint());
    if(null == rights)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_460323501 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_460323501.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_460323501;
        }
InputStream varD3A2B9CE17FD01493269BA1CF954048F_1198096263 =         new DrmInputStream(rights);
        varD3A2B9CE17FD01493269BA1CF954048F_1198096263.addTaint(taint);
        return varD3A2B9CE17FD01493269BA1CF954048F_1198096263;
        // ---------- Original Method ----------
        //if (null == rights)
            //throw new NullPointerException();
        //return new DrmInputStream(rights);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.544 -0400", hash_original_method = "B3F2608C469A4E7BAEFC0D100E327F2C", hash_generated_method = "50BFCD61396ED7A5B2A448AFFBDB0E95")
    public String getContentType() {
String var218CC42AA082B133996F120877DCB8CE_2111278103 =         mediaType;
        var218CC42AA082B133996F120877DCB8CE_2111278103.addTaint(taint);
        return var218CC42AA082B133996F120877DCB8CE_2111278103;
        // ---------- Original Method ----------
        //return mediaType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.545 -0400", hash_original_method = "1DD68310D2E0F74333AF2EE851C2CA4C", hash_generated_method = "7171EC86D71D753C6A558242C0B9FF0D")
    public int getContentLength(DrmRights rights) throws DrmException {
        addTaint(rights.getTaint());
    if(null == rights)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1824410927 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_1824410927.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_1824410927;
        }
        int mediaLen = nativeGetContentLength();
    if(JNI_DRM_FAILURE == mediaLen)        
        {
        DrmException var8A3163A58E09D271279347C18AD8AD72_204790086 = new DrmException("nativeGetContentLength() returned JNI_DRM_FAILURE");
        var8A3163A58E09D271279347C18AD8AD72_204790086.addTaint(taint);
        throw var8A3163A58E09D271279347C18AD8AD72_204790086;
        }
    if(JNI_DRM_UNKNOWN_DATA_LEN == mediaLen)        
        {
        int varBD55273A24A1A36531C0AA04B73E293E_2144976366 = (DRM_UNKNOWN_DATA_LEN);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1914547207 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1914547207;
        }
        int var8E12870FABA953D6D0237E7A881DBFCB_526795990 = (mediaLen);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1816213076 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1816213076;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.546 -0400", hash_original_method = "C7FDCF3FD928AB15F38956E64BA9E194", hash_generated_method = "E64870F9BC8738D1054B2F20AD921CB6")
    private int nativeConstructDrmContent(InputStream data, int len, int mimeType) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_568993398 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_568993398;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.546 -0400", hash_original_method = "F8C7C9754DABA7F76C3A7CE0927D169C", hash_generated_method = "FB49DAE02267FB01D7F8074178E3812C")
    private String nativeGetRightsAddress() {
    	String s = new String();
    	s.addTaint(this.taint);
    	return s;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.546 -0400", hash_original_method = "DEB2FF4C98D7FB31135AB87CA522046D", hash_generated_method = "85592D2FEA21A4F3B4F79BA73190CFC2")
    private int nativeGetDeliveryMethod() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1225180848 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1225180848;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.547 -0400", hash_original_method = "EB4FD7737CAA6B47FAF861D2CF75741C", hash_generated_method = "3BCF7ECFD2607388F4AA688B1D5CBFAA")
    private int nativeReadContent(byte[] buf, int bufOff, int len, int mediaOff) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1522815527 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1522815527;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.547 -0400", hash_original_method = "9C49D7586D5C53FF58306596D0BFC464", hash_generated_method = "3114617F023481A1F61CCC44387FD7A5")
    private String nativeGetContentType() {
    	String s = new String();
    	s.addTaint(this.taint);
    	return s;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.548 -0400", hash_original_method = "B76F89F97A3E0D25504A6F7E11289FEA", hash_generated_method = "EBF4F0D5A83B9039B1B7DA0E312F1358")
    private int nativeGetContentLength() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_512604545 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_512604545;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.548 -0400", hash_original_method = "45E7CB171B397E7ACAF01FE08BEFF46E", hash_generated_method = "D47E0B43C74D4C6D781EA85994B08A67")
    protected void finalize() {
    }

    
    class DrmInputStream extends InputStream {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.549 -0400", hash_original_field = "7587750400D3C39AEAD7C1489F6FE7F3", hash_generated_field = "61C76B683BBEFCB5006250611D355A94")

        private boolean isClosed;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.549 -0400", hash_original_field = "7A86C157EE9713C34FBD7A1EE40F0C5A", hash_generated_field = "EA4C80BAC452228E60AC0DA2D3E0C953")

        private int offset;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.550 -0400", hash_original_field = "92EB5FFEE6AE2FEC3AD71C777531578F", hash_generated_field = "A9C85E0E8E361BA26D5E816C01AD5FF6")

        private byte[] b;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.551 -0400", hash_original_method = "757FC08885175457E85C9AB1294F9204", hash_generated_method = "8BDC6C4E5A19B8AC25EEE8E7EF250AAC")
        public  DrmInputStream(DrmRights rights) {
            addTaint(rights.getTaint());
            isClosed = false;
            offset = 0;
            b = new byte[1];
            // ---------- Original Method ----------
            //isClosed = false;
            //offset = 0;
            //b = new byte[1];
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.551 -0400", hash_original_method = "DD7664962C7714C7E289B90A25098018", hash_generated_method = "0613BAD0CF764802639DE090886FA0BF")
        public int available() throws IOException {
            int len = nativeGetContentLength();
    if(JNI_DRM_FAILURE == len)            
            {
            IOException var1508E3FDF27FD56D4E1051DB16DE1816_1301747969 = new IOException();
            var1508E3FDF27FD56D4E1051DB16DE1816_1301747969.addTaint(taint);
            throw var1508E3FDF27FD56D4E1051DB16DE1816_1301747969;
            }
    if(JNI_DRM_UNKNOWN_DATA_LEN == len)            
            {
            int varCFCD208495D565EF66E7DFF9F98764DA_1682355353 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1703256981 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1703256981;
            }
            int availableLen = len - offset;
    if(availableLen < 0)            
            {
            IOException var1508E3FDF27FD56D4E1051DB16DE1816_2037355418 = new IOException();
            var1508E3FDF27FD56D4E1051DB16DE1816_2037355418.addTaint(taint);
            throw var1508E3FDF27FD56D4E1051DB16DE1816_2037355418;
            }
            int varE7999F86B8E870AF9FBD3A167F5B20A8_2041571088 = (availableLen);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1182603820 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1182603820;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.552 -0400", hash_original_method = "287241C29465CA302A7D4AC4EAA3FF8F", hash_generated_method = "A4ACC7D98BFFE1D2EBC0BF48B20B6F10")
        public int read() throws IOException {
            int res;
            res = read(b, 0, 1);
    if(-1 == res)            
            {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_2102556927 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_617240364 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_617240364;
            }
            int varF6DD97E47423C349144684C9E696C469_1703342602 = (b[0] & 0xff);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1790846950 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1790846950;
            // ---------- Original Method ----------
            //int res;
            //res = read(b, 0, 1);
            //if (-1 == res)
                //return -1;
            //return b[0] & 0xff;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.553 -0400", hash_original_method = "03121A7AC3B4E7519E88953F37DA485C", hash_generated_method = "E4F48307880AB3BA17D1026F30D3792B")
        public int read(byte[] b) throws IOException {
            addTaint(b[0]);
            int var3AE1B8835719D1E8BA9C297EF156E04B_2136065418 = (read(b, 0, b.length));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_314561956 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_314561956;
            // ---------- Original Method ----------
            //return read(b, 0, b.length);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.554 -0400", hash_original_method = "E3473D498149E2AB489389364DA9079E", hash_generated_method = "6B8BE7599C63A6D7D0837258AB236E3D")
        public int read(byte[] b, int off, int len) throws IOException {
            addTaint(off);
            addTaint(b[0]);
    if(null == b)            
            {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1932243119 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1932243119.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1932243119;
            }
    if(off < 0 || len < 0 || off + len > b.length)            
            {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_1105961210 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_1105961210.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_1105961210;
            }
    if(true == isClosed)            
            {
            IOException var1508E3FDF27FD56D4E1051DB16DE1816_1964741374 = new IOException();
            var1508E3FDF27FD56D4E1051DB16DE1816_1964741374.addTaint(taint);
            throw var1508E3FDF27FD56D4E1051DB16DE1816_1964741374;
            }
    if(0 == len)            
            {
            int varCFCD208495D565EF66E7DFF9F98764DA_1261679474 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_299813144 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_299813144;
            }
            len = nativeReadContent(b, off, len, offset);
    if(JNI_DRM_FAILURE == len)            
            {
            IOException var1508E3FDF27FD56D4E1051DB16DE1816_387250034 = new IOException();
            var1508E3FDF27FD56D4E1051DB16DE1816_387250034.addTaint(taint);
            throw var1508E3FDF27FD56D4E1051DB16DE1816_387250034;
            }
            else
    if(JNI_DRM_EOF == len)            
            {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_1366061400 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1072683526 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1072683526;
            }
            offset += len;
            int varF5A8E923F8CD24B56B3BAB32358CC58A_457451970 = (len);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1127245444 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1127245444;
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

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.555 -0400", hash_original_method = "12DAC0CE56878A53F37AFF65E12010EB", hash_generated_method = "AB42700FDD51AD37083713A522FFFAA8")
        public boolean markSupported() {
            boolean var68934A3E9455FA72420237EB05902327_48397863 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1779035825 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1779035825;
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.555 -0400", hash_original_method = "99EDC8CF58ACEFC383E40E1B1F253896", hash_generated_method = "7B9F66D07F75DF8B4C4E6E1ACAEF159F")
        public void mark(int readlimit) {
            addTaint(readlimit);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.555 -0400", hash_original_method = "B2B0ACE34E24898AD20F33154DDE5ADD", hash_generated_method = "4C4C0F604242297CFFA5DF0983B82726")
        public void reset() throws IOException {
            IOException var1508E3FDF27FD56D4E1051DB16DE1816_1944895929 = new IOException();
            var1508E3FDF27FD56D4E1051DB16DE1816_1944895929.addTaint(taint);
            throw var1508E3FDF27FD56D4E1051DB16DE1816_1944895929;
            // ---------- Original Method ----------
            //throw new IOException();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.556 -0400", hash_original_method = "373BCB0654FCF6410EF04A71B1FD669C", hash_generated_method = "6E0590439C4C4DA697AEDA6628995B06")
        public long skip(long n) throws IOException {
            addTaint(n);
            long varCFCD208495D565EF66E7DFF9F98764DA_1907068258 = (0);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_232331320 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_232331320;
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.556 -0400", hash_original_method = "10D4C3BAF156E237AD0273689BD4B9BB", hash_generated_method = "4A6EF94E7CC50F6E20EC58D80F40022A")
        public void close() {
            isClosed = true;
            // ---------- Original Method ----------
            //isClosed = true;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.557 -0400", hash_original_field = "EE2389BA76C61A887BA5E8CFDE227879", hash_generated_field = "29181C4D953A39C351B8C01664607777")

    public static final String DRM_MIMETYPE_MESSAGE_STRING = "application/vnd.oma.drm.message";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.557 -0400", hash_original_field = "C367179349EEA4DC677F3C41F127A5D1", hash_generated_field = "BD795434A76D303A889FDEE440B9A38D")

    public static final String DRM_MIMETYPE_CONTENT_STRING = "application/vnd.oma.drm.content";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.557 -0400", hash_original_field = "160810718F7EF8699984FE4A38C977D4", hash_generated_field = "BE75013ACBBFB578DD0D79AA8B030FDD")

    public static final int DRM_FORWARD_LOCK = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.557 -0400", hash_original_field = "7848E734B7C049BF4AFFA1CE97E3D7EB", hash_generated_field = "4BF6251F8F423A87A7453D2F3EE60637")

    public static final int DRM_COMBINED_DELIVERY = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.557 -0400", hash_original_field = "C5794F128494D31C971447A9A2D8B82F", hash_generated_field = "FCF82C97F26D5D315B6F34A5C28873E0")

    public static final int DRM_SEPARATE_DELIVERY = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.557 -0400", hash_original_field = "9B420FB7C61AE4C6F2450B6C347F1755", hash_generated_field = "A770CEF0324BA4B3D13C058366063385")

    public static final int DRM_SEPARATE_DELIVERY_DM = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.557 -0400", hash_original_field = "E11C93EDAAB178F7594A3A4DCEC2F8EF", hash_generated_field = "71B094D9F60A448ABA482B2A442A14B2")

    public static final int DRM_UNKNOWN_DATA_LEN = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.557 -0400", hash_original_field = "645447E2174388024FD7F54546325361", hash_generated_field = "98083C2F2BCD6A089C4D9DF2D1E75981")

    private static final int DRM_MIMETYPE_MESSAGE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.557 -0400", hash_original_field = "7C112B99C67FB2AB48E4427196B3E402", hash_generated_field = "E725C855FB7FE62F795595C2E189FF67")

    private static final int DRM_MIMETYPE_CONTENT = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.558 -0400", hash_original_field = "F927EA5B26734A5B21BABCBBE2780573", hash_generated_field = "25E0D3E71BAEFA88E14AB25E5D0E168C")

    private static final int JNI_DRM_SUCCESS = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.558 -0400", hash_original_field = "8AA00AA09B306612E26D7EEB1735511B", hash_generated_field = "E53DB537690563C59F99436A7DB3F114")

    private static final int JNI_DRM_FAILURE = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.558 -0400", hash_original_field = "6992FB18B14564243EBC2B28DEDD3878", hash_generated_field = "67E46112BDC89D140887F40C5BD4DE7D")

    private static final int JNI_DRM_EOF = -2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.558 -0400", hash_original_field = "BA5F2F884AD3969FDB7F88D570288B4B", hash_generated_field = "B332F11E3A55D2D327F1A2362D31A7AA")

    private static final int JNI_DRM_UNKNOWN_DATA_LEN = -3;
    static {
        try {
            System.loadLibrary("drm1_jni");
        }
        catch (UnsatisfiedLinkError ule) {
            System.err.println("WARNING: Could not load libdrm1_jni.so");
        }
    }
    
}

