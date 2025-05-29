package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class EncoderDemo extends LinearOpMode {
    //Declare the motor variable to use
    DcMotor motor = null;
    //Declare some additional positions you'll want the motor to run to
    int Pos1 = 2000;
    int Pos2 = 1000;
    int Pos3 = 500;
    int Pos4 = 0;



    public void runOpMode() {


       motor = hardwareMap.get(DcMotor.class,"motor");


       //Resets the encoder (any previous values will be reset, etc.
       motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
       //Sets the motor to run using the encoder
       //Allows for the motor to use telemetry etc.
       motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
       //adds a caption to the driver station that states its current position
       telemetry.addData("Motor Position: ", motor.getCurrentPosition());

       //Not necessary, however when the motor recieves no power, it SHOULD
       //try to hold it's position, though this hasn't worked on all motors
       motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        waitForStart();

        while(opModeIsActive()) {
            //another example of telemetry, using Pos1's value
            telemetry.addData("Value of Pos1: ", Pos1);
            //displays what the target position of the motor is
            telemetry.addData("target position is at: ", motor.getTargetPosition());
            //sets the target position to "Pos1", this does not do anything on its own
            telemetry.update();
            motor.setTargetPosition(Pos1);
            //Will make the motor run to its target position
            //the target position must be set before setting the motor to RUN_TO_POSITION
            //as long as it's like this, the motor will be running, can burn out motor
            motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            //ensures that the motor has time to move to the position, is not necessary
            //if the motor is left running or has specific conditions (button controls)
            sleep(3000);
            //repeats above steps with the other position variables
            motor.setTargetPosition( Pos2);
            telemetry.update();
            sleep(3000);
            motor.setTargetPosition(Pos3);
            telemetry.update();
            sleep(3000);
            motor.setTargetPosition(Pos4);
            telemetry.update();
            sleep(3000);

            motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
           //updates all current captions/telemetry. Necessary to update captions
            // USE AS FEW AS POSSIBLE
            telemetry.update();
        }
    }




}
