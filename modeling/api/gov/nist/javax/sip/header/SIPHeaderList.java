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
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
* Conditions Of Use
*
* This software was developed by employees of the National Institute of
* Standards and Technology (NIST), an agency of the Federal Government.
* Pursuant to title 15 Untied States Code Section 105, works of NIST
* employees are not subject to copyright protection in the United States
* and are considered to be in the public domain.  As a result, a formal
* license is not needed to use the software.
*
* This software is provided by NIST as a service and is expressly
* provided "AS IS."  NIST MAKES NO WARRANTY OF ANY KIND, EXPRESS, IMPLIED
* OR STATUTORY, INCLUDING, WITHOUT LIMITATION, THE IMPLIED WARRANTY OF
* MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, NON-INFRINGEMENT
* AND DATA ACCURACY.  NIST does not warrant or make any representations
* regarding the use of the software or the results thereof, including but
* not limited to the correctness, accuracy, reliability or usefulness of
* the software.
*
* Permission to use this software is contingent upon your acceptance
* of the terms of this agreement
*
* .
*
*/
/*******************************************************************************
 * Product of NIST/ITL Advanced Networking Technologies Division (ANTD).       *
 ******************************************************************************/

/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.core.GenericObject;
import gov.nist.core.Separators;
import gov.nist.javax.sip.header.ims.PrivacyHeader;

import java.lang.reflect.Constructor;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import javax.sip.header.Header;

