/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sordar Saikat
 */

import com.email.durgesh.Email;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.awt.*;
import java.awt.event.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
public class Money  extends Frame implements ActionListener {
       Label l2,l3,l4;
        TextField t1,t2;
        Button b2,b1;
        
        String s1,s2,s3,email1,ptk;
        int x,y,z,nf;
    
    
    
      Money () {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        
       
                b2 = new Button("Back");
            b1 = new Button("Sent");
            
            
               l2 = new Label("Account no");     
               l2.setBounds(150,130,200,20);
                 l3 = new Label("Amounts");     
               l3.setBounds(150,230,200,20);
             
               
               
               
         t1 = new TextField();
         t1.setBounds(150,180,200,20);
          t2 = new TextField();
         t2.setBounds(150,280,200,20);
         b1.setBounds(250,330,70,35);
          b2.setBounds(700,650,70,35);

        add(b1); add(b2); add(t1); add(l2);add(l3);add(t2);
         Font mg = new Font("Serif", Font.BOLD, 20);
           Font mfdg = new Font("Serif", Font.BOLD, 20);
       
        l2.setFont(mg);
        l3.setFont(mfdg);
        
            setSize(900, 700);
            setLayout(null);
            setVisible(true);
             setBackground(Color.lightGray);
             b1.addActionListener(this);
             b2.addActionListener(this);
        
    
    
    
      }
      
      public void actionPerformed(ActionEvent e){
          s1 = t1.getText();
           s2 = t2.getText();
           x = Integer.parseInt(s2);
          
          
          if (e.getSource()== b1){
                try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=(Connection) DriverManager.getConnection( "jdbc:mysql://localhost:3306/account","root","");  
String sql ="Select * from accountinfo where accountno=?";
PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
pst.setString(1, s1);


ResultSet rs = pst.executeQuery();


if(rs.next()){
      ptk = rs.getString("any");
      email1 = rs.getString("email");
      nf = Integer.parseInt(ptk);//database tk to int
      y = nf + x;

       
    }


else{
 
     JOptionPane.showMessageDialog(null, "Try againg");
    }
}
             
             
      catch(Exception egg)
      { 
          System.out.println(egg);
      }
                
                try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=(Connection) DriverManager.getConnection( "jdbc:mysql://localhost:3306/account","root","");  
String sql ="update accountinfo  set any = ? where accountno = ?";
PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
pst.setInt(1, y);
pst.setString(2, s1);
pst.executeUpdate();
con.close();
JOptionPane.showMessageDialog(null, "Please wait");

}
             
             
      catch(Exception egg)
      { 
          System.out.println(egg);
      }
  try{
            Email email = new Email("s8856010@gmail.com","******");
            email.setFrom("s8856010@gmail.com", "ABC BANK" );
            email.setSubject("money received");
            //email.setContent("<h>your key is </h> ","text/html");
            email.setContent( s2,"text/html");
            email.addRecipient(email1);
            email.send();
            JOptionPane.showMessageDialog(null, "cheak your email");
   
        }
        catch(Exception g){
            System.out.println(g);
        }
             
              
              
          }
             else if (e.getSource()== b2){
              
            new  FirstInterFace();
            dispose();
              
          }
          
          
          
      }
      
   
      
      public static void main(String args []){
          new Money();
          
          
      }
    
}
