package sub.object.c_etc.prameter;

import java.util.Arrays;

public class ParameterTest {


    /* 메소드의 파라미터 선언부에는 다양한 종류의 값을 인자로 전달하며 호출할 수 있다.
     *
     * 매개변수(parameter)로 사용 가능한 자료형
     * 1. 기본자료형
     * 2. 배열
     * 3. 객체
     * 4. 가변인자
     * */


    // 1. 기본자료형 (값 전달)
    public void test1(int num){
        System.out.println("기본자료형 전달: " + num);
    }


    // 2. 배열 전달 (주소값 전달)
    // 인자로 전달되는 배열은 얕은복사 , 서로 동일한 배열을 가리키고있다( 얕은복사 )
    public void test2(int[] arr){

        System.out.println("변경전 배열"+ Arrays.toString(arr));

        arr[0] = 99;
        System.out.println("변경후 배열"+ Arrays.toString(arr));
    }

    // 3. 객체 전달 (주소값 전달)
    //인자로 전달되는 객체는 동일한 인스턴스를 가리킨다.( 얕은복사 )
    public void test3(RectAngle rectAngle){
        System.out.println(rectAngle);
        /* 사각형의 넓이와 둘레 출력 */
        System.out.println("변경 전 사각형의 넓이와 둘레 ========================");
        rectAngle.calcArea();
        rectAngle.calcRound();

        /* 사각형의 너비와 높이를 변경 */
        rectAngle.setWidth(100);		//자동형변환 적용됨
        rectAngle.setHeight(100);

        /* 변경 후 사각형의 넓이와 둘레 출력 */
        System.out.println("변경 후 사각형의 넓이와 둘레 ========================");
        rectAngle.calcArea();
        rectAngle.calcRound();


    }

    // 4. 가변인자 (배열로 처리됨)- 매개변수의 마지막에 사용 ,
//    public void test4(String...hobby){
//        System.out.println(Arrays.toString(hobby));
//    }
    public void test4(String name, String...hobby){
        System.out.println("이름 : " + name);
        System.out.println("취미의 갯수 : " + hobby.length);
        System.out.print("취미 : ");

        System.out.println(Arrays.toString(hobby));
    }


}
