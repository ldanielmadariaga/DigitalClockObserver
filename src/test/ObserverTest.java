import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ObserverTest {

	private MockTimeSource source;
	private MockTimeSink sink;

	@Before
	public void setUp() {
		source = new MockTimeSource();
		sink = new MockTimeSink(source);
		source.registerObserver(sink);
	}

	private void assertSinkEquals(MockTimeSink sink, int hours, int minutes, int seconds) {
		assertEquals(hours, sink.getHours());
		assertEquals(minutes, sink.getMinutes());
		assertEquals(seconds, sink.getSeconds());
	}

	@Test
	public void testTimeChange() {
		source.setTime(3, 4, 5);
		assertSinkEquals(sink, 3, 4, 5);

		source.setTime(7, 8, 9);
		assertSinkEquals(sink, 7, 8, 9);
	}

	@Test
	public void testMultipleSinks() {
		MockTimeSink sink2 = new MockTimeSink(source);
		source.registerObserver(sink2);

		source.setTime(12, 13, 14);
		assertSinkEquals(sink, 12, 13, 14);
		assertSinkEquals(sink2, 12, 13, 14);
	}
}
