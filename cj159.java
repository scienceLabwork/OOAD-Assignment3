/* MIT License
*
* Copyright (c) 2022 Rudra Shah
* Permission is hereby granted, free of charge, to any person obtaining a copy
* of this software and associated documentation files (the "Software"), to deal
* in the Software without restriction, including without limitation the rights
* to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
* copies of the Software, and to permit persons to whom the Software is
* furnished to do so, subject to the following conditions:
*
* The above copyright notice and this permission notice shall be included in all
* copies or substantial portions of the Software.
*
* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
* IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
* FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
* AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
* LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
* OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
* SOFTWARE.
*
* -- LICENSE ENDS --
*
* Name: Rudra Shah
* Roll No: 21BCM054
* Class: 2nd Year CSE-MBA
* Section: I
* College: Nirma University
* Subject: OOAD -> OBJECT ORIENTED APPLICATION DEVELOPMENT
* Assignment: 3
*/

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import static java.lang.System.out;      
import javax.swing.*;       

public class cj159{
    String gender1of = "";
    String errorMessage = "";
    String f1 = "";
    String f2 = "";
    String f3 = "";
    String f4 = "";
    String f5 = "";
    String f6 = "";
    String f7 = "";
    String f8 = "";
    String f9 = "";
    String f10 = "";
    Statement cursor;

    cj159(){
        // Initialize Labels
        Frame f = new Frame("21BCM054: Assignments3");
        Label name = new Label("First Name: ");
        Label mname = new Label("Middle Name: ");
        Label lname = new Label("Last Name: ");
        Label dob = new Label("Date of Birth: ");
        Label gender = new Label("Gender: ");
        Label email = new Label("Email: ");
        Label password = new Label("Password: ");
        Label hobbies = new Label("Hobbies: ");
        Label language = new Label("Language(s): ");
        Label address = new Label("Address: ");
        Label pincode = new Label("Pincode: ");
        Label city = new Label("City name: ");
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:/Users/rudrashah/Desktop/My_python_course/21BCM054_A3.db");
            cursor = conn.createStatement();
            cursor.executeUpdate("create table if not exists user_details(name TEXT, dob TEXT, gender TEXT, email TEXT, password TEXT, hobbies TEXT, language TEXT, address TEXT, pincode TEXT, city TEXT)");

        } catch (SQLException e) {
            print("Database Not connected");
            print(""+e);
        }

