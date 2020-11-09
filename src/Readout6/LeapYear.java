package Readout6;

public class LeapYear {

    /**
     * Liste von bekannten Schaltjahren zum testen.
     */
    static final int[] testList = new int[] {1404, 1408, 1412, 1416, 1420, 1424, 1428, 1432, 1436, 1440, 1444, 1448, 1452, 1456, 1460, 1464, 1468, 1472, 1476, 1480, 1484, 1488, 1492, 1496, 1504, 1508, 1512, 1516, 1520, 1524, 1528, 1532, 1536, 1540, 1544, 1548, 1552, 1556, 1560, 1564, 1568, 1572, 1576, 1580, 1584, 1588, 1592, 1596, 1600, 1604, 1608, 1612, 1616, 1620, 1624, 1628, 1632, 1636, 1640, 1644, 1648, 1652, 1656, 1660, 1664, 1668, 1672, 1676, 1680, 1684, 1688, 1692, 1696, 1704, 1708, 1712, 1716, 1720, 1724, 1728, 1732, 1736, 1740, 1744, 1748, 1752, 1756, 1760, 1764, 1768, 1772, 1776, 1780, 1784, 1788, 1792, 1796, 1804, 1808, 1812, 1816, 1820, 1824, 1828, 1832, 1836, 1840, 1844, 1848, 1852, 1856, 1860, 1864, 1868, 1872, 1876, 1880, 1884, 1888, 1892, 1896, 1904, 1908, 1912, 1916, 1920, 1924, 1928, 1932, 1936, 1940, 1944, 1948, 1952, 1956, 1960, 1964, 1968, 1972, 1976, 1980, 1984, 1988, 1992, 1996, 2000, 2004, 2008, 2012, 2016, 2020, 2024, 2028, 2032, 2036, 2040, 2044, 2048, 2052, 2056, 2060, 2064, 2068, 2072, 2076, 2080, 2084, 2088, 2092, 2096, 2104, 2108, 2112, 2116, 2120, 2124, 2128, 2132, 2136, 2140, 2144, 2148, 2152, 2156, 2160, 2164, 2168, 2172, 2176, 2180, 2184, 2188, 2192, 2196, 2204, 2208, 2212, 2216, 2220, 2224, 2228, 2232, 2236, 2240, 2244, 2248, 2252, 2256, 2260, 2264, 2268, 2272, 2276, 2280, 2284, 2288, 2292, 2296, 2304, 2308, 2312, 2316, 2320, 2324, 2328, 2332, 2336, 2340, 2344, 2348, 2352, 2356, 2360, 2364, 2368, 2372, 2376, 2380, 2384, 2388, 2392, 2396, 2400 };

    /**
     * Start Methode.
     * @param args ; nichts erwartet.
     */
    public static void main(String[] args) {
        testLeapYearsFromTo(1400,2400);
        testLeapYearsByList();
    }

    /**
     * Testet alle Schaltjahre von {from} bis {to}
     * @param from erstes Jahr zum suchen
     * @param to letztes Jahr zum suchen (inklusive)
     */
    public static void testLeapYearsFromTo(int from,int to){
        for (int i = from; i <= to; i++) {
            System.out.println(""+i+": "+(isLeapYear(i)? "Schaltjahr" :"kein Schaltjahr"));
        }
    }

    /**
     * Testet die Schaltjahre, die in der {testList} drin sind.
     */
    public static void testLeapYearsByList(){
        for(int i = 0; i< testList.length; i++){
            if(isLeapYear(testList[i])){
                System.out.println("Fehler: "+i+"("+ testList[i]+") ist kein Schaltjahr.");
            }
        }
    }

    /**
     * Testet ein Schaltjahr in einer Zeile.
     * @param i das Jahr, welches getestet werden muss.
     * @return true | false ob es sich um ein Schaltjahr handelt.
     */
    public static boolean isLeapYearOneline(int i) {
        return i % 4 == 0 && (i % 100 != 0 || i % 400 == 0);
    }

    /**
     * Testet ein Schaltjahr mit einfacheren if statements.
     * @param i das Jahr, welches getestet werden muss.
     * @return true | false ob es sich um ein Schaltjahr handelt.
     */
    public static boolean isLeapYear(int i) {
        if (i % 4 == 0) { // durch 4 Teilbar
            if (i % 100 != 0) { // nicht durch 100 Teilbar
                return true;
            }
            if (i % 400 == 0) { // durch 400 Teilbar
                return true;
            }
        }
        return false;
    }

}
