package Ex2;

public class Circle extends Form{
    //b)
    private float radius;

    public Circle(){
        super();
        this.radius = 0;
    }
    public Circle(String color, float radius){
        super(color);
        this.radius = radius;
    }
    //g)
    public void printCircleDimensions(){
        System.out.println("Radius: "+this.radius);
    }
    //c)
    @Override
    public float getArea(){
        return (float) (Math.PI*Math.pow(this.radius,2));
    }
    //d)
    @Override
    public String toString(){
        return "Cerc: "+super.toString()+" "+this.getArea();
    }
}
