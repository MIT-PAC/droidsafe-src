package javax.xml.transform;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;


public class TransformerConfigurationException extends TransformerException {

    /**
     * Create a new <code>TransformerConfigurationException</code> with no
     * detail message.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.578 -0500", hash_original_method = "BD9B4D3E21457DCFC8705065705F7747", hash_generated_method = "4D8300DC52435F7C51CE1BCC47D4B828")
    
public TransformerConfigurationException() {
        super("Configuration Error");
    }

    /**
     * Create a new <code>TransformerConfigurationException</code> with
     * the <code>String </code> specified as an error message.
     *
     * @param msg The error message for the exception.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.580 -0500", hash_original_method = "69DD6C44C48D0F6E1DFC35936EC71C54", hash_generated_method = "1DA52A124EF9A0857EAB5EB6F9595CB2")
    
public TransformerConfigurationException(String msg) {
        super(msg);
    }

    /**
     * Create a new <code>TransformerConfigurationException</code> with a
     * given <code>Exception</code> base cause of the error.
     *
     * @param e The exception to be encapsulated in a
     * TransformerConfigurationException.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.583 -0500", hash_original_method = "E488733BAF7BF3463DC8581AFFE97D88", hash_generated_method = "AAD3A6B5BCB22726BABE1F817C39C043")
    
public TransformerConfigurationException(Throwable e) {
        super(e);
    }

    /**
     * Create a new <code>TransformerConfigurationException</code> with the
     * given <code>Exception</code> base cause and detail message.
     *
     * @param e The exception to be encapsulated in a
     *      TransformerConfigurationException
     * @param msg The detail message.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.585 -0500", hash_original_method = "BD51DDC4165DA92B6AA2ED19748DFB52", hash_generated_method = "2478274CC8587AAA739966AD0079D7D8")
    
public TransformerConfigurationException(String msg, Throwable e) {
        super(msg, e);
    }

    /**
     * Create a new TransformerConfigurationException from a message and a Locator.
     *
     * <p>This constructor is especially useful when an application is
     * creating its own exception from within a DocumentHandler
     * callback.</p>
     *
     * @param message The error or warning message.
     * @param locator The locator object for the error or warning.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.588 -0500", hash_original_method = "81D0C9E7195DBF524596695CB4BBF5D5", hash_generated_method = "84A0AEFB0C92E74564BF503C80907662")
    
public TransformerConfigurationException(String message,
                                             SourceLocator locator) {
        super(message, locator);
    }

    /**
     * Wrap an existing exception in a TransformerConfigurationException.
     *
     * @param message The error or warning message, or null to
     *                use the message from the embedded exception.
     * @param locator The locator object for the error or warning.
     * @param e Any exception.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.591 -0500", hash_original_method = "C1BB4F182A4DB12C2F5D6DBB3B298E48", hash_generated_method = "016C7D9E77FD36417D09AB3DDBDC580F")
    
public TransformerConfigurationException(String message,
                                             SourceLocator locator,
                                             Throwable e) {
        super(message, locator, e);
    }

    
}

