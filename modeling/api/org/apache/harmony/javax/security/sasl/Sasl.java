/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.apache.harmony.javax.security.sasl;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.security.Provider;
import java.security.Security;
import org.apache.harmony.javax.security.auth.callback.CallbackHandler;

import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Map;
import java.util.HashSet;
import java.util.Iterator;

public class Sasl {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.666 -0400", hash_original_field = "25F3E4C697E8842352262D3C2DEE3476", hash_generated_field = "CF5A4D97FD160589D03B4973A539755B")

    private static final String CLIENTFACTORYSRV = "SaslClientFactory";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.667 -0400", hash_original_field = "876D20EF1455BEC74A99743FB11C2DAC", hash_generated_field = "6E6722B39359C13682824D8B96045BDB")

    // SaslServerFactory service name
    private static final String SERVERFACTORYSRV = "SaslServerFactory";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.667 -0400", hash_original_field = "63E291D8077F42F3C54DC84FCF604278", hash_generated_field = "8B9A9BAEEE75B7314CA0AC674C087732")

    public static final String POLICY_NOPLAINTEXT = "javax.security.sasl.policy.noplaintext";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.668 -0400", hash_original_field = "4CE360E0BC29510C0E9CCBEE644552F8", hash_generated_field = "68A9369B35A350A84299B3ACFA0E70A2")

    public static final String POLICY_NOACTIVE = "javax.security.sasl.policy.noactive";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.668 -0400", hash_original_field = "190D35DF7BD0BAD48D9A24B4D3CAC29B", hash_generated_field = "2840BDD4CF75DF812B0D2CCA192C8B4C")

    public static final String POLICY_NODICTIONARY = "javax.security.sasl.policy.nodictionary";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.669 -0400", hash_original_field = "8296CD85622774271342FC15CA78577F", hash_generated_field = "715CFCBAA40D1BDEF13756C05BC3138F")

    public static final String POLICY_NOANONYMOUS = "javax.security.sasl.policy.noanonymous";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.670 -0400", hash_original_field = "D87DCB269DB398523C236A334DB75118", hash_generated_field = "799311FCB8E662E0BB5753295DD0BE69")

    public static final String POLICY_FORWARD_SECRECY = "javax.security.sasl.policy.forward";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.670 -0400", hash_original_field = "7D4DD99AC2EA9D01412482E564CFFF4C", hash_generated_field = "615931B89ABFE7379A04B0317FA1E547")

    public static final String POLICY_PASS_CREDENTIALS = "javax.security.sasl.policy.credentials";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.671 -0400", hash_original_field = "848FF897FB69DC1940B6498E39E50175", hash_generated_field = "394F3E07D103D2FF772AE015E3B01642")

    public static final String MAX_BUFFER = "javax.security.sasl.maxbuffer";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.672 -0400", hash_original_field = "764E78A1D7A70F45861A1171F17DAF17", hash_generated_field = "FBB3926C16B2C5DE9E5511432E018CC8")

    public static final String RAW_SEND_SIZE = "javax.security.sasl.rawsendsize";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.672 -0400", hash_original_field = "68B358104FF94CEAEFC625CBD275D266", hash_generated_field = "BFD50980780CE47E6450323491B204E7")

    public static final String REUSE = "javax.security.sasl.reuse";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.673 -0400", hash_original_field = "488FF1E9ED26737F7A55AF094F7612F8", hash_generated_field = "A408F77660708637522D4B698AC7DCC2")

    public static final String QOP = "javax.security.sasl.qop";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.673 -0400", hash_original_field = "E9AE37BEBD86F66835F4A78079188644", hash_generated_field = "6260CE989D647DEC1E4FF731A9D33D26")

    public static final String STRENGTH = "javax.security.sasl.strength";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.674 -0400", hash_original_field = "A9DD395876782CD74D8F2941ED675833", hash_generated_field = "0843BB158D490DEAFD93D5AAC41C795C")

    public static final String SERVER_AUTH = "javax.security.sasl.server.authentication";

    // Forms new instance of factory
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.675 -0400", hash_original_method = "A22E26D7D508455A024AA2A1D979B72B", hash_generated_method = "95A1D0DF36A51AD50595EF2DE46F3F97")
    
private static Object newInstance(String factoryName, Provider prv) throws SaslException {
        String msg = "auth.31"; //$NON-NLS-1$
        Object factory;
        ClassLoader cl = prv.getClass().getClassLoader();
        if (cl == null) {
            cl = ClassLoader.getSystemClassLoader();
        }
        try {
            factory = (Class.forName(factoryName, true, cl)).newInstance();
            return factory;
        } catch (IllegalAccessException e) {
            throw new SaslException(msg + factoryName, e);
        } catch (ClassNotFoundException e) {
            throw new SaslException(msg + factoryName, e);
        } catch (InstantiationException e) {
            throw new SaslException(msg + factoryName, e);
        }
    }

