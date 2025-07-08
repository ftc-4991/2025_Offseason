package org.firstinspires.ftc.teamcode.demobots;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


@TeleOp
public class DarshCode extends LinearOpMode {

    DcMotor motor = null;
    Servo servo = null;

    public void runOpMode() {
        motor = hardwareMap.get(DcMotor.class,"motor");
        servo = hardwareMap.get(Servo.class,"servo");

        waitForStart();

        while (opModeIsActive()) {

            if (gamepad1.a) {
                motor.setPower(1);
                motor.setTargetPosition(-50);
                servo.setPosition(0);
                motor.setPower(1);
                motor.setTargetPosition(50);
                servo.setPosition(1);
            }

            if (gamepad1.x) {
                Darsh.setPower(-1);
                Darsh2.setPower(-1);
                Darsh3.setPosition(0);
            }

        }
    }

}
