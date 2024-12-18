import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;

public class MyGui {
   public static void main(String [] args){
   
   JFrame frame;
   JPanel panel = new JPanel();
   panel.setLayout(null);
   
   JLabel title = new JLabel();
   title.setText("Only Admin can log in");
   title.setBounds(10, 10, 320, 30);  
   title.setForeground(Color.green);
   panel.add(title);
   
   JLabel userLabel = new JLabel("Username: ");
   userLabel.setBounds(10, 35, 80, 350);
   userLabel.setForeground(Color.blue);
   panel.add(userLabel);
   
   JTextField userInput = new JTextField(25);
   userInput.setBounds(75, 200, 150, 25);
   panel.add(userInput);
   
   JLabel passLabel = new JLabel("Password: ");
   passLabel.setBounds(10, 70, 80, 350);
   passLabel.setForeground(Color.blue);
   panel.add(passLabel);
   
   JPasswordField passInput = new JPasswordField(25);
   passInput.setBounds(75, 230, 150, 25);
   panel.add(passInput);
   
   frame = new JFrame ("Dino's lover");
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   frame.setSize(360, 385);
   frame.setLocationRelativeTo(null);
   frame.add(panel);
   
   JButton loginButton = new JButton("Log In");
   loginButton.setBounds(75, 270, 150, 30);
   panel.add(loginButton);
   
   
   loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userInput.getText();
                char[] password = passInput.getPassword();
                if (username.equals("dino") && String.valueOf(password).equals("mybaby")) {
                    System.out.println("Username: " + username);
                    System.out.println("Password: " + String.valueOf(password));
                    System.out.println("Log in Successfully!");
                    
                    frame.setVisible(false);
                    new Calculator(); 
                    
                } else {
                    System.out.println("Username: " + username);
                    System.out.println("Password: " + String.valueOf(password));
                    System.out.println("Error!"); 
                }
                
                userInput.setText(""); 
                passInput.setText("");
            }
        });
        
   ImageIcon image = new ImageIcon("dodot.jpeg");      
   JLabel backgroundLabel = new JLabel(image);
   backgroundLabel.setBounds(0, 0, 350, 350);
   panel.add(backgroundLabel);
   frame.setVisible(true);
     
   }
}

class Calculator implements ActionListener{
   
   JFrame frame;
   ImageIcon image;
   JTextField textfield;
   JButton[] numberButtons = new JButton[10];
   JButton[] functionButtons = new JButton[9];
   JButton addButton,subButton,mulButton,divButton;
   JButton decButton, equButton, delButton, clrButton, negButton;
   JPanel panel;
   
   Font myFont = new Font("Roboto",Font.BOLD,30);
   
   double num1=0,num2=0,result=0;
   char operator;
   
   
   Calculator(){
      frame = new JFrame("Dino's Calculator");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(420, 550);
      frame.setLocationRelativeTo(null);
      frame.setLayout(null);
      
      textfield = new JTextField();
      textfield.setBounds(50, 25, 300, 50);
      textfield.setFont(myFont);
      textfield.setEditable(false);
      textfield.setBackground(Color.BLACK);
      textfield.setForeground(Color.WHITE);
      textfield.setHorizontalAlignment(JTextField.RIGHT);
      textfield.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
      
      addButton = new JButton("+");
      subButton = new JButton("-");
      mulButton = new JButton("*");
      divButton = new JButton("/");
      decButton = new JButton(".");
      equButton = new JButton("=");
      delButton = new JButton("dlt");
      clrButton = new JButton("clr");
      negButton = new JButton("(-)");
      
      functionButtons[0] = addButton;
      functionButtons[1] = subButton;
      functionButtons[2] = mulButton;
      functionButtons[3] = divButton;
      functionButtons[4] = decButton;
      functionButtons[5] = equButton;
      functionButtons[6] = delButton;
      functionButtons[7] = clrButton;
      functionButtons[8] = negButton;
      
      
      for(int i = 0; i < 9; i++){
         functionButtons[i].addActionListener(this);
         functionButtons[i].setFont(myFont);
         functionButtons[i].setFocusable(false);
      }
      
      for(int i = 0; i < 10; i++){
         numberButtons[i] = new JButton(String.valueOf(i));
         numberButtons[i].addActionListener(this);
         numberButtons[i].setFont(myFont);
         numberButtons[i].setFocusable(false);
      }
      
      negButton.setBounds(50,430,100,50);
      delButton.setBounds(150,430,100,50);
      clrButton.setBounds(250,430,100,50);
      
      panel = new JPanel();
      panel.setBounds(50,100,300,300);
      panel.setLayout(new GridLayout(4,4,10,10));
      
      panel.add(numberButtons[1]);
      panel.add(numberButtons[2]);
      panel.add(numberButtons[3]);
      panel.add(addButton);
      panel.add(numberButtons[4]);
      panel.add(numberButtons[5]);
      panel.add(numberButtons[6]);
      panel.add(subButton);
      panel.add(numberButtons[7]);
      panel.add(numberButtons[8]);
      panel.add(numberButtons[9]);
      panel.add(mulButton);
      panel.add(decButton);
      panel.add(numberButtons[0]);
      panel.add(equButton);
      panel.add(divButton);
      
      
      
      frame.add(panel);
      frame.add(negButton);
      frame.add(delButton);
      frame.add(clrButton);
      frame.add(textfield);
      frame.setVisible(true);
   }
   
   
     
   @Override
   public void actionPerformed(ActionEvent e){
      for(int i = 0; i < 10; i++){ 
         if(e.getSource() == numberButtons[i]){
            textfield.setText(textfield.getText().concat(String.valueOf(i)));
         }
      }
      
      if(e.getSource() == decButton){
         textfield.setText(textfield.getText().concat("."));
      }
      
      if(e.getSource() == addButton){
         num1 = Double.parseDouble(textfield.getText());
         operator = '+';
         textfield.setText("");
      }
      
      if(e.getSource() == subButton){
         num1 = Double.parseDouble(textfield.getText());
         operator = '-';
         textfield.setText("");
      }
      
      if(e.getSource() == mulButton){
         num1 = Double.parseDouble(textfield.getText());
         operator = '*';
         textfield.setText("");
      }
      
      if(e.getSource() == divButton){
         num1 = Double.parseDouble(textfield.getText());
         operator = '/';
         textfield.setText("");
      }
      
      if(e.getSource() == equButton){
         num2 = Double.parseDouble(textfield.getText());
         
         switch(operator){
            case '+':
               result = num1 + num2;
               break;
            case '-':
               result = num1 - num2;
               break;
            case '*':
               result = num1 * num2;
               break;
            case '/':
               result = num1 / num2;
               break;          
         }
         textfield.setText(String.valueOf(result));
         num1 = result;
      }
      
      if(e.getSource() == clrButton){
         textfield.setText("");
      }
      
      if(e.getSource() == delButton){
         String string = textfield.getText();
         textfield.setText("");
         for(int i = 0; i < string.length() - 1; i++){
            textfield.setText(textfield.getText()+string.charAt(i));
         } 
      }
      
      if(e.getSource() == negButton){
         double temp = Double.parseDouble(textfield.getText());
         temp *= -1;
         textfield.setText(String.valueOf(temp));
         } 
      }
      
}
