import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("버스와 택시 둘 중 어느 교통수단을 이용하시겠습니까? 버스면 1 을 택시면 2 를 입력해주세요.");

        /* 버스 */
        if (sc.nextInt() == 1) {
            String id = UUID.randomUUID().toString();
            bus A = new bus(id);

            //// 버스 상태 체크
            A.status_Check();

            //// 첫번째 정류장 버스에 승객 타기
            System.out.print("버스가 첫번째 정류장에 도착했습니다. 탑승할 승객 수를 입력해주세요.");
            int on_People = sc.nextInt(); // 탑승 인원수 입력받음
            A.get_On(on_People);

            //// 버스 속도 변경
            System.out.println("현재 속도에서 올리거나 낮추고싶은 변경 값을 입력해주세요. ex : -20입력시 현재 속도 70에서 50으로 변경");
            int speed = sc.nextInt(); // 변경 속도 알파값 입력받음
            A.change_Speed(speed);

            //// 두번째 정류장 버스 승객 내리기
            System.out.println("버스가 두번째 정류장에 도착했습니다. 하차할 승객 수를 입력해주세요");
            int second_off_People = sc.nextInt(); // 하차 인원수 입력받음
            A.get_Out(second_off_People);

            //// 두번째 정류장 버스에 승객 타기
            System.out.println("탑승할 승객 수도 입력해주세요.");
            int second_on_People = sc.nextInt(); // 탑승 인원수 입력받음
            A.get_On(second_on_People);

            //// 세번째 정류장 버스 승객 내리기
            System.out.println("버스가 세번째 정류장에 도착했습니다. 하차할 승객 수를 입력해주세요");
            int third_off_People = sc.nextInt(); // 탑승 인원수 입력받음
            A.get_Out(third_off_People);

            //// 세번째 정류장 버스에 승객 타기
            System.out.println("탑승할 승객 수도 입력해주세요.");
            int third_on_People = sc.nextInt(); // 탑승 인원수 입력받음
            A.get_On(third_on_People);


            /* 택시 */
        } else {

            //// 택시 고유번호 생성
            String id = UUID.randomUUID().toString();
            taxi B = new taxi(id);

            //// 첫 번째 승객 타기
            System.out.println("택시가 출발합니다. 이동할 거리를 입력해주세요. 2km일 시 2000을 입력해주세요 m 단위입니다.");
            int distance = sc.nextInt(); //
            System.out.println("목적지를 입력해주세요.");
            String destination = sc.next();
            B.taxi_get_On(distance, destination);

            ////  속도 변경
            System.out.println("현재 속도에서 올리거나 낮추고싶은 변경 값을 입력해주세요. ex : -20입력시 현재 속도 70에서 50으로 변경");
            int speed = sc.nextInt(); // 변경 속도 알파값 입력받음
            B.taxi_change_Speed(speed);

            //// 첫번째 승객 내리기
            System.out.println("택시가 목적지에 도착했습니다.");
            B.taxi_get_Out();

            //// 두 번째 승객 타기
            System.out.println("택시가 출발합니다. 이동할 거리를 입력해주세요. 2km일 시 2000을 입력해주세요 m 단위입니다.");
            int second_distance = sc.nextInt(); // 탑승 인원수 입력받음
            System.out.println("목적지를 입력해주세요.");
            String second_destination = sc.next();
            B.taxi_get_On(second_distance, second_destination);

            //// 두번째 승객 내리기
            System.out.println("택시가 목적지에 도착했습니다.");
            B.taxi_get_Out();

            //// 세 번째 승객 타기
            System.out.println("택시가 출발합니다. 이동할 거리를 입력해주세요. 2km일 시 2000을 입력해주세요 m 단위입니다.");
            int third_distance = sc.nextInt(); // 탑승 인원수 입력받음
            System.out.println("목적지를 입력해주세요.");
            String third_destination = sc.next();
            B.taxi_get_On(third_distance, third_destination);

            //// 세 번째 승객 내리기
            System.out.println("택시가 목적지에 도착했습니다.");
            B.taxi_get_Out();

            //// 네 번째 승객 타기
            System.out.println("택시가 출발합니다. 이동할 거리를 입력해주세요. 2km일 시 2000을 입력해주세요 m 단위입니다.");
            int fourth_distance = sc.nextInt(); // 탑승 인원수 입력받음
            System.out.println("목적지를 입력해주세요.");
            String fourth_destination = sc.next();
            B.taxi_get_On(fourth_distance, fourth_destination);

            //// 네 번째 승객 내리기
            System.out.println("택시가 목적지에 도착했습니다.");
            B.taxi_get_Out();


        }
    }
}
