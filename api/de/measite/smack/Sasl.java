/*
 * Copyright 2009 Rene Treffer
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package de.measite.smack;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map;

import org.apache.harmony.javax.security.auth.callback.CallbackHandler;
import org.apache.harmony.javax.security.sasl.SaslClient;
import org.apache.harmony.javax.security.sasl.SaslException;
import org.apache.harmony.javax.security.sasl.SaslServer;
import org.apache.harmony.javax.security.sasl.SaslServerFactory;

public class Sasl {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:36.315 -0400", hash_original_field = "25F3E4C697E8842352262D3C2DEE3476", hash_generated_field = "CF5A4D97FD160589D03B4973A539755B")

    private static final String CLIENTFACTORYSRV = "SaslClientFactory";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:36.316 -0400", hash_original_field = "876D20EF1455BEC74A99743FB11C2DAC", hash_generated_field = "6E6722B39359C13682824D8B96045BDB")


    // SaslServerFactory service name
    private static final String SERVERFACTORYSRV = "SaslServerFactory";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:36.316 -0400", hash_original_field = "63E291D8077F42F3C54DC84FCF604278", hash_generated_field = "8B9A9BAEEE75B7314CA0AC674C087732")


    public static final String POLICY_NOPLAINTEXT = "javax.security.sasl.policy.noplaintext";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:36.316 -0400", hash_original_field = "4CE360E0BC29510C0E9CCBEE644552F8", hash_generated_field = "68A9369B35A350A84299B3ACFA0E70A2")


    public static final String POLICY_NOACTIVE = "javax.security.sasl.policy.noactive";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:36.317 -0400", hash_original_field = "190D35DF7BD0BAD48D9A24B4D3CAC29B", hash_generated_field = "2840BDD4CF75DF812B0D2CCA192C8B4C")


    public static final String POLICY_NODICTIONARY = "javax.security.sasl.policy.nodictionary";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:36.317 -0400", hash_original_field = "8296CD85622774271342FC15CA78577F", hash_generated_field = "715CFCBAA40D1BDEF13756C05BC3138F")


    public static final String POLICY_NOANONYMOUS = "javax.security.sasl.policy.noanonymous";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:36.318 -0400", hash_original_field = "D87DCB269DB398523C236A334DB75118", hash_generated_field = "799311FCB8E662E0BB5753295DD0BE69")


    public static final String POLICY_FORWARD_SECRECY = "javax.security.sasl.policy.forward";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:36.318 -0400", hash_original_field = "7D4DD99AC2EA9D01412482E564CFFF4C", hash_generated_field = "615931B89ABFE7379A04B0317FA1E547")


    public static final String POLICY_PASS_CREDENTIALS = "javax.security.sasl.policy.credentials";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:36.318 -0400", hash_original_field = "848FF897FB69DC1940B6498E39E50175", hash_generated_field = "394F3E07D103D2FF772AE015E3B01642")


    public static final String MAX_BUFFER = "javax.security.sasl.maxbuffer";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:36.319 -0400", hash_original_field = "764E78A1D7A70F45861A1171F17DAF17", hash_generated_field = "FBB3926C16B2C5DE9E5511432E018CC8")


    public static final String RAW_SEND_SIZE = "javax.security.sasl.rawsendsize";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:36.319 -0400", hash_original_field = "68B358104FF94CEAEFC625CBD275D266", hash_generated_field = "BFD50980780CE47E6450323491B204E7")


    public static final String REUSE = "javax.security.sasl.reuse";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:36.320 -0400", hash_original_field = "488FF1E9ED26737F7A55AF094F7612F8", hash_generated_field = "A408F77660708637522D4B698AC7DCC2")


    public static final String QOP = "javax.security.sasl.qop";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:36.320 -0400", hash_original_field = "E9AE37BEBD86F66835F4A78079188644", hash_generated_field = "6260CE989D647DEC1E4FF731A9D33D26")


    public static final String STRENGTH = "javax.security.sasl.strength";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:36.320 -0400", hash_original_field = "A9DD395876782CD74D8F2941ED675833", hash_generated_field = "0843BB158D490DEAFD93D5AAC41C795C")


    public static final String SERVER_AUTH = "javax.security.sasl.server.authentication"; //$NON-NLS-1$

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:36.321 -0400", hash_original_method = "FB583A9D0E8C520320442E1FACE0FC54", hash_generated_method = "BD4BCA12ABB745754951F72FD045CF30")
    
public static Enumeration<SaslClientFactory> getSaslClientFactories() {
        Hashtable<SaslClientFactory,Object> factories = new Hashtable<SaslClientFactory,Object>();
        factories.put(new SaslClientFactory(), new Object());
        return factories.keys();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:36.321 -0400", hash_original_method = "ADC77BD0F09B8B5B35B82AC31D9D3051", hash_generated_method = "7737173AD2F24AF72EB833A5A27F5B12")
    
public static Enumeration<SaslServerFactory> getSaslServerFactories() {
        return org.apache.harmony.javax.security.sasl.Sasl.getSaslServerFactories();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:36.322 -0400", hash_original_method = "49759CC05D6DEBB1940428F14328A4A2", hash_generated_method = "32014EE75C264D8EB1D751BD82742399")
    
public static SaslServer createSaslServer(String mechanism, String protocol,
            String serverName, Map<String, ?> prop, CallbackHandler cbh) throws SaslException {
        return org.apache.harmony.javax.security.sasl.Sasl.createSaslServer(mechanism, protocol, serverName, prop, cbh);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:36.322 -0400", hash_original_method = "4D44B613E25388E12515C0046DA2E9AF", hash_generated_method = "9398A140066A844822EFAB2DE9A182A5")
    
public static SaslClient createSaslClient(String[] mechanisms, String authanticationID,
            String protocol, String serverName, Map<String, ?> prop, CallbackHandler cbh)
            throws SaslException {
        if (mechanisms == null) {
            throw new NullPointerException("auth.33"); //$NON-NLS-1$
        }
        SaslClientFactory fact = getSaslClientFactories().nextElement();
        String[] mech = fact.getMechanismNames(null);
        boolean is = false;
        if (mech != null) {
            for (int j = 0; j < mech.length; j++) {
                for (int n = 0; n < mechanisms.length; n++) {
                    if (mech[j].equals(mechanisms[n])) {
                        is = true;
                        break;
                    }
                }
            }
        }
        if (is) {
            return fact.createSaslClient(
                mechanisms,
                authanticationID,
                protocol,
                serverName,
                prop,
                cbh
            );
        }
        return null;
    }

}
