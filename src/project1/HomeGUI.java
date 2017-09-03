package project1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * Home GUI
 * This class contains all source code for the 
 * initialization and display of the GUI.  This class
 * also handles user interactions.
 */
public class HomeGUI extends JFrame { 
    private final Color selectBlue;
    
    private JFrame mainFrame;
    private JPanel northPanel;
    private JPanel southPanel;
    private JPanel middlePanel;
    
    private JTextField gui_txtBox;
    private JButton gui_btn_new;
    private JButton gui_btn_save;
    private JButton gui_btn_max;
    private JButton gui_btn_min;
    private JButton gui_btn_average;
   
    /**
     * Home GUI
     * This constructor initializes the GUI.
     */    
    public HomeGUI(){
        initComponets();
        selectBlue = new Color(27,161,226);
    } 
    
    /**
     * Initialize Components
     * This method starts the setup and initialization 
     * of the GUI.
     */  
    private void initComponets(){
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        /**
        * GUI Component Setup Sequence  
        */    
        
        //Build JFrame 
        mainFrame = new JFrame();
            mainFrame.setPreferredSize(new Dimension(275, 150));
            mainFrame.setResizable(false);

        //Build JPanels
        northPanel = new JPanel();
        southPanel = new JPanel();
        middlePanel = new JPanel();

        //Text Box Attributes
        gui_txtBox = new JTextField();
            gui_txtBox.setPreferredSize(new Dimension(250, 40));
            gui_txtBox.setHorizontalAlignment(SwingConstants.RIGHT);
            Font font = new Font("Calibri", Font.BOLD, 28);
            gui_txtBox.setFont(font);
            gui_txtBox.setEnabled(false);

        //Set Button Attributes
        gui_btn_new = new JButton("New");
            gui_btn_new.setPreferredSize(new Dimension(125, 18));
            gui_btn_new.setRolloverEnabled(false);
            gui_btn_new.setFocusable(false);       
        gui_btn_save = new JButton("Save");
            gui_btn_save.setPreferredSize(new Dimension(125, 18));
            gui_btn_save.setRolloverEnabled(false);
            gui_btn_save.setFocusable(false);
            gui_btn_save.setEnabled(false);
        gui_btn_max = new JButton("Max");
            gui_btn_max.setPreferredSize(new Dimension(80, 35));
            gui_btn_max.setFocusable(false);  
            gui_btn_max.setEnabled(false);
        gui_btn_min = new JButton("Min");
            gui_btn_min.setPreferredSize(new Dimension(80, 35));
            gui_btn_min.setFocusable(false);
            gui_btn_min.setEnabled(false);
        gui_btn_average = new JButton("Average");
            gui_btn_average.setPreferredSize(new Dimension(80, 35));  
            gui_btn_average.setFocusable(false);
            gui_btn_average.setEnabled(false);

        //Populate JPanels
        northPanel.add(gui_txtBox); 
        southPanel.add(gui_btn_max);
        southPanel.add(gui_btn_min); 
        southPanel.add(gui_btn_average);
        middlePanel.add(gui_btn_new);
        middlePanel.add(gui_btn_save);

        //Populate JFrame with JPanels
        mainFrame.add(northPanel, BorderLayout.NORTH);
        mainFrame.add(southPanel, BorderLayout.SOUTH);
        mainFrame.add(middlePanel, BorderLayout.CENTER);

        //Launch GUI
        mainFrame.pack();
        mainFrame.setVisible( true );                   

        /**
        * Action Listener Sequence
        */  
        
        //New Button 
        gui_btn_new.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                gui_btn_newActionPerformed(evt);
            }
        });

        //Save Button 
        gui_btn_save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                gui_btn_saveActionPerformed(evt);
            }
        });
        
        //Max Button 
        gui_btn_max.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                gui_btn_maxActionPerformed(evt);
            }
        });
        
        //Min Button 
        gui_btn_min.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                gui_btn_minActionPerformed(evt);
            }
        });
        
        //Average Button 
        gui_btn_average.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                gui_btn_averageActionPerformed(evt);
            }
        });
    }

    /**
    * Action handler Sequence
    */ 
    
    //New Button 
    private void gui_btn_newActionPerformed(ActionEvent evt) {
        Calculator math = new Calculator();  

        defaultCalcBtns();
        math.populateArray();
        math.mathEngine();
        gui_txtBox.setText("");
        enableBtns();
    } 

    //Save Button
    private void gui_btn_saveActionPerformed(ActionEvent evt) {
        SaveDataHandler sdh = new SaveDataHandler();
        sdh.saveData();
    }

    //Max Button
    private void gui_btn_maxActionPerformed(ActionEvent evt) {
        highlightButton(evt);
        gui_txtBox.setText(Calculator.getMax());
    } 

    //Min Button
    private void gui_btn_minActionPerformed(ActionEvent evt) {
        highlightButton(evt);
        gui_txtBox.setText(Calculator.getMin());
    } 

    //Average Button
    private void gui_btn_averageActionPerformed(ActionEvent evt) {
        gui_txtBox.setEditable(false);
        highlightButton(evt);
        gui_txtBox.setText(Calculator.getAverage());
    } 

    /**
    * Highlight Buttons
    * This method accepts ActionEvents and determines which 
    * button was selected.  The selected button is then
    * highlighted.
    * @param evt Button click event
    */    
    private void highlightButton(ActionEvent evt){
        //Reset all buttons 
        defaultCalcBtns();
        
        //Get selected button from ActionEvent
        JButton getBtnObj = (JButton)evt.getSource();
        
        //Highlight selected button
        getBtnObj.setBackground(selectBlue);
        getBtnObj.setBorder(BorderFactory.createLineBorder(selectBlue, 2)); 
        getBtnObj.setFont(new Font("Calibri", Font.BOLD, 12));
    }

    /**
    * Default Calculator Buttons
    * This method resets all calculator buttons;
    * max, min, average to their original state.
    */    
    private void defaultCalcBtns(){
        gui_btn_max.setBorder(null);
        gui_btn_min.setBorder(null);
        gui_btn_average.setBorder(null);

        gui_btn_max.setBackground(null);
        gui_btn_min.setBackground(null);
        gui_btn_average.setBackground(null);

        gui_btn_max.setFont(null);
        gui_btn_min.setFont(null);
        gui_btn_average.setFont(null);
    }

    /**
    * Enable Buttons
    * This method sets buttons enabled for the user to select.
    */  
    private void enableBtns(){
        gui_btn_max.setEnabled(true);
        gui_btn_min.setEnabled(true);
        gui_btn_average.setEnabled(true);
        gui_btn_save.setEnabled(true);
    }

    /**
    * Error Message
    * This method launches a JOptionPane GUI to display 
    * any error messages.  
    * @param message String description of the error.
    * @param title String description of the error title.
    */  
    public static void errMessage(String message, String title){
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.WARNING_MESSAGE);
    }
}



