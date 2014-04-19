package com.windy.learn.guava.basic;

import com.google.common.base.*;
import com.google.common.collect.*;
import com.google.common.primitives.Ints;
import junit.framework.TestCase;
import org.junit.Assert;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 *
 * Created by yang.hua on 14-4-9.
 */
public class TestBasicUtilities extends TestCase {

    public void testMatcher() {
        CharMatcher ID = CharMatcher.DIGIT;
        String s = "123-0987-1232";
        System.out.println(s);
        System.out.println(ID.retainFrom(s));
        System.out.println(ID.replaceFrom(s, '='));
        System.out.println(ID.removeFrom(s));
        List list = Lists.newArrayList(1, 2, 2, 3, null, 4, 4, 5, 5, null);
        String joined = Joiner.on(",").useForNull("None").join(list);
        System.out.println(joined);
    }

    public void testPreconditions() {
        try {
            Preconditions.checkState(false, "faosdjfas");
            Assert.fail();
        } catch (Exception e) {

        }
    }

    public void testStopWatch() {
        Stopwatch watch = Stopwatch.createStarted();
        System.out.println(fib(30));
        System.out.println(watch.elapsed(TimeUnit.NANOSECONDS));
        System.out.println(watch.isRunning());
        watch.reset().start();
        System.out.println(fib(30));
        System.out.println(watch.elapsed(TimeUnit.NANOSECONDS));
        watch.stop();
    }

    public void testFP() {
        List<Integer> list = ImmutableList.of(1, 2, 3, 4, 22, 5, 11, 5, 6, 7, 78, 8, 8, 899, 10, 9, 0);
        List<String> older = FluentIterable.from(list).filter(new Predicate<Integer>() {
            @Override
            public boolean apply(Integer input) {
                return input % 2 == 0;
            }
        }).transform(Functions.toStringFunction())
                .skip(1)
                .toSortedList(new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return Ints.compare(Ints.tryParse(o1), Ints.tryParse(o2));
                    }
                });
        System.out.println(older);
        List<String> words = ImmutableList.of("abc", "JAVA", "PYTHON", "C", "C++", "GO", "GO", "MYSQL",
                "SCALA", "hadoop", "MYSQL", "yes", "hello", "good", "ERLANG", "PHP", "TORNADO", "JAVA");
        ;

        Multiset<String> multiSet = HashMultiset.create(
                Iterables.transform(
                        Iterables.filter(words,
                                new Predicate<String>() {
                                    @Override
                                    public boolean apply(String input) {
                                        return CharMatcher.JAVA_UPPER_CASE.matchesAllOf(input);
                                    }
                                }),
                        new Function<String, String>() {
                            @Override
                            public String apply(String input) {
                                return null;
                            }
                        })
        );

    }

    public void testOptional() {
        Optional<Integer> possible = Optional.of(5);
        assertTrue(possible.isPresent());
        assertEquals(Ints.tryParse("5"), possible.get());
        Optional op = getOptionalString(null);
        assertTrue(!op.isPresent());
    }

    public void testOrdering() {
        List<Integer> list = ImmutableList.of(1, 19, 3, 45, 5, 60, 2, 22, 12);
        Ordering<Integer> order = new Ordering<Integer>() {
            @Override
            public int compare(Integer left, Integer right) {
                return Ints.compare(left, right);
            }
        };
        System.out.println(order.sortedCopy(list));
    }

    public void testObjects() {
        assertTrue(Objects.equal("a", "a")); // returns true
        assertTrue(!Objects.equal(null, "a")); // returns false
        assertTrue(!Objects.equal("a", null)); // returns false
        assertTrue(Objects.equal(null, null)); // returns true
        assertEquals(1, ComparisonChain.start().compare("a", " b").result());
        System.out.println(Objects.toStringHelper(this).add("name", "test toString").addValue(false).toString());
    }

    public void testCollections() {
        Map<String, String> map = ImmutableMap.of("a", "b", "c", "d", "a", "b", "c", "d", "a", "b");

        System.out.println(map);
        //This is like an ArrayList<E> without an ordering constraint: ordering does not matter.
        //This is like a Map<E, Integer>, with elements and counts.
//        Multiset<String> ms = HashMultiset.create();
//        Multimap<K, V> map = HashMultimap.create();
//        BiMap biMap = HashBiMap.create();
//        Table
//          ClassToInstanceMap
        RangeSet<Integer> rangeSet = TreeRangeSet.create();
        rangeSet.add(Range.closed(1, 10)); // {[1, 10]}
        rangeSet.add(Range.closedOpen(11, 15)); // disconnected range: {[1, 10], [11, 15)}
        rangeSet.add(Range.closedOpen(15, 20)); // connected range; {[1, 10], [11, 20)}
        rangeSet.add(Range.openClosed(0, 0)); // empty range; {[1, 10], [11, 20)}
        rangeSet.remove(Range.open(5, 10)); // splits [1, 10]; {[1, 5], [10, 10], [11, 20)}

        RangeMap<Integer, String> rangeMap = TreeRangeMap.create();
        rangeMap.put(Range.closed(1, 10), "foo"); // {[1, 10] => "foo"}
        rangeMap.put(Range.open(3, 6), "bar"); // {[1, 3] => "foo", (3, 6) => "bar", [6, 10] => "foo"}
        rangeMap.put(Range.open(10, 20), "foo"); // {[1, 3] => "foo", (3, 6) => "bar", [6, 10] => "foo", (10, 20) => "foo"}
        rangeMap.remove(Range.closed(5, 11)); // {[1, 3] => "foo", (3, 5) => "bar", (11, 20) => "foo"}

    }

    public Optional<String> getOptionalString(String x) {
        return Optional.fromNullable(x);
    }

    private int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

}