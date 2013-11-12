package practicajtable;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class PracticaJTable extends AbstractTableModel{
       
        ArrayList datos = new ArrayList();
        String []columnas = {"Nombre", "Apellidos","Edad","Deporte","Localidad"};
        Object[] fila = new Object[5];  
        Class[] types = new Class[]{
            java.lang.String.class, java.lang.String.class, java.lang.Integer.class,
            java.lang.String.class, java.lang.String.class
             
            
        };
        
    public PracticaJTable(){
     // Object[] fila = new Object[5];
       fila[0] = "Alberto";
       fila[1] = "Martinez";
       fila[2] = new Integer(29);
       fila[3] = "Basket";
                
    }
    
     public PracticaJTable(ArrayList list){
        this.datos=list;
    }
    
    
    public String getColumnName(int col){
        return columnas[col].toString();
    }
    
     public Object[] getArray(){
         
        return this.fila;
           
    }
     
    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object[]elemento=(Object[]) datos.get(rowIndex);
        return  elemento[columnIndex];
    }
    
    public Class getColumnClass(int columIndex){
        return types[columIndex];
    }
    
    public boolean isCellEditable(int row, int col) { 
        boolean editar = false;
         if(col==columnas.length-1)
            editar=true;
         
    return editar;}
    
    public void setValueAt(Object value,int row,int col){
        Object[]fila=(Object[]) datos.get(row);
        fila[col]=value;
        fireTableCellUpdated(row,col);
    }
    
    public void addRow(Object [] fila){
        datos.add(fila);
        fireTableDataChanged();
    }
    
    public void removeRow (int fila){
        datos.remove(fila);
        fireTableDataChanged();
    }
}