    /**
     * This method forms the list of SaslClient/SaslServer factories which are
     * implemented in used providers
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.676 -0400", hash_original_method = "F390E337D6352367BF020E091E2B438B", hash_generated_method = "8E32C8D41118D9235A7CC44D6951ACEF")
    
private static Collection<?> findFactories(String service) {
        HashSet<Object> fact = new HashSet<Object>();
        Provider[] pp = Security.getProviders();
        if ((pp == null) || (pp.length == 0)) {
            return fact;
        }
        HashSet<String> props = new HashSet<String>();
        for (int i = 0; i < pp.length; i++) {
            String prName = pp[i].getName();
            Enumeration<Object> keys = pp[i].keys();
            while (keys.hasMoreElements()) {
                String s = (String) keys.nextElement();
                if (s.startsWith(service)) {
                    String prop = pp[i].getProperty(s);
                    try {
                        if (props.add(prName.concat(prop))) {
                            fact.add(newInstance(prop, pp[i]));
                        }
                    } catch (SaslException e) {
                        // ignore this factory
                        e.printStackTrace();
                    }
                }
            }
        }
        return fact;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.677 -0400", hash_original_method = "E38312B5D0C9D222C8B18194E31CAE93", hash_generated_method = "8DBA4672253C1ABC6C6AFB3B8EB54D48")
    
@SuppressWarnings("unchecked")
    public static Enumeration<SaslClientFactory> getSaslClientFactories() {
        Collection<SaslClientFactory> res = (Collection<SaslClientFactory>) findFactories(CLIENTFACTORYSRV);
        return Collections.enumeration(res);

    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.678 -0400", hash_original_method = "2ABEE3248274931C12A5E79833E2E025", hash_generated_method = "23FCE9F5380F579813D3F8671B43C745")
    
@SuppressWarnings("unchecked")
    public static Enumeration<SaslServerFactory> getSaslServerFactories() {
        Collection<SaslServerFactory> res = (Collection<SaslServerFactory>) findFactories(SERVERFACTORYSRV);
        return Collections.enumeration(res);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.679 -0400", hash_original_method = "34B4957EEAD9E52BF4CDC65B23B73862", hash_generated_method = "473CF3CB8403D188A3006EC789D13082")
    
public static SaslServer createSaslServer(String mechanism, String protocol,
            String serverName, Map<String, ?> prop, CallbackHandler cbh) throws SaslException {
        if (mechanism == null) {
            throw new NullPointerException("auth.32"); //$NON-NLS-1$
        }
        Collection<?> res = findFactories(SERVERFACTORYSRV);
        if (res.isEmpty()) {
            return null;
        }

        Iterator<?> iter = res.iterator();
        while (iter.hasNext()) {
            SaslServerFactory fact = (SaslServerFactory) iter.next();
            String[] mech = fact.getMechanismNames(null);
            boolean is = false;
            if (mech != null) {
                for (int j = 0; j < mech.length; j++) {
                    if (mech[j].equals(mechanism)) {
                        is = true;
                        break;
                    }
                }
            }
            if (is) {
                SaslServer saslS = fact.createSaslServer(mechanism, protocol, serverName, prop,
                        cbh);
                if (saslS != null) {
                    return saslS;
                }
            }
        }
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.680 -0400", hash_original_method = "972A454F756B9E192A45D33AB1ED692F", hash_generated_method = "15D280CFEA4A2289EA03D017061C922F")
    
public static SaslClient createSaslClient(String[] mechanisms, String authanticationID,
            String protocol, String serverName, Map<String, ?> prop, CallbackHandler cbh)
            throws SaslException {
        if (mechanisms == null) {
            throw new NullPointerException("auth.33"); //$NON-NLS-1$
        }
        Collection<?> res = findFactories(CLIENTFACTORYSRV);
        if (res.isEmpty()) {
            return null;
        }

        Iterator<?> iter = res.iterator();
        while (iter.hasNext()) {
            SaslClientFactory fact = (SaslClientFactory) iter.next();
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
                SaslClient saslC = fact.createSaslClient(mechanisms, authanticationID,
                        protocol, serverName, prop, cbh);
                if (saslC != null) {
                    return saslC;
                }
            }
        }
        return null;
    } //$NON-NLS-1$

    // Default public constructor is overridden
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.674 -0400", hash_original_method = "596EDD6EF52364FF8F1CF0CF3A3CAC32", hash_generated_method = "1CC55109D30BDA94E876E57DB6A3FBDF")
    
private Sasl() {
        super();
    }
}
