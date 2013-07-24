package bot.classHolder;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public abstract @interface Anotation {
	String Name();

	String Version();

	String Author();

	String Description();

}
