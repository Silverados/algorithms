# 回溯算法

## 划分

### 组合问题
> N个数里挑出k个数得到组合


### 排列
> N个数里按某种顺序得到k个数的组合


### 子集问题
> 一个


## 模板

```java
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        sol();
    }

    public static void sol() {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtrace(res, temp, 0);
    }

    private static void backtrace(List<List<Integer>> res, List<Integer> temp, int index) {
        if (终止条件) {
            res.add(new ArrayList<>(temp));
            return;
        }
        
        for (int i = index; i < len; i++) {
            // do something
            backtrace(res, temp, i + 1);
            // backtrace
        }
    }
}
```

