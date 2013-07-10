package org.bouncycastle.openssl;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public interface PasswordFinder
{
    public char[] getPassword();
}
