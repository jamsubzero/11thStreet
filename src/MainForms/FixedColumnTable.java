package MainForms;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.BorderFactory;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class FixedColumnTable
  implements ChangeListener, PropertyChangeListener
{
  private JTable main;
  private JTable fixed;
  private JScrollPane scrollPane;
  
  public FixedColumnTable(int fixedColumns, JScrollPane scrollPane)
  {
    this.scrollPane = scrollPane;
    
    this.main = ((JTable)scrollPane.getViewport().getView());
    this.main.setAutoCreateColumnsFromModel(false);
    this.main.addPropertyChangeListener(this);
    



    int totalColumns = this.main.getColumnCount();
    
    this.fixed = new JTable();
    

    this.fixed.setBorder(BorderFactory.createEtchedBorder());
    


    this.fixed.setAutoResizeMode(0);
    
    this.fixed.setIntercellSpacing(new Dimension(5, 5));
    
    this.fixed.setRowHeight(27);
    
    this.fixed.setRowSelectionAllowed(false);
    
    this.fixed.setFont(new Font("Tahoma", 1, 12));
    


    this.fixed.setEnabled(false);
    
    this.fixed.getTableHeader().setReorderingAllowed(false);
    
    this.fixed.setAutoCreateColumnsFromModel(false);
    this.fixed.setModel(this.main.getModel());
    this.fixed.setSelectionModel(this.main.getSelectionModel());
    this.fixed.setFocusable(false);
    for (int i = 0; i < fixedColumns; i++)
    {
      TableColumnModel columnModel = this.main.getColumnModel();
      TableColumn column = columnModel.getColumn(0);
      columnModel.removeColumn(column);
      this.fixed.getColumnModel().addColumn(column);
    }
    this.fixed.setPreferredScrollableViewportSize(this.fixed.getPreferredSize());
    scrollPane.setRowHeaderView(this.fixed);
    scrollPane.setCorner("UPPER_LEFT_CORNER", this.fixed.getTableHeader());
    


    scrollPane.getRowHeader().addChangeListener(this);
  }
  
  public JTable getFixedTable()
  {
    return this.fixed;
  }
  
  public void stateChanged(ChangeEvent e)
  {
    JViewport viewport = (JViewport)e.getSource();
    this.scrollPane.getVerticalScrollBar().setValue(viewport.getViewPosition().y);
  }
  
  public void propertyChange(PropertyChangeEvent e)
  {
    if ("selectionModel".equals(e.getPropertyName())) {
      this.fixed.setSelectionModel(this.main.getSelectionModel());
    }
    if ("model".equals(e.getPropertyName())) {
      this.fixed.setModel(this.main.getModel());
    }
  }
}


/* Location:           D:\New folder\New folder\dist\11thPrototype.jar
 * Qualified Name:     MainForms.FixedColumnTable
 * JD-Core Version:    0.7.0.1
 */