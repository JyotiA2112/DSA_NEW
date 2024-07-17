package src;

import java.io.File;

public class WM {


    public static void main(String[] args) {
            final File folder = new File("/Users/jyoti/Desktop/root");

        listFilesForFolder(folder);
    }

    public static void listFilesForFolder(final File folder) { // n //m = n*m = // n^m
        // O(n)
        // O(n)
        String parentName = folder.getName();
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else {
                if(checkForMaliciousFile(fileEntry.getName(),parentName))
                {
                    fileEntry.delete();
                }
                System.out.println(fileEntry.getName());
            }
        }
    }

    public static boolean checkForMaliciousFile(String filename, String parentName)
    {
        return (filename.equals(parentName+".exe"));
    }


}
