package contests.c20250406;

import java.util.*;

/**
 * 6242. 二叉搜索树最近节点查询
 * @author Chen Runwen
 * @difficulty M 1
 * @status AC21
 * @time 2022/11/20 10:36
 */

public class P2 {
    class Router {
        public class Package {
            public int source;
            public int destination;
            public int timestamp;

            public Package(int source, int destination, int timestamp) {
                this.source = source;
                this.destination = destination;
                this.timestamp = timestamp;
            }

            public int[] toArray() {
                return new int[]{source, destination, timestamp};
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Package aPackage = (Package) o;
                return source == aPackage.source && destination == aPackage.destination && timestamp == aPackage.timestamp;
            }

            @Override
            public int hashCode() {
                return Objects.hash(source, destination, timestamp);
            }
        }

        private int memoryLimit;
        private ArrayDeque<Package> queue;
        private Map<Integer, ArrayDeque<Package>> dest;
        private Set<Package> set;

        public Router(int memoryLimit) {
            this.memoryLimit = memoryLimit;
            queue = new ArrayDeque<>(memoryLimit);
            dest = new HashMap<>();
            set = new HashSet<>(memoryLimit);
        }

        public boolean addPacket(int source, int destination, int timestamp) {
            Package pack = new Package(source, destination, timestamp);
            if (set.contains(pack)) {
                return false;
            }
            if (queue.size() == memoryLimit) {
                Package old = queue.removeFirst();
                set.remove(old);
                dest.get(old.destination).removeFirst();
            }
            queue.addLast(pack);
            set.add(pack);
            dest.computeIfAbsent(destination, key -> new ArrayDeque<>()).addLast(pack);
            return true;
        }

        public int[] forwardPacket() {
            if (queue.isEmpty()) {
                return new int[]{};
            }
            Package old = queue.removeFirst();
            set.remove(old);
            dest.get(old.destination).removeFirst();
            return old.toArray();
        }

        public int getCount(int destination, int startTime, int endTime) {
            ArrayDeque<Package> destPacks = dest.get(destination);
            if (destPacks == null || destPacks.isEmpty()) return 0;
            Package[] array = new Package[destPacks.size()];
            destPacks.toArray(array);

            // (lo, hi]
            if (array[0].timestamp > endTime || array[array.length-1].timestamp < startTime) {
                return 0;
            }
            int lo = -1, hi = array.length-1;
            while (hi-lo >1) {
                int mid = (hi+lo)/2;
                if (array[mid].timestamp>=startTime) {
                    hi=mid;
                } else {
                    lo = mid;
                }
            }
            int start = hi;

            // [lo, hi)
            lo = 0;
            hi = array.length;
            while (hi-lo >1) {
                int mid = (hi+lo)/2;
                if (array[mid].timestamp<=endTime) {
                    lo = mid;
                } else {
                    hi = mid;
                }
            }
            int end = lo;
            return end - start + 1;
        }
    }
}
