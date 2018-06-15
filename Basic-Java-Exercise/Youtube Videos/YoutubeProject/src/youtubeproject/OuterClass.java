/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youtubeproject;

import abstractpackage.Figure;
import interfacepackage.NewInterfaceOne;
import java.lang.reflect.Method;

/**
 *
 * @author SayefReyadh
 */
public class OuterClass {

    public int id;

    public void showOutter() {
        System.out.println("This is OutterClass");
        
        
                
        class MethodClass{
            private int id;
            public void show()
            {
                System.out.println("This is MethodClass");
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }
            
        }
        
        MethodClass ob = new MethodClass();
        ob.show();
        
        ob.setId(15);
        
    }

    
    public void message(NewInterfaceOne ob)
    {
        ob.show();
        ob.show2();
    }
    
    public void message(Figure ob)
    {
        System.out.println(ob.calculateArea());
    }
    
    public static class StaticInnerClass{
        public void show()
        {
            System.out.println("This is StaticInnerClass");
        }
    }
    
    public class InnerClass {

        public int id;

        public void showInner() {
            System.out.println("This is InnerClass");
        }

        public class InnerInnerClass {

            public int id;

            public void showInnerInner() {
                System.out.println("This is InnerInnerClass");
            }

        }
    }
}
