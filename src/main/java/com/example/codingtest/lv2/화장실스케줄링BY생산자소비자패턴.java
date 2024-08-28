package com.example.codingtest.lv2;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.*;

/**
 * 공원에 공중 화장실이 있다. 화장실의 칸은 n개 이며, m명의 사람들이 급한 볼 일을 보기 위해 대기한다고 하자. 이를 이용하는 사람마다 이용 시간은 최소 1분에서 10분까지 걸린다고 하자.
 * 위와 같은 상황에서 화장실을 대기하는 사람들을 공평하고 안전하게 볼 일을 보고 나갈 수 있도록 시뮬레이터를 작성하시오.
 *
 * - 처리 조건
 *     - 화장실 칸 수는 실행 전에 인수로 받도록 하고 각 화장실을 스레드로 구현하도록 한다.
 *     - 대기 하는 사람은 실행전 인수로 받도록 하고 랜덤 함수에 의하여 생성하도록 한다.
 *     - 실행을 빨리 돌려야 하므로 1분을 1초로 환산하여 처리하도록 한다.
 *     - 아래의 예와 같이 1분 단위로 상태 변화를 출력하여 스케줄링 상태를 확인할 수 있도록 한다.
 * */
public class 화장실스케줄링BY생산자소비자패턴 {

    @Data
    public static class Person{
        private int id;
        private final int waitingTime;
        private int remainTime;

        Person( int id, int waitingTime ){
            this.id = id;
            this.waitingTime = waitingTime;
            this.remainTime = waitingTime;
        }

        public void goTime() throws InterruptedException {
            if(remainTime > 0){
                --remainTime;
            }
        }

        public boolean isEnd(){
            return remainTime <= 0;
        }
    }

    @Data
    @AllArgsConstructor
    public static class Producer implements Runnable{
        private BlockingQueue<Toilet> currentToilets;
        private BlockingQueue<Toilet> remainToiletList;
        private final ExecutorService executorService;

        @Override
        public void run() {
            while (!remainToiletList.isEmpty()){
                if( currentToilets.remainingCapacity() > 0){
                    Toilet poll = remainToiletList.poll();
                    try {
                        currentToilets.put(poll);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    executorService.submit(poll);
                }
            }
        }
    }

    // 컨슈머
    @Data
    @AllArgsConstructor
    public static class Toilet implements Runnable {
        private Person person;
        private BlockingQueue<Toilet> currentToilets;

        @Override
        public void run() {
            while (!person.isEnd()){
                try {
                    person.goTime();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            // 완료 후 자신 제거
            currentToilets.remove(this);
        }
    }

    private static void printPersons(BlockingQueue<Toilet> toilets) {
        toilets.forEach(
                o -> {
                    Person person = o.getPerson();
                    System.out.printf( "[ %2d ( %2d / %2d ) ]  ", person.getId(), person.getRemainTime(), person.getWaitingTime() );
                }
        );
    }

    public static void main(String[] args) throws InterruptedException {
        final int m = 10; // 사람 수
        final int n = 5; // 화장실 수

        BlockingQueue<Toilet> currentToilets = new ArrayBlockingQueue<>(n);
        BlockingQueue<Toilet> remainToiletList = new ArrayBlockingQueue<>(m);
        ExecutorService executorService = Executors.newFixedThreadPool(n+1);

        for(int i = 1; i<=m ; i++){
            int randomNum = ThreadLocalRandom.current().nextInt(1, 10 + 1);
            Toilet toilet = new Toilet( new Person(i, randomNum), currentToilets);
            if( currentToilets.size() < n ){
                currentToilets.put( toilet );
            }
            remainToiletList.add( toilet );
        }

        System.out.print("최초 대기열 : ");
        printPersons(remainToiletList);
        System.out.println();


        for(int j = 0; j < n; j++){
            executorService.submit(remainToiletList.poll());
        }

        Producer producer = new Producer(currentToilets, remainToiletList, executorService);
        executorService.submit(producer);

        int i = 0;
        while (!currentToilets.isEmpty()){
            System.out.printf( ">> 화장실 모니터 : [ %10d 초 경과 ] ==================================================================================\n", i );
            System.out.print( "대기열 : " );
            printPersons(remainToiletList);

            System.out.println();
            System.out.print( "화장실 : " );
            printPersons(currentToilets);
            System.out.println();

            i++;
            Thread.sleep(1000);
        }
        System.out.println("================================================================================== END ==================================================================================");
        executorService.shutdown();
    }
}
