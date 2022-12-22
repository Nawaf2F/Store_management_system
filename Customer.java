public class Customer extends Users{

    private int visit=0;
    public String status="new Customer ";
    public Product product[]=new Product[100];
    public int cur=0;

    public Customer(String n) {
        super(n);
    }

    public int getVisit() {
        return visit;
    }

    public void setVisit(int visit) {
        this.visit = visit;
    }

    @Override
    public String toString() {
        return status +super.toString() +" visit " + visit + " times";
    }
    
  public void addproduct(Product p){
      if(cur<product.length){
          product[cur]=p;
          cur++;
          System.out.println("Product Added");
  }  else{
          System.out.println("Product Not Added");
      }
  }

  public void Newvisit(){
      visit++;
      if(visit>=3)
          status="Special customer ";
      cur=0;
      product=new Product[100];
  }

  public void printproduct(){
      for(int i=0;i<cur;i++)
          System.out.println(product[i].toString());
  }
  
  public double totalcost(){
  double sum=0;
  for(int i=0;i<cur;i++)
      sum+=product[i].getPrice();
  if(visit>=3)
      sum-=sum*25/100;
  return sum;
  }
}
