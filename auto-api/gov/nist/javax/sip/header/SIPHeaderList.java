package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.core.GenericObject;
import gov.nist.core.Separators;
import gov.nist.javax.sip.header.ims.PrivacyHeader;
import javax.sip.header.Header;
import java.lang.reflect.Constructor;
import java.util.*;

public abstract class SIPHeaderList<HDR extends SIPHeader> extends SIPHeader implements java.util.List<HDR>, Header {
    protected List<HDR> hlist;
    private Class<HDR> myClass;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.342 -0400", hash_original_method = "D7E30AE5F54C678856B1E2B4E08FADF6", hash_generated_method = "DD0314912C40308B77D7E83CB7E4756A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private SIPHeaderList() {
        hlist = new LinkedList<HDR>();
        // ---------- Original Method ----------
        //hlist = new LinkedList<HDR>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.342 -0400", hash_original_method = "C956079DDC347F2EE85C1D1E44860715", hash_generated_method = "C7B3FB785CA896201460115552DF489B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected SIPHeaderList(Class<HDR> objclass, String hname) {
        this();
        dsTaint.addTaint(objclass.dsTaint);
        dsTaint.addTaint(hname);
        this.headerName = hname;
        // ---------- Original Method ----------
        //this.headerName = hname;
        //this.myClass =  objclass;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.343 -0400", hash_original_method = "5A8D65821D08B5534EF9F59F256EB0ED", hash_generated_method = "D08943AA2502BFC3B901E809ADE0ED44")
    @DSModeled(DSC.SAFE)
    public String getName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.headerName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.343 -0400", hash_original_method = "45FF804DBFA2BB4F4071CDF27CE28633", hash_generated_method = "40BFEDC8D75357D347290C285EFAD096")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean add(HDR objectToAdd) {
        dsTaint.addTaint(objectToAdd.dsTaint);
        hlist.add((HDR)objectToAdd);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //hlist.add((HDR)objectToAdd);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.343 -0400", hash_original_method = "87B618AF10705C22EFB36E4A71158D56", hash_generated_method = "3AE6C8675B7E956F45E4D94D2C2A261E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addFirst(HDR obj) {
        dsTaint.addTaint(obj.dsTaint);
        hlist.add(0,(HDR) obj);
        // ---------- Original Method ----------
        //hlist.add(0,(HDR) obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.343 -0400", hash_original_method = "3D14CCA72C816FE4801BBC05991E4343", hash_generated_method = "5EE01AE6CC25921A4510FC8B3C5289C8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void add(HDR sipheader, boolean top) {
        dsTaint.addTaint(sipheader.dsTaint);
        dsTaint.addTaint(top);
        this.addFirst(sipheader);
        this.add(sipheader);
        // ---------- Original Method ----------
        //if (top)
            //this.addFirst(sipheader);
        //else
            //this.add(sipheader);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.343 -0400", hash_original_method = "2C5EDAC0235777863EFD087B4072277C", hash_generated_method = "80503162FC17C485D21710C8A3F2B74C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void concatenate(SIPHeaderList<HDR> other, boolean topFlag) throws IllegalArgumentException {
        dsTaint.addTaint(other.dsTaint);
        dsTaint.addTaint(topFlag);
        {
            this.addAll(other);
        } //End block
        {
            this.addAll(0, other);
        } //End block
        // ---------- Original Method ----------
        //if (!topFlag) {
            //this.addAll(other);
        //} else {
            //this.addAll(0, other);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.344 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "2CCF802C3AB051E31C7272359E1B51CC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String encode() {
        String varFFB45C40AF627644780ECFF5921CFE15_120798033 = (encode(new StringBuffer()).toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return encode(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.344 -0400", hash_original_method = "4452028BB43CC449CBD4FD5523C455CD", hash_generated_method = "4183FDB8BAA42A52FD7514B3508F8EA4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringBuffer encode(StringBuffer buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        {
            boolean varADCB242902E2A36C5E7E88B9C037FBC8_1332925513 = (hlist.isEmpty());
            {
                buffer.append(headerName).append(':').append(Separators.NEWLINE);
            } //End block
            {
                {
                    boolean varAA9EB60710CB021FA924A856488476AF_1741201468 = (this.headerName.equals(SIPHeaderNames.WWW_AUTHENTICATE)
                    || this.headerName.equals(SIPHeaderNames.PROXY_AUTHENTICATE)
                    || this.headerName.equals(SIPHeaderNames.AUTHORIZATION)
                    || this.headerName.equals(SIPHeaderNames.PROXY_AUTHORIZATION)
                    || (prettyEncode &&
                            (this.headerName.equals(SIPHeaderNames.VIA) || this.headerName.equals(SIPHeaderNames.ROUTE) || this.headerName.equals(SIPHeaderNames.RECORD_ROUTE))) 
                    || this.getClass().equals( ExtensionHeaderList.class));
                    {
                        ListIterator<HDR> li;
                        li = hlist.listIterator();
                        {
                            boolean varD36012C5F0076A971BB5DCB92CB4D117_1705871410 = (li.hasNext());
                            {
                                HDR sipheader;
                                sipheader = (HDR) li.next();
                                sipheader.encode(buffer);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    {
                        buffer.append(headerName).append(Separators.COLON).append(Separators.SP);
                        this.encodeBody(buffer);
                        buffer.append(Separators.NEWLINE);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return (StringBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.344 -0400", hash_original_method = "3A5F29F99CF35D16AD0C376ECAFA4E44", hash_generated_method = "958BB4DB0249A96186FBB99E57F0307C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<String> getHeadersAsEncodedStrings() {
        List<String> retval;
        retval = new LinkedList<String>();
        ListIterator<HDR> li;
        li = hlist.listIterator();
        {
            boolean varBC3D864DE8830EFC1098D2C2F456529D_147198027 = (li.hasNext());
            {
                Header sipheader;
                sipheader = li.next();
                retval.add(sipheader.toString());
            } //End block
        } //End collapsed parenthetic
        return (List<String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //List<String> retval = new LinkedList<String>();
        //ListIterator<HDR> li = hlist.listIterator();
        //while (li.hasNext()) {
            //Header sipheader = li.next();
            //retval.add(sipheader.toString());
        //}
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.345 -0400", hash_original_method = "6C7059400A289BDBD2DC174FD9546E0E", hash_generated_method = "F6792CA1411F0616AFBBB79200DC2C1E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Header getFirst() {
        {
            boolean varBC3C1D335DC6F5058F706F5D73C7DB2D_964191454 = (hlist == null || hlist.isEmpty());
            Header var11D0729BC53C745953E902C9A6D94412_274044563 = (hlist.get(0));
        } //End collapsed parenthetic
        return (Header)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (hlist == null || hlist.isEmpty())
            //return null;
        //else
            //return  hlist.get(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.345 -0400", hash_original_method = "564DA566938B5DEC3F30C613889BA2FD", hash_generated_method = "7129AFBF93CAE09BAAA3FD0610F84261")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Header getLast() {
        {
            boolean varBC3C1D335DC6F5058F706F5D73C7DB2D_1980617083 = (hlist == null || hlist.isEmpty());
        } //End collapsed parenthetic
        Header var2A6183282ED64CFBBFB4843392BD7116_1823308627 = (hlist.get(hlist.size() - 1));
        return (Header)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (hlist == null || hlist.isEmpty())
            //return null;
        //return  hlist.get(hlist.size() - 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.345 -0400", hash_original_method = "52DB400388897C60F1E5D7C5CF768C2C", hash_generated_method = "D563EB3475F3809BD3C760528FA08D7E")
    @DSModeled(DSC.SAFE)
    public Class<HDR> getMyClass() {
        return (Class<HDR>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return  this.myClass;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.345 -0400", hash_original_method = "FF43F4EB263E123805961D1A87217B48", hash_generated_method = "4114333A589D38E9CA6679A6097EFC6A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isEmpty() {
        boolean varE0F068754A4434D383386203B916E809_1462492600 = (hlist.isEmpty());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return hlist.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.345 -0400", hash_original_method = "36E257E69C92FC5D45CD0DCB007DB07A", hash_generated_method = "2D7163B5D5FBB35FC60AB09DD148F5B0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ListIterator<HDR> listIterator() {
        ListIterator<HDR> var3122E5ACE0A5E7A0EFED51545470CFD7_956894389 = (hlist.listIterator(0));
        return (ListIterator<HDR>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return hlist.listIterator(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.345 -0400", hash_original_method = "9E6C15618943805727A8B08583C0FF39", hash_generated_method = "D4AD4DDE6B83FA09BD9EEA419C02AC94")
    @DSModeled(DSC.SAFE)
    public List<HDR> getHeaderList() {
        return (List<HDR>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.hlist;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.346 -0400", hash_original_method = "EDE82742DF271310D47CFC69F814BF44", hash_generated_method = "912ED8815CB4FDA19331BC67256726CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ListIterator<HDR> listIterator(int position) {
        dsTaint.addTaint(position);
        ListIterator<HDR> var17A7068B8B381EEDC05B279F2A77D190_1351332691 = (hlist.listIterator(position));
        return (ListIterator<HDR>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return hlist.listIterator(position);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.346 -0400", hash_original_method = "66F538C19C1B45B9F4975D517A08EBE7", hash_generated_method = "C787F8949631386E15F46FCC6DD1C205")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeFirst() {
        {
            boolean varEF2906AB9D37F5F9FE2592D0F985ED0F_449087610 = (hlist.size() != 0);
            hlist.remove(0);
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (hlist.size() != 0)
            //hlist.remove(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.346 -0400", hash_original_method = "56685A1560151077841543B2BC810F93", hash_generated_method = "21C806F782742528078EE2E31A901AE7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeLast() {
        {
            boolean varEF2906AB9D37F5F9FE2592D0F985ED0F_134258254 = (hlist.size() != 0);
            hlist.remove(hlist.size() - 1);
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (hlist.size() != 0)
            //hlist.remove(hlist.size() - 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.346 -0400", hash_original_method = "6090D81CA85470AC09234766F76789C0", hash_generated_method = "577D719E2026789040AAA1CE0B2F5A52")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean remove(HDR obj) {
        dsTaint.addTaint(obj.dsTaint);
        {
            boolean varE27C8BEA585DAC7A51DC79C569D41E9A_569173371 = (hlist.size() == 0);
            boolean varD8FBF7C33228C788AD0720ECF32B962A_41878856 = (hlist.remove(obj));
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (hlist.size() == 0)
            //return false;
        //else
            //return hlist.remove(obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.346 -0400", hash_original_method = "23B9304014C757503CC0D5B9D6DB550F", hash_generated_method = "A664BDAF3F7E2153AE3667549E08C020")
    @DSModeled(DSC.SAFE)
    protected void setMyClass(Class<HDR> cl) {
        dsTaint.addTaint(cl.dsTaint);
        // ---------- Original Method ----------
        //this.myClass = cl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.347 -0400", hash_original_method = "CC42CBF49D5975143777F4A2B14A482C", hash_generated_method = "630564AC6C27350501741505836F98EA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String debugDump(int indentation) {
        dsTaint.addTaint(indentation);
        stringRepresentation = "";
        String indent;
        indent = new Indentation(indentation).getIndentation();
        String className;
        className = this.getClass().getName();
        sprint(indent + className);
        sprint(indent + "{");
        {
            Iterator<HDR> it;
            it = hlist.iterator();
            boolean var03729FD53960D8DCA3A41A13A0229637_949771728 = (it.hasNext());
            {
                HDR sipHeader;
                sipHeader = (HDR) it.next();
                sprint(indent + sipHeader.debugDump());
            } //End block
        } //End collapsed parenthetic
        sprint(indent + "}");
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //stringRepresentation = "";
        //String indent = new Indentation(indentation).getIndentation();
        //String className = this.getClass().getName();
        //sprint(indent + className);
        //sprint(indent + "{");
        //for (Iterator<HDR> it = hlist.iterator(); it.hasNext();) {
            //HDR sipHeader = (HDR) it.next();
            //sprint(indent + sipHeader.debugDump());
        //}
        //sprint(indent + "}");
        //return stringRepresentation;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.347 -0400", hash_original_method = "ABFB21316126C2849AB41073C957D80E", hash_generated_method = "D1C655060C8999898701BDDC26D7CE06")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String debugDump() {
        String var127645791C8E629A8AB8A6924EA2CD86_1139931201 = (debugDump(0));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return debugDump(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.347 -0400", hash_original_method = "7EBA89BCEE46EEC5D25867CF89F8E8B9", hash_generated_method = "D3980D0707353B09CE84ECEA05CF9457")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object[] toArray() {
        Object[] var94FB6D0654B65C10E9B10840E26F6F3D_1903744714 = (hlist.toArray());
        return (Object[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return hlist.toArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.347 -0400", hash_original_method = "795B857E8950EF3C66EEA5946EF97E00", hash_generated_method = "0182A30F3BD2365E24CACD15C1756564")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int indexOf(GenericObject gobj) {
        dsTaint.addTaint(gobj.dsTaint);
        int varFE7F2AD0158B0E9DB2F579EDDA049625_1820901735 = (hlist.indexOf(gobj));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return hlist.indexOf(gobj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.347 -0400", hash_original_method = "D4A0602F4424EB672EFBEE9811EC3EF2", hash_generated_method = "5BEE9593CA53264DD08B814EC19B9BFE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void add(int index, HDR  sipHeader) throws IndexOutOfBoundsException {
        dsTaint.addTaint(sipHeader.dsTaint);
        dsTaint.addTaint(index);
        hlist.add(index, sipHeader);
        // ---------- Original Method ----------
        //hlist.add(index, sipHeader);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.347 -0400", hash_original_method = "7AF224A0221DFF0013A72A01287D2D95", hash_generated_method = "906294644ECEDD7A2C0FD9112F30E60D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
    public boolean equals(Object other) {
        dsTaint.addTaint(other.dsTaint);
        {
            boolean var140A8815FDEEC27C4D8944D501CA10BC_1147143551 = (other == this);
        } //End collapsed parenthetic
        {
            SIPHeaderList<SIPHeader> that;
            that = (SIPHeaderList<SIPHeader>) other;
            boolean varB0759ED93504D2871EADB7BC17D112AC_782611471 = (that.hlist == null || that.hlist.size() == 0);
            boolean var5490630F41DAE65E89132ADE4761F7BB_858511721 = (this.hlist.equals(that.hlist));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (other == this)
            //return true;
        //if (other instanceof SIPHeaderList) {
            //SIPHeaderList<SIPHeader> that = (SIPHeaderList<SIPHeader>) other;
            //if (this.hlist == that.hlist)
                //return true;
            //else if (this.hlist == null)
                //return that.hlist == null || that.hlist.size() == 0;
            //return this.hlist.equals(that.hlist);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.348 -0400", hash_original_method = "6ED02991F9AD79524F79D6703964DFB6", hash_generated_method = "EF42A9135C38BE8EEF0C8BD084EBE8AE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean match(SIPHeaderList<?> template) {
        dsTaint.addTaint(template.dsTaint);
        {
            boolean var42D525C71BB0E2BEC53AF10700E42587_371607265 = (!this.getClass().equals(template.getClass()));
        } //End collapsed parenthetic
        SIPHeaderList<SIPHeader> that;
        that = (SIPHeaderList<SIPHeader>) template;
        {
            {
                Iterator<SIPHeader> it;
                it = that.hlist.iterator();
                boolean varB2FF4435B274CC4BE01D264DEA08F957_650460580 = (it.hasNext());
                {
                    SIPHeader sipHeader;
                    sipHeader = (SIPHeader) it.next();
                    boolean found;
                    found = false;
                    {
                        Iterator<HDR> it1;
                        it1 = this.hlist.iterator();
                        boolean varD776FD1A955609D835179BFFD00F64DE_1770459623 = (it1.hasNext()
                        && !found);
                        {
                            SIPHeader sipHeader1;
                            sipHeader1 = (SIPHeader) it1.next();
                            found = sipHeader1.match(sipHeader);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.348 -0400", hash_original_method = "359991759D26E2A3F33ACAEA17758D18", hash_generated_method = "8B9E5B994A0736A167874C86B7299B37")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        try 
        {
            Class<?> clazz;
            clazz = this.getClass();
            Constructor<?> cons;
            cons = clazz.getConstructor((Class[])null);
            SIPHeaderList<HDR> retval;
            retval = (SIPHeaderList<HDR>) cons.newInstance((Object[])null);
            retval.headerName = this.headerName;
            retval.myClass  = this.myClass;
            Object var268B79BB48973E13E6E396F5746A92B1_1043956769 = (retval.clonehlist(this.hlist));
        } //End block
        catch (Exception ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Could not clone!", ex);
        } //End block
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //Class<?> clazz = this.getClass();
            //Constructor<?> cons = clazz.getConstructor((Class[])null);
            //SIPHeaderList<HDR> retval = (SIPHeaderList<HDR>) cons.newInstance((Object[])null);
            //retval.headerName = this.headerName;
            //retval.myClass  = this.myClass;
            //return retval.clonehlist(this.hlist);
        //} catch (Exception ex) {
            //throw new RuntimeException("Could not clone!", ex);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.348 -0400", hash_original_method = "CA032BB58CFE2AE5C2CC307C2E78224F", hash_generated_method = "5FD9370EEAECF3FFD198B317FBBCB647")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected final SIPHeaderList<HDR> clonehlist(List<HDR> hlistToClone) {
        dsTaint.addTaint(hlistToClone.dsTaint);
        {
            {
                Iterator<HDR> it;
                it = (Iterator<HDR>) hlistToClone.iterator();
                boolean varB2FF4435B274CC4BE01D264DEA08F957_1990846179 = (it.hasNext());
                {
                    Header h;
                    h = it.next();
                    this.hlist.add((HDR)h.clone());
                } //End block
            } //End collapsed parenthetic
        } //End block
        return (SIPHeaderList<HDR>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (hlistToClone != null) {
            //for (Iterator<HDR> it = (Iterator<HDR>) hlistToClone.iterator(); it.hasNext();) {
                //Header h = it.next();
                //this.hlist.add((HDR)h.clone());
            //}
        //}
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.349 -0400", hash_original_method = "FCBD3ECE23AA666BDE06756DAACE9219", hash_generated_method = "C5A1FB5670B39D608C200061D9B567FF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int size() {
        int varAD7F07CB7D5D3937AFE4543892270C80_1090721296 = (hlist.size());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return hlist.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.349 -0400", hash_original_method = "32932F147EA25CC7B7BC47F740C6BF91", hash_generated_method = "3BDB32B227E014831CD9411C785ED1A1")
    @DSModeled(DSC.SAFE)
    public boolean isHeaderList() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.349 -0400", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "03EC4F1C456B305DB3C03FA5E0D7DAC2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected String encodeBody() {
        String var1FB3D4520BF100042DCF9757D0219988_51347492 = (encodeBody(new StringBuffer()).toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return encodeBody(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.349 -0400", hash_original_method = "8EFAAECA9CE0AC45762D4D910A6D9585", hash_generated_method = "CA005820E2F6738FC38C1F7BDA1A21FF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected StringBuffer encodeBody(StringBuffer buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        ListIterator<HDR> iterator;
        iterator = this.listIterator();
        {
            SIPHeader sipHeader;
            sipHeader = (SIPHeader) iterator.next();
            {
                boolean var81FA26130A77648ABA9F7EE49157FB67_1233500401 = (sipHeader == this);
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException ("Unexpected circularity in SipHeaderList");
            } //End collapsed parenthetic
            sipHeader.encodeBody(buffer);
            {
                boolean var863C7B066016334243F11BA2A858D956_1780307487 = (iterator.hasNext());
                {
                    {
                        boolean varEC2BFBCD9D89F853D1F8004544E80422_1923318531 = (!this.headerName.equals(PrivacyHeader.NAME));
                        buffer.append(Separators.COMMA);
                        buffer.append(Separators.SEMICOLON);
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        return (StringBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ListIterator<HDR> iterator = this.listIterator();
        //while (true) {
            //SIPHeader sipHeader = (SIPHeader) iterator.next();
            //if ( sipHeader == this ) throw new RuntimeException ("Unexpected circularity in SipHeaderList");
            //sipHeader.encodeBody(buffer);
            //if (iterator.hasNext()) {
                //if (!this.headerName.equals(PrivacyHeader.NAME))
                    //buffer.append(Separators.COMMA);
                //else
                    //buffer.append(Separators.SEMICOLON);
                //continue;
            //} else
                //break;
        //}
        //return buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.349 -0400", hash_original_method = "D5DDE9BDBABBA5EC4E7B0879A10A7D8D", hash_generated_method = "DAECB2C8746A70617A31246120FA89DF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean addAll(Collection<? extends HDR> collection) {
        dsTaint.addTaint(collection.dsTaint);
        boolean var9940151E0E552CDF60A32A4F5430F34D_620851419 = (this.hlist.addAll(collection));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this.hlist.addAll(collection);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.350 -0400", hash_original_method = "5E3DA6DCBC302D72E9103E3CB1D3527B", hash_generated_method = "38B8C699C90851DBE09686B6AAB4DE76")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean addAll(int index, Collection<? extends HDR> collection) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(collection.dsTaint);
        boolean varEFE51ECFC9507D8AC4C14D317E8D6CB0_860951149 = (this.hlist.addAll(index, collection));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this.hlist.addAll(index, collection);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.350 -0400", hash_original_method = "F1DA48A9A827D74FF9F3AEB298E80E0A", hash_generated_method = "3FB123C076A2616E07780892472AC350")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean containsAll(Collection<?> collection) {
        dsTaint.addTaint(collection.dsTaint);
        boolean varD2618BE52D31E66DA0B87AF95177D40B_208303663 = (this.hlist.containsAll(collection));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this.hlist.containsAll(collection);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.350 -0400", hash_original_method = "D791B8D331C82850017A4DF87B2D73FE", hash_generated_method = "7B3736200B6CC37F2F0C36EB7F8C7C36")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void clear() {
        this.hlist.clear();
        // ---------- Original Method ----------
        //this.hlist.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.350 -0400", hash_original_method = "B039DF80CC42319FF93C93DFC4F09CCF", hash_generated_method = "A3C2600AF44C0BA3319859DF8B275EA8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean contains(Object header) {
        dsTaint.addTaint(header.dsTaint);
        boolean varFF9B9114D30EEBE8FF7C2118E12A9B47_572809340 = (this.hlist.contains(header));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this.hlist.contains(header);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.350 -0400", hash_original_method = "B0FF15B145547E100ED44D45A7137CDE", hash_generated_method = "A087641A4DFAF24CD6E3858884112A8D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public HDR get(int index) {
        dsTaint.addTaint(index);
        HDR varAB41816B7BEEDE6432C1A2BAB43CBA4F_1800150329 = (this.hlist.get(index));
        return (HDR)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return  this.hlist.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.350 -0400", hash_original_method = "9C1A1055EA03DFB32FF882EA4FC9149D", hash_generated_method = "D3B24D9AF9806C3A958DFE0B066F7A05")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int indexOf(Object obj) {
        dsTaint.addTaint(obj.dsTaint);
        int varBEC02A7A8B6C276C18FAB86ECDD19E4E_1585577489 = (this.hlist.indexOf(obj));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.hlist.indexOf(obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.351 -0400", hash_original_method = "84FF645EE0B76DB0D5B552F9A7A0DC94", hash_generated_method = "E147DD34B2616CF12ED2BB46AD9A20CA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public java.util.Iterator<HDR> iterator() {
        java.util.Iterator<HDR> varB6724506EE1644BAB539AB32B17EE8AF_561580858 = (this.hlist.listIterator());
        return (java.util.Iterator<HDR>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.hlist.listIterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.351 -0400", hash_original_method = "05A7D65C6D911E0B1F3261A66888CB52", hash_generated_method = "2D761ED6FE441E438B58E1AEDD90793A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int lastIndexOf(Object obj) {
        dsTaint.addTaint(obj.dsTaint);
        int varD48BB8B2C188D796AB5E25DB24A359A2_222137600 = (this.hlist.lastIndexOf(obj));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.hlist.lastIndexOf(obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.351 -0400", hash_original_method = "FB49499CFAFE2E72F27390E6807CB034", hash_generated_method = "5CADE307794690B54276198CD07CC29B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean remove(Object obj) {
        dsTaint.addTaint(obj.dsTaint);
        boolean varA126E10370F872777A607D5086A88085_2088111353 = (this.hlist.remove(obj));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this.hlist.remove(obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.351 -0400", hash_original_method = "2B7049D180B166140C32B8D54A96E238", hash_generated_method = "A4633966880A0E6B5A1E5AF5BD10AE7A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public HDR remove(int index) {
        dsTaint.addTaint(index);
        HDR varE529D0AF64560AA6810B2B638CC6442C_81730100 = (this.hlist.remove(index));
        return (HDR)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.hlist.remove(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.351 -0400", hash_original_method = "5A03B3005777615BF04A1D43320D1AA1", hash_generated_method = "C9BCC4EABEFB14E0906F1885472DD5AB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean removeAll(java.util.Collection<?> collection) {
        dsTaint.addTaint(collection.dsTaint);
        boolean var1B94C4550E9AC61EE706C14BF778F96F_144823768 = (this.hlist.removeAll(collection));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this.hlist.removeAll(collection);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.351 -0400", hash_original_method = "4FD342E6A050272CE06CEE9969944C1B", hash_generated_method = "F3C27FCB87B28E1F62F56A2A5062F227")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean retainAll(java.util.Collection<?> collection) {
        dsTaint.addTaint(collection.dsTaint);
        boolean varD3CD1D943CC0A6AFD9C7DA463C27ADE5_1561321096 = (this.hlist.retainAll(collection));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this.hlist.retainAll(collection);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.352 -0400", hash_original_method = "894CB5A5FAD7AFC5CD5A3389B3F77AB4", hash_generated_method = "2CBCBA9742662287C8D8155F14AAD1FC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public java.util.List<HDR> subList(int index1, int index2) {
        dsTaint.addTaint(index1);
        dsTaint.addTaint(index2);
        java.util.List<HDR> var72B25F40B615F09664CC2BAB8DA9ECF7_1030920508 = (this.hlist.subList(index1, index2));
        return (java.util.List<HDR>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.hlist.subList(index1, index2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.352 -0400", hash_original_method = "78242797F449E5EBFB278CC5A6BC56D0", hash_generated_method = "9C97E65E2199105CD214C130CEBCB061")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int hashCode() {
        int var4B8D37533CC12365BECFAB730FC9EDC2_1015459194 = (this.headerName.hashCode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.headerName.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.352 -0400", hash_original_method = "A9FD382DBA3FE66AACB46D6203100A0D", hash_generated_method = "098247D9BF07DB474DBDB9D294BFCF4C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public HDR set(int position, HDR sipHeader) {
        dsTaint.addTaint(position);
        dsTaint.addTaint(sipHeader.dsTaint);
        HDR varFEFD89B90DDE20EAAF1DA527ACE2C8D0_886434523 = (hlist.set(position, sipHeader));
        return (HDR)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return hlist.set(position, sipHeader);
    }

    
        public static void setPrettyEncode(boolean flag) {
        prettyEncode = flag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.352 -0400", hash_original_method = "B04CD19C0316B320C5B66A678FB2994B", hash_generated_method = "3AC76B4C932B3AF07B1F5155A47B0700")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public <T> T[] toArray(T[] array) {
        dsTaint.addTaint(array[0].dsTaint);
        T[] varAF20075E6206E1ABABE5B1A210B15156_458133752 = (this.hlist.toArray(array));
        return (T[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.hlist.toArray(array);
    }

    
    private static boolean prettyEncode = false;
}

