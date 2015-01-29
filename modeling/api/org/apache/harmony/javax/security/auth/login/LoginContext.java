/*
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

package org.apache.harmony.javax.security.auth.login;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.IOException;
import java.security.AccessController;
import java.security.AccessControlContext;
import java.security.PrivilegedExceptionAction;
import java.security.PrivilegedActionException;

import java.security.Security;
import java.util.HashMap;
import java.util.Map;

import org.apache.harmony.javax.security.auth.Subject;
import org.apache.harmony.javax.security.auth.callback.CallbackHandler;
import org.apache.harmony.javax.security.auth.callback.Callback;
import org.apache.harmony.javax.security.auth.callback.UnsupportedCallbackException;
import org.apache.harmony.javax.security.auth.spi.LoginModule;
import org.apache.harmony.javax.security.auth.AuthPermission;

import org.apache.harmony.javax.security.auth.login.AppConfigurationEntry.LoginModuleControlFlag;

public class LoginContext {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.564 -0400", hash_original_field = "786C4516A34DD6924235607C72BBFE3D", hash_generated_field = "465F28CD88257C051E6128DC1AD51EB1")

    private static final String DEFAULT_CALLBACK_HANDLER_PROPERTY = "auth.login.defaultCallbackHandler";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.565 -0400", hash_original_field = "B5957D3D1087D15DD4712AC531AA4754", hash_generated_field = "10283C997C1D4E9976DF96451CD94C37")

    /*
     * Integer constants which serve as a replacement for the corresponding
     * LoginModuleControlFlag.* constants. These integers are used later as
     * index in the arrays - see loginImpl() and logoutImpl() methods
     */
    private static final int OPTIONAL = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.565 -0400", hash_original_field = "D9EAFF0F40F3524F487216C929653C6A", hash_generated_field = "6C5B7D4F716BFD782CD0C5C30D70DF3B")

    private static final int REQUIRED = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.566 -0400", hash_original_field = "4D17B7C67AEF647825AF00D6D9320EDD", hash_generated_field = "BDFCB22B3663206FEC10DE32F8360C8C")

    private static final int REQUISITE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.566 -0400", hash_original_field = "E3977FE1387CF15CEE8B617F7A052432", hash_generated_field = "08011BABD5E92F29CC26BCDF1A8B06D9")

    private static final int SUFFICIENT = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.567 -0400", hash_original_field = "30BAA2E2AE0B9CC8117DC874E7246F92", hash_generated_field = "EFE21B59DD4BD4F533148D4E82C7B2AF")

    private Subject subject;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.567 -0400", hash_original_field = "A8A64CB70062C349EED6698EDFB59025", hash_generated_field = "DCDAC970019827D40D4B60FCBE53E069")

    private boolean userProvidedSubject;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.568 -0400", hash_original_field = "5DBE0A684967C8D33B437673070170A1", hash_generated_field = "31E5950AFAC1278EBCB0270EECBC73BD")

    private boolean userProvidedConfig;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.568 -0400", hash_original_field = "E39E4FC555907117B4EDA236E948CD4D", hash_generated_field = "3AD5A1F3778703936FB9AAF7E8AE98AC")

    private AccessControlContext userContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.569 -0400", hash_original_field = "FE40C24C8725B2D4EE000B726D3ACB84", hash_generated_field = "30CF87E450CC91F7899E85CF6B0C3092")

    private CallbackHandler callbackHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.570 -0400", hash_original_field = "E8211C720CAA645292A22AAC2455595F", hash_generated_field = "3C9FC992E0B90C1356D7D64D658C3FE5")

    private Module[] modules;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.570 -0400", hash_original_field = "2D3C8238B50B2A2558C5A5EC4999D0E4", hash_generated_field = "1BEBCB5E13566780AE4097AF519BCE3D")

    private Map<String, ?> sharedState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.571 -0400", hash_original_field = "0A137DE0B6C8729CA24F8F9B18D44243", hash_generated_field = "C41102AB5C0E4C512DB1FC97849C5D3F")

    private ClassLoader contextClassLoader;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.571 -0400", hash_original_field = "81000511724FDD773DCB61DB1DD4033C", hash_generated_field = "B4964227C4B60BA9ADE17FF8234E7957")

    private boolean loggedIn;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.572 -0400", hash_original_method = "D4AED5F0D67BB76FBF68CADBE71D75E5", hash_generated_method = "FA5C74E3EAB828425BCE62A0F02A621F")
    
