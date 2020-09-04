import com.email.durgesh.Email;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.awt.*;
import java.awt.event.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Random;
import javax.swing.JOptionPane;

public class FirstInterFace extends Frame implements ActionListener {
    Button b1,b2,b3,b4,b5,b6;
    Label l1,l2,l3,l4,l5,l6,l7,l8,l9;
    TextField t1,t2,t3,t4,t5,t6,t7;
   
    FirstInterFace(){
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        l1 = new Label("Find Account");
        l3 = new Label("Create New Account ");

         b6 = new Button("Add money"); 
        
        
        
        l4 = new Label("Name:");
        l5 = new Label("NID No.");
        l6 = new Label("Address:");
        l7 = new Label("Email:");

        l8 = new Label("Balance cheak");


        l4.setBounds(432, 170, 70, 20);
        l5.setBounds(432, 210, 70, 20);
        l6.setBounds(432, 250, 70, 20);
        l7.setBounds(432, 290, 70, 20);
        l9= new Label("Account number");

        t3 = new TextField();
        t4 = new TextField();
        t5 = new TextField();
        t6 = new TextField();
        t7 = new TextField();

        t3.setBounds(500, 170, 200, 20);
        t4.setBounds(500, 210, 200, 20);
        t5.setBounds(500, 250, 200, 20);
        t6.setBounds(500, 290, 200, 20);


       // l1.setBounds(380,50,170,20);

        t1 = new TextField();
        //t2 = new TextField();
            t7.setBounds(120, 350, 200, 20);
      


        l1.setBounds(120, 130, 150, 20);
        
        l3.setBounds(600, 130, 200, 20);
          l8.setBounds(120, 300, 150, 20);
           l9.setBounds(120, 330, 150, 20);

        b1 = new Button("Find");
        b2 = new Button("Back");
        b3= new Button("Request");
        b4 = new Button("Cheak");
        b5 = new Button("Balance transfer");

        b1.setBounds(150,180,70,35);
        b2.setBounds(700,650,70,20);
        b3.setBounds(600, 400, 70, 35);
        b4.setBounds(150,400,70,35);
           b5.setBounds(150,500,100,50);
            b6.setBounds(250,500,100,50);
        
        add(b4);
        add(l8);
        add(t7);
        add(b5);
        add(l9);
        b4.addActionListener(this);
        b5.addActionListener(this);
        
    

        Font myFont = new Font("Serif", Font.BOLD, 20);
        Font m = new Font("Serif", Font.BOLD, 20);
        Font b = new Font("Serif", Font.BOLD, 16);
        Font c = new Font("Serif", Font.BOLD, 16);
        Font d = new Font("Serif", Font.BOLD, 16);
        Font crfe = new Font("Serif", Font.BOLD, 16);
        Font cf = new Font("Serif", Font.BOLD, 16);
        Font df = new Font("Serif", Font.BOLD, 16);
        Font cref = new Font("Serif", Font.BOLD, 16);
         Font mg = new Font("Serif", Font.BOLD, 20);
        Font bg = new Font("Serif", Font.BOLD, 16);
     
        l8.setFont(mg);

        l1.setFont(m);l3.setFont(myFont);
        l4.setFont(c);l5.setFont(d);l6.setFont(cf);l7.setFont(crfe);


        setSize(900,700);
        setLayout(null);
        setVisible(true);
        setBackground(Color.lightGray);

        b2.addActionListener(this);
        b1.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
         b6.addActionListener(this);
 


        add(l1);
        add(t1);add(b1);add(b2);
        add(l3);
        add(l4);add(l5);add(l6);add(l7);
        add(t3);add(t4);add(t5);add(t6);
        add(b3);add(b6);
   



    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String s1 = t3.getText();//name
        String s2 = t4.getText();//nid
        String s3 = t5.getText();//address
        String s4 = t6.getText();//email
        String s5 = t7.getText();
        
        if(e.getSource() == b2){
            new LongIn();
            dispose();
        }
        
       else if(e.getSource()==b1){
 
            new UserDe();
            dispose();
        }
          else if(e.getSource() == b3){
            int result = Integer.parseInt(s2);//nid
            Random random = new Random();
            int ran_1 =random.nextInt(1010102030);//random int
            String s=String.valueOf(ran_1); //int to string
            int k = ran_1;
            int key = result +k; 
            
             String acc=String.valueOf(key);
            
            int ran_2 = random.nextInt(84654165);
            int card =ran_1 + ran_2;
            String mom = "500";
            
            
                              
    try{  
        Class.forName("com.mysql.jdbc.Driver");  
        Connection con=(Connection) DriverManager.getConnection( "jdbc:mysql://localhost:3306/account","root","");  
        String sql ="insert into accountinfo(name,nid,address,email,accountno,cardno,any)values(?,?,?,?,?,?,?)";
        PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
        pst.setString(1, s1);
        pst.setString(2, s2);
        pst.setString(3, s3);
        pst.setString(4, s4);
        pst.setInt(5, key);
        pst.setInt(6, card);
        pst.setString(7, mom);
        pst.executeUpdate();
        JOptionPane.showMessageDialog(null, "Wait few seccounds");
          try{
            Email email = new Email("s8856010@gmail.com","01737256480");
            email.setFrom("s8856010@gmail.com", "ABC BANK" );
            email.setSubject("your account number");
            //email.setContent("<h>your key is </h> ","text/html");
            email.setContent( acc,"text/html");
            email.addRecipient(s4);
            email.send();
            JOptionPane.showMessageDialog(null, "cheak your email");
   
        }
        catch(Exception g){
            System.out.println(g);
            
        }
       
        }

      catch(Exception egg)
      { 
          JOptionPane.showMessageDialog(null, "Try again");
          System.out.println(egg);
      }
   
            
                 
              

        }
        
          else if(e.getSource() == b4){
                 try{  
        Class.forName("com.mysql.jdbc.Driver");  
        Connection con=(Connection) DriverManager.getConnection( "jdbc:mysql://localhost:3306/account","root","");  
        String sql ="Select * from accountinfo where accountno=?";
        PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
        pst.setString(1, s5);


        ResultSet rs = pst.executeQuery();


if(rs.next()){
    JOptionPane.showMessageDialog(null, "Wait");
     String money = rs.getString("any");
     String em = rs.getString("email");

   try{
            Email email = new Email("s8856010@gmail.com","*******");
            email.setFrom("s8856010@gmail.com", "ABC BANK" );
            email.setSubject("Your Balance");
            //email.setContent("<h>your key is </h> ","text/html");
            email.setContent( money,"text/html");
            email.addRecipient(em);
            email.send();
            JOptionPane.showMessageDialog(null, "cheak your email");


        }
        catch(Exception gf){
            System.out.println(gf);
            
        }
         
     
    }
                 }
        catch(Exception g){
            System.out.println(g);  
              }
       
             }
        
          else if(e.getSource() == b5){
              
              new BnlaceT();
              dispose();
          }
          else if(e.getSource()==b6){
              
            new Money();
            dispose();
              
              
          }
     
         }
        


    public static void main (String args []){
        new FirstInterFace();

    }
}
