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

public class Folio
{
  private static final Font redInfo = new Font(Font.FontFamily.TIMES_ROMAN, 10.0F, 0, BaseColor.RED);
  private static final Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 10.0F, 1, BaseColor.RED);
  private static final Font labelBold1 = new Font(Font.FontFamily.TIMES_ROMAN, 12.0F, 0);
  private static final Font info1 = new Font(Font.FontFamily.TIMES_ROMAN, 12.0F, 0);
  private static final Font labelBold = new Font(Font.FontFamily.TIMES_ROMAN, 14.0F, 0);
  private static final Font titleBold = new Font(Font.FontFamily.TIMES_ROMAN, 14.0F, 1);
  private static final Font totalBold = new Font(Font.FontFamily.TIMES_ROMAN, 14.0F, 1);
  private static final Font balanceBold = new Font(Font.FontFamily.TIMES_ROMAN, 16.0F, 1);
  private static final Font info = new Font(Font.FontFamily.TIMES_ROMAN, 12.0F, 0);
  private static final Font cuteFont = new Font(Font.FontFamily.TIMES_ROMAN, 5.0F, 2);
  private static final Font empFont = new Font(Font.FontFamily.TIMES_ROMAN, 3.0F, 1);
  private String filename = "";
  private String guest = "";
  private String room = "";
  private String checkIn = "";
  private String checkOut = "";
  private String roomPrice = "";
  private String extra = "";
  private String numDays = "";
  private DefaultTableModel adjustModel = null;
  private static String totalAdjust = "";
  private DefaultTableModel salesAccModel = null;
  private static String totalSales = "";
  private static String paidSales = "";
  private static String balSales = "";
  private DefaultTableModel payHistModel = null;
  private static String totalPayment = "";
  private String returnStat = "";
  private String totalBal = "";
  
  public Folio(String filename, String guest, String room, String checkIn, String checkOut, String roomPrice, String extra, String numDays, DefaultTableModel adjustModel, String totalAdjust, DefaultTableModel salesAccModel, String totalSales, String paidSales, String balSales, DefaultTableModel payHistModel, String totalPayment, String returnStat, String totalBal)
  {
    this.filename = filename;
    this.guest = guest;
    this.room = room;
    this.checkIn = checkIn;
    this.checkOut = checkOut;
    this.roomPrice = roomPrice;
    this.salesAccModel = salesAccModel;
    this.adjustModel = adjustModel;
    totalAdjust = totalAdjust;
    this.payHistModel = payHistModel;
    this.extra = extra;
    this.numDays = numDays;
    totalSales = totalSales;
    paidSales = paidSales;
    balSales = balSales;
    totalPayment = totalPayment;
    this.returnStat = returnStat;
    this.totalBal = totalBal;
    savePDF();
  }
  
  private void savePDF()
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
      Hpreface.setSpacingAfter(10.0F);
      Hpreface.setSpacingBefore(10.0F);
      Hpreface.setLeading(15.0F);
      

      Hpreface.add(new Paragraph("11th Street Bed & Breakfast Inn", labelBold1));
      

      Hpreface.add(new Paragraph("11th Lacson St., Bacolod City, Negros Occidental", labelBold1));
      


      Hpreface.add(new Paragraph("Telefax: (034) 4339191", labelBold1));
      


      Hpreface.add(new Paragraph("Mobile: 0922-8433919", labelBold1));
      

      Hpreface.add(new Paragraph("Email: bb11st@yahoo.com", labelBold1));
      

      Hpreface.add(new Paragraph("Website: www.bb11st.webeden.co.uk", labelBold1));
      

      Hpreface.add(new Paragraph("Facebook: 11th Street bed and breakfast pension house Bacolod City", labelBold1));
      

      addEmptyLine(Hpreface, 1);
      Hpreface.add(new Paragraph("G U E S T    F O L I O", labelBold1));
      

      addEmptyLine(Hpreface, 1);
      Hpreface.add(new Paragraph("Guest: " + this.guest, labelBold1));
      


      Paragraph preface = new Paragraph();
      preface.setAlignment(0);
      preface.setLeading(15.0F);
      
      Paragraph p = new Paragraph();
      
      p.setLeading(15.0F);
      
      PdfPTable maintable = new PdfPTable(2);
      maintable.setHorizontalAlignment(1);
      maintable.setWidthPercentage(100.0F);
      float[] columnWidths1 = { 50.0F, 50.0F };
      maintable.setWidths(columnWidths1);
      maintable.getDefaultCell().setBorder(0);
      
      PdfPTable table = new PdfPTable(2);
      
      float[] columnWidths = { 30.0F, 40.0F };
      table.setWidths(columnWidths);
      table.setHorizontalAlignment(0);
      table.setWidthPercentage(100.0F);
      
      table.addCell(new Paragraph("Check In:", labelBold1));
      table.addCell(new Paragraph(this.checkIn, labelBold1));
      table.addCell(new Paragraph("Check Out:", labelBold1));
      table.addCell(new Paragraph(this.checkOut, labelBold1));
      table.addCell(new Paragraph("Room Name:", labelBold1));
      table.addCell(new Paragraph(this.room, labelBold1));
      table.addCell(new Paragraph("Days:", labelBold1));
      table.addCell(new Paragraph(this.numDays, labelBold1));
      table.addCell(new Paragraph("Room Price", labelBold1));
      PdfPCell cell = new PdfPCell(new Paragraph(this.roomPrice, labelBold1));
      cell.setHorizontalAlignment(2);
      table.addCell(cell);
      table.addCell(new Paragraph("Extra:", labelBold1));
      
      cell = new PdfPCell(new Paragraph(this.extra, labelBold1));
      cell.setHorizontalAlignment(2);
      table.addCell(cell);
      table.addCell(new Paragraph("Total Amount:", totalBold));
      float total = Integer.parseInt(this.numDays) * Float.parseFloat(this.roomPrice) + Float.parseFloat(this.extra);
      

      cell = new PdfPCell(new Paragraph(total + "", totalBold));
      cell.setHorizontalAlignment(2);
      
      table.addCell(cell);
      maintable.addCell(new Paragraph("I. Room Charges", titleBold));
      maintable.addCell(new Paragraph("II. Adjustments", titleBold));
      maintable.addCell(table);
      maintable.addCell(createTable1(preface, this.adjustModel));
      maintable.addCell(new Paragraph(""));maintable.addCell(new Paragraph(""));
      maintable.addCell(new Paragraph("III. Sales Account", titleBold));
      maintable.addCell(new Paragraph("IV. Payment History", titleBold));
      maintable.addCell(createTable2(preface, this.salesAccModel));
      maintable.addCell(createTable3(preface, this.payHistModel));
      
      p.add(maintable);
      preface.add(p);
      p.clear();
      
      p.add(new Chunk(this.returnStat, balanceBold));
      p.add(new Chunk(" " + this.totalBal, balanceBold));
      preface.add(p);
      p.clear();
      
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
  
  private static PdfPTable createTable1(Paragraph par, DefaultTableModel t)
    throws BadElementException, DocumentException
  {
    int colNum = t.getColumnCount();
    
    PdfPTable table = new PdfPTable(colNum);
    
    float[] columnWidths = { 50.0F, 50.0F, 50.0F };
    table.setWidths(columnWidths);
    table.setHorizontalAlignment(0);
    






    table.setWidthPercentage(45.0F);
    
    PdfPCell c1 = new PdfPCell(new Paragraph(t.getColumnName(0), labelBold));
    
    c1.setHorizontalAlignment(0);
    c1.setBorderWidth(1.0F);
    c1.setMinimumHeight(0.0F);
    table.addCell(c1);
    for (int c = 1; c < colNum; c++)
    {
      c1 = new PdfPCell(new Paragraph(t.getColumnName(c), labelBold));
      c1.setHorizontalAlignment(0);
      c1.setBorderWidth(1.0F);
      table.addCell(c1);
    }
    table.setHeaderRows(1);
    for (int r = 0; r < t.getRowCount(); r++) {
      for (int c = 0; c < colNum; c++)
      {
        PdfPCell cell = new PdfPCell(new Paragraph(t.getValueAt(r, c).toString(), info));
        if (c == 2) {
          cell.setHorizontalAlignment(2);
        } else {
          cell.setHorizontalAlignment(0);
        }
        table.addCell(cell);
      }
    }
    table.addCell(new Paragraph(""));
    table.addCell(new Paragraph("Total:", totalBold));
    PdfPCell cell = new PdfPCell(new Paragraph(totalAdjust, totalBold));
    cell.setHorizontalAlignment(2);
    table.addCell(cell);
    return table;
  }
  
  private static PdfPTable createTable3(Paragraph par, DefaultTableModel t)
    throws BadElementException, DocumentException
  {
    int colNum = t.getColumnCount();
    
    PdfPTable table = new PdfPTable(colNum);
    
    float[] columnWidths = { 50.0F, 50.0F, 50.0F };
    table.setWidths(columnWidths);
    table.setHorizontalAlignment(0);
    






    table.setWidthPercentage(60.0F);
    
    PdfPCell c1 = new PdfPCell(new Paragraph(t.getColumnName(0), labelBold));
    
    c1.setHorizontalAlignment(0);
    c1.setBorderWidth(1.0F);
    c1.setMinimumHeight(0.0F);
    table.addCell(c1);
    for (int c = 1; c < colNum; c++)
    {
      c1 = new PdfPCell(new Paragraph(t.getColumnName(c), labelBold));
      c1.setHorizontalAlignment(0);
      c1.setBorderWidth(1.0F);
      table.addCell(c1);
    }
    table.setHeaderRows(1);
    for (int r = 0; r < t.getRowCount(); r++) {
      for (int c = 0; c < colNum; c++)
      {
        PdfPCell cell = new PdfPCell(new Paragraph(t.getValueAt(r, c).toString(), info));
        if (c == 2) {
          cell.setHorizontalAlignment(2);
        } else {
          cell.setHorizontalAlignment(0);
        }
        table.addCell(cell);
      }
    }
    table.addCell(new Paragraph(""));
    table.addCell(new Paragraph("Total:", totalBold));
    PdfPCell cell = new PdfPCell(new Paragraph(totalPayment, totalBold));
    cell.setHorizontalAlignment(2);
    table.addCell(cell);
    return table;
  }
  
  private static PdfPTable createTable2(Paragraph par, DefaultTableModel t)
    throws BadElementException, DocumentException
  {
    int colNum = t.getColumnCount();
    
    PdfPTable table = new PdfPTable(colNum);
    float[] columnWidths = { 60.0F, 35.0F, 50.0F, 50.0F, 50.0F };
    table.setWidths(columnWidths);
    table.setHorizontalAlignment(0);
    







    table.setWidthPercentage(60.0F);
    
    PdfPCell c1 = new PdfPCell(new Paragraph(t.getColumnName(0), labelBold));
    
    c1.setHorizontalAlignment(0);
    c1.setBorderWidth(1.0F);
    c1.setMinimumHeight(0.0F);
    table.addCell(c1);
    for (int c = 1; c < colNum; c++)
    {
      c1 = new PdfPCell(new Paragraph(t.getColumnName(c), labelBold));
      c1.setHorizontalAlignment(0);
      c1.setBorderWidth(1.0F);
      table.addCell(c1);
    }
    table.setHeaderRows(1);
    for (int r = 0; r < t.getRowCount(); r++) {
      for (int c = 0; c < colNum; c++)
      {
        PdfPCell cell = new PdfPCell(new Paragraph(t.getValueAt(r, c).toString(), info));
        if (c == 4) {
          cell.setHorizontalAlignment(2);
        } else {
          cell.setHorizontalAlignment(0);
        }
        table.addCell(cell);
      }
    }
    table.addCell("");table.addCell("");table.addCell("");
    table.addCell(new Paragraph("Total:", totalBold));
    
    PdfPCell cell = new PdfPCell(new Paragraph(totalSales, totalBold));
    cell.setHorizontalAlignment(2);
    
    table.addCell(cell);
    table.addCell("");table.addCell("");table.addCell("");
    table.addCell(new Paragraph("Paid:", totalBold));
    
    cell = new PdfPCell(new Paragraph(paidSales, totalBold));
    cell.setHorizontalAlignment(2);
    table.addCell(cell);
    
    table.addCell("");table.addCell("");table.addCell("");
    table.addCell(new Paragraph("Balance:", totalBold));
    
    cell = new PdfPCell(new Paragraph(balSales, totalBold));
    cell.setHorizontalAlignment(2);
    table.addCell(cell);
    
    table.addCell(new Paragraph(balSales, totalBold));
    return table;
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
 * Qualified Name:     Reports.Folio
 * JD-Core Version:    0.7.0.1
 */