        // Initialize different type fields
        TextField name1 = new TextField();
        name1.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                e.setKeyChar(Character.toUpperCase(e.getKeyChar()));
            }
        });
        TextField mname1 = new TextField();
        mname1.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                e.setKeyChar(Character.toUpperCase(e.getKeyChar()));
            }
        });
        TextField lname1 = new TextField();
        lname1.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                e.setKeyChar(Character.toUpperCase(e.getKeyChar()));
            }
        });
        Choice date = new Choice();
        Choice month = new Choice();
        Choice year = new Choice();
        for(int i=1;i<=31;i++){
            date.add(String.valueOf(i));
        }
        for(int i=1;i<=12;i++){
            month.add(String.valueOf(i));
        }
        for(int i=1998;i<=2003;i++){
            year.add(String.valueOf(i));
        }
        CheckboxGroup gender1 = new CheckboxGroup();
        Checkbox male = new Checkbox("Male", gender1, false);
        Checkbox female = new Checkbox("Female", gender1, false);
        TextField temail = new TextField();
        TextField tpass = new TextField();
        tpass.setEchoChar('*');
        Checkbox h1 = new Checkbox("Coding");
        Checkbox h2 = new Checkbox("Dancing");
        Checkbox h3 = new Checkbox("Singing");
        Checkbox l1 = new Checkbox("English");
        Checkbox l2 = new Checkbox("Hindi");
        Checkbox l3 = new Checkbox("Gujarati");
        TextField taddress = new TextField();
        TextField tpincode = new TextField();
        Choice tcity = new Choice();
        tcity.add("Select City");
        tcity.add("Ahmedabad");
        tcity.add("Surat");
        tcity.add("Vadodara");
        tcity.add("Rajkot");
        tcity.add("Bhavnagar");
        tcity.add("Jamnagar");
        tcity.add("Junagadh");
        tcity.add("Gandhinagar");
        tcity.add("Anand");
        tcity.add("Nadiad");
        tcity.add("Navsari");
        tcity.add("Bharuch");
        tcity.add("Patan");
        tcity.add("Porbandar");
        tcity.add("Surendranagar");
        tcity.add("Morvi");
        tcity.add("Veraval");
        tcity.add("Godhra");
        tcity.add("Palanpur");
        tcity.add("Botad");
        tcity.add("Valsad");
        Button submit = new Button("Register");
        Button Login = new Button("Login");

        // Initialize Bounds
        name.setBounds(50,50,100,25);
        name1.setBounds(150,50,150,25);
        mname.setBounds(50,80,100,25);
        mname1.setBounds(150,80,150,25);
        lname.setBounds(50,110,100,25);
        lname1.setBounds(150,110,150,25);
        dob.setBounds(50,140,90,25);
        date.setBounds(145,140,80,25);
        month.setBounds(225,140,80,25);
        year.setBounds(305,140,90,25);
        gender.setBounds(50,170,90,25);
        male.setBounds(150,170,70,25);
        female.setBounds(220,170,80,25);
        email.setBounds(50,200,100,25);
        temail.setBounds(150,200,150,25);
        password.setBounds(50,230,100,25);
        tpass.setBounds(150,230,150,25);
        hobbies.setBounds(50,260,95,25);
        h1.setBounds(145,260,90,25);
        h2.setBounds(240,260,90,25);
        h3.setBounds(340,260,90,25);
        language.setBounds(50,290,95,25);
        l1.setBounds(145,290,90,25);
        l2.setBounds(240,290,90,25);
        l3.setBounds(340,290,90,25);
        address.setBounds(50,320,95,25);
        taddress.setBounds(150,320,150,25);
        pincode.setBounds(50,350,95,25);
        tpincode.setBounds(150,350,150,25);
        city.setBounds(50,380,95,25);
        tcity.setBounds(145,380,150,25);
        submit.setBounds(120,420,100,25);
        Login.setBounds(250,420,100,25);

        // Initialize Action Listener
        date.addItemListener(e->{
            if(month.getSelectedItem().equals("2")){
                if(Integer.parseInt(year.getSelectedItem())%4==0){
                    if(Integer.parseInt(date.getSelectedItem())>29){
                        date.select("29");
                    }
                }else{
                    if(Integer.parseInt(date.getSelectedItem())>28){
                        date.select("28");
                    }
                }
            }else if(month.getSelectedItem().equals("4")||month.getSelectedItem().equals("6")||month.getSelectedItem().equals("9")||month.getSelectedItem().equals("11")){
                if(Integer.parseInt(date.getSelectedItem())>30){
                    date.select("30");
                }
            }
            else{
                if(Integer.parseInt(date.getSelectedItem())>31){
                    date.select("31");
                }
            }
        });
        month.addItemListener(e->{
            if(month.getSelectedItem().equals("2")){
                if(Integer.parseInt(year.getSelectedItem())%4==0){
                    if(Integer.parseInt(date.getSelectedItem())>29){
                        date.select("29");
                    }
                }else{
                    if(Integer.parseInt(date.getSelectedItem())>28){
                        date.select("28");
                    }
                }
            }else if(month.getSelectedItem().equals("4")||month.getSelectedItem().equals("6")||month.getSelectedItem().equals("9")||month.getSelectedItem().equals("11")){
                if(Integer.parseInt(date.getSelectedItem())>30){
                    date.select("30");
                }
            }
            else{
                if(Integer.parseInt(date.getSelectedItem())>31){
                    date.select("31");
                }
            }
        });
        year.addItemListener(e->{
            if(month.getSelectedItem().equals("2")){
                if(Integer.parseInt(year.getSelectedItem())%4==0){
                    if(Integer.parseInt(date.getSelectedItem())>29){
                        date.select("29");
                    }
                }else{
                    if(Integer.parseInt(date.getSelectedItem())>28){
                        date.select("28");
                    }
                }
            }else if(month.getSelectedItem().equals("4")||month.getSelectedItem().equals("6")||month.getSelectedItem().equals("9")||month.getSelectedItem().equals("11")){
                if(Integer.parseInt(date.getSelectedItem())>30){
                    date.select("30");
                }
            }
            else{
                if(Integer.parseInt(date.getSelectedItem())>31){
                    date.select("31");
                }
            }
        });
        male.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e){
                gender1of = "Male";
            }
        });
        female.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e){
                gender1of = "Female";
            }
        });
        submit.addActionListener(e->{
            //append all 12 fields to text area
            f1 = name1.getText() + " " + mname1.getText() + " " + lname1.getText();
            f2 = date.getSelectedItem() + "/" + month.getSelectedItem() + "/" + year.getSelectedItem();
            f3 = gender1of;
            f6 = "";
            String emailc = temail.getText();
            if(emailc.matches(".*[@].*")){
                f4 = emailc;
            }else{
                errorMessage+="\nEmail must contain @";
            }
            String pasc = tpass.getText();
            if(pasc.matches(".*[!@#$%^&*()_+].*") && pasc.length()>=10){
                f5 = pasc;
            }else{
                errorMessage+="Password must contain atleast one special character and 10 characters";
            }
            if(h1.getState()){
                f6+=h1.getLabel()+" ";
            }
            if(h2.getState()){
                f6+=h2.getLabel()+" ";
            }
            if(h3.getState()){
                f6+=h3.getLabel()+" ";
            }
            f7 = "";
            if(l1.getState()){
                f7+=l1.getLabel()+" ";
            }
            if(l2.getState()){
                f7+=l2.getLabel()+" ";
            }
            if(l3.getState()){
                f7+=l3.getLabel()+" ";
            }
            String addressc = taddress.getText();
            if(addressc.matches(".*[0-9].*")){
                f8 = addressc;
            }else{
                errorMessage+="\nAddress must contain atleast one number";
            }
            String pincodec = tpincode.getText();
            if(pincodec.matches(".*[0-9].*") && pincodec.length()==6){
                f9 = pincodec;
            }else{
                errorMessage+="\nPincode must contain atleast one number";
            }
            String cityc = tcity.getSelectedItem();
            if(!cityc.equals("Select City")){
                f10 = cityc;
            }else{
                errorMessage+="\nCity must be selected";
            }
            if(errorMessage!=""){
                JOptionPane.showMessageDialog(null, errorMessage);
                errorMessage="";
            }else{
                try{
                    cursor.executeUpdate("INSERT INTO `user_details`(`name`, `dob`, `gender`, `email`, `password`, `hobbies`, `language`, `address`, `pincode`, `city`) VALUES ('"+f1+"','"+f2+"','"+f3+"','"+f4+"','"+f5+"','"+f6+"','"+f7+"','"+f8+"','"+f9+"','"+f10+"')");   
                    JOptionPane.showMessageDialog(null, "Registered Successfully!! \n\n");
                }catch(SQLException sqle){
                    print(sqle);
                    JOptionPane.showMessageDialog(null, "Database Connection Error!! \n\n");
                }
            }
        });

        Login.addActionListener(e->{
            Frame frame = new Frame("21BCM054: Login Form");
            Label fl1 = new Label("Email");
            Label fl2 = new Label("Password");
            TextField ft1 = new TextField();
            TextField ft2 = new TextField();
            ft2.setEchoChar('*');
            Button fb1 = new Button("Login");

            fb1.addActionListener(e1->{
                String emailc = ft1.getText();
                String pasc = ft2.getText();
                try{
                    ResultSet rs = cursor.executeQuery("SELECT * FROM `user_details` WHERE `email`='"+emailc+"' AND `password`='"+pasc+"'");
                    if(rs.next()){
                        Frame frame1 = new Frame("21BCM054: User Details");
                        Label fl3 = new Label("Name");
                        Label fl4 = new Label("Date of Birth");
                        Label fl5 = new Label("Gender: ");
                        Label ffemail = new Label("Email: ");
                        Label ffhobbies = new Label("Hobbies: ");
                        Label fflanguage = new Label("Language(s): ");
                        Label ffaddress = new Label("Address: ");
                        Label ffpincode = new Label("Pincode: ");
                        Label ffcity = new Label("City name: ");

                        Label ff1 = new Label(rs.getString("name"));
                        Label ff2 = new Label(rs.getString("dob"));
                        Label ff3 = new Label(rs.getString("gender"));
                        Label ffemail1 = new Label(rs.getString("email"));
                        Label ffhobbies1 = new Label(rs.getString("hobbies"));
                        Label fflanguage1 = new Label(rs.getString("language"));
                        Label ffaddress1 = new Label(rs.getString("address"));
                        Label ffpincode1 = new Label(rs.getString("pincode"));
                        Label ffcity1 = new Label(rs.getString("city"));

                        fl3.setBounds(50, 50, 100, 30);
                        fl4.setBounds(50, 100, 100, 30);
                        fl5.setBounds(50, 150, 100, 30);
                        ffemail.setBounds(50, 200, 100, 30);
                        ffhobbies.setBounds(50, 250, 100, 30);
                        fflanguage.setBounds(50, 300, 100, 30);
                        ffaddress.setBounds(50, 350, 100, 30);
                        ffpincode.setBounds(50, 400, 100, 30);
                        ffcity.setBounds(50, 450, 100, 30);

                        ff1.setBounds(200, 50, 200, 30);
                        ff2.setBounds(200, 100, 200, 30);
                        ff3.setBounds(200, 150, 200, 30);
                        ffemail1.setBounds(200, 200, 200, 30);
                        ffhobbies1.setBounds(200, 250, 200, 30);
                        fflanguage1.setBounds(200, 300, 200, 30);
                        ffaddress1.setBounds(200, 350, 200, 30);
                        ffpincode1.setBounds(200, 400, 200, 30);
                        ffcity1.setBounds(200, 450, 200, 30);

                        frame1.add(fl3);
                        frame1.add(ff1);
                        frame1.add(fl4);
                        frame1.add(ff2);
                        frame1.add(fl5);
                        frame1.add(ff3);
                        frame1.add(ffemail);
                        frame1.add(ffemail1);
                        frame1.add(ffhobbies);
                        frame1.add(ffhobbies1);
                        frame1.add(fflanguage);
                        frame1.add(fflanguage1);
                        frame1.add(ffaddress);
                        frame1.add(ffaddress1);
                        frame1.add(ffpincode);
                        frame1.add(ffpincode1);
                        frame1.add(ffcity);
                        frame1.add(ffcity1);

                        frame1.setLayout(null);
                        frame1.setSize(500,500);
                        frame1.setVisible(true);
                    }else{
                        JOptionPane.showMessageDialog(null, "Login Failed!! \n\n");
                    }
                }catch(SQLException sqle){
                    print(sqle);
                    JOptionPane.showMessageDialog(null, "Database Connection Error!! \n\n");
                }
            });

            fl1.setBounds(50, 100, 100, 30);
            fl2.setBounds(50, 150, 100, 30);
            ft1.setBounds(150, 100, 220, 30);
            ft2.setBounds(150, 150, 220, 30);
            fb1.setBounds(150, 200, 100, 30);

            frame.add(fl1);
            frame.add(fl2);
            frame.add(ft1);
            frame.add(ft2);
            frame.add(fb1);

            frame.setSize(500, 500);
            frame.setLayout(null);
            frame.setVisible(true);
        });
        
        f.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });

        // Adding to Frame
        f.add(name);
        f.add(name1);
        f.add(mname);
        f.add(mname1);
        f.add(lname);
        f.add(lname1);
        f.add(dob);
        f.add(date);
        f.add(month);
        f.add(year);
        f.add(gender);
        f.add(male);
        f.add(female);
        f.add(email);
        f.add(temail);
        f.add(password);
        f.add(tpass);
        f.add(hobbies);
        f.add(h1);
        f.add(h2);
        f.add(h3);
        f.add(language);
        f.add(l1);
        f.add(l2);
        f.add(l3);
        f.add(address);
        f.add(taddress);
        f.add(pincode);
        f.add(tpincode);
        f.add(city);
        f.add(tcity);
        f.add(submit);
        f.add(Login);

        // Configure Frame
        f.setSize(500,500);
        f.setLayout(null);
        f.setVisible(true);
    }
    public static void main(String[] args){
        new cj159();
    }
    private static <T>void print(T s){
        out.print(s);
    }
    public static void endl(){
        out.println();
    }
}
/* 21BCM054 RUDRA SHAH */