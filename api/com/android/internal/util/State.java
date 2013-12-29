package com.android.internal.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Message;




public class State implements IState {

    /**
     * Constructor
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:40.863 -0500", hash_original_method = "1314C653F2455ACB4C7CC9637DF86BCF", hash_generated_method = "515F83F87C0E6701C630976BB07638BA")
    protected State() {
    }

    /* (non-Javadoc)
     * @see com.android.internal.util.IState#enter()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:40.864 -0500", hash_original_method = "D62227FCEF84BCF6A743C917250E2211", hash_generated_method = "EBF94F83F3244F29E0EE41377142146D")
    @Override
public void enter() {
    }

    /* (non-Javadoc)
     * @see com.android.internal.util.IState#exit()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:40.865 -0500", hash_original_method = "2C3CB485438CBA20E6D214DF13F075C8", hash_generated_method = "B65B82CF13D4CEAB9A73D949D4541202")
    @Override
public void exit() {
    }

    /* (non-Javadoc)
     * @see com.android.internal.util.IState#processMessage(android.os.Message)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:40.866 -0500", hash_original_method = "19EA475E2A58E089BFF1524EDD692DAE", hash_generated_method = "0B2C9F3D417EBC98B3B6D3CB5B3C9C1E")
    @Override
public boolean processMessage(Message msg) {
        return false;
    }

    /**
     * Name of State for debugging purposes.
     *
     * This default implementation returns the class name, returning
     * the instance name would better in cases where a State class
     * is used for multiple states. But normally there is one class per
     * state and the class name is sufficient and easy to get. You may
     * want to provide a setName or some other mechanism for setting
     * another name if the class name is not appropriate.
     *
     * @see com.android.internal.util.IState#processMessage(android.os.Message)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:40.867 -0500", hash_original_method = "F20278175B30FDA9C7EB84130BA3C8FE", hash_generated_method = "98BD1CF5439F96260CFE47E80D38DB06")
    @Override
public String getName() {
        String name = getClass().getName();
        int lastDollar = name.lastIndexOf('$');
        return name.substring(lastDollar + 1);
    }

    
}

