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

package org.apache.harmony.javax.security.auth;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.DomainCombiner;
import java.security.Permission;
import java.security.Principal;
import java.security.PrivilegedAction;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.security.ProtectionDomain;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;



/**
 * The central class of the {@code javax.security.auth} package representing an
 * authenticated user or entity (both referred to as "subject"). IT defines also
 * the static methods that allow code to be run, and do modifications according
 * to the subject's permissions.
 * <p>
 * A subject has the following features:
 * <ul>
 * <li>A set of {@code Principal} objects specifying the identities bound to a
 * {@code Subject} that distinguish it.</li>
 * <li>Credentials (public and private) such as certificates, keys, or
 * authentication proofs such as tickets</li>
 * </ul>
 */
public final class Subject implements Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.924 -0400", hash_original_field = "83E371B3CF06F1A3C983E6EF2991F115", hash_generated_field = "650BA7E5223938D071200D497FC1E3E2")


    private static final long serialVersionUID = -8308522755600156056L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.925 -0400", hash_original_field = "A8C0155CF084CA57000A40DC9B149C7B", hash_generated_field = "01CD37D90C524137EC8683DFA0694DBC")

    
    private static final AuthPermission _AS = new AuthPermission("doAs");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.925 -0400", hash_original_field = "40177A21A7BF1D61D8C8691BA989BAD7", hash_generated_field = "D229E77B878BA9A8B1F3E569CEF16492")


    private static final AuthPermission _AS_PRIVILEGED = new AuthPermission(
            "doAsPrivileged");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.926 -0400", hash_original_field = "B66E57B36153EB9E9C85012942600AB6", hash_generated_field = "594216FA5B9A9FDF38AA198AFB793EAD")


    private static final AuthPermission _SUBJECT = new AuthPermission(
            "getSubject");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.926 -0400", hash_original_field = "D8094C5A08F5E14C3C9705A8F7876249", hash_generated_field = "82CD78EBD801039E393CCDD11C8E2B4A")


    private static final AuthPermission _PRINCIPALS = new AuthPermission(
            "modifyPrincipals");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.927 -0400", hash_original_field = "B7BA802B414D4B087C2B724EAA02361D", hash_generated_field = "2074F746249BD32D9577DB6DA43384F7")


    private static final AuthPermission _PRIVATE_CREDENTIALS = new AuthPermission(
            "modifyPrivateCredentials");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.927 -0400", hash_original_field = "5457F85750E21D74E2940A3F86761298", hash_generated_field = "30FC878E270F20A927F42A31C898B862")


    private static final AuthPermission _PUBLIC_CREDENTIALS = new AuthPermission(
            "modifyPublicCredentials");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.928 -0400", hash_original_field = "A50923205C60544E9EA2A2CB0B8D73EA", hash_generated_field = "57FD217E7CA002929BDAFE9652DE07D5")


    private static final AuthPermission _READ_ONLY = new AuthPermission(
            "setReadOnly");

    /**
     * Runs the code defined by {@code action} using the permissions granted to
     * the {@code Subject} itself and to the code as well.
     *
     * @param subject
     *            the distinguished {@code Subject}.
     * @param action
     *            the code to be run.
     * @return the {@code Object} returned when running the {@code action}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.933 -0400", hash_original_method = "447366A90AFBC2A20A299347BC762BA4", hash_generated_method = "0D23E21F0967636AC47DB3B6211437FC")
    
@SuppressWarnings("unchecked")
    public static Object doAs(Subject subject, PrivilegedAction action) {

        checkPermission(_AS);

        return doAs_PrivilegedAction(subject, action, AccessController.getContext());
    }

    /**
     * Run the code defined by {@code action} using the permissions granted to
     * the {@code Subject} and to the code itself, additionally providing a more
     * specific context.
     *
     * @param subject
     *            the distinguished {@code Subject}.
     * @param action
     *            the code to be run.
     * @param context
     *            the specific context in which the {@code action} is invoked.
     *            if {@code null} a new {@link AccessControlContext} is
     *            instantiated.
     * @return the {@code Object} returned when running the {@code action}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.933 -0400", hash_original_method = "0C1705D6762AD6D815E348B382938AB5", hash_generated_method = "49E6420D4FAE6F51CE014B9B0A5A2D44")
    
@SuppressWarnings("unchecked")
    public static Object doAsPrivileged(Subject subject, PrivilegedAction action,
            AccessControlContext context) {

        checkPermission(_AS_PRIVILEGED);

        if (context == null) {
            return doAs_PrivilegedAction(subject, action, new AccessControlContext(
                    new ProtectionDomain[0]));
        }
        return doAs_PrivilegedAction(subject, action, context);
    }

    // instantiates a new context and passes it to AccessController
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.935 -0400", hash_original_method = "A33CBDD8BC9D958C31BE9E7737E61E38", hash_generated_method = "BFFE29E4C8FF9DE59909AC2C5C51AF44")
    
@SuppressWarnings("unchecked")
    private static Object doAs_PrivilegedAction(Subject subject, PrivilegedAction action,
            final AccessControlContext context) {

        AccessControlContext newContext;

        final SubjectDomainCombiner combiner;
        if (subject == null) {
            // performance optimization
            // if subject is null there is nothing to combine
            combiner = null;
        } else {
            combiner = new SubjectDomainCombiner(subject);
        }

        PrivilegedAction dccAction = new PrivilegedAction() {
            public Object run() {

                return new AccessControlContext(context, combiner);
            }
        };

        newContext = (AccessControlContext) AccessController.doPrivileged(dccAction);

        return AccessController.doPrivileged(action, newContext);
    }

    /**
     * Runs the code defined by {@code action} using the permissions granted to
     * the subject and to the code itself.
     *
     * @param subject
     *            the distinguished {@code Subject}.
     * @param action
     *            the code to be run.
     * @return the {@code Object} returned when running the {@code action}.
     * @throws PrivilegedActionException
     *             if running the {@code action} throws an exception.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.935 -0400", hash_original_method = "7A3609EA59C7FDF24C8C4EA597EC0B39", hash_generated_method = "69BF7569E1816AE1474F8A87E8F0ED86")
    
@SuppressWarnings("unchecked")
    public static Object doAs(Subject subject, PrivilegedExceptionAction action)
            throws PrivilegedActionException {

        checkPermission(_AS);

        return doAs_PrivilegedExceptionAction(subject, action, AccessController.getContext());
    }

    /**
     * Runs the code defined by {@code action} using the permissions granted to
     * the subject and to the code itself, additionally providing a more
     * specific context.
     *
     * @param subject
     *            the distinguished {@code Subject}.
     * @param action
     *            the code to be run.
     * @param context
     *            the specific context in which the {@code action} is invoked.
     *            if {@code null} a new {@link AccessControlContext} is
     *            instantiated.
     * @return the {@code Object} returned when running the {@code action}.
     * @throws PrivilegedActionException
     *             if running the {@code action} throws an exception.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.936 -0400", hash_original_method = "DC63FC079A98F2ED434B7AA1C838EF65", hash_generated_method = "E635146E1E6CB966643CB2F64BE5B9A6")
    
@SuppressWarnings("unchecked")
    public static Object doAsPrivileged(Subject subject,
            PrivilegedExceptionAction action, AccessControlContext context)
            throws PrivilegedActionException {

        checkPermission(_AS_PRIVILEGED);

        if (context == null) {
            return doAs_PrivilegedExceptionAction(subject, action,
                    new AccessControlContext(new ProtectionDomain[0]));
        }
        return doAs_PrivilegedExceptionAction(subject, action, context);
    }

    // instantiates a new context and passes it to AccessController
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.937 -0400", hash_original_method = "F403058294F81F85A4D22425610A5032", hash_generated_method = "7E737254DAD158B11110CA6EDE0E3462")
    
@SuppressWarnings("unchecked")
    private static Object doAs_PrivilegedExceptionAction(Subject subject,
            PrivilegedExceptionAction action, final AccessControlContext context)
            throws PrivilegedActionException {

        AccessControlContext newContext;

        final SubjectDomainCombiner combiner;
        if (subject == null) {
            // performance optimization
            // if subject is null there is nothing to combine
            combiner = null;
        } else {
            combiner = new SubjectDomainCombiner(subject);
        }

        PrivilegedAction<AccessControlContext> dccAction = new PrivilegedAction<AccessControlContext>() {
            public AccessControlContext run() {
                return new AccessControlContext(context, combiner);
            }
        };

        newContext = AccessController.doPrivileged(dccAction);

        return AccessController.doPrivileged(action, newContext);
    }

    /**
     * Returns the {@code Subject} that was last associated with the {@code
     * context} provided as argument.
     *
     * @param context
     *            the {@code context} that was associated with the
     *            {@code Subject}.
     * @return the {@code Subject} that was last associated with the {@code
     *         context} provided as argument.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.946 -0400", hash_original_method = "D8EE8EEF5C1B8581367B38765F35B285", hash_generated_method = "7C62A964FCF100AE6FDCA44DD9AA6D4C")
    
public static Subject getSubject(final AccessControlContext context) {
        checkPermission(_SUBJECT);
        if (context == null) {
            throw new NullPointerException("auth.09"); //$NON-NLS-1$
        }
        PrivilegedAction<DomainCombiner> action = new PrivilegedAction<DomainCombiner>() {
            public DomainCombiner run() {
                return context.getDomainCombiner();
            }
        };
        DomainCombiner combiner = AccessController.doPrivileged(action);

        if ((combiner == null) || !(combiner instanceof SubjectDomainCombiner)) {
            return null;
        }
        return ((SubjectDomainCombiner) combiner).getSubject();
    }

    // checks passed permission
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.947 -0400", hash_original_method = "68C8C533405D4A524F1441177C1DCFFF", hash_generated_method = "05244F5C4A28D3425C129B2DE91455D9")
    
private static void checkPermission(Permission p) {
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            sm.checkPermission(p);
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.929 -0400", hash_original_field = "80589A7BCC8195FA980CFCE751166045", hash_generated_field = "8C7B57842A763E27D5B61EC91EAB4DF6")


    private  Set<Principal> principals;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.930 -0400", hash_original_field = "33D60A783111741336ACFEFD5BC43578", hash_generated_field = "3DD6BC0BB0ADB1E11D53E8F1129974CA")


    private boolean readOnly;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.930 -0400", hash_original_field = "4104854C933417FC9DB716A30F856641", hash_generated_field = "9B795B2C6AA5F4DBB2C4993E584276EA")

    private transient SecureSet<Object> privateCredentials;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.931 -0400", hash_original_field = "661911864BD2F399ED895AEB2A70B7A4", hash_generated_field = "84811F008D06873E649CF1E43EE25060")

    private transient SecureSet<Object> publicCredentials;
    
    /**
     * The default constructor initializing the sets of public and private
     * credentials and principals with the empty set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.931 -0400", hash_original_method = "2D354A10CAA1218C8858627DB4A7F43C", hash_generated_method = "5DE4853516E09EAF53AEF7F945B70A9A")
    
public Subject() {
        super();
        principals = new SecureSet<Principal>(_PRINCIPALS);
        publicCredentials = new SecureSet<Object>(_PUBLIC_CREDENTIALS);
        privateCredentials = new SecureSet<Object>(_PRIVATE_CREDENTIALS);

        readOnly = false;
    }

    /**
     * The constructor for the subject, setting its public and private
     * credentials and principals according to the arguments.
     *
     * @param readOnly
     *            {@code true} if this {@code Subject} is read-only, thus
     *            preventing any modifications to be done.
     * @param subjPrincipals
     *            the set of Principals that are attributed to this {@code
     *            Subject}.
     * @param pubCredentials
     *            the set of public credentials that distinguish this {@code
     *            Subject}.
     * @param privCredentials
     *            the set of private credentials that distinguish this {@code
     *            Subject}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.932 -0400", hash_original_method = "B267288DDC50A1183254AC369C866862", hash_generated_method = "5CF8A45B6614BF12D449A81CE2F8783D")
    
public Subject(boolean readOnly, Set<? extends Principal> subjPrincipals,
            Set<?> pubCredentials, Set<?> privCredentials) {

        if (subjPrincipals == null || pubCredentials == null || privCredentials == null) {
            throw new NullPointerException();
        }

        principals = new SecureSet<Principal>(_PRINCIPALS, subjPrincipals);
        publicCredentials = new SecureSet<Object>(_PUBLIC_CREDENTIALS, pubCredentials);
        privateCredentials = new SecureSet<Object>(_PRIVATE_CREDENTIALS, privCredentials);

        this.readOnly = readOnly;
    }

    /**
     * Checks two Subjects for equality. More specifically if the principals,
     * public and private credentials are equal, equality for two {@code
     * Subjects} is implied.
     *
     * @param obj
     *            the {@code Object} checked for equality with this {@code
     *            Subject}.
     * @return {@code true} if the specified {@code Subject} is equal to this
     *         one.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.938 -0400", hash_original_method = "9A73CF0E6C91EA95CE15AF8BB9E040DF", hash_generated_method = "8A8BF022A29E9018EE40C18E3BC669CF")
    
@Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        Subject that = (Subject) obj;

        if (principals.equals(that.principals)
                && publicCredentials.equals(that.publicCredentials)
                && privateCredentials.equals(that.privateCredentials)) {
            return true;
        }
        return false;
    }

    /**
     * Returns this {@code Subject}'s {@link Principal}.
     *
     * @return this {@code Subject}'s {@link Principal}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.939 -0400", hash_original_method = "CE83A4A49B82D71D3046E9B4674B5C53", hash_generated_method = "F86211B5BD9C0EBADDE671FF9A7B45A0")
    
public Set<Principal> getPrincipals() {
        return principals;
    }


    /**
     * Returns this {@code Subject}'s {@link Principal} which is a subclass of
     * the {@code Class} provided.
     *
     * @param c
     *            the {@code Class} as a criteria which the {@code Principal}
     *            returned must satisfy.
     * @return this {@code Subject}'s {@link Principal}. Modifications to the
     *         returned set of {@code Principal}s do not affect this {@code
     *         Subject}'s set.
     */
    public <T extends Principal> Set<T> getPrincipals(Class<T> c) {
        return ((SecureSet<Principal>) principals).get(c);
    }

    /**
     * Returns the private credentials associated with this {@code Subject}.
     *
     * @return the private credentials associated with this {@code Subject}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.939 -0400", hash_original_method = "E5A1CFBF2FA03793447BEB5C13809C7C", hash_generated_method = "288B8163A8F63F7082D3971DAA21FE41")
    
public Set<Object> getPrivateCredentials() {
        return privateCredentials;
    }

    /**
     * Returns this {@code Subject}'s private credentials which are a subclass
     * of the {@code Class} provided.
     *
     * @param c
     *            the {@code Class} as a criteria which the private credentials
     *            returned must satisfy.
     * @return this {@code Subject}'s private credentials. Modifications to the
     *         returned set of credentials do not affect this {@code Subject}'s
     *         credentials.
     */
    public <T> Set<T> getPrivateCredentials(Class<T> c) {
        return privateCredentials.get(c);
    }

    /**
     * Returns the public credentials associated with this {@code Subject}.
     *
     * @return the public credentials associated with this {@code Subject}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.940 -0400", hash_original_method = "2DB429A92023A9A6BA2CEB310E5E5A7E", hash_generated_method = "27A1D02890115602D15137783508D9DD")
    
public Set<Object> getPublicCredentials() {
        return publicCredentials;
    }


    /**
     * Returns this {@code Subject}'s public credentials which are a subclass of
     * the {@code Class} provided.
     *
     * @param c
     *            the {@code Class} as a criteria which the public credentials
     *            returned must satisfy.
     * @return this {@code Subject}'s public credentials. Modifications to the
     *         returned set of credentials do not affect this {@code Subject}'s
     *         credentials.
     */
    public <T> Set<T> getPublicCredentials(Class<T> c) {
        return publicCredentials.get(c);
    }

    /**
     * Returns a hash code of this {@code Subject}.
     *
     * @return a hash code of this {@code Subject}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.941 -0400", hash_original_method = "922E575B91166261BAF01CDEC921B8F1", hash_generated_method = "38819E9D07A47BF07A14D8BAD2F72E9D")
    
@Override
    public int hashCode() {
        return principals.hashCode() + privateCredentials.hashCode()
                + publicCredentials.hashCode();
    }

    /**
     * Prevents from modifications being done to the credentials and {@link
     * Principal} sets. After setting it to read-only this {@code Subject} can
     * not be made writable again. The destroy method on the credentials still
     * works though.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.942 -0400", hash_original_method = "F818BF49CFCDB4C84825C136B26DB6A8", hash_generated_method = "B4932553E19D4941151478AD5F862915")
    
public void setReadOnly() {
        checkPermission(_READ_ONLY);

        readOnly = true;
    }

    /**
     * Returns whether this {@code Subject} is read-only or not.
     *
     * @return whether this {@code Subject} is read-only or not.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.942 -0400", hash_original_method = "7F96B35F8F79C51B3F748C56EEA20BE0", hash_generated_method = "9E34EDCB39728B9445DC5F35CC50B5F5")
    
public boolean isReadOnly() {
        return readOnly;
    }

    /**
     * Returns a {@code String} representation of this {@code Subject}.
     *
     * @return a {@code String} representation of this {@code Subject}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.943 -0400", hash_original_method = "61A39B7E74AC3892A6C28B08F4766525", hash_generated_method = "4EB9490FA1452B301782FA47B2D3416E")
    
@Override
    public String toString() {

        StringBuilder buf = new StringBuilder("Subject:\n"); //$NON-NLS-1$

        Iterator<?> it = principals.iterator();
        while (it.hasNext()) {
            buf.append("\tPrincipal: "); //$NON-NLS-1$
            buf.append(it.next());
            buf.append('\n');
        }

        it = publicCredentials.iterator();
        while (it.hasNext()) {
            buf.append("\tPublic Credential: "); //$NON-NLS-1$
            buf.append(it.next());
            buf.append('\n');
        }

        int offset = buf.length() - 1;
        it = privateCredentials.iterator();
        try {
            while (it.hasNext()) {
                buf.append("\tPrivate Credential: "); //$NON-NLS-1$
                buf.append(it.next());
                buf.append('\n');
            }
        } catch (SecurityException e) {
            buf.delete(offset, buf.length());
            buf.append("\tPrivate Credentials: no accessible information\n"); //$NON-NLS-1$
        }
        return buf.toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.944 -0400", hash_original_method = "0D0BA87E286D5565C6A92EF45111E2F7", hash_generated_method = "5C2974FA9289F3C4720A1B582DE3C914")
    
private void readObject(ObjectInputStream in) throws IOException,
            ClassNotFoundException {

        in.defaultReadObject();

        publicCredentials = new SecureSet<Object>(_PUBLIC_CREDENTIALS);
        privateCredentials = new SecureSet<Object>(_PRIVATE_CREDENTIALS);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.945 -0400", hash_original_method = "36C8E2237DE0E1492EB8316E43BE687F", hash_generated_method = "D83872F261E3529F816BC68C77515208")
    
private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    // FIXME is used only in two places. remove?
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.948 -0400", hash_original_method = "FD52BC15183885BA696BA24DDFFEB7B2", hash_generated_method = "282850BF179216CBE6D7B71CE1E1AF0B")
    
private void checkState() {
        if (readOnly) {
            throw new IllegalStateException("auth.0A"); //$NON-NLS-1$
        }
    }

    private final class SecureSet<SST> extends AbstractSet<SST> implements Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.948 -0400", hash_original_field = "C41B15296D23B160AB28C19B5AAF23D5", hash_generated_field = "2E0CC61FEEEAF7DD25A9FF6545D3C4AF")

        private static final long serialVersionUID = 7911754171111800359L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.950 -0400", hash_original_field = "88372FCF930397111006A83AEE72BD78", hash_generated_field = "26F9AABEF9D1455EA01FBF9BE060D456")

        private static final int SET_Principal = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.950 -0400", hash_original_field = "75AA615280775E8F27CC1FD5BA66E771", hash_generated_field = "231DD9CB5EF39CE53D5622FAE2EF58C5")

        private static final int SET_PrivCred = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.951 -0400", hash_original_field = "026C45AE1257A02CC196CA67ACD44CA1", hash_generated_field = "B52BE823DAD39C88232037AA13427430")

        private static final int SET_PubCred = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.949 -0400", hash_original_field = "E8762E035920E788359E150072E9A897", hash_generated_field = "D7EDF8FC2DC520C207C8069EB07493B1")


        private LinkedList<SST> elements;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.949 -0400", hash_original_field = "17E9ADD77F09749BEB9ACC0286F5F067", hash_generated_field = "CDF7539C055F429AE15FF4CAB97B4D40")

        private int setType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.951 -0400", hash_original_field = "519E901CFA7E771799E9B5F54D3E7FA4", hash_generated_field = "1099DFE891C328E5A4EB2629660102CA")

        private transient AuthPermission permission;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.952 -0400", hash_original_method = "2DCE213441F0831821CBC087ECED3E01", hash_generated_method = "15AB4BCA5CDE92103A547F3267FA90A1")
        
protected SecureSet(AuthPermission perm) {
            permission = perm;
            elements = new LinkedList<SST>();
        }

        // creates set from specified collection with specified permission
        // all collection elements are verified before adding
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.953 -0400", hash_original_method = "38B6D48D2C6BD4A0E0D0138D044F967F", hash_generated_method = "18781D5645A0AA4A64BBBEAFB350DE1F")
        
protected SecureSet(AuthPermission perm, Collection<? extends SST> s) {
            this(perm);

            // Subject's constructor receives a Set, we can trusts if a set is from bootclasspath,
            // and not to check whether it contains duplicates or not
            boolean trust = s.getClass().getClassLoader() == null; 
            
            Iterator<? extends SST> it = s.iterator();
            while (it.hasNext()) {
                SST o = it.next();
                verifyElement(o);
                if (trust || !elements.contains(o)) {
                    elements.add(o);
                }
            }
        }

        // verifies new set element
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.953 -0400", hash_original_method = "C2DA609635F1136D9CF304EAF89F8F65", hash_generated_method = "ABE19008878854AAF43F1EF070AD876F")
        
private void verifyElement(Object o) {

            if (o == null) {
                throw new NullPointerException();
            }
            if (permission == _PRINCIPALS && !(Principal.class.isAssignableFrom(o.getClass()))) {
                throw new IllegalArgumentException("auth.0B"); //$NON-NLS-1$
            }
        }

        /*
         * verifies specified element, checks set state, and security permission
         * to modify set before adding new element
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.954 -0400", hash_original_method = "DEACFE9986F4C4A4405BB0BA90E5A571", hash_generated_method = "0A790DA89CDDF22E8010ADA34FED7ACD")
        
@Override
        public boolean add(SST o) {

            verifyElement(o);

            checkState();
            checkPermission(permission);

            if (!elements.contains(o)) {
                elements.add(o);
                return true;
            }
            return false;
        }

        // returns an instance of SecureIterator
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.956 -0400", hash_original_method = "85CACC2FAB77B932D0F1585C2FCCE0B9", hash_generated_method = "CD2A6561532B3081A494FF8526795238")
        
@Override
        public Iterator<SST> iterator() {

            if (permission == _PRIVATE_CREDENTIALS) {
                /*
                 * private credential set requires iterator with additional
                 * security check (PrivateCredentialPermission)
                 */
                return new SecureIterator(elements.iterator()) {
                    /*
                     * checks permission to access next private credential moves
                     * to the next element even SecurityException was thrown
                     */
                    @Override
                    public SST next() {
                        SST obj = iterator.next();
                        checkPermission(new PrivateCredentialPermission(obj
                                .getClass().getName(), principals));
                        return obj;
                    }
                };
            }
            return new SecureIterator(elements.iterator());
        }

                @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.959 -0400", hash_original_method = "0BCAD680E42DBFF24B0504284FCEF539", hash_generated_method = "3B2A1D5E0234ACA76AD0C4EAA743A0BC")
                
