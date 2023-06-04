/*
With the help of this program i'm trying to solve a problem that may we all face in our laptop.
Where we put our all types of files/ documents in a single directory and create a mesh of files and if we
want to find any file then it took lots of times.

So this program take path of the directory that have the mesh of files and it separate all kind of
file in separate folder.
*/

package JAVA.Project;       // package

// import statements

import java.io.File;
import java.util.*;

public class FileSeparater {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Directory Path : ");  // taking input of main Directory that have multiple files
        String dirName = sc.nextLine();

        File file = new File(dirName);  // Creating object of directory


        // creating file object of Separator files

        File pdf = new File(dirName + "\\PDF");
        File img = new File(dirName + "\\IMAGE");
        File docx = new File(dirName + "\\DOCUMENT");
        File txt = new File(dirName + "\\TEXT");
        File vid = new File(dirName + "\\VIDEO");

        File[] allfiles = file.listFiles();     // file array of all files present in the directory entered by user

        for (int i = 0; i < allfiles.length; i++) {

            String filename = "";   // store name of file
            String[] extension;     // It store splited file name and extension by "." eg: - fileName.pdf --> ["fileName","pdf"]

            if (allfiles[i].isFile()) {     // It check is this file is file or directory, if file then execute the block of code

                filename = allfiles[i].getName();       // extracting file name from absolute path of file
                extension = filename.split("\\.");      // split file name and extension

                switch (extension[extension.length - 1]) {      // ["fileName","pdf"] --> get n-1 (extension) of file from this array

                    case "pdf":     // checking if extension if pdf then this block of code executed
                        File moveto;    // file type variable that store location where file will move
                        Boolean done;   // store acknowledgement of file move or not
                        if (!pdf.exists()) {    // firstly this line check if directory not exist then it create directory
                            if (pdf.mkdir()) {
                                System.out.println("PDF DONE");  // if directory create the print this line for acknowledgement message.
                            }
                        }
                        moveto = new File(pdf + "\\" + filename);   // this create a file location object where file will move
                        allfiles[i].renameTo(moveto);    // this line move file from source (allfiles[i]) to destination (moveto).
                        break;

                    case "docx":
                        if (!docx.exists()) {
                            if (docx.mkdir()) {
                                System.out.println("DOCX DONE");
                            }
                        }
                        moveto = new File(docx + "\\" + filename);
                        allfiles[i].renameTo(moveto);
                        break;
                    case "jpg":
                        if (!img.exists()) {
                            if (img.mkdir()) {
                                System.out.println("IMG DONE");
                            }
                        }
                        moveto = new File(img + "\\" + filename);
                        allfiles[i].renameTo(moveto);
                        break;
                    case "txt":
                        if (!txt.exists()) {
                            if (txt.mkdir()) {
                                System.out.println("TXT DONE");
                            }
                        }
                        moveto = new File(txt + "\\" + filename);
                        allfiles[i].renameTo(moveto);
                        break;
                    case ("mp4"):
                        if (!vid.exists()) {
                            if (vid.mkdir()) {
                                System.out.println("VIDEO DONE");
                            }
                        }
                        moveto = new File(vid + "\\" + filename);
                        allfiles[i].renameTo(moveto);
                        break;
                    case ("mkv"):
                        if (!vid.exists()) {
                            if (vid.mkdir()) {
                                System.out.println("VIDEO DONE");
                            }
                        }
                        moveto = new File(vid + "\\" + filename);
                        allfiles[i].renameTo(moveto);
                        break;
                }
            }
        }
    }
}