public abstract class SIPHeaderList<HDR extends SIPHeader> extends SIPHeader implements java.util.List<HDR>, Header {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:08.748 -0500", hash_original_method = "3479D46A175E4E7E02958E37278BD36E", hash_generated_method = "7BD48B92D903DC8EF08046D5E59526DD")
    
public static void setPrettyEncode(boolean flag) {
        prettyEncode = flag;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:08.568 -0500", hash_original_field = "3E6654B574B7B146FB19CF38092BC78D", hash_generated_field = "F24392C13A6D95700264E5A997197264")

    private static boolean prettyEncode = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:08.572 -0500", hash_original_field = "4353EE1013E3359C24F2F7A43652CFED", hash_generated_field = "1610EB574C9A048E3BE2EA98FBE15AF1")

    protected List<HDR> hlist;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:08.574 -0500", hash_original_field = "43B2ABA48E81AE0750B9B4971CAD7379", hash_generated_field = "7DDB65A0A435AAFCBC63AD9D687C490F")

    private Class<HDR> myClass;

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:08.580 -0500", hash_original_method = "D7E30AE5F54C678856B1E2B4E08FADF6", hash_generated_method = "1B375F3151E47402C3A2F26A1EB13D02")
    
private SIPHeaderList() {
        hlist = new LinkedList<HDR>();
    }

    /**
     * Constructor
     *
     * @param objclass
     *            Class to set
     * @param hname
     *            String to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:08.583 -0500", hash_original_method = "C956079DDC347F2EE85C1D1E44860715", hash_generated_method = "9519CE0209E2AF9954175B26F2B41E10")
    
protected SIPHeaderList(Class<HDR> objclass, String hname) {
        this();
        this.headerName = hname;
        this.myClass =  objclass;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:08.577 -0500", hash_original_method = "5A8D65821D08B5534EF9F59F256EB0ED", hash_generated_method = "F3F8F203B82F62163ACC77D3355FEA39")
    
public String getName() {
        return this.headerName;
    }

    /**
     * Concatenate the list of stuff that we are keeping around and also the
     * text corresponding to these structures (that we parsed).
     *
     * @param objectToAdd
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:08.587 -0500", hash_original_method = "45FF804DBFA2BB4F4071CDF27CE28633", hash_generated_method = "DE85DD5FA87051E0F364973767E0E8A1")
    
        @DSSafe(DSCat.SAFE_LIST)
public boolean add(HDR objectToAdd) {
        hlist.add((HDR)objectToAdd);
        return true;
    }

    /**
     * Concatenate the list of stuff that we are keeping around and also the
     * text corresponding to these structures (that we parsed).
     *
     * @param obj
     *            Genericobject to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:08.590 -0500", hash_original_method = "87B618AF10705C22EFB36E4A71158D56", hash_generated_method = "54A200294B7C93768F11F3C3B2B34FAD")
    @DSSafe(DSCat.SAFE_LIST) 
public void addFirst(HDR obj) {
        hlist.add(0,(HDR) obj);
    }

    /**
     * Add to this list.
     *
     * @param sipheader
     *            SIPHeader to add.
     * @param top
     *            is true if we want to add to the top of the list.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:08.594 -0500", hash_original_method = "3D14CCA72C816FE4801BBC05991E4343", hash_generated_method = "06F3350CA231C61E6E3D685EA2191004")
    @DSSafe(DSCat.SAFE_LIST) 
public void add(HDR sipheader, boolean top) {
        if (top)
            this.addFirst(sipheader);
        else
            this.add(sipheader);
    }

    /**
     * Concatenate two compatible lists. This appends or prepends the new list
     * to the end of this list.
     *
     * @param other
     *            SIPHeaderList to set
     * @param topFlag
     *            flag which indicates which end to concatenate
     *            the lists.
     * @throws IllegalArgumentException
     *             if the two lists are not compatible
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:08.597 -0500", hash_original_method = "2C5EDAC0235777863EFD087B4072277C", hash_generated_method = "9E7C21291AC9652038CC874A9632FB81")
    @DSSafe(DSCat.SAFE_LIST)
public void concatenate(SIPHeaderList<HDR> other, boolean topFlag)
            throws IllegalArgumentException {
        if (!topFlag) {
            this.addAll(other);
        } else {
            // add given items to the top end of the list.
            this.addAll(0, other);
        }

    }

    /**
     * Encode a list of sip headers. Headers are returned in cannonical form.
     *
     * @return String encoded string representation of this list of headers.
     *         (Contains string append of each encoded header).
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:08.600 -0500", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "3E83C3693072E036EE6283AD07E42258")
    
public String encode() {
        return encode(new StringBuffer()).toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:08.603 -0500", hash_original_method = "4452028BB43CC449CBD4FD5523C455CD", hash_generated_method = "D705592BC6F3769032920683153554BA")
    
public StringBuffer encode(StringBuffer buffer) {
        if (hlist.isEmpty()) {
            buffer.append(headerName).append(':').append(Separators.NEWLINE);
        }
        else {
            // The following headers do not have comma separated forms for
            // multiple headers. Thus, they must be encoded separately.
            if (this.headerName.equals(SIPHeaderNames.WWW_AUTHENTICATE)
                    || this.headerName.equals(SIPHeaderNames.PROXY_AUTHENTICATE)
                    || this.headerName.equals(SIPHeaderNames.AUTHORIZATION)
                    || this.headerName.equals(SIPHeaderNames.PROXY_AUTHORIZATION)
                    || (prettyEncode &&
                            (this.headerName.equals(SIPHeaderNames.VIA) || this.headerName.equals(SIPHeaderNames.ROUTE) || this.headerName.equals(SIPHeaderNames.RECORD_ROUTE))) // Less confusing to read
                    || this.getClass().equals( ExtensionHeaderList.class) ) {
                ListIterator<HDR> li = hlist.listIterator();
                while (li.hasNext()) {
                    HDR sipheader = (HDR) li.next();
                    sipheader.encode(buffer);
                }
            } else {
                // These can be concatenated together in an comma separated
                // list.
                buffer.append(headerName).append(Separators.COLON).append(Separators.SP);
                this.encodeBody(buffer);
                buffer.append(Separators.NEWLINE);
            }
        }
        return buffer;
    }

    /**
     * Return a list of encoded strings (one for each sipheader).
     *
     * @return LinkedList containing encoded strings in this header list. an
     *         empty list is returned if this header list contains no sip
     *         headers.
     */

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:08.607 -0500", hash_original_method = "3A5F29F99CF35D16AD0C376ECAFA4E44", hash_generated_method = "2F8A4294D043A0D4FFD1926147911900")
    
public List<String> getHeadersAsEncodedStrings() {
        List<String> retval = new LinkedList<String>();

        ListIterator<HDR> li = hlist.listIterator();
        while (li.hasNext()) {
            Header sipheader = li.next();
            retval.add(sipheader.toString());

        }

        return retval;

    }

    /**
     * Get the first element of this list.
     *
     * @return SIPHeader first element of the list.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:08.610 -0500", hash_original_method = "6C7059400A289BDBD2DC174FD9546E0E", hash_generated_method = "9A9A6622EA50661311B6037CD7613E34")
    
public Header getFirst() {
        if (hlist == null || hlist.isEmpty())
            return null;
        else
            return  hlist.get(0);
    }

    /**
     * Get the last element of this list.
     *
     * @return SIPHeader last element of the list.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:08.613 -0500", hash_original_method = "564DA566938B5DEC3F30C613889BA2FD", hash_generated_method = "D066CE7B66C3741C7EE78C82FBCA05AD")
    
public Header getLast() {
        if (hlist == null || hlist.isEmpty())
            return null;
        return  hlist.get(hlist.size() - 1);
    }

    /**
     * Get the class for the headers of this list.
     *
     * @return Class of header supported by this list.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:08.616 -0500", hash_original_method = "52DB400388897C60F1E5D7C5CF768C2C", hash_generated_method = "B793AA81A1208A012BD710EE4FCA211B")
    
public Class<HDR> getMyClass() {
        return  this.myClass;
    }

    /**
     * Empty check
     *
     * @return boolean true if list is empty
     */
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:08.619 -0500", hash_original_method = "FF43F4EB263E123805961D1A87217B48", hash_generated_method = "F540E74265E8FD3B0104DB3691099F57")
    
public boolean isEmpty() {
        return hlist.isEmpty();
    }

    /**
     * Get an initialized iterator for my imbedded list
     *
     * @return the generated ListIterator
     */
    @DSSafe(DSCat.DATA_STRUCTURE)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:08.621 -0500", hash_original_method = "36E257E69C92FC5D45CD0DCB007DB07A", hash_generated_method = "765263DBB9F52D22742C0677CC4C7BD4")
    
public ListIterator<HDR> listIterator() {

        return hlist.listIterator(0);
    }

    /**
     * Get the imbedded linked list.
     *
     * @return the imedded linked list of SIP headers.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:08.624 -0500", hash_original_method = "9E6C15618943805727A8B08583C0FF39", hash_generated_method = "1915FE8BC5C77ABA174AE011674FFC44")
    
public List<HDR> getHeaderList() {
        return this.hlist;
    }

    /**
     * Get the list iterator for a given position.
     *
     * @param position
     *            position for the list iterator to return
     * @return the generated list iterator
     */
    @DSSafe(DSCat.DATA_STRUCTURE)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:08.627 -0500", hash_original_method = "EDE82742DF271310D47CFC69F814BF44", hash_generated_method = "E5B689D6ABBE0E3C06D78A5F5688548E")
    
public ListIterator<HDR> listIterator(int position) {
        return hlist.listIterator(position);
    }

    /**
     * Remove the first element of this list.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:08.632 -0500", hash_original_method = "66F538C19C1B45B9F4975D517A08EBE7", hash_generated_method = "9AE1AEC462E0711E2705F635F396C136")
    @DSSafe(DSCat.SAFE_LIST) 
public void removeFirst() {
        if (hlist.size() != 0)
            hlist.remove(0);

    }

    /**
     * Remove the last element of this list.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:08.635 -0500", hash_original_method = "56685A1560151077841543B2BC810F93", hash_generated_method = "438653CD56BAA77611CAFBBADC3F6DC5")
    @DSSafe(DSCat.SAFE_LIST) 
public void removeLast() {
        if (hlist.size() != 0)
            hlist.remove(hlist.size() - 1);
    }

    /**
     * Remove a sip header from this list of sip headers.
     *
     * @param obj
     *            SIPHeader to remove
     * @return boolean
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:08.637 -0500", hash_original_method = "6090D81CA85470AC09234766F76789C0", hash_generated_method = "BF14AB6561EF00397BB414AC6D1395B7")
    @DSSafe(DSCat.SAFE_LIST) 
public boolean remove(HDR obj) {
        if (hlist.size() == 0)
            return false;
        else
            return hlist.remove(obj);
    }

    /**
     * Set the root class for all objects inserted into my list (for assertion
     * check)
     *
     * @param cl
     *            class to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:08.641 -0500", hash_original_method = "23B9304014C757503CC0D5B9D6DB550F", hash_generated_method = "FE282A1BA4803976A805E0476682E2C2")
    @DSSafe(DSCat.SAFE_LIST) 
protected void setMyClass(Class<HDR> cl) {
        this.myClass = cl;
    }

    /**
     * convert to a string representation (for printing).
     *
     * @param indentation
     *            int to set
     * @return String string representation of object (for printing).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:08.644 -0500", hash_original_method = "CC42CBF49D5975143777F4A2B14A482C", hash_generated_method = "A63B3964BB51A31D78901103FC617267")
    
public String debugDump(int indentation) {
        stringRepresentation = "";
        String indent = new Indentation(indentation).getIndentation();

        String className = this.getClass().getName();
        sprint(indent + className);
        sprint(indent + "{");

        for (Iterator<HDR> it = hlist.iterator(); it.hasNext();) {
            HDR sipHeader = (HDR) it.next();
            sprint(indent + sipHeader.debugDump());
        }
        sprint(indent + "}");
        return stringRepresentation;
    }

    /**
     * convert to a string representation
     *
     * @return String
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:08.647 -0500", hash_original_method = "ABFB21316126C2849AB41073C957D80E", hash_generated_method = "CA9FDAB05D64003C749F093A56047C05")
    
public String debugDump() {
        return debugDump(0);
    }

    /**
     * Array conversion.
     *
     * @return SIPHeader []
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:08.650 -0500", hash_original_method = "7EBA89BCEE46EEC5D25867CF89F8E8B9", hash_generated_method = "AFD4D64ED22ACE50EF1BB1B1A7A48939")
    
public Object[] toArray() {
        return hlist.toArray();

    }

    /**
     * index of an element.
     *
     * @return index of the given element (-1) if element does not exist.
     */
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:08.653 -0500", hash_original_method = "795B857E8950EF3C66EEA5946EF97E00", hash_generated_method = "348846283D89ED607D27C17EE4A9858E")
    
public int indexOf(GenericObject gobj) {
        return hlist.indexOf(gobj);
    }

    /**
     * insert at a location.
     *
     * @param index
     *            location where to add the sipHeader.
     * @param sipHeader
     *            SIPHeader structure to add.
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:08.656 -0500", hash_original_method = "D4A0602F4424EB672EFBEE9811EC3EF2", hash_generated_method = "994D15028CCE2587BC5BF1494F96A5CF")
    @DSSafe(DSCat.SAFE_LIST)
public void add(int index, HDR  sipHeader)
            throws IndexOutOfBoundsException {
        hlist.add(index, sipHeader);
    }

    /**
     * Equality comparison operator.
     *
     * @param other
     *            the other object to compare with. true is returned iff the
     *            classes match and list of headers herein is equal to the list
     *            of headers in the target (order of the headers is not
     *            important).
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:08.659 -0500", hash_original_method = "7AF224A0221DFF0013A72A01287D2D95", hash_generated_method = "819F4559335C9CF8A66F92D1D8519B6E")
    
@SuppressWarnings("unchecked")
    public boolean equals(Object other) {

        if (other == this)
            return true;

        if (other instanceof SIPHeaderList) {
            SIPHeaderList<SIPHeader> that = (SIPHeaderList<SIPHeader>) other;
            if (this.hlist == that.hlist)
                return true;
            else if (this.hlist == null)
                return that.hlist == null || that.hlist.size() == 0;
            return this.hlist.equals(that.hlist);
        }
        return false;
    }

    /**
     * Template match against a template. null field in template indicates wild
     * card match.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:08.664 -0500", hash_original_method = "6ED02991F9AD79524F79D6703964DFB6", hash_generated_method = "23ED2E4757232F6FD7BCDFDE5B223E43")
    
public boolean match(SIPHeaderList<?> template) {
        if (template == null)
            return true;
        if (!this.getClass().equals(template.getClass()))
            return false;
        SIPHeaderList<SIPHeader> that = (SIPHeaderList<SIPHeader>) template;
        if (this.hlist == that.hlist)
            return true;
        else if (this.hlist == null)
            return false;
        else {

            for (Iterator<SIPHeader> it = that.hlist.iterator(); it.hasNext();) {
                SIPHeader sipHeader = (SIPHeader) it.next();

                boolean found = false;
                for (Iterator<HDR> it1 = this.hlist.iterator(); it1.hasNext()
                        && !found;) {
                    SIPHeader sipHeader1 = (SIPHeader) it1.next();
                    found = sipHeader1.match(sipHeader);
                }
                if (!found)
                    return false;
            }
            return true;
        }
    }

    /**
     * make a clone of this header list.
     *
     * @return clone of this Header.
     */
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:08.667 -0500", hash_original_method = "359991759D26E2A3F33ACAEA17758D18", hash_generated_method = "DF397C0487B7030073A58781A19C1EEE")
    
public Object clone() {
        try {
            Class<?> clazz = this.getClass();

            Constructor<?> cons = clazz.getConstructor((Class[])null);
            SIPHeaderList<HDR> retval = (SIPHeaderList<HDR>) cons.newInstance((Object[])null);
            retval.headerName = this.headerName;
            retval.myClass  = this.myClass;
            return retval.clonehlist(this.hlist);
        } catch (Exception ex) {
            throw new RuntimeException("Could not clone!", ex);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:08.670 -0500", hash_original_method = "CA032BB58CFE2AE5C2CC307C2E78224F", hash_generated_method = "74C76046F8D1164B9DC25D24C80317D9")
    
protected final SIPHeaderList<HDR> clonehlist(List<HDR> hlistToClone) {
        if (hlistToClone != null) {
            for (Iterator<HDR> it = (Iterator<HDR>) hlistToClone.iterator(); it.hasNext();) {
                Header h = it.next();
                this.hlist.add((HDR)h.clone());
            }
        }
        return this;
    }

    /**
     * Get the number of headers in the list.
     */
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:08.673 -0500", hash_original_method = "FCBD3ECE23AA666BDE06756DAACE9219", hash_generated_method = "562F7FD4E7CCD444CD48E6FB580E5C32")
    
public int size() {
        return hlist.size();
    }

    /**
     * Return true if this is a header list (overrides the base class method
     * which returns false).
     *
     * @return true
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:08.677 -0500", hash_original_method = "32932F147EA25CC7B7BC47F740C6BF91", hash_generated_method = "0DC811C156890046C4A2AB310C83BF76")
    
public boolean isHeaderList() {
        return true;
    }

    /**
     * Encode the body of this header (the stuff that follows headerName). A.K.A
     * headerValue. This will not give a reasonable result for WWW-Authenticate,
     * Authorization, Proxy-Authenticate and Proxy-Authorization and hence this
     * is protected.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:08.680 -0500", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "BBFCFD2AD6BD270AD38D8FE87FD0572B")
    
protected String encodeBody() {
        return encodeBody(new StringBuffer()).toString();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:08.683 -0500", hash_original_method = "8EFAAECA9CE0AC45762D4D910A6D9585", hash_generated_method = "61808CFC1656C3F3D4153C2FD2D330E1")
    
protected StringBuffer encodeBody(StringBuffer buffer) {
        ListIterator<HDR> iterator = this.listIterator();
        while (true) {
            SIPHeader sipHeader = (SIPHeader) iterator.next();
            if ( sipHeader == this ) throw new RuntimeException ("Unexpected circularity in SipHeaderList");
            sipHeader.encodeBody(buffer);
            // if (body.equals("")) System.out.println("BODY == ");
            if (iterator.hasNext()) {
                if (!this.headerName.equals(PrivacyHeader.NAME))
                    buffer.append(Separators.COMMA);
                else
                    buffer.append(Separators.SEMICOLON);
                continue;
            } else
                break;

        }
        return buffer;
    }

    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:08.686 -0500", hash_original_method = "D5DDE9BDBABBA5EC4E7B0879A10A7D8D", hash_generated_method = "BFBB847B654FE2CC083CE01E67A19D9B")
    
public boolean addAll(Collection<? extends HDR> collection) {
        return this.hlist.addAll(collection);
    }

    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:08.689 -0500", hash_original_method = "5E3DA6DCBC302D72E9103E3CB1D3527B", hash_generated_method = "E4F69B7A71A96C867BBBAF4E17B7E2A3")
    
public boolean addAll(int index, Collection<? extends HDR> collection) {
        return this.hlist.addAll(index, collection);

    }

    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:08.692 -0500", hash_original_method = "F1DA48A9A827D74FF9F3AEB298E80E0A", hash_generated_method = "F2C05BF8E74DFEF8E6CC6B3BE48637D3")
    
public boolean containsAll(Collection<?> collection) {
        return this.hlist.containsAll(collection);
    }

    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:08.695 -0500", hash_original_method = "D791B8D331C82850017A4DF87B2D73FE", hash_generated_method = "DD48FCDD38D43309D1E9BD10583894DA")
    
public void clear() {
        this.hlist.clear();
    }

    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:08.698 -0500", hash_original_method = "B039DF80CC42319FF93C93DFC4F09CCF", hash_generated_method = "EB644998ED00092BE046641143971738")
    
public boolean contains(Object header) {
        return this.hlist.contains(header);
    }

    /**
     * Get the object at the specified location.
     *
     * @param index --
     *            location from which to get the object.
     *
     */
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:08.701 -0500", hash_original_method = "B0FF15B145547E100ED44D45A7137CDE", hash_generated_method = "F46DEB9CDD87E07C4051278902E10473")
    
public HDR get(int index) {
        return  this.hlist.get(index);
    }

    /**
     * Return the index of a given object.
     *
     * @param obj --
     *            object whose index to compute.
     */
    @DSSafe(DSCat.DATA_STRUCTURE)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:08.705 -0500", hash_original_method = "9C1A1055EA03DFB32FF882EA4FC9149D", hash_generated_method = "59A048735E082051D84A211B25F71E16")
    
public int indexOf(Object obj) {
        return this.hlist.indexOf(obj);
    }

    /**
     * Return the iterator to the imbedded list.
     *
     * @return iterator to the imbedded list.
     *
     */

    @DSSafe(DSCat.SAFE_OTHERS)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:08.708 -0500", hash_original_method = "84FF645EE0B76DB0D5B552F9A7A0DC94", hash_generated_method = "2C9F9172277FBCC77F44B8EB9FF01C29")
    
public java.util.Iterator<HDR> iterator() {
        return this.hlist.listIterator();
    }

    /**
     * Get the last index of the given object.
     *
     * @param obj --
     *            object whose index to find.
     */
    @DSSafe(DSCat.DATA_STRUCTURE)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:08.711 -0500", hash_original_method = "05A7D65C6D911E0B1F3261A66888CB52", hash_generated_method = "3AFFFBA2DDE5D54646A6F203B3BBAF40")
    
public int lastIndexOf(Object obj) {

        return this.hlist.lastIndexOf(obj);
    }

    /**
     * Remove the given object.
     *
     * @param obj --
     *            object to remove.
     *
     */

    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:08.715 -0500", hash_original_method = "FB49499CFAFE2E72F27390E6807CB034", hash_generated_method = "260C3A1E9B90029916A52C1DCC486CE4")
    
public boolean remove(Object obj) {

        return this.hlist.remove(obj);
    }

    /**
     * Remove the object at a given index.
     *
     * @param index --
     *            index at which to remove the object
     */

    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:08.719 -0500", hash_original_method = "2B7049D180B166140C32B8D54A96E238", hash_generated_method = "E3B492E3EA37500381FA59083A1CD08A")
    
public HDR remove(int index) {
        return this.hlist.remove(index);
    }

    /**
     * Remove all the elements.
     * @see List#removeAll(java.util.Collection)
     */
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:08.725 -0500", hash_original_method = "5A03B3005777615BF04A1D43320D1AA1", hash_generated_method = "A568AD10F00EA2CC70306780A6D6D9DD")
    
public boolean removeAll(java.util.Collection<?> collection) {
        return this.hlist.removeAll(collection);
    }

    /**
     * @see List#retainAll(java.util.Collection)
     * @param collection
     */
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:08.731 -0500", hash_original_method = "4FD342E6A050272CE06CEE9969944C1B", hash_generated_method = "8003CE05FE216B9ACB6AE8B5310557B9")
    
public boolean retainAll(java.util.Collection<?> collection) {
        return this.hlist.retainAll(collection);
    }

    /**
     * Get a sublist of the list.
     *
     * @see List#subList(int, int)
     */
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:08.736 -0500", hash_original_method = "894CB5A5FAD7AFC5CD5A3389B3F77AB4", hash_generated_method = "35638E214210D780397781FC12C13372")
    
public java.util.List<HDR> subList(int index1, int index2) {
        return this.hlist.subList(index1, index2);

    }

    /**
     * @see Object#hashCode()
     * @return -- the computed hashcode.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:08.741 -0500", hash_original_method = "78242797F449E5EBFB278CC5A6BC56D0", hash_generated_method = "684C0BABDAF236671E858A8C4C737032")
    
public int hashCode() {

        return this.headerName.hashCode();
    }

    /**
     * Set a SIPHeader at a particular position in the list.
     *
     * @see List#set(int, java.lang.Object)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:08.744 -0500", hash_original_method = "A9FD382DBA3FE66AACB46D6203100A0D", hash_generated_method = "C6D352BFFEECAC0F38AAD655317FD08C")
    @DSSafe(DSCat.SAFE_LIST) 
public HDR set(int position, HDR sipHeader) {

        return hlist.set(position, sipHeader);

    }
        
@DSSafe(DSCat.SAFE_OTHERS)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.339 -0400", hash_original_method = "B04CD19C0316B320C5B66A678FB2994B", hash_generated_method = "913F231D737BF10A7AB8B832C5BAA111")
    public <T> T[] toArray(T[] array) {
        addTaint(array[0].getTaint());
T[] var0350DC20E51885F26BC9AE21A5634403_1012850215 =         this.hlist.toArray(array);
        var0350DC20E51885F26BC9AE21A5634403_1012850215.addTaint(getTaint());
        return var0350DC20E51885F26BC9AE21A5634403_1012850215;
        // ---------- Original Method ----------
        //return this.hlist.toArray(array);
    }
}

