package org.firstinspires.ftc.teamcode.demobots;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="DroneLauncher")
public class DroneLauncher extends LinearOpMode {
    DcMotor Drone_Motor  = null;
    DcMotor leftWheel = null;
    DcMotor rightWheel = null;
    CRServo Drone_Servo  = null;
    double leftY;
    double rightY;
    double speed = 0.75;

    public void runOpMode() {
        Drone_Motor = hardwareMap.get(DcMotor.class, "Drone_Motor");
        leftWheel = hardwareMap.get(DcMotor.class, "left");
        rightWheel = hardwareMap.get(DcMotor.class, "right");
        Drone_Servo = hardwareMap.get(CRServo.class, "Drone_Servo");
        leftWheel.setDirection(DcMotor.Direction.REVERSE);
        waitForStart();
        while(opModeIsActive()) {

           leftY  = gamepad1.left_stick_y;
           rightY  = gamepad1.right_stick_y;

            leftWheel.setPower(leftY * speed);
            rightWheel.setPower(rightY * speed);

            if (gamepad1.a) {
                Drone_Motor.setPower(1);
                sleep(500);

                Drone_Servo.setPower(1);
                sleep(300);
                Drone_Motor.setPower(0);
                Drone_Servo.setPower(0);
            }
            if (gamepad1.dpad_up) {
                speed = 1;
            } else if (gamepad1.dpad_down) {
                speed = 0.5;
            } else if (gamepad1.dpad_right) {
                speed = 0.75;
            }
        }
    }
}
