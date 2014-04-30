package org.bouncycastle.asn1.x509;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DEREncodable;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERSet;
import org.bouncycastle.asn1.DERString;
import org.bouncycastle.asn1.DERUniversalString;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.encoders.Hex;

public class X509Name extends ASN1Encodable {

    /**
     * Return a X509Name based on the passed in tagged object.
     * 
     * @param obj tag object holding name.
     * @param explicit true if explicitly tagged false otherwise.
     * @return the X509Name
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.897 -0500", hash_original_method = "35717B5D44D40B15BC305384A515B852", hash_generated_method = "95406EE1261899B50CBD9CB2E395A509")
    
public static X509Name getInstance(
        ASN1TaggedObject obj,
        boolean          explicit)
    {
        return getInstance(ASN1Sequence.getInstance(obj, explicit));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.899 -0500", hash_original_method = "48285B3BE307C3DF1D7E2E269123DFE3", hash_generated_method = "6B86B0BE37D36155AC11623678B6E32F")
    
public static X509Name getInstance(
        Object  obj)
    {
        if (obj == null || obj instanceof X509Name)
        {
            return (X509Name)obj;
        }
        else if (obj instanceof X500Name)
        {
            return new X509Name(ASN1Sequence.getInstance(((X500Name)obj).getDERObject()));
        }
        else if (obj != null)
        {
            return new X509Name(ASN1Sequence.getInstance(obj));
        }

        return null;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.768 -0500", hash_original_field = "AC43C952E106CFD7F964E16593B15917", hash_generated_field = "82D687239E3C86279A9A387C3E8AE15F")

    public static final DERObjectIdentifier C = new DERObjectIdentifier("2.5.4.6");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.771 -0500", hash_original_field = "FDDED9CA16A440BADDF82743028CFDF5", hash_generated_field = "9A0BCC4B2444A7BF0405630803C2F2D0")

    public static final DERObjectIdentifier O = new DERObjectIdentifier("2.5.4.10");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.774 -0500", hash_original_field = "8D088347DE678410C2C4659D9E7F69F4", hash_generated_field = "6326280D591C30719B3DB5C13338F0A3")

    public static final DERObjectIdentifier OU = new DERObjectIdentifier("2.5.4.11");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.776 -0500", hash_original_field = "6E31D186555B147C5C13BE685C0ED00C", hash_generated_field = "E8B45184A7115EE6111EDB1B37A68019")

    public static final DERObjectIdentifier T = new DERObjectIdentifier("2.5.4.12");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.779 -0500", hash_original_field = "7CBBBC6FA98F82D006AC1C3CEBD357A8", hash_generated_field = "CF9435847FFC6C3C7927992F9EE3FAFF")

    public static final DERObjectIdentifier CN = new DERObjectIdentifier("2.5.4.3");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.781 -0500", hash_original_field = "78CAFEE0257AB794C6021C33D0C258DC", hash_generated_field = "1C5FE81E2DBFFB02A7D19673EC4A90E2")

    public static final DERObjectIdentifier SN = new DERObjectIdentifier("2.5.4.5");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.783 -0500", hash_original_field = "6C28EFC044ABF6316678E6C3502849E7", hash_generated_field = "2F85801FBF51C8EE5695ECB3E05715B4")

    public static final DERObjectIdentifier STREET = new DERObjectIdentifier("2.5.4.9");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.786 -0500", hash_original_field = "D284015078C9FE4C22D3CC2C97D9914E", hash_generated_field = "BDDAF789362E72D2FF3111AE8E110F7A")

    public static final DERObjectIdentifier SERIALNUMBER = SN;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.788 -0500", hash_original_field = "A00E2F3F6341370BDDDFDCCCCBB14F51", hash_generated_field = "CBB2A0091E475910A1B9F56755855304")

    public static final DERObjectIdentifier L = new DERObjectIdentifier("2.5.4.7");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.791 -0500", hash_original_field = "6B1B2A615D04B83D8E2D786231B08734", hash_generated_field = "FA86D310F2857FB8F860635B33CDE85B")

    public static final DERObjectIdentifier ST = new DERObjectIdentifier("2.5.4.8");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.794 -0500", hash_original_field = "9E5210CF50E0ACD198AAE2B8B5C76D0C", hash_generated_field = "59FFCD55B0D0B45F483BC2293E395377")

    public static final DERObjectIdentifier SURNAME = new DERObjectIdentifier("2.5.4.4");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.796 -0500", hash_original_field = "1BB8F42BE8272C131965F4476D448078", hash_generated_field = "E97C7C5B7041A426BC30CC1454C5DBF7")

    public static final DERObjectIdentifier GIVENNAME = new DERObjectIdentifier("2.5.4.42");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.799 -0500", hash_original_field = "868A98DFC8291023040AD2693FABC4E2", hash_generated_field = "A5FD4B35D111D951F8765946D5A83284")

    public static final DERObjectIdentifier INITIALS = new DERObjectIdentifier("2.5.4.43");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.801 -0500", hash_original_field = "3121D94201EBFF735BEA4326E520CC24", hash_generated_field = "533BDABA5EA8217D595157FA1EE80ABF")

    public static final DERObjectIdentifier GENERATION = new DERObjectIdentifier("2.5.4.44");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.804 -0500", hash_original_field = "4D6B68FAD518E0281F3F27A0713BDB6D", hash_generated_field = "4F43AC9282AD9798244BC73AEDAA5A8D")

    public static final DERObjectIdentifier UNIQUE_IDENTIFIER = new DERObjectIdentifier("2.5.4.45");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.807 -0500", hash_original_field = "AD0FC11A41EC275AB549DD7964A240B1", hash_generated_field = "B855455F4EDB294C798C9D3C9026BF51")

    public static final DERObjectIdentifier BUSINESS_CATEGORY = new DERObjectIdentifier(
                    "2.5.4.15");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.809 -0500", hash_original_field = "738BF07F1B7B3E4D4E9A6F8708625BDE", hash_generated_field = "AFCF615F7F4AD23472ADBFCF9493AE20")

    public static final DERObjectIdentifier POSTAL_CODE = new DERObjectIdentifier(
                    "2.5.4.17");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.812 -0500", hash_original_field = "768FBD571C177EED83315C564FD135E5", hash_generated_field = "3BEB0664EEAAC66C4E6B3507A541A961")

    public static final DERObjectIdentifier DN_QUALIFIER = new DERObjectIdentifier(
                    "2.5.4.46");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.814 -0500", hash_original_field = "692BFD9E5BEED93D3C8DDCF285E53E6F", hash_generated_field = "8BDA30822F069D0EF535FB88FF8A1F36")

    public static final DERObjectIdentifier PSEUDONYM = new DERObjectIdentifier(
                    "2.5.4.65");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.817 -0500", hash_original_field = "AB843B3B41951FDE3F0B407B2A612E8E", hash_generated_field = "9420DBC6483B34D87C2038353B444C41")

    public static final DERObjectIdentifier DATE_OF_BIRTH = new DERObjectIdentifier(
                    "1.3.6.1.5.5.7.9.1");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.819 -0500", hash_original_field = "E31B74347ED6B9DAFEEE3FDC7A6FD5D3", hash_generated_field = "DD23A595DF652DF1A4A46D9CF34396D1")

    public static final DERObjectIdentifier PLACE_OF_BIRTH = new DERObjectIdentifier(
                    "1.3.6.1.5.5.7.9.2");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.822 -0500", hash_original_field = "8FD528DD146BF5E6980947A67BB732EE", hash_generated_field = "653665F25666ED2418201CB7491A2E83")

    public static final DERObjectIdentifier GENDER = new DERObjectIdentifier(
                    "1.3.6.1.5.5.7.9.3");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.824 -0500", hash_original_field = "3E6A15C3DBFD631D10CAC1E0B3CD4C9D", hash_generated_field = "60C31DC383F5B2CBA146E21EF7DBE62C")

    public static final DERObjectIdentifier COUNTRY_OF_CITIZENSHIP = new DERObjectIdentifier(
                    "1.3.6.1.5.5.7.9.4");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.827 -0500", hash_original_field = "8E8F94E57C95E02D32A483C187B2E0A0", hash_generated_field = "298A701F0CC84796B2E4DA6C024B48DE")

    public static final DERObjectIdentifier COUNTRY_OF_RESIDENCE = new DERObjectIdentifier(
                    "1.3.6.1.5.5.7.9.5");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.829 -0500", hash_original_field = "77D35207023305A12D6FCB1221141DA6", hash_generated_field = "543131AACA3F47053FDEC53A1C384306")

    public static final DERObjectIdentifier NAME_AT_BIRTH =  new DERObjectIdentifier("1.3.36.8.3.14");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.831 -0500", hash_original_field = "C892E218C458E4D5433134662755C17F", hash_generated_field = "587BAD00A55BF518298D870F21FA8435")

    public static final DERObjectIdentifier POSTAL_ADDRESS = new DERObjectIdentifier("2.5.4.16");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.834 -0500", hash_original_field = "6FE626B521B4AAC85AEA0A402A79AA98", hash_generated_field = "EFCF83D1673ED3AA566EA2CBA7E1FCE8")

    public static final DERObjectIdentifier DMD_NAME = new DERObjectIdentifier("2.5.4.54");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.837 -0500", hash_original_field = "8DA62222BE5ABB5D41D75AECFE738C8A", hash_generated_field = "9E94AA66AACE8B4A0BE080CCD0FAC70F")

    public static final DERObjectIdentifier TELEPHONE_NUMBER = X509ObjectIdentifiers.id_at_telephoneNumber;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.840 -0500", hash_original_field = "F4E9AD83FB9FA1AC2DAC854510EEF810", hash_generated_field = "FFAD4425897D716BCD593C09C46AFD73")

    public static final DERObjectIdentifier NAME = X509ObjectIdentifiers.id_at_name;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.843 -0500", hash_original_field = "7A52801220B5B641D1C3965842F88193", hash_generated_field = "584A7AECA4B0ACA0DBBC90E0BD7C9332")

    public static final DERObjectIdentifier EmailAddress = PKCSObjectIdentifiers.pkcs_9_at_emailAddress;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.845 -0500", hash_original_field = "A25D3A9F838B0783AC81B66E39A852BE", hash_generated_field = "CCAA56F97463C5118260AD6DD1DDC80F")

    public static final DERObjectIdentifier UnstructuredName = PKCSObjectIdentifiers.pkcs_9_at_unstructuredName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.848 -0500", hash_original_field = "895770A4CBCA274AC674A78BCE0FB03C", hash_generated_field = "342508E8CA88924FDFDA1D381AFD3338")

    public static final DERObjectIdentifier UnstructuredAddress = PKCSObjectIdentifiers.pkcs_9_at_unstructuredAddress;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.850 -0500", hash_original_field = "A6687F29245D3E2FC23B9E8AFB5C8BBF", hash_generated_field = "021E5BC1569FD92F01DB6A01724523C2")

    public static final DERObjectIdentifier E = EmailAddress;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.853 -0500", hash_original_field = "866FA73658D1416F11983C47F692BC40", hash_generated_field = "1334C446DFB8D545DC3107A020531330")

    public static final DERObjectIdentifier DC = new DERObjectIdentifier("0.9.2342.19200300.100.1.25");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.855 -0500", hash_original_field = "743CAEB97E7D363A5238FD78BCE894F5", hash_generated_field = "E4CD602AF9770F8D3B9404D5F2532570")

    public static final DERObjectIdentifier UID = new DERObjectIdentifier("0.9.2342.19200300.100.1.1");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.857 -0500", hash_original_field = "0D67DF502A72844A0964BC1D0556CF02", hash_generated_field = "BB46BFBE07BCC7526C461E59C789AB8E")

    public static boolean DefaultReverse = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.860 -0500", hash_original_field = "BB36420B0085FE57C4931038638024E1", hash_generated_field = "158D1B2B36F24863D1B8E7C3B9D7F7A2")

    public static final Hashtable DefaultSymbols = new Hashtable();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.863 -0500", hash_original_field = "2432E3E061948F72A55E387668E5BCF8", hash_generated_field = "C9354DE849CFE049572C4221C51E7309")

    public static final Hashtable RFC2253Symbols = new Hashtable();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.865 -0500", hash_original_field = "89FDAC41F8450B8A51C2C7B094C0B651", hash_generated_field = "10F89287F10A6638EB4EE375195390E2")

    public static final Hashtable RFC1779Symbols = new Hashtable();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.868 -0500", hash_original_field = "6A9B8BA2687E2B038C6E773AEF73F5D5", hash_generated_field = "9EEF14EBA4A5D75E5091872B5F8BAEFC")

    public static final Hashtable DefaultLookUp = new Hashtable();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.870 -0500", hash_original_field = "AAF24ECDD294C1626FFC3EDAE8C51F4C", hash_generated_field = "914593EB818CF28AF7D26BC6344231F7")

    public static final Hashtable OIDLookUp = DefaultSymbols;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.872 -0500", hash_original_field = "90B5DE8F2CE0353CE1B72C7F34419119", hash_generated_field = "777E54E742DACB0C5BCAD8347B24CD80")

    public static final Hashtable SymbolLookUp = DefaultLookUp;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.875 -0500", hash_original_field = "4C49049C10203D323EC00B264E2B128E", hash_generated_field = "D283B4A736D2AC5091CFA69743A46FDD")

    private static final Boolean TRUE = Boolean.TRUE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.877 -0500", hash_original_field = "A97F87E7EEC56616A0D5FA3208AED11B", hash_generated_field = "0C266C5D45C3B38D3B96B825C1C5DA0B")

    private static final Boolean FALSE = Boolean.FALSE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.881 -0500", hash_original_field = "4991E2934223DCC25A5EF9D9C72EA338", hash_generated_field = "9B1A952CEBF3178959A402DABEDC0A6B")

    private X509NameEntryConverter  converter = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.884 -0500", hash_original_field = "8370039E4421170D8B7341A1E9105E8E", hash_generated_field = "C8A65116741473EAA58816E75213B0AF")

    private Vector                  ordering = new Vector();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.886 -0500", hash_original_field = "D5F4258DC93AB73236ACC763C6FC18B8", hash_generated_field = "F7859DDEE63780863860095D2E4D0AB7")

    private Vector                  values = new Vector();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.888 -0500", hash_original_field = "A77CAF43271092CCE53A1C59B522B483", hash_generated_field = "93EE51D59E70850C8E38EBF0508102EE")

    private Vector                  added = new Vector();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.890 -0500", hash_original_field = "67B66723C4558F27E19029159A09253A", hash_generated_field = "37E06257AFCE21CC4EDFE67F34DC271C")

    private ASN1Sequence            seq;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.892 -0500", hash_original_field = "B6293280C3B6F91ED7F24C3952096C1C", hash_generated_field = "FFD3E18FB59EA084D3FD8E8945E2AACA")

    private boolean                 isHashCodeCalculated;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.895 -0500", hash_original_field = "2D42E71DE4D8857610CF43708417333A", hash_generated_field = "D4D90810E0E6D99534BB2E8797B7FFA9")

    private int                     hashCodeValue;

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.902 -0500", hash_original_method = "E0A402814C87C5337199B2B0EDD62792", hash_generated_method = "4C8C3C7FF82B27C841BA9074162C5C32")
    
protected X509Name()
    {
        // constructure use by new X500 Name class
    }
    /**
     * Constructor from ASN1Sequence
     *
     * the principal will be a list of constructed sets, each containing an (OID, String) pair.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.905 -0500", hash_original_method = "88A842BBAF40DA82D57137327D6884BA", hash_generated_method = "84F6C70CA1BEF05ED67A3F94D642FC68")
    
public X509Name(
        ASN1Sequence  seq)
    {
        this.seq = seq;

        Enumeration e = seq.getObjects();

        while (e.hasMoreElements())
        {
            ASN1Set         set = ASN1Set.getInstance(((DEREncodable)e.nextElement()).getDERObject());

            for (int i = 0; i < set.size(); i++) 
            {
                   ASN1Sequence s = ASN1Sequence.getInstance(set.getObjectAt(i));

                   if (s.size() != 2)
                   {
                       throw new IllegalArgumentException("badly sized pair");
                   }

                   ordering.addElement(DERObjectIdentifier.getInstance(s.getObjectAt(0)));
                   
                   DEREncodable value = s.getObjectAt(1);
                   if (value instanceof DERString && !(value instanceof DERUniversalString))
                   {
                       String v = ((DERString)value).getString();
                       if (v.length() > 0 && v.charAt(0) == '#')
                       {
                           values.addElement("\\" + v);
                       }
                       else
                       {
                           values.addElement(v);
                       }
                   }
                   else
                   {
                       values.addElement("#" + bytesToString(Hex.encode(value.getDERObject().getDEREncoded())));
                   }
                   // BEGIN android-changed
                   added.addElement(Boolean.valueOf(i != 0));
                   // END android-changed
            }
        }
    }

    /**
     * constructor from a table of attributes.
     * <p>
     * it's is assumed the table contains OID/String pairs, and the contents
     * of the table are copied into an internal table as part of the
     * construction process.
     * <p>
     * <b>Note:</b> if the name you are trying to generate should be
     * following a specific ordering, you should use the constructor
     * with the ordering specified below.
     * @deprecated use an ordered constructor! The hashtable ordering is rarely correct
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.908 -0500", hash_original_method = "E338E099196C520643EABA462B148868", hash_generated_method = "AE21EDE54C7ECC7ED02380890890761E")
    
public X509Name(
        Hashtable  attributes)
    {
        this(null, attributes);
    }

    /**
     * Constructor from a table of attributes with ordering.
     * <p>
     * it's is assumed the table contains OID/String pairs, and the contents
     * of the table are copied into an internal table as part of the
     * construction process. The ordering vector should contain the OIDs
     * in the order they are meant to be encoded or printed in toString.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.911 -0500", hash_original_method = "0E56A2506DE147DC0FDCD121F4661515", hash_generated_method = "211D2849828CF9FF2A857A4E3A6B6F8C")
    
public X509Name(
        Vector      ordering,
        Hashtable   attributes)
    {
        this(ordering, attributes, new X509DefaultEntryConverter());
    }

    /**
     * Constructor from a table of attributes with ordering.
     * <p>
     * it's is assumed the table contains OID/String pairs, and the contents
     * of the table are copied into an internal table as part of the
     * construction process. The ordering vector should contain the OIDs
     * in the order they are meant to be encoded or printed in toString.
     * <p>
     * The passed in converter will be used to convert the strings into their
     * ASN.1 counterparts.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.914 -0500", hash_original_method = "391D1DCB58738C4647988CF64EC70334", hash_generated_method = "3BA3642B5ADE2BD217D7E933B5622096")
    
public X509Name(
        Vector                   ordering,
        Hashtable                attributes,
        X509NameEntryConverter   converter)
    {
        this.converter = converter;

        if (ordering != null)
        {
            for (int i = 0; i != ordering.size(); i++)
            {
                this.ordering.addElement(ordering.elementAt(i));
                this.added.addElement(FALSE);
            }
        }
        else
        {
            Enumeration     e = attributes.keys();

            while (e.hasMoreElements())
            {
                this.ordering.addElement(e.nextElement());
                this.added.addElement(FALSE);
            }
        }

        for (int i = 0; i != this.ordering.size(); i++)
        {
            DERObjectIdentifier     oid = (DERObjectIdentifier)this.ordering.elementAt(i);

            if (attributes.get(oid) == null)
            {
                throw new IllegalArgumentException("No attribute for object id - " + oid.getId() + " - passed to distinguished name");
            }

            this.values.addElement(attributes.get(oid)); // copy the hash table
        }
    }

    /**
     * Takes two vectors one of the oids and the other of the values.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.917 -0500", hash_original_method = "09339315E74F09704223BAA476796553", hash_generated_method = "2C68E0B96E192360B579F5B500C88F97")
    
public X509Name(
        Vector  oids,
        Vector  values)
    {
        this(oids, values, new X509DefaultEntryConverter());
    }

    /**
     * Takes two vectors one of the oids and the other of the values.
     * <p>
     * The passed in converter will be used to convert the strings into their
     * ASN.1 counterparts.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.920 -0500", hash_original_method = "492C8BC9ACE864159B4ED5D85649FE7D", hash_generated_method = "EEAA5DD329489A39C31FC59FF3F1E428")
    
public X509Name(
        Vector                  oids,
        Vector                  values,
        X509NameEntryConverter  converter)
    {
        this.converter = converter;

        if (oids.size() != values.size())
        {
            throw new IllegalArgumentException("oids vector must be same length as values.");
        }

        for (int i = 0; i < oids.size(); i++)
        {
            this.ordering.addElement(oids.elementAt(i));
            this.values.addElement(values.elementAt(i));
            this.added.addElement(FALSE);
        }
    }

//    private Boolean isEncoded(String s)
//    {
//        if (s.charAt(0) == '#')
//        {
//            return TRUE;
//        }
//
//        return FALSE;
//    }

    /**
     * Takes an X509 dir name as a string of the format "C=AU, ST=Victoria", or
     * some such, converting it into an ordered set of name attributes.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.922 -0500", hash_original_method = "4DE51E849F59B0AA80C7ECB38F0D9925", hash_generated_method = "75DE0EBDD6E564D92EC7944E0433C01E")
    
public X509Name(
        String  dirName)
    {
        this(DefaultReverse, DefaultLookUp, dirName);
    }

    /**
     * Takes an X509 dir name as a string of the format "C=AU, ST=Victoria", or
     * some such, converting it into an ordered set of name attributes with each
     * string value being converted to its associated ASN.1 type using the passed
     * in converter.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.925 -0500", hash_original_method = "225E7940DFC3CDF11421E5A31C692555", hash_generated_method = "E9F4A4633FFFB712F3C91CCD1598E010")
    
public X509Name(
        String                  dirName,
        X509NameEntryConverter  converter)
    {
        this(DefaultReverse, DefaultLookUp, dirName, converter);
    }

    /**
     * Takes an X509 dir name as a string of the format "C=AU, ST=Victoria", or
     * some such, converting it into an ordered set of name attributes. If reverse
     * is true, create the encoded version of the sequence starting from the
     * last element in the string.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.928 -0500", hash_original_method = "A1386F925B8F997747CFC9FBEC64818C", hash_generated_method = "4F117C36CA82C778618B1D2E8208F876")
    
public X509Name(
        boolean reverse,
        String  dirName)
    {
        this(reverse, DefaultLookUp, dirName);
    }

    /**
     * Takes an X509 dir name as a string of the format "C=AU, ST=Victoria", or
     * some such, converting it into an ordered set of name attributes with each
     * string value being converted to its associated ASN.1 type using the passed
     * in converter. If reverse is true the ASN.1 sequence representing the DN will
     * be built by starting at the end of the string, rather than the start.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.930 -0500", hash_original_method = "0ED99673E1BB44384871E74A0AAAAEE6", hash_generated_method = "E892788093A2CD439E9F7B181AC8482E")
    
public X509Name(
        boolean                 reverse,
        String                  dirName,
        X509NameEntryConverter  converter)
    {
        this(reverse, DefaultLookUp, dirName, converter);
    }

    /**
     * Takes an X509 dir name as a string of the format "C=AU, ST=Victoria", or
     * some such, converting it into an ordered set of name attributes. lookUp
     * should provide a table of lookups, indexed by lowercase only strings and
     * yielding a DERObjectIdentifier, other than that OID. and numeric oids
     * will be processed automatically.
     * <br>
     * If reverse is true, create the encoded version of the sequence
     * starting from the last element in the string.
     * @param reverse true if we should start scanning from the end (RFC 2553).
     * @param lookUp table of names and their oids.
     * @param dirName the X.500 string to be parsed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.933 -0500", hash_original_method = "AD0C5D6A617F7C4CAD4929B6BAF77A7F", hash_generated_method = "9B10DB69B913282F9475EFAEA3120D4C")
    
public X509Name(
        boolean     reverse,
        Hashtable   lookUp,
        String      dirName)
    {
        this(reverse, lookUp, dirName, new X509DefaultEntryConverter());
    }

    /**
     * Takes an X509 dir name as a string of the format "C=AU, ST=Victoria", or
     * some such, converting it into an ordered set of name attributes. lookUp
     * should provide a table of lookups, indexed by lowercase only strings and
     * yielding a DERObjectIdentifier, other than that OID. and numeric oids
     * will be processed automatically. The passed in converter is used to convert the
     * string values to the right of each equals sign to their ASN.1 counterparts.
     * <br>
     * @param reverse true if we should start scanning from the end, false otherwise.
     * @param lookUp table of names and oids.
     * @param dirName the string dirName
     * @param converter the converter to convert string values into their ASN.1 equivalents
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.939 -0500", hash_original_method = "E0536EE704C9789715788F9D659749FC", hash_generated_method = "673D0E77C6829E7F611F2082214D9A94")
    
public X509Name(
        boolean                 reverse,
        Hashtable               lookUp,
        String                  dirName,
        X509NameEntryConverter  converter)
    {
        this.converter = converter;
        X509NameTokenizer   nTok = new X509NameTokenizer(dirName);

        while (nTok.hasMoreTokens())
        {
            String  token = nTok.nextToken();
            int     index = token.indexOf('=');

            if (index == -1)
            {
                // BEGIN android-changed
                throw new IllegalArgumentException("badly formatted directory string");
                // END android-changed
            }

            String              name = token.substring(0, index);
            String              value = token.substring(index + 1);
            DERObjectIdentifier oid = decodeOID(name, lookUp);

            if (value.indexOf('+') > 0)
            {
                X509NameTokenizer   vTok = new X509NameTokenizer(value, '+');
                String  v = vTok.nextToken();

                this.ordering.addElement(oid);
                this.values.addElement(v);
                this.added.addElement(FALSE);

                while (vTok.hasMoreTokens())
                {
                    String  sv = vTok.nextToken();
                    int     ndx = sv.indexOf('=');

                    String  nm = sv.substring(0, ndx);
                    String  vl = sv.substring(ndx + 1);
                    this.ordering.addElement(decodeOID(nm, lookUp));
                    this.values.addElement(vl);
                    this.added.addElement(TRUE);
                }
            }
            else
            {
                this.ordering.addElement(oid);
                this.values.addElement(value);
                this.added.addElement(FALSE);
            }
        }

        if (reverse)
        {
            Vector  o = new Vector();
            Vector  v = new Vector();
            Vector  a = new Vector();

            int count = 1;

            for (int i = 0; i < this.ordering.size(); i++)
            {
                if (((Boolean)this.added.elementAt(i)).booleanValue())
                {
                    o.insertElementAt(this.ordering.elementAt(i), count);
                    v.insertElementAt(this.values.elementAt(i), count);
                    a.insertElementAt(this.added.elementAt(i), count);
                    count++;
                }
                else
                {
                    o.insertElementAt(this.ordering.elementAt(i), 0);
                    v.insertElementAt(this.values.elementAt(i), 0);
                    a.insertElementAt(this.added.elementAt(i), 0);
                    count = 1;
                }
            }

            this.ordering = o;
            this.values = v;
            this.added = a;
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.935 -0500", hash_original_method = "964F6D63AF200DB73DB551657282148F", hash_generated_method = "813BD70A3791EAD090BFF26467F4BC63")
    
private DERObjectIdentifier decodeOID(
        String      name,
        Hashtable   lookUp)
    {
        if (Strings.toUpperCase(name).startsWith("OID."))
        {
            return new DERObjectIdentifier(name.substring(4));
        }
        else if (name.charAt(0) >= '0' && name.charAt(0) <= '9')
        {
            return new DERObjectIdentifier(name);
        }

        DERObjectIdentifier oid = (DERObjectIdentifier)lookUp.get(Strings.toLowerCase(name));
        if (oid == null)
        {
            throw new IllegalArgumentException("Unknown object id - " + name + " - passed to distinguished name");
        }

        return oid;
    }

    /**
     * return a vector of the oids in the name, in the order they were found.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.942 -0500", hash_original_method = "2D101B81AA4F7CB6B72317966361C7FD", hash_generated_method = "8FDD2BD7B996DEBBA0343B72267A4050")
    
public Vector getOIDs()
    {
        Vector  v = new Vector();

        for (int i = 0; i != ordering.size(); i++)
        {
            v.addElement(ordering.elementAt(i));
        }

        return v;
    }

    /**
     * return a vector of the values found in the name, in the order they
     * were found.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.944 -0500", hash_original_method = "F648A0377CD08E6DCA69D49343904A7E", hash_generated_method = "11B393EA383F1D6622D44834F15AC67C")
    
public Vector getValues()
    {
        Vector  v = new Vector();

        for (int i = 0; i != values.size(); i++)
        {
            v.addElement(values.elementAt(i));
        }

        return v;
    }

    /**
     * return a vector of the values found in the name, in the order they
     * were found, with the DN label corresponding to passed in oid.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.947 -0500", hash_original_method = "B5B05F9A72085C1CEE80B6960CBCC4AA", hash_generated_method = "F2CD46D39A604F19567622D7DC53FDE3")
    
public Vector getValues(
        DERObjectIdentifier oid)
    {
        Vector  v = new Vector();

        for (int i = 0; i != values.size(); i++)
        {
            if (ordering.elementAt(i).equals(oid))
            {
                String val = (String)values.elementAt(i);

                if (val.length() > 2 && val.charAt(0) == '\\' && val.charAt(1) == '#')
                {
                    v.addElement(val.substring(1));
                }
                else
                {
                    v.addElement(val);
                }
            }
        }

        return v;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.949 -0500", hash_original_method = "3947A3064A86A512C4391326C6ABB01D", hash_generated_method = "EC2F005F89183801DBAB204494839EC6")
    
public DERObject toASN1Object()
    {
        if (seq == null)
        {
            ASN1EncodableVector  vec = new ASN1EncodableVector();
            ASN1EncodableVector  sVec = new ASN1EncodableVector();
            DERObjectIdentifier  lstOid = null;
            
            for (int i = 0; i != ordering.size(); i++)
            {
                ASN1EncodableVector     v = new ASN1EncodableVector();
                DERObjectIdentifier     oid = (DERObjectIdentifier)ordering.elementAt(i);

                v.add(oid);

                String  str = (String)values.elementAt(i);

                v.add(converter.getConvertedValue(oid, str));
 
                if (lstOid == null 
                    || ((Boolean)this.added.elementAt(i)).booleanValue())
                {
                    sVec.add(new DERSequence(v));
                }
                else
                {
                    vec.add(new DERSet(sVec));
                    sVec = new ASN1EncodableVector();
                    
                    sVec.add(new DERSequence(v));
                }
                
                lstOid = oid;
            }
            
            vec.add(new DERSet(sVec));
            
            seq = new DERSequence(vec);
        }

        return seq;
    }

    /**
     * @param inOrder if true the order of both X509 names must be the same,
     * as well as the values associated with each element.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.952 -0500", hash_original_method = "280DBAE44A81315C42DC75BD60909480", hash_generated_method = "9521315A265A3D7B1BDAA93659BA6D02")
    
public boolean equals(Object obj, boolean inOrder)
    {
        if (!inOrder)
        {
            return this.equals(obj);
        }

        if (obj == this)
        {
            return true;
        }

        if (!(obj instanceof X509Name || obj instanceof ASN1Sequence))
        {
            return false;
        }

        DERObject derO = ((DEREncodable)obj).getDERObject();

        if (this.getDERObject().equals(derO))
        {
            return true;
        }

        X509Name other;

        try
        {
            other = X509Name.getInstance(obj);
        }
        catch (IllegalArgumentException e)
        {
            return false;
        }

        int      orderingSize = ordering.size();

        if (orderingSize != other.ordering.size())
        {
            return false;
        }

        for (int i = 0; i < orderingSize; i++)
        {
            DERObjectIdentifier  oid = (DERObjectIdentifier)ordering.elementAt(i);
            DERObjectIdentifier  oOid = (DERObjectIdentifier)other.ordering.elementAt(i);

            if (oid.equals(oOid))
            {
                String value = (String)values.elementAt(i);
                String oValue = (String)other.values.elementAt(i);

                if (!equivalentStrings(value, oValue))
                {
                    return false;
                }
            }
            else
            {
                return false;
            }
        }

        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.956 -0500", hash_original_method = "F1AF8C1EFC711A1D842EED436165BEED", hash_generated_method = "E12114BF123A62D0442731AC9267F725")
    
public int hashCode()
    {
        if (isHashCodeCalculated)
        {
            return hashCodeValue;
        }

        isHashCodeCalculated = true;

        // this needs to be order independent, like equals
        for (int i = 0; i != ordering.size(); i += 1)
        {
            String value = (String)values.elementAt(i);

            value = canonicalize(value);
            value = stripInternalSpaces(value);

            hashCodeValue ^= ordering.elementAt(i).hashCode();
            hashCodeValue ^= value.hashCode();
        }

        return hashCodeValue;
    }

    /**
     * test for equality - note: case is ignored.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.959 -0500", hash_original_method = "9BE112C8870FAD3CF61652B8C6BD4A74", hash_generated_method = "F2D77CB590F7FA9E0FF8D44FB616069C")
    
public boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }

        if (!(obj instanceof X509Name || obj instanceof ASN1Sequence))
        {
            return false;
        }
        
        DERObject derO = ((DEREncodable)obj).getDERObject();
        
        if (this.getDERObject().equals(derO))
        {
            return true;
        }

        X509Name other;

        try
        {
            other = X509Name.getInstance(obj);
        }
        catch (IllegalArgumentException e)
        { 
            return false;
        }

        int      orderingSize = ordering.size();

        if (orderingSize != other.ordering.size())
        {
            return false;
        }
        
        boolean[] indexes = new boolean[orderingSize];
        int       start, end, delta;

        if (ordering.elementAt(0).equals(other.ordering.elementAt(0)))   // guess forward
        {
            start = 0;
            end = orderingSize;
            delta = 1;
        }
        else  // guess reversed - most common problem
        {
            start = orderingSize - 1;
            end = -1;
            delta = -1;
        }

        for (int i = start; i != end; i += delta)
        {
            boolean              found = false;
            DERObjectIdentifier  oid = (DERObjectIdentifier)ordering.elementAt(i);
            String               value = (String)values.elementAt(i);

            for (int j = 0; j < orderingSize; j++)
            {
                if (indexes[j])
                {
                    continue;
                }

                DERObjectIdentifier oOid = (DERObjectIdentifier)other.ordering.elementAt(j);

                if (oid.equals(oOid))
                {
                    String oValue = (String)other.values.elementAt(j);

                    if (equivalentStrings(value, oValue))
                    {
                        indexes[j] = true;
                        found      = true;
                        break;
                    }
                }
            }

            if (!found)
            {
                return false;
            }
        }
        
        return true;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.961 -0500", hash_original_method = "4C05CDE4A9C2B68738F6FCFBDDBEA55B", hash_generated_method = "0DC697C632F8E307989A51314BBE9F7A")
    
private boolean equivalentStrings(String s1, String s2)
    {
        String value = canonicalize(s1);
        String oValue = canonicalize(s2);
        
        if (!value.equals(oValue))
        {
            value = stripInternalSpaces(value);
            oValue = stripInternalSpaces(oValue);

            if (!value.equals(oValue))
            {
                return false;
            }
        }

        return true;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.964 -0500", hash_original_method = "94F49650EDA8FF5038678A71C47387EA", hash_generated_method = "99D555158364CA3DEF5AF3388187EB1F")
    
private String canonicalize(String s)
    {
        String value = Strings.toLowerCase(s.trim());
        
        if (value.length() > 0 && value.charAt(0) == '#')
        {
            DERObject obj = decodeObject(value);

            if (obj instanceof DERString)
            {
                value = Strings.toLowerCase(((DERString)obj).getString().trim());
            }
        }

        return value;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.966 -0500", hash_original_method = "DA9861DC0244404A041AD42C955600B0", hash_generated_method = "5DAC87C479937FD6C9024087BA34C1AD")
    
private ASN1Object decodeObject(String oValue)
    {
        try
        {
            return ASN1Object.fromByteArray(Hex.decode(oValue.substring(1)));
        }
        catch (IOException e)
        {
            throw new IllegalStateException("unknown encoding in name: " + e);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.969 -0500", hash_original_method = "1E1DA2E49EB072DAE70813000ABE2315", hash_generated_method = "9DC24EF1383CA0D3011861C7B442B127")
    
private String stripInternalSpaces(
        String str)
    {
        StringBuffer res = new StringBuffer();

        if (str.length() != 0)
        {
            char    c1 = str.charAt(0);

            res.append(c1);

            for (int k = 1; k < str.length(); k++)
            {
                char    c2 = str.charAt(k);
                if (!(c1 == ' ' && c2 == ' '))
                {
                    res.append(c2);
                }
                c1 = c2;
            }
        }

        return res.toString();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.972 -0500", hash_original_method = "276C610AF86C7F7EC8233E2E5B295559", hash_generated_method = "A5562AC24A647AF0B591142A9B8EE0F8")
    
private void appendValue(
        StringBuffer        buf,
        Hashtable           oidSymbols,
        DERObjectIdentifier oid,
        String              value)
    {
        String  sym = (String)oidSymbols.get(oid);

        if (sym != null)
        {
            buf.append(sym);
        }
        else
        {
            buf.append(oid.getId());
        }

        buf.append('=');

        int     index = buf.length();
        
        buf.append(value);

        int     end = buf.length();

        if (value.length() >= 2 && value.charAt(0) == '\\' && value.charAt(1) == '#')
        {
            index += 2;   
        }

        while (index != end)
        {
            if ((buf.charAt(index) == ',')
               || (buf.charAt(index) == '"')
               || (buf.charAt(index) == '\\')
               || (buf.charAt(index) == '+')
               || (buf.charAt(index) == '=')
               || (buf.charAt(index) == '<')
               || (buf.charAt(index) == '>')
               || (buf.charAt(index) == ';'))
            {
                buf.insert(index, "\\");
                index++;
                end++;
            }

            index++;
        }
    }

    /**
     * convert the structure to a string - if reverse is true the
     * oids and values are listed out starting with the last element
     * in the sequence (ala RFC 2253), otherwise the string will begin
     * with the first element of the structure. If no string definition
     * for the oid is found in oidSymbols the string value of the oid is
     * added. Two standard symbol tables are provided DefaultSymbols, and
     * RFC2253Symbols as part of this class.
     *
     * @param reverse if true start at the end of the sequence and work back.
     * @param oidSymbols look up table strings for oids.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.975 -0500", hash_original_method = "656BABE23C68D82FE6D3AB319F560E81", hash_generated_method = "AD96BCE3B23DB4C0476167B5645576D5")
    
public String toString(
        boolean     reverse,
        Hashtable   oidSymbols)
    {
        StringBuffer            buf = new StringBuffer();
        Vector                  components = new Vector();
        boolean                 first = true;

        StringBuffer ava = null;

        for (int i = 0; i < ordering.size(); i++)
        {
            if (((Boolean)added.elementAt(i)).booleanValue())
            {
                ava.append('+');
                appendValue(ava, oidSymbols,
                    (DERObjectIdentifier)ordering.elementAt(i),
                    (String)values.elementAt(i));
            }
            else
            {
                ava = new StringBuffer();
                appendValue(ava, oidSymbols,
                    (DERObjectIdentifier)ordering.elementAt(i),
                    (String)values.elementAt(i));
                components.addElement(ava);
            }
        }

        if (reverse)
        {
            for (int i = components.size() - 1; i >= 0; i--)
            {
                if (first)
                {
                    first = false;
                }
                else
                {
                    buf.append(',');
                }

                buf.append(components.elementAt(i).toString());
            }
        }
        else
        {
            for (int i = 0; i < components.size(); i++)
            {
                if (first)
                {
                    first = false;
                }
                else
                {
                    buf.append(',');
                }

                buf.append(components.elementAt(i).toString());
            }
        }

        return buf.toString();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.977 -0500", hash_original_method = "B6C7D564A6D3D0BE9A656CE0C6CFB554", hash_generated_method = "6E98F280D567BB4804327BA6C2203108")
    
private String bytesToString(
        byte[] data)
    {
        char[]  cs = new char[data.length];

        for (int i = 0; i != cs.length; i++)
        {
            cs[i] = (char)(data[i] & 0xff);
        }

        return new String(cs);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.980 -0500", hash_original_method = "E860E9E8B8CF997531DC86A289D376AE", hash_generated_method = "8B72C1A60AC984BE730E0959D0E7CD26")
    
public String toString()
    {
        return toString(DefaultReverse, DefaultSymbols);
    }
    static {
        DefaultSymbols.put(C, "C");
        DefaultSymbols.put(O, "O");
        DefaultSymbols.put(T, "T");
        DefaultSymbols.put(OU, "OU");
        DefaultSymbols.put(CN, "CN");
        DefaultSymbols.put(L, "L");
        DefaultSymbols.put(ST, "ST");
        DefaultSymbols.put(SN, "SERIALNUMBER");
        DefaultSymbols.put(EmailAddress, "E");
        DefaultSymbols.put(DC, "DC");
        DefaultSymbols.put(UID, "UID");
        DefaultSymbols.put(STREET, "STREET");
        DefaultSymbols.put(SURNAME, "SURNAME");
        DefaultSymbols.put(GIVENNAME, "GIVENNAME");
        DefaultSymbols.put(INITIALS, "INITIALS");
        DefaultSymbols.put(GENERATION, "GENERATION");
        DefaultSymbols.put(UnstructuredAddress, "unstructuredAddress");
        DefaultSymbols.put(UnstructuredName, "unstructuredName");
        DefaultSymbols.put(UNIQUE_IDENTIFIER, "UniqueIdentifier");
        DefaultSymbols.put(DN_QUALIFIER, "DN");
        DefaultSymbols.put(PSEUDONYM, "Pseudonym");
        DefaultSymbols.put(POSTAL_ADDRESS, "PostalAddress");
        DefaultSymbols.put(NAME_AT_BIRTH, "NameAtBirth");
        DefaultSymbols.put(COUNTRY_OF_CITIZENSHIP, "CountryOfCitizenship");
        DefaultSymbols.put(COUNTRY_OF_RESIDENCE, "CountryOfResidence");
        DefaultSymbols.put(GENDER, "Gender");
        DefaultSymbols.put(PLACE_OF_BIRTH, "PlaceOfBirth");
        DefaultSymbols.put(DATE_OF_BIRTH, "DateOfBirth");
        DefaultSymbols.put(POSTAL_CODE, "PostalCode");
        DefaultSymbols.put(BUSINESS_CATEGORY, "BusinessCategory");
        DefaultSymbols.put(TELEPHONE_NUMBER, "TelephoneNumber");
        DefaultSymbols.put(NAME, "Name");
        RFC2253Symbols.put(C, "C");
        RFC2253Symbols.put(O, "O");
        RFC2253Symbols.put(OU, "OU");
        RFC2253Symbols.put(CN, "CN");
        RFC2253Symbols.put(L, "L");
        RFC2253Symbols.put(ST, "ST");
        RFC2253Symbols.put(STREET, "STREET");
        RFC2253Symbols.put(DC, "DC");
        RFC2253Symbols.put(UID, "UID");
        RFC1779Symbols.put(C, "C");
        RFC1779Symbols.put(O, "O");
        RFC1779Symbols.put(OU, "OU");
        RFC1779Symbols.put(CN, "CN");
        RFC1779Symbols.put(L, "L");
        RFC1779Symbols.put(ST, "ST");
        RFC1779Symbols.put(STREET, "STREET");
        DefaultLookUp.put("c", C);
        DefaultLookUp.put("o", O);
        DefaultLookUp.put("t", T);
        DefaultLookUp.put("ou", OU);
        DefaultLookUp.put("cn", CN);
        DefaultLookUp.put("l", L);
        DefaultLookUp.put("st", ST);
        DefaultLookUp.put("sn", SN);
        DefaultLookUp.put("serialnumber", SN);
        DefaultLookUp.put("street", STREET);
        DefaultLookUp.put("emailaddress", E);
        DefaultLookUp.put("dc", DC);
        DefaultLookUp.put("e", E);
        DefaultLookUp.put("uid", UID);
        DefaultLookUp.put("surname", SURNAME);
        DefaultLookUp.put("givenname", GIVENNAME);
        DefaultLookUp.put("initials", INITIALS);
        DefaultLookUp.put("generation", GENERATION);
        DefaultLookUp.put("unstructuredaddress", UnstructuredAddress);
        DefaultLookUp.put("unstructuredname", UnstructuredName);
        DefaultLookUp.put("uniqueidentifier", UNIQUE_IDENTIFIER);
        DefaultLookUp.put("dn", DN_QUALIFIER);
        DefaultLookUp.put("pseudonym", PSEUDONYM);
        DefaultLookUp.put("postaladdress", POSTAL_ADDRESS);
        DefaultLookUp.put("nameofbirth", NAME_AT_BIRTH);
        DefaultLookUp.put("countryofcitizenship", COUNTRY_OF_CITIZENSHIP);
        DefaultLookUp.put("countryofresidence", COUNTRY_OF_RESIDENCE);
        DefaultLookUp.put("gender", GENDER);
        DefaultLookUp.put("placeofbirth", PLACE_OF_BIRTH);
        DefaultLookUp.put("dateofbirth", DATE_OF_BIRTH);
        DefaultLookUp.put("postalcode", POSTAL_CODE);
        DefaultLookUp.put("businesscategory", BUSINESS_CATEGORY);
        DefaultLookUp.put("telephonenumber", TELEPHONE_NUMBER);
        DefaultLookUp.put("name", NAME);
    }
    
}

