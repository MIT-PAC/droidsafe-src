package org.apache.harmony.security.x501;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.IOException;
import org.apache.harmony.security.asn1.ASN1StringType;
import org.apache.harmony.security.asn1.DerInputStream;

public final class AttributeValue {
    public final boolean wasEncoded;
    public String escapedString;
    private String hexString;
    private int tag = -1;
    public byte[] encoded;
    public byte[] bytes;
    public boolean hasQE;
    public String rawString;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.854 -0400", hash_original_method = "A5E243B4900F23BDC01508FC8D249E26", hash_generated_method = "33D39E77C142FF15779A4394A09B4B7D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AttributeValue(String parsedString, boolean hasQorE) {
        dsTaint.addTaint(parsedString);
        dsTaint.addTaint(hasQorE);
        wasEncoded = false;
        this.escapedString = makeEscaped(rawString);
        // ---------- Original Method ----------
        //wasEncoded = false;
        //this.hasQE = hasQorE;
        //this.rawString = parsedString;
        //this.escapedString = makeEscaped(rawString);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.854 -0400", hash_original_method = "5A85F043C6F0B70EF97E2EBE9C6D742A", hash_generated_method = "371DEC81E2C6ACDFC7B474D3C82D643D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AttributeValue(String hexString, byte[] encoded) {
        dsTaint.addTaint(hexString);
        dsTaint.addTaint(encoded);
        wasEncoded = true;
        try 
        {
            DerInputStream in;
            in = new DerInputStream(encoded);
            tag = in.tag;
            {
                boolean var7466733B22F4332843ED3830B816DED5_141766103 = (DirectoryString.ASN1.checkTag(tag));
                {
                    this.rawString = (String) DirectoryString.ASN1.decode(in);
                    this.escapedString = makeEscaped(rawString);
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (IOException e)
        {
            IllegalArgumentException iae;
            iae = new IllegalArgumentException();
            iae.initCause(e);
            throw iae;
        } //End block
        // ---------- Original Method ----------
        //wasEncoded = true;
        //this.hexString = hexString;
        //this.encoded = encoded;
        //try {
            //DerInputStream in = new DerInputStream(encoded);
            //tag = in.tag;
            //if (DirectoryString.ASN1.checkTag(tag)) {
                //this.rawString = (String) DirectoryString.ASN1.decode(in);
                //this.escapedString = makeEscaped(rawString);
            //} else {
                //this.rawString = hexString;
                //this.escapedString = hexString;
            //}
        //} catch (IOException e) {
            //IllegalArgumentException iae = new IllegalArgumentException(); 
            //iae.initCause(e);
            //throw iae;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.855 -0400", hash_original_method = "B45EBCED75AEC87D8B9060BD1DB130BC", hash_generated_method = "75A9C1E026A7DFAA396F606DFA40BB29")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AttributeValue(String rawString, byte[] encoded, int tag) {
        dsTaint.addTaint(rawString);
        dsTaint.addTaint(tag);
        dsTaint.addTaint(encoded);
        wasEncoded = true;
        {
            this.rawString = getHexString();
            this.escapedString = hexString;
        } //End block
        {
            this.escapedString = makeEscaped(rawString);
        } //End block
        // ---------- Original Method ----------
        //wasEncoded = true;
        //this.encoded = encoded;
        //this.tag = tag;
        //if (rawString == null) {
            //this.rawString = getHexString();
            //this.escapedString = hexString;
        //} else {
            //this.rawString = rawString;
            //this.escapedString = makeEscaped(rawString);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.855 -0400", hash_original_method = "0119351D8B397CC03524377768328668", hash_generated_method = "F734B1537574F8DC4EDF09D43AB75EF2")
    private static boolean isPrintableString(String str) {
        for (int i = 0; i< str.length(); ++i) {
            char ch = str.charAt(i);
            if (!(ch == 0x20
            || ch >= 0x27 && ch<= 0x29 
            || ch >= 0x2B && ch<= 0x3A 
            || ch == '='
            || ch == '?'
            || ch >= 'A' && ch<= 'Z'
            || ch >= 'a' && ch<= 'z')) {
                return false;
            }
        }
        return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.855 -0400", hash_original_method = "01F8BD1A541A09C15BC5DA5B1F02995A", hash_generated_method = "49C2B11CF3324E233EAB3E50EA122AC0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getTag() {
        {
            tag = isPrintableString(rawString)
                    ? ASN1StringType.PRINTABLESTRING.id
                    : ASN1StringType.UTF8STRING.id;
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (tag == -1) {
            //tag = isPrintableString(rawString)
                    //? ASN1StringType.PRINTABLESTRING.id
                    //: ASN1StringType.UTF8STRING.id;
        //}
        //return tag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.855 -0400", hash_original_method = "2B88DEF802689DAD6E450E66D9E740A5", hash_generated_method = "9E55EF504416636AC2142D699EF8D0EE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getHexString() {
        {
            {
                encoded = isPrintableString(rawString)
                        ? ASN1StringType.PRINTABLESTRING.encode(rawString)
                        : ASN1StringType.UTF8STRING.encode(rawString);
            } //End block
            StringBuilder buf;
            buf = new StringBuilder(encoded.length * 2 + 1);
            buf.append('#');
            {
                int i, c;
                i = 0;
                {
                    c = (encoded[i] >> 4) & 0x0F;
                    {
                        buf.append((char) (c + 48));
                    } //End block
                    {
                        buf.append((char) (c + 87));
                    } //End block
                    c = encoded[i] & 0x0F;
                    {
                        buf.append((char) (c + 48));
                    } //End block
                    {
                        buf.append((char) (c + 87));
                    } //End block
                } //End block
            } //End collapsed parenthetic
            hexString = buf.toString();
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.855 -0400", hash_original_method = "8E668EEB627F91F8E1893DDB676A8040", hash_generated_method = "118D4C4A8739780968A343F45461222D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void appendQEString(StringBuilder sb) {
        dsTaint.addTaint(sb.dsTaint);
        sb.append('"');
        {
            char c;
            {
                int i;
                i = 0;
                boolean var489536AE5EACF56C867BD0460A2CDE53_1477038245 = (i < rawString.length());
                {
                    c = rawString.charAt(i);
                    {
                        sb.append('\\');
                    } //End block
                    sb.append(c);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            sb.append(rawString);
        } //End block
        sb.append('"');
        // ---------- Original Method ----------
        //sb.append('"');
        //if (hasQE) {
            //char c;
            //for (int i = 0; i < rawString.length(); i++) {
                //c = rawString.charAt(i);
                //if (c == '"' || c == '\\') {
                    //sb.append('\\');
                //}
                //sb.append(c);
            //}
        //} else {
            //sb.append(rawString);
        //}
        //sb.append('"');
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.855 -0400", hash_original_method = "63614CD0FCED93BBCAC192EC682E4A51", hash_generated_method = "D074BBDADED2A5545AD4AB19927C4A55")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String makeEscaped(String name) {
        dsTaint.addTaint(name);
        int length;
        length = name.length();
        StringBuilder buf;
        buf = new StringBuilder(length * 2);
        {
            int index;
            index = 0;
            {
                char ch;
                ch = name.charAt(index);
                //Begin case ' ' 
                {
                    buf.append('\\');
                } //End block
                //End case ' ' 
                //Begin case ' ' 
                buf.append(' ');
                //End case ' ' 
                //Begin case '"' '\\' 
                hasQE = true;
                //End case '"' '\\' 
                //Begin case '"' '\\' 
                buf.append('\\');
                //End case '"' '\\' 
                //Begin case '"' '\\' 
                buf.append(ch);
                //End case '"' '\\' 
                //Begin case ',' '+' '<' '>' ';' '#' '=' 
                buf.append('\\');
                //End case ',' '+' '<' '>' ';' '#' '=' 
                //Begin case ',' '+' '<' '>' ';' '#' '=' 
                buf.append(ch);
                //End case ',' '+' '<' '>' ';' '#' '=' 
                //Begin case default 
                buf.append(ch);
                //End case default 
            } //End block
        } //End collapsed parenthetic
        String var0C174602EFE4BFBCB80A7056CFA680FB_1377497917 = (buf.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.856 -0400", hash_original_method = "2CE0F91F50A3484CAFB1D45D122355E5", hash_generated_method = "E20A17F5E8581E90B5540576E03DDF46")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String makeCanonical() {
        int length;
        length = rawString.length();
        StringBuilder buf;
        buf = new StringBuilder(length * 2);
        int index;
        index = 0;
        {
            boolean varF48C85942000814A2A20728333117321_306020175 = (rawString.charAt(0) == '#');
            {
                buf.append('\\');
                buf.append('#');
                index++;
            } //End block
        } //End collapsed parenthetic
        int bufLength;
        {
            char ch;
            ch = rawString.charAt(index);
            //Begin case ' ' 
            bufLength = buf.length();
            //End case ' ' 
            //Begin case ' ' 
            {
                boolean var76068870855D73C60B790CBF930511C6_1775407947 = (bufLength == 0 || buf.charAt(bufLength - 1) == ' ');
            } //End collapsed parenthetic
            //End case ' ' 
            //Begin case ' ' 
            buf.append(' ');
            //End case ' ' 
            //Begin case '"' '\\' ',' '+' '<' '>' ';' 
            buf.append('\\');
            //End case '"' '\\' ',' '+' '<' '>' ';' 
            //Begin case default 
            buf.append(ch);
            //End case default 
        } //End block
        {
            bufLength = buf.length() - 1;
            boolean varF07DB73BE4727375CF1F8671293E732D_894699051 = (bufLength > -1
                && buf.charAt(bufLength) == ' ');
        } //End collapsed parenthetic
        buf.setLength(bufLength + 1);
        String var0C174602EFE4BFBCB80A7056CFA680FB_1220047524 = (buf.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}


