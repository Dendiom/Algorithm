package TestOne;




public class Five {

    public static int manacherLength(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            stringBuilder.append("#").append(s.charAt(i));
        }
        String formalString = stringBuilder.append("#").toString();
        int lens = formalString.length();
        int[] container = new int[lens];
        int maxPosition = 0;
        int maxRight = 0;
        for (int i = 0; i < lens; i++) {
            //在最右端的右边，初始化为1
            if (i >= maxRight) {
                container[i] = 1;
            } else {
                //在左边有两种情况
                container[i] = Math.min(maxRight - i, container[2 * maxPosition - i]);
            }
            System.out.println("position: " + i + " " + container[i]);
            //扩展
            while (i + container[i] < lens && i - container[i] >= 0 && (formalString.charAt(i - container[i] ) == formalString.charAt(i + container[i]))) {
                container[i]++;
            }
            if (container[i] >= container[maxPosition]) {
                maxPosition = i;
                maxRight = maxPosition + container[maxPosition];
            }
        }
        return container[maxPosition] - 1;
    }

    public static String manacher(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            stringBuilder.append("#").append(s.charAt(i));
        }
        String formalString = stringBuilder.append("#").toString();
        int lens = formalString.length();
        int[] container = new int[lens];
        int maxPosition = 0;
        int maxRight = 0;
        for (int i = 0; i < lens; i++) {
            //在最右端的右边，初始化为1
            if (i >= maxRight) {
                container[i] = 1;
            } else {
                //在左边有两种情况
                container[i] = Math.min(maxRight - i, container[2 * maxPosition - i]);
            }
            //扩展
            while (i + container[i] < lens && i - container[i] >= 0 && (formalString.charAt(i - container[i] ) == formalString.charAt(i + container[i]))) {
                container[i]++;
            }
            if (container[i] >= container[maxPosition]) {
                maxPosition = i;
                maxRight = maxPosition + container[maxPosition];
            }
        }
//        if(s.length()%2 == 0)
//            return s.substring((maxPosition - container[maxPosition] + 1)/2,maxRight/2);
        return s.substring((maxPosition - container[maxPosition] + 1)/2,maxRight/2);
    }

    public static void main(String[] args) {
        String test = "abab";
        int ans = manacherLength(test);
        System.out.println(ans);
        System.out.println(manacher(test));

    }
}
