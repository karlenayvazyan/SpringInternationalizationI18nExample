import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by karlen on 5/19/17.
 */
public class InternationalizationTest {

    private static MessageSource messageSource;

    @BeforeClass
    public static void setUp() {
        messageSource = new ClassPathXmlApplicationContext("application-contex.xml");
    }

    @Test
    public void testInternationalization() {
        String message = messageSource.getMessage("message", null, "Default", null);
        assertNotNull(message);
        String expectedMessage = "Alligators rock!";
        assertEquals(expectedMessage, message);
    }

    @Test
    public void testInternationalizationExceptions() {
        String message = messageSource.getMessage("argument.required", new Object[] {"userDao"}, "Required", null);
        assertNotNull(message);
        String expectedMessage = "The userDao argument is required.";
        assertEquals(expectedMessage, message);
    }

    @Test
    public void testInternationalizationExceptionsLocal() {
        String message = messageSource.getMessage("argument.required", new Object[] {"userDao"}, "Required", Locale.UK);
        System.out.println(message);
        assertNotNull(message);
        String expectedMessage = "Ebagum lad, the userDao argument is required, I say, required.";
        assertEquals(expectedMessage, message);
    }
}
