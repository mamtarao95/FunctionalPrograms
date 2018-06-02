/*******************************************************************************
 *  Purpose: This method searches a word from a file
 *
 *  @author  BridgeLabz
 *  @version 1.0
 *  @since   06-08-2017
 *
 ******************************************************************************/
package com.bridgelabz.algorithmprograms;

import java.io.File;
import java.io.IOException;
import com.bridgelabz.util.Utility;

public class WordList {

    public static void main(String[] args) throws IOException {
     File file=new File("test");
     Utility.wordSearch(file);

}

}