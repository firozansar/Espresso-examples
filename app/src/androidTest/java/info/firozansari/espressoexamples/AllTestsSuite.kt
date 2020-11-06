package info.firozansari.espressoexamples

import org.junit.runner.RunWith
import org.junit.runners.Suite

/**
 * Runs all instrumentation tests from one place
 */
@RunWith(Suite::class)
@Suite.SuiteClasses(CustomIntentTests::class, HierarchyActivityTests::class, MainActivityTests::class, PositionActivityTests::class, SwitchFragmentTests::class, ViewPagerFragmentTests::class)
class AllTestsSuite