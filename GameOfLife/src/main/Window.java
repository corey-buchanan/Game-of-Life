package main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * @author coreybuchanan
 *
 */
public class Window extends JPanel implements MouseListener, ActionListener {

	private static final long serialVersionUID = 1L;
	private Gameplay session;
	
	private static JFrame gui;
	
	private JButton start;
	private JButton stop;
	
	private Timer timer;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				gui = new JFrame("Game of Life");
				gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				Window window = new Window();
				
				gui.setContentPane(window);
				gui.setPreferredSize(new Dimension(400, 500));
				gui.pack();
				gui.setVisible(true);
				
			}
		});
	}
	
	public Window() {
		session = new Gameplay();
		
		timer = new Timer(100, this);
		
		addMouseListener(this);
		
		add(start = new JButton("Start"));
		start.addActionListener(this);
		add(stop = new JButton("Stop"));
		stop.addActionListener(this);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		session.spaceClicked(e.getX(), e.getY() - 100);
		repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		session.draw(g);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == start) {
			timer.start();
		}
		
		if (e.getSource() == stop) {
			timer.stop();
		}
		
		if (e.getSource() == timer) {
			session.updateBoard();
		}
		
		repaint();
		
	}

}
