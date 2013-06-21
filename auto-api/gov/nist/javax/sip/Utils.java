package gov.nist.javax.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.header.Via;
import gov.nist.javax.sip.message.SIPResponse;
import java.security.MessageDigest;
import java.util.HashSet;

public class Utils implements UtilsExt {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.340 -0400", hash_original_method = "878FA166D9A83DE45758B18E9C8C0D16", hash_generated_method = "878FA166D9A83DE45758B18E9C8C0D16")
        public Utils ()
    {
    }


        public static Utils getInstance() {
        return instance;
    }

    
        public static String toHexString(byte b[]) {
        int pos = 0;
        char[] c = new char[b.length * 2];
        for (int i = 0; i < b.length; i++) {
            c[pos++] = toHex[(b[i] >> 4) & 0x0F];
            c[pos++] = toHex[b[i] & 0x0f];
        }
        return new String(c);
    }

    
        public static String getQuotedString(String str) {
        return '"' + str.replace( "\"", "\\\"" ) + '"';
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.341 -0400", hash_original_method = "8B9CD4355F65A61EBC08146A51CEAFC7", hash_generated_method = "FA991AEB3E7DC5694BA830D9D0CAB06B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized String generateCallIdentifier(String address) {
        dsTaint.addTaint(address);
        String date;
        date = Long.toString(System.currentTimeMillis() + callIDCounter++
                    + rand.nextLong());
        byte cid[];
        cid = digester.digest(date.getBytes());
        String cidString;
        cidString = Utils.toHexString(cid);
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String date = Long.toString(System.currentTimeMillis() + callIDCounter++
                    //+ rand.nextLong());
        //byte cid[] = digester.digest(date.getBytes());
        //String cidString = Utils.toHexString(cid);
        //return cidString + "@" + address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.341 -0400", hash_original_method = "9AA82EE1A1BEF7CB34AB2EE7CC0970FC", hash_generated_method = "EA7D34E05F2FCAE2F78DD29884AF92B9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized String generateTag() {
        String varA5D27D9E6A00942053FDC816D4FEEBCB_1674574759 = (Integer.toHexString(rand.nextInt()));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return Integer.toHexString(rand.nextInt());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.342 -0400", hash_original_method = "7AE3A829A02A70B14E30FF17666004A8", hash_generated_method = "54490AA5BCBD7C22A05062690A205A37")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized String generateBranchId() {
        long num;
        num = rand.nextLong() + Utils.counter++  + System.currentTimeMillis();
        byte bid[];
        bid = digester.digest(Long.toString(num).getBytes());
        String var6718D31AD60378E536ED51C77A33AB0E_846345417 = (SIPConstants.BRANCH_MAGIC_COOKIE + Utils.toHexString(bid) + this.signature);
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //long num = rand.nextLong() + Utils.counter++  + System.currentTimeMillis();
        //byte bid[] = digester.digest(Long.toString(num).getBytes());
        //return SIPConstants.BRANCH_MAGIC_COOKIE + Utils.toHexString(bid) + this.signature;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.342 -0400", hash_original_method = "C81ECDD34C7D54B91D88A9F561BC20EF", hash_generated_method = "AF3F2080681ECDD5BDAFD8D32E3D289E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean responseBelongsToUs(SIPResponse response) {
        dsTaint.addTaint(response.dsTaint);
        Via topmostVia;
        topmostVia = response.getTopmostVia();
        String branch;
        branch = topmostVia.getBranch();
        boolean varCEB2BE90E0E559CE062D36543E0ECFB4_214752500 = (branch != null && branch.endsWith(this.signature));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Via topmostVia = response.getTopmostVia();
        //String branch = topmostVia.getBranch();
        //return branch != null && branch.endsWith(this.signature);
    }

    
        public static String getSignature() {
        return signature;
    }

    
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

    
    private static MessageDigest digester;
    private static java.util.Random rand;
    private static long counter = 0;
    private static int callIDCounter;
    private static String signature ;
    private static Utils instance = new Utils();
    private static final char[] toHex = { '0', '1', '2', '3', '4', '5', '6',
            '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
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

