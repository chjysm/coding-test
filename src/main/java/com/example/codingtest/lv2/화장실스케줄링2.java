package com.example.codingtest.lv2;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class 화장실스케줄링2 {
    @Getter
    static class Person {

        private final int id;
        private final int time;
        @Setter
        private int remainingTime;

        public Person( int id, int time ) {
            this.id = id;
            this.time = time;
            this.remainingTime = time;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "id=" + id +
                    ", time=" + time +
                    ", remainingTime=" + remainingTime +
                    '}';
        }
    }

    public static class RestRoomSchedule {

        public static final int MAX_WAITING = 100;

        private final int rooms;
        private final BlockingQueue< Person > persons;
        private final ExecutorService pool;
        private final List<Future< ? >> futures;
        private final ConcurrentMap< Integer, Person > monitor;

        private final ScheduledExecutorService scheduler;

        public RestRoomSchedule( int rooms ) {

            this.rooms = rooms;
            this.persons = new ArrayBlockingQueue<>( MAX_WAITING );
            this.pool = Executors.newFixedThreadPool( rooms );
            this.futures = new ArrayList<>( rooms );
            this.monitor = new ConcurrentHashMap<>();
            this.scheduler = Executors.newScheduledThreadPool( 1 );
        }

        public void start( int initPerson ) throws InterruptedException, ExecutionException {

            System.out.print( "최초 대기열 : " );

            for ( int i = 0; i < initPerson; i++ ) {

                Person p = new Person(i + 1, (int) (Math.random() * 10d + 1d));

                persons.put( p );
                System.out.printf( "[ %2d ( %2d / %2d ) ]  ", p.getId(), p.getRemainingTime(), p.getTime() );
            }

            System.out.println();

            this.scheduler.scheduleAtFixedRate(
                    new Runnable() {

                        private int i;

                        @Override
                        public void run() {

                            System.out.printf( ">> 화장실 모니터 : [ %10d 초 경과 ] ==================================================================================\n", i );
                            System.out.print( "대기열 : " );
                            for ( Person p : persons ) {
                                System.out.printf( "[ %2d ( %2d / %2d ) ]  ", p.getId(), p.getRemainingTime(), p.getTime() );
                            }
                            System.out.println();

                            System.out.print( "화장실 : " );
                            for ( Map.Entry< Integer, Person > entry : monitor.entrySet() ) {
                                Person person = entry.getValue();
                                System.out.printf( "[ %2d ( %2d / %2d ) ]  ", person.getId(), person.getRemainingTime(), person.getTime() );
                            }

                            System.out.println();

                            i++;
                        }
                    },
                    500, 1000, TimeUnit.MILLISECONDS );

            for ( int i = 0; i < rooms; i++ ) {

                futures.add( pool.submit( new RoomTask( i ) ) );
            }

            for ( Future< ? > f : futures ) {

                f.get();
            }

            pool.shutdownNow();

            TimeUnit.SECONDS.sleep( 1 );
            scheduler.shutdownNow();
        }

        public class RoomTask implements Runnable {

            private final int id;

            public RoomTask( int id ) {

                this.id = id;
            }

            @Override
            public void run() {

                while ( !Thread.currentThread().isInterrupted() ) {

                    try {

                        Person currentPerson = persons.poll();

                        if ( currentPerson == null ) {

                            return;
                        }

                        monitor.put( id, currentPerson);

                        while ( currentPerson.getRemainingTime() > 0 ) {

                            currentPerson.setRemainingTime( currentPerson.getRemainingTime() - 1 );

                            TimeUnit.SECONDS.sleep( 1 );
                        }

                        monitor.remove( id );

                    } catch ( InterruptedException e ) {

                        return;
                    }
                }
            }

        }
    }


    public static void main( String[] args ) throws InterruptedException, ExecutionException {
        RestRoomSchedule s = new RestRoomSchedule(5);
        s.start( 10 );
    }
}
