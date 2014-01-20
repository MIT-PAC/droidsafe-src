package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.core.Debug;
import gov.nist.core.InternalErrorHandler;
import gov.nist.javax.sip.header.ContentLength;
import gov.nist.javax.sip.message.SIPMessage;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;

public final class PipelinedMsgParser implements Runnable {

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.961 -0500", hash_original_method = "DAF76D5DD85CC446D92B47A110AC634C", hash_generated_method = "DE313A56D6E4C9D480B32495037BE062")
    
private static synchronized int getNewUid() {
        return uid++;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.958 -0500", hash_original_field = "8E7F39D78C11D0D620F5769854F95AD4", hash_generated_field = "C945ED2D87187C29A8B309C59A8903B9")

    private static int uid = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.943 -0500", hash_original_field = "3A28FCAF17F65963C61393B050C3AEEC", hash_generated_field = "E951DA693006702904D44903EC071300")

    protected SIPMessageListener sipMessageListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.946 -0500", hash_original_field = "4AB983356694FB1E44D4AE16E3897B0E", hash_generated_field = "8890F3B68DD2F65EEDEBEEF6284B3EE1")

    private Thread mythread;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.948 -0500", hash_original_field = "68012D41A36981DBB1951911F9086543", hash_generated_field = "199D445F1CDE522CAD696E07DB2A1BAF")

    //private byte[] messageBody;
    //private boolean errorFlag;
    private Pipeline rawInputStream;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.950 -0500", hash_original_field = "22F0990BFBB825F63302151EEE1DEF9C", hash_generated_field = "6056A74FE8111EC12B2D46373C91E6E1")

    private int maxMessageSize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.953 -0500", hash_original_field = "BFD1B2A66F160593F8C728C2037366DD", hash_generated_field = "87B02180527F6273015739A99F276EBD")

    private int sizeCounter;
    //private int messageSize;

    /**
     * default constructor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.955 -0500", hash_original_method = "E22CE959BAB24F19C875E84872180E07", hash_generated_method = "2C194672D47C6EEA080B4FF20D4E0703")
    
protected PipelinedMsgParser() {
        super();

    }

    /**
     * Constructor when we are given a message listener and an input stream
     * (could be a TCP connection or a file)
     *
     * @param sipMessageListener
     *            Message listener which has methods that get called back from
     *            the parser when a parse is complete
     * @param in
     *            Input stream from which to read the input.
     * @param debug
     *            Enable/disable tracing or lexical analyser switch.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.964 -0500", hash_original_method = "A3AB807F1456A67D8271D731B6987080", hash_generated_method = "2CBEC2E4691FB150D025B1CDBA904F96")
    
public PipelinedMsgParser(SIPMessageListener sipMessageListener,
            Pipeline in, boolean debug, int maxMessageSize) {
        this();
        this.sipMessageListener = sipMessageListener;
        rawInputStream = in;
        this.maxMessageSize = maxMessageSize;
        mythread = new Thread(this);
        mythread.setName("PipelineThread-" + getNewUid());

    }

    /**
     * This is the constructor for the pipelined parser.
     *
     * @param mhandler
     *            a SIPMessageListener implementation that provides the message
     *            handlers to handle correctly and incorrectly parsed messages.
     * @param in
     *            An input stream to read messages from.
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.967 -0500", hash_original_method = "BDF51C7E7DDD69BD9B7D7DBBB57B9FF1", hash_generated_method = "3F2F3DD7A2E94C0596679AA217B1473A")
    
public PipelinedMsgParser(SIPMessageListener mhandler, Pipeline in,
            int maxMsgSize) {
        this(mhandler, in, false, maxMsgSize);
    }

    /**
     * This is the constructor for the pipelined parser.
     *
     * @param in -
     *            An input stream to read messages from.
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.970 -0500", hash_original_method = "748DD8A3EFE43FF431548555AB3BE25D", hash_generated_method = "257831BBD49AA3A14DAA67BEFACD49BE")
    
public PipelinedMsgParser(Pipeline in) {
        this(null, in, false, 0);
    }

    /**
     * Start reading and processing input.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.972 -0500", hash_original_method = "AFB6FAED7CE2C798D2C88DCB60C1E3BA", hash_generated_method = "5052780A51C172A7104F8230B21D9B2E")
    
public void processInput() {
        mythread.start();
    }

    /**
     * Create a new pipelined parser from an existing one.
     *
     * @return A new pipelined parser that reads from the same input stream.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.975 -0500", hash_original_method = "7B58421AA7682D1CD65CE1288FB2F0E9", hash_generated_method = "F568C8989067E18EBDA66C388D30FDAD")
    
protected Object clone() {
        PipelinedMsgParser p = new PipelinedMsgParser();

        p.rawInputStream = this.rawInputStream;
        p.sipMessageListener = this.sipMessageListener;
        Thread mythread = new Thread(p);
        mythread.setName("PipelineThread");
        return p;
    }

    /**
     * Add a class that implements a SIPMessageListener interface whose methods
     * get called * on successful parse and error conditons.
     *
     * @param mlistener
     *            a SIPMessageListener implementation that can react to correct
     *            and incorrect pars.
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.977 -0500", hash_original_method = "AE1DFBE29C50512ACC863FBFFDC539ED", hash_generated_method = "DEDA56DC267C61F1D03CF1A43E7B6209")
    
public void setMessageListener(SIPMessageListener mlistener) {
        sipMessageListener = mlistener;
    }

    /**
     * read a line of input (I cannot use buffered reader because we may need to
     * switch encodings mid-stream!
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.980 -0500", hash_original_method = "CA26412E58B11F2830D7673D2CC5E1EF", hash_generated_method = "C900F8ACEA0D0AB63148521651B7CD91")
    
private String readLine(InputStream inputStream) throws IOException {
        StringBuffer retval = new StringBuffer("");
        while (true) {
            char ch;
            int i = inputStream.read();
            if (i == -1) {
                throw new IOException("End of stream");
            } else
                ch = (char) i;
            // reduce the available read size by 1 ("size" of a char).
            if (this.maxMessageSize > 0) {
                this.sizeCounter--;
                if (this.sizeCounter <= 0)
                    throw new IOException("Max size exceeded!");
            }
            if (ch != '\r')
                retval.append(ch);
            if (ch == '\n') {
                break;
            }
        }
        return retval.toString();
    }

    /**
     * This is input reading thread for the pipelined parser. You feed it input
     * through the input stream (see the constructor) and it calls back an event
     * listener interface for message processing or error. It cleans up the
     * input - dealing with things like line continuation
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.984 -0500", hash_original_method = "4591706E6DAAE4ED54EAE930623099BB", hash_generated_method = "5B31420BBBF7F0CEACC295D11F5F68A9")
    
public void run() {

        Pipeline inputStream = this.rawInputStream;
        // inputStream = new MyFilterInputStream(this.rawInputStream);
        // I cannot use buffered reader here because we may need to switch
        // encodings to read the message body.
        try {
            while (true) {
                this.sizeCounter = this.maxMessageSize;
                // this.messageSize = 0;
                StringBuffer inputBuffer = new StringBuffer();

                if (Debug.parserDebug)
                    Debug.println("Starting parse!");

                String line1;
                String line2 = null;

                while (true) {
                    try {
                        line1 = readLine(inputStream);
                        // ignore blank lines.
                        if (line1.equals("\n")) {
                            if (Debug.parserDebug) {
                                Debug.println("Discarding blank line. ");
                            }
                            continue;
                        } else
                            break;
                    } catch (IOException ex) {
                        Debug.printStackTrace(ex);
                        this.rawInputStream.stopTimer();
                        return;

                    }
                }

                inputBuffer.append(line1);
                // Guard against bad guys.
                this.rawInputStream.startTimer();

                Debug.println("Reading Input Stream");
                while (true) {
                    try {
                        line2 = readLine(inputStream);
                        inputBuffer.append(line2);
                        if (line2.trim().equals(""))
                            break;
                    } catch (IOException ex) {
                        this.rawInputStream.stopTimer();
                        Debug.printStackTrace(ex);
                        return;

                    }
                }

                // Stop the timer that will kill the read.
                this.rawInputStream.stopTimer();
                inputBuffer.append(line2);
                StringMsgParser smp = new StringMsgParser(sipMessageListener);
                smp.readBody = false;
                SIPMessage sipMessage = null;

                try {
                    if (Debug.debug) {
                        Debug.println("About to parse : " + inputBuffer.toString());
                    }
                    sipMessage = smp.parseSIPMessage(inputBuffer.toString());
                    if (sipMessage == null) {
                        this.rawInputStream.stopTimer();
                        continue;
                    }
                } catch (ParseException ex) {
                    // Just ignore the parse exception.
                    Debug.logError("Detected a parse error", ex);
                    continue;
                }

                if (Debug.debug) {
                    Debug.println("Completed parsing message");
                }
                ContentLength cl = (ContentLength) sipMessage
                        .getContentLength();
                int contentLength = 0;
                if (cl != null) {
                    contentLength = cl.getContentLength();
                } else {
                    contentLength = 0;
                }

                if (Debug.debug) {
                    Debug.println("contentLength " + contentLength);
                }

                if (contentLength == 0) {
                    sipMessage.removeContent();
                } else if (maxMessageSize == 0
                        || contentLength < this.sizeCounter) {
                    byte[] message_body = new byte[contentLength];
                    int nread = 0;
                    while (nread < contentLength) {
                        // Start my starvation timer.
                        // This ensures that the other end
                        // writes at least some data in
                        // or we will close the pipe from
                        // him. This prevents DOS attack
                        // that takes up all our connections.
                        this.rawInputStream.startTimer();
                        try {

                            int readlength = inputStream.read(message_body,
                                    nread, contentLength - nread);
                            if (readlength > 0) {
                                nread += readlength;
                            } else {
                                break;
                            }
                        } catch (IOException ex) {
                            Debug.logError("Exception Reading Content",ex);
                            break;
                        } finally {
                            // Stop my starvation timer.
                            this.rawInputStream.stopTimer();
                        }
                    }
                    sipMessage.setMessageContent(message_body);
                }
                // Content length too large - process the message and
                // return error from there.
                if (sipMessageListener != null) {
                    try {
                        sipMessageListener.processMessage(sipMessage);
                    } catch (Exception ex) {
                        // fatal error in processing - close the
                        // connection.
                        break;
                    }
                }
            }
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                InternalErrorHandler.handleException(e);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:46.987 -0500", hash_original_method = "CD7CB4D97896F4DDC9750ED4F3C04317", hash_generated_method = "C2E57EB99EF1FD69BC47C1D38FD5733F")
    
public void close() {
        try {
            this.rawInputStream.close();
        } catch (IOException ex) {
            // Ignore.
        }
    }
}

