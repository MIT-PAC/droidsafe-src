package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.core.*;
import gov.nist.javax.sip.message.*;
import gov.nist.javax.sip.header.*;
import java.text.ParseException;
import java.io.*;

public final class PipelinedMsgParser implements Runnable {
    protected SIPMessageListener sipMessageListener;
    private Thread mythread;
    private Pipeline rawInputStream;
    private int maxMessageSize;
    private int sizeCounter;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.472 -0400", hash_original_method = "E22CE959BAB24F19C875E84872180E07", hash_generated_method = "362C6A06EBFCC475DC7BD25EA8D59893")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected PipelinedMsgParser() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.472 -0400", hash_original_method = "A3AB807F1456A67D8271D731B6987080", hash_generated_method = "8C7A0D75A79F67B84166865211C9BB69")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PipelinedMsgParser(SIPMessageListener sipMessageListener,
            Pipeline in, boolean debug, int maxMessageSize) {
        this();
        dsTaint.addTaint(sipMessageListener.dsTaint);
        dsTaint.addTaint(maxMessageSize);
        dsTaint.addTaint(debug);
        dsTaint.addTaint(in.dsTaint);
        mythread = new Thread(this);
        mythread.setName("PipelineThread-" + getNewUid());
        // ---------- Original Method ----------
        //this.sipMessageListener = sipMessageListener;
        //rawInputStream = in;
        //this.maxMessageSize = maxMessageSize;
        //mythread = new Thread(this);
        //mythread.setName("PipelineThread-" + getNewUid());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.473 -0400", hash_original_method = "BDF51C7E7DDD69BD9B7D7DBBB57B9FF1", hash_generated_method = "1942376166532E4DF1606F4644033334")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PipelinedMsgParser(SIPMessageListener mhandler, Pipeline in,
            int maxMsgSize) {
        this(mhandler, in, false, maxMsgSize);
        dsTaint.addTaint(maxMsgSize);
        dsTaint.addTaint(mhandler.dsTaint);
        dsTaint.addTaint(in.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.473 -0400", hash_original_method = "748DD8A3EFE43FF431548555AB3BE25D", hash_generated_method = "730F244645D7ED95BC4863A40FCEB4F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PipelinedMsgParser(Pipeline in) {
        this(null, in, false, 0);
        dsTaint.addTaint(in.dsTaint);
        // ---------- Original Method ----------
    }

    
        private static synchronized int getNewUid() {
        return uid++;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.473 -0400", hash_original_method = "AFB6FAED7CE2C798D2C88DCB60C1E3BA", hash_generated_method = "5A7C2DED95E3A949F3D0D6A47527D147")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void processInput() {
        mythread.start();
        // ---------- Original Method ----------
        //mythread.start();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.473 -0400", hash_original_method = "7B58421AA7682D1CD65CE1288FB2F0E9", hash_generated_method = "993836DEF9D15872EDD6BD971F18CDA4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected Object clone() {
        PipelinedMsgParser p;
        p = new PipelinedMsgParser();
        p.rawInputStream = this.rawInputStream;
        p.sipMessageListener = this.sipMessageListener;
        Thread mythread;
        mythread = new Thread(p);
        mythread.setName("PipelineThread");
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //PipelinedMsgParser p = new PipelinedMsgParser();
        //p.rawInputStream = this.rawInputStream;
        //p.sipMessageListener = this.sipMessageListener;
        //Thread mythread = new Thread(p);
        //mythread.setName("PipelineThread");
        //return p;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.473 -0400", hash_original_method = "AE1DFBE29C50512ACC863FBFFDC539ED", hash_generated_method = "2604D25AB408AAF7CFD751703F8B43D5")
    @DSModeled(DSC.SAFE)
    public void setMessageListener(SIPMessageListener mlistener) {
        dsTaint.addTaint(mlistener.dsTaint);
        // ---------- Original Method ----------
        //sipMessageListener = mlistener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.474 -0400", hash_original_method = "CA26412E58B11F2830D7673D2CC5E1EF", hash_generated_method = "9FC7A8607CC63F1F9D3B1A70A2E54D65")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String readLine(InputStream inputStream) throws IOException {
        dsTaint.addTaint(inputStream.dsTaint);
        StringBuffer retval;
        retval = new StringBuffer("");
        {
            char ch;
            int i;
            i = inputStream.read();
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("End of stream");
            } //End block
            ch = (char) i;
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("Max size exceeded!");
            } //End block
            retval.append(ch);
        } //End block
        String var0F1F65BA89BF920BA1A29FC87F91B969_543508658 = (retval.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuffer retval = new StringBuffer("");
        //while (true) {
            //char ch;
            //int i = inputStream.read();
            //if (i == -1) {
                //throw new IOException("End of stream");
            //} else
                //ch = (char) i;
            //if (this.maxMessageSize > 0) {
                //this.sizeCounter--;
                //if (this.sizeCounter <= 0)
                    //throw new IOException("Max size exceeded!");
            //}
            //if (ch != '\r')
                //retval.append(ch);
            //if (ch == '\n') {
                //break;
            //}
        //}
        //return retval.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.475 -0400", hash_original_method = "4591706E6DAAE4ED54EAE930623099BB", hash_generated_method = "C690A0AF5116B6CE8A94347AAFAAF4A0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void run() {
        Pipeline inputStream;
        inputStream = this.rawInputStream;
        try 
        {
            {
                this.sizeCounter = this.maxMessageSize;
                StringBuffer inputBuffer;
                inputBuffer = new StringBuffer();
                Debug.println("Starting parse!");
                String line1;
                String line2;
                line2 = null;
                {
                    try 
                    {
                        line1 = readLine(inputStream);
                        {
                            boolean var18A2C9203A3D833765FF2840DAA6399A_1127152789 = (line1.equals("\n"));
                            {
                                {
                                    Debug.println("Discarding blank line. ");
                                } //End block
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    catch (IOException ex)
                    {
                        Debug.printStackTrace(ex);
                        this.rawInputStream.stopTimer();
                    } //End block
                } //End block
                inputBuffer.append(line1);
                this.rawInputStream.startTimer();
                Debug.println("Reading Input Stream");
                {
                    try 
                    {
                        line2 = readLine(inputStream);
                        inputBuffer.append(line2);
                        {
                            boolean var161D78251336BA90A13BBA4567AF4368_1941424251 = (line2.trim().equals(""));
                        } //End collapsed parenthetic
                    } //End block
                    catch (IOException ex)
                    {
                        this.rawInputStream.stopTimer();
                        Debug.printStackTrace(ex);
                    } //End block
                } //End block
                this.rawInputStream.stopTimer();
                inputBuffer.append(line2);
                StringMsgParser smp;
                smp = new StringMsgParser(sipMessageListener);
                smp.readBody = false;
                SIPMessage sipMessage;
                sipMessage = null;
                try 
                {
                    {
                        Debug.println("About to parse : " + inputBuffer.toString());
                    } //End block
                    sipMessage = smp.parseSIPMessage(inputBuffer.toString());
                    {
                        this.rawInputStream.stopTimer();
                    } //End block
                } //End block
                catch (ParseException ex)
                {
                    Debug.logError("Detected a parse error", ex);
                } //End block
                {
                    Debug.println("Completed parsing message");
                } //End block
                ContentLength cl;
                cl = (ContentLength) sipMessage
                        .getContentLength();
                int contentLength;
                contentLength = 0;
                {
                    contentLength = cl.getContentLength();
                } //End block
                {
                    contentLength = 0;
                } //End block
                {
                    Debug.println("contentLength " + contentLength);
                } //End block
                {
                    sipMessage.removeContent();
                } //End block
                {
                    byte[] message_body;
                    message_body = new byte[contentLength];
                    int nread;
                    nread = 0;
                    {
                        this.rawInputStream.startTimer();
                        try 
                        {
                            int readlength;
                            readlength = inputStream.read(message_body,
                                    nread, contentLength - nread);
                            {
                                nread += readlength;
                            } //End block
                        } //End block
                        catch (IOException ex)
                        {
                            Debug.logError("Exception Reading Content",ex);
                        } //End block
                        finally 
                        {
                            this.rawInputStream.stopTimer();
                        } //End block
                    } //End block
                    sipMessage.setMessageContent(message_body);
                } //End block
                {
                    try 
                    {
                        sipMessageListener.processMessage(sipMessage);
                    } //End block
                    catch (Exception ex)
                    { }
                } //End block
            } //End block
        } //End block
        finally 
        {
            try 
            {
                inputStream.close();
            } //End block
            catch (IOException e)
            {
                InternalErrorHandler.handleException(e);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.475 -0400", hash_original_method = "CD7CB4D97896F4DDC9750ED4F3C04317", hash_generated_method = "D8499A34E86CDA9E47E8F0CCF5D7CBA5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void close() {
        try 
        {
            this.rawInputStream.close();
        } //End block
        catch (IOException ex)
        { }
        // ---------- Original Method ----------
        //try {
            //this.rawInputStream.close();
        //} catch (IOException ex) {
        //}
    }

    
    private static int uid = 0;
}

