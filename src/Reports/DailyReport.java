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

public class DailyReport
{
  private static final Font redInfo = new Font(Font.FontFamily.TIMES_ROMAN, 10.0F, 0, BaseColor.RED);
  private static final Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 10.0F, 1, BaseColor.RED);
  private static final Font labelBold1 = new Font(Font.FontFamily.TIMES_ROMAN, 12.0F, 0);
  private static final Font totalBold = new Font(Font.FontFamily.TIMES_ROMAN, 14.0F, 1);
  private static final Font info1 = new Font(Font.FontFamily.TIMES_ROMAN, 12.0F, 0);
  private static final Font label = new Font(Font.FontFamily.TIMES_ROMAN, 12.0F, 0);
  private static final Font labelAdj = new Font(Font.FontFamily.TIMES_ROMAN, 9.0F, 0);
  private static final Font titleBold = new Font(Font.FontFamily.TIMES_ROMAN, 12.0F, 1);
  private static final Font info = new Font(Font.FontFamily.TIMES_ROMAN, 12.0F, 0);
  private static final Font cuteFont = new Font(Font.FontFamily.TIMES_ROMAN, 5.0F, 2);
  private static final Font empFont = new Font(Font.FontFamily.TIMES_ROMAN, 3.0F, 1);
  private String filename = "";
  private String repDay = "";
  private String sales = "";
  private String room = "";
  private String balance = "";
  private String setCredit = "";
  private DefaultTableModel adjModel = null;
  private String cashAdj = "";
  private String total = "";
  private DefaultTableModel slipModel = null;
  private static String totalSlip = "";
  private DefaultTableModel outRecModel = null;
  private static String outTotal = "";
  private DefaultTableModel otherRecModel = null;
  private static String otherTotal = "";
  private String occu = "";
  private String vacant = "";
  private String unsetCC = "";
  private String numUnsetCC = "";
  private String occuRate = "";
  
  public DailyReport(String filename, String repDay, String sales, String room, String balance, String setCredit, DefaultTableModel adjModel, String cashAdj, String total, DefaultTableModel slipModel, String totalSlip, DefaultTableModel outRecModel, String outTotal, DefaultTableModel otherRecModel, String otherTotal, String occu, String vacant, String unsetCC, String numUnsetCC, String occuRate)
  {
    this.filename = filename;
    this.repDay = repDay;
    this.sales = sales;
    this.room = room;
    this.balance = balance;
    this.setCredit = setCredit;
    this.adjModel = adjModel;
    this.cashAdj = cashAdj;
    this.total = total;
    this.slipModel = slipModel;
    totalSlip = totalSlip;
    this.outRecModel = outRecModel;
    outTotal = outTotal;
    this.otherRecModel = otherRecModel;
    otherTotal = otherTotal;
    this.occu = occu;
    this.vacant = vacant;
    this.unsetCC = unsetCC;
    this.numUnsetCC = numUnsetCC;
    this.occuRate = occuRate;
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
      

      Hpreface.add(new Paragraph("D A I L Y    R E P O R T", labelBold1));
      

      Hpreface.add(new Paragraph("Report for " + this.repDay, info1));
      
      Paragraph preface = new Paragraph();
      preface.setAlignment(0);
      preface.setLeading(15.0F);
      
      Paragraph p = new Paragraph();
      p.setLeading(15.0F);
      
      p.add(new Chunk("I. Cash Reconciliation", titleBold));
      preface.add(p);
      p.clear();
      
      PdfPTable maintable = new PdfPTable(2);
      maintable.setHorizontalAlignment(1);
      maintable.setWidthPercentage(100.0F);
      float[] columnWidths1 = { 50.0F, 50.0F };
      maintable.setWidths(columnWidths1);
      maintable.getDefaultCell().setBorder(0);
      
      PdfPTable table = new PdfPTable(2);
      
      float[] columnWidths = { 50.0F, 50.0F };
      table.setWidths(columnWidths);
      table.setHorizontalAlignment(0);
      table.setWidthPercentage(100.0F);
      
      table.addCell(new Paragraph("Cash Sales:", label));
      PdfPCell cell = new PdfPCell(new Paragraph(this.sales, label));
      cell.setHorizontalAlignment(2);
      table.addCell(cell);
      table.addCell(new Paragraph("Room Account Payments:", label));
      cell = new PdfPCell(new Paragraph(this.room, label));
      cell.setHorizontalAlignment(2);
      table.addCell(cell);
      table.addCell(new Paragraph("Settled Balances:", label));
      cell = new PdfPCell(new Paragraph(this.balance, label));
      cell.setHorizontalAlignment(2);
      table.addCell(cell);
      table.addCell(new Paragraph("Credit Card Settlements:", label));
      cell = new PdfPCell(new Paragraph(this.setCredit, label));
      cell.setHorizontalAlignment(2);
      table.addCell(cell);
      
      table.addCell(new Paragraph("Cash Adjustments:", label));
      cell = new PdfPCell(new Paragraph(this.cashAdj, label));
      cell.setHorizontalAlignment(2);
      table.addCell(cell);
      for (int r = 0; r < this.adjModel.getRowCount(); r++)
      {
        table.addCell(new Paragraph(this.adjModel.getValueAt(r, 0).toString() + ":", labelAdj));
        cell = new PdfPCell(new Paragraph(this.adjModel.getValueAt(r, 1).toString(), labelAdj));
        cell.setHorizontalAlignment(2);
        table.addCell(cell);
      }
      table.addCell(new Paragraph("Total:", totalBold));
      cell = new PdfPCell(new Paragraph(this.total, totalBold));
      cell.setHorizontalAlignment(2);
      table.addCell(cell);
      

      maintable.addCell(new Paragraph("      a. Sales Received", titleBold));
      maintable.addCell(new Paragraph("      b. Deposit Slips", titleBold));
      maintable.addCell(table);
      maintable.addCell(createTable(preface, this.slipModel));
      maintable.addCell(new Paragraph(""));maintable.addCell(new Paragraph(""));
      maintable.addCell(new Paragraph("II. Accounts Receivables", titleBold));
      maintable.addCell(new Paragraph("III. Other Receivables", titleBold));
      maintable.addCell(createTable1(preface, this.outRecModel));
      maintable.addCell(createTable2(preface, this.otherRecModel));
      p.add(maintable);
      preface.add(p);
      p.clear();
      
      p.add(new Chunk("IV. Miscellaneous", titleBold));
      preface.add(p);
      p.clear();
      p.add(new Chunk("           Unsettled Credit Cards: ", labelBold1));
      p.add(new Chunk(this.unsetCC, info1));
      preface.add(p);
      p.clear();
      p.add(new Chunk("                                   " + this.numUnsetCC, info1));
      preface.add(p);
      p.clear();
      p.add(new Chunk("           Occupied Rooms: ", labelBold1));
      p.add(new Chunk(this.occu, info1));
      preface.add(p);
      p.clear();
      p.add(new Chunk("           Vacant Rooms: ", labelBold1));
      p.add(new Chunk(this.vacant, info1));
      preface.add(p);
      p.clear();
      p.add(new Chunk("           Occupation Rate: ", labelBold1));
      p.add(new Chunk(this.occuRate, info1));
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
  
  private static PdfPTable createTable(Paragraph par, DefaultTableModel t)
    throws BadElementException, DocumentException
  {
    int colNum = t.getColumnCount();
    
    PdfPTable table = new PdfPTable(colNum);
    
    float[] columnWidths = { 50.0F, 50.0F };
    table.setWidths(columnWidths);
    table.setHorizontalAlignment(0);
    






    table.setWidthPercentage(60.0F);
    
    PdfPCell c1 = new PdfPCell(new Paragraph(t.getColumnName(0), label));
    
    c1.setHorizontalAlignment(0);
    c1.setBorderWidth(1.0F);
    c1.setMinimumHeight(0.0F);
    table.addCell(c1);
    for (int c = 1; c < colNum; c++)
    {
      c1 = new PdfPCell(new Paragraph(t.getColumnName(c), label));
      c1.setHorizontalAlignment(0);
      c1.setBorderWidth(1.0F);
      table.addCell(c1);
    }
    table.setHeaderRows(1);
    for (int r = 0; r < t.getRowCount(); r++) {
      for (int c = 0; c < colNum; c++)
      {
        PdfPCell cell = new PdfPCell(new Paragraph(t.getValueAt(r, c).toString(), info));
        if (c == 1) {
          cell.setHorizontalAlignment(2);
        } else {
          cell.setHorizontalAlignment(0);
        }
        table.addCell(cell);
      }
    }
    table.addCell(new Paragraph("Total Deposits:", totalBold));
    PdfPCell cell = new PdfPCell(new Paragraph(totalSlip, totalBold));
    
    cell.setHorizontalAlignment(2);
    table.addCell(cell);
    
    return table;
  }
  
  private static PdfPTable createTable1(Paragraph par, DefaultTableModel t)
    throws BadElementException, DocumentException
  {
    int colNum = t.getColumnCount();
    
    PdfPTable table = new PdfPTable(colNum);
    float[] columnWidths = { 30.0F, 50.0F, 50.0F, 50.0F };
    table.setWidths(columnWidths);
    table.setHorizontalAlignment(0);
    







    table.setWidthPercentage(60.0F);
    
    PdfPCell c1 = new PdfPCell(new Paragraph(t.getColumnName(0), label));
    
    c1.setHorizontalAlignment(0);
    c1.setBorderWidth(1.0F);
    c1.setMinimumHeight(0.0F);
    table.addCell(c1);
    for (int c = 1; c < colNum; c++)
    {
      c1 = new PdfPCell(new Paragraph(t.getColumnName(c), label));
      c1.setHorizontalAlignment(0);
      c1.setBorderWidth(1.0F);
      table.addCell(c1);
    }
    table.setHeaderRows(1);
    for (int r = 0; r < t.getRowCount(); r++) {
      for (int c = 0; c < colNum; c++)
      {
        PdfPCell cell = new PdfPCell(new Paragraph(t.getValueAt(r, c).toString(), info));
        if (c == 3) {
          cell.setHorizontalAlignment(2);
        } else {
          cell.setHorizontalAlignment(0);
        }
        table.addCell(cell);
      }
    }
    table.addCell(new Paragraph(""));
    table.addCell(new Paragraph(""));
    table.addCell(new Paragraph("Total:", totalBold));
    PdfPCell cell = new PdfPCell(new Paragraph(outTotal, totalBold));
    cell.setHorizontalAlignment(2);
    table.addCell(cell);
    return table;
  }
  
  private static PdfPTable createTable2(Paragraph par, DefaultTableModel t)
    throws BadElementException, DocumentException
  {
    int colNum = t.getColumnCount();
    
    PdfPTable table = new PdfPTable(colNum);
    float[] columnWidths = { 50.0F, 40.0F, 40.0F, 40.0F };
    table.setWidths(columnWidths);
    table.setHorizontalAlignment(0);
    







    table.setWidthPercentage(60.0F);
    
    PdfPCell c1 = new PdfPCell(new Paragraph(t.getColumnName(0), label));
    
    c1.setHorizontalAlignment(0);
    c1.setBorderWidth(1.0F);
    c1.setMinimumHeight(0.0F);
    table.addCell(c1);
    for (int c = 1; c < colNum; c++)
    {
      c1 = new PdfPCell(new Paragraph(t.getColumnName(c), label));
      c1.setHorizontalAlignment(0);
      c1.setBorderWidth(1.0F);
      table.addCell(c1);
    }
    table.setHeaderRows(1);
    for (int r = 0; r < t.getRowCount(); r++) {
      for (int c = 0; c < colNum; c++)
      {
        PdfPCell cell = new PdfPCell(new Paragraph(t.getValueAt(r, c).toString(), info));
        if (c == 3) {
          cell.setHorizontalAlignment(2);
        } else {
          cell.setHorizontalAlignment(0);
        }
        table.addCell(cell);
      }
    }
    table.addCell(new Paragraph(""));
    table.addCell(new Paragraph(""));
    table.addCell(new Paragraph("Total:", totalBold));
    PdfPCell cell = new PdfPCell(new Paragraph(otherTotal, totalBold));
    cell.setHorizontalAlignment(2);
    table.addCell(cell);
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
 * Qualified Name:     Reports.DailyReport
 * JD-Core Version:    0.7.0.1
 */