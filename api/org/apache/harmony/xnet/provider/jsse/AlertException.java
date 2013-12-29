package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import javax.net.ssl.SSLException;






public class AlertException extends RuntimeException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:14.149 -0500", hash_original_field = "93BAD4977ECA98BFF8CF4CFAAEAFE6D7", hash_generated_field = "49414C5F100260BFB79C458FA4822DE5")


    private static final long serialVersionUID = -4448327177165687581L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:14.149 -0500", hash_original_field = "6E497387AC14EA196BB0BE1BDE11805E", hash_generated_field = "C530EE3CBD485644D7525A400EA925B6")

    private  SSLException reason;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:14.150 -0500", hash_original_field = "74F280F6E7E26FDCFDB578AAFF84DF3E", hash_generated_field = "970155BA799F3943C9383598DE4C30A5")

    private  byte description;

    /**
     * Constructs the instance.
     *
     * @param description The alert description code from {@link AlertProtocol}
     * @param reason The SSLException to be thrown to application side after alert processing
     *            (sending the record with alert, shutdown work, etc).
     * @see AlertProtocol
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:14.151 -0500", hash_original_method = "76164594E21D6CE99D1A0A90A760CF7A", hash_generated_method = "25B1C1BA84DF5BEBAF46122E1A31B670")
    protected AlertException(byte description, SSLException reason) {
        super(reason);
        this.reason = reason;
        this.description = description;
    }

    /**
     * Returns the reason of alert. This reason should be rethrown after alert processing.
     *
     * @return the reason of alert.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:14.152 -0500", hash_original_method = "5B702ECC4BAE0D4CD4DED59A097CDBFC", hash_generated_method = "30CB20ECF89290BA04D7334DD1E64E5F")
    protected SSLException getReason() {
        return reason;
    }

    /**
     * Returns alert's description code.
     *
     * @return alert description code from {@link AlertProtocol}
     * @see AlertProtocol for more information about possible reason codes.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:14.153 -0500", hash_original_method = "4016638ED8025AA5C043B11675AF3321", hash_generated_method = "406210F086F3DA6DDF270588E443BAA5")
    protected byte getDescriptionCode() {
        return description;
    }
}

