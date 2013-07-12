package gov.nist.javax.sip.parser;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.core.*;
import gov.nist.javax.sip.message.*;
import gov.nist.javax.sip.header.*;
import java.text.ParseException;
import java.io.*;

public final class PipelinedMsgParser implements Runnable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:41.433 -0400", hash_original_field = "0BFCB22B0FA3021CB632B75985A84AE3", hash_generated_field = "E951DA693006702904D44903EC071300")

    protected SIPMessageListener sipMessageListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:41.433 -0400", hash_original_field = "9842605C72E3BC73DA5398CE4B5EB840", hash_generated_field = "8890F3B68DD2F65EEDEBEEF6284B3EE1")

    private Thread mythread;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:41.433 -0400", hash_original_field = "2759837858165AEB83DF72AAAD1EDF36", hash_generated_field = "EE0974413FD18213D1855469CB35ED3B")

    private Pipeline rawInputStream;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:41.433 -0400", hash_original_field = "BF1B271FFDC69F10249067CA74EC9584", hash_generated_field = "6056A74FE8111EC12B2D46373C91E6E1")

    private int maxMessageSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:41.433 -0400", hash_original_field = "00E1B751A8E3E1D3B531BBBCD4E40948", hash_generated_field = "87B02180527F6273015739A99F276EBD")

    private int sizeCounter;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:41.434 -0400", hash_original_method = "E22CE959BAB24F19C875E84872180E07", hash_generated_method = "362C6A06EBFCC475DC7BD25EA8D59893")
    protected  PipelinedMsgParser() {
        super();
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:41.435 -0400", hash_original_method = "A3AB807F1456A67D8271D731B6987080", hash_generated_method = "BD9DE796F5D2FEC781FD56D51A7F9912")
    public  PipelinedMsgParser(SIPMessageListener sipMessageListener,
            Pipeline in, boolean debug, int maxMessageSize) {
        this();
        addTaint(debug);
        this.sipMessageListener = sipMessageListener;
        rawInputStream = in;
        this.maxMessageSize = maxMessageSize;
        mythread = new Thread(this);
        mythread.setName("PipelineThread-" + getNewUid());
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:41.436 -0400", hash_original_method = "BDF51C7E7DDD69BD9B7D7DBBB57B9FF1", hash_generated_method = "221A6DCBA2C7DAFFC85ECEE9ADDCFEE7")
    public  PipelinedMsgParser(SIPMessageListener mhandler, Pipeline in,
            int maxMsgSize) {
        this(mhandler, in, false, maxMsgSize);
        addTaint(maxMsgSize);
        addTaint(in.getTaint());
        addTaint(mhandler.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:41.437 -0400", hash_original_method = "748DD8A3EFE43FF431548555AB3BE25D", hash_generated_method = "3038AA5B53537C11A13D7FA6558B7FA2")
    public  PipelinedMsgParser(Pipeline in) {
        this(null, in, false, 0);
        addTaint(in.getTaint());
        
    }

    
        @DSModeled(DSC.SAFE)
    private static synchronized int getNewUid() {
        return uid++;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:41.438 -0400", hash_original_method = "AFB6FAED7CE2C798D2C88DCB60C1E3BA", hash_generated_method = "5A7C2DED95E3A949F3D0D6A47527D147")
    public void processInput() {
        mythread.start();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:41.439 -0400", hash_original_method = "7B58421AA7682D1CD65CE1288FB2F0E9", hash_generated_method = "D0EF6DB3757C5769542AB4550A799B66")
    protected Object clone() {
        PipelinedMsgParser p = new PipelinedMsgParser();
        p.rawInputStream = this.rawInputStream;
        p.sipMessageListener = this.sipMessageListener;
        Thread mythread = new Thread(p);
        mythread.setName("PipelineThread");
Object var74E4690D9F2A026504928C017944E149_1052112470 =         p;
        var74E4690D9F2A026504928C017944E149_1052112470.addTaint(taint);
        return var74E4690D9F2A026504928C017944E149_1052112470;
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:41.440 -0400", hash_original_method = "AE1DFBE29C50512ACC863FBFFDC539ED", hash_generated_method = "853BB09F699662204A7FAC41D98CD659")
    public void setMessageListener(SIPMessageListener mlistener) {
        sipMessageListener = mlistener;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:41.440 -0400", hash_original_method = "CA26412E58B11F2830D7673D2CC5E1EF", hash_generated_method = "B40505A96BB12C347FA43FFD9FEA30D4")
    private String readLine(InputStream inputStream) throws IOException {
        addTaint(inputStream.getTaint());
        StringBuffer retval = new StringBuffer("");
        while
(true)        
        {
            char ch;
            int i = inputStream.read();
    if(i == -1)            
            {
                IOException varC66D24A26061D49450FA56EB3E7BB066_582528756 = new IOException("End of stream");
                varC66D24A26061D49450FA56EB3E7BB066_582528756.addTaint(taint);
                throw varC66D24A26061D49450FA56EB3E7BB066_582528756;
            } 
            else
            ch = (char) i;
    if(this.maxMessageSize > 0)            
            {
                this.sizeCounter--;
    if(this.sizeCounter <= 0)                
                {
                IOException var2096C78080BB34E8F80BA52B746DF290_1492702578 = new IOException("Max size exceeded!");
                var2096C78080BB34E8F80BA52B746DF290_1492702578.addTaint(taint);
                throw var2096C78080BB34E8F80BA52B746DF290_1492702578;
                }
            } 
    if(ch != '\r')            
            retval.append(ch);
    if(ch == '\n')            
            {
                break;
            } 
        } 
String var1B324365A764C077A55854483509F4AB_1835986132 =         retval.toString();
        var1B324365A764C077A55854483509F4AB_1835986132.addTaint(taint);
        return var1B324365A764C077A55854483509F4AB_1835986132;
        
        
        
            
            
            
                
            
                
            
                
                
                    
            
            
                
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:41.444 -0400", hash_original_method = "4591706E6DAAE4ED54EAE930623099BB", hash_generated_method = "FDA85F84C593795ED1A4189CAB96ACDF")
    public void run() {
        Pipeline inputStream = this.rawInputStream;
        try 
        {
            while
(true)            
            {
                this.sizeCounter = this.maxMessageSize;
                StringBuffer inputBuffer = new StringBuffer();
    if(Debug.parserDebug)                
                Debug.println("Starting parse!");
                String line1;
                String line2 = null;
                while
(true)                
                {
                    try 
                    {
                        line1 = readLine(inputStream);
    if(line1.equals("\n"))                        
                        {
    if(Debug.parserDebug)                            
                            {
                                Debug.println("Discarding blank line. ");
                            } 
                            continue;
                        } 
                        else
                        break;
                    } 
                    catch (IOException ex)
                    {
                        Debug.printStackTrace(ex);
                        this.rawInputStream.stopTimer();
                        return;
                    } 
                } 
                inputBuffer.append(line1);
                this.rawInputStream.startTimer();
                Debug.println("Reading Input Stream");
                while
(true)                
                {
                    try 
                    {
                        line2 = readLine(inputStream);
                        inputBuffer.append(line2);
    if(line2.trim().equals(""))                        
                        break;
                    } 
                    catch (IOException ex)
                    {
                        this.rawInputStream.stopTimer();
                        Debug.printStackTrace(ex);
                        return;
                    } 
                } 
                this.rawInputStream.stopTimer();
                inputBuffer.append(line2);
                StringMsgParser smp = new StringMsgParser(sipMessageListener);
                smp.readBody = false;
                SIPMessage sipMessage = null;
                try 
                {
    if(Debug.debug)                    
                    {
                        Debug.println("About to parse : " + inputBuffer.toString());
                    } 
                    sipMessage = smp.parseSIPMessage(inputBuffer.toString());
    if(sipMessage == null)                    
                    {
                        this.rawInputStream.stopTimer();
                        continue;
                    } 
                } 
                catch (ParseException ex)
                {
                    Debug.logError("Detected a parse error", ex);
                    continue;
                } 
    if(Debug.debug)                
                {
                    Debug.println("Completed parsing message");
                } 
                ContentLength cl = (ContentLength) sipMessage
                        .getContentLength();
                int contentLength = 0;
    if(cl != null)                
                {
                    contentLength = cl.getContentLength();
                } 
                else
                {
                    contentLength = 0;
                } 
    if(Debug.debug)                
                {
                    Debug.println("contentLength " + contentLength);
                } 
    if(contentLength == 0)                
                {
                    sipMessage.removeContent();
                } 
                else
    if(maxMessageSize == 0
                        || contentLength < this.sizeCounter)                
                {
                    byte[] message_body = new byte[contentLength];
                    int nread = 0;
                    while
(nread < contentLength)                    
                    {
                        this.rawInputStream.startTimer();
                        try 
                        {
                            int readlength = inputStream.read(message_body,
                                    nread, contentLength - nread);
    if(readlength > 0)                            
                            {
                                nread += readlength;
                            } 
                            else
                            {
                                break;
                            } 
                        } 
                        catch (IOException ex)
                        {
                            Debug.logError("Exception Reading Content",ex);
                            break;
                        } 
                        finally 
                        {
                            this.rawInputStream.stopTimer();
                        } 
                    } 
                    sipMessage.setMessageContent(message_body);
                } 
    if(sipMessageListener != null)                
                {
                    try 
                    {
                        sipMessageListener.processMessage(sipMessage);
                    } 
                    catch (Exception ex)
                    {
                        break;
                    } 
                } 
            } 
        } 
        finally 
        {
            try 
            {
                inputStream.close();
            } 
            catch (IOException e)
            {
                InternalErrorHandler.handleException(e);
            } 
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:41.447 -0400", hash_original_method = "CD7CB4D97896F4DDC9750ED4F3C04317", hash_generated_method = "192A77C307E1B0090303A5E8F33C3527")
    public void close() {
        try 
        {
            this.rawInputStream.close();
        } 
        catch (IOException ex)
        {
        } 
        
        
            
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:41.447 -0400", hash_original_field = "0CB100AF67BD2EB1F0E2A464C0F12B08", hash_generated_field = "C945ED2D87187C29A8B309C59A8903B9")

    private static int uid = 0;
}

