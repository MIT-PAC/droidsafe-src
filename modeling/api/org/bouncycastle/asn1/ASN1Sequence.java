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
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;

public abstract class ASN1Sequence extends ASN1Object {

    /**
     * return an ASN1Sequence from the given object.
     *
     * @param obj the object we want converted.
     * @exception IllegalArgumentException if the object cannot be converted.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:29.347 -0500", hash_original_method = "8F76C15DF856D0B527D44681C219DFA0", hash_generated_method = "5C15F60CB659D3B007B78E8CACE1D3BE")
    
public static ASN1Sequence getInstance(
        Object  obj)
    {
        if (obj == null || obj instanceof ASN1Sequence)
        {
            return (ASN1Sequence)obj;
        }
        else if (obj instanceof byte[])
        {
            try
            {
                return ASN1Sequence.getInstance(ASN1Object.fromByteArray((byte[])obj));
            }
            catch (IOException e)
            {
                throw new IllegalArgumentException("failed to construct sequence from byte[]: " + e.getMessage());
            }
        }

        throw new IllegalArgumentException("unknown object in getInstance: " + obj.getClass().getName());
    }

    /**
     * Return an ASN1 sequence from a tagged object. There is a special
     * case here, if an object appears to have been explicitly tagged on 
     * reading but we were expecting it to be implicitly tagged in the 
     * normal course of events it indicates that we lost the surrounding
     * sequence - so we need to add it back (this will happen if the tagged
     * object is a sequence that contains other sequences). If you are
     * dealing with implicitly tagged sequences you really <b>should</b>
     * be using this method.
     *
     * @param obj the tagged object.
     * @param explicit true if the object is meant to be explicitly tagged,
     *          false otherwise.
     * @exception IllegalArgumentException if the tagged object cannot
     *          be converted.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:29.350 -0500", hash_original_method = "BA509B6C9098F8ABF71CE75575C82A2E", hash_generated_method = "A0D992A773AB453B81E650E8477401FD")
    
public static ASN1Sequence getInstance(
        ASN1TaggedObject    obj,
        boolean             explicit)
    {
        if (explicit)
        {
            if (!obj.isExplicit())
            {
                throw new IllegalArgumentException("object implicit - explicit expected.");
            }

            return (ASN1Sequence)obj.getObject();
        }
        else
        {
            //
            // constructed object which appears to be explicitly tagged
            // when it should be implicit means we have to add the
            // surrounding sequence.
            //
            if (obj.isExplicit())
            {
                if (obj instanceof BERTaggedObject)
                {
                    return new BERSequence(obj.getObject());
                }
                else
                {
                    return new DERSequence(obj.getObject());
                }
            }
            else
            {
                if (obj.getObject() instanceof ASN1Sequence)
                {
                    return (ASN1Sequence)obj.getObject();
                }
            }
        }

        throw new IllegalArgumentException("unknown object in getInstance: " + obj.getClass().getName());
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:29.344 -0500", hash_original_field = "ECA674B11DD6E95C65F3C0647A5D0065", hash_generated_field = "1C6134BBF67C6927627E9694230C698B")

    private Vector seq = new Vector();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:29.357 -0500", hash_original_field = "8BD524D6245D998B3BBC44EB9313082E", hash_generated_field = "56A277C77B76B31C1E1045C8C11CA802")

            private int index;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:29.355 -0500", hash_original_field = "FE6035598DC4A50E38F7DA885A8391F1", hash_generated_field = "D2E8168F8D49E25944D5BC65100B260E")

            private final int max = size();
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.775 -0400", hash_original_method = "A2B39ADE0CCBD8FB2D75DB3228C401C7", hash_generated_method = "A2B39ADE0CCBD8FB2D75DB3228C401C7")
    public ASN1Sequence ()
    {
        //Synthesized constructor
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:29.352 -0500", hash_original_method = "CC34A39B9814871A0958BEBA7EE6E2F9", hash_generated_method = "A1A20B622B834BA59AF0820325D0EFE7")
    
public Enumeration getObjects()
    {
        return seq.elements();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.778 -0400", hash_original_method = "43ADC5A8CCFA8153E5DA918392680258", hash_generated_method = "688B3E7DD00954858DC6DB9A210BD8C5")
    public ASN1SequenceParser parser() {
        final ASN1Sequence outer = this;
ASN1SequenceParser varE723BAB1DECCC34402FAFCD6CCEC2AFA_488909682 =         new ASN1SequenceParser() {        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.776 -0400", hash_original_field = "AF8DE777B25121CBA56AF409B9C79B72", hash_generated_field = "D2E8168F8D49E25944D5BC65100B260E")
        private final int max = size();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.777 -0400", hash_original_field = "6A992D5529F459A44FEE58C733255E86", hash_generated_field = "56A277C77B76B31C1E1045C8C11CA802")
        private int index;

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:29.361 -0500", hash_original_method = "BEBFD2E59C81385F3717CD5615389B19", hash_generated_method = "EEB83FF896D04FE8CA5A28BE281CE69D")
            
public DEREncodable readObject() throws IOException
            {
                if (index == max)
                {
                    return null;
                }
                
                DEREncodable obj = getObjectAt(index++);
                if (obj instanceof ASN1Sequence)
                {
                    return ((ASN1Sequence)obj).parser();
                }
                if (obj instanceof ASN1Set)
                {
                    return ((ASN1Set)obj).parser();
                }

                return obj;
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:29.363 -0500", hash_original_method = "D852EEAF1DA4AF081125D411C2A8F904", hash_generated_method = "4AB9590B3C45CC3D0EFEEBA6EF56F456")
            
public DERObject getLoadedObject()
            {
                return outer;
            }
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:29.366 -0500", hash_original_method = "4FE555C2610E9C432E83EB0CA479A77A", hash_generated_method = "28EF2E886E789C49BBAA8822B9091A42")
            
public DERObject getDERObject()
            {
                return outer;
            }
};
        varE723BAB1DECCC34402FAFCD6CCEC2AFA_488909682.addTaint(getTaint());
        return varE723BAB1DECCC34402FAFCD6CCEC2AFA_488909682;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    /**
     * return the object at the sequence position indicated by index.
     *
     * @param index the sequence number (starting at zero) of the object
     * @return the object at the sequence position indicated by index.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:29.370 -0500", hash_original_method = "09A8CA93ED2ECABA19E96E21E19C2A5D", hash_generated_method = "61F5021E388B3C28009E0FD73E3D3F21")
    
public DEREncodable getObjectAt(
        int index)
    {
        return (DEREncodable)seq.elementAt(index);
    }

    /**
     * return the number of objects in this sequence.
     *
     * @return the number of objects in this sequence.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:29.372 -0500", hash_original_method = "18AB5743B6289573A8FB502D4D80C9A6", hash_generated_method = "A963F947D905175D6B8A3EC128B19364")
    
public int size()
    {
        return seq.size();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:29.375 -0500", hash_original_method = "169312DEA8D054B4F83730CF694439C2", hash_generated_method = "30BCB15E7964E7556EB51535BFA9820D")
    
public int hashCode()
    {
        Enumeration             e = this.getObjects();
        int                     hashCode = size();

        while (e.hasMoreElements())
        {
            Object o = getNext(e);
            hashCode *= 17;

            hashCode ^= o.hashCode();
        }

        return hashCode;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:29.377 -0500", hash_original_method = "736827C8F8F39EC68A9619F02A5000FC", hash_generated_method = "736827C8F8F39EC68A9619F02A5000FC")
    
boolean asn1Equals(
        DERObject  o)
    {
        if (!(o instanceof ASN1Sequence))
        {
            return false;
        }
        
        ASN1Sequence   other = (ASN1Sequence)o;

        if (this.size() != other.size())
        {
            return false;
        }

        Enumeration s1 = this.getObjects();
        Enumeration s2 = other.getObjects();

        while (s1.hasMoreElements())
        {
            DEREncodable  obj1 = getNext(s1);
            DEREncodable  obj2 = getNext(s2);

            DERObject  o1 = obj1.getDERObject();
            DERObject  o2 = obj2.getDERObject();

            if (o1 == o2 || o1.equals(o2))
            {
                continue;
            }

            return false;
        }

        return true;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:29.380 -0500", hash_original_method = "A69C6C665FC9D3DE250A324544079C85", hash_generated_method = "71F8019F43835013203D7AD69C0E7F8C")
    
private DEREncodable getNext(Enumeration e)
    {
        DEREncodable encObj = (DEREncodable)e.nextElement();

        // unfortunately null was allowed as a substitute for DER null
        if (encObj == null)
        {
            return DERNull.INSTANCE;
        }

        return encObj;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:29.383 -0500", hash_original_method = "FBD504B361191BF80361CE4D106B6193", hash_generated_method = "94B9997DF6551700DD61BB1825DB7338")
    
protected void addObject(
        DEREncodable obj)
    {
        seq.addElement(obj);
    }

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:29.385 -0500", hash_original_method = "A1E289DFE0364C85836C0C8908499825", hash_generated_method = "877693E84D45EBE13EC3671BCE6F2F0C")
    
abstract void encode(DEROutputStream out)
        throws IOException;

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:29.387 -0500", hash_original_method = "467BC9BFB84385F84F9590AA6DD6E2BE", hash_generated_method = "08E1BFA8F7FD49828A086FB7DFACF8DC")
    
public String toString() 
    {
      return seq.toString();
    }
    
}

