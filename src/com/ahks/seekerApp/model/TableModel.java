package com.ahks.seekerApp.model;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class TableModel extends AbstractTableModel {

    private ArrayList<TextFile> fileArray;
    private ArrayList<ArrayList<Integer>> resultsArray;
    private String[] columnNames = {"Name","Path","Matched Results"};


   public TableModel() {
       fileArray = new ArrayList<TextFile>();
       resultsArray = new ArrayList<ArrayList<Integer>>();
   }

//   adding file to table model
    public void addFileToArray(String fileName, String filePath, ArrayList<Integer> results) {
       fileArray.add(new TextFile(fileName, filePath, results));
       resultsArray.add(results);
       fireTableDataChanged();
   }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
   public int getRowCount() {
       return fileArray.size();
   }

   @Override
   public int getColumnCount() {
       return 3;
   }

   @Override
//   returns value at certain row and column of the table model
   public Object getValueAt(int row, int col) {
       switch (col) {
           case 0:
               return fileArray.get(row).getName();
           case 1:
               return fileArray.get(row).getFullPath();
           case 2:
               return fileArray.get(row).getResults();
           default:
               return null;
       }
   }
    public ArrayList<ArrayList<Integer>> getResultsArray() {
        return resultsArray;
    }

    public String getRowPath(int row){
       return fileArray.get(row).getFullPath();
   }

//    public String[] getTextFilesPaths () {
//        int nRow = this.getRowCount();
//        String[] filePath = new String[nRow];
//        for (int i = 0 ; i < nRow ; i++)
//            filePath[i] = (String) this.getValueAt(i,1);
//        return filePath;
//    }
}
