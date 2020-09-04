import com.email.durgesh.Email;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.awt.*;
import  java.awt.event.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;
import javax.swing.JOptionPane;
public class SignUp extends Frame implements ActionListener {
    Label l1, l2, l3, l4, l5,l6;
    TextField t1, t2, t4, t5;
    Button b1, b2;


        SignUp() {

            addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    dispose();
                }
            });
            l1 = new Label("ABC Bank Limited");
            l2 = new Label("Name:");
            l3 = new Label("Id no.");
            l4 = new Label("Password:");
            l5 = new Label("Welcome to ABC bank");
            l6 = new Label("Email id:");

            t1 = new TextField();
            t2 = new TextField();

            t4 = new TextField();
            t5 = new TextField();
            b1 = new Button("Back");
            b2 = new Button("Get key");
            t1.setBounds(140, 130, 300, 20);
            t2.setBounds(140, 170, 300, 20);
            t4.setBounds(140, 210, 300, 20);
            t5.setBounds(140, 250, 300, 20);
            l1.setBounds(380, 50, 200, 20);
            l5.setBounds(380, 650, 200, 20);
            
            l2.setBounds(69, 130, 70, 20);
            l3.setBounds(69, 170, 70, 20);
            l4.setBounds(69, 210, 70, 20);
            l6.setBounds(69, 250, 70, 20);


            b2.setBounds(350, 290, 80, 40);
            b1.setBounds(700,650,70,20);
            Font myFont = new Font("Serif", Font.BOLD, 20);
            Font m = new Font("Serif", Font.BOLD, 20);
            Font b = new Font("Serif", Font.BOLD, 16);
            Font c = new Font("Serif", Font.BOLD, 16);
            Font d = new Font("Serif", Font.BOLD, 16);
            Font cre = new Font("Serif", Font.BOLD, 16);
             Font crey = new Font("Serif", Font.BOLD, 16);
            l1.setFont(myFont);
            l5.setFont(m);
            l2.setFont(b);
            l3.setFont(c);
            l4.setFont(d);
            l6.setFont(crey);

            setSize(900, 700);
            setLayout(null);
            setVisible(true);
            setBackground(Color.lightGray);
            b1.addActionListener(this);
            b2.addActionListener(this);
            add(l1);
            add(l2);
            add(l3);
            add(l4);
            add(l5);
            add(l6);
            add(t1);
            add(t2);
            add(t4);
            add(t5);
            add(b2);
            add(b1);

        }


        @Override
        public void actionPerformed (ActionEvent e){
            String s1 = t1.getText();
            String s2 = t2.getText();
            String s3 = t4.getText();
            String s6 = t5.getText();
           if(e.getSource() == b1){
               new LongIn();
               dispose();

           }
           
           else if(e.getSource() == b2){
         
            int result = Integer.parseInt(s2);
            Random random = new Random();
               int ran_1 =random.nextInt(1010102030);
             String s=String.valueOf(ran_1); 
            int k = ran_1;
            int key = result +k;
            
            
                   
    try{  
        Class.forName("com.mysql.jdbc.Driver");  
        Connection con=(Connection) DriverManager.getConnection( "jdbc:mysql://localhost:3306/applogin","root","");  
        String sql ="insert into logindatabase(username,password,keyu,id)values(?,?,?,?)";
        PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
        pst.setString(1, s1);
        pst.setString(4, s2);
        pst.setInt(3, key);
        pst.setString(2, s3);
        pst.executeUpdate();
        JOptionPane.showMessageDialog(null, "Wait for email");
          try{
            Email email = new Email("s8856010@gmail.com","******");
            email.setFrom("s8856010@gmail.com", "ABC BANK" );
            email.setSubject("Your key");
            //email.setContent("<h>your key is </h> ","text/html");
            email.setContent( s,"text/html");
            email.addRecipient(s6);
            email.send();
            JOptionPane.showMessageDialog(null, "cheak your email");

        new LongIn();
        dispose();
            
            
        }
        catch(Exception g){
            System.out.println(g);
            
        }
       
        }

      catch(Exception egg)
      { 
          System.out.println(egg);
      }
  
               
               
           }

        }


        public static void main (String args []){
            new SignUp();
        }
    }