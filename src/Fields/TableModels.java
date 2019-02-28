package Fields;

import javax.swing.table.DefaultTableModel;

public class TableModels
{
  public DefaultTableModel occuModel = new DefaultTableModel(new Object[0][], new String[] { "Booking ID", "Room", "Guest", "Date In", "Date Out", "Remarks" })
  {
    boolean[] canEdit = { false, false, false, false, false, false, false };
    
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
      return this.canEdit[columnIndex];
    }
  };
  public DefaultTableModel resModel = new DefaultTableModel(new Object[0][], new String[] { "Reservation ID", "Room", "Guest", "Date In", "Date Out", "Remarks" })
  {
    boolean[] canEdit = { false, false, false, false, false, false };
    
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
      return this.canEdit[columnIndex];
    }
  };
  public DefaultTableModel vacantModel = new DefaultTableModel(new Object[0][], new String[] { "Room ID", "Room Type", "Ventilation", "Price", "Extra", "Remarks", "Status" })
  {
    boolean[] canEdit = { false, false, false, false, false, false, false };
    
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
      return this.canEdit[columnIndex];
    }
  };
  public DefaultTableModel suggestModel = new DefaultTableModel(new Object[0][], new String[] { "From", "To" })
  {
    boolean[] canEdit = { false, false };
    
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
      return this.canEdit[columnIndex];
    }
  };
  public DefaultTableModel viewPayModel = new DefaultTableModel(new Object[0][], new String[] { "PayID", "Mode", "Date Paid", "Amount" })
  {
    boolean[] canEdit = { false, false, false, false };
    
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
      return this.canEdit[columnIndex];
    }
  };
  public DefaultTableModel guestModel = new DefaultTableModel(new Object[0][], new String[] { "Guest ID", "Guest Name", "Address", "Contact #", "Remarks" })
  {
    boolean[] canEdit = { false, false, false, false, false };
    
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
      return this.canEdit[columnIndex];
    }
  };
  public DefaultTableModel roomModel = new DefaultTableModel(new Object[0][], new String[] { "Room Name", "Type", "Ventilation", "Price", "Extra", "Remarks", "Status" })
  {
    boolean[] canEdit = { false, false, false, false, false, false, false };
    
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
      return this.canEdit[columnIndex];
    }
  };
  public DefaultTableModel calModel = new DefaultTableModel(new Object[0][], new String[0]);
  public DefaultTableModel outReportModel = new DefaultTableModel(new Object[0][], new String[] { "Record#", "Guest", "Room", "Discount", "Room Price", "Sales", "Extra", "Adjustments", "Total", "Balance", "Date In", "Date Out" })
  {
    boolean[] canEdit = { false, false, false, false, false, false, false, false, false, false, false, false };
    
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
      return this.canEdit[columnIndex];
    }
  };
  public DefaultTableModel outIncomeModel = new DefaultTableModel(new Object[0][], new String[] { "Room", "Guest", "Amount", "Mode", "Date Paid" })
  {
    boolean[] canEdit = { false, false, false, false, false };
    
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
      return this.canEdit[columnIndex];
    }
  };
  public DefaultTableModel viewSaleModel = new DefaultTableModel(new Object[0][], new String[] { "Date", "Item", "Quantity", "Price", "Amount" })
  {
    boolean[] canEdit = { false, false, false, false, false };
    
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
      return this.canEdit[columnIndex];
    }
  };
  public DefaultTableModel currentReport = new DefaultTableModel(new Object[0][], new String[] { "Room", "Guest", "Room Price", "Discount", "Extra", "Adjustments", "Sales", "Total", "Paid", "Balance", "Date In", "Date Out" })
  {
    boolean[] canEdit = { false, false, false, false, false, false, false, false, false, false, false, false };
    
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
      return this.canEdit[columnIndex];
    }
  };
  public DefaultTableModel viewExtraModel = new DefaultTableModel(new Object[0][], new String[] { "Price", "Quantity", "Date In", "Date Out" })
  {
    boolean[] canEdit = { false, false, false, false };
    
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
      return this.canEdit[columnIndex];
    }
  };
  public DefaultTableModel notifModel = new DefaultTableModel(new Object[0][], new String[] { "Room", "Guest", "Check Out Date", "Remarks" })
  {
    boolean[] canEdit = { false, false, false, false };
    
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
      return this.canEdit[columnIndex];
    }
  };
  public DefaultTableModel adjustModel = new DefaultTableModel(new Object[0][], new String[] { "AdjID", "Description", "Date Issued", "Amount" })
  {
    boolean[] canEdit = { false, false, false, false };
    
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
      return this.canEdit[columnIndex];
    }
  };
  public DefaultTableModel unSetModel = new DefaultTableModel(new Object[0][], new String[] { "Amount", "Customer", "Trans. Date", "#" })
  {
    boolean[] canEdit = { false, false, false, false };
    
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
      return this.canEdit[columnIndex];
    }
  };
  public DefaultTableModel setModel = new DefaultTableModel(new Object[0][], new String[] { "Amount", "Customer", "Trans. Date", "Date Settled", "#" })
  {
    boolean[] canEdit = { false, false, false, false, false };
    
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
      return this.canEdit[columnIndex];
    }
  };
  public DefaultTableModel depModel = new DefaultTableModel(new Object[0][], new String[] { "Deposit Date", "Amount" })
  {
    boolean[] canEdit = { false, false, false };
    
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
      return this.canEdit[columnIndex];
    }
  };
  public DefaultTableModel dayAdjModel = new DefaultTableModel(new Object[0][], new String[] { "Description", "Amount", "Date Added" })
  {
    boolean[] canEdit = { false, false, false };
    
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
      return this.canEdit[columnIndex];
    }
  };
  public DefaultTableModel receivablesModel = new DefaultTableModel(new Object[0][], new String[] { "Room", "Guest", "Date Out", "Balance" })
  {
    boolean[] canEdit = { false, false, false, false };
    
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
      return this.canEdit[columnIndex];
    }
  };
  public DefaultTableModel otherBalModel = new DefaultTableModel(new Object[0][], new String[] { "Customer", "Date", "Amount", "Charged" })
  {
    boolean[] canEdit = { false, false, false, false };
    
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
      return this.canEdit[columnIndex];
    }
  };
  public DefaultTableModel balancesModel = new DefaultTableModel(new Object[0][], new String[] { "Amount", "Date", "Room" })
  {
    boolean[] canEdit = { false, false, false };
    
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
      return this.canEdit[columnIndex];
    }
  };
}


/* Location:           D:\New folder\New folder\dist\11thPrototype.jar
 * Qualified Name:     Fields.TableModels
 * JD-Core Version:    0.7.0.1
 */