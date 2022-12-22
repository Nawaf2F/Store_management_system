import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Store implements ActionListener {
    public Users user[]=new Users[100];
    public int User_cursor=0;
    public Product storeproduct[]=new Product[100];
    public int Product_cursor=0;
    private Employee manager;
    private String name;

    public Store(String name,Employee manager) {
        this.manager = manager;
        this.name=name;
    }
    public boolean searchUser(int id){
     for(int i=0;i<User_cursor;i++)
         if(user[i].getId()==id)
             return true;
     return false;
    }
    public boolean searchProduct(int id){
   for(int i=0;i<Product_cursor;i++)
         if(storeproduct[i].getId()==id)
             return true;
     return false;     
    }
    public Product getProduct(int id){
   for(int i=0;i<Product_cursor;i++)
         if(storeproduct[i].getId()==id)
             return storeproduct[i];
     return null;     
    }
    public double totalPrice(int id){
        for(int i=0;i<User_cursor;i++)
        if(user[i].getId()==id&& user[i] instanceof Customer)
        {
            Customer c=(Customer)user[i];
            return c.totalcost();
        }
        return 0;
    }
public void addUser(Users c){
 if(User_cursor<user.length)  {
     user[User_cursor]=c;
     User_cursor++;
     System.out.println("Users added");
     return;
 } 
    System.out.println("user Not added");
}
public void deleteUser(int id){
    for(int i=0;i<User_cursor;i++)
        if(user[i].getId()==id)
        {
            User_cursor--;
            user[i]=user[User_cursor];
            System.out.println("Users Deleted");
            return;
        }
     System.out.println("Users Not Deleted");
    
}
public void searchUser1(int id){
  for(int i=0;i<User_cursor;i++)
        if(user[i].getId()==id)
        {
            System.out.println(user[i].toString());
            return;
        }   
    System.out.println("Users Not Found");
}
public Users searchUserById(int id){
  for(int i=0;i<User_cursor;i++)
        if(user[i].getId()==id)
        {
           
            return user[i];
        }   
    System.out.println("Users Not Found");
    return null;
}
public boolean getUser(int id){
  for(int i=0;i<User_cursor;i++)
        if(user[i].getId()==id)
        {
            return true;
        }
  return false;
}
public void printUser(){
    for(int i=0;i<User_cursor;i++)
         System.out.println(user[i].toString());
    System.out.println(manager.toString());
}
   
public void increaseSalary(int b){
    for(int i=0;i<User_cursor;i++){
        if(user[i] instanceof Employee)
        {
            Employee e=(Employee)user[i];
            e.setSalary(e.getSalary()+e.getSalary()*b/100);
            user[i]=e;
        }
    }
    manager.setSalary(manager.getSalary()+manager.getSalary()*b/100);
}


public void addProduct(Product p){
  if(Product_cursor<storeproduct.length)
  { storeproduct[Product_cursor]=p;
  Product_cursor++;
      System.out.println("Product added");
      return;
  }
   System.out.println("Product Not added");
}
public void addSpecialProduct(int id,Product p){
  for(int i=0;i<Product_cursor;i++){
      if(storeproduct[i].getId()==id){
          storeproduct[i].addspecialproduct(p);
      }
  }
}
public void printSpecialProduct(int id){
  for(int i=0;i<Product_cursor;i++){
      if(storeproduct[i].getId()==id){
          storeproduct[i].printspecialproduct();
      }
  }
}
public boolean removeProduct(int id){
     for(int i=0;i<Product_cursor;i++){
      if(storeproduct[i].getId()==id){
          Product_cursor--;
          storeproduct[i]=storeproduct[Product_cursor];
          return true;
      }
}
     return false;
}
public void addUserProduct(int id,Product p){
    for(int i=0;i<User_cursor;i++){
        if(user[i].getId()==id &&user[i] instanceof Customer){
            Customer c= (Customer)user[i];
            c.addproduct(p);
            user[i]=c;
            System.out.println("Product added");
            return;
            
        }
    }
    System.out.println("Product NOT added");
}
public void isExist(){
   for(int i=0;i<Product_cursor;i++){
       System.out.println(storeproduct[i].toString());
   }  
}
public void NewUserBuying(int id){
   for(int i=0;i<User_cursor;i++){
        if(user[i].getId()==id &&user[i] instanceof Customer){
            Customer c= (Customer)user[i];
    c.Newvisit();
     user[i]=c;
      return;
        }
   }
}
public void CustomerProduct(int id){
     for(int i=0;i<User_cursor;i++){
        if(user[i].getId()==id &&user[i] instanceof Customer){
            Customer c= (Customer)user[i];
            c.printproduct();
        }
     }
}
public void ChangeProductRelation(int id,String relation){
    for(int i=0;i<Product_cursor;i++){
      if(storeproduct[i].getId()==id){
     storeproduct[i].setRelationName(relation);
      } 
    }
}
    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public String getName() {
        return name;
    }

   
    public void setName(String name) {
        this.name = name;
    }
    
    
    
    public void removeProductGui(){
         frame.dispose();
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame=new JFrame("Delete product");
         JTextArea A=new JTextArea();
         String s="";
         for(int i=0;i<Product_cursor;i++){
         s+=storeproduct[i].toString()+"\n";
         A.setText(s);
       
            
            JLabel l1=new JLabel("enter id");
           
            frame.setLayout(new GridLayout(4,1));
            frame.setSize(350, 350);
            frame.setVisible(true);
            b.addActionListener(this);
            frame.add(A);
            frame.add(l1);
            frame.add(NN);
            frame.add(b);
   }  
        
    }
    JFrame frame=new JFrame("Delete product from store");
    JButton b=new JButton("delete");
    JTextField NN=new JTextField(10);
    @Override
    public void actionPerformed(ActionEvent e) {
        int id=Integer.parseInt(NN.getText());
        if(removeProduct(id)){
            JOptionPane.showMessageDialog( frame,"product delete");
        }else{
            JOptionPane.showMessageDialog( frame,"product Not delete"); 
        frame.dispose();
        }
        
    }
}
