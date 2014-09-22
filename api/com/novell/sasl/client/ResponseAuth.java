/* **************************************************************************
 * $OpenLDAP: /com/novell/sasl/client/ResponseAuth.java,v 1.3 2005/01/17 15:00:54 sunilk Exp $
 *
 * Copyright (C) 2002 Novell, Inc. All Rights Reserved.
 *
 * THIS WORK IS SUBJECT TO U.S. AND INTERNATIONAL COPYRIGHT LAWS AND
 * TREATIES. USE, MODIFICATION, AND REDISTRIBUTION OF THIS WORK IS SUBJECT
 * TO VERSION 2.0.1 OF THE OPENLDAP PUBLIC LICENSE, A COPY OF WHICH IS
 * AVAILABLE AT HTTP://WWW.OPENLDAP.ORG/LICENSE.HTML OR IN THE FILE "LICENSE"
 * IN THE TOP-LEVEL DIRECTORY OF THE DISTRIBUTION. ANY USE OR EXPLOITATION
 * OF THIS WORK OTHER THAN AS AUTHORIZED IN VERSION 2.0.1 OF THE OPENLDAP
 * PUBLIC LICENSE, OR OTHER PRIOR WRITTEN CONSENT FROM NOVELL, COULD SUBJECT
 * THE PERPETRATOR TO CRIMINAL AND CIVIL LIABILITY.
 ******************************************************************************/
package com.novell.sasl.client;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.util.*;
import org.apache.harmony.javax.security.sasl.*;

/**
 * Implements the ResponseAuth class used by the DigestMD5SaslClient mechanism
 */
class ResponseAuth
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.340 -0400", hash_original_field = "06BEA5F57DE6851C6A036F694EB873B2", hash_generated_field = "6F0960AD0BDE2A7ECE88331D4F26E453")


    private String m_responseValue;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.340 -0400", hash_original_method = "A1D4534FE04FD59F74A70E0B30A71339", hash_generated_method = "A1D4534FE04FD59F74A70E0B30A71339")
    
ResponseAuth(
        byte[] responseAuth)
            throws SaslException
    {
        m_responseValue = null;

        DirectiveList dirList = new DirectiveList(responseAuth);
        try
        {
            dirList.parseDirectives();
            checkSemantics(dirList);
        }
        catch (SaslException e)
        {
        }
    }

    /**
     * Checks the semantics of the directives in the directive list as parsed
     * from the digest challenge byte array.
     *
     * @param dirList  the list of directives parsed from the digest challenge
     *
     * @exception SaslException   If a semantic error occurs
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.341 -0400", hash_original_method = "EE3ED6E7CE5EB56E215F2968B06CF264", hash_generated_method = "393B09FC912AE59D5045B216F4009ACF")
    
void checkSemantics(
        DirectiveList dirList) throws SaslException
    {
        Iterator        directives = dirList.getIterator();
        ParsedDirective directive;
        String          name;

        while (directives.hasNext())
        {
            directive = (ParsedDirective)directives.next();
            name = directive.getName();
            if (name.equals("rspauth"))
                m_responseValue = directive.getValue();
        }

        /* post semantic check */
        if (m_responseValue == null)
            throw new SaslException("Missing response-auth directive.");
    }

    /**
     * returns the ResponseValue
     *
     * @return the ResponseValue as a String.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:02:38.341 -0400", hash_original_method = "F2713963B707EC23E2E74602FB00812D", hash_generated_method = "682C74E3E8C4C2E85C9D766F4F6AAAB2")
    
public String getResponseValue()
    {
        return m_responseValue;
    }
}

