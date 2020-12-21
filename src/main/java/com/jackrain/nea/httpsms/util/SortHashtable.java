package com.jackrain.nea.httpsms.util;

import java.util.*;

public class SortHashtable {
    public SortHashtable() {
    }

    @SuppressWarnings("unchecked")
    public static Map.Entry[] getSortedHashtableByKey(Hashtable h) {
        Set var1 = h.entrySet();
        Map.Entry[] var2 = (Map.Entry[]) var1.toArray(new Map.Entry[var1.size()]);
        Arrays.sort(var2, (Comparator) (arg0, arg1) -> {
            Object var3 = ((Map.Entry)arg0).getKey();
            Object var4 = ((Map.Entry)arg1).getKey();
            return ((Comparable)var3).compareTo(var4);
        });
        return var2;
    }

}
