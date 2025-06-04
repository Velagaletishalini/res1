import java.awt.*; 
import java.awt.event.*; 
import java.sql.*; 
class Shalini11 extends Frame implements ActionListener 
{ 
Label regNum, sn, dob, g, br, pl, address; 
TextField regNumField, snField, dobField; 
Checkbox r1, r2, c1, c2, c3, c4, htmlCheckbox; 
Choice branchChoice; 
CheckboxGroup cbg; 
TextArea addressArea;
Button b1, b2; 
Shalini11() 
{ 
setTitle("Student Registration Form"); 
setSize(400, 500); 
setLayout(null); 
regNum = new Label("Reg Number:"); 
sn = new Label("Student Name:"); 
dob = new Label("DOB(DD-MM-YYYY):"); 
g = new Label("Gender"); 
br = new Label("Select Your Branch:"); 
pl = new Label("Programming Languages"); 
address = new Label("Address"); 
regNumField = new TextField(); 
snField = new TextField(); 
dobField = new TextField(); 
cbg = new CheckboxGroup(); 
r1 = new Checkbox("Male", cbg, true); 
r2 = new Checkbox("Female", cbg, false); 
c1 = new Checkbox("C"); 
c2 = new Checkbox("C++"); 
c3 = new Checkbox("Java"); 
c4 = new Checkbox("Python"); 
htmlCheckbox = new Checkbox("HTML"); 
branchChoice = new Choice(); 
branchChoice.add("CSE"); 
branchChoice.add("IT"); 
branchChoice.add("ECE"); 
branchChoice.add("EEE"); 
addressArea = new TextArea("", 5, TextArea.SCROLLBARS_BOTH); 
b1 = new Button("Submit"); 
b2 = new Button("ResetAll"); 
regNum.setBounds(20, 50, 100, 20); 
regNumField.setBounds(150, 50, 150, 20); 
sn.setBounds(20, 80, 100, 20); 
snField.setBounds(150, 80, 150, 20); 
dob.setBounds(20, 110, 120, 20); 
dobField.setBounds(150, 110, 150, 20); 
g.setBounds(20, 140, 80, 20); 
r1.setBounds(150, 140, 60, 20); 
r2.setBounds(220, 140, 80, 20); 
br.setBounds(20, 170, 150, 20); 
branchChoice.setBounds(180, 170, 120, 20); 
pl.setBounds(20, 200, 150, 20); 
c1.setBounds(150, 200, 40, 20); 
c2.setBounds(200, 200, 50, 20); 
c3.setBounds(250, 200, 50, 20); 
c4.setBounds(300, 200, 70, 20); 
htmlCheckbox.setBounds(370, 200, 60, 20); 
address.setBounds(20, 230, 150, 20); 
addressArea.setBounds(180, 230, 150, 80); 
b1.setBounds(100, 330, 80, 30); 
b2.setBounds(200, 330, 80, 30); 
add(regNum); 
add(regNumField); 
add(sn); 
add(snField); 
add(dob); add(dobField); 
add(g); 
add(r1); 
add(r2); 
add(br); 
add(branchChoice); 
add(pl); 
add(c1); 
add(c2); 
add(c3); 
add(c4); 
add(htmlCheckbox); 
add(address); 
add(addressArea); 
add(b1); 
add(b2); 
b1.addActionListener(this); 
b2.addActionListener(this); 
setVisible(true); 
} 
public void actionPerformed(ActionEvent x) 
{ 
Button bc = (Button) x.getSource(); 
if (bc.getLabel().equals("Submit")) { 
try { 
Class.forName("oracle.jdbc.driver.OracleDriver"); Connection con = 
DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", 
"shalini"); 
Statement s = con.createStatement(); 
String regNum = regNumField.getText(); 
String sname = snField.getText(); 
String dob = dobField.getText(); 
String gen = ""; 
for (Checkbox cb : new Checkbox[]{r1, r2}) { 
if (cb.getState()) { 
gen = cb.getLabel(); 
break; 
} 
} 
String b = branchChoice.getSelectedItem(); 
String planguages = ""; 
for (Checkbox cb : new Checkbox[]{c1, c2, c3, c4, htmlCheckbox}) { 
if (cb.getState()) { 
planguages += cb.getLabel() + ","; 
} 
} 
if (planguages.length() > 0) { 
planguages = planguages.substring(0, planguages.length() - 1); 
} 
String addr = addressArea.getText(); String q = "insert into Student11 values('" + regNum + "','" + sname + "','" + dob + "','" + gen + "','" + b + "','" + planguages + "','" + addr + "')"; 
s.executeQuery(q); 
System.out.println("Row Inserted"); 
} catch (Exception e) { 
System.out.println(e); 
} 
} else { 
regNumField.setText(""); 
snField.setText(""); 
dobField.setText(""); 
cbg.setSelectedCheckbox(null); 
branchChoice.select("CSE"); 
c1.setState(false); 
c2.setState(false); 
c3.setState(false); 
c4.setState(false); 
htmlCheckbox.setState(false); 
addressArea.setText(""); 
} 
} 
public static void main(String args[]) { 
Shalini11 s = new Shalini11(); 
} 
}