@Override
                public boolean retainAll(Collection<?> c) {

                    if (c == null) {
                        throw new NullPointerException();
                    }
                    return super.retainAll(c);
                }

                @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.960 -0400", hash_original_method = "9CEEF1FB7FE0E92F89E50428A2A0794E", hash_generated_method = "6CA49245EE51DC3B47072B5BD0A5EDFC")
                
@Override
                public int size() {
                    return elements.size();
                }

        /**
         * return set with elements that are instances or subclasses of the
         * specified class
         */
        protected final <E> Set<E> get(final Class<E> c) {

            if (c == null) {
                throw new NullPointerException();
            }

            AbstractSet<E> s = new AbstractSet<E>() {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.957 -0400", hash_original_field = "F1C399DCD5E5B8F742B849E547B12993", hash_generated_field = "D0834658F226E5432836EDF4506E7FF0")

                private LinkedList<E> elements = new LinkedList<E>();

                @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.958 -0400", hash_original_method = "F1FE8DDD28EE8B7E23237285E4648ECC", hash_generated_method = "BF992DB2331349E1B9F70D4640135616")
                
@Override
                public boolean add(E o) {

                    if (!c.isAssignableFrom(o.getClass())) {
                        throw new IllegalArgumentException(
                                "auth.0C " + c.getName()); //$NON-NLS-1$
                    }

                    if (elements.contains(o)) {
                        return false;
                    }
                    elements.add(o);
                    return true;
                }

                @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.959 -0400", hash_original_method = "F74DAED678A58B80055D86B41CE5385A", hash_generated_method = "562D4607421BFB2E8B42A18B0D83061B")
                
@Override
                public Iterator<E> iterator() {
                    return elements.iterator();
                }

                @Override
                public boolean retainAll(Collection<?> c) {

                    if (c == null) {
                        throw new NullPointerException();
                    }
                    return super.retainAll(c);
                }

                @Override
                public int size() {
                    return elements.size();
                }
            };

            // FIXME must have permissions for requested priv. credentials
            for (Iterator<SST> it = iterator(); it.hasNext();) {
                SST o = it.next();
                if (c.isAssignableFrom(o.getClass())) {
                    s.add(c.cast(o));
                }
            }
            return s;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.961 -0400", hash_original_method = "63A479756CA23F0B1DA6F370079C1EA4", hash_generated_method = "12FC7F0151B61146E5471B3C6E079F3F")
        
private void readObject(ObjectInputStream in) throws IOException,
                ClassNotFoundException {
            in.defaultReadObject();

            switch (setType) {
            case SET_Principal:
                permission = _PRINCIPALS;
                break;
            case SET_PrivCred:
                permission = _PRIVATE_CREDENTIALS;
                break;
            case SET_PubCred:
                permission = _PUBLIC_CREDENTIALS;
                break;
            default:
                throw new IllegalArgumentException();
            }

            Iterator<SST> it = elements.iterator();
            while (it.hasNext()) {
                verifyElement(it.next());
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.962 -0400", hash_original_method = "4889097D99FD37D87E16537E55A8A8C1", hash_generated_method = "8F8C66783F207F048B56D85D1A25FCA3")
        
private void writeObject(ObjectOutputStream out) throws IOException {

            if (permission == _PRIVATE_CREDENTIALS) {
                // does security check for each private credential
                for (Iterator<SST> it = iterator(); it.hasNext();) {
                    it.next();
                }
                setType = SET_PrivCred;
            } else if (permission == _PRINCIPALS) {
                setType = SET_Principal;
            } else {
                setType = SET_PubCred;
            }

            out.defaultWriteObject();
        }

        /**
         * Represents iterator for subject's secure set
         */
        private class SecureIterator implements Iterator<SST> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.963 -0400", hash_original_field = "837A874F9665700E4D9FFAE8AAD3E378", hash_generated_field = "C89B16D808E3D744FD411D16239A945F")

            protected Iterator<SST> iterator;

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.963 -0400", hash_original_method = "32FFF4DB26746386A028806AD014A738", hash_generated_method = "CBCDC3BB8B01BAACBB6718D3DD3811A0")
            
protected SecureIterator(Iterator<SST> iterator) {
                this.iterator = iterator;
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.964 -0400", hash_original_method = "AA3B17E619A4DDCE5FFF27C1294FF431", hash_generated_method = "C980563D1FCC5FC801457BF9C1053824")
            
public boolean hasNext() {
                return iterator.hasNext();
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.964 -0400", hash_original_method = "8FDE5D25AC393B3FFD9D30C415E45749", hash_generated_method = "C5421228DDE8DA5C571D03A025039E5F")
            
public SST next() {
                return iterator.next();
            }

            /**
             * checks set state, and security permission to modify set before
             * removing current element
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.965 -0400", hash_original_method = "98E24A6845BBF25040BEC171675E83AB", hash_generated_method = "1FE2BBDF8C727F155D7F6FB9C0D304DF")
            
public void remove() {
                checkState();
                checkPermission(permission);
                iterator.remove();
            }
        }
    }
}
