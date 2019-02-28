package Reports;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.sun.pdfview.PDFFile;
import java.awt.Toolkit;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

public class CheckedOut
{
  private static Font redInfo = new Font(Font.FontFamily.TIMES_ROMAN, 10.0F, 0, BaseColor.RED);
  private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 10.0F, 1, BaseColor.RED);
  private static Font labelBold1 = new Font(Font.FontFamily.TIMES_ROMAN, 8.0F, 1);
  private static Font info1 = new Font(Font.FontFamily.TIMES_ROMAN, 8.0F, 0);
  private static Font labelBold = new Font(Font.FontFamily.TIMES_ROMAN, 8.0F, 1);
  private static Font info = new Font(Font.FontFamily.TIMES_ROMAN, 8.0F, 0);
  private static Font cuteFont = new Font(Font.FontFamily.TIMES_ROMAN, 5.0F, 2);
  private static Font tnxFont = new Font(Font.FontFamily.TIMES_ROMAN, 11.0F, 2);
  private static Font empFont = new Font(Font.FontFamily.TIMES_ROMAN, 3.0F, 1);
  private String filename = "";
  private DefaultTableModel tableModel = null;
  String incDates = null;
  String recNo = null;
  String cash = null;
  String credit = null;
  String check = null;
  String total = null;
  
  public CheckedOut(String filename, DefaultTableModel tableModel, String incDates, String recNo, String cash, String credit, String check, String total)
  {
    this.filename = filename;
    this.tableModel = tableModel;
    this.incDates = incDates;
    this.recNo = recNo;
    this.cash = cash;
    this.credit = credit;
    this.check = check;
    this.total = total;
    
    savePDF();
  }
  
  public void savePDF()
  {
    try
    {
      Document document = new Document();
      document.setMargins(25.0F, 25.0F, 25.0F, 25.0F);
      
      document.setPageSize(PageSize.LETTER);
      PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(this.filename));
      document.open();
      


      addMetaData(document);
      
      Paragraph Hpreface = new Paragraph();
      Hpreface.setFirstLineIndent(0.0F);
      Hpreface.setAlignment(1);
      Hpreface.setSpacingAfter(0.0F);
      Hpreface.setSpacingBefore(0.0F);
      Hpreface.setLeading(10.0F);
      

      Hpreface.add(new Paragraph("11th Street Bed & Breakfast Inn", labelBold1));
      

      Hpreface.add(new Paragraph("11th Lacson St., Bacolod City, Negros Occidental", labelBold1));
      


      Hpreface.add(new Paragraph("Telefax: (034) 4339191", labelBold1));
      


      Hpreface.add(new Paragraph("Mobile: 0922-8433919", labelBold1));
      

      Hpreface.add(new Paragraph("Email: bb11st@yahoo.com", labelBold1));
      

      Hpreface.add(new Paragraph("Website: www.bb11st.webeden.co.uk", labelBold1));
      

      Hpreface.add(new Paragraph("Facebook: 11th Street bed and breakfast pension house Bacolod City", labelBold1));
      

      addEmptyLine(Hpreface, 1);
      Hpreface.add(new Paragraph("C H E C K E D    O U T    R E P O R T", labelBold1));
      

      addEmptyLine(Hpreface, 1);
      
      Paragraph preface = new Paragraph();
      preface.setAlignment(7);
      
      preface.setSpacingAfter(1.0F);
      preface.setSpacingBefore(1.0F);
      preface.setLeading(10.0F);
      Paragraph p = new Paragraph();
      p.setSpacingBefore(1.0F);
      p.setSpacingBefore(1.0F);
      p.setLeading(10.0F);
      
      p.add(new Chunk("Inclusive Dates: ", labelBold1));
      p.add(new Chunk(this.incDates, info1));
      preface.add(p);
      p.clear();
      p.add(new Chunk("No. Of Records: ", labelBold1));
      p.add(new Chunk(this.recNo, info1));
      preface.add(p);
      
      createTable(preface, this.tableModel);
      p.clear();
      p.setLeading(17.0F);
      p.add(new Chunk("Room: ", labelBold1));
      p.add(new Chunk(this.cash + "                  ", info1));
      p.add(new Chunk("Sales: ", labelBold1));
      p.add(new Chunk(this.credit + "                  ", info1));
      preface.add(p);
      p.clear();
      p.add(new Chunk("Total: ", labelBold1));
      p.add(new Chunk(this.check + "                  ", info1));
      p.add(new Chunk("Balance: ", labelBold1));
      p.add(new Chunk(this.total + "                  ", info1));
      preface.add(p);
      
      p.setLeading(7.0F);
      p.clear();
      preface.add(p);
      
      document.add(Hpreface);
      document.add(preface);
      
      document.add(new Paragraph("Report generated by: " + System.getProperty("user.name") + " using 11th Street Room Management System, " + new Date(), cuteFont));
      


      document.close();
      
      Toolkit.getDefaultToolkit().beep();
      

      File f = new File(this.filename);
      FileInputStream fis = new FileInputStream(f);
      FileChannel fc = fis.getChannel();
      ByteBuffer bb = fc.map(FileChannel.MapMode.READ_ONLY, 0L, fc.size());
      PDFFile pdfFile = new PDFFile(bb);
      PDFPrintPage pages = new PDFPrintPage(pdfFile);
      
      PrinterJob pjob = PrinterJob.getPrinterJob();
      PageFormat pf = PrinterJob.getPrinterJob().defaultPage();
      
      Paper paper = new Paper();
      paper.setImageableArea(0.0D, 0.0D, paper.getWidth(), paper.getHeight());
      pf.setPaper(paper);
      
      pjob.setJobName(f.getName());
      Book book = new Book();
      book.append(pages, pf, pdfFile.getNumPages());
      pjob.setPageable(book);
      

      pjob.print();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
  
  private static void addMetaData(Document document)
  {
    document.addAuthor("Developer: Jose Armin Maningo; contact: jamsubzero@gmail.com");
    document.addCreator("jam");
  }
  
  private static void createTable(Paragraph par, DefaultTableModel t)
    throws BadElementException, DocumentException
  {
    int colNum = t.getColumnCount();
    
    PdfPTable table = new PdfPTable(colNum);
    float[] columnWidths = { 50.0F, 50.0F, 50.0F, 50.0F, 50.0F, 50.0F, 50.0F, 50.0F, 50.0F, 50.0F, 50.0F };
    table.setWidths(columnWidths);
    






    table.setWidthPercentage(100.0F);
    
    PdfPCell c1 = new PdfPCell(new Paragraph(t.getColumnName(0), labelBold));
    
    c1.setHorizontalAlignment(1);
    c1.setBorderWidth(1.0F);
    c1.setMinimumHeight(0.0F);
    table.addCell(c1);
    for (int c = 1; c < colNum; c++)
    {
      c1 = new PdfPCell(new Paragraph(t.getColumnName(c), labelBold));
      c1.setHorizontalAlignment(1);
      c1.setBorderWidth(1.0F);
      table.addCell(c1);
    }
    table.setHeaderRows(1);
    for (int r = 0; r < t.getRowCount(); r++) {
      for (int c = 0; c < colNum; c++) {
        table.addCell(new Paragraph(String.valueOf(t.getValueAt(r, c)), info));
      }
    }
    par.add(table);
  }
  
  private static void addEmptyLine(Paragraph paragraph, int number)
  {
    paragraph.setFont(empFont);
    for (int i = 0; i < number; i++) {
      paragraph.add(new Paragraph(" "));
    }
  }
}


/* Location:           D:\New folder\New folder\dist\11thPrototype.jar
 * Qualified Name:     Reports.CheckedOut
 * JD-Core Version:    0.7.0.1
 */