import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener
{
    JButton farePage=new JButton();
    JButton emiPage=new JButton();

    public MyFrame()
    {
        this.setTitle("MultiCalcPro"); //Title of window
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Exits program on cancelling
        this.setSize(1555, 860); //size of the screen 
        this.setLayout(new BorderLayout(10, 10)); //width and height with Layout
        //this.setResizable(false); //size cannot be manually changed during runtime

        Dimension objDimension = Toolkit.getDefaultToolkit().getScreenSize();

        int X = (objDimension.width - this.getWidth()) / 2;
        int Y = (objDimension.height - this.getHeight()) / 2;
        this.setLocation(X, Y);
        
        ImageIcon img=new ImageIcon("Logo.png");
        this.setIconImage(img.getImage());
        
        this.getContentPane().setBackground(new Color(0xFF206E));

        JPanel panelUp=new JPanel();
        JPanel panelLeft=new JPanel();
        // JPanel panelRight=new JPanel();
        // JPanel panelDown=new JPanel();
        JPanel panelCenter=new JPanel();
    
        panelUp.setPreferredSize(new Dimension(100, 100));
        panelLeft.setPreferredSize(new Dimension(100, 100));
        panelCenter.setPreferredSize(new Dimension(100, 100));

        panelUp.setBackground(new Color(0xBB86FC));
        panelLeft.setBackground(new Color(0xFFFFFF));
        panelCenter.setBackground(new Color(0x121212));

        JLabel topic=new JLabel();
        topic.setText("MultiCalcPro");
        topic.setFont(new Font("Times New Roman", Font.PLAIN, 65));
        topic.setForeground(new Color(0x000000)); //EBE6D2 //0x000080 //7002d6
        panelUp.add(topic);

        this.add(panelUp, BorderLayout.NORTH);
        this.add(panelLeft, BorderLayout.WEST);
        this.add(panelCenter, BorderLayout.CENTER);

        panelCenter.setLayout(null);

        JLabel choice=new JLabel("Which calculator do you want to access?");
        choice.setFont(new Font("Times New Roman", Font.PLAIN, 44));
        choice.setForeground(new Color(0xBB86FC));
        choice.setBounds(344, 100, 800, 200);
        panelCenter.add(choice);

        //Fare Calculator button
        farePage.setText("Fare Calculator");
        farePage.setFont(new Font("Mouse Memoirs", Font.BOLD, 20));
        farePage.setFocusable(false);
        farePage.setForeground(new Color(0xF2CEE6));
        farePage.setBackground(new Color(0x3D3A3A));
        farePage.setBorder(null);
        farePage.setBounds(300, 310, 200, 64);
        farePage.addActionListener(this);
        panelCenter.add(farePage);
        
        emiPage.setText("EMI Calculator");
        emiPage.setFont(new Font("Mouse Memoirs", Font.BOLD, 20));
        emiPage.setFocusable(false);
        emiPage.setForeground(new Color(0xF2CEE6));
        emiPage.setBackground(new Color(0x3D3A3A));
        emiPage.setBorder(null);
        emiPage.setBounds(900, 310, 200, 64);
        emiPage.addActionListener(this);
        panelCenter.add(emiPage);

        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==farePage)
        {
            new FareCalculatorGUI(); 
        }
        if(e.getSource()==emiPage)
        {
            new EMICalculator();
        }
        //throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