public LoginContext(String name) throws LoginException {
        super();
        init(name, null, null, null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.572 -0400", hash_original_method = "0262D0A79817FBE5A3B61E58EA2840B6", hash_generated_method = "B0CDFB14ABB8BF706430B9C1E7019CAD")
    
public LoginContext(String name, CallbackHandler cbHandler) throws LoginException {
        super();
        if (cbHandler == null) {
            throw new LoginException("auth.34"); //$NON-NLS-1$
        }
        init(name, null, cbHandler, null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.573 -0400", hash_original_method = "1A937D77CC1C4BD71F12B640C8A7BEB0", hash_generated_method = "5CBD83D43985AEFA132FB59CFC37A0D9")
    
public LoginContext(String name, Subject subject) throws LoginException {
        super();
        if (subject == null) {
            throw new LoginException("auth.03"); //$NON-NLS-1$
        }
        init(name, subject, null, null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.573 -0400", hash_original_method = "048F1648CAAC9D1D7F68E078C7469A32", hash_generated_method = "0BEE6E7783ACA5E2A0747501938FE4E0")
    
public LoginContext(String name, Subject subject, CallbackHandler cbHandler)
            throws LoginException {
        super();
        if (subject == null) {
            throw new LoginException("auth.03"); //$NON-NLS-1$
        }
        if (cbHandler == null) {
            throw new LoginException("auth.34"); //$NON-NLS-1$
        }
        init(name, subject, cbHandler, null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.574 -0400", hash_original_method = "9CFD9F55FBD0332DD5438208EFD68900", hash_generated_method = "809C23BBB1B30B2A7F21E63FD617F197")
    
public LoginContext(String name, Subject subject, CallbackHandler cbHandler,
            Configuration config) throws LoginException {
        super();
        init(name, subject, cbHandler, config);
    }

    // Does all the machinery needed for the initialization.
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.577 -0400", hash_original_method = "9368DF244C2CD5DADDF75C85089AC8BD", hash_generated_method = "1FA093070BF44ED080D5A716990E1315")
    
private void init(String name, Subject subject, final CallbackHandler cbHandler,
            Configuration config) throws LoginException {
        userProvidedSubject = (this.subject = subject) != null;

        //
        // Set config
        //
        if (name == null) {
            throw new LoginException("auth.00"); //$NON-NLS-1$
        }

        if (config == null) {
            config = Configuration.getAccessibleConfiguration();
        } else {
            userProvidedConfig = true;
        }

        SecurityManager sm = System.getSecurityManager();

        if (sm != null && !userProvidedConfig) {
            sm.checkPermission(new AuthPermission("createLoginContext." + name));//$NON-NLS-1$
        }

        AppConfigurationEntry[] entries = config.getAppConfigurationEntry(name);
        if (entries == null) {
            if (sm != null && !userProvidedConfig) {
                sm.checkPermission(new AuthPermission("createLoginContext.other")); //$NON-NLS-1$
            }
            entries = config.getAppConfigurationEntry("other"); //$NON-NLS-1$
            if (entries == null) {
                throw new LoginException("auth.35 " + name); //$NON-NLS-1$
            }
        }

        modules = new Module[entries.length];
        for (int i = 0; i < modules.length; i++) {
            modules[i] = new Module(entries[i]);
        }
        //
        // Set CallbackHandler and this.contextClassLoader
        //

        /*
         * as some of the operations to be executed (i.e. get*ClassLoader,
         * getProperty, class loading) are security-checked, then combine all of
         * them into a single doPrivileged() call.
         */
        try {
            AccessController.doPrivileged(new PrivilegedExceptionAction<Void>() {
                @DSSafe(DSCat.SAFE_LIST)
        public Void run() throws Exception {
                    // First, set the 'contextClassLoader'
                    contextClassLoader = Thread.currentThread().getContextClassLoader();
                    if (contextClassLoader == null) {
                        contextClassLoader = ClassLoader.getSystemClassLoader();
                    }
                    // then, checks whether the cbHandler is set
                    if (cbHandler == null) {
                        // well, let's try to find it
                        String klassName = Security
                                .getProperty(DEFAULT_CALLBACK_HANDLER_PROPERTY);
                        if (klassName == null || klassName.length() == 0) {
                            return null;
                        }
                        Class<?> klass = Class.forName(klassName, true, contextClassLoader);
                        callbackHandler = (CallbackHandler) klass.newInstance();
                    } else {
                        callbackHandler = cbHandler;
                    }
                    return null;
                }
            });
        } catch (PrivilegedActionException ex) {
            Throwable cause = ex.getCause();
            throw (LoginException) new LoginException("auth.36").initCause(cause);//$NON-NLS-1$
        }

        if (userProvidedConfig) {
            userContext = AccessController.getContext();
        } else if (callbackHandler != null) {
            userContext = AccessController.getContext();
            callbackHandler = new ContextedCallbackHandler(callbackHandler);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.577 -0400", hash_original_method = "87E6639B51D3356CDC42FF37067687A2", hash_generated_method = "3933BE4A1384B547C26CD6495D507C26")
    
public Subject getSubject() {
        if (userProvidedSubject || loggedIn) {
            return subject;
        }
        return null;
    }

    /**
     * Warning: calling the method more than once may result in undefined
     * behaviour if logout() method is not invoked before.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.579 -0400", hash_original_method = "1A77F960DA19A688CD9E78A2585D70FA", hash_generated_method = "17915AAC7CEC6191189C65866D6A4C37")
    
public void login() throws LoginException {
        PrivilegedExceptionAction<Void> action = new PrivilegedExceptionAction<Void>() {
            @DSSafe(DSCat.SAFE_LIST)
        public Void run() throws LoginException {
                loginImpl();
                return null;
            }
        };
        try {
            if (userProvidedConfig) {
                AccessController.doPrivileged(action, userContext);
            } else {
                AccessController.doPrivileged(action);
            }
        } catch (PrivilegedActionException ex) {
            throw (LoginException) ex.getException();
        }
    }

    /**
     * The real implementation of login() method whose calls are wrapped into
     * appropriate doPrivileged calls in login().
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.581 -0400", hash_original_method = "65CB23093571023AFD966C156CCF81DC", hash_generated_method = "82EF4FC138409DCC182E9C80804C5C0D")
    
private void loginImpl() throws LoginException {
        if (subject == null) {
            subject = new Subject();
        }

        if (sharedState == null) {
            sharedState = new HashMap<String, Object>();
        }

        // PHASE 1: Calling login()-s
        Throwable firstProblem = null;

        int[] logged = new int[4];
        int[] total = new int[4];

        for (Module module : modules) {
            try {
                // if a module fails during Class.forName(), then it breaks overall 
                // attempt - see catch() below
                module.create(subject, callbackHandler, sharedState);

                if (module.module.login()) {
                    ++total[module.getFlag()];
                    ++logged[module.getFlag()];
                    if (module.getFlag() == SUFFICIENT) {
                        break;
                    }
                }
            } catch (Throwable ex) {
                if (firstProblem == null) {
                    firstProblem = ex;
                }
                if (module.klass == null) {
                    /*
                     * an exception occurred during class lookup - overall
                     * attempt must fail a little trick: increase the REQUIRED's
                     * number - this will look like a failed REQUIRED module
                     * later, so overall attempt will fail
                     */
                    ++total[REQUIRED];
                    break;
                }
                ++total[module.getFlag()];
                // something happened after the class was loaded
                if (module.getFlag() == REQUISITE) {
                    // ... and no need to walk down anymore
                    break;
                }
            }
        }
        // end of PHASE1,

        // Let's decide whether we have either overall success or a total failure
        boolean fail = true;

        /*
         * Note: 'failed[xxx]!=0' is not enough to check.
         * 
         * Use 'logged[xx] != total[xx]' instead. This is because some modules
         * might not be counted as 'failed' if an exception occurred during
         * preload()/Class.forName()-ing. But, such modules still get counted in
         * the total[].
         */

        // if any REQ* module failed - then it's failure
        if (logged[REQUIRED] != total[REQUIRED] || logged[REQUISITE] != total[REQUISITE]) {
            // fail = true;
        } else {
            if (total[REQUIRED] == 0 && total[REQUISITE] == 0) {
                // neither REQUIRED nor REQUISITE was configured.
                // must have at least one SUFFICIENT or OPTIONAL
                if (logged[OPTIONAL] != 0 || logged[SUFFICIENT] != 0) {
                    fail = false;
                }
                //else { fail = true; }
            } else {
                fail = false;
            }
        }

        int commited[] = new int[4];
        // clear it
        total[0] = total[1] = total[2] = total[3] = 0;
        if (!fail) {
            // PHASE 2:

            for (Module module : modules) {
                if (module.klass != null) {
                    ++total[module.getFlag()];
                    try {
                        module.module.commit();
                        ++commited[module.getFlag()];
                    } catch (Throwable ex) {
                        if (firstProblem == null) {
                            firstProblem = ex;
                        }
                    }
                }
            }
        }

        // need to decide once again
        fail = true;
        if (commited[REQUIRED] != total[REQUIRED] || commited[REQUISITE] != total[REQUISITE]) {
            //fail = true;
        } else {
            if (total[REQUIRED] == 0 && total[REQUISITE] == 0) {
                /*
                 * neither REQUIRED nor REQUISITE was configured. must have at
                 * least one SUFFICIENT or OPTIONAL
                 */
                if (commited[OPTIONAL] != 0 || commited[SUFFICIENT] != 0) {
                    fail = false;
                } else {
                    //fail = true;
                }
            } else {
                fail = false;
            }
        }

        if (fail) {
            // either login() or commit() failed. aborting...

            for (Module module : modules) {
                try {
                    module.module.abort();
                } catch ( /*LoginException*/Throwable ex) {
                    if (firstProblem == null) {
                        firstProblem = ex;
                    }
                }
            }
            if (firstProblem instanceof PrivilegedActionException
                    && firstProblem.getCause() != null) {
                firstProblem = firstProblem.getCause();
            }
            if (firstProblem instanceof LoginException) {
                throw (LoginException) firstProblem;
            }
            throw (LoginException) new LoginException("auth.37").initCause(firstProblem); //$NON-NLS-1$
        }
        loggedIn = true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.582 -0400", hash_original_method = "124871DAA53D8E1E1C7D76E355CF6897", hash_generated_method = "AD1EA2BCCC58D02E7B638F4D8B884E6C")
    
public void logout() throws LoginException {
        PrivilegedExceptionAction<Void> action = new PrivilegedExceptionAction<Void>() {
            @DSSafe(DSCat.SAFE_LIST)
        public Void run() throws LoginException {
                logoutImpl();
                return null;
            }
        };
        try {
            if (userProvidedConfig) {
                AccessController.doPrivileged(action, userContext);
            } else {
                AccessController.doPrivileged(action);
            }
        } catch (PrivilegedActionException ex) {
            throw (LoginException) ex.getException();
        }
    }

    /**
     * The real implementation of logout() method whose calls are wrapped into
     * appropriate doPrivileged calls in logout().
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.583 -0400", hash_original_method = "A9891476F065F752D65076C47DD0F56C", hash_generated_method = "5E4D9365EB88F796C24EBE2347160B86")
    
private void logoutImpl() throws LoginException {
        if (subject == null) {
            throw new LoginException("auth.38"); //$NON-NLS-1$
        }
        loggedIn = false;
        Throwable firstProblem = null;
        int total = 0;
        for (Module module : modules) {
            try {
                module.module.logout();
                ++total;
            } catch (Throwable ex) {
                if (firstProblem == null) {
                    firstProblem = ex;
                }
            }
        }
        if (firstProblem != null || total == 0) {
            if (firstProblem instanceof PrivilegedActionException
                    && firstProblem.getCause() != null) {
                firstProblem = firstProblem.getCause();
            }
            if (firstProblem instanceof LoginException) {
                throw (LoginException) firstProblem;
            }
            throw (LoginException) new LoginException("auth.37").initCause(firstProblem); //$NON-NLS-1$
        }
    }

    /**
     * <p>A class that servers as a wrapper for the CallbackHandler when we use
     * installed Configuration, but not a passed one. See API docs on the
     * LoginContext.</p>
     * 
     * <p>Simply invokes the given handler with the given AccessControlContext.</p>
     */
    private class ContextedCallbackHandler implements CallbackHandler {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.584 -0400", hash_original_field = "C75FDA6652CE19B7F72CB01B31D4C608", hash_generated_field = "E018232A5A1F031B8242DB269F57D8F1")

        private  CallbackHandler hiddenHandlerRef;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.585 -0400", hash_original_method = "36D9E9F6C54C2AF219F8BE4A568EBBB3", hash_generated_method = "36D9E9F6C54C2AF219F8BE4A568EBBB3")
        
ContextedCallbackHandler(CallbackHandler handler) {
            super();
            this.hiddenHandlerRef = handler;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.587 -0400", hash_original_method = "8ADA70CB1CC38DBCF15EE720477AB34C", hash_generated_method = "F5A5E71A239FDAD6780AAC911D697EAA")
        
public void handle(final Callback[] callbacks) throws IOException,
                UnsupportedCallbackException {
            try {
                AccessController.doPrivileged(new PrivilegedExceptionAction<Void>() {
                    @DSSafe(DSCat.SAFE_LIST)
            public Void run() throws IOException, UnsupportedCallbackException {
                        hiddenHandlerRef.handle(callbacks);
                        return null;
                    }
                }, userContext);
            } catch (PrivilegedActionException ex) {
                if (ex.getCause() instanceof UnsupportedCallbackException) {
                    throw (UnsupportedCallbackException) ex.getCause();
                }
                throw (IOException) ex.getCause();
            }
        }
    }

    /** 
     * A private class that stores an instantiated LoginModule.
     */
    private final class Module {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.588 -0400", hash_original_field = "5F390A097BC44067F527F0ED37CE2E6B", hash_generated_field = "5F390A097BC44067F527F0ED37CE2E6B")

        AppConfigurationEntry entry;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.588 -0400", hash_original_field = "D7C6F93054CF05A79E7193C197C92887", hash_generated_field = "D7C6F93054CF05A79E7193C197C92887")

        int flag;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.589 -0400", hash_original_field = "268E6B2387DB4F893B311DFDB71C0D3B", hash_generated_field = "268E6B2387DB4F893B311DFDB71C0D3B")

        LoginModule module;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.589 -0400", hash_original_field = "4FD4A1C9793C636452EC47941970310E", hash_generated_field = "4FD4A1C9793C636452EC47941970310E")

        Class<?> klass;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.590 -0400", hash_original_method = "9B95C0D2C4907549BFD725796935316C", hash_generated_method = "DC178A8970C25FF816CB1DE582B21035")
        
Module(AppConfigurationEntry entry) {
            this.entry = entry;
            LoginModuleControlFlag flg = entry.getControlFlag();
            if (flg == LoginModuleControlFlag.OPTIONAL) {
                flag = OPTIONAL;
            } else if (flg == LoginModuleControlFlag.REQUISITE) {
                flag = REQUISITE;
            } else if (flg == LoginModuleControlFlag.SUFFICIENT) {
                flag = SUFFICIENT;
            } else {
                flag = REQUIRED;
                //if(flg!=LoginModuleControlFlag.REQUIRED) throw new Error()
            }
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.590 -0400", hash_original_method = "A505ACE4B2757A66973C93875ABE4BCC", hash_generated_method = "A505ACE4B2757A66973C93875ABE4BCC")
        
int getFlag() {
            return flag;
        }

        /**
         * Loads class of the LoginModule, instantiates it and then calls
         * initialize().
         */
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.591 -0400", hash_original_method = "B00ECC3366986543C948864F6AC687FF", hash_generated_method = "4701467D424149486DFEDEFF7F429925")
        
void create(Subject subject, CallbackHandler callbackHandler, Map<String, ?> sharedState)
                throws LoginException {
            String klassName = entry.getLoginModuleName();
            if (klass == null) {
                try {
                    klass = Class.forName(klassName, false, contextClassLoader);
                } catch (ClassNotFoundException ex) {
                    throw (LoginException) new LoginException(
                            "auth.39 " + klassName).initCause(ex); //$NON-NLS-1$
                }
            }

            if (module == null) {
                try {
                    module = (LoginModule) klass.newInstance();
                } catch (IllegalAccessException ex) {
                    throw (LoginException) new LoginException(
                            "auth.3A " + klassName) //$NON-NLS-1$
                            .initCause(ex);
                } catch (InstantiationException ex) {
                    throw (LoginException) new LoginException(
                            "auth.3A" + klassName) //$NON-NLS-1$
                            .initCause(ex);
                }
                module.initialize(subject, callbackHandler, sharedState, entry.getOptions());
            }
        }
    }
}
