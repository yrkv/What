package what;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import what.entity.Player;
import what.graphics.SpriteHandler;
import what.level.Level;

import java.io.IOException;

import static org.lwjgl.opengl.GL11.*;

public class Main {

	private long totalFrames = 0;
	private long startTime;
	private double t;
	private int w, h;

	private Level level;

	public static int screenOffsetX = 0, screenOffsetY = 0;

	public void start() throws IOException {
		try {
//			Display.setDisplayMode(Display.getDesktopDisplayMode());
			Display.setDisplayMode(new DisplayMode(16 * 100, 16 * 16));
//			Display.setFullscreen(true);
			Display.create();
			w = Display.getWidth(); h = Display.getHeight();
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.exit(0);
		}

		new SpriteHandler();

		level = new Level("res/test.png");
		level.setPlayer(new Player(16 * 5, 16 * 5));

		init();
		loop();

		Display.destroy();
	}

	public void init() throws IOException {
		glEnable(GL_TEXTURE_2D);

		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, Display.getWidth(), Display.getHeight(), 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		glEnable (GL_BLEND); glBlendFunc (GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);

	}

	public void loop() {
		t = startTime = System.currentTimeMillis();

		while (!Display.isCloseRequested()) {
			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

			render();

			totalFrames++;
			run();
			Display.update();
		}
	}

	public static void main(String[] args) throws IOException {
		new Main().start();
	}

	private void render() {
		level.render();

		totalFrames++;
	}

	private void run() {
		if (System.currentTimeMillis() - t > (double) 1000 / 60) {
			update();

			t += (double) 1000 / 60;
		}
	}

	private void update() {
		level.update();
	}
}