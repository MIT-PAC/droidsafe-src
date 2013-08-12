package gov.nist.javax.sip.header;

// Droidsafe Imports
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.309 -0400", hash_original_field = "54FC99FFF06FAFF26E47359497AA764D", hash_generated_field = "1610EB574C9A048E3BE2EA98FBE15AF1")

    protected List<HDR> hlist;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.309 -0400", hash_original_field = "D0509468108F68C610DFF430648FE029", hash_generated_field = "7DDB65A0A435AAFCBC63AD9D687C490F")

    private Class<HDR> myClass;
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.309 -0400", hash_original_method = "D7E30AE5F54C678856B1E2B4E08FADF6", hash_generated_method = "DD0314912C40308B77D7E83CB7E4756A")
    private  SIPHeaderList() {
        hlist = new LinkedList<HDR>();
        // ---------- Original Method ----------
        //hlist = new LinkedList<HDR>();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.310 -0400", hash_original_method = "C956079DDC347F2EE85C1D1E44860715", hash_generated_method = "51235193447C0D5C365999E9B5547A62")
    protected  SIPHeaderList(Class<HDR> objclass, String hname) {
        this();
        addTaint(hname.getTaint());
        this.headerName = hname;
        this.myClass =  objclass;
        // ---------- Original Method ----------
        //this.headerName = hname;
        //this.myClass =  objclass;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.310 -0400", hash_original_method = "5A8D65821D08B5534EF9F59F256EB0ED", hash_generated_method = "1D07CC87CD6DF871E8798B12FCA91C34")
    public String getName() {
String var2D0A9E749E9205038C7691483855DB68_1200055251 =         this.headerName;
        var2D0A9E749E9205038C7691483855DB68_1200055251.addTaint(taint);
        return var2D0A9E749E9205038C7691483855DB68_1200055251;
        // ---------- Original Method ----------
        //return this.headerName;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.310 -0400", hash_original_method = "45FF804DBFA2BB4F4071CDF27CE28633", hash_generated_method = "E5619B43F23B89BE7768660E40174F67")
    public boolean add(HDR objectToAdd) {
        addTaint(objectToAdd.getTaint());
        hlist.add((HDR)objectToAdd);
        boolean varB326B5062B2F0E69046810717534CB09_1618050060 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1270863581 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1270863581;
        // ---------- Original Method ----------
        //hlist.add((HDR)objectToAdd);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.311 -0400", hash_original_method = "87B618AF10705C22EFB36E4A71158D56", hash_generated_method = "2C07AFDE4A0DCA38E55746E3ADF9124E")
    public void addFirst(HDR obj) {
        addTaint(obj.getTaint());
        hlist.add(0,(HDR) obj);
        // ---------- Original Method ----------
        //hlist.add(0,(HDR) obj);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.311 -0400", hash_original_method = "3D14CCA72C816FE4801BBC05991E4343", hash_generated_method = "DA68F4029F6FD9ED2C2B15C62DFE59D0")
    public void add(HDR sipheader, boolean top) {
        addTaint(top);
        addTaint(sipheader.getTaint());
        if(top)        
        this.addFirst(sipheader);
        else
        this.add(sipheader);
        // ---------- Original Method ----------
        //if (top)
            //this.addFirst(sipheader);
        //else
            //this.add(sipheader);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.312 -0400", hash_original_method = "2C5EDAC0235777863EFD087B4072277C", hash_generated_method = "D4AD0D90F9A0DB1B91A4CC16A1AF54E3")
    public void concatenate(SIPHeaderList<HDR> other, boolean topFlag) throws IllegalArgumentException {
        addTaint(topFlag);
        addTaint(other.getTaint());
        if(!topFlag)        
        {
            this.addAll(other);
        } //End block
        else
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.312 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "C16A1F021C6D139585167C20C9B322E2")
    public String encode() {
String var678B6FE61D54E5BD4E109D01C318C133_33171039 =         encode(new StringBuffer()).toString();
        var678B6FE61D54E5BD4E109D01C318C133_33171039.addTaint(taint);
        return var678B6FE61D54E5BD4E109D01C318C133_33171039;
        // ---------- Original Method ----------
        //return encode(new StringBuffer()).toString();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.313 -0400", hash_original_method = "4452028BB43CC449CBD4FD5523C455CD", hash_generated_method = "78B9AF9DF35DC4CBA04BF25C1B2CA180")
    public StringBuffer encode(StringBuffer buffer) {
        addTaint(buffer.getTaint());
        if(hlist.isEmpty())        
        {
            buffer.append(headerName).append(':').append(Separators.NEWLINE);
        } //End block
        else
        {
            if(this.headerName.equals(SIPHeaderNames.WWW_AUTHENTICATE)
                    || this.headerName.equals(SIPHeaderNames.PROXY_AUTHENTICATE)
                    || this.headerName.equals(SIPHeaderNames.AUTHORIZATION)
                    || this.headerName.equals(SIPHeaderNames.PROXY_AUTHORIZATION)
                    || (prettyEncode &&
                            (this.headerName.equals(SIPHeaderNames.VIA) || this.headerName.equals(SIPHeaderNames.ROUTE) || this.headerName.equals(SIPHeaderNames.RECORD_ROUTE))) 
                    || this.getClass().equals( ExtensionHeaderList.class))            
            {
                ListIterator<HDR> li = hlist.listIterator();
                while
(li.hasNext())                
                {
                    HDR sipheader = (HDR) li.next();
                    sipheader.encode(buffer);
                } //End block
            } //End block
            else
            {
                buffer.append(headerName).append(Separators.COLON).append(Separators.SP);
                this.encodeBody(buffer);
                buffer.append(Separators.NEWLINE);
            } //End block
        } //End block
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_978429764 =         buffer;
        varE75BCB56CC6A0BCEED51BE38E1BB3F38_978429764.addTaint(taint);
        return varE75BCB56CC6A0BCEED51BE38E1BB3F38_978429764;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.314 -0400", hash_original_method = "3A5F29F99CF35D16AD0C376ECAFA4E44", hash_generated_method = "DB27A59A1B371D6F9DF56F29A84831C6")
    public List<String> getHeadersAsEncodedStrings() {
        List<String> retval = new LinkedList<String>();
        ListIterator<HDR> li = hlist.listIterator();
        while
(li.hasNext())        
        {
            Header sipheader = li.next();
            retval.add(sipheader.toString());
        } //End block
List<String> varF9E19AD6135C970F387F77C6F3DE4477_215406655 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_215406655.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_215406655;
        // ---------- Original Method ----------
        //List<String> retval = new LinkedList<String>();
        //ListIterator<HDR> li = hlist.listIterator();
        //while (li.hasNext()) {
            //Header sipheader = li.next();
            //retval.add(sipheader.toString());
        //}
        //return retval;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.315 -0400", hash_original_method = "6C7059400A289BDBD2DC174FD9546E0E", hash_generated_method = "CCCB06047E3FEDEC86BFCD9802A8538E")
    public Header getFirst() {
        if(hlist == null || hlist.isEmpty())        
        {
Header var540C13E9E156B687226421B24F2DF178_225228875 =         null;
        var540C13E9E156B687226421B24F2DF178_225228875.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_225228875;
        }
        else
        {
Header var03CBF4E7FCB6AE9DEC069A1A9E942FE2_1886511432 =         hlist.get(0);
        var03CBF4E7FCB6AE9DEC069A1A9E942FE2_1886511432.addTaint(taint);
        return var03CBF4E7FCB6AE9DEC069A1A9E942FE2_1886511432;
        }
        // ---------- Original Method ----------
        //if (hlist == null || hlist.isEmpty())
            //return null;
        //else
            //return  hlist.get(0);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.315 -0400", hash_original_method = "564DA566938B5DEC3F30C613889BA2FD", hash_generated_method = "3F567384FFBE6798CC4E1D613B6BDA1B")
    public Header getLast() {
        if(hlist == null || hlist.isEmpty())        
        {
Header var540C13E9E156B687226421B24F2DF178_872040930 =         null;
        var540C13E9E156B687226421B24F2DF178_872040930.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_872040930;
        }
Header var374F33CD83CC900111AB59F8D731DC16_1512715182 =         hlist.get(hlist.size() - 1);
        var374F33CD83CC900111AB59F8D731DC16_1512715182.addTaint(taint);
        return var374F33CD83CC900111AB59F8D731DC16_1512715182;
        // ---------- Original Method ----------
        //if (hlist == null || hlist.isEmpty())
            //return null;
        //return  hlist.get(hlist.size() - 1);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.315 -0400", hash_original_method = "52DB400388897C60F1E5D7C5CF768C2C", hash_generated_method = "F6B3436529CC96ED871B519A30146C08")
    public Class<HDR> getMyClass() {
Class<HDR> var15B6B2C8B82C709EA0861459314166EA_600096434 =         this.myClass;
        var15B6B2C8B82C709EA0861459314166EA_600096434.addTaint(taint);
        return var15B6B2C8B82C709EA0861459314166EA_600096434;
        // ---------- Original Method ----------
        //return  this.myClass;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.316 -0400", hash_original_method = "FF43F4EB263E123805961D1A87217B48", hash_generated_method = "5D931D7D15F7726088C919D3611E3032")
    public boolean isEmpty() {
        boolean varF6FBFC9C4283831A4C403D058FEA1D3C_2073111956 = (hlist.isEmpty());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1758834817 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1758834817;
        // ---------- Original Method ----------
        //return hlist.isEmpty();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.317 -0400", hash_original_method = "36E257E69C92FC5D45CD0DCB007DB07A", hash_generated_method = "5DC9C9FBC24818AC266BF8FB502C5D87")
    public ListIterator<HDR> listIterator() {
ListIterator<HDR> var214F06B8FEED8333C89E5D0EB8E4FC02_501857793 =         hlist.listIterator(0);
        var214F06B8FEED8333C89E5D0EB8E4FC02_501857793.addTaint(taint);
        return var214F06B8FEED8333C89E5D0EB8E4FC02_501857793;
        // ---------- Original Method ----------
        //return hlist.listIterator(0);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.317 -0400", hash_original_method = "9E6C15618943805727A8B08583C0FF39", hash_generated_method = "0D7EE555C7C95ED814AEA508465B2C59")
    public List<HDR> getHeaderList() {
List<HDR> var49BC912958DD04CBD88E5E5E589C21A1_559529271 =         this.hlist;
        var49BC912958DD04CBD88E5E5E589C21A1_559529271.addTaint(taint);
        return var49BC912958DD04CBD88E5E5E589C21A1_559529271;
        // ---------- Original Method ----------
        //return this.hlist;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.317 -0400", hash_original_method = "EDE82742DF271310D47CFC69F814BF44", hash_generated_method = "6C837FBDEB59D144335CEF63CAACFD7B")
    public ListIterator<HDR> listIterator(int position) {
        addTaint(position);
ListIterator<HDR> varB6858C2A0A5D5DA33796D38FD73E73F3_35324220 =         hlist.listIterator(position);
        varB6858C2A0A5D5DA33796D38FD73E73F3_35324220.addTaint(taint);
        return varB6858C2A0A5D5DA33796D38FD73E73F3_35324220;
        // ---------- Original Method ----------
        //return hlist.listIterator(position);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.317 -0400", hash_original_method = "66F538C19C1B45B9F4975D517A08EBE7", hash_generated_method = "0EC6A71C3B50D213E8D72294E41D19C0")
    public void removeFirst() {
        if(hlist.size() != 0)        
        hlist.remove(0);
        // ---------- Original Method ----------
        //if (hlist.size() != 0)
            //hlist.remove(0);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.318 -0400", hash_original_method = "56685A1560151077841543B2BC810F93", hash_generated_method = "4174F13ADDBFAB97F9B36DBC7B1C6E1C")
    public void removeLast() {
        if(hlist.size() != 0)        
        hlist.remove(hlist.size() - 1);
        // ---------- Original Method ----------
        //if (hlist.size() != 0)
            //hlist.remove(hlist.size() - 1);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.318 -0400", hash_original_method = "6090D81CA85470AC09234766F76789C0", hash_generated_method = "8735E52278494E3A67D9E16CE3042F68")
    public boolean remove(HDR obj) {
        addTaint(obj.getTaint());
        if(hlist.size() == 0)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1210546678 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1617973562 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1617973562;
        }
        else
        {
        boolean var0A591BD0247EB6D15AFA01AFEB2B4319_416115275 = (hlist.remove(obj));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_930834261 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_930834261;
        }
        // ---------- Original Method ----------
        //if (hlist.size() == 0)
            //return false;
        //else
            //return hlist.remove(obj);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.318 -0400", hash_original_method = "23B9304014C757503CC0D5B9D6DB550F", hash_generated_method = "B52967299638535006F513B062474563")
    protected void setMyClass(Class<HDR> cl) {
        this.myClass = cl;
        // ---------- Original Method ----------
        //this.myClass = cl;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.319 -0400", hash_original_method = "CC42CBF49D5975143777F4A2B14A482C", hash_generated_method = "795D1C84413F298102C50C7709DD7D33")
    public String debugDump(int indentation) {
        addTaint(indentation);
        stringRepresentation = "";
        String indent = new Indentation(indentation).getIndentation();
        String className = this.getClass().getName();
        sprint(indent + className);
        sprint(indent + "{");
for(Iterator<HDR> it = hlist.iterator();it.hasNext();)
        {
            HDR sipHeader = (HDR) it.next();
            sprint(indent + sipHeader.debugDump());
        } //End block
        sprint(indent + "}");
String var8D11C2D110975896438D6F91C60E6D6F_1221915648 =         stringRepresentation;
        var8D11C2D110975896438D6F91C60E6D6F_1221915648.addTaint(taint);
        return var8D11C2D110975896438D6F91C60E6D6F_1221915648;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.319 -0400", hash_original_method = "ABFB21316126C2849AB41073C957D80E", hash_generated_method = "79B1854AB6BC7EAA0A2FA1C0D2E58017")
    public String debugDump() {
String varF5750B8E6AF3561EC64E2884C2BF2D7F_2061620986 =         debugDump(0);
        varF5750B8E6AF3561EC64E2884C2BF2D7F_2061620986.addTaint(taint);
        return varF5750B8E6AF3561EC64E2884C2BF2D7F_2061620986;
        // ---------- Original Method ----------
        //return debugDump(0);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.320 -0400", hash_original_method = "7EBA89BCEE46EEC5D25867CF89F8E8B9", hash_generated_method = "84BDAB1546BA4DB5344ECF45F00CBE26")
    public Object[] toArray() {
Object[] var9BCCDED204626682CB94D4271D3BFC41_1638096471 =         hlist.toArray();
        var9BCCDED204626682CB94D4271D3BFC41_1638096471.addTaint(taint);
        return var9BCCDED204626682CB94D4271D3BFC41_1638096471;
        // ---------- Original Method ----------
        //return hlist.toArray();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.320 -0400", hash_original_method = "795B857E8950EF3C66EEA5946EF97E00", hash_generated_method = "65B204B69677EF469CC0CF072B2B18B9")
    public int indexOf(GenericObject gobj) {
        addTaint(gobj.getTaint());
        int var096EA5045151DF57BBE15BF4244ABD78_684881012 = (hlist.indexOf(gobj));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1042741613 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1042741613;
        // ---------- Original Method ----------
        //return hlist.indexOf(gobj);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.320 -0400", hash_original_method = "D4A0602F4424EB672EFBEE9811EC3EF2", hash_generated_method = "C084A196CCF5B74F0FC6E53FE5DF92D9")
    public void add(int index, HDR  sipHeader) throws IndexOutOfBoundsException {
        addTaint(sipHeader.getTaint());
        addTaint(index);
        hlist.add(index, sipHeader);
        // ---------- Original Method ----------
        //hlist.add(index, sipHeader);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.321 -0400", hash_original_method = "7AF224A0221DFF0013A72A01287D2D95", hash_generated_method = "6749EE85E71D7AAE83CD21FA94941951")
    @SuppressWarnings("unchecked")
    public boolean equals(Object other) {
        addTaint(other.getTaint());
        if(other == this)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_786285060 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2038260425 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2038260425;
        }
        if(other instanceof SIPHeaderList)        
        {
            SIPHeaderList<SIPHeader> that = (SIPHeaderList<SIPHeader>) other;
            if(this.hlist == that.hlist)            
            {
            boolean varB326B5062B2F0E69046810717534CB09_15306269 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_435668109 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_435668109;
            }
            else
            if(this.hlist == null)            
            {
            boolean var0345CD47BA79A23179449C6BFBDB3502_1594344422 = (that.hlist == null || that.hlist.size() == 0);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_97385607 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_97385607;
            }
            boolean var81B7B0BB46EA552398BF0C1D820E9C57_57783395 = (this.hlist.equals(that.hlist));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_745702597 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_745702597;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1950247104 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_50206077 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_50206077;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.322 -0400", hash_original_method = "6ED02991F9AD79524F79D6703964DFB6", hash_generated_method = "FD5A93352E0CFD287D0ABD38814FA56F")
    public boolean match(SIPHeaderList<?> template) {
        addTaint(template.getTaint());
        if(template == null)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_318849311 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2088264161 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2088264161;
        }
        if(!this.getClass().equals(template.getClass()))        
        {
        boolean var68934A3E9455FA72420237EB05902327_25684540 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1741007353 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1741007353;
        }
        SIPHeaderList<SIPHeader> that = (SIPHeaderList<SIPHeader>) template;
        if(this.hlist == that.hlist)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_779734806 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1136725356 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1136725356;
        }
        else
        if(this.hlist == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_2084820265 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1962160560 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1962160560;
        }
        else
        {
for(Iterator<SIPHeader> it = that.hlist.iterator();it.hasNext();)
            {
                SIPHeader sipHeader = (SIPHeader) it.next();
                boolean found = false;
for(Iterator<HDR> it1 = this.hlist.iterator();it1.hasNext()
                        && !found;)
                {
                    SIPHeader sipHeader1 = (SIPHeader) it1.next();
                    found = sipHeader1.match(sipHeader);
                } //End block
                if(!found)                
                {
                boolean var68934A3E9455FA72420237EB05902327_1598332003 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_394092708 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_394092708;
                }
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_951030359 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_538665944 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_538665944;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.325 -0400", hash_original_method = "359991759D26E2A3F33ACAEA17758D18", hash_generated_method = "5A094DCA0018FE1618660E060DDA2A51")
    public Object clone() {
        try 
        {
            Class<?> clazz = this.getClass();
            Constructor<?> cons = clazz.getConstructor((Class[])null);
            SIPHeaderList<HDR> retval = (SIPHeaderList<HDR>) cons.newInstance((Object[])null);
            retval.headerName = this.headerName;
            retval.myClass  = this.myClass;
Object varF627329B9209466293A1BF71D9AF7B2B_2023925332 =             retval.clonehlist(this.hlist);
            varF627329B9209466293A1BF71D9AF7B2B_2023925332.addTaint(taint);
            return varF627329B9209466293A1BF71D9AF7B2B_2023925332;
        } //End block
        catch (Exception ex)
        {
            RuntimeException var2C1E94E23404E6CD9DAB357D8EB46717_1520769021 = new RuntimeException("Could not clone!", ex);
            var2C1E94E23404E6CD9DAB357D8EB46717_1520769021.addTaint(taint);
            throw var2C1E94E23404E6CD9DAB357D8EB46717_1520769021;
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.326 -0400", hash_original_method = "CA032BB58CFE2AE5C2CC307C2E78224F", hash_generated_method = "BE69EB21D0E78EB885DBDEE38E05C965")
    protected final SIPHeaderList<HDR> clonehlist(List<HDR> hlistToClone) {
        addTaint(hlistToClone.getTaint());
        if(hlistToClone != null)        
        {
for(Iterator<HDR> it = (Iterator<HDR>) hlistToClone.iterator();it.hasNext();)
            {
                Header h = it.next();
                this.hlist.add((HDR)h.clone());
            } //End block
        } //End block
SIPHeaderList<HDR> var72A74007B2BE62B849F475C7BDA4658B_282590313 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_282590313.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_282590313;
        // ---------- Original Method ----------
        //if (hlistToClone != null) {
            //for (Iterator<HDR> it = (Iterator<HDR>) hlistToClone.iterator(); it.hasNext();) {
                //Header h = it.next();
                //this.hlist.add((HDR)h.clone());
            //}
        //}
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.327 -0400", hash_original_method = "FCBD3ECE23AA666BDE06756DAACE9219", hash_generated_method = "CAEB35EA688817B1B256F9308BCF8A06")
    public int size() {
        int varAF3E3129CF1C5C3FB4229A92D894C33E_615239629 = (hlist.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_641513382 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_641513382;
        // ---------- Original Method ----------
        //return hlist.size();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.327 -0400", hash_original_method = "32932F147EA25CC7B7BC47F740C6BF91", hash_generated_method = "0BAD400BE7EEBCE33BD579F6D46042D7")
    public boolean isHeaderList() {
        boolean varB326B5062B2F0E69046810717534CB09_1712632595 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_564889767 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_564889767;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.328 -0400", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "8C59B77E402AD1E685C96CAAE7F427CD")
    protected String encodeBody() {
String varB9AAF3B320DC07C68A40DABE06BFAFD1_1856150876 =         encodeBody(new StringBuffer()).toString();
        varB9AAF3B320DC07C68A40DABE06BFAFD1_1856150876.addTaint(taint);
        return varB9AAF3B320DC07C68A40DABE06BFAFD1_1856150876;
        // ---------- Original Method ----------
        //return encodeBody(new StringBuffer()).toString();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.329 -0400", hash_original_method = "8EFAAECA9CE0AC45762D4D910A6D9585", hash_generated_method = "5263EB1F5D2EFDCEDC208A3899E4C414")
    protected StringBuffer encodeBody(StringBuffer buffer) {
        addTaint(buffer.getTaint());
        ListIterator<HDR> iterator = this.listIterator();
        while
(true)        
        {
            SIPHeader sipHeader = (SIPHeader) iterator.next();
            if(sipHeader == this)            
            {
            RuntimeException var4E49D9E9544AAFAA7AA7CB9288406656_1242642997 = new RuntimeException ("Unexpected circularity in SipHeaderList");
            var4E49D9E9544AAFAA7AA7CB9288406656_1242642997.addTaint(taint);
            throw var4E49D9E9544AAFAA7AA7CB9288406656_1242642997;
            }
            sipHeader.encodeBody(buffer);
            if(iterator.hasNext())            
            {
                if(!this.headerName.equals(PrivacyHeader.NAME))                
                buffer.append(Separators.COMMA);
                else
                buffer.append(Separators.SEMICOLON);
                continue;
            } //End block
            else
            break;
        } //End block
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_593479420 =         buffer;
        varE75BCB56CC6A0BCEED51BE38E1BB3F38_593479420.addTaint(taint);
        return varE75BCB56CC6A0BCEED51BE38E1BB3F38_593479420;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.330 -0400", hash_original_method = "D5DDE9BDBABBA5EC4E7B0879A10A7D8D", hash_generated_method = "B720BACB042B76AFCF8698B541D80644")
    public boolean addAll(Collection<? extends HDR> collection) {
        addTaint(collection.getTaint());
        boolean var2F99B7A53C0E3F568E166C1088FAE05D_1732543960 = (this.hlist.addAll(collection));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1405611634 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1405611634;
        // ---------- Original Method ----------
        //return this.hlist.addAll(collection);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.331 -0400", hash_original_method = "5E3DA6DCBC302D72E9103E3CB1D3527B", hash_generated_method = "ADB90164EFB7427B9DCFAB0EADA5D60C")
    public boolean addAll(int index, Collection<? extends HDR> collection) {
        addTaint(collection.getTaint());
        addTaint(index);
        boolean varB4EBE377B9166E9DECFDE489F4A7AC18_592767187 = (this.hlist.addAll(index, collection));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1635543490 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1635543490;
        // ---------- Original Method ----------
        //return this.hlist.addAll(index, collection);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.332 -0400", hash_original_method = "F1DA48A9A827D74FF9F3AEB298E80E0A", hash_generated_method = "659F81639DB14D582620541114076294")
    public boolean containsAll(Collection<?> collection) {
        addTaint(collection.getTaint());
        boolean var89FEFD365191181AAD3D23E2761A1800_2047882622 = (this.hlist.containsAll(collection));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_305302200 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_305302200;
        // ---------- Original Method ----------
        //return this.hlist.containsAll(collection);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.332 -0400", hash_original_method = "D791B8D331C82850017A4DF87B2D73FE", hash_generated_method = "7B3736200B6CC37F2F0C36EB7F8C7C36")
    public void clear() {
        this.hlist.clear();
        // ---------- Original Method ----------
        //this.hlist.clear();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.333 -0400", hash_original_method = "B039DF80CC42319FF93C93DFC4F09CCF", hash_generated_method = "C1E7C8DD1FA610E00168066533BEB1DD")
    public boolean contains(Object header) {
        addTaint(header.getTaint());
        boolean var43C10FBEA04219F6C839E45603981969_1781305888 = (this.hlist.contains(header));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_317468828 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_317468828;
        // ---------- Original Method ----------
        //return this.hlist.contains(header);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.333 -0400", hash_original_method = "B0FF15B145547E100ED44D45A7137CDE", hash_generated_method = "277E5216C188F9D247BC586CDFD66D62")
    public HDR get(int index) {
        addTaint(index);
HDR varE814669528E94208DB851E0203603324_397239305 =         this.hlist.get(index);
        varE814669528E94208DB851E0203603324_397239305.addTaint(taint);
        return varE814669528E94208DB851E0203603324_397239305;
        // ---------- Original Method ----------
        //return  this.hlist.get(index);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.333 -0400", hash_original_method = "9C1A1055EA03DFB32FF882EA4FC9149D", hash_generated_method = "835DDB2C5CB55343B9DB28FE8285DAC1")
    public int indexOf(Object obj) {
        addTaint(obj.getTaint());
        int varAC466A844787C6333CA17A2EB953058F_895871832 = (this.hlist.indexOf(obj));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1725087425 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1725087425;
        // ---------- Original Method ----------
        //return this.hlist.indexOf(obj);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.334 -0400", hash_original_method = "84FF645EE0B76DB0D5B552F9A7A0DC94", hash_generated_method = "8A35D19C6E2A74C515AE10FE00DE3B11")
    public java.util.Iterator<HDR> iterator() {
java.util.Iterator<HDR> var96DA5F4DE476CD2881BA1D682D0C27E7_450788592 =         this.hlist.listIterator();
        var96DA5F4DE476CD2881BA1D682D0C27E7_450788592.addTaint(taint);
        return var96DA5F4DE476CD2881BA1D682D0C27E7_450788592;
        // ---------- Original Method ----------
        //return this.hlist.listIterator();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.334 -0400", hash_original_method = "05A7D65C6D911E0B1F3261A66888CB52", hash_generated_method = "D197E61CA3A57DAF5A1091436CCD923E")
    public int lastIndexOf(Object obj) {
        addTaint(obj.getTaint());
        int var6AF16C4D258C7D1B28A34D5FD81D47F4_185022444 = (this.hlist.lastIndexOf(obj));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_843717483 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_843717483;
        // ---------- Original Method ----------
        //return this.hlist.lastIndexOf(obj);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.335 -0400", hash_original_method = "FB49499CFAFE2E72F27390E6807CB034", hash_generated_method = "145CAD7562C72C0047D44ECA15146BA6")
    public boolean remove(Object obj) {
        addTaint(obj.getTaint());
        boolean var91A3ABCCA3E1FA8D3ED21E0F4E2D5AB4_2100989177 = (this.hlist.remove(obj));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1995786488 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1995786488;
        // ---------- Original Method ----------
        //return this.hlist.remove(obj);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.336 -0400", hash_original_method = "2B7049D180B166140C32B8D54A96E238", hash_generated_method = "0BFE549E0282DF90B77B951916389738")
    public HDR remove(int index) {
        addTaint(index);
HDR var2AFA8B7520708C0D013D76A45AB5CB74_23727402 =         this.hlist.remove(index);
        var2AFA8B7520708C0D013D76A45AB5CB74_23727402.addTaint(taint);
        return var2AFA8B7520708C0D013D76A45AB5CB74_23727402;
        // ---------- Original Method ----------
        //return this.hlist.remove(index);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.336 -0400", hash_original_method = "5A03B3005777615BF04A1D43320D1AA1", hash_generated_method = "8631B82C294379B71B839BC20A5F244C")
    public boolean removeAll(java.util.Collection<?> collection) {
        addTaint(collection.getTaint());
        boolean var30F068D3689D3D4F51A9B37B262304C6_2141305798 = (this.hlist.removeAll(collection));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2034563787 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2034563787;
        // ---------- Original Method ----------
        //return this.hlist.removeAll(collection);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.337 -0400", hash_original_method = "4FD342E6A050272CE06CEE9969944C1B", hash_generated_method = "7A49F4483B2A46BE51BD048B8F1B43E6")
    public boolean retainAll(java.util.Collection<?> collection) {
        addTaint(collection.getTaint());
        boolean varA2A738B814C2F176D6750A1B29B16AEE_10279087 = (this.hlist.retainAll(collection));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_20441660 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_20441660;
        // ---------- Original Method ----------
        //return this.hlist.retainAll(collection);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.337 -0400", hash_original_method = "894CB5A5FAD7AFC5CD5A3389B3F77AB4", hash_generated_method = "6DA6E7ABCB0B8022566B2D641884D908")
    public java.util.List<HDR> subList(int index1, int index2) {
        addTaint(index2);
        addTaint(index1);
java.util.List<HDR> varBF1746F375784D42EB824D444080CEAC_1272407585 =         this.hlist.subList(index1, index2);
        varBF1746F375784D42EB824D444080CEAC_1272407585.addTaint(taint);
        return varBF1746F375784D42EB824D444080CEAC_1272407585;
        // ---------- Original Method ----------
        //return this.hlist.subList(index1, index2);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.338 -0400", hash_original_method = "78242797F449E5EBFB278CC5A6BC56D0", hash_generated_method = "112A8C63C784E992C6F71D335C3D8B4E")
    public int hashCode() {
        int var3CA62782399404389049138061B2C659_1703872488 = (this.headerName.hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2102527198 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2102527198;
        // ---------- Original Method ----------
        //return this.headerName.hashCode();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.338 -0400", hash_original_method = "A9FD382DBA3FE66AACB46D6203100A0D", hash_generated_method = "BC01B0CA28D5F8D42F048290C23E6CC0")
    public HDR set(int position, HDR sipHeader) {
        addTaint(sipHeader.getTaint());
        addTaint(position);
HDR var73EA56BF60982634FDD7524661BF8918_1768864166 =         hlist.set(position, sipHeader);
        var73EA56BF60982634FDD7524661BF8918_1768864166.addTaint(taint);
        return var73EA56BF60982634FDD7524661BF8918_1768864166;
        // ---------- Original Method ----------
        //return hlist.set(position, sipHeader);
    }

    
    @DSModeled(DSC.SAFE)
    public static void setPrettyEncode(boolean flag) {
        prettyEncode = flag;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.339 -0400", hash_original_method = "B04CD19C0316B320C5B66A678FB2994B", hash_generated_method = "913F231D737BF10A7AB8B832C5BAA111")
    public <T> T[] toArray(T[] array) {
        addTaint(array[0].getTaint());
T[] var0350DC20E51885F26BC9AE21A5634403_1012850215 =         this.hlist.toArray(array);
        var0350DC20E51885F26BC9AE21A5634403_1012850215.addTaint(taint);
        return var0350DC20E51885F26BC9AE21A5634403_1012850215;
        // ---------- Original Method ----------
        //return this.hlist.toArray(array);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.339 -0400", hash_original_field = "BB31D88D930D91866C4879183DCACA7E", hash_generated_field = "F24392C13A6D95700264E5A997197264")

    private static boolean prettyEncode = false;
}

