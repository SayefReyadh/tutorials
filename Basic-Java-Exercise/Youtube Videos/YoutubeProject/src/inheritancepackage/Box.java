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
public class Box {
    
    private int width;
    private int height;
    private int depth;

    public Box() {
        this.width = 1;
        this.height = 1;
        this.depth = 1;
    }

    public Box(int width, int height, int depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }
    
    public Box(Box ob) {
        this.width = ob.getWidth();
        this.height = ob.getHeight();
        this.depth = ob.getDepth();
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }
    
    
    public void show()
    {
        System.out.println("This is the Box Class");
    }

    @Override
    public String toString() {
        return "Box{" + "width=" + width + ", height=" + height + ", depth=" + depth + '}';
    }
    
    
    
    
}
