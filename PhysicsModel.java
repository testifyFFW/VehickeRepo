import java.util.Scanner;

public class PhysicsModel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please choose the PhysicsModel：");
        System.out.println("1. horizontalModel");
        System.out.println("2. inclinedPlaneModel");
        System.out.println("3. circularMotion");
        System.out.println("4. horizontalModelPractiseMode");
        System.out.println("5. inclinedPlaneModelPractiseMode");
        System.out.println("6. circularMotionPractiseMode");
        int choice = scanner.nextInt();

        switch (choice) {  //We can choose the model 1 or 2 , if you choose an undefined word , it will be error .
            case 1:
                horizontalModel(scanner);
                break;
            case 2:
                inclinedPlaneModel(scanner);
                break;
            case 3:
                circularMotion(scanner);
                break;
            case 4:
                horizontalModelPractiseMode(scanner);//This is a Mode that you can input your answer and the system will tell weather you are right .
                break;
            case 5:
                inclinedPlaneModelPractiseMode(scanner);//It is the same as case 4 .
                break;
            case 6 :
                circularMotionPractiseMode(scanner);//It is the same as case 5,4 .
                break;

            default:
                System.out.println("Error");
                break;
        }

        scanner.close();
    }

    private static void horizontalModel(Scanner scanner) {     // You can write the word on the table .
        System.out.println("Input the coefficient of friction u：");
        double u = scanner.nextDouble();
        System.out.println("Input the object mass m：");
        double m = scanner.nextDouble();
        System.out.println("Input the initial speed v：");
        double v = scanner.nextDouble();
        System.out.println("Input the gravity g：");
        double g = scanner.nextDouble();
        System.out.println("Input the length of the table l：");
        double l = scanner.nextDouble();

        double frictionForce = m * g * u;
        double kineticEnergy = 0.5 * m * v * v;
        double fworkDone = frictionForce * l;

        if (fworkDone < kineticEnergy) {    //If the kineticEnergy is larger than the fworkDone , the object will leave the table .
            System.out.println("Object will leave the table");
        } else {

            double x = (m*v*v)/2*frictionForce;
            double deltaX = l - x ; // To calculate the distance of an object from the edge of the horizontal plane .
            System.out.println("Object will not leave the table");

            System.out.println("The distance between the object and the table is " + deltaX);
        }
    }

    private static void inclinedPlaneModel(Scanner scanner) {
        System.out.println("Input the coefficient of friction U：");
        double U = scanner.nextDouble();
        System.out.println("Input the object mass M：");
        double M = scanner.nextDouble();
        System.out.println("Input the initial speed V：");
        double V = scanner.nextDouble();
        System.out.println("Input the gravity G：");
        double G = scanner.nextDouble();
        System.out.println("Input the Slope angle (Angle system) R：");
        double R = scanner.nextDouble();
        System.out.println("Input the length of the inclinedPlane：");
        double L = scanner.nextDouble();

        double angleInRadians = Math.toRadians(R);
        double frictionForce = M * G * U * Math.cos(angleInRadians);
        double gravitationalComponent = M * G * Math.sin(angleInRadians);
        double kineticEnergy = 0.5 * M * V * V;
        double workDone = -(gravitationalComponent - frictionForce) * L;

        if (workDone < kineticEnergy) {
            System.out.println("Object will leave the inclinedPlane");
        } else {
            double X = (V*V)/2*(G*Math.sin(R) - U*G*Math.cos(R));
            double deltaXX = L - X ; // To calculate how much distance the object still has to fall .
            System.out.println("Object will not leave the inclinedPlane");
            System.out.println("The distance between the object and the table is " + deltaXX);
        }
    }



    public static void circularMotion(Scanner scanner) {
        System.out.println("Input the length of the cord LL");
        double LL = scanner.nextDouble();
        System.out.println("Input the gravity GG：");
        double GG = scanner.nextDouble();
        System.out.println("Input the initial speed of the object VV:");
        double VV = scanner.nextDouble();


        if(VV*VV >= 5*GG*LL){
            double T = 2*3.14*LL/ Math.sqrt( VV * Math.sqrt( VV * VV - 2* GG*LL)); // To calculate the time that the object can make one complete circularMotion .
            double w = 2*3.14 / T ; // To calculate the speed of the object .
            System.out.println("The object can make a complete circularMotion .");
            System.out.println("The cycle of the object is "+T);
            System.out.println("The angular speed is " + w);
        }else{
            double H = VV*VV/2*GG ;

            System.out.println("The object can not make a complete circularMotion .");
            System.out.println("The height that the object rises is " + H);
        }
    }
    private static void horizontalModelPractiseMode(Scanner scanner) {//It is a mode that you can write parameter and write your answer on the table , the system will judge weather your answer is right .
        System.out.println("Input the coefficient of friction u：");
        double u = scanner.nextDouble();
        System.out.println("Input the object mass m：");
        double m = scanner.nextDouble();
        System.out.println("Input the initial speed v：");
        double v = scanner.nextDouble();
        System.out.println("Input the gravity g：");
        double g = scanner.nextDouble();
        System.out.println("Input the length of the table l：");
        double l = scanner.nextDouble();
        System.out.println("Input your answer that the weather the object will leave the table , if yes answer 1 , if no answer 2 :");
        double answer1 = scanner.nextDouble();
        double frictionForce = m * g * u;
        double kineticEnergy = 0.5 * m * v * v;
        double fworkDone = frictionForce * l;

        if (fworkDone < kineticEnergy) {
            if (answer1 == 1){
                System.out.println("Your are right .");
            }if (answer1 == 2){
                System.out.println("Your are wrong .");
            }
        } else {
            if (answer1==1) {
                System.out.println("Your are wrong , the object will not leave the table .");
            }if (answer1 ==2){
                System.out.println("Your are right , and you can answer how many the deltaX is .");




                double x = (m * v * v) / 2 * frictionForce;
                double deltaX = l - x;

                System.out.println("Input your answer :");
                double Youranswer = scanner.nextDouble();

                if (Youranswer == deltaX) {
                    System.out.println("You are right ");
                } else {
                    System.out.println("You are wrong , the right answer is " + deltaX);
                }
            }
        }
    }

    private static void inclinedPlaneModelPractiseMode(Scanner scanner) {
        System.out.println("Input the coefficient of friction U：");
        double U = scanner.nextDouble();
        System.out.println("Input the object mass M：");
        double M = scanner.nextDouble();
        System.out.println("Input the initial speed V：");
        double V = scanner.nextDouble();
        System.out.println("Input the gravity G：");
        double G = scanner.nextDouble();
        System.out.println("Input the Slope angle (Angle system) R：");
        double R = scanner.nextDouble();
        System.out.println("Input the length of the inclinedPlane：");
        double L = scanner.nextDouble();


        System.out.println("Input your answer that weather the object will leave the table , if yes answer 1 , if no answer 2:");
        double answer2 = scanner.nextDouble();
        double angleInRadians = Math.toRadians(R);

        double frictionForce = M * G * U * Math.cos(angleInRadians);
        double gravitationalComponent = M * G * Math.sin(angleInRadians);
        double kineticEnergy = 0.5 * M * V * V;
        double workDone = -(gravitationalComponent - frictionForce) * L;

        if (workDone < kineticEnergy) {
            if (answer2==1){
                System.out.println("You are right .");
            }if (answer2==2){
                System.out.println("You are wrong .");
            }

        } else {
            if (answer2==1){
                System.out.println("You are wrong , the object will not leave the table .");

            }if (answer2==2) {
                System.out.println("You are right , and you can answer how many the deltaXX is .");
            }
            double X = (V * V) / 2 * (G * Math.sin(R) - U * G * Math.cos(R));
            double deltaXX = L - X; // To calculate how much distance the object still has to fall .
            System.out.println("Input your answer :");
            double answer3 = scanner.nextDouble();
            if (answer3==deltaXX){
                System.out.println("You are right .");
            }else{
                System.out.println("You are wrong , the answer is "+ deltaXX);

            }

        }
    }

    private static void circularMotionPractiseMode(Scanner scanner){
        System.out.println("Input the length of the cord LL");
        double LL = scanner.nextDouble();
        System.out.println("Input the gravity GG：");
        double GG = scanner.nextDouble();
        System.out.println("Input the initial speed of the object VV:");
        double VV = scanner.nextDouble();
        System.out.println("Input your answer that weather the object will make a complete circularMotion, if yes answer 1, if no answer 2 :");
        double answer4 = scanner.nextDouble();


        if(VV*VV >= 5*GG*LL){

            if (answer4==1){
                System.out.println("You are right , then you can answer the 'T' and the 'w' .");
            }if (answer4==2){
                System.out.println("You are wrong , the object can make that, then you can answer the ' T ' and the ' w ' .");

            }

            double T = 2*3.14*LL/ Math.sqrt( VV * Math.sqrt( VV * VV - 2* GG*LL)); // To calculate the time that the object can make one complete circularMotion .
            double w = 2*3.14 / T ; // To calculate the speed of the object .
            System.out.println("Input your answer T :");
            double answerT = scanner.nextDouble();
            System.out.println("Input your answer w :");
            double answerw = scanner.nextDouble();
            if (answerT==T){
                System.out.println("Your T is right .");
            }
            else{
                System.out.println("Your T is wrong , the right answer is :"+T);
            }

            if (answerw == w){
                System.out.println("Your w is right .");
            }else{
                System.out.println("Your w is wrong , the right answer is :"+w);
            }
        }else{
            if (answer4==1){
                System.out.println("You are wrong , then you can answer at what height does the object have 0 speed :");

            }if (answer4==2){
                System.out.println("You are right , then you can answer at what height dose the object have 0 speed :");

            }
            double answerH = scanner.nextDouble();
            double H = VV*VV/2*GG ;
            if (answerH==H){
                System.out.println("Your answer H is right .");
            }else{
                System.out.println("Your answer H is wrong , and the right answer is :"+H);
            }
        }
    }
}
