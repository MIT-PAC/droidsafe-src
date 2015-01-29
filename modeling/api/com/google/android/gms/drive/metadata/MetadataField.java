package com.google.android.gms.drive.metadata;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.util.Collection;
import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;

public abstract interface MetadataField
{

    public abstract java.lang.String getName();

    public abstract java.util.Collection gC();

    public abstract java.lang.Object e(android.os.Bundle  r0);

    public abstract java.lang.Object a(com.google.android.gms.common.data.DataHolder  r0, int  i1, int  i2);

    public abstract void a(java.lang.Object  r0, android.os.Bundle  r1);

    //public abstract void a(com.google.android.gms.common.data.DataHolder  r0, com.google.android.gms.drive.metadata.internal.MetadataBundle  r1, int  i2, int  i3);
}
