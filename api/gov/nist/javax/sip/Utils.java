package gov.nist.javax.sip;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.Via;
import gov.nist.javax.sip.message.SIPResponse;

import java.security.MessageDigest;
import java.util.HashSet;

public class Utils implements UtilsExt {
   
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:49.449 -0500", hash_original_method = "374DAC9ECD069BD80F1EF985F978C693", hash_generated_method = "D07E1DA751C02C51B488E18E42FF7C46")
    
public static Utils getInstance() {
        return instance;
    }
   
    /**
     * convert an array of bytes to an hexadecimal string
     *
     * @return a string
     * @param b
     *            bytes array to convert to a hexadecimal string
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:49.459 -0500", hash_original_method = "CAF32B6D436555758214A0AC3F1F5894", hash_generated_method = "5C573BF9CE1FD82E4A0CBC97D477F4AB")
    
public static String toHexString(byte b[]) {
        int pos = 0;
        char[] c = new char[b.length * 2];
        for (int i = 0; i < b.length; i++) {
            c[pos++] = toHex[(b[i] >> 4) & 0x0F];
            c[pos++] = toHex[b[i] & 0x0f];
        }
        return new String(c);
    }

    /**
     * Put quotes around a string and return it.
     * Any " characters appearing in str are escaped
     *
     * @return a quoted string
     * @param str
     *            string to be quoted
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:49.468 -0500", hash_original_method = "71A98D541624CF2F27EE7D084D0F14CB", hash_generated_method = "2415D683FF1EC39CD848F03436E4CDA9")
    
public static String getQuotedString(String str) {
        return '"' + str.replace( "\"", "\\\"" ) + '"';
    }

    /**
     * Squeeze out all white space from a string and return the reduced string.
     *
     * @param input
     *            input string to sqeeze.
     * @return String a reduced string.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:49.481 -0500", hash_original_method = "57A8851D0E49FA55CB02D4F17330C148", hash_generated_method = "45B96C72B5A72BAD8A013471D2375A1E")
    
protected static String reduceString(String input) {
        String newString = input.toLowerCase();
        int len = newString.length();
        String retval = "";
        for (int i = 0; i < len; i++) {
            if (newString.charAt(i) == ' ' || newString.charAt(i) == '\t')
                continue;
            else
                retval += newString.charAt(i);
        }
        return retval;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:49.537 -0500", hash_original_method = "91350AA934456C18675F81415E4BE737", hash_generated_method = "86C869EE06A24E640B4A51E22B6F3B54")
    
public static String getSignature() {
        return signature;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:49.547 -0500", hash_original_method = "A0680B0202A5BDD37BF6A486B5ACD4CD", hash_generated_method = "4EEB897DEF8BAFD4834C2831002FA5EF")
    
public static void main(String[] args) {
        HashSet branchIds = new HashSet();
        for (int b = 0; b < 100000; b++) {
            String bid = Utils.getInstance().generateBranchId();
            if (branchIds.contains(bid)) {
                throw new RuntimeException("Duplicate Branch ID");
            } else {
                branchIds.add(bid);
            }
        }
        System.out.println("Done!!");

    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:49.376 -0500", hash_original_field = "03C720A7278CD9E26C7C8FA651CBEBD9", hash_generated_field = "75DF3FBD64D6EA0108E137FADE714C1F")

    private static MessageDigest digester;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:49.388 -0500", hash_original_field = "C79F987FE2CD4684369481EB8585180A", hash_generated_field = "7E238EAE548E2EE44C039EC6AC75AC3D")
   
    private static java.util.Random rand;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:49.395 -0500", hash_original_field = "99661A4B2A071330FB28852FE8E4D92A", hash_generated_field = "AE51E4CF92FF648669819D7B0481713C")
   
    private static long counter = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:49.403 -0500", hash_original_field = "240BC6F69F6A2B8E94596F09922B7D47", hash_generated_field = "6CF948D0E8697F6CBD93101CC8EE4EA8")

    private static int callIDCounter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:49.411 -0500", hash_original_field = "2054B836E70C3B2D56EA815469FD928A", hash_generated_field = "512F210EC728FA3837ABDE0579788961")

    private static String signature ;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:49.429 -0500", hash_original_field = "9932D9F02B56D2BDE79047F67B56517B", hash_generated_field = "B26221B75DD3069F1E7CEE68F1C1307C")
    
    private static Utils instance = new Utils();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:49.440 -0500", hash_original_field = "8D139981331595450D79D39F36281B87", hash_generated_field = "D08ABC333720B6C25B9902ED84803CDE")

    private static final char[] toHex = { '0', '1', '2', '3', '4', '5', '6',
            '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.887 -0400", hash_original_method = "4A92704CBFAAEA8B3C41F62FC777198C", hash_generated_method = "4A92704CBFAAEA8B3C41F62FC777198C")
    public Utils ()
    {
        //Synthesized constructor
    }

    /**
     * Generate a call identifier. This is useful when we want to generate a
     * call identifier in advance of generating a message.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:49.492 -0500", hash_original_method = "8B9CD4355F65A61EBC08146A51CEAFC7", hash_generated_method = "FCC3DA8CF69F39629A5B563BBF09E59A")
    
public synchronized String generateCallIdentifier(String address) {

            String date = Long.toString(System.currentTimeMillis() + callIDCounter++
                    + rand.nextLong());
            byte cid[] = digester.digest(date.getBytes());

            String cidString = Utils.toHexString(cid);
            return cidString + "@" + address;

    }

    /**
     * Generate a tag for a FROM header or TO header. Just return a random 4
     * digit integer (should be enough to avoid any clashes!) Tags only need to
     * be unique within a call.
     *
     * @return a string that can be used as a tag parameter.
     *
     * synchronized: needed for access to 'rand', else risk to generate same tag
     * twice
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:49.509 -0500", hash_original_method = "9AA82EE1A1BEF7CB34AB2EE7CC0970FC", hash_generated_method = "7E14C3B54647C0239A344CC421AAE0ED")
    
public synchronized String generateTag() {

            return Integer.toHexString(rand.nextInt());

    }

    /**
     * Generate a cryptographically random identifier that can be used to
     * generate a branch identifier.
     *
     * @return a cryptographically random gloablly unique string that can be
     *         used as a branch identifier.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:49.521 -0500", hash_original_method = "7AE3A829A02A70B14E30FF17666004A8", hash_generated_method = "3B7496053364E45945255665684F4A5F")
    
public synchronized String generateBranchId() {
        //

            long num = rand.nextLong() + Utils.counter++  + System.currentTimeMillis();

            byte bid[] = digester.digest(Long.toString(num).getBytes());
            // prepend with a magic cookie to indicate we are bis09 compatible.
            return SIPConstants.BRANCH_MAGIC_COOKIE + Utils.toHexString(bid) + this.signature;

    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:49.530 -0500", hash_original_method = "C81ECDD34C7D54B91D88A9F561BC20EF", hash_generated_method = "5641701A93773A6DA35CC5CF8E139C0B")
    
public boolean responseBelongsToUs(SIPResponse response) {
        Via topmostVia = response.getTopmostVia();
        String branch = topmostVia.getBranch();
        return branch != null && branch.endsWith(this.signature);
    }
    static {
        try {
            digester = MessageDigest.getInstance("MD5");
        } catch (Exception ex) {
            throw new RuntimeException("Could not intialize Digester ", ex);
        }
        rand = new java.util.Random();
        signature = toHexString(Integer.toString(Math.abs( rand.nextInt() % 1000 )).getBytes());
    }
    
}

