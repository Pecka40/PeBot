package bot.methodes;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import bot.methodes.Keyboard.KEYS;

public class Keyboard {

	private Robot r;

	public enum KEYS {
		ENTER(KeyEvent.VK_ENTER), BACKSPACE(KeyEvent.VK_BACK_SPACE), Q(
				KeyEvent.VK_Q), W(KeyEvent.VK_W), E(KeyEvent.VK_E), R(
				KeyEvent.VK_R), T(KeyEvent.VK_T), Y(KeyEvent.VK_Y), U(
				KeyEvent.VK_U), I(KeyEvent.VK_I), O(KeyEvent.VK_O), P(
				KeyEvent.VK_P), A(KeyEvent.VK_A), S(KeyEvent.VK_S), D(
				KeyEvent.VK_D), F(KeyEvent.VK_F), G(KeyEvent.VK_G), H(
				KeyEvent.VK_H), J(KeyEvent.VK_J), K(KeyEvent.VK_K), L(
				KeyEvent.VK_L), Z(KeyEvent.VK_Z), X(KeyEvent.VK_X), C(
				KeyEvent.VK_C), V(KeyEvent.VK_V), B(KeyEvent.VK_B), N(
				KeyEvent.VK_N), M(KeyEvent.VK_M), SEMI_COLON(
				KeyEvent.VK_SEMICOLON), STAR(KeyEvent.VK_ASTERISK), LEFT_BRACKET(
				KeyEvent.VK_OPEN_BRACKET), RIGHT_BRACKET(
				KeyEvent.VK_CLOSE_BRACKET), SPACE(KeyEvent.VK_SPACE), SHIFT(
				KeyEvent.VK_SHIFT), EXLAMATION_MARK(
				KeyEvent.VK_E), FULL_STOP(KeyEvent.VK_PERIOD), CTRL(
				KeyEvent.VK_CONTROL),EIGHT(KeyEvent.VK_8),ONE(KeyEvent.VK_1),COMMA(KeyEvent.VK_COMMA);

		private int value;

		private KEYS(int value) {
			this.value = value;
		}
	}

	public Keyboard(Robot robot) {
		r = robot;

	}

	public void writeString(String s) {
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			switch (c) {
			case 'q':
				pressKey(KEYS.Q);
				break;
			case 'w':
				pressKey(KEYS.W);
				break;
			case 'e':
				pressKey(KEYS.E);
				break;
			case 'r':
				pressKey(KEYS.R);
				break;
			case 't':
				pressKey(KEYS.T);
				break;
			case 'y':
				pressKey(KEYS.Y);
				break;
			case 'u':
				pressKey(KEYS.U);
				break;
			case 'i':
				pressKey(KEYS.I);
				break;
			case 'o':
				pressKey(KEYS.O);
				break;
			case 'p':
				pressKey(KEYS.P);
				break;
			case 'a':
				pressKey(KEYS.A);
				break;
			case 's':
				pressKey(KEYS.S);
				break;
			case 'd':
				pressKey(KEYS.D);
				break;
			case 'f':
				pressKey(KEYS.F);
				break;
			case 'g':
				pressKey(KEYS.G);
				break;
			case 'h':
				pressKey(KEYS.H);
				break;
			case 'j':
				pressKey(KEYS.J);
				break;
			case 'k':
				pressKey(KEYS.K);
				break;
			case 'l':
				pressKey(KEYS.L);
				break;
			case 'z':
				pressKey(KEYS.Z);
				break;
			case 'x':
				pressKey(KEYS.X);
				break;
			case 'c':
				pressKey(KEYS.C);
				break;
			case 'v':
				pressKey(KEYS.V);
				break;
			case 'b':
				pressKey(KEYS.B);
				break;
			case 'n':
				pressKey(KEYS.N);
				break;
			case 'm':
				pressKey(KEYS.M);
				break;
			case ' ':
				pressKey(KEYS.SPACE);
				break;
			case '*':
				//pressKey(KEYS.STAR);
				pressCombinedKey(KEYS.SHIFT,KEYS.EIGHT);
				break;
			case ';':
				pressKey(KEYS.SEMI_COLON);
				break;
			case 'Q':
				pressBigKey(KEYS.Q);
				break;
			case 'W':
				pressBigKey(KEYS.W);
				break;
			case 'E':
				pressBigKey(KEYS.E);
				break;
			case 'R':
				pressBigKey(KEYS.R);
				break;
			case 'T':
				pressBigKey(KEYS.T);
				break;
			case 'Y':
				pressBigKey(KEYS.Y);
				break;
			case 'U':
				pressBigKey(KEYS.U);
				break;
			case 'I':
				pressBigKey(KEYS.I);
				break;
			case 'O':
				pressBigKey(KEYS.O);
				break;
			case 'P':
				pressBigKey(KEYS.P);
				break;
			case 'A':
				pressBigKey(KEYS.A);
				break;
			case 'S':
				pressBigKey(KEYS.S);
				break;
			case 'D':
				pressBigKey(KEYS.D);
				break;
			case 'F':
				pressBigKey(KEYS.F);
				break;
			case 'G':
				pressBigKey(KEYS.G);
				break;
			case 'H':
				pressBigKey(KEYS.H);
				break;
			case 'J':
				pressBigKey(KEYS.J);
				break;
			case 'K':
				pressBigKey(KEYS.K);
				break;
			case 'L':
				pressBigKey(KEYS.L);
				break;
			case 'Z':
				pressBigKey(KEYS.Z);
				break;
			case 'X':
				pressBigKey(KEYS.X);
				break;
			case 'C':
				pressBigKey(KEYS.C);
				break;
			case 'V':
				pressBigKey(KEYS.V);
				break;
			case 'B':
				pressBigKey(KEYS.B);
				break;
			case 'N':
				pressBigKey(KEYS.N);
				break;
			case 'M':
				pressBigKey(KEYS.M);
				break;
			case '.':
				pressKey(KEYS.FULL_STOP);
				break;
			case '!':
				//pressKey(KEYS.EXLAMATION_MARK);
				pressCombinedKey(KEYS.SHIFT,KEYS.ONE);
				break;
			case ',':
				pressKey(KEYS.COMMA);
				break;
			}
		}
	}

	public void pressKey(KEYS key) {
		r.keyPress(key.value);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		r.keyRelease(key.value);
	}

	public void pressBigKey(KEYS key) {
		r.keyPress(KEYS.SHIFT.value);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		r.keyPress(key.value);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		r.keyRelease(key.value);
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		r.keyRelease(KEYS.SHIFT.value);
	}

	public void pressCombinedKey(KEYS bigKey,KEYS smallkey) {
		r.keyPress(bigKey.value);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		r.keyPress(smallkey.value);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		r.keyRelease(smallkey.value);
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		r.keyRelease(bigKey.value);
	}

}
