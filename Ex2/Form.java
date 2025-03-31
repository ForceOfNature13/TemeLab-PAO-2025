package Ex2;
public class Form {
    //a)
    private String color;

    public float getArea(){
        return 0.0F;
    }
    public Form(){
        this.color="No color";
    }
    public Form(String color){
        this.color = color;
    }
    @Override
    public String toString(){
        return this.color;
    }
}
