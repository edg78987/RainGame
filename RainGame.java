/**
 * @author edguzma2, allenxg2
 */
public class RainGame {

	public static void main(String[] args) {
		/*	type in the number that's falling down.
		*	0. The numbers always fall vertically and 
		*	don't reset back to the top if they fall past 
		*	the bottom of the screen"
		*	1. They don't like the flicker (hint:  you can 
		*	use Zen.flipBuffer - see the PongGame)
		*	2. It's possible to make the game die with an 
		*	exception:
		*	Exception in thread "main" java.lang.StringIndexOutOfBoundsException: String index out of range: 0
		*	at java.lang.String.charAt(String.java:686)
		*	at RainGame.main(RainGame:41)
		*	3. It would be nice if the game got harder and more interesting.
		*	e.g Some more visual distractions.
		*	4. It would be useful if you could skip the easiest levels. */
	
		int x=0, y=0, dx=0, dy=0, score = 0;
		String text = "";
		long startTime =System.currentTimeMillis();
		
		Zen.setFont("Helvetica-64");
		while (Zen.isRunning()) {

			if (text.length() == 0) {
				x = 0;
				y = Zen.getZenHeight() / 2;
				dx = 2;
				dy = 0;
				text = "" + (int) (Math.random() * 999);
				long elapsed = System.currentTimeMillis() - startTime;
				startTime = System.currentTimeMillis();
				score += 3000 / elapsed;
			}
			Zen.setColor(255, 0, 255);
			Zen.fillRect(0, 0, Zen.getZenWidth(), Zen.getZenHeight());

			Zen.setColor(0, 255, 0);
			Zen.drawText(text, x, y);
			
			Zen.drawText("Level: 0",10,30);
			Zen.drawText("Score: 0",10,60);
			
			x += dx;
			y += dy;
			
			// Find out what keys the user has been pressing.
			String user = Zen.getEditText();
			// Reset the keyboard input to an empty string
			// So next iteration we will only get the most recently pressed keys.
			Zen.setEditText("");
			
			for(int i=0;i < user.length();i++) {
				char c = user.charAt(i);
				if(c == text.charAt(0))
					text = text.substring(1,text.length()); // all except first character
			}
			
			Zen.sleep(90);// sleep for 90 milliseconds

		}
	}

}
