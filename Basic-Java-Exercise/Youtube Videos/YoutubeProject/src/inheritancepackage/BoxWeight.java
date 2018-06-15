/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inheritancepackage;

/**
 *
 * @author SayefReyadh
 */
public class BoxWeight extends Box{
    private int weight;

    public BoxWeight(int width, int height, int depth , int weight) {
  
        super(width , height , depth);
        
        this.weight = weight;
    }

    public BoxWeight(Box ob , int weight) {
        super(ob);
        this.weight = weight;
    }

    public BoxWeight(int weight) {
        //super();
        this.weight = weight;
    }

    public BoxWeight() {
    }

    public BoxWeight(BoxWeight ob) {
        super(ob.getWidth(), ob.getHeight(), ob.getDepth());
        this.weight = ob.getWeight();
    }

    
    
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    
    
    
    @Override
    public void show()
    {
        System.out.println("This is the BoxWeight Class");
    }
    
    
}
