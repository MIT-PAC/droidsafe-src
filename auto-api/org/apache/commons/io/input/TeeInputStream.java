package org.apache.commons.io.input;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TeeInputStream extends ProxyInputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.059 -0400", hash_original_field = "9603A224B40D7B67210B78F2E390D00F", hash_generated_field = "164ADC33B65EBBC2FB8F6BCF766DF944")

    private OutputStream branch;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.059 -0400", hash_original_field = "000A85DE32C8AB3B4EA056CFC921487F", hash_generated_field = "5364FDC39A5D908CFAA7DC7A7FAE9382")

    private boolean closeBranch;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.060 -0400", hash_original_method = "DAFFFEC0A2F1C3FC2568CE035A699270", hash_generated_method = "8F896923D026714E3C4CD4CC33202E17")
    public  TeeInputStream(InputStream input, OutputStream branch) {
        this(input, branch, false);
        addTaint(input.getTaint());
        addTaint(branch.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.060 -0400", hash_original_method = "D520336E920C0FCB03E0DA6241BF85F5", hash_generated_method = "08B004931CF889CE3216ABADCDE02B91")
    public  TeeInputStream(
            InputStream input, OutputStream branch, boolean closeBranch) {
        super(input);
        this.branch = branch;
        this.closeBranch = closeBranch;
        addTaint(input.getTaint());
        // ---------- Original Method ----------
        //this.branch = branch;
        //this.closeBranch = closeBranch;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.061 -0400", hash_original_method = "D498A8731A99C06BAF1ACCF96CD0CEC8", hash_generated_method = "8CFAD53C0133BD0CF13215A2D7B6C37F")
    @Override
    public void close() throws IOException {
        try 
        {
            super.close();
        } //End block
        finally 
        {
            {
                branch.close();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //try {
            //super.close();
        //} finally {
            //if (closeBranch) {
                //branch.close();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.062 -0400", hash_original_method = "CF82A12C742F079DEF5ED86F8D9B664D", hash_generated_method = "8A5E9F8F084556B65A320D7FC4F59CA3")
    @Override
    public int read() throws IOException {
        int ch;
        ch = super.read();
        {
            branch.write(ch);
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1969609131 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1969609131;
        // ---------- Original Method ----------
        //int ch = super.read();
        //if (ch != -1) {
            //branch.write(ch);
        //}
        //return ch;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.062 -0400", hash_original_method = "BF6CBA9653E90970E99199ACD6FE8DC4", hash_generated_method = "D0F4DAE2E16C0AD2699D7D4178826312")
    @Override
    public int read(byte[] bts, int st, int end) throws IOException {
        int n;
        n = super.read(bts, st, end);
        {
            branch.write(bts, st, n);
        } //End block
        addTaint(bts[0]);
        addTaint(st);
        addTaint(end);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2058093872 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2058093872;
        // ---------- Original Method ----------
        //int n = super.read(bts, st, end);
        //if (n != -1) {
            //branch.write(bts, st, n);
        //}
        //return n;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.062 -0400", hash_original_method = "C8E3227EF2C47EB9F6C9D577624742C0", hash_generated_method = "61003A8FB59D690D1B89D2D84C295543")
    @Override
    public int read(byte[] bts) throws IOException {
        int n;
        n = super.read(bts);
        {
            branch.write(bts, 0, n);
        } //End block
        addTaint(bts[0]);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_794772033 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_794772033;
        // ---------- Original Method ----------
        //int n = super.read(bts);
        //if (n != -1) {
            //branch.write(bts, 0, n);
        //}
        //return n;
    }

    
}

