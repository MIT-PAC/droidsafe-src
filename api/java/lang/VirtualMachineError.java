package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;





public abstract class VirtualMachineError extends Error {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:22.298 -0500", hash_original_field = "CA226E7B36C8CC2F5E87D0DBCC6508E5", hash_generated_field = "37C73C9EC87FE5E20B65E378CAE59D15")


    private static final long serialVersionUID = 4161983926571568670L;

    /**
     * Constructs a new {@code VirtualMachineError} that includes the current
     * stack trace.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:22.299 -0500", hash_original_method = "0F69B8238323DB052C2C0DA7A3D55736", hash_generated_method = "AC68FC3493D4CF6ED61B6320912C03C9")
    public VirtualMachineError() {
    }

    /**
     * Constructs a new {@code VirtualMachineError} with the current stack trace
     * and the specified detail message.
     *
     * @param detailMessage
     *            the detail message for this exception.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:22.301 -0500", hash_original_method = "93E73561FDCA8CBD84645ED54333765D", hash_generated_method = "761DD29964FA2489C0602A5C8451A558")
    public VirtualMachineError(String detailMessage) {
        super(detailMessage);
    }
}

