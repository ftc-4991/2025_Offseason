package org.firstinspires.ftc.teamcode.demobots;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;


@TeleOp
public class ParkersClaw extends LinearOpMode {


    Servo Rotation = null;
    Servo Claw = null;

    double yValue;


    public void runOpMode() {
        Rotation = hardwareMap.get(Servo.class,"servo1");
        Claw = hardwareMap.get(Servo.class,"servo2");

        waitForStart();

        while (opModeIsActive()) {
            yValue = gamepad1.left_stick_y;

            if (gamepad1.a) {
                Claw.
            }
            if (gamepad1.b) {
                Claw.setPosition(-1);
            }

        }
    }

}
