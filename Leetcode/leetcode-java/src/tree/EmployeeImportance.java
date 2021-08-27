package tree;

import java.util.HashMap;
import java.util.List;

// Example 1:

// Input: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
// Output: 11
// Explanation:
// Employee 1 has importance value 5, and he has two direct subordinates: 
// employee 2 and employee 3. They both have importance value 3. 
// So the total importance value of employee 1 is 5 + 3 + 3 = 11.
 

// Note:

// One employee has at most one direct leader and may have several subordinates.
// The maximum number of employees won't exceed 2000.



/*
Definition for Employee.
*/
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};

public class EmployeeImportance {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        return helper(map, id);

    }

    private int helper(HashMap<Integer, Employee> map, int id) {
        Employee e = map.get(id);
        int res = e.importance;

        for(int i = 0; i < e.subordinates.size(); i++) {
            Integer subId = e.subordinates.get(i);
            res += helper(map, subId);
        }
        return res;
    }
}