/*
FTC Team 4991 GearFreaks
Author(s): Alex Pereira and Charles Burometto
Date: 15 Feb 2019
*/
package org.firstinspires.ftc.teamcode.demobots;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="Eddie _Play_Ball_v1")
public class Eddies_Play_Ball_v1 extends LinearOpMode {

    // Declare OpMode members.
    DcMotor Left;
    DcMotor Right;
    DcMotor Catapult;  // need to use encoder with this motor - neverest 60

    Float DCMotorSpeed;
    float Yvalue1;
    float Xvalue1;
    float Yvalue2;
    float Xvalue2;

    boolean buttonA;
    boolean buttonB;
    boolean buttonX;
    boolean buttonY;
    boolean dpad_up;
    boolean dpad_down;
    double speed = 0.50;
    int launch_position =0;




    private ElapsedTime     runtime = new ElapsedTime();

    @Override
    public void runOpMode() throws InterruptedException {

        Left = hardwareMap.dcMotor.get("left");
        Right = hardwareMap.dcMotor.get("right");
        Left.setDirection(DcMotor.Direction.REVERSE);

        Catapult = hardwareMap.dcMotor.get("catapult");
        //Catapult.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        Catapult.setTargetPosition(Catapult.getCurrentPosition());
        Catapult.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        telemetry.addData("Initial Catapult: ", launch_position);



        // set catapult to starting position
        launch_position = (Catapult.getCurrentPosition());
        launch_position += 1180;
        Catapult.setPower(1.00);
        Catapult.setTargetPosition(launch_position);
        telemetry.addData("Launch Position: ", launch_position);
        sleep(2000);
        Catapult.setPower(0.00);

        telemetry.addData("Robot Initiatized:", "Ready to Start");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {
            //getJoystickSettings(joystick);
            Yvalue1 = gamepad1.left_stick_y;
            Yvalue2 = gamepad1.right_stick_y;

            buttonA = gamepad1.a;
            buttonB = gamepad1.b;
            buttonX = gamepad1.x;
            buttonY = gamepad1.y;
            dpad_down = gamepad1.dpad_down;
            dpad_up = gamepad1.dpad_up;

            Yvalue1 = Range.clip(Yvalue1, -1, 1);
            Yvalue2 = Range.clip(Yvalue2, -1, 1);

            Left.setPower(Yvalue1 * speed);
            Right.setPower(Yvalue2 * speed);


            // button X is used to launch the ball in manual mode
            if(buttonX) {
                launch_position = (Catapult.getCurrentPosition());
                launch_position += 500;
                Catapult.setPower(1.00);
                Catapult.setTargetPosition(launch_position);
                telemetry.addData("Manual Launching Ball: ", launch_position);
                telemetry.update();

                // give the catapult a chance to settle/stop moving before resetting
                sleep(4000);
                launch_position = (Catapult.getCurrentPosition());
                launch_position += 1180;
                Catapult.setPower(1.00);
                Catapult.setTargetPosition(launch_position);
                telemetry.addData("Manual Resetting Launcher: ", launch_position);
                telemetry.update();
                sleep(5000);
               // Catapult.setPower(0.00);
            }
            if(dpad_down) {
                // increment the Catapult motor by 10;
                launch_position = (Catapult.getCurrentPosition());
                launch_position += 105;
                Catapult.setPower(1.00);
                Catapult.setTargetPosition(launch_position);
                telemetry.addData("INCREMENTING BY 10:", launch_position);
                telemetry.update();
                sleep(500);
              //  Catapult.setPower(0.00);
            }
            if(dpad_up) {
                // decrement the Catapult motor by 10;
                launch_position = (Catapult.getCurrentPosition());
                telemetry.addData("Starting down:", launch_position);
                telemetry.update();
                launch_position -= 105;
                Catapult.setPower(1.00);
                Catapult.setTargetPosition(launch_position);
                telemetry.addData("DECREMENTING by 10:", launch_position);
                telemetry.update();
                sleep(500);
              //  Catapult.setPower(0.00);
            }
            if (gamepad1.right_bumper) {
                speed = 1;
            } else if (gamepad1.left_bumper) {
                speed = 0.50;
            }
        }

        //Prepares To End Match
        // set catapult to a non-tension position
        launch_position = (Catapult.getCurrentPosition());
        launch_position -= 500;
        Catapult.setPower(1.00);
        Catapult.setTargetPosition(launch_position);
        telemetry.addData("Catapult at Rest: ", launch_position);
        telemetry.update();


        Left.setPower(0.00);
        Right.setPower(0.00);
        Catapult.setPower(0.00);

        telemetry.addData("Program: ", "Complete");
        telemetry.update();
        idle();
    }

}