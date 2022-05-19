public class bus {
    int max_Passenger;
    int cur_Passenger;
    int total_Price;
    int price;
    String bus_Num;
    int gas_Amount;
    int cur_Speed;
    boolean status;


    //생성자 생성
    public bus(int max_Passenger, int cur_Passenger, int total_Price, int price, String bus_Num, int gas_Amount, int cur_Speed, boolean status) {
        this.max_Passenger = max_Passenger;
        this.cur_Passenger = cur_Passenger;
        this.total_Price = total_Price;
        this.price = price;
        this.bus_Num = bus_Num;
        this.gas_Amount = gas_Amount;
        this.cur_Speed = cur_Speed;
        this.status = status;
    }


    //디폴트값 있는 생성자 생성
    public bus(String bus_Num) {
        this(25, 0, 0, 1000, bus_Num, 100, 60, true);
    }


    //버스 상태 체크
    public void status_Check() {
        System.out.println("bus num" + bus_Num + "은 승객수" + cur_Passenger + "명이며 현재 속도" + cur_Speed + "로 운행 중입니다.");
    }


    //버스 상태 변경
    public void status_Change() {
        status = !status;
        if(status == true) {
            System.out.println("버스의 상태가 차고지행에서 운행으로 변경되었습니다");
        } else {
            System.out.println("버스의 상태가 운행중에서 차고지행으로 변경되었습니다.");
        }
    }


    //승객 탑승
    public void get_On(int x) {
        if (status == true){
        if (x + cur_Passenger < max_Passenger) {
            cur_Passenger += x;
            total_Price += price*x;
            System.out.println(x + "명이 탑승했습니다. 현재 승객은 총" + cur_Passenger + "명 입니다.");
        } else {
            System.out.println("최대 승객이 초과되었습니다 내려주세요");
        }
    } else {
        System.out.println("현재 해당 버스는 차고지행 상태입니다. 탑승하실 수 없습니다.");
    }}


    //승객 하차
    public void get_Out(int x) {
        gas_Check();
        if (x > cur_Passenger) {
            System.out.println("잘못 입력하셨습니다. 현재 인원수를 초과합니다.");
        } else {
            cur_Passenger -= x;
            System.out.println(x +"명이 하차했습니다. 현재 승객은 총" + cur_Passenger + "명 입니다.");
        }
    }


    //속도 변경
    public void change_Speed(int x) {
        gas_Check();
        if (gas_Amount > 10) {
            cur_Speed += x;
            System.out.print("속력을" + cur_Speed +"으로 변경했습니다");
        }
    }


    //주유량 체크
    //버스의 총 요금량이 많을수록 운행시간이 증가했고 주유량은 떨어지기에 그 개념으로 메서드 작성
    public void gas_Check() {
        if (15000 < total_Price && total_Price < 25000) {
            gas_Amount = 30;
            System.out.println("현재 주유량 30으로 주유량에 주의해주세요");
            System.out.println("총 요금은" + total_Price +"입니다.");
        } else if (25000 < total_Price) {
            gas_Amount = 10;
            System.out.println("현재 주유량 10이하로 운행을 중단하며 주유 바랍니다");
            System.out.println("총 요금은" + total_Price +"입니다.");
            status_Change();
        } else {
            gas_Amount = 100;
            System.out.println("현재 주유량 괜찮습니다");
            System.out.println("총 요금은" + total_Price +"입니다.");
        }
    }
}
