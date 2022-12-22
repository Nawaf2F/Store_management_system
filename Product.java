



public class Product {
    private String name;
    private double price;
    private static int num=0;
    private int id;
    private String RelationName;
    private final Product[]specialproduct;
    int cur=0;
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        this.id = num;
        num++;
        specialproduct=new Product[100];
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

   
    public static int getNum() {
        return num;
    }

    public static void setNum(int aNum) {
        num = aNum;
    }

    public int getId() {
        return id;
    }

   
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Product("+id+"): " +name + " cost " + price + " SR" ;
    }

    
    public String getRelationName() {
        return RelationName;
    }

    public void setRelationName(String RelationName) {
        this.RelationName = RelationName;
    }
    
    public void addspecialproduct(Product p){
        if(cur<specialproduct.length){
            specialproduct[cur]=p;
        cur++;
        }
    }
        public void printspecialproduct(){
            for(int i=0;i<cur;i++)
                System.out.println(specialproduct[i].toString());
        }
        
    
}
