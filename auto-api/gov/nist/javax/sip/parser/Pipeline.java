package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.core.InternalErrorHandler;
import gov.nist.javax.sip.stack.SIPStackTimerTask;
import java.io.*;
import java.util.*;

public class Pipeline extends InputStream {
    private LinkedList buffList;
    private Buffer currentBuffer;
    private boolean isClosed;
    private Timer timer;
    private InputStream pipe;
    private int readTimeout;
    private TimerTask myTimerTask;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.461 -0400", hash_original_method = "F09CF9CB05C3E89BEBCB566F6112879F", hash_generated_method = "014B2F8565EBDDD5A5595BC09ADEF1B1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Pipeline(InputStream pipe, int readTimeout, Timer timer) {
        dsTaint.addTaint(readTimeout);
        dsTaint.addTaint(timer.dsTaint);
        dsTaint.addTaint(pipe.dsTaint);
        buffList = new LinkedList();
        // ---------- Original Method ----------
        //this.timer = timer;
        //this.pipe = pipe;
        //buffList = new LinkedList();
        //this.readTimeout = readTimeout;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.461 -0400", hash_original_method = "2B544F7E796D3D68CE94D6BF6C677E04", hash_generated_method = "DDC95ADC070313150C821BF878D93632")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void startTimer() {
        this.myTimerTask = new MyTimer(this);
        this.timer.schedule(this.myTimerTask, this.readTimeout);
        // ---------- Original Method ----------
        //if (this.readTimeout == -1)
            //return;
        //this.myTimerTask = new MyTimer(this);
        //this.timer.schedule(this.myTimerTask, this.readTimeout);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.461 -0400", hash_original_method = "37F409FD7F01F3081F8A12D9761B8422", hash_generated_method = "12BEF41184C2C7B905B236B9F62E82E5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void stopTimer() {
        this.myTimerTask.cancel();
        // ---------- Original Method ----------
        //if (this.readTimeout == -1)
            //return;
        //if (this.myTimerTask != null)
            //this.myTimerTask.cancel();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.461 -0400", hash_original_method = "B005CBAD4698DC28B9A1B35993572349", hash_generated_method = "C8A4C416F360FB3EA2E1524821717079")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void write(byte[] bytes, int start, int length) throws IOException {
        dsTaint.addTaint(bytes[0]);
        dsTaint.addTaint(start);
        dsTaint.addTaint(length);
        if (DroidSafeAndroidRuntime.control) throw new IOException("Closed!!");
        Buffer buff;
        buff = new Buffer(bytes, length);
        buff.ptr = start;
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.462 -0400", hash_original_method = "C06546AC352C387D8ACC673056FAD350", hash_generated_method = "456E47B7FC28DDDEEBD45D6297AE07C0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void write(byte[] bytes) throws IOException {
        dsTaint.addTaint(bytes[0]);
        if (DroidSafeAndroidRuntime.control) throw new IOException("Closed!!");
        Buffer buff;
        buff = new Buffer(bytes, bytes.length);
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.462 -0400", hash_original_method = "9D61CBBC55A04932A86EE90F3831850B", hash_generated_method = "9A17ABCE2088D9237267B0C1150FA666")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void close() throws IOException {
        this.isClosed = true;
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.463 -0400", hash_original_method = "F2F79F1D43766E909F353C0CFC9043D6", hash_generated_method = "72131EAFD77A7D49175037B20E684120")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int read() throws IOException {
        {
            {
                int retval;
                retval = currentBuffer.getNextByte();
                this.currentBuffer = null;
            } //End block
            {
                boolean var702A97E9FFAB272C43CE3C8CADFE6348_665436597 = (this.isClosed && this.buffList.isEmpty());
            } //End collapsed parenthetic
            try 
            {
                {
                    boolean varC73B6569C0DBCE872A63D294569E0B26_1275172798 = (this.buffList.isEmpty());
                    {
                        this.buffList.wait();
                    } //End block
                } //End collapsed parenthetic
                currentBuffer = (Buffer) this.buffList.removeFirst();
                int retval;
                retval = currentBuffer.getNextByte();
                this.currentBuffer = null;
            } //End block
            catch (InterruptedException ex)
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException(ex.getMessage());
            } //End block
            catch (NoSuchElementException ex)
            {
                ex.printStackTrace();
                if (DroidSafeAndroidRuntime.control) throw new IOException(ex.getMessage());
            } //End block
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    class MyTimer extends SIPStackTimerTask {
        Pipeline pipeline;
        private boolean isCancelled;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.464 -0400", hash_original_method = "469A54409CE651B527E545FCC2B571E7", hash_generated_method = "238DBA4C5A3BE26484FD7371C34B9838")
        @DSModeled(DSC.SAFE)
        protected MyTimer(Pipeline pipeline) {
            dsTaint.addTaint(pipeline.dsTaint);
            // ---------- Original Method ----------
            //this.pipeline = pipeline;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.464 -0400", hash_original_method = "6E25F52123B3B61D6A13AFDDD464AC50", hash_generated_method = "0AFC3109E8EE0E2B16DD1BD4F8D03837")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected void runTask() {
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.464 -0400", hash_original_method = "866118B2542F2688ED0E9C68986718EB", hash_generated_method = "CDA3FCA9785CD6FFECEC2902401DEA50")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean cancel() {
            boolean retval;
            retval = super.cancel();
            this.isCancelled = true;
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //boolean retval = super.cancel();
            //this.isCancelled = true;
            //return retval;
        }

        
    }


    
    class Buffer {
        byte[] bytes;
        int length;
        int ptr;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.465 -0400", hash_original_method = "093A036FC0CE68502CB27911CE2FE87A", hash_generated_method = "B852C640C9DC9737F23676E8AD791131")
        @DSModeled(DSC.SAFE)
        public Buffer(byte[] bytes, int length) {
            dsTaint.addTaint(bytes[0]);
            dsTaint.addTaint(length);
            ptr = 0;
            // ---------- Original Method ----------
            //ptr = 0;
            //this.length = length;
            //this.bytes = bytes;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.465 -0400", hash_original_method = "C5E9FA9D1099E171DFD942E3B525903F", hash_generated_method = "0798452116B8562DCB258DDEB0C9C92C")
        @DSModeled(DSC.SAFE)
        public int getNextByte() {
            int retval;
            retval = bytes[ptr++] & 0xFF;
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //int retval = bytes[ptr++] & 0xFF;
            //return retval;
        }

        
    }


    
}

