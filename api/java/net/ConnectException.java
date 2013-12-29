package java.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;



public class ConnectException extends SocketException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:05.611 -0500", hash_original_field = "0873C361B01E00CE7D79D8A550E89E66", hash_generated_field = "CAE820EF0FC06E92C927106699F8E8B2")


    private static final long serialVersionUID = 3831404271622369215L;

    /**
     * Constructs a new instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:05.612 -0500", hash_original_method = "E8FAEAA07CFA8C05C275809EB6A40178", hash_generated_method = "BB9F8D3297DCBD21031F1186CD0A4450")
    public ConnectException() {
    }

    /**
     * Constructs a new instance with the given detail message.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:05.613 -0500", hash_original_method = "49125F9CA125EC7F4D4C7EADF3FA5E9C", hash_generated_method = "E8492FD71B26032754743479D11BC783")
    public ConnectException(String detailMessage) {
        super(detailMessage);
    }

    /**
     * Constructs a new instance with the given detail message and cause.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:05.614 -0500", hash_original_method = "4C12D3BC3A1875DEC95F9E2E6B90AD5C", hash_generated_method = "E4ED9CBDDFFECC7DA411A3A817D8F161")
    public ConnectException(String detailMessage, Throwable cause) {
        super(detailMessage, cause);
    }
}

