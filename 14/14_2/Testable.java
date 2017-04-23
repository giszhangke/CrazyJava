import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.Documented;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;

//@Retation(value=RetationPolicy.NTIME)
//@Target(value=ElementType.METHOD)
@Retention(value=RetentionPolicy.RUNTIME)
@Target(value=ElementType.METHOD)
@Documented
public @interface Testable {
	
}
