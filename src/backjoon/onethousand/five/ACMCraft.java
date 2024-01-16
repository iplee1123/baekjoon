package backjoon.onethousand.five;


import java.util.*;

public class ACMCraft {

    /**
     * https://www.acmicpc.net/problem/1005
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = 0;
        int testCaseCount = sc.nextInt();
        int buildingCount, order; //건물 개수, 건설 순서
        int[] intArr, load;
        Map<Integer, Building> buildingMap = new HashMap<>();
        Building a, b;

        while(num < testCaseCount) {
            intArr = splitConvert(sc.nextLine());
            buildingCount = intArr[0];
            order = intArr[1];
            intArr = splitConvert(sc.nextLine());
            for(int i = 0; i < buildingCount; i++) {
                buildingMap.put(i+1, new Building(intArr[i]));
            }
            for(int i = 0; i < order; i++) {
                load = splitConvert(sc.nextLine());
                a = buildingMap.get(load[0]);
                b = buildingMap.get(load[1]);
                if (a.nextBuildingSec < b.sec)
                    a.nextBuildingSec = b.sec;
            }
            num ++;
        }

    }

    static int[] splitConvert(String str) {
        String[] strArr = str.split(" ");
        int[] intArr = new int[strArr.length];
        for(int i = 0; i < strArr.length; i++)
            intArr[i] = Integer.parseInt(strArr[i]);
        return intArr;
    }

    static class Building {
        int sec;
        int nextBuildingSec = 0;

        public Building(int sec) {
            this.sec = sec;
        }
    }
}
/*

2
4 4
10 1 100 10
1 2
1 3
2 4
3 4
4
8 8
10 20 1 5 8 7 1 43
1 2
1 3
2 4
2 5
3 6
5 7
6 7
7 8
7

*
* */