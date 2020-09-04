import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.awt.*;
import  java.awt.event.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
public class LongIn extends Frame implements ActionListener {
    Label l1,l2,l3,l4,l5,l6;
    TextField t1,t2,t3,t4,t5;
    Button b1,b2;

    LongIn(){
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        l1 = new Label("ABC Bank Limited");
        l2 = new Label("Name:");
        l3 = new Label("Id no.");
        l4 = new Label("Password:");
        l5 = new Label("Welcome to ABC bank");
        l6 = new Label("your key:");
        t1 = new TextField();
        t2 = new TextField();
        t3 = new TextField();
        t4 = new TextField();
        t5 = new TextField();
        b1 = new Button("Signin");
        b2 = new Button("Signup");
        t1.setBounds(185,130,200,20);
        t2.setBounds(185,170,200,20);
        t3.setBounds(185,210,200,20);
        t4.setBounds(185,250,200,20);
        l1.setBounds(380,50,170,20);
        l5.setBounds(380,650,200,20);
        l2.setBounds(90,130,80,20);
        l3.setBounds(90,170,80,20);
        l4.setBounds(90,250,80,20);
        l6.setBounds(90,210,80,20);
        b1.setBounds(170,290,70,40);
        b2.setBounds(350,290,70,40);
        Font myFont = new Font("Serif",Font.BOLD,20);
        Font m = new Font("Serif",Font.BOLD,20);
        Font b = new Font("Serif",Font.BOLD,16);
        Font c = new Font("Serif",Font.BOLD,16);
        Font d = new Font("Serif",Font.BOLD,16);
        Font cre = new Font("Serif",Font.BOLD,16);
        l1.setFont(myFont);
        l5.setFont(m);
        l2.setFont(b);
        l3.setFont(c);
        l4.setFont(d);
        l6.setFont(cre);
        setSize(900,700);
        setLayout(null);
        setVisible(true);
        setBackground(Color.lightGray);
        add(l1);add(l2);add(l3);add(l4);add(l5);add(l6);add(t1);add(t2);add(t3);add(t4);add(b1);add(b2);
        b2.addActionListener(this);
        b1.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
            String s1 = t1.getText();
           // String s3 = t2.getText();
            String s2 = t4.getText();
            String s4 = t3.getText();
        if(e.getSource()== b2){
            new SignUp();
            dispose();

        }
        if(e.getSource()== b1){ 
            try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=(Connection) DriverManager.getConnection( "jdbc:mysql://localhost:3306/applogin","root","");  
String sql ="Select * from logindatabase where username=?  and keyu=?";
PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
pst.setString(1, s1);
//pst.setString(2, s2);
pst.setString(2, s4);
//pst.setString(2, s3);


ResultSet rs = pst.executeQuery();


if(rs.next()){
   
    JOptionPane.showMessageDialog(null, "username and pass match");
    new FirstInterFace();
    dispose();
    }
else{
 
     JOptionPane.showMessageDialog(null, "Wrong user name or password");
    }
}
      catch(Exception egg)
      { 
          System.out.println(egg);
      } 
        }
    }

    public  static void main(String args []){
        new LongIn();
    }
}


