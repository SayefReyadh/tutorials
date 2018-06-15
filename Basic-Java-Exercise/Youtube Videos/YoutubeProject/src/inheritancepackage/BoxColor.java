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
public class BoxColor extends BoxWeight{
    
    private String colorString;

    public BoxColor(String colorString, int width, int height, int depth, int weight) {
        super(width, height, depth, weight);
        this.colorString = colorString;
    }

    public BoxColor(String colorString, Box ob, int weight) {
        super(ob, weight);
        this.colorString = colorString;
    }

    public BoxColor(String colorString, int weight) {
        super(weight);
        this.colorString = colorString;
    }
    
    public BoxColor(String colorString, BoxWeight ob) {
        super(ob);
        this.colorString = colorString;
    }

    public BoxColor() {
    }

    
    public void print()
    {
        System.out.println(this.getDepth());
        System.out.println(this.getHeight());
        System.out.println(this.getWidth());
        System.out.println(this.getWeight());
        System.out.println(this.colorString);
        
    }
    
    @Override
    public void show()
    {
        System.out.println("This is the BoxColor Class");
    
    }
    
    
    
}
