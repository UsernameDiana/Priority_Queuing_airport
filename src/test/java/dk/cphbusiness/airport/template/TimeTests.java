package dk.cphbusiness.airport.template;

import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;

public class TimeTests {
  
  @Test
  public void testToString() {
    Time time = new Time(36_902_000);
    assertThat(time.toString(), is("10:15:02"));
    }
  }
