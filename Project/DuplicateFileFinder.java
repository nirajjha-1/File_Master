
package JAVA.Project;

import java.io.*;
import java.util.Scanner;

/*
1. open two file
*/

public class DuplicateFileFinder
{

    public static int fileNo = 0;
    public static String[] setPathName(File[] abspath) {
        String[] fpath = new String[abspath.length];
        fileNo++;
        int fcount = 0;
        for (int i = 0; i < abspath.length; i++) {
            if (abspath[i].isFile()) {
                fpath[i] = abspath[i].getName();
                fcount++;
            }
        }
        // display number of files in both directory
        System.out.println("Number of Files in Directory "+fileNo+" : " + fcount);

        return fpath;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter First File Name : ");
        String file1 = sc.nextLine();       // First File path

        System.out.println("Enter Second File Name : ");
        String file2 = sc.nextLine();       // Second file path

        // creating file object of directory 1 & 2
        File f1 = new File(file1);
        File f2 = new File(file2);

        // to collect all list of files of directory in file type array with abstract path
        File[] fileArr1 = f1.listFiles();
        File[] fileArr2 = f2.listFiles();

        /*// Number of files elements in directory
        int fcount1 = fileArr1.length;
        int fcount2 = fileArr2.length;*/

        // to collect path name of all files of directory in array
        String[] files1 ;               // = new String[fcount1];
        String[] files2 ;               // = new String[fcount2];

        // call setPathName() - to get only file name from full abstract name and store in string array
        files1 = setPathName(fileArr1);
        files2 = setPathName(fileArr2);

        /*// number of only files in the directory
        int fcount1 = files1.length;
        int fcount2 = files2.length;*/

//        System.out.println("Enter Directory path where to move duplicate files : ");
//        String dupFile = sc.nextLine();

        for (int i = 0; i < files1.length; i++) {
            for (int j = 0; j < files2.length; j++) {
                if (files1[i].equals(files2[j])) {
                    File tomove = new File(file2 + "\\" + files2[j]);
                    File dupfile = new File(f1.getParentFile()+"\\Duplicate");
                    if(!dupfile.exists()){
                        dupfile.mkdir();
                        System.out.println("Directory For containing Duplicate files is created.");
                    }
                    File todup = new File(dupfile + "\\" + files2[j]);
                    boolean done = tomove.renameTo(todup);
                    System.out.println("done");
                }
            }
        }
    }
}
