import com.jogamp.nativewindow.WindowClosingProtocol;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.geom.Point2D;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color.*;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class Main extends JFrame {
	public Main(String title){
		super(title);
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		addWindowListener(new WindowClosing());
		setState(JFrame.ICONIFIED);
		setIconImage(new ImageIcon("icon.jpg").getImage());
		canvas.setSize(800, 600);
		canvas.setBackground(Color.WHITE);
		add(canvas);
		pack();
		setVisible( true );
		//setExtendedState(JFrame.MAXIMIZED_BOTH);

		canvas.addMouseListener(
				new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						drawPoint(e.getX(),e.getY());
					}
				}
		);

	}

	class WindowClosing extends WindowAdapter{
		public void windowClosing(WindowEvent e ){
			int ans = JOptionPane.showConfirmDialog(Main.this, "本当に終了しますか?");
			if(ans == JOptionPane.YES_OPTION){
				System.exit(0);
			}
		}
	}

	public void drawPoint(int _x, int _y){
		Graphics g = canvas.getGraphics();
		g.drawOval(_x, _y, 2, 2);
	}

	public static void main(String[] args){ new Main( "Main" ); }

	private Canvas canvas = new Canvas();

}

