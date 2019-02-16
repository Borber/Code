import java.awt.*;
import javax.swing.*;

//import com.sun.xml.internal.ws.api.pipe.Tube;
public class BallGame extends JFrame{
    private static final long serialVersionUID = 1L;
    Image ball = Toolkit.getDefaultToolkit().getImage("images/ball.png");
    Image desk = Toolkit.getDefaultToolkit().getImage("images/table.jpg");
    //画窗口的方法
    double x = 100,y = 100;
    double degree = 3.14/3;
    public void paint(Graphics g){
        System.out.println("1");
        g.drawImage(desk,0,0,null);
        g.drawImage(ball,(int)x,(int)y,null);
        x = x + 5*Math.cos(degree);
        y = y + 5*Math.sin(degree);
        if(y > 500-40-30||y < 40) degree*=-1;
    }
    //窗口加载
    void launchFrame(){
        setSize(856,500);
        setLocation(50,50);
        setVisible(true);
        //重画窗口
        while(true){
            repaint();
            try{
                Thread.sleep(40);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        System.out.println("Hello World");
        BallGame game = new BallGame();
        game.launchFrame();
    }
}

