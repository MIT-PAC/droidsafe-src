package org.bouncycastle.asn1.x500;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;

public interface X500NameStyle
{
    
    ASN1Encodable stringToValue(ASN1ObjectIdentifier oid, String value);

    ASN1ObjectIdentifier attrNameToOID(String attrName);

    boolean areEqual(X500Name name1, X500Name name2);

    RDN[] fromString(String dirName);

    int calculateHashCode(X500Name name);

    String toString(X500Name name);
}
