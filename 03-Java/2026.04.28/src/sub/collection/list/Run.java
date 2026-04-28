package sub.collection.list;

import java.util.List;
import java.util.ArrayList;

public class Run {
    public static void main(String[] args) {
        //   1. 직원 2명을 생성하여 List에 저장하시오.
        //   2. 전체 직원을 출력하시오.

        Employee e1 = new Employee();
        e1.setId("lisa");
        e1.setPw("123456");
        e1.setName("리사");
        e1.setAge(25);
        e1.setSalary(3000);
        e1.setGender('F');

        Employee e2 = new Employee();
        e2.setId("jenny");
        e2.setPw("abcdef");
        e2.setName("제니");
        e2.setAge(26);
        e2.setSalary(3500);
        e2.setGender('F');

        List<Employee> list = new ArrayList<>();
        list.add(e1);
        list.add(e2);

        for(Employee e : list){
            System.out.println(e);
        }
        //   3. id가 "lisa"인 직원을 조회하시오.

        for(Employee e : list) {
            if (e.getId().equals("lisa")) {
                System.out.println(e);
            }
        }
        //   4. lisa의 급여를 4000으로 수정하시오.

        for(Employee e : list) {
            if (e.getId().equals("lisa")) {
                e.setSalary(4000);
                System.out.println(e);
            }
        }
        //   5. id가 "jenny"인 직원을 삭제하시오.

        for (int i = 0; i < list.size(); i++){
            if (list.get(i).getId().equals("jenny")){
                list.remove(i);
                break;
            }
        }
        //   6. 최종 직원 목록을 출력하시오.

        for(Employee e : list){
            System.out.println(e);
        }

        System.out.println("==========");
        System.out.println(list);
    }
}
