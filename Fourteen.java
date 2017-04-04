package TestOne;


public class Fourteen {

    public static String commonPre(String[] strs){
        String ans = "";
        int count = strs.length - 1;
        if(count == 0)
            return strs[0];
        if(count<0)
            return ans;
        int index = 0;
        outer:
        while (true) {
            int temp = 0;
            for (int i = 0; i < count; i++) {
                if (index >= strs[i].length() || index>= strs[i+1].length()) {
                    break outer;
                }
                if(strs[i].charAt(index) == strs[i+1].charAt(index)) {
                    temp++;
                }else {
                    break outer;
                }
            }
            if(temp == count)
                ans = ans + strs[0].charAt(index);
            index++;
        }
        return ans;
    }

    public static String betterMethod(String[] strs){
        if(strs == null || strs.length == 0)
            return "";
        String pre = strs[0];
        int i = 1;
        while (i<strs.length){
            while (strs[i].indexOf(pre)!=0){
                pre = pre.substring(0,pre.length() - 1);
            }
            i++;
        }
        return pre;
    }

    public static void  main(String[] args){
        System.out.println(betterMethod(new String[]{"aca", "cba"}));
        System.out.println(betterMethod(new String[]{"abc","ab","agdg","aff"}));
    }
}
