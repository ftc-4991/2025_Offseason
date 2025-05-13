package org.firstinspires.ftc.teamcode.tutorial;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

//Give a description of what the program will do
/*
 * This program will use a Dc Motor as well as a 180 degree servo. The program will take input
 * from a gamepad to drive the motor speed and set the servo position.  The program will
 * also send telemetry for display on the driver station.
 */

@TeleOp(name="SolutionGamepadInput")
public class SolutionGamepadInput extends LinearOpMode {

    //Declare a Dc motor
    DcMotor motor1 = null;

    //Declare a 180 degree servo
    Servo   servo1 = null;

    @Override

    public void runOpMode() {

        //add the motor and servo to the hardware map
        //The device name you set in the hardware map will be what you have to type in the config
        motor1 = hardwareMap.get(DcMotor.class, "motor");
        servo1 = hardwareMap.get(Servo.class,"servo");

        //display some initial status info for the driver with program state, motor power,
        // and initial servo position.
        telemetry.addData("Status", "Initialized");
        telemetry.addData("Motor Power", "%.2f", motor1.getPower());
        telemetry.addData("Servo Position", "%.2f", servo1.getPosition());
        telemetry.update();

        waitForStart();

        while (opModeIsActive()){
            /*
             * Assign the gamepad left joystick y-axis to the motor power value.
             * Joystick values range from -1.0 to +1.0 with a value of 0.0 at rest.
             * The horizontal axis is labeled x, where hard left = -1.0 and hard right = +1.0
             * and the vertical axis is labeled y, where forward = -1.0 and back = +1.0.
             * The motorPower variable below is the negative of the y-stick value so that
             * pushing the stick forward increases motor power towards +1.0, moving the wheel forward.
             * Pulling the stick back increases the motor power towards -1.0, moving the wheel in reverse.
             */
            double motorPower = -gamepad1.left_stick_y;
            motor1.setPower(motorPower);

            /*
             * Assign gamepad buttons to servo positions. The current state of each button is returned when read.
             * The button state is a boolean value, either true (pressed) or false (not pressed).
             * Use an if-else block to move the servo to its leftmost position when Y (top button) is pressed,
             * to the center position when either X or B (middle buttons) are pressed, and to the rightmost
             * position when A (bottom button) is pressed.
             * Add a sleep method afterwards to allow the servo to reach position before continuing the loop
             * and responding to a different button press.
             */

            if (gamepad1.y) {
                servo1.setPosition(1.0);  // Left
            } else if (gamepad1.x || gamepad1.b)  {
                servo1.setPosition(0.5);  // Center
            } else if (gamepad1.a) {
                servo1.setPosition(0.0);  // Right
            }
            sleep(2000);

            // update status information on the driver station with program state,
            // current motor power and servo position.
            telemetry.addData("Status", "Running");
            telemetry.addData("Motor Power", "%.2f", motor1.getPower());
            telemetry.addData("Servo Position", "%.2f", servo1.getPosition());
            telemetry.update();

        }

    }

}
