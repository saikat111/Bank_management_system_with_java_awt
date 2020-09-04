import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.awt.*;
import java.awt.event.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class UserDe extends Frame implements ActionListener {
Button b2,b1,b3;
Label l1,l2,l11,l3,l4,l5,l6,l7;
 TextField t1,t2,t3,t4,t5,t6,t7;

    UserDe() {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
         l1 = new Label("Account No. ");
          l2 = new Label("Name ");
           l11 = new Label("NID ");
            l4 = new Label("Address");
             l5 = new Label("Email ");
              l6 = new Label("Account No. ");
               l7 = new Label("Card No. ");
             
                
                
                
         t1 = new TextField();
          t2 = new TextField();
           t3 = new TextField();
            t4 = new TextField();
             t5 = new TextField();
              t6 = new TextField();
               t7 = new TextField();
             
          
          
         
         l1.setBounds(80,170,90,40);
          l2.setBounds(450,210,80,40);
           l11.setBounds(450,250,80,40);
            l4.setBounds(450,290,80,40);
             l5.setBounds(450,330,80,40);
              l6.setBounds(450,370,80,40);
               l7.setBounds(450,410,80,40);
               
                
                t1.setBounds(167,490,200,20);
                t2.setBounds(600,210,250,30);
                t3.setBounds(600,250,250,30);
                t4.setBounds(600,290,250,30);
                t5.setBounds(600,330,250,30);
                t6.setBounds(600,370,250,30);
                t7.setBounds(600,410,250,30);
              
                
         
        b2 = new Button("Back");
          b1 = new Button("Cheak");
          b3 = new Button("Details");
        
          t1.setBounds(167,170,200,20);

        b2.setBounds(700,650,70,20);
        b1.setBounds(300,220,80,30);
        b3.setBounds(300,270,80,30);
        
        
        
        
        Font mg = new Font("Serif", Font.BOLD, 20);
        Font bg = new Font("Serif", Font.BOLD, 16);
        l1.setFont(bg);
        
        
        setSize(900,700);
        setLayout(null);
        setVisible(true);
        setBackground(Color.lightGray);
        add(b2);
        b2.addActionListener(this);
         b1.addActionListener(this);
           b3.addActionListener(this);
        add(l1);add(t1);add(b1);
        
        add(l2);add(l11);add(l4);add(l5);add(l6);add(l7);
        add(t2);
                add(t3);
                        add(t4);
                                add(t5);
                                        add(t6);
                                                add(t7);
                                                add(b3);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s1 = t1.getText();
        if(e.getSource() == b2){
          new FirstInterFace();
            dispose();
        }
        else if(e.getSource() == b1){
                        try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=(Connection) DriverManager.getConnection( "jdbc:mysql://localhost:3306/account","root","");  
String sql ="Select * from accountinfo where accountno=?";
PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
pst.setString(1, s1);


ResultSet rs = pst.executeQuery();


if(rs.next()){
    JOptionPane.showMessageDialog(null, "Account found");
    }
else{
 
     JOptionPane.showMessageDialog(null, "Wrong account number or try againg");
    }
}
      catch(Exception egg)
      { 
          System.out.println(egg);
      }
   
        
    }
        else if(e.getSource() == b3){
             try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=(Connection) DriverManager.getConnection( "jdbc:mysql://localhost:3306/account","root","");  
String sql ="Select * from accountinfo where accountno=?";
PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
pst.setString(1, s1);


ResultSet rs = pst.executeQuery();


if(rs.next()){
   
     String firstName = rs.getString("name");
     String nid = rs.getString("nid");
     String address = rs.getString("address");
     String email = rs.getString("email");
     String accountno = rs.getString("accountno");
     String cardno = rs.getString("cardno");
   
     JOptionPane.showMessageDialog(null, "Working pleace wait");
     t2.setText(firstName);
      t3.setText(nid);
       t4.setText(address);
        t5.setText(email);
         t6.setText(accountno);
          t7.setText(cardno);
          

     
    }
else{
 
     JOptionPane.showMessageDialog(null, "Wrong account number or try againg");
    }
}
      catch(Exception egg)
      { 
          System.out.println(egg);
      }
    
       
       
            
            
        }
          
        
        

    }
    public  static void main(String args[]){
        new UserDe();
    }
}