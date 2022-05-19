public class taxi {
    String taxi_Num;
    int gas_Amount;
    int cur_Speed;
    String destination;
    int base_Distance;
    int alpha_Distance;
    int total_Distance;
    int base_Price;
    int extra_unit_Price;
    boolean status;


    // 생성자 만들기
    public taxi(String taxi_Num, int gas_Amount, int cur_Speed, String destination, int base_Distance, int alpha_Distance, int total_Distance, int base_Price, int extra_unit_Price, boolean status) {
        this.taxi_Num = taxi_Num;
        this.gas_Amount = gas_Amount;
        this.cur_Speed = cur_Speed;
        this.destination = destination;
        this.base_Distance = base_Distance;
        this.alpha_Distance = alpha_Distance;
        this.total_Distance = total_Distance;
        this.base_Price = base_Price;
        this.extra_unit_Price = extra_unit_Price;
        this.status = status;
    }


    //디폴트값 있는 생성자 생성
    public taxi(String taxi_Num) {
        this(taxi_Num, 100, 60, "", 2000, 0, 0, 4000, 1, true);
    }


    //운행상태 변경
    public void taxi_status_Change() {
        status = !status;
    }


    //승객 탑승 & 운행시작
    public void taxi_get_On(int x, String destination) {
        taxi_gas_Check();
        if (status == true && gas_Amount>10) {
            taxi_status_Change();
            System.out.println("승객이 탑승했습니다. 목적지는" + destination + "이며 도착지까지 총 거리는 " + x + "m 입니다.");
            System.out.println("택시 상태를 일반에서 운행 중으로 변경했습니다. 출발합니다.");
            this.destination = destination;
            alpha_Distance = x > base_Distance?  x-base_Distance : 0;
            total_Distance += x;
        } else {
            System.out.println("탑승 불가 차량입니다.");
        }
    }


    //속도 변경
    public void taxi_change_Speed(int x) {
        cur_Speed += x;
        System.out.println("속력을" + cur_Speed + "으로 변경했습니다");
    }

    //승객 하차, 요금결제
    public void taxi_get_Out() {
        if (!status) {
            System.out.println("택시가 목적지에 도착했습니다.요금은" + (base_Price + (alpha_Distance * extra_unit_Price)) + "입니다. 안녕히 가세요");
            alpha_Distance = 0; // reset
            taxi_status_Change(); // 운행상태에서 일반으로 변경
        } else {
            System.out.println("주유량 문제로 운행을 못하게 돼서 죄송합니다.");
        }
    }

    //주유량 체크 (거리량으로 체크함)
    public void taxi_gas_Check() {
        if (5000 < total_Distance) {
            gas_Amount = 10;
            System.out.println("현재 주유량 10으로 운행 불가하며 운행상태를 일반으로 변경했습니다.");
            status = true;
        } else {
            gas_Amount = 100;
            System.out.println("현재 주유량 양호합니다.");
        }
    }
}





