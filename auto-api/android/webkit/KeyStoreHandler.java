package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.os.Handler;
import android.util.Log;

class KeyStoreHandler extends Handler {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.868 -0400", hash_original_field = "1F82295670D8C49C778553291F467693", hash_generated_field = "2801F24E84D6A18BEF883D3AE94526E9")

    private ByteArrayBuilder mDataBuilder = new ByteArrayBuilder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.869 -0400", hash_original_field = "FA38F1960A45A7EC16349AAF783A80BC", hash_generated_field = "D6D2783B71AE4BF9CBF84D44336E2BF9")

    private String mMimeType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.869 -0400", hash_original_method = "587ABBBEDE647D3237F91706DA6610BD", hash_generated_method = "0B2E23A7411CC981C66241E70E1BCCAE")
    public  KeyStoreHandler(String mimeType) {
        mMimeType = mimeType;
        // ---------- Original Method ----------
        //mMimeType = mimeType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.869 -0400", hash_original_method = "2DA424A8A87A21D10409F02AA8AEC0E6", hash_generated_method = "D4DC2D9979B5438159345F8C9746153A")
    public void didReceiveData(byte[] data, int length) {
        {
            mDataBuilder.append(data, 0, length);
        } //End block
        addTaint(data[0]);
        addTaint(length);
        // ---------- Original Method ----------
        //synchronized (mDataBuilder) {
            //mDataBuilder.append(data, 0, length);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.870 -0400", hash_original_method = "736EF2EF4199424B0094A77A85DC708B", hash_generated_method = "49EB03044385D11857B54FD293AC4A57")
    public void installCert(Context context) {
        String type;
        type = CertTool.getCertType(mMimeType);
        {
            byte[] cert;
            cert = new byte[mDataBuilder.getByteSize()];
            int offset;
            offset = 0;
            {
                ByteArrayBuilder.Chunk c;
                c = mDataBuilder.getFirstChunk();
                {
                    System.arraycopy(c.mArray, 0, cert, offset, c.mLength);
                    offset += c.mLength;
                } //End block
                c.release();
            } //End block
            CertTool.addCertificate(context, type, cert);
        } //End block
        addTaint(context.getTaint());
        // ---------- Original Method ----------
        //String type = CertTool.getCertType(mMimeType);
        //if (type == null) return;
        //synchronized (mDataBuilder) {
            //byte[] cert = new byte[mDataBuilder.getByteSize()];
            //int offset = 0;
            //while (true) {
                //ByteArrayBuilder.Chunk c = mDataBuilder.getFirstChunk();
                //if (c == null) break;
                //if (c.mLength != 0) {
                    //System.arraycopy(c.mArray, 0, cert, offset, c.mLength);
                    //offset += c.mLength;
                //}
                //c.release();
            //}
            //CertTool.addCertificate(context, type, cert);
            //return;
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.870 -0400", hash_original_field = "57BF66CDF3DA6CF7C4606CCDC898C652", hash_generated_field = "03F1C1232D63342186FD1A8AB4580410")

    private static String LOGTAG = "KeyStoreHandler";
}

