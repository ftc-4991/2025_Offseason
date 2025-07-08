package ftc4991.sandbox.tutorial.template;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;



/**
 * We're going to program the mechanise ( the shaft with the wheel and servo attached) to active the motor and connect the serve
 */
//@TeleOp
public class BasicTemplate extends LinearOpMode {

    //Declare a Dc motor variable
     DcMotor motor1 = null;

    //Declare a 180 degree servo variable
     Servo servo1 = null;




    @Override

    public void runOpMode() {
        //This is the "init" section

        //look up motor and servo from the hardware map
        //The device name you set in the hardware map will be what you have to type in the config
        motor1 = hardwareMap.get(DcMotor.class,"motor");
        servo1 = hardwareMap.get(Servo.class,"servo");
        //this brings the servo to it's leftmost position
        servo1.setPosition(1.00);

        //This waits for the user to press the play button
        waitForStart();

        while (opModeIsActive()){
            //This is the "run" section

            //give the motor power
            motor1.setPower(1);
            sleep(2000);
            //add a sleep() method to allow the motor to move

            //stop the motor
            motor1.setPower(0);
            sleep(5000);
            //bring the servo to its rightmost position
            servo1.setPosition(0.00);
            //add a sleep() method to allow the servo time to reach the desired position
            sleep(2000);
            //bring the servo to it's middle position
            servo1.setPosition(0.5);
            sleep(1000);
            //bring the servo to its leftmost position
            servo1.setPosition(1);
            sleep(1000);
        }

    }

}
