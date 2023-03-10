public class Main {
    public static void main(String[] args) {

        Person jack = new Athlete();
        Athlete anjali = new Athlete();
        SoccerPlayer chirasree = new SoccerPlayer();
        Athlete sohum = new SoccerPlayer();


        jack.speakTo(anjali);
        ((Person)chirasree).speakTo(sohum);


    }

    public static class Person {
        void speakTo(Person other) {
            System.out.println("kudos");
        }

        void watch(SoccerPlayer other) {
            System.out.println("wow");
        }
    }

    public static class Athlete extends Person {
        void speakTo(Athlete other) {
            System.out.println("take notes");
        }

        void watch(Athlete other) {
            System.out.println("game on");
        }
    }

    public static class SoccerPlayer extends Athlete {
        void speakTo(Athlete other) {
            System.out.println("respect");
        }

        void speakTo(Person other) {
            System.out.println("hmph");
        }
    }


}