package org.apache.commons.io.input;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.DataInput;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.EndianUtils;

public class SwappedDataInputStream extends ProxyInputStream implements DataInput {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.026 -0400", hash_original_method = "C54F0CC2DA015E75B52724488AA233EF", hash_generated_method = "3EB18BB8436A2503A4C57E0CC19ACB3E")
    public  SwappedDataInputStream( InputStream input ) {
        super( input );
        addTaint(input.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.031 -0400", hash_original_method = "C6E52C66D7D123E3533290F6D5AFC7C2", hash_generated_method = "D84E1150A14B410A5C3232E960E51B00")
    public boolean readBoolean() throws IOException, EOFException {
        boolean varF2CBA2B00FE4FC431BEE75B5CFED5BCB_150242403 = (0 != readByte());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_735465726 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_735465726;
        // ---------- Original Method ----------
        //return 0 != readByte();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.032 -0400", hash_original_method = "29D7601B80549C4B9C567F426A16BACB", hash_generated_method = "516E1CB11FC8434F389F691AB72B5E30")
    public byte readByte() throws IOException, EOFException {
        byte var5F236C33FCC114BD0F9DB969A1D965D9_768659384 = ((byte)in.read());
        byte var40EA57D3EE3C07BF1C102B466E1C3091_600174264 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_600174264;
        // ---------- Original Method ----------
        //return (byte)in.read();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.032 -0400", hash_original_method = "8E7A427A98E0CBF45D66268DB7B1B5CD", hash_generated_method = "7AD38B92522198EDC1DC2FB425BB87B0")
    public char readChar() throws IOException, EOFException {
        char var99918E5210D621682357E07F116991D9_986395763 = ((char)readShort());
        char varA87DEB01C5F539E6BDA34829C8EF2368_2133286363 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_2133286363;
        // ---------- Original Method ----------
        //return (char)readShort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.032 -0400", hash_original_method = "E0B187CE0A555FF37672F5C84109272C", hash_generated_method = "6706236EF4C7D4AEB8DFCA59DC053690")
    public double readDouble() throws IOException, EOFException {
        double var1BF8A5F657980106C536F2DEB01C3B00_874283911 = (EndianUtils.readSwappedDouble( in ));
        double varE8CD7DA078A86726031AD64F35F5A6C0_1006735868 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1006735868;
        // ---------- Original Method ----------
        //return EndianUtils.readSwappedDouble( in );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.033 -0400", hash_original_method = "2E4D15B0B4A0FBF0E7EA1877C828CDC6", hash_generated_method = "00BDCEBAEF95A969584236D34D3B3995")
    public float readFloat() throws IOException, EOFException {
        float var45CDDA7D52100C03B3ADF12D8EF5B2A3_359386589 = (EndianUtils.readSwappedFloat( in ));
        float var546ADE640B6EDFBC8A086EF31347E768_2060663113 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_2060663113;
        // ---------- Original Method ----------
        //return EndianUtils.readSwappedFloat( in );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.036 -0400", hash_original_method = "BDF1FFA031B8E898D91BB8F353BF6070", hash_generated_method = "CCCD885E4521A8587577EA91A22A65C8")
    public void readFully( byte[] data ) throws IOException, EOFException {
        readFully( data, 0, data.length );
        addTaint(data[0]);
        // ---------- Original Method ----------
        //readFully( data, 0, data.length );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.037 -0400", hash_original_method = "C68A979C97C9773BF4E1D97780D466BC", hash_generated_method = "0E0782B3B6277CFC705873A3D53D9EF9")
    public void readFully( byte[] data, int offset, int length ) throws IOException, EOFException {
        int remaining;
        remaining = length;
        {
            int location;
            location = offset + length - remaining;
            int count;
            count = read( data, location, remaining );
            {
                if (DroidSafeAndroidRuntime.control) throw new EOFException();
            } //End block
            remaining -= count;
        } //End block
        addTaint(data[0]);
        addTaint(offset);
        addTaint(length);
        // ---------- Original Method ----------
        //int remaining = length;
        //while( remaining > 0 )
        //{
            //int location = offset + length - remaining;
            //int count = read( data, location, remaining );
            //if( -1 == count )
            //{
                //throw new EOFException();
            //}
            //remaining -= count;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.037 -0400", hash_original_method = "924D53EB92B2DC5D270610CAC14BB6FD", hash_generated_method = "A8028C1F274FC3740C143D3490A62933")
    public int readInt() throws IOException, EOFException {
        int var2A3415A3F153855EF1653676E44E0021_1114304122 = (EndianUtils.readSwappedInteger( in ));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1052983129 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1052983129;
        // ---------- Original Method ----------
        //return EndianUtils.readSwappedInteger( in );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.048 -0400", hash_original_method = "6DEA886173F95E4A3BBF989737ED1DB7", hash_generated_method = "A5A8230175403CA21B4629620A3774EA")
    public String readLine() throws IOException, EOFException {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException( 
                "Operation not supported: readLine()" );
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException( 
                //"Operation not supported: readLine()" );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.048 -0400", hash_original_method = "CC507B2A57FF0027D07E24F5AD4CD5D0", hash_generated_method = "601CE9509E204665020448418C87803F")
    public long readLong() throws IOException, EOFException {
        long var733D75A960E8845CFFAD8F488194623A_1841158998 = (EndianUtils.readSwappedLong( in ));
        long var0F5264038205EDFB1AC05FBB0E8C5E94_342368514 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_342368514;
        // ---------- Original Method ----------
        //return EndianUtils.readSwappedLong( in );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.048 -0400", hash_original_method = "147194CFB85434C80763957452B45FC6", hash_generated_method = "BD7A6447B7175B39A4ECC386C8B867A1")
    public short readShort() throws IOException, EOFException {
        short var7C90D403D8B523CE675BC876D9FF4F0F_1079069210 = (EndianUtils.readSwappedShort( in ));
        short var4F09DAA9D95BCB166A302407A0E0BABE_1151277289 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1151277289;
        // ---------- Original Method ----------
        //return EndianUtils.readSwappedShort( in );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.052 -0400", hash_original_method = "712AFF9E606E487D08D6F6FFCD673798", hash_generated_method = "C07BA37269166255A5E97C0457160ACF")
    public int readUnsignedByte() throws IOException, EOFException {
        int var2EE2703F88097027B4DEA42C13801E06_154586613 = (in.read());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_136620434 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_136620434;
        // ---------- Original Method ----------
        //return in.read();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.053 -0400", hash_original_method = "447E5EB8854335FBF10C9BDB3B1A51D4", hash_generated_method = "F04830CD1CA3E155D8AC37AD7CFFC25A")
    public int readUnsignedShort() throws IOException, EOFException {
        int varE15133F9792610DE313735F41BF73A47_559488066 = (EndianUtils.readSwappedUnsignedShort( in ));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_734398038 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_734398038;
        // ---------- Original Method ----------
        //return EndianUtils.readSwappedUnsignedShort( in );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.066 -0400", hash_original_method = "DF617DE965D7ED4B9960FC14A4BE0BB9", hash_generated_method = "FB723ABED2E5C65C87E259FD96FC5F29")
    public String readUTF() throws IOException, EOFException {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException( 
                "Operation not supported: readUTF()" );
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException( 
                //"Operation not supported: readUTF()" );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.067 -0400", hash_original_method = "F2ACC4611C0738057C364BC3F2D0ADCF", hash_generated_method = "AF9884A8B785D738CF7F4D51B2E2CE47")
    public int skipBytes( int count ) throws IOException, EOFException {
        int varE9B0B123987EFF0440782CEBF783100D_1994215400 = ((int)in.skip( count ));
        addTaint(count);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1571934993 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1571934993;
        // ---------- Original Method ----------
        //return (int)in.skip( count );
    }

    
}

