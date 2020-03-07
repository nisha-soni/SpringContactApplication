package com.mycompany.springcontactapp.util;

/**
 *this class contains utility methods related to string operations
 * @author Nisha
 */
public class StringUtil {
    public static String toCommaSeperatedString(Object[] items){
     StringBuilder sb = new StringBuilder();
     for(Object item:items){
      sb.append(item).append(",");
     }
     if(sb.length()>0){
      sb.deleteCharAt(sb.length()-1);
     }
     return sb.toString();
    }
}
