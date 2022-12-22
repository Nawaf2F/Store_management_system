public abstract class Users {
    private String name;
    public static int count=1000;
    private int id;

    public Users( String name) {
        this.name = name;
        this.id = count;
        count++;
    }
   
    
    public String getName() {
        return name;
    }

    public void setName( String name) {
    this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId( int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return   name + "(" + id + ") " ;
    }
    
    
}
