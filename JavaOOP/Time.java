import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener; 
import java.awt.event.ActionEvent;
public class Time extends JFrame
{
   private JLabel hour, minute, second, month, day, year;//the following are instance variables
   private JButton setButton, iDayButton, dDayButton, iSecondButton, dSecondButton;
   private final String[] hrArray = new String[24];
   private final String[] minArray = new String[60];
   private final String[] secArray = new String[60];
   private final String[] monArray = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
   private final String[] dyArray = new String[32];
   private final String[] yrArray = new String[201];
   private JList hrList, minList, secList, monList, dyList, yrList;
   private JTextField disTime;  
   buttonHandler h = new buttonHandler();
   public Time()//No Argument construstor
     {
       super("Time");//Creates container for JFrame
       Container mycontainer = getContentPane();
       mycontainer.setLayout(new FlowLayout());
       
       hour = new JLabel("Hour");//Labels for drop downs
       minute = new JLabel("Minute");
       second = new JLabel("Second  ");
       month = new JLabel("Month    ");
       day = new JLabel("Day  ");
       year = new JLabel("Year  ");
       add(hour);
       add(minute);
       add(second);
       add(month);
       add(day);
       add(year);
       
       
       for(int i = 0; i>=0 && i<=23; i ++)//hour DropDown
       {
         hrArray[i] = String.valueOf(i);
       }
       hrList = new JList( hrArray );
       hrList.setVisibleRowCount( 10 );
       hrList.setSelectionMode( ListSelectionModel.SINGLE_SELECTION);
       add (new JScrollPane(hrList));
    
       
       
       for(int j = 0; j>=0 && j<=59; j ++)//Minute DropDown
       {
         minArray[j] = String.valueOf(j);
       }
       minList = new JList( minArray );
       minList.setVisibleRowCount( 10 );
       minList.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
       add (new JScrollPane(minList));
       
       for(int k = 0; k>=0 && k<=59; k ++)//Second Dropdown
       {
         secArray[k] = String.valueOf(k);
       }
       secList = new JList( secArray );
       secList.setVisibleRowCount( 10 );
       secList.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
       add (new JScrollPane(secList));
        
       monList = new JList( monArray );//Month Dropdown
       monList.setVisibleRowCount( 10 );
       monList.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
       add (new JScrollPane(monList));
       
       for(int l = 1; l>=1 && l<=31; l ++)//day Dropdown
       {
         dyArray[l] = String.valueOf(l);
       }
       dyList = new JList( dyArray );
       dyList.setVisibleRowCount(85);
       dyList.setSelectionMode( ListSelectionModel.SINGLE_SELECTION);
       add (new JScrollPane(dyList));
       
       
       int yr = 1900;
       for(int m = 0; m>=0 && m<=200; m ++)//Year Dropdown
       {
         
         yrArray[m] = String.valueOf(yr);
         yr ++;
       }
       yrList = new JList( yrArray );
       yrList.setVisibleRowCount(10);
       yrList.setSelectionMode( ListSelectionModel.SINGLE_SELECTION);
       add (new JScrollPane(yrList));
       
       
       disTime = new JTextField(25);//Uneditable text field
       disTime.setEditable( false );
       add( disTime ); 
       
       setButton  = new JButton("Set Watch");//SetWatch Button with action listener
       setButton.addActionListener(h);
       add (setButton);
                                 
       iDayButton = new JButton("Increase Day");//Increase Day button with action listener
       iDayButton.addActionListener(h);
       add (iDayButton);
       
       dDayButton = new JButton("Decrease Day");//Decrese Day button with action listener
       dDayButton.addActionListener(h);
       add (dDayButton);
       
       iSecondButton = new JButton("Increase Second");//Increase Second Button with action listener
       iSecondButton.addActionListener(h);
       add (iSecondButton);
       
       dSecondButton = new JButton("Decrease Second");//Decrease Second with action listener
       dSecondButton.addActionListener(h);
       add (dSecondButton); 
       
       mycontainer.setPreferredSize(new Dimension(316,365));//Prfered size for flowLayout
             
       
       
     }
     
   
   //-----------------------------Button Action Listener Class------------------
   
     private class buttonHandler implements ActionListener
     {
       betterWatch tick = new betterWatch();//Creates betterWatch object tick
       
       public void actionPerformed( ActionEvent e)
       {
         
         //Set Button action handler
         if(e.getSource() == setButton)
         {
           //setWatch from tick
           tick.setWatch(hrList.getSelectedIndex(),  minList.getSelectedIndex(),  secList.getSelectedIndex(),
                        monList.getSelectedIndex()+1,  dyList.getSelectedIndex(), (yrList.getSelectedIndex()+1900));
           
           disTime.setText(tick.showWatch());
           
         }
       
         //Increase Day handler
         else if (e.getSource() == iDayButton) 
           {
             
             tick.increaseDay();
             disTime.setText(tick.showWatch());
             
           }
         //Decrease Day handler                            
         else if(e.getSource() == dDayButton)
           {
             tick.decreaseDay();
             
             disTime.setText(tick.showWatch());
             
           }
         //Increase Second handler  
         else if (e.getSource() == iSecondButton) 
           {
            
             tick.increaseSecond();
             
             disTime.setText(tick.showWatch());
             
           }
         //Decrease Second Handler
         else if (e.getSource() == dSecondButton) 
           {
             
             tick.decreaseSecond();
             
             disTime.setText(tick.showWatch());
           }
         
            
      }
    }
  }                                
             
          
         


     
      