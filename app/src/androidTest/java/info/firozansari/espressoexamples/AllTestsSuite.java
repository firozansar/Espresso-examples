package info.firozansari.espressoexamples;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Runs all instrumentation tests from one place
 */
@RunWith (Suite.class)
@Suite.SuiteClasses ({
		CustomIntentTests.class,
		DeviceRotationTests.class,
		HierarchyActivityTests.class,
		MainActivityTests.class,
		NavigationDrawerActivityTests.class,
		PositionActivityTests.class,
		SwitchActivityTests.class,
		ViewPagerActivityTests.class
})
public class AllTestsSuite {
}
