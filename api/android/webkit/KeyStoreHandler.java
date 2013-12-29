package android.webkit;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.Context;
import android.os.Handler;



class KeyStoreHandler extends Handler {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.681 -0500", hash_original_field = "57D9472E60143F42931867FB31034239", hash_generated_field = "C9E2CFC610075E6FBB1A3E399A292AA6")

    private static final String LOGTAG = "KeyStoreHandler";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.682 -0500", hash_original_field = "E6EE4FF0DEA62AEFAFF3DBB439BA6E92", hash_generated_field = "C2ADEC4B7675869DD34EF84CA5DC8ADA")


    private final ByteArrayBuilder mDataBuilder = new ByteArrayBuilder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.683 -0500", hash_original_field = "B161F982909610C03B68BAACDD54E076", hash_generated_field = "D6D2783B71AE4BF9CBF84D44336E2BF9")


    private String mMimeType;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.684 -0500", hash_original_method = "587ABBBEDE647D3237F91706DA6610BD", hash_generated_method = "51BD0A331D376AE273376AA53593E8CC")
    public KeyStoreHandler(String mimeType) {
      mMimeType = mimeType;
    }

    /**
     * Add data to the internal collection of data.
     * @param data A byte array containing the content.
     * @param length The length of data.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.684 -0500", hash_original_method = "2DA424A8A87A21D10409F02AA8AEC0E6", hash_generated_method = "3A207DA0834E6BC699C9CF6E0EAC2295")
    public void didReceiveData(byte[] data, int length) {
        synchronized (mDataBuilder) {
            mDataBuilder.append(data, 0, length);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.685 -0500", hash_original_method = "736EF2EF4199424B0094A77A85DC708B", hash_generated_method = "C5EDB0CCB25C78CFB2DB87C26D662897")
    public void installCert(Context context) {
        String type = CertTool.getCertType(mMimeType);
        if (type == null) return;

        // This must be synchronized so that no more data can be added
        // after getByteSize returns.
        synchronized (mDataBuilder) {
            // In the case of downloading certificate, we will save it
            // to the KeyStore and stop the current loading so that it
            // will not generate a new history page
            byte[] cert = new byte[mDataBuilder.getByteSize()];
            int offset = 0;
            while (true) {
                ByteArrayBuilder.Chunk c = mDataBuilder.getFirstChunk();
                if (c == null) break;

                if (c.mLength != 0) {
                    System.arraycopy(c.mArray, 0, cert, offset, c.mLength);
                    offset += c.mLength;
                }
                c.release();
            }
            CertTool.addCertificate(context, type, cert);
            return;
        }
    }
}

