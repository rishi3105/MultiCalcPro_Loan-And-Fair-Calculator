//Fonts: Comic Sans MS, Curlz MT, Brush Script MT

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class EMICalculator extends JFrame implements ActionListener
{
    String loanQ1="Principal amount:";
    String productQ1="Cost of product:";
    String loanQ2="Rate of Interest(%):";
    String productQ2="Standard Interest(%):";

    JPanel panelUp;
    JPanel panelLeft;
    JPanel panelCenter;

    JPanel centerChoice;
    JComboBox dropDownBox;

    JPanel emiQuestions;    
    
    JLabel Q1=new JLabel(); //Making a Label to the subpanel for auto rickshaw
    JLabel Q1text=new JLabel(); //A Label text to tell the user what to enter
    JTextField amount=new JTextField("EG:7000"); //A Textfield to input the answer from the user

    JLabel Q2=new JLabel();
    JLabel Q2text=new JLabel();
    JTextField rate=new JTextField("EG:6.5");

    JLabel Q3=new JLabel();
    JLabel Q3text=new JLabel("Duration(years):");
    JTextField years=new JTextField("EG:4");

    JButton submit;

    JPanel answerPanel1;
    JPanel answerPanel2;
    JLabel answerText1;
    JLabel answerText2;
    JLabel answer1;
    JLabel answer2;

    //Label sat=new Label("Just a Label from awt");
    public EMICalculator()
    {
        this.setTitle("MultiCalcPro | EMI Calculator"); //Title of window
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
        this.getContentPane().setBackground(new Color(0xB8B68F)); //B8B68F

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
        panelUp.setBackground(new Color(0x89A666)); //89A666 //B8B68F
        panelLeft.setBackground(new Color(0xFFFFFF));
        panelCenter.setBackground(new Color(0xEBE6D2)); //EBE6D2

        JLabel topic=new JLabel();
        topic.setText("Welcome to EMI Calculator!");
        topic.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));
        topic.setForeground(new Color(0xEBE6D2)); //EBE6D2 //0x000080 //7002d6
        panelUp.add(topic);

        //Setting layout of Center Panel to null
        //Now every component added to it must have setBounds to set where to be in the panel
        panelCenter.setLayout(null);

        //Subpanel that will contain choice of vehicle
        centerChoice=new JPanel();
        centerChoice.setBackground(new Color(0xEBE6D2)); //EBE6D2
        centerChoice.setLayout(new FlowLayout());
        centerChoice.setBounds(50, 10, 500, 70);
        //centerChoice.setPreferredSize(new Dimension(250, 40));
        panelCenter.add(centerChoice);

        //Making and adding text by a label to the subpanel
        JLabel textDropDownBox=new JLabel();
        textDropDownBox.setText("Select the type of EMI");
        textDropDownBox.setForeground(new Color(0x60714E)); //60714E
        textDropDownBox.setFont(new Font("Arial", Font.BOLD, 17));
        centerChoice.add(textDropDownBox);

        //Making and adding dropdown to the subpanel
        String choice[]={"", "Loan", "Product"};
        dropDownBox=new JComboBox<>(choice);
        dropDownBox.setPreferredSize(new Dimension(100, 20));
        dropDownBox.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        dropDownBox.addActionListener(this);
        centerChoice.add(dropDownBox);

        //New subpanel for auto which will have the questions and answers typed by the user
        emiQuestions=new JPanel();
        emiQuestions.setLayout(new GridLayout(3, 1)); //Defines rows and columns
        emiQuestions.setBounds(0, 100, 550, 210);
        emiQuestions.setBackground(new Color(0xEBE6D2)); //EBE6D2

        questions(Q1, Q1text, amount); //Q1
        questions(Q2, Q2text, rate); //Q2
        questions(Q3, Q3text, years); //Q3

        placeholder(amount, "EG:7000");
        placeholder(rate, "EG:6.5");
        placeholder(years, "EG:4");
        
        //Creating the submit button and adding an Action Listener to it
        submit=new JButton("SUBMIT");
        //submit.setBackground(new Color(0x89A666)); //89A666
        submit.setForeground(new Color(0x60714E)); //60714E //89A666
        submit.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        submit.setBounds(10, 360, 95, 32);
        submit.setFocusable(false);
        submit.addActionListener(this);
        submit.setVisible(false);
        panelCenter.add(submit);
    
        //Adding all components in Center Panel and the Subpanel for EMI
        panelCenter.add(emiQuestions);
        emiQuestions.add(Q1);
        emiQuestions.add(Q2);
        emiQuestions.add(Q3);

        //Adding the answer panel to be displayed after calculation to Center Panel
        answerPanel1=new JPanel();
        answerPanel1.setLayout(new FlowLayout());
        answerPanel1.setBounds(150, 480, 300, 32);
        answerPanel1.setFont(new Font("Arial", Font.BOLD, 16));
        answerPanel1.setBackground(new Color(0x89A666)); //89A666 //FF02B3 //022870
        answerPanel1.setVisible(false);

        answerText1=new JLabel(); //Label text to be displayed
        answerText1.setFont(new Font("Arial", Font.BOLD, 16));
        answerText1.setForeground(new Color(0xEBE6D2));

        answer1=new JLabel(); //Answer label
        answer1.setFont(new Font("Arial", Font.BOLD, 16));
        answer1.setForeground(new Color(0xEBE6D2));
        answer1.setVisible(false); //Keeping it hidden before the calculations

        answerPanel1.add(answerText1); 
        answerPanel1.add(answer1);
        panelCenter.add(answerPanel1);

        answerPanel2=new JPanel();
        answerPanel2.setLayout(new FlowLayout());
        answerPanel2.setBounds(195, 512, 215, 32);
        answerPanel2.setFont(new Font("Arial", Font.BOLD, 16));
        answerPanel2.setBackground(new Color(0x89A666)); //89A666 //FF02B3 //022870
        answerPanel2.setVisible(false);

        answerText2=new JLabel(); //Label text to be displayed
        answerText2.setFont(new Font("Arial", Font.BOLD, 16));
        answerText2.setForeground(new Color(0xEBE6D2));

        answer2=new JLabel(); //Answer label
        answer2.setFont(new Font("Arial", Font.BOLD, 16));
        answer2.setForeground(new Color(0xEBE6D2)); //EBE6D2
        answer2.setVisible(false); //Keeping it hidden before the calculations

        answerPanel2.add(answerText2); 
        answerPanel2.add(answer2);
        panelCenter.add(answerPanel2);
        
        //Adding the main panels
        this.add(panelUp, BorderLayout.NORTH);
        this.add(panelLeft, BorderLayout.WEST);
        this.add(panelCenter, BorderLayout.CENTER);
        
        emiQuestions.setVisible(false); //Setting it invisible before user's choice
        this.setVisible(true); //Frame visibility 
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //User entering choice for vehicle
        int ch=dropDownBox.getSelectedIndex();
        if(e.getSource()==dropDownBox)
        {
            if(ch==1) //Loan EMI
            {
                setInitials(amount, rate, years);
                emiQuestions.setVisible(true);
                Q1text.setText(loanQ1);
                Q2text.setText(loanQ2);
                rate.setEditable(true);
                answerText1.setText("Simple Interest on amount for the tenure:"); //Total
                answerText2.setText("The monthly EMI is:");
                answerPanel1.setBounds(120, 480, 410, 32);
                answerPanel2.setBounds(200, 512, 250, 32);
                answerPanel1.setVisible(true);
                answerPanel2.setVisible(true);
                answer1.setText("");
                answer2.setText("");
                submit.setVisible(true);
            }

            else if(ch==2) //Product EMI
            {
                setInitials(amount, rate, years);
                answerText1.setText("Yearly Interest on cost:");
                answerText2.setText("The monthly EMI is:");
                emiQuestions.setVisible(true);
                answerPanel1.setBounds(180, 480, 290, 32);
                answerPanel2.setBounds(200, 512, 250, 32);
                Q1text.setText(productQ1);
                Q2text.setText(productQ2);
                answerPanel1.setVisible(true);
                answerPanel2.setVisible(true);
                rate.setText("2");
                rate.setForeground(new Color(0x000000)); //DD0000
                rate.setEditable(false);
                answer1.setText("");
                answer2.setText("");
                submit.setVisible(true);
            }
            
            else //None
            {
                answerPanel1.setVisible(false);
                answerPanel2.setVisible(false);
                emiQuestions.setVisible(false);
                submit.setVisible(false);
            }
        }

        //When user clicks on submit after answering all questions
        if(e.getSource()==submit) 
        {
            if(validateInputs())
            {
                double amount=0.0d, roi=0.0d, time=0.0d;  
                long ans1=0, ans2=0;  

                amount=Double.parseDouble(this.amount.getText());
                roi=Double.parseDouble(rate.getText());
                time=Double.parseDouble(years.getText());

                if(ch==1)
                {
                    double SI = (amount*roi*time)/100;
                    ans1=Math.round(SI);
                    ans2=Math.round(loanCalc(amount, roi/12/100, time*12));
                    //ans1=ans2*Math.round(time)*12 - Math.round(amount);
                }    
                else
                {
                    double interest = amount*roi*time*12/100;
                    ans1=Math.round(interest);
                    ans2=Math.round(productCalc(amount, roi/100, time));
                }
            
                answer1.setText(String.valueOf(ans1));
                answer1.setVisible(true);
                answer2.setText(String.valueOf(ans2));
                answer2.setVisible(true);
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
                    textField.setForeground(new Color(0x000000)); //DD0000 //Orange:ff7d08
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
        Qtext.setForeground(new Color(0x60714E)); //60714E
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

    public void setInitials(JTextField a, JTextField b, JTextField c)
    {
        a.setText("EG:7000");
        b.setText("EG:6.5");
        c.setText("EG:4");

        a.setForeground(Color.GRAY);
        b.setForeground(Color.GRAY);
        c.setForeground(Color.GRAY);
    }

    public boolean validateInputs() {
        boolean valid = true;

        if (!isDouble(amount.getText())) {
            showError("Invalid Input for amount");
            valid = false;
        }

        if (!isDouble(rate.getText())) {
            showError("Invalid Input for rate of interest");
            valid = false;
        }

        if (!isDouble(years.getText())) {
            showError("Invalid Input for time");
            valid = false;
        }

        return valid;
    }

    // Check if a string is a valid double
    public boolean isDouble(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Show an error message dialog
    public void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static double loanCalc(double a, double r, double n)
	{
        double emi = (a * r * Math.pow(1+r, n) / (Math.pow(1+r, n) - 1));
        return emi;
    }

    public static double productCalc(double c, double i, double t2)
    {
        double pe = ((c/12)+(i*c));
		return pe;
    }
}