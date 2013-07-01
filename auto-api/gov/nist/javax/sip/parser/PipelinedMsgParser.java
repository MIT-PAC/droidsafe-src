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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.398 -0400", hash_original_field = "0BFCB22B0FA3021CB632B75985A84AE3", hash_generated_field = "E951DA693006702904D44903EC071300")

    protected SIPMessageListener sipMessageListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.398 -0400", hash_original_field = "9842605C72E3BC73DA5398CE4B5EB840", hash_generated_field = "8890F3B68DD2F65EEDEBEEF6284B3EE1")

    private Thread mythread;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.398 -0400", hash_original_field = "2759837858165AEB83DF72AAAD1EDF36", hash_generated_field = "EE0974413FD18213D1855469CB35ED3B")

    private Pipeline rawInputStream;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.398 -0400", hash_original_field = "BF1B271FFDC69F10249067CA74EC9584", hash_generated_field = "6056A74FE8111EC12B2D46373C91E6E1")

    private int maxMessageSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.398 -0400", hash_original_field = "00E1B751A8E3E1D3B531BBBCD4E40948", hash_generated_field = "87B02180527F6273015739A99F276EBD")

    private int sizeCounter;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.399 -0400", hash_original_method = "E22CE959BAB24F19C875E84872180E07", hash_generated_method = "362C6A06EBFCC475DC7BD25EA8D59893")
    protected  PipelinedMsgParser() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.399 -0400", hash_original_method = "A3AB807F1456A67D8271D731B6987080", hash_generated_method = "42B0CF46200A61F1D64551D16CA8B0BC")
    public  PipelinedMsgParser(SIPMessageListener sipMessageListener,
            Pipeline in, boolean debug, int maxMessageSize) {
        this();
        this.sipMessageListener = sipMessageListener;
        rawInputStream = in;
        this.maxMessageSize = maxMessageSize;
        mythread = new Thread(this);
        mythread.setName("PipelineThread-" + getNewUid());
        addTaint(debug);
        // ---------- Original Method ----------
        //this.sipMessageListener = sipMessageListener;
        //rawInputStream = in;
        //this.maxMessageSize = maxMessageSize;
        //mythread = new Thread(this);
        //mythread.setName("PipelineThread-" + getNewUid());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.400 -0400", hash_original_method = "BDF51C7E7DDD69BD9B7D7DBBB57B9FF1", hash_generated_method = "9A2FF3D67C3FDB9A469FDD2C647B3854")
    public  PipelinedMsgParser(SIPMessageListener mhandler, Pipeline in,
            int maxMsgSize) {
        this(mhandler, in, false, maxMsgSize);
        addTaint(mhandler.getTaint());
        addTaint(in.getTaint());
        addTaint(maxMsgSize);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.400 -0400", hash_original_method = "748DD8A3EFE43FF431548555AB3BE25D", hash_generated_method = "3038AA5B53537C11A13D7FA6558B7FA2")
    public  PipelinedMsgParser(Pipeline in) {
        this(null, in, false, 0);
        addTaint(in.getTaint());
        // ---------- Original Method ----------
    }

    
    private static synchronized int getNewUid() {
        return uid++;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.400 -0400", hash_original_method = "AFB6FAED7CE2C798D2C88DCB60C1E3BA", hash_generated_method = "5A7C2DED95E3A949F3D0D6A47527D147")
    public void processInput() {
        mythread.start();
        // ---------- Original Method ----------
        //mythread.start();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.401 -0400", hash_original_method = "7B58421AA7682D1CD65CE1288FB2F0E9", hash_generated_method = "EB2B69DD42A771F85C568E1CA68670F2")
    protected Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_908590274 = null; //Variable for return #1
        PipelinedMsgParser p = new PipelinedMsgParser();
        p.rawInputStream = this.rawInputStream;
        p.sipMessageListener = this.sipMessageListener;
        Thread mythread = new Thread(p);
        mythread.setName("PipelineThread");
        varB4EAC82CA7396A68D541C85D26508E83_908590274 = p;
        varB4EAC82CA7396A68D541C85D26508E83_908590274.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_908590274;
        // ---------- Original Method ----------
        //PipelinedMsgParser p = new PipelinedMsgParser();
        //p.rawInputStream = this.rawInputStream;
        //p.sipMessageListener = this.sipMessageListener;
        //Thread mythread = new Thread(p);
        //mythread.setName("PipelineThread");
        //return p;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.401 -0400", hash_original_method = "AE1DFBE29C50512ACC863FBFFDC539ED", hash_generated_method = "853BB09F699662204A7FAC41D98CD659")
    public void setMessageListener(SIPMessageListener mlistener) {
        sipMessageListener = mlistener;
        // ---------- Original Method ----------
        //sipMessageListener = mlistener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.402 -0400", hash_original_method = "CA26412E58B11F2830D7673D2CC5E1EF", hash_generated_method = "38A7D317FCE40CA93C6174C74612911D")
    private String readLine(InputStream inputStream) throws IOException {
        String varB4EAC82CA7396A68D541C85D26508E83_1639413818 = null; //Variable for return #1
        StringBuffer retval = new StringBuffer("");
        {
            char ch;
            int i = inputStream.read();
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("End of stream");
            } //End block
            ch = (char) i;
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("Max size exceeded!");
            } //End block
            retval.append(ch);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1639413818 = retval.toString();
        addTaint(inputStream.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1639413818.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1639413818;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.404 -0400", hash_original_method = "4591706E6DAAE4ED54EAE930623099BB", hash_generated_method = "C662EF2E4FBACD9A02B01D102EE23B13")
    public void run() {
        Pipeline inputStream = this.rawInputStream;
        try 
        {
            {
                this.sizeCounter = this.maxMessageSize;
                StringBuffer inputBuffer = new StringBuffer();
                Debug.println("Starting parse!");
                String line1 = null;
                String line2 = null;
                {
                    try 
                    {
                        line1 = readLine(inputStream);
                        {
                            boolean var18A2C9203A3D833765FF2840DAA6399A_778925897 = (line1.equals("\n"));
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
                            boolean var161D78251336BA90A13BBA4567AF4368_913062083 = (line2.trim().equals(""));
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
                StringMsgParser smp = new StringMsgParser(sipMessageListener);
                smp.readBody = false;
                SIPMessage sipMessage = null;
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
                ContentLength cl = (ContentLength) sipMessage
                        .getContentLength();
                int contentLength = 0;
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
                    byte[] message_body = new byte[contentLength];
                    int nread = 0;
                    {
                        this.rawInputStream.startTimer();
                        try 
                        {
                            int readlength = inputStream.read(message_body,
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.405 -0400", hash_original_method = "CD7CB4D97896F4DDC9750ED4F3C04317", hash_generated_method = "D8499A34E86CDA9E47E8F0CCF5D7CBA5")
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.405 -0400", hash_original_field = "0CB100AF67BD2EB1F0E2A464C0F12B08", hash_generated_field = "C945ED2D87187C29A8B309C59A8903B9")

    private static int uid = 0;
}

