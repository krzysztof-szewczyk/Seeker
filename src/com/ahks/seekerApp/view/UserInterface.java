package com.ahks.seekerApp.view;

import com.ahks.seekerApp.controller.SeekerController;
import com.ahks.seekerApp.model.MyListModel;
import com.ahks.seekerApp.model.SeekerModel;
import com.ahks.seekerApp.model.MyTableModel;
import javax.swing.*;

/**
 * User interface
 */
public class UserInterface extends JPanel{

    // GUI form components
    private JButton addFileBtn;
    private JTable table;
    private JButton searchBtn;
    private JList list;
    private JTextField searchField;
    private JButton addStringBtn;
    private JTextArea textAreaR;
    private JPanel panel;
    private JTextField threadCountField;
    private JLabel timeLabel;

    /**
     * Seeker model
     */
    private SeekerModel sm;

    /**
     * Table model
     */
    private MyTableModel tableModel;

    /**
     * List model
     */
    private MyListModel listModel;

    /**
     * <code>userInterface</code> constructor
     * @param sm Seeker model
     */
    public UserInterface(SeekerModel sm) {
        this.sm = sm;
        initializeView();
    }

    /*
    Getters
     */
    public JButton getAddFileBtn() {
        return addFileBtn;
    }
    public JButton getSearchBtn() {
        return searchBtn;
    }
    public JButton getAddStringBtn() {
        return addStringBtn;
    }
    public JTextField getSearchField() {
        return searchField;
    }
    public JTextArea getTextAreaR() {
        return textAreaR;
    }
    public JTable getTable() {
        return table;
    }
    public MyTableModel getTableModel() {
        return tableModel;
    }
    public JLabel getTimeLabel() {
        return timeLabel;
    }
    public MyListModel getListModel() {
        return listModel;
    }

    /**
     * Check if threads count is numerical. If not, sets 100
     * @return thread count
     */
    public int getThreadCountField() {
        if(!threadCountField.getText().isEmpty()){
            char[] ch=threadCountField.getText().toCharArray();
            for(int i = 0 ; i<ch.length; i++){
                if(!(ch[i]>='0' && ch[i]<='9')){
                    this.threadCountField.setText("100");
                    return 100;
                }
            }
            int time = Integer.parseInt(threadCountField.getText());
            return time;
        }else{
            this.threadCountField.setText("100");
            return 100;
        }
    }

    /**
     * Initialization of actionListseners and mouseListeners
     */
    public void initializeActionListener(SeekerController listener){
        addFileBtn.addActionListener(listener);
        addStringBtn.addActionListener(listener);
        searchBtn.addActionListener(listener);
        table.getSelectionModel().addListSelectionListener(listener);
        searchField.addActionListener(listener);
    }

    /**
     * Initializing of user interface components
     */
    private void initializeView() {

        JFrame frame = new JFrame("Your window name");
        frame.setTitle("Thread app");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        this.tableModel = sm.getTableModel();
        this.listModel = sm.getListModel();

        this.table.setModel(tableModel);
        this.list.setModel(listModel);

        searchBtn.setEnabled(false);
        searchField.setEnabled(false);
        addStringBtn.setEnabled(false);
    }
}
