package Ex2;
public class Triangle extends Form{
//b)
    private float base;
    private float height;

    public Triangle(){
        super();
        this.base = 0;
        this.height = 0;
    }
    public Triangle(String color, float base, float height){
        super(color);
        this.base = base;
        this.height = height;
    }
    //g)
    public void printTriangleDimensions(){
        System.out.println("Base: "+this.base+" Height: "+this.height);
    }
    //c)
    @Override
    public float getArea(){
        return (this.base*this.height)/2;
    }
    //d)
    @Override
    public String toString(){
        return "Triunghi: "+super.toString()+" "+this.getArea();
    }
    //e)
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Triangle){
            Triangle t = (Triangle) obj;
            return this.base == t.base && this.height == t.height;
        }
        return false;
    }
    //Am ales sa consider doua triunghiuri egale daca au aceeasi baza si aceeasi inaltime,deoarece aceste proprietati descriu dimensiunea geometrica unui triunghi in aplicatia noastra
    //Optional,putem verifica si daca cele doua triunghiuri au aceeasi culoare:
    //return this.base == t.base && this.height == t.height && super.toString().equals(t.toString());
}
