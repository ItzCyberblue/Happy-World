package com.XboxPro39Games.HappyWorld.Main;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable{
	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	public static final int SCALE = 1;
	public static final String NAME = "Happy World";
	
	private JFrame frame;
	
	private boolean running = false;
	
	public Game() {
		setMinimumSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
		setMaximumSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
		setPreferredSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
		
		frame = new JFrame(NAME);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		frame.add(this, BorderLayout.CENTER);
		frame.pack();
		
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public synchronized void start() {
		running = true;
		new Thread(this).start();
	}
	
	public synchronized void stop() {
		running = false;
	}

	public void run() {
		long lasTime = System.nanoTime();
		double nsPerTick = 1000000000D/60D;
		
		int ticks = 0;
		int frames = 0;
		
		long lasTimer = System.currentTimeMillis();
		double delta = 0;
		
		while(running) {
			long now = System.nanoTime();
			delta += (now - lasTime) / nsPerTick;
			lasTime = now;
			
			tick();
			render();
		}
	}
	
	public void tick() {
		
	}
	
	public void render() {
		
	}
	
	public static void main(String[] args) {
		new Game().start();
	}
}