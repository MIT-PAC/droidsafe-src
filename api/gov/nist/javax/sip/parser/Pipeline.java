package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.core.InternalErrorHandler;
import gov.nist.javax.sip.stack.SIPStackTimerTask;
import java.io.*;
import java.util.*;

public class Pipeline extends InputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.250 -0400", hash_original_field = "4244A1F5602C48D4F541FF17F0EFE294", hash_generated_field = "B4DAA050AED16D506138B23A2C545CFC")

    private LinkedList buffList;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.250 -0400", hash_original_field = "488539971F69BCE841700639EA8339BA", hash_generated_field = "18A2B612A1CF4422210AEC79BF708D17")

    private Buffer currentBuffer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.250 -0400", hash_original_field = "7587750400D3C39AEAD7C1489F6FE7F3", hash_generated_field = "61C76B683BBEFCB5006250611D355A94")

    private boolean isClosed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.250 -0400", hash_original_field = "2C127BF32CCB4EDF2BF22FEA5A00E494", hash_generated_field = "02D2240A23798B540E9F3183DC11EA33")

    private Timer timer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.250 -0400", hash_original_field = "20826A3CB51D6C7D9C219C7F4BF4E5C9", hash_generated_field = "74EA00CD9256C545C6A23A280DF2583C")

    private InputStream pipe;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.250 -0400", hash_original_field = "8FC05721DCBB3B49F66A6D283A300B5B", hash_generated_field = "6532B828611581315664CF6DAFB483BF")

    private int readTimeout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.250 -0400", hash_original_field = "9E6E99F878456DB9CCB1D5339C06EDD3", hash_generated_field = "861338A3A376656ED2C9B97C2EA0F97E")

    private TimerTask myTimerTask;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.252 -0400", hash_original_method = "F09CF9CB05C3E89BEBCB566F6112879F", hash_generated_method = "85EA9CC5B3486843BC1F25288BAC0190")
    public  Pipeline(InputStream pipe, int readTimeout, Timer timer) {
        this.timer = timer;
        this.pipe = pipe;
        buffList = new LinkedList();
        this.readTimeout = readTimeout;
        // ---------- Original Method ----------
        //this.timer = timer;
        //this.pipe = pipe;
        //buffList = new LinkedList();
        //this.readTimeout = readTimeout;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.254 -0400", hash_original_method = "2B544F7E796D3D68CE94D6BF6C677E04", hash_generated_method = "F1007A6A7ADD2C63A526302593DACFE0")
    public void startTimer() {
        if(this.readTimeout == -1)        
        return;
        this.myTimerTask = new MyTimer(this);
        this.timer.schedule(this.myTimerTask, this.readTimeout);
        // ---------- Original Method ----------
        //if (this.readTimeout == -1)
            //return;
        //this.myTimerTask = new MyTimer(this);
        //this.timer.schedule(this.myTimerTask, this.readTimeout);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.255 -0400", hash_original_method = "37F409FD7F01F3081F8A12D9761B8422", hash_generated_method = "9D1FEC64C892C262511518F9F868101B")
    public void stopTimer() {
        if(this.readTimeout == -1)        
        return;
        if(this.myTimerTask != null)        
        this.myTimerTask.cancel();
        // ---------- Original Method ----------
        //if (this.readTimeout == -1)
            //return;
        //if (this.myTimerTask != null)
            //this.myTimerTask.cancel();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.256 -0400", hash_original_method = "B005CBAD4698DC28B9A1B35993572349", hash_generated_method = "D525B687107201E0639D515E37075902")
    public void write(byte[] bytes, int start, int length) throws IOException {
        addTaint(length);
        addTaint(start);
        addTaint(bytes[0]);
        if(this.isClosed)        
        {
        IOException var9919040440F76E2B6E268DAEA5D4134D_919413719 = new IOException("Closed!!");
        var9919040440F76E2B6E268DAEA5D4134D_919413719.addTaint(taint);
        throw var9919040440F76E2B6E268DAEA5D4134D_919413719;
        }
        Buffer buff = new Buffer(bytes, length);
        buff.ptr = start;
        synchronized
(this.buffList)        {
            buffList.add(buff);
            buffList.notifyAll();
        } //End block
        // ---------- Original Method ----------
        //if (this.isClosed)
            //throw new IOException("Closed!!");
        //Buffer buff = new Buffer(bytes, length);
        //buff.ptr = start;
        //synchronized (this.buffList) {
            //buffList.add(buff);
            //buffList.notifyAll();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.257 -0400", hash_original_method = "C06546AC352C387D8ACC673056FAD350", hash_generated_method = "34735B8E84F6FCA8D09563EE8CECB9D4")
    public void write(byte[] bytes) throws IOException {
        addTaint(bytes[0]);
        if(this.isClosed)        
        {
        IOException var9919040440F76E2B6E268DAEA5D4134D_912031964 = new IOException("Closed!!");
        var9919040440F76E2B6E268DAEA5D4134D_912031964.addTaint(taint);
        throw var9919040440F76E2B6E268DAEA5D4134D_912031964;
        }
        Buffer buff = new Buffer(bytes, bytes.length);
        synchronized
(this.buffList)        {
            buffList.add(buff);
            buffList.notifyAll();
        } //End block
        // ---------- Original Method ----------
        //if (this.isClosed)
            //throw new IOException("Closed!!");
        //Buffer buff = new Buffer(bytes, bytes.length);
        //synchronized (this.buffList) {
            //buffList.add(buff);
            //buffList.notifyAll();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.258 -0400", hash_original_method = "9D61CBBC55A04932A86EE90F3831850B", hash_generated_method = "B867A1B5A44B26D8032AA9D1A8C08AF6")
    public void close() throws IOException {
        this.isClosed = true;
        synchronized
(this.buffList)        {
            this.buffList.notifyAll();
        } //End block
        this.pipe.close();
        // ---------- Original Method ----------
        //this.isClosed = true;
        //synchronized (this.buffList) {
            //this.buffList.notifyAll();
        //}
        //this.pipe.close();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.260 -0400", hash_original_method = "F2F79F1D43766E909F353C0CFC9043D6", hash_generated_method = "60FCF488A7F348ABCB1EA8689BF48C9A")
    public int read() throws IOException {
        synchronized
(this.buffList)        {
            if(currentBuffer != null
                    && currentBuffer.ptr < currentBuffer.length)            
            {
                int retval = currentBuffer.getNextByte();
                if(currentBuffer.ptr == currentBuffer.length)                
                this.currentBuffer = null;
                int var020B759ADEF679A47CB9AFE965BB2314_617506993 = (retval);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_133083012 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_133083012;
            } //End block
            if(this.isClosed && this.buffList.isEmpty())            
            {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_1183072087 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1873812017 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1873812017;
            }
            try 
            {
                while
(this.buffList.isEmpty())                
                {
                    this.buffList.wait();
                    if(this.isClosed)                    
                    {
                    int var6BB61E3B7BCE0931DA574D19D1D82C88_1202672406 = (-1);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1316017195 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1316017195;
                    }
                } //End block
                currentBuffer = (Buffer) this.buffList.removeFirst();
                int retval = currentBuffer.getNextByte();
                if(currentBuffer.ptr == currentBuffer.length)                
                this.currentBuffer = null;
                int var020B759ADEF679A47CB9AFE965BB2314_1928867776 = (retval);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1131739709 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1131739709;
            } //End block
            catch (InterruptedException ex)
            {
                IOException var1FC0CF6650AEC5395B2E1C7E06C33B6F_330806113 = new IOException(ex.getMessage());
                var1FC0CF6650AEC5395B2E1C7E06C33B6F_330806113.addTaint(taint);
                throw var1FC0CF6650AEC5395B2E1C7E06C33B6F_330806113;
            } //End block
            catch (NoSuchElementException ex)
            {
                ex.printStackTrace();
                IOException var1FC0CF6650AEC5395B2E1C7E06C33B6F_1721720683 = new IOException(ex.getMessage());
                var1FC0CF6650AEC5395B2E1C7E06C33B6F_1721720683.addTaint(taint);
                throw var1FC0CF6650AEC5395B2E1C7E06C33B6F_1721720683;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    class MyTimer extends SIPStackTimerTask {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.262 -0400", hash_original_field = "99F6F4BE0908F24BB4A22A4FFB277DA4", hash_generated_field = "7840915867A0DD99EC64B89800E1CB6D")

        Pipeline pipeline;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.262 -0400", hash_original_field = "8635331F2AC93FE51B1EAC6451DA1DCC", hash_generated_field = "59DB49985984D67A006441E7DEFF885A")

        private boolean isCancelled;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.263 -0400", hash_original_method = "469A54409CE651B527E545FCC2B571E7", hash_generated_method = "1427EA2EBB4B5AD7315253D0FC644C17")
        protected  MyTimer(Pipeline pipeline) {
            this.pipeline = pipeline;
            // ---------- Original Method ----------
            //this.pipeline = pipeline;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.263 -0400", hash_original_method = "6E25F52123B3B61D6A13AFDDD464AC50", hash_generated_method = "303D90C268A39060C89EA65A33526DDF")
        protected void runTask() {
            if(this.isCancelled)            
            return;
            try 
            {
                pipeline.close();
            } //End block
            catch (IOException ex)
            {
                InternalErrorHandler.handleException(ex);
            } //End block
            // ---------- Original Method ----------
            //if (this.isCancelled)
                //return;
            //try {
                //pipeline.close();
            //} catch (IOException ex) {
                //InternalErrorHandler.handleException(ex);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.264 -0400", hash_original_method = "866118B2542F2688ED0E9C68986718EB", hash_generated_method = "537826948ABF88BE67ACE53B71EF9DFB")
        public boolean cancel() {
            boolean retval = super.cancel();
            this.isCancelled = true;
            boolean var020B759ADEF679A47CB9AFE965BB2314_1844444298 = (retval);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_141052091 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_141052091;
            // ---------- Original Method ----------
            //boolean retval = super.cancel();
            //this.isCancelled = true;
            //return retval;
        }

        
    }


    
    class Buffer {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.264 -0400", hash_original_field = "4B3A6218BB3E3A7303E8A171A60FCF92", hash_generated_field = "AB97A4156FC1CC1DAF26375194010FF1")

        byte[] bytes;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.264 -0400", hash_original_field = "2FA47F7C65FEC19CC163B195725E3844", hash_generated_field = "136C4DD872F8065EECD33F6CD4E7556E")

        int length;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.265 -0400", hash_original_field = "4D9AD2B37053671B594B237BD061B3F2", hash_generated_field = "407F33A4FEC278EC364347D42DC7DA18")

        int ptr;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.266 -0400", hash_original_method = "093A036FC0CE68502CB27911CE2FE87A", hash_generated_method = "472B6068A5A13A0C758199B66E1D9C16")
        public  Buffer(byte[] bytes, int length) {
            ptr = 0;
            this.length = length;
            this.bytes = bytes;
            // ---------- Original Method ----------
            //ptr = 0;
            //this.length = length;
            //this.bytes = bytes;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.266 -0400", hash_original_method = "C5E9FA9D1099E171DFD942E3B525903F", hash_generated_method = "C9F7CB8A32E4CB9B8E3FD695412210E9")
        public int getNextByte() {
            int retval = bytes[ptr++] & 0xFF;
            int var020B759ADEF679A47CB9AFE965BB2314_394715932 = (retval);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_926262534 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_926262534;
            // ---------- Original Method ----------
            //int retval = bytes[ptr++] & 0xFF;
            //return retval;
        }

        
    }


    
}

