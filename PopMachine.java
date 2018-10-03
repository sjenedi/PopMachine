import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author Sami Jenedi
 * Class PopMachine simulates simple functionality of a PopMachine
 */
public class PopMachine
{
  public static void main(String[] args) throws IOException
  {
    final int MAX_SODAS = 10;

    // Create a new array named popMachine that will be able
    // to hold MAX_SODAS Soda objects
    Soda[] popMachine = new Soda[MAX_SODAS];

    for(int i=0; i<MAX_SODAS ; i++)

    popMachine[i] = new Soda();
    
    int numSodas = fillMachine(popMachine, "Sodas.txt");

    // Loop to reduce the quantity of each soda in the popMachine
    // by one. Note that the machine may not be filled. Use
    // the reduce method.

   
    for(int i = 0; i < numSodas ; i++)
      

      popMachine[i].reduce(1);
    
    saveMachine(popMachine, numSodas, "SodasChanged.txt");

    System.out.println("Machine closed.");
  }

  /**
   * fillMachine loads the machine with sodas from the specified file.
   * @param popMachine The array to fill with sodas
   * @param fileName The name of the file containing soda information
   * @return The number of sodas read into the machine
   * @throws IOException
   */
  public static int fillMachine(Soda[] popMachine,
                              String fileName) throws IOException
  {
    // Check if the file exists. If not, inform the user that the
    // file does not exist and exit with an error code of 1.
    fileName = "Sodas.txt";
    File file = new File(fileName);
     if(!file.exists()) {
       System.out.print("File Open Error: " + file.getName());
       System.exit(1);
      }

    // Open the file for reading and read each Soda into the array
    // Stop reading when there are no more lines to process or the
    // array is filled with sodas.
    // Note: In each loop iteration, you will need to add a new Soda
    // object to the array, get the 4 lines of data associated with
    // that soda, and set the soda object with that data. You will need
    // to keep track of the number of sodas read, and that can be used
    // as an index into the array.
     Scanner input = new Scanner (new File (fileName));
     
     int i=0;

     while (input.hasNext())

     { //reading the content of text file

     popMachine[i].setName(input.next());

     popMachine[i].setPrice(input.nextDouble());

     popMachine[i].setQuantity(input.nextInt());

     popMachine[i].setOunces(input.nextInt());

     i++;

     }  

     input.close();

     return(i);

     }
     
    // Return the number of sodas read

  
  
  /**
   * saveMachine writes the popMachine data back to file in the same format
   * as originally read.
   * @param popMachine The array that contains the sodas
   * @param numSodas The number of sodas in the array
   * @param fileName The name of the file to write the soda information
   * @throws IOException
   */
  
  public static void saveMachine(Soda[] popMachine, int numSodas,
      String fileName) throws IOException
  {
    // Open the fileName for writing. No need to check for an error.
    FileOutputStream outfile = new FileOutputStream (fileName);

    // Create a DecimalFormat class that will output the price with
    // always 1 digit before the decimal point and 2 digits after.
    DecimalFormat df = new DecimalFormat("0.00");

    PrintWriter pw = new PrintWriter(outfile);

   

    // Loop to write the soda data back to file in the same original format.
    for(int i=0; i < numSodas ; i++)
    {   

      pw.println(popMachine[i].getName());

      pw.println(df.format(popMachine[i].getPrice())); 

      pw.println(popMachine[i].getQuantity());

      pw.println(popMachine[i].getOunces());

      }

   
    
    // Close the output file.
    pw.close();
  }
}
