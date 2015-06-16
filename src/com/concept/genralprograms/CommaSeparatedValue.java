package com.concept.genralprograms;

public class CommaSeparatedValue {

    public static void main(String[] args) {
        String str = " 0000011,0000021,0000031";
/*        System.out.println(str);
        str = str+",0000051";
        System.out.println(str);
        String[] dbName = str.split(",");

        for (int i = 0; i < dbName.length; i++) {
            System.out.println(dbName[i].trim());
        }
*/
        String senders = str;
        String senderDBName = "0000041";
        if (!senders.contains(senderDBName)) {
            senders = senders + "," + senderDBName;
        }
        System.out.println(senders);

    }
}
