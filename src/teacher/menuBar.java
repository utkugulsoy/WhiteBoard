import javax.swing.*;
public class menuBar extends JMenuBar
{
    protected static JMenu menu, submenu,square,circle;
    protected static JMenuItem line,eraser,finishClass,attendance,colorPicker
            ,clearPage,smallSquare,mediumSquare,largeSquare,smallCircle,mediumCircle,largeCircle;


    public menuBar(){
        menu=new JMenu("Menu");
        submenu=new JMenu("Shapes");
        square=new JMenu("Square");
        circle=new JMenu("Circle");
        finishClass=new JMenu("Finish Class");
        attendance=new JMenu("Attendance");

        line=new JMenuItem("Line");

        eraser=new JMenuItem("Eraser");
        finishClass=new JMenuItem("Finish Class");
        attendance=new JMenuItem("Attendance");
        colorPicker=new JMenuItem("Choose Color");
        clearPage=new JMenuItem("Clear Page");
        smallSquare=new JMenuItem("Small");
        mediumSquare=new JMenuItem("Medium");
        largeSquare=new JMenuItem("Large");

        smallCircle=new JMenuItem("Small");
        mediumCircle=new JMenuItem("Medium");
        largeCircle=new JMenuItem("Large");

        add(menu);
        menu.add(submenu);
        submenu.add(line);
        submenu.add(square);
        square.add(smallSquare);
        square.add(mediumSquare);
        square.add(largeSquare);
        submenu.add(circle);
        circle.add(smallCircle);
        circle.add(mediumCircle);
        circle.add(largeCircle);
        submenu.add(eraser);

        menu.add(finishClass);
        menu.add(attendance);
        menu.add(clearPage);
        menu.add(colorPicker);


    }
}