package com.android.internal.telephony.sip;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.android.internal.telephony.Call;
import com.android.internal.telephony.Connection;






abstract class SipCallBase extends Call {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.331 -0500", hash_original_field = "CF6A431F779622AF0115FA7C1EE3B9D1", hash_generated_field = "8202D840EE6CEF3CCCA47896EED71E34")

    protected List<Connection> connections = new ArrayList<Connection>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.071 -0400", hash_original_method = "0EF508E50423F81ECC9230D92981C1BD", hash_generated_method = "0EF508E50423F81ECC9230D92981C1BD")
    public SipCallBase ()
    {
        //Synthesized constructor
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.333 -0500", hash_original_method = "77598EDB7A4C0294DEE395EE32533812", hash_generated_method = "9E4D06176A8C81C8EE2C1DA904E8E091")
    
protected abstract void setState(State newState);

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.336 -0500", hash_original_method = "DA46D72C53A8C0722B0E4038E55B8A9F", hash_generated_method = "B2D46C83F0D5D8DC52CF45AA8A64DAEC")
    
public List<Connection> getConnections() {
        // FIXME should return Collections.unmodifiableList();
        return connections;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.338 -0500", hash_original_method = "E944BDEAA6C46A001782606E74F9EFB0", hash_generated_method = "2CA3BDACC129D60EAE4D95F06A3D2F50")
    
public boolean isMultiparty() {
        return connections.size() > 1;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.341 -0500", hash_original_method = "7D1F122E9D021AC073DB09CCD6084B65", hash_generated_method = "AE254132F7C591FD635DC3E850C99BF3")
    
public String toString() {
        return state.toString() + ":" + super.toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.343 -0500", hash_original_method = "2179B35862415320201802CDBF1F003D", hash_generated_method = "2179B35862415320201802CDBF1F003D")
    
void clearDisconnected() {
        for (Iterator<Connection> it = connections.iterator(); it.hasNext(); ) {
            Connection c = it.next();
            if (c.getState() == State.DISCONNECTED) it.remove();
        }

        if (connections.isEmpty()) setState(State.IDLE);
    }

    
}

