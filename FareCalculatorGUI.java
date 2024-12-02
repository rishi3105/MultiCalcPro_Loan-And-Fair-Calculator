//Fonts: Comic Sans MS, Curlz MT, Brush Script MT

import javax.swing.*;
// import javax.swing.event.DocumentEvent;
// import javax.swing.event.DocumentListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class FareCalculatorGUI extends JFrame implements ActionListener
{
    int ch;

    JPanel panelUp;
    JPanel panelLeft;
    JPanel panelCenter;

    JPanel centerChoice;
    JComboBox dropDownBox;

    JPanel autoRickshaw;
    
    JLabel Q1=new JLabel(); //Making a Label to the subpanel for auto rickshaw
    JLabel Q1text=new JLabel("Distance travelled(km):"); //A Label text to tell the user what to enter
    JTextField distance=new JTextField("EG:12.4"); //A Textfield to input the answer from the user

    JLabel Q2=new JLabel();
    JLabel Q2text=new JLabel("Waiting time(mins):");
    JTextField waitingTime=new JTextField("EG:4.5");

    JLabel Q3=new JLabel();
    JLabel Q3text=new JLabel("Post-midnight travel?(12:00AM - 5:00AM):");
    JTextField night=new JTextField("EG:yes/no/y/n");

    JLabel Q4=new JLabel();
    JLabel Q4text=new JLabel("Bags exceeding 60x40cm:");
    JTextField bags=new JTextField("EG:0/1/2");

    JLabel Q5=new JLabel();
    JLabel Q5text=new JLabel("AC journey?:");
    JTextField ac=new JTextField("EG:yes/no/y/n");

    JButton submit;

    JPanel answerPanel;
    JLabel answer;

    // InputVerifier verifier = new InputVerifier() {
    //     @Override
    //     public boolean verify(JComponent input) 
    //     {
    //         JTextField textField = (JTextField) input;
    //         String text = textField.getText();

    //         if(input == bags) 
    //         {
    //             try
    //             {
    //                 Integer.parseInt(text);
    //                 return true;
    //             }
    //             catch(Exception e) 
    //             {
    //                 return false;
    //             }
    //         } 
    //         else 
    //         {
    //             try 
    //             {
    //                 Double.parseDouble(text);
    //                 return true;
    //             } 
    //             catch(Exception e) 
    //             {
    //                 return false;
    //             }
    //         }
    //     }
    // };

    // DocumentListener docListener = new DocumentListener() {
    //     @Override
    //     public void insertUpdate(DocumentEvent e) {
    //         updateSubmitButton();
    //     }

    //     @Override
    //     public void removeUpdate(DocumentEvent e) {
    //         updateSubmitButton();
    //     }

    //     @Override
    //     public void changedUpdate(DocumentEvent e) {
    //         updateSubmitButton();
    //     }
    // };

    public FareCalculatorGUI()
    {
        this.setTitle("MultiCalcPro | Fare Calculator"); //Title of window
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Exits program on cancelling
        this.setSize(760, 760); //size of the screen 
        this.setLayout(new BorderLayout(10, 10)); //width and height with Layout
        //this.setResizable(false); //size cannot be manually changed during runtime

        //To centralize the window when it pops up
        Dimension objDimension = Toolkit.getDefaultToolkit().getScreenSize();
        int X = (objDimension.width - this.getWidth()) / 2;
        int Y = (objDimension.height - this.getHeight()) / 2;
        this.setLocation(X, Y);
        
        //Logo for the window
        ImageIcon img=new ImageIcon("Logo.png");
        this.setIconImage(img.getImage());
        
        //Background color of the window
        this.getContentPane().setBackground(new Color(0xBA8E7A)); //BA8E7A //B7BCBF //66796B

        //Main Panels
        panelUp=new JPanel();
        panelLeft=new JPanel();
        panelCenter=new JPanel();
        // JPanel panelRight=new JPanel();
        // JPanel panelDown=new JPanel();
        
    
        //Panel sizes
        panelUp.setPreferredSize(new Dimension(100, 100));
        panelLeft.setPreferredSize(new Dimension(100, 100));
        panelCenter.setPreferredSize(new Dimension(100, 100));

        //Panel Background Colors
        panelUp.setBackground(new Color(0xFFE2C3)); // BB86FC
        panelLeft.setBackground(new Color(0xFFFFFF)); 
        panelCenter.setBackground(new Color(0xFBF2ED)); //FBF2ED

        JLabel topic=new JLabel();
        topic.setText("Welcome to Fare Calculator!");
        topic.setFont(new Font("Brush Script MT", Font.PLAIN, 65));
        topic.setForeground(new Color(0x800000)); //800000 //0x000080 //7002d6
        panelUp.add(topic);

        //Setting layout of Center Panel to null
        //Now every component added to it must have setBounds to set where to be in the panel
        panelCenter.setLayout(null);

        //Subpanel that will contain choice of vehicle
        centerChoice=new JPanel();
        centerChoice.setBackground(new Color(0xFBF2ED)); //F2CEE6 //FBF2ED
        centerChoice.setLayout(new FlowLayout());
        centerChoice.setBounds(32, 10, 500, 70);
        //centerChoice.setPreferredSize(new Dimension(250, 40));
        panelCenter.add(centerChoice);

        //Making and adding text by a label to the subpanel
        JLabel textDropDownBox=new JLabel();
        textDropDownBox.setText("Select the vehicle for your journey");
        textDropDownBox.setForeground(new Color(0x800000));
        textDropDownBox.setFont(new Font("Arial", Font.BOLD, 17));
        centerChoice.add(textDropDownBox);

        //Making and adding dropdown to the subpanel
        String choice[]={"", "Auto-Rickshaw", "Kaali-Peeli Taxi"};
        dropDownBox=new JComboBox<>(choice);
        dropDownBox.setForeground(new Color(0xf77602)); //f77602
        dropDownBox.setPreferredSize(new Dimension(127, 20));
        dropDownBox.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
        dropDownBox.addActionListener(this);
        centerChoice.add(dropDownBox);

        //New subpanel for auto which will have the questions and answers typed by the user
        autoRickshaw=new JPanel();
        autoRickshaw.setLayout(new GridLayout(6, 1)); //Defines rows and columns
        autoRickshaw.setBounds(0, 100, 550, 300);
        autoRickshaw.setBackground(new Color(0xFBF2ED)); //FBF2ED

        //Adding a normal Label sat in JPanel
        //sat.setBounds(250, 250, 20, 20);
        //sat.setBackground(Color.BLUE);
        //panelCenter.add(sat);
        
        /* A question blueprint
        //Q1 
        JLabel Q1=new JLabel(); //Making a Label to the subpanel for auto rickshaw

        JLabel Q1text=new JLabel(); //A Label text to tell the user what to enter
        Q1text.setText("Enter distance travelled in km:");
        Q1text.setFont(new Font("Times New Roman", Font.BOLD, 17));
        Q1.setLayout(new FlowLayout());

        distance=new JTextField(); //A Textfield to input the answer from the user
        distance.setPreferredSize(new Dimension(150, 30));
        distance.setText("EG:12.4");
        distance.setFont(new Font("Arial", Font.PLAIN, 16));
        distance.setBackground(Color.WHITE);
        distance.setForeground(Color.BLUE);
        Q1.add(Q1text);
        Q1.add(distance);
        */

        questions(Q1, Q1text, distance); //Q1
        questions(Q2, Q2text, waitingTime); //Q2
        questions(Q3, Q3text, night); //Q3
        questions(Q4, Q4text, bags); //Q4
        questions(Q5, Q5text, ac); //Q5 for only taxi

        placeholder(distance, "EG:12.4");
        placeholder(waitingTime, "EG:4.5");
        placeholder(night, "EG:yes/no/y/n");
        placeholder(bags, "EG:0/1/2");
        placeholder(ac, "EG:yes/no/y/n");

        // distance.setInputVerifier(verifier);
        // waitingTime.setInputVerifier(verifier);
        // bags.setInputVerifier(verifier);

        // distance.getDocument().addDocumentListener(docListener);
        // waitingTime.getDocument().addDocumentListener(docListener);
        // bags.getDocument().addDocumentListener(docListener);
        
        //Creating the submit button and adding an Action Listener to it
        submit=new JButton("SUBMIT");
        submit.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        submit.setForeground(new Color(0x800000));
        submit.setBounds(10, 360, 95, 32);
        submit.setFocusable(false);
        submit.addActionListener(this);
        submit.setVisible(false);
        //submit.setEnabled(false);
        panelCenter.add(submit);
    
        //Adding all components in Center Panel and the Subpanel for auto
        panelCenter.add(autoRickshaw);
        autoRickshaw.add(Q1);
        autoRickshaw.add(Q2);
        autoRickshaw.add(Q3);
        autoRickshaw.add(Q4);
        autoRickshaw.add(Q5);

        //Adding the answer panel to be displayed after calculation to Center Panel
        answerPanel=new JPanel();
        answerPanel.setLayout(new FlowLayout());
        answerPanel.setBounds(150, 480, 300, 32);
        answerPanel.setFont(new Font("Arial", Font.BOLD, 16));
        answerPanel.setBackground(new Color(0xBA8E7A)); //FF02B3 //022870 //BA8E7A

        JLabel answerText=new JLabel("Estimated Fare:"); //Label text to be displayed
        answerText.setFont(new Font("Arial", Font.BOLD, 16));
        answerText.setForeground(Color.WHITE);

        answer=new JLabel(); //Answer label
        answer.setFont(new Font("Arial", Font.BOLD, 16));
        answer.setForeground(Color.WHITE);
        answer.setVisible(false); //Keeping it hidden before the calculations

        answerPanel.add(answerText); 
        answerPanel.add(answer);
        panelCenter.add(answerPanel);
        
        //Adding the main panels
        this.add(panelUp, BorderLayout.NORTH);
        this.add(panelLeft, BorderLayout.WEST);
        this.add(panelCenter, BorderLayout.CENTER);
        
        autoRickshaw.setVisible(false); //Setting it invisible before user's choice
        this.setVisible(true); //Frame visibility 
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //User entering choice for vehicle
        ch=dropDownBox.getSelectedIndex();
        if(e.getSource()==dropDownBox)
        {
            if(ch==1) //Auto Rickshaw
            {
                setInitials(distance, waitingTime, night, bags, ac);
                autoRickshaw.setVisible(true);
                Q5.setVisible(false);
                answer.setVisible(false);
                submit.setBounds(10, 360, 95, 32);
                submit.setVisible(true);
            }
            else if(ch==2) //Taxi
            {
                setInitials(distance, waitingTime, night, bags, ac);
                answer.setVisible(false);
                autoRickshaw.setVisible(true);
                Q5.setVisible(true);
                submit.setBounds(10, 385, 95, 32);
                submit.setVisible(true);
            }
            else //None
            {
                answer.setVisible(false);
                autoRickshaw.setVisible(false);
                submit.setVisible(false);
            }
        }

        //When user clicks on submit after answering all questions
        if(e.getSource()==submit) 
        {
            if(validateInputs())
            {   
                double dist=0.0d, time=0.0d;
                int luggage=0;  
                long ans1=0;  

                dist=Double.parseDouble(distance.getText());
                time=Double.parseDouble(waitingTime.getText());
                luggage=Integer.parseInt(bags.getText());
                String night=this.night.getText(); 

                if(ch==1)
                    ans1=fareRickshaw(dist, time, night, luggage);
                else
                {
                    String acCheck=ac.getText();
                    ans1=fareTaxi(dist, time, night, luggage, acCheck);
                }
                String ans=String.valueOf(ans1);
                answer.setText(ans);
                answer.setVisible(true);
            }
        }
        //throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

    public void placeholder(JTextField textField, String placeholderText)
    {
        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(textField.getText().equals(placeholderText))
                {
                    textField.setText("");
                    textField.setForeground(new Color(0xf77602)); //f77602
                }
            }
    
            @Override
            public void focusLost(FocusEvent e) {
                if(textField.getText().equals(""))
                {    
                    textField.setText(placeholderText);
                    textField.setForeground(Color.GRAY);
                }
            }
        });
    }

    public void questions(JLabel Q, JLabel Qtext, JTextField property)
    {
        //A Label to the subpanel for auto rickshaw
        Q.setLayout(new FlowLayout(FlowLayout.LEFT)); 

        //A Label text to tell the user what to enter
        Qtext.setForeground(new Color(0x800000));
        Qtext.setFont(new Font("Times New Roman", Font.BOLD, 19));

        //A Textfield to input the answer from the user
        property.setPreferredSize(new Dimension(150, 30));
        property.setFont(new Font("Arial", Font.PLAIN, 17));
        property.setBackground(Color.WHITE);
        property.setForeground(Color.GRAY);
        //property.addFocusListener(this);

        Q.add(Qtext);
        Q.add(property);
    }

    public void setInitials(JTextField a, JTextField b, JTextField c, JTextField d, JTextField e)
    {
        a.setText("EG:12.4");
        b.setText("EG:4.5");
        c.setText("EG:yes/no/y/n");
        d.setText("EG:0/1/2");
        e.setText("EG:yes/no/y/n");

        a.setForeground(Color.GRAY);
        b.setForeground(Color.GRAY);
        c.setForeground(Color.GRAY);
        d.setForeground(Color.GRAY);
        e.setForeground(Color.GRAY);
    }

    // Validate input values
    public boolean validateInputs() {
        boolean valid = true;

        if (!isDouble(distance.getText())) {
            showError("Invalid Input for distance");
            valid = false;
        }

        if (!isDouble(waitingTime.getText())) {
            showError("Invalid Input for time");
            valid = false;
        }

        if (!isYesOrNo(night.getText())) {
            showError("Invalid Input for night time.");
            valid = false;
        }

        if (!isInt(bags.getText())) {
            showError("Invalid Input for luggage");
            valid = false;
        }

        if(ch==2)
        {   
            if (!isYesOrNo(ac.getText())) {
                showError("Invalid Input for AC");
                valid = false;
            }
        }

        return valid;
    }

    // Check if a string is a valid double
    public boolean isDouble(String input) 
    {
        try 
        {
            Double.parseDouble(input);
            return true;
        } 
        catch (Exception e) 
        {
            return false;
        }
    }

    // Check if a string is a valid int
    public boolean isInt(String input) 
    {
        try 
        {
            Integer.parseInt(input);
            return true;
        } 
        catch (Exception e) 
        {
            return false;
        }
    }

    // Check if a string is 'yes' or 'no' (case-insensitive)
    public boolean isYesOrNo(String input) 
    {
        return input.equalsIgnoreCase("no") || input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("y") || input.equalsIgnoreCase("n");
    }

    // Show an error message dialog
    public void showError(String message) 
    {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    // public void updateSubmitButton() 
    // {
    //     if(distance.getInputVerifier().verify(distance) && 
    //        waitingTime.getInputVerifier().verify(waitingTime) && 
    //        bags.getInputVerifier().verify(bags))
    //     {
    //         submit.setEnabled(true);
    //     } 
    //     else 
    //     {
    //         submit.setEnabled(false);
    //     }
    // }

    public long fareRickshaw(double dist, double time, String night, int luggage)
    {
        double ans=0;

        //Fare calculation
        if(dist<=1.4)
            ans = 23;
        else
            ans = 23 + (dist-1.4)*15.33;

        //Adding waiting time fare
        if(dist + time*0.1 <= 1.4)
            ans = 23;
        else if(dist<=1.4 && dist + time*0.1>1.4)
            ans+=(time-(1.4-dist)*10)*1.42; //only the time after which total is >1.4 is considered
        else
            ans+=time*1.42;

        //Adding night charges if applicable
        if(night.equalsIgnoreCase("yes") || night.equalsIgnoreCase("y") ==true)
        {    
            ans+=ans/4; //Night charges applied: 25% of the fare
        }

        ans+=luggage*6; //Luggage charges: Rs.6 per bag

        return Math.round(ans); //Return final answer
    }

    public long fareTaxi(double dist, double time, String night, int luggage, String acCheck)
    {
       double ans=0;

        //Fare calculation
        if(dist<=1.4)
            ans = 28;
        else
            ans = 28 + (dist-1.4)*18.66;

        //Adding the waiting time fare
        if(dist + time*0.1 <= 1.4)
            ans = 28;
        else if(dist<=1.4 && dist + time*0.1>1.4)
            ans+=(time-(1.4-dist)*10)*1.7; //only the time after which total is >1.4 is considered
        else
            ans+=time*1.7;

        //Adding night charges if applicable
        if(night.equalsIgnoreCase("yes") || night.equalsIgnoreCase("y")==true)
        {
            ans+=ans/4; //Night charges applied: 25% of the fare
        }

        //Adding AC charges if applicable
        if(acCheck.equalsIgnoreCase("yes") || acCheck.equalsIgnoreCase("y")==true)
        {    
            ans+=ans/10; //AC charges applied: 10% of the fare
        }

        ans+=luggage*6; //Luggage charges: Rs.6 per bag

        return Math.round(ans); //Return final answer
    }
}