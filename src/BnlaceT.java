import com.email.durgesh.Email;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.awt.*;
import java.awt.event.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class BnlaceT extends Frame implements ActionListener {

        Button b2,b1;
        Label l2,l3,l4;
        TextField t1,t2,t3;
        String a,b,ptk,ttk,c,p,q,rr,email1,email2;
        int from,to,nf,nff,r,x,y,z;
        
    BnlaceT() {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        b2 = new Button("Back");
            b1 = new Button("Sent");
            
            
               l2 = new Label("From");
               l3 = new Label("To");
                l4 = new Label("Ammount");
               l2.setBounds(90,130,80,20);
               l3.setBounds(90,170,80,20);
               l4.setBounds(90,210,80,20);
               
               
               
               
                 t1 = new TextField();
        t2 = new TextField();
          t3 = new TextField();

        
        
          t1.setBounds(185,130,200,20);
        t2.setBounds(185,170,200,20);
          t3.setBounds(185,210,200,20);
        
           b1.setBounds(300,300,90,40);
        
        
        b2.setBounds(700,650,70,20);
        setSize(900,700);
        setLayout(null);
        setVisible(true);
        setBackground(Color.lightGray);
        add(b2);
        add(l2);add(l3);
        add(t1);add(t2);
        add(b1);add(t3);
        add(l4);
        b2.addActionListener(this);
          b1.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       try{ 
         a = t1.getText();
         b = t2.getText();
         c= t3.getText();
         from = Integer.parseInt(c);
       }
       catch(Exception ess){
            JOptionPane.showMessageDialog(null, "Try again");
       }
         
        //  to = Integer.parseInt(b);
        
        if(e.getSource() == b2){
            new FirstInterFace();
            dispose();
        }
        else if(e.getSource()== b1){
            
             try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=(Connection) DriverManager.getConnection( "jdbc:mysql://localhost:3306/account","root","");  
String sql ="Select * from accountinfo where accountno=?";
PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
pst.setString(1, a);


ResultSet rs = pst.executeQuery();


if(rs.next()){
      ptk = rs.getString("any");
      email1 = rs.getString("email");
      nf = Integer.parseInt(ptk);//database tk to int
      x = nf - from;
      if(x<100){
          
            JOptionPane.showMessageDialog(null, "Not enought balance");
         System.exit(0);
           
          
      }
       
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
String sql ="Select * from accountinfo where accountno=?";
PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
pst.setString(1, b);


ResultSet rs = pst.executeQuery();


if(rs.next()){
      ttk = rs.getString("any");
       email2 = rs.getString("email");
      nff = Integer.parseInt(ttk);//database tk to int
     y = from + nff;//nao balance
     
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
pst.setInt(1, x);
pst.setString(2, b);
pst.executeUpdate();
con.close();

}
             
             
      catch(Exception egg)
      { 
          System.out.println(egg);
      }
  try{
            Email email = new Email("s8856010@gmail.com","*******");
            email.setFrom("s8856010@gmail.com", "ABC BANK" );
            email.setSubject("money received");
            //email.setContent("<h>your key is </h> ","text/html");
            email.setContent( c,"text/html");
            email.addRecipient(email2);
            email.send();
            JOptionPane.showMessageDialog(null, "cheak your email");
   
        }
        catch(Exception g){
            System.out.println(g);
        }
 
             
 try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=(Connection) DriverManager.getConnection( "jdbc:mysql://localhost:3306/account","root","");  
String sql ="update accountinfo  set any = ? where accountno = ?";
PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
pst.setInt(1, y);
pst.setString(2, a);
pst.executeUpdate();
con.close();



}
             
             
      catch(Exception egg)
      { 
          System.out.println(egg);
      }
 try{
            Email email = new Email("s8856010@gmail.com","01737256480");
            email.setFrom("s8856010@gmail.com", "ABC BANK" );
            email.setSubject("money sent");
            //email.setContent("<h>your key is </h> ","text/html");
            email.setContent( c,"text/html");
            email.addRecipient(email1);
            email.send();
            JOptionPane.showMessageDialog(null, "cheak your email");
   
        }
        catch(Exception g){
            System.out.println(g);
        }
             
             
    
            
        }

    }
    public  static void main(String args[]){
        new BnlaceT();
    }
}
