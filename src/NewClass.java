
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ARAVIND
 */
public class NewClass 
{
  public static void main(String[] args) 
  {
		
                        Scanner in= new Scanner(System.in);
                       
                        System.out.println("Enter name,run time, lead actor and the genre");
                        String name= in.nextLine(); 
                        Integer run= in.nextInt();
                        in.nextLine();
                        String lead= in.nextLine();
                        String gen= in.nextLine();
                        
			String value = "Name:" + name + " Run Time:" + run + " Lead:" + lead + " Genre:"+gen;
                        
                        System.out.println("Save in text format(1) or PDF format(2)?");
                        Integer ch = in.nextInt();
                        
                        if(ch==1)
                        {
                           try
                           {
                             File file = new File("Movies.txt");

			// if file doesnt exists, then create it
			if (!file.exists()) 
                        {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(value);
			bw.close();

			System.out.println("Done");

                          } 
                        catch (IOException e) 
                        {
			e.printStackTrace();
                        }    
                           
                     }
                        
                     if(ch==2)   
                     {
                         PDDocument doc = null;
        PDPage page = null;

       try{
           doc = new PDDocument();
           page = new PDPage();

           doc.addPage(page);
           PDFont font = PDType1Font.HELVETICA;

           PDPageContentStream content = new PDPageContentStream(doc, page);
           content.beginText();
           content.setFont( font, 12 );
           content.moveTextPositionByAmount( 100, 700 );
           content.drawString(value);

           content.endText();
           content.close();
          doc.save("Movie.pdf");
          doc.close();
        } 
       catch (Exception e)
       {
        System.out.println(e);
       }
                     }
                
  }            
}
