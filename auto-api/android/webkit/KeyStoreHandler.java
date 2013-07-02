package android.webkit;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.content.Context;
import android.os.Handler;
import android.util.Log;

class KeyStoreHandler extends Handler {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.998 -0400", hash_original_field = "1F82295670D8C49C778553291F467693", hash_generated_field = "C2ADEC4B7675869DD34EF84CA5DC8ADA")

    private final ByteArrayBuilder mDataBuilder = new ByteArrayBuilder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.998 -0400", hash_original_field = "FA38F1960A45A7EC16349AAF783A80BC", hash_generated_field = "D6D2783B71AE4BF9CBF84D44336E2BF9")

    private String mMimeType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.999 -0400", hash_original_method = "587ABBBEDE647D3237F91706DA6610BD", hash_generated_method = "0B2E23A7411CC981C66241E70E1BCCAE")
    public  KeyStoreHandler(String mimeType) {
        mMimeType = mimeType;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.999 -0400", hash_original_method = "2DA424A8A87A21D10409F02AA8AEC0E6", hash_generated_method = "D4DC2D9979B5438159345F8C9746153A")
    public void didReceiveData(byte[] data, int length) {
        {
            mDataBuilder.append(data, 0, length);
        } 
        addTaint(data[0]);
        addTaint(length);
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.999 -0400", hash_original_method = "736EF2EF4199424B0094A77A85DC708B", hash_generated_method = "C029CB8B306DB75D5BEFA3DE03E32271")
    public void installCert(Context context) {
        String type = CertTool.getCertType(mMimeType);
        {
            byte[] cert = new byte[mDataBuilder.getByteSize()];
            int offset = 0;
            {
                ByteArrayBuilder.Chunk c = mDataBuilder.getFirstChunk();
                {
                    System.arraycopy(c.mArray, 0, cert, offset, c.mLength);
                    offset += c.mLength;
                } 
                c.release();
            } 
            CertTool.addCertificate(context, type, cert);
        } 
        addTaint(context.getTaint());
        
        
        
        
            
            
            
                
                
                
                    
                    
                
                
            
            
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.000 -0400", hash_original_field = "57BF66CDF3DA6CF7C4606CCDC898C652", hash_generated_field = "C9E2CFC610075E6FBB1A3E399A292AA6")

    private static final String LOGTAG = "KeyStoreHandler";
}

