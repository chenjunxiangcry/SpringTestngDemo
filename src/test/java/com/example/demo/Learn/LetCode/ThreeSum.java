package com.example.demo.Learn.LetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ThreeSum {
    public static List<List<Integer>> threeSumBaoli(int[] nums) {
        List<List<Integer>> ls = new ArrayList<>();
        List<List<Integer>> lsend = new ArrayList<>();

        for(int i = 0; i <nums.length-2;i++){
            int x = nums[i];
            for(int j = i+1;j < nums.length-1;j++){
                int y = nums[j];
                for(int k = j+1; k < nums.length;k++){
                    int z = nums[k];
                    if(y+z == -x){
                        System.out.println("x is "+x+ " y is "+y +" z is "+z);
                        //System.out.println("i is "+i+ " j is "+j +" k is "+k);
                        ls.add(Arrays.asList(x,y,z));
                    }
                }
            }
        }
        boolean flagzero = false;
        int countZero = 0;
        for(int i =0; i < ls.size();i++){
            boolean flag =false;
            for(int j = i+1;j<ls.size();j++){
                if(ls.get(j).contains(ls.get(i).get(0)) && ls.get(j).contains(ls.get(i).get(1))&& ls.get(j).contains(ls.get(i).get(2))){
                    // 确保当有三个0的时候 会丢失部分数据
                    if(ls.get(i).get(0) == 0 && ls.get(i).get(1)==0 && ls.get(i).get(2)==0){
                        continue;
                    }
                    flag = true;
                    System.out.println("find duplicated array");
                    System.out.println(ls.get(j));
                    System.out.println(ls.get(i));
                }
            }
            if(flag == false){
                if(ls.get(i).get(0) == 0 && ls.get(i).get(1)==0 && ls.get(i).get(2)==0 ){
                    flagzero = true;
                }else{
                    flagzero = false;
                }
                if(flagzero && countZero == 0){
                    lsend.add(ls.get(i));
                    countZero++;
                }else if(!flagzero) {
                    lsend.add(ls.get(i));
                }else if (flagzero && countZero > 0){
                    System.out.println("exist 0 alreay");
                    System.out.println(ls.get(i));

                }

            }
        }
        System.out.println(ls);
        return lsend;

    }

    public static void findDuplitated(List<List<Integer>> ls ){
        for(int i =0; i < ls.size()-1;i++){
            boolean flag =false;
            for(int j = i+1;j<ls.size();j++){
                if(ls.get(j).contains(ls.get(i).get(0)) && ls.get(j).contains(ls.get(i).get(1))){
                    flag = true ;
                    System.out.println("find duplicated array");
                    System.out.println(ls.get(j));
                    System.out.println(ls.get(i));
                    break;


                }
            }

        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ls = new ArrayList<>();
        Arrays.sort(nums);
        System.out.println(nums[0]);
        for(int i=0; i< nums.length-2;i++){
            if(nums[i] >0){
                System.out.println("nums");
                break;
            }
            if(nums[i] == nums[i+1]){
                continue;
            }
            int R = nums.length-1;
            int L= i+1;
            for(;L<R;L++){
                if(nums[i]+nums[L]+nums[R] == 0){
                    List<Integer> e = new ArrayList<>();
                    e.add(nums[i]);
                    e.add(nums[L]);
                    e.add(nums[R]);
                    ls.add(e);
                }
                R--;


            }

        }

        return ls;
    }

    public static int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int result = 0;
        if(nums.length < 3 ){return 0;}
        for(int i =0; i < nums.length-2; i++){
            int L=i+1;
            int R=nums.length-1;
            while(L<R){
                if(nums[i]+nums[L]+nums[R]<target){
                    result+=R-L;
                    L++;
                }else{
                    R--;
                }

            }



        }
        return result;
    }
    public static void main(String[] args){

       int[] array = new int[]{-1,0,1,2,-1,-4};
      // array = new int[]{13,4,-6,-7,-15,-1,0,-1,0,-12,-12,9,3,-14,-2,-5,-6,7,8,2,-4,6,-5,-10,-4,-9,-14,-14,12,-13,-7,3,7,2,11,7,9,-4,13,-6,-1,-14,-12,9,9,-6,-11,10,-14,13,-2,-11,-4,8,-6,0,7,-12,1,4,12,9,14,-4,-3,11,10,-9,-8,8,0,-1,1,3,-15,-12,4,12,13,6,10,-4,10,13,12,12,-2,4,7,7,-15,-4,1,-15,8,5,3,3,11,2,-11,-12,-14,5,-1,9,0,-12,6,-1,1,1,2,-3};
      // System.out.println(threeSum(array));
       array = new int[]{0,-4,-1,1,-1,2};
       System.out.println(threeSumSmaller(array,-5));

//       Integer[] array1 = new Integer[]{-2,0,2};
//       Integer[] array2 = new Integer[]{-2,-2,4};
//       List<List<Integer>> ls = new ArrayList<>();
//       ls.add(Arrays.asList(array1));
//       ls.add(Arrays.asList(array2));
//       findDuplitated(ls);

    }
}
