package Reports;

import com.sun.pdfview.PDFFile;
import com.sun.pdfview.PDFPage;
import com.sun.pdfview.PDFRenderer;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;

public class PDFPrintPage
  implements Printable
{
  private PDFFile file;
  
  PDFPrintPage(PDFFile file)
  {
    this.file = file;
  }
  
  public int print(Graphics g, PageFormat format, int index)
    throws PrinterException
  {
    int pagenum = index + 1;
    if ((pagenum >= 1) && (pagenum <= this.file.getNumPages()))
    {
      Graphics2D g2 = (Graphics2D)g;
      PDFPage page = this.file.getPage(pagenum);
      double pwidth = format.getImageableWidth();
      double pheight = format.getImageableHeight();
      
      double aspect = page.getAspectRatio();
      double paperaspect = pwidth / pheight;
      Rectangle imgbounds;
      if (aspect > paperaspect)
      {
        int height = (int)(pwidth / aspect);
        imgbounds = new Rectangle((int)format.getImageableX(), (int)(format.getImageableY() + (pheight - height) / 2.0D), (int)pwidth, height);
      }
      else
      {
        int width = (int)(pheight * aspect);
        imgbounds = new Rectangle((int)(format.getImageableX() + (pwidth - width) / 2.0D), (int)format.getImageableY(), width, (int)pheight);
      }
      PDFRenderer pgs = new PDFRenderer(page, g2, imgbounds, null, null);
      try
      {
        page.waitForFinish();
        pgs.run();
      }
      catch (InterruptedException ie) {}
      return 0;
    }
    return 1;
  }
}



/* Location:           D:\New folder\New folder\dist\11thPrototype.jar

 * Qualified Name:     Reports.PDFPrintPage

 * JD-Core Version:    0.7.0.1

 */