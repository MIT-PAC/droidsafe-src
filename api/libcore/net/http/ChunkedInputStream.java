package libcore.net.http;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.CacheRequest;
import java.util.Arrays;
import libcore.io.Streams;

final class ChunkedInputStream extends AbstractHttpInputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.053 -0400", hash_original_field = "837B811620D66AECDECD9FB207F3D4F7", hash_generated_field = "FDB0DA7DADF9682B7A13CAE6AF74D826")

    private int bytesRemainingInChunk = NO_CHUNK_YET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.053 -0400", hash_original_field = "F2767B700D21ABCF8D14F590FE4DB4E3", hash_generated_field = "B67E9C22EADF6797D475937CE5ACA397")

    private boolean hasMoreChunks = true;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.054 -0400", hash_original_method = "F83C2E58EBE5A0D51F69F747FEAA67C2", hash_generated_method = "F4BADE76F5C981ECA829182116065B50")
      ChunkedInputStream(InputStream is, CacheRequest cacheRequest,
            HttpEngine httpEngine) throws IOException {
        super(is, httpEngine, cacheRequest);
        addTaint(httpEngine.getTaint());
        addTaint(cacheRequest.getTaint());
        addTaint(is.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.054 -0400", hash_original_method = "A69C93E854B37E522584F08EF88E59BD", hash_generated_method = "0353BCF789C2FAAC5A1C66BAF7794A3E")
    @Override
    public int read(byte[] buffer, int offset, int count) throws IOException {
        addTaint(count);
        addTaint(offset);
        addTaint(buffer[0]);
        Arrays.checkOffsetAndCount(buffer.length, offset, count);
        checkNotClosed();
    if(!hasMoreChunks)        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_789934542 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_192360201 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_192360201;
        } 
    if(bytesRemainingInChunk == 0 || bytesRemainingInChunk == NO_CHUNK_YET)        
        {
            readChunkSize();
    if(!hasMoreChunks)            
            {
                int var6BB61E3B7BCE0931DA574D19D1D82C88_1251313437 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1357201512 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1357201512;
            } 
        } 
        int read = in.read(buffer, offset, Math.min(count, bytesRemainingInChunk));
    if(read == -1)        
        {
            unexpectedEndOfInput();
            IOException var9FCEBBA092763F5F75BC70A376D097E6_702977330 = new IOException("unexpected end of stream");
            var9FCEBBA092763F5F75BC70A376D097E6_702977330.addTaint(taint);
            throw var9FCEBBA092763F5F75BC70A376D097E6_702977330;
        } 
        bytesRemainingInChunk -= read;
        cacheWrite(buffer, offset, read);
    if(bytesRemainingInChunk == 0 && in.available() >= MIN_LAST_CHUNK_LENGTH)        
        {
            readChunkSize();
        } 
        int varECAE13117D6F0584C25A9DA6C8F8415E_329592011 = (read);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1415193929 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1415193929;
        
        
        
        
            
        
        
            
            
                
            
        
        
        
            
            
        
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.055 -0400", hash_original_method = "140E1DA8E8861D1C317B4255A250B320", hash_generated_method = "1D9F2176CD8F8A42E69682A7CFB28B12")
    private void readChunkSize() throws IOException {
    if(bytesRemainingInChunk != NO_CHUNK_YET)        
        {
            Streams.readAsciiLine(in);
        } 
        String chunkSizeString = Streams.readAsciiLine(in);
        int index = chunkSizeString.indexOf(";");
    if(index != -1)        
        {
            chunkSizeString = chunkSizeString.substring(0, index);
        } 
        try 
        {
            bytesRemainingInChunk = Integer.parseInt(chunkSizeString.trim(), 16);
        } 
        catch (NumberFormatException e)
        {
            IOException var012098BF550B7327769772BC6B0C1846_1650610492 = new IOException("Expected a hex chunk size, but was " + chunkSizeString);
            var012098BF550B7327769772BC6B0C1846_1650610492.addTaint(taint);
            throw var012098BF550B7327769772BC6B0C1846_1650610492;
        } 
    if(bytesRemainingInChunk == 0)        
        {
            hasMoreChunks = false;
            httpEngine.readTrailers();
            endOfInput(true);
        } 
        
        
            
        
        
        
        
            
        
        
            
        
            
        
        
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.056 -0400", hash_original_method = "637FFB0CF7184A6B5BB58296121EFC54", hash_generated_method = "47CCD3CAFA1CCEE64576E63F713F308D")
    @Override
    public int available() throws IOException {
        checkNotClosed();
    if(!hasMoreChunks || bytesRemainingInChunk == NO_CHUNK_YET)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_942365459 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_144021749 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_144021749;
        } 
        int var79C497F3E0FA13A85FD80EA6E8DD7183_648540219 = (Math.min(in.available(), bytesRemainingInChunk));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_424409751 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_424409751;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.057 -0400", hash_original_method = "A3F7257F208C4120BEF39F0167994D8B", hash_generated_method = "45B363479133BFF7E531B10717EF67BE")
    @Override
    public void close() throws IOException {
    if(closed)        
        {
            return;
        } 
        closed = true;
    if(hasMoreChunks)        
        {
            unexpectedEndOfInput();
        } 
        
        
            
        
        
        
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.057 -0400", hash_original_field = "745082C684F20695677D0834835747B1", hash_generated_field = "C5956A6D669A15373C0A4736E4DBDA7D")

    private static final int MIN_LAST_CHUNK_LENGTH = "\r\n0\r\n\r\n".length();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.057 -0400", hash_original_field = "2775A55E130B5CDA97B034600260B7B6", hash_generated_field = "D686DA2F205CF442EB1A44AB0D31BF16")

    private static final int NO_CHUNK_YET = -1;
}

