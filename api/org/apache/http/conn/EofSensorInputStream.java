package org.apache.http.conn;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.InputStream;
import java.io.IOException;

public class EofSensorInputStream extends InputStream implements ConnectionReleaseTrigger {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.387 -0400", hash_original_field = "D0BF9123FAB84E3B79E1ED23A59D1B53", hash_generated_field = "75EE73214070AB1FED136199F98CB7D5")

    protected InputStream wrappedStream;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.387 -0400", hash_original_field = "095A370CA6B8C603CAAA75F2B4F12919", hash_generated_field = "41AE24AA8B5ED51DCEF7DAEC1C441A42")

    private boolean selfClosed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.387 -0400", hash_original_field = "5F7CFA8693A30C3927B4D76CE04FED85", hash_generated_field = "604EC2A2F6D75D40086FC63DE46C1C59")

    private EofSensorWatcher eofWatcher;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.387 -0400", hash_original_method = "9B2B9BBE0E73ACBBC201B99B60B700AE", hash_generated_method = "13C8EA8263B2DFBF05096219C3653BA4")
    public  EofSensorInputStream(final InputStream in,
                                final EofSensorWatcher watcher) {
    if(in == null)        
        {
            IllegalArgumentException varB4D1A5C6F0B6B1FF769A8C9715BBACB5_402024833 = new IllegalArgumentException
                ("Wrapped stream may not be null.");
            varB4D1A5C6F0B6B1FF769A8C9715BBACB5_402024833.addTaint(taint);
            throw varB4D1A5C6F0B6B1FF769A8C9715BBACB5_402024833;
        } //End block
        wrappedStream = in;
        selfClosed = false;
        eofWatcher = watcher;
        // ---------- Original Method ----------
        //if (in == null) {
            //throw new IllegalArgumentException
                //("Wrapped stream may not be null.");
        //}
        //wrappedStream = in;
        //selfClosed = false;
        //eofWatcher = watcher;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.388 -0400", hash_original_method = "7D1410F2491A2101D94AEDEF5E6D4821", hash_generated_method = "B7C2102E8683B6D6C3B1CF928C04BA37")
    protected boolean isReadAllowed() throws IOException {
    if(selfClosed)        
        {
            IOException varE5C540A0E901F55D6DB159FC3152529D_1393905652 = new IOException("Attempted read on closed stream.");
            varE5C540A0E901F55D6DB159FC3152529D_1393905652.addTaint(taint);
            throw varE5C540A0E901F55D6DB159FC3152529D_1393905652;
        } //End block
        boolean var24C2961E761C5BC202E23678CA937332_228947793 = ((wrappedStream != null));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_293118211 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_293118211;
        // ---------- Original Method ----------
        //if (selfClosed) {
            //throw new IOException("Attempted read on closed stream.");
        //}
        //return (wrappedStream != null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.388 -0400", hash_original_method = "EEFED13FF9B8A7AEEF5F21DDE66222B5", hash_generated_method = "F39B291C67167ACDAB3A5261B90A2B6A")
    @Override
    public int read() throws IOException {
        int l = -1;
    if(isReadAllowed())        
        {
            try 
            {
                l = wrappedStream.read();
                checkEOF(l);
            } //End block
            catch (IOException ex)
            {
                checkAbort();
                ex.addTaint(taint);
                throw ex;
            } //End block
        } //End block
        int var2DB95E8E1A9267B7A1188556B2013B33_1527265235 = (l);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1765805346 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1765805346;
        // ---------- Original Method ----------
        //int l = -1;
        //if (isReadAllowed()) {
            //try {
                //l = wrappedStream.read();
                //checkEOF(l);
            //} catch (IOException ex) {
                //checkAbort();
                //throw ex;
            //}
        //}
        //return l;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.389 -0400", hash_original_method = "140106DCDF4EB864C1587DEC2B46B903", hash_generated_method = "F7535DF1E298110569C98F31C2586C84")
    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        addTaint(len);
        addTaint(off);
        addTaint(b[0]);
        int l = -1;
    if(isReadAllowed())        
        {
            try 
            {
                l = wrappedStream.read(b,  off,  len);
                checkEOF(l);
            } //End block
            catch (IOException ex)
            {
                checkAbort();
                ex.addTaint(taint);
                throw ex;
            } //End block
        } //End block
        int var2DB95E8E1A9267B7A1188556B2013B33_1972831902 = (l);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_807129180 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_807129180;
        // ---------- Original Method ----------
        //int l = -1;
        //if (isReadAllowed()) {
            //try {
                //l = wrappedStream.read(b,  off,  len);
                //checkEOF(l);
            //} catch (IOException ex) {
                //checkAbort();
                //throw ex;
            //}
        //}
        //return l;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.390 -0400", hash_original_method = "4F7157F64E168AA9C8D7643824C693E0", hash_generated_method = "F68593B89DC641653B4B8A4636137322")
    @Override
    public int read(byte[] b) throws IOException {
        addTaint(b[0]);
        int l = -1;
    if(isReadAllowed())        
        {
            try 
            {
                l = wrappedStream.read(b);
                checkEOF(l);
            } //End block
            catch (IOException ex)
            {
                checkAbort();
                ex.addTaint(taint);
                throw ex;
            } //End block
        } //End block
        int var2DB95E8E1A9267B7A1188556B2013B33_483547414 = (l);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1291901268 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1291901268;
        // ---------- Original Method ----------
        //int l = -1;
        //if (isReadAllowed()) {
            //try {
                //l = wrappedStream.read(b);
                //checkEOF(l);
            //} catch (IOException ex) {
                //checkAbort();
                //throw ex;
            //}
        //}
        //return l;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.390 -0400", hash_original_method = "4A9A4C62148DEF77484BCFABD0B37515", hash_generated_method = "F5CC35E9ACC9F6B3FE9FAC83C46811C4")
    @Override
    public int available() throws IOException {
        int a = 0;
    if(isReadAllowed())        
        {
            try 
            {
                a = wrappedStream.available();
            } //End block
            catch (IOException ex)
            {
                checkAbort();
                ex.addTaint(taint);
                throw ex;
            } //End block
        } //End block
        int var0CC175B9C0F1B6A831C399E269772661_1162517883 = (a);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_651739385 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_651739385;
        // ---------- Original Method ----------
        //int a = 0;
        //if (isReadAllowed()) {
            //try {
                //a = wrappedStream.available();
            //} catch (IOException ex) {
                //checkAbort();
                //throw ex;
            //}
        //}
        //return a;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.391 -0400", hash_original_method = "BBB2789F4CB1F09FFDECF0070B286C07", hash_generated_method = "9CE787676AF3BC2FF1BCDDF0C7498C87")
    @Override
    public void close() throws IOException {
        selfClosed = true;
        checkClose();
        // ---------- Original Method ----------
        //selfClosed = true;
        //checkClose();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.392 -0400", hash_original_method = "AE762594E7D7874DF7D34819786C5E24", hash_generated_method = "40B0324A4E4BF295A3065280029A5ABD")
    protected void checkEOF(int eof) throws IOException {
        addTaint(eof);
    if((wrappedStream != null) && (eof < 0))        
        {
            try 
            {
                boolean scws = true;
    if(eofWatcher != null)                
                scws = eofWatcher.eofDetected(wrappedStream);
    if(scws)                
                wrappedStream.close();
            } //End block
            finally 
            {
                wrappedStream = null;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if ((wrappedStream != null) && (eof < 0)) {
            //try {
                //boolean scws = true; 
                //if (eofWatcher != null)
                    //scws = eofWatcher.eofDetected(wrappedStream);
                //if (scws)
                    //wrappedStream.close();
            //} finally {
                //wrappedStream = null;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.392 -0400", hash_original_method = "5F2207AEF37490FFD8B76672ACFD7F2C", hash_generated_method = "1FB1EAF2655D1BF1A67F58560DB61035")
    protected void checkClose() throws IOException {
    if(wrappedStream != null)        
        {
            try 
            {
                boolean scws = true;
    if(eofWatcher != null)                
                scws = eofWatcher.streamClosed(wrappedStream);
    if(scws)                
                wrappedStream.close();
            } //End block
            finally 
            {
                wrappedStream = null;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (wrappedStream != null) {
            //try {
                //boolean scws = true; 
                //if (eofWatcher != null)
                    //scws = eofWatcher.streamClosed(wrappedStream);
                //if (scws)
                    //wrappedStream.close();
            //} finally {
                //wrappedStream = null;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.393 -0400", hash_original_method = "85C58A54B3CFDF3144733266DFBF6D58", hash_generated_method = "CC39B6CA46C1FFA79A8272D004358E91")
    protected void checkAbort() throws IOException {
    if(wrappedStream != null)        
        {
            try 
            {
                boolean scws = true;
    if(eofWatcher != null)                
                scws = eofWatcher.streamAbort(wrappedStream);
    if(scws)                
                wrappedStream.close();
            } //End block
            finally 
            {
                wrappedStream = null;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (wrappedStream != null) {
            //try {
                //boolean scws = true; 
                //if (eofWatcher != null)
                    //scws = eofWatcher.streamAbort(wrappedStream);
                //if (scws)
                    //wrappedStream.close();
            //} finally {
                //wrappedStream = null;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.393 -0400", hash_original_method = "02046A66B4E60C074CA5E7223CFCAAA0", hash_generated_method = "AAF8AA5F8B1ADF608224C02DBF968299")
    public void releaseConnection() throws IOException {
        this.close();
        // ---------- Original Method ----------
        //this.close();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.394 -0400", hash_original_method = "0D022924489DD4E5DC4E4B7CC5A41FBA", hash_generated_method = "2816D09D80A223528F6FAFD5D9771168")
    public void abortConnection() throws IOException {
        selfClosed = true;
        checkAbort();
        // ---------- Original Method ----------
        //selfClosed = true;
        //checkAbort();
    }

    
}

