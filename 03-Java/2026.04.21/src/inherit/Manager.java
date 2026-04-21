package inherit;

public class Manager extends Employee{
    //필드 4개
    //매서드
    //Object가 상속한 매서드들
    //Employee가 상속한 매서드들
    private int bonus; //필드 5개

    public Manager(String name, String address, int salary, String rrn, int bonus) {
        //무조건 부모의 생성자를 호출하는 메서드는 첫번째 줄에 와야함
        super(name, address, salary, rrn);
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public void test(){
        System.out.println("관리 감독");
    }

    //재정의한 매서드
    @Override
    public String toString() {
        return super.toString() + " " + bonus;
    }
